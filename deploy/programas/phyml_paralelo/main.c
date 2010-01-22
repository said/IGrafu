/*

PHYML :  a program that  computes maximum likelihood  phylogenies from
DNA or AA homologous sequences 

Copyright (C) Stephane Guindon. Oct 2003 onward

All parts of  the source except where indicated  are distributed under
the GNU public licence.  See http://www.opensource.org for details.

*/
#include "mpi.h"
#include "utilities.h"
#include "ml.h"
#include "optimiz.h"
#include "bionj.h"
#include "models.h"
#include "free.h"
#include "options.h"
#include "simu.h"


#ifdef PHYML

int T_MAX_FILE;

int main(int argc, char **argv)
{
  seq **data;
  allseq *alldata;
  option *input;
  char *s_tree, *s_any;
  FILE *fp_phyml_tree,*fp_phyml_stats,*fp_phyml_lk,*fp_best_tree,*fp_best_tree_stats;
  arbre *tree;
  int n_otu, n_data_sets;
  matrix *mat;
  model *mod;
  time_t t_beg,t_end;
  div_t hour,min;
  int num_tree,tree_line_number;
  double best_loglk;
  int numprocs;
  int myid;


   int i,j; /*para testes*/
   MPI_Init(&argc,&argv);
 
   MPI_Comm_size(MPI_COMM_WORLD,&numprocs);
    MPI_Comm_rank(MPI_COMM_WORLD,&myid);
  // printf("eu %d rodando\n", myid);
//if (myid == 0){
 

  srand(time(NULL));

  tree = NULL;
  mod  = NULL;

  Init_Constant();

  s_any = (char *)mCalloc(T_MAX_FILE,sizeof(char));

  fflush(stdout);
  
  
  input = (option *)Get_Input(argc,argv, myid);

   
  
  Make_Model_Complete(input->mod);

  mod = input->mod;

  fp_phyml_stats = Openfile(input->phyml_stat_file,input->phyml_stat_file_open_mode);

  fprintf(fp_phyml_stats,"\n- PHYML %s -\n\n", VERSION);
  
  if (myid == 0){

  fp_phyml_tree = Openfile(input->phyml_tree_file,input->phyml_tree_file_open_mode);
  
  }
  
  n_data_sets = 0;
  if (myid == 0){
  fp_phyml_lk = fopen(input->phyml_lk_file,"w");
  }

  if(input->inputtree) Test_Multiple_Data_Set_Format(input);
  else input->n_trees = 1;
  
/*   if(input->n_data_sets > 1) input->n_trees = 1; */

  best_loglk = UNLIKELY;
  tree_line_number = 0;

  do
    {

      n_data_sets++;

      time(&t_beg);

      n_otu = 0;

      if(n_data_sets > input->n_data_sets) 
	{
	  data = NULL;	  
	}
      else
	{
            data = Get_Seq(input,0);
	}

      if(data)
	{
	  if(n_data_sets > 1) { if (myid == 0){printf("\n. Data set [#%d]\n",n_data_sets);}}
          if(myid == 0){
	  printf("\n. Compressing sequences...\n");}

	  alldata = Compact_Seq(data,input);

	  Free_Seq(data,alldata->n_otu);

	  Init_Model(alldata,mod);
	  
	  Check_Ambiguities(alldata,input->mod->datatype,input->mod->stepsize);


	  For(num_tree,input->n_trees)
	    {
	      if(!input->inputtree)
		{ 
		  if (myid == 0){
		  printf("\n. Computing pairwise distances...\n");}
		  
		  mat = ML_Dist(alldata,mod);

		  if(myid == 0){
		  printf("\n. Building BIONJ tree...\n");}
		  	      
		  mat->tree = Make_Tree(alldata);

		  Bionj(mat);
                    /*  printf("depois de bionj\n"); */
		  		  
		  tree = mat->tree;

		  Free_Mat(mat);
		}
	      else 
		{
                    if(input->n_trees > 1) printf("\n. Reading user tree [#%d]\n",tree_line_number+1);
                    else printf("\n. Reading user tree...\n");
		  
                    if(input->n_trees == 1) 
                        {
                            rewind(input->fp_input_tree);
                            tree_line_number = 0;
                        }

                    tree = Read_Tree_File(input->fp_input_tree);
                    
                    tree_line_number++;
                  
                    if(!tree) 
                        {
                            printf("\n. Missing tree for data set #%d\n",n_data_sets);
                            printf("  This data set is not analyzed.\n");
                            data = NULL;
                        }
                    
                    if(!tree->has_branch_lengths)
                        {
                            printf("\n. Computing branch length estimates...\n");
                            
                            Order_Tree_CSeq(tree,alldata);
                            
                            mat = ML_Dist(alldata,mod);
                            
                            mat->tree = tree;
		      
                            mat->method = 0;
                            
                            Bionj_Br_Length(mat);
                            
                            Free_Mat(mat);
                        }
		}
	      
	      if(!tree) continue;
	      
	      
	      tree->mod        = mod;
	      tree->input      = input;
	      tree->data       = alldata;
	      tree->both_sides = 1;
	      tree->n_pattern  = tree->data->crunch_len/tree->mod->stepsize;
	      
	      Order_Tree_CSeq(tree,alldata);
	      
	      Make_Tree_4_Lk(tree,alldata,alldata->init_len);
/*
             printf("teste\n");
             for (i=0;i<2*tree->n_otu-2;i++){
               printf(" no[%d] = %s , ",i, tree->noeud[i]->name);
               for (j=0; j<3; j++){
                       printf("l[%d] = %lf ",j, tree->noeud[i]->l[j]);
               }
               printf("\n");
             }
             for (i=0;i<2*tree->n_otu-3;i++){
               printf(" b[%d] = %lf \n ",i, tree->t_edges[i]->l);
             }
             for (i=0; i<2*tree->n_otu-2;i++){
               printf("node[%d] = %s  ",i,tree->noeud[i]->name);
               for (j=0; j<3; j++){
                 if (tree->noeud[i]->b[j]){
                    printf("l de branch[%d] = %lf ; ",j,tree->noeud[i]->b[j]->l);
                 }
                 if (tree->noeud[i]->v[j]){
                          printf("vizinho[%d] = %s ; ",j,tree->noeud[i]->v[j]->name);
                          printf("l[0] de vizinho : %lf\n",tree->noeud[i]->v[j]->l[0]);
                          printf("tax de vizinho : %d\n",tree->noeud[i]->v[j]->tax);
                 }
               }
               printf("\n");
             }

 */             
	      
	      if(tree->mod->s_opt->opt_topo){
		Simu(tree,1000);
                printf("executo Simu\n");
              }
	      else
		{
		  if(tree->mod->s_opt->opt_free_param){
		    Round_Optimize(tree,tree->data);
                    printf("executo Roun\n");
                  }
                    
		  else
		    {
		      Lk(tree,tree->data);
		      printf("\n. Log(lk) :               * -> %15.6f ",tree->tot_loglk);
		    }
		}
	      

	      if(tree->mod->bootstrap) Bootstrap(tree, myid, numprocs);
	      
	      Update_BrLen_Invar(tree);
             if (myid == 0){
	     //printf("escrevendo arvore\n"); 
	      s_tree = Write_Tree(tree);
	     //printf("sainda da escrita da arvore\n"); 
	      
	      fprintf(fp_phyml_tree,"%s\n",s_tree);

	      Free(s_tree);
               }
	       
	      Unconstraint_Lk(tree);

	      time(&t_end);
	      
	      hour = div(t_end-t_beg,3600);
	      min  = div(t_end-t_beg,60  );
	      
	      min.quot -= hour.quot*60;
	      
	      if (input->n_data_sets==1){
	           //printf("poraquisim \n");
		Print_Fp_Out(fp_phyml_stats, t_beg, t_end, tree, input, n_data_sets);}
	      else{
	         printf("poraqui \n");
		Print_Fp_Out_Lines(fp_phyml_stats, t_beg, t_end, tree, input, n_data_sets);
               }
			      
	     // printf("\n\n. Time used %dh%dm%ds\n", hour.quot,min.quot,(int)(t_end-t_beg)%60);
	     // printf("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n");
	      
	      if (myid ==0){
	      fprintf(fp_phyml_lk,"%f\n",tree->tot_loglk);	 
	      }
	      
	      if((input->n_data_sets == 1) &&
		 (input->n_trees     >  1) &&
		 (tree->tot_loglk > best_loglk))
		{

		  best_loglk = tree->tot_loglk;
		  strcpy(s_any,input->seqfile);
		  fp_best_tree = fopen(s_any = strcat(s_any,"_phyml_best_tree.txt"),"w");
		  s_tree = Write_Tree(tree);
		  fprintf(fp_best_tree,"%s\n",s_tree);
		  Free(s_tree);
		  strcpy(s_any,input->seqfile);
		  fp_best_tree_stats = fopen(s_any = strcat(s_any,"_phyml_best_stat.txt"),"w");
		  Print_Fp_Out(fp_best_tree_stats, 
			       t_beg, 
			       t_end, 
			       tree, 
			       input, 
			       n_data_sets);
		  
		  fclose(fp_best_tree);
		  fclose(fp_best_tree_stats);
		}

	      Free_Tree_Lk(tree);
	      
	      Free_Tree(tree);
	      
              if(input->n_data_sets > 1) 
                  {
                      break;
                  }
	    }
	  Free_Cseq(alldata);
	}
    }while(data);

  Free_Model(mod);

  if(input->fp_seq ) fclose(input->fp_seq );
  if(input->fp_input_tree) fclose(input->fp_input_tree);
if (myid == 0){
  fclose(fp_phyml_lk);
  fclose(fp_phyml_tree);
  }

  fclose(fp_phyml_stats);

  Free_Input(input);    
  
  Free(s_any);
//}
  MPI_Finalize();
  return 0;
}

#endif
/*********************************************************/

