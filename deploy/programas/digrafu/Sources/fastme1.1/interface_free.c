#include "interface_utilities.h"
#include "interface_free.h"

/*********************************************************/

void Free (void *p)
{
	free (p);
	return;
}

/*********************************************************/

void Free_Input (option *input)
{
	Free (input->mat_file);
	Free (input->tree_file);
	Free (input->topo_file);
	Free (input->method);
	Free (input->NNI_name);
	Free (input->branch_name);
	Free (input);
	return;
}

/*********************************************************/

