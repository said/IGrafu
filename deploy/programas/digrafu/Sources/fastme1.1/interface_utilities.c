#include "interface_utilities.h"

/*********************************************************/

void Exit (char *message)
{
	fprintf (stderr, "%s", message);
	exit (1);
	return;
}

/*********************************************************/
	
int Filexists (char *filename)
{ 
	FILE *fp;
	fp = fopen (filename, "r");
	if (fp) {
		fclose(fp);
		return 1;
	}
	else
		return 0;
}

/*********************************************************/

void Getstring_Stdin (char *file_name)
{ 
	fgets (file_name, T_MAX_FILE, stdin);
	if (strchr (file_name, '\n') != NULL)
		*strchr (file_name, '\n') = '\0';
	return;
}

/*********************************************************/

FILE *Openfile (char *filename, int mode)
{
	/* mode = 0 -> read */
	/* mode = 1 -> write */
	/* mode = 2 -> append */
	FILE *fp;
	char *s;
	int open_test = 0;

	s = filename;
	fp = NULL;
	switch (mode)
	{
		case 0 :
		{
			while (!(fp = (FILE *) fopen (s, "r")) && ++open_test < 10)
			{
				printf ("\nCan't open file %s, enter a new name : ", s);
				Getstring_Stdin (s);
				fflush (stdout);
			}
			break;
      	}
		case 1 :
		{
			fp = (FILE *) fopen (s, "w");
			break;
		}
		case 2 :
		{
			fp = (FILE *) fopen (s, "a");
			break;
		}
 		default :
 			break;
    }
	return fp;
}

/*********************************************************/

void Uppercase (char *ch)
{
	/* convert ch to upper case -- either ASCII or EBCDIC */
	int i;
	for (i = 0; i < strlen (ch); ++i) {
		ch[i] = isupper((int)ch[i]) ? ch[i] : toupper((int)ch[i]);
	}
	return;
}

/*********************************************************/

void *mCalloc (int nb, size_t size)
{
	void *allocated = NULL;
	if ((allocated = calloc ((size_t) nb, (size_t) size)) == NULL)
		Exit ("\n. Err: low memory\n");
	return allocated;
}

/*********************************************************/

void askOption (char *question, char *c)
{
	printf (question);
	Getstring_Stdin (c);
	Uppercase (c);
	return;
}

/*********************************************************/

bool testB (char *c)
{
	bool ret = FALSE;
	switch (strlen (c))
	{
	case 1:
		if (strncmp (c, "N", 1) == 0 || strncmp (c, "B", 1) == 0 || strncmp (c, "O", 1) == 0 || strncmp (c, "I", 1) == 0 || strncmp (c, "U", 1) == 0)
			ret = TRUE;
		break;
	case 2:
		if (strncmp (c, "NJ", 2) == 0)
			ret = TRUE;
		break;
	case 3:
		if (strncmp (c, "OLS", 3) == 0)
			ret = TRUE;
		break;
	case 4:
		if (strncmp (c, "USER", 4) == 0)
			ret = TRUE;
		break;
	case 5:
		if (strncmp (c, "BIONJ", 5) == 0)
			ret = TRUE;
		break;
	case 7:
		if (strncmp (c, "OLS_GME", 7) == 0)
			ret = TRUE;
		break;
	case 8:
		if (strncmp (c, "BALANCED", 8) == 0)
			ret = TRUE;
		break;
	case 12:
		if (strncmp (c, "BALANCED_GME", 12) == 0)
			ret = TRUE;
		break;
	default:
		break;
	}
	return ret;
}

/*********************************************************/

bool testS (char *c)
{
	bool ret = FALSE;
	switch (strlen (c))
	{
	case 1:
		if (strncmp (c, "B", 1) == 0 || strncmp (c, "O", 1) == 0 || strncmp (c, "N", 1) == 0)
			ret = TRUE;
		break;
	case 3:
		if (strncmp (c, "OLS", 3) == 0)
			ret = TRUE;
		break;
	case 4:
		if (strncmp (c, "NONE", 4) == 0 )
			ret = TRUE;
		break;
	case 7:
		if (strncmp (c, "OLS_NNI", 7) == 0 )
			ret = TRUE;
		break;
	case 8:
		if (strncmp (c, "BALANCED", 8) == 0 )
			ret = TRUE;
		break;
	case 12:
		if (strncmp (c, "BALANCED_NNI", 12) == 0 )
			ret = TRUE;
		break;
	default:
		break;
	}
	return ret;
}

/*********************************************************/

bool testW (char *c, bool none)
{
	bool ret = FALSE;
	switch (strlen (c))
	{
	case 1:
		if (strncmp (c, "B", 1) == 0 || strncmp (c, "O", 1) == 0)
			ret = TRUE;
		else if  (strncmp (c, "N", 1) == 0 && none)
			ret = TRUE;
		break;
	case 3:
		if (strncmp (c, "OLS", 3) == 0)
			ret = TRUE;
		break;
	case 4:
		if (strncmp (c, "NONE", 4) == 0 && none)
			ret = TRUE;
		break;
	case 8:
		if (strncmp (c, "BALANCED", 8) == 0 )
			ret = TRUE;
		break;
	default:
		break;
	}
	return ret;
}
