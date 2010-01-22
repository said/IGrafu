/*
	Exercicio 5 - TypeStruct
	Equipe:
	Jose Francisco
	Carine Monteiro
	Daniel Leao	


*/

#include <stdio.h>
#include "mpi.h"

int main(int argc, char* argv[]) {
	int p,id,N,i,j,ii,jj;
	const int tag = 42;	        /* Message tag */
	 MPI_Status    status;
	
	MPI_Init(&argc, &argv);
    	MPI_Comm_size(MPI_COMM_WORLD, &p);
    	MPI_Comm_rank(MPI_COMM_WORLD, &id);
	if(p<2)
	{
		printf("numero de processadores deve ser maior ou igual a 2\n");
		return 0;
	}
	if(argc!=2)
	{
		if(id ==0)
		printf("<nome do progama> <tamanho da matriz>\n");
		return 0;
	}
	else
	{
		sscanf(argv[1],"%i",&N);
	}
	
	int ** matriz, /*matriz*/
		**tamBlocos;/*vetor tamanho de blocos*/
	MPI_Aint **desloc,/*vetor do deslocamento de enderecos*/
		  inicio,/*endereco inicial*/
		  endereco;/*endereco auxiliar*/
	//MPI_Datatype novoTipo;/*novo tipo para a Struct*/
	
	/*Aloca a matriz*/
	matriz = (int **)malloc(N*sizeof(int*));
	for( i=0;i<N;i++)
	{
	matriz[i]= (int *)malloc(N*sizeof(int));
	}
	/*aloca os vetores*/
	//tamBlocos = (int *)malloc(N*sizeof(int));
	tamBlocos = (int **)malloc(N*sizeof(int*));
	for( i=0;i<N;i++)
	{
	tamBlocos[i]= (int *)malloc(N*sizeof(int));
	}
	//desloc = (MPI_Aint *)malloc(N*sizeof(MPI_Aint));
	desloc = (int **)malloc(N*sizeof(int*));
	for( i=0;i<N;i++)
	{
	desloc[i]= (int *)malloc(N*sizeof(int));
	}
	//MPI_Datatype *tipos = (int *)malloc(N*sizeof(MPI_Datatype));/******************/
	MPI_Datatype **tipos = (int **)malloc(N*sizeof(MPI_Datatype*));
	for( i=0;i<N;i++)
	{
	tipos[i]= (int *)malloc(N*sizeof(MPI_Datatype));
	}
	MPI_Datatype *novoTipo = (int *)malloc(N*sizeof(MPI_Datatype));/******************/
	
	
	/*
		Inicializa o vetor  deslocamento , os tipos e o vetor de tamanho de blocos
	*/
	MPI_Address(matriz[id*(N/p)],&inicio);
	for(jj=0;jj<p;jj++){
	desloc[jj][0]=0;
	tipos[jj][0]=MPI_INT;
	tamBlocos[jj][0]=N;
        for(i=id*(N/p);i<(id+1)*(N/p); i++)
	{
		MPI_Address(matriz[i],&endereco);
		desloc[jj][i]=endereco -inicio;	
		tipos[jj][i]=MPI_INT;
		tamBlocos[jj][i]=N;
	}
	
	
	MPI_Type_struct(N, tamBlocos[jj], desloc[jj],tipos[jj], &novoTipo[jj]);
	MPI_Type_commit(&novoTipo[jj]);
	}
       	
	if(id==0){
	
		printf("Processador 0 envia para 1 a matriz:\n");
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				matriz[i][j]=i*N+j+1;
				printf("%4i ",matriz[i][j]);
			}
			printf("\n");
		}
		
        for(ii=0;ii<p;ii= i++){
		MPI_Send(matriz[id*(N/p)], 1, novoTipo[id], ii, tag, MPI_COMM_WORLD);	
         }
		
	}
	else 
	{
		printf("\nNo processador %i recebida a matriz:\n",id);
		
		MPI_Recv(matriz[0], 1, novoTipo[id], 0, tag, MPI_COMM_WORLD, &status);
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				
				printf("%4i ",matriz[i][j]);
			}
			printf("\n");
		}
	}
	
	/*for(i=0;i<N;i++)
	{
	free(matriz[i]);
	}
	free(matriz);
	free(tipos);
	free(tamBlocos);
	free(desloc);*/
	MPI_Finalize();
	return 0;

}  
