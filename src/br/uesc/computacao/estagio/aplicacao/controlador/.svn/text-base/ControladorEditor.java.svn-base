package br.uesc.computacao.estagio.aplicacao.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.ManipulaArquivo;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.Editor;

/**
 * Classe que faz o controle do Editor
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */
public class ControladorEditor implements ActionListener {

	/*
	 * Variaveis Globais
	 */
	private ManipulaArquivo arquivo = null;

	/*
	 * Construtor
	 */
	public ControladorEditor() {
		ControladorIGrafu.editor = new Editor();

		ControladorIGrafu.editor.getJButtonSalvar().addActionListener(this);
		ControladorIGrafu.editor.getJButtonAbrir().addActionListener(this);
		ControladorIGrafu.editor.getJButtonLimpar().addActionListener(this);
		ControladorIGrafu.editor.getJCheckBoxEditar().addActionListener(this);

		ControladorIGrafu.editor.getJMenuItemAbrir().addActionListener(this);
		ControladorIGrafu.editor.getJMenuItemSalvar().addActionListener(this);

		ControladorIGrafu.editor.setVisible(true);
		ControladorIGrafu.editor.repaint();
		ControladorIGrafu.editor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/*
	 * Trata Eventos
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ControladorIGrafu.editor.getJButtonSalvar() ||
				e.getSource() == ControladorIGrafu.editor.getJMenuItemSalvar()) {
    		try {
    			if (Navegar.navegar == null) {
    				Navegar.navegar = new Navegar();
    				Navegar.navegar.salvar();
    				if (Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
    					if (arquivo == null)
    						arquivo = new ManipulaArquivo(Navegar.navegar.getCaminho(), ControladorIGrafu.editor.getJTextArea().getText());
    					else
    						ManipulaArquivo.gravaArquivo(Navegar.navegar.getCaminho(), ControladorIGrafu.editor.getJTextArea().getText());
    				}
    			} else {
    				Navegar.navegar.salvar();
    				if (Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
    					if (arquivo == null)
    						arquivo = new ManipulaArquivo(Navegar.navegar.getCaminho(), ControladorIGrafu.editor.getJTextArea().getText());
    					else
    						ManipulaArquivo.gravaArquivo(Navegar.navegar.getCaminho(), ControladorIGrafu.editor.getJTextArea().getText());
    				}
    			}
    		}
    		catch( Exception ex ) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog( null, " Erro - Não foi possível salvar o arquivo ", "Erro", JOptionPane.ERROR_MESSAGE );
            }

		}

		if (e.getSource() == ControladorIGrafu.editor.getJButtonAbrir() ||
				e.getSource() == ControladorIGrafu.editor.getJMenuItemAbrir()) {
			try {
				if(Navegar.navegar == null) {
					Navegar.navegar = new Navegar();
					Navegar.navegar.abreArquivos();
					if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
						ControladorIGrafu.editor.getJTextArea().setText(ManipulaArquivo.leArquivo(Navegar.file.getAbsolutePath()));
						ControladorIGrafu.editor.getJTabbedPane().setTitleAt(0, Navegar.file.getName());
					}
				}
				else {
					Navegar.navegar.abreArquivos();
					if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
						ControladorIGrafu.editor.getJTextArea().setText(ManipulaArquivo.leArquivo(Navegar.file.getAbsolutePath()));
						ControladorIGrafu.editor.getJTabbedPane().setTitleAt(0, Navegar.file.getName());
					}
				}
			}
			catch (Exception exception) {

			}

		}

        if(e.getSource() == ControladorIGrafu.editor.getJButtonLimpar()) {
        	ControladorIGrafu.editor.getJTextArea().setText("");
        	ControladorIGrafu.editor.getJTabbedPane().setTitleAt(0, "");
            ControladorIGrafu.editor.getJTextArea().setEditable(false);
            ControladorIGrafu.editor.getJCheckBoxEditar().setSelected(false);
        }

        if(e.getSource() == ControladorIGrafu.editor.getJCheckBoxEditar()) {
            if(ControladorIGrafu.editor.getJCheckBoxEditar().isSelected() ) {
            	ControladorIGrafu.editor.getJTextArea().setEditable(true);
            }
            else {
            	ControladorIGrafu.editor.getJTextArea().setEditable(false);

            }

        }

	}

	/*
	 * Metodo de traducao Portugues/Ingles
	 */
	public static void traduzir() {
		ControladorIGrafu.editor.getJMenuArquivo().setText(Tradutor.traduzir("Arquivo", "File"));
		ControladorIGrafu.editor.getJCheckBoxEditar().setText(Tradutor.traduzir("Editar", "Edit"));
		ControladorIGrafu.editor.getJMenuItemAbrir().setText(Tradutor.traduzir("Abrir", "Open"));
		ControladorIGrafu.editor.getJMenuItemSalvar().setText(Tradutor.traduzir("Salvar", "Save"));

		ControladorIGrafu.editor.getJButtonAbrir().setToolTipText(Tradutor.traduzir("Abrir", "Open"));
		ControladorIGrafu.editor.getJButtonLimpar().setToolTipText(Tradutor.traduzir("Limpar", "Clean"));
		ControladorIGrafu.editor.getJButtonSalvar().setToolTipText(Tradutor.traduzir("Salvar", "Save"));
	}
}
