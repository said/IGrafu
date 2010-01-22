package br.uesc.computacao.estagio.apresentacao.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.uesc.computacao.estagio.aplicacao.util.JNumberField;
import br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField;

/**
 * Classe que gera a tela Bootstrap seqboot/Consense
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

public class Seqboot extends JFrame {

	/**
	 * Variaveis Globais
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTabbedPane jTabbedPaneGeral = null;

	private JPanel jPanelSequencia = null;

	private JLabel jLabelArquivoSequencia = null;

	private JMenuBar jJMenuBar = null;

	private JMenu jMenuArquivo = null;

	private JSeparator jSeparator0 = null;

	private JSeparator jSeparator1 = null;

	private JSeparator jSeparator2 = null;

	private JSeparator jSeparator3 = null;

	private JSeparator jSeparator4 = null;

	private JButton jButtonArquivoSequencia = null;

	private JLabel jLabelTipoDado = null;

	private JSeparator jSeparator5 = null;

	private JSeparator jSeparator6 = null;

	private JSeparator jSeparator7 = null;

	private JSeparator jSeparator8 = null;

	private JSeparator jSeparator9 = null;

	private JTextField jTextFieldArquivoSequencia = null;

	private JLabel jLabelTipoSequencia = null;

	private JSeparator jSeparator10 = null;

	private JSeparator jSeparator11 = null;

	private JSeparator jSeparator12 = null;

	private JSeparator jSeparator13 = null;

	private JSeparator jSeparator14 = null;

	private JSeparator jSeparatorS1 = null;

	private JSeparator jSeparatorS0 = null;

	private JSeparator jSeparatorS2 = null;

	private JSeparator jSeparatorS3 = null;

	private JSeparator jSeparatorS4 = null;

	private JSeparator jSeparatorS5 = null;

	private JSeparator jSeparatorS6 = null;

	private JSeparator jSeparatorS7 = null;

	private JSeparator jSeparatorS8 = null;

	private JSeparator jSeparatorS9 = null;

	private JSeparator jSeparatorS10 = null;

	private JSeparator jSeparatorS11 = null;

	private JButton jButtonAvancar = null;

	private JButton jButtonVoltar = null;

	private JButton jButtonEditor = null;

	private JMenuItem jMenuItemFechar = null;

	private ImageIcon imagemDNA = null;

	private ImageIcon imagemAA = null;  //  @jve:decl-index=0:

	private JMenu jMenuConfiguracoes = null;

	private JCheckBoxMenuItem jCheckBoxMenuItemIngles = null;

	private JCheckBoxMenuItem jCheckBoxMenuItemPortugues = null;

	private JMenu jMenuIdiomas = null;

	private JComboBox jComboBoxTipoDado = null;

	private JComboBox jComboBoxTipoSequencia = null;

	private JLabel jLabelModelo = null;

	private JSeparator jSeparatorS81 = null;

	private JSeparator jSeparatorS101 = null;

	private JSeparator jSeparatorS91 = null;

	private JSeparator jSeparatorS1011 = null;

	private JSeparator jSeparator101 = null;

	private JSeparator jSeparatorS92 = null;

	private JSeparator jSeparator111 = null;

	private JSeparator jSeparator102 = null;

	private JSeparator jSeparator121 = null;

	private JComboBox jComboBoxModelo = null;

	private JLabel jLabelFormato = null;

	private JSeparator jSeparatorS82 = null;

	private JSeparator jSeparatorS61 = null;

	private JSeparator jSeparatorS821 = null;

	private JSeparator jSeparatorS611 = null;

	private JSeparator jSeparator91 = null;

	private JSeparator jSeparator92 = null;

	private JSeparator jSeparator81 = null;

	private JSeparator jSeparator71 = null;

	private JSeparator jSeparator811 = null;

	private JComboBox jComboBoxFormato = null;

	private JLabel jLabelCategoriaSitios = null;

	private JSeparator jSeparatorS31 = null;

	private JSeparator jSeparatorS01 = null;

	private JSeparator jSeparatorS311 = null;

	private JSeparator jSeparator41 = null;

	private JSeparator jSeparator42 = null;

	private JSeparator jSeparator31 = null;

	private JSeparator jSeparator311 = null;

	private JSeparator jSeparator421 = null;

	private JSeparator jSeparator21 = null;

	private JTextField jTextFieldCategoriasSitios = null;

	private JButton jButtonCategoriasSitios = null;

	private JLabel jLabelSemente = null;

	private JNumberField jNumberFieldSemente = null;

	private JSeparator jSeparatorS83 = null;

	private JSeparator jSeparatorS102 = null;

	private JSeparator jSeparatorS831 = null;

	private JSeparator jSeparatorS1021 = null;

	private JSeparator jSeparator61 = null;

	private JSeparator jSeparator611 = null;

	private JSeparator jSeparator911 = null;

	private JSeparator jSeparator9111 = null;

	private JSeparator jSeparator6111 = null;

	private JLabel jLabelReplicas = null;

	private JSeparator jSeparatorS8311 = null;

	private JSeparator jSeparatorS832 = null;

	private JSeparator jSeparatorS1022 = null;

	private JSeparator jSeparatorS10211 = null;

	private JSeparator jSeparator612 = null;

	private JSeparator jSeparator613 = null;

	private JNumberField jNumberFieldReplicas = null;

	private JSeparator jSeparator91111 = null;

	private JSeparator jSeparator9112 = null;

	private JSeparator jSeparator61111 = null;

	private JCheckBox jCheckBoxEnzimas = null;

	private JLabel jLabelBloco = null;

	private JSeparator jSeparatorS833 = null;

	private JSeparator jSeparatorS1023 = null;

	private JSeparator jSeparatorS8331 = null;

	private JSeparator jSeparatorS10231 = null;

	private JSeparator jSeparator6112 = null;

	private JSeparator jSeparator61121 = null;

	private JSeparator jSeparator91112 = null;

	private JSeparator jSeparator911121 = null;

	private JSeparator jSeparator61122 = null;

	private JNumberField jNumberFieldBloco = null;

	private JLabel jLabelAmostras = null;

	private JSeparator jSeparatorS83311 = null;

	private JSeparator jSeparatorS10232 = null;

	private JSeparator jSeparatorS833111 = null;

	private JSeparator jSeparatorS102111 = null;

	private JSeparator jSeparator61123 = null;

	private JSeparator jSeparator611231 = null;

	private JSeparator jSeparator911122 = null;

	private JSeparator jSeparator9111221 = null;

	private JSeparator jSeparator611221 = null;

	private JNumberField jNumberFieldAmostras = null;

	private JPanel jPanelParametros = null;

	private JLabel jLabelPesos = null;

	private JSeparator jSeparator01 = null;

	private JSeparator jSeparator15 = null;

	private JSeparator jSeparator22 = null;

	private JSeparator jSeparator32 = null;

	private JSeparator jSeparator43 = null;

	private JButton jButtonPesos = null;

	private JTextField jTextFieldPesos = null;

	private JLabel jLabelFormatoSaida = null;

	private JSeparator jSeparator103 = null;

	private JSeparator jSeparator112 = null;

	private JSeparator jSeparator122 = null;

	private JSeparator jSeparator131 = null;

	private JSeparator jSeparator141 = null;

	private JSeparator jSeparatorS12 = null;

	private JSeparator jSeparatorS02 = null;

	private JSeparator jSeparatorS21 = null;

	private JSeparator jSeparatorS32 = null;

	private JSeparator jSeparatorS84 = null;

	private JSeparator jSeparatorS93 = null;

	private JSeparator jSeparatorS103 = null;

	private JSeparator jSeparatorS111 = null;

	private JComboBox jComboBoxFormatoSaida = null;

	private JLabel jLabelArquivoAncestral = null;

	private JSeparator jSeparatorS811 = null;

	private JSeparator jSeparatorS1012 = null;

	private JSeparator jSeparatorS911 = null;

	private JSeparator jSeparatorS10111 = null;

	private JSeparator jSeparator1011 = null;

	private JSeparator jSeparatorS921 = null;

	private JSeparator jSeparator1111 = null;

	private JSeparator jSeparator1021 = null;

	private JSeparator jSeparator1211 = null;

	private JLabel jLabelArquivoMisturado = null;

	private JSeparator jSeparatorS312 = null;

	private JSeparator jSeparatorS011 = null;

	private JSeparator jSeparatorS3111 = null;

	private JSeparator jSeparator411 = null;

	private JSeparator jSeparator422 = null;

	private JSeparator jSeparator312 = null;

	private JSeparator jSeparator3111 = null;

	private JSeparator jSeparator4211 = null;

	private JSeparator jSeparator211 = null;

	private JTextField jTextFieldArquivoMisturado = null;

	private JButton jButtonArquivoMisturado = null;

	private JLabel jLabelMultiplosArquivosSaida = null;

	private JSeparator jSeparatorS83111 = null;

	private JSeparator jSeparatorS8321 = null;

	private JSeparator jSeparatorS10221 = null;

	private JSeparator jSeparatorS102112 = null;

	private JSeparator jSeparator6121 = null;

	private JSeparator jSeparator6131 = null;

	private JSeparator jSeparator911111 = null;

	private JSeparator jSeparator91121 = null;

	private JSeparator jSeparator611111 = null;

	private JTextField jTextFieldArquivoAncestral = null;

	private JButton jButtonArquivoAncestral = null;

	private JPanel jPanelConsense = null;

	private JLabel jLabelArvore = null;

	private JSeparator jSeparator011 = null;

	private JSeparator jSeparator151 = null;

	private JSeparator jSeparator221 = null;

	private JSeparator jSeparator321 = null;

	private JSeparator jSeparator431 = null;

	private JButton jButtonArvore = null;

	private JTextField jTextFieldArvore = null;

	private JLabel jLabelAvaliacao = null;

	private JSeparator jSeparator1031 = null;

	private JSeparator jSeparator1121 = null;

	private JSeparator jSeparator1221 = null;

	private JSeparator jSeparator1311 = null;

	private JSeparator jSeparator1411 = null;

	private JSeparator jSeparatorS121 = null;

	private JSeparator jSeparatorS021 = null;

	private JSeparator jSeparatorS211 = null;

	private JSeparator jSeparatorS321 = null;

	private JSeparator jSeparatorS841 = null;

	private JSeparator jSeparatorS931 = null;

	private JSeparator jSeparatorS1031 = null;

	private JSeparator jSeparatorS1111 = null;

	private JComboBox jComboBoxAvaliacao = null;

	private JLabel jLabelMaiorAncestral = null;

	private JSeparator jSeparatorS8111 = null;

	private JSeparator jSeparatorS10121 = null;

	private JSeparator jSeparatorS9111 = null;

	private JSeparator jSeparatorS101111 = null;

	private JSeparator jSeparator10111 = null;

	private JSeparator jSeparatorS9211 = null;

	private JSeparator jSeparator11111 = null;

	private JSeparator jSeparator10211 = null;

	private JSeparator jSeparator12111 = null;

	private JLabel jLabelRaiz = null;

	private JSeparator jSeparatorS3121 = null;

	private JSeparator jSeparatorS0111 = null;

	private JSeparator jSeparatorS31111 = null;

	private JSeparator jSeparator4111 = null;

	private JSeparator jSeparator4221 = null;

	private JSeparator jSeparator3121 = null;

	private JSeparator jSeparator31111 = null;

	private JSeparator jSeparator42111 = null;

	private JSeparator jSeparator2111 = null;

	private JLabel jLabelEspeciesArquivoSaida = null;

	private JSeparator jSeparatorS8341 = null;

	private JSeparator jSeparatorS10241 = null;

	private JSeparator jSeparatorS83121 = null;

	private JSeparator jSeparatorS102121 = null;

	private JSeparator jSeparator6141 = null;

	private JSeparator jSeparator61131 = null;

	private JSeparator jSeparator91131 = null;

	private JSeparator jSeparator911131 = null;

	private JSeparator jSeparator611121 = null;

	private JLabel jLabelExecucao = null;

	private JSeparator jSeparatorS831111 = null;

	private JSeparator jSeparatorS83211 = null;

	private JSeparator jSeparatorS102211 = null;

	private JSeparator jSeparatorS1021121 = null;

	private JSeparator jSeparator61211 = null;

	private JSeparator jSeparator61311 = null;

	private JSeparator jSeparator9111111 = null;

	private JSeparator jSeparator911211 = null;

	private JSeparator jSeparator6111111 = null;

	private JLabel jLabelArvoreArquivoSaida = null;

	private JSeparator jSeparatorS83321 = null;

	private JSeparator jSeparatorS102331 = null;

	private JSeparator jSeparatorS833121 = null;

	private JSeparator jSeparatorS1023111 = null;

	private JSeparator jSeparator611241 = null;

	private JSeparator jSeparator6112111 = null;

	private JSeparator jSeparator9111231 = null;

	private JSeparator jSeparator91112111 = null;

	private JSeparator jSeparator6112221 = null;

	private JLabel jLabelFracaoTempo = null;

	private JSeparator jSeparatorS8331121 = null;

	private JSeparator jSeparatorS1023211 = null;

	private JSeparator jSeparatorS83311111 = null;

	private JSeparator jSeparatorS10211111 = null;

	private JSeparator jSeparator6112321 = null;

	private JSeparator jSeparator61123111 = null;

	private JSeparator jSeparator91112221 = null;

	private JSeparator jSeparator911122111 = null;

	private JSeparator jSeparator61122111 = null;

	private JCheckBox jCheckBoxArvoreArquivoSaidaDesenhar = null;

	private JCheckBox jCheckBoxEspeciesArquivoSaidaIndicar = null;

	private JRadioButton jRadioButtonRaizSim = null;

	private JRadioButton jRadioButtonRaizNao = null;

	private JNumberField jNumberFieldMaiorAncestral = null;

	private JCheckBox jCheckBoxExecucaoIndicar = null;

	private JNumberFloatField jNumberFieldFracaoTempo = null;

	private JSeparator jSeparator911124 = null;

	private JSeparator jSeparator611223 = null;

	private JSeparator jSeparator611224 = null;

	private JSeparator jSeparator9111241 = null;

	private JCheckBox jCheckBoxMultiplosArquivosSaidaPesos = null;

	private JLabel jLabelPorcento = null;

	private JCheckBox jCheckBoxFracaoTempoUsar = null;

	private JCheckBox jCheckBoxMultiplosArquivosSaidaDados = null;

	private JTabbedPane jTabbedPaneSeqboot = null;



	/**
	 * Este metodo inicializa o jTabbedPaneGeral
	 *
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPaneGeral() {
		if (jTabbedPaneGeral == null) {
			jTabbedPaneGeral = new JTabbedPane();
			jTabbedPaneGeral.setLocation(new Point(33, 10));
			jTabbedPaneGeral.setSize(625, 409);
			jTabbedPaneGeral.setBackground(new Color(192, 209, 226));
			jTabbedPaneGeral.addTab("Seqboot", null, getJTabbedPaneSeqboot(), null);
			jTabbedPaneGeral.addTab("Consense", null, getJPanelConsense(), null);
		}
		return jTabbedPaneGeral;
	}


	/**
	 * This method initializes jTabbedPaneSeqboot
	 *
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPaneSeqboot() {
		if (jTabbedPaneSeqboot == null) {
			jTabbedPaneSeqboot = new JTabbedPane();
			jTabbedPaneSeqboot.addTab("Seqüência", new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/anotacao.png")), getJPanelSequencia(), null);
			jTabbedPaneSeqboot.addTab("Parâmetros", new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/aa.png")), getJPanelParametros(), null);
		}
		return jTabbedPaneSeqboot;
	}



	/**
	 * This method initializes jPanelSequencia
	 * O qual da origem a aba "Sequencia"
     * Este jPanelSequencia eh adicionado a jTabbedPaneGeral no metodo getJTabbedPaneGeral()
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelSequencia() {
		if (jPanelSequencia == null) {
			jLabelPorcento = new JLabel();
			jLabelPorcento.setText("%");
			jLabelPorcento.setLocation(new Point(587, 295));
			jLabelPorcento.setSize(new Dimension(17, 15));
			jLabelAmostras = new JLabel();
			jLabelAmostras.setText("Amostras");
			jLabelAmostras.setSize(new Dimension(81, 15));
			jLabelAmostras.setLocation(new Point(430, 294));
			jLabelAmostras.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelBloco = new JLabel();
			jLabelBloco.setText("Bloco");
			jLabelBloco.setSize(new Dimension(46, 15));
			jLabelBloco.setLocation(new Point(225, 294));
			jLabelBloco.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelReplicas = new JLabel();
			jLabelReplicas.setText("Réplicas");
			jLabelReplicas.setSize(new Dimension(78, 15));
			jLabelReplicas.setLocation(new Point(430, 216));
			jLabelReplicas.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelSemente = new JLabel();
			jLabelSemente.setText("Semente");
			jLabelSemente.setSize(new Dimension(61, 15));
			jLabelSemente.setLocation(new Point(225, 216));
			jLabelSemente.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelCategoriaSitios = new JLabel();
			jLabelCategoriaSitios.setText("Categorias de sítios");
			jLabelCategoriaSitios.setSize(new Dimension(140, 15));
			jLabelCategoriaSitios.setLocation(new Point(400, 31));
			jLabelCategoriaSitios.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelFormato = new JLabel();
			jLabelFormato.setBounds(new Rectangle(58, 188, 64, 15));
			jLabelFormato.setText("Formato");
			jLabelFormato.setFont(new Font("Arial", Font.BOLD, 12));
                        jLabelFormato.setEnabled(false);
			jLabelModelo = new JLabel();
			jLabelModelo.setText("Modelo");
			jLabelModelo.setSize(new Dimension(57, 15));
			jLabelModelo.setLocation(new Point(490, 108));
			jLabelModelo.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelTipoSequencia = new JLabel();
			jLabelTipoSequencia.setText("Tipo de seqüência");
			jLabelTipoSequencia.setSize(new Dimension(122, 15));
			jLabelTipoSequencia.setLocation(new Point(240, 108));
			jLabelTipoSequencia.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelTipoDado = new JLabel();
			jLabelTipoDado.setText("Tipo de dado");
			jLabelTipoDado.setSize(new Dimension(93, 15));
			jLabelTipoDado.setLocation(new Point(55, 106));
			jLabelTipoDado.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoSequencia = new JLabel();
			jLabelArquivoSequencia.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoSequencia.setSize(new Dimension(78, 16));
			jLabelArquivoSequencia.setLocation(new Point(89, 31));
			jLabelArquivoSequencia.setText("Seqüência");
			jPanelSequencia = new JPanel();
			jPanelSequencia.setLayout(null);
			jPanelSequencia.setBackground(new Color(173, 200, 226));
			jPanelSequencia.add(jLabelArquivoSequencia, null);
			jPanelSequencia.add(getJSeparator0(), null);
			jPanelSequencia.add(getJSeparator1(), null);
			jPanelSequencia.add(getJSeparator2(), null);
			jPanelSequencia.add(getJSeparator3(), null);
			jPanelSequencia.add(getJSeparator4(), null);
			jPanelSequencia.add(getJButtonArquivoSequencia(), null);
			jPanelSequencia.add(jLabelTipoDado, null);
			jPanelSequencia.add(getJSeparator5(), null);
			jPanelSequencia.add(getJSeparator6(), null);
			jPanelSequencia.add(getJSeparator7(), null);
			jPanelSequencia.add(getJSeparator8(), null);
			jPanelSequencia.add(getJSeparator9(), null);
			jPanelSequencia.add(getJTextFieldArquivoSequencia(), null);
			jPanelSequencia.add(jLabelTipoSequencia, null);
			jPanelSequencia.add(getJSeparator10(), null);
			jPanelSequencia.add(getJSeparator11(), null);
			jPanelSequencia.add(getJSeparator12(), null);
			jPanelSequencia.add(getJSeparator13(), null);
			jPanelSequencia.add(getJSeparator14(), null);
			jPanelSequencia.add(getJSeparatorS1(), null);
			jPanelSequencia.add(getJSeparatorS0(), null);
			jPanelSequencia.add(getJSeparatorS2(), null);
			jPanelSequencia.add(getJSeparatorS3(), null);
			jPanelSequencia.add(getJSeparatorS4(), null);
			jPanelSequencia.add(getJSeparatorS5(), null);
			jPanelSequencia.add(getJSeparatorS6(), null);
			jPanelSequencia.add(getJSeparatorS7(), null);
			jPanelSequencia.add(getJSeparatorS8(), null);
			jPanelSequencia.add(getJSeparatorS9(), null);
			jPanelSequencia.add(getJSeparatorS10(), null);
			jPanelSequencia.add(getJSeparatorS11(), null);
			jPanelSequencia.add(getJComboBoxTipoDado(), null);
			jPanelSequencia.add(getJComboBoxTipoSequencia(), null);
			jPanelSequencia.add(jLabelModelo, null);
			jPanelSequencia.add(getJSeparatorS81(), null);
			jPanelSequencia.add(getJSeparatorS101(), null);
			jPanelSequencia.add(getJSeparatorS91(), null);
			jPanelSequencia.add(getJSeparatorS1011(), null);
			jPanelSequencia.add(getJSeparator101(), null);
			jPanelSequencia.add(getJSeparatorS92(), null);
			jPanelSequencia.add(getJSeparator111(), null);
			jPanelSequencia.add(getJSeparator102(), null);
			jPanelSequencia.add(getJSeparator121(), null);
			jPanelSequencia.add(getJComboBoxModelo(), null);
			jPanelSequencia.add(jLabelFormato, null);
			jPanelSequencia.add(getJSeparatorS82(), null);
			jPanelSequencia.add(getJSeparatorS61(), null);
			jPanelSequencia.add(getJSeparatorS821(), null);
			jPanelSequencia.add(getJSeparatorS611(), null);
			jPanelSequencia.add(getJSeparator91(), null);
			jPanelSequencia.add(getJSeparator92(), null);
			jPanelSequencia.add(getJSeparator81(), null);
			jPanelSequencia.add(getJSeparator71(), null);
			jPanelSequencia.add(getJSeparator811(), null);
			jPanelSequencia.add(getJComboBoxFormato(), null);
			jPanelSequencia.add(jLabelCategoriaSitios, null);
			jPanelSequencia.add(getJSeparatorS31(), null);
			jPanelSequencia.add(getJSeparatorS01(), null);
			jPanelSequencia.add(getJSeparatorS311(), null);
			jPanelSequencia.add(getJSeparator41(), null);
			jPanelSequencia.add(getJSeparator42(), null);
			jPanelSequencia.add(getJSeparator31(), null);
			jPanelSequencia.add(getJSeparator311(), null);
			jPanelSequencia.add(getJSeparator421(), null);
			jPanelSequencia.add(getJSeparator21(), null);
			jPanelSequencia.add(getJTextFieldCategoriasSitios(), null);
			jPanelSequencia.add(getJButtonCategoriasSitios(), null);
			jPanelSequencia.add(jLabelSemente, null);
			jPanelSequencia.add(getJNumberFieldSemente(), null);
			jPanelSequencia.add(getJSeparatorS83(), null);
			jPanelSequencia.add(getJSeparatorS102(), null);
			jPanelSequencia.add(getJSeparatorS831(), null);
			jPanelSequencia.add(getJSeparatorS1021(), null);
			jPanelSequencia.add(getJSeparator61(), null);
			jPanelSequencia.add(getJSeparator611(), null);
			jPanelSequencia.add(getJSeparator911(), null);
			jPanelSequencia.add(getJSeparator9111(), null);
			jPanelSequencia.add(getJSeparator6111(), null);
			jPanelSequencia.add(jLabelReplicas, null);
			jPanelSequencia.add(getJSeparatorS8311(), null);
			jPanelSequencia.add(getJSeparatorS832(), null);
			jPanelSequencia.add(getJSeparatorS1022(), null);
			jPanelSequencia.add(getJSeparatorS10211(), null);
			jPanelSequencia.add(getJSeparator612(), null);
			jPanelSequencia.add(getJSeparator613(), null);
			jPanelSequencia.add(getJNumberFieldReplicas(), null);
			jPanelSequencia.add(getJSeparator91111(), null);
			jPanelSequencia.add(getJSeparator9112(), null);
			jPanelSequencia.add(getJSeparator61111(), null);
			jPanelSequencia.add(getJCheckBoxEnzimas(), null);
			jPanelSequencia.add(jLabelBloco, null);
			jPanelSequencia.add(getJSeparatorS833(), null);
			jPanelSequencia.add(getJSeparatorS1023(), null);
			jPanelSequencia.add(getJSeparatorS8331(), null);
			jPanelSequencia.add(getJSeparatorS10231(), null);
			jPanelSequencia.add(getJSeparator6112(), null);
			jPanelSequencia.add(getJSeparator61121(), null);
			jPanelSequencia.add(getJSeparator91112(), null);
			jPanelSequencia.add(getJSeparator911121(), null);
			jPanelSequencia.add(getJSeparator61122(), null);
			jPanelSequencia.add(getJNumberFieldBloco(), null);
			jPanelSequencia.add(jLabelAmostras, null);
			jPanelSequencia.add(getJSeparatorS83311(), null);
			jPanelSequencia.add(getJSeparatorS10232(), null);
			jPanelSequencia.add(getJSeparatorS833111(), null);
			jPanelSequencia.add(getJSeparatorS102111(), null);
			jPanelSequencia.add(getJSeparator61123(), null);
			jPanelSequencia.add(getJSeparator611231(), null);
			jPanelSequencia.add(getJSeparator911122(), null);
			jPanelSequencia.add(getJSeparator9111221(), null);
			jPanelSequencia.add(getJSeparator611221(), null);
			jPanelSequencia.add(getJNumberFieldAmostras(), null);
			jPanelSequencia.add(getJSeparator911124(), null);
			jPanelSequencia.add(getJSeparator611223(), null);
			jPanelSequencia.add(getJSeparator611224(), null);
			jPanelSequencia.add(getJSeparator9111241(), null);
			jPanelSequencia.add(jLabelPorcento, null);
		}
		return jPanelSequencia;
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
			jJMenuBar.add(getJMenuConfiguracoes());
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
			jMenuArquivo.add(getJMenuItemFechar());
		}
		return jMenuArquivo;
	}

	/**
	 * This method initializes jSeparator0
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator0() {
		if (jSeparator0 == null) {
			jSeparator0 = new JSeparator();
			jSeparator0.setLocation(new Point(14, 38));
			jSeparator0.setSize(new Dimension(72, 10));
		}
		return jSeparator0;
	}

	/**
	 * This method initializes jSeparator1
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1() {
		if (jSeparator1 == null) {
			jSeparator1 = new JSeparator();
			jSeparator1.setOrientation(SwingConstants.VERTICAL);
			jSeparator1.setLocation(new Point(13, 38));
			jSeparator1.setSize(new Dimension(10, 51));
		}
		return jSeparator1;
	}

	/**
	 * This method initializes jSeparator2
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator2() {
		if (jSeparator2 == null) {
			jSeparator2 = new JSeparator();
			jSeparator2.setLocation(new Point(13, 89));
			jSeparator2.setSize(new Dimension(295, 10));
		}
		return jSeparator2;
	}

	/**
	 * This method initializes jSeparator3
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator3() {
		if (jSeparator3 == null) {
			jSeparator3 = new JSeparator();
			jSeparator3.setOrientation(SwingConstants.VERTICAL);
			jSeparator3.setSize(new Dimension(10, 51));
			jSeparator3.setLocation(new Point(308, 39));
		}
		return jSeparator3;
	}

	/**
	 * This method initializes jSeparator4
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator4() {
		if (jSeparator4 == null) {
			jSeparator4 = new JSeparator();
			jSeparator4.setLocation(new Point(172, 38));
			jSeparator4.setSize(new Dimension(137, 10));
		}
		return jSeparator4;
	}

	/**
	 * Este metodo inicializa o jButtonArquivoSequencia
	 * O qual da origem ao botao onde o usuario
     * escolhe o nome da sequencia a ser passada para o phyml
     *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonArquivoSequencia() {
		if (jButtonArquivoSequencia == null) {
			jButtonArquivoSequencia = new JButton();
			jButtonArquivoSequencia.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonArquivoSequencia.setLocation(new Point(245, 55));
			jButtonArquivoSequencia.setBackground(new Color(173, 200, 226));
			jButtonArquivoSequencia.setSize(new Dimension(31, 28));
			jButtonArquivoSequencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jButtonArquivoSequencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonArquivoSequencia;
	}

	/**
	 * This method initializes jSeparator5
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator5() {
		if (jSeparator5 == null) {
			jSeparator5 = new JSeparator();
			jSeparator5.setLocation(new Point(150, 114));
			jSeparator5.setSize(new Dimension(43, 10));
		}
		return jSeparator5;
	}

	/**
	 * This method initializes jSeparator6
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6() {
		if (jSeparator6 == null) {
			jSeparator6 = new JSeparator();
			jSeparator6.setOrientation(SwingConstants.VERTICAL);
			jSeparator6.setSize(new Dimension(10, 51));
			jSeparator6.setLocation(new Point(193, 115));
		}
		return jSeparator6;
	}

	/**
	 * This method initializes jSeparator7
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator7() {
		if (jSeparator7 == null) {
			jSeparator7 = new JSeparator();
			jSeparator7.setSize(new Dimension(178, 10));
			jSeparator7.setLocation(new Point(16, 165));
		}
		return jSeparator7;
	}

	/**
	 * This method initializes jSeparator8
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator8() {
		if (jSeparator8 == null) {
			jSeparator8 = new JSeparator();
			jSeparator8.setOrientation(SwingConstants.VERTICAL);
			jSeparator8.setSize(new Dimension(10, 50));
			jSeparator8.setLocation(new Point(14, 115));
		}
		return jSeparator8;
	}

	/**
	 * This method initializes jSeparator9
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9() {
		if (jSeparator9 == null) {
			jSeparator9 = new JSeparator();
			jSeparator9.setLocation(new Point(14, 114));
			jSeparator9.setSize(new Dimension(39, 10));
		}
		return jSeparator9;
	}

	/**
	 * This method initializes jTextFieldArquivoSequencia
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldArquivoSequencia() {
		if (jTextFieldArquivoSequencia == null) {
			jTextFieldArquivoSequencia = new JTextField();
			jTextFieldArquivoSequencia.setSize(new Dimension(200, 20));
			jTextFieldArquivoSequencia.setEditable(false);
			jTextFieldArquivoSequencia.setLocation(new Point(36, 58));
		}
		return jTextFieldArquivoSequencia;
	}

	/**
	 * This method initializes jSeparator10
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator10() {
		if (jSeparator10 == null) {
			jSeparator10 = new JSeparator();
			jSeparator10.setLocation(new Point(366, 115));
			jSeparator10.setSize(new Dimension(34, 10));
		}
		return jSeparator10;
	}

	/**
	 * This method initializes jSeparator11
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator11() {
		if (jSeparator11 == null) {
			jSeparator11 = new JSeparator();
			jSeparator11.setOrientation(SwingConstants.VERTICAL);
			jSeparator11.setSize(new Dimension(10, 50));
			jSeparator11.setLocation(new Point(400, 116));
		}
		return jSeparator11;
	}

	/**
	 * This method initializes jSeparator12
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator12() {
		if (jSeparator12 == null) {
			jSeparator12 = new JSeparator();
			jSeparator12.setBounds(new Rectangle(217, 165, 182, 10));
		}
		return jSeparator12;
	}

	/**
	 * This method initializes jSeparator13
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator13() {
		if (jSeparator13 == null) {
			jSeparator13 = new JSeparator();
			jSeparator13.setOrientation(SwingConstants.VERTICAL);
			jSeparator13.setSize(new Dimension(10, 51));
			jSeparator13.setLocation(new Point(216, 115));
		}
		return jSeparator13;
	}

	/**
	 * This method initializes jSeparator14
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator14() {
		if (jSeparator14 == null) {
			jSeparator14 = new JSeparator();
			jSeparator14.setLocation(new Point(216, 114));
			jSeparator14.setSize(new Dimension(21, 10));
		}
		return jSeparator14;
	}

	/**
	 * This method initializes jSeparatorS1
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1() {
		if (jSeparatorS1 == null) {
			jSeparatorS1 = new JSeparator();
			jSeparatorS1.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS1.setSize(new Dimension(10, 22));
			jSeparatorS1.setLocation(new Point(86, 28));
		}
		return jSeparatorS1;
	}

	/**
	 * This method initializes jSeparatorS0
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS0() {
		if (jSeparatorS0 == null) {
			jSeparatorS0 = new JSeparator();
			jSeparatorS0.setSize(new Dimension(84, 10));
			jSeparatorS0.setLocation(new Point(87, 27));
		}
		return jSeparatorS0;
	}

	/**
	 * This method initializes jSeparatorS2
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS2() {
		if (jSeparatorS2 == null) {
			jSeparatorS2 = new JSeparator();
			jSeparatorS2.setLocation(new Point(86, 50));
			jSeparatorS2.setSize(new Dimension(85, 10));
		}
		return jSeparatorS2;
	}

	/**
	 * This method initializes jSeparatorS3
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS3() {
		if (jSeparatorS3 == null) {
			jSeparatorS3 = new JSeparator();
			jSeparatorS3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS3.setSize(new Dimension(10, 22));
			jSeparatorS3.setLocation(new Point(171, 28));
		}
		return jSeparatorS3;
	}

	/**
	 * This method initializes jSeparatorS4
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS4() {
		if (jSeparatorS4 == null) {
			jSeparatorS4 = new JSeparator();
			jSeparatorS4.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS4.setSize(new Dimension(10, 22));
			jSeparatorS4.setLocation(new Point(52, 103));
		}
		return jSeparatorS4;
	}

	/**
	 * This method initializes jSeparatorS5
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS5() {
		if (jSeparatorS5 == null) {
			jSeparatorS5 = new JSeparator();
			jSeparatorS5.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS5.setLocation(new Point(149, 103));
			jSeparatorS5.setSize(new Dimension(10, 22));
		}
		return jSeparatorS5;
	}

	/**
	 * This method initializes jSeparatorS6
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS6() {
		if (jSeparatorS6 == null) {
			jSeparatorS6 = new JSeparator();
			jSeparatorS6.setBounds(new Rectangle(52, 102, 98, 10));
		}
		return jSeparatorS6;
	}

	/**
	 * This method initializes jSeparatorS7
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS7() {
		if (jSeparatorS7 == null) {
			jSeparatorS7 = new JSeparator();
			jSeparatorS7.setBounds(new Rectangle(52, 125, 98, 10));
		}
		return jSeparatorS7;
	}

	/**
	 * This method initializes jSeparatorS8
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8() {
		if (jSeparatorS8 == null) {
			jSeparatorS8 = new JSeparator();
			jSeparatorS8.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8.setSize(new Dimension(10, 22));
			jSeparatorS8.setLocation(new Point(237, 103));
		}
		return jSeparatorS8;
	}

	/**
	 * This method initializes jSeparatorS9
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS9() {
		if (jSeparatorS9 == null) {
			jSeparatorS9 = new JSeparator();
			jSeparatorS9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS9.setSize(new Dimension(10, 22));
			jSeparatorS9.setLocation(new Point(365, 103));
		}
		return jSeparatorS9;
	}

	/**
	 * This method initializes jSeparatorS10
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10() {
		if (jSeparatorS10 == null) {
			jSeparatorS10 = new JSeparator();
			jSeparatorS10.setSize(new Dimension(128, 10));
			jSeparatorS10.setLocation(new Point(238, 102));
		}
		return jSeparatorS10;
	}

	/**
	 * This method initializes jSeparatorS11
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS11() {
		if (jSeparatorS11 == null) {
			jSeparatorS11 = new JSeparator();
			jSeparatorS11.setLocation(new Point(238, 125));
			jSeparatorS11.setSize(new Dimension(128, 10));
		}
		return jSeparatorS11;
	}

	/**
	 * Este metodo inicializa o jButtonAvancar
	 *
	 * O qual da origem ao botao "Avancar"
     * Este botao faz com que seja verificada todas as escolhas feitas pelo usuario,
     * caso sejao validas o phyml sera executado recebendo os parametros informados pelo usuario.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAvancar() {
		if (jButtonAvancar == null) {
			jButtonAvancar = new JButton();
			jButtonAvancar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/avancar.png")));
			jButtonAvancar.setFont(new Font("Arial", Font.BOLD, 10));
			jButtonAvancar.setSize(new Dimension(117, 25));
			jButtonAvancar.setLocation(new Point(663, 70));
			jButtonAvancar.setActionCommand("Avancar");
			jButtonAvancar.setText("Avançar");
			jButtonAvancar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonAvancar;
	}

	/**
	 * Este metodo inicializa o jButtonVoltar
	 *
	 * O qual da origem ao botao "voltar"
     * Este botao faz com que o frame phyml seja fechado e seja aberto novamente o frame anterior
     * Voltando assim para a tela anterior caso o usuario queira fazer alguma modificacao em suas escolhas
     *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonVoltar() {
		if (jButtonVoltar == null) {
			jButtonVoltar = new JButton();
			jButtonVoltar.setText("Voltar");
			jButtonVoltar.setSize(new Dimension(117, 25));
			jButtonVoltar.setLocation(new Point(663, 120));
			jButtonVoltar.setFont(new Font("Arial", Font.BOLD, 10));
			jButtonVoltar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png")));
			jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonVoltar;
	}

	/**
	 * Este metodo inicializa o jButtonEditor
	 *
     * Este botao e utilizado para abrir o Editos de texto da IGRAFU.
     * Este editor pode ser utilizado tanto para visualizar os arquivos gerados pela execucao
     * quanto para gerar arquivos texto.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonEditor() {
		if (jButtonEditor == null) {
			jButtonEditor = new JButton();
			jButtonEditor.setText("Editor");
			jButtonEditor.setSize(new Dimension(117, 25));
			jButtonEditor.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/filoEditor.png")));
			jButtonEditor.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonEditor.setLocation(new Point(663, 340));
			jButtonEditor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonEditor;
	}

	/**
	 * This method initializes jMenuItemFechar
	 *
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJMenuItemFechar() {
		if (jMenuItemFechar == null) {
			jMenuItemFechar = new JMenuItem();
			jMenuItemFechar.setText("Sair");
			jMenuItemFechar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/fechar.gif")));
			jMenuItemFechar.setActionCommand("Sair");
		}
		return jMenuItemFechar;
	}

	/**
	 * This is the default constructor
	 */
	public Seqboot() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	public void initialize() {
		this.setSize(790, 470);
		this.setBackground(new Color(173, 200, 226));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/IGrafuAF.png")));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("IGrafu: Bootstrap");

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( ( dimension.width - getSize().width )/2, ( dimension.height - getSize().height )/2 );

		this.setVisible(true);
		this.setResizable(false);
                
		this.repaint();
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(230, 234, 240));
			jContentPane.add(getJTabbedPaneGeral(), null);
			jContentPane.add(getJButtonAvancar(), null);
			jContentPane.add(getJButtonVoltar(), null);
			jContentPane.add(getJButtonEditor(), null);
		}
		return jContentPane;
	}

	public ImageIcon getImagemDNA() {
		return imagemDNA;
	}

	public void setImagemDNA(ImageIcon imagemDNA) {
		this.imagemDNA = imagemDNA;
	}

	public ImageIcon getImagemAA() {
		return imagemAA;
	}

	public void setImagemAA(ImageIcon imagemAA) {
		this.imagemAA = imagemAA;
	}

	/**
	 * This method initializes jMenuConfiguracoes
	 *
	 * @return javax.swing.JMenu
	 */
	public JMenu getJMenuConfiguracoes() {
		if (jMenuConfiguracoes == null) {
			jMenuConfiguracoes = new JMenu();
			jMenuConfiguracoes.setText("Configurações");
			jMenuConfiguracoes.add(getJMenuIdiomas());
		}
		return jMenuConfiguracoes;
	}

	/**
	 * This method initializes jCheckBoxMenuItemIngles
	 *
	 * @return javax.swing.JCheckBoxMenuItem
	 */
	public JCheckBoxMenuItem getJCheckBoxMenuItemIngles() {
		if (jCheckBoxMenuItemIngles == null) {
			jCheckBoxMenuItemIngles = new JCheckBoxMenuItem();
			jCheckBoxMenuItemIngles.setText("Inglês");
		}
		return jCheckBoxMenuItemIngles;
	}

	/**
	 * This method initializes jCheckBoxMenuItemPortugues
	 *
	 * @return javax.swing.JCheckBoxMenuItem
	 */
	public JCheckBoxMenuItem getJCheckBoxMenuItemPortugues() {
		if (jCheckBoxMenuItemPortugues == null) {
			jCheckBoxMenuItemPortugues = new JCheckBoxMenuItem();
			jCheckBoxMenuItemPortugues.setText("Português");
		}
		return jCheckBoxMenuItemPortugues;
	}

	/**
	 * This method initializes jMenuIdiomas
	 *
	 * @return javax.swing.JMenu
	 */
	public JMenu getJMenuIdiomas() {
		if (jMenuIdiomas == null) {
			jMenuIdiomas = new JMenu();
			jMenuIdiomas.setText("Idiomas");
			jMenuIdiomas.add(getJCheckBoxMenuItemPortugues());
			jMenuIdiomas.add(getJCheckBoxMenuItemIngles());
		}
		return jMenuIdiomas;
	}

	public JLabel getJLabelArquivoSequencia() {
		return jLabelArquivoSequencia;
	}

	public JLabel getJLabelTipoSequencia() {
		return jLabelTipoSequencia;
	}

	public JLabel getJLabelTipoDado() {
		return jLabelTipoDado;
	}

	/**
	 * This method initializes jComboBoxTipoDado
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxTipoDado() {
		if (jComboBoxTipoDado == null) {
			jComboBoxTipoDado = new JComboBox();
			jComboBoxTipoDado.setBounds(new Rectangle(40, 135, 131, 24));
			jComboBoxTipoDado.addItem("DNA");
			jComboBoxTipoDado.addItem("RNA");
			jComboBoxTipoDado.addItem("Proteína");
			jComboBoxTipoDado.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jComboBoxTipoDado;
	}

	/**
	 * This method initializes jComboBoxTipoSequencia
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxTipoSequencia() {
		if (jComboBoxTipoSequencia == null) {
			jComboBoxTipoSequencia = new JComboBox();
			jComboBoxTipoSequencia.setSize(new Dimension(164, 24));
			jComboBoxTipoSequencia.setLocation(new Point(226, 135));
			jComboBoxTipoSequencia.addItem("Sequencia Molecular");
			jComboBoxTipoSequencia.addItem("Morfologia Discreta");
			jComboBoxTipoSequencia.addItem("Restrição de Sítios");
			jComboBoxTipoSequencia.addItem("Freqüência de Genes");
			jComboBoxTipoSequencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jComboBoxTipoSequencia;
	}

	/**
	 * This method initializes jSeparatorS81
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS81() {
		if (jSeparatorS81 == null) {
			jSeparatorS81 = new JSeparator();
			jSeparatorS81.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS81.setLocation(new Point(485, 103));
			jSeparatorS81.setSize(new Dimension(10, 22));
		}
		return jSeparatorS81;
	}

	/**
	 * This method initializes jSeparatorS101
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS101() {
		if (jSeparatorS101 == null) {
			jSeparatorS101 = new JSeparator();
			jSeparatorS101.setSize(new Dimension(66, 10));
			jSeparatorS101.setLocation(new Point(486, 102));
		}
		return jSeparatorS101;
	}

	/**
	 * This method initializes jSeparatorS91
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS91() {
		if (jSeparatorS91 == null) {
			jSeparatorS91 = new JSeparator();
			jSeparatorS91.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS91.setSize(new Dimension(10, 22));
			jSeparatorS91.setLocation(new Point(552, 104));
		}
		return jSeparatorS91;
	}

	/**
	 * This method initializes jSeparatorS1011
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1011() {
		if (jSeparatorS1011 == null) {
			jSeparatorS1011 = new JSeparator();
			jSeparatorS1011.setSize(new Dimension(67, 10));
			jSeparatorS1011.setLocation(new Point(486, 125));
		}
		return jSeparatorS1011;
	}

	/**
	 * This method initializes jSeparator101
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator101() {
		if (jSeparator101 == null) {
			jSeparator101 = new JSeparator();
			jSeparator101.setSize(new Dimension(57, 10));
			jSeparator101.setLocation(new Point(553, 115));
		}
		return jSeparator101;
	}

	/**
	 * This method initializes jSeparatorS92
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS92() {
		if (jSeparatorS92 == null) {
			jSeparatorS92 = new JSeparator();
			jSeparatorS92.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS92.setSize(new Dimension(10, 50));
			jSeparatorS92.setLocation(new Point(610, 116));
		}
		return jSeparatorS92;
	}

	/**
	 * This method initializes jSeparator111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator111() {
		if (jSeparator111 == null) {
			jSeparator111 = new JSeparator();
			jSeparator111.setOrientation(SwingConstants.VERTICAL);
			jSeparator111.setSize(new Dimension(10, 51));
			jSeparator111.setLocation(new Point(422, 116));
		}
		return jSeparator111;
	}

	/**
	 * This method initializes jSeparator102
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator102() {
		if (jSeparator102 == null) {
			jSeparator102 = new JSeparator();
			jSeparator102.setSize(new Dimension(63, 15));
			jSeparator102.setLocation(new Point(423, 115));
		}
		return jSeparator102;
	}

	/**
	 * This method initializes jSeparator121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator121() {
		if (jSeparator121 == null) {
			jSeparator121 = new JSeparator();
			jSeparator121.setSize(new Dimension(188, 10));
			jSeparator121.setLocation(new Point(422, 165));
		}
		return jSeparator121;
	}

	/**
	 * This method initializes jComboBoxModelo
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxModelo() {
		if (jComboBoxModelo == null) {
			jComboBoxModelo = new JComboBox();
			jComboBoxModelo.setBounds(new Rectangle(430, 135, 171, 24));
			jComboBoxModelo.addItem("Bootstrap");
			jComboBoxModelo.addItem("Jackknife");
			jComboBoxModelo.addItem("Permute Character");
			jComboBoxModelo.addItem("Permute Character Order");
			jComboBoxModelo.addItem("Permute Whith Species");
			jComboBoxModelo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jComboBoxModelo;
	}

	/**
	 * This method initializes jSeparatorS82
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS82() {
		if (jSeparatorS82 == null) {
			jSeparatorS82 = new JSeparator();
			jSeparatorS82.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS82.setSize(new Dimension(10, 22));
			jSeparatorS82.setLocation(new Point(54, 185));
		}
		return jSeparatorS82;
	}

	/**
	 * This method initializes jSeparatorS61
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS61() {
		if (jSeparatorS61 == null) {
			jSeparatorS61 = new JSeparator();
			jSeparatorS61.setSize(new Dimension(70, 10));
			jSeparatorS61.setLocation(new Point(54, 184));
		}
		return jSeparatorS61;
	}

	/**
	 * This method initializes jSeparatorS821
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS821() {
		if (jSeparatorS821 == null) {
			jSeparatorS821 = new JSeparator();
			jSeparatorS821.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS821.setSize(new Dimension(10, 22));
			jSeparatorS821.setLocation(new Point(124, 185));
		}
		return jSeparatorS821;
	}

	/**
	 * This method initializes jSeparatorS611
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS611() {
		if (jSeparatorS611 == null) {
			jSeparatorS611 = new JSeparator();
			jSeparatorS611.setBounds(new Rectangle(54, 207, 71, 10));
		}
		return jSeparatorS611;
	}

	/**
	 * This method initializes jSeparator91
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91() {
		if (jSeparator91 == null) {
			jSeparator91 = new JSeparator();
			jSeparator91.setBounds(new Rectangle(125, 196, 69, 10));
		}
		return jSeparator91;
	}

	/**
	 * This method initializes jSeparator92
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator92() {
		if (jSeparator92 == null) {
			jSeparator92 = new JSeparator();
			jSeparator92.setSize(new Dimension(40, 10));
			jSeparator92.setLocation(new Point(15, 196));
		}
		return jSeparator92;
	}

	/**
	 * This method initializes jSeparator81
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator81() {
		if (jSeparator81 == null) {
			jSeparator81 = new JSeparator();
			jSeparator81.setOrientation(SwingConstants.VERTICAL);
			jSeparator81.setSize(new Dimension(10, 51));
			jSeparator81.setLocation(new Point(14, 197));
		}
		return jSeparator81;
	}

	/**
	 * This method initializes jSeparator71
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator71() {
		if (jSeparator71 == null) {
			jSeparator71 = new JSeparator();
			jSeparator71.setBounds(new Rectangle(15, 248, 179, 10));
		}
		return jSeparator71;
	}

	/**
	 * This method initializes jSeparator811
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator811() {
		if (jSeparator811 == null) {
			jSeparator811 = new JSeparator();
			jSeparator811.setBounds(new Rectangle(194, 197, 10, 53));
			jSeparator811.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparator811;
	}

	/**
	 * This method initializes jComboBoxFormato
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxFormato() {
		if (jComboBoxFormato == null) {
			jComboBoxFormato = new JComboBox();
			jComboBoxFormato.setBounds(new Rectangle(39, 218, 133, 24));
			jComboBoxFormato.addItem("Seqüencial");
			jComboBoxFormato.addItem("Intercalado");
			jComboBoxFormato.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        jComboBoxFormato.setEnabled(false);
		}
		return jComboBoxFormato;
	}

	/**
	 * This method initializes jSeparatorS31
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS31() {
		if (jSeparatorS31 == null) {
			jSeparatorS31 = new JSeparator();
			jSeparatorS31.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS31.setLocation(new Point(396, 28));
			jSeparatorS31.setSize(new Dimension(10, 22));
		}
		return jSeparatorS31;
	}

	/**
	 * This method initializes jSeparatorS01
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS01() {
		if (jSeparatorS01 == null) {
			jSeparatorS01 = new JSeparator();
			jSeparatorS01.setSize(new Dimension(145, 10));
			jSeparatorS01.setLocation(new Point(397, 27));
		}
		return jSeparatorS01;
	}

	/**
	 * This method initializes jSeparatorS311
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS311() {
		if (jSeparatorS311 == null) {
			jSeparatorS311 = new JSeparator();
			jSeparatorS311.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS311.setSize(new Dimension(10, 22));
			jSeparatorS311.setLocation(new Point(542, 28));
		}
		return jSeparatorS311;
	}

	/**
	 * This method initializes jSeparator41
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator41() {
		if (jSeparator41 == null) {
			jSeparator41 = new JSeparator();
			jSeparator41.setBounds(new Rectangle(396, 49, 147, 10));
		}
		return jSeparator41;
	}

	/**
	 * This method initializes jSeparator42
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator42() {
		if (jSeparator42 == null) {
			jSeparator42 = new JSeparator();
			jSeparator42.setSize(new Dimension(67, 10));
			jSeparator42.setLocation(new Point(330, 38));
		}
		return jSeparator42;
	}

	/**
	 * This method initializes jSeparator31
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator31() {
		if (jSeparator31 == null) {
			jSeparator31 = new JSeparator();
			jSeparator31.setOrientation(SwingConstants.VERTICAL);
			jSeparator31.setSize(new Dimension(10, 51));
			jSeparator31.setLocation(new Point(610, 39));
		}
		return jSeparator31;
	}

	/**
	 * This method initializes jSeparator311
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator311() {
		if (jSeparator311 == null) {
			jSeparator311 = new JSeparator();
			jSeparator311.setOrientation(SwingConstants.VERTICAL);
			jSeparator311.setSize(new Dimension(10, 51));
			jSeparator311.setLocation(new Point(329, 38));
		}
		return jSeparator311;
	}

	/**
	 * This method initializes jSeparator421
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator421() {
		if (jSeparator421 == null) {
			jSeparator421 = new JSeparator();
			jSeparator421.setSize(new Dimension(68, 10));
			jSeparator421.setLocation(new Point(543, 38));
		}
		return jSeparator421;
	}

	/**
	 * This method initializes jSeparator21
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator21() {
		if (jSeparator21 == null) {
			jSeparator21 = new JSeparator();
			jSeparator21.setBounds(new Rectangle(329, 89, 282, 10));
		}
		return jSeparator21;
	}

	/**
	 * This method initializes jTextFieldCategoriasSitios
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldCategoriasSitios() {
		if (jTextFieldCategoriasSitios == null) {
			jTextFieldCategoriasSitios = new JTextField();
			jTextFieldCategoriasSitios.setEditable(false);
			jTextFieldCategoriasSitios.setLocation(new Point(350, 58));
			jTextFieldCategoriasSitios.setSize(new Dimension(200, 20));
		}
		return jTextFieldCategoriasSitios;
	}

	/**
	 * This method initializes jButtonCategoriasSitios
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonCategoriasSitios() {
		if (jButtonCategoriasSitios == null) {
			jButtonCategoriasSitios = new JButton();
			jButtonCategoriasSitios.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonCategoriasSitios.setLocation(new Point(560, 55));
			jButtonCategoriasSitios.setSize(new Dimension(31, 28));
			jButtonCategoriasSitios.setBackground(new Color(173, 200, 226));
			jButtonCategoriasSitios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonCategoriasSitios;
	}

	/**
	 * This method initializes jNumberFieldSemente
	 *
	 * @return br.uesc.computacao.estagio.util.JNumberField
	 */
	public JNumberField getJNumberFieldSemente() {
		if (jNumberFieldSemente == null) {
			jNumberFieldSemente = new JNumberField();
			jNumberFieldSemente.setLocation(new Point(325, 214));
			jNumberFieldSemente.setSize(new Dimension(57, 20));
		}
		return jNumberFieldSemente;
	}

	/**
	 * This method initializes jSeparatorS83
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83() {
		if (jSeparatorS83 == null) {
			jSeparatorS83 = new JSeparator();
			jSeparatorS83.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83.setSize(new Dimension(10, 22));
			jSeparatorS83.setLocation(new Point(216, 212));
		}
		return jSeparatorS83;
	}

	/**
	 * This method initializes jSeparatorS102
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS102() {
		if (jSeparatorS102 == null) {
			jSeparatorS102 = new JSeparator();
			jSeparatorS102.setSize(new Dimension(77, 10));
			jSeparatorS102.setLocation(new Point(216, 211));
		}
		return jSeparatorS102;
	}

	/**
	 * This method initializes jSeparatorS831
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS831() {
		if (jSeparatorS831 == null) {
			jSeparatorS831 = new JSeparator();
			jSeparatorS831.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS831.setSize(new Dimension(10, 22));
			jSeparatorS831.setLocation(new Point(293, 212));
		}
		return jSeparatorS831;
	}

	/**
	 * This method initializes jSeparatorS1021
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1021() {
		if (jSeparatorS1021 == null) {
			jSeparatorS1021 = new JSeparator();
			jSeparatorS1021.setSize(new Dimension(77, 10));
			jSeparatorS1021.setLocation(new Point(216, 234));
		}
		return jSeparatorS1021;
	}

	/**
	 * This method initializes jSeparator61
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61() {
		if (jSeparator61 == null) {
			jSeparator61 = new JSeparator();
			jSeparator61.setOrientation(SwingConstants.VERTICAL);
			jSeparator61.setSize(new Dimension(10, 12));
			jSeparator61.setLocation(new Point(250, 236));
		}
		return jSeparator61;
	}

	/**
	 * This method initializes jSeparator611
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611() {
		if (jSeparator611 == null) {
			jSeparator611 = new JSeparator();
			jSeparator611.setOrientation(SwingConstants.VERTICAL);
			jSeparator611.setSize(new Dimension(10, 15));
			jSeparator611.setLocation(new Point(250, 197));
		}
		return jSeparator611;
	}

	/**
	 * This method initializes jSeparator911
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911() {
		if (jSeparator911 == null) {
			jSeparator911 = new JSeparator();
			jSeparator911.setSize(new Dimension(149, 10));
			jSeparator911.setLocation(new Point(251, 196));
		}
		return jSeparator911;
	}

	/**
	 * This method initializes jSeparator9111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9111() {
		if (jSeparator9111 == null) {
			jSeparator9111 = new JSeparator();
			jSeparator9111.setLocation(new Point(251, 248));
			jSeparator9111.setSize(new Dimension(149, 10));
		}
		return jSeparator9111;
	}

	/**
	 * This method initializes jSeparator6111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6111() {
		if (jSeparator6111 == null) {
			jSeparator6111 = new JSeparator();
			jSeparator6111.setOrientation(SwingConstants.VERTICAL);
			jSeparator6111.setSize(new Dimension(10, 52));
			jSeparator6111.setLocation(new Point(400, 197));
		}
		return jSeparator6111;
	}

	/**
	 * This method initializes jSeparatorS8311
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8311() {
		if (jSeparatorS8311 == null) {
			jSeparatorS8311 = new JSeparator();
			jSeparatorS8311.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8311.setLocation(new Point(513, 212));
			jSeparatorS8311.setSize(new Dimension(10, 22));
		}
		return jSeparatorS8311;
	}

	/**
	 * This method initializes jSeparatorS832
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS832() {
		if (jSeparatorS832 == null) {
			jSeparatorS832 = new JSeparator();
			jSeparatorS832.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS832.setSize(new Dimension(10, 22));
			jSeparatorS832.setLocation(new Point(422, 212));
		}
		return jSeparatorS832;
	}

	/**
	 * This method initializes jSeparatorS1022
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1022() {
		if (jSeparatorS1022 == null) {
			jSeparatorS1022 = new JSeparator();
			jSeparatorS1022.setSize(new Dimension(92, 10));
			jSeparatorS1022.setLocation(new Point(422, 211));
		}
		return jSeparatorS1022;
	}

	/**
	 * This method initializes jSeparatorS10211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10211() {
		if (jSeparatorS10211 == null) {
			jSeparatorS10211 = new JSeparator();
			jSeparatorS10211.setBounds(new Rectangle(422, 233, 92, 10));
		}
		return jSeparatorS10211;
	}

	/**
	 * This method initializes jSeparator612
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator612() {
		if (jSeparator612 == null) {
			jSeparator612 = new JSeparator();
			jSeparator612.setOrientation(SwingConstants.VERTICAL);
			jSeparator612.setSize(new Dimension(10, 14));
			jSeparator612.setLocation(new Point(475, 198));
		}
		return jSeparator612;
	}

	/**
	 * This method initializes jSeparator613
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator613() {
		if (jSeparator613 == null) {
			jSeparator613 = new JSeparator();
			jSeparator613.setOrientation(SwingConstants.VERTICAL);
			jSeparator613.setLocation(new Point(476, 236));
			jSeparator613.setSize(new Dimension(10, 12));
		}
		return jSeparator613;
	}

	/**
	 * This method initializes jNumberFieldReplicas
	 *
	 * @return br.uesc.computacao.estagio.util.JNumberField
	 */
	public JNumberField getJNumberFieldReplicas() {
		if (jNumberFieldReplicas == null) {
			jNumberFieldReplicas = new JNumberField();
			jNumberFieldReplicas.setLocation(new Point(528, 214));
			jNumberFieldReplicas.setSize(new Dimension(57, 20));
		}
		return jNumberFieldReplicas;
	}

	/**
	 * This method initializes jSeparator91111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91111() {
		if (jSeparator91111 == null) {
			jSeparator91111 = new JSeparator();
			jSeparator91111.setBounds(new Rectangle(476, 248, 134, 10));
		}
		return jSeparator91111;
	}

	/**
	 * This method initializes jSeparator9112
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9112() {
		if (jSeparator9112 == null) {
			jSeparator9112 = new JSeparator();
			jSeparator9112.setBounds(new Rectangle(475, 197, 135, 10));
		}
		return jSeparator9112;
	}

	/**
	 * This method initializes jSeparator61111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61111() {
		if (jSeparator61111 == null) {
			jSeparator61111 = new JSeparator();
			jSeparator61111.setOrientation(SwingConstants.VERTICAL);
			jSeparator61111.setSize(new Dimension(10, 51));
			jSeparator61111.setLocation(new Point(610, 198));
		}
		return jSeparator61111;
	}

	/**
	 * This method initializes jCheckBoxEnzimas
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxEnzimas() {
		if (jCheckBoxEnzimas == null) {
			jCheckBoxEnzimas = new JCheckBox();
			jCheckBoxEnzimas.setOpaque(false);
			jCheckBoxEnzimas.setSize(new Dimension(84, 21));
			jCheckBoxEnzimas.setLocation(new Point(64, 290));
			jCheckBoxEnzimas.setText("Enzimas");
			jCheckBoxEnzimas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jCheckBoxEnzimas;
	}

	/**
	 * This method initializes jSeparatorS833
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS833() {
		if (jSeparatorS833 == null) {
			jSeparatorS833 = new JSeparator();
			jSeparatorS833.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS833.setSize(new Dimension(10, 22));
			jSeparatorS833.setLocation(new Point(216, 291));
		}
		return jSeparatorS833;
	}

	/**
	 * This method initializes jSeparatorS1023
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1023() {
		if (jSeparatorS1023 == null) {
			jSeparatorS1023 = new JSeparator();
			jSeparatorS1023.setSize(new Dimension(59, 10));
			jSeparatorS1023.setLocation(new Point(216, 290));
		}
		return jSeparatorS1023;
	}

	/**
	 * This method initializes jSeparatorS8331
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8331() {
		if (jSeparatorS8331 == null) {
			jSeparatorS8331 = new JSeparator();
			jSeparatorS8331.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8331.setSize(new Dimension(10, 22));
			jSeparatorS8331.setLocation(new Point(275, 291));
		}
		return jSeparatorS8331;
	}

	/**
	 * This method initializes jSeparatorS10231
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10231() {
		if (jSeparatorS10231 == null) {
			jSeparatorS10231 = new JSeparator();
			jSeparatorS10231.setSize(new Dimension(59, 10));
			jSeparatorS10231.setLocation(new Point(216, 313));
		}
		return jSeparatorS10231;
	}

	/**
	 * This method initializes jSeparator6112
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6112() {
		if (jSeparator6112 == null) {
			jSeparator6112 = new JSeparator();
			jSeparator6112.setOrientation(SwingConstants.VERTICAL);
			jSeparator6112.setSize(new Dimension(10, 15));
			jSeparator6112.setLocation(new Point(250, 275));
		}
		return jSeparator6112;
	}

	/**
	 * This method initializes jSeparator61121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61121() {
		if (jSeparator61121 == null) {
			jSeparator61121 = new JSeparator();
			jSeparator61121.setOrientation(SwingConstants.VERTICAL);
			jSeparator61121.setSize(new Dimension(10, 12));
			jSeparator61121.setLocation(new Point(250, 314));
		}
		return jSeparator61121;
	}

	/**
	 * This method initializes jSeparator91112
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91112() {
		if (jSeparator91112 == null) {
			jSeparator91112 = new JSeparator();
			jSeparator91112.setSize(new Dimension(149, 10));
			jSeparator91112.setLocation(new Point(251, 274));
		}
		return jSeparator91112;
	}

	/**
	 * This method initializes jSeparator911121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911121() {
		if (jSeparator911121 == null) {
			jSeparator911121 = new JSeparator();
			jSeparator911121.setSize(new Dimension(149, 10));
			jSeparator911121.setLocation(new Point(251, 326));
		}
		return jSeparator911121;
	}

	/**
	 * This method initializes jSeparator61122
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61122() {
		if (jSeparator61122 == null) {
			jSeparator61122 = new JSeparator();
			jSeparator61122.setOrientation(SwingConstants.VERTICAL);
			jSeparator61122.setLocation(new Point(400, 275));
			jSeparator61122.setSize(new Dimension(10, 52));
		}
		return jSeparator61122;
	}

	/**
	 * This method initializes jNumberFieldBloco
	 *
	 * @return br.uesc.computacao.estagio.util.JNumberField
	 */
	public JNumberField getJNumberFieldBloco() {
		if (jNumberFieldBloco == null) {
			jNumberFieldBloco = new JNumberField();
			jNumberFieldBloco.setLocation(new Point(325, 293));
			jNumberFieldBloco.setSize(new Dimension(57, 20));
		}
		return jNumberFieldBloco;
	}

	/**
	 * This method initializes jSeparatorS83311
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83311() {
		if (jSeparatorS83311 == null) {
			jSeparatorS83311 = new JSeparator();
			jSeparatorS83311.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83311.setSize(new Dimension(10, 22));
			jSeparatorS83311.setLocation(new Point(422, 291));
		}
		return jSeparatorS83311;
	}

	/**
	 * This method initializes jSeparatorS10232
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10232() {
		if (jSeparatorS10232 == null) {
			jSeparatorS10232 = new JSeparator();
			jSeparatorS10232.setBounds(new Rectangle(423, 290, 93, 10));
		}
		return jSeparatorS10232;
	}

	/**
	 * This method initializes jSeparatorS833111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS833111() {
		if (jSeparatorS833111 == null) {
			jSeparatorS833111 = new JSeparator();
			jSeparatorS833111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS833111.setSize(new Dimension(10, 22));
			jSeparatorS833111.setLocation(new Point(516, 291));
		}
		return jSeparatorS833111;
	}

	/**
	 * This method initializes jSeparatorS102111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS102111() {
		if (jSeparatorS102111 == null) {
			jSeparatorS102111 = new JSeparator();
			jSeparatorS102111.setBounds(new Rectangle(422, 313, 95, 10));
		}
		return jSeparatorS102111;
	}

	/**
	 * This method initializes jSeparator61123
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61123() {
		if (jSeparator61123 == null) {
			jSeparator61123 = new JSeparator();
			jSeparator61123.setOrientation(SwingConstants.VERTICAL);
			jSeparator61123.setSize(new Dimension(10, 15));
			jSeparator61123.setLocation(new Point(476, 275));
		}
		return jSeparator61123;
	}

	/**
	 * This method initializes jSeparator611231
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611231() {
		if (jSeparator611231 == null) {
			jSeparator611231 = new JSeparator();
			jSeparator611231.setOrientation(SwingConstants.VERTICAL);
			jSeparator611231.setSize(new Dimension(10, 12));
			jSeparator611231.setLocation(new Point(476, 314));
		}
		return jSeparator611231;
	}

	/**
	 * This method initializes jSeparator911122
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911122() {
		if (jSeparator911122 == null) {
			jSeparator911122 = new JSeparator();
			jSeparator911122.setSize(new Dimension(134, 10));
			jSeparator911122.setLocation(new Point(476, 274));
		}
		return jSeparator911122;
	}

	/**
	 * This method initializes jSeparator9111221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9111221() {
		if (jSeparator9111221 == null) {
			jSeparator9111221 = new JSeparator();
			jSeparator9111221.setBounds(new Rectangle(476, 326, 134, 10));
		}
		return jSeparator9111221;
	}

	/**
	 * This method initializes jSeparator611221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611221() {
		if (jSeparator611221 == null) {
			jSeparator611221 = new JSeparator();
			jSeparator611221.setOrientation(SwingConstants.VERTICAL);
			jSeparator611221.setLocation(new Point(610, 275));
			jSeparator611221.setSize(new Dimension(10, 52));
		}
		return jSeparator611221;
	}

	/**
	 * This method initializes jNumberFieldAmostras
	 *
	 * @return br.uesc.computacao.estagio.util.JNumberField
	 */
	public JNumberField getJNumberFieldAmostras() {
		if (jNumberFieldAmostras == null) {
			jNumberFieldAmostras = new JNumberField();
			jNumberFieldAmostras.setLocation(new Point(528, 292));
			jNumberFieldAmostras.setSize(new Dimension(57, 20));
		}
		return jNumberFieldAmostras;
	}

	/**
	 * This method initializes jPanelParametros
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelParametros() {
		if (jPanelParametros == null) {
			jLabelMultiplosArquivosSaida = new JLabel();
			jLabelMultiplosArquivosSaida.setLocation(new Point(232, 254));
			jLabelMultiplosArquivosSaida.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelMultiplosArquivosSaida.setText("Múltiplos arquivos de saída");
			jLabelMultiplosArquivosSaida.setSize(new Dimension(185, 15));
			jLabelArquivoMisturado = new JLabel();
			jLabelArquivoMisturado.setLocation(new Point(400, 31));
			jLabelArquivoMisturado.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoMisturado.setText("Arquivo Misturado");
			jLabelArquivoMisturado.setSize(new Dimension(128, 15));
			jLabelArquivoAncestral = new JLabel();
			jLabelArquivoAncestral.setLocation(new Point(399, 144));
			jLabelArquivoAncestral.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoAncestral.setText("Arquivo Ancestral");
			jLabelArquivoAncestral.setSize(new Dimension(132, 15));
			jLabelFormatoSaida = new JLabel();
			jLabelFormatoSaida.setLocation(new Point(83, 144));
			jLabelFormatoSaida.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelFormatoSaida.setText("Formato da saída");
			jLabelFormatoSaida.setSize(new Dimension(122, 15));
                        jLabelFormatoSaida.setEnabled(false);
			jLabelPesos = new JLabel();
			jLabelPesos.setLocation(new Point(89, 31));
			jLabelPesos.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelPesos.setText("Pesos");
			jLabelPesos.setSize(new Dimension(50, 16));
			jPanelParametros = new JPanel();
			jPanelParametros.setLayout(null);
			jPanelParametros.setBackground(new Color(173, 200, 226));
			jPanelParametros.add(jLabelPesos, null);
			jPanelParametros.add(getJSeparator01(), null);
			jPanelParametros.add(getJSeparator15(), null);
			jPanelParametros.add(getJSeparator22(), null);
			jPanelParametros.add(getJSeparator32(), null);
			jPanelParametros.add(getJSeparator43(), null);
			jPanelParametros.add(getJButtonPesos(), null);
			jPanelParametros.add(getJTextFieldPesos(), null);
			jPanelParametros.add(jLabelFormatoSaida, null);
			jPanelParametros.add(getJSeparator103(), null);
			jPanelParametros.add(getJSeparator112(), null);
			jPanelParametros.add(getJSeparator122(), null);
			jPanelParametros.add(getJSeparator131(), null);
			jPanelParametros.add(getJSeparator141(), null);
			jPanelParametros.add(getJSeparatorS12(), null);
			jPanelParametros.add(getJSeparatorS02(), null);
			jPanelParametros.add(getJSeparatorS21(), null);
			jPanelParametros.add(getJSeparatorS32(), null);
			jPanelParametros.add(getJSeparatorS84(), null);
			jPanelParametros.add(getJSeparatorS93(), null);
			jPanelParametros.add(getJSeparatorS103(), null);
			jPanelParametros.add(getJSeparatorS111(), null);
			jPanelParametros.add(getJComboBoxFormatoSaida(), null);
			jPanelParametros.add(jLabelArquivoAncestral, null);
			jPanelParametros.add(getJSeparatorS811(), null);
			jPanelParametros.add(getJSeparatorS1012(), null);
			jPanelParametros.add(getJSeparatorS911(), null);
			jPanelParametros.add(getJSeparatorS10111(), null);
			jPanelParametros.add(getJSeparator1011(), null);
			jPanelParametros.add(getJSeparatorS921(), null);
			jPanelParametros.add(getJSeparator1111(), null);
			jPanelParametros.add(getJSeparator1021(), null);
			jPanelParametros.add(getJSeparator1211(), null);
			jPanelParametros.add(jLabelArquivoMisturado, null);
			jPanelParametros.add(getJSeparatorS312(), null);
			jPanelParametros.add(getJSeparatorS011(), null);
			jPanelParametros.add(getJSeparatorS3111(), null);
			jPanelParametros.add(getJSeparator411(), null);
			jPanelParametros.add(getJSeparator422(), null);
			jPanelParametros.add(getJSeparator312(), null);
			jPanelParametros.add(getJSeparator3111(), null);
			jPanelParametros.add(getJSeparator4211(), null);
			jPanelParametros.add(getJSeparator211(), null);
			jPanelParametros.add(getJTextFieldArquivoMisturado(), null);
			jPanelParametros.add(getJButtonArquivoMisturado(), null);
			jPanelParametros.add(jLabelMultiplosArquivosSaida, null);
			jPanelParametros.add(getJSeparatorS83111(), null);
			jPanelParametros.add(getJSeparatorS8321(), null);
			jPanelParametros.add(getJSeparatorS10221(), null);
			jPanelParametros.add(getJSeparatorS102112(), null);
			jPanelParametros.add(getJSeparator6121(), null);
			jPanelParametros.add(getJSeparator6131(), null);
			jPanelParametros.add(getJSeparator911111(), null);
			jPanelParametros.add(getJSeparator91121(), null);
			jPanelParametros.add(getJSeparator611111(), null);
			jPanelParametros.add(getJTextFieldArquivoAncestral(), null);
			jPanelParametros.add(getJButtonArquivoAncestral(), null);
			jPanelParametros.add(getJCheckBoxMultiplosArquivosSaidaPesos(), null);
			jPanelParametros.add(getJCheckBoxMultiplosArquivosSaidaDados(), null);
		}
		return jPanelParametros;
	}

	/**
	 * This method initializes jSeparator01
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator01() {
		if (jSeparator01 == null) {
			jSeparator01 = new JSeparator();
			jSeparator01.setLocation(new Point(14, 38));
			jSeparator01.setSize(new Dimension(72, 10));
		}
		return jSeparator01;
	}

	/**
	 * This method initializes jSeparator15
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator15() {
		if (jSeparator15 == null) {
			jSeparator15 = new JSeparator();
			jSeparator15.setLocation(new Point(13, 38));
			jSeparator15.setOrientation(SwingConstants.VERTICAL);
			jSeparator15.setSize(new Dimension(10, 51));
		}
		return jSeparator15;
	}

	/**
	 * This method initializes jSeparator22
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator22() {
		if (jSeparator22 == null) {
			jSeparator22 = new JSeparator();
			jSeparator22.setLocation(new Point(13, 89));
			jSeparator22.setSize(new Dimension(295, 10));
		}
		return jSeparator22;
	}

	/**
	 * This method initializes jSeparator32
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator32() {
		if (jSeparator32 == null) {
			jSeparator32 = new JSeparator();
			jSeparator32.setLocation(new Point(308, 39));
			jSeparator32.setOrientation(SwingConstants.VERTICAL);
			jSeparator32.setSize(new Dimension(10, 51));
		}
		return jSeparator32;
	}

	/**
	 * This method initializes jSeparator43
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator43() {
		if (jSeparator43 == null) {
			jSeparator43 = new JSeparator();
			jSeparator43.setLocation(new Point(143, 38));
			jSeparator43.setSize(new Dimension(166, 10));
		}
		return jSeparator43;
	}

	/**
	 * This method initializes jButtonPesos
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonPesos() {
		if (jButtonPesos == null) {
			jButtonPesos = new JButton();
			jButtonPesos.setLocation(new Point(245, 55));
			jButtonPesos.setBackground(new Color(173, 200, 226));
			jButtonPesos.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonPesos.setSize(new Dimension(31, 28));
			jButtonPesos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonPesos;
	}

	/**
	 * This method initializes jTextFieldPesos
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldPesos() {
		if (jTextFieldPesos == null) {
			jTextFieldPesos = new JTextField();
			jTextFieldPesos.setLocation(new Point(36, 58));
			jTextFieldPesos.setEditable(false);
			jTextFieldPesos.setSize(new Dimension(200, 20));
		}
		return jTextFieldPesos;
	}

	/**
	 * This method initializes jSeparator103
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator103() {
		if (jSeparator103 == null) {
			jSeparator103 = new JSeparator();
			jSeparator103.setLocation(new Point(209, 151));
			jSeparator103.setSize(new Dimension(98, 10));
		}
		return jSeparator103;
	}

	/**
	 * This method initializes jSeparator112
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator112() {
		if (jSeparator112 == null) {
			jSeparator112 = new JSeparator();
			jSeparator112.setLocation(new Point(307, 152));
			jSeparator112.setOrientation(SwingConstants.VERTICAL);
			jSeparator112.setSize(new Dimension(10, 50));
		}
		return jSeparator112;
	}

	/**
	 * This method initializes jSeparator122
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator122() {
		if (jSeparator122 == null) {
			jSeparator122 = new JSeparator();
			jSeparator122.setBounds(new Rectangle(13, 201, 295, 10));
		}
		return jSeparator122;
	}

	/**
	 * This method initializes jSeparator131
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator131() {
		if (jSeparator131 == null) {
			jSeparator131 = new JSeparator();
			jSeparator131.setLocation(new Point(12, 151));
			jSeparator131.setOrientation(SwingConstants.VERTICAL);
			jSeparator131.setSize(new Dimension(10, 51));
		}
		return jSeparator131;
	}

	/**
	 * This method initializes jSeparator141
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator141() {
		if (jSeparator141 == null) {
			jSeparator141 = new JSeparator();
			jSeparator141.setLocation(new Point(13, 150));
			jSeparator141.setSize(new Dimension(67, 10));
		}
		return jSeparator141;
	}

	/**
	 * This method initializes jSeparatorS12
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS12() {
		if (jSeparatorS12 == null) {
			jSeparatorS12 = new JSeparator();
			jSeparatorS12.setLocation(new Point(86, 28));
			jSeparatorS12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS12.setSize(new Dimension(10, 22));
		}
		return jSeparatorS12;
	}

	/**
	 * This method initializes jSeparatorS02
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS02() {
		if (jSeparatorS02 == null) {
			jSeparatorS02 = new JSeparator();
			jSeparatorS02.setLocation(new Point(87, 27));
			jSeparatorS02.setSize(new Dimension(55, 10));
		}
		return jSeparatorS02;
	}

	/**
	 * This method initializes jSeparatorS21
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS21() {
		if (jSeparatorS21 == null) {
			jSeparatorS21 = new JSeparator();
			jSeparatorS21.setLocation(new Point(86, 50));
			jSeparatorS21.setSize(new Dimension(56, 10));
		}
		return jSeparatorS21;
	}

	/**
	 * This method initializes jSeparatorS32
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS32() {
		if (jSeparatorS32 == null) {
			jSeparatorS32 = new JSeparator();
			jSeparatorS32.setLocation(new Point(142, 28));
			jSeparatorS32.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS32.setSize(new Dimension(10, 22));
		}
		return jSeparatorS32;
	}

	/**
	 * This method initializes jSeparatorS84
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS84() {
		if (jSeparatorS84 == null) {
			jSeparatorS84 = new JSeparator();
			jSeparatorS84.setLocation(new Point(80, 139));
			jSeparatorS84.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS84.setSize(new Dimension(10, 22));
		}
		return jSeparatorS84;
	}

	/**
	 * This method initializes jSeparatorS93
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS93() {
		if (jSeparatorS93 == null) {
			jSeparatorS93 = new JSeparator();
			jSeparatorS93.setLocation(new Point(208, 139));
			jSeparatorS93.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS93.setSize(new Dimension(10, 22));
		}
		return jSeparatorS93;
	}

	/**
	 * This method initializes jSeparatorS103
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS103() {
		if (jSeparatorS103 == null) {
			jSeparatorS103 = new JSeparator();
			jSeparatorS103.setLocation(new Point(81, 138));
			jSeparatorS103.setSize(new Dimension(128, 10));
		}
		return jSeparatorS103;
	}

	/**
	 * This method initializes jSeparatorS111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS111() {
		if (jSeparatorS111 == null) {
			jSeparatorS111 = new JSeparator();
			jSeparatorS111.setLocation(new Point(81, 161));
			jSeparatorS111.setSize(new Dimension(128, 10));
		}
		return jSeparatorS111;
	}

	/**
	 * This method initializes jComboBoxFormatoSaida
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxFormatoSaida() {
		if (jComboBoxFormatoSaida == null) {
			jComboBoxFormatoSaida = new JComboBox();
			jComboBoxFormatoSaida.setLocation(new Point(69, 171));
			jComboBoxFormatoSaida.setSize(new Dimension(164, 24));
			jComboBoxFormatoSaida.addItem("  ");
			jComboBoxFormatoSaida.addItem("Phylip");
			jComboBoxFormatoSaida.addItem("Nexus");
			jComboBoxFormatoSaida.addItem("XML");
			jComboBoxFormatoSaida.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        jComboBoxFormatoSaida.setEnabled(false);
		}
		return jComboBoxFormatoSaida;
	}

	/**
	 * This method initializes jSeparatorS811
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS811() {
		if (jSeparatorS811 == null) {
			jSeparatorS811 = new JSeparator();
			jSeparatorS811.setLocation(new Point(394, 140));
			jSeparatorS811.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS811.setSize(new Dimension(10, 22));
		}
		return jSeparatorS811;
	}

	/**
	 * This method initializes jSeparatorS1012
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1012() {
		if (jSeparatorS1012 == null) {
			jSeparatorS1012 = new JSeparator();
			jSeparatorS1012.setLocation(new Point(395, 138));
			jSeparatorS1012.setSize(new Dimension(138, 10));
		}
		return jSeparatorS1012;
	}

	/**
	 * This method initializes jSeparatorS911
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS911() {
		if (jSeparatorS911 == null) {
			jSeparatorS911 = new JSeparator();
			jSeparatorS911.setLocation(new Point(534, 139));
			jSeparatorS911.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS911.setSize(new Dimension(10, 22));
		}
		return jSeparatorS911;
	}

	/**
	 * This method initializes jSeparatorS10111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10111() {
		if (jSeparatorS10111 == null) {
			jSeparatorS10111 = new JSeparator();
			jSeparatorS10111.setLocation(new Point(395, 161));
			jSeparatorS10111.setSize(new Dimension(139, 10));
		}
		return jSeparatorS10111;
	}

	/**
	 * This method initializes jSeparator1011
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1011() {
		if (jSeparator1011 == null) {
			jSeparator1011 = new JSeparator();
			jSeparator1011.setLocation(new Point(535, 151));
			jSeparator1011.setSize(new Dimension(74, 10));
		}
		return jSeparator1011;
	}

	/**
	 * This method initializes jSeparatorS921
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS921() {
		if (jSeparatorS921 == null) {
			jSeparatorS921 = new JSeparator();
			jSeparatorS921.setLocation(new Point(609, 152));
			jSeparatorS921.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS921.setSize(new Dimension(10, 50));
		}
		return jSeparatorS921;
	}

	/**
	 * This method initializes jSeparator1111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1111() {
		if (jSeparator1111 == null) {
			jSeparator1111 = new JSeparator();
			jSeparator1111.setLocation(new Point(328, 152));
			jSeparator1111.setOrientation(SwingConstants.VERTICAL);
			jSeparator1111.setSize(new Dimension(10, 50));
		}
		return jSeparator1111;
	}

	/**
	 * This method initializes jSeparator1021
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1021() {
		if (jSeparator1021 == null) {
			jSeparator1021 = new JSeparator();
			jSeparator1021.setLocation(new Point(329, 151));
			jSeparator1021.setSize(new Dimension(64, 15));
		}
		return jSeparator1021;
	}

	/**
	 * This method initializes jSeparator1211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1211() {
		if (jSeparator1211 == null) {
			jSeparator1211 = new JSeparator();
			jSeparator1211.setLocation(new Point(329, 201));
			jSeparator1211.setSize(new Dimension(281, 10));
		}
		return jSeparator1211;
	}

	/**
	 * This method initializes jSeparatorS312
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS312() {
		if (jSeparatorS312 == null) {
			jSeparatorS312 = new JSeparator();
			jSeparatorS312.setLocation(new Point(396, 28));
			jSeparatorS312.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS312.setSize(new Dimension(10, 22));
		}
		return jSeparatorS312;
	}

	/**
	 * This method initializes jSeparatorS011
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS011() {
		if (jSeparatorS011 == null) {
			jSeparatorS011 = new JSeparator();
			jSeparatorS011.setLocation(new Point(397, 27));
			jSeparatorS011.setSize(new Dimension(133, 10));
		}
		return jSeparatorS011;
	}

	/**
	 * This method initializes jSeparatorS3111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS3111() {
		if (jSeparatorS3111 == null) {
			jSeparatorS3111 = new JSeparator();
			jSeparatorS3111.setLocation(new Point(530, 28));
			jSeparatorS3111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS3111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS3111;
	}

	/**
	 * This method initializes jSeparator411
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator411() {
		if (jSeparator411 == null) {
			jSeparator411 = new JSeparator();
			jSeparator411.setBounds(new Rectangle(396, 49, 134, 10));
		}
		return jSeparator411;
	}

	/**
	 * This method initializes jSeparator422
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator422() {
		if (jSeparator422 == null) {
			jSeparator422 = new JSeparator();
			jSeparator422.setLocation(new Point(330, 38));
			jSeparator422.setSize(new Dimension(67, 10));
		}
		return jSeparator422;
	}

	/**
	 * This method initializes jSeparator312
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator312() {
		if (jSeparator312 == null) {
			jSeparator312 = new JSeparator();
			jSeparator312.setLocation(new Point(610, 39));
			jSeparator312.setOrientation(SwingConstants.VERTICAL);
			jSeparator312.setSize(new Dimension(10, 51));
		}
		return jSeparator312;
	}

	/**
	 * This method initializes jSeparator3111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator3111() {
		if (jSeparator3111 == null) {
			jSeparator3111 = new JSeparator();
			jSeparator3111.setLocation(new Point(329, 38));
			jSeparator3111.setOrientation(SwingConstants.VERTICAL);
			jSeparator3111.setSize(new Dimension(10, 51));
		}
		return jSeparator3111;
	}

	/**
	 * This method initializes jSeparator4211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator4211() {
		if (jSeparator4211 == null) {
			jSeparator4211 = new JSeparator();
			jSeparator4211.setLocation(new Point(531, 38));
			jSeparator4211.setSize(new Dimension(80, 10));
		}
		return jSeparator4211;
	}

	/**
	 * This method initializes jSeparator211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator211() {
		if (jSeparator211 == null) {
			jSeparator211 = new JSeparator();
			jSeparator211.setBounds(new Rectangle(329, 89, 282, 10));
		}
		return jSeparator211;
	}

	/**
	 * This method initializes jTextFieldArquivoMisturado
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldArquivoMisturado() {
		if (jTextFieldArquivoMisturado == null) {
			jTextFieldArquivoMisturado = new JTextField();
			jTextFieldArquivoMisturado.setLocation(new Point(350, 58));
			jTextFieldArquivoMisturado.setEditable(false);
			jTextFieldArquivoMisturado.setSize(new Dimension(200, 20));
		}
		return jTextFieldArquivoMisturado;
	}

	/**
	 * This method initializes jButtonArquivoMisturado
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonArquivoMisturado() {
		if (jButtonArquivoMisturado == null) {
			jButtonArquivoMisturado = new JButton();
			jButtonArquivoMisturado.setLocation(new Point(560, 55));
			jButtonArquivoMisturado.setBackground(new Color(173, 200, 226));
			jButtonArquivoMisturado.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonArquivoMisturado.setSize(new Dimension(31, 28));
			jButtonArquivoMisturado.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonArquivoMisturado;
	}

	/**
	 * This method initializes jSeparatorS83111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83111() {
		if (jSeparatorS83111 == null) {
			jSeparatorS83111 = new JSeparator();
			jSeparatorS83111.setLocation(new Point(228, 250));
			jSeparatorS83111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS83111;
	}

	/**
	 * This method initializes jSeparatorS8321
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8321() {
		if (jSeparatorS8321 == null) {
			jSeparatorS8321 = new JSeparator();
			jSeparatorS8321.setLocation(new Point(422, 249));
			jSeparatorS8321.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8321.setSize(new Dimension(10, 24));
		}
		return jSeparatorS8321;
	}

	/**
	 * This method initializes jSeparatorS10221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10221() {
		if (jSeparatorS10221 == null) {
			jSeparatorS10221 = new JSeparator();
			jSeparatorS10221.setLocation(new Point(229, 249));
			jSeparatorS10221.setSize(new Dimension(194, 10));
		}
		return jSeparatorS10221;
	}

	/**
	 * This method initializes jSeparatorS102112
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS102112() {
		if (jSeparatorS102112 == null) {
			jSeparatorS102112 = new JSeparator();
			jSeparatorS102112.setBounds(new Rectangle(228, 272, 194, 11));
		}
		return jSeparatorS102112;
	}

	/**
	 * This method initializes jSeparator6121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6121() {
		if (jSeparator6121 == null) {
			jSeparator6121 = new JSeparator();
			jSeparator6121.setLocation(new Point(161, 261));
			jSeparator6121.setOrientation(SwingConstants.VERTICAL);
			jSeparator6121.setSize(new Dimension(10, 50));
		}
		return jSeparator6121;
	}

	/**
	 * This method initializes jSeparator6131
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6131() {
		if (jSeparator6131 == null) {
			jSeparator6131 = new JSeparator();
			jSeparator6131.setLocation(new Point(423, 260));
			jSeparator6131.setOrientation(SwingConstants.HORIZONTAL);
			jSeparator6131.setSize(new Dimension(67, 10));
		}
		return jSeparator6131;
	}

	/**
	 * This method initializes jSeparator911111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911111() {
		if (jSeparator911111 == null) {
			jSeparator911111 = new JSeparator();
			jSeparator911111.setBounds(new Rectangle(162, 311, 329, 10));
		}
		return jSeparator911111;
	}

	/**
	 * This method initializes jSeparator91121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91121() {
		if (jSeparator91121 == null) {
			jSeparator91121 = new JSeparator();
			jSeparator91121.setBounds(new Rectangle(162, 260, 67, 10));
		}
		return jSeparator91121;
	}

	/**
	 * This method initializes jSeparator611111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611111() {
		if (jSeparator611111 == null) {
			jSeparator611111 = new JSeparator();
			jSeparator611111.setLocation(new Point(490, 261));
			jSeparator611111.setOrientation(SwingConstants.VERTICAL);
			jSeparator611111.setSize(new Dimension(10, 51));
		}
		return jSeparator611111;
	}

	/**
	 * This method initializes jTextFieldArquivoAncestral
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldArquivoAncestral() {
		if (jTextFieldArquivoAncestral == null) {
			jTextFieldArquivoAncestral = new JTextField();
			jTextFieldArquivoAncestral.setEditable(false);
			jTextFieldArquivoAncestral.setLocation(new Point(349, 174));
			jTextFieldArquivoAncestral.setSize(new Dimension(200, 20));
		}
		return jTextFieldArquivoAncestral;
	}

	/**
	 * This method initializes jButtonArquivoAncestral
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonArquivoAncestral() {
		if (jButtonArquivoAncestral == null) {
			jButtonArquivoAncestral = new JButton();
			jButtonArquivoAncestral.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonArquivoAncestral.setLocation(new Point(559, 169));
			jButtonArquivoAncestral.setSize(new Dimension(31, 28));
			jButtonArquivoAncestral.setBackground(new Color(173, 200, 226));
			jButtonArquivoAncestral.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonArquivoAncestral;
	}

	/**
	 * This method initializes jPanelConsense
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelConsense() {
		if (jPanelConsense == null) {
			jLabelFracaoTempo = new JLabel();
			jLabelFracaoTempo.setLocation(new Point(336, 294));
			jLabelFracaoTempo.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelFracaoTempo.setText("Fração de tempo");
			jLabelFracaoTempo.setSize(new Dimension(122, 15));
			jLabelArvoreArquivoSaida = new JLabel();
			jLabelArvoreArquivoSaida.setBounds(new Rectangle(20, 294, 175, 15));
			jLabelArvoreArquivoSaida.setText("Árvore no arquivo de saída");
			jLabelArvoreArquivoSaida.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelExecucao = new JLabel();
			jLabelExecucao.setLocation(new Point(336, 214));
			jLabelExecucao.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelExecucao.setText("Execução");
			jLabelExecucao.setSize(new Dimension(67, 15));
			jLabelEspeciesArquivoSaida = new JLabel();
			jLabelEspeciesArquivoSaida.setBounds(new Rectangle(21, 214, 190, 15));
			jLabelEspeciesArquivoSaida.setText("Espécies no arquivo de saída");
			jLabelEspeciesArquivoSaida.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRaiz = new JLabel();
			jLabelRaiz.setLocation(new Point(400, 31));
			jLabelRaiz.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRaiz.setText("Raíz");
			jLabelRaiz.setSize(new Dimension(37, 15));
			jLabelMaiorAncestral = new JLabel();
			jLabelMaiorAncestral.setLocation(new Point(400, 111));
			jLabelMaiorAncestral.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelMaiorAncestral.setText("Maior Ancestral");
			jLabelMaiorAncestral.setSize(new Dimension(115, 15));
			jLabelAvaliacao = new JLabel();
			jLabelAvaliacao.setLocation(new Point(84, 111));
			jLabelAvaliacao.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelAvaliacao.setText("Avaliação");
			jLabelAvaliacao.setSize(new Dimension(74, 15));
			jLabelArvore = new JLabel();
			jLabelArvore.setLocation(new Point(89, 31));
			jLabelArvore.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArvore.setText("Árvore");
			jLabelArvore.setSize(new Dimension(50, 16));
			jPanelConsense = new JPanel();
			jPanelConsense.setLayout(null);
			jPanelConsense.setBackground(new Color(173, 200, 226));
			jPanelConsense.add(jLabelArvore, null);
			jPanelConsense.add(getJSeparator011(), null);
			jPanelConsense.add(getJSeparator151(), null);
			jPanelConsense.add(getJSeparator221(), null);
			jPanelConsense.add(getJSeparator321(), null);
			jPanelConsense.add(getJSeparator431(), null);
			jPanelConsense.add(getJButtonArvore(), null);
			jPanelConsense.add(getJTextFieldArvore(), null);
			jPanelConsense.add(jLabelAvaliacao, null);
			jPanelConsense.add(getJSeparator1031(), null);
			jPanelConsense.add(getJSeparator1121(), null);
			jPanelConsense.add(getJSeparator1221(), null);
			jPanelConsense.add(getJSeparator1311(), null);
			jPanelConsense.add(getJSeparator1411(), null);
			jPanelConsense.add(getJSeparatorS121(), null);
			jPanelConsense.add(getJSeparatorS021(), null);
			jPanelConsense.add(getJSeparatorS211(), null);
			jPanelConsense.add(getJSeparatorS321(), null);
			jPanelConsense.add(getJSeparatorS841(), null);
			jPanelConsense.add(getJSeparatorS931(), null);
			jPanelConsense.add(getJSeparatorS1031(), null);
			jPanelConsense.add(getJSeparatorS1111(), null);
			jPanelConsense.add(getJComboBoxAvaliacao(), null);
			jPanelConsense.add(jLabelMaiorAncestral, null);
			jPanelConsense.add(getJSeparatorS8111(), null);
			jPanelConsense.add(getJSeparatorS10121(), null);
			jPanelConsense.add(getJSeparatorS9111(), null);
			jPanelConsense.add(getJSeparatorS101111(), null);
			jPanelConsense.add(getJSeparator10111(), null);
			jPanelConsense.add(getJSeparatorS9211(), null);
			jPanelConsense.add(getJSeparator11111(), null);
			jPanelConsense.add(getJSeparator10211(), null);
			jPanelConsense.add(getJSeparator12111(), null);
			jPanelConsense.add(jLabelRaiz, null);
			jPanelConsense.add(getJSeparatorS3121(), null);
			jPanelConsense.add(getJSeparatorS0111(), null);
			jPanelConsense.add(getJSeparatorS31111(), null);
			jPanelConsense.add(getJSeparator4111(), null);
			jPanelConsense.add(getJSeparator4221(), null);
			jPanelConsense.add(getJSeparator3121(), null);
			jPanelConsense.add(getJSeparator31111(), null);
			jPanelConsense.add(getJSeparator42111(), null);
			jPanelConsense.add(getJSeparator2111(), null);
			jPanelConsense.add(jLabelEspeciesArquivoSaida, null);
			jPanelConsense.add(getJSeparatorS8341(), null);
			jPanelConsense.add(getJSeparatorS10241(), null);
			jPanelConsense.add(getJSeparatorS83121(), null);
			jPanelConsense.add(getJSeparatorS102121(), null);
			jPanelConsense.add(getJSeparator6141(), null);
			jPanelConsense.add(getJSeparator61131(), null);
			jPanelConsense.add(getJSeparator91131(), null);
			jPanelConsense.add(getJSeparator911131(), null);
			jPanelConsense.add(getJSeparator611121(), null);
			jPanelConsense.add(jLabelExecucao, null);
			jPanelConsense.add(getJSeparatorS831111(), null);
			jPanelConsense.add(getJSeparatorS83211(), null);
			jPanelConsense.add(getJSeparatorS102211(), null);
			jPanelConsense.add(getJSeparatorS1021121(), null);
			jPanelConsense.add(getJSeparator61211(), null);
			jPanelConsense.add(getJSeparator61311(), null);
			jPanelConsense.add(getJSeparator9111111(), null);
			jPanelConsense.add(getJSeparator911211(), null);
			jPanelConsense.add(getJSeparator6111111(), null);
			jPanelConsense.add(jLabelArvoreArquivoSaida, null);
			jPanelConsense.add(getJSeparatorS83321(), null);
			jPanelConsense.add(getJSeparatorS102331(), null);
			jPanelConsense.add(getJSeparatorS833121(), null);
			jPanelConsense.add(getJSeparatorS1023111(), null);
			jPanelConsense.add(getJSeparator611241(), null);
			jPanelConsense.add(getJSeparator6112111(), null);
			jPanelConsense.add(getJSeparator9111231(), null);
			jPanelConsense.add(getJSeparator91112111(), null);
			jPanelConsense.add(getJSeparator6112221(), null);
			jPanelConsense.add(jLabelFracaoTempo, null);
			jPanelConsense.add(getJSeparatorS8331121(), null);
			jPanelConsense.add(getJSeparatorS1023211(), null);
			jPanelConsense.add(getJSeparatorS83311111(), null);
			jPanelConsense.add(getJSeparatorS10211111(), null);
			jPanelConsense.add(getJSeparator6112321(), null);
			jPanelConsense.add(getJSeparator61123111(), null);
			jPanelConsense.add(getJSeparator91112221(), null);
			jPanelConsense.add(getJSeparator911122111(), null);
			jPanelConsense.add(getJSeparator61122111(), null);
			jPanelConsense.add(getJCheckBoxArvoreArquivoSaidaDesenhar(), null);
			jPanelConsense.add(getJCheckBoxEspeciesArquivoSaidaIndicar(), null);
			jPanelConsense.add(getJRadioButtonRaizSim(), null);
			jPanelConsense.add(getJRadioButtonRaizNao(), null);
			jPanelConsense.add(getJNumberFieldMaiorAncestral(), null);
			jPanelConsense.add(getJCheckBoxExecucaoIndicar(), null);
			jPanelConsense.add(getJNumberFloatFieldFracaoTempo(), null);
			jPanelConsense.add(getJCheckBoxFracaoTempoUsar(), null);
		}
		return jPanelConsense;
	}

	/**
	 * This method initializes jSeparator011
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator011() {
		if (jSeparator011 == null) {
			jSeparator011 = new JSeparator();
			jSeparator011.setLocation(new Point(14, 38));
			jSeparator011.setSize(new Dimension(72, 10));
		}
		return jSeparator011;
	}

	/**
	 * This method initializes jSeparator151
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator151() {
		if (jSeparator151 == null) {
			jSeparator151 = new JSeparator();
			jSeparator151.setLocation(new Point(13, 38));
			jSeparator151.setOrientation(SwingConstants.VERTICAL);
			jSeparator151.setSize(new Dimension(10, 51));
		}
		return jSeparator151;
	}

	/**
	 * This method initializes jSeparator221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator221() {
		if (jSeparator221 == null) {
			jSeparator221 = new JSeparator();
			jSeparator221.setLocation(new Point(13, 89));
			jSeparator221.setSize(new Dimension(295, 10));
		}
		return jSeparator221;
	}

	/**
	 * This method initializes jSeparator321
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator321() {
		if (jSeparator321 == null) {
			jSeparator321 = new JSeparator();
			jSeparator321.setLocation(new Point(308, 39));
			jSeparator321.setOrientation(SwingConstants.VERTICAL);
			jSeparator321.setSize(new Dimension(10, 51));
		}
		return jSeparator321;
	}

	/**
	 * This method initializes jSeparator431
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator431() {
		if (jSeparator431 == null) {
			jSeparator431 = new JSeparator();
			jSeparator431.setLocation(new Point(143, 38));
			jSeparator431.setSize(new Dimension(166, 10));
		}
		return jSeparator431;
	}

	/**
	 * This method initializes jButtonArvore
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonArvore() {
		if (jButtonArvore == null) {
			jButtonArvore = new JButton();
			jButtonArvore.setLocation(new Point(245, 55));
			jButtonArvore.setBackground(new Color(173, 200, 226));
			jButtonArvore.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
			jButtonArvore.setSize(new Dimension(31, 28));
			jButtonArvore.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonArvore;
	}

	/**
	 * This method initializes jTextFieldArvore
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldArvore() {
		if (jTextFieldArvore == null) {
			jTextFieldArvore = new JTextField();
			jTextFieldArvore.setLocation(new Point(36, 58));
			jTextFieldArvore.setEditable(false);
			jTextFieldArvore.setSize(new Dimension(200, 20));
		}
		return jTextFieldArvore;
	}

	/**
	 * This method initializes jSeparator1031
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1031() {
		if (jSeparator1031 == null) {
			jSeparator1031 = new JSeparator();
			jSeparator1031.setLocation(new Point(165, 118));
			jSeparator1031.setSize(new Dimension(143, 10));
		}
		return jSeparator1031;
	}

	/**
	 * This method initializes jSeparator1121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1121() {
		if (jSeparator1121 == null) {
			jSeparator1121 = new JSeparator();
			jSeparator1121.setLocation(new Point(308, 119));
			jSeparator1121.setOrientation(SwingConstants.VERTICAL);
			jSeparator1121.setSize(new Dimension(10, 50));
		}
		return jSeparator1121;
	}

	/**
	 * This method initializes jSeparator1221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1221() {
		if (jSeparator1221 == null) {
			jSeparator1221 = new JSeparator();
			jSeparator1221.setBounds(new Rectangle(14, 168, 295, 10));
		}
		return jSeparator1221;
	}

	/**
	 * This method initializes jSeparator1311
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1311() {
		if (jSeparator1311 == null) {
			jSeparator1311 = new JSeparator();
			jSeparator1311.setLocation(new Point(13, 118));
			jSeparator1311.setOrientation(SwingConstants.VERTICAL);
			jSeparator1311.setSize(new Dimension(10, 51));
		}
		return jSeparator1311;
	}

	/**
	 * This method initializes jSeparator1411
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1411() {
		if (jSeparator1411 == null) {
			jSeparator1411 = new JSeparator();
			jSeparator1411.setLocation(new Point(14, 117));
			jSeparator1411.setSize(new Dimension(67, 10));
		}
		return jSeparator1411;
	}

	/**
	 * This method initializes jSeparatorS121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS121() {
		if (jSeparatorS121 == null) {
			jSeparatorS121 = new JSeparator();
			jSeparatorS121.setLocation(new Point(86, 28));
			jSeparatorS121.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS121.setSize(new Dimension(10, 22));
		}
		return jSeparatorS121;
	}

	/**
	 * This method initializes jSeparatorS021
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS021() {
		if (jSeparatorS021 == null) {
			jSeparatorS021 = new JSeparator();
			jSeparatorS021.setLocation(new Point(87, 27));
			jSeparatorS021.setSize(new Dimension(55, 10));
		}
		return jSeparatorS021;
	}

	/**
	 * This method initializes jSeparatorS211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS211() {
		if (jSeparatorS211 == null) {
			jSeparatorS211 = new JSeparator();
			jSeparatorS211.setLocation(new Point(86, 50));
			jSeparatorS211.setSize(new Dimension(56, 10));
		}
		return jSeparatorS211;
	}

	/**
	 * This method initializes jSeparatorS321
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS321() {
		if (jSeparatorS321 == null) {
			jSeparatorS321 = new JSeparator();
			jSeparatorS321.setLocation(new Point(142, 28));
			jSeparatorS321.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS321.setSize(new Dimension(10, 22));
		}
		return jSeparatorS321;
	}

	/**
	 * This method initializes jSeparatorS841
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS841() {
		if (jSeparatorS841 == null) {
			jSeparatorS841 = new JSeparator();
			jSeparatorS841.setLocation(new Point(81, 106));
			jSeparatorS841.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS841.setSize(new Dimension(10, 22));
		}
		return jSeparatorS841;
	}

	/**
	 * This method initializes jSeparatorS931
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS931() {
		if (jSeparatorS931 == null) {
			jSeparatorS931 = new JSeparator();
			jSeparatorS931.setLocation(new Point(164, 107));
			jSeparatorS931.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS931.setSize(new Dimension(10, 22));
		}
		return jSeparatorS931;
	}

	/**
	 * This method initializes jSeparatorS1031
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1031() {
		if (jSeparatorS1031 == null) {
			jSeparatorS1031 = new JSeparator();
			jSeparatorS1031.setLocation(new Point(82, 105));
			jSeparatorS1031.setSize(new Dimension(81, 10));
		}
		return jSeparatorS1031;
	}

	/**
	 * This method initializes jSeparatorS1111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1111() {
		if (jSeparatorS1111 == null) {
			jSeparatorS1111 = new JSeparator();
			jSeparatorS1111.setLocation(new Point(82, 128));
			jSeparatorS1111.setSize(new Dimension(81, 10));
		}
		return jSeparatorS1111;
	}

	/**
	 * This method initializes jComboBoxAvaliacao
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxAvaliacao() {
		if (jComboBoxAvaliacao == null) {
			jComboBoxAvaliacao = new JComboBox();
			jComboBoxAvaliacao.setLocation(new Point(38, 136));
			jComboBoxAvaliacao.setSize(new Dimension(201, 24));
			jComboBoxAvaliacao.addItem("EXTENDED MAJORITY RULE");
			jComboBoxAvaliacao.addItem("STRICT");
			jComboBoxAvaliacao.addItem("MAJORITY");
			jComboBoxAvaliacao.addItem("ML");
			jComboBoxAvaliacao.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}
		return jComboBoxAvaliacao;
	}

	/**
	 * This method initializes jSeparatorS8111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8111() {
		if (jSeparatorS8111 == null) {
			jSeparatorS8111 = new JSeparator();
			jSeparatorS8111.setLocation(new Point(395, 107));
			jSeparatorS8111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS8111;
	}

	/**
	 * This method initializes jSeparatorS10121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10121() {
		if (jSeparatorS10121 == null) {
			jSeparatorS10121 = new JSeparator();
			jSeparatorS10121.setLocation(new Point(396, 105));
			jSeparatorS10121.setSize(new Dimension(121, 10));
		}
		return jSeparatorS10121;
	}

	/**
	 * This method initializes jSeparatorS9111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS9111() {
		if (jSeparatorS9111 == null) {
			jSeparatorS9111 = new JSeparator();
			jSeparatorS9111.setLocation(new Point(518, 106));
			jSeparatorS9111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS9111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS9111;
	}

	/**
	 * This method initializes jSeparatorS101111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS101111() {
		if (jSeparatorS101111 == null) {
			jSeparatorS101111 = new JSeparator();
			jSeparatorS101111.setLocation(new Point(396, 128));
			jSeparatorS101111.setSize(new Dimension(122, 10));
		}
		return jSeparatorS101111;
	}

	/**
	 * This method initializes jSeparator10111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator10111() {
		if (jSeparator10111 == null) {
			jSeparator10111 = new JSeparator();
			jSeparator10111.setLocation(new Point(519, 118));
			jSeparator10111.setSize(new Dimension(91, 10));
		}
		return jSeparator10111;
	}

	/**
	 * This method initializes jSeparatorS9211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS9211() {
		if (jSeparatorS9211 == null) {
			jSeparatorS9211 = new JSeparator();
			jSeparatorS9211.setLocation(new Point(610, 119));
			jSeparatorS9211.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS9211.setSize(new Dimension(10, 50));
		}
		return jSeparatorS9211;
	}

	/**
	 * This method initializes jSeparator11111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator11111() {
		if (jSeparator11111 == null) {
			jSeparator11111 = new JSeparator();
			jSeparator11111.setLocation(new Point(329, 119));
			jSeparator11111.setOrientation(SwingConstants.VERTICAL);
			jSeparator11111.setSize(new Dimension(10, 50));
		}
		return jSeparator11111;
	}

	/**
	 * This method initializes jSeparator10211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator10211() {
		if (jSeparator10211 == null) {
			jSeparator10211 = new JSeparator();
			jSeparator10211.setLocation(new Point(330, 118));
			jSeparator10211.setSize(new Dimension(64, 15));
		}
		return jSeparator10211;
	}

	/**
	 * This method initializes jSeparator12111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator12111() {
		if (jSeparator12111 == null) {
			jSeparator12111 = new JSeparator();
			jSeparator12111.setLocation(new Point(330, 168));
			jSeparator12111.setSize(new Dimension(281, 10));
		}
		return jSeparator12111;
	}

	/**
	 * This method initializes jSeparatorS3121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS3121() {
		if (jSeparatorS3121 == null) {
			jSeparatorS3121 = new JSeparator();
			jSeparatorS3121.setLocation(new Point(396, 28));
			jSeparatorS3121.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS3121.setSize(new Dimension(10, 22));
		}
		return jSeparatorS3121;
	}

	/**
	 * This method initializes jSeparatorS0111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS0111() {
		if (jSeparatorS0111 == null) {
			jSeparatorS0111 = new JSeparator();
			jSeparatorS0111.setLocation(new Point(397, 27));
			jSeparatorS0111.setSize(new Dimension(44, 10));
		}
		return jSeparatorS0111;
	}

	/**
	 * This method initializes jSeparatorS31111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS31111() {
		if (jSeparatorS31111 == null) {
			jSeparatorS31111 = new JSeparator();
			jSeparatorS31111.setLocation(new Point(441, 28));
			jSeparatorS31111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS31111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS31111;
	}

	/**
	 * This method initializes jSeparator4111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator4111() {
		if (jSeparator4111 == null) {
			jSeparator4111 = new JSeparator();
			jSeparator4111.setBounds(new Rectangle(396, 49, 45, 10));
		}
		return jSeparator4111;
	}

	/**
	 * This method initializes jSeparator4221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator4221() {
		if (jSeparator4221 == null) {
			jSeparator4221 = new JSeparator();
			jSeparator4221.setLocation(new Point(330, 38));
			jSeparator4221.setSize(new Dimension(67, 10));
		}
		return jSeparator4221;
	}

	/**
	 * This method initializes jSeparator3121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator3121() {
		if (jSeparator3121 == null) {
			jSeparator3121 = new JSeparator();
			jSeparator3121.setLocation(new Point(610, 39));
			jSeparator3121.setOrientation(SwingConstants.VERTICAL);
			jSeparator3121.setSize(new Dimension(10, 51));
		}
		return jSeparator3121;
	}

	/**
	 * This method initializes jSeparator31111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator31111() {
		if (jSeparator31111 == null) {
			jSeparator31111 = new JSeparator();
			jSeparator31111.setLocation(new Point(329, 38));
			jSeparator31111.setOrientation(SwingConstants.VERTICAL);
			jSeparator31111.setSize(new Dimension(10, 51));
		}
		return jSeparator31111;
	}

	/**
	 * This method initializes jSeparator42111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator42111() {
		if (jSeparator42111 == null) {
			jSeparator42111 = new JSeparator();
			jSeparator42111.setLocation(new Point(442, 38));
			jSeparator42111.setSize(new Dimension(169, 10));
		}
		return jSeparator42111;
	}

	/**
	 * This method initializes jSeparator2111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator2111() {
		if (jSeparator2111 == null) {
			jSeparator2111 = new JSeparator();
			jSeparator2111.setBounds(new Rectangle(329, 89, 282, 10));
		}
		return jSeparator2111;
	}

	/**
	 * This method initializes jSeparatorS8341
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8341() {
		if (jSeparatorS8341 == null) {
			jSeparatorS8341 = new JSeparator();
			jSeparatorS8341.setLocation(new Point(13, 210));
			jSeparatorS8341.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8341.setSize(new Dimension(10, 22));
		}
		return jSeparatorS8341;
	}

	/**
	 * This method initializes jSeparatorS10241
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10241() {
		if (jSeparatorS10241 == null) {
			jSeparatorS10241 = new JSeparator();
			jSeparatorS10241.setLocation(new Point(13, 209));
			jSeparatorS10241.setSize(new Dimension(199, 10));
		}
		return jSeparatorS10241;
	}

	/**
	 * This method initializes jSeparatorS83121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83121() {
		if (jSeparatorS83121 == null) {
			jSeparatorS83121 = new JSeparator();
			jSeparatorS83121.setLocation(new Point(212, 210));
			jSeparatorS83121.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83121.setSize(new Dimension(10, 22));
		}
		return jSeparatorS83121;
	}

	/**
	 * This method initializes jSeparatorS102121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS102121() {
		if (jSeparatorS102121 == null) {
			jSeparatorS102121 = new JSeparator();
			jSeparatorS102121.setSize(new Dimension(199, 10));
			jSeparatorS102121.setLocation(new Point(13, 232));
		}
		return jSeparatorS102121;
	}

	/**
	 * This method initializes jSeparator6141
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6141() {
		if (jSeparator6141 == null) {
			jSeparator6141 = new JSeparator();
			jSeparator6141.setLocation(new Point(104, 234));
			jSeparator6141.setOrientation(SwingConstants.VERTICAL);
			jSeparator6141.setSize(new Dimension(10, 12));
		}
		return jSeparator6141;
	}

	/**
	 * This method initializes jSeparator61131
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61131() {
		if (jSeparator61131 == null) {
			jSeparator61131 = new JSeparator();
			jSeparator61131.setLocation(new Point(104, 195));
			jSeparator61131.setOrientation(SwingConstants.VERTICAL);
			jSeparator61131.setSize(new Dimension(10, 15));
		}
		return jSeparator61131;
	}

	/**
	 * This method initializes jSeparator91131
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91131() {
		if (jSeparator91131 == null) {
			jSeparator91131 = new JSeparator();
			jSeparator91131.setLocation(new Point(104, 194));
			jSeparator91131.setSize(new Dimension(204, 10));
		}
		return jSeparator91131;
	}

	/**
	 * This method initializes jSeparator911131
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911131() {
		if (jSeparator911131 == null) {
			jSeparator911131 = new JSeparator();
			jSeparator911131.setLocation(new Point(104, 246));
			jSeparator911131.setSize(new Dimension(204, 10));
		}
		return jSeparator911131;
	}

	/**
	 * This method initializes jSeparator611121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611121() {
		if (jSeparator611121 == null) {
			jSeparator611121 = new JSeparator();
			jSeparator611121.setLocation(new Point(308, 195));
			jSeparator611121.setOrientation(SwingConstants.VERTICAL);
			jSeparator611121.setSize(new Dimension(10, 52));
		}
		return jSeparator611121;
	}

	/**
	 * This method initializes jSeparatorS831111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS831111() {
		if (jSeparatorS831111 == null) {
			jSeparatorS831111 = new JSeparator();
			jSeparatorS831111.setLocation(new Point(406, 210));
			jSeparatorS831111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS831111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS831111;
	}

	/**
	 * This method initializes jSeparatorS83211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83211() {
		if (jSeparatorS83211 == null) {
			jSeparatorS83211 = new JSeparator();
			jSeparatorS83211.setLocation(new Point(330, 209));
			jSeparatorS83211.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83211.setSize(new Dimension(10, 22));
		}
		return jSeparatorS83211;
	}

	/**
	 * This method initializes jSeparatorS102211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS102211() {
		if (jSeparatorS102211 == null) {
			jSeparatorS102211 = new JSeparator();
			jSeparatorS102211.setLocation(new Point(331, 209));
			jSeparatorS102211.setSize(new Dimension(76, 10));
		}
		return jSeparatorS102211;
	}

	/**
	 * This method initializes jSeparatorS1021121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1021121() {
		if (jSeparatorS1021121 == null) {
			jSeparatorS1021121 = new JSeparator();
			jSeparatorS1021121.setSize(new Dimension(77, 10));
			jSeparatorS1021121.setLocation(new Point(330, 231));
		}
		return jSeparatorS1021121;
	}

	/**
	 * This method initializes jSeparator61211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61211() {
		if (jSeparator61211 == null) {
			jSeparator61211 = new JSeparator();
			jSeparator61211.setLocation(new Point(368, 195));
			jSeparator61211.setOrientation(SwingConstants.VERTICAL);
			jSeparator61211.setSize(new Dimension(10, 15));
		}
		return jSeparator61211;
	}

	/**
	 * This method initializes jSeparator61311
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61311() {
		if (jSeparator61311 == null) {
			jSeparator61311 = new JSeparator();
			jSeparator61311.setLocation(new Point(369, 234));
			jSeparator61311.setOrientation(SwingConstants.VERTICAL);
			jSeparator61311.setSize(new Dimension(10, 12));
		}
		return jSeparator61311;
	}

	/**
	 * This method initializes jSeparator9111111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9111111() {
		if (jSeparator9111111 == null) {
			jSeparator9111111 = new JSeparator();
			jSeparator9111111.setSize(new Dimension(241, 10));
			jSeparator9111111.setLocation(new Point(369, 246));
		}
		return jSeparator9111111;
	}

	/**
	 * This method initializes jSeparator911211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911211() {
		if (jSeparator911211 == null) {
			jSeparator911211 = new JSeparator();
			jSeparator911211.setBounds(new Rectangle(368, 194, 242, 10));
		}
		return jSeparator911211;
	}

	/**
	 * This method initializes jSeparator6111111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6111111() {
		if (jSeparator6111111 == null) {
			jSeparator6111111 = new JSeparator();
			jSeparator6111111.setLocation(new Point(610, 195));
			jSeparator6111111.setOrientation(SwingConstants.VERTICAL);
			jSeparator6111111.setSize(new Dimension(10, 51));
		}
		return jSeparator6111111;
	}

	/**
	 * This method initializes jSeparatorS83321
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83321() {
		if (jSeparatorS83321 == null) {
			jSeparatorS83321 = new JSeparator();
			jSeparatorS83321.setLocation(new Point(13, 291));
			jSeparatorS83321.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83321.setSize(new Dimension(10, 22));
		}
		return jSeparatorS83321;
	}

	/**
	 * This method initializes jSeparatorS102331
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS102331() {
		if (jSeparatorS102331 == null) {
			jSeparatorS102331 = new JSeparator();
			jSeparatorS102331.setLocation(new Point(13, 290));
			jSeparatorS102331.setSize(new Dimension(185, 10));
		}
		return jSeparatorS102331;
	}

	/**
	 * This method initializes jSeparatorS833121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS833121() {
		if (jSeparatorS833121 == null) {
			jSeparatorS833121 = new JSeparator();
			jSeparatorS833121.setLocation(new Point(198, 291));
			jSeparatorS833121.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS833121.setSize(new Dimension(10, 22));
		}
		return jSeparatorS833121;
	}

	/**
	 * This method initializes jSeparatorS1023111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1023111() {
		if (jSeparatorS1023111 == null) {
			jSeparatorS1023111 = new JSeparator();
			jSeparatorS1023111.setSize(new Dimension(186, 10));
			jSeparatorS1023111.setLocation(new Point(13, 313));
		}
		return jSeparatorS1023111;
	}

	/**
	 * This method initializes jSeparator611241
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611241() {
		if (jSeparator611241 == null) {
			jSeparator611241 = new JSeparator();
			jSeparator611241.setLocation(new Point(104, 275));
			jSeparator611241.setOrientation(SwingConstants.VERTICAL);
			jSeparator611241.setSize(new Dimension(10, 15));
		}
		return jSeparator611241;
	}

	/**
	 * This method initializes jSeparator6112111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6112111() {
		if (jSeparator6112111 == null) {
			jSeparator6112111 = new JSeparator();
			jSeparator6112111.setLocation(new Point(104, 314));
			jSeparator6112111.setOrientation(SwingConstants.VERTICAL);
			jSeparator6112111.setSize(new Dimension(10, 12));
		}
		return jSeparator6112111;
	}

	/**
	 * This method initializes jSeparator9111231
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9111231() {
		if (jSeparator9111231 == null) {
			jSeparator9111231 = new JSeparator();
			jSeparator9111231.setLocation(new Point(105, 274));
			jSeparator9111231.setSize(new Dimension(203, 10));
		}
		return jSeparator9111231;
	}

	/**
	 * This method initializes jSeparator91112111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91112111() {
		if (jSeparator91112111 == null) {
			jSeparator91112111 = new JSeparator();
			jSeparator91112111.setLocation(new Point(105, 326));
			jSeparator91112111.setSize(new Dimension(204, 10));
		}
		return jSeparator91112111;
	}

	/**
	 * This method initializes jSeparator6112221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6112221() {
		if (jSeparator6112221 == null) {
			jSeparator6112221 = new JSeparator();
			jSeparator6112221.setLocation(new Point(308, 275));
			jSeparator6112221.setOrientation(SwingConstants.VERTICAL);
			jSeparator6112221.setSize(new Dimension(10, 52));
		}
		return jSeparator6112221;
	}

	/**
	 * This method initializes jSeparatorS8331121
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS8331121() {
		if (jSeparatorS8331121 == null) {
			jSeparatorS8331121 = new JSeparator();
			jSeparatorS8331121.setLocation(new Point(330, 291));
			jSeparatorS8331121.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS8331121.setSize(new Dimension(10, 22));
		}
		return jSeparatorS8331121;
	}

	/**
	 * This method initializes jSeparatorS1023211
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS1023211() {
		if (jSeparatorS1023211 == null) {
			jSeparatorS1023211 = new JSeparator();
			jSeparatorS1023211.setSize(new Dimension(130, 10));
			jSeparatorS1023211.setLocation(new Point(331, 290));
		}
		return jSeparatorS1023211;
	}

	/**
	 * This method initializes jSeparatorS83311111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS83311111() {
		if (jSeparatorS83311111 == null) {
			jSeparatorS83311111 = new JSeparator();
			jSeparatorS83311111.setLocation(new Point(461, 291));
			jSeparatorS83311111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorS83311111.setSize(new Dimension(10, 22));
		}
		return jSeparatorS83311111;
	}

	/**
	 * This method initializes jSeparatorS10211111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10211111() {
		if (jSeparatorS10211111 == null) {
			jSeparatorS10211111 = new JSeparator();
			jSeparatorS10211111.setSize(new Dimension(132, 10));
			jSeparatorS10211111.setLocation(new Point(330, 313));
		}
		return jSeparatorS10211111;
	}

	/**
	 * This method initializes jSeparator6112321
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator6112321() {
		if (jSeparator6112321 == null) {
			jSeparator6112321 = new JSeparator();
			jSeparator6112321.setLocation(new Point(369, 275));
			jSeparator6112321.setOrientation(SwingConstants.VERTICAL);
			jSeparator6112321.setSize(new Dimension(10, 15));
		}
		return jSeparator6112321;
	}

	/**
	 * This method initializes jSeparator61123111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61123111() {
		if (jSeparator61123111 == null) {
			jSeparator61123111 = new JSeparator();
			jSeparator61123111.setLocation(new Point(369, 314));
			jSeparator61123111.setOrientation(SwingConstants.VERTICAL);
			jSeparator61123111.setSize(new Dimension(10, 12));
		}
		return jSeparator61123111;
	}

	/**
	 * This method initializes jSeparator91112221
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator91112221() {
		if (jSeparator91112221 == null) {
			jSeparator91112221 = new JSeparator();
			jSeparator91112221.setLocation(new Point(369, 274));
			jSeparator91112221.setSize(new Dimension(241, 10));
		}
		return jSeparator91112221;
	}

	/**
	 * This method initializes jSeparator911122111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911122111() {
		if (jSeparator911122111 == null) {
			jSeparator911122111 = new JSeparator();
			jSeparator911122111.setSize(new Dimension(241, 10));
			jSeparator911122111.setLocation(new Point(369, 326));
		}
		return jSeparator911122111;
	}

	/**
	 * This method initializes jSeparator61122111
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator61122111() {
		if (jSeparator61122111 == null) {
			jSeparator61122111 = new JSeparator();
			jSeparator61122111.setLocation(new Point(610, 275));
			jSeparator61122111.setOrientation(SwingConstants.VERTICAL);
			jSeparator61122111.setSize(new Dimension(10, 52));
		}
		return jSeparator61122111;
	}

	/**
	 * This method initializes jCheckBoxArvoreArquivoSaidaDesenhar
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxArvoreArquivoSaidaDesenhar() {
		if (jCheckBoxArvoreArquivoSaidaDesenhar == null) {
			jCheckBoxArvoreArquivoSaidaDesenhar = new JCheckBox();
			jCheckBoxArvoreArquivoSaidaDesenhar.setLocation(new Point(220, 292));
			jCheckBoxArvoreArquivoSaidaDesenhar.setOpaque(false);
			jCheckBoxArvoreArquivoSaidaDesenhar.setText("Desenhar");
			jCheckBoxArvoreArquivoSaidaDesenhar.setSelected(true);
			jCheckBoxArvoreArquivoSaidaDesenhar.setSize(new Dimension(88, 21));
		}
		return jCheckBoxArvoreArquivoSaidaDesenhar;
	}

	/**
	 * This method initializes jCheckBoxEspeciesArquivoSaidaIndicar
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxEspeciesArquivoSaidaIndicar() {
		if (jCheckBoxEspeciesArquivoSaidaIndicar == null) {
			jCheckBoxEspeciesArquivoSaidaIndicar = new JCheckBox();
			jCheckBoxEspeciesArquivoSaidaIndicar.setLocation(new Point(220, 210));
			jCheckBoxEspeciesArquivoSaidaIndicar.setOpaque(false);
			jCheckBoxEspeciesArquivoSaidaIndicar.setText("Indicar");
			jCheckBoxEspeciesArquivoSaidaIndicar.setSize(new Dimension(85, 23));
			jCheckBoxEspeciesArquivoSaidaIndicar.setSelected(true);
			jCheckBoxEspeciesArquivoSaidaIndicar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jCheckBoxEspeciesArquivoSaidaIndicar;
	}

	/**
	 * This method initializes jRadioButtonRaizSim
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRaizSim() {
		if (jRadioButtonRaizSim == null) {
			jRadioButtonRaizSim = new JRadioButton();
			jRadioButtonRaizSim.setBounds(new Rectangle(453, 61, 64, 21));
			jRadioButtonRaizSim.setOpaque(false);
			jRadioButtonRaizSim.setSelected(true);
			jRadioButtonRaizSim.setText("Sim");
		}
		return jRadioButtonRaizSim;
	}

	/**
	 * This method initializes jRadioButtonRaizNao
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRaizNao() {
		if (jRadioButtonRaizNao == null) {
			jRadioButtonRaizNao = new JRadioButton();
			jRadioButtonRaizNao.setText("Não");
			jRadioButtonRaizNao.setSize(new Dimension(69, 23));
			jRadioButtonRaizNao.setLocation(new Point(538, 61));
			jRadioButtonRaizNao.setOpaque(false);
		}
		return jRadioButtonRaizNao;
	}

	/**
	 * This method initializes jNumberFieldMaiorAncestral
	 *
	 * @return br.uesc.computacao.estagio.util.JNumberField
	 */
	public JNumberField getJNumberFieldMaiorAncestral() {
		if (jNumberFieldMaiorAncestral == null) {
			jNumberFieldMaiorAncestral = new JNumberField();
			jNumberFieldMaiorAncestral.setLocation(new Point(440, 139));
			jNumberFieldMaiorAncestral.setSize(new Dimension(57, 20));
		}
		return jNumberFieldMaiorAncestral;
	}

	/**
	 * This method initializes jCheckBoxExecucaoIndicar
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxExecucaoIndicar() {
		if (jCheckBoxExecucaoIndicar == null) {
			jCheckBoxExecucaoIndicar = new JCheckBox();
			jCheckBoxExecucaoIndicar.setText("Indicar");
			jCheckBoxExecucaoIndicar.setSize(new Dimension(91, 23));
			jCheckBoxExecucaoIndicar.setLocation(new Point(488, 210));
			jCheckBoxExecucaoIndicar.setOpaque(false);
			jCheckBoxExecucaoIndicar.setSelected(true);
			jCheckBoxExecucaoIndicar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jCheckBoxExecucaoIndicar;
	}

	/**
	 * This method initializes jNumberFieldFracaoTempo
	 *
	 * @return br.uesc.computacao.estagio.util.JNumberField
	 */
	public JNumberFloatField getJNumberFloatFieldFracaoTempo() {
		if (jNumberFieldFracaoTempo == null) {
			jNumberFieldFracaoTempo = new JNumberFloatField();
			jNumberFieldFracaoTempo.setLocation(new Point(475, 294));
			jNumberFieldFracaoTempo.setEnabled(false);
			jNumberFieldFracaoTempo.setText("");
			jNumberFieldFracaoTempo.setSize(new Dimension(57, 20));
		}
		return jNumberFieldFracaoTempo;
	}

	/**
	 * This method initializes jSeparator911124
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator911124() {
		if (jSeparator911124 == null) {
			jSeparator911124 = new JSeparator();
			jSeparator911124.setLocation(new Point(17, 274));
			jSeparator911124.setSize(new Dimension(177, 10));
		}
		return jSeparator911124;
	}

	/**
	 * This method initializes jSeparator611223
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611223() {
		if (jSeparator611223 == null) {
			jSeparator611223 = new JSeparator();
			jSeparator611223.setOrientation(SwingConstants.VERTICAL);
			jSeparator611223.setLocation(new Point(16, 275));
			jSeparator611223.setSize(new Dimension(10, 51));
		}
		return jSeparator611223;
	}

	/**
	 * This method initializes jSeparator611224
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator611224() {
		if (jSeparator611224 == null) {
			jSeparator611224 = new JSeparator();
			jSeparator611224.setOrientation(SwingConstants.VERTICAL);
			jSeparator611224.setSize(new Dimension(10, 51));
			jSeparator611224.setLocation(new Point(194, 275));
		}
		return jSeparator611224;
	}

	/**
	 * This method initializes jSeparator9111241
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator9111241() {
		if (jSeparator9111241 == null) {
			jSeparator9111241 = new JSeparator();
			jSeparator9111241.setSize(new Dimension(179, 10));
			jSeparator9111241.setLocation(new Point(16, 326));
		}
		return jSeparator9111241;
	}

	/**
	 * This method initializes jCheckBoxMultiplosArquivosSaidaPeso
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxMultiplosArquivosSaidaPesos() {
		if (jCheckBoxMultiplosArquivosSaidaPesos == null) {
			jCheckBoxMultiplosArquivosSaidaPesos = new JCheckBox();
			jCheckBoxMultiplosArquivosSaidaPesos.setText("Pesos");
			jCheckBoxMultiplosArquivosSaidaPesos.setSize(new Dimension(94, 23));
			jCheckBoxMultiplosArquivosSaidaPesos.setLocation(new Point(342, 281));
			jCheckBoxMultiplosArquivosSaidaPesos.setOpaque(false);
			jCheckBoxMultiplosArquivosSaidaPesos.setActionCommand("Peso");
			jCheckBoxMultiplosArquivosSaidaPesos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jCheckBoxMultiplosArquivosSaidaPesos;
	}

	/**
	 * This method initializes jCheckBoxFracaoTempoUsar
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxFracaoTempoUsar() {
		if (jCheckBoxFracaoTempoUsar == null) {
			jCheckBoxFracaoTempoUsar = new JCheckBox();
			jCheckBoxFracaoTempoUsar.setText("Usar");
			jCheckBoxFracaoTempoUsar.setLocation(new Point(545, 294));
			jCheckBoxFracaoTempoUsar.setOpaque(false);
			jCheckBoxFracaoTempoUsar.setSize(new Dimension(61, 21));
		}
		return jCheckBoxFracaoTempoUsar;
	}

	/**
	 * This method initializes jCheckBoxMultiplosArquivosSaidaDados
	 *
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxMultiplosArquivosSaidaDados() {
		if (jCheckBoxMultiplosArquivosSaidaDados == null) {
			jCheckBoxMultiplosArquivosSaidaDados = new JCheckBox();
			jCheckBoxMultiplosArquivosSaidaDados.setOpaque(false);
			jCheckBoxMultiplosArquivosSaidaDados.setSize(new Dimension(81, 21));
			jCheckBoxMultiplosArquivosSaidaDados.setLocation(new Point(242, 281));
			jCheckBoxMultiplosArquivosSaidaDados.setText("Dados");
		}
		return jCheckBoxMultiplosArquivosSaidaDados;
	}

	public JLabel getJLabelAmostras() {
		return jLabelAmostras;
	}

	public JLabel getJLabelArquivoMisturado() {
		return jLabelArquivoMisturado;
	}

	public JLabel getJLabelArvore() {
		return jLabelArvore;
	}

	public JLabel getJLabelAvaliacao() {
		return jLabelAvaliacao;
	}

	public JLabel getJLabelBloco() {
		return jLabelBloco;
	}

	public JLabel getJLabelArvoreArquivoSaida() {
		return jLabelArvoreArquivoSaida;
	}

	public JLabel getJLabelCategoriaSitios() {
		return jLabelCategoriaSitios;
	}

	public JLabel getJLabelEspeciesArquivoSaida() {
		return jLabelEspeciesArquivoSaida;
	}

	public JLabel getJLabelExecucao() {
		return jLabelExecucao;
	}

	public JLabel getJLabelFormato() {
		return jLabelFormato;
	}

	public JLabel getJLabelSemente() {
		return jLabelSemente;
	}

	public JLabel getJLabelFormatoSaida() {
		return jLabelFormatoSaida;
	}

	public JLabel getJLabelFracaoTempo() {
		return jLabelFracaoTempo;
	}

	public JLabel getJLabelMaiorAncestral() {
		return jLabelMaiorAncestral;
	}

	public JLabel getJLabelModelo() {
		return jLabelModelo;
	}

	public JLabel getJLabelArquivoAncestral() {
		return jLabelArquivoAncestral;
	}

	public JLabel getJLabelMultiplosArquivosSaida() {
		return jLabelMultiplosArquivosSaida;
	}

	public JLabel getJLabelPesos() {
		return jLabelPesos;
	}

	public JLabel getJLabelPorcento() {
		return jLabelPorcento;
	}

	public JLabel getJLabelRaiz() {
		return jLabelRaiz;
	}

	public JLabel getJLabelReplicas() {
		return jLabelReplicas;
	}


}

