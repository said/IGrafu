import java.util.Vector;
import java.util.concurrent.*;
import java.util.*;

public class PhylipDist {
	public static void main(String[] args) {

		String diretorio, arquivo, paramProc;
		int aux = 0, contador = 0, nos = 0, cont = 0, amostra = 0;
		CyclicBarrier barrier;
		Vector<String> nomeArquivo, processos, host;

		ArquivoManip man = new ArquivoManip();
		Parametros argumentos = new Parametros();
		nomeArquivo = new Vector<String>();
		processos = new Vector<String>();
		
		argumentos.help(args, 4);

		//posiçao do executavel phyml. e diretorio onde ficara o arquivo criado
		contador = argumentos.qualPosicao(args, "phyml");
		diretorio = argumentos.qualDiretorio(args[1]);
		arquivo = diretorio + "host";// ler nome de maquinas.
		if( !man.criaInstancia(arquivo).exists()){
			System.out.println("Arquivo "+diretorio+"host nao encontrado, o programa sera cancelado");
			System.exit(1);
		}
		
		host = man.getFileLine(arquivo);
		arquivo = diretorio + "outSample";// nome do arquivo saida.

		if (argumentos.existeArquivo(args[1])) {
			paramProc = argumentos.paraSeqboot(args, diretorio, (contador - 1));
			Processo.criarProcesso(paramProc);
			if (argumentos.existeArquivo(arquivo)) {
				try {
					nomeArquivo = man.newFileOut(man.getFileVector(arquivo),
							diretorio);
					amostra = Integer.parseInt(args[3]);// quantidade de amostra
					nos = Integer.parseInt(args[contador - 1]);// quantidade de
																// no
					cont = amostra / nos;// qtidade q fica para cada
											// processador.
				} catch (Exception e) {
					System.out
							.println("Nao foi possivel transformar os parametros em inteiro");
				}

				aux = argumentos.qualPosicao(args, "consense");

				barrier = new CyclicBarrier(nos + 1);

				// criar referencia para os arquivos q serao criados.
				for (int i = 0; i < amostra; i++) {
					paramProc = argumentos.paraPhymlDist(args, diretorio,
							contador, aux, i);
					processos.add(i, paramProc);
				}

				// cria thread
				if(nos<=host.size()){
				for (int i = 0; i < nos - 1; i++) {
					new Thread(new ProcessoThread(processos, barrier, host
							.get(i), i * cont, (i + 1) * cont)).start();
					System.out.println("iniciou thread: " + i);
				}
				new Thread(new ProcessoThread(processos, barrier, host
						.get(nos - 1), (nos - 1) * cont, processos.size()))
						.start();
				System.out.println("iniciou thread:"+ (nos-1));
				}// fim do if
				
				try {// espera terminar
					barrier.await();
				} catch (InterruptedException ex) {
					System.out.println(ex);
				} catch (BrokenBarrierException ex) {
					System.out.println(ex);
				}

				nomeArquivo.clear();
				try {
					for (int i = 0; i < amostra; i++)
						nomeArquivo.add(i, new String(arquivo + "_" + i
								+ "_phyml_tree.txt"));
					arquivo = man.UnicoArq(diretorio, nomeArquivo);
				} catch (Exception e) {
					System.out
							.println("nao foi possivel juntar os arquivos gerados pelo phyml");
				}

				if (argumentos.existeArquivo(diretorio+arquivo)) {
					paramProc = argumentos.paraConsense(args, diretorio,
							arquivo, aux, args.length);
					Processo.criarProcesso(paramProc);
				} else {
					System.out.println("o arquivo " + arquivo
							+ " nao foi criado. Impossivel rodar o Consense.");
					System.exit(1);
				}
			} else {
				System.out.println("nao foi possivel encontrar o arquivos "
						+ arquivo + ". Programa sendo cancelado");
			}
		} else {
			System.out
					.println("o arquivo passado como parametro nao foi encontrado. Impossivel rodar o Seqboot");
			System.exit(1);
		}

		System.exit(0);

	}

}
