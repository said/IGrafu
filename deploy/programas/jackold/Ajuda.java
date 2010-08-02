public class Ajuda {

	public void helpSeqboot() {
		System.out
				.println("[endereco_seqboot] -- deve passar o diretorio onde se encontra o executavel do SeqBoot.");
		System.out
				.println("[entrada_seqboot] -- indicar o diretorio/arquivo para leitura do arquivo entrada do seqboot -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[seed] -- semente, aceitando somente VALOR impar -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[R] -- quantidade de replicas, aceitando VALOR ex: 100 -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[D] -- tipo da sequencia, pode ser:\nSEQUENCIA MOLECULAR:(SEQU); MORFOLOGIA DISCRETA: (MORF) ; RESTRICAO DE SITIOS: (REST); FREQUENCIA DE GENES:(FREQ) -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[J] -- modelo de permutacao, pode ser:\nBOOTSTRAP:(boot); JACKKNIFE:(jack); PERMUTE CHARACTER:(perm); PERMUTE CHARACTER ORDER:(pord);PERMUTE WHITH SPECIES:(pspec);  -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[I] -- formato do arquivo_entrada,sendo INTERLEAVED(i) ou SEQUENCIAL(s) -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[16] -- indica tipo da sequencia avaliada,pode ser:\n\t dna(DNA); rna(RNA);proteina(PRO) -- PARAMETRO OBRIGATORIO");
		System.out
				.println("[A,F,C] -- arquivo de informacoes extra sobre as categorias de sitios ou fatores ou alelos, deve passar dois parametro:\n\to primeiro a palavra chave: ALL ou CAT ou FAC, \n\to segundo o diretorio/NOME_ARQUIVO \n\t--  PARAMETRO NAO OBRIGATORIO ");
		System.out
				.println("[E] -- informa as enzimas no arquivo entrada, deve passar no parametro a palavra ENZIMA -- PARAMETRO NAO OBRIGATORIO ");
		System.out
				.println("[B] -- tamanho do bloco que divide a sequencia,deve passar dois parametro:\n\t o primeiro a palavra BLOCO,\n\t o segunto o tamanho (valor)que sera dividido as sequencias\n\t -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[W] -- arquivo que contem os pesos do caracter, deve passar dois parametros:\n\t o primeito a palavra WEIGHT,\n\t o segundo o diretorio/NOME_ARQUIVO\n\t -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[S] -- produce multiple output files, deve passar como parametro o nome:JUSTW( just weight) ou OUTD(out data) -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[X] -- arquivo_mixture, deve passar dois parametro \n\t o primeiro a palavra MIX, \n\t o segundo o  Diretorio/NOME_ARQUIVO\n\t--PARAMETRO NAO OBRIGATORIO ");
		System.out
				.println("[N] -- arquivo_ancestral, deve passar dois parametro \n\t o primeiro a palavra ANC, \n\t o segundo o diretorio/NOME_ARQUIVO\n\t -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[%] -- indicar a porcentagem das amaostras, deve passar dois parametro:\n\t o primeiro a palavra FRACAO,\n\t o segundo o valor da porcentagem das amostras \n\t--PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[P] -- formato saida para rescrever o arquivo,deve passar dois parametros\n\t o primeiro a palavra RESC, \n\t o segundo uma das palavras: PHY(formato phylip),NEX(formato nexus),XML(formato xml)\n\t -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[1] -- escrever os dados de saida, deve passar como parametro a palavra PRINT -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[2] -- indicar execucao,deve passar como parametro a palavra RUN -- PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[.] -- usar o dot-differencing, deve passar como parametro a palavra DIFFER -- PARAMETRO NAO OBRIGATORIO");

	}

	public void helpPhyml() {
		System.out
				.println("[endereco_phyml] -- deve passar o diretorio onde se encontra o executavel Phyml");
		System.out
				.println("[model] -- nome do modelo de substituicao, pode ser: JC69 | K2P | F81 | HKY | F84 | TN93 | GTR (DNA) JTT | MtREV | Dayhoff | WAG (Amino-Acids)");
		System.out
				.println("[kappa] -- transition/transversion ratio, only for DNA sequences,\na fixed value (ex:4.0) | e to get the maximum likelihood estimate");
		System.out
				.println("[invar] --  proportion of invariable sites,\na fixed value (ex:0.0) | e to get the maximum likelihood estimate");
		System.out
				.println("[nb_categ] -- number of relative substitution rate categories (ex:4)");
		System.out
				.println("[alpha] -- gamma distribution parameter,\na fixed value (ex:1.0) | e to get the maximum likelihood estimate");
		System.out
				.println("[tree] -- starting tree filename (Newick format),\nyour tree filename | BIONJ for a distance-based tree");
		System.out
				.println("[opt_topology] -- otimizacao da topologia.Pode ser sim(y) ou nao(n)");
		System.out
				.println("[opt_lengths ]-- otimizacao do tamanho do galho da arvore. Pode ser sim(y) ou nao(n)");

	}

	public void helpConsense() {

		System.out
				.println("[endereco_consense]-- deve passar o diretorio onde se encontra o executavel");
		System.out
				.println("[R] -- Se trata a arvore com ou sem raiz: SIM(S) ou NAO(N).\n--PARAMETRO OBRIGATORIO");
		System.out
				.println("[C] -- tipo de avaliacao, pode ser: EXTENDED MAJORITY RULE(MRE); STRICT(STR); MAJORITY RULE(MR); ML(ML).\n--PARAMETRO OBRIGATORIO");
		System.out
				.println("[O] -- opcao para definir raiz(maior ancestral), deve-se passar dois parametro:\n\t o primeiro a palavra ROOT,\n\t o segundo indicar a posicao da especie no arquivo considerando a ordem.EX: 3 (a terceira especie).\n--PARAMETRO NAO OBRIGATORIO");
		System.out
				.println("[1] --  indicar as especies no arquivo saida,deve-se escrever a palavra PRINT. \n--PARAMETRO NAO OBRIGATORIO\n");
		System.out
				.println("[2] -- indicar execucao,deve-se escrever a palavra RUN.\n--PARAMETRO NAO OBRIGATORIO\n");
		System.out
				.println("[3] -- desenhar arvore resultado no arquivo saida, deve-se escrever a palavra TREE.\n--PARAMETRO NAO OBRIGATORIO\n");
		System.out
				.println("[4] -- escrever a arvore em outro arquivo,deve-se escrever dois parametros:\n\to primeira a palavra FILE,\n\to segundo o diretorio/Nome_arquivo onde sera salvo o arquivo.\n\t--PARAMETRO NAO OBRIGATORIO\n");
		System.out
				.println("[5] -- Fraction (l) of times a branch must appear, somente considerado se opçao C = ML.Deve-se passar dois parametro:\n\t o primeiro a palavra FRACTION,\n\t o segundo o valor entre 0.5 - 1.0 EX.0.5\n\t--PARAMETRO NAO OBRIGATORIO \n");

	}

	public void helpDigrafu() {
		System.out
				.println("[endereco_DiGrafu] -- deve passar o diretorio/Run.pl onde se encontra o executavel do Digrafu.");
		System.out
				.println("[entradas_opcionais] -- Nao deve-se passar arquivo entrada e saida para o digrafu,os outros argumentos sao opcional");
	}
	
	public void helpPhylipSequencial() {
		System.out
				.print("\n\nDeve-se passar os parametros, alguns sao OBRIGATORIOS:\n\t\tPhymlSequencial [endereco_seqboot] [arquivo_entrada] [seed] [R] [D] [J] [I] [16] [A,F,C] [E] [B]");
		System.out.print(" [W]  [S] [X] [N] [%,P] [1] [.] ");
		System.out
				.print("[endereco_phyml] [model] [kappa] [invar] [nb_categ] [alpha] [tree] [opt_topology] [opt_lengths ]");
		System.out
				.println("[endereco_consense] [R] [C] [O] [1] [2] [3] [4] [5]\n");
		helpSeqboot();
		helpPhyml();
		helpConsense();
		System.out
				.print("Modelo:\t java PhymlSequencial DIRETORIO/seqboot DIRETORIO/exem5 3 100 SEQU BOOT S DNA ");
		System.out
				.println("/DIRETORIO/phyml JC69 1.0 e 1 1.0 BIONJ y y /DIRETORIO/consense S MRE PRINT RUN TREE FILE DIRETORIO/arvore ");
	}

	public void helpDigrafuDis() {//faltando
		System.out
				.print("Deve-se passar os parametros, alguns sao OBRIGATORIOS:\n\tDigrafuDist [endereco_seqboot] [arquivo_entrada] [arquivo_saida] [seed] [R] [D] [J] ");
		System.out
				.println("[I] [16] [A,F,C] [E] [B] [W]  [S] [X] [N] [%,P] [1] [.] [Num_Proc]"); // falta
		helpSeqboot();
		System.out
				.println("[Num_Proc]-- indicar o numero de processadores usados");
		helpDigrafu();
		helpConsense();
	}

	public void helpDigrafuSequencial() {
		System.out
				.print("Deve-se passar os parametros, alguns sao OBRIGATORIOS:\n\tDigrafuSequencial [endereco_seqboot] [arquivo_entrada] [arquivo_saida] [seed] [R] [D] [J] ");
		System.out
				.print("[I] [16] [A,F,C] [E] [B] [W]  [S] [X] [N] [%,P] [1] [.] ");
		System.out.print("[endereco_DiGrafu] [entradas_opcionais] ");
		System.out
				.println("[endereco_consense] [R] [C] [O] [1] [2] [3] [4] [5]\n");
		helpSeqboot();
		helpDigrafu();
		helpConsense();
		System.out
		.print("Modelo:\t java DigrafuSequencial DIRETORIO/seqboot DIRETORIO/exem5 3 100 SEQU BOOT S DNA ");
		System.out
		.println("/DIRETORIO/Run.pl  /DIRETORIO/consense S MRE PRINT RUN TREE ");
	}

	public void helpPhymlParalelo() {
		System.out
				.print("Deve-se passar os parametros, alguns sao OBRIGATORIOS:\n\tPhymlParalelo [endereco_seqboot] [arquivo_entrada] [arquivo_saida] [seed] [R] [D] [J] ");
		System.out
				.print("[I] [16] [A,F,C] [E] [B] [W]  [S] [X] [N] [%,P] [1] [.] [Num_Proc]");
		System.out
				.print("[endereco_phymlParalelo] [model][kappa] [invar] [nb_categ] [alpha] [tree] [opt_topology] [opt_lengths ]");
		System.out
				.println("[endereco_consense] [R] [C] [O] [1] [2] [3] [4] [5] \n");
		helpSeqboot();
		System.out
				.println("[Num_Proc]-- indicar o numero de processadores usados,deve ser passado antes do parametro [endereco_phymlParalelo] ");
		helpPhyml();
		helpConsense();
		System.out
		.print("Modelo:\t java PhymlParalelo DIRETORIO/seqboot DIRETORIO/exem5 3 100 SEQU BOOT S DNA 2 ");
System.out
		.println("/DIRETORIO/phyml_Paralelo JC69 1.0 e 1 1.0 BIONJ n y DIRETORIO/consense S MRE PRINT RUN TREE");
	}

	public void helpPhylipDist() {
		System.out
				.print("Deve-se passar os parametros, alguns sao OBRIGATORIOS:\n\tPhylipDist [endereco_seqboot] [arquivo_entrada] [arquivo_saida] [seed] [R] [D] [J] ");
		System.out
				.print("[I] [16] [A,F,C] [E] [B] [W]  [S] [X] [N] [%,P] [1] [.] [Num_Proc]");
		System.out
				.print("\t\t [endreco_phyml] [model][kappa] [invar] [nb_categ] [alpha] [tree] [opt_topology] [opt_lengths ]");
		System.out
				.println("\t\t[endreco_consense] [R] [C] [O] [1] [2] [3] [4] [5] \n\n");
		helpSeqboot();
		System.out
				.println("[Num_Proc]-- indicar o numero de processadores usados, deve ser passado antes do parametro [endreco_phyml] ");
		helpPhyml();
		helpConsense();
		System.out
		.print("Modelo:\t java PhylipDist DIRETORIO/seqboot DIRETORIO/exem5 3 100 SEQU BOOT S DNA 2 ");
		System.out
		.println("/DIRETORIO/phyml JC69 1.0 e 1 1.0 BIONJ y y /DIRETORIO/consense S MRE PRINT RUN TREE FILE DIRETORIO/arvore ");
	}

}
