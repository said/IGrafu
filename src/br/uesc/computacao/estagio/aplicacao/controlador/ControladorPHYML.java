/**
 *
 */
package br.uesc.computacao.estagio.aplicacao.controlador;

/**
 * Classe controladora da tela phyml
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.ManipulaArquivo;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import br.uesc.computacao.estagio.aplicacao.util.Processo;
import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.PHYML;

/**
 * @author Zilton Cordeiro Junior
 *
 */

public class ControladorPHYML implements ActionListener {

	/*
	 * variaveis Globais
	 */

	public static GeraParametrosPHYML geraParametrosPHYML = null;

	public static Navegar navegar = null;

	public static ManipulaArquivo arquivo = null;

	public static ControladorPHYML controladorPHYML = null;
        
        public static String caminhoSaidaPHYML = "";

	private ButtonGroup grupoBotoesSequenciaTipoDados = null;

	private ButtonGroup grupoBotoesSequenciaTipoArquivo = null;

	private ButtonGroup grupoBotoesArvoreInicializar = null;

	private ButtonGroup grupoBotoesArvoreTopologia = null;

	private ButtonGroup grupoBotoesArvoreTaxa = null;

	private ButtonGroup grupoBotoesModeloF81Relacao = null;

	private ButtonGroup grupoBotoesModeloGTRRelacao = null;

	private ButtonGroup grupoBotoesModeloJC69Relacao = null;

	private ButtonGroup grupoBotoesModeloGTRProporcao = null;

	private ButtonGroup grupoBotoesModeloGTRParametro = null;

	private ButtonGroup grupoBotoesModeloF81Proporcao = null;

	private ButtonGroup grupoBotoesModeloF81Parametro = null;

	private ButtonGroup grupoBotoesModeloK2PRelacao = null;

	private ButtonGroup grupoBotoesModeloK2PParametro = null;

	private ButtonGroup grupoBotoesModeloK2PProporcao = null;

	private ButtonGroup grupoBotoesModeloJC69Proporcao = null;

	private ButtonGroup grupoBotoesModeloJC69Parametro = null;

	private ButtonGroup grupoBotoesModeloHKYRelacao = null;

	private ButtonGroup grupoBotoesModeloHKYProporcao = null;

	private ButtonGroup grupoBotoesModeloHKYParametro = null;

	private ButtonGroup grupoBotoesModeloTN93Relacao = null;

	private ButtonGroup grupoBotoesModeloTN93Proporcao = null;

	private ButtonGroup grupoBotoesModeloTN93Parametro = null;

	private ButtonGroup grupoBotoesModeloF84Relacao = null;

	private ButtonGroup grupoBotoesModeloF84Proporcao = null;

	private ButtonGroup grupoBotoesModeloF84Parametro = null;

	private ButtonGroup grupoBotoesModelosSubstituicaoDNA = null;

	private ButtonGroup grupoBotoesModelosSubstituicaoAA = null;

	private ButtonGroup grupoBotoesProporcaoWAG = null;

	private ButtonGroup grupoBotoesParametroWAG = null;

	private ButtonGroup grupoBotoesProporcaoJTT = null;

	private ButtonGroup grupoBotoesParametroJTT = null;

	private ButtonGroup grupoBotoesProporcaoDayhoff = null;

	private ButtonGroup grupoBotoesParametroDayhoff = null;

	private ButtonGroup grupoBotoesProporcaoMtREV = null;

	private ButtonGroup grupoBotoesParametroMtREV = null;

	private ButtonGroup grupoBotoesProporcaoDCMut = null;

	private ButtonGroup grupoBotoesParametroDCMut = null;

	private ButtonGroup grupoBotoesBootstrapModoExecucao = null;

	private ButtonGroup grupoBotoesConfiguracoes = null;

	private boolean escolheuAA = false;

	public float field = 0;

	static String ERRO = "Erro";

	public static String ERRO1 = "Erro - Não foi possível abrir a tela anterior!";

	public static String FECHAR = "Deseja sair do sistema?";

	public static String SAIR = "Sair";

	public static String CANCELAR = "Cancelar";

	public static String guardaArquivo = "";

	public static String guardaNomeSequencia = "";

	public static boolean perfil = false;

	public static String nomePerfil = "";

	/*
	 * Construtor
	 */
	public ControladorPHYML() {
		ControladorIGrafu.phyml = new PHYML();
		init();

		
                ControladorIGrafu.phyml.setVisible(true);
                ControladorIGrafu.phyml.repaint();
                ControladorIGrafu.phyml.getJRadioButtonIntercalado().setEnabled(false);
                ControladorIGrafu.phyml.getJRadioButtonSequencial().setEnabled(false);
                

	}

	/*
	 * Metodo de inicializacao de campos e variaveis
	 */
	private void init() {
		ControladorIGrafu.phyml.setResizable(false);
		inicializaGruposBotoes();
		inicializaBotoesHKY();
		inicializaBotoesK2P();
		inicializaBotoesF84();
		inicializaBotoesTN93();
		inicializaBotoesJC69();
		inicializaBotoesF81();
		inicializaBotoesGTR();
		inicializaGerencia();
		//inicializaBootstrap();

		inicializaBotoesDayhoff();
		inicializaBotoesJTT();
		inicializaBotoesMtREV();
		inicializaBotoesWAG();
		inicializaBotoesDCMut();
		
		//Aba de bootstrap
		setBootstrapTabManagement();

		addListenerModelosAA();
		addListenerModelosDNA();

		bootstrap();
		ControladorIGrafu.phyml.getJProgressBar().setVisible(false);

		if (ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao().isSelected()) {
			if (ControladorIGrafu.conversor != null) {
				if (ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText() != "") {
					ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().setText(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());
				}
			}
		} else if (ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim().isSelected()) {
			if (ControladorIGrafu.conversor != null) {
				if (ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText() != "") {
					ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().setText(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());
					ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());
				}
			}
		}

		if (ControladorModoManualBootstrap.bootstrap)
			ControladorIGrafu.phyml.getJButtonArquivoSequencia().setEnabled(false);
		else
			ControladorIGrafu.phyml.getJButtonArquivoSequencia().setEnabled(true);

		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ().setSelected(true);
		ControladorIGrafu.phyml.getJButtonArquivoArvore().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreSim().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreSim().setSelected(true);
	}

	/*
	 * Metodo que verifica se foi utilizada a opcao bootstrap seqboot/consense
	 * Caso sim a opcao bootstrap do phyml fica indisponivel para o usuario
	 * Caso nao a opcao bootstrap do phyml fica disponivel para o usuario
	 */
	public static void bootstrap() {
		if (ControladorModoManualBootstrap.bootstrap == true) {
			ControladorIGrafu.phyml.getJButtonArquivoSequencia().setEnabled(false);
			ControladorIGrafu.phyml.getJRadioButtonSequencial().setEnabled(false);
			ControladorIGrafu.phyml.getJRadioButtonIntercalado().setEnabled(false);

		}

		else {
			ControladorIGrafu.phyml.getJButtonArquivoSequencia().setEnabled(true);
			ControladorIGrafu.phyml.getJRadioButtonSequencial().setEnabled(false);
			ControladorIGrafu.phyml.getJRadioButtonIntercalado().setEnabled(false);


		}
	}
	
	/**
	 * Seta esta classe como gerenciador dos eventos da aba Bootstrap
	 */	
	public void setBootstrapTabManagement() {
		ControladorIGrafu.phyml.
			getJRadioButtonBootstrapInterno().addActionListener
			(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel valor = ControladorIGrafu.phyml.
							getJLabelValorBootstrap();
						valor.setText("Numero de dados que o " +
								"Phyml deve calcular:");
						ControladorIGrafu.phyml.
							jBorderedPanelValorBootstrap.setVisible(true);
						valor.setSize(valor.getPreferredSize());
					}
				}
			);
		ControladorIGrafu.phyml.
		getJRadioButtonBootstrapExterno().addActionListener
		(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JLabel valor = ControladorIGrafu.phyml.
						getJLabelValorBootstrap();
					valor.setText("Numero de dados contidos " +
							"no arquivo:");
					ControladorIGrafu.phyml.
					jBorderedPanelValorBootstrap.setVisible(true);
					valor.setSize(valor.getPreferredSize());					
				}
			}
		);
			
	}

	/*
	 * Metodo utilizado para adicionar eventos a botoes e campos
	 */
	public void inicializaGerencia() {
		ControladorIGrafu.phyml.getJMenuItemCriarPerfil().addActionListener(this);
		ControladorIGrafu.phyml.getJMenuItemDeletarPerfil().addActionListener(this);
		ControladorIGrafu.phyml.getJCheckBoxMenuItemPortugues().addActionListener(this);
		ControladorIGrafu.phyml.getJCheckBoxMenuItemIngles().addActionListener(this);

		ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().setSelected(true);

		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo().addActionListener(this);

		ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().addActionListener(this);

		ControladorIGrafu.phyml.getJButtonEditor().addActionListener(this);

		ControladorIGrafu.phyml.getJButtonExecutar().addActionListener(this);
		ControladorIGrafu.phyml.getJButtonVoltar().addActionListener(this);
                ControladorIGrafu.phyml.getJButtonInicio().addActionListener(this);

		//ControladorIGrafu.phyml.getJButtonArquivoSequencia().addActionListener(this);
		ControladorIGrafu.phyml.getJButtonArquivoArvore().addActionListener(this);

		ControladorIGrafu.phyml.getJButtonVisualizar().addActionListener(this);

		ControladorIGrafu.phyml.getJCheckBoxTipoExecucaoParalelo().addActionListener(this);
		

		ControladorIGrafu.phyml.getJMenuItemFechar().addActionListener(this);

		//ControladorIGrafu.phyml.getJNumberFieldBootstrapCalculadoPHYML().setValue(1);

		ControladorIGrafu.phyml.getJButtonTipoExecucao().addActionListener(this);
		ControladorIGrafu.phyml.getJDialogTipoExecucao().addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				ControladorIGrafu.phyml.setEnabled(true);
				ControladorIGrafu.phyml.setVisible(true);
			}
		});


		ControladorIGrafu.phyml.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ControladorIGrafu.phyml.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				Object[] opcoes = { SAIR, CANCELAR };
				int opcao = JOptionPane.showOptionDialog(null, FECHAR, "IGRAFU 2.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes,
						opcoes[1]);

				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	

	/**
	 * Este metodo cria grupos de botoes, onde somente um pode ficar selecionado
	 * em cada grupo da aba Sequencia Os botoes sao da aba sequencia Os botoes
	 * DNA e Aminoacido estao em um grupo Os botoes Intercalado e Sequencial
	 * estao em outro grupo
	 */
	public void buttonGroupSequencia() {
		if (grupoBotoesSequenciaTipoDados == null) {
			grupoBotoesSequenciaTipoDados = new ButtonGroup();
			grupoBotoesSequenciaTipoDados.add(ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA());
			grupoBotoesSequenciaTipoDados.add(ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA());
		}
		if (grupoBotoesSequenciaTipoArquivo == null) {
			grupoBotoesSequenciaTipoArquivo = new ButtonGroup();
			grupoBotoesSequenciaTipoArquivo.add(ControladorIGrafu.phyml.getJRadioButtonSequencial());
			grupoBotoesSequenciaTipoArquivo.add(ControladorIGrafu.phyml.getJRadioButtonIntercalado());
		}
	}

	/**
	 * Este metodo cria grupos de botoes, onde somente um pode ficar selecionado
	 * em no menu configurações
	 */
	public void buttonGroupConfiguracoes() {
		if (grupoBotoesConfiguracoes == null) {
			grupoBotoesConfiguracoes = new ButtonGroup();
			grupoBotoesConfiguracoes.add(ControladorIGrafu.phyml.getJCheckBoxMenuItemPortugues());
			grupoBotoesConfiguracoes.add(ControladorIGrafu.phyml.getJCheckBoxMenuItemIngles());
		}
	}

	/**
	 * Este metodo cria grupos de botoes, onde somente um pode ficar selecionado
	 * em cada grupo da aba Arvore Os botoes Arquivo e BIONJ estao em um grupo
	 * Os botoes Sim e Nao da topologia estão em outro grupo Os botoes Sim e Nao
	 * da taxa estao em outro grupo
	 */
	public void buttonGroupArvore() {
		if (grupoBotoesArvoreInicializar == null) {
			grupoBotoesArvoreInicializar = new ButtonGroup();
			grupoBotoesArvoreInicializar.add(ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo());
			grupoBotoesArvoreInicializar.add(ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ());
		}
		if (grupoBotoesArvoreTopologia == null) {
			grupoBotoesArvoreTopologia = new ButtonGroup();
			grupoBotoesArvoreTopologia.add(ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreSim());
			grupoBotoesArvoreTopologia.add(ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreNao());
		}
		if (grupoBotoesArvoreTaxa == null) {
			grupoBotoesArvoreTaxa = new ButtonGroup();
			grupoBotoesArvoreTaxa.add(ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreNao());
			grupoBotoesArvoreTaxa.add(ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreSim());
		}
	}

	/**
	 * Este metodo cria grupos de botoes, onde somente um pode ficar selecionado
	 * em cada grupo os if's geram um grupo de botoes, para verificar em qual
	 * grupo o botao estao inserido basta procurar nos if's abaixo
	 */
	public void buttonGroupModeloSubstituicao() {
		// GTR
		if (grupoBotoesModeloGTRRelacao == null) {
			grupoBotoesModeloGTRRelacao = new ButtonGroup();
			grupoBotoesModeloGTRRelacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR());
			grupoBotoesModeloGTRRelacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoGTR());
		}
		if (grupoBotoesModeloGTRProporcao == null) {
			grupoBotoesModeloGTRProporcao = new ButtonGroup();
			grupoBotoesModeloGTRProporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR());
			grupoBotoesModeloGTRProporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoGTR());
		}
		if (grupoBotoesModeloGTRParametro == null) {
			grupoBotoesModeloGTRParametro = new ButtonGroup();
			grupoBotoesModeloGTRParametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR());
			grupoBotoesModeloGTRParametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR());
		}
		// F81
		if (grupoBotoesModeloF81Relacao == null) {
			grupoBotoesModeloF81Relacao = new ButtonGroup();
			grupoBotoesModeloF81Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81());
			grupoBotoesModeloF81Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF81());
		}
		if (grupoBotoesModeloF81Proporcao == null) {
			grupoBotoesModeloF81Proporcao = new ButtonGroup();
			grupoBotoesModeloF81Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF81());
			grupoBotoesModeloF81Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81());
		}
		if (grupoBotoesModeloF81Parametro == null) {
			grupoBotoesModeloF81Parametro = new ButtonGroup();
			grupoBotoesModeloF81Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81());
			grupoBotoesModeloF81Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81());
		}
		// K2P
		if (grupoBotoesModeloK2PRelacao == null) {
			grupoBotoesModeloK2PRelacao = new ButtonGroup();
			grupoBotoesModeloK2PRelacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P());
			grupoBotoesModeloK2PRelacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoK2P());
		}
		if (grupoBotoesModeloK2PParametro == null) {
			grupoBotoesModeloK2PParametro = new ButtonGroup();
			grupoBotoesModeloK2PParametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P());
			grupoBotoesModeloK2PParametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P());
		}
		if (grupoBotoesModeloK2PProporcao == null) {
			grupoBotoesModeloK2PProporcao = new ButtonGroup();
			grupoBotoesModeloK2PProporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoK2P());
			grupoBotoesModeloK2PProporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P());
		}
		// JC69
		if (grupoBotoesModeloJC69Relacao == null) {
			grupoBotoesModeloJC69Relacao = new ButtonGroup();
			grupoBotoesModeloJC69Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69());
			grupoBotoesModeloJC69Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoJC69());
		}
		if (grupoBotoesModeloJC69Proporcao == null) {
			grupoBotoesModeloJC69Proporcao = new ButtonGroup();
			grupoBotoesModeloJC69Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJC69());
			grupoBotoesModeloJC69Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69());
		}
		if (grupoBotoesModeloJC69Parametro == null) {
			grupoBotoesModeloJC69Parametro = new ButtonGroup();
			grupoBotoesModeloJC69Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69());
			grupoBotoesModeloJC69Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69());
		}
		// HKY
		if (grupoBotoesModeloHKYRelacao == null) {
			grupoBotoesModeloHKYRelacao = new ButtonGroup();
			grupoBotoesModeloHKYRelacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoHKY());
			grupoBotoesModeloHKYRelacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY());
		}
		if (grupoBotoesModeloHKYProporcao == null) {
			grupoBotoesModeloHKYProporcao = new ButtonGroup();
			grupoBotoesModeloHKYProporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoHKY());
			grupoBotoesModeloHKYProporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY());
		}
		if (grupoBotoesModeloHKYParametro == null) {
			grupoBotoesModeloHKYParametro = new ButtonGroup();
			grupoBotoesModeloHKYParametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY());
			grupoBotoesModeloHKYParametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY());
		}
		// TN93
		if (grupoBotoesModeloTN93Relacao == null) {
			grupoBotoesModeloTN93Relacao = new ButtonGroup();
			grupoBotoesModeloTN93Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoTN93());
			grupoBotoesModeloTN93Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93());
		}
		if (grupoBotoesModeloTN93Proporcao == null) {
			grupoBotoesModeloTN93Proporcao = new ButtonGroup();
			grupoBotoesModeloTN93Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93());
			grupoBotoesModeloTN93Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoTN93());
		}
		if (grupoBotoesModeloTN93Parametro == null) {
			grupoBotoesModeloTN93Parametro = new ButtonGroup();
			grupoBotoesModeloTN93Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93());
			grupoBotoesModeloTN93Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93());
		}
		// F84
		if (grupoBotoesModeloF84Relacao == null) {
			grupoBotoesModeloF84Relacao = new ButtonGroup();
			grupoBotoesModeloF84Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF84());
			grupoBotoesModeloF84Relacao.add(ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84());
		}
		if (grupoBotoesModeloF84Proporcao == null) {
			grupoBotoesModeloF84Proporcao = new ButtonGroup();
			grupoBotoesModeloF84Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF84());
			grupoBotoesModeloF84Proporcao.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84());
		}
		if (grupoBotoesModeloF84Parametro == null) {
			grupoBotoesModeloF84Parametro = new ButtonGroup();
			grupoBotoesModeloF84Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84());
			grupoBotoesModeloF84Parametro.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84());
		}
	}

	/**
	 * Este metodo cria um grupo de botoes, onde somente um pode ficar
	 * selecionado na aba DNA Este grupo serve para garantir que o usuario ira
	 * escolher somente um tipo de modelo - DNA
	 */
	public void grupoBotoesModelosSubstituicaoDNA() {
		if (grupoBotoesModelosSubstituicaoDNA == null) {
			grupoBotoesModelosSubstituicaoDNA = new ButtonGroup();
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloGTR());
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF81());
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloK2P());
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJC69());
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloHKY());
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloTN93());
			grupoBotoesModelosSubstituicaoDNA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF84());
		}
	}

	/**
	 * Selecionado na aba Aminoacido este grupo serve para garantir que o
	 * usuario ira escolher somente um tipo de modelo - AA
	 */
	private void grupoBotoesModelosSubstituicaoAA() {
		if (grupoBotoesModelosSubstituicaoAA == null) {
			grupoBotoesModelosSubstituicaoAA = new ButtonGroup();
			grupoBotoesModelosSubstituicaoAA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDayhoff());
			grupoBotoesModelosSubstituicaoAA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJTT());
			grupoBotoesModelosSubstituicaoAA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloMtREV());
			grupoBotoesModelosSubstituicaoAA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloWAG());
			grupoBotoesModelosSubstituicaoAA.add(ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDCMut());
		}
	}

	/**
	 * Abaixo sao os grupos de botoes dos modelos - AA
	 *
	 */
	private void grupoBotoesProporcaoWAG() {
		if (grupoBotoesProporcaoWAG == null) {
			grupoBotoesProporcaoWAG = new ButtonGroup();
			grupoBotoesProporcaoWAG.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoWAG());
			grupoBotoesProporcaoWAG.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG());
		}
	}

	private void grupoBotoesParametroWAG() {
		if (grupoBotoesParametroWAG == null) {
			grupoBotoesParametroWAG = new ButtonGroup();
			grupoBotoesParametroWAG.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG());
			grupoBotoesParametroWAG.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG());
		}
	}

	private void grupoBotoesProporcaoJTT() {
		if (grupoBotoesProporcaoJTT == null) {
			grupoBotoesProporcaoJTT = new ButtonGroup();
			grupoBotoesProporcaoJTT.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJTT());
			grupoBotoesProporcaoJTT.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT());
		}
	}

	private void grupoBotoesParametroJTT() {
		if (grupoBotoesParametroJTT == null) {
			grupoBotoesParametroJTT = new ButtonGroup();
			grupoBotoesParametroJTT.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT());
			grupoBotoesParametroJTT.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT());
		}
	}

	private void grupoBotoesProporcaoDayhoff() {
		if (grupoBotoesProporcaoDayhoff == null) {
			grupoBotoesProporcaoDayhoff = new ButtonGroup();
			grupoBotoesProporcaoDayhoff.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDayhoff());
			grupoBotoesProporcaoDayhoff.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff());
		}
	}

	private void grupoBotoesParametroDayhoff() {
		if (grupoBotoesParametroDayhoff == null) {
			grupoBotoesParametroDayhoff = new ButtonGroup();
			grupoBotoesParametroDayhoff.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff());
			grupoBotoesParametroDayhoff.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff());
		}
	}

	private void grupoBotoesProporcaoMtREV() {
		if (grupoBotoesProporcaoMtREV == null) {
			grupoBotoesProporcaoMtREV = new ButtonGroup();
			grupoBotoesProporcaoMtREV.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoMtREV());
			grupoBotoesProporcaoMtREV.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV());
		}
	}

	private void grupoBotoesParametroMtREV() {
		if (grupoBotoesParametroMtREV == null) {
			grupoBotoesParametroMtREV = new ButtonGroup();
			grupoBotoesParametroMtREV.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV());
			grupoBotoesParametroMtREV.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV());
		}
	}

	private void grupoBotoesProporcaoDCMut() {
		if (grupoBotoesProporcaoDCMut == null) {
			grupoBotoesProporcaoDCMut = new ButtonGroup();
			grupoBotoesProporcaoDCMut.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDCMut());
			grupoBotoesProporcaoDCMut.add(ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut());
		}
	}

	private void grupoBotoesParametroDCMut() {
		if (grupoBotoesParametroDCMut == null) {
			grupoBotoesParametroDCMut = new ButtonGroup();
			grupoBotoesParametroDCMut.add(ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut());
			grupoBotoesParametroDCMut.add(ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut());
		}
	}

	private void grupoBotoesBootstrapModoExecucao() {
		if (grupoBotoesBootstrapModoExecucao == null) {
			grupoBotoesBootstrapModoExecucao = new ButtonGroup();
			grupoBotoesBootstrapModoExecucao.add(ControladorIGrafu.phyml.getJCheckBoxTipoExecucaoParalelo());
			
		}
	}

	/**
	 * Metodo utilizado para chamar os metodos geradores de grupos de botoes
	 */
	private void inicializaGruposBotoes() {
		buttonGroupConfiguracoes();
		buttonGroupSequencia();
		buttonGroupArvore();
		buttonGroupModeloSubstituicao();
		grupoBotoesModelosSubstituicaoDNA();
		grupoBotoesModelosSubstituicaoAA();
		grupoBotoesBootstrapModoExecucao();
		grupoBotoesProporcaoWAG();
		grupoBotoesParametroWAG();
		grupoBotoesProporcaoJTT();
		grupoBotoesParametroJTT();
		grupoBotoesProporcaoDayhoff();
		grupoBotoesParametroDayhoff();
		grupoBotoesProporcaoMtREV();
		grupoBotoesParametroMtREV();
		grupoBotoesProporcaoDCMut();
		grupoBotoesParametroDCMut();
	}

	/*
	 * Metodo utilizado para controlar os valores dos campos
	 * ControladorIGrafu.phyml.getJNumberFieldBootstrapInternoArquivoPHYML()
	 * ControladorIGrafu.phyml.getJNumberFieldBootstrapCalculadoPHYML()
	 *
	 */
	/*private void inicializaBootstrap() {
		// Bootstrap calculado pelo PHYML
		
		ControladorIGrafu.phyml.getJNumberFieldBootstrapCalculadoPHYML().setValue(0);
		ControladorIGrafu.phyml.getJNumberFieldBootstrapCalculadoPHYML().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFieldBootstrapCalculadoPHYML().getValue() >= 0)) {
					ControladorIGrafu.phyml.getJNumberFieldBootstrapInternoArquivoPHYML().setValue(1);
				}
			}
		});

		// Bootstrap interno ao arquivo
		ControladorIGrafu.phyml.getJNumberFieldBootstrapInternoArquivoPHYML().setValue(1);
		ControladorIGrafu.phyml.getJNumberFieldBootstrapInternoArquivoPHYML().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFieldBootstrapInternoArquivoPHYML().getValue() >= 1)) {
					ControladorIGrafu.phyml.getJNumberFieldBootstrapCalculadoPHYML().setValue(1);
				}
			}
		});
		
	}*/

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba HKY (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba HKY (Modelos - DNA)
	 */
	private void inicializaBotoesHKY() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setValue(4);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaHKY().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba K2P (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba K2P (Modelos - DNA)
	 */
	private void inicializaBotoesK2P() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setValue(4);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaK2P().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba F84 (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba F84 (Modelos - DNA)
	 */
	private void inicializaBotoesF84() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF84().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF84().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF84().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setValue(4);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF84().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba TN93 (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba TN93 (Modelos -
	 * DNA)
	 */
	private void inicializaBotoesTN93() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setValue(4);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaTN93().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba JC69 (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba JC69 (Modelos -
	 * DNA)
	 */
	private void inicializaBotoesJC69() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJC69().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba F81 (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba F81 (Modelos - DNA)
	 */
	private void inicializaBotoesF81() {
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF81().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF81().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF81().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaF81().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba GTR (Modelos -
	 * DNA) Metodo utilizado para controlar os campos da aba GTR (Modelos - DNA)
	 */
	private void inicializaBotoesGTR() {
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaGTR().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba Dayhoff
	 * (Modelos - AA) Metodo utilizado para controlar os campos da aba Dayhoff
	 * (Modelos - AA)
	 */
	private void inicializaBotoesDayhoff() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDayhoff().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDayhoff().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDayhoff().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba JTT (Modelos -
	 * AA) Metodo utilizado para controlar os campos da aba JTT (Modelos - AA)
	 */
	private void inicializaBotoesJTT() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJTT().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJTT().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaJTT().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba MtREV (Modelos -
	 * AA) Metodo utilizado para controlar os campos da aba MtREV (Modelos - AA)
	 */
	private void inicializaBotoesMtREV() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloMtREV().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoMtREV().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaMtREV().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba WAG (Modelos -
	 * AA) Metodo utilizado para controlar os campos da aba WAG (Modelos - AA)
	 */
	private void inicializaBotoesWAG() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloWAG().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoWAG().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaWAG().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para iniciar os valores dos campos da aba DCMut (Modelos -
	 * AA) Metodo utilizado para controlar os campos da aba DCMut (Modelos - AA)
	 */
	private void inicializaBotoesDCMut() {
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDCMut().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDCMut().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().addActionListener(this);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().setSelected(true);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut().addActionListener(this);
		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setText("0.0");
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().setValue(1);
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().setEnabled(false);
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setEnabled(false);
		ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if ((ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getValue() <= 1)) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().setEnabled(false);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut().setEnabled(false);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setEnabled(false);
				}
				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getValue() >= 2) {
					ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().setEnabled(true);
					ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut().setEnabled(true);
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setEnabled(true);
				}

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldTaxaDCMut().setText("1");
			}
		});
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel�s para HKY (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelHKY() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("HKY");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("HKY");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("HKY");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("HKY");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("HKY");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("HKY");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("HKY");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para K2P (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelK2P() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("K2P");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("K2P");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("K2P");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("K2P");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("K2P");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("K2P");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("K2P");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para F84 (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelF84() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("F84");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("F84");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("F84");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("F84");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("F84");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("F84");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("F84");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para TN93 (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelTN93() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("TN93");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("TN93");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("TN93");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("TN93");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("TN93");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("TN93");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("TN93");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para JC69 (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelJC69() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("JC69");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("JC69");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("JC69");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("JC69");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("JC69");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("JC69");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("JC69");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para F81 (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelF81() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("F81");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("F81");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("F81");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("F81");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("F81");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("F81");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("F81");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para GTR (Modelos -
	 * DNA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelGTR() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoHKY.setText("GTR");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF84.setText("GTR");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoTN93.setText("GTR");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJC69.setText("GTR");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoK2P.setText("GTR");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoF81.setText("GTR");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoGTR.setText("GTR");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para Dayhoff (Modelos -
	 * AA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelDayhoff() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDayhoff.setText("Dayhoff");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJTT.setText("Dayhoff");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoMtREV.setText("Dayhoff");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoWAG.setText("Dayhoff");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDCMut.setText("Dayhoff");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para JTT (Modelos -
	 * AA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelJTT() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDayhoff.setText("JTT");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJTT.setText("JTT");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoMtREV.setText("JTT");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoWAG.setText("JTT");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDCMut.setText("JTT");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para MtREV (Modelos -
	 * AA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelMtREV() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDayhoff.setText("MtREV");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJTT.setText("MtREV");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoMtREV.setText("MtREV");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoWAG.setText("MtREV");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDCMut.setText("MtREV");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para WAG (Modelos -
	 * AA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelWAG() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDayhoff.setText("WAG");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJTT.setText("WAG");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoMtREV.setText("WAG");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoWAG.setText("WAG");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDCMut.setText("WAG");
	}

	/**
	 * Metodo utilizado para alterar o valor dos JLabel's para DCMut (Modelos -
	 * AA), informando assim que este eh o modelo selecionado.
	 */
	private void trocaModeloUtilizadoJLabelDCMut() {
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDayhoff.setText("DCMut");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoJTT.setText("DCMut");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoMtREV.setText("DCMut");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoWAG.setText("DCMut");
		ControladorIGrafu.phyml.jLabelModeloUtilizadoDCMut.setText("DCMut");
	}

	/*
	 * Metodo utilizado para adiconar a aba AA e remover a aba DNA
	 */
	public void addAARemDNA() {
		// DNA
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().setToolTipText("O tipo de dado selecionado é aminoácido.");
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelF84());
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelHKY());
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelJC69());
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelK2P());
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelF81());
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelGTR());
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().remove(ControladorIGrafu.phyml.getJPanelTN93());
		ControladorIGrafu.phyml.setImagemDNA(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/dnaBackground.jpg")));
		//Aminoacido
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().setToolTipText("");
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().addTab("Dayhoff", null, ControladorIGrafu.phyml.getJPanelDayhoff(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().addTab("JTT", null, ControladorIGrafu.phyml.getJPanelJTT(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().addTab("MtREV", null, ControladorIGrafu.phyml.getJPanelMtREV(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().addTab("WAG", null, ControladorIGrafu.phyml.getJPanelWAG(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().addTab("DCMut", null, ControladorIGrafu.phyml.getJPanelDCMut(), null);
		ControladorIGrafu.phyml.setImagemAA(new ImageIcon());
	}

	/*
	 * Metodo utilizado para adiconar a aba DNA e remover a aba AA
	 */
	public void addDNARemAA() {
		// DNA
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().setToolTipText("");
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("F84", null, ControladorIGrafu.phyml.getJPanelF84(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("TN93", null, ControladorIGrafu.phyml.getJPanelTN93(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("HKY", null, ControladorIGrafu.phyml.getJPanelHKY(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("JC69", null, ControladorIGrafu.phyml.getJPanelJC69(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("K2P", null, ControladorIGrafu.phyml.getJPanelK2P(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("F81", null, ControladorIGrafu.phyml.getJPanelF81(), null);
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().addTab("GTR", null, ControladorIGrafu.phyml.getJPanelGTR(), null);
		ControladorIGrafu.phyml.setImagemDNA(new ImageIcon());

		// Aminoacido
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().setToolTipText("O tipo de dado selecionado é DNA.");
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().remove(ControladorIGrafu.phyml.getJPanelDayhoff());
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().remove(ControladorIGrafu.phyml.getJPanelJTT());
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().remove(ControladorIGrafu.phyml.getJPanelMtREV());
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().remove(ControladorIGrafu.phyml.getJPanelWAG());
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().remove(ControladorIGrafu.phyml.getJPanelDCMut());
		ControladorIGrafu.phyml.setImagemAA(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/dnaBackground.jpg")));
	}

	/*
	 * Metodo utilizado para adicionar um ouvidor nos campos abaixo (da aba DNA) para capturar eventos do teclado
	 * quando o usuario pressiona a tecla do teclado no campo
	 */
	public void addListenerModelosDNA() {
		// F84
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setText("0.0");

			}
		});

		// TN93
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setText("0.0");

			}
		});

		// HKY
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setText("0.0");

			}
		});

		// K2P
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setText("0.0");

			}
		});

		// JC69
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setText("0.0");

			}
		});

		// F81
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setText("0.0");

			}
		});

		// GTR
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setText("4");
		ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setText("4");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setText("4");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setText("0.0");

			}
		});
	}

	/*
	 * Metodo utilizado para adicionar um ouvidor nos campos abaixo (da aba AA) para capturar eventos do teclado
	 * quando o usuario pressiona a tecla do teclado no campo
	 */
	public void addListenerModelosAA() {
		// Dayhoff
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setText("0.0");

			}
		});

		// JTT
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setText("0.0");

			}
		});

		// MtREV
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setText("0.0");

			}
		});

		// WAG
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setText("0.0");

			}
		});

		// DCMut
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setText("1");
		ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setText("1");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setText("1");

			}
		});

		ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (possuiVarios(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().getText(), "."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setText("0.0");

				if (ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().getText().equals("."))
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setText("0.0");

				try {
					field = Float.parseFloat(ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().getText());
				} catch (NumberFormatException nfe) {
				}

				if (field > 1)
					ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setText("0.0");

			}
		});
	}

	/*
	 * Metodo utilizado para tratar botoes "Fixo" e "Estimado" dos modelos da aba DNA
	 */
	public void trataBotoesFixoEstimadoModelosDNA(ActionEvent e) {
		// F84
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF84())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF84())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setText("");

		// TN93
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoTN93())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoTN93())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setText("");

		// HKY
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoHKY())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoHKY())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setText("");

		// K2P
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoK2P())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoK2P())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setText("");

		// JC69
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoJC69())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJC69())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setText("");

		// F81
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF81())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF81())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setText("");

		// GTR
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setText("4");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoGTR())
			ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoGTR())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setText("");
	}

	/*
	 * Metodo utilizado para tratar botoes "Fixo" e "Estimado" dos modelos da aba AA
	 */
	public void trataBotoesFixoEstimadoModelosAA(ActionEvent e) {
		// Dayhoff
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDayhoff())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setText("");

		// JTT
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJTT())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setText("");

		// MtREV
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoMtREV())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setText("");

		// WAG
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoWAG())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setText("");

		// DCMut
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setText("0.0");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDCMut())
			ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setText("");

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setText("1");
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut())
			ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setText("");
	}

	/*
	 * Trata eventos
	 */
	public void actionPerformed(ActionEvent e) {
		// DNA
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloHKY()) {
			trocaModeloUtilizadoJLabelHKY();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloK2P()) {
			trocaModeloUtilizadoJLabelK2P();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF84()) {
			trocaModeloUtilizadoJLabelF84();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloTN93()) {
			trocaModeloUtilizadoJLabelTN93();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJC69()) {
			trocaModeloUtilizadoJLabelJC69();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF81()) {
			trocaModeloUtilizadoJLabelF81();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloGTR()) {
			trocaModeloUtilizadoJLabelGTR();
		}

		// AA
		else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDayhoff()) {
			trocaModeloUtilizadoJLabelDayhoff();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJTT()) {
			trocaModeloUtilizadoJLabelJTT();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloMtREV()) {
			trocaModeloUtilizadoJLabelMtREV();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloWAG()) {
			trocaModeloUtilizadoJLabelWAG();
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDCMut()) {
			trocaModeloUtilizadoJLabelDCMut();
		}

		// DNA
		else if (ControladorIGrafu.phyml.getJPanelHKY().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoHKY()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoHKY()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaHKY().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoHKY().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoHKY().setEnabled(true);
			}
		} else if (ControladorIGrafu.phyml.getJPanelK2P().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoK2P()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoK2P()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaK2P().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoK2P().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoK2P().setEnabled(true);
			}
		} else if (ControladorIGrafu.phyml.getJPanelF84().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF84()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF84()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaF84().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF84().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF84().setEnabled(true);
			}
		} else if (ControladorIGrafu.phyml.getJPanelTN93().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoTN93()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoTN93()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaTN93().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoTN93().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoTN93().setEnabled(true);
			}
		} else if (ControladorIGrafu.phyml.getJPanelJC69().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoJC69()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoJC69().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJC69()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaJC69().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJC69().setEnabled(true);
			}
		} else if (ControladorIGrafu.phyml.getJPanelF81().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF81()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoF81().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF81()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaF81().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoF81().setEnabled(true);
			}
		} else if (ControladorIGrafu.phyml.getJPanelGTR().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoGTR()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldRelacaoGTR().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoGTR()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaGTR().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoGTR().setEnabled(true);
			}
		}

		// AA
		if (ControladorIGrafu.phyml.getJPanelDayhoff().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDayhoff()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaDayhoff().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDayhoff().setEnabled(true);
			}
		}

		else if (ControladorIGrafu.phyml.getJPanelJTT().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJTT()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaJTT().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoJTT().setEnabled(true);
			}
		}

		else if (ControladorIGrafu.phyml.getJPanelMtREV().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoMtREV()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaMtREV().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoMtREV().setEnabled(true);
			}
		}

		else if (ControladorIGrafu.phyml.getJPanelWAG().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoWAG()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaWAG().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoWAG().setEnabled(true);
			}
		}

		else if (ControladorIGrafu.phyml.getJPanelDCMut().isVisible()) {
			if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDCMut()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setEnabled(false);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldGamaDCMut().setEnabled(true);
			} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut()) {
				ControladorIGrafu.phyml.getJNumberFloatFieldProporcaoDCMut().setEnabled(true);
			}
		}
		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA()) {
			if (ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().isSelected()) {
				escolheuAA = true;
				addAARemDNA();
				traduzirAA();
			}
		} else if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA()) {
			if (ControladorIGrafu.phyml.getJRadioButtonTipoDadoDNA().isSelected()) {
				addDNARemAA();
			}
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonEditor()) {
			new ControladorEditor();
			ControladorEditor.traduzir();
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonExecutar()) {
                    /*Convertendo para phylip sequencial*/
                   ControladorPHYML.guardaNomeSequencia = GerarParametrosConversor.ChamaConversorIGrafu();
                   ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText(ControladorPHYML.guardaNomeSequencia);
                   ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().setText(ControladorPHYML.guardaNomeSequencia);

			if (GeraParametrosPHYML.trataAbaSequecia()) {
				if ((GeraParametrosPHYML.trataAbaModeloDNA()) || (GeraParametrosPHYML.trataAbaModeloAA())) {
					if (GeraParametrosPHYML.trataAbaModeloArvore()) {
						ControladorIGrafu.phyml.setEnabled(false);

						Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
						ControladorIGrafu.phyml.getJDialogTipoExecucao().setLocation((dimension.width - ControladorIGrafu.phyml.getX()) / 2,
								(dimension.height - ControladorIGrafu.phyml.getY()) / 2);

						ControladorIGrafu.phyml.getJPanelTipoExecucaoSequencial().setEnabled(true);
						ControladorIGrafu.phyml.getJDialogTipoExecucao().setVisible(false);
						ControladorIGrafu.phyml.getJDialogTipoExecucao().setVisible(true);
						ControladorIGrafu.phyml.getJDialogTipoExecucao().repaint();
					}
				}
			}
                  
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonTipoExecucao()) {

			if (ControladorIGrafu.phyml.getJPanelTipoExecucaoSequencial().isVisible()) {
			} else if (ControladorIGrafu.phyml.getJPanelTipoExecucaoParalelo().isVisible()) {
				ControladorIGrafu.phyml.getJCheckBoxTipoExecucaoParalelo().setSelected(true);
			}
			ControladorIGrafu.phyml.getJDialogTipoExecucao().removeNotify();
			ControladorIGrafu.phyml.getJDialogTipoExecucao().setVisible(false);
			ControladorIGrafu.phyml.setEnabled(true);
			ControladorIGrafu.phyml.setVisible(true);

                         

			ControladorIGrafu.phyml.getJProgressBar().setVisible(true);
			ControladorIGrafu.phyml.getJProgressBar().setStringPainted(true);

			Thread threadProgress = new Thread(new Runnable() {
				public void run() {
					ControladorIGrafu.phyml.getJProgressBar().setString("Executando PHYML");
					ControladorIGrafu.phyml.getJProgressBar().setIndeterminate(true);
				}
			});
			threadProgress.setDaemon(true);
			threadProgress.start();

			Thread threadPhyml = new Thread(new Runnable() {
				public void run() {
					ControlaExecucao.executaPHYML();
					ControladorIGrafu.phyml.getJProgressBar().setVisible(false);
                                }
			});
                        //threadPhyml.setDaemon(true);
			threadPhyml.start();

                        
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonArquivoSequencia()) {
			if (Navegar.navegar == null) {
				Navegar.navegar = new Navegar();
				Navegar.navegar.abreArquivos();
				if (Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
					ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
					ControladorConversor.arquivoSaida = "" + Navegar.file.getName();
				}
			} else {
				Navegar.navegar.abreArquivos();
				if (Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
					ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
					ControladorConversor.arquivoSaida = "" + Navegar.file.getName();
				}
			}
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ()) {
			ControladorIGrafu.phyml.getJButtonArquivoArvore().setEnabled(false);
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo()) {
			ControladorIGrafu.phyml.getJButtonArquivoArvore().setEnabled(true);
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonVisualizar()) {
			if(!ControladorModoManualBootstrap.bootstrap)
				Processo.processarHyperTreePHYML();
			else
				Processo.processarHyperTreePHYMLBootstrap();
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonArquivoArvore()) {
			if (Navegar.navegar == null) {
				Navegar.navegar = new Navegar();
				Navegar.navegar.abreArquivos();
				if (Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION)
					ControladorIGrafu.phyml.getJTextFieldArquivoArvore().setText(Navegar.file.getAbsolutePath());
			} else {
				Navegar.navegar.abreArquivos();
				if (Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION)
					ControladorIGrafu.phyml.getJTextFieldArquivoArvore().setText(Navegar.file.getAbsolutePath());
			}
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJButtonVoltar()) {
			try {
				if (ControladorIGrafu.programas == null) {
					ControladorIGrafu.phyml.removeNotify();
					new ControladorProgramas();
					ControladorProgramas.traduzir();
					ControladorIGrafu.programas.setVisible(true);
                                        ControladorIGrafu.programas.repaint();
                                        ControladorIGrafu.phyml.setVisible(false);
					
				} else {
					ControladorIGrafu.phyml.removeNotify();
					ControladorProgramas.traduzir();
					ControladorIGrafu.programas.setVisible(true);
                                        ControladorIGrafu.programas.repaint();
                                        ControladorIGrafu.phyml.setVisible(false);
				}
			} catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);
			}
		}
                
                if(e.getSource() == ControladorIGrafu.phyml.getJButtonInicio()){
                    
                        ControladorIGrafu.phyml.removeNotify();
                        //ControladorIGrafu.novaInstancia();
                        ControladorIGrafu.conversor.setVisible(true);
                        ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().setSelectedIndex(0);
                        ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText("");
                        ControladorIGrafu.conversor.repaint();
                        ControladorIGrafu.phyml.setVisible(false);
                }

		if (e.getSource() == ControladorIGrafu.phyml.getJCheckBoxMenuItemIngles() || e.getSource() == ControladorIGrafu.phyml.getJCheckBoxMenuItemPortugues()) {
			if (ControladorIGrafu.phyml.getJCheckBoxMenuItemIngles().isSelected()) {
				Tradutor.setLinguage(1);
				traduzir();
				if (escolheuAA)
					traduzirAA();
			} else {
				Tradutor.setLinguage(0);
				traduzir();
				if (escolheuAA)
					traduzirAA();
			}
		}

		if(e.getSource() == ControladorIGrafu.phyml.getJMenuItemCriarPerfil()) {
			nomePerfil = JOptionPane.showInputDialog(Tradutor.traduzir("<html>Informe o nome do perfil.<br>O perfil será criado após a<br>próxima execução do Phyml.</html>","<html>Inform the name of the profile.<br>The profile will be created in the<br>next Phyml execution."));
			if(!(nomePerfil.equals("")))
				perfil = true;
		}

		if (e.getSource() == ControladorIGrafu.phyml.getJMenuItemFechar()) {
			Object[] opcoes = { SAIR, CANCELAR };
			int opcao = JOptionPane.showOptionDialog(null, FECHAR, "IGRAFU 2.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes,
					opcoes[1]);

			if (opcao == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

		trataBotoesFixoEstimadoModelosAA(e);
		trataBotoesFixoEstimadoModelosDNA(e);
	}

	/*
	 * Metodo utilizado para traduzir Portugues/Ingles
	 */
	public static void traduzir() {
		ControladorIGrafu.phyml.getJTabbedPaneGeral().setTitleAt(0, Tradutor.traduzir("Seqüência", "Sequence"));
		ControladorIGrafu.phyml.getJTabbedPaneGeral().setTitleAt(1, Tradutor.traduzir("Modelo - DNA", "Model - DNA"));
		ControladorIGrafu.phyml.getJTabbedPaneGeral().setTitleAt(2, Tradutor.traduzir("Modelo - AA", "Model - AA"));
		ControladorIGrafu.phyml.getJTabbedPaneGeral().setTitleAt(3, Tradutor.traduzir("Árvore", "Tree"));
		ControladorIGrafu.phyml.getJLabelArquivoSequencia().setText(Tradutor.traduzir("Seqüências", "Sequences"));
		ControladorIGrafu.phyml.getJButtonArquivoSequencia().setToolTipText(Tradutor.traduzir("Informe o local onde está o arquivo da seqüência.", "Inform the place where is the sequence file."));
		ControladorIGrafu.phyml.getJRadioButtonTipoDadoAA().setText(Tradutor.traduzir("Aminoácido", "Amino-Acid"));
		ControladorIGrafu.phyml.getJLabelTipoDado().setText(Tradutor.traduzir("Tipo de dado", "Data type"));
		ControladorIGrafu.phyml.getJLabelTipoArquivo().setText(Tradutor.traduzir("Tipo de arquivo", "File type"));
		ControladorIGrafu.phyml.getJRadioButtonIntercalado().setText(Tradutor.traduzir("Intercalado", "Interleaved"));
		ControladorIGrafu.phyml.getJRadioButtonSequencial().setText(Tradutor.traduzir("Seqüencial", "Sequential"));
		ControladorIGrafu.phyml.getJButtonExecutar().setText(Tradutor.traduzir("Executar", "Execute"));
		ControladorIGrafu.phyml.getJButtonVoltar().setText(Tradutor.traduzir("Voltar", "Back"));
		ControladorIGrafu.phyml.getJButtonEditor().setText(Tradutor.traduzir("Editor", "Edition"));
		ControladorIGrafu.phyml.getJButtonVisualizar().setText(Tradutor.traduzir("Visualizar", "Visualize"));
		ControladorIGrafu.phyml.getJLabelArquivoArvore().setText(Tradutor.traduzir("Iniciar árvore", "Starting tree"));
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo().setText(Tradutor.traduzir("Arquivo", "File"));
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreBIONJ().setText(Tradutor.traduzir("BIONJ", "BIONJ"));
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreArquivo().setText(Tradutor.traduzir("Arquivo", "File"));
		ControladorIGrafu.phyml.getJLabelTopologiaArvore().setText(Tradutor.traduzir("Otimizar topologia", "Optimise topology"));
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreSim().setText(Tradutor.traduzir("Sim", "Yes"));
		ControladorIGrafu.phyml.getJRadioButtonTopologiaArvoreNao().setText(Tradutor.traduzir("Não", "No"));
		ControladorIGrafu.phyml.getJLabelTaxaArvore().setText(Tradutor.traduzir("Otimizar comprimentos dos galhos", "Optimise branch lengths"));
		ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreSim().setText(Tradutor.traduzir("Sim", "Yes"));
		ControladorIGrafu.phyml.getJRadioButtonTaxaArvoreNao().setText(Tradutor.traduzir("Não", "No"));
		ControladorIGrafu.phyml.getJTabbedPaneTipoExecucao().setTitleAt(0, Tradutor.traduzir("Seqüencial", "Sequential"));
		ControladorIGrafu.phyml.getJTabbedPaneTipoExecucao().setTitleAt(1, Tradutor.traduzir("Paralelo", "Parallel"));
		ControladorIGrafu.phyml.getJLabelTipoExecucaoSequencial().setText(Tradutor.traduzir("Executar em:", "Execute in:"));
		ControladorIGrafu.phyml.getJLabelTipoExecucaoParalelo().setText(Tradutor.traduzir("Processadores:", "Processors:"));
		ControladorIGrafu.phyml.getJDialogTipoExecucao().setTitle(Tradutor.traduzir("Tipo de Execução", "Type of Execution"));

		ControladorIGrafu.phyml.getJMenuArquivo().setText(Tradutor.traduzir("Arquivo", "File"));
		ControladorIGrafu.phyml.getJMenuConfiguracoes().setText(Tradutor.traduzir("Configurações", "Configurations"));

		ControladorIGrafu.phyml.getJButtonTipoExecucao().setText(Tradutor.traduzir("Executar", "Execute"));

		if (Tradutor.getLinguage() == Tradutor.getENGLISH()) {
			ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().removeItemAt(0);
			ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().insertItemAt("server", 0);
			ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().setSelectedIndex(0);
		} else if (Tradutor.getLinguage() == Tradutor.getPORTUGUESE()) {
			ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().removeItemAt(0);
			ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().insertItemAt("servidor", 0);
			ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().setSelectedIndex(0);
		}
		traduzirDNA();


		ControladorIGrafu.phyml.getJMenuIdiomas().setText(Tradutor.traduzir("Idioma", "Language"));
		ControladorIGrafu.phyml.getJCheckBoxMenuItemIngles().setText(Tradutor.traduzir("Inglês", "English"));
		ControladorIGrafu.phyml.getJCheckBoxMenuItemPortugues().setText(Tradutor.traduzir("Português", "Portuguese"));
		ControladorIGrafu.phyml.getJMenuItemFechar().setText(Tradutor.traduzir("Sair", "Exit"));
		ControladorIGrafu.phyml.getJMenuPerfil().setText(Tradutor.traduzir("Perfil","Profile"));
		ControladorIGrafu.phyml.getJMenuItemDeletarPerfil().setText(Tradutor.traduzir("Deletar Perfil","Delete profile"));
		ControladorIGrafu.phyml.getJMenuItemCriarPerfil().setText(Tradutor.traduzir("Criar Perfil","Create profile"));
		nomePerfil = Tradutor.traduzir("<html>Informe o nome do perfil.<br>O perfil será criado após a<br>próxima execução do Phyml.</html>","<html>Inform the name of the profile.<br>The profile will be created in the<br>next Phyml execution.");

		FECHAR = Tradutor.traduzir("Deseja sair do sistema?", "Do you want to leave the system?");
		SAIR = Tradutor.traduzir("Sair", "Exit");
		CANCELAR = Tradutor.traduzir("Cancelar", "Cancel");
		ERRO = Tradutor.traduzir("Erro", "Error");
		ERRO1 = Tradutor.traduzir("Não foi possível abrir a tela anterior!", "Was not possible open the previous screen!");

		ControladorIGrafu.phyml.repaint();
	}

	/*
	 * Metodo utilizado para traduzir Portugues/Ingles
	 */
	public static void traduzirDNA() {
		ControladorIGrafu.phyml.getJTabbedPaneModelosAA().setToolTipText(
				Tradutor.traduzir("O tipo de dado selecionado é DNA.", "The type of selected data is DNA."));

		ControladorIGrafu.phyml.getJLabelModeloSelecionadoF81().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoF84().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoGTR().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoHKY().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoJC69().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoK2P().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoTN93().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));

		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF81().setText(Tradutor.traduzir("Utilizar o modelo F81", "Use F81 model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloF84().setText(Tradutor.traduzir("Utilizar o modelo F84", "Use F84 model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloGTR().setText(Tradutor.traduzir("Utilizar o modelo GTR", "Use GTR model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloHKY().setText(Tradutor.traduzir("Utilizar o modelo HKY", "Use HKY model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJC69().setText(Tradutor.traduzir("Utilizar o modelo JC69", "Use JC69 model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloK2P().setText(Tradutor.traduzir("Utilizar o modelo K2P", "Use K2P model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloTN93().setText(Tradutor.traduzir("Utilizar o modelo TN93", "Use TN93 model"));

		ControladorIGrafu.phyml.getJLabelRelacaoF81().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.phyml.getJLabelRelacaoGTR().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.phyml.getJLabelRelacaoJC69().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.phyml.getJLabelRelacaoTN93().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.phyml.getJLabelRelacaoF84().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.phyml.getJLabelRelacaoHKY().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.phyml.getJLabelRelacaoK2P().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));

		ControladorIGrafu.phyml.getJLabelProporcaoF81().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoF84().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoGTR().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoHKY().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoJC69().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoK2P().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoTN93().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));

		ControladorIGrafu.phyml.getJLabelTaxaF81().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaF84().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaGTR().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaHKY().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaJC69().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaK2P().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaTN93().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));

		ControladorIGrafu.phyml.getJLabelGamaF81().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaF84().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaGTR().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaHKY().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaJC69().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaK2P().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaTN93().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));

		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF81().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoGTR().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoJC69().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoF84().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoHKY().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoK2P().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoFixoTN93().setText(Tradutor.traduzir("Fixo", "Fixed"));

		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF81().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoGTR().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoJC69().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoF84().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoHKY().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoK2P().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonRelacaoEstimadoTN93().setText(Tradutor.traduzir("Estimado", "Estimated"));

		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF81().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoF84().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoGTR().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoHKY().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJC69().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoK2P().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoTN93().setText(Tradutor.traduzir("Fixo", "Fixed"));

		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF81().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoF84().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoGTR().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoHKY().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJC69().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoK2P().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoTN93().setText(Tradutor.traduzir("Estimado", "Estimated"));

		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF81().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoF84().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoGTR().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoHKY().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJC69().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoK2P().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoTN93().setText(Tradutor.traduzir("Fixo", "Fixed"));

		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF81().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoF84().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoGTR().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoHKY().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJC69().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoK2P().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoTN93().setText(Tradutor.traduzir("Estimado", "Estimated"));

	}

	/*
	 * Metodo utilizado para traduzir Portugues/Ingles
	 */
	public static void traduzirAA() {
		ControladorIGrafu.phyml.getJTabbedPaneModelosDNA().setToolTipText(
				Tradutor.traduzir("O tipo de dado selecionado é aminoácido.", "The type of selected data is amino-acid."));

		ControladorIGrafu.phyml.getJLabelModeloSelecionadoDayhoff().setText(Tradutor.traduzir("Modelo selecionado: ", "Selected model"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoDCMut().setText(Tradutor.traduzir("Modelo selecionado: ", "Selected model"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoJTT().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoMtREV().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.phyml.getJLabelModeloSelecionadoWAG().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));

		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDayhoff().setText(Tradutor.traduzir("Utilizar o modelo Dayhoff", "Use Dayhoff model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloDCMut().setText(Tradutor.traduzir("Utilizar o modelo DCMut", "Use DCMut model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloJTT().setText(Tradutor.traduzir("Utilizar o modelo JTT", "Use JTT model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloMtREV().setText(Tradutor.traduzir("Utilizar o modelo MtREV", "Use MtREV model"));
		ControladorIGrafu.phyml.getJRadioButtonUtilizarModeloWAG().setText(Tradutor.traduzir("Utilizar o modelo WAG", "Use WAG model"));

		ControladorIGrafu.phyml.getJLabelProporcaoDayhoff().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoDCMut().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoJTT().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoMtREV().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));
		ControladorIGrafu.phyml.getJLabelProporcaoWAG().setText(Tradutor.traduzir("Proporção de locais invariáveis", "Proportion of invariable sites"));

		ControladorIGrafu.phyml.getJLabelTaxaDayhoff().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaDCMut().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaJTT().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaMtREV().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));
		ControladorIGrafu.phyml.getJLabelTaxaWAG().setText(Tradutor.traduzir("Número de categorias da taxa de substituição", "Number of substitution rate categories"));

		ControladorIGrafu.phyml.getJLabelGamaDayhoff().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaDCMut().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaJTT().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaMtREV().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));
		ControladorIGrafu.phyml.getJLabelGamaWAG().setText(Tradutor.traduzir("Parâmetro gama da distribuição", "Gamma distribution parameter"));

		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDayhoff().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoDCMut().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoJTT().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoMtREV().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoFixoWAG().setText(Tradutor.traduzir("Fixo", "Fixed"));

		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDayhoff().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoDCMut().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoJTT().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoMtREV().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonProporcaoEstimadoWAG().setText(Tradutor.traduzir("Estimado", "Estimated"));

		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDayhoff().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoDCMut().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoJTT().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoWAG().setText(Tradutor.traduzir("Fixo", "Fixed"));
		ControladorIGrafu.phyml.getJRadioButtonGamaFixoMtREV().setText(Tradutor.traduzir("Fixo", "Fixed"));

		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDayhoff().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoDCMut().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoJTT().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoMtREV().setText(Tradutor.traduzir("Estimado", "Estimated"));
		ControladorIGrafu.phyml.getJRadioButtonGamaEstimadoWAG().setText(Tradutor.traduzir("Estimado", "Estimated"));
	}

	/**
	 * Metodo utilizado para retornar se existem mais de um caracter igual no
	 * texto
	 *
	 * @return boolean
	 */
	public boolean possuiVarios(String str, String igual) {
		int aux = 0;

		if (igual.length() > 1)
			return false;

		for (int i = 1; i <= str.length(); i++) {
			if (str.substring(i - 1, i).equals(igual))
				aux++;
		}

		if (aux > 1)
			return true;
		else
			return false;
	}
}
