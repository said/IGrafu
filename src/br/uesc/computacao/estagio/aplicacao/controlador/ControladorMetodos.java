package br.uesc.computacao.estagio.aplicacao.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.Metodos;

/**
 * Classe que controla a tela Metodos
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */


public class ControladorMetodos implements ActionListener {

	/*
	 * Variaveis Globais
	 */
	public static String ERRO = "Erro";
	public static String ERRO1 = "Erro - Não foi possível abrir a tela anterior!";
	public static String ERRO2 = "Erro - Não foi possível abrir a próxima tela!";
	public static String INFORME_BOOTSTRAP = "Informe se deseja utilizar bootstrap!";
	public static String FECHAR = "Deseja sair do sistema?";
	public static String SAIR = "Sair";
	public static String CANCELAR = "Cancelar";
	public static String METODO_UTILIZAR = "Informe o método a ser Utilizado!";
	public static String METODO = "Método";

	private ButtonGroup grupoBotoesMetodos = null;

	/*
	 * Construtor
	 */
	public ControladorMetodos() {
		ControladorIGrafu.metodos = new Metodos();
		ControladorIGrafu.metodos.setResizable(false);
		ControladorIGrafu.metodos.setVisible(true);
		ControladorIGrafu.metodos.repaint();
		ControladorIGrafu.metodos.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ControladorIGrafu.metodos.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				Object[] opcoes = { SAIR, CANCELAR };
				int opcao = JOptionPane.showOptionDialog(null,
						FECHAR, "IGRAFU 2.0",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);

				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		buttonGroupModoBootstrap();
		ControladorIGrafu.metodos.getJButtonAvancar().addActionListener(this);
		ControladorIGrafu.metodos.getJButtonVoltar().addActionListener(this);
	}

	/*
	 * Grupo de botoes dos metodos
	 */
	public void buttonGroupModoBootstrap() {
		if (grupoBotoesMetodos == null) {
			grupoBotoesMetodos = new ButtonGroup();
			grupoBotoesMetodos.add(ControladorIGrafu.metodos.getJRadioButtonBayes());
			grupoBotoesMetodos.add(ControladorIGrafu.metodos.getJRadioButtonDistancia());
			grupoBotoesMetodos.add(ControladorIGrafu.metodos.getJRadioButtonMaximaVerossimilhanca());
			grupoBotoesMetodos.add(ControladorIGrafu.metodos.getJRadioButtonParcimonia());
		}
	}

	/*
	 * Trada eventos
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ControladorIGrafu.metodos.getJButtonVoltar()) {
			try {
				if(ControladorModoManualBootstrap.bootstrap == false) {
					if (ControladorIGrafu.modoManualBootstrap == null) {
						ControladorIGrafu.metodos.removeNotify();
						new ControladorModoManualBootstrap();
						ControladorModoManualBootstrap.traduzir();
						ControladorIGrafu.modoManualBootstrap.setVisible(true);
                                                ControladorIGrafu.modoManualBootstrap.repaint();
                                                ControladorIGrafu.metodos.setVisible(false);

					} else {
						ControladorIGrafu.metodos.removeNotify();
						ControladorModoManualBootstrap.traduzir();
                                                ControladorIGrafu.modoManualBootstrap.setVisible(true);
                                                ControladorIGrafu.modoManualBootstrap.repaint();
						ControladorIGrafu.metodos.setVisible(false);
						
					}
				}
				else {
					if (ControladorIGrafu.seqboot == null) {
						ControladorIGrafu.metodos.removeNotify();
						new ControladorSeqboot();						
						ControladorIGrafu.seqboot.setVisible(true);
                                                ControladorIGrafu.seqboot.repaint();
                                                ControladorIGrafu.metodos.setVisible(false);

					} else {
						ControladorIGrafu.metodos.removeNotify();
						ControladorIGrafu.seqboot.setVisible(true);
                                                ControladorIGrafu.seqboot.repaint();
                                                ControladorIGrafu.metodos.setVisible(false);
					}
				}

			} catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == ControladorIGrafu.metodos.getJButtonAvancar()) {
			try {
				if (ControladorIGrafu.metodos.getJRadioButtonMaximaVerossimilhanca().isSelected()
						|| ControladorIGrafu.metodos.getJRadioButtonBayes().isSelected()
						|| ControladorIGrafu.metodos.getJRadioButtonDistancia().isSelected()
						|| ControladorIGrafu.metodos.getJRadioButtonParcimonia().isSelected()) {

					if (ControladorIGrafu.metodos.getJRadioButtonMaximaVerossimilhanca().isSelected()) {
						if (ControladorIGrafu.programas == null) {
							ControladorIGrafu.metodos.removeNotify();
							new ControladorProgramas();
							ControladorProgramas.traduzir();
							ControladorIGrafu.programas.getJRadioButtonPHYML().setEnabled(true);
							ControladorIGrafu.programas.getJRadioButtonPHYML().setSelected(true);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setSelected(false);

							ControladorIGrafu.programas.setVisible(true);
                                                        ControladorIGrafu.programas.repaint();
                                                        ControladorIGrafu.metodos.setVisible(false);

						} else {
							ControladorIGrafu.metodos.removeNotify();
							ControladorProgramas.traduzir();
							ControladorIGrafu.programas.getJRadioButtonPHYML().setEnabled(true);
							ControladorIGrafu.programas.getJRadioButtonPHYML().setVisible(true);
							ControladorIGrafu.programas.getJRadioButtonPHYML().setSelected(true);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setSelected(false);

							ControladorIGrafu.programas.setVisible(true);
                                                        ControladorIGrafu.programas.repaint();
                                                        ControladorIGrafu.metodos.setVisible(false);
							
						}
					}
					else if (ControladorIGrafu.metodos.getJRadioButtonBayes().isSelected()) {
						JOptionPane.showMessageDialog(null,
								"Mr. Bayes ainda não implementado!", "Bayes",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else if (ControladorIGrafu.metodos.getJRadioButtonDistancia().isSelected()) {
						if (ControladorIGrafu.programas == null) {
							ControladorIGrafu.metodos.removeNotify();
                            ControladorIGrafu.metodos.setVisible(false);
							new ControladorProgramas();
							ControladorProgramas.traduzir();
							ControladorIGrafu.programas.getJRadioButtonPHYML().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonPHYML().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setVisible(true);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setSelected(true);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setSelected(false);
							ControladorIGrafu.programas.setVisible(true);
							ControladorIGrafu.programas.repaint();
						} else {
							ControladorIGrafu.metodos.removeNotify();
                            ControladorIGrafu.metodos.setVisible(false);
							ControladorProgramas.traduzir();
							ControladorIGrafu.programas.getJRadioButtonPHYML().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonPHYML().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setVisible(true);
							ControladorIGrafu.programas.getJRadioButtonDIGRAFU().setSelected(true);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonMrBayes().setSelected(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setVisible(false);
							ControladorIGrafu.programas.getJRadioButtonParcimonia().setSelected(false);
							ControladorIGrafu.programas.setVisible(true);
							ControladorIGrafu.programas.repaint();
						}
					}
					else if (ControladorIGrafu.metodos.getJRadioButtonParcimonia().isSelected()) {
						JOptionPane.showMessageDialog(null,
								"Parcimônia ainda não implementado!", "Parcimônia",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(null, METODO_UTILIZAR, METODO,
							JOptionPane.INFORMATION_MESSAGE);
			} catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, ERRO2, ERRO, JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/*
	 * Metodo de traducao Portugues/Ingles
	 */
	public static void traduzir() {
		ControladorIGrafu.metodos.getJLabelMetodos().setText(Tradutor.traduzir("Qual método deseja utilizar?","Which method desires use?"));
		ControladorIGrafu.metodos.getJButtonAvancar().setText(Tradutor.traduzir("Avançar","Advance"));
		ControladorIGrafu.metodos.getJButtonVoltar().setText(Tradutor.traduzir("Voltar","Back"));
		ControladorIGrafu.metodos.getJRadioButtonMaximaVerossimilhanca().setText(Tradutor.traduzir("Máxima Verossimilhança", "Maximum Likelihood"));
		ControladorIGrafu.metodos.getJRadioButtonDistancia().setText(Tradutor.traduzir("Distância", "Distance"));
		ControladorIGrafu.metodos.getJRadioButtonParcimonia().setText(Tradutor.traduzir("Parcimônia", "Parsimony"));
		ControladorIGrafu.metodos.getJRadioButtonBayes().setText(Tradutor.traduzir("Bayes", "Bayes"));
		ControladorIGrafu.metodos.setTitle(Tradutor.traduzir("IGRAFU: Métodos","IGRAFU: Methods"));

		METODO = Tradutor.traduzir("Método","Method");
		METODO_UTILIZAR = Tradutor.traduzir("Informe o método a ser Utilizado!","Inform the method To be used!");
		FECHAR = Tradutor.traduzir("Deseja sair do sistema?", "Do you want to leave the system?");
		SAIR = Tradutor.traduzir("Sair","Exit");
		CANCELAR = Tradutor.traduzir("Cancelar","Cancel");
		ERRO = Tradutor.traduzir("Erro","Error");
		ERRO1 = Tradutor.traduzir("Não foi possível abrir a tela anterior!","Was not possible open the previous screen!");
		ERRO2 = Tradutor.traduzir("Não foi possível abrir a próxima tela!","Was not possible open the next screen!");
		INFORME_BOOTSTRAP = Tradutor.traduzir("Informe se deseja utilizar bootstrap!", "Inform if desires use bootstrap!");
	}

}
