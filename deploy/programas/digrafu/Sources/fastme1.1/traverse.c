#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "graph.h"
#include "main.h"

edge *findBottomLeft(edge *e)
     /*findBottomLeft searches by gottom down in the tree and to the left.*/
{
  edge *f;
  f = e;
  while (NULL != f->head->leftEdge)
    f = f->head->leftEdge;
  return(f);  
}
  
edge *moveRight(edge *e)
{
  edge *f;
  f = e->tail->rightEdge; /*this step moves from a left-oriented edge
			    to a right-oriented edge*/
  if (NULL != f)
    f = findBottomLeft(f);
  return(f);
}

edge *moveMiddle(edge *e)
{
  edge *f;
  f = e->tail->middleEdge;
  if (NULL == f)
    return(e->tail->parentEdge);
  else
    f = findBottomLeft(f);
  return(f);
}

edge *trinaryDepthFirstTraverse(tree *T, edge *e)
     /*depthFirstTraverse returns the edge f which is least in T according
       to the depth-first order, but which is later than e in the search
       pattern.  If e is null, f is the least edge of T*/
{
  edge *f;
  if (NULL == e)
    {
      f = T->root->leftEdge;   
      if (NULL != f)
	f = findBottomLeft(f); 
      return(f);  /*this is the first edge of this search pattern*/
    }
  else /*e is non-null*/
    {
      if (e->tail->leftEdge == e) 
	/*if e is a left-oriented edge, we skip the entire
	  tree cut below e, and find least edge*/
	f = moveRight(e);
      else if (e->tail->rightEdge == e)
	f = moveMiddle(e);
      else  /*if e is a middle-oriented edge, we have already looked at its
	      sibling and everything below e, so we move up*/
	f = e->tail->parentEdge;
    }
  return(f);
}


edge *depthFirstTraverse(tree *T, edge *e)
     /*depthFirstTraverse returns the edge f which is least in T according
       to the depth-first order, but which is later than e in the search
       pattern.  If e is null, f is the least edge of T*/
{
  edge *f;
  if (NULL == e)
    {
      f = T->root->leftEdge;   
      if (NULL != f)
	f = findBottomLeft(f); 
      return(f);  /*this is the first edge of this search pattern*/
    }
  else /*e is non-null*/
    {
      if (e->tail->leftEdge == e) 
	/*if e is a left-oriented edge, we skip the entire
	  tree cut below e, and find least edge*/
	f = moveRight(e);
      else  /*if e is a right-oriented edge, we have already looked at its
	      sibling and everything below e, so we move up*/
	f = e->tail->parentEdge;
    }
  return(f);
}
        
edge *moveUpRight(edge *e)
{
  edge *f;
  f = e;
  while ((NULL != f) && ( f->tail->leftEdge != f))
    f = f->tail->parentEdge;
  /*go up the tree until f is a leftEdge*/
  if (NULL == f)
    return(f); /*triggered at end of search*/
  else
    return(f->tail->rightEdge);      
  /*and then go right*/
}
  
boolean leaf(node *v);

edge *topFirstTraverse(tree *T, edge *e)
     /*topFirstTraverse starts from the top of T, and from there moves stepwise
       down, left before right*/
     /*assumes tree has been detrifurcated*/
{
  edge *f;
  if (NULL == e)
    return(T->root->leftEdge); /*first Edge searched*/
  else if (!(leaf(e->head)))
    return(e->head->leftEdge); /*down and to the left is preferred*/
  else /*e->head is a leaf*/
    {
      f = moveUpRight(e);
      return(f);
    }
}
