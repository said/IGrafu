#ifndef MAX_LABEL_LENGTH
#define MAX_LABEL_LENGTH 30
#endif
#ifndef NODE_LABEL_LENGTH
#define NODE_LABEL_LENGTH 30
#endif
#ifndef EDGE_LABEL_LENGTH
#define EDGE_LABEL_LENGTH 30
#endif
#ifndef MAX_DIGITS
#define MAX_DIGITS 20
#endif

/*#ifndef true
#define true 1
#endif

#ifndef TRUE
#define TRUE 1
#endif

#ifndef false
#define false 0
#endif
#ifndef FALSE
#define FALSE 0
#endif
#ifndef EXIT_FAILURE
#define EXIT_FAILURE (-1)
#endif

#define ReadOpenParenthesis 0
#define ReadSubTree 1
#define ReadLabel 2
#define ReadWeight 3
#define AddEdge 4
*/

typedef struct node {
  char label[NODE_LABEL_LENGTH];
  struct edge *parentEdge;
  struct edge *leftEdge;
  struct edge *middleEdge;
  struct edge *rightEdge;
  int index;
  int index2;
} node;

typedef struct edge {
  char label[EDGE_LABEL_LENGTH];
  struct node *tail; /*for edge (u,v), u is the tail, v is the head*/
  struct node *head;
  int bottomsize; /*number of nodes below edge */
  int topsize;    /*number of nodes above edge */
  double distance;
  double totalweight;
} edge;

typedef struct tree {
  char name[MAX_LABEL_LENGTH];
  struct node *root;
  int size;
  double weight;
} tree;

typedef struct set 
{
  struct node *firstNode;
  struct set *secondNode;
} set;

node *makeNewNode(char *label, int i);
node *makeNode(char *label, edge *parentEdge, int index);
edge *makeEdge(char *label, node *tail, node *head, double weight);
set *addToSet(node *v, set *X);
tree *newTree();

set *species;
