public class PhymlSequencial {

	public static void main(String[] args) {

		String diretorio;
		String paramProc;
		int contador = 0, aux = 0;

		Parametros argumentos = new Parametros();

		argumentos.help(args, 1);
		
		contador = argumentos.qualPosicao(args, "phyml");

		diretorio = argumentos.qualDiretorio(args[1]);
		
		if (argumentos.existeArquivo(args[1])) {
			paramProc = argumentos.paraSeqboot(args, diretorio, contador);
			Processo.criarProcesso(paramProc);
		} else {
			System.out.println("o arquivo passado como parametro nao foi encontrado. Impossivel rodar o Seqboot");
			System.exit(1);
		}
		
		aux = argumentos.qualPosicao(args, "consense");

		if (argumentos.existeArquivo(diretorio + "outSample")) {
			paramProc = argumentos.paraPhymlVariasSeq(args, diretorio,
					contador, aux);
			Processo.criarProcesso(paramProc);
		} else {
			System.out.println("o arquivo " + diretorio
					+ "outSample nao foi criado.Impossivel rodar o Phyml");
			System.exit(1);
		}
		if (argumentos.existeArquivo(diretorio + "outSample_phyml_tree.txt")) {
			paramProc = argumentos.paraConsense(args, diretorio,
					"outSample_phyml_tree.txt", aux, args.length);
           	Processo.criarProcesso(paramProc);
		} else {
			System.out.println("o arquivo " + diretorio
					+ "outSample_phyml_tree.txt  "
					+ "nao foi criado. Impossivel rodar o Consense.");
			System.exit(1);
		}

		System.exit(0);

	}

}
