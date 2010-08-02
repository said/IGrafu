import java.util.Vector;

public class DigrafuSequencial {

        public static void main (String[] args) throws Exception{

        	String diretorio, arquivo ,paramProc;
                int amostra=0, contador=0, aux=0;
                Vector<String> nomeArquivo2, nomeArquivo;

                ArquivoManip   man          = new ArquivoManip();
                Parametros     argumentos   = new Parametros();

                nomeArquivo2 = new Vector<String>();

		argumentos.help(args,2);

                diretorio = argumentos.qualDiretorio(args[1]);
                arquivo   = diretorio+"outSample";
                contador  = argumentos.qualPosicao(args, "Run");

                paramProc=argumentos.paraSeqboot(args, diretorio, contador);
                Processo.criarProcesso(paramProc);

                if(!argumentos.existeArquivo(arquivo)){
                        System.out.println("o arquivo "+arquivo+" nao foi criado. Impossivel continuar.");
               		System.exit(1);
           	 }

            	nomeArquivo = man.newFileOut( man.getFileVector(arquivo),diretorio);
                amostra     = Integer.parseInt( args[3]);// quantidade de seqboot
                aux         = argumentos.qualPosicao(args, "consense");

                // rodando todos os arquivos gerados.
                for (int i = 0; i < amostra; i++) {
                        paramProc= argumentos.paraDiGrafu(args, diretorio,nomeArquivo.get(i),i, contador, aux);
                        nomeArquivo2.add(diretorio+"outDiGrafu_"+i);
                        System.out.println("rodando DiGrafu "+(i+1));
                        Processo.criarProcesso(paramProc);

                }
		// juntar os arquivos e rodar o consense.
                arquivo= man.UnicoArq(diretorio,nomeArquivo2);

                paramProc= argumentos.paraConsense(args, diretorio,arquivo,aux, args.length);
                Processo.criarProcesso(paramProc);
                System.gc();
            	System.exit(0);

	}
}
