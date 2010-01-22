package br.uesc.computacao.estagio.aplicacao.util;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Classe utilizada para navegar na arvore de diretorios do sistema operacional
 *
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena
 *         Torres Delgado
 * @version 2.0
 */

public class Navegar extends JFrame {

	private static final long serialVersionUID = 1L;

	private static int returnVal;

	private static String caminho = "";

	private static boolean salvou = false;

	public static JFileChooser fileChooser = null;

	public static File file = null;

	public static Navegar navegar = null;

	/*
	 * Contrutor default
	 */
	public Navegar() {
		idioma();
	}

	/*
	 * Metodo utilizado para abrir arquivos
	 */
	public void abreArquivos() {
		idioma();
                Processo.pegaCaminho();

		if (fileChooser == null)
			fileChooser = new JFileChooser((Processo.pegaCaminho+Processo.corrigeCaminho+"/"));
			//Now gets the current working dir and open the dialog
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
               
		returnVal = fileChooser.showOpenDialog(this);
                
		
		// user clicked Cancel button on dialog
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		} else
			file = null;
	}

	/*
	 * Metodo utilizado para escolha de diretorios
	 */
	public void abreDiretorios() {
		idioma();
                Processo.pegaCaminho();

		if (fileChooser == null)
			fileChooser = new JFileChooser((Processo.pegaCaminho+Processo.corrigeCaminho+"/"));

		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		returnVal = fileChooser.showOpenDialog(this);

		// user clicked Cancel button on dialog
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		} else
			file = null;
	}

	/*
	 * Metodo utilizado para salvar arquivos
	 */
	public void salvar() {
		idioma();

		if (fileChooser == null)
			fileChooser = new JFileChooser();

		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File arquivo = null;
		fileChooser.setFileFilter(fileChooser.getFileFilter());
		fileChooser.addChoosableFileFilter(fileChooser.getFileFilter());
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setEnabled(true);
		Navegar.returnVal = fileChooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			arquivo = fileChooser.getSelectedFile();
			setCaminho((arquivo.getAbsolutePath()));
			salvou = true;
		}
	}

	/*
	 * Metodo utilizado para mudar o idioma para Portugues
	 */
	public static void mudar() {

		UIManager.put("FileChooser.lookInLabelMnemonic", new Integer('E'));
		UIManager.put("FileChooser.lookInLabelText", "Examinar");
		UIManager.put("FileChooser.saveInLabelText", "Salvar em");

		UIManager.put("FileChooser.fileNameLabelMnemonic", new Integer('N'));
		UIManager.put("FileChooser.fileNameLabelText", "Nome arquivo");

		UIManager.put("FileChooser.filesOfTypeLabelMnemonic", new Integer('T'));
		UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo");

		UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
		UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

		UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
		UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");

		UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
		UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

		UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
		UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

		UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
		UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");

		UIManager.put("FileChooser.fileNameHeaderText", "Nome");
		UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
		UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
		UIManager.put("FileChooser.fileDateHeaderText", "Data");
		UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");

		UIManager.put("FileChooser.openButtonText", "Abrir");
		UIManager.put("FileChooser.cancelButtonText", "Cancelar");
		UIManager.put("FileChooser.openButtonToolTipText", "Abrir arquivo selecionado");
		UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
		UIManager.put("FileChooser.approveButtonToolTipText", "Abrir");
		UIManager.put("FileChooser.CANCEL_OPTION", "Abrir");
		UIManager.put("FileChooser.lookInLabelText", "Abrir");

	}

	/*
	 * Metodo utilizado para mudar o idioma para Ingles
	 */
	public static void desmudar() {

		UIManager.put("FileChooser.lookInLabelMnemonic", new Integer('E'));
		UIManager.put("FileChooser.lookInLabelText", "Examine");
		UIManager.put("FileChooser.saveInLabelText", "Save in");

		UIManager.put("FileChooser.fileNameLabelMnemonic", new Integer('N')); // N
		UIManager.put("FileChooser.fileNameLabelText", "File name");

		UIManager.put("FileChooser.filesOfTypeLabelMnemonic", new Integer('T')); // T
		UIManager.put("FileChooser.filesOfTypeLabelText", "Type");

		UIManager.put("FileChooser.upFolderToolTipText", "One level above");
		UIManager.put("FileChooser.upFolderAccessibleName", "One level above");

		UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
		UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");

		UIManager.put("FileChooser.newFolderToolTipText", "Creat new folder");
		UIManager.put("FileChooser.newFolderAccessibleName", "Creat new folder");

		UIManager.put("FileChooser.listViewButtonToolTipText", "List");
		UIManager.put("FileChooser.listViewButtonAccessibleName", "List");

		UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
		UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Details");

		UIManager.put("FileChooser.fileNameHeaderText", "Name");
		UIManager.put("FileChooser.fileSizeHeaderText", "Size");
		UIManager.put("FileChooser.fileTypeHeaderText", "Type");
		UIManager.put("FileChooser.fileDateHeaderText", "Date");
		UIManager.put("FileChooser.fileAttrHeaderText", "Attributes");

		UIManager.put("FileChooser.openButtonText", "Open");
		UIManager.put("FileChooser.cancelButtonText", "Cancel");
		UIManager.put("FileChooser.openButtonToolTipText", "Open selected file");
		UIManager.put("FileChooser.cancelButtonToolTipText", "Cancel");
		UIManager.put("FileChooser.approveButtonToolTipText", "Open");
		UIManager.put("FileChooser.CANCEL_OPTION", "Open");
		UIManager.put("FileChooser.lookInLabelText", "Open");

	}

	/*
	 * Metodo utilizada para traduzir Portugues/Ingles
	 */
	public static void idioma() {
		if (Tradutor.getLinguage() == 1) {
			desmudar();
		}

		else if (Tradutor.getLinguage() == 0) {
			mudar();
		}
	}

	public static boolean isSalvou() {
		return salvou;
	}

	public static void setSalvou(boolean salvou) {
		Navegar.salvou = salvou;
	}

	/**
	 * @return o returnVal
	 */
	public static int getReturnVal() {
		return returnVal;
	}

	/**
	 * @param returnVal
	 *            o returnVal a ser configurado
	 */
	public static void setReturnVal(int returnVal) {
		Navegar.returnVal = returnVal;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		Navegar.caminho = caminho;
	}
}
