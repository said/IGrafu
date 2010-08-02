#ifndef OPTIONS_H_
#define OPTIONS_H_

void Usage();
void Set_Defaults_Input (option *input);
option *Get_Input(int argc, char **argv);
void Get_Input_Interactive (option *input);
void Get_Input_CommandLine(option *input, int argc, char **argv);

#endif /*OPTIONS_H_*/
