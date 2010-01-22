package br.uesc.computacao.estagio.aplicacao.controlador;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.ManipulaArquivo;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import br.uesc.computacao.estagio.aplicacao.util.Processo;
import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.ModoExecucao;


/**
 * Classe que faz o controle da primeira tela da IGrafu "modo de Execucao"
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */
public class ControladorModoExecucao implements ActionListener {

	/*
	 * Variaveis globais
	 */
	private ButtonGroup buttonGroupModoExecucao = null;
	private ButtonGroup buttonGroupIdioma = null;
	public static String arquivoSaida = "";

	public static String FECHAR = "Deseja sair do sistema?";
	public static String SAIR = "Sair";
	public static String CANCELAR = "Cancelar";
	public String ERRO = "Erro";
	public static String ERRO1 = "Não foi possível abrir a próxima tela!";

	public static String INFORME_MODO = "Informe o modo de execução!";
	public static String INFORME_SEQUENCIA = "Informe o arquivo da seqüência!";
	public static String SEQUENCIA = "Seqüência";
	public static String MODO_EXECUCAO = "Modo de execução";
	public static String SISTEMA_ARQUIVO = "ERRO - Não foi possível visualizar o sistema de arquivos!";
	public static String SOBRE = "Sobre a IGRAFU";

	/*
	 * Construtor
	 */
	public ControladorModoExecucao() {

		ControladorIGrafu.modoExecucao = new ModoExecucao();
		ControladorIGrafu.modoExecucao.setResizable(false);
		ControladorIGrafu.modoExecucao.setVisible(false);
		ControladorIGrafu.modoExecucao.setVisible(true);
		ControladorIGrafu.modoExecucao.repaint();

		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico().setEnabled(false);

		buttonGroupModoExecucao();
		buttonGroupIdioma();
		carregaPerfil();

		ControladorIGrafu.modoExecucao.getJButtonArquivoSequencia().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJButtonAvancar().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJButtonVisualizar().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemEnglish().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemPortuguese().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemPortuguese().setSelected(true);
		ControladorIGrafu.modoExecucao.getJMenuItemSobre().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJMenuItemFechar().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJMenuItemSobre().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJButtonExecutarPerfil().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico().addActionListener(this);
		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual().addActionListener(this);
		setArquivoClickHandler();
		ControladorIGrafu.modoExecucao.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ControladorIGrafu.modoExecucao.addWindowListener(new java.awt.event.WindowAdapter() {
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

		ControladorIGrafu.modoExecucao.getJTextFieldArquivoSequencia().setText("");
		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual().setSelected(true);
		ControladorIGrafu.modoExecucao.repaint();

		ControladorIGrafu.modoExecucao.getJDialogModoExecucaoPerfil().addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				ControladorIGrafu.modoExecucao.getJDialogModoExecucaoPerfil().removeNotify();
				ControladorIGrafu.modoExecucao.setEnabled(true);
				ControladorIGrafu.modoExecucao.setVisible(true);
			}
		});
	}
	
	private void setArquivoClickHandler() {
		ControladorIGrafu.modoExecucao.
		getJTextFieldArquivoSequencia().addMouseListener(
				new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ControladorIGrafu.modoExecucao.getJButtonArquivoSequencia().doClick();
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// Do nothing
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// Do nothing
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// Do nothing
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// Do nothing
						
					}
				}
				);
	}

	/**
	 * Os botoes Manual e automatico, somente um dos dois pode ficar selecionado
	 */
	public void buttonGroupModoExecucao() {
		if (buttonGroupModoExecucao == null) {
			buttonGroupModoExecucao = new ButtonGroup();
			buttonGroupModoExecucao.add(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual());
			buttonGroupModoExecucao.add(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico());
			buttonGroupModoExecucao.add(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoPerfil());
		}
		else {
			buttonGroupModoExecucao.add(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual());
			buttonGroupModoExecucao.add(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico());
		}
	}

	/**
	 * Os botoes do menu Idioma English e Portuguese, somente um dos dois pode ficar selecionado
	 */
	public void buttonGroupIdioma() {
		if (buttonGroupIdioma == null) {
			buttonGroupIdioma = new ButtonGroup();
			buttonGroupIdioma.add(ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemEnglish());
			buttonGroupIdioma.add(ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemPortuguese());
		}
		else {
			buttonGroupIdioma.add(ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemEnglish());
			buttonGroupIdioma.add(ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemPortuguese());
		}
	}

	/**
	 * Trata eventos
	 */
	public void actionPerformed(ActionEvent e) {

		/*
		 * Botao "Avancar"
		 */
		if(e.getSource() == ControladorIGrafu.modoExecucao.getJButtonAvancar()) {
			try {
                            ControladorIGrafu.modoExecucao.removeNotify();
                            new ControladorConversor();
                            ControladorConversor.traduzir();
                            ControladorIGrafu.conversor.setVisible(true);
                            ControladorIGrafu.conversor.repaint();
                            ControladorIGrafu.modoExecucao.setVisible(false);
                            


                            

			}

			catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);
			}

		}


//		if(e.getSource() == ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico()) {
//			if(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico().isSelected()) {
//				ControladorIGrafu.modoExecucao.getJButtonArquivoSequencia().setEnabled(false);
//				ControladorIGrafu.modoExecucao.getJTextFieldArquivoSequencia().setText("");
//			}
//		}
//
		if(e.getSource() == ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual()) {
			if(ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual().isSelected()) {
				ControladorIGrafu.modoExecucao.getJButtonVisualizar().setVisible(false);
			}
		}

		if(e.getSource() == ControladorIGrafu.modoExecucao.getJButtonExecutarPerfil() ) {
			ControladorIGrafu.modoExecucao.getJDialogModoExecucaoPerfil().removeNotify();
			ControladorIGrafu.modoExecucao.getJDialogModoExecucaoPerfil().setVisible(false);
			ControladorIGrafu.modoExecucao.setEnabled(true);
			ControladorIGrafu.modoExecucao.setVisible(true);

			ControladorIGrafu.modoExecucao.getJProgressBarAutomatico().setVisible(true);
			ControladorIGrafu.modoExecucao.getJProgressBarAutomatico().setStringPainted(true);

			Thread threadProgress = new Thread(new Runnable() {
				public void run() {
					ControladorIGrafu.modoExecucao.getJProgressBarAutomatico().setString("Executando");
					ControladorIGrafu.modoExecucao.getJProgressBarAutomatico().setIndeterminate(true);
				}
			});
			threadProgress.setDaemon(true);
			threadProgress.start();

			Thread threadAutomatico = new Thread(new Runnable() {
				public void run() {
					Processo.execucaoPerfil();
					ControladorIGrafu.modoExecucao.getJButtonVisualizar().setVisible(true);
					ControladorIGrafu.modoExecucao.getJProgressBarAutomatico().setVisible(false);
				}
			});
			threadAutomatico.start();
		}

		if(e.getSource() == ControladorIGrafu.modoExecucao.getJButtonVisualizar()) {
			Processo.processarHyperTreePHYML();
		}

		/*
		 * Menu Configuracoes -> idiomas
		 */
		if(e.getSource() == ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemEnglish() || e.getSource() == ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemPortuguese()) {
			if(ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemEnglish().isSelected()) {
				Tradutor.setLinguage(1);
				traduzir();
			}
			else {
				Tradutor.setLinguage(0);
				traduzir();
			}
		}

		/*
		 * Menu Arquivo -> Fechar
		 */
		if(e.getSource() == ControladorIGrafu.modoExecucao.getJMenuItemFechar()) {
			Object[] opcoes = { SAIR, CANCELAR };
			int opcao = JOptionPane.showOptionDialog(null, FECHAR,
					"IGRAFU 2.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, opcoes, opcoes[1]);

			if (opcao == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

		/*
		 * Menu Ajuda -> Sobre
		 */
		if(e.getSource() == ControladorIGrafu.modoExecucao.getJMenuItemSobre()) {

			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			ControladorIGrafu.modoExecucao.getJDialogSobre().setLocation( ( dimension.width - ControladorIGrafu.modoExecucao.getX() - 300)/2, ( dimension.height - ControladorIGrafu.modoExecucao.getY() - 50)/2 );

			ControladorIGrafu.modoExecucao.getJDialogSobre().setVisible(true);
			ControladorIGrafu.modoExecucao.getJDialogSobre().repaint();
		}
	}

	public void carregaPerfil() {
		if(ManipulaArquivo.existeArquivo("perfil/nomes_perfil")) {
			for(int i = 0; i < ManipulaArquivo.contaLinhas("perfil/nomes_perfil"); i++) {
				ControladorIGrafu.modoExecucao.getJComboBoxExecucaoPerfil().addItem((ManipulaArquivo.leLinha("perfil/nomes_perfil", i)));
			}
		}
	}

	/*
	 * Metodo que faz a traducao Portugues/Ingles
	 */
	public static void traduzir() {
		ControladorIGrafu.modoExecucao.getJLabelModoExecucao().setText(Tradutor.traduzir("Modo de execução:","    Execution way:"));
		ControladorIGrafu.modoExecucao.getJLabelArquivoSequencia().setText(Tradutor.traduzir("Arquivo da Seqüencia","          Sequence file"));
		ControladorIGrafu.modoExecucao.getJLabelPerfil().setText(Tradutor.traduzir("Perfil","Profile"));
		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoManual().setText(Tradutor.traduzir("Manual","Manual"));
		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoAutomatico().setText(Tradutor.traduzir("Automático","Automatic"));
		ControladorIGrafu.modoExecucao.getJRadioButtonModoExecucaoPerfil().setText(Tradutor.traduzir("Perfil","Profile"));
		ControladorIGrafu.modoExecucao.getJButtonArquivoSequencia().setToolTipText(Tradutor.traduzir("Abrir aquivo","Open archive"));
		ControladorIGrafu.modoExecucao.getJButtonAvancar().setText(Tradutor.traduzir("Avançar", "Advance"));
		ControladorIGrafu.modoExecucao.getJMenuArquivo().setText(Tradutor.traduzir("Arquivo","File"));
		ControladorIGrafu.modoExecucao.getJMenuConfiguracao().setText(Tradutor.traduzir("Configuração","Configuration"));
		ControladorIGrafu.modoExecucao.getJMenuAjuda().setText(Tradutor.traduzir("Ajuda","Help"));
		ControladorIGrafu.modoExecucao.getJMenuIdioma().setText(Tradutor.traduzir("Idioma","Language"));
		ControladorIGrafu.modoExecucao.getJMenuPerfil().setText(Tradutor.traduzir("Perfil","Profile"));
		ControladorIGrafu.modoExecucao.getJMenuItemDeletarPerfil().setText(Tradutor.traduzir("Deletar Perfil","Delete profile"));
		ControladorIGrafu.modoExecucao.getJMenuItemFechar().setText(Tradutor.traduzir("Sair","Exit"));
		ControladorIGrafu.modoExecucao.getJMenuItemSobre().setText(Tradutor.traduzir("Sobre a IGRAFU","About IGRAFU"));
		ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemEnglish().setText(Tradutor.traduzir("Inglês","English"));
		ControladorIGrafu.modoExecucao.getJCheckBoxMenuItemPortuguese().setText(Tradutor.traduzir("Português","Portuguese"));
		ControladorIGrafu.modoExecucao.getJDialogSobre().setTitle(Tradutor.traduzir("Sobre a IGRAFU","About IGRAFU"));
		ControladorIGrafu.modoExecucao.getJDialogModoExecucaoPerfil().setTitle(Tradutor.traduzir("Executar Perfil","Execute Profile"));
		ControladorIGrafu.modoExecucao.getJButtonExecutarPerfil().setText(Tradutor.traduzir("Executar", "Execute"));

		ControladorIGrafu.modoExecucao.getJTextArea().setText(Tradutor.traduzir("IGRAFU \nVersão: 2.0\nEste produto inclui os programas:\n   " +
				"- DIGRAFU (Cristiano Martins)\n   - PHYML\n   - Seqboot\n   " +
				"- Consense.\n\nAutores: Zilton Junior & Martha Ximena","IGRAFU \nVersion: 2.0\nThis product includ softwares:\n   " +
					"- DIGRAFU (Cristiano Martins)\n   - PHYML\n   - Seqboot\n   " +
					"- Consense.\n\nAuthors: Zilton Junior & Martha Ximena"));

		FECHAR = Tradutor.traduzir("Deseja sair do sistema?", "Do you want to leave the system?");
		SAIR = Tradutor.traduzir("Sair","Exit");
		CANCELAR = Tradutor.traduzir("Cancelar","Cancel");
		ERRO1 = Tradutor.traduzir("Não foi possível abrir a próxima tela!","Was not possible open the next screen!");
		INFORME_MODO = Tradutor.traduzir("Informe o modo de execução!","Inform the execution way!");
		INFORME_SEQUENCIA = Tradutor.traduzir("Informe o arquivo da seqüência!","Inform the sequence file!");
		MODO_EXECUCAO = Tradutor.traduzir("Modo de execução","Way of execution");
		SEQUENCIA = Tradutor.traduzir("Seqüência","Sequence");
		SISTEMA_ARQUIVO = Tradutor.traduzir("Não foi possível visualizar o sistema de arquivos!", "It was not possible to visualize the system of archives!");
		SOBRE = (Tradutor.traduzir("Sobre a IGRAFU","About IGRAFU"));

		Navegar.navegar = null;
		Navegar.fileChooser = null;
		Navegar.navegar = new Navegar();
	}
}
