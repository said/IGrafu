                                                                     #include "phylip.h"
#include "cons.h"

/* version 3.6. (c) Copyright 1993-2004 by the University of Washington.
   Written by Joseph Felsenstein, Hisashi Horino,
   Akiko Fuseki, Dan Fineman, Sean Lamont, and Andrew Keeffe.
   Permission is granted
   to copy and use this program provided no fee is charged for it and
   provided that this copyright notice is not removed. */


/* The following extern's refer to things declared in cons.c */

extern int tree_pairing;

extern Char outfilename[FNMLNGTH], intreename[FNMLNGTH], intree2name[FNMLNGTH], outtreename[FNMLNGTH];
extern node *root;

extern long numopts, outgrno, col;
extern long maxgrp;               /* max. no. of groups in all trees found  */

extern boolean trout, firsttree, noroot, outgropt, didreroot, prntsets,
          progress, treeprint, goteof, strict, mr, mre, ml;
extern pointarray nodep;                 /* pointers to all nodes in tree */
extern group_type **grouping, **grping2, **group2;/* to store groups found  */
extern long **order, **order2, lasti;
extern group_type *fullset;
extern long tipy;

extern double trweight, ntrees, mlfrac;

#ifndef OLDC
/* function prototypes */
void   getoptions(void);
void   count_siblings(node **p);
void   treeout(node *);
/* function prototypes */
#endif

void   help(void);//eu
void   lerArgumentos(Char *argv[],int argc);

void getoptions()
{
  /* interactively set options */
  long loopcount, loopcount2;
  Char ch;
  boolean done, done1;

  /* Initial settings */
  ibmpc          = IBMCRT;
  ansi           = ANSICRT;
  didreroot      = false;
  firsttree      = true;
  spp            = 0 ;
  col            = 0 ;

  /* This is needed so functions in cons.c work */
  tree_pairing   = NO_PAIRING ;  

  fprintf(outfile, "\nConsensus tree");
  fprintf(outfile, " program, version %s\n\n", VERSION);
  putchar('\n');
  strict = false;
  mr = false;
  mre = true;
  ml = false;
  mlfrac = 0.5;
  noroot = true;
  numopts = 0;
  outgrno = 1;
  outgropt = false;
  trout = true;
  prntsets = true;
  progress = true;
  treeprint = true;
  loopcount = 0;
  do {
    cleerhome();
    printf("\nConsensus tree");
    printf(" program, version %s\n\n", VERSION);
    printf("Settings for this run:\n");
    printf(" C         Consensus type (MRe, strict, MR, Ml):");
    if (strict)
      printf("  strict\n");
    else if (mr)
        printf("  Majority rule\n");
      else if (mre)
          printf("  Majority rule (extended)\n");
        else if (ml)
            printf("  Ml\n");
          else printf("  Adams\n");
    if (noroot) {
      printf(" O                                Outgroup root:");
      if (outgropt)
        printf("  Yes, at species number%3ld\n", outgrno);
      else
        printf("  No, use as outgroup species%3ld\n", outgrno);
      }
    printf(" R                Trees to be treated as Rooted:");
    if (noroot)
      printf("  No\n");
    else
      printf("  Yes\n");
    printf(" T           Terminal type (IBM PC, ANSI, none):");
    if (ibmpc)
      printf("  IBM PC\n");
    if (ansi)
      printf("  ANSI\n");
    if (!(ibmpc || ansi))
      printf("  (none)\n");
    printf(" 1                Print out the sets of species:");
    if (prntsets)
      printf("  Yes\n");
    else
      printf("  No\n");
    printf(" 2         Print indications of progress of run:  %s\n",
           (progress ? "Yes" : "No"));
    printf(" 3                               Print out tree:");
    if (treeprint)
      printf("  Yes\n");
    else
      printf("  No\n");
    printf(" 4               Write out trees onto tree file:");
    if (trout)
      printf("  Yes\n");
    else
      printf("  No\n");

    printf("\nAre these settings correct? (type Y or the letter for one to change)\n");
#ifdef WIN32
    phyFillScreenColor();
#endif
    scanf("%c%*[^\n]", &ch);
    getchar();
    uppercase(&ch);
    done = (ch == 'Y');
    if (!done) {
      if ((noroot && (ch == 'O')) || strchr("CRT1234",ch) != NULL) {
        switch (ch) {

        case 'C':
          if (strict) {
            strict = false;
            mr = true;
          } else {
            if (ml) {
              ml = false;
              mre = true;
            } else {
              if (mre) {
                mre = false;
                strict = true;
              } else {
                if (mr) {
                  mr = false;
                  ml = true;
                }
              }
            }
          }
          break;

        case 'O':
          outgropt = !outgropt;
          if (outgropt) {
            numopts++;
            loopcount2 = 0;
            do {
              printf("Type number of the outgroup:\n");
#ifdef WIN32
              phyFillScreenColor();
#endif
              scanf("%ld%*[^\n]", &outgrno);
              getchar();
              done1 = (outgrno >= 1);
              if (!done1) {
                printf("ERROR: Bad outgroup number: %ld\n", outgrno);
                printf("  Must be greater than zero\n");
              }
            countup(&loopcount2, 10);
            } while (done1 != true);
          }
          break;

        case 'R':
          noroot = !noroot;
          break;

        case 'T':
          initterminal(&ibmpc, &ansi);
          break;

        case '1':
          prntsets = !prntsets;
          break;

        case '2':
          progress = !progress;
          break;
        
        case '3':
          treeprint = !treeprint;
          break;

        case '4':
          trout = !trout;
          break;

        }
      } else
        printf("Not a possible option!\n");
    }
    countup(&loopcount, 100);
  } while (!done);
  if (ml) {
    do {
      printf("\nFraction (l) of times a branch must appear\n");
      scanf("%lf%*[^\n]", &mlfrac);
      getchar();
    } while ((mlfrac < 0.5) || (mlfrac > 1.0));
  }
}  /* getoptions */


void count_siblings(node **p)
{
  node *tmp_node;
  int i;

  if (!(*p)) {
    /* This is a leaf, */
    return;
  } else {
    tmp_node = (*p)->next;
  }

  for (i = 0 ; i < 1000; i++) {
    if (tmp_node == (*p)) {
      /* When we've gone through all the siblings, */
      break;
    } else if (tmp_node) {
      tmp_node = tmp_node->next;
    } else  {
      /* Should this be executed? */
      return ;
    }
  }
} /* count_siblings */


void treeout(node *p)
{
  /* write out file with representation of final tree */
  long i, n = 0;
  Char c;
  node *q;
  double x;

  count_siblings (&p);  

  if (p->tip) {
    /* If we're at a node which is a leaf, figure out how long the
       name is and print it out. */
    for (i = 1; i <= MAXNCH; i++) {
      if (p->nayme[i - 1] != '\0')
        n = i;
    }
    for (i = 0; i < n; i++) {
      c = p->nayme[i];
      if (c == ' ')
        c = '_';
      putc(c, outtree);
    }
    col += n;
  } else {
    /* If we're at a furcation, print out the proper formatting, loop
       through all the children, calling the procedure recursively. */
    putc('(', outtree);
    col++;
    q = p->next;
    while (q != p) {
      /* This should terminate when we've gone through all the
         siblings, */
      treeout(q->back);
      q = q->next;
      if (q == p)
        break;
      putc(',', outtree);
      col++;
      if (col > 60) {
        putc('\n', outtree);
        col = 0;
      }
    }
    putc(')', outtree);
    col++;
  }

  if (p->tip)
    x = ntrees;
  else
    x = (double)p->deltav;

  if (p == root) {
    /* When we're all done with this tree, */
    fprintf(outtree, ";\n");
    return;
  }

  /* Figure out how many characters the branch length requires: */
  else {
    if (!strict) {
      if (x >= 100.0) { 
        fprintf(outtree, ":%5.1f", x);
        col += 4;
      } else if (x >= 10.0) {
          fprintf(outtree, ":%4.1f", x); 
          col += 3;
        } else if (x >= 0.99) {
            fprintf(outtree, ":%3.1f", x);
            col += 2;
          } else {
            fprintf(outtree, ":%4.2f", x); 
            col += 3;
          }
    }
  }
}  /* treeout */

void help(){
printf("./Consense [Arquivo_entrada] [Arquivo_saida] [R] [C] [O] [1] [2] [3] [4] [5] \n");
        printf("\t cada letra indica opcoes do menu interativo.\n\n");
        printf("[Arquivo_entrada]  -- arquivo entrada contendo as arvores.\n--PARAMETRO OBRIGATORIO\n");
        printf("[Arquivo_saida] -- saida padrao do consense \n");
        printf("[R] -- Se trata a arvore com ou sem raiz: SIM(S) ou NAO(N).\n--PARAMETRO OBRIGATORIO\n");
        printf("[C] -- tipo de avaliacao, pode ser: EXTENDED MAJORITY RULE(MRE); STRICT(STR); MAJORITY RULE(MR); ML(ML).\n--PARAMETRO OBRIGATORIO\n");
        printf("[O] -- opcao para definir raiz(maior ancestral), deve-se passar dois parametro:\n\t o primeiro a palavra ROOT,\n\t o segundo indicar a posicao da especie no arquivo considerando a ordem.EX: 3 (a terceira especie).\n--PARAMETRO NAO OBRIGATORIO\n");
       printf("[1] --  indicar as especies no arquivo saida,deve-se escrever a palavra PRINT. \n--PARAMETRO NAO OBRIGATORIO\n");
       printf("[2] -- indicar execucao,deve-se escrever a palavra RUN.\n--PARAMETRO NAO OBRIGATORIO\n");
       printf("[3] -- escrever arvore resultado, deve-se escrever a palavra TREE.\n--PARAMETRO NAO OBRIGATORIO\n");
       printf("[4] -- escrever a arvore em outro arquivo,deve-se escrever dois parametros:\n\to primeira a palavra FILE,\n\to segundo o diretorio/Nome_arquivo onde sera salvo o arquivo.\n--PARAMETRO NAO OBRIGATORIO\n");
	printf("[5] -- Fraction (l), somente considerado se opçao C = ML.Deve-se passar dois parametro:\n\t o primeiro a palavra FRACTION,\n\t o segundo o valor entre 0.5 - 1.0 EX.0.5\n--PARAMETRO NAO OBRIGATORIO \n");
        exit (0);
         }

void lerArgumentos(  Char *argv[], int argc){
/* Initial settings *///-- copia
long db;
int pos=5;
  ibmpc          = IBMCRT;
  ansi           = ANSICRT;
  didreroot      = false;
  firsttree      = true;
  spp            = 0 ;
  col            = 0 ;

/* This is needed so functions in cons.c work *///copia
  tree_pairing   = NO_PAIRING ;  

// default
  strict = false;
  mr = false;
  mre = true;
  ml = false;
  mlfrac = 0.5;
  noroot = true;
  numopts = 0;
  outgrno = 1;
  outgropt = false;
  trout = false;
  prntsets = false;
  progress = false;
  treeprint = false;

openfile(&intree, argv[1], "input tree file", "r", argv[1], intreename);
openfile(&outfile, argv[2], "output file", "w", argv[2], outfilename);

if(strcmp(argv[4],"MRE")==0)
 mre=true;
else{
if(strcmp(argv[4],"STR")==0)//c
    {    strict = true;
          mre = false;
          }else{
             if(strcmp(argv[4],"MR")==0){
                 mre = false;
                 mr = true;
}else{
if(strcmp(argv[4],"ML")==0){
         mre = false;
         ml = true;
}else{
printf("opçao nao reconhecida (C). Escolha uma opçao pre-definida na ajuda\n");
          exit(0);// interrompe
}}}}

   if(strcmp(argv[3],"N")==0)//R-- verificar...
     noroot = true;
   else{ 
     if(strcmp(argv[3],"S")==0)
       noroot = false;
     else{
          printf("opçao nao reconhecida (R). Escolha uma opçao pre-definida na ajuda\n");
          exit(0);// interrompe
      }}

//os nao obrigatorios.

while(pos<argc){
     //condiçao..

     if(strcmp(argv[pos],"ROOT")==0 && noroot)//O
      {  if (pos++<argc){
          db= atof(argv[pos]);
          if (db<1)
          { printf("outgroup, bad number\n\n");
            exit(0);
           }else
             outgrno= db;
        }
     }//fim condiçao

     if(strcmp(argv[pos],"PRINT")==0)//1
        prntsets = true;
     if(strcmp(argv[pos],"RUN")==0)//2
        progress= true;
     if(strcmp(argv[pos],"TREE")==0)//3
        treeprint= true;
     if(strcmp(argv[pos],"FRACTION")==0 && ml && pos+1<argc)//4
     {
         pos++;
         db= atof(argv[pos]);
           if((db < 0.5) || (db > 1.0))
                printf("Fraction (l) of times a branch must appear, bad number\nDefault-0.5\n\n");
          else 
              mlfrac= db;
      }//fim_5
    if (strcmp(argv[pos],"FILE")==0)
     { if( pos++<argc){
            trout = true;
            openfile(&outtree, argv[pos], "output tree file", "w", argv[pos], outtreename);//escrita no arquivo.
          }else
             printf("Opcao desconsiderada\n");
       }//4

pos++;

}

}
int main(int argc, Char *argv[])
{  
  /* Local variables added by Dan F. */
  pattern_elm  ***pattern_array;
  double *timesseen_changes = NULL;
  long trees_in = 0;
  long i, j;
  node *p, *q;
  

#ifdef MAC
  argc = 1;                /* macsetup("Consense", "");        */
  argv[0] = "Consense";
#endif
  init(argc, argv);
  
  
    if(argc > 1)
     { // entra com argumentos...
      if ( strcmp(argv[1],"help" )==0)
        help();// imprime tela de ajuda
       if ( argc <5 ){
	printf("Quantidade de parametros ERRADA\n");
	printf("Todos os parametros OBRIGATORIOS devem ser passados corretamente e na ordem.Os parametros nao obrigatorios so devem ser passados apos terminar os obrigatorios!\n\n");
	exit(0);
	}
     lerArgumentos( argv,argc);
   }else   {// nao entra na linha d comando
    openfile(&outfile, OUTFILE, "output file", "w", argv[0], outfilename);
    openfile(&intree, INTREE, "input tree file", "r", argv[0], intreename);
    getoptions();
        if (trout)
    openfile(&outtree, OUTTREE, "output tree file", "w", argv[0], outtreename);
    }

  ntrees = 0.0;
  maxgrp = 32767;   /* initial size of set hash table */
  lasti  = -1;	

  if (prntsets)
    fprintf(outfile, "Species in order: \n\n");

  trees_in = countsemic(&intree);
// colocar para imprimir opçoes.
/*printf(" op C-strict = %d\n",strict);
printf("op C-mr = %d\n",mr);
printf("op C-mre = %d\n",mre);
printf("op C-ml = %d\n",ml);
printf("mlfrac = %4.2f\n",mlfrac);
printf("op R-noroot = %d\n",noroot);
printf("numopts = %d\n",numopts);
printf("op o2-outgrno = %d\n",outgrno);
printf("op 4-trout = %d\n",trout);
printf("prntsets = %d\n",prntsets);
printf("op 3-treeprint = %d\n",treeprint);
printf("op 1-progress = %d\n",progress);*/


  /* Read the tree file and put together grouping, order, and timesseen */
  read_groups (&pattern_array, timesseen_changes, trees_in, trees_in, intree);
  /* Compute the consensus tree. */
  putc('\n', outfile);
  nodep      = (pointarray)Malloc(2*(1+spp)*sizeof(node *));
  for (i = 0; i < spp; i++) {
    nodep[i] = (node *)Malloc(sizeof(node));
    for (j = 0; j < MAXNCH; j++)
      nodep[i]->nayme[j] = '\0';
    strncpy(nodep[i]->nayme, nayme[i], MAXNCH);
  }
  for (i = spp; i < 2*(1+spp); i++)
    nodep[i] = NULL;
  consensus(pattern_array, trees_in);
  printf("\n");
  if (trout) {
    treeout(root);
    if (progress)
      printf("Consensus tree written to file \"%s\"\n\n", outtreename);
  }
  if (progress)
    printf("Output written to file \"%s\"\n\n", outfilename);
  for (i = 0; i < spp; i++)
    free(nodep[i]);
  for (i = spp; i < 2*(1 + spp); i++) {
    if (nodep[i] != NULL) {
      p = nodep[i]->next;
      do {
        q = p->next;
        free(p);
        p = q;
      } while (p != nodep[i]);
      free(p);
    }
  }
  free(nodep);
  FClose(outtree);
  FClose(intree);
  FClose(outfile);

#ifdef MAC
  fixmacfile(outfilename);
  fixmacfile(outtreename);
#endif
printf("Done.\n\n");

#ifdef WIN32
  phyRestoreConsoleAttributes();
#endif

return 0;
}  /* main */

