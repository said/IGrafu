#ifndef UTILITIES_H_
#define UTILITIES_H_

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <ctype.h>
#include <string.h>
#include <time.h>

#define	VERSION		"v1.1"
#define	T_MAX_FILE	200

#define TRUE  1
#define FALSE 0
typedef int bool;

typedef struct __Option {						/* mostly used in 'options.c' */
	char				*mat_file;			/* matrix file name */
	int				nb_matrix;			/* number of matrices (default 1)*/
	char				*tree_file;			/* tree output file name */
	int				tree_file_open_mode;		/* opening file mode for tree file */
	char				*method;			/* method for building initial tree */
	char				NNI;				/* the type of tree swapping */
	char				*NNI_name;			/* the type of tree swapping name */
	char				*topo_file;			/* starting tree topology filename (optional) */
	bool				use_topo_file;			/* do or do not use the topology file */
	char				branch_length;			/* branch lengths to assign to a topology */
	char				*branch_name;			/* branch name assigned to the topology */
	char				*stat_file;			/* statiscal file about FastME execution */
} option;


void Exit (char *message);
int Filexists (char *filename);
void Getstring_Stdin (char *file_name);
FILE *Openfile (char *filename, int mode);
void Uppercase (char *ch);
void *mCalloc (int nb, size_t size);
void askOption (char *question, char *c);
bool testB (char *c);
bool testS (char *c);
bool testW (char *c, bool none);

#endif /*UTILITIES_H_*/
