package br.uesc.computacao.estagio.apresentacao.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.FlowLayout;

/**
 * Classe que gera a tela do Editor
 * @author Zilton Cordeiro Junior
 *
 */
public class Editor extends JFrame {

	/**
	 * Variaveis Globais
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenuArquivo = null;
	private JMenuItem jMenuItemAbrir = null;
	private JMenuItem jMenuItemSalvar = null;
	private JSeparator jSeparatorMenu = null;
	private JPanel jPanel = null;
	private JButton jButtonAbrir = null;
	private JButton jButtonSalvar = null;
	private JButton jButtonLimpar = null;
	private JCheckBox jCheckBoxEditar = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanelAreaTexto = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextArea = null;
	public Editor() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(790, 470);
		this.setPreferredSize(new Dimension(790, 470));
		this.setJMenuBar(getJJMenuBar());
		this.setBackground(new Color(173, 200, 226));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/IGrafuAF.png")));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( ( dimension.width - getSize().width )/2 + 30, ( dimension.height - getSize().height )/2 + 30 );
		this.setContentPane(getJContentPane());
		this.setTitle("Editor");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.NORTH);
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 *
	 * @return javax.swing.JMenuBar
	 */
	public JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenuArquivo());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenuArquivo
	 *
	 * @return javax.swing.JMenu
	 */
	public JMenu getJMenuArquivo() {
		if (jMenuArquivo == null) {
			jMenuArquivo = new JMenu();
			jMenuArquivo.setText("Arquivo");
			jMenuArquivo.add(getJMenuItemAbrir());
			jMenuArquivo.add(getJSeparatorMenu());
			jMenuArquivo.add(getJMenuItemSalvar());
		}
		return jMenuArquivo;
	}

	/**
	 * This method initializes jMenuItemAbrir
	 *
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJMenuItemAbrir() {
		if (jMenuItemAbrir == null) {
			jMenuItemAbrir = new JMenuItem();
			jMenuItemAbrir.setText("Abrir");
			jMenuItemAbrir.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder_open.gif")));
		}
		return jMenuItemAbrir;
	}

	/**
	 * This method initializes jMenuItemSalvar
	 *
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJMenuItemSalvar() {
		if (jMenuItemSalvar == null) {
			jMenuItemSalvar = new JMenuItem();
			jMenuItemSalvar.setText("Salvar");
			jMenuItemSalvar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/save.gif")));
		}
		return jMenuItemSalvar;
	}

	/**
	 * This method initializes jSeparatorMenu
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMenu() {
		if (jSeparatorMenu == null) {
			jSeparatorMenu = new JSeparator();
		}
		return jSeparatorMenu;
	}

	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new FlowLayout());
			jPanel.add(getJButtonAbrir(), null);
			jPanel.add(getJButtonSalvar(), null);
			jPanel.add(getJButtonLimpar(), null);
			jPanel.add(getJCheckBoxEditar(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButtonAbrir
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAbrir() {
		if (jButtonAbrir == null) {
			jButtonAbrir = new JButton();
			jButtonAbrir.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonAbrir.setOpaque(false);
			jButtonAbrir.setMargin(new Insets(2, 14, 2, 14));
			jButtonAbrir.setName("jButtonAbrir");
			jButtonAbrir.setPreferredSize(new Dimension(30, 29));
		}
		return jButtonAbrir;
	}

	/**
	 * This method initializes jButtonSalvar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonSalvar() {
		if (jButtonSalvar == null) {
			jButtonSalvar = new JButton();
			jButtonSalvar.setPreferredSize(new Dimension(30, 29));
			jButtonSalvar.setOpaque(false);
			jButtonSalvar.setName("jButtonSalvar");
			jButtonSalvar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/salvar.gif")));
		}
		return jButtonSalvar;
	}

	/**
	 * This method initializes jButtonLimpar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonLimpar() {
		if (jButtonLimpar == null) {
			jButtonLimpar = new JButton();
			jButtonLimpar.setPreferredSize(new Dimension(30, 29));
			jButtonLimpar.setOpaque(false);
			jButtonLimpar.setName("jButton");
			jButtonLimpar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/recicla.png")));
		}
		return jButtonLimpar;
	}

	/**
	 * This method initializes jCheckBoxEditar
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxEditar() {
		if (jCheckBoxEditar == null) {
			jCheckBoxEditar = new JCheckBox();
			jCheckBoxEditar.setText("Editar");
			jCheckBoxEditar.setName("jCheckBox");
			jCheckBoxEditar.setOpaque(false);
		}
		return jCheckBoxEditar;
	}

	/**
	 * This method initializes jTabbedPane
	 *
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab(null, null, getJPanelAreaTexto(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanelAreaTexto
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelAreaTexto() {
		if (jPanelAreaTexto == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.weightx = 1.0;
			jPanelAreaTexto = new JPanel();
			jPanelAreaTexto.setLayout(new GridBagLayout());
			jPanelAreaTexto.add(getJScrollPane(), gridBagConstraints1);
		}
		return jPanelAreaTexto;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	public JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea
	 *
	 * @return javax.swing.JTextArea
	 */
	public JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}

}
