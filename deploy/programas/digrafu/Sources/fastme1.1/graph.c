#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "graph.h"
#include "main.h"

boolean leaf(node *v)
{
  int count = 0;
  if (NULL != v->parentEdge)
    count++;
  if (NULL != v->leftEdge)
    count++;
  if (NULL != v->rightEdge)
    count++;
  if (NULL != v->middleEdge)
    count++;
  if (count > 1)
    return(FALSE);
  return(TRUE);
}

set *addToSet(node *v, set *X)
{
  if (NULL == X)
    {
      X = (set *) malloc(sizeof(set));
      X->firstNode = v;
      X->secondNode = NULL;
    }
  else if (NULL == X->firstNode) 
    X->firstNode = v;
  else
    X->secondNode = addToSet(v,X->secondNode);
  return(X);
}

node *makeNode(char *label, edge *parentEdge, int index)
{
  node *newNode;  /*points to new node added to the graph*/
  newNode = (node *) malloc(sizeof(node));
  strncpy(newNode->label,label,NODE_LABEL_LENGTH);
  newNode->index = index;
  newNode->index2 = -1;
  newNode->parentEdge = parentEdge;
  newNode->leftEdge = NULL;
  newNode->middleEdge = NULL;
  newNode->rightEdge = NULL;
  /*all fields have been initialized*/
  return(newNode);
}

edge *makeEdge(char *label, node *tail, node *head, double weight)
{
  edge *newEdge;
  newEdge = (edge *) malloc(sizeof(edge));
  strncpy(newEdge->label,label,EDGE_LABEL_LENGTH);
  newEdge->tail = tail;
  newEdge->head = head;
  newEdge->distance = weight;
  newEdge->totalweight = 0.0;
  return(newEdge);
}

tree *newTree()
{
  tree *T;
  T = (tree *) malloc(sizeof(tree));
  T->root = NULL;
  T->size = 0;
  T->weight = -1;
  return(T);
}

void freeSubTree(edge *e)
{
  node *v;
  edge *e1, *e2;
  v = e->head;
  e1 = v->leftEdge;
  if (NULL != e1)
    freeSubTree(e1);
  e2 = v->rightEdge;
  if (NULL != e2)
    freeSubTree(e2);
  free(v);
  e->tail = NULL;
  e->head = NULL;
  free(e);
}

void freeTree(tree *T)
{
  node *v;
  v = T->root;
  if (NULL != v->leftEdge)
    freeSubTree(v->leftEdge);
  free(T->root);
  free(T);
}

void freeSet(set *S)
{
  if (NULL != S)
    freeSet(S->secondNode);
  free(S);
}

/*copyNode returns a copy of v which has all of the fields identical to those
of v, except the node pointer fields*/
node *copyNode(node *v)
{
  node *w;
  w = makeNode(v->label,NULL,v->index);
  w->index2 = v->index2;
  return(w);
}

node *makeNewNode(char *label, int i)
{
  return(makeNode(label,NULL,i));
}

/*copyEdge calls makeEdge to make a copy of a given edge */
/*does not copy all fields*/
edge *copyEdge (edge *e)
{
  edge *newEdge;
  newEdge = makeEdge(e->label,e->tail,e->head,e->distance);
  newEdge->topsize = e->topsize;
  newEdge->bottomsize = e->bottomsize;
  return(newEdge);
}

/*detrifurcate takes the (possibly trifurcated) input tree
  and reroots the tree to a leaf*/
/*assumes tree is only trifurcated at root*/
tree *detrifurcate(tree *T)
{
  node *v, *w;
  edge *e, *f;
  v = T->root;
  if(leaf(v))
    return(T);
  if (NULL != v->parentEdge)
    {
      fprintf(stderr,"Error: root %s is poorly rooted.\n",v->label);
      exit(EXIT_FAILURE);
    }
  for(e = v->middleEdge, v->middleEdge = NULL; NULL != e; e = f )
    {
      w = e->head;
      v = e->tail;
      e->tail = w;
      e->head = v;
      f = w->leftEdge;
      v->parentEdge = e;
      w->leftEdge = e;
      w->parentEdge = NULL;      
    }
  T->root = w;
  return(T);
}

edge *siblingEdge(edge *e)
{
  if(e == e->tail->leftEdge)
    return(e->tail->rightEdge);
  else
    return(e->tail->leftEdge);
}

void updateSizes(edge *e, int direction)
{
  edge *f;
  switch(direction)
    {
    case UP:
      f = e->head->leftEdge;
      if (NULL != f)
	updateSizes(f,UP);
      f = e->head->rightEdge;
      if (NULL != f)
	updateSizes(f,UP);
      e->topsize++;
      break;
    case DOWN:
      f = siblingEdge(e);
      if (NULL != f)
	updateSizes(f,UP);
      f = e->tail->parentEdge;
      if (NULL != f)
	updateSizes(f,DOWN);
      e->bottomsize++;
      break;
    }
}      
