#revised 12/11/2002
#revised 8/24/2006

CC = cc
CFLAGS = -O4 
LIBS = -lm
EXEC = fastme
DFLAG = -DUNIX

######################################################################################################

MEOBJS = main.o graph.o inputs.o gme.o bme.o newick.o heap.o traverse.o NNI.o bNNI.o interface_utilities.o interface_free.o interface_options.o BIONJ.o

$(EXEC) : $(MEOBJS)
	$(CC) -o $(EXEC) $(MEOBJS) $(LIBS) $(CFLAGS)

clean:
	@rm *.o
######################################################################################################

BIONJ.o : BIONJ.c
	$(CC) $(CFLAGS) $(DFLAG) -c BIONJ.c

interface_utilities.o : interface_utilities.c interface_utilities.h
	$(CC) $(CFLAGS) $(DFLAG) -c interface_utilities.c
	
interface_free.o : interface_free.c interface_free.h
	$(CC) $(CFLAGS) $(DFLAG) -c interface_free.c
	
interface_options.o : interface_options.c interface_options.h
	$(CC) $(CFLAGS) $(DFLAG) -c interface_options.c
	
graph.o : graph.c graph.h
	$(CC) $(CFLAGS) $(DFLAG) -c graph.c
	
inputs.o : inputs.c
	$(CC) $(CFLAGS) $(DFLAG) -c inputs.c
	
gme.o : gme.c
	$(CC) $(CFLAGS) $(DFLAG) -c gme.c
	
bme.o : bme.c
	$(CC) $(CFLAGS) $(DFLAG) -c bme.c
		
newick.o : newick.c newick.h
	$(CC) $(CFLAGS) $(DFLAG) -c newick.c
	
heap.o : heap.c
	$(CC) $(CFLAGS) $(DFLAG) -c heap.c
	
traverse.o : traverse.c
	$(CC) $(CFLAGS) $(DFLAG) -c traverse.c
	
NNI.o : NNI.c
	$(CC) $(CFLAGS) $(DFLAG) -c NNI.c
	
bNNI.o : bNNI.c
	$(CC) $(CFLAGS) $(DFLAG) -c bNNI.c

main.o : main.c main.h
	$(CC) $(CFLAGS) $(DFLAG) -c main.c
