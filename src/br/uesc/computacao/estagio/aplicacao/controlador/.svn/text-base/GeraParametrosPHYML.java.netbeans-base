package br.uesc.computacao.estagio.aplicacao.controlador;

import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.Tradutor;

/**
 * classe que gerencia os parametros escolhidos na tela phyml
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */


public class GeraParametrosPHYML {

	/*
	 * Variaveis Globais
	 */
	private static String ARQUIVO = "Informe o arquivo da seqüência";

	private static String SEQUENCIA = "Seqüencia";

	private static String TIPO_DADO = "Informe o tipo de dado";

	private static String ARQUIVO_SEQUENCIA_TIPO = "Informe o tipo de arquivo da seqüência\n Seqüencial/Intercalado";

	private static String ARQUIVO_SEQUENCIA = "Arquivo da seqüência";

	private static String BOOTSTRAP = "Informe o numero de Bootstrap";

	private static String LOCAIS_INVARIAVEIS = "Informe as proporções de locais invariáveis";

	private static String PROPORCOES = "Proporções";

	private static String INFORME_MODELO_DNA = "Informe o Modelo - DNA a ser utilizado!";

	private static String INFORME_MODELO_AA = "Informe o Modelo - AA a ser utilizado!";

	private static String MODELO_AA = "Modelo AA";

	private static String MODELO_DNA = "Modelo DNA";

	private static String PARAMETRO_GAMA = "Informe o parâmetro gama da distribuição!";

	private static String PARAMETRO = "Parâmetro";

	private static String ARQUIVO_ARVORE = "Informe o arquivo da árvore";

	private static String ARVORE = "Árvore";

	private static String ARVORE_BIONJ = "Escolha o Arquivo da árvore ou o BIONJ";

	private static String ARQUIVO_BIONJ = "Arquivo/BIONJ";

	private static String ESCOLHA_TOPOLOGIA = "Escolha a Topologia";

	private static String TOPOLOGIA = "Topologia";

	private static String TAXA_ARVORE = "Escolha a Taxa da árvore";

	private static String TAXA = "Taxa";

	/**
	 * Este metodo trata os dados da aba - Sequencia para poder gerar o arquivo
	 * que sera passado ao PHYML Caso alguma opcao esteja errada ou sem
	 * preenchimento o tipo de retorno e um byte = 0, assim indica que teve erro
	 * e o metodo e Abortado Caso o retorno seja um byte = 1, indica que o
	 * metodo foi executado com sucesso, todos os dados estavam corretos
	 *
	 * @return byte
	 */
	// Tratando dados para gerar arquivo
	public static boolean trataAbaSequecia() {
		traduzir();

		if(!ControladorModoManualBootstrap.bootstrap){
			if (ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().getText().length() == 0) {
				JOptionPane.showMessageDialog(null, ARQUIVO, SEQUENCIA, JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else {
				ControladorPHYML.guardaNomeSequencia = ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().getText();
			}
			if (!(ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().isSelected()) && !(ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().isSelected())) {
				JOptionPane.showMessageDialog(null, TIPO_DADO, "DNA/AA", JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else {
				if (ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().isSelected())
					ControladorPHYML.guardaArquivo += " " + "0";
				if (ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().isSelected())
					ControladorPHYML.guardaArquivo += " " + "1";//DNA / AA
			}
			if (!(ControladorIGrafu.phyml.getJRadioButtonSequencial().isSelected()) && !(ControladorIGrafu.phyml.getJRadioButtonIntercalado().isSelected())) {
				JOptionPane.showMessageDialog(null, ARQUIVO_SEQUENCIA_TIPO, ARQUIVO_SEQUENCIA, JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else {
				if (ControladorIGrafu.phyml.getJRadioButtonIntercalado().isSelected())
					ControladorPHYML.guardaArquivo += " " + "i";
				if (ControladorIGrafu.phyml.getJRadioButtonSequencial().isSelected())
					ControladorPHYML.guardaArquivo += " " + "s";// Intercalado Sequencial
			}

			String bootstrapParameters = ControladorIGrafu.phyml.
			getBootstrapParameters();
			if(bootstrapParameters==" ")
				JOptionPane.showMessageDialog(null, BOOTSTRAP, "Bootstrap!", JOptionPane.INFORMATION_MESSAGE);
			else ControladorPHYML.guardaArquivo += bootstrapParameters;
			
		}

		return true;
	}

	/**
	 * Este metodo trata os dados da aba Modelo - DNA para poder gerar o arquivo
	 * que sera passado ao PHYML Caso alguma opcao esteja errada ou sem
	 * preenchimento o tipo de retorno e um boolean = 0, assim indica que teve erro
	 * e o metodo e Abortado Caso o retorno seja um boolean = 1, indica que o
	 * metodo foi executado com sucesso, todos os dados estavam corretos
	 *
	 * @return boolean
	 */
	public static boolean trataAbaModeloDNA() {
		// Caso retorne 0 nesta condicao é por que a aba Modelo - DNA não está
		// selecionado
		if (!(ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().isSelected())) {
			return false;
		}
		// Caso esteja selecionada
		else {
			// Nesta condição o radioButtonSequenciaDNA ja era pra esta
			// selecionado, porem por garantia é feita a verificacao
			if (ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().isSelected()) {
				// Verifica se algum modelo esta selecionado
				if ((ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloGTR().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF81().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJC69().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloK2P().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloHKY().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloTN93().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF84().isSelected())) {
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloGTR().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "GTR";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoGTR().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoGTR().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}

						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getText();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF81().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "F81";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF81().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF81().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().getText();
								}
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getText();
							ControladorPHYML.guardaArquivo += " " + "e";
						}

					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJC69().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "JC69";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoJC69().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().getText();
							} else {
								JOptionPane.showMessageDialog(null, LOCAIS_INVARIAVEIS, PROPORCOES, JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJC69().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getText();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloK2P().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "K2P";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoK2P().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoK2P().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getText();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloHKY().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "HKY";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoHKY().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoHKY().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getText();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloTN93().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "TN93";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoTN93().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoTN93().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getText();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF84().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "F84";
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF84().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF84().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getText();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getText();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
				}
				// Caso nenhum modelo esteja selecionado
				else {
					JOptionPane.showMessageDialog(null, INFORME_MODELO_DNA, MODELO_DNA, JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Este metodo trata os dados da aba Modelo - AA para poder gerar o arquivo
	 * que sera passado ao PHYML Caso alguma opcao esteja errada ou sem
	 * preenchimento o tipo de retorno e um byte = 0, assim indica que teve erro
	 * e o metodo e Abortado Caso o retorno seja um byte = 1, indica que o
	 * metodo foi executado com sucesso, todos os dados estavam corretos
	 *
	 * @return byte
	 */
	public static boolean trataAbaModeloAA() {
		// Caso retorne 0 nesta condicao é por que a aba Modelo - AA não está
		// selecionado
		if (!(ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().isSelected())) {
			return false;
		}
		// Caso esteja selecionada
		else {
			// Nesta condição o radioButtonSequenciaAminoAcido ja era pra esta
			// selecionado, porem por garantia é feita a verificacao
			if (ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().isSelected()) {
				// Verifica se algum modelo esta selecionado
				if ((ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloWAG().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDayhoff().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloMtREV().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDCMut().isSelected())
						|| (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJTT().isSelected())) {
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloWAG().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "WAG";
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoWAG().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getValue();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getValue();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDayhoff().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "Dayhoff";
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDayhoff().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getValue();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getValue();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloMtREV().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "MtREV";
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoMtREV().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getValue();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getValue();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDCMut().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "DCMut";
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDCMut().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getValue();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().getText();
								} else {
									JOptionPane.showMessageDialog(null, PARAMETRO_GAMA, PARAMETRO, JOptionPane.INFORMATION_MESSAGE);
									return false;
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getValue();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
					if (ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJTT().isSelected()) {
						ControladorPHYML.guardaArquivo += " " + "JTT";
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT().isSelected()) {
							if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().getValue() >= 0) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().getText();
							}
						}
						if (ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT().isSelected()) {
							ControladorPHYML.guardaArquivo += " " + "e";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getValue() <= 1) {
							ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getText();
							ControladorPHYML.guardaArquivo += " " + "1";
						}
						if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getValue() >= 2) {
							if (ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().isSelected()) {
								if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().getValue() >= 0) {
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getValue();
									ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().getText();
								}
							}
							if (ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT().isSelected()) {
								ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getValue();
								ControladorPHYML.guardaArquivo += " " + "e";
							}
						}
					}
				}
				// Caso nenhum modelo esteja selecionado
				else {
					JOptionPane.showMessageDialog(null, INFORME_MODELO_AA, MODELO_AA, JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Este metodo trata os dados da aba Arvore para poder gerar o arquivo que
	 * sera passado ao PHYML Caso alguma opcao esteja errada ou sem
	 * preenchimento o tipo de retorno e um byte = 0, assim indica que teve erro
	 * e o metodo e Abortado Caso o retorno seja um byte = 1, indica que o
	 * metodo foi executado com sucesso, todos os dados estavam corretos
	 *
	 * @return byte
	 */
	public static boolean trataAbaModeloArvore() {
		if ((ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ().isSelected())
				|| (ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo().isSelected())) {
			if (ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ().isSelected()) {
				ControladorPHYML.guardaArquivo += " " + "BIONJ";
			}
			if (ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo().isSelected()) {
				if (ControladorIGrafu.phyml.getJTextFieldArquivoArvore().getText() != "") {
					ControladorPHYML.guardaArquivo += " " + ControladorIGrafu.phyml.getJTextFieldArquivoArvore().getText();
				} else {
					JOptionPane.showMessageDialog(null, ARQUIVO_ARVORE, ARVORE, JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, ARVORE_BIONJ, ARQUIVO_BIONJ, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if ((ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreNao().isSelected())
				|| (ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreSim().isSelected())) {
			if (ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreNao().isSelected()) {
				ControladorPHYML.guardaArquivo += " " + "n";
			}
			if (ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreSim().isSelected()) {
				ControladorPHYML.guardaArquivo += " " + "y";
			}
		} else {
			JOptionPane.showMessageDialog(null, ESCOLHA_TOPOLOGIA, TOPOLOGIA, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if ((ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreSim().isSelected()) || (ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreNao().isSelected())) {
			if (ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreSim().isSelected()) {
				ControladorPHYML.guardaArquivo += " " + "y";
			}
			if (ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreNao().isSelected()) {
				ControladorPHYML.guardaArquivo += " " + "n";
			}
		} else {
			JOptionPane.showMessageDialog(null, TAXA_ARVORE, TAXA, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	/*
	 * Metodo de traducao Portugues/Ingles
	 */
	public static void traduzir() {
		ARQUIVO = Tradutor.traduzir("Informe oarquivo da seqüência", "Inform the sequence file");
		SEQUENCIA = Tradutor.traduzir("Seqüencia", "Sequence");
		TIPO_DADO = Tradutor.traduzir("Informe o tipo de dado", "Inform the type of data");
		ARQUIVO_SEQUENCIA_TIPO = Tradutor.traduzir("Informe o tipo de arquivo da seqüência\n Seqüencial/Intercalado",
				"Inform the type of sequence file\n Sequential/Intercalated");
		ARQUIVO_SEQUENCIA = Tradutor.traduzir("Arquivo da seqüência", "Sequence file");
		BOOTSTRAP = Tradutor.traduzir("Informe o numero de Bootstrap", "" + "Inform the Bootstrap value");
		LOCAIS_INVARIAVEIS = Tradutor.traduzir("Informe as proporções de locais invariáveis", "Inform the proportion of invariable sites");
		PROPORCOES = Tradutor.traduzir("Proporção", "Proportion");
		INFORME_MODELO_DNA = Tradutor.traduzir("Informe o Modelo DNA a ser utilizado!", "Inform Model DNA to be used!");
		INFORME_MODELO_AA = Tradutor.traduzir("Informe o Modelo AA a ser utilizado!", "Inform Model AA to be used!");
		MODELO_AA = Tradutor.traduzir("Modelo - AA", "Model - AA");
		MODELO_DNA = Tradutor.traduzir("Modelo - DNA", "Model - DNA");
		PARAMETRO_GAMA = Tradutor.traduzir("Informe o parâmetro gama da distribuição!", "Inform the gamma distribution parameter!");
		PARAMETRO = Tradutor.traduzir("Parâmetro", "Parameter");
		ARQUIVO_ARVORE = Tradutor.traduzir("Informe o arquivo da árvore", "Inform the tree file");
		ARVORE = Tradutor.traduzir("Árvore", "Tree");
		ARVORE_BIONJ = Tradutor.traduzir("Escolha o Arquivo da árvore ou BIONJ", "Choose the tree file or BIONJ");
		ARQUIVO_BIONJ = Tradutor.traduzir("Arquivo/BIONJ", "File/BIONJ");
		ESCOLHA_TOPOLOGIA = Tradutor.traduzir("Escolha a Topologia", "Choose the Topology");
		TOPOLOGIA = Tradutor.traduzir("Topologia", "Topology");
		TAXA_ARVORE = Tradutor.traduzir("Escolha a Taxa da árvore", "Choose the tree tax");
		TAXA = Tradutor.traduzir("Taxa", "Tax");
	}
}
