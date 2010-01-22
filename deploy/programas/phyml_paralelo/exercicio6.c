/* scatterv com memoria dinamica */
#include "mpi.h"
#include <stdio.h>
#include <math.h>
#include <stdlib.h>



int main(int argc,char *argv[])
{
    int  i, numprocs, myid, d;
    double *A;

    int j, c, e;
    int nc, nl;

    MPI_Init(&argc,&argv);
    MPI_Comm_size(MPI_COMM_WORLD,&numprocs);
    MPI_Comm_rank(MPI_COMM_WORLD,&myid);
    double *B;
    nc = 6;
    nl = 16;
    d = nc*nl;
    A = (double *)malloc((d)*sizeof(double));
             for (i=0; i<nl*nc; i++){
		       A[i] = 1.0;
                }
     if (nl%numprocs != 0){
           if (myid != numprocs - 1){
              e = nl/numprocs;
           }
	   else{
              e = nl/numprocs + nl%numprocs;
           }
       }
     else{
              e = nl/numprocs;
      }
    B = envio_matriz(A,numprocs, myid, nc , nl, e);

    printf("eu %d\n ", myid);
             for (i=0; i<e ; i++){
		for(j=0; j<nc; j++){
    			printf(" %lf ",  B[i+ e*j]);
                }
             printf("\n");
             }

    MPI_Finalize();
    return 0;
    }
    
    double *envio_matriz( double *A, int numprocs, int myid, int nc, int nl, int e)
    {
    
    int *tamanho;
    int *desplazamento;
    int  c, i,j;
    double *B;
    
    
    if(myid == 0){
            /* printf("entre valor de linhas\n");
             scanf("%d", &nl);   
             printf("valor de nl %d\n", nl);
             printf("entre valor de colunas\n");
             scanf("%d", &nc);   
             printf("valor de nc %d\n", nc);
             d = nl * nc; 
             A = (int *)malloc((d)*sizeof(int));
             for (i=0; i<nl*nc; i++){
		       A[i] = 1;
                }
             for (i=0; i<nl ; i++){
		for(j=0; j<nc; j++){
    			printf(" %d ",  A[i+ nl*j]);
                }
             printf("\n");
             }*/
	     
             tamanho = (int *)malloc(numprocs*sizeof(int));
             desplazamento = (int *)malloc(numprocs*sizeof(int));
             if (nl % numprocs != 0){
                     for(i=0; i<numprocs-1; i++){
                              tamanho[i] = (nl/numprocs)*nc;
                     }
                     tamanho[numprocs - 1] = (nl/numprocs + nl%numprocs)*nc;
             }
             else{
                     for(i=0; i<numprocs; i++){
                              tamanho[i] = (nl/numprocs)*nc;
                     }
              }
              desplazamento[0] = 0;
              for (i=1; i < numprocs; i++){
              c = desplazamento[i-1];
              desplazamento[i] = tamanho[i-1] + c;
              }

            
     }
     /*MPI_Bcast(&nl,1,MPI_INT,0, MPI_COMM_WORLD);
     MPI_Bcast(&nc,1,MPI_INT,0, MPI_COMM_WORLD);*/
     /*if (nl%numprocs != 0){
           if (myid != numprocs - 1){
              e = nl/numprocs;
           }
	   else{
              e = nl/numprocs + nl%numprocs;
           }
       }
     else{
              e = nl/numprocs;
      }*/
            
     B = (double *)malloc((e)*nc*sizeof(double));
     MPI_Scatterv(&A[0],tamanho,desplazamento,MPI_DOUBLE,&B[0],e*nc,MPI_DOUBLE,0,MPI_COMM_WORLD); 
           /* printf("eu %d\n ", myid);
             for (i=0; i<e ; i++){
		for(j=0; j<nc; j++){
    			printf(" %lf ",  B[i+ e*j]);
                }
             printf("\n");
             }*/

    
    return B;
}
