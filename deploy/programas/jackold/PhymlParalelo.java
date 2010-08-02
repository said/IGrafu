import java.util.Vector;

public class PhymlParalelo {

	public static void main (String[] args) throws Exception  {
				
				String diretorio="", arquivo;
				String paramProc;
				int proc,aux=0,contador=0; 
										
				ArquivoManip    man          = new ArquivoManip();
				Vector<String> nomeArquivo2  = new Vector<String>();
				Parametros argumentos        = new Parametros();
				
				argumentos.help(args, 3);
				contador  = argumentos.qualPosicao(args, "phyml");
					  					
				diretorio = argumentos.qualDiretorio(args[1]);
				arquivo   =diretorio+"outSample";
				proc   = Integer.parseInt(args[contador-1]);// numero de
															// processador
				if (argumentos.existeArquivo(args[1])) {
					paramProc=argumentos.paraSeqboot(args, diretorio,contador-1);
					Processo.criarProcesso(paramProc);
				} else {
					System.out.println("o arquivo passado como parametro nao foi encontrado. Impossivel rodar o Seqboot");
					System.exit(1);
				}			
				
				
				aux = argumentos.qualPosicao(args,"consense");				
						
				if(argumentos.existeArquivo(arquivo)){
				 man.newFileOut3( man.getFileVector(arquivo),arquivo,proc);
				 paramProc= argumentos.paraPhymlParalelo(args,arquivo,contador, aux, proc);
				  Processo.criarProcesso(paramProc);
				} else{
					System.out.println("o arquivo "+arquivo+" nao foi criado. Impossivel rodar o Phyml");
					  System.exit(1);
					 }  
				// juntar arquivo.
				for(int i=0;i<proc;i++)
				  nomeArquivo2.add(i,new String(arquivo+"_"+i+"_phyml_tree.txt"));				
				
				arquivo= man.UnicoArq(diretorio,nomeArquivo2);	
				
				if (argumentos.existeArquivo(diretorio+arquivo)) {
					paramProc= argumentos.paraConsense(args,diretorio,arquivo,aux, args.length);
				    System.out.println("Consense...");
					Processo.criarProcesso(paramProc);
				} else {
					System.out.println("o arquivo "+arquivo+" nao foi criado. Impossivel rodar o Consense");
					  System.exit(1);
				}
				
			    
				System.gc();
				
			    System.exit(0);
			}
}
