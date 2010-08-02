#include "interface_utilities.h"
#include "interface_options.h"
#include "interface_free.h"
//#include "main.h"

#define BOLD      "\033[00;01m"
#define FLAT      "\033[00;00m"
#define LINE      "\033[00;04m"


/*********************************************************/

void Usage()
{
	printf (BOLD"NAME\n"
		FLAT"\tFastME\n"
		FLAT"\tA distance based phylogeny reconstruction algorithm.\n"
		FLAT"\tFastME showed better topological accuracy than NJ,\n"
		FLAT"\tBIONJ, WEIGHBOR and FITCH, in all evolutionary\n"
		FLAT"\tconditions we tested, which include large range\n"
		FLAT"\tdeviations from molecular clock and substitution rates.\n\n"
		FLAT"\tRichard Desper and Olivier Gascuel,\n"
		FLAT"\tJournal of Computational Biology 19(5), 687-705, 2002.\n"
		FLAT"\tMolecular Biology and Evolution 21(3), 587-598, 2004.\n"
		FLAT"\tPlease cite these papers if you use this software in your publications.\n");

	printf(BOLD"\nCOMMAND-LINE USE\n"
		BOLD"\tfastme "FLAT"[ "
		LINE"matrix_file"FLAT" "
		LINE"method"FLAT" "
		LINE"number_of_matrix"FLAT" "
		LINE"NNI_type"FLAT" ] [ "
		LINE"topology_file"FLAT" ] [ "
		LINE"branch_length"FLAT" ] \n");

	printf(FLAT"\n\tYou can use fastme with no arguments, in this case change the value of\n"
		FLAT"\ta parameter by typing its corresponding character as shown on screen.\n\n"
		FLAT"\tYou can alternatively use fastme with the following arguments :\n");

	printf(LINE"\n\tfastme"FLAT"\t-ibnstwv\n"
	
		LINE"\n\t-i"FLAT"\tmatrix_file: filename of distance matrix\n"

		LINE"\n\t-b"FLAT"\tmethod: method for building initial tree"
		FLAT"\n\t\t"BOLD"(b)alanced_GME"FLAT" (default) | "BOLD"(O)LS_GME"FLAT" | "BOLD"B(I)ONJ"FLAT" | "BOLD"(N)J\n"

		LINE"\n\t-n"FLAT"\tnumber_of_matrix: number of trees/matrices input (default = 1)\n"

		LINE"\n\t-s"FLAT"\tNNI_type: type of tree swapping"
		FLAT"\n\t\t"BOLD"(b)alanced_NNI"FLAT" (default) | "BOLD"(O)LS_NNI"FLAT" | "BOLD"(n)one\n"

		LINE"\n\t-t"FLAT"\ttopology_file: filename of starting tree topology\n"

		LINE"\n\t-w"FLAT"\tbranch_length: (b)alanced or (O)LS branch lengths (if not doing NNIs), (n)one only available with NJ or BIONJ\n\n");
		
//		LINE"\n\t-v"FLAT"\tverbose output\n\n");

	Exit ("");
	return;
}

/*********************************************************/

void Set_Defaults_Input (option *input)
{
	input->mat_file		= (char *) mCalloc (T_MAX_FILE, sizeof(char));
	input->tree_file	= (char *) mCalloc (T_MAX_FILE, sizeof(char));
	input->topo_file	= (char *) mCalloc (T_MAX_FILE, sizeof(char));
	input->method		= (char *) mCalloc (50, sizeof(char));
	input->NNI_name		= (char *) mCalloc (50, sizeof(char));
	input->branch_name	= (char *) mCalloc (50, sizeof(char));
	input->stat_file	= (char *) mCalloc (T_MAX_FILE, sizeof(char));
	
	input->nb_matrix		= 1;
	input->tree_file_open_mode	= 1;
	input->NNI			= 'b';
	input->branch_length		= 'b';
	input->use_topo_file		= FALSE;
	strncpy (input->method, "balanced", 8);
	strncpy (input->NNI_name, "balanced", 8);
	strncpy (input->topo_file, "", 0);
	strncpy (input->branch_name, "balanced", 8);
	return;
}

/*********************************************************/

option *Get_Input (int argc, char **argv)
{
 	option *input = (option *) mCalloc (1, sizeof (option));
	putchar('\n');

	Set_Defaults_Input (input);

	switch (argc)
	{
	case 1:
		Get_Input_Interactive (input);
		break;
//	case 2:
//		Get_Input_CommandLine (input, argc, argv);
//		break;
	default:
		Usage();
		break;
	}

	/*print the parameter values*/
/*	printf ("\n\n\n");
	printf ("Matrix filename : \t\t %s\n", input->mat_file);
	printf ("Number of matrices : \t\t %d\n", input->nb_matrix);
	printf ("Method: \t\t %s\n", input->method);
*/
	return input;
}

/*********************************************************/

void Get_Input_CommandLine (option *input, int argc, char **argv)
{
	printf ("command line");
	return;
}

/*********************************************************/

void Get_Input_Interactive (option *input)
{
	int n_trial = 0;
	char choix, choix_T;
	char *tmp;
	bool none;
	
	printf ("Enter the matrix file name > "); fflush (NULL);
	Getstring_Stdin (input->mat_file);
	while (! Filexists (input->mat_file))
	{
		tmp = (char *) mCalloc (T_MAX_FILE, sizeof(char));
		if (++n_trial > 10) {
			strncpy (tmp, "\nErr : the file '", 17);
			strncat (tmp, input->mat_file, strlen (input->mat_file));
			strncat (tmp, "' doesn't exist\n", 16);
			Exit (tmp);
		}
		strncpy (tmp, "The file '", 10);
		strncat (tmp, input->mat_file, strlen (input->mat_file));
		strncat (tmp, "' doesn't exist\n", 16);
		printf (tmp);
		printf ("Enter the matrix file name > "); fflush (NULL);
		Getstring_Stdin (input->mat_file);
		Free (tmp);
	}
	
	strncpy (input->tree_file, input->mat_file, T_MAX_FILE - 10);
	strncat (input->tree_file, "_tree.txt", 9);
	strncpy (input->stat_file, input->mat_file, T_MAX_FILE - 10);
	strncat (input->stat_file, "_stat.txt", 9);
	
	if (Filexists (input->tree_file) || Filexists (input->stat_file))
	{
		printf ("The file(s) '%s' and/or '%s' already exist(s)\n", input->tree_file, input->stat_file);
		printf ("Do you want to Replace them or Append to them ?\n");
		n_trial = 0;
		do
		{
			printf ("Please type R or A > ");
			scanf ("%c", &choix);
			if (choix == '\n')
				choix = 'X'; 
			else
				getchar();
			Uppercase (&choix);
	  		if (++n_trial > 10)
	  			Exit("\n");
		}
		while ((choix != 'R') && (choix != 'A'));
		if (choix == 'R')
			input->tree_file_open_mode = 1;
		else
			input->tree_file_open_mode = 2;
	}
	choix = 0;

	do
	{
	#ifdef WIN32
		system ("cls");
	#elif UNIX
		printf ("\033[2J\033[H");
	#endif
	
		printf ("\n - FastME %s - \n\n\n", VERSION);
		printf ("Settings for this run:\n\n");
		
		printf ("  B "
			" Initial tree: build method (balanced_GME, OLS_GME, BIONJ or NJ) or user tree "
			" %-15s \n", (input->use_topo_file ? "USER" : input->method));
	
	
		printf ("  N "
			"                                                     Number of matrices/trees "
			" %-15d \n", input->nb_matrix);
	
	
		printf ("  S "
			"                        Type of tree swapping (balanced_NNI, OLS_NNI or none) "
			" %-15s \n", input->NNI_name);
	
	
/*		printf ("  T "
			"                                          Starting tree topology "
			" %-15s \n", (input->use_topo_file ? "yes" : "no"));
*/	
	
/*		printf ("  V "
			"                                                    Verbose mode "
			" %-15s \n", (verbose ? "yes" : "no"));
*/	
	
//		if (input->use_topo_file && input->NNI == 'n')
		if (input->NNI == 'n')
		{
			if (strncmp (input->method, "balanced", 8) == 0 ||
			   (strncmp (input->method, "OLS", 3) == 0) ||
			   (strncmp (input->method, "USER", 4) == 0))
			printf ("  W "
			"                    Branch lengths assigned to the topology (balanced or OLS) "
			" %-15s \n", input->branch_name);
			else
			printf ("  W "
			"              Branch lengths assigned to the topology (balanced, OLS or none) "
			" %-15s \n", input->branch_name);
		}
	
	
		printf ("\n");
		printf ("\nAre these settings correct? "
			"(type  Y  or letter for one to change)  ");

		scanf ("%c", &choix);
		if (choix == '\n') choix = 'X'; 
		else getchar(); // \n

		Uppercase (&choix);

		if ((choix == 'Y') || (choix == 'y'))
			break;
	
		switch (choix)
		{
		
			case 'B':
			{
				char *c;
				c = (char *) mCalloc (T_MAX_FILE, sizeof(char));
				askOption ("Choose your method: (b)alanced_GME, (O)LS_GME, B(I)ONJ, (N)J or (U)ser > ", c);
				n_trial = 0;
				while (! testB (c))
				{
					if (++n_trial > 10)
						Exit ("\nErr : invalid method choosen\n");
					printf ("\nInvalid method choosen\n");
					askOption ("Enter a new value > ", c);
				}
				input->use_topo_file = FALSE;
				if (strncmp (c, "B", 1) == 0 || strncmp (c, "BALANCED", 8) == 0 || strncmp (c, "BALANCED_GME", 12) == 0 ) {
					strncpy (input->method, "balanced\0", 9);
					input->branch_length = 'b';
					strncpy (input->branch_name, "balanced\0", 9);
				}
				else if (strncmp (c, "O", 1) == 0 || strncmp (c, "OLS", 3) == 0 || strncmp (c, "OLS_GME", 7) == 0 ) {
					strncpy (input->method, "OLS\0", 4);
					input->branch_length = 'O';
					strncpy (input->branch_name, "OLS\0", 4);
				}
				else if (strncmp (c, "N", 1) == 0 || strncmp (c, "NJ", 2) == 0) {
					strncpy (input->method, "NJ\0", 3);
					input->branch_length = 'n';
					strncpy (input->branch_name, "none\0", 5);
				}
				else if (strncmp (c, "I", 1) == 0 || strncmp (c, "BIONJ", 5) == 0) {
					strncpy (input->method, "BIONJ\0", 6);
					input->branch_length = 'n';
					strncpy (input->branch_name, "none\0", 5);
				}
				else if (strncmp (c, "U", 1) == 0 || strncmp (c, "USER", 4) == 0) {
					printf ("Enter the starting tree topology file name > "); fflush (NULL);
					Getstring_Stdin (input->topo_file);
					n_trial = 0;
					while (! Filexists (input->topo_file))
					{
						tmp = (char *) mCalloc (T_MAX_FILE, sizeof(char));
						if (++n_trial > 10) {
							strncpy (tmp, "\nErr : the file '", 17);
							strncat (tmp, input->topo_file, strlen (input->topo_file));
							strncat (tmp, "' doesn't exist\n", 16);
							Exit (tmp);
						}
						strncpy (tmp, "The file '", 10);
						strncat (tmp, input->topo_file, strlen (input->topo_file));
						strncat (tmp, "' doesn't exist\n", 16);
						printf (tmp);
						printf ("Enter the starting tree topology file name > "); fflush (NULL);
						Getstring_Stdin (input->topo_file);
						Free (tmp);
					}
					input->use_topo_file = TRUE;
				}
				Free(c);
				break;
			}
		
			case 'N':
			{
				char *c;
				c = (char *) mCalloc (T_MAX_FILE, sizeof(char));
				askOption ("Number of matrices/trees > ", c);
				n_trial = 0;
				while ((!atoi (c)) || (atoi (c) < 0))
				{
					if (++n_trial > 10)
						Exit ("\nErr : the number of matrices/trees must be a positive integer\n");
					printf ("\nThe number of matrices/trees must be a positive integer\n");
					askOption ("Enter a new value > ", c);
				}
				input->nb_matrix = atoi (c);
				Free (c);
				break;
			}
			
			case 'S':
			{
				char *c;
				c = (char *) mCalloc (T_MAX_FILE, sizeof(char));
				askOption ("Choose your tree swapping: (b)alanced_NNI, (O)LS_NNI or (n)one > ", c);
				n_trial = 0;
				while (! testS (c))
				{
					if (++n_trial > 10)
						Exit ("\nErr : invalid NNI choosen\n");
					printf ("\nInvalid NNI choosen\n");
					askOption ("Enter a new value > ", c);
				}
				if (strncmp (c, "B", 1) == 0 || strncmp (c, "BALANCED", 8) == 0 || strncmp (c, "BALANCED_NNI", 12) == 0 ) {
					input->NNI = 'b';
					strncpy (input->NNI_name, "balanced\0", 9);
				}
				else if (strncmp (c, "O", 1) == 0 || strncmp (c, "OLS", 3) == 0 || strncmp (c, "OLS_NNI", 7) == 0 ) {
					input->NNI = 'O';
					strncpy (input->NNI_name, "OLS\0", 4);
				}
				else if (strncmp (c, "N", 1) == 0 || strncmp (c, "NONE", 4) == 0) {
					input->NNI = 'n';
					strncpy (input->NNI_name, "none\0", 5);
				}
				Free (c);
				break;
			}
			
/*			case 'V':
			{
				verbose = abs (verbose - 1);
				break;
			}
*/			
/*			case 'T':
			{
				char *c;
				c = (char *) mCalloc (T_MAX_FILE, sizeof(char));
				if (strlen (input->topo_file) != 0) {
					strncpy (c, "\nStarting tree topology file: '", 31);
					strncat (c, input->topo_file, strlen (input->topo_file));
					strncat (c, "'\n", 2);
					printf (c);
					
					printf ("\n  C "
						"                    Change the topology file name \n");
					if (input->use_topo_file)
						printf ("  U "
							"                     Do not use the topology file \n");
					else
						printf ("  U "
							"                            Use the topology file \n");
					printf ("\nMake your choice > ");
					scanf ("%c", &choix_T);
					if (choix_T == '\n') choix_T = 'X';
					else getchar(); // \n
					Uppercase (&choix_T);

					n_trial = 0;
					switch (choix_T)
					{
						case 'C':
						{
							//char *tmp;
							printf ("Enter the starting tree topology file name > "); fflush (NULL);
							Getstring_Stdin (input->topo_file);
							while (! Filexists (input->topo_file))
							{
								tmp = (char *) mCalloc (T_MAX_FILE, sizeof(char));
								if (++n_trial > 10) {
									strncpy (tmp, "\nErr : the file '", 17);
									strncat (tmp, input->topo_file, strlen (input->topo_file));
									strncat (tmp, "' doesn't exist\n", 16);
									Exit (tmp);
								}
								strncpy (tmp, "The file '", 10);
								strncat (tmp, input->topo_file, strlen (input->topo_file));
								strncat (tmp, "' doesn't exist\n", 16);
								printf (tmp);
								printf ("Enter the starting tree topology file name > "); fflush (NULL);
								Getstring_Stdin (input->topo_file);
								Free (tmp);
							}
							input->use_topo_file = TRUE;
							break;
						}
						case 'U':
						{
							input->use_topo_file = abs (input->use_topo_file - 1);
							break;
						}
						default:
							break;
					}
				}
				else
				{
					//char *tmp;
					printf ("Enter the starting tree topology file name > "); fflush (NULL);
					Getstring_Stdin (input->topo_file);
					n_trial = 0;
					while (! Filexists (input->topo_file))
					{
						tmp = (char *) mCalloc (T_MAX_FILE, sizeof(char));
						if (++n_trial > 10) {
							strncpy (tmp, "\nErr : the file '", 17);
							strncat (tmp, input->topo_file, strlen (input->topo_file));
							strncat (tmp, "' doesn't exist\n", 16);
							Exit (tmp);
						}
						strncpy (tmp, "The file '", 10);
						strncat (tmp, input->topo_file, strlen (input->topo_file));
						strncat (tmp, "' doesn't exist\n", 16);
						printf (tmp);
						printf ("Enter the starting tree topology file name > "); fflush (NULL);
						Getstring_Stdin (input->topo_file);
						Free (tmp);
					}
					input->use_topo_file = TRUE;
				}
				break;
			}
*/
			case 'W':
			{
				char *c;
				c = (char *) mCalloc (T_MAX_FILE, sizeof(char));
				//if (input->use_topo_file && input->NNI == 'n')
				if (input->NNI == 'n')
				{
					if (strncmp (input->method, "balanced", 8) == 0 ||
					   (strncmp (input->method, "OLS", 3) == 0) ||
					   (strncmp (input->method, "USER", 4) == 0))
					{
						askOption ("Choose your branch lengths to assign to the topology: (b)alanced or (O)LS) > ", c);
						none = FALSE;
					}
					else
					{
						askOption ("Choose your branch lengths to assign to the topology: (b)alanced, (O)LS) or (n)one > ", c);
						none = TRUE;
					}
					n_trial = 0;
					while (! testW (c, none))
					{
						if (++n_trial > 10)
							Exit ("\nErr : invalid branch length\n");
						printf ("\nInvalid branch length\n");
						askOption ("Enter a new value > ", c);
					}
					if (strncmp (c, "B", 1) == 0 || strncmp (c, "BALANCED", 8) == 0) {
						input->branch_length = 'b';
						strncpy (input->branch_name, "balanced\0", 9);
					}
					else if (strncmp (c, "O", 1) == 0 || strncmp (c, "OLS", 3) == 0) {
						input->branch_length = 'O';
						strncpy (input->branch_name, "OLS\0", 4);
					}
					else if (strncmp (c, "N", 1) == 0 || strncmp (c, "NONE", 4) == 0) {
						input->branch_length = 'n';
						strncpy (input->branch_name, "none\0", 5);
					}
				}
				Free (c);
				break;
			}
			
			default:
				break;
		}
	} while (1);
	return;
}

