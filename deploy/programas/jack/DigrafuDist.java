import java.util.Vector;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.lang.InterruptedException;

public class DigrafuDist {

	public static void main(String[] args) throws Exception {

		String diretorio, arquivo,paramProc;
		int contador = 0, amostra = 0, aux = 0, cont = 0, nos = 0;
		Vector<String> processos , nomeArquivo;
		CyclicBarrier barrier;
	
	//	Vector<String>	 nomeArquivo, processos;
		
		ArquivoManip man = new ArquivoManip();
		Parametros argumentos = new Parametros();
		processos = new Vector<String>();
		nomeArquivo = new Vector<String>();

		argumentos.help(args,5);
		contador  =argumentos.qualPosicao(args, "Run");
		diretorio = argumentos.qualDiretorio(args[1]);	
		
		paramProc = argumentos.paraSeqboot(args, diretorio,contador-1);
		arquivo = diretorio + "outSample";// saida do seq
		Processo.criarProcesso( paramProc);
		
		if (!argumentos.existeArquivo(arquivo)) {
			System.out.println("o arquivo " + arquivo + " nao foi criado. Impossivel continuar");
			System.exit(1);
		}

		try {
			nomeArquivo = man.newFileOut(man.getFileVector(arquivo), diretorio);
			amostra = Integer.parseInt(args[3]);// quantidade de seqboot
			nos = Integer.parseInt(args[contador - 1]);
			cont= amostra/nos;// qtidade q fica para cada processador.
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel transformar o parametro em inteiro");
		}
		
		aux   =argumentos.qualPosicao(args, "consense");
		 barrier= new CyclicBarrier(nos+1);
		 
		for (int i = 0; i < amostra; i++) {
			 paramProc = argumentos.paraDiGrafu(args, diretorio, nomeArquivo
					.get(i), i, contador, aux);
			 processos.add(i, paramProc);
			nomeArquivo.add(diretorio + "outDiGrafu_" + i);		
		}
//		cria thread 
		for(int i=0;i<nos-1;i++){ 
			new Thread(new ProcessoThread(processos, barrier,"no"+(i+1),i*cont,(i+1)*cont)).start();
			System.out.println("iniciou uma thread: "+i+" --valor:"+i*cont+" , "+(i+1)*cont);
		    }
			new Thread(new ProcessoThread(processos, barrier,"no"+nos,(nos-1)*cont,processos.size())).start();
				System.out.println("iniciou ultima thread:  --valor:"+(nos-1)*cont+" , "+processos.size());
				
				try {//espera terminar
	             barrier.await();
				 } catch (InterruptedException ex) { 
			            System.out.println(ex); 
			         } catch (BrokenBarrierException ex) { 
			           System.out.println(ex); 
			         }
			         
		//nomeArquivo.clear();         

		// juntar arquivo.		
		try {
			arquivo = man.UnicoArq(diretorio, nomeArquivo);
		} catch (Exception e) {
			System.out.println("nao foi possivel juntar o arquivo");
		}

		 paramProc = argumentos.paraConsense(args, diretorio,arquivo,aux,
				args.length);		
		Processo.criarProcesso( paramProc);
		
		System.gc();
		System.exit(0);
	}
}
