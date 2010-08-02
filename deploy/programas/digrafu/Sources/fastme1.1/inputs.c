#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "main.h"
#include "graph.h"

boolean leaf(node *v);

edge *depthFirstTraverse(tree *T, edge *e);

/*********************************************************/

void ReplaceForbiddenChar (char *str, char tofind, char replace)
{
  char *tmp;
  while ((tmp = strchr (str, tofind)) != NULL) {
    *tmp = replace;
  }
  return;
}

/*********************************************************/

void ReplaceForbiddenChars (char *str, char replace)
{
  ReplaceForbiddenChar (str, ';', replace);
  ReplaceForbiddenChar (str, ',', replace);
  return;
}

/*********************************************************/

//void compareSets(tree *T, set *S, FILE *ofile)
void compareSets(tree *T, set *S)
{
  edge *e;
  node *v,*w;
  set *X;
  e = depthFirstTraverse(T,NULL);
  while (NULL != e)
    {
      v = e->head;
      for(X = S; NULL != X; X = X->secondNode)
	{
	  w = X->firstNode;
	  if (0 == strcmp(v->label,w->label))
	    {
	      v->index2 = w->index2;
	    w->index2 = -1;
	    break;
	    }
	}
      e = depthFirstTraverse(T,e);
    }
  v = T->root;
  for(X = S; NULL != X; X = X->secondNode)
    {
      w = X->firstNode;
      if (0 == strcmp(v->label,w->label))
	{
	  v->index2 = w->index2;
	  w->index2 = -1;
	  break;
	}
    }
  if (-1 == v->index2)
    {
      fprintf(stderr,"Error leaf %s in tree not in distance matrix.\n",v->label);
      exit(EXIT_FAILURE);
    }
  e = depthFirstTraverse(T,NULL);
  while (NULL != e)
    {
      v = e->head;
      if ((leaf(v)) && (-1 == v->index2))
	{
	  fprintf(stderr,"Error leaf %s in tree not in distance matrix.\n",v->label);
	  exit(EXIT_FAILURE);
	}
      e = depthFirstTraverse(T,e);
      }
  for(X = S; NULL != X; X = X->secondNode)
    if (X->firstNode->index2 > -1)
      {
//	fprintf(ofile,"(v1:0.0)v2;");
//	fclose(ofile);
	fprintf(stderr,"Error node %s in matrix but not a leaf in tree.\n",X->firstNode->label);
	exit(EXIT_FAILURE);
      }
}

void freeMatrix(double **D, int size)
{
  int i;
  for(i=0;i<size;i++)
    free(D[i]);
  free(D);
}

double **loadMatrix(FILE *ifile, int *size, set *S)
{
//  char nextString[MAX_EVENT_NAME];
  char nextString[MAX_LABEL_LENGTH];
  node *v;
  double **table;
  double val;
  int i,j;
  
  char format[MAX_DIGITS];
  snprintf (format, MAX_DIGITS, "%%%ds", MAX_LABEL_LENGTH);
  
  if (!(fscanf(ifile,format,nextString)))
//  if (!(fscanf(ifile,"%s",nextString)))
    {
      fprintf(stderr,"Error loading input matrix.\n");
      exit(EXIT_FAILURE);
    }
  
  *size = atoi(nextString);
  if (*size < 0)
    {
      printf("Problem inputting size.\n");
      exit(EXIT_FAILURE);
    }
  table = (double **) calloc(*size,sizeof(double *));
  for(i=0;i<*size;i++)
    {
      j = 0;
      table[i] = (double *) calloc(*size,sizeof(double));
      if (!(fscanf(ifile,format,nextString)))
      //if (!(fscanf(ifile,"%s",nextString)))
	{
	  fprintf(stderr,"Error loading label %d.\n",i);
	  exit(EXIT_FAILURE);
	}
      ReplaceForbiddenChars (nextString, '_');
      v = makeNewNode(nextString,-1);
      v->index2 = i;
      S = addToSet(v,S);
      while (j < *size)
	{
	  if (!(fscanf(ifile,format,nextString)))
	  //if (!(fscanf(ifile,"%s",nextString)))
	    {
	      fprintf(stderr,"Error loading (%d,%d)-entry.\n",i,j);
	      exit(EXIT_FAILURE);
	    }
	  val = atof(nextString);
	  if ((i != j) && (0 > val))
	    {
	      fprintf(stderr,"Error: program is expecting distance matrix.");
	      fprintf(stderr,"\nInput of %s off diagonal is inappropriate.\n",nextString);
	      exit(EXIT_FAILURE);
	    }
	  table[i][j++] = atof(nextString);
	}	  
    }
  return(table);
}

void CopyMatrix (double **D, float **M, int n)
{
  int i, j;
  for (i = 0; i < n; i++)
  {
    M[i+1]=(float *)calloc(n+1, sizeof(float));
    for (j = 0; j < n; j++)
      M[i+1][j+1] = D[i][j];
  }
  return;
}

void partitionSizes(tree *T)
{
  edge *e;
  e = depthFirstTraverse(T,NULL);
  while (NULL != e)
    {
      if (leaf(e->head))
	e->bottomsize = 1;
      else
	e->bottomsize = e->head->leftEdge->bottomsize 
	  + e->head->rightEdge->bottomsize;
      e->topsize = (T->size + 2)/2 - e->bottomsize;
      e = depthFirstTraverse(T,e);
    }
}
