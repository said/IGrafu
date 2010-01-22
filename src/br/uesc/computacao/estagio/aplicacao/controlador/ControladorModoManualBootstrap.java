package br.uesc.computacao.estagio.aplicacao.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.ModoManualBootstrap;

/**
 * Classe que faz o controle da segunda tela da IGrafu "Bootstrap"
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */
public class ControladorModoManualBootstrap implements ActionListener {

	/*
	 * Variaveis globais
	 */
	private ButtonGroup buttonGroupModoManualBootstrap = null;
	public static boolean bootstrap = false;
	public static String ERRO = "Erro";
	public static String ERRO1 = "Erro - Não foi possível abrir a tela anterior!";
	public static String ERRO2 = "Erro - Não foi possível abrir a próxima tela!";
	public static String INFORME_BOOTSTRAP = "Informe se deseja utilizar bootstrap!";
	public static String FECHAR = "Deseja sair do sistema?";
	public static String SAIR = "Sair";
	public static String CANCELAR = "Cancelar";

	/*
	 * Construtor
	 */
	public ControladorModoManualBootstrap() {
		ControladorIGrafu.modoManualBootstrap = new ModoManualBootstrap();
		ControladorIGrafu.modoManualBootstrap.setResizable(false);
		ControladorIGrafu.modoManualBootstrap.setVisible(true);
		ControladorIGrafu.modoManualBootstrap.repaint();
		ControladorIGrafu.modoManualBootstrap.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ControladorIGrafu.modoManualBootstrap.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				Object[] opcoes = { SAIR, CANCELAR };
				int opcao = JOptionPane.showOptionDialog(null, FECHAR,
						"IGRAFU 2.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, opcoes, opcoes[1]);

				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		buttonGroupModoManualBootstrap();
		ControladorIGrafu.modoManualBootstrap.getJButtonAvancar().addActionListener(this);
		ControladorIGrafu.modoManualBootstrap.getJButtonVoltar().addActionListener(this);
	}

	/**
	 * Este metodo cria grupos de botoes, onde somente um pode ficar selecionado
	 * Os botoes Manual e automatico, somente um dos dois pode ficar selecionado
	 */
	public void buttonGroupModoManualBootstrap() {
		if (buttonGroupModoManualBootstrap == null) {
			buttonGroupModoManualBootstrap = new ButtonGroup();
			buttonGroupModoManualBootstrap.add(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim());
			buttonGroupModoManualBootstrap.add(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao());
		}
		else {
			buttonGroupModoManualBootstrap.add(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim());
			buttonGroupModoManualBootstrap.add(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao());
		}
	}

	/*
	 * Trata eventos
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * Botao "Voltar"
		 */
		if(e.getSource() == ControladorIGrafu.modoManualBootstrap.getJButtonVoltar()) {
			try {
				if(ControladorIGrafu.conversor == null) {
					ControladorIGrafu.modoManualBootstrap.removeNotify();
					new ControladorConversor();
					//ControladorJanelaTeste.traduzir();
                                        ControladorIGrafu.conversor.setVisible(true);
					ControladorIGrafu.conversor.repaint();
					ControladorIGrafu.modoManualBootstrap.setVisible(false);
					
				}
				else {
					ControladorIGrafu.modoManualBootstrap.removeNotify();
					//ControladorJanelaTeste.traduzir();
                                        ControladorIGrafu.conversor.setVisible(true);
					ControladorIGrafu.conversor.repaint();
					ControladorIGrafu.modoManualBootstrap.setVisible(false);
					
				}
			}
			catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);
			}

		}

		/**
		 * Botao "Avancar"
		 */
		else if(e.getSource() == ControladorIGrafu.modoManualBootstrap.getJButtonAvancar()) {
			try {
				if(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao().isSelected() ||
						ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim().isSelected()) {
					if(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim().isSelected()) {
						if(ControladorIGrafu.seqboot == null) {
							bootstrap = true;
							ControladorIGrafu.modoManualBootstrap.removeNotify();
							new ControladorSeqboot();
							ControladorSeqboot.traduzir();

							ControladorIGrafu.seqboot.setVisible(true);
                                                        ControladorIGrafu.seqboot.repaint();
                                                        ControladorIGrafu.modoManualBootstrap.setVisible(false);
						}
						else {
							bootstrap = true;
							ControladorIGrafu.modoManualBootstrap.removeNotify();
							ControladorSeqboot.traduzir();
                                                        ControladorIGrafu.seqboot.setVisible(true);
                                                        ControladorIGrafu.seqboot.repaint();
							ControladorIGrafu.modoManualBootstrap.setVisible(false);
						}
					}
					else if(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao().isSelected()) {
						if(ControladorIGrafu.metodos == null) {
							bootstrap = false;
							ControladorIGrafu.modoManualBootstrap.removeNotify();
							new ControladorMetodos();
							ControladorMetodos.traduzir();
							ControladorIGrafu.metodos.setVisible(true);
                                                        ControladorIGrafu.metodos.repaint();
                                                        ControladorIGrafu.modoManualBootstrap.setVisible(false);
						}
						else {
							bootstrap = false;
							ControladorIGrafu.modoManualBootstrap.removeNotify();
							ControladorMetodos.traduzir();
							ControladorIGrafu.metodos.setVisible(true);
                                                        ControladorIGrafu.metodos.repaint();
                                                        ControladorIGrafu.modoManualBootstrap.setVisible(false);
						}
					}
				}
				else
					JOptionPane.showMessageDialog(null, INFORME_BOOTSTRAP, "Bootstrap", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, "ERRO - Não foi possível abrir a próxima tela!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/*
	 * Metodo de traducao Portugues/Ingles
	 */
	public static void traduzir() {
		ControladorIGrafu.modoManualBootstrap.getJLabelUtilizarBootstrap().setText(Tradutor.traduzir("Deseja utilizar bootstrap?","Desires use bootstrap?"));
		ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim().setText(Tradutor.traduzir("Sim","Yes"));
		ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao().setText(Tradutor.traduzir("Não","No"));
		ControladorIGrafu.modoManualBootstrap.getJButtonAvancar().setText(Tradutor.traduzir("Avançar","Advance"));
		ControladorIGrafu.modoManualBootstrap.getJButtonVoltar().setText(Tradutor.traduzir("Voltar","Back"));

		FECHAR = Tradutor.traduzir("Deseja sair do sistema?", "Do you want to leave the system?");
		SAIR = Tradutor.traduzir("Sair","Exit");
		CANCELAR = Tradutor.traduzir("Cancelar","Cancel");
		ERRO = Tradutor.traduzir("Erro","Error");
		ERRO1 = Tradutor.traduzir("Não foi possível abrir a tela anterior!","Was not possible open the previous screen!");
		ERRO2 = Tradutor.traduzir("Não foi possível abrir a próxima tela!","Was not possible open the next screen!");
		INFORME_BOOTSTRAP = Tradutor.traduzir("Informe se deseja utilizar bootstrap!", "Informs if desires use bootstrap!");
	}
}
