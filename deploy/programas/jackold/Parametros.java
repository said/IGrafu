import java.io.File;

public class Parametros extends Ajuda{

	public void help(String vetor[], int l) {
		if (vetor.length < 1 || vetor[0].equalsIgnoreCase("ajuda")) {
			switch (l) {
			case 1:// ajuda para o PhymlSequencial
				helpPhylipSequencial();
				break;
			case 2:// ajuda para o DigrafuSequencial
				helpDigrafuSequencial();
				break;
			case 3:// ajuda para o PhymlParalelo
				helpPhymlParalelo();
				break;
			case 4:// ajuda para o PhymlpDist
				helpPhylipDist();
				break;
			case 5:// ajuda para o DigrafuDis
				helpDigrafuDis();
				break;
			default:
				System.out.println("valor inesperado para chave");
				break;
			}
			System.exit(0);
		} else
			System.out.println(" Verificando Parametros ... ");
	}

	public String listaVetorString(int inicio, int fim, String[] args) {
		String parametros = "";

		for (int i = inicio; i < fim; i++)
			parametros += " " + args[i];

		return parametros;
	}

	public int qualPosicao(String vetor[], String nome) {

		for (int i = 0; i < vetor.length; i++) { // informa a posi�ao do nome
													// no vetor
			if (vetor[i].indexOf(nome) > -1)
				return i;
		}// fim_for
		System.out.println("Nao foi encontrado o executavel:" + nome);
		return -1;
	}

	/**
	 * RETORNA OS PARAMETROS NECESSARIOS PRA RODAR O SEQBOOT
	 * 
	 * @param String[],String,int,int
	 * @return String
	 */
	public String paraSeqboot(String[] args, String diretorio, int ultimo) {
		String parametros;
		parametros = args[0] + " " + args[1] + " " + diretorio + "outSample"
				+ listaVetorString(2, ultimo, args);

		return parametros;
	}

	/**
	 * RETORNA OS PARAMETROS NECESSARIOS PRA RODAR O CONSENSE
	 * 
	 * @param String[],String,String,int,int
	 * @return String
	 */
	public String paraConsense(String[] args, String diretorio, String arquivo,
			int inicio, int ultimo) {
		String parametros = "";

		parametros = args[inicio] + " " + diretorio + arquivo + " " + diretorio
				+ "outConsense ";
		parametros += listaVetorString(inicio + 1, ultimo, args);
		return parametros;
	}

	/**
	 * RETORNA OS PARAMETROS NECESSARIOS PRA RODAR O phyml com varias amostra.
	 * 
	 * @param String[],String,int,int
	 * @return String
	 */
	public String paraPhymlVariasSeq(String[] args, String diretorio,
			int inicio, int ultimo) {
		String parametros = "";

		parametros = args[inicio] + " " + diretorio + "outSample ";
		if (args[7].equalsIgnoreCase("PRO"))
			parametros += "1 " + args[6] + " " + args[3] + " 0";
		else
			parametros += "0 " + args[6] + " " + args[3] + " 0";

		parametros += listaVetorString(inicio + 1, ultimo, args);

		return parametros;
	}

	/**
	 * RETORNA OS PARAMETROS NECESSARIOS PRA RODAR O phyml distribuido.
	 * 
	 * @param String[],String,int,int
	 * @return String
	 */
	public String paraPhymlDist(String[] args, String diretorio, int inicio,
			int ultimo, int i) {
		String parametros = "";

		parametros = args[inicio] + " " + diretorio + "outSample_" + i + " ";
		if (args[7].equalsIgnoreCase("PRO"))
			parametros += "1 1 " + args[3] + " 0";
		else
			parametros += "0 1 " + args[3] + " 0";
		parametros += listaVetorString(inicio + 1, ultimo, args);

		return parametros;
	}

	/**
	 * RETORNA OS PARAMETROS NECESSARIOS PRA RODAR O phyml PARALELO.
	 * 
	 * @param String[],String,int,int
	 * @return String
	 */
	public String paraPhymlParalelo(String[] args, String diretorio,
			int inicio, int ultimo, int pc) {
		String parametros = "/usr/local/mpich-1.2.7p1/bin/mpirun -np " + pc +
				" -nolocal ";

		parametros += " " + args[inicio] + " " + diretorio;
		if (args[7].equalsIgnoreCase("PRO"))// aminoacido
			parametros += " 1 " + args[6] + " " + args[3] + " 0";
		else
			// dna
			parametros += " 0 " + args[6] + " " + args[3] + " 0";

		parametros += listaVetorString(inicio + 1, ultimo, args);

		return parametros;
	}

	/**
	 * RETORNA OS PARAMETROS NECESSARIOS PRA RODAR O DIGRAFU.
	 * 
	 * @param String[],String,int,int
	 * @return String
	 */
	public String paraDiGrafu(String[] args, String diretorio,
			String inputFile, int i, int inicio, int opcao) {
		String parametros;

		parametros = args[inicio] + " INPUT " + inputFile + " OUTPUT "
				+ diretorio + "outDiGrafu_" + i;
		parametros += listaVetorString(inicio + 1, opcao, args);

		return parametros;
	}

	public String qualDiretorio(String completo) {

		int posicao;

		posicao = completo.lastIndexOf('/');// retorna a posiçao da ultima
											// ocorencia.
		return completo.substring(0, posicao + 1);// so o diretorio.

	}

	public boolean existeArquivo(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
}
