package br.uesc.computacao.estagio.apresentacao.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

import br.uesc.computacao.estagio.aplicacao.util.JBorderedPanel;
import br.uesc.computacao.estagio.aplicacao.util.JNumberField;
import br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField;
import javax.swing.JProgressBar;

/**
 * Classe que gera a tela do phyml
 * 
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena
 *         Torres Delgado
 * @version 2.0
 */

public class PHYML extends JFrame {

	/**
	 * Variaveis Globais
	 */
    
    public static int x;
    public static int y;
	private static final long serialVersionUID = 1L;

	public JBorderedPanel jBorderedPanelValorBootstrap;
	
	private String oldImagesPath = "/br/uesc/computacao/estagio/apresentacao/figuras/";
	
	private ImageIcon imagemAA = null;

	private ImageIcon imagemDNA = null;

	private JButton jButtonArquivoArvore = null;

	private JButton jButtonArquivoSequencia = null;

	private JButton jButtonEditor = null;

	private JButton jButtonExecutar = null;

	private JButton jButtonTipoExecucao = null;

	private JButton jButtonVisualizar = null;

	private JButton jButtonVoltar = null;

        private JButton jButtonInicio = null; // Botão para retornar à janela de entrada

	private JCheckBoxMenuItem jCheckBoxMenuItemIngles = null;

	private JCheckBoxMenuItem jCheckBoxMenuItemPortugues = null;

	private JCheckBox jCheckBoxTipoExecucaoParalelo = null;

	private JComboBox jComboBoxTipoExecucaoParalelo = null;

	private JComboBox jComboBoxTipoExecucaoSequencial = null;

	private JPanel jContentPane = null;

	private JPanel jContentPaneBootstrap = null;

	private JDialog jDialogTipoExecucao = null; // @jve:decl-index=0:visual-constraint="10,2049"

	private JMenuBar jJMenuBar = null;

	private JLabel jLabelArquivoArvore = null;
	
	private JLabel jLabelTipoBootstrap;
	
	private JLabel jLabelValorBootstrap;
	
	private JTextField jTextFieldValorBootstrap;
	
	private JRadioButton jRadioButtonBootstrapInterno;
	
	private JRadioButton jRadioButtonBootstrapExterno;

	private JLabel jLabelArquivoSequencia = null;

	private JLabel jLabelGamaDayhoff = null;

	private JLabel jLabelGamaDCMut = null;

	private JLabel jLabelGamaF81 = null;

	private JLabel jLabelGamaF84 = null;

	public JLabel jLabelGamaGTR = null;

	private JLabel jLabelGamaHKY = null;

	private JLabel jLabelGamaJC69 = null;

	private JLabel jLabelGamaJTT = null;

	private JLabel jLabelGamaK2P = null;

	private JLabel jLabelGamaMtREV = null;

	private JLabel jLabelGamaTN93 = null;

	private JLabel jLabelGamaWAG = null;

	private JLabel jLabelModeloSelecionadoDayhoff = null;

	private JLabel jLabelModeloSelecionadoDCMut = null;

	private JLabel jLabelModeloSelecionadoF81 = null;

	private JLabel jLabelModeloSelecionadoF84 = null;

	public JLabel jLabelModeloSelecionadoGTR = null;

	private JLabel jLabelModeloSelecionadoHKY = null;

	private JLabel jLabelModeloSelecionadoJC69 = null;

	private JLabel jLabelModeloSelecionadoJTT = null;

	private JLabel jLabelModeloSelecionadoK2P = null;

	private JLabel jLabelModeloSelecionadoMtREV = null;

	private JLabel jLabelModeloSelecionadoTN93 = null;

	private JLabel jLabelModeloSelecionadoWAG = null;

	public JLabel jLabelModeloUtilizadoDayhoff = null;

	public JLabel jLabelModeloUtilizadoDCMut = null;

	public JLabel jLabelModeloUtilizadoF81 = null;

	public JLabel jLabelModeloUtilizadoF84 = null;

	public JLabel jLabelModeloUtilizadoGTR = null;

	public JLabel jLabelModeloUtilizadoHKY = null;

	public JLabel jLabelModeloUtilizadoJC69 = null;

	public JLabel jLabelModeloUtilizadoJTT = null;

	public JLabel jLabelModeloUtilizadoK2P = null;

	public JLabel jLabelModeloUtilizadoMtREV = null;

	public JLabel jLabelModeloUtilizadoTN93 = null;

	public JLabel jLabelModeloUtilizadoWAG = null;

	private JLabel jLabelProporcaoDayhoff = null;

	private JLabel jLabelProporcaoDCMut = null;

	private JLabel jLabelProporcaoF81 = null;

	private JLabel jLabelProporcaoF84 = null;

	public JLabel jLabelProporcaoGTR = null;

	private JLabel jLabelProporcaoHKY = null;

	private JLabel jLabelProporcaoJC69 = null;

	private JLabel jLabelProporcaoJTT = null;

	private JLabel jLabelProporcaoK2P = null;

	private JLabel jLabelProporcaoMtREV = null;

	private JLabel jLabelProporcaoTN93 = null;

	private JLabel jLabelProporcaoWAG = null;

	private JLabel jLabelRelacaoF81 = null;

	private JLabel jLabelRelacaoF84 = null;

	public JLabel jLabelRelacaoGTR = null;

	private JLabel jLabelRelacaoHKY = null;

	private JLabel jLabelRelacaoJC69 = null;

	private JLabel jLabelRelacaoK2P = null;

	private JLabel jLabelRelacaoTN93 = null;

	private JLabel jLabelTaxaArvore = null;

	private JLabel jLabelTaxaDayhoff = null;

	private JLabel jLabelTaxaDCMut = null;

	private JLabel jLabelTaxaF81 = null;

	private JLabel jLabelTaxaF84 = null;

	public JLabel jLabelTaxaGTR = null;

	private JLabel jLabelTaxaHKY = null;

	private JLabel jLabelTaxaJC69 = null;

	private JLabel jLabelTaxaJTT = null;

	private JLabel jLabelTaxaK2P = null;

	private JLabel jLabelTaxaMtREV = null;

	private JLabel jLabelTaxaTN93 = null;

	private JLabel jLabelTaxaWAG = null;

	private JLabel jLabelTipoArquivo = null;

	private JLabel jLabelTipoExecucaoParalelo = null;

	private JLabel jLabelTipoExecucaoSequencial = null;

	private JLabel jLabelTopologiaArvore = null;

	private JMenu jMenuArquivo = null;

	private JMenu jMenuConfiguracoes = null;

	private JMenu jMenuIdiomas = null;

	private JMenuItem jMenuItemCriarPerfil = null;

	private JMenuItem jMenuItemDeletarPerfil = null;

	private JMenuItem jMenuItemFechar = null;

	private JMenu jMenuPerfil = null;

	private JNumberFloatField jNumberFloatFieldGamaDayhoff = null;

	private JNumberFloatField jNumberFloatFieldGamaDCMut = null;

	private JNumberFloatField jNumberFloatFieldGamaF81 = null;

	private JNumberFloatField jNumberFloatFieldGamaF84 = null;

	private JNumberFloatField jNumberFloatFieldGamaGTR = null;

	private JNumberFloatField jNumberFloatFieldGamaHKY = null;

	private JNumberFloatField jNumberFloatFieldGamaJC69 = null;

	private JNumberFloatField jNumberFloatFieldGamaJTT = null;

	private JNumberFloatField jNumberFloatFieldGamaK2P = null;

	private JNumberFloatField jNumberFloatFieldGamaMtREV = null;

	private JNumberFloatField jNumberFloatFieldGamaTN93 = null;

	private JNumberFloatField jNumberFloatFieldGamaWAG = null;

	private JNumberFloatField jNumberFloatFieldProporcaoDayhoff = null;

	private JNumberFloatField jNumberFloatFieldProporcaoDCMut = null;

	private JNumberFloatField jNumberFloatFieldProporcaoF81 = null;

	private JNumberFloatField jNumberFloatFieldProporcaoF84 = null;

	private JNumberFloatField jNumberFloatFieldProporcaoGTR = null;

	private JNumberFloatField jNumberFloatFieldProporcaoHKY = null;

	private JNumberFloatField jNumberFloatFieldProporcaoJC69 = null;

	private JNumberFloatField jNumberFloatFieldProporcaoJTT = null;

	private JNumberFloatField jNumberFloatFieldProporcaoK2P = null;

	private JNumberFloatField jNumberFloatFieldProporcaoMtREV = null;

	private JNumberFloatField jNumberFloatFieldProporcaoTN93 = null;

	private JNumberFloatField jNumberFloatFieldProporcaoWAG = null;

	private JNumberFloatField jNumberFloatFieldRelacaoF81 = null;

	private JNumberFloatField jNumberFloatFieldRelacaoF84 = null;

	private JNumberFloatField jNumberFloatFieldRelacaoGTR = null;

	private JNumberFloatField jNumberFloatFieldRelacaoHKY = null;

	private JNumberFloatField jNumberFloatFieldRelacaoJC69 = null;

	private JNumberFloatField jNumberFloatFieldRelacaoK2P = null;

	private JNumberFloatField jNumberFloatFieldRelacaoTN93 = null;

	private JNumberFloatField jNumberFloatFieldTaxaDayhoff = null;

	private JNumberFloatField jNumberFloatFieldTaxaDCMut = null;

	private JNumberFloatField jNumberFloatFieldTaxaF81 = null;

	private JNumberFloatField jNumberFloatFieldTaxaF84 = null;

	private JNumberFloatField jNumberFloatFieldTaxaGTR = null;

	private JNumberFloatField jNumberFloatFieldTaxaHKY = null;

	private JNumberFloatField jNumberFloatFieldTaxaJC69 = null;

	private JNumberFloatField jNumberFloatFieldTaxaJTT = null;

	private JNumberFloatField jNumberFloatFieldTaxaK2P = null;

	private JNumberFloatField jNumberFloatFieldTaxaMtREV = null;

	private JNumberFloatField jNumberFloatFieldTaxaTN93 = null;

	private JNumberFloatField jNumberFloatFieldTaxaWAG = null;

	private JPanel jPanelAA = null;

	private JPanel jPanelArvore = null;

	private JPanel jPaneLArvore = null;

	private JPanel jPanelDayhoff = null;

	private JPanel jPanelDCMut = null;

	private JPanel jPanelDNA = null;

	private JPanel jPanelF81 = null; // @jve:decl-index=0:visual-constraint="227,974"

	private JPanel jPanelF84 = null;

	private JPanel jPanelGTR = null; // @jve:decl-index=0:visual-constraint="231,1007"

	private JPanel jPanelHKY = null;

	private JPanel jPanelJC69 = null;

	private JPanel jPanelJTT = null;

	private JPanel jPanelK2P = null;

	private JPanel jPanelMtREV = null;

	private JPanel jPanelSequencia = null;

	private JPanel jPanelTipoExecucaoParalelo = null;

	private JPanel jPanelTipoExecucaoSequencial = null;

	private JPanel jPanelTN93 = null;

	private JPanel jPanelWAG = null;

	private JProgressBar jProgressBar = null;

	private JRadioButton jRadioButtonGamaEstimadoDayhoff = null;

	private JRadioButton jRadioButtonGamaEstimadoDCMut = null;

	private JRadioButton jRadioButtonGamaEstimadoF81 = null;

	private JRadioButton jRadioButtonGamaEstimadoF84 = null;

	private JRadioButton jRadioButtonGamaEstimadoGTR = null;

	private JRadioButton jRadioButtonGamaEstimadoHKY = null;

	private JRadioButton jRadioButtonGamaEstimadoJC69 = null;

	private JRadioButton jRadioButtonGamaEstimadoJTT = null;

	private JRadioButton jRadioButtonGamaEstimadoK2P = null;

	private JRadioButton jRadioButtonGamaEstimadoMtREV = null;

	private JRadioButton jRadioButtonGamaEstimadoTN93 = null;

	private JRadioButton jRadioButtonGamaEstimadoWAG = null;

	private JRadioButton jRadioButtonGamaFixoDayhoff = null;

	private JRadioButton jRadioButtonGamaFixoDCMut = null;

	private JRadioButton jRadioButtonGamaFixoF81 = null;

	private JRadioButton jRadioButtonGamaFixoF84 = null;

	private JRadioButton jRadioButtonGamaFixoGTR = null;

	private JRadioButton jRadioButtonGamaFixoHKY = null;

	private JRadioButton jRadioButtonGamaFixoJC69 = null;

	private JRadioButton jRadioButtonGamaFixoJTT = null;

	private JRadioButton jRadioButtonGamaFixoK2P = null;

	private JRadioButton jRadioButtonGamaFixoMtREV = null;

	private JRadioButton jRadioButtonGamaFixoTN93 = null;

	private JRadioButton jRadioButtonGamaFixoWAG = null;

	private JRadioButton jRadioButtonIntercalado = null;

	private JRadioButton jRadioButtonProporcaoEstimadoDayhoff = null;

	private JRadioButton jRadioButtonProporcaoEstimadoDCMut = null;

	private JRadioButton jRadioButtonProporcaoEstimadoF81 = null;

	private JRadioButton jRadioButtonProporcaoEstimadoF84 = null;

	private JRadioButton jRadioButtonProporcaoEstimadoGTR = null;

	private JRadioButton jRadioButtonProporcaoEstimadoHKY = null;

	private JRadioButton jRadioButtonProporcaoEstimadoJC69 = null;

	private JRadioButton jRadioButtonProporcaoEstimadoJTT = null;

	private JRadioButton jRadioButtonProporcaoEstimadoK2P = null;

	private JRadioButton jRadioButtonProporcaoEstimadoMtREV = null;

	private JRadioButton jRadioButtonProporcaoEstimadoTN93 = null;

	private JRadioButton jRadioButtonProporcaoEstimadoWAG = null;

	private JRadioButton jRadioButtonProporcaoFixoDayhoff = null;

	private JRadioButton jRadioButtonProporcaoFixoDCMut = null;

	private JRadioButton jRadioButtonProporcaoFixoF81 = null;

	private JRadioButton jRadioButtonProporcaoFixoF84 = null;

	private JRadioButton jRadioButtonProporcaoFixoGTR = null;

	private JRadioButton jRadioButtonProporcaoFixoHKY = null;

	private JRadioButton jRadioButtonProporcaoFixoJC69 = null;

	private JRadioButton jRadioButtonProporcaoFixoJTT = null;

	private JRadioButton jRadioButtonProporcaoFixoK2P = null;

	private JRadioButton jRadioButtonProporcaoFixoMtREV = null;

	private JRadioButton jRadioButtonProporcaoFixoTN93 = null;

	private JRadioButton jRadioButtonProporcaoFixoWAG = null;

	private JRadioButton jRadioButtonRelacaoEstimadoF81 = null;

	private JRadioButton jRadioButtonRelacaoEstimadoF84 = null;

	private JRadioButton jRadioButtonRelacaoEstimadoGTR = null;

	private JRadioButton jRadioButtonRelacaoEstimadoHKY = null;

	private JRadioButton jRadioButtonRelacaoEstimadoJC69 = null;

	private JRadioButton jRadioButtonRelacaoEstimadoK2P = null;

	private JRadioButton jRadioButtonRelacaoEstimadoTN93 = null;

	private JRadioButton jRadioButtonRelacaoFixoF81 = null;

	private JRadioButton jRadioButtonRelacaoFixoF84 = null;

	private JRadioButton jRadioButtonRelacaoFixoGTR = null;

	private JRadioButton jRadioButtonRelacaoFixoHKY = null;

	private JRadioButton jRadioButtonRelacaoFixoJC69 = null;

	private JRadioButton jRadioButtonRelacaoFixoK2P = null;

	private JRadioButton jRadioButtonRelacaoFixoTN93 = null;

	private JRadioButton jRadioButtonSequencial = null;

	private JRadioButton jRadioButtonTaxaArvoreNao = null;

	private JRadioButton jRadioButtonTaxaArvoreSim = null;

	private JRadioButton jRadioButtonTipoDadoAA = null;

	private JRadioButton jRadioButtonTipoDadoDNA = null;

	private JRadioButton jRadioButtonTopologiaArvoreArquivo = null;

	private JRadioButton jRadioButtonTopologiaArvoreBIONJ = null;

	private JRadioButton jRadioButtonTopologiaArvoreNao = null;

	private JRadioButton jRadioButtonTopologiaArvoreSim = null;

	private JRadioButton jRadioButtonUtilizarModeloDayhoff = null;

	private JRadioButton jRadioButtonUtilizarModeloDCMut = null;

	private JRadioButton jRadioButtonUtilizarModeloF81 = null;

	private JRadioButton jRadioButtonUtilizarModeloF84 = null;

	private JRadioButton jRadioButtonUtilizarModeloGTR = null;

	private JRadioButton jRadioButtonUtilizarModeloHKY = null;

	private JRadioButton jRadioButtonUtilizarModeloJC69 = null;

	private JRadioButton jRadioButtonUtilizarModeloJTT = null;

	private JRadioButton jRadioButtonUtilizarModeloK2P = null;

	private JRadioButton jRadioButtonUtilizarModeloMtREV = null;

	private JRadioButton jRadioButtonUtilizarModeloTN93 = null;

	private JRadioButton jRadioButtonUtilizarModeloWAG = null;

	
	private JSeparator jSeparatorArvore01 = null;

	private JSeparator jSeparatorArvore101 = null;

	private JSeparator jSeparatorArvore111 = null;

	private JSeparator jSeparatorArvore121 = null;

	private JSeparator jSeparatorArvore131 = null;

	private JSeparator jSeparatorArvore141 = null;

	private JSeparator jSeparatorArvore15 = null;

	private JSeparator jSeparatorArvore21 = null;

	private JSeparator jSeparatorArvore31 = null;

	private JSeparator jSeparatorArvore41 = null;

	private JSeparator jSeparatorArvore51 = null;

	private JSeparator jSeparatorArvore61 = null;

	private JSeparator jSeparatorArvore71 = null;

	private JSeparator jSeparatorArvore81 = null;

	private JSeparator jSeparatorArvore91 = null;

	private JSeparator jSeparatorArvoreS01 = null;

	private JSeparator jSeparatorArvoreS101 = null;

	private JSeparator jSeparatorArvoreS111 = null;

	private JSeparator jSeparatorArvoreS12 = null;

	private JSeparator jSeparatorArvoreS21 = null;

	private JSeparator jSeparatorArvoreS31 = null;

	private JSeparator jSeparatorArvoreS41 = null;

	private JSeparator jSeparatorArvoreS51 = null;

	private JSeparator jSeparatorArvoreS61 = null;

	private JSeparator jSeparatorArvoreS71 = null;

	private JSeparator jSeparatorArvoreS81 = null;

	private JSeparator jSeparatorArvoreS91 = null;

	private JSeparator jSeparatorBootstrap19 = null;

	private JSeparator jSeparatorBootstrap191 = null;

	private JSeparator jSeparatorBootstrap20 = null;

	private JSeparator jSeparatorBootstrap201 = null;

	private JSeparator jSeparatorBootstrap21 = null;

	private JSeparator jSeparatorBootstrap211 = null;

	private JSeparator jSeparatorBootstrap22 = null;

	private JSeparator jSeparatorBootstrap221 = null;

	private JSeparator jSeparatorBootstrap23 = null;

	private JSeparator jSeparatorBootstrap231 = null;

	private JSeparator jSeparatorBootstrap24 = null;

	private JSeparator jSeparatorBootstrap241 = null;

	private JSeparator jSeparatorBootstrap7 = null;

	private JSeparator jSeparatorBootstrap71 = null;

	private JSeparator jSeparatorBootstrap8 = null;

	private JSeparator jSeparatorBootstrap81 = null;

	private JSeparator jSeparatorBootstrap9 = null;

	private JSeparator jSeparatorBootstrap91 = null;

	private JSeparator jSeparatorDayhoff01 = null;

	private JSeparator jSeparatorDayhoff02 = null;

	private JSeparator jSeparatorDayhoff03 = null;

	private JSeparator jSeparatorDayhoff04 = null;

	private JSeparator jSeparatorDayhoff05 = null;

	private JSeparator jSeparatorDayhoff1 = null;

	private JSeparator jSeparatorDayhoff11 = null;

	private JSeparator jSeparatorDayhoff110 = null;

	private JSeparator jSeparatorDayhoff12 = null;

	private JSeparator jSeparatorDayhoff13 = null;

	private JSeparator jSeparatorDayhoff14 = null;

	private JSeparator jSeparatorDayhoff15 = null;

	private JSeparator jSeparatorDayhoff16 = null;

	private JSeparator jSeparatorDayhoff17 = null;

	private JSeparator jSeparatorDayhoff18 = null;

	private JSeparator jSeparatorDayhoff19 = null;

	private JSeparator jSeparatorDayhoff20 = null;

	private JSeparator jSeparatorDayhoff21 = null;

	private JSeparator jSeparatorDayhoff22 = null;

	private JSeparator jSeparatorDayhoff23 = null;

	private JSeparator jSeparatorDayhoff24 = null;

	private JSeparator jSeparatorDayhoff25 = null;

	private JSeparator jSeparatorDayhoffM10 = null;

	private JSeparator jSeparatorDayhoffM11 = null;

	private JSeparator jSeparatorDayhoffM12 = null;

	private JSeparator jSeparatorDayhoffM13 = null;

	private JSeparator jSeparatorDayhoffM14 = null;

	private JSeparator jSeparatorDayhoffM15 = null;

	private JSeparator jSeparatorDayhoffM16 = null;

	private JSeparator jSeparatorDayhoffM2 = null;

	private JSeparator jSeparatorDayhoffM3 = null;

	private JSeparator jSeparatorDayhoffM4 = null;

	private JSeparator jSeparatorDayhoffM5 = null;

	private JSeparator jSeparatorDayhoffM6 = null;

	private JSeparator jSeparatorDayhoffM7 = null;

	private JSeparator jSeparatorDayhoffM8 = null;

	private JSeparator jSeparatorDayhoffM9 = null;

	private JSeparator jSeparatorDCMut01 = null;

	private JSeparator jSeparatorDCMut02 = null;

	private JSeparator jSeparatorDCMut03 = null;

	private JSeparator jSeparatorDCMut04 = null;

	private JSeparator jSeparatorDCMut05 = null;

	private JSeparator jSeparatorDCMut11 = null;

	private JSeparator jSeparatorDCMut12 = null;

	private JSeparator jSeparatorDCMut13 = null;

	private JSeparator jSeparatorDCMut14 = null;

	private JSeparator jSeparatorDCMut15 = null;

	private JSeparator jSeparatorDCMut16 = null;

	private JSeparator jSeparatorDCMut17 = null;

	private JSeparator jSeparatorDCMut18 = null;

	private JSeparator jSeparatorDCMut19 = null;

	private JSeparator jSeparatorDCMut20 = null;

	private JSeparator jSeparatorDCMut22 = null;

	private JSeparator jSeparatorDCMut23 = null;

	private JSeparator jSeparatorDCMut24 = null;

	private JSeparator jSeparatorDCMut25 = null;

	private JSeparator jSeparatorDCMutM1 = null;

	private JSeparator jSeparatorDCMutM10 = null;

	private JSeparator jSeparatorDCMutM11 = null;

	private JSeparator jSeparatorDCMutM12 = null;

	private JSeparator jSeparatorDCMutM13 = null;

	private JSeparator jSeparatorDCMutM14 = null;

	private JSeparator jSeparatorDCMutM15 = null;

	private JSeparator jSeparatorDCMutM16 = null;

	private JSeparator jSeparatorDCMutM21 = null;

	private JSeparator jSeparatorDCMutM3 = null;

	private JSeparator jSeparatorDCMutM4 = null;

	private JSeparator jSeparatorDCMutM5 = null;

	private JSeparator jSeparatorDCMutM6 = null;

	private JSeparator jSeparatorDCMutM7 = null;

	private JSeparator jSeparatorDCMutM8 = null;

	private JSeparator jSeparatorDCMutM9 = null;

	private JSeparator jSeparatorF8401 = null;

	private JSeparator jSeparatorF8402 = null;

	private JSeparator jSeparatorF8403 = null;

	private JSeparator jSeparatorF8404 = null;

	private JSeparator jSeparatorF8405 = null;

	private JSeparator jSeparatorF8406 = null;

	private JSeparator jSeparatorF8407 = null;

	private JSeparator jSeparatorF8408 = null;

	private JSeparator jSeparatorF8409 = null;

	private JSeparator jSeparatorF8410 = null;

	private JSeparator jSeparatorF8411 = null;

	private JSeparator jSeparatorF8412 = null;

	private JSeparator jSeparatorF8413 = null;

	private JSeparator jSeparatorF8414 = null;

	private JSeparator jSeparatorF8415 = null;

	private JSeparator jSeparatorF8416 = null;

	private JSeparator jSeparatorF8417 = null;

	private JSeparator jSeparatorF8418 = null;

	private JSeparator jSeparatorF8419 = null;

	private JSeparator jSeparatorF8420 = null;

	private JSeparator jSeparatorF8421 = null;

	private JSeparator jSeparatorF8422 = null;

	private JSeparator jSeparatorF8423 = null;

	private JSeparator jSeparatorF8424 = null;

	private JSeparator jSeparatorF8425 = null;

	private JSeparator jSeparatorF84M1 = null;

	private JSeparator jSeparatorF84M10 = null;

	private JSeparator jSeparatorF84M11 = null;

	private JSeparator jSeparatorF84M12 = null;

	private JSeparator jSeparatorF84M13 = null;

	private JSeparator jSeparatorF84M14 = null;

	private JSeparator jSeparatorF84M15 = null;

	private JSeparator jSeparatorF84M16 = null;

	private JSeparator jSeparatorF84M17 = null;

	private JSeparator jSeparatorF84M18 = null;

	private JSeparator jSeparatorF84M19 = null;

	private JSeparator jSeparatorF84M2 = null;

	private JSeparator jSeparatorF84M20 = null;

	private JSeparator jSeparatorF84M3 = null;

	private JSeparator jSeparatorF84M4 = null;

	private JSeparator jSeparatorF84M5 = null;

	private JSeparator jSeparatorF84M6 = null;

	private JSeparator jSeparatorF84M7 = null;

	private JSeparator jSeparatorF84M8 = null;

	private JSeparator jSeparatorF84M9 = null;

	private JSeparator jSeparatorHKY = null;

	private JSeparator jSeparatorHKY01 = null;

	private JSeparator jSeparatorHKY011 = null;

	private JSeparator jSeparatorHKY0111 = null;

	private JSeparator jSeparatorHKY01111 = null;

	private JSeparator jSeparatorHKY02 = null;

	private JSeparator jSeparatorHKY021 = null;

	private JSeparator jSeparatorHKY0211 = null;

	private JSeparator jSeparatorHKY02111 = null;

	private JSeparator jSeparatorHKY03 = null;

	private JSeparator jSeparatorHKY031 = null;

	private JSeparator jSeparatorHKY0311 = null;

	private JSeparator jSeparatorHKY03111 = null;

	private JSeparator jSeparatorHKY04 = null;

	private JSeparator jSeparatorHKY041 = null;

	private JSeparator jSeparatorHKY0411 = null;

	private JSeparator jSeparatorHKY04111 = null;

	private JSeparator jSeparatorHKY05 = null;

	private JSeparator jSeparatorHKY051 = null;

	private JSeparator jSeparatorHKY0511 = null;

	private JSeparator jSeparatorHKY05111 = null;

	private JSeparator jSeparatorHKY06 = null;

	private JSeparator jSeparatorHKY061 = null;

	private JSeparator jSeparatorHKY0611 = null;

	private JSeparator jSeparatorHKY06111 = null;

	private JSeparator jSeparatorHKY07 = null;

	private JSeparator jSeparatorHKY072 = null;

	private JSeparator jSeparatorHKY0721 = null;

	private JSeparator jSeparatorHKY07211 = null;

	private JSeparator jSeparatorHKY08 = null;

	private JSeparator jSeparatorHKY081 = null;

	private JSeparator jSeparatorHKY0811 = null;

	private JSeparator jSeparatorHKY08111 = null;

	private JSeparator jSeparatorHKY09 = null;

	private JSeparator jSeparatorHKY091 = null;

	private JSeparator jSeparatorHKY0911 = null;

	private JSeparator jSeparatorHKY09111 = null;

	private JSeparator jSeparatorHKY1 = null;

	private JSeparator jSeparatorHKY10 = null;

	private JSeparator jSeparatorHKY101 = null;

	private JSeparator jSeparatorHKY1011 = null;

	private JSeparator jSeparatorHKY10111 = null;

	private JSeparator jSeparatorHKY11 = null;

	private JSeparator jSeparatorHKY110 = null;

	private JSeparator jSeparatorHKY1101 = null;

	private JSeparator jSeparatorHKY111 = null;

	private JSeparator jSeparatorHKY1111 = null;

	private JSeparator jSeparatorHKY11111 = null;

	private JSeparator jSeparatorHKY12 = null;

	private JSeparator jSeparatorHKY121 = null;

	private JSeparator jSeparatorHKY1211 = null;

	private JSeparator jSeparatorHKY12111 = null;

	private JSeparator jSeparatorHKY13 = null;

	private JSeparator jSeparatorHKY131 = null;

	private JSeparator jSeparatorHKY1311 = null;

	private JSeparator jSeparatorHKY13111 = null;

	private JSeparator jSeparatorHKY14 = null;

	private JSeparator jSeparatorHKY141 = null;

	private JSeparator jSeparatorHKY1411 = null;

	private JSeparator jSeparatorHKY14111 = null;

	private JSeparator jSeparatorHKY15 = null;

	private JSeparator jSeparatorHKY151 = null;

	private JSeparator jSeparatorHKY1511 = null;

	private JSeparator jSeparatorHKY15111 = null;

	private JSeparator jSeparatorHKY16 = null;

	private JSeparator jSeparatorHKY161 = null;

	private JSeparator jSeparatorHKY1611 = null;

	private JSeparator jSeparatorHKY16111 = null;

	private JSeparator jSeparatorHKY17 = null;

	private JSeparator jSeparatorHKY171 = null;

	private JSeparator jSeparatorHKY1711 = null;

	private JSeparator jSeparatorHKY17111 = null;

	private JSeparator jSeparatorHKY18 = null;

	private JSeparator jSeparatorHKY181 = null;

	private JSeparator jSeparatorHKY1811 = null;

	private JSeparator jSeparatorHKY18111 = null;

	private JSeparator jSeparatorHKY19 = null;

	private JSeparator jSeparatorHKY191 = null;

	private JSeparator jSeparatorHKY1911 = null;

	private JSeparator jSeparatorHKY19111 = null;

	private JSeparator jSeparatorHKY20 = null;

	private JSeparator jSeparatorHKY201 = null;

	private JSeparator jSeparatorHKY2011 = null;

	private JSeparator jSeparatorHKY20111 = null;

	private JSeparator jSeparatorHKY21 = null;

	private JSeparator jSeparatorHKY211 = null;

	private JSeparator jSeparatorHKY2111 = null;

	private JSeparator jSeparatorHKY21111 = null;

	private JSeparator jSeparatorHKY22 = null;

	private JSeparator jSeparatorHKY221 = null;

	private JSeparator jSeparatorHKY2211 = null;

	private JSeparator jSeparatorHKY22111 = null;

	private JSeparator jSeparatorHKY23 = null;

	private JSeparator jSeparatorHKY231 = null;

	private JSeparator jSeparatorHKY2311 = null;

	private JSeparator jSeparatorHKY23111 = null;

	private JSeparator jSeparatorHKY24 = null;

	private JSeparator jSeparatorHKY241 = null;

	private JSeparator jSeparatorHKY2411 = null;

	private JSeparator jSeparatorHKY24111 = null;

	private JSeparator jSeparatorHKY25 = null;

	private JSeparator jSeparatorHKY251 = null;

	private JSeparator jSeparatorHKY2511 = null;

	private JSeparator jSeparatorHKY25111 = null;

	private JSeparator jSeparatorHKYM1 = null;

	private JSeparator jSeparatorHKYM10 = null;

	private JSeparator jSeparatorHKYM101 = null;

	private JSeparator jSeparatorHKYM1011 = null;

	private JSeparator jSeparatorHKYM10111 = null;

	private JSeparator jSeparatorHKYM11 = null;

	private JSeparator jSeparatorHKYM110 = null;

	private JSeparator jSeparatorHKYM1101 = null;

	private JSeparator jSeparatorHKYM11011 = null;

	private JSeparator jSeparatorHKYM111 = null;

	private JSeparator jSeparatorHKYM1111 = null;

	private JSeparator jSeparatorHKYM11111 = null;

	private JSeparator jSeparatorHKYM12 = null;

	private JSeparator jSeparatorHKYM121 = null;

	private JSeparator jSeparatorHKYM1211 = null;

	private JSeparator jSeparatorHKYM12111 = null;

	private JSeparator jSeparatorHKYM13 = null;

	private JSeparator jSeparatorHKYM131 = null;

	private JSeparator jSeparatorHKYM1311 = null;

	private JSeparator jSeparatorHKYM13111 = null;

	private JSeparator jSeparatorHKYM14 = null;

	private JSeparator jSeparatorHKYM141 = null;

	private JSeparator jSeparatorHKYM1411 = null;

	private JSeparator jSeparatorHKYM14111 = null;

	private JSeparator jSeparatorHKYM15 = null;

	private JSeparator jSeparatorHKYM151 = null;

	private JSeparator jSeparatorHKYM1511 = null;

	private JSeparator jSeparatorHKYM15111 = null;

	private JSeparator jSeparatorHKYM16 = null;

	private JSeparator jSeparatorHKYM161 = null;

	private JSeparator jSeparatorHKYM1611 = null;

	private JSeparator jSeparatorHKYM16111 = null;

	private JSeparator jSeparatorHKYM17 = null;

	private JSeparator jSeparatorHKYM171 = null;

	private JSeparator jSeparatorHKYM1711 = null;

	private JSeparator jSeparatorHKYM17111 = null;

	private JSeparator jSeparatorHKYM18 = null;

	private JSeparator jSeparatorHKYM181 = null;

	private JSeparator jSeparatorHKYM1811 = null;

	private JSeparator jSeparatorHKYM18111 = null;

	private JSeparator jSeparatorHKYM19 = null;

	private JSeparator jSeparatorHKYM191 = null;

	private JSeparator jSeparatorHKYM1911 = null;

	private JSeparator jSeparatorHKYM19111 = null;

	private JSeparator jSeparatorHKYM20 = null;

	private JSeparator jSeparatorHKYM201 = null;

	private JSeparator jSeparatorHKYM2011 = null;

	private JSeparator jSeparatorHKYM20111 = null;

	private JSeparator jSeparatorHKYM3 = null;

	private JSeparator jSeparatorHKYM31 = null;

	private JSeparator jSeparatorHKYM311 = null;

	private JSeparator jSeparatorHKYM3111 = null;

	private JSeparator jSeparatorHKYM4 = null;

	private JSeparator jSeparatorHKYM41 = null;

	private JSeparator jSeparatorHKYM411 = null;

	private JSeparator jSeparatorHKYM4111 = null;

	private JSeparator jSeparatorHKYM5 = null;

	private JSeparator jSeparatorHKYM51 = null;

	private JSeparator jSeparatorHKYM511 = null;

	private JSeparator jSeparatorHKYM5111 = null;

	private JSeparator jSeparatorHKYM6 = null;

	private JSeparator jSeparatorHKYM61 = null;

	private JSeparator jSeparatorHKYM611 = null;

	private JSeparator jSeparatorHKYM6111 = null;

	private JSeparator jSeparatorHKYM7 = null;

	private JSeparator jSeparatorHKYM71 = null;

	private JSeparator jSeparatorHKYM711 = null;

	private JSeparator jSeparatorHKYM7111 = null;

	private JSeparator jSeparatorHKYM8 = null;

	private JSeparator jSeparatorHKYM81 = null;

	private JSeparator jSeparatorHKYM811 = null;

	private JSeparator jSeparatorHKYM8111 = null;

	private JSeparator jSeparatorHKYM9 = null;

	private JSeparator jSeparatorHKYM91 = null;

	private JSeparator jSeparatorHKYM911 = null;

	private JSeparator jSeparatorHKYM9111 = null;

	private JSeparator jSeparatorHM13 = null;

	private JSeparator jSeparatorJTT01 = null;

	private JSeparator jSeparatorJTT02 = null;

	private JSeparator jSeparatorJTT03 = null;

	private JSeparator jSeparatorJTT04 = null;

	private JSeparator jSeparatorJTT05 = null;

	private JSeparator jSeparatorJTT11 = null;

	private JSeparator jSeparatorJTT12 = null;

	private JSeparator jSeparatorJTT13 = null;

	private JSeparator jSeparatorJTT14 = null;

	private JSeparator jSeparatorJTT15 = null;

	private JSeparator jSeparatorJTT16 = null;

	private JSeparator jSeparatorJTT17 = null;

	private JSeparator jSeparatorJTT18 = null;

	private JSeparator jSeparatorJTT19 = null;

	private JSeparator jSeparatorJTT20 = null;

	private JSeparator jSeparatorJTT21 = null;

	private JSeparator jSeparatorJTT22 = null;

	private JSeparator jSeparatorJTT23 = null;

	private JSeparator jSeparatorJTT24 = null;

	private JSeparator jSeparatorJTT25 = null;

	private JSeparator jSeparatorJTTM10 = null;

	private JSeparator jSeparatorJTTM11 = null;

	private JSeparator jSeparatorJTTM12 = null;

	private JSeparator jSeparatorJTTM13 = null;

	private JSeparator jSeparatorJTTM14 = null;

	private JSeparator jSeparatorJTTM15 = null;

	private JSeparator jSeparatorJTTM16 = null;

	private JSeparator jSeparatorJTTM2 = null;

	private JSeparator jSeparatorJTTM3 = null;

	private JSeparator jSeparatorJTTM4 = null;

	private JSeparator jSeparatorJTTM5 = null;

	private JSeparator jSeparatorJTTM6 = null;

	private JSeparator jSeparatorJTTM7 = null;

	private JSeparator jSeparatorJTTM8 = null;

	private JSeparator jSeparatorJTTM9 = null;

	private JSeparator jSeparatorK2P01 = null;

	private JSeparator jSeparatorK2P02 = null;

	private JSeparator jSeparatorK2P03 = null;

	private JSeparator jSeparatorK2P04 = null;

	private JSeparator jSeparatorK2P05 = null;

	private JSeparator jSeparatorK2P06 = null;

	private JSeparator jSeparatorK2P07 = null;

	private JSeparator jSeparatorK2P08 = null;

	private JSeparator jSeparatorK2P09 = null;

	private JSeparator jSeparatorK2P10 = null;

	private JSeparator jSeparatorK2P11 = null;

	private JSeparator jSeparatorK2P12 = null;

	private JSeparator jSeparatorK2P13 = null;

	private JSeparator jSeparatorK2P14 = null;

	private JSeparator jSeparatorK2P15 = null;

	private JSeparator jSeparatorK2P16 = null;

	private JSeparator jSeparatorK2P17 = null;

	private JSeparator jSeparatorK2P18 = null;

	private JSeparator jSeparatorK2P19 = null;

	private JSeparator jSeparatorK2P20 = null;

	private JSeparator jSeparatorK2P21 = null;

	private JSeparator jSeparatorK2P22 = null;

	private JSeparator jSeparatorK2P23 = null;

	private JSeparator jSeparatorK2P24 = null;

	private JSeparator jSeparatorK2P25 = null;

	private JSeparator jSeparatorK2PM1 = null;

	private JSeparator jSeparatorK2PM10 = null;

	private JSeparator jSeparatorK2PM11 = null;

	private JSeparator jSeparatorK2PM12 = null;

	private JSeparator jSeparatorK2PM14 = null;

	private JSeparator jSeparatorK2PM15 = null;

	private JSeparator jSeparatorK2PM16 = null;

	private JSeparator jSeparatorK2PM17 = null;

	private JSeparator jSeparatorK2PM18 = null;

	private JSeparator jSeparatorK2PM19 = null;

	private JSeparator jSeparatorK2PM2 = null;

	private JSeparator jSeparatorK2PM20 = null;

	private JSeparator jSeparatorK2PM3 = null;

	private JSeparator jSeparatorK2PM4 = null;

	private JSeparator jSeparatorK2PM5 = null;

	private JSeparator jSeparatorK2PM6 = null;

	private JSeparator jSeparatorK2PM8 = null;

	private JSeparator jSeparatorK2PM9 = null;

	private JSeparator jSeparatorM17 = null;

	private JSeparator jSeparatorM7 = null;

	private JSeparator jSeparatorMtREV01 = null;

	private JSeparator jSeparatorMtREV02 = null;

	private JSeparator jSeparatorMtREV03 = null;

	private JSeparator jSeparatorMtREV04 = null;

	private JSeparator jSeparatorMtREV05 = null;

	private JSeparator jSeparatorMtREV1 = null;

	private JSeparator jSeparatorMtREV11 = null;

	private JSeparator jSeparatorMtREV12 = null;

	private JSeparator jSeparatorMtREV13 = null;

	private JSeparator jSeparatorMtREV14 = null;

	private JSeparator jSeparatorMtREV15 = null;

	private JSeparator jSeparatorMtREV16 = null;

	private JSeparator jSeparatorMtREV17 = null;

	private JSeparator jSeparatorMtREV18 = null;

	private JSeparator jSeparatorMtREV19 = null;

	private JSeparator jSeparatorMtREV20 = null;

	private JSeparator jSeparatorMtREV22 = null;

	private JSeparator jSeparatorMtREV23 = null;

	private JSeparator jSeparatorMtREV24 = null;

	private JSeparator jSeparatorMtREV25 = null;

	private JSeparator jSeparatorMtREVM10 = null;

	private JSeparator jSeparatorMtREVM11 = null;

	private JSeparator jSeparatorMtREVM12 = null;

	private JSeparator jSeparatorMtREVM13 = null;

	private JSeparator jSeparatorMtREVM14 = null;

	private JSeparator jSeparatorMtREVM15 = null;

	private JSeparator jSeparatorMtREVM16 = null;

	private JSeparator jSeparatorMtREVM21 = null;

	private JSeparator jSeparatorMtREVM3 = null;

	private JSeparator jSeparatorMtREVM4 = null;

	private JSeparator jSeparatorMtREVM5 = null;

	private JSeparator jSeparatorMtREVM6 = null;

	private JSeparator jSeparatorMtREVM7 = null;

	private JSeparator jSeparatorMtREVM8 = null;

	private JSeparator jSeparatorMtREVM9 = null;

	private JSeparator jSeparatorS0 = null;

	private JSeparator jSeparatorS1 = null;

	private JSeparator jSeparatorS10 = null;

	private JSeparator jSeparatorS11 = null;

	private JSeparator jSeparatorS2 = null;

	private JSeparator jSeparatorS3 = null;

	private JSeparator jSeparatorS4 = null;

	private JSeparator jSeparatorS5 = null;

	private JSeparator jSeparatorS6 = null;

	private JSeparator jSeparatorS7 = null;

	private JSeparator jSeparatorS8 = null;

	private JSeparator jSeparatorS9 = null;

	private JSeparator jSeparatorTN9301 = null;

	private JSeparator jSeparatorTN9302 = null;

	private JSeparator jSeparatorTN9303 = null;

	private JSeparator jSeparatorTN9304 = null;

	private JSeparator jSeparatorTN9305 = null;

	private JSeparator jSeparatorTN9306 = null;

	private JSeparator jSeparatorTN9307 = null;

	private JSeparator jSeparatorTN9308 = null;

	private JSeparator jSeparatorTN9309 = null;

	private JSeparator jSeparatorTN9310 = null;

	private JSeparator jSeparatorTN9311 = null;

	private JSeparator jSeparatorTN9312 = null;

	private JSeparator jSeparatorTN9313 = null;

	private JSeparator jSeparatorTN9314 = null;

	private JSeparator jSeparatorTN9315 = null;

	private JSeparator jSeparatorTN9316 = null;

	private JSeparator jSeparatorTN9317 = null;

	private JSeparator jSeparatorTN9318 = null;

	private JSeparator jSeparatorTN9319 = null;

	private JSeparator jSeparatorTN9320 = null;

	private JSeparator jSeparatorTN9321 = null;

	private JSeparator jSeparatorTN9322 = null;

	private JSeparator jSeparatorTN9323 = null;

	private JSeparator jSeparatorTN9324 = null;

	private JSeparator jSeparatorTN9325 = null;

	private JSeparator jSeparatorTN93M1 = null;

	private JSeparator jSeparatorTN93M10 = null;

	private JSeparator jSeparatorTN93M11 = null;

	private JSeparator jSeparatorTN93M12 = null;

	private JSeparator jSeparatorTN93M13 = null;

	private JSeparator jSeparatorTN93M14 = null;

	private JSeparator jSeparatorTN93M15 = null;

	private JSeparator jSeparatorTN93M16 = null;

	private JSeparator jSeparatorTN93M18 = null;

	private JSeparator jSeparatorTN93M19 = null;

	private JSeparator jSeparatorTN93M2 = null;

	private JSeparator jSeparatorTN93M20 = null;

	private JSeparator jSeparatorTN93M3 = null;

	private JSeparator jSeparatorTN93M4 = null;

	private JSeparator jSeparatorTN93M5 = null;

	private JSeparator jSeparatorTN93M6 = null;

	private JSeparator jSeparatorTN93M7 = null;

	private JSeparator jSeparatorTN93M8 = null;

	private JSeparator jSeparatorTN93M9 = null;

	private JSeparator jSeparatorWAG01 = null;

	private JSeparator jSeparatorWAG02 = null;

	private JSeparator jSeparatorWAG03 = null;

	private JSeparator jSeparatorWAG04 = null;

	private JSeparator jSeparatorWAG05 = null;

	private JSeparator jSeparatorWAG11 = null;

	private JSeparator jSeparatorWAG110 = null;

	private JSeparator jSeparatorWAG12 = null;

	private JSeparator jSeparatorWAG13 = null;

	private JSeparator jSeparatorWAG14 = null;

	private JSeparator jSeparatorWAG15 = null;

	private JSeparator jSeparatorWAG16 = null;

	private JSeparator jSeparatorWAG17 = null;

	private JSeparator jSeparatorWAG18 = null;

	private JSeparator jSeparatorWAG19 = null;

	private JSeparator jSeparatorWAG20 = null;

	private JSeparator jSeparatorWAG21 = null;

	private JSeparator jSeparatorWAG22 = null;

	private JSeparator jSeparatorWAG23 = null;

	private JSeparator jSeparatorWAG24 = null;

	private JSeparator jSeparatorWAG25 = null;

	private JSeparator jSeparatorWAGM10 = null;

	private JSeparator jSeparatorWAGM11 = null;

	private JSeparator jSeparatorWAGM12 = null;

	private JSeparator jSeparatorWAGM13 = null;

	private JSeparator jSeparatorWAGM14 = null;

	private JSeparator jSeparatorWAGM15 = null;

	private JSeparator jSeparatorWAGM16 = null;

	private JSeparator jSeparatorWAGM2 = null;

	private JSeparator jSeparatorWAGM3 = null;

	private JSeparator jSeparatorWAGM4 = null;

	private JSeparator jSeparatorWAGM5 = null;

	private JSeparator jSeparatorWAGM6 = null;

	private JSeparator jSeparatorWAGM7 = null;

	private JSeparator jSeparatorWAGM8 = null;

	private JSeparator jSeparatorWAGM9 = null;

	private JTabbedPane jTabbedPaneGeral = null;

	private JTabbedPane jTabbedPaneModelosAA = null;

	private JTabbedPane jTabbedPaneModelosDNA = null;

	private JTabbedPane jTabbedPaneTipoExecucao = null;

	private JTextField jTextFieldArquivoArvore = null;

	private JTextField jTextFieldArquivoSequencia = null;

	private JSeparator SeparatorDCMut21 = null;

	private JSeparator SeparatorMtREV21 = null;

	private JPanel jPanelBootstrap;

	/**
	 * This is the default constructor
	 */
	public PHYML() {
		super();
		initialize();
	}

	public ImageIcon getImagemAA() {
		return imagemAA;
	}

	public ImageIcon getImagemDNA() {
		return imagemDNA;
	}

	/**
	 * This method initializes jButtonArquivoArvore
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonArquivoArvore() {
		if (jButtonArquivoArvore == null) {
			jButtonArquivoArvore = new JButton();
			jButtonArquivoArvore.setLocation(new Point(380, 45));
			jButtonArquivoArvore.setBackground(new Color(173, 200, 226));
			jButtonArquivoArvore
					.setIcon(getIcon(
							"/br/uesc/computacao/estagio/apresentacao/figuras/folder.png"));
			jButtonArquivoArvore.setSize(new Dimension(31, 28));
			jButtonArquivoArvore.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonArquivoArvore;
	}

	/**
	 * Este metodo inicializa o jButtonArquivoSequencia O qual da origem ao
	 * botao onde o usuario escolhe o nome da sequencia a ser passada para o
	 * phyml
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonArquivoSequencia() {
		if (jButtonArquivoSequencia == null) {
			jButtonArquivoSequencia = new JButton();
			jButtonArquivoSequencia
					.setIcon(getIcon(
							"/br/uesc/computacao/estagio/apresentacao/figuras/folder.png"));
			jButtonArquivoSequencia.setLocation(new Point(418, 21));
			jButtonArquivoSequencia.setBackground(new Color(173, 200, 226));
			jButtonArquivoSequencia
					.setToolTipText("Informe o local onde está o arquivo da seqüência.");
			jButtonArquivoSequencia.setSize(new Dimension(31, 28));
			jButtonArquivoSequencia.setSize(new Dimension(31, 28));
			jButtonArquivoSequencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        jButtonArquivoSequencia.setEnabled(false);
		}
		return jButtonArquivoSequencia;
	}

	/**
	 * Este metodo inicializa o jButtonEditor
	 * 
	 * Este botao e utilizado para abrir o Editos de texto da IGRAFU. Este
	 * editor pode ser utilizado tanto para visualizar os arquivos gerados pela
	 * execucao quanto para gerar arquivos texto.
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonEditor() {
		if (jButtonEditor == null) {
			jButtonEditor = new JButton();
			jButtonEditor.setText("Editor");
			jButtonEditor.setSize(new Dimension(117, 25));
			jButtonEditor
					.setIcon(getIcon(
						"/br/uesc/computacao/estagio/apresentacao/figuras/filoEditor.png"));
			jButtonEditor.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonEditor.setLocation(new Point(663, 276));
			jButtonEditor.setSize(new Dimension(117, 25));
			jButtonEditor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonEditor;
	}

	/**
	 * Este metodo inicializa o jButtonExecutar
	 * 
	 * O qual da origem ao botao "Avancar" Este botao faz com que seja
	 * verificada todas as escolhas feitas pelo usuario, caso sejao validas o
	 * phyml sera executado recebendo os parametros informados pelo usuario.
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonExecutar() {
		if (jButtonExecutar == null) {
			jButtonExecutar = new JButton();
			jButtonExecutar
					.setIcon(getIcon(
							"/br/uesc/computacao/estagio/apresentacao/figuras/Ok.png"));
			jButtonExecutar.setFont(new Font("Arial", Font.BOLD, 10));
			jButtonExecutar.setSize(new Dimension(117, 25));
			jButtonExecutar.setLocation(new Point(663, 70));
			jButtonExecutar.setText("Executar");
			jButtonExecutar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonExecutar;
	}

	/**
	 * This method initializes jButtonTipoExecucao
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonTipoExecucao() {
		if (jButtonTipoExecucao == null) {
			jButtonTipoExecucao = new JButton();
			jButtonTipoExecucao.setText("Executar");
			jButtonTipoExecucao.setSize(new Dimension(99, 22));
			jButtonTipoExecucao.setLocation(new Point(71, 152));
		}
		return jButtonTipoExecucao;
	}

	/**
	 * Este metodo inicializa o jButtonVisualizar
	 * 
	 * Este botao e utilizado para axecutar o HyperTree
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonVisualizar() {
		if (jButtonVisualizar == null) {
			jButtonVisualizar = new JButton();
			jButtonVisualizar
					.setIcon(getIcon(
							"/br/uesc/computacao/estagio/apresentacao/figuras/HyperTree.gif"));
			jButtonVisualizar.setLocation(new Point(663, 326));
			jButtonVisualizar.setSize(new Dimension(117, 25));
			jButtonVisualizar.setText("Visualizar");
			jButtonVisualizar.setFont(new Font("Arial", Font.BOLD, 10));
			jButtonVisualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonVisualizar;
	}

	/**
	 * Este metodo inicializa o jButtonVoltar
	 * 
	 * O qual da origem ao botao "voltar" Este botao faz com que o frame phyml
	 * seja fechado e seja aberto novamente o frame anterior Voltando assim para
	 * a tela anterior caso o usuario queira fazer alguma modificacao em suas
	 * escolhas
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
			jButtonVoltar.setIcon(getIcon("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png"));
			jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonVoltar;
	}
        
        public JButton getJButtonInicio() {
             if (jButtonInicio == null) {
                 jButtonInicio = new JButton();
                 jButtonInicio.setBounds(new Rectangle(663+x, 150+y, 117, 25));
                 jButtonInicio.setText("Início");
                 jButtonInicio.setFont(new Font("Dialog", Font.BOLD, 10));
                 jButtonInicio.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/home.png")));
                 jButtonInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
             }
             return jButtonInicio;
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
	 * This method initializes jCheckBoxTipoExecucaoParalelo
	 * 
	 * @return javax.swing.JCheckBox
	 */
	public JCheckBox getJCheckBoxTipoExecucaoParalelo() {
		if (jCheckBoxTipoExecucaoParalelo == null) {
			jCheckBoxTipoExecucaoParalelo = new JCheckBox();
			jCheckBoxTipoExecucaoParalelo
					.setBounds(new Rectangle(0, 2, 190, 21));
			jCheckBoxTipoExecucaoParalelo
					.setBackground(new Color(173, 200, 226));
			jCheckBoxTipoExecucaoParalelo.setText("Executar em paralelo");
			jCheckBoxTipoExecucaoParalelo.setVisible(false);
		}
		return jCheckBoxTipoExecucaoParalelo;
	}

	/**
	 * This method initializes jComboBoxTipoExecucaoParalelo
	 * 
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxTipoExecucaoParalelo() {
		if (jComboBoxTipoExecucaoParalelo == null) {
			jComboBoxTipoExecucaoParalelo = new JComboBox();
			jComboBoxTipoExecucaoParalelo.setLocation(new Point(53, 44));
			jComboBoxTipoExecucaoParalelo.setSize(new Dimension(112, 20));
			jComboBoxTipoExecucaoParalelo.addItem("2");
			jComboBoxTipoExecucaoParalelo.addItem("3");
			jComboBoxTipoExecucaoParalelo.addItem("4");
		}
		return jComboBoxTipoExecucaoParalelo;
	}

	/**
	 * This method initializes jComboBoxTipoExecucaoSequencial
	 * 
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxTipoExecucaoSequencial() {
		if (jComboBoxTipoExecucaoSequencial == null) {
			jComboBoxTipoExecucaoSequencial = new JComboBox();
			jComboBoxTipoExecucaoSequencial.setLocation(new Point(77, 40));
			jComboBoxTipoExecucaoSequencial.setSize(new Dimension(105, 20));
			jComboBoxTipoExecucaoSequencial.addItem("servidor");
			jComboBoxTipoExecucaoSequencial.addItem("no1");
			jComboBoxTipoExecucaoSequencial.addItem("no2");
			jComboBoxTipoExecucaoSequencial.addItem("no3");
			jComboBoxTipoExecucaoSequencial.addItem("no4");
		}
		return jComboBoxTipoExecucaoSequencial;
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
			jContentPane.add(getJButtonExecutar(), null);
			jContentPane.add(getJButtonVoltar(), null);
			jContentPane.add(getJButtonVisualizar(), null);
			jContentPane.add(getJButtonEditor(), null);
			jContentPane.add(getJProgressBar(), null);
                        jContentPane.add(getJButtonInicio(),null);


		}
		return jContentPane;
	}

	/**
	 * This method initializes jContentPaneBootstrap
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPaneBootstrap() {
		if (jContentPaneBootstrap == null) {
			jContentPaneBootstrap = new JPanel();
			jContentPaneBootstrap.setLayout(null);
			jContentPaneBootstrap.setBackground(new Color(230, 234, 240));
			jContentPaneBootstrap.add(getJTabbedPaneTipoExecucao(), null);
			jContentPaneBootstrap.add(getJButtonTipoExecucao(), null);
		}
		return jContentPaneBootstrap;
	}

	/**
	 * This method initializes jDialogTipoExecucao
	 * 
	 * @return javax.swing.JDialog
	 */
	public JDialog getJDialogTipoExecucao() {
		if (jDialogTipoExecucao == null) {
			jDialogTipoExecucao = new JDialog(this);
			jDialogTipoExecucao.setSize(new Dimension(252, 210));
			jDialogTipoExecucao.setTitle("Tipo de Execução");
			jDialogTipoExecucao.setResizable(false);

			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			jDialogTipoExecucao.setLocation((dimension.width) / 2,
					(dimension.height) / 2);

			jDialogTipoExecucao.setContentPane(getJContentPaneBootstrap());
			jDialogTipoExecucao.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			jDialogTipoExecucao
					.addWindowListener(new java.awt.event.WindowAdapter() {
						public void windowClosing(WindowEvent evt) {
							jDialogTipoExecucao.removeNotify();
						}
					});
		}
		return jDialogTipoExecucao;
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

	public JLabel getJLabelArquivoArvore() {
		return jLabelArquivoArvore;
	}

	public JLabel getJLabelArquivoSequencia() {
		return jLabelArquivoSequencia;
	}

	
	public JLabel getJLabelGamaDayhoff() {
		return jLabelGamaDayhoff;
	}

	public JLabel getJLabelGamaDCMut() {
		return jLabelGamaDCMut;
	}

	public JLabel getJLabelGamaF81() {
		return jLabelGamaF81;
	}

	public JLabel getJLabelGamaF84() {
		return jLabelGamaF84;
	}

	public JLabel getJLabelGamaGTR() {
		return jLabelGamaGTR;
	}

	public JLabel getJLabelGamaHKY() {
		return jLabelGamaHKY;
	}

	public JLabel getJLabelGamaJC69() {
		return jLabelGamaJC69;
	}

	public JLabel getJLabelGamaJTT() {
		return jLabelGamaJTT;
	}

	public JLabel getJLabelGamaK2P() {
		return jLabelGamaK2P;
	}

	public JLabel getJLabelGamaMtREV() {
		return jLabelGamaMtREV;
	}

	public JLabel getJLabelGamaTN93() {
		return jLabelGamaTN93;
	}

	public JLabel getJLabelGamaWAG() {
		return jLabelGamaWAG;
	}

	public JLabel getJLabelModeloSelecionadoDayhoff() {
		return jLabelModeloSelecionadoDayhoff;
	}

	public JLabel getJLabelModeloSelecionadoDCMut() {
		return jLabelModeloSelecionadoDCMut;
	}

	public JLabel getJLabelModeloSelecionadoF81() {
		return jLabelModeloSelecionadoF81;
	}

	public JLabel getJLabelModeloSelecionadoF84() {
		return jLabelModeloSelecionadoF84;
	}

	public JLabel getJLabelModeloSelecionadoGTR() {
		return jLabelModeloSelecionadoGTR;
	}

	public JLabel getJLabelModeloSelecionadoHKY() {
		return jLabelModeloSelecionadoHKY;
	}

	public JLabel getJLabelModeloSelecionadoJC69() {
		return jLabelModeloSelecionadoJC69;
	}

	public JLabel getJLabelModeloSelecionadoJTT() {
		return jLabelModeloSelecionadoJTT;
	}

	public JLabel getJLabelModeloSelecionadoK2P() {
		return jLabelModeloSelecionadoK2P;
	}

	public JLabel getJLabelModeloSelecionadoMtREV() {
		return jLabelModeloSelecionadoMtREV;
	}

	public JLabel getJLabelModeloSelecionadoTN93() {
		return jLabelModeloSelecionadoTN93;
	}

	public JLabel getJLabelModeloSelecionadoWAG() {
		return jLabelModeloSelecionadoWAG;
	}

	public JLabel getJLabelModeloUtilizadoDayhoff() {
		return jLabelModeloUtilizadoDayhoff;
	}

	public JLabel getJLabelModeloUtilizadoDCMut() {
		return jLabelModeloUtilizadoDCMut;
	}

	public JLabel getJLabelModeloUtilizadoF81() {
		return jLabelModeloUtilizadoF81;
	}

	public JLabel getJLabelModeloUtilizadoF84() {
		return jLabelModeloUtilizadoF84;
	}

	public JLabel getJLabelModeloUtilizadoGTR() {
		return jLabelModeloUtilizadoGTR;
	}

	public JLabel getJLabelModeloUtilizadoHKY() {
		return jLabelModeloUtilizadoHKY;
	}

	public JLabel getJLabelModeloUtilizadoJC69() {
		return jLabelModeloUtilizadoJC69;
	}

	public JLabel getJLabelModeloUtilizadoJTT() {
		return jLabelModeloUtilizadoJTT;
	}

	public JLabel getJLabelModeloUtilizadoK2P() {
		return jLabelModeloUtilizadoK2P;
	}

	public JLabel getJLabelModeloUtilizadoMtREV() {
		return jLabelModeloUtilizadoMtREV;
	}

	public JLabel getJLabelModeloUtilizadoTN93() {
		return jLabelModeloUtilizadoTN93;
	}

	public JLabel getJLabelModeloUtilizadoWAG() {
		return jLabelModeloUtilizadoWAG;
	}

	public JLabel getJLabelProporcaoDayhoff() {
		return jLabelProporcaoDayhoff;
	}

	public JLabel getJLabelProporcaoDCMut() {
		return jLabelProporcaoDCMut;
	}

	public JLabel getJLabelProporcaoF81() {
		return jLabelProporcaoF81;
	}

	public JLabel getJLabelProporcaoF84() {
		return jLabelProporcaoF84;
	}

	public JLabel getJLabelProporcaoGTR() {
		return jLabelProporcaoGTR;
	}

	public JLabel getJLabelProporcaoHKY() {
		return jLabelProporcaoHKY;
	}

	public JLabel getJLabelProporcaoJC69() {
		return jLabelProporcaoJC69;
	}

	public JLabel getJLabelProporcaoJTT() {
		return jLabelProporcaoJTT;
	}

	public JLabel getJLabelProporcaoK2P() {
		return jLabelProporcaoK2P;
	}

	public JLabel getJLabelProporcaoMtREV() {
		return jLabelProporcaoMtREV;
	}

	public JLabel getJLabelProporcaoTN93() {
		return jLabelProporcaoTN93;
	}

	public JLabel getJLabelProporcaoWAG() {
		return jLabelProporcaoWAG;
	}

	public JLabel getJLabelRelacaoF81() {
		return jLabelRelacaoF81;
	}

	public JLabel getJLabelRelacaoF84() {
		return jLabelRelacaoF84;
	}

	public JLabel getJLabelRelacaoGTR() {
		return jLabelRelacaoGTR;
	}

	public JLabel getJLabelRelacaoHKY() {
		return jLabelRelacaoHKY;
	}

	public JLabel getJLabelRelacaoJC69() {
		return jLabelRelacaoJC69;
	}

	public JLabel getJLabelRelacaoK2P() {
		return jLabelRelacaoK2P;
	}

	public JLabel getJLabelRelacaoTN93() {
		return jLabelRelacaoTN93;
	}

	public JLabel getJLabelTaxaArvore() {
		return jLabelTaxaArvore;
	}

	public JLabel getJLabelTaxaDayhoff() {
		return jLabelTaxaDayhoff;
	}

	public JLabel getJLabelTaxaDCMut() {
		return jLabelTaxaDCMut;
	}

	public JLabel getJLabelTaxaF81() {
		return jLabelTaxaF81;
	}

	public JLabel getJLabelTaxaF84() {
		return jLabelTaxaF84;
	}

	public JLabel getJLabelTaxaGTR() {
		return jLabelTaxaGTR;
	}

	public JLabel getJLabelTaxaHKY() {
		return jLabelTaxaHKY;
	}

	public JLabel getJLabelTaxaJC69() {
		return jLabelTaxaJC69;
	}

	public JLabel getJLabelTaxaJTT() {
		return jLabelTaxaJTT;
	}

	public JLabel getJLabelTaxaK2P() {
		return jLabelTaxaK2P;
	}

	public JLabel getJLabelTaxaMtREV() {
		return jLabelTaxaMtREV;
	}

	public JLabel getJLabelTaxaTN93() {
		return jLabelTaxaTN93;
	}

	public JLabel getJLabelTaxaWAG() {
		return jLabelTaxaWAG;
	}

	public JLabel getJLabelTipoArquivo() {
		return jLabelTipoArquivo;
	}


	public JLabel getJLabelTipoExecucaoParalelo() {
		return jLabelTipoExecucaoParalelo;
	}

	public JLabel getJLabelTipoExecucaoSequencial() {
		return jLabelTipoExecucaoSequencial;
	}

	public JLabel getJLabelTopologiaArvore() {
		return jLabelTopologiaArvore;
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
	 * This method initializes jMenuConfiguracoes
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getJMenuConfiguracoes() {
		if (jMenuConfiguracoes == null) {
			jMenuConfiguracoes = new JMenu();
			jMenuConfiguracoes.setText("Configurações");
			jMenuConfiguracoes.add(getJMenuIdiomas());
			jMenuConfiguracoes.add(getJMenuPerfil());
		}
		return jMenuConfiguracoes;
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
			jMenuIdiomas.add(getJCheckBoxMenuItemIngles());
			jMenuIdiomas.add(getJCheckBoxMenuItemPortugues());
		}
		return jMenuIdiomas;
	}

	/**
	 * This method initializes jMenuItemCriarPerfil
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJMenuItemCriarPerfil() {
		if (jMenuItemCriarPerfil == null) {
			jMenuItemCriarPerfil = new JMenuItem();
			jMenuItemCriarPerfil.setText("Criar Perfil");
		}
		return jMenuItemCriarPerfil;
	}

	/**
	 * This method initializes jMenuItemDeletarPerfil
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJMenuItemDeletarPerfil() {
		if (jMenuItemDeletarPerfil == null) {
			jMenuItemDeletarPerfil = new JMenuItem();
			jMenuItemDeletarPerfil.setText("Deletar Perfil");
		}
		return jMenuItemDeletarPerfil;
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
			jMenuItemFechar.setIcon(getIcon(oldImagesPath+"fechar.gif"));
			jMenuItemFechar.setActionCommand("fechar");
		}
		return jMenuItemFechar;
	}
	
	/**
	 * Este metodo pega todos os icones da classe Phyml
	 * caso o icone não seja encontrado uma mensagem é
	 * exibida no terminal e o programa continua a 
	 * execução.
	 * @param path
	 */
	public ImageIcon getIcon(String path)
	{
		try {
			return new ImageIcon(
				getClass().getResource(path));
		} catch (Exception e) {
			System.out.println("Um icone não pôde ser " +
					"exibido:");
			System.out.println(path);
			System.out.println("Causa:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method initializes jMenuPerfil
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getJMenuPerfil() {
		if (jMenuPerfil == null) {
			jMenuPerfil = new JMenu();
			jMenuPerfil.setText("Perfil");
			jMenuPerfil.add(getJMenuItemCriarPerfil());
			jMenuPerfil.add(getJMenuItemDeletarPerfil());
		}
		return jMenuPerfil;
	}

	

	

	/**
	 * This method initializes jNumberFloatFieldGamaDayhoff
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaDayhoff() {
		if (jNumberFloatFieldGamaDayhoff == null) {
			jNumberFloatFieldGamaDayhoff = new JNumberFloatField();
			jNumberFloatFieldGamaDayhoff.setLocation(new Point(345, 265));
			jNumberFloatFieldGamaDayhoff.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaDayhoff;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaDCMut
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaDCMut() {
		if (jNumberFloatFieldGamaDCMut == null) {
			jNumberFloatFieldGamaDCMut = new JNumberFloatField();
			jNumberFloatFieldGamaDCMut.setLocation(new Point(345, 265));
			jNumberFloatFieldGamaDCMut.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaDCMut;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaF81
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaF81() {
		if (jNumberFloatFieldGamaF81 == null) {
			jNumberFloatFieldGamaF81 = new JNumberFloatField();
			jNumberFloatFieldGamaF81.setLocation(new Point(345, 279));
			jNumberFloatFieldGamaF81.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaF81;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaF84
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaF84() {
		if (jNumberFloatFieldGamaF84 == null) {
			jNumberFloatFieldGamaF84 = new JNumberFloatField();
			jNumberFloatFieldGamaF84.setSize(new Dimension(65, 20));
			jNumberFloatFieldGamaF84.setLocation(new Point(345, 279));
		}
		return jNumberFloatFieldGamaF84;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaGTR
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaGTR() {
		if (jNumberFloatFieldGamaGTR == null) {
			jNumberFloatFieldGamaGTR = new JNumberFloatField();
			jNumberFloatFieldGamaGTR.setLocation(new Point(345, 279));
			jNumberFloatFieldGamaGTR.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaGTR;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaHKY
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaHKY() {
		if (jNumberFloatFieldGamaHKY == null) {
			jNumberFloatFieldGamaHKY = new JNumberFloatField();
			jNumberFloatFieldGamaHKY.setLocation(new Point(345, 279));
			jNumberFloatFieldGamaHKY.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaHKY;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaJC69
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaJC69() {
		if (jNumberFloatFieldGamaJC69 == null) {
			jNumberFloatFieldGamaJC69 = new JNumberFloatField();
			jNumberFloatFieldGamaJC69.setLocation(new Point(345, 279));
			jNumberFloatFieldGamaJC69.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaJC69;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaJTT
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaJTT() {
		if (jNumberFloatFieldGamaJTT == null) {
			jNumberFloatFieldGamaJTT = new JNumberFloatField();
			jNumberFloatFieldGamaJTT.setLocation(new Point(345, 265));
			jNumberFloatFieldGamaJTT.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaJTT;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaK2P
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaK2P() {
		if (jNumberFloatFieldGamaK2P == null) {
			jNumberFloatFieldGamaK2P = new JNumberFloatField();
			jNumberFloatFieldGamaK2P.setLocation(new Point(345, 279));
			jNumberFloatFieldGamaK2P.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaK2P;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaMtREV
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaMtREV() {
		if (jNumberFloatFieldGamaMtREV == null) {
			jNumberFloatFieldGamaMtREV = new JNumberFloatField();
			jNumberFloatFieldGamaMtREV.setLocation(new Point(345, 265));
			jNumberFloatFieldGamaMtREV.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaMtREV;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaTN93
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaTN93() {
		if (jNumberFloatFieldGamaTN93 == null) {
			jNumberFloatFieldGamaTN93 = new JNumberFloatField();
			jNumberFloatFieldGamaTN93.setLocation(new Point(345, 279));
			jNumberFloatFieldGamaTN93.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaTN93;
	}

	/**
	 * This method initializes jNumberFloatFieldGamaWAG
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldGamaWAG() {
		if (jNumberFloatFieldGamaWAG == null) {
			jNumberFloatFieldGamaWAG = new JNumberFloatField();
			jNumberFloatFieldGamaWAG.setLocation(new Point(345, 265));
			jNumberFloatFieldGamaWAG.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldGamaWAG;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoDayhoff
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoDayhoff() {
		if (jNumberFloatFieldProporcaoDayhoff == null) {
			jNumberFloatFieldProporcaoDayhoff = new JNumberFloatField();
			jNumberFloatFieldProporcaoDayhoff.setLocation(new Point(345, 106));
			jNumberFloatFieldProporcaoDayhoff.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoDayhoff;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoDCMut
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoDCMut() {
		if (jNumberFloatFieldProporcaoDCMut == null) {
			jNumberFloatFieldProporcaoDCMut = new JNumberFloatField();
			jNumberFloatFieldProporcaoDCMut.setLocation(new Point(345, 106));
			jNumberFloatFieldProporcaoDCMut.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoDCMut;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoF81
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoF81() {
		if (jNumberFloatFieldProporcaoF81 == null) {
			jNumberFloatFieldProporcaoF81 = new JNumberFloatField();
			jNumberFloatFieldProporcaoF81.setLocation(new Point(345, 153));
			jNumberFloatFieldProporcaoF81.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoF81;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoF84
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoF84() {
		if (jNumberFloatFieldProporcaoF84 == null) {
			jNumberFloatFieldProporcaoF84 = new JNumberFloatField();
			jNumberFloatFieldProporcaoF84.setSize(new Dimension(65, 20));
			jNumberFloatFieldProporcaoF84.setLocation(new Point(345, 153));
		}
		return jNumberFloatFieldProporcaoF84;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoGTR
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoGTR() {
		if (jNumberFloatFieldProporcaoGTR == null) {
			jNumberFloatFieldProporcaoGTR = new JNumberFloatField();
			jNumberFloatFieldProporcaoGTR.setLocation(new Point(345, 153));
			jNumberFloatFieldProporcaoGTR.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoGTR;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoHKY
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoHKY() {
		if (jNumberFloatFieldProporcaoHKY == null) {
			jNumberFloatFieldProporcaoHKY = new JNumberFloatField();
			jNumberFloatFieldProporcaoHKY.setLocation(new Point(345, 153));
			jNumberFloatFieldProporcaoHKY.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoHKY;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoJC69
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoJC69() {
		if (jNumberFloatFieldProporcaoJC69 == null) {
			jNumberFloatFieldProporcaoJC69 = new JNumberFloatField();
			jNumberFloatFieldProporcaoJC69.setLocation(new Point(345, 153));
			jNumberFloatFieldProporcaoJC69.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoJC69;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoJTT
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoJTT() {
		if (jNumberFloatFieldProporcaoJTT == null) {
			jNumberFloatFieldProporcaoJTT = new JNumberFloatField();
			jNumberFloatFieldProporcaoJTT.setLocation(new Point(345, 106));
			jNumberFloatFieldProporcaoJTT.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoJTT;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoK2P
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoK2P() {
		if (jNumberFloatFieldProporcaoK2P == null) {
			jNumberFloatFieldProporcaoK2P = new JNumberFloatField();
			jNumberFloatFieldProporcaoK2P.setLocation(new Point(345, 153));
			jNumberFloatFieldProporcaoK2P.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoK2P;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoMtREV
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoMtREV() {
		if (jNumberFloatFieldProporcaoMtREV == null) {
			jNumberFloatFieldProporcaoMtREV = new JNumberFloatField();
			jNumberFloatFieldProporcaoMtREV.setLocation(new Point(345, 106));
			jNumberFloatFieldProporcaoMtREV.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoMtREV;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoTN93
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoTN93() {
		if (jNumberFloatFieldProporcaoTN93 == null) {
			jNumberFloatFieldProporcaoTN93 = new JNumberFloatField();
			jNumberFloatFieldProporcaoTN93.setLocation(new Point(345, 153));
			jNumberFloatFieldProporcaoTN93.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoTN93;
	}

	/**
	 * This method initializes jNumberFloatFieldProporcaoWAG
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldProporcaoWAG() {
		if (jNumberFloatFieldProporcaoWAG == null) {
			jNumberFloatFieldProporcaoWAG = new JNumberFloatField();
			jNumberFloatFieldProporcaoWAG.setLocation(new Point(345, 106));
			jNumberFloatFieldProporcaoWAG.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldProporcaoWAG;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoF81
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoF81() {
		if (jNumberFloatFieldRelacaoF81 == null) {
			jNumberFloatFieldRelacaoF81 = new JNumberFloatField();
			jNumberFloatFieldRelacaoF81.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoF81.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoF81.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoF81;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoF84
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoF84() {
		if (jNumberFloatFieldRelacaoF84 == null) {
			jNumberFloatFieldRelacaoF84 = new JNumberFloatField();
			jNumberFloatFieldRelacaoF84.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoF84.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoF84.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoF84;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoGTR
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoGTR() {
		if (jNumberFloatFieldRelacaoGTR == null) {
			jNumberFloatFieldRelacaoGTR = new JNumberFloatField();
			jNumberFloatFieldRelacaoGTR.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoGTR.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoGTR.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoGTR;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoHKY
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoHKY() {
		if (jNumberFloatFieldRelacaoHKY == null) {
			jNumberFloatFieldRelacaoHKY = new JNumberFloatField();
			jNumberFloatFieldRelacaoHKY.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoHKY.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoHKY.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoHKY;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoJC69
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoJC69() {
		if (jNumberFloatFieldRelacaoJC69 == null) {
			jNumberFloatFieldRelacaoJC69 = new JNumberFloatField();
			jNumberFloatFieldRelacaoJC69.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoJC69.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoJC69.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoJC69;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoK2P
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoK2P() {
		if (jNumberFloatFieldRelacaoK2P == null) {
			jNumberFloatFieldRelacaoK2P = new JNumberFloatField();
			jNumberFloatFieldRelacaoK2P.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoK2P.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoK2P.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoK2P;
	}

	/**
	 * This method initializes jNumberFloatFieldRelacaoTN93
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldRelacaoTN93() {
		if (jNumberFloatFieldRelacaoTN93 == null) {
			jNumberFloatFieldRelacaoTN93 = new JNumberFloatField();
			jNumberFloatFieldRelacaoTN93.setLocation(new Point(345, 90));
			jNumberFloatFieldRelacaoTN93.setFont(new Font("Arial", Font.PLAIN,
					12));
			jNumberFloatFieldRelacaoTN93.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldRelacaoTN93;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaDayhoff
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaDayhoff() {
		if (jNumberFloatFieldTaxaDayhoff == null) {
			jNumberFloatFieldTaxaDayhoff = new JNumberFloatField();
			jNumberFloatFieldTaxaDayhoff.setLocation(new Point(345, 186));
			jNumberFloatFieldTaxaDayhoff.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaDayhoff;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaDCMut
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaDCMut() {
		if (jNumberFloatFieldTaxaDCMut == null) {
			jNumberFloatFieldTaxaDCMut = new JNumberFloatField();
			jNumberFloatFieldTaxaDCMut.setLocation(new Point(345, 186));
			jNumberFloatFieldTaxaDCMut.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaDCMut;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaF81
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaF81() {
		if (jNumberFloatFieldTaxaF81 == null) {
			jNumberFloatFieldTaxaF81 = new JNumberFloatField();
			jNumberFloatFieldTaxaF81.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaF81.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaF81;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaF84
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaF84() {
		if (jNumberFloatFieldTaxaF84 == null) {
			jNumberFloatFieldTaxaF84 = new JNumberFloatField();
			jNumberFloatFieldTaxaF84.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaF84.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaF84;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaGTR
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaGTR() {
		if (jNumberFloatFieldTaxaGTR == null) {
			jNumberFloatFieldTaxaGTR = new JNumberFloatField();
			jNumberFloatFieldTaxaGTR.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaGTR.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaGTR;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaHKY
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaHKY() {
		if (jNumberFloatFieldTaxaHKY == null) {
			jNumberFloatFieldTaxaHKY = new JNumberFloatField();
			jNumberFloatFieldTaxaHKY.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaHKY.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaHKY;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaJC69
	 * 
	 * @return br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaJC69() {
		if (jNumberFloatFieldTaxaJC69 == null) {
			jNumberFloatFieldTaxaJC69 = new JNumberFloatField();
			jNumberFloatFieldTaxaJC69.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaJC69.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaJC69;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaJTT
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaJTT() {
		if (jNumberFloatFieldTaxaJTT == null) {
			jNumberFloatFieldTaxaJTT = new JNumberFloatField();
			jNumberFloatFieldTaxaJTT.setLocation(new Point(345, 186));
			jNumberFloatFieldTaxaJTT.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaJTT;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaK2P
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaK2P() {
		if (jNumberFloatFieldTaxaK2P == null) {
			jNumberFloatFieldTaxaK2P = new JNumberFloatField();
			jNumberFloatFieldTaxaK2P.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaK2P.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaK2P;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaMtREV
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaMtREV() {
		if (jNumberFloatFieldTaxaMtREV == null) {
			jNumberFloatFieldTaxaMtREV = new JNumberFloatField();
			jNumberFloatFieldTaxaMtREV.setLocation(new Point(345, 186));
			jNumberFloatFieldTaxaMtREV.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaMtREV;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaTN93
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaTN93() {
		if (jNumberFloatFieldTaxaTN93 == null) {
			jNumberFloatFieldTaxaTN93 = new JNumberFloatField();
			jNumberFloatFieldTaxaTN93.setLocation(new Point(345, 216));
			jNumberFloatFieldTaxaTN93.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaTN93;
	}

	/**
	 * This method initializes jNumberFloatFieldTaxaWAG
	 * 
	 * @return br.uesc.computacao.estagio.util.JNumberFloatField
	 */
	public JNumberFloatField getJNumberFloatFieldTaxaWAG() {
		if (jNumberFloatFieldTaxaWAG == null) {
			jNumberFloatFieldTaxaWAG = new JNumberFloatField();
			jNumberFloatFieldTaxaWAG.setLocation(new Point(345, 186));
			jNumberFloatFieldTaxaWAG.setSize(new Dimension(65, 20));
		}
		return jNumberFloatFieldTaxaWAG;
	}

	/**
	 * Este metodo inicializa o jPanelAA O qual da origem a aba "Modelo - AA"
	 * Este jPanelAA eh adicionado a jTabbedPaneGeral no metodo
	 * getJTabbedPaneGeral()
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelAA() {
		if (jPanelAA == null) {
			jPanelAA = new JPanel();
			jPanelAA.setLayout(null);
			jPanelAA.setBackground(new Color(173, 200, 226));
			jPanelAA.add(getJTabbedPaneModelosAA(), null);
		}
		return jPanelAA;
	}

	/**
	 * Este metodo inicializa o jPanelArvore O qual da origem a aba "Arvore"
	 * Este jPanelArvore eh adicionado a jTabbedPaneGeral no metodo
	 * getJTabbedPaneGeral()
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelArvore() {
		if (jPanelArvore == null) {
			jPanelArvore = new JPanel();
			jPanelArvore.setLayout(null);
			jPanelArvore.setBackground(new Color(173, 200, 226));
			jPanelArvore.add(getJPaneLArvore(), null);
		}
		return jPanelArvore;
	}

	/**
	 * This method initializes jPaneLArvore
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPaneLArvore() {
		if (jPaneLArvore == null) {
			jLabelTaxaArvore = new JLabel();
			jLabelTaxaArvore.setLocation(new Point(89, 179));
			jLabelTaxaArvore.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelTaxaArvore.setText("Otimizar comprimentos dos galhos");
			jLabelTaxaArvore.setSize(new Dimension(237, 15));
			jLabelTopologiaArvore = new JLabel();
			jLabelTopologiaArvore.setLocation(new Point(89, 105));
			jLabelTopologiaArvore.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelTopologiaArvore.setText("Otimizar topologia");
			jLabelTopologiaArvore.setSize(new Dimension(129, 15));
			jLabelArquivoArvore = new JLabel();
			jLabelArquivoArvore.setLocation(new Point(89, 31));
			jLabelArquivoArvore.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoArvore.setText("Inicializar árvore");
			jLabelArquivoArvore.setSize(new Dimension(118, 16));
			jPaneLArvore = new JPanel();
			jPaneLArvore.setLayout(null);
			jPaneLArvore.setBackground(new Color(173, 200, 226));
			jPaneLArvore.setSize(new Dimension(620, 345));
			jPaneLArvore.setLocation(new Point(0, 0));
			jPaneLArvore.add(jLabelArquivoArvore, null);
			jPaneLArvore.add(getJSeparatorArvore01(), null);
			jPaneLArvore.add(getJSeparatorArvore15(), null);
			jPaneLArvore.add(getJSeparatorArvore21(), null);
			jPaneLArvore.add(getJSeparatorArvore31(), null);
			jPaneLArvore.add(getJSeparatorArvore41(), null);
			jPaneLArvore.add(getJButtonArquivoArvore(), null);
			jPaneLArvore.add(jLabelTopologiaArvore, null);
			jPaneLArvore.add(getJSeparatorArvore51(), null);
			jPaneLArvore.add(getJSeparatorArvore61(), null);
			jPaneLArvore.add(getJSeparatorArvore71(), null);
			jPaneLArvore.add(getJSeparatorArvore81(), null);
			jPaneLArvore.add(getJSeparatorArvore91(), null);
			jPaneLArvore.add(getJRadioButtonTopologiaArvoreSim(), null);
			jPaneLArvore.add(getJRadioButtonTopologiaArvoreNao(), null);
			jPaneLArvore.add(getJTextFieldArquivoArvore(), null);
			jPaneLArvore.add(jLabelTaxaArvore, null);
			jPaneLArvore.add(getJSeparatorArvore101(), null);
			jPaneLArvore.add(getJSeparatorArvore111(), null);
			jPaneLArvore.add(getJSeparatorArvore121(), null);
			jPaneLArvore.add(getJSeparatorArvore131(), null);
			jPaneLArvore.add(getJSeparatorArvore141(), null);
			jPaneLArvore.add(getJRadioButtonTaxaArvoreNao(), null);
			jPaneLArvore.add(getJRadioButtonTaxaArvoreSim(), null);
			jPaneLArvore.add(getJSeparatorArvoreS12(), null);
			jPaneLArvore.add(getJSeparatorArvoreS01(), null);
			jPaneLArvore.add(getJSeparatorArvoreS21(), null);
			jPaneLArvore.add(getJSeparatorArvoreS31(), null);
			jPaneLArvore.add(getJSeparatorArvoreS41(), null);
			jPaneLArvore.add(getJSeparatorArvoreS51(), null);
			jPaneLArvore.add(getJSeparatorArvoreS61(), null);
			jPaneLArvore.add(getJSeparatorArvoreS71(), null);
			jPaneLArvore.add(getJSeparatorArvoreS81(), null);
			jPaneLArvore.add(getJSeparatorArvoreS91(), null);
			jPaneLArvore.add(getJSeparatorArvoreS101(), null);
			jPaneLArvore.add(getJSeparatorArvoreS111(), null);
			jPaneLArvore.add(getJRadioButtonTopologiaArvoreArquivo(), null);
			jPaneLArvore.add(getJRadioButtonTopologiaArvoreBIONJ(), null);
		}
		return jPaneLArvore;
	}
	
	private ButtonGroup group;

	private JLabel jLabelTipoDado;

	//TODO Edit Bootstrap tab
	private void initializeJPanelBootstrap() {
		JPanel jBootstrap = new JPanel();
		jBootstrap.setBackground(new Color(173, 200, 226));
		jBootstrap.setLayout(null);
		initializeJLabelTipoBootstrap();
		initializeJLabelValorBootstrap();
		initializeJRadioButtonBootstrapInterno();
		initializeJRadioButtonBootstrapExterno();
		initializeJTextFieldValorBootstrap();
		setJBorderedPanelValorBootstrap();
		
		setButtonGroupTipoBootstrap();
	    //Add items.
	    jBootstrap.add(getJBorderedPanelTipoBootstrap());
	    jBootstrap.add(jBorderedPanelValorBootstrap);
	    
		jPanelBootstrap = jBootstrap;
	}

	private void setButtonGroupTipoBootstrap() {
		//Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
	    group.add(getJRadioButtonBootstrapInterno());
	    group.add(getJRadioButtonBootstrapExterno());
	}
	
	private void setJBorderedPanelValorBootstrap() {
		JBorderedPanel jb = new JBorderedPanel(
				getJLabelValorBootstrap(),
				false, new Dimension(500, 60), 138);
		jb.setBackground(new Color(173, 200, 226));
		jb.setLocation(60, 100);
		jb.add(getJTextFieldValorBootstrap());
		
		jb.setVisible(false);
		jBorderedPanelValorBootstrap = jb;
	}

	private JBorderedPanel getJBorderedPanelTipoBootstrap() {
		JBorderedPanel jb = new JBorderedPanel(
				getJLabelTipoBootstrap(),
				false, new Dimension(500, 60), 30);
		jb.setBackground(new Color(173, 200, 226));
		jb.setLocation(60, 20);
		jb.add(getJLabelTipoBootstrap());
		jb.add(getJRadioButtonBootstrapInterno());
		jb.add(getJRadioButtonBootstrapExterno());
		
		return jb;
	}

	public JPanel getJPanelBootstrap()
	{
		return jPanelBootstrap;
	}
	
	private void initializeJLabelTipoBootstrap()
	{
		JLabel jLabelTipoBootstrap = new JLabel("Tipo de bootstrap:");
		jLabelTipoBootstrap.setSize(jLabelTipoBootstrap.getPreferredSize());
		this.jLabelTipoBootstrap = jLabelTipoBootstrap;
		
	}
	
	public JLabel getJLabelTipoBootstrap()
	{
		return jLabelTipoBootstrap;
	}
	
	private void initializeJLabelValorBootstrap()
	{
		JLabel jLabelValorBootstrap = new JLabel("Número de dados" +
				" contidos no arquivo");
		jLabelValorBootstrap.setSize(jLabelValorBootstrap.getPreferredSize());
		this.jLabelValorBootstrap = jLabelValorBootstrap;
	}
	
	public JLabel getJLabelValorBootstrap()
	{
		return jLabelValorBootstrap;
	}
	
	private void initializeJRadioButtonBootstrapInterno()
	{
		JRadioButton jRadioButtonBootstrapInterno = new JRadioButton();
		jRadioButtonBootstrapInterno.setText("Calculado pelo PHYML");
		jRadioButtonBootstrapInterno.setSize(jRadioButtonBootstrapInterno.
				getPreferredSize());
		jRadioButtonBootstrapInterno
			.setBackground(new Color(173, 200, 226));
		
		jRadioButtonBootstrapInterno.setLocation(64, 25);
		this.jRadioButtonBootstrapInterno = jRadioButtonBootstrapInterno;
	}
	
	public JRadioButton getJRadioButtonBootstrapInterno()
	{
		return jRadioButtonBootstrapInterno;
	}
	
	private void initializeJRadioButtonBootstrapExterno() 
	{
		JRadioButton jRadioButtonBootstrapExterno = new JRadioButton();
		jRadioButtonBootstrapExterno.setText("No arquivo de entrada");
		jRadioButtonBootstrapExterno.setSize(jRadioButtonBootstrapExterno.
				getPreferredSize());
		jRadioButtonBootstrapExterno
			.setBackground(new Color(173, 200, 226));
		jRadioButtonBootstrapExterno.setLocation(93 + 
				getJRadioButtonBootstrapInterno().
				getSize().width + 50, 25);
		this.jRadioButtonBootstrapExterno = jRadioButtonBootstrapExterno;
	}
	 
	 
	 
	
	public JRadioButton getJRadioButtonBootstrapExterno()
	{
		return jRadioButtonBootstrapExterno;
	}
	
	private void initializeJTextFieldValorBootstrap() 
	{
		JTextField jTextFieldValorBootstrap = new JNumberField();
		jTextFieldValorBootstrap.setLocation(59, 160);
		jTextFieldValorBootstrap.setSize(150, 20);
		jTextFieldValorBootstrap.setText("1");
		jTextFieldValorBootstrap.setLocation(500/2 - 150/2,
				60/2 - 20/2 + 13);
		this.jTextFieldValorBootstrap = jTextFieldValorBootstrap;
	}
	
	public JTextField getJTextFieldValorBootstrap()
	{
		return jTextFieldValorBootstrap;
	}
	
	public String getBootstrapParameters()
	{
		String result = " ";
		if(getJRadioButtonBootstrapExterno().isSelected())
			result += getJTextFieldValorBootstrap().getText()
			+ " 0";
		else
			if(getJRadioButtonBootstrapInterno().isSelected())
				result += "1 " +
				getJTextFieldValorBootstrap().getText();
		/*In case internal bootstrap is selected the number
			of bootstrap the number of bootstrap contained in
			the input file must be 1*/
		return result;
			
	}

	/**
	 * This method initializes jPanelDayhoff
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelDayhoff() {
		if (jPanelDayhoff == null) {
			jLabelGamaDayhoff = new JLabel();
			jLabelGamaDayhoff.setLocation(new Point(45, 241));
			jLabelGamaDayhoff.setText("Parâmetro gama da distribuição");
			jLabelGamaDayhoff.setSize(new Dimension(210, 16));
			jLabelTaxaDayhoff = new JLabel();
			jLabelTaxaDayhoff.setLocation(new Point(45, 161));
			jLabelTaxaDayhoff
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaDayhoff.setSize(new Dimension(289, 16));
			jLabelProporcaoDayhoff = new JLabel();
			jLabelProporcaoDayhoff.setLocation(new Point(45, 82));
			jLabelProporcaoDayhoff.setText("Proporção de locais invariáveis");
			jLabelProporcaoDayhoff.setSize(new Dimension(202, 16));
			jLabelModeloUtilizadoDayhoff = new JLabel();
			jLabelModeloUtilizadoDayhoff.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoDayhoff.setFont(new Font("Arial", Font.BOLD,
					12));
			jLabelModeloUtilizadoDayhoff.setText("---");
			jLabelModeloUtilizadoDayhoff.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoDayhoff = new JLabel();
			jLabelModeloSelecionadoDayhoff.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoDayhoff.setFont(new Font("Arial", Font.BOLD,
					12));
			jLabelModeloSelecionadoDayhoff.setText("Modelo selecionado:");
			jLabelModeloSelecionadoDayhoff.setSize(new Dimension(133, 16));
			jPanelDayhoff = new JPanel();
			jPanelDayhoff.setLayout(null);
			jPanelDayhoff.setBackground(new Color(173, 200, 226));
			jPanelDayhoff.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelDayhoff.add(getJRadioButtonUtilizarModeloDayhoff(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff01(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff02(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff03(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff04(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff05(), null);
			jPanelDayhoff.add(jLabelModeloSelecionadoDayhoff, null);
			jPanelDayhoff.add(jLabelModeloUtilizadoDayhoff, null);
			jPanelDayhoff.add(jLabelProporcaoDayhoff, null);
			jPanelDayhoff.add(getJSeparatorDayhoff11(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff12(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff13(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff14(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff15(), null);
			jPanelDayhoff.add(getJNumberFloatFieldProporcaoDayhoff(), null);
			jPanelDayhoff.add(jLabelTaxaDayhoff, null);
			jPanelDayhoff.add(getJNumberFloatFieldTaxaDayhoff(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff16(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff17(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff18(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff19(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff20(), null);
			jPanelDayhoff.add(jLabelGamaDayhoff, null);
			jPanelDayhoff.add(getJSeparatorDayhoff21(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff22(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff23(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff24(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff25(), null);
			jPanelDayhoff.add(getJNumberFloatFieldGamaDayhoff(), null);
			jPanelDayhoff.add(getJRadioButtonGamaFixoDayhoff(), null);
			jPanelDayhoff.add(getJRadioButtonGamaEstimadoDayhoff(), null);
			jPanelDayhoff.add(getJRadioButtonProporcaoFixoDayhoff(), null);
			jPanelDayhoff.add(getJRadioButtonProporcaoEstimadoDayhoff(), null);
			jPanelDayhoff.add(getJSeparatorDayhoff1(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM2(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM3(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM4(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM5(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM6(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM7(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM8(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM9(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM10(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM11(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM12(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM13(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM14(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM15(), null);
			jPanelDayhoff.add(getJSeparatorDayhoffM16(), null);
		}
		return jPanelDayhoff;
	}

	/**
	 * This method initializes jPanelDCMut
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelDCMut() {
		if (jPanelDCMut == null) {
			jLabelGamaDCMut = new JLabel();
			jLabelGamaDCMut.setLocation(new Point(45, 241));
			jLabelGamaDCMut.setText("Parâmetro gama da distribuição");
			jLabelGamaDCMut.setSize(new Dimension(208, 16));
			jLabelTaxaDCMut = new JLabel();
			jLabelTaxaDCMut.setLocation(new Point(45, 161));
			jLabelTaxaDCMut
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaDCMut.setSize(new Dimension(292, 16));
			jLabelProporcaoDCMut = new JLabel();
			jLabelProporcaoDCMut.setLocation(new Point(45, 82));
			jLabelProporcaoDCMut.setText("Proporção de locais invariáveis");
			jLabelProporcaoDCMut.setSize(new Dimension(203, 16));
			jLabelModeloUtilizadoDCMut = new JLabel();
			jLabelModeloUtilizadoDCMut.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoDCMut
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoDCMut.setText("---");
			jLabelModeloUtilizadoDCMut.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoDCMut = new JLabel();
			jLabelModeloSelecionadoDCMut.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoDCMut.setFont(new Font("Arial", Font.BOLD,
					12));
			jLabelModeloSelecionadoDCMut.setText("Modelo selecionado:");
			jLabelModeloSelecionadoDCMut.setSize(new Dimension(133, 16));
			jPanelDCMut = new JPanel();
			jPanelDCMut.setLayout(null);
			jPanelDCMut.setBackground(new Color(173, 200, 226));
			jPanelDCMut.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelDCMut.add(getJRadioButtonUtilizarModeloDCMut(), null);
			jPanelDCMut.add(getJSeparatorDCMut01(), null);
			jPanelDCMut.add(getJSeparatorDCMut02(), null);
			jPanelDCMut.add(getJSeparatorDCMut03(), null);
			jPanelDCMut.add(getJSeparatorDCMut04(), null);
			jPanelDCMut.add(getJSeparatorDCMut05(), null);
			jPanelDCMut.add(jLabelModeloSelecionadoDCMut, null);
			jPanelDCMut.add(jLabelModeloUtilizadoDCMut, null);
			jPanelDCMut.add(jLabelProporcaoDCMut, null);
			jPanelDCMut.add(getJSeparatorDCMutM1(), null);
			jPanelDCMut.add(getJSeparatorDCMut12(), null);
			jPanelDCMut.add(getJSeparatorDCMut13(), null);
			jPanelDCMut.add(getJSeparatorDCMut14(), null);
			jPanelDCMut.add(getJSeparatorDCMut15(), null);
			jPanelDCMut.add(getJNumberFloatFieldProporcaoDCMut(), null);
			jPanelDCMut.add(jLabelTaxaDCMut, null);
			jPanelDCMut.add(getJNumberFloatFieldTaxaDCMut(), null);
			jPanelDCMut.add(getJSeparatorDCMut16(), null);
			jPanelDCMut.add(getJSeparatorDCMut17(), null);
			jPanelDCMut.add(getJSeparatorDCMut18(), null);
			jPanelDCMut.add(getJSeparatorDCMut19(), null);
			jPanelDCMut.add(getJSeparatorDCMut20(), null);
			jPanelDCMut.add(jLabelGamaDCMut, null);
			jPanelDCMut.add(getSeparatorDCMut21(), null);
			jPanelDCMut.add(getJSeparatorDCMut22(), null);
			jPanelDCMut.add(getJSeparatorDCMut23(), null);
			jPanelDCMut.add(getJSeparatorDCMut24(), null);
			jPanelDCMut.add(getJSeparatorDCMut25(), null);
			jPanelDCMut.add(getJNumberFloatFieldGamaDCMut(), null);
			jPanelDCMut.add(getJRadioButtonGamaFixoDCMut(), null);
			jPanelDCMut.add(getJRadioButtonGamaEstimadoDCMut(), null);
			jPanelDCMut.add(getJRadioButtonProporcaoFixoDCMut(), null);
			jPanelDCMut.add(getJRadioButtonProporcaoEstimadoDCMut(), null);
			jPanelDCMut.add(getJSeparatorDCMut11(), null);
			jPanelDCMut.add(getJSeparatorDCMutM21(), null);
			jPanelDCMut.add(getJSeparatorDCMutM3(), null);
			jPanelDCMut.add(getJSeparatorDCMutM4(), null);
			jPanelDCMut.add(getJSeparatorDCMutM5(), null);
			jPanelDCMut.add(getJSeparatorDCMutM6(), null);
			jPanelDCMut.add(getJSeparatorDCMutM7(), null);
			jPanelDCMut.add(getJSeparatorDCMutM8(), null);
			jPanelDCMut.add(getJSeparatorDCMutM9(), null);
			jPanelDCMut.add(getJSeparatorDCMutM10(), null);
			jPanelDCMut.add(getJSeparatorDCMutM11(), null);
			jPanelDCMut.add(getJSeparatorDCMutM12(), null);
			jPanelDCMut.add(getJSeparatorDCMutM13(), null);
			jPanelDCMut.add(getJSeparatorDCMutM14(), null);
			jPanelDCMut.add(getJSeparatorDCMutM15(), null);
			jPanelDCMut.add(getJSeparatorDCMutM16(), null);
		}
		return jPanelDCMut;
	}

	/**
	 * Este metodo inicializa o jPanelDNA O qual da origem a aba "Modelo - DNA"
	 * Este jPanelDNA eh adicionado a jTabbedPaneGeral no metodo
	 * getJTabbedPaneGeral()
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelDNA() {
		if (jPanelDNA == null) {
			jPanelDNA = new JPanel();
			jPanelDNA.setLayout(null);
			jPanelDNA.setBackground(new Color(173, 200, 226));
			jPanelDNA.setForeground(new Color(51, 51, 51));
			jPanelDNA.add(getJTabbedPaneModelosDNA(), null);
		}
		return jPanelDNA;
	}

	/**
	 * This method initializes jPanelF81
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelF81() {
		if (jPanelF81 == null) {
			jLabelGamaF81 = new JLabel();
			jLabelGamaF81.setLocation(new Point(45, 255));
			jLabelGamaF81.setText("Parâmetro gama da distribuição");
			jLabelGamaF81.setSize(new Dimension(209, 16));
			jLabelTaxaF81 = new JLabel();
			jLabelTaxaF81.setLocation(new Point(45, 192));
			jLabelTaxaF81
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaF81.setSize(new Dimension(292, 16));
			jLabelProporcaoF81 = new JLabel();
			jLabelProporcaoF81.setLocation(new Point(45, 129));
			jLabelProporcaoF81.setText("Proporção de locais invariáveis");
			jLabelProporcaoF81.setSize(new Dimension(206, 16));
			jLabelRelacaoF81 = new JLabel();
			jLabelRelacaoF81.setLocation(new Point(45, 67));
			jLabelRelacaoF81.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoF81.setText("Relação Transição/Transversão");
			jLabelRelacaoF81.setSize(new Dimension(209, 16));
			jLabelModeloUtilizadoF81 = new JLabel();
			jLabelModeloUtilizadoF81.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoF81.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoF81.setText("---");
			jLabelModeloUtilizadoF81.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoF81 = new JLabel();
			jLabelModeloSelecionadoF81.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoF81
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoF81.setText("Modelo selecionado:");
			jLabelModeloSelecionadoF81.setSize(new Dimension(133, 16));
			jPanelF81 = new JPanel();
			jPanelF81.setLayout(null);
			jPanelF81.setBackground(new Color(173, 200, 226));
			jPanelF81.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelF81.add(getJRadioButtonUtilizarModeloF81(), null);
			jPanelF81.add(getJSeparatorHKY01111(), null);
			jPanelF81.add(getJSeparatorHKY02111(), null);
			jPanelF81.add(getJSeparatorHKY03111(), null);
			jPanelF81.add(getJSeparatorHKY04111(), null);
			jPanelF81.add(getJSeparatorHKY05111(), null);
			jPanelF81.add(jLabelModeloSelecionadoF81, null);
			jPanelF81.add(jLabelModeloUtilizadoF81, null);
			jPanelF81.add(jLabelRelacaoF81, null);
			jPanelF81.add(getJSeparatorHKY06111(), null);
			jPanelF81.add(getJSeparatorHKY07211(), null);
			jPanelF81.add(getJSeparatorHKY08111(), null);
			jPanelF81.add(getJSeparatorHKY09111(), null);
			jPanelF81.add(getJSeparatorHKY10111(), null);
			jPanelF81.add(getJNumberFloatFieldRelacaoF81(), null);
			jPanelF81.add(getJRadioButtonRelacaoFixoF81(), null);
			jPanelF81.add(getJRadioButtonRelacaoEstimadoF81(), null);
			jPanelF81.add(jLabelProporcaoF81, null);
			jPanelF81.add(getJSeparatorHKY11111(), null);
			jPanelF81.add(getJSeparatorHKY12111(), null);
			jPanelF81.add(getJSeparatorHKY13111(), null);
			jPanelF81.add(getJSeparatorHKY14111(), null);
			jPanelF81.add(getJSeparatorHKY15111(), null);
			jPanelF81.add(getJNumberFloatFieldProporcaoF81(), null);
			jPanelF81.add(jLabelTaxaF81, null);
			jPanelF81.add(getJNumberFloatFieldTaxaF81(), null);
			jPanelF81.add(getJSeparatorHKY16111(), null);
			jPanelF81.add(getJSeparatorHKY17111(), null);
			jPanelF81.add(getJSeparatorHKY18111(), null);
			jPanelF81.add(getJSeparatorHKY19111(), null);
			jPanelF81.add(getJSeparatorHKY20111(), null);
			jPanelF81.add(jLabelGamaF81, null);
			jPanelF81.add(getJSeparatorHKY21111(), null);
			jPanelF81.add(getJSeparatorHKY22111(), null);
			jPanelF81.add(getJSeparatorHKY23111(), null);
			jPanelF81.add(getJSeparatorHKY24111(), null);
			jPanelF81.add(getJSeparatorHKY25111(), null);
			jPanelF81.add(getJNumberFloatFieldGamaF81(), null);
			jPanelF81.add(getJRadioButtonGamaFixoF81(), null);
			jPanelF81.add(getJRadioButtonGamaEstimadoF81(), null);
			jPanelF81.add(getJRadioButtonProporcaoFixoF81(), null);
			jPanelF81.add(getJRadioButtonProporcaoEstimadoF81(), null);
			jPanelF81.add(getJSeparatorHKY1101(), null);
			jPanelF81.add(getJSeparatorHKYM3111(), null);
			jPanelF81.add(getJSeparatorHKYM4111(), null);
			jPanelF81.add(getJSeparatorHKYM5111(), null);
			jPanelF81.add(getJSeparatorHKYM6111(), null);
			jPanelF81.add(getJSeparatorHKYM7111(), null);
			jPanelF81.add(getJSeparatorHKYM8111(), null);
			jPanelF81.add(getJSeparatorHKYM11111(), null);
			jPanelF81.add(getJSeparatorHKYM9111(), null);
			jPanelF81.add(getJSeparatorHKYM10111(), null);
			jPanelF81.add(getJSeparatorHKYM11011(), null);
			jPanelF81.add(getJSeparatorHKYM12111(), null);
			jPanelF81.add(getJSeparatorHKYM13111(), null);
			jPanelF81.add(getJSeparatorHKYM14111(), null);
			jPanelF81.add(getJSeparatorHKYM15111(), null);
			jPanelF81.add(getJSeparatorHKYM16111(), null);
			jPanelF81.add(getJSeparatorHKYM17111(), null);
			jPanelF81.add(getJSeparatorHKYM18111(), null);
			jPanelF81.add(getJSeparatorHKYM19111(), null);
			jPanelF81.add(getJSeparatorHKYM20111(), null);
		}
		return jPanelF81;
	}

	/**
	 * This method initializes jPanelF84
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelF84() {
		if (jPanelF84 == null) {
			jLabelGamaF84 = new JLabel();
			jLabelGamaF84.setText("Parâmetro gama da distribuição");
			jLabelGamaF84.setLocation(new Point(45, 255));
			jLabelGamaF84.setSize(new Dimension(209, 16));
			jLabelTaxaF84 = new JLabel();
			jLabelTaxaF84
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaF84.setLocation(new Point(45, 192));
			jLabelTaxaF84.setSize(new Dimension(291, 16));
			jLabelProporcaoF84 = new JLabel();
			jLabelProporcaoF84.setText("Proporção de locais invariáveis");
			jLabelProporcaoF84.setLocation(new Point(45, 129));
			jLabelProporcaoF84.setSize(new Dimension(206, 16));
			jLabelRelacaoF84 = new JLabel();
			jLabelRelacaoF84.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoF84.setSize(new Dimension(209, 16));
			jLabelRelacaoF84.setLocation(new Point(45, 67));
			jLabelRelacaoF84.setText("Relação Transição/Transversão");
			jLabelModeloUtilizadoF84 = new JLabel();
			jLabelModeloUtilizadoF84.setText("---");
			jLabelModeloUtilizadoF84.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoF84.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoF84.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoF84 = new JLabel();
			jLabelModeloSelecionadoF84.setText("Modelo selecionado:");
			jLabelModeloSelecionadoF84.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoF84
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoF84.setSize(new Dimension(133, 16));
			jPanelF84 = new JPanel();
			jPanelF84.setLayout(null);
			jPanelF84.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelF84.setBackground(new Color(173, 200, 226));
			jPanelF84.add(getJRadioButtonUtilizarModeloF84(), null);
			jPanelF84.add(getJSeparatorF8401(), null);
			jPanelF84.add(getJSeparatorF8402(), null);
			jPanelF84.add(getJSeparatorF8403(), null);
			jPanelF84.add(getJSeparatorF8404(), null);
			jPanelF84.add(getJSeparatorF8405(), null);
			jPanelF84.add(jLabelModeloSelecionadoF84, null);
			jPanelF84.add(jLabelModeloUtilizadoF84, null);
			jPanelF84.add(jLabelRelacaoF84, null);
			jPanelF84.add(getJSeparatorF8406(), null);
			jPanelF84.add(getJSeparatorF8407(), null);
			jPanelF84.add(getJSeparatorF8408(), null);
			jPanelF84.add(getJSeparatorF8409(), null);
			jPanelF84.add(getJSeparatorF8410(), null);
			jPanelF84.add(getJNumberFloatFieldRelacaoF84(), null);
			jPanelF84.add(getJRadioButtonRelacaoFixoF84(), null);
			jPanelF84.add(getJRadioButtonRelacaoEstimadoF84(), null);
			jPanelF84.add(jLabelProporcaoF84, null);
			jPanelF84.add(getJSeparatorF8411(), null);
			jPanelF84.add(getJSeparatorF8412(), null);
			jPanelF84.add(getJSeparatorF8413(), null);
			jPanelF84.add(getJSeparatorF8414(), null);
			jPanelF84.add(getJSeparatorF8415(), null);
			jPanelF84.add(getJNumberFloatFieldProporcaoF84(), null);
			jPanelF84.add(jLabelTaxaF84, null);
			jPanelF84.add(getJNumberFloatFieldTaxaF84(), null);
			jPanelF84.add(getJSeparatorF8416(), null);
			jPanelF84.add(getJSeparatorF8417(), null);
			jPanelF84.add(getJSeparatorF8418(), null);
			jPanelF84.add(getJSeparatorF8419(), null);
			jPanelF84.add(getJSeparatorF8420(), null);
			jPanelF84.add(jLabelGamaF84, null);
			jPanelF84.add(getJSeparatorF8421(), null);
			jPanelF84.add(getJSeparatorF8422(), null);
			jPanelF84.add(getJSeparatorF8423(), null);
			jPanelF84.add(getJSeparatorF8424(), null);
			jPanelF84.add(getJSeparatorF8425(), null);
			jPanelF84.add(getJNumberFloatFieldGamaF84(), null);
			jPanelF84.add(getJRadioButtonGamaFixoF84(), null);
			jPanelF84.add(getJRadioButtonGamaEstimadoF84(), null);
			jPanelF84.add(getJRadioButtonProporcaoFixoF84(), null);
			jPanelF84.add(getJRadioButtonProporcaoEstimadoF84(), null);
			jPanelF84.add(getJSeparatorF84M2(), null);
			jPanelF84.add(getJSeparatorF84M3(), null);
			jPanelF84.add(getJSeparatorF84M4(), null);
			jPanelF84.add(getJSeparatorF84M5(), null);
			jPanelF84.add(getJSeparatorF84M6(), null);
			jPanelF84.add(getJSeparatorF84M7(), null);
			jPanelF84.add(getJSeparatorF84M8(), null);
			jPanelF84.add(getJSeparatorF84M1(), null);
			jPanelF84.add(getJSeparatorF84M9(), null);
			jPanelF84.add(getJSeparatorF84M10(), null);
			jPanelF84.add(getJSeparatorF84M11(), null);
			jPanelF84.add(getJSeparatorF84M12(), null);
			jPanelF84.add(getJSeparatorF84M13(), null);
			jPanelF84.add(getJSeparatorF84M14(), null);
			jPanelF84.add(getJSeparatorF84M15(), null);
			jPanelF84.add(getJSeparatorF84M16(), null);
			jPanelF84.add(getJSeparatorF84M17(), null);
			jPanelF84.add(getJSeparatorF84M18(), null);
			jPanelF84.add(getJSeparatorF84M19(), null);
			jPanelF84.add(getJSeparatorF84M20(), null);
		}
		return jPanelF84;
	}

	/**
	 * This method initializes jPanelGTR
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelGTR() {
		if (jPanelGTR == null) {
			jLabelGamaGTR = new JLabel();
			jLabelGamaGTR.setLocation(new Point(45, 255));
			jLabelGamaGTR.setText("Parâmetro gama da distribuição");
			jLabelGamaGTR.setSize(new Dimension(209, 16));
			jLabelTaxaGTR = new JLabel();
			jLabelTaxaGTR.setLocation(new Point(45, 192));
			jLabelTaxaGTR
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaGTR.setSize(new Dimension(292, 16));
			jLabelProporcaoGTR = new JLabel();
			jLabelProporcaoGTR.setLocation(new Point(45, 129));
			jLabelProporcaoGTR.setText("Proporção de locais invariáveis");
			jLabelProporcaoGTR.setSize(new Dimension(206, 16));
			jLabelRelacaoGTR = new JLabel();
			jLabelRelacaoGTR.setLocation(new Point(45, 67));
			jLabelRelacaoGTR.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoGTR.setText("Relação Transição/Transversão");
			jLabelRelacaoGTR.setSize(new Dimension(209, 16));
			jLabelModeloUtilizadoGTR = new JLabel();
			jLabelModeloUtilizadoGTR.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoGTR.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoGTR.setText("---");
			jLabelModeloUtilizadoGTR.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoGTR = new JLabel();
			jLabelModeloSelecionadoGTR.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoGTR
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoGTR.setText("Modelo selecionado:");
			jLabelModeloSelecionadoGTR.setSize(new Dimension(133, 16));
			jPanelGTR = new JPanel();
			jPanelGTR.setLayout(null);
			jPanelGTR.setBackground(new Color(173, 200, 226));
			jPanelGTR.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelGTR.add(getJRadioButtonUtilizarModeloGTR(), null);
			jPanelGTR.add(getJSeparatorHKY0111(), null);
			jPanelGTR.add(getJSeparatorHKY0211(), null);
			jPanelGTR.add(getJSeparatorHKY0311(), null);
			jPanelGTR.add(getJSeparatorHKY0411(), null);
			jPanelGTR.add(getJSeparatorHKY0511(), null);
			jPanelGTR.add(jLabelModeloSelecionadoGTR, null);
			jPanelGTR.add(jLabelModeloUtilizadoGTR, null);
			jPanelGTR.add(jLabelRelacaoGTR, null);
			jPanelGTR.add(getJSeparatorHKY0611(), null);
			jPanelGTR.add(getJSeparatorHKY0721(), null);
			jPanelGTR.add(getJSeparatorHKY0811(), null);
			jPanelGTR.add(getJSeparatorHKY0911(), null);
			jPanelGTR.add(getJSeparatorHKY1011(), null);
			jPanelGTR.add(getJNumberFloatFieldRelacaoGTR(), null);
			jPanelGTR.add(getJRadioButtonRelacaoFixoGTR(), null);
			jPanelGTR.add(getJRadioButtonRelacaoEstimadoGTR(), null);
			jPanelGTR.add(jLabelProporcaoGTR, null);
			jPanelGTR.add(getJSeparatorHKY1111(), null);
			jPanelGTR.add(getJSeparatorHKY1211(), null);
			jPanelGTR.add(getJSeparatorHKY1311(), null);
			jPanelGTR.add(getJSeparatorHKY1411(), null);
			jPanelGTR.add(getJSeparatorHKY1511(), null);
			jPanelGTR.add(getJNumberFloatFieldProporcaoGTR(), null);
			jPanelGTR.add(jLabelTaxaGTR, null);
			jPanelGTR.add(getJNumberFloatFieldTaxaGTR(), null);
			jPanelGTR.add(getJSeparatorHKY1611(), null);
			jPanelGTR.add(getJSeparatorHKY1711(), null);
			jPanelGTR.add(getJSeparatorHKY1811(), null);
			jPanelGTR.add(getJSeparatorHKY1911(), null);
			jPanelGTR.add(getJSeparatorHKY2011(), null);
			jPanelGTR.add(jLabelGamaGTR, null);
			jPanelGTR.add(getJSeparatorHKY2111(), null);
			jPanelGTR.add(getJSeparatorHKY2211(), null);
			jPanelGTR.add(getJSeparatorHKY2311(), null);
			jPanelGTR.add(getJSeparatorHKY2411(), null);
			jPanelGTR.add(getJSeparatorHKY2511(), null);
			jPanelGTR.add(getJNumberFloatFieldGamaGTR(), null);
			jPanelGTR.add(getJRadioButtonGamaFixoGTR(), null);
			jPanelGTR.add(getJRadioButtonGamaEstimadoGTR(), null);
			jPanelGTR.add(getJRadioButtonProporcaoFixoGTR(), null);
			jPanelGTR.add(getJRadioButtonProporcaoEstimadoGTR(), null);
			jPanelGTR.add(getJSeparatorHKY110(), null);
			jPanelGTR.add(getJSeparatorHKYM311(), null);
			jPanelGTR.add(getJSeparatorHKYM411(), null);
			jPanelGTR.add(getJSeparatorHKYM511(), null);
			jPanelGTR.add(getJSeparatorHKYM611(), null);
			jPanelGTR.add(getJSeparatorHKYM711(), null);
			jPanelGTR.add(getJSeparatorHKYM811(), null);
			jPanelGTR.add(getJSeparatorHKYM1111(), null);
			jPanelGTR.add(getJSeparatorHKYM911(), null);
			jPanelGTR.add(getJSeparatorHKYM1011(), null);
			jPanelGTR.add(getJSeparatorHKYM1101(), null);
			jPanelGTR.add(getJSeparatorHKYM1211(), null);
			jPanelGTR.add(getJSeparatorHKYM1311(), null);
			jPanelGTR.add(getJSeparatorHKYM1411(), null);
			jPanelGTR.add(getJSeparatorHKYM1511(), null);
			jPanelGTR.add(getJSeparatorHKYM1611(), null);
			jPanelGTR.add(getJSeparatorHKYM1711(), null);
			jPanelGTR.add(getJSeparatorHKYM1811(), null);
			jPanelGTR.add(getJSeparatorHKYM1911(), null);
			jPanelGTR.add(getJSeparatorHKYM2011(), null);
		}
		return jPanelGTR;
	}

	/**
	 * This method initializes jPanelHKY
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelHKY() {
		if (jPanelHKY == null) {
			jLabelGamaHKY = new JLabel();
			jLabelGamaHKY.setLocation(new Point(45, 255));
			jLabelGamaHKY.setText("Parâmetro gama da distribuição");
			jLabelGamaHKY.setSize(new Dimension(209, 16));
			jLabelTaxaHKY = new JLabel();
			jLabelTaxaHKY.setLocation(new Point(45, 192));
			jLabelTaxaHKY
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaHKY.setSize(new Dimension(292, 16));
			jLabelProporcaoHKY = new JLabel();
			jLabelProporcaoHKY.setLocation(new Point(45, 129));
			jLabelProporcaoHKY.setText("Proporção de locais invariáveis");
			jLabelProporcaoHKY.setSize(new Dimension(206, 16));
			jLabelRelacaoHKY = new JLabel();
			jLabelRelacaoHKY.setLocation(new Point(45, 67));
			jLabelRelacaoHKY.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoHKY.setText("Relação Transição/Transversão");
			jLabelRelacaoHKY.setSize(new Dimension(209, 16));
			jLabelModeloUtilizadoHKY = new JLabel();
			jLabelModeloUtilizadoHKY.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoHKY.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoHKY.setText("---");
			jLabelModeloUtilizadoHKY.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoHKY = new JLabel();
			jLabelModeloSelecionadoHKY.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoHKY
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoHKY.setText("Modelo selecionado:");
			jLabelModeloSelecionadoHKY.setSize(new Dimension(133, 16));
			jPanelHKY = new JPanel();
			jPanelHKY.setLayout(null);
			jPanelHKY.setBackground(new Color(173, 200, 226));
			jPanelHKY.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelHKY.add(getJRadioButtonUtilizarModeloHKY(), null);
			jPanelHKY.add(getJSeparatorHKY01(), null);
			jPanelHKY.add(getJSeparatorHKY02(), null);
			jPanelHKY.add(getJSeparatorHKY03(), null);
			jPanelHKY.add(getJSeparatorHKY04(), null);
			jPanelHKY.add(getJSeparatorHKY05(), null);
			jPanelHKY.add(jLabelModeloSelecionadoHKY, null);
			jPanelHKY.add(jLabelModeloUtilizadoHKY, null);
			jPanelHKY.add(jLabelRelacaoHKY, null);
			jPanelHKY.add(getJSeparatorHKY06(), null);
			jPanelHKY.add(getJSeparatorHKY07(), null);
			jPanelHKY.add(getJSeparatorHKY08(), null);
			jPanelHKY.add(getJSeparatorHKY09(), null);
			jPanelHKY.add(getJSeparatorHKY10(), null);
			jPanelHKY.add(getJNumberFloatFieldRelacaoHKY(), null);
			jPanelHKY.add(getJRadioButtonRelacaoFixoHKY(), null);
			jPanelHKY.add(getJRadioButtonRelacaoEstimadoHKY(), null);
			jPanelHKY.add(jLabelProporcaoHKY, null);
			jPanelHKY.add(getJSeparatorHKY11(), null);
			jPanelHKY.add(getJSeparatorHKY12(), null);
			jPanelHKY.add(getJSeparatorHKY13(), null);
			jPanelHKY.add(getJSeparatorHKY14(), null);
			jPanelHKY.add(getJSeparatorHKY15(), null);
			jPanelHKY.add(getJNumberFloatFieldProporcaoHKY(), null);
			jPanelHKY.add(jLabelTaxaHKY, null);
			jPanelHKY.add(getJNumberFloatFieldTaxaHKY(), null);
			jPanelHKY.add(getJSeparatorHKY16(), null);
			jPanelHKY.add(getJSeparatorHKY17(), null);
			jPanelHKY.add(getJSeparatorHKY18(), null);
			jPanelHKY.add(getJSeparatorHKY19(), null);
			jPanelHKY.add(getJSeparatorHKY20(), null);
			jPanelHKY.add(jLabelGamaHKY, null);
			jPanelHKY.add(getJSeparatorHKY21(), null);
			jPanelHKY.add(getJSeparatorHKY22(), null);
			jPanelHKY.add(getJSeparatorHKY23(), null);
			jPanelHKY.add(getJSeparatorHKY24(), null);
			jPanelHKY.add(getJSeparatorHKY25(), null);
			jPanelHKY.add(getJNumberFloatFieldGamaHKY(), null);
			jPanelHKY.add(getJRadioButtonGamaFixoHKY(), null);
			jPanelHKY.add(getJRadioButtonGamaEstimadoHKY(), null);
			jPanelHKY.add(getJRadioButtonProporcaoFixoHKY(), null);
			jPanelHKY.add(getJRadioButtonProporcaoEstimadoHKY(), null);
			jPanelHKY.add(getJSeparatorHKY(), null);
			jPanelHKY.add(getJSeparatorHKYM3(), null);
			jPanelHKY.add(getJSeparatorHKYM4(), null);
			jPanelHKY.add(getJSeparatorHKYM5(), null);
			jPanelHKY.add(getJSeparatorHKYM6(), null);
			jPanelHKY.add(getJSeparatorHKYM7(), null);
			jPanelHKY.add(getJSeparatorHKYM8(), null);
			jPanelHKY.add(getJSeparatorHKYM11(), null);
			jPanelHKY.add(getJSeparatorHKYM9(), null);
			jPanelHKY.add(getJSeparatorHKYM10(), null);
			jPanelHKY.add(getJSeparatorHKYM1(), null);
			jPanelHKY.add(getJSeparatorHKYM12(), null);
			jPanelHKY.add(getJSeparatorHKYM13(), null);
			jPanelHKY.add(getJSeparatorHKYM14(), null);
			jPanelHKY.add(getJSeparatorHKYM15(), null);
			jPanelHKY.add(getJSeparatorHKYM16(), null);
			jPanelHKY.add(getJSeparatorHKYM17(), null);
			jPanelHKY.add(getJSeparatorHKYM18(), null);
			jPanelHKY.add(getJSeparatorHKYM19(), null);
			jPanelHKY.add(getJSeparatorHKYM20(), null);
		}
		return jPanelHKY;
	}

	/**
	 * This method initializes jPanelJC69
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelJC69() {
		if (jPanelJC69 == null) {
			jLabelGamaJC69 = new JLabel();
			jLabelGamaJC69.setLocation(new Point(45, 255));
			jLabelGamaJC69.setText("Parâmetro gama da distribuição");
			jLabelGamaJC69.setSize(new Dimension(209, 16));
			jLabelTaxaJC69 = new JLabel();
			jLabelTaxaJC69.setLocation(new Point(45, 192));
			jLabelTaxaJC69
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaJC69.setSize(new Dimension(292, 16));
			jLabelProporcaoJC69 = new JLabel();
			jLabelProporcaoJC69.setLocation(new Point(45, 129));
			jLabelProporcaoJC69.setText("Proporção de locais invariáveis");
			jLabelProporcaoJC69.setSize(new Dimension(206, 16));
			jLabelRelacaoJC69 = new JLabel();
			jLabelRelacaoJC69.setLocation(new Point(45, 67));
			jLabelRelacaoJC69.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoJC69.setText("Relação Transição/Transversão");
			jLabelRelacaoJC69.setSize(new Dimension(209, 16));
			jLabelModeloUtilizadoJC69 = new JLabel();
			jLabelModeloUtilizadoJC69.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoJC69.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoJC69.setText("---");
			jLabelModeloUtilizadoJC69.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoJC69 = new JLabel();
			jLabelModeloSelecionadoJC69.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoJC69
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoJC69.setText("Modelo selecionado:");
			jLabelModeloSelecionadoJC69.setSize(new Dimension(133, 16));
			jPanelJC69 = new JPanel();
			jPanelJC69.setLayout(null);
			jPanelJC69.setBackground(new Color(173, 200, 226));
			jPanelJC69.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelJC69.add(getJRadioButtonUtilizarModeloJC69(), null);
			jPanelJC69.add(getJSeparatorHKY011(), null);
			jPanelJC69.add(getJSeparatorHKY021(), null);
			jPanelJC69.add(getJSeparatorHKY031(), null);
			jPanelJC69.add(getJSeparatorHKY041(), null);
			jPanelJC69.add(getJSeparatorHKY051(), null);
			jPanelJC69.add(jLabelModeloSelecionadoJC69, null);
			jPanelJC69.add(jLabelModeloUtilizadoJC69, null);
			jPanelJC69.add(jLabelRelacaoJC69, null);
			jPanelJC69.add(getJSeparatorHKY061(), null);
			jPanelJC69.add(getJSeparatorHKY072(), null);
			jPanelJC69.add(getJSeparatorHKY081(), null);
			jPanelJC69.add(getJSeparatorHKY091(), null);
			jPanelJC69.add(getJSeparatorHKY101(), null);
			jPanelJC69.add(getJNumberFloatFieldRelacaoJC69(), null);
			jPanelJC69.add(getJRadioButtonRelacaoFixoJC69(), null);
			jPanelJC69.add(getJRadioButtonRelacaoEstimadoJC69(), null);
			jPanelJC69.add(jLabelProporcaoJC69, null);
			jPanelJC69.add(getJSeparatorHKY111(), null);
			jPanelJC69.add(getJSeparatorHKY121(), null);
			jPanelJC69.add(getJSeparatorHKY131(), null);
			jPanelJC69.add(getJSeparatorHKY141(), null);
			jPanelJC69.add(getJSeparatorHKY151(), null);
			jPanelJC69.add(getJNumberFloatFieldProporcaoJC69(), null);
			jPanelJC69.add(jLabelTaxaJC69, null);
			jPanelJC69.add(getJNumberFloatFieldTaxaJC69(), null);
			jPanelJC69.add(getJSeparatorHKY161(), null);
			jPanelJC69.add(getJSeparatorHKY171(), null);
			jPanelJC69.add(getJSeparatorHKY181(), null);
			jPanelJC69.add(getJSeparatorHKY191(), null);
			jPanelJC69.add(getJSeparatorHKY201(), null);
			jPanelJC69.add(jLabelGamaJC69, null);
			jPanelJC69.add(getJSeparatorHKY211(), null);
			jPanelJC69.add(getJSeparatorHKY221(), null);
			jPanelJC69.add(getJSeparatorHKY231(), null);
			jPanelJC69.add(getJSeparatorHKY241(), null);
			jPanelJC69.add(getJSeparatorHKY251(), null);
			jPanelJC69.add(getJNumberFloatFieldGamaJC69(), null);
			jPanelJC69.add(getJRadioButtonGamaFixoJC69(), null);
			jPanelJC69.add(getJRadioButtonGamaEstimadoJC69(), null);
			jPanelJC69.add(getJRadioButtonProporcaoFixoJC69(), null);
			jPanelJC69.add(getJRadioButtonProporcaoEstimadoJC69(), null);
			jPanelJC69.add(getJSeparatorHKY1(), null);
			jPanelJC69.add(getJSeparatorHKYM31(), null);
			jPanelJC69.add(getJSeparatorHKYM41(), null);
			jPanelJC69.add(getJSeparatorHKYM51(), null);
			jPanelJC69.add(getJSeparatorHKYM61(), null);
			jPanelJC69.add(getJSeparatorHKYM71(), null);
			jPanelJC69.add(getJSeparatorHKYM81(), null);
			jPanelJC69.add(getJSeparatorHKYM111(), null);
			jPanelJC69.add(getJSeparatorHKYM91(), null);
			jPanelJC69.add(getJSeparatorHKYM101(), null);
			jPanelJC69.add(getJSeparatorHKYM110(), null);
			jPanelJC69.add(getJSeparatorHKYM121(), null);
			jPanelJC69.add(getJSeparatorHKYM131(), null);
			jPanelJC69.add(getJSeparatorHKYM141(), null);
			jPanelJC69.add(getJSeparatorHKYM151(), null);
			jPanelJC69.add(getJSeparatorHKYM161(), null);
			jPanelJC69.add(getJSeparatorHKYM171(), null);
			jPanelJC69.add(getJSeparatorHKYM181(), null);
			jPanelJC69.add(getJSeparatorHKYM191(), null);
			jPanelJC69.add(getJSeparatorHKYM201(), null);
		}
		return jPanelJC69;
	}

	/**
	 * This method initializes jPanelJTT
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelJTT() {
		if (jPanelJTT == null) {
			jLabelGamaJTT = new JLabel();
			jLabelGamaJTT.setLocation(new Point(45, 241));
			jLabelGamaJTT.setText("Parâmetro gama da distribuição");
			jLabelGamaJTT.setSize(new Dimension(209, 16));
			jLabelTaxaJTT = new JLabel();
			jLabelTaxaJTT.setLocation(new Point(45, 161));
			jLabelTaxaJTT
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaJTT.setSize(new Dimension(291, 16));
			jLabelProporcaoJTT = new JLabel();
			jLabelProporcaoJTT.setLocation(new Point(45, 82));
			jLabelProporcaoJTT.setText("Proporção de locais invariáveis");
			jLabelProporcaoJTT.setSize(new Dimension(209, 16));
			jLabelModeloUtilizadoJTT = new JLabel();
			jLabelModeloUtilizadoJTT.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoJTT.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoJTT.setText("---");
			jLabelModeloUtilizadoJTT.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoJTT = new JLabel();
			jLabelModeloSelecionadoJTT.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoJTT
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoJTT.setText("Modelo selecionado:");
			jLabelModeloSelecionadoJTT.setSize(new Dimension(133, 16));
			jPanelJTT = new JPanel();
			jPanelJTT.setLayout(null);
			jPanelJTT.setBackground(new Color(173, 200, 226));
			jPanelJTT.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelJTT.add(getJRadioButtonUtilizarModeloJTT(), null);
			jPanelJTT.add(getJSeparatorJTT01(), null);
			jPanelJTT.add(getJSeparatorJTT02(), null);
			jPanelJTT.add(getJSeparatorJTT03(), null);
			jPanelJTT.add(getJSeparatorJTT04(), null);
			jPanelJTT.add(getJSeparatorJTT05(), null);
			jPanelJTT.add(jLabelModeloSelecionadoJTT, null);
			jPanelJTT.add(jLabelModeloUtilizadoJTT, null);
			jPanelJTT.add(jLabelProporcaoJTT, null);
			jPanelJTT.add(getJSeparatorJTT11(), null);
			jPanelJTT.add(getJSeparatorJTT12(), null);
			jPanelJTT.add(getJSeparatorJTT13(), null);
			jPanelJTT.add(getJSeparatorJTT14(), null);
			jPanelJTT.add(getJSeparatorJTT15(), null);
			jPanelJTT.add(getJNumberFloatFieldProporcaoJTT(), null);
			jPanelJTT.add(jLabelTaxaJTT, null);
			jPanelJTT.add(getJNumberFloatFieldTaxaJTT(), null);
			jPanelJTT.add(getJSeparatorJTT16(), null);
			jPanelJTT.add(getJSeparatorJTT17(), null);
			jPanelJTT.add(getJSeparatorJTT18(), null);
			jPanelJTT.add(getJSeparatorJTT19(), null);
			jPanelJTT.add(getJSeparatorJTT20(), null);
			jPanelJTT.add(jLabelGamaJTT, null);
			jPanelJTT.add(getJSeparatorJTT21(), null);
			jPanelJTT.add(getJSeparatorJTT22(), null);
			jPanelJTT.add(getJSeparatorJTT23(), null);
			jPanelJTT.add(getJSeparatorJTT24(), null);
			jPanelJTT.add(getJSeparatorJTT25(), null);
			jPanelJTT.add(getJNumberFloatFieldGamaJTT(), null);
			jPanelJTT.add(getJRadioButtonGamaFixoJTT(), null);
			jPanelJTT.add(getJRadioButtonGamaEstimadoJTT(), null);
			jPanelJTT.add(getJRadioButtonProporcaoFixoJTT(), null);
			jPanelJTT.add(getJRadioButtonProporcaoEstimadoJTT(), null);
			jPanelJTT.add(getJSeparatorDayhoff110(), null);
			jPanelJTT.add(getJSeparatorJTTM2(), null);
			jPanelJTT.add(getJSeparatorJTTM3(), null);
			jPanelJTT.add(getJSeparatorJTTM4(), null);
			jPanelJTT.add(getJSeparatorJTTM5(), null);
			jPanelJTT.add(getJSeparatorJTTM6(), null);
			jPanelJTT.add(getJSeparatorJTTM7(), null);
			jPanelJTT.add(getJSeparatorJTTM8(), null);
			jPanelJTT.add(getJSeparatorJTTM9(), null);
			jPanelJTT.add(getJSeparatorJTTM10(), null);
			jPanelJTT.add(getJSeparatorJTTM11(), null);
			jPanelJTT.add(getJSeparatorJTTM12(), null);
			jPanelJTT.add(getJSeparatorJTTM13(), null);
			jPanelJTT.add(getJSeparatorJTTM14(), null);
			jPanelJTT.add(getJSeparatorJTTM15(), null);
			jPanelJTT.add(getJSeparatorJTTM16(), null);
		}
		return jPanelJTT;
	}

	/**
	 * This method initializes jPanelK2P
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelK2P() {
		if (jPanelK2P == null) {
			jLabelGamaK2P = new JLabel();
			jLabelGamaK2P.setLocation(new Point(45, 255));
			jLabelGamaK2P.setText("Parâmetro gama da distribuição");
			jLabelGamaK2P.setSize(new Dimension(204, 16));
			jLabelTaxaK2P = new JLabel();
			jLabelTaxaK2P.setLocation(new Point(45, 192));
			jLabelTaxaK2P
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaK2P.setSize(new Dimension(289, 16));
			jLabelProporcaoK2P = new JLabel();
			jLabelProporcaoK2P.setLocation(new Point(45, 129));
			jLabelProporcaoK2P.setText("Proporção de locais invariáveis");
			jLabelProporcaoK2P.setSize(new Dimension(204, 16));
			jLabelRelacaoK2P = new JLabel();
			jLabelRelacaoK2P.setLocation(new Point(45, 67));
			jLabelRelacaoK2P.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoK2P.setText("Relação Transição/Transversão");
			jLabelRelacaoK2P.setSize(new Dimension(207, 16));
			jLabelModeloUtilizadoK2P = new JLabel();
			jLabelModeloUtilizadoK2P.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoK2P.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoK2P.setText("---");
			jLabelModeloUtilizadoK2P.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoK2P = new JLabel();
			jLabelModeloSelecionadoK2P.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoK2P
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoK2P.setText("Modelo selecionado:");
			jLabelModeloSelecionadoK2P.setSize(new Dimension(133, 16));
			jPanelK2P = new JPanel();
			jPanelK2P.setLayout(null);
			jPanelK2P.setBackground(new Color(173, 200, 226));
			jPanelK2P.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelK2P.add(getJRadioButtonUtilizarModeloK2P(), null);
			jPanelK2P.add(getJSeparatorK2P01(), null);
			jPanelK2P.add(getJSeparatorK2P02(), null);
			jPanelK2P.add(getJSeparatorK2P03(), null);
			jPanelK2P.add(getJSeparatorK2P04(), null);
			jPanelK2P.add(getJSeparatorK2P05(), null);
			jPanelK2P.add(jLabelModeloSelecionadoK2P, null);
			jPanelK2P.add(jLabelModeloUtilizadoK2P, null);
			jPanelK2P.add(jLabelRelacaoK2P, null);
			jPanelK2P.add(getJSeparatorK2P06(), null);
			jPanelK2P.add(getJSeparatorK2P07(), null);
			jPanelK2P.add(getJSeparatorK2P08(), null);
			jPanelK2P.add(getJSeparatorK2P09(), null);
			jPanelK2P.add(getJSeparatorK2P10(), null);
			jPanelK2P.add(getJNumberFloatFieldRelacaoK2P(), null);
			jPanelK2P.add(getJRadioButtonRelacaoFixoK2P(), null);
			jPanelK2P.add(getJRadioButtonRelacaoEstimadoK2P(), null);
			jPanelK2P.add(jLabelProporcaoK2P, null);
			jPanelK2P.add(getJSeparatorK2P11(), null);
			jPanelK2P.add(getJSeparatorK2P12(), null);
			jPanelK2P.add(getJSeparatorK2P13(), null);
			jPanelK2P.add(getJSeparatorK2P14(), null);
			jPanelK2P.add(getJSeparatorK2P15(), null);
			jPanelK2P.add(getJNumberFloatFieldProporcaoK2P(), null);
			jPanelK2P.add(jLabelTaxaK2P, null);
			jPanelK2P.add(getJNumberFloatFieldTaxaK2P(), null);
			jPanelK2P.add(getJSeparatorK2P16(), null);
			jPanelK2P.add(getJSeparatorK2P17(), null);
			jPanelK2P.add(getJSeparatorK2P18(), null);
			jPanelK2P.add(getJSeparatorK2P19(), null);
			jPanelK2P.add(getJSeparatorK2P20(), null);
			jPanelK2P.add(jLabelGamaK2P, null);
			jPanelK2P.add(getJSeparatorK2P21(), null);
			jPanelK2P.add(getJSeparatorK2P22(), null);
			jPanelK2P.add(getJSeparatorK2P23(), null);
			jPanelK2P.add(getJSeparatorK2P24(), null);
			jPanelK2P.add(getJSeparatorK2P25(), null);
			jPanelK2P.add(getJNumberFloatFieldGamaK2P(), null);
			jPanelK2P.add(getJRadioButtonGamaFixoK2P(), null);
			jPanelK2P.add(getJRadioButtonGamaEstimadoK2P(), null);
			jPanelK2P.add(getJRadioButtonProporcaoFixoK2P(), null);
			jPanelK2P.add(getJRadioButtonProporcaoEstimadoK2P(), null);
			jPanelK2P.add(getJSeparatorK2PM2(), null);
			jPanelK2P.add(getJSeparatorK2PM3(), null);
			jPanelK2P.add(getJSeparatorK2PM4(), null);
			jPanelK2P.add(getJSeparatorK2PM5(), null);
			jPanelK2P.add(getJSeparatorK2PM6(), null);
			jPanelK2P.add(getJSeparatorM7(), null);
			jPanelK2P.add(getJSeparatorK2PM8(), null);
			jPanelK2P.add(getJSeparatorK2PM11(), null);
			jPanelK2P.add(getJSeparatorK2PM9(), null);
			jPanelK2P.add(getJSeparatorK2PM10(), null);
			jPanelK2P.add(getJSeparatorK2PM1(), null);
			jPanelK2P.add(getJSeparatorK2PM12(), null);
			jPanelK2P.add(getJSeparatorHM13(), null);
			jPanelK2P.add(getJSeparatorK2PM14(), null);
			jPanelK2P.add(getJSeparatorK2PM15(), null);
			jPanelK2P.add(getJSeparatorK2PM16(), null);
			jPanelK2P.add(getJSeparatorK2PM17(), null);
			jPanelK2P.add(getJSeparatorK2PM18(), null);
			jPanelK2P.add(getJSeparatorK2PM19(), null);
			jPanelK2P.add(getJSeparatorK2PM20(), null);
		}
		return jPanelK2P;
	}

	/**
	 * This method initializes jPanelMtREV
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelMtREV() {
		if (jPanelMtREV == null) {
			jLabelGamaMtREV = new JLabel();
			jLabelGamaMtREV.setLocation(new Point(45, 241));
			jLabelGamaMtREV.setText("Parâmetro gama da distribuição");
			jLabelGamaMtREV.setSize(new Dimension(204, 16));
			jLabelTaxaMtREV = new JLabel();
			jLabelTaxaMtREV.setLocation(new Point(45, 161));
			jLabelTaxaMtREV
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaMtREV.setSize(new Dimension(291, 16));
			jLabelProporcaoMtREV = new JLabel();
			jLabelProporcaoMtREV.setLocation(new Point(45, 82));
			jLabelProporcaoMtREV.setText("Proporção de locais invariáveis");
			jLabelProporcaoMtREV.setSize(new Dimension(202, 16));
			jLabelModeloUtilizadoMtREV = new JLabel();
			jLabelModeloUtilizadoMtREV.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoMtREV
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoMtREV.setText("---");
			jLabelModeloUtilizadoMtREV.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoMtREV = new JLabel();
			jLabelModeloSelecionadoMtREV.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoMtREV.setFont(new Font("Arial", Font.BOLD,
					12));
			jLabelModeloSelecionadoMtREV.setText("Modelo selecionado:");
			jLabelModeloSelecionadoMtREV.setSize(new Dimension(133, 16));
			jPanelMtREV = new JPanel();
			jPanelMtREV.setLayout(null);
			jPanelMtREV.setBackground(new Color(173, 200, 226));
			jPanelMtREV.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelMtREV.add(getJRadioButtonUtilizarModeloMtREV(), null);
			jPanelMtREV.add(getJSeparatorMtREV01(), null);
			jPanelMtREV.add(getJSeparatorMtREV02(), null);
			jPanelMtREV.add(getJSeparatorMtREV03(), null);
			jPanelMtREV.add(getJSeparatorMtREV04(), null);
			jPanelMtREV.add(getJSeparatorMtREV05(), null);
			jPanelMtREV.add(jLabelModeloSelecionadoMtREV, null);
			jPanelMtREV.add(jLabelModeloUtilizadoMtREV, null);
			jPanelMtREV.add(jLabelProporcaoMtREV, null);
			jPanelMtREV.add(getJSeparatorMtREV11(), null);
			jPanelMtREV.add(getJSeparatorMtREV12(), null);
			jPanelMtREV.add(getJSeparatorMtREV13(), null);
			jPanelMtREV.add(getJSeparatorMtREV14(), null);
			jPanelMtREV.add(getJSeparatorMtREV15(), null);
			jPanelMtREV.add(getJNumberFloatFieldProporcaoMtREV(), null);
			jPanelMtREV.add(jLabelTaxaMtREV, null);
			jPanelMtREV.add(getJNumberFloatFieldTaxaMtREV(), null);
			jPanelMtREV.add(getJSeparatorMtREV16(), null);
			jPanelMtREV.add(getJSeparatorMtREV17(), null);
			jPanelMtREV.add(getJSeparatorMtREV18(), null);
			jPanelMtREV.add(getJSeparatorMtREV19(), null);
			jPanelMtREV.add(getJSeparatorMtREV20(), null);
			jPanelMtREV.add(jLabelGamaMtREV, null);
			jPanelMtREV.add(getSeparatorMtREV21(), null);
			jPanelMtREV.add(getJSeparatorMtREV22(), null);
			jPanelMtREV.add(getJSeparatorMtREV23(), null);
			jPanelMtREV.add(getJSeparatorMtREV24(), null);
			jPanelMtREV.add(getJSeparatorMtREV25(), null);
			jPanelMtREV.add(getJNumberFloatFieldGamaMtREV(), null);
			jPanelMtREV.add(getJRadioButtonGamaFixoMtREV(), null);
			jPanelMtREV.add(getJRadioButtonGamaEstimadoMtREV(), null);
			jPanelMtREV.add(getJRadioButtonProporcaoFixoMtREV(), null);
			jPanelMtREV.add(getJRadioButtonProporcaoEstimadoMtREV(), null);
			jPanelMtREV.add(getJSeparatorMtREV1(), null);
			jPanelMtREV.add(getJSeparatorMtREVM21(), null);
			jPanelMtREV.add(getJSeparatorMtREVM3(), null);
			jPanelMtREV.add(getJSeparatorMtREVM4(), null);
			jPanelMtREV.add(getJSeparatorMtREVM5(), null);
			jPanelMtREV.add(getJSeparatorMtREVM6(), null);
			jPanelMtREV.add(getJSeparatorMtREVM7(), null);
			jPanelMtREV.add(getJSeparatorMtREVM8(), null);
			jPanelMtREV.add(getJSeparatorMtREVM9(), null);
			jPanelMtREV.add(getJSeparatorMtREVM10(), null);
			jPanelMtREV.add(getJSeparatorMtREVM11(), null);
			jPanelMtREV.add(getJSeparatorMtREVM12(), null);
			jPanelMtREV.add(getJSeparatorMtREVM13(), null);
			jPanelMtREV.add(getJSeparatorMtREVM14(), null);
			jPanelMtREV.add(getJSeparatorMtREVM15(), null);
			jPanelMtREV.add(getJSeparatorMtREVM16(), null);
		}
		return jPanelMtREV;
	}

	/**
	 * This method initializes jPanelSequencia O qual da origem a aba
	 * "Sequencia" Este jPanelSequencia eh adicionado a jTabbedPaneGeral no
	 * metodo getJTabbedPaneGeral()
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelSequencia() {
		if (jPanelSequencia == null) {
			jLabelTipoArquivo = new JLabel();
			jLabelTipoArquivo.setText("Tipo de arquivo");
			jLabelTipoArquivo.setSize(new Dimension(108, 15));
			jLabelTipoArquivo.setLocation(new Point(89, 179));
			jLabelTipoArquivo.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelTipoDado = new JLabel();
			jLabelTipoDado.setText("Tipo de dado");
			jLabelTipoDado.setSize(new Dimension(94, 15));
			jLabelTipoDado.setLocation(new Point(89, 105));
			jLabelTipoDado.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoSequencia = new JLabel();
			jLabelArquivoSequencia.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelArquivoSequencia.setSize(new Dimension(76, 16));
			jLabelArquivoSequencia.setLocation(new Point(89, 31));
			jLabelArquivoSequencia.setText("Numero de entradas");
			jPanelSequencia = new JPanel();
			jPanelSequencia.setLayout(null);
			jPanelSequencia.setBackground(new Color(173, 200, 226));
			jPanelSequencia.add(getJRadioButtonTipoDadoDNA(), null);
			jPanelSequencia.add(getJRadioButtonTipoDadoAA(), null);
			jPanelSequencia.add(getJRadioButtonIntercalado(), null);
			jPanelSequencia.add(getJRadioButtonSequencial(), null);
			jPanelSequencia.add(getBorderedPanelTipoDeDado());
			jPanelSequencia.add(getBorderedPanelArquivo());
			jPanelSequencia.add(getBorderedPanelTipoArquivo());
                        
                        //getBorderedPanelTipoArquivo().setEnabled(false);
                        getJRadioButtonSequencial().setSelected(true);
                        jLabelTipoArquivo.setVisible(true);
		}
		return jPanelSequencia;
	}

	private JBorderedPanel getBorderedPanelTipoDeDado() {
		JBorderedPanel jb = new JBorderedPanel(
				jLabelTipoDado, false, new Dimension(500, 50), 30);
		jb.setBackground(new Color(173, 200, 226));
		jb.setLocation(60, 101);
		jb.add(getJRadioButtonTipoDadoAA());
		jb.add(getJRadioButtonTipoDadoDNA());
		return jb;
		
	}
	
	private JBorderedPanel getBorderedPanelArquivo() {
		JBorderedPanel jb = new JBorderedPanel(
				jLabelArquivoSequencia, false, 
				new Dimension(500, 60), 30);
		jb.setBackground(new Color(173, 200, 226));
		jb.setLocation(60, 20);
		jb.add(getJTextFieldArquivoSequencia());
		jb.add(getJButtonArquivoSequencia());
		return jb;
	}
	
	private JBorderedPanel getBorderedPanelTipoArquivo() {
		JBorderedPanel jb = new JBorderedPanel(
				jLabelTipoArquivo, false, 
				new Dimension(500, 60), 30);
		jb.setBackground(new Color(173, 200, 226));
		jb.setLocation(60, 171);
                jLabelTipoArquivo.setEnabled(false);
		//Os radio buttons não vão ser adicionados nessa variavel.
		return jb;
	}
	
	public JLabel getJLabelTipoDado(){
		return jLabelTipoDado;
	}

	/**
	 * This method initializes jPanelTipoExecucaoParalelo
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelTipoExecucaoParalelo() {
		if (jPanelTipoExecucaoParalelo == null) {
			jLabelTipoExecucaoParalelo = new JLabel();
			jLabelTipoExecucaoParalelo.setLocation(new Point(59, 16));
			jLabelTipoExecucaoParalelo.setText("Processadores");
			jLabelTipoExecucaoParalelo.setSize(new Dimension(100, 16));
			jPanelTipoExecucaoParalelo = new JPanel();
			jPanelTipoExecucaoParalelo.setLayout(null);
			jPanelTipoExecucaoParalelo.setBackground(new Color(173, 200, 226));
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap71(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap81(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap91(), null);
			jPanelTipoExecucaoParalelo.add(getJComboBoxTipoExecucaoParalelo(),
					null);
			jPanelTipoExecucaoParalelo.add(jLabelTipoExecucaoParalelo, null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap201(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap191(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap211(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap221(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap231(), null);
			jPanelTipoExecucaoParalelo.add(getJSeparatorBootstrap241(), null);
			jPanelTipoExecucaoParalelo.add(getJCheckBoxTipoExecucaoParalelo(),
					null);
		}
		return jPanelTipoExecucaoParalelo;
	}

	/**
	 * This method initializes jPanelTipoExecucaoSequencial
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelTipoExecucaoSequencial() {
		if (jPanelTipoExecucaoSequencial == null) {
			jLabelTipoExecucaoSequencial = new JLabel();
			jLabelTipoExecucaoSequencial.setText("Executar em");
			jLabelTipoExecucaoSequencial.setLocation(new Point(64, 13));
			jLabelTipoExecucaoSequencial.setSize(new Dimension(87, 16));
			jPanelTipoExecucaoSequencial = new JPanel();
			jPanelTipoExecucaoSequencial.setLayout(null);
			jPanelTipoExecucaoSequencial
					.setBackground(new Color(173, 200, 226));
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap7(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap8(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap9(), null);
			jPanelTipoExecucaoSequencial.add(
					getJComboBoxTipoExecucaoSequencial(), null);
			jPanelTipoExecucaoSequencial
					.add(jLabelTipoExecucaoSequencial, null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap20(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap19(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap21(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap22(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap23(), null);
			jPanelTipoExecucaoSequencial.add(getJSeparatorBootstrap24(), null);

		}
		return jPanelTipoExecucaoSequencial;
	}

	/**
	 * This method initializes jPanelTN93
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelTN93() {
		if (jPanelTN93 == null) {
			jLabelGamaTN93 = new JLabel();
			jLabelGamaTN93.setLocation(new Point(45, 255));
			jLabelGamaTN93.setText("Parâmetro gama da distribuição");
			jLabelGamaTN93.setSize(new Dimension(209, 16));
			jLabelTaxaTN93 = new JLabel();
			jLabelTaxaTN93.setLocation(new Point(45, 192));
			jLabelTaxaTN93
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaTN93.setSize(new Dimension(292, 16));
			jLabelProporcaoTN93 = new JLabel();
			jLabelProporcaoTN93.setLocation(new Point(45, 129));
			jLabelProporcaoTN93.setText("Proporção de locais invariáveis");
			jLabelProporcaoTN93.setSize(new Dimension(206, 16));
			jLabelRelacaoTN93 = new JLabel();
			jLabelRelacaoTN93.setLocation(new Point(45, 67));
			jLabelRelacaoTN93.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelRelacaoTN93.setText("Relação Transição/Transversão");
			jLabelRelacaoTN93.setSize(new Dimension(209, 16));
			jLabelModeloUtilizadoTN93 = new JLabel();
			jLabelModeloUtilizadoTN93.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoTN93.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoTN93.setText("---");
			jLabelModeloUtilizadoTN93.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoTN93 = new JLabel();
			jLabelModeloSelecionadoTN93.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoTN93
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoTN93.setText("Modelo selecionado:");
			jLabelModeloSelecionadoTN93.setSize(new Dimension(133, 16));
			jPanelTN93 = new JPanel();
			jPanelTN93.setLayout(null);
			jPanelTN93.setBackground(new Color(173, 200, 226));
			jPanelTN93.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelTN93.add(getJRadioButtonUtilizarModeloTN93(), null);
			jPanelTN93.add(getJSeparatorTN9301(), null);
			jPanelTN93.add(getJSeparatorTN9302(), null);
			jPanelTN93.add(getJSeparatorTN9303(), null);
			jPanelTN93.add(getJSeparatorTN9304(), null);
			jPanelTN93.add(getJSeparatorTN9305(), null);
			jPanelTN93.add(jLabelModeloSelecionadoTN93, null);
			jPanelTN93.add(jLabelModeloUtilizadoTN93, null);
			jPanelTN93.add(jLabelRelacaoTN93, null);
			jPanelTN93.add(getJSeparatorTN9306(), null);
			jPanelTN93.add(getJSeparatorTN9307(), null);
			jPanelTN93.add(getJSeparatorTN9308(), null);
			jPanelTN93.add(getJSeparatorTN9309(), null);
			jPanelTN93.add(getJSeparatorTN9310(), null);
			jPanelTN93.add(getJNumberFloatFieldRelacaoTN93(), null);
			jPanelTN93.add(getJRadioButtonRelacaoFixoTN93(), null);
			jPanelTN93.add(getJRadioButtonRelacaoEstimadoTN93(), null);
			jPanelTN93.add(jLabelProporcaoTN93, null);
			jPanelTN93.add(getJSeparatorTN9311(), null);
			jPanelTN93.add(getJSeparatorTN9312(), null);
			jPanelTN93.add(getJSeparatorTN9313(), null);
			jPanelTN93.add(getJSeparatorTN9314(), null);
			jPanelTN93.add(getJSeparatorTN9315(), null);
			jPanelTN93.add(getJNumberFloatFieldProporcaoTN93(), null);
			jPanelTN93.add(jLabelTaxaTN93, null);
			jPanelTN93.add(getJNumberFloatFieldTaxaTN93(), null);
			jPanelTN93.add(getJSeparatorTN9316(), null);
			jPanelTN93.add(getJSeparatorTN9317(), null);
			jPanelTN93.add(getJSeparatorTN9318(), null);
			jPanelTN93.add(getJSeparatorTN9319(), null);
			jPanelTN93.add(getJSeparatorTN9320(), null);
			jPanelTN93.add(jLabelGamaTN93, null);
			jPanelTN93.add(getJSeparatorTN9321(), null);
			jPanelTN93.add(getJSeparatorTN9322(), null);
			jPanelTN93.add(getJSeparatorTN9323(), null);
			jPanelTN93.add(getJSeparatorTN9324(), null);
			jPanelTN93.add(getJSeparatorTN9325(), null);
			jPanelTN93.add(getJNumberFloatFieldGamaTN93(), null);
			jPanelTN93.add(getJRadioButtonGamaFixoTN93(), null);
			jPanelTN93.add(getJRadioButtonGamaEstimadoTN93(), null);
			jPanelTN93.add(getJRadioButtonProporcaoFixoTN93(), null);
			jPanelTN93.add(getJRadioButtonProporcaoEstimadoTN93(), null);
			jPanelTN93.add(getJSeparatorTN93M2(), null);
			jPanelTN93.add(getJSeparatorTN93M3(), null);
			jPanelTN93.add(getJSeparatorTN93M4(), null);
			jPanelTN93.add(getJSeparatorTN93M5(), null);
			jPanelTN93.add(getJSeparatorTN93M6(), null);
			jPanelTN93.add(getJSeparatorTN93M7(), null);
			jPanelTN93.add(getJSeparatorTN93M8(), null);
			jPanelTN93.add(getJSeparatorTN93M11(), null);
			jPanelTN93.add(getJSeparatorTN93M9(), null);
			jPanelTN93.add(getJSeparatorTN93M10(), null);
			jPanelTN93.add(getJSeparatorTN93M1(), null);
			jPanelTN93.add(getJSeparatorTN93M12(), null);
			jPanelTN93.add(getJSeparatorTN93M13(), null);
			jPanelTN93.add(getJSeparatorTN93M14(), null);
			jPanelTN93.add(getJSeparatorTN93M15(), null);
			jPanelTN93.add(getJSeparatorTN93M16(), null);
			jPanelTN93.add(getJSeparatorM17(), null);
			jPanelTN93.add(getJSeparatorTN93M18(), null);
			jPanelTN93.add(getJSeparatorTN93M19(), null);
			jPanelTN93.add(getJSeparatorTN93M20(), null);
		}
		return jPanelTN93;
	}

	/**
	 * This method initializes jPanelWAG
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelWAG() {
		if (jPanelWAG == null) {
			jLabelGamaWAG = new JLabel();
			jLabelGamaWAG.setLocation(new Point(45, 241));
			jLabelGamaWAG.setText("Parâmetro gama da distribuição");
			jLabelGamaWAG.setSize(new Dimension(210, 16));
			jLabelTaxaWAG = new JLabel();
			jLabelTaxaWAG.setLocation(new Point(45, 161));
			jLabelTaxaWAG
					.setText("Número de categorias da taxa de substituição");
			jLabelTaxaWAG.setSize(new Dimension(294, 16));
			jLabelProporcaoWAG = new JLabel();
			jLabelProporcaoWAG.setLocation(new Point(45, 82));
			jLabelProporcaoWAG.setText("Proporção de locais invariáveis");
			jLabelProporcaoWAG.setSize(new Dimension(201, 16));
			jLabelModeloUtilizadoWAG = new JLabel();
			jLabelModeloUtilizadoWAG.setLocation(new Point(518, 24));
			jLabelModeloUtilizadoWAG.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloUtilizadoWAG.setText("---");
			jLabelModeloUtilizadoWAG.setSize(new Dimension(70, 16));
			jLabelModeloSelecionadoWAG = new JLabel();
			jLabelModeloSelecionadoWAG.setLocation(new Point(385, 24));
			jLabelModeloSelecionadoWAG
					.setFont(new Font("Arial", Font.BOLD, 12));
			jLabelModeloSelecionadoWAG.setText("Modelo selecionado:");
			jLabelModeloSelecionadoWAG.setSize(new Dimension(133, 16));
			jPanelWAG = new JPanel();
			jPanelWAG.setLayout(null);
			jPanelWAG.setBackground(new Color(173, 200, 226));
			jPanelWAG.setFont(new Font("Arial", Font.PLAIN, 12));
			jPanelWAG.add(getJRadioButtonUtilizarModeloWAG(), null);
			jPanelWAG.add(getJSeparatorWAG01(), null);
			jPanelWAG.add(getJSeparatorWAG02(), null);
			jPanelWAG.add(getJSeparatorWAG03(), null);
			jPanelWAG.add(getJSeparatorWAG04(), null);
			jPanelWAG.add(getJSeparatorWAG05(), null);
			jPanelWAG.add(jLabelModeloSelecionadoWAG, null);
			jPanelWAG.add(jLabelModeloUtilizadoWAG, null);
			jPanelWAG.add(jLabelProporcaoWAG, null);
			jPanelWAG.add(getJSeparatorWAG11(), null);
			jPanelWAG.add(getJSeparatorWAG12(), null);
			jPanelWAG.add(getJSeparatorWAG13(), null);
			jPanelWAG.add(getJSeparatorWAG14(), null);
			jPanelWAG.add(getJSeparatorWAG15(), null);
			jPanelWAG.add(getJNumberFloatFieldProporcaoWAG(), null);
			jPanelWAG.add(jLabelTaxaWAG, null);
			jPanelWAG.add(getJNumberFloatFieldTaxaWAG(), null);
			jPanelWAG.add(getJSeparatorWAG16(), null);
			jPanelWAG.add(getJSeparatorWAG17(), null);
			jPanelWAG.add(getJSeparatorWAG18(), null);
			jPanelWAG.add(getJSeparatorWAG19(), null);
			jPanelWAG.add(getJSeparatorWAG20(), null);
			jPanelWAG.add(jLabelGamaWAG, null);
			jPanelWAG.add(getJSeparatorWAG21(), null);
			jPanelWAG.add(getJSeparatorWAG22(), null);
			jPanelWAG.add(getJSeparatorWAG23(), null);
			jPanelWAG.add(getJSeparatorWAG24(), null);
			jPanelWAG.add(getJSeparatorWAG25(), null);
			jPanelWAG.add(getJNumberFloatFieldGamaWAG(), null);
			jPanelWAG.add(getJRadioButtonGamaFixoWAG(), null);
			jPanelWAG.add(getJRadioButtonGamaEstimadoWAG(), null);
			jPanelWAG.add(getJRadioButtonProporcaoFixoWAG(), null);
			jPanelWAG.add(getJRadioButtonProporcaoEstimadoWAG(), null);
			jPanelWAG.add(getJSeparatorWAG110(), null);
			jPanelWAG.add(getJSeparatorWAGM2(), null);
			jPanelWAG.add(getJSeparatorWAGM3(), null);
			jPanelWAG.add(getJSeparatorWAGM4(), null);
			jPanelWAG.add(getJSeparatorWAGM5(), null);
			jPanelWAG.add(getJSeparatorWAGM6(), null);
			jPanelWAG.add(getJSeparatorWAGM7(), null);
			jPanelWAG.add(getJSeparatorWAGM8(), null);
			jPanelWAG.add(getJSeparatorWAGM9(), null);
			jPanelWAG.add(getJSeparatorWAGM10(), null);
			jPanelWAG.add(getJSeparatorWAGM11(), null);
			jPanelWAG.add(getJSeparatorWAGM12(), null);
			jPanelWAG.add(getJSeparatorWAGM13(), null);
			jPanelWAG.add(getJSeparatorWAGM14(), null);
			jPanelWAG.add(getJSeparatorWAGM15(), null);
			jPanelWAG.add(getJSeparatorWAGM16(), null);
		}
		return jPanelWAG;
	}

	/**
	 * This method initializes jProgressBar
	 * 
	 * @return javax.swing.JProgressBar
	 */
	public JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setLocation(new Point(34, 399));
			jProgressBar.setSize(new Dimension(194, 15));
			jProgressBar.setVisible(false);
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoDayhoff
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoDayhoff() {
		if (jRadioButtonGamaEstimadoDayhoff == null) {
			jRadioButtonGamaEstimadoDayhoff = new JRadioButton();
			jRadioButtonGamaEstimadoDayhoff.setLocation(new Point(493, 265));
			jRadioButtonGamaEstimadoDayhoff.setBackground(new Color(173, 200,
					226));
			jRadioButtonGamaEstimadoDayhoff.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonGamaEstimadoDayhoff.setText("Estimado");
			jRadioButtonGamaEstimadoDayhoff.setSize(new Dimension(101, 23));
		}
		return jRadioButtonGamaEstimadoDayhoff;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoDCMut
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoDCMut() {
		if (jRadioButtonGamaEstimadoDCMut == null) {
			jRadioButtonGamaEstimadoDCMut = new JRadioButton();
			jRadioButtonGamaEstimadoDCMut.setLocation(new Point(493, 265));
			jRadioButtonGamaEstimadoDCMut
					.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoDCMut.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonGamaEstimadoDCMut.setText("Estimado");
			jRadioButtonGamaEstimadoDCMut.setSize(new Dimension(103, 23));
		}
		return jRadioButtonGamaEstimadoDCMut;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoF81() {
		if (jRadioButtonGamaEstimadoF81 == null) {
			jRadioButtonGamaEstimadoF81 = new JRadioButton();
			jRadioButtonGamaEstimadoF81.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoF81.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoF81
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoF81.setText("Estimado");
			jRadioButtonGamaEstimadoF81.setSize(new Dimension(100, 23));
		}
		return jRadioButtonGamaEstimadoF81;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoF84() {
		if (jRadioButtonGamaEstimadoF84 == null) {
			jRadioButtonGamaEstimadoF84 = new JRadioButton();
			jRadioButtonGamaEstimadoF84
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoF84.setText("Estimado");
			jRadioButtonGamaEstimadoF84.setSize(new Dimension(97, 23));
			jRadioButtonGamaEstimadoF84.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoF84.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonGamaEstimadoF84;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoGTR() {
		if (jRadioButtonGamaEstimadoGTR == null) {
			jRadioButtonGamaEstimadoGTR = new JRadioButton();
			jRadioButtonGamaEstimadoGTR.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoGTR.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoGTR
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoGTR.setText("Estimado");
			jRadioButtonGamaEstimadoGTR.setSize(new Dimension(100, 23));
		}
		return jRadioButtonGamaEstimadoGTR;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoHKY() {
		if (jRadioButtonGamaEstimadoHKY == null) {
			jRadioButtonGamaEstimadoHKY = new JRadioButton();
			jRadioButtonGamaEstimadoHKY.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoHKY.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoHKY
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoHKY.setText("Estimado");
			jRadioButtonGamaEstimadoHKY.setSize(new Dimension(100, 23));
		}
		return jRadioButtonGamaEstimadoHKY;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoJC69() {
		if (jRadioButtonGamaEstimadoJC69 == null) {
			jRadioButtonGamaEstimadoJC69 = new JRadioButton();
			jRadioButtonGamaEstimadoJC69.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoJC69
					.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoJC69.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonGamaEstimadoJC69.setText("Estimado");
			jRadioButtonGamaEstimadoJC69.setSize(new Dimension(100, 23));
		}
		return jRadioButtonGamaEstimadoJC69;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoJTT
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoJTT() {
		if (jRadioButtonGamaEstimadoJTT == null) {
			jRadioButtonGamaEstimadoJTT = new JRadioButton();
			jRadioButtonGamaEstimadoJTT.setLocation(new Point(493, 265));
			jRadioButtonGamaEstimadoJTT.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoJTT
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoJTT.setText("Estimado");
			jRadioButtonGamaEstimadoJTT.setSize(new Dimension(102, 23));
		}
		return jRadioButtonGamaEstimadoJTT;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoK2P() {
		if (jRadioButtonGamaEstimadoK2P == null) {
			jRadioButtonGamaEstimadoK2P = new JRadioButton();
			jRadioButtonGamaEstimadoK2P.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoK2P.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoK2P
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoK2P.setText("Estimado");
			jRadioButtonGamaEstimadoK2P.setSize(new Dimension(100, 23));
		}
		return jRadioButtonGamaEstimadoK2P;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoMtREV
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoMtREV() {
		if (jRadioButtonGamaEstimadoMtREV == null) {
			jRadioButtonGamaEstimadoMtREV = new JRadioButton();
			jRadioButtonGamaEstimadoMtREV.setLocation(new Point(493, 265));
			jRadioButtonGamaEstimadoMtREV
					.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoMtREV.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonGamaEstimadoMtREV.setText("Estimado");
			jRadioButtonGamaEstimadoMtREV.setSize(new Dimension(105, 23));
		}
		return jRadioButtonGamaEstimadoMtREV;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoTN93() {
		if (jRadioButtonGamaEstimadoTN93 == null) {
			jRadioButtonGamaEstimadoTN93 = new JRadioButton();
			jRadioButtonGamaEstimadoTN93.setLocation(new Point(493, 279));
			jRadioButtonGamaEstimadoTN93
					.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoTN93.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonGamaEstimadoTN93.setText("Estimado");
			jRadioButtonGamaEstimadoTN93.setSize(new Dimension(98, 23));
		}
		return jRadioButtonGamaEstimadoTN93;
	}

	/**
	 * This method initializes jRadioButtonGamaEstimadoWAG
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaEstimadoWAG() {
		if (jRadioButtonGamaEstimadoWAG == null) {
			jRadioButtonGamaEstimadoWAG = new JRadioButton();
			jRadioButtonGamaEstimadoWAG.setLocation(new Point(493, 265));
			jRadioButtonGamaEstimadoWAG.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaEstimadoWAG
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaEstimadoWAG.setText("Estimado");
			jRadioButtonGamaEstimadoWAG.setSize(new Dimension(103, 23));
		}
		return jRadioButtonGamaEstimadoWAG;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoDayhoff
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoDayhoff() {
		if (jRadioButtonGamaFixoDayhoff == null) {
			jRadioButtonGamaFixoDayhoff = new JRadioButton();
			jRadioButtonGamaFixoDayhoff.setLocation(new Point(425, 265));
			jRadioButtonGamaFixoDayhoff.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoDayhoff
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoDayhoff.setText("Fixo");
			jRadioButtonGamaFixoDayhoff.setSize(new Dimension(57, 23));
		}
		return jRadioButtonGamaFixoDayhoff;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoDCMut
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoDCMut() {
		if (jRadioButtonGamaFixoDCMut == null) {
			jRadioButtonGamaFixoDCMut = new JRadioButton();
			jRadioButtonGamaFixoDCMut.setLocation(new Point(425, 265));
			jRadioButtonGamaFixoDCMut.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoDCMut.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoDCMut.setText("Fixo");
			jRadioButtonGamaFixoDCMut.setSize(new Dimension(59, 23));
		}
		return jRadioButtonGamaFixoDCMut;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoF81() {
		if (jRadioButtonGamaFixoF81 == null) {
			jRadioButtonGamaFixoF81 = new JRadioButton();
			jRadioButtonGamaFixoF81.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoF81.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoF81.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoF81.setText("Fixo");
			jRadioButtonGamaFixoF81.setSize(new Dimension(61, 23));
		}
		return jRadioButtonGamaFixoF81;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoF84() {
		if (jRadioButtonGamaFixoF84 == null) {
			jRadioButtonGamaFixoF84 = new JRadioButton();
			jRadioButtonGamaFixoF84.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoF84.setText("Fixo");
			jRadioButtonGamaFixoF84.setSize(new Dimension(58, 23));
			jRadioButtonGamaFixoF84.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoF84.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonGamaFixoF84;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoGTR() {
		if (jRadioButtonGamaFixoGTR == null) {
			jRadioButtonGamaFixoGTR = new JRadioButton();
			jRadioButtonGamaFixoGTR.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoGTR.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoGTR.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoGTR.setText("Fixo");
			jRadioButtonGamaFixoGTR.setSize(new Dimension(61, 23));
		}
		return jRadioButtonGamaFixoGTR;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoHKY() {
		if (jRadioButtonGamaFixoHKY == null) {
			jRadioButtonGamaFixoHKY = new JRadioButton();
			jRadioButtonGamaFixoHKY.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoHKY.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoHKY.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoHKY.setText("Fixo");
			jRadioButtonGamaFixoHKY.setSize(new Dimension(61, 23));
		}
		return jRadioButtonGamaFixoHKY;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoJC69() {
		if (jRadioButtonGamaFixoJC69 == null) {
			jRadioButtonGamaFixoJC69 = new JRadioButton();
			jRadioButtonGamaFixoJC69.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoJC69.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoJC69.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoJC69.setText("Fixo");
			jRadioButtonGamaFixoJC69.setSize(new Dimension(61, 23));
		}
		return jRadioButtonGamaFixoJC69;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoJTT
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoJTT() {
		if (jRadioButtonGamaFixoJTT == null) {
			jRadioButtonGamaFixoJTT = new JRadioButton();
			jRadioButtonGamaFixoJTT.setLocation(new Point(425, 265));
			jRadioButtonGamaFixoJTT.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoJTT.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoJTT.setText("Fixo");
			jRadioButtonGamaFixoJTT.setSize(new Dimension(63, 23));
		}
		return jRadioButtonGamaFixoJTT;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoK2P() {
		if (jRadioButtonGamaFixoK2P == null) {
			jRadioButtonGamaFixoK2P = new JRadioButton();
			jRadioButtonGamaFixoK2P.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoK2P.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoK2P.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoK2P.setText("Fixo");
			jRadioButtonGamaFixoK2P.setSize(new Dimension(61, 23));
		}
		return jRadioButtonGamaFixoK2P;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoMtREV
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoMtREV() {
		if (jRadioButtonGamaFixoMtREV == null) {
			jRadioButtonGamaFixoMtREV = new JRadioButton();
			jRadioButtonGamaFixoMtREV.setLocation(new Point(425, 265));
			jRadioButtonGamaFixoMtREV.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoMtREV.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoMtREV.setText("Fixo");
			jRadioButtonGamaFixoMtREV.setSize(new Dimension(60, 23));
		}
		return jRadioButtonGamaFixoMtREV;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoTN93() {
		if (jRadioButtonGamaFixoTN93 == null) {
			jRadioButtonGamaFixoTN93 = new JRadioButton();
			jRadioButtonGamaFixoTN93.setLocation(new Point(425, 279));
			jRadioButtonGamaFixoTN93.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoTN93.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoTN93.setText("Fixo");
			jRadioButtonGamaFixoTN93.setSize(new Dimension(59, 23));
		}
		return jRadioButtonGamaFixoTN93;
	}

	/**
	 * This method initializes jRadioButtonGamaFixoWAG
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonGamaFixoWAG() {
		if (jRadioButtonGamaFixoWAG == null) {
			jRadioButtonGamaFixoWAG = new JRadioButton();
			jRadioButtonGamaFixoWAG.setLocation(new Point(425, 265));
			jRadioButtonGamaFixoWAG.setBackground(new Color(173, 200, 226));
			jRadioButtonGamaFixoWAG.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonGamaFixoWAG.setText("Fixo");
			jRadioButtonGamaFixoWAG.setSize(new Dimension(60, 23));
		}
		return jRadioButtonGamaFixoWAG;
	}

	/**
	 * Este metodo inicializa o jRadioButtonIntercalado O qual da origem ao
	 * botao "Intercalado" da parte "Tipo de arquivo" da aba sequencia
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonIntercalado() {
		if (jRadioButtonIntercalado == null) {
			jRadioButtonIntercalado = new JRadioButton();
			jRadioButtonIntercalado.setText("Intercalado");
			jRadioButtonIntercalado.setLocation(new Point(372, 195));
			jRadioButtonIntercalado.setBackground(new Color(173, 200, 226));
			jRadioButtonIntercalado.setSize(new Dimension(94, 21));
		}
		return jRadioButtonIntercalado;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoDayhoff
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoDayhoff() {
		if (jRadioButtonProporcaoEstimadoDayhoff == null) {
			jRadioButtonProporcaoEstimadoDayhoff = new JRadioButton();
			jRadioButtonProporcaoEstimadoDayhoff
					.setLocation(new Point(493, 106));
			jRadioButtonProporcaoEstimadoDayhoff.setBackground(new Color(173,
					200, 226));
			jRadioButtonProporcaoEstimadoDayhoff.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoDayhoff.setText("Estimado");
			jRadioButtonProporcaoEstimadoDayhoff
					.setSize(new Dimension(104, 23));
		}
		return jRadioButtonProporcaoEstimadoDayhoff;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoDCMut
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoDCMut() {
		if (jRadioButtonProporcaoEstimadoDCMut == null) {
			jRadioButtonProporcaoEstimadoDCMut = new JRadioButton();
			jRadioButtonProporcaoEstimadoDCMut.setLocation(new Point(493, 106));
			jRadioButtonProporcaoEstimadoDCMut.setBackground(new Color(173,
					200, 226));
			jRadioButtonProporcaoEstimadoDCMut.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoDCMut.setText("Estimado");
			jRadioButtonProporcaoEstimadoDCMut.setSize(new Dimension(98, 23));
		}
		return jRadioButtonProporcaoEstimadoDCMut;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoF81() {
		if (jRadioButtonProporcaoEstimadoF81 == null) {
			jRadioButtonProporcaoEstimadoF81 = new JRadioButton();
			jRadioButtonProporcaoEstimadoF81.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoF81.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoF81.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoF81.setText("Estimado");
			jRadioButtonProporcaoEstimadoF81.setSize(new Dimension(100, 23));
		}
		return jRadioButtonProporcaoEstimadoF81;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoF84() {
		if (jRadioButtonProporcaoEstimadoF84 == null) {
			jRadioButtonProporcaoEstimadoF84 = new JRadioButton();
			jRadioButtonProporcaoEstimadoF84.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoF84.setText("Estimado");
			jRadioButtonProporcaoEstimadoF84.setSize(new Dimension(97, 23));
			jRadioButtonProporcaoEstimadoF84.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoF84.setBackground(new Color(173, 200,
					226));
		}
		return jRadioButtonProporcaoEstimadoF84;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoGTR() {
		if (jRadioButtonProporcaoEstimadoGTR == null) {
			jRadioButtonProporcaoEstimadoGTR = new JRadioButton();
			jRadioButtonProporcaoEstimadoGTR.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoGTR.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoGTR.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoGTR.setText("Estimado");
			jRadioButtonProporcaoEstimadoGTR.setSize(new Dimension(100, 23));
		}
		return jRadioButtonProporcaoEstimadoGTR;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoHKY() {
		if (jRadioButtonProporcaoEstimadoHKY == null) {
			jRadioButtonProporcaoEstimadoHKY = new JRadioButton();
			jRadioButtonProporcaoEstimadoHKY.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoHKY.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoHKY.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoHKY.setText("Estimado");
			jRadioButtonProporcaoEstimadoHKY.setSize(new Dimension(100, 23));
		}
		return jRadioButtonProporcaoEstimadoHKY;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoJC69() {
		if (jRadioButtonProporcaoEstimadoJC69 == null) {
			jRadioButtonProporcaoEstimadoJC69 = new JRadioButton();
			jRadioButtonProporcaoEstimadoJC69.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoJC69.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoJC69.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoJC69.setText("Estimado");
			jRadioButtonProporcaoEstimadoJC69.setSize(new Dimension(100, 23));
		}
		return jRadioButtonProporcaoEstimadoJC69;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoJTT
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoJTT() {
		if (jRadioButtonProporcaoEstimadoJTT == null) {
			jRadioButtonProporcaoEstimadoJTT = new JRadioButton();
			jRadioButtonProporcaoEstimadoJTT.setLocation(new Point(493, 106));
			jRadioButtonProporcaoEstimadoJTT.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoJTT.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoJTT.setText("Estimado");
			jRadioButtonProporcaoEstimadoJTT.setSize(new Dimension(100, 23));
		}
		return jRadioButtonProporcaoEstimadoJTT;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoK2P() {
		if (jRadioButtonProporcaoEstimadoK2P == null) {
			jRadioButtonProporcaoEstimadoK2P = new JRadioButton();
			jRadioButtonProporcaoEstimadoK2P.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoK2P.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoK2P.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoK2P.setText("Estimado");
			jRadioButtonProporcaoEstimadoK2P.setSize(new Dimension(100, 23));
		}
		return jRadioButtonProporcaoEstimadoK2P;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoMtREV
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoMtREV() {
		if (jRadioButtonProporcaoEstimadoMtREV == null) {
			jRadioButtonProporcaoEstimadoMtREV = new JRadioButton();
			jRadioButtonProporcaoEstimadoMtREV.setLocation(new Point(493, 106));
			jRadioButtonProporcaoEstimadoMtREV.setBackground(new Color(173,
					200, 226));
			jRadioButtonProporcaoEstimadoMtREV.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoMtREV.setText("Estimado");
			jRadioButtonProporcaoEstimadoMtREV.setSize(new Dimension(104, 23));
		}
		return jRadioButtonProporcaoEstimadoMtREV;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoTN93() {
		if (jRadioButtonProporcaoEstimadoTN93 == null) {
			jRadioButtonProporcaoEstimadoTN93 = new JRadioButton();
			jRadioButtonProporcaoEstimadoTN93.setLocation(new Point(493, 153));
			jRadioButtonProporcaoEstimadoTN93.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoTN93.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoTN93.setText("Estimado");
			jRadioButtonProporcaoEstimadoTN93.setSize(new Dimension(98, 23));
		}
		return jRadioButtonProporcaoEstimadoTN93;
	}

	/**
	 * This method initializes jRadioButtonProporcaoEstimadoWAG
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoEstimadoWAG() {
		if (jRadioButtonProporcaoEstimadoWAG == null) {
			jRadioButtonProporcaoEstimadoWAG = new JRadioButton();
			jRadioButtonProporcaoEstimadoWAG.setLocation(new Point(493, 106));
			jRadioButtonProporcaoEstimadoWAG.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoEstimadoWAG.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoEstimadoWAG.setText("Estimado");
			jRadioButtonProporcaoEstimadoWAG.setSize(new Dimension(103, 23));
		}
		return jRadioButtonProporcaoEstimadoWAG;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoDayhoff
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoDayhoff() {
		if (jRadioButtonProporcaoFixoDayhoff == null) {
			jRadioButtonProporcaoFixoDayhoff = new JRadioButton();
			jRadioButtonProporcaoFixoDayhoff.setLocation(new Point(425, 106));
			jRadioButtonProporcaoFixoDayhoff.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoFixoDayhoff.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonProporcaoFixoDayhoff.setText("Fixo");
			jRadioButtonProporcaoFixoDayhoff.setSize(new Dimension(60, 23));
		}
		return jRadioButtonProporcaoFixoDayhoff;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoDCMut
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoDCMut() {
		if (jRadioButtonProporcaoFixoDCMut == null) {
			jRadioButtonProporcaoFixoDCMut = new JRadioButton();
			jRadioButtonProporcaoFixoDCMut.setLocation(new Point(425, 106));
			jRadioButtonProporcaoFixoDCMut.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoFixoDCMut.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoDCMut.setText("Fixo");
			jRadioButtonProporcaoFixoDCMut.setSize(new Dimension(59, 23));
		}
		return jRadioButtonProporcaoFixoDCMut;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoF81() {
		if (jRadioButtonProporcaoFixoF81 == null) {
			jRadioButtonProporcaoFixoF81 = new JRadioButton();
			jRadioButtonProporcaoFixoF81.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoF81
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoF81.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoF81.setText("Fixo");
			jRadioButtonProporcaoFixoF81.setSize(new Dimension(61, 23));
		}
		return jRadioButtonProporcaoFixoF81;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoF84() {
		if (jRadioButtonProporcaoFixoF84 == null) {
			jRadioButtonProporcaoFixoF84 = new JRadioButton();
			jRadioButtonProporcaoFixoF84.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoF84.setText("Fixo");
			jRadioButtonProporcaoFixoF84.setSize(new Dimension(58, 23));
			jRadioButtonProporcaoFixoF84.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoF84
					.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonProporcaoFixoF84;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoGTR() {
		if (jRadioButtonProporcaoFixoGTR == null) {
			jRadioButtonProporcaoFixoGTR = new JRadioButton();
			jRadioButtonProporcaoFixoGTR.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoGTR
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoGTR.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoGTR.setText("Fixo");
			jRadioButtonProporcaoFixoGTR.setSize(new Dimension(61, 23));
		}
		return jRadioButtonProporcaoFixoGTR;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoHKY() {
		if (jRadioButtonProporcaoFixoHKY == null) {
			jRadioButtonProporcaoFixoHKY = new JRadioButton();
			jRadioButtonProporcaoFixoHKY.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoHKY
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoHKY.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoHKY.setText("Fixo");
			jRadioButtonProporcaoFixoHKY.setSize(new Dimension(61, 23));
		}
		return jRadioButtonProporcaoFixoHKY;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoJC69() {
		if (jRadioButtonProporcaoFixoJC69 == null) {
			jRadioButtonProporcaoFixoJC69 = new JRadioButton();
			jRadioButtonProporcaoFixoJC69.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoJC69
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoJC69.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoJC69.setText("Fixo");
			jRadioButtonProporcaoFixoJC69.setSize(new Dimension(61, 23));
		}
		return jRadioButtonProporcaoFixoJC69;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoJTT
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoJTT() {
		if (jRadioButtonProporcaoFixoJTT == null) {
			jRadioButtonProporcaoFixoJTT = new JRadioButton();
			jRadioButtonProporcaoFixoJTT.setLocation(new Point(425, 106));
			jRadioButtonProporcaoFixoJTT
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoJTT.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoJTT.setText("Fixo");
			jRadioButtonProporcaoFixoJTT.setSize(new Dimension(61, 23));
		}
		return jRadioButtonProporcaoFixoJTT;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoK2P() {
		if (jRadioButtonProporcaoFixoK2P == null) {
			jRadioButtonProporcaoFixoK2P = new JRadioButton();
			jRadioButtonProporcaoFixoK2P.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoK2P
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoK2P.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoK2P.setText("Fixo");
			jRadioButtonProporcaoFixoK2P.setSize(new Dimension(61, 23));
		}
		return jRadioButtonProporcaoFixoK2P;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoMtREV
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoMtREV() {
		if (jRadioButtonProporcaoFixoMtREV == null) {
			jRadioButtonProporcaoFixoMtREV = new JRadioButton();
			jRadioButtonProporcaoFixoMtREV.setLocation(new Point(425, 106));
			jRadioButtonProporcaoFixoMtREV.setBackground(new Color(173, 200,
					226));
			jRadioButtonProporcaoFixoMtREV.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoMtREV.setText("Fixo");
			jRadioButtonProporcaoFixoMtREV.setSize(new Dimension(59, 23));
		}
		return jRadioButtonProporcaoFixoMtREV;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoTN93() {
		if (jRadioButtonProporcaoFixoTN93 == null) {
			jRadioButtonProporcaoFixoTN93 = new JRadioButton();
			jRadioButtonProporcaoFixoTN93.setLocation(new Point(425, 153));
			jRadioButtonProporcaoFixoTN93
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoTN93.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoTN93.setText("Fixo");
			jRadioButtonProporcaoFixoTN93.setSize(new Dimension(59, 23));
		}
		return jRadioButtonProporcaoFixoTN93;
	}

	/**
	 * This method initializes jRadioButtonProporcaoFixoWAG
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonProporcaoFixoWAG() {
		if (jRadioButtonProporcaoFixoWAG == null) {
			jRadioButtonProporcaoFixoWAG = new JRadioButton();
			jRadioButtonProporcaoFixoWAG.setLocation(new Point(425, 106));
			jRadioButtonProporcaoFixoWAG
					.setBackground(new Color(173, 200, 226));
			jRadioButtonProporcaoFixoWAG.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonProporcaoFixoWAG.setText("Fixo");
			jRadioButtonProporcaoFixoWAG.setSize(new Dimension(58, 23));
		}
		return jRadioButtonProporcaoFixoWAG;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoF81() {
		if (jRadioButtonRelacaoEstimadoF81 == null) {
			jRadioButtonRelacaoEstimadoF81 = new JRadioButton();
			jRadioButtonRelacaoEstimadoF81.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoF81.setBackground(new Color(173, 200,
					226));
			jRadioButtonRelacaoEstimadoF81.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonRelacaoEstimadoF81.setText("Estimado");
			jRadioButtonRelacaoEstimadoF81.setSize(new Dimension(100, 23));
		}
		return jRadioButtonRelacaoEstimadoF81;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoF84() {
		if (jRadioButtonRelacaoEstimadoF84 == null) {
			jRadioButtonRelacaoEstimadoF84 = new JRadioButton();
			jRadioButtonRelacaoEstimadoF84.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonRelacaoEstimadoF84.setText("Estimado");
			jRadioButtonRelacaoEstimadoF84.setSize(new Dimension(99, 23));
			jRadioButtonRelacaoEstimadoF84.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoF84.setBackground(new Color(173, 200,
					226));
		}
		return jRadioButtonRelacaoEstimadoF84;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoGTR() {
		if (jRadioButtonRelacaoEstimadoGTR == null) {
			jRadioButtonRelacaoEstimadoGTR = new JRadioButton();
			jRadioButtonRelacaoEstimadoGTR.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoGTR.setBackground(new Color(173, 200,
					226));
			jRadioButtonRelacaoEstimadoGTR.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonRelacaoEstimadoGTR.setText("Estimado");
			jRadioButtonRelacaoEstimadoGTR.setSize(new Dimension(100, 23));
		}
		return jRadioButtonRelacaoEstimadoGTR;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoHKY() {
		if (jRadioButtonRelacaoEstimadoHKY == null) {
			jRadioButtonRelacaoEstimadoHKY = new JRadioButton();
			jRadioButtonRelacaoEstimadoHKY.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoHKY.setBackground(new Color(173, 200,
					226));
			jRadioButtonRelacaoEstimadoHKY.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonRelacaoEstimadoHKY.setText("Estimado");
			jRadioButtonRelacaoEstimadoHKY.setSize(new Dimension(100, 23));
		}
		return jRadioButtonRelacaoEstimadoHKY;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoJC69() {
		if (jRadioButtonRelacaoEstimadoJC69 == null) {
			jRadioButtonRelacaoEstimadoJC69 = new JRadioButton();
			jRadioButtonRelacaoEstimadoJC69.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoJC69.setBackground(new Color(173, 200,
					226));
			jRadioButtonRelacaoEstimadoJC69.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonRelacaoEstimadoJC69.setText("Estimado");
			jRadioButtonRelacaoEstimadoJC69.setSize(new Dimension(100, 23));
		}
		return jRadioButtonRelacaoEstimadoJC69;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoK2P() {
		if (jRadioButtonRelacaoEstimadoK2P == null) {
			jRadioButtonRelacaoEstimadoK2P = new JRadioButton();
			jRadioButtonRelacaoEstimadoK2P.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoK2P.setBackground(new Color(173, 200,
					226));
			jRadioButtonRelacaoEstimadoK2P.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonRelacaoEstimadoK2P.setText("Estimado");
			jRadioButtonRelacaoEstimadoK2P.setSize(new Dimension(100, 23));
		}
		return jRadioButtonRelacaoEstimadoK2P;
	}

	/**
	 * This method initializes jRadioButtonRelacaoEstimadoTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoEstimadoTN93() {
		if (jRadioButtonRelacaoEstimadoTN93 == null) {
			jRadioButtonRelacaoEstimadoTN93 = new JRadioButton();
			jRadioButtonRelacaoEstimadoTN93.setLocation(new Point(493, 90));
			jRadioButtonRelacaoEstimadoTN93.setBackground(new Color(173, 200,
					226));
			jRadioButtonRelacaoEstimadoTN93.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonRelacaoEstimadoTN93.setText("Estimado");
			jRadioButtonRelacaoEstimadoTN93.setSize(new Dimension(98, 23));
		}
		return jRadioButtonRelacaoEstimadoTN93;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoF81() {
		if (jRadioButtonRelacaoFixoF81 == null) {
			jRadioButtonRelacaoFixoF81 = new JRadioButton();
			jRadioButtonRelacaoFixoF81.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoF81.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoF81
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoF81.setText("Fixo");
			jRadioButtonRelacaoFixoF81.setSize(new Dimension(61, 21));
		}
		return jRadioButtonRelacaoFixoF81;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoF84() {
		if (jRadioButtonRelacaoFixoF84 == null) {
			jRadioButtonRelacaoFixoF84 = new JRadioButton();
			jRadioButtonRelacaoFixoF84
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoF84.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoF84.setSize(new Dimension(61, 21));
			jRadioButtonRelacaoFixoF84.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoF84.setText("Fixo");
		}
		return jRadioButtonRelacaoFixoF84;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoGTR() {
		if (jRadioButtonRelacaoFixoGTR == null) {
			jRadioButtonRelacaoFixoGTR = new JRadioButton();
			jRadioButtonRelacaoFixoGTR.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoGTR.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoGTR
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoGTR.setText("Fixo");
			jRadioButtonRelacaoFixoGTR.setSize(new Dimension(61, 21));
		}
		return jRadioButtonRelacaoFixoGTR;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoHKY() {
		if (jRadioButtonRelacaoFixoHKY == null) {
			jRadioButtonRelacaoFixoHKY = new JRadioButton();
			jRadioButtonRelacaoFixoHKY.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoHKY.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoHKY
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoHKY.setText("Fixo");
			jRadioButtonRelacaoFixoHKY.setSize(new Dimension(61, 21));
		}
		return jRadioButtonRelacaoFixoHKY;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoJC69() {
		if (jRadioButtonRelacaoFixoJC69 == null) {
			jRadioButtonRelacaoFixoJC69 = new JRadioButton();
			jRadioButtonRelacaoFixoJC69.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoJC69.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoJC69
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoJC69.setText("Fixo");
			jRadioButtonRelacaoFixoJC69.setSize(new Dimension(61, 21));
		}
		return jRadioButtonRelacaoFixoJC69;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoK2P() {
		if (jRadioButtonRelacaoFixoK2P == null) {
			jRadioButtonRelacaoFixoK2P = new JRadioButton();
			jRadioButtonRelacaoFixoK2P.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoK2P.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoK2P
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoK2P.setText("Fixo");
			jRadioButtonRelacaoFixoK2P.setSize(new Dimension(61, 21));
		}
		return jRadioButtonRelacaoFixoK2P;
	}

	/**
	 * This method initializes jRadioButtonRelacaoFixoTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonRelacaoFixoTN93() {
		if (jRadioButtonRelacaoFixoTN93 == null) {
			jRadioButtonRelacaoFixoTN93 = new JRadioButton();
			jRadioButtonRelacaoFixoTN93.setLocation(new Point(425, 90));
			jRadioButtonRelacaoFixoTN93.setBackground(new Color(173, 200, 226));
			jRadioButtonRelacaoFixoTN93
					.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonRelacaoFixoTN93.setText("Fixo");
			jRadioButtonRelacaoFixoTN93.setSize(new Dimension(59, 21));
		}
		return jRadioButtonRelacaoFixoTN93;
	}

	/**
	 * Este metodo inicializa o jRadioButtonSequencial O qual da origem ao botao
	 * "Sequencial" da parte "Tipo de arquivo" da aba sequencia
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonSequencial() {
		if (jRadioButtonSequencial == null) {
			jRadioButtonSequencial = new JRadioButton();
			jRadioButtonSequencial.setText("Seqüencial");
			jRadioButtonSequencial.setSize(new Dimension(108, 24));
			jRadioButtonSequencial.setLocation(new Point(255, 195));
			jRadioButtonSequencial.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonSequencial;
	}

	/**
	 * This method initializes jRadioButtonTaxaArvoreNao
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTaxaArvoreNao() {
		if (jRadioButtonTaxaArvoreNao == null) {
			jRadioButtonTaxaArvoreNao = new JRadioButton();
			jRadioButtonTaxaArvoreNao.setLocation(new Point(520, 211));
			jRadioButtonTaxaArvoreNao.setBackground(new Color(173, 200, 226));
			jRadioButtonTaxaArvoreNao.setText("Não");
			jRadioButtonTaxaArvoreNao.setSize(new Dimension(49, 21));
		}
		return jRadioButtonTaxaArvoreNao;
	}

	/**
	 * This method initializes jRadioButtonTaxaArvoreSim
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTaxaArvoreSim() {
		if (jRadioButtonTaxaArvoreSim == null) {
			jRadioButtonTaxaArvoreSim = new JRadioButton();
			jRadioButtonTaxaArvoreSim.setLocation(new Point(430, 209));
			jRadioButtonTaxaArvoreSim.setBackground(new Color(173, 200, 226));
			jRadioButtonTaxaArvoreSim.setText("Sim");
			jRadioButtonTaxaArvoreSim.setSize(new Dimension(48, 24));
		}
		return jRadioButtonTaxaArvoreSim;
	}

	/**
	 * Este metodo inicializa o jRadioButtonTipoDadoAA O qual da origem ao botao
	 * "Aminoacido " da parte "Tipo de dados" da aba sequencia
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTipoDadoAA() {
		if (jRadioButtonTipoDadoAA == null) {
			jRadioButtonTipoDadoAA = new JRadioButton();
			jRadioButtonTipoDadoAA.setText("Aminoácido");
			jRadioButtonTipoDadoAA.setSize(jRadioButtonTipoDadoAA
					.getPreferredSize());
			jRadioButtonTipoDadoAA.setLocation(new Point(194, 20));
			jRadioButtonTipoDadoAA.setBackground(new Color(173, 200, 226));
			jRadioButtonTipoDadoAA.setFont(new Font("Arial", Font.BOLD, 12));
		}
		return jRadioButtonTipoDadoAA;
	}

	/**
	 * Este metodo inicializa o jRadioButtonTipoDadoDNA O qual da origem ao
	 * botao "DNA " da parte "Tipo de dados" da aba sequencia
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTipoDadoDNA() {
		if (jRadioButtonTipoDadoDNA == null) {
			jRadioButtonTipoDadoDNA = new JRadioButton();
			jRadioButtonTipoDadoDNA.setText("DNA");
			jRadioButtonTipoDadoDNA.setFont(new Font("Arial", Font.BOLD, 12));
			jRadioButtonTipoDadoDNA.setBackground(new Color(173, 200, 226));
			jRadioButtonTipoDadoDNA.setSize(
					jRadioButtonTipoDadoDNA.getPreferredSize());
			jRadioButtonTipoDadoDNA.setLocation(
					new Point(173 + getJRadioButtonTipoDadoAA()
						.getPreferredSize().width + 50, 20));
			jRadioButtonTipoDadoDNA.setSelected(true);
		}
		return jRadioButtonTipoDadoDNA;
	}

	/**
	 * This method initializes jRadioButtonTopologiaArvoreArquivo
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTopologiaArvoreArquivo() {
		if (jRadioButtonTopologiaArvoreArquivo == null) {
			jRadioButtonTopologiaArvoreArquivo = new JRadioButton();
			jRadioButtonTopologiaArvoreArquivo.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonTopologiaArvoreArquivo.setText("Arquivo");
			jRadioButtonTopologiaArvoreArquivo.setSize(new Dimension(83, 23));
			jRadioButtonTopologiaArvoreArquivo.setLocation(new Point(430, 59));
			jRadioButtonTopologiaArvoreArquivo.setBackground(new Color(173,
					200, 226));
		}
		return jRadioButtonTopologiaArvoreArquivo;
	}

	/**
	 * This method initializes jRadioButtonTopologiaArvoreBIONJ
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTopologiaArvoreBIONJ() {
		if (jRadioButtonTopologiaArvoreBIONJ == null) {
			jRadioButtonTopologiaArvoreBIONJ = new JRadioButton();
			jRadioButtonTopologiaArvoreBIONJ.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonTopologiaArvoreBIONJ.setText("BIONJ");
			jRadioButtonTopologiaArvoreBIONJ.setSize(new Dimension(62, 23));
			jRadioButtonTopologiaArvoreBIONJ.setLocation(new Point(520, 59));
			jRadioButtonTopologiaArvoreBIONJ.setBackground(new Color(173, 200,
					226));
		}
		return jRadioButtonTopologiaArvoreBIONJ;
	}

	/**
	 * This method initializes jRadioButtonTopologiaArvoreNao
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTopologiaArvoreNao() {
		if (jRadioButtonTopologiaArvoreNao == null) {
			jRadioButtonTopologiaArvoreNao = new JRadioButton();
			jRadioButtonTopologiaArvoreNao.setLocation(new Point(520, 133));
			jRadioButtonTopologiaArvoreNao.setBackground(new Color(173, 200,
					226));
			jRadioButtonTopologiaArvoreNao.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonTopologiaArvoreNao.setText("Não");
			jRadioButtonTopologiaArvoreNao.setSize(new Dimension(60, 23));
		}
		return jRadioButtonTopologiaArvoreNao;
	}

	/**
	 * This method initializes jRadioButtonTopologiaArvoreSim
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonTopologiaArvoreSim() {
		if (jRadioButtonTopologiaArvoreSim == null) {
			jRadioButtonTopologiaArvoreSim = new JRadioButton();
			jRadioButtonTopologiaArvoreSim.setLocation(new Point(430, 133));
			jRadioButtonTopologiaArvoreSim.setBackground(new Color(173, 200,
					226));
			jRadioButtonTopologiaArvoreSim.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonTopologiaArvoreSim.setText("Sim");
			jRadioButtonTopologiaArvoreSim.setSize(new Dimension(48, 21));
		}
		return jRadioButtonTopologiaArvoreSim;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloDayhoff
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloDayhoff() {
		if (jRadioButtonUtilizarModeloDayhoff == null) {
			jRadioButtonUtilizarModeloDayhoff = new JRadioButton();
			jRadioButtonUtilizarModeloDayhoff.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloDayhoff.setBackground(new Color(173, 200,
					226));
			jRadioButtonUtilizarModeloDayhoff.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonUtilizarModeloDayhoff.setToolTipText("");
			jRadioButtonUtilizarModeloDayhoff
					.setText("Utilizar o modelo Dayhoff");
			jRadioButtonUtilizarModeloDayhoff.setSize(new Dimension(195, 21));
		}
		return jRadioButtonUtilizarModeloDayhoff;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloDCMut
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloDCMut() {
		if (jRadioButtonUtilizarModeloDCMut == null) {
			jRadioButtonUtilizarModeloDCMut = new JRadioButton();
			jRadioButtonUtilizarModeloDCMut.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloDCMut.setBackground(new Color(173, 200,
					226));
			jRadioButtonUtilizarModeloDCMut.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonUtilizarModeloDCMut.setToolTipText("");
			jRadioButtonUtilizarModeloDCMut.setText("Utilizar o modelo DCMut");
			jRadioButtonUtilizarModeloDCMut.setSize(new Dimension(192, 21));
		}
		return jRadioButtonUtilizarModeloDCMut;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloF81
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloF81() {
		if (jRadioButtonUtilizarModeloF81 == null) {
			jRadioButtonUtilizarModeloF81 = new JRadioButton();
			jRadioButtonUtilizarModeloF81.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloF81
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloF81.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloF81.setToolTipText("");
			jRadioButtonUtilizarModeloF81
					.setActionCommand("Utilizar o modelo F81");
			jRadioButtonUtilizarModeloF81.setText("Utilizar o modelo HKY");
			jRadioButtonUtilizarModeloF81.setSize(new Dimension(173, 21));
		}
		return jRadioButtonUtilizarModeloF81;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloF84
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloF84() {
		if (jRadioButtonUtilizarModeloF84 == null) {
			jRadioButtonUtilizarModeloF84 = new JRadioButton();
			jRadioButtonUtilizarModeloF84
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloF84.setSize(new Dimension(165, 21));
			jRadioButtonUtilizarModeloF84.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloF84.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloF84.setToolTipText("");
			jRadioButtonUtilizarModeloF84.setText("Utilizar o modelo F84");
		}
		return jRadioButtonUtilizarModeloF84;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloGTR
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloGTR() {
		if (jRadioButtonUtilizarModeloGTR == null) {
			jRadioButtonUtilizarModeloGTR = new JRadioButton();
			jRadioButtonUtilizarModeloGTR.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloGTR
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloGTR.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloGTR.setToolTipText("");
			jRadioButtonUtilizarModeloGTR
					.setActionCommand("Utilizar o modelo GTR");
			jRadioButtonUtilizarModeloGTR.setText("Utilizar o modelo HKY");
			jRadioButtonUtilizarModeloGTR.setSize(new Dimension(173, 21));
		}
		return jRadioButtonUtilizarModeloGTR;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloHKY
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloHKY() {
		if (jRadioButtonUtilizarModeloHKY == null) {
			jRadioButtonUtilizarModeloHKY = new JRadioButton();
			jRadioButtonUtilizarModeloHKY.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloHKY
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloHKY.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloHKY.setToolTipText("");
			jRadioButtonUtilizarModeloHKY.setText("Utilizar o modelo HKY");
			jRadioButtonUtilizarModeloHKY.setSize(new Dimension(173, 21));
		}
		return jRadioButtonUtilizarModeloHKY;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloJC69
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloJC69() {
		if (jRadioButtonUtilizarModeloJC69 == null) {
			jRadioButtonUtilizarModeloJC69 = new JRadioButton();
			jRadioButtonUtilizarModeloJC69.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloJC69.setBackground(new Color(173, 200,
					226));
			jRadioButtonUtilizarModeloJC69.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloJC69.setToolTipText("");
			jRadioButtonUtilizarModeloJC69.setText("Utilizar o modelo HKY");
			jRadioButtonUtilizarModeloJC69
					.setActionCommand("Utilizar o modelo JC69");
			jRadioButtonUtilizarModeloJC69.setSize(new Dimension(173, 21));
		}
		return jRadioButtonUtilizarModeloJC69;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloJTT
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloJTT() {
		if (jRadioButtonUtilizarModeloJTT == null) {
			jRadioButtonUtilizarModeloJTT = new JRadioButton();
			jRadioButtonUtilizarModeloJTT.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloJTT
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloJTT.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloJTT.setToolTipText("");
			jRadioButtonUtilizarModeloJTT.setText("Utilizar o modelo JTT");
			jRadioButtonUtilizarModeloJTT.setSize(new Dimension(167, 21));
		}
		return jRadioButtonUtilizarModeloJTT;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloK2P
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloK2P() {
		if (jRadioButtonUtilizarModeloK2P == null) {
			jRadioButtonUtilizarModeloK2P = new JRadioButton();
			jRadioButtonUtilizarModeloK2P.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloK2P
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloK2P.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloK2P.setToolTipText("");
			jRadioButtonUtilizarModeloK2P.setText("Utilizar o modelo K2P");
			jRadioButtonUtilizarModeloK2P.setSize(new Dimension(176, 21));
		}
		return jRadioButtonUtilizarModeloK2P;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloMtREV
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloMtREV() {
		if (jRadioButtonUtilizarModeloMtREV == null) {
			jRadioButtonUtilizarModeloMtREV = new JRadioButton();
			jRadioButtonUtilizarModeloMtREV.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloMtREV.setBackground(new Color(173, 200,
					226));
			jRadioButtonUtilizarModeloMtREV.setFont(new Font("Arial",
					Font.BOLD, 12));
			jRadioButtonUtilizarModeloMtREV.setToolTipText("");
			jRadioButtonUtilizarModeloMtREV.setText("Utilizar o modelo MtREV");
			jRadioButtonUtilizarModeloMtREV.setSize(new Dimension(180, 21));
		}
		return jRadioButtonUtilizarModeloMtREV;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloTN93
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloTN93() {
		if (jRadioButtonUtilizarModeloTN93 == null) {
			jRadioButtonUtilizarModeloTN93 = new JRadioButton();
			jRadioButtonUtilizarModeloTN93.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloTN93.setBackground(new Color(173, 200,
					226));
			jRadioButtonUtilizarModeloTN93.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloTN93.setToolTipText("");
			jRadioButtonUtilizarModeloTN93.setText("Utilizar o modelo TN93");
			jRadioButtonUtilizarModeloTN93.setSize(new Dimension(173, 21));
		}
		return jRadioButtonUtilizarModeloTN93;
	}

	/**
	 * This method initializes jRadioButtonUtilizarModeloWAG
	 * 
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonUtilizarModeloWAG() {
		if (jRadioButtonUtilizarModeloWAG == null) {
			jRadioButtonUtilizarModeloWAG = new JRadioButton();
			jRadioButtonUtilizarModeloWAG.setLocation(new Point(40, 4));
			jRadioButtonUtilizarModeloWAG
					.setBackground(new Color(173, 200, 226));
			jRadioButtonUtilizarModeloWAG.setFont(new Font("Arial", Font.BOLD,
					12));
			jRadioButtonUtilizarModeloWAG.setToolTipText("");
			jRadioButtonUtilizarModeloWAG.setText("Utilizar o modelo WAG");
			jRadioButtonUtilizarModeloWAG.setSize(new Dimension(167, 21));
		}
		return jRadioButtonUtilizarModeloWAG;
	}

	
	/**
	 * This method initializes jSeparatorArvore01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore01() {
		if (jSeparatorArvore01 == null) {
			jSeparatorArvore01 = new JSeparator();
			jSeparatorArvore01.setLocation(new Point(14, 38));
			jSeparatorArvore01.setSize(new Dimension(72, 10));
		}
		return jSeparatorArvore01;
	}

	/**
	 * This method initializes jSeparatorArvore101
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore101() {
		if (jSeparatorArvore101 == null) {
			jSeparatorArvore101 = new JSeparator();
			jSeparatorArvore101.setLocation(new Point(328, 186));
			jSeparatorArvore101.setSize(new Dimension(264, 10));
		}
		return jSeparatorArvore101;
	}

	/**
	 * This method initializes jSeparatorArvore111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore111() {
		if (jSeparatorArvore111 == null) {
			jSeparatorArvore111 = new JSeparator();
			jSeparatorArvore111.setLocation(new Point(592, 186));
			jSeparatorArvore111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvore111.setSize(new Dimension(10, 51));
		}
		return jSeparatorArvore111;
	}

	/**
	 * This method initializes jSeparatorArvore121
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore121() {
		if (jSeparatorArvore121 == null) {
			jSeparatorArvore121 = new JSeparator();
			jSeparatorArvore121.setBounds(new Rectangle(15, 237, 578, 10));
		}
		return jSeparatorArvore121;
	}

	/**
	 * This method initializes jSeparatorArvore131
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore131() {
		if (jSeparatorArvore131 == null) {
			jSeparatorArvore131 = new JSeparator();
			jSeparatorArvore131.setLocation(new Point(14, 187));
			jSeparatorArvore131.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvore131.setSize(new Dimension(10, 51));
		}
		return jSeparatorArvore131;
	}

	/**
	 * This method initializes jSeparatorArvore141
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore141() {
		if (jSeparatorArvore141 == null) {
			jSeparatorArvore141 = new JSeparator();
			jSeparatorArvore141.setLocation(new Point(14, 186));
			jSeparatorArvore141.setSize(new Dimension(72, 10));
		}
		return jSeparatorArvore141;
	}

	/**
	 * This method initializes jSeparatorArvore15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore15() {
		if (jSeparatorArvore15 == null) {
			jSeparatorArvore15 = new JSeparator();
			jSeparatorArvore15.setLocation(new Point(13, 38));
			jSeparatorArvore15.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvore15.setSize(new Dimension(10, 51));
		}
		return jSeparatorArvore15;
	}

	/**
	 * This method initializes jSeparatorArvore21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore21() {
		if (jSeparatorArvore21 == null) {
			jSeparatorArvore21 = new JSeparator();
			jSeparatorArvore21.setLocation(new Point(13, 89));
			jSeparatorArvore21.setSize(new Dimension(577, 10));
		}
		return jSeparatorArvore21;
	}

	/**
	 * This method initializes jSeparatorArvore31
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore31() {
		if (jSeparatorArvore31 == null) {
			jSeparatorArvore31 = new JSeparator();
			jSeparatorArvore31.setLocation(new Point(590, 39));
			jSeparatorArvore31.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvore31.setSize(new Dimension(10, 51));
		}
		return jSeparatorArvore31;
	}

	/**
	 * This method initializes jSeparatorArvore41
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore41() {
		if (jSeparatorArvore41 == null) {
			jSeparatorArvore41 = new JSeparator();
			jSeparatorArvore41.setLocation(new Point(209, 38));
			jSeparatorArvore41.setSize(new Dimension(382, 10));
		}
		return jSeparatorArvore41;
	}

	/**
	 * This method initializes jSeparatorArvore51
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore51() {
		if (jSeparatorArvore51 == null) {
			jSeparatorArvore51 = new JSeparator();
			jSeparatorArvore51.setLocation(new Point(220, 112));
			jSeparatorArvore51.setSize(new Dimension(371, 10));
		}
		return jSeparatorArvore51;
	}

	/**
	 * This method initializes jSeparatorArvore61
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore61() {
		if (jSeparatorArvore61 == null) {
			jSeparatorArvore61 = new JSeparator();
			jSeparatorArvore61.setLocation(new Point(591, 112));
			jSeparatorArvore61.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvore61.setSize(new Dimension(10, 51));
		}
		return jSeparatorArvore61;
	}

	/**
	 * This method initializes jSeparatorArvore71
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore71() {
		if (jSeparatorArvore71 == null) {
			jSeparatorArvore71 = new JSeparator();
			jSeparatorArvore71.setLocation(new Point(15, 163));
			jSeparatorArvore71.setSize(new Dimension(577, 10));
		}
		return jSeparatorArvore71;
	}

	/**
	 * This method initializes jSeparatorArvore81
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore81() {
		if (jSeparatorArvore81 == null) {
			jSeparatorArvore81 = new JSeparator();
			jSeparatorArvore81.setLocation(new Point(13, 113));
			jSeparatorArvore81.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvore81.setSize(new Dimension(10, 51));
		}
		return jSeparatorArvore81;
	}

	/**
	 * This method initializes jSeparatorArvore91
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvore91() {
		if (jSeparatorArvore91 == null) {
			jSeparatorArvore91 = new JSeparator();
			jSeparatorArvore91.setLocation(new Point(13, 112));
			jSeparatorArvore91.setSize(new Dimension(72, 10));
		}
		return jSeparatorArvore91;
	}

	/**
	 * This method initializes jSeparatorArvoreS01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS01() {
		if (jSeparatorArvoreS01 == null) {
			jSeparatorArvoreS01 = new JSeparator();
			jSeparatorArvoreS01.setLocation(new Point(86, 27));
			jSeparatorArvoreS01.setSize(new Dimension(123, 10));
		}
		return jSeparatorArvoreS01;
	}

	/**
	 * This method initializes jSeparatorArvoreS101
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS101() {
		if (jSeparatorArvoreS101 == null) {
			jSeparatorArvoreS101 = new JSeparator();
			jSeparatorArvoreS101.setLocation(new Point(86, 176));
			jSeparatorArvoreS101.setSize(new Dimension(242, 10));
		}
		return jSeparatorArvoreS101;
	}

	/**
	 * This method initializes jSeparatorArvoreS111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS111() {
		if (jSeparatorArvoreS111 == null) {
			jSeparatorArvoreS111 = new JSeparator();
			jSeparatorArvoreS111.setLocation(new Point(86, 199));
			jSeparatorArvoreS111.setSize(new Dimension(242, 10));
		}
		return jSeparatorArvoreS111;
	}

	/**
	 * This method initializes jSeparatorArvoreS12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS12() {
		if (jSeparatorArvoreS12 == null) {
			jSeparatorArvoreS12 = new JSeparator();
			jSeparatorArvoreS12.setLocation(new Point(86, 28));
			jSeparatorArvoreS12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvoreS12.setSize(new Dimension(10, 22));
		}
		return jSeparatorArvoreS12;
	}

	/**
	 * This method initializes jSeparatorArvoreS21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS21() {
		if (jSeparatorArvoreS21 == null) {
			jSeparatorArvoreS21 = new JSeparator();
			jSeparatorArvoreS21.setLocation(new Point(86, 50));
			jSeparatorArvoreS21.setSize(new Dimension(123, 10));
		}
		return jSeparatorArvoreS21;
	}

	/**
	 * This method initializes jSeparatorArvoreS31
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS31() {
		if (jSeparatorArvoreS31 == null) {
			jSeparatorArvoreS31 = new JSeparator();
			jSeparatorArvoreS31.setLocation(new Point(208, 28));
			jSeparatorArvoreS31.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvoreS31.setSize(new Dimension(10, 22));
		}
		return jSeparatorArvoreS31;
	}

	/**
	 * This method initializes jSeparatorArvoreS41
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS41() {
		if (jSeparatorArvoreS41 == null) {
			jSeparatorArvoreS41 = new JSeparator();
			jSeparatorArvoreS41.setLocation(new Point(86, 102));
			jSeparatorArvoreS41.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvoreS41.setSize(new Dimension(10, 22));
		}
		return jSeparatorArvoreS41;
	}

	/**
	 * This method initializes jSeparatorArvoreS51
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS51() {
		if (jSeparatorArvoreS51 == null) {
			jSeparatorArvoreS51 = new JSeparator();
			jSeparatorArvoreS51.setLocation(new Point(219, 102));
			jSeparatorArvoreS51.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvoreS51.setSize(new Dimension(10, 22));
		}
		return jSeparatorArvoreS51;
	}

	/**
	 * This method initializes jSeparatorArvoreS61
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS61() {
		if (jSeparatorArvoreS61 == null) {
			jSeparatorArvoreS61 = new JSeparator();
			jSeparatorArvoreS61.setLocation(new Point(86, 101));
			jSeparatorArvoreS61.setSize(new Dimension(134, 10));
		}
		return jSeparatorArvoreS61;
	}

	/**
	 * This method initializes jSeparatorArvoreS71
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS71() {
		if (jSeparatorArvoreS71 == null) {
			jSeparatorArvoreS71 = new JSeparator();
			jSeparatorArvoreS71.setBounds(new Rectangle(86, 124, 134, 10));
		}
		return jSeparatorArvoreS71;
	}

	/**
	 * This method initializes jSeparatorArvoreS81
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS81() {
		if (jSeparatorArvoreS81 == null) {
			jSeparatorArvoreS81 = new JSeparator();
			jSeparatorArvoreS81.setLocation(new Point(86, 177));
			jSeparatorArvoreS81.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvoreS81.setSize(new Dimension(10, 22));
		}
		return jSeparatorArvoreS81;
	}

	/**
	 * This method initializes jSeparatorArvoreS91
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorArvoreS91() {
		if (jSeparatorArvoreS91 == null) {
			jSeparatorArvoreS91 = new JSeparator();
			jSeparatorArvoreS91.setLocation(new Point(327, 177));
			jSeparatorArvoreS91.setOrientation(SwingConstants.VERTICAL);
			jSeparatorArvoreS91.setSize(new Dimension(10, 22));
		}
		return jSeparatorArvoreS91;
	}

	/**
	 * This method initializes jSeparatorBootstrap19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap19() {
		if (jSeparatorBootstrap19 == null) {
			jSeparatorBootstrap19 = new JSeparator();
			jSeparatorBootstrap19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap19.setSize(new Dimension(10, 22));
			jSeparatorBootstrap19.setLocation(new Point(57, 11));
		}
		return jSeparatorBootstrap19;
	}

	/**
	 * This method initializes jSeparatorBootstrap191
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap191() {
		if (jSeparatorBootstrap191 == null) {
			jSeparatorBootstrap191 = new JSeparator();
			jSeparatorBootstrap191.setLocation(new Point(52, 14));
			jSeparatorBootstrap191.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap191.setSize(new Dimension(10, 22));
		}
		return jSeparatorBootstrap191;
	}

	/**
	 * This method initializes jSeparatorBootstrap20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap20() {
		if (jSeparatorBootstrap20 == null) {
			jSeparatorBootstrap20 = new JSeparator();
			jSeparatorBootstrap20.setSize(new Dimension(77, 10));
			jSeparatorBootstrap20.setLocation(new Point(153, 21));
		}
		return jSeparatorBootstrap20;
	}

	/**
	 * This method initializes jSeparatorBootstrap201
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap201() {
		if (jSeparatorBootstrap201 == null) {
			jSeparatorBootstrap201 = new JSeparator();
			jSeparatorBootstrap201.setLocation(new Point(161, 24));
			jSeparatorBootstrap201.setSize(new Dimension(64, 10));
		}
		return jSeparatorBootstrap201;
	}

	/**
	 * This method initializes jSeparatorBootstrap21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap21() {
		if (jSeparatorBootstrap21 == null) {
			jSeparatorBootstrap21 = new JSeparator();
			jSeparatorBootstrap21.setSize(new Dimension(95, 10));
			jSeparatorBootstrap21.setLocation(new Point(57, 10));
		}
		return jSeparatorBootstrap21;
	}

	/**
	 * This method initializes jSeparatorBootstrap211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap211() {
		if (jSeparatorBootstrap211 == null) {
			jSeparatorBootstrap211 = new JSeparator();
			jSeparatorBootstrap211.setLocation(new Point(52, 13));
			jSeparatorBootstrap211.setSize(new Dimension(108, 10));
		}
		return jSeparatorBootstrap211;
	}

	/**
	 * This method initializes jSeparatorBootstrap22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap22() {
		if (jSeparatorBootstrap22 == null) {
			jSeparatorBootstrap22 = new JSeparator();
			jSeparatorBootstrap22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap22.setSize(new Dimension(10, 22));
			jSeparatorBootstrap22.setLocation(new Point(152, 11));
		}
		return jSeparatorBootstrap22;
	}

	/**
	 * This method initializes jSeparatorBootstrap221
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap221() {
		if (jSeparatorBootstrap221 == null) {
			jSeparatorBootstrap221 = new JSeparator();
			jSeparatorBootstrap221.setLocation(new Point(160, 14));
			jSeparatorBootstrap221.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap221.setSize(new Dimension(10, 22));
		}
		return jSeparatorBootstrap221;
	}

	/**
	 * This method initializes jSeparatorBootstrap23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap23() {
		if (jSeparatorBootstrap23 == null) {
			jSeparatorBootstrap23 = new JSeparator();
			jSeparatorBootstrap23.setLocation(new Point(57, 33));
			jSeparatorBootstrap23.setSize(new Dimension(95, 10));
		}
		return jSeparatorBootstrap23;
	}

	/**
	 * This method initializes jSeparatorBootstrap231
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap231() {
		if (jSeparatorBootstrap231 == null) {
			jSeparatorBootstrap231 = new JSeparator();
			jSeparatorBootstrap231.setLocation(new Point(52, 36));
			jSeparatorBootstrap231.setSize(new Dimension(108, 10));
		}
		return jSeparatorBootstrap231;
	}

	/**
	 * This method initializes jSeparatorBootstrap24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap24() {
		if (jSeparatorBootstrap24 == null) {
			jSeparatorBootstrap24 = new JSeparator();
			jSeparatorBootstrap24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap24.setSize(new Dimension(10, 50));
			jSeparatorBootstrap24.setLocation(new Point(230, 22));
		}
		return jSeparatorBootstrap24;
	}

	/**
	 * This method initializes jSeparatorBootstrap241
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap241() {
		if (jSeparatorBootstrap241 == null) {
			jSeparatorBootstrap241 = new JSeparator();
			jSeparatorBootstrap241.setLocation(new Point(225, 25));
			jSeparatorBootstrap241.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap241.setSize(new Dimension(10, 50));
		}
		return jSeparatorBootstrap241;
	}

	/**
	 * This method initializes jSeparatorBootstrap7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap7() {
		if (jSeparatorBootstrap7 == null) {
			jSeparatorBootstrap7 = new JSeparator();
			jSeparatorBootstrap7.setSize(new Dimension(45, 10));
			jSeparatorBootstrap7.setLocation(new Point(11, 21));
		}
		return jSeparatorBootstrap7;
	}

	/**
	 * This method initializes jSeparatorBootstrap71
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap71() {
		if (jSeparatorBootstrap71 == null) {
			jSeparatorBootstrap71 = new JSeparator();
			jSeparatorBootstrap71.setLocation(new Point(6, 24));
			jSeparatorBootstrap71.setSize(new Dimension(45, 10));
		}
		return jSeparatorBootstrap71;
	}

	/**
	 * This method initializes jSeparatorBootstrap8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap8() {
		if (jSeparatorBootstrap8 == null) {
			jSeparatorBootstrap8 = new JSeparator();
			jSeparatorBootstrap8.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap8.setSize(new Dimension(10, 49));
			jSeparatorBootstrap8.setLocation(new Point(10, 22));
		}
		return jSeparatorBootstrap8;
	}

	/**
	 * This method initializes jSeparatorBootstrap81
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap81() {
		if (jSeparatorBootstrap81 == null) {
			jSeparatorBootstrap81 = new JSeparator();
			jSeparatorBootstrap81.setLocation(new Point(5, 25));
			jSeparatorBootstrap81.setOrientation(SwingConstants.VERTICAL);
			jSeparatorBootstrap81.setSize(new Dimension(10, 50));
		}
		return jSeparatorBootstrap81;
	}

	/**
	 * This method initializes jSeparatorBootstrap9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap9() {
		if (jSeparatorBootstrap9 == null) {
			jSeparatorBootstrap9 = new JSeparator();
			jSeparatorBootstrap9.setLocation(new Point(10, 71));
			jSeparatorBootstrap9.setSize(new Dimension(220, 10));
		}
		return jSeparatorBootstrap9;
	}

	/**
	 * This method initializes jSeparatorBootstrap91
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorBootstrap91() {
		if (jSeparatorBootstrap91 == null) {
			jSeparatorBootstrap91 = new JSeparator();
			jSeparatorBootstrap91.setLocation(new Point(7, 74));
			jSeparatorBootstrap91.setSize(new Dimension(218, 10));
		}
		return jSeparatorBootstrap91;
	}

	/**
	 * This method initializes jSeparatorDayhoff01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff01() {
		if (jSeparatorDayhoff01 == null) {
			jSeparatorDayhoff01 = new JSeparator();
			jSeparatorDayhoff01.setLocation(new Point(11, 12));
			jSeparatorDayhoff01.setSize(new Dimension(28, 10));
		}
		return jSeparatorDayhoff01;
	}

	/**
	 * This method initializes jSeparatorDayhoff02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff02() {
		if (jSeparatorDayhoff02 == null) {
			jSeparatorDayhoff02 = new JSeparator();
			jSeparatorDayhoff02.setLocation(new Point(10, 12));
			jSeparatorDayhoff02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff02.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff02;
	}

	/**
	 * This method initializes jSeparatorDayhoff03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff03() {
		if (jSeparatorDayhoff03 == null) {
			jSeparatorDayhoff03 = new JSeparator();
			jSeparatorDayhoff03.setLocation(new Point(10, 52));
			jSeparatorDayhoff03.setSize(new Dimension(591, 10));
		}
		return jSeparatorDayhoff03;
	}

	/**
	 * This method initializes jSeparatorDayhoff04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff04() {
		if (jSeparatorDayhoff04 == null) {
			jSeparatorDayhoff04 = new JSeparator();
			jSeparatorDayhoff04.setLocation(new Point(601, 13));
			jSeparatorDayhoff04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff04.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff04;
	}

	/**
	 * This method initializes jSeparatorDayhoff05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff05() {
		if (jSeparatorDayhoff05 == null) {
			jSeparatorDayhoff05 = new JSeparator();
			jSeparatorDayhoff05.setLocation(new Point(237, 12));
			jSeparatorDayhoff05.setSize(new Dimension(365, 10));
		}
		return jSeparatorDayhoff05;
	}

	/**
	 * This method initializes jSeparatorDayhoff1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff1() {
		if (jSeparatorDayhoff1 == null) {
			jSeparatorDayhoff1 = new JSeparator();
			jSeparatorDayhoff1.setBounds(new Rectangle(39, 2, 10, 26));
			jSeparatorDayhoff1.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorDayhoff1;
	}

	/**
	 * This method initializes jSeparatorDayhoff11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff11() {
		if (jSeparatorDayhoff11 == null) {
			jSeparatorDayhoff11 = new JSeparator();
			jSeparatorDayhoff11.setLocation(new Point(11, 91));
			jSeparatorDayhoff11.setSize(new Dimension(28, 10));
		}
		return jSeparatorDayhoff11;
	}

	/**
	 * This method initializes jSeparatorDayhoff110
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff110() {
		if (jSeparatorDayhoff110 == null) {
			jSeparatorDayhoff110 = new JSeparator();
			jSeparatorDayhoff110.setBounds(new Rectangle(39, 2, 10, 26));
			jSeparatorDayhoff110.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorDayhoff110;
	}

	/**
	 * This method initializes jSeparatorDayhoff12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff12() {
		if (jSeparatorDayhoff12 == null) {
			jSeparatorDayhoff12 = new JSeparator();
			jSeparatorDayhoff12.setLocation(new Point(10, 91));
			jSeparatorDayhoff12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff12.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff12;
	}

	/**
	 * This method initializes jSeparatorDayhoff13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff13() {
		if (jSeparatorDayhoff13 == null) {
			jSeparatorDayhoff13 = new JSeparator();
			jSeparatorDayhoff13.setLocation(new Point(10, 131));
			jSeparatorDayhoff13.setSize(new Dimension(592, 10));
		}
		return jSeparatorDayhoff13;
	}

	/**
	 * This method initializes jSeparatorDayhoff14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff14() {
		if (jSeparatorDayhoff14 == null) {
			jSeparatorDayhoff14 = new JSeparator();
			jSeparatorDayhoff14.setLocation(new Point(601, 91));
			jSeparatorDayhoff14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff14.setSize(new Dimension(10, 41));
		}
		return jSeparatorDayhoff14;
	}

	/**
	 * This method initializes jSeparatorDayhoff15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff15() {
		if (jSeparatorDayhoff15 == null) {
			jSeparatorDayhoff15 = new JSeparator();
			jSeparatorDayhoff15.setLocation(new Point(248, 91));
			jSeparatorDayhoff15.setSize(new Dimension(354, 10));
		}
		return jSeparatorDayhoff15;
	}

	/**
	 * This method initializes jSeparatorDayhoff16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff16() {
		if (jSeparatorDayhoff16 == null) {
			jSeparatorDayhoff16 = new JSeparator();
			jSeparatorDayhoff16.setLocation(new Point(11, 171));
			jSeparatorDayhoff16.setSize(new Dimension(28, 10));
		}
		return jSeparatorDayhoff16;
	}

	/**
	 * This method initializes jSeparatorDayhoff17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff17() {
		if (jSeparatorDayhoff17 == null) {
			jSeparatorDayhoff17 = new JSeparator();
			jSeparatorDayhoff17.setLocation(new Point(10, 171));
			jSeparatorDayhoff17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff17.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff17;
	}

	/**
	 * This method initializes jSeparatorDayhoff18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff18() {
		if (jSeparatorDayhoff18 == null) {
			jSeparatorDayhoff18 = new JSeparator();
			jSeparatorDayhoff18.setLocation(new Point(10, 211));
			jSeparatorDayhoff18.setSize(new Dimension(592, 10));
		}
		return jSeparatorDayhoff18;
	}

	/**
	 * This method initializes jSeparatorDayhoff19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff19() {
		if (jSeparatorDayhoff19 == null) {
			jSeparatorDayhoff19 = new JSeparator();
			jSeparatorDayhoff19.setLocation(new Point(601, 171));
			jSeparatorDayhoff19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff19.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff19;
	}

	/**
	 * This method initializes jSeparatorDayhoff20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff20() {
		if (jSeparatorDayhoff20 == null) {
			jSeparatorDayhoff20 = new JSeparator();
			jSeparatorDayhoff20.setLocation(new Point(341, 170));
			jSeparatorDayhoff20.setSize(new Dimension(260, 10));
		}
		return jSeparatorDayhoff20;
	}

	/**
	 * This method initializes jSeparatorDayhoff21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff21() {
		if (jSeparatorDayhoff21 == null) {
			jSeparatorDayhoff21 = new JSeparator();
			jSeparatorDayhoff21.setLocation(new Point(11, 250));
			jSeparatorDayhoff21.setSize(new Dimension(28, 10));
		}
		return jSeparatorDayhoff21;
	}

	/**
	 * This method initializes jSeparatorDayhoff22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff22() {
		if (jSeparatorDayhoff22 == null) {
			jSeparatorDayhoff22 = new JSeparator();
			jSeparatorDayhoff22.setLocation(new Point(10, 250));
			jSeparatorDayhoff22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff22.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff22;
	}

	/**
	 * This method initializes jSeparatorDayhoff23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff23() {
		if (jSeparatorDayhoff23 == null) {
			jSeparatorDayhoff23 = new JSeparator();
			jSeparatorDayhoff23.setLocation(new Point(10, 290));
			jSeparatorDayhoff23.setSize(new Dimension(592, 10));
		}
		return jSeparatorDayhoff23;
	}

	/**
	 * This method initializes jSeparatorDayhoff24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff24() {
		if (jSeparatorDayhoff24 == null) {
			jSeparatorDayhoff24 = new JSeparator();
			jSeparatorDayhoff24.setLocation(new Point(602, 250));
			jSeparatorDayhoff24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoff24.setSize(new Dimension(10, 40));
		}
		return jSeparatorDayhoff24;
	}

	/**
	 * This method initializes jSeparatorDayhoff25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoff25() {
		if (jSeparatorDayhoff25 == null) {
			jSeparatorDayhoff25 = new JSeparator();
			jSeparatorDayhoff25.setLocation(new Point(256, 250));
			jSeparatorDayhoff25.setSize(new Dimension(348, 10));
		}
		return jSeparatorDayhoff25;
	}

	/**
	 * This method initializes jSeparatorDayhoffM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM10() {
		if (jSeparatorDayhoffM10 == null) {
			jSeparatorDayhoffM10 = new JSeparator();
			jSeparatorDayhoffM10.setLocation(new Point(39, 185));
			jSeparatorDayhoffM10.setSize(new Dimension(301, 10));
		}
		return jSeparatorDayhoffM10;
	}

	/**
	 * This method initializes jSeparatorDayhoffM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM11() {
		if (jSeparatorDayhoffM11 == null) {
			jSeparatorDayhoffM11 = new JSeparator();
			jSeparatorDayhoffM11.setLocation(new Point(339, 159));
			jSeparatorDayhoffM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoffM11.setSize(new Dimension(10, 26));
		}
		return jSeparatorDayhoffM11;
	}

	/**
	 * This method initializes jSeparatorDayhoffM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM12() {
		if (jSeparatorDayhoffM12 == null) {
			jSeparatorDayhoffM12 = new JSeparator();
			jSeparatorDayhoffM12.setLocation(new Point(39, 158));
			jSeparatorDayhoffM12.setSize(new Dimension(301, 10));
		}
		return jSeparatorDayhoffM12;
	}

	/**
	 * This method initializes jSeparatorDayhoffM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM13() {
		if (jSeparatorDayhoffM13 == null) {
			jSeparatorDayhoffM13 = new JSeparator();
			jSeparatorDayhoffM13.setLocation(new Point(39, 238));
			jSeparatorDayhoffM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoffM13.setSize(new Dimension(10, 26));
		}
		return jSeparatorDayhoffM13;
	}

	/**
	 * This method initializes jSeparatorDayhoffM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM14() {
		if (jSeparatorDayhoffM14 == null) {
			jSeparatorDayhoffM14 = new JSeparator();
			jSeparatorDayhoffM14.setLocation(new Point(256, 238));
			jSeparatorDayhoffM14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoffM14.setSize(new Dimension(10, 26));
		}
		return jSeparatorDayhoffM14;
	}

	/**
	 * This method initializes jSeparatorDayhoffM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM15() {
		if (jSeparatorDayhoffM15 == null) {
			jSeparatorDayhoffM15 = new JSeparator();
			jSeparatorDayhoffM15.setLocation(new Point(39, 264));
			jSeparatorDayhoffM15.setSize(new Dimension(218, 10));
		}
		return jSeparatorDayhoffM15;
	}

	/**
	 * This method initializes jSeparatorDayhoffM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM16() {
		if (jSeparatorDayhoffM16 == null) {
			jSeparatorDayhoffM16 = new JSeparator();
			jSeparatorDayhoffM16.setLocation(new Point(39, 237));
			jSeparatorDayhoffM16.setSize(new Dimension(218, 10));
		}
		return jSeparatorDayhoffM16;
	}

	/**
	 * This method initializes jSeparatorDayhoffM2
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM2() {
		if (jSeparatorDayhoffM2 == null) {
			jSeparatorDayhoffM2 = new JSeparator();
			jSeparatorDayhoffM2.setLocation(new Point(39, 28));
			jSeparatorDayhoffM2.setSize(new Dimension(199, 10));
		}
		return jSeparatorDayhoffM2;
	}

	/**
	 * This method initializes jSeparatorDayhoffM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM3() {
		if (jSeparatorDayhoffM3 == null) {
			jSeparatorDayhoffM3 = new JSeparator();
			jSeparatorDayhoffM3.setLocation(new Point(237, 3));
			jSeparatorDayhoffM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoffM3.setSize(new Dimension(10, 25));
		}
		return jSeparatorDayhoffM3;
	}

	/**
	 * This method initializes jSeparatorDayhoffM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM4() {
		if (jSeparatorDayhoffM4 == null) {
			jSeparatorDayhoffM4 = new JSeparator();
			jSeparatorDayhoffM4.setLocation(new Point(39, 1));
			jSeparatorDayhoffM4.setSize(new Dimension(199, 8));
		}
		return jSeparatorDayhoffM4;
	}

	/**
	 * This method initializes jSeparatorDayhoffM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM5() {
		if (jSeparatorDayhoffM5 == null) {
			jSeparatorDayhoffM5 = new JSeparator();
			jSeparatorDayhoffM5.setBounds(new Rectangle(39, 79, 10, 26));
			jSeparatorDayhoffM5.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorDayhoffM5;
	}

	/**
	 * This method initializes jSeparatorDayhoffM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM6() {
		if (jSeparatorDayhoffM6 == null) {
			jSeparatorDayhoffM6 = new JSeparator();
			jSeparatorDayhoffM6.setLocation(new Point(247, 80));
			jSeparatorDayhoffM6.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoffM6.setSize(new Dimension(10, 26));
		}
		return jSeparatorDayhoffM6;
	}

	/**
	 * This method initializes jSeparatorDayhoffM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM7() {
		if (jSeparatorDayhoffM7 == null) {
			jSeparatorDayhoffM7 = new JSeparator();
			jSeparatorDayhoffM7.setBounds(new Rectangle(40, 105, 208, 10));
		}
		return jSeparatorDayhoffM7;
	}

	/**
	 * This method initializes jSeparatorDayhoffM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM8() {
		if (jSeparatorDayhoffM8 == null) {
			jSeparatorDayhoffM8 = new JSeparator();
			jSeparatorDayhoffM8.setLocation(new Point(40, 78));
			jSeparatorDayhoffM8.setSize(new Dimension(208, 10));
		}
		return jSeparatorDayhoffM8;
	}

	/**
	 * This method initializes jSeparatorDayhoffM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDayhoffM9() {
		if (jSeparatorDayhoffM9 == null) {
			jSeparatorDayhoffM9 = new JSeparator();
			jSeparatorDayhoffM9.setLocation(new Point(39, 159));
			jSeparatorDayhoffM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDayhoffM9.setSize(new Dimension(10, 26));
		}
		return jSeparatorDayhoffM9;
	}

	/**
	 * This method initializes jSeparatorDCMut01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut01() {
		if (jSeparatorDCMut01 == null) {
			jSeparatorDCMut01 = new JSeparator();
			jSeparatorDCMut01.setLocation(new Point(11, 12));
			jSeparatorDCMut01.setSize(new Dimension(28, 10));
		}
		return jSeparatorDCMut01;
	}

	/**
	 * This method initializes jSeparatorDCMut02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut02() {
		if (jSeparatorDCMut02 == null) {
			jSeparatorDCMut02 = new JSeparator();
			jSeparatorDCMut02.setLocation(new Point(10, 12));
			jSeparatorDCMut02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut02.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut02;
	}

	/**
	 * This method initializes jSeparatorDCMut03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut03() {
		if (jSeparatorDCMut03 == null) {
			jSeparatorDCMut03 = new JSeparator();
			jSeparatorDCMut03.setLocation(new Point(10, 52));
			jSeparatorDCMut03.setSize(new Dimension(591, 10));
		}
		return jSeparatorDCMut03;
	}

	/**
	 * This method initializes jSeparatorDCMut04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut04() {
		if (jSeparatorDCMut04 == null) {
			jSeparatorDCMut04 = new JSeparator();
			jSeparatorDCMut04.setLocation(new Point(601, 13));
			jSeparatorDCMut04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut04.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut04;
	}

	/**
	 * This method initializes jSeparatorDCMut05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut05() {
		if (jSeparatorDCMut05 == null) {
			jSeparatorDCMut05 = new JSeparator();
			jSeparatorDCMut05.setLocation(new Point(238, 12));
			jSeparatorDCMut05.setSize(new Dimension(364, 10));
		}
		return jSeparatorDCMut05;
	}

	/**
	 * This method initializes jSeparatorDCMut11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut11() {
		if (jSeparatorDCMut11 == null) {
			jSeparatorDCMut11 = new JSeparator();
			jSeparatorDCMut11.setBounds(new Rectangle(39, 2, 10, 26));
			jSeparatorDCMut11.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorDCMut11;
	}

	/**
	 * This method initializes jSeparatorDCMut12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut12() {
		if (jSeparatorDCMut12 == null) {
			jSeparatorDCMut12 = new JSeparator();
			jSeparatorDCMut12.setLocation(new Point(10, 91));
			jSeparatorDCMut12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut12.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut12;
	}

	/**
	 * This method initializes jSeparatorDCMut13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut13() {
		if (jSeparatorDCMut13 == null) {
			jSeparatorDCMut13 = new JSeparator();
			jSeparatorDCMut13.setLocation(new Point(10, 131));
			jSeparatorDCMut13.setSize(new Dimension(592, 10));
		}
		return jSeparatorDCMut13;
	}

	/**
	 * This method initializes jSeparatorDCMut14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut14() {
		if (jSeparatorDCMut14 == null) {
			jSeparatorDCMut14 = new JSeparator();
			jSeparatorDCMut14.setLocation(new Point(601, 91));
			jSeparatorDCMut14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut14.setSize(new Dimension(10, 41));
		}
		return jSeparatorDCMut14;
	}

	/**
	 * This method initializes jSeparatorDCMut15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut15() {
		if (jSeparatorDCMut15 == null) {
			jSeparatorDCMut15 = new JSeparator();
			jSeparatorDCMut15.setLocation(new Point(250, 91));
			jSeparatorDCMut15.setSize(new Dimension(352, 10));
		}
		return jSeparatorDCMut15;
	}

	/**
	 * This method initializes jSeparatorDCMut16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut16() {
		if (jSeparatorDCMut16 == null) {
			jSeparatorDCMut16 = new JSeparator();
			jSeparatorDCMut16.setLocation(new Point(11, 171));
			jSeparatorDCMut16.setSize(new Dimension(28, 10));
		}
		return jSeparatorDCMut16;
	}

	/**
	 * This method initializes jSeparatorDCMut17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut17() {
		if (jSeparatorDCMut17 == null) {
			jSeparatorDCMut17 = new JSeparator();
			jSeparatorDCMut17.setLocation(new Point(10, 171));
			jSeparatorDCMut17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut17.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut17;
	}

	/**
	 * This method initializes jSeparatorDCMut18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut18() {
		if (jSeparatorDCMut18 == null) {
			jSeparatorDCMut18 = new JSeparator();
			jSeparatorDCMut18.setLocation(new Point(10, 211));
			jSeparatorDCMut18.setSize(new Dimension(592, 10));
		}
		return jSeparatorDCMut18;
	}

	/**
	 * This method initializes jSeparatorDCMut19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut19() {
		if (jSeparatorDCMut19 == null) {
			jSeparatorDCMut19 = new JSeparator();
			jSeparatorDCMut19.setLocation(new Point(601, 171));
			jSeparatorDCMut19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut19.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut19;
	}

	/**
	 * This method initializes jSeparatorDCMut20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut20() {
		if (jSeparatorDCMut20 == null) {
			jSeparatorDCMut20 = new JSeparator();
			jSeparatorDCMut20.setLocation(new Point(341, 170));
			jSeparatorDCMut20.setSize(new Dimension(261, 10));
		}
		return jSeparatorDCMut20;
	}

	/**
	 * This method initializes jSeparatorDCMut22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut22() {
		if (jSeparatorDCMut22 == null) {
			jSeparatorDCMut22 = new JSeparator();
			jSeparatorDCMut22.setLocation(new Point(10, 250));
			jSeparatorDCMut22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut22.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut22;
	}

	/**
	 * This method initializes jSeparatorDCMut23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut23() {
		if (jSeparatorDCMut23 == null) {
			jSeparatorDCMut23 = new JSeparator();
			jSeparatorDCMut23.setLocation(new Point(10, 290));
			jSeparatorDCMut23.setSize(new Dimension(592, 10));
		}
		return jSeparatorDCMut23;
	}

	/**
	 * This method initializes jSeparatorDCMut24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut24() {
		if (jSeparatorDCMut24 == null) {
			jSeparatorDCMut24 = new JSeparator();
			jSeparatorDCMut24.setLocation(new Point(602, 250));
			jSeparatorDCMut24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMut24.setSize(new Dimension(10, 40));
		}
		return jSeparatorDCMut24;
	}

	/**
	 * This method initializes jSeparatorDCMut25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMut25() {
		if (jSeparatorDCMut25 == null) {
			jSeparatorDCMut25 = new JSeparator();
			jSeparatorDCMut25.setLocation(new Point(255, 250));
			jSeparatorDCMut25.setSize(new Dimension(349, 10));
		}
		return jSeparatorDCMut25;
	}

	/**
	 * This method initializes jSeparatorDCMutM1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM1() {
		if (jSeparatorDCMutM1 == null) {
			jSeparatorDCMutM1 = new JSeparator();
			jSeparatorDCMutM1.setLocation(new Point(11, 91));
			jSeparatorDCMutM1.setSize(new Dimension(28, 10));
		}
		return jSeparatorDCMutM1;
	}

	/**
	 * This method initializes jSeparatorDCMutM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM10() {
		if (jSeparatorDCMutM10 == null) {
			jSeparatorDCMutM10 = new JSeparator();
			jSeparatorDCMutM10.setLocation(new Point(39, 185));
			jSeparatorDCMutM10.setSize(new Dimension(301, 10));
		}
		return jSeparatorDCMutM10;
	}

	/**
	 * This method initializes jSeparatorDCMutM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM11() {
		if (jSeparatorDCMutM11 == null) {
			jSeparatorDCMutM11 = new JSeparator();
			jSeparatorDCMutM11.setLocation(new Point(339, 159));
			jSeparatorDCMutM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMutM11.setSize(new Dimension(10, 26));
		}
		return jSeparatorDCMutM11;
	}

	/**
	 * This method initializes jSeparatorDCMutM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM12() {
		if (jSeparatorDCMutM12 == null) {
			jSeparatorDCMutM12 = new JSeparator();
			jSeparatorDCMutM12.setLocation(new Point(39, 158));
			jSeparatorDCMutM12.setSize(new Dimension(301, 10));
		}
		return jSeparatorDCMutM12;
	}

	/**
	 * This method initializes jSeparatorDCMutM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM13() {
		if (jSeparatorDCMutM13 == null) {
			jSeparatorDCMutM13 = new JSeparator();
			jSeparatorDCMutM13.setLocation(new Point(39, 238));
			jSeparatorDCMutM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMutM13.setSize(new Dimension(10, 26));
		}
		return jSeparatorDCMutM13;
	}

	/**
	 * This method initializes jSeparatorDCMutM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM14() {
		if (jSeparatorDCMutM14 == null) {
			jSeparatorDCMutM14 = new JSeparator();
			jSeparatorDCMutM14.setLocation(new Point(254, 238));
			jSeparatorDCMutM14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMutM14.setSize(new Dimension(10, 26));
		}
		return jSeparatorDCMutM14;
	}

	/**
	 * This method initializes jSeparatorDCMutM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM15() {
		if (jSeparatorDCMutM15 == null) {
			jSeparatorDCMutM15 = new JSeparator();
			jSeparatorDCMutM15.setLocation(new Point(39, 264));
			jSeparatorDCMutM15.setSize(new Dimension(216, 10));
		}
		return jSeparatorDCMutM15;
	}

	/**
	 * This method initializes jSeparatorDCMutM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM16() {
		if (jSeparatorDCMutM16 == null) {
			jSeparatorDCMutM16 = new JSeparator();
			jSeparatorDCMutM16.setLocation(new Point(39, 237));
			jSeparatorDCMutM16.setSize(new Dimension(216, 10));
		}
		return jSeparatorDCMutM16;
	}

	/**
	 * This method initializes jSeparatorDCMutM21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM21() {
		if (jSeparatorDCMutM21 == null) {
			jSeparatorDCMutM21 = new JSeparator();
			jSeparatorDCMutM21.setLocation(new Point(39, 28));
			jSeparatorDCMutM21.setSize(new Dimension(199, 10));
		}
		return jSeparatorDCMutM21;
	}

	/**
	 * This method initializes jSeparatorDCMutM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM3() {
		if (jSeparatorDCMutM3 == null) {
			jSeparatorDCMutM3 = new JSeparator();
			jSeparatorDCMutM3.setLocation(new Point(237, 3));
			jSeparatorDCMutM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMutM3.setSize(new Dimension(10, 25));
		}
		return jSeparatorDCMutM3;
	}

	/**
	 * This method initializes jSeparatorDCMutM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM4() {
		if (jSeparatorDCMutM4 == null) {
			jSeparatorDCMutM4 = new JSeparator();
			jSeparatorDCMutM4.setLocation(new Point(39, 1));
			jSeparatorDCMutM4.setSize(new Dimension(199, 8));
		}
		return jSeparatorDCMutM4;
	}

	/**
	 * This method initializes jSeparatorDCMutM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM5() {
		if (jSeparatorDCMutM5 == null) {
			jSeparatorDCMutM5 = new JSeparator();
			jSeparatorDCMutM5.setBounds(new Rectangle(39, 79, 10, 26));
			jSeparatorDCMutM5.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorDCMutM5;
	}

	/**
	 * This method initializes jSeparatorDCMutM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM6() {
		if (jSeparatorDCMutM6 == null) {
			jSeparatorDCMutM6 = new JSeparator();
			jSeparatorDCMutM6.setLocation(new Point(249, 79));
			jSeparatorDCMutM6.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMutM6.setSize(new Dimension(10, 26));
		}
		return jSeparatorDCMutM6;
	}

	/**
	 * This method initializes jSeparatorDCMutM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM7() {
		if (jSeparatorDCMutM7 == null) {
			jSeparatorDCMutM7 = new JSeparator();
			jSeparatorDCMutM7.setBounds(new Rectangle(40, 105, 210, 10));
		}
		return jSeparatorDCMutM7;
	}

	/**
	 * This method initializes jSeparatorDCMutM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM8() {
		if (jSeparatorDCMutM8 == null) {
			jSeparatorDCMutM8 = new JSeparator();
			jSeparatorDCMutM8.setLocation(new Point(40, 78));
			jSeparatorDCMutM8.setSize(new Dimension(210, 10));
		}
		return jSeparatorDCMutM8;
	}

	/**
	 * This method initializes jSeparatorDCMutM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorDCMutM9() {
		if (jSeparatorDCMutM9 == null) {
			jSeparatorDCMutM9 = new JSeparator();
			jSeparatorDCMutM9.setLocation(new Point(39, 159));
			jSeparatorDCMutM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorDCMutM9.setSize(new Dimension(10, 26));
		}
		return jSeparatorDCMutM9;
	}

	/**
	 * This method initializes jSeparatorF8401
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8401() {
		if (jSeparatorF8401 == null) {
			jSeparatorF8401 = new JSeparator();
			jSeparatorF8401.setSize(new Dimension(28, 10));
			jSeparatorF8401.setBackground(Color.white);
			jSeparatorF8401.setLocation(new Point(11, 12));
		}
		return jSeparatorF8401;
	}

	/**
	 * This method initializes jSeparatorF8402
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8402() {
		if (jSeparatorF8402 == null) {
			jSeparatorF8402 = new JSeparator();
			jSeparatorF8402.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8402.setLocation(new Point(10, 12));
			jSeparatorF8402.setBackground(Color.white);
			jSeparatorF8402.setSize(new Dimension(10, 40));
		}
		return jSeparatorF8402;
	}

	/**
	 * This method initializes jSeparatorF8403
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8403() {
		if (jSeparatorF8403 == null) {
			jSeparatorF8403 = new JSeparator();
			jSeparatorF8403.setSize(new Dimension(591, 10));
			jSeparatorF8403.setBackground(Color.white);
			jSeparatorF8403.setLocation(new Point(10, 52));
		}
		return jSeparatorF8403;
	}

	/**
	 * This method initializes jSeparatorF8404
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8404() {
		if (jSeparatorF8404 == null) {
			jSeparatorF8404 = new JSeparator();
			jSeparatorF8404.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8404.setLocation(new Point(601, 13));
			jSeparatorF8404.setBackground(Color.white);
			jSeparatorF8404.setSize(new Dimension(10, 40));
		}
		return jSeparatorF8404;
	}

	/**
	 * This method initializes jSeparatorF8405
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8405() {
		if (jSeparatorF8405 == null) {
			jSeparatorF8405 = new JSeparator();
			jSeparatorF8405.setSize(new Dimension(395, 10));
			jSeparatorF8405.setBackground(Color.white);
			jSeparatorF8405.setLocation(new Point(207, 12));
		}
		return jSeparatorF8405;
	}

	/**
	 * This method initializes jSeparatorF8406
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8406() {
		if (jSeparatorF8406 == null) {
			jSeparatorF8406 = new JSeparator();
			jSeparatorF8406.setSize(new Dimension(28, 10));
			jSeparatorF8406.setLocation(new Point(11, 75));
		}
		return jSeparatorF8406;
	}

	/**
	 * This method initializes jSeparatorF8407
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8407() {
		if (jSeparatorF8407 == null) {
			jSeparatorF8407 = new JSeparator();
			jSeparatorF8407.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8407.setSize(new Dimension(10, 40));
			jSeparatorF8407.setLocation(new Point(10, 75));
		}
		return jSeparatorF8407;
	}

	/**
	 * This method initializes jSeparatorF8408
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8408() {
		if (jSeparatorF8408 == null) {
			jSeparatorF8408 = new JSeparator();
			jSeparatorF8408.setSize(new Dimension(592, 10));
			jSeparatorF8408.setLocation(new Point(10, 115));
		}
		return jSeparatorF8408;
	}

	/**
	 * This method initializes jSeparatorF8409
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8409() {
		if (jSeparatorF8409 == null) {
			jSeparatorF8409 = new JSeparator();
			jSeparatorF8409.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8409.setSize(new Dimension(10, 40));
			jSeparatorF8409.setLocation(new Point(601, 75));
		}
		return jSeparatorF8409;
	}

	/**
	 * This method initializes jSeparatorF8410
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8410() {
		if (jSeparatorF8410 == null) {
			jSeparatorF8410 = new JSeparator();
			jSeparatorF8410.setSize(new Dimension(347, 10));
			jSeparatorF8410.setLocation(new Point(256, 75));
		}
		return jSeparatorF8410;
	}

	/**
	 * This method initializes jSeparatorF8411
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8411() {
		if (jSeparatorF8411 == null) {
			jSeparatorF8411 = new JSeparator();
			jSeparatorF8411.setSize(new Dimension(28, 10));
			jSeparatorF8411.setLocation(new Point(11, 138));
		}
		return jSeparatorF8411;
	}

	/**
	 * This method initializes jSeparatorF8412
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8412() {
		if (jSeparatorF8412 == null) {
			jSeparatorF8412 = new JSeparator();
			jSeparatorF8412.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8412.setSize(new Dimension(10, 40));
			jSeparatorF8412.setLocation(new Point(10, 138));
		}
		return jSeparatorF8412;
	}

	/**
	 * This method initializes jSeparatorF8413
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8413() {
		if (jSeparatorF8413 == null) {
			jSeparatorF8413 = new JSeparator();
			jSeparatorF8413.setLocation(new Point(10, 178));
			jSeparatorF8413.setSize(new Dimension(592, 10));
		}
		return jSeparatorF8413;
	}

	/**
	 * This method initializes jSeparatorF8414
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8414() {
		if (jSeparatorF8414 == null) {
			jSeparatorF8414 = new JSeparator();
			jSeparatorF8414.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8414.setLocation(new Point(601, 138));
			jSeparatorF8414.setSize(new Dimension(10, 41));
		}
		return jSeparatorF8414;
	}

	/**
	 * This method initializes jSeparatorF8415
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8415() {
		if (jSeparatorF8415 == null) {
			jSeparatorF8415 = new JSeparator();
			jSeparatorF8415.setSize(new Dimension(344, 10));
			jSeparatorF8415.setLocation(new Point(258, 138));
		}
		return jSeparatorF8415;
	}

	/**
	 * This method initializes jSeparatorF8416
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8416() {
		if (jSeparatorF8416 == null) {
			jSeparatorF8416 = new JSeparator();
			jSeparatorF8416.setLocation(new Point(11, 201));
			jSeparatorF8416.setSize(new Dimension(28, 10));
		}
		return jSeparatorF8416;
	}

	/**
	 * This method initializes jSeparatorF8417
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8417() {
		if (jSeparatorF8417 == null) {
			jSeparatorF8417 = new JSeparator();
			jSeparatorF8417.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8417.setSize(new Dimension(10, 40));
			jSeparatorF8417.setLocation(new Point(10, 201));
		}
		return jSeparatorF8417;
	}

	/**
	 * This method initializes jSeparatorF8418
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8418() {
		if (jSeparatorF8418 == null) {
			jSeparatorF8418 = new JSeparator();
			jSeparatorF8418.setLocation(new Point(10, 241));
			jSeparatorF8418.setSize(new Dimension(592, 10));
		}
		return jSeparatorF8418;
	}

	/**
	 * This method initializes jSeparatorF8419
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8419() {
		if (jSeparatorF8419 == null) {
			jSeparatorF8419 = new JSeparator();
			jSeparatorF8419.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8419.setSize(new Dimension(10, 40));
			jSeparatorF8419.setLocation(new Point(601, 202));
		}
		return jSeparatorF8419;
	}

	/**
	 * This method initializes jSeparatorF8420
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8420() {
		if (jSeparatorF8420 == null) {
			jSeparatorF8420 = new JSeparator();
			jSeparatorF8420.setLocation(new Point(341, 201));
			jSeparatorF8420.setSize(new Dimension(261, 10));
		}
		return jSeparatorF8420;
	}

	/**
	 * This method initializes jSeparatorF8421
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8421() {
		if (jSeparatorF8421 == null) {
			jSeparatorF8421 = new JSeparator();
			jSeparatorF8421.setSize(new Dimension(28, 10));
			jSeparatorF8421.setLocation(new Point(11, 264));
		}
		return jSeparatorF8421;
	}

	/**
	 * This method initializes jSeparatorF8422
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8422() {
		if (jSeparatorF8422 == null) {
			jSeparatorF8422 = new JSeparator();
			jSeparatorF8422.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8422.setSize(new Dimension(10, 40));
			jSeparatorF8422.setLocation(new Point(10, 264));
		}
		return jSeparatorF8422;
	}

	/**
	 * This method initializes jSeparatorF8423
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8423() {
		if (jSeparatorF8423 == null) {
			jSeparatorF8423 = new JSeparator();
			jSeparatorF8423.setLocation(new Point(10, 304));
			jSeparatorF8423.setSize(new Dimension(592, 10));
		}
		return jSeparatorF8423;
	}

	/**
	 * This method initializes jSeparatorF8424
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8424() {
		if (jSeparatorF8424 == null) {
			jSeparatorF8424 = new JSeparator();
			jSeparatorF8424.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF8424.setSize(new Dimension(10, 40));
			jSeparatorF8424.setLocation(new Point(602, 264));
		}
		return jSeparatorF8424;
	}

	/**
	 * This method initializes jSeparatorF8425
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF8425() {
		if (jSeparatorF8425 == null) {
			jSeparatorF8425 = new JSeparator();
			jSeparatorF8425.setBounds(new Rectangle(254, 264, 349, 10));
		}
		return jSeparatorF8425;
	}

	/**
	 * This method initializes jSeparatorF84M1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M1() {
		if (jSeparatorF84M1 == null) {
			jSeparatorF84M1 = new JSeparator();
			jSeparatorF84M1.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorF84M1.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M1.setBackground(Color.white);
		}
		return jSeparatorF84M1;
	}

	/**
	 * This method initializes jSeparatorF84M10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M10() {
		if (jSeparatorF84M10 == null) {
			jSeparatorF84M10 = new JSeparator();
			jSeparatorF84M10.setLocation(new Point(39, 212));
			jSeparatorF84M10.setSize(new Dimension(301, 10));
		}
		return jSeparatorF84M10;
	}

	/**
	 * This method initializes jSeparatorF84M11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M11() {
		if (jSeparatorF84M11 == null) {
			jSeparatorF84M11 = new JSeparator();
			jSeparatorF84M11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M11.setSize(new Dimension(10, 23));
			jSeparatorF84M11.setLocation(new Point(339, 189));
		}
		return jSeparatorF84M11;
	}

	/**
	 * This method initializes jSeparatorF84M12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M12() {
		if (jSeparatorF84M12 == null) {
			jSeparatorF84M12 = new JSeparator();
			jSeparatorF84M12.setSize(new Dimension(301, 10));
			jSeparatorF84M12.setLocation(new Point(39, 188));
		}
		return jSeparatorF84M12;
	}

	/**
	 * This method initializes jSeparatorF84M13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M13() {
		if (jSeparatorF84M13 == null) {
			jSeparatorF84M13 = new JSeparator();
			jSeparatorF84M13.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorF84M13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M13.setBackground(Color.white);
		}
		return jSeparatorF84M13;
	}

	/**
	 * This method initializes jSeparatorF84M14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M14() {
		if (jSeparatorF84M14 == null) {
			jSeparatorF84M14 = new JSeparator();
			jSeparatorF84M14.setSize(new Dimension(219, 10));
			jSeparatorF84M14.setLocation(new Point(39, 150));
		}
		return jSeparatorF84M14;
	}

	/**
	 * This method initializes jSeparatorF84M15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M15() {
		if (jSeparatorF84M15 == null) {
			jSeparatorF84M15 = new JSeparator();
			jSeparatorF84M15.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M15.setLocation(new Point(257, 128));
			jSeparatorF84M15.setSize(new Dimension(10, 22));
			jSeparatorF84M15.setBackground(Color.white);
		}
		return jSeparatorF84M15;
	}

	/**
	 * This method initializes jSeparatorF84M16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M16() {
		if (jSeparatorF84M16 == null) {
			jSeparatorF84M16 = new JSeparator();
			jSeparatorF84M16.setBounds(new Rectangle(39, 127, 219, 10));
		}
		return jSeparatorF84M16;
	}

	/**
	 * This method initializes jSeparatorF84M17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M17() {
		if (jSeparatorF84M17 == null) {
			jSeparatorF84M17 = new JSeparator();
			jSeparatorF84M17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M17.setLocation(new Point(39, 254));
			jSeparatorF84M17.setSize(new Dimension(10, 23));
			jSeparatorF84M17.setBackground(Color.white);
		}
		return jSeparatorF84M17;
	}

	/**
	 * This method initializes jSeparatorF84M18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M18() {
		if (jSeparatorF84M18 == null) {
			jSeparatorF84M18 = new JSeparator();
			jSeparatorF84M18.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M18.setLocation(new Point(253, 254));
			jSeparatorF84M18.setSize(new Dimension(10, 23));
			jSeparatorF84M18.setBackground(Color.white);
		}
		return jSeparatorF84M18;
	}

	/**
	 * This method initializes jSeparatorF84M19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M19() {
		if (jSeparatorF84M19 == null) {
			jSeparatorF84M19 = new JSeparator();
			jSeparatorF84M19.setSize(new Dimension(214, 10));
			jSeparatorF84M19.setLocation(new Point(39, 277));
		}
		return jSeparatorF84M19;
	}

	/**
	 * This method initializes jSeparatorF84M2
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M2() {
		if (jSeparatorF84M2 == null) {
			jSeparatorF84M2 = new JSeparator();
			jSeparatorF84M2.setBounds(new Rectangle(39, 26, 168, 10));
			jSeparatorF84M2.setBackground(Color.white);
			jSeparatorF84M2.setPreferredSize(new Dimension(0, 2));
		}
		return jSeparatorF84M2;
	}

	/**
	 * This method initializes jSeparatorF84M20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M20() {
		if (jSeparatorF84M20 == null) {
			jSeparatorF84M20 = new JSeparator();
			jSeparatorF84M20.setBounds(new Rectangle(39, 253, 214, 10));
		}
		return jSeparatorF84M20;
	}

	/**
	 * This method initializes jSeparatorF84M3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M3() {
		if (jSeparatorF84M3 == null) {
			jSeparatorF84M3 = new JSeparator();
			jSeparatorF84M3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M3.setSize(new Dimension(10, 23));
			jSeparatorF84M3.setBackground(Color.white);
			jSeparatorF84M3.setLocation(new Point(206, 3));
		}
		return jSeparatorF84M3;
	}

	/**
	 * This method initializes jSeparatorF84M4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M4() {
		if (jSeparatorF84M4 == null) {
			jSeparatorF84M4 = new JSeparator();
			jSeparatorF84M4.setSize(new Dimension(168, 10));
			jSeparatorF84M4.setBackground(Color.white);
			jSeparatorF84M4.setLocation(new Point(39, 2));
		}
		return jSeparatorF84M4;
	}

	/**
	 * This method initializes jSeparatorF84M5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M5() {
		if (jSeparatorF84M5 == null) {
			jSeparatorF84M5 = new JSeparator();
			jSeparatorF84M5.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M5.setSize(new Dimension(10, 26));
			jSeparatorF84M5.setBackground(Color.white);
			jSeparatorF84M5.setLocation(new Point(38, 63));
		}
		return jSeparatorF84M5;
	}

	/**
	 * This method initializes jSeparatorF84M6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M6() {
		if (jSeparatorF84M6 == null) {
			jSeparatorF84M6 = new JSeparator();
			jSeparatorF84M6.setSize(new Dimension(217, 10));
			jSeparatorF84M6.setLocation(new Point(38, 89));
		}
		return jSeparatorF84M6;
	}

	/**
	 * This method initializes jSeparatorF84M7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M7() {
		if (jSeparatorF84M7 == null) {
			jSeparatorF84M7 = new JSeparator();
			jSeparatorF84M7.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M7.setSize(new Dimension(10, 26));
			jSeparatorF84M7.setLocation(new Point(255, 63));
		}
		return jSeparatorF84M7;
	}

	/**
	 * This method initializes jSeparatorF84M8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M8() {
		if (jSeparatorF84M8 == null) {
			jSeparatorF84M8 = new JSeparator();
			jSeparatorF84M8.setSize(new Dimension(217, 10));
			jSeparatorF84M8.setLocation(new Point(38, 62));
		}
		return jSeparatorF84M8;
	}

	/**
	 * This method initializes jSeparatorF84M9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorF84M9() {
		if (jSeparatorF84M9 == null) {
			jSeparatorF84M9 = new JSeparator();
			jSeparatorF84M9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorF84M9.setLocation(new Point(39, 189));
			jSeparatorF84M9.setSize(new Dimension(10, 23));
			jSeparatorF84M9.setBackground(Color.white);
		}
		return jSeparatorF84M9;
	}

	/**
	 * This method initializes jSeparatorHKY
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY() {
		if (jSeparatorHKY == null) {
			jSeparatorHKY = new JSeparator();
			jSeparatorHKY.setBounds(new Rectangle(39, 26, 176, 10));
			jSeparatorHKY.setPreferredSize(new Dimension(0, 2));
			jSeparatorHKY.setBackground(Color.white);
		}
		return jSeparatorHKY;
	}

	/**
	 * This method initializes jSeparatorHKY01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY01() {
		if (jSeparatorHKY01 == null) {
			jSeparatorHKY01 = new JSeparator();
			jSeparatorHKY01.setLocation(new Point(11, 12));
			jSeparatorHKY01.setBackground(Color.white);
			jSeparatorHKY01.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY01;
	}

	/**
	 * This method initializes jSeparatorHKY011
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY011() {
		if (jSeparatorHKY011 == null) {
			jSeparatorHKY011 = new JSeparator();
			jSeparatorHKY011.setLocation(new Point(11, 12));
			jSeparatorHKY011.setBackground(Color.white);
			jSeparatorHKY011.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY011;
	}

	/**
	 * This method initializes jSeparatorHKY0111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0111() {
		if (jSeparatorHKY0111 == null) {
			jSeparatorHKY0111 = new JSeparator();
			jSeparatorHKY0111.setLocation(new Point(11, 12));
			jSeparatorHKY0111.setBackground(Color.white);
			jSeparatorHKY0111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY0111;
	}

	/**
	 * This method initializes jSeparatorHKY01111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY01111() {
		if (jSeparatorHKY01111 == null) {
			jSeparatorHKY01111 = new JSeparator();
			jSeparatorHKY01111.setLocation(new Point(11, 12));
			jSeparatorHKY01111.setBackground(Color.white);
			jSeparatorHKY01111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY01111;
	}

	/**
	 * This method initializes jSeparatorHKY02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY02() {
		if (jSeparatorHKY02 == null) {
			jSeparatorHKY02 = new JSeparator();
			jSeparatorHKY02.setLocation(new Point(10, 12));
			jSeparatorHKY02.setBackground(Color.white);
			jSeparatorHKY02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY02.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY02;
	}

	/**
	 * This method initializes jSeparatorHKY021
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY021() {
		if (jSeparatorHKY021 == null) {
			jSeparatorHKY021 = new JSeparator();
			jSeparatorHKY021.setLocation(new Point(10, 12));
			jSeparatorHKY021.setBackground(Color.white);
			jSeparatorHKY021.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY021.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY021;
	}

	/**
	 * This method initializes jSeparatorHKY0211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0211() {
		if (jSeparatorHKY0211 == null) {
			jSeparatorHKY0211 = new JSeparator();
			jSeparatorHKY0211.setLocation(new Point(10, 12));
			jSeparatorHKY0211.setBackground(Color.white);
			jSeparatorHKY0211.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY0211.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY0211;
	}

	/**
	 * This method initializes jSeparatorHKY02111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY02111() {
		if (jSeparatorHKY02111 == null) {
			jSeparatorHKY02111 = new JSeparator();
			jSeparatorHKY02111.setLocation(new Point(10, 12));
			jSeparatorHKY02111.setBackground(Color.white);
			jSeparatorHKY02111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY02111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY02111;
	}

	/**
	 * This method initializes jSeparatorHKY03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY03() {
		if (jSeparatorHKY03 == null) {
			jSeparatorHKY03 = new JSeparator();
			jSeparatorHKY03.setLocation(new Point(10, 52));
			jSeparatorHKY03.setBackground(Color.white);
			jSeparatorHKY03.setSize(new Dimension(591, 10));
		}
		return jSeparatorHKY03;
	}

	/**
	 * This method initializes jSeparatorHKY031
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY031() {
		if (jSeparatorHKY031 == null) {
			jSeparatorHKY031 = new JSeparator();
			jSeparatorHKY031.setLocation(new Point(10, 52));
			jSeparatorHKY031.setBackground(Color.white);
			jSeparatorHKY031.setSize(new Dimension(591, 10));
		}
		return jSeparatorHKY031;
	}

	/**
	 * This method initializes jSeparatorHKY0311
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0311() {
		if (jSeparatorHKY0311 == null) {
			jSeparatorHKY0311 = new JSeparator();
			jSeparatorHKY0311.setLocation(new Point(10, 52));
			jSeparatorHKY0311.setBackground(Color.white);
			jSeparatorHKY0311.setSize(new Dimension(591, 10));
		}
		return jSeparatorHKY0311;
	}

	/**
	 * This method initializes jSeparatorHKY03111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY03111() {
		if (jSeparatorHKY03111 == null) {
			jSeparatorHKY03111 = new JSeparator();
			jSeparatorHKY03111.setLocation(new Point(10, 52));
			jSeparatorHKY03111.setBackground(Color.white);
			jSeparatorHKY03111.setSize(new Dimension(591, 10));
		}
		return jSeparatorHKY03111;
	}

	/**
	 * This method initializes jSeparatorHKY04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY04() {
		if (jSeparatorHKY04 == null) {
			jSeparatorHKY04 = new JSeparator();
			jSeparatorHKY04.setLocation(new Point(601, 13));
			jSeparatorHKY04.setBackground(Color.white);
			jSeparatorHKY04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY04.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY04;
	}

	/**
	 * This method initializes jSeparatorHKY041
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY041() {
		if (jSeparatorHKY041 == null) {
			jSeparatorHKY041 = new JSeparator();
			jSeparatorHKY041.setLocation(new Point(601, 13));
			jSeparatorHKY041.setBackground(Color.white);
			jSeparatorHKY041.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY041.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY041;
	}

	/**
	 * This method initializes jSeparatorHKY0411
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0411() {
		if (jSeparatorHKY0411 == null) {
			jSeparatorHKY0411 = new JSeparator();
			jSeparatorHKY0411.setLocation(new Point(601, 13));
			jSeparatorHKY0411.setBackground(Color.white);
			jSeparatorHKY0411.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY0411.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY0411;
	}

	/**
	 * This method initializes jSeparatorHKY04111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY04111() {
		if (jSeparatorHKY04111 == null) {
			jSeparatorHKY04111 = new JSeparator();
			jSeparatorHKY04111.setLocation(new Point(601, 13));
			jSeparatorHKY04111.setBackground(Color.white);
			jSeparatorHKY04111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY04111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY04111;
	}

	/**
	 * This method initializes jSeparatorHKY05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY05() {
		if (jSeparatorHKY05 == null) {
			jSeparatorHKY05 = new JSeparator();
			jSeparatorHKY05.setLocation(new Point(216, 12));
			jSeparatorHKY05.setBackground(Color.white);
			jSeparatorHKY05.setSize(new Dimension(386, 10));
		}
		return jSeparatorHKY05;
	}

	/**
	 * This method initializes jSeparatorHKY051
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY051() {
		if (jSeparatorHKY051 == null) {
			jSeparatorHKY051 = new JSeparator();
			jSeparatorHKY051.setLocation(new Point(216, 12));
			jSeparatorHKY051.setBackground(Color.white);
			jSeparatorHKY051.setSize(new Dimension(386, 10));
		}
		return jSeparatorHKY051;
	}

	/**
	 * This method initializes jSeparatorHKY0511
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0511() {
		if (jSeparatorHKY0511 == null) {
			jSeparatorHKY0511 = new JSeparator();
			jSeparatorHKY0511.setLocation(new Point(216, 12));
			jSeparatorHKY0511.setBackground(Color.white);
			jSeparatorHKY0511.setSize(new Dimension(386, 10));
		}
		return jSeparatorHKY0511;
	}

	/**
	 * This method initializes jSeparatorHKY05111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY05111() {
		if (jSeparatorHKY05111 == null) {
			jSeparatorHKY05111 = new JSeparator();
			jSeparatorHKY05111.setLocation(new Point(216, 12));
			jSeparatorHKY05111.setBackground(Color.white);
			jSeparatorHKY05111.setSize(new Dimension(386, 10));
		}
		return jSeparatorHKY05111;
	}

	/**
	 * This method initializes jSeparatorHKY06
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY06() {
		if (jSeparatorHKY06 == null) {
			jSeparatorHKY06 = new JSeparator();
			jSeparatorHKY06.setLocation(new Point(11, 75));
			jSeparatorHKY06.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY06;
	}

	/**
	 * This method initializes jSeparatorHKY061
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY061() {
		if (jSeparatorHKY061 == null) {
			jSeparatorHKY061 = new JSeparator();
			jSeparatorHKY061.setLocation(new Point(11, 75));
			jSeparatorHKY061.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY061;
	}

	/**
	 * This method initializes jSeparatorHKY0611
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0611() {
		if (jSeparatorHKY0611 == null) {
			jSeparatorHKY0611 = new JSeparator();
			jSeparatorHKY0611.setLocation(new Point(11, 75));
			jSeparatorHKY0611.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY0611;
	}

	/**
	 * This method initializes jSeparatorHKY06111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY06111() {
		if (jSeparatorHKY06111 == null) {
			jSeparatorHKY06111 = new JSeparator();
			jSeparatorHKY06111.setLocation(new Point(11, 75));
			jSeparatorHKY06111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY06111;
	}

	/**
	 * This method initializes jSeparatorHKY07
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY07() {
		if (jSeparatorHKY07 == null) {
			jSeparatorHKY07 = new JSeparator();
			jSeparatorHKY07.setLocation(new Point(10, 75));
			jSeparatorHKY07.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY07.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY07;
	}

	/**
	 * This method initializes jSeparatorHKY072
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY072() {
		if (jSeparatorHKY072 == null) {
			jSeparatorHKY072 = new JSeparator();
			jSeparatorHKY072.setLocation(new Point(10, 75));
			jSeparatorHKY072.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY072.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY072;
	}

	/**
	 * This method initializes jSeparatorHKY0721
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0721() {
		if (jSeparatorHKY0721 == null) {
			jSeparatorHKY0721 = new JSeparator();
			jSeparatorHKY0721.setLocation(new Point(10, 75));
			jSeparatorHKY0721.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY0721.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY0721;
	}

	/**
	 * This method initializes jSeparatorHKY07211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY07211() {
		if (jSeparatorHKY07211 == null) {
			jSeparatorHKY07211 = new JSeparator();
			jSeparatorHKY07211.setLocation(new Point(10, 75));
			jSeparatorHKY07211.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY07211.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY07211;
	}

	/**
	 * This method initializes jSeparatorHKY08
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY08() {
		if (jSeparatorHKY08 == null) {
			jSeparatorHKY08 = new JSeparator();
			jSeparatorHKY08.setLocation(new Point(10, 115));
			jSeparatorHKY08.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY08;
	}

	/**
	 * This method initializes jSeparatorHKY081
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY081() {
		if (jSeparatorHKY081 == null) {
			jSeparatorHKY081 = new JSeparator();
			jSeparatorHKY081.setLocation(new Point(10, 115));
			jSeparatorHKY081.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY081;
	}

	/**
	 * This method initializes jSeparatorHKY0811
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0811() {
		if (jSeparatorHKY0811 == null) {
			jSeparatorHKY0811 = new JSeparator();
			jSeparatorHKY0811.setLocation(new Point(10, 115));
			jSeparatorHKY0811.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY0811;
	}

	/**
	 * This method initializes jSeparatorHKY08111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY08111() {
		if (jSeparatorHKY08111 == null) {
			jSeparatorHKY08111 = new JSeparator();
			jSeparatorHKY08111.setLocation(new Point(10, 115));
			jSeparatorHKY08111.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY08111;
	}

	/**
	 * This method initializes jSeparatorHKY09
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY09() {
		if (jSeparatorHKY09 == null) {
			jSeparatorHKY09 = new JSeparator();
			jSeparatorHKY09.setLocation(new Point(601, 75));
			jSeparatorHKY09.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY09.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY09;
	}

	/**
	 * This method initializes jSeparatorHKY091
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY091() {
		if (jSeparatorHKY091 == null) {
			jSeparatorHKY091 = new JSeparator();
			jSeparatorHKY091.setLocation(new Point(601, 75));
			jSeparatorHKY091.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY091.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY091;
	}

	/**
	 * This method initializes jSeparatorHKY0911
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY0911() {
		if (jSeparatorHKY0911 == null) {
			jSeparatorHKY0911 = new JSeparator();
			jSeparatorHKY0911.setLocation(new Point(601, 75));
			jSeparatorHKY0911.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY0911.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY0911;
	}

	/**
	 * This method initializes jSeparatorHKY09111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY09111() {
		if (jSeparatorHKY09111 == null) {
			jSeparatorHKY09111 = new JSeparator();
			jSeparatorHKY09111.setLocation(new Point(601, 75));
			jSeparatorHKY09111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY09111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY09111;
	}

	/**
	 * This method initializes jSeparatorHKY1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1() {
		if (jSeparatorHKY1 == null) {
			jSeparatorHKY1 = new JSeparator();
			jSeparatorHKY1.setBounds(new Rectangle(39, 26, 176, 10));
			jSeparatorHKY1.setPreferredSize(new Dimension(0, 2));
			jSeparatorHKY1.setBackground(Color.white);
		}
		return jSeparatorHKY1;
	}

	/**
	 * This method initializes jSeparatorHKY10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY10() {
		if (jSeparatorHKY10 == null) {
			jSeparatorHKY10 = new JSeparator();
			jSeparatorHKY10.setLocation(new Point(256, 75));
			jSeparatorHKY10.setSize(new Dimension(346, 10));
		}
		return jSeparatorHKY10;
	}

	/**
	 * This method initializes jSeparatorHKY101
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY101() {
		if (jSeparatorHKY101 == null) {
			jSeparatorHKY101 = new JSeparator();
			jSeparatorHKY101.setLocation(new Point(256, 75));
			jSeparatorHKY101.setSize(new Dimension(346, 10));
		}
		return jSeparatorHKY101;
	}

	/**
	 * This method initializes jSeparatorHKY1011
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1011() {
		if (jSeparatorHKY1011 == null) {
			jSeparatorHKY1011 = new JSeparator();
			jSeparatorHKY1011.setLocation(new Point(256, 75));
			jSeparatorHKY1011.setSize(new Dimension(346, 10));
		}
		return jSeparatorHKY1011;
	}

	/**
	 * This method initializes jSeparatorHKY10111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY10111() {
		if (jSeparatorHKY10111 == null) {
			jSeparatorHKY10111 = new JSeparator();
			jSeparatorHKY10111.setLocation(new Point(256, 75));
			jSeparatorHKY10111.setSize(new Dimension(346, 10));
		}
		return jSeparatorHKY10111;
	}

	/**
	 * This method initializes jSeparatorHKY11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY11() {
		if (jSeparatorHKY11 == null) {
			jSeparatorHKY11 = new JSeparator();
			jSeparatorHKY11.setLocation(new Point(11, 138));
			jSeparatorHKY11.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY11;
	}

	/**
	 * This method initializes jSeparatorHKY110
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY110() {
		if (jSeparatorHKY110 == null) {
			jSeparatorHKY110 = new JSeparator();
			jSeparatorHKY110.setBounds(new Rectangle(39, 26, 176, 10));
			jSeparatorHKY110.setPreferredSize(new Dimension(0, 2));
			jSeparatorHKY110.setBackground(Color.white);
		}
		return jSeparatorHKY110;
	}

	/**
	 * This method initializes jSeparatorHKY1101
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1101() {
		if (jSeparatorHKY1101 == null) {
			jSeparatorHKY1101 = new JSeparator();
			jSeparatorHKY1101.setBounds(new Rectangle(39, 26, 176, 10));
			jSeparatorHKY1101.setPreferredSize(new Dimension(0, 2));
			jSeparatorHKY1101.setBackground(Color.white);
		}
		return jSeparatorHKY1101;
	}

	/**
	 * This method initializes jSeparatorHKY111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY111() {
		if (jSeparatorHKY111 == null) {
			jSeparatorHKY111 = new JSeparator();
			jSeparatorHKY111.setLocation(new Point(11, 138));
			jSeparatorHKY111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY111;
	}

	/**
	 * This method initializes jSeparatorHKY1111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1111() {
		if (jSeparatorHKY1111 == null) {
			jSeparatorHKY1111 = new JSeparator();
			jSeparatorHKY1111.setLocation(new Point(11, 138));
			jSeparatorHKY1111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY1111;
	}

	/**
	 * This method initializes jSeparatorHKY11111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY11111() {
		if (jSeparatorHKY11111 == null) {
			jSeparatorHKY11111 = new JSeparator();
			jSeparatorHKY11111.setLocation(new Point(11, 138));
			jSeparatorHKY11111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY11111;
	}

	/**
	 * This method initializes jSeparatorHKY12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY12() {
		if (jSeparatorHKY12 == null) {
			jSeparatorHKY12 = new JSeparator();
			jSeparatorHKY12.setLocation(new Point(10, 138));
			jSeparatorHKY12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY12.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY12;
	}

	/**
	 * This method initializes jSeparatorHKY121
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY121() {
		if (jSeparatorHKY121 == null) {
			jSeparatorHKY121 = new JSeparator();
			jSeparatorHKY121.setLocation(new Point(10, 138));
			jSeparatorHKY121.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY121.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY121;
	}

	/**
	 * This method initializes jSeparatorHKY1211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1211() {
		if (jSeparatorHKY1211 == null) {
			jSeparatorHKY1211 = new JSeparator();
			jSeparatorHKY1211.setLocation(new Point(10, 138));
			jSeparatorHKY1211.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY1211.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY1211;
	}

	/**
	 * This method initializes jSeparatorHKY12111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY12111() {
		if (jSeparatorHKY12111 == null) {
			jSeparatorHKY12111 = new JSeparator();
			jSeparatorHKY12111.setLocation(new Point(10, 138));
			jSeparatorHKY12111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY12111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY12111;
	}

	/**
	 * This method initializes jSeparatorHKY13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY13() {
		if (jSeparatorHKY13 == null) {
			jSeparatorHKY13 = new JSeparator();
			jSeparatorHKY13.setLocation(new Point(10, 178));
			jSeparatorHKY13.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY13;
	}

	/**
	 * This method initializes jSeparatorHKY131
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY131() {
		if (jSeparatorHKY131 == null) {
			jSeparatorHKY131 = new JSeparator();
			jSeparatorHKY131.setLocation(new Point(10, 178));
			jSeparatorHKY131.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY131;
	}

	/**
	 * This method initializes jSeparatorHKY1311
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1311() {
		if (jSeparatorHKY1311 == null) {
			jSeparatorHKY1311 = new JSeparator();
			jSeparatorHKY1311.setLocation(new Point(10, 178));
			jSeparatorHKY1311.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY1311;
	}

	/**
	 * This method initializes jSeparatorHKY13111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY13111() {
		if (jSeparatorHKY13111 == null) {
			jSeparatorHKY13111 = new JSeparator();
			jSeparatorHKY13111.setLocation(new Point(10, 178));
			jSeparatorHKY13111.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY13111;
	}

	/**
	 * This method initializes jSeparatorHKY14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY14() {
		if (jSeparatorHKY14 == null) {
			jSeparatorHKY14 = new JSeparator();
			jSeparatorHKY14.setLocation(new Point(601, 138));
			jSeparatorHKY14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY14.setSize(new Dimension(10, 41));
		}
		return jSeparatorHKY14;
	}

	/**
	 * This method initializes jSeparatorHKY141
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY141() {
		if (jSeparatorHKY141 == null) {
			jSeparatorHKY141 = new JSeparator();
			jSeparatorHKY141.setLocation(new Point(601, 138));
			jSeparatorHKY141.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY141.setSize(new Dimension(10, 41));
		}
		return jSeparatorHKY141;
	}

	/**
	 * This method initializes jSeparatorHKY1411
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1411() {
		if (jSeparatorHKY1411 == null) {
			jSeparatorHKY1411 = new JSeparator();
			jSeparatorHKY1411.setLocation(new Point(601, 138));
			jSeparatorHKY1411.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY1411.setSize(new Dimension(10, 41));
		}
		return jSeparatorHKY1411;
	}

	/**
	 * This method initializes jSeparatorHKY14111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY14111() {
		if (jSeparatorHKY14111 == null) {
			jSeparatorHKY14111 = new JSeparator();
			jSeparatorHKY14111.setLocation(new Point(601, 138));
			jSeparatorHKY14111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY14111.setSize(new Dimension(10, 41));
		}
		return jSeparatorHKY14111;
	}

	/**
	 * This method initializes jSeparatorHKY15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY15() {
		if (jSeparatorHKY15 == null) {
			jSeparatorHKY15 = new JSeparator();
			jSeparatorHKY15.setLocation(new Point(258, 138));
			jSeparatorHKY15.setSize(new Dimension(343, 10));
		}
		return jSeparatorHKY15;
	}

	/**
	 * This method initializes jSeparatorHKY151
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY151() {
		if (jSeparatorHKY151 == null) {
			jSeparatorHKY151 = new JSeparator();
			jSeparatorHKY151.setLocation(new Point(258, 138));
			jSeparatorHKY151.setSize(new Dimension(343, 10));
		}
		return jSeparatorHKY151;
	}

	/**
	 * This method initializes jSeparatorHKY1511
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1511() {
		if (jSeparatorHKY1511 == null) {
			jSeparatorHKY1511 = new JSeparator();
			jSeparatorHKY1511.setLocation(new Point(258, 138));
			jSeparatorHKY1511.setSize(new Dimension(343, 10));
		}
		return jSeparatorHKY1511;
	}

	/**
	 * This method initializes jSeparatorHKY15111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY15111() {
		if (jSeparatorHKY15111 == null) {
			jSeparatorHKY15111 = new JSeparator();
			jSeparatorHKY15111.setLocation(new Point(258, 138));
			jSeparatorHKY15111.setSize(new Dimension(343, 10));
		}
		return jSeparatorHKY15111;
	}

	/**
	 * This method initializes jSeparatorHKY16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY16() {
		if (jSeparatorHKY16 == null) {
			jSeparatorHKY16 = new JSeparator();
			jSeparatorHKY16.setLocation(new Point(11, 201));
			jSeparatorHKY16.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY16;
	}

	/**
	 * This method initializes jSeparatorHKY161
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY161() {
		if (jSeparatorHKY161 == null) {
			jSeparatorHKY161 = new JSeparator();
			jSeparatorHKY161.setLocation(new Point(11, 201));
			jSeparatorHKY161.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY161;
	}

	/**
	 * This method initializes jSeparatorHKY1611
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1611() {
		if (jSeparatorHKY1611 == null) {
			jSeparatorHKY1611 = new JSeparator();
			jSeparatorHKY1611.setLocation(new Point(11, 201));
			jSeparatorHKY1611.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY1611;
	}

	/**
	 * This method initializes jSeparatorHKY16111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY16111() {
		if (jSeparatorHKY16111 == null) {
			jSeparatorHKY16111 = new JSeparator();
			jSeparatorHKY16111.setLocation(new Point(11, 201));
			jSeparatorHKY16111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY16111;
	}

	/**
	 * This method initializes jSeparatorHKY17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY17() {
		if (jSeparatorHKY17 == null) {
			jSeparatorHKY17 = new JSeparator();
			jSeparatorHKY17.setLocation(new Point(10, 201));
			jSeparatorHKY17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY17.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY17;
	}

	/**
	 * This method initializes jSeparatorHKY171
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY171() {
		if (jSeparatorHKY171 == null) {
			jSeparatorHKY171 = new JSeparator();
			jSeparatorHKY171.setLocation(new Point(10, 201));
			jSeparatorHKY171.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY171.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY171;
	}

	/**
	 * This method initializes jSeparatorHKY1711
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1711() {
		if (jSeparatorHKY1711 == null) {
			jSeparatorHKY1711 = new JSeparator();
			jSeparatorHKY1711.setLocation(new Point(10, 201));
			jSeparatorHKY1711.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY1711.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY1711;
	}

	/**
	 * This method initializes jSeparatorHKY17111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY17111() {
		if (jSeparatorHKY17111 == null) {
			jSeparatorHKY17111 = new JSeparator();
			jSeparatorHKY17111.setLocation(new Point(10, 201));
			jSeparatorHKY17111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY17111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY17111;
	}

	/**
	 * This method initializes jSeparatorHKY18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY18() {
		if (jSeparatorHKY18 == null) {
			jSeparatorHKY18 = new JSeparator();
			jSeparatorHKY18.setLocation(new Point(10, 241));
			jSeparatorHKY18.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY18;
	}

	/**
	 * This method initializes jSeparatorHKY181
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY181() {
		if (jSeparatorHKY181 == null) {
			jSeparatorHKY181 = new JSeparator();
			jSeparatorHKY181.setLocation(new Point(10, 241));
			jSeparatorHKY181.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY181;
	}

	/**
	 * This method initializes jSeparatorHKY1811
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1811() {
		if (jSeparatorHKY1811 == null) {
			jSeparatorHKY1811 = new JSeparator();
			jSeparatorHKY1811.setLocation(new Point(10, 241));
			jSeparatorHKY1811.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY1811;
	}

	/**
	 * This method initializes jSeparatorHKY18111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY18111() {
		if (jSeparatorHKY18111 == null) {
			jSeparatorHKY18111 = new JSeparator();
			jSeparatorHKY18111.setLocation(new Point(10, 241));
			jSeparatorHKY18111.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY18111;
	}

	/**
	 * This method initializes jSeparatorHKY19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY19() {
		if (jSeparatorHKY19 == null) {
			jSeparatorHKY19 = new JSeparator();
			jSeparatorHKY19.setLocation(new Point(601, 202));
			jSeparatorHKY19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY19.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY19;
	}

	/**
	 * This method initializes jSeparatorHKY191
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY191() {
		if (jSeparatorHKY191 == null) {
			jSeparatorHKY191 = new JSeparator();
			jSeparatorHKY191.setLocation(new Point(601, 202));
			jSeparatorHKY191.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY191.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY191;
	}

	/**
	 * This method initializes jSeparatorHKY1911
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY1911() {
		if (jSeparatorHKY1911 == null) {
			jSeparatorHKY1911 = new JSeparator();
			jSeparatorHKY1911.setLocation(new Point(601, 202));
			jSeparatorHKY1911.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY1911.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY1911;
	}

	/**
	 * This method initializes jSeparatorHKY19111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY19111() {
		if (jSeparatorHKY19111 == null) {
			jSeparatorHKY19111 = new JSeparator();
			jSeparatorHKY19111.setLocation(new Point(601, 202));
			jSeparatorHKY19111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY19111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY19111;
	}

	/**
	 * This method initializes jSeparatorHKY20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY20() {
		if (jSeparatorHKY20 == null) {
			jSeparatorHKY20 = new JSeparator();
			jSeparatorHKY20.setLocation(new Point(341, 201));
			jSeparatorHKY20.setSize(new Dimension(261, 10));
		}
		return jSeparatorHKY20;
	}

	/**
	 * This method initializes jSeparatorHKY201
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY201() {
		if (jSeparatorHKY201 == null) {
			jSeparatorHKY201 = new JSeparator();
			jSeparatorHKY201.setLocation(new Point(341, 201));
			jSeparatorHKY201.setSize(new Dimension(261, 10));
		}
		return jSeparatorHKY201;
	}

	/**
	 * This method initializes jSeparatorHKY2011
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY2011() {
		if (jSeparatorHKY2011 == null) {
			jSeparatorHKY2011 = new JSeparator();
			jSeparatorHKY2011.setLocation(new Point(341, 201));
			jSeparatorHKY2011.setSize(new Dimension(261, 10));
		}
		return jSeparatorHKY2011;
	}

	/**
	 * This method initializes jSeparatorHKY20111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY20111() {
		if (jSeparatorHKY20111 == null) {
			jSeparatorHKY20111 = new JSeparator();
			jSeparatorHKY20111.setLocation(new Point(341, 201));
			jSeparatorHKY20111.setSize(new Dimension(261, 10));
		}
		return jSeparatorHKY20111;
	}

	/**
	 * This method initializes jSeparatorHKY21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY21() {
		if (jSeparatorHKY21 == null) {
			jSeparatorHKY21 = new JSeparator();
			jSeparatorHKY21.setLocation(new Point(11, 264));
			jSeparatorHKY21.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY21;
	}

	/**
	 * This method initializes jSeparatorHKY211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY211() {
		if (jSeparatorHKY211 == null) {
			jSeparatorHKY211 = new JSeparator();
			jSeparatorHKY211.setLocation(new Point(11, 264));
			jSeparatorHKY211.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY211;
	}

	/**
	 * This method initializes jSeparatorHKY2111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY2111() {
		if (jSeparatorHKY2111 == null) {
			jSeparatorHKY2111 = new JSeparator();
			jSeparatorHKY2111.setLocation(new Point(11, 264));
			jSeparatorHKY2111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY2111;
	}

	/**
	 * This method initializes jSeparatorHKY21111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY21111() {
		if (jSeparatorHKY21111 == null) {
			jSeparatorHKY21111 = new JSeparator();
			jSeparatorHKY21111.setLocation(new Point(11, 264));
			jSeparatorHKY21111.setSize(new Dimension(28, 10));
		}
		return jSeparatorHKY21111;
	}

	/**
	 * This method initializes jSeparatorHKY22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY22() {
		if (jSeparatorHKY22 == null) {
			jSeparatorHKY22 = new JSeparator();
			jSeparatorHKY22.setLocation(new Point(10, 264));
			jSeparatorHKY22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY22.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY22;
	}

	/**
	 * This method initializes jSeparatorHKY221
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY221() {
		if (jSeparatorHKY221 == null) {
			jSeparatorHKY221 = new JSeparator();
			jSeparatorHKY221.setLocation(new Point(10, 264));
			jSeparatorHKY221.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY221.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY221;
	}

	/**
	 * This method initializes jSeparatorHKY2211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY2211() {
		if (jSeparatorHKY2211 == null) {
			jSeparatorHKY2211 = new JSeparator();
			jSeparatorHKY2211.setLocation(new Point(10, 264));
			jSeparatorHKY2211.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY2211.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY2211;
	}

	/**
	 * This method initializes jSeparatorHKY22111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY22111() {
		if (jSeparatorHKY22111 == null) {
			jSeparatorHKY22111 = new JSeparator();
			jSeparatorHKY22111.setLocation(new Point(10, 264));
			jSeparatorHKY22111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY22111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY22111;
	}

	/**
	 * This method initializes jSeparatorHKY23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY23() {
		if (jSeparatorHKY23 == null) {
			jSeparatorHKY23 = new JSeparator();
			jSeparatorHKY23.setLocation(new Point(10, 304));
			jSeparatorHKY23.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY23;
	}

	/**
	 * This method initializes jSeparatorHKY231
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY231() {
		if (jSeparatorHKY231 == null) {
			jSeparatorHKY231 = new JSeparator();
			jSeparatorHKY231.setLocation(new Point(10, 304));
			jSeparatorHKY231.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY231;
	}

	/**
	 * This method initializes jSeparatorHKY2311
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY2311() {
		if (jSeparatorHKY2311 == null) {
			jSeparatorHKY2311 = new JSeparator();
			jSeparatorHKY2311.setLocation(new Point(10, 304));
			jSeparatorHKY2311.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY2311;
	}

	/**
	 * This method initializes jSeparatorHKY23111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY23111() {
		if (jSeparatorHKY23111 == null) {
			jSeparatorHKY23111 = new JSeparator();
			jSeparatorHKY23111.setLocation(new Point(10, 304));
			jSeparatorHKY23111.setSize(new Dimension(592, 10));
		}
		return jSeparatorHKY23111;
	}

	/**
	 * This method initializes jSeparatorHKY24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY24() {
		if (jSeparatorHKY24 == null) {
			jSeparatorHKY24 = new JSeparator();
			jSeparatorHKY24.setLocation(new Point(602, 264));
			jSeparatorHKY24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY24.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY24;
	}

	/**
	 * This method initializes jSeparatorHKY241
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY241() {
		if (jSeparatorHKY241 == null) {
			jSeparatorHKY241 = new JSeparator();
			jSeparatorHKY241.setLocation(new Point(602, 264));
			jSeparatorHKY241.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY241.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY241;
	}

	/**
	 * This method initializes jSeparatorHKY2411
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY2411() {
		if (jSeparatorHKY2411 == null) {
			jSeparatorHKY2411 = new JSeparator();
			jSeparatorHKY2411.setLocation(new Point(602, 264));
			jSeparatorHKY2411.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY2411.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY2411;
	}

	/**
	 * This method initializes jSeparatorHKY24111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY24111() {
		if (jSeparatorHKY24111 == null) {
			jSeparatorHKY24111 = new JSeparator();
			jSeparatorHKY24111.setLocation(new Point(602, 264));
			jSeparatorHKY24111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKY24111.setSize(new Dimension(10, 40));
		}
		return jSeparatorHKY24111;
	}

	/**
	 * This method initializes jSeparatorHKY25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY25() {
		if (jSeparatorHKY25 == null) {
			jSeparatorHKY25 = new JSeparator();
			jSeparatorHKY25.setBounds(new Rectangle(254, 264, 348, 10));
		}
		return jSeparatorHKY25;
	}

	/**
	 * This method initializes jSeparatorHKY251
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY251() {
		if (jSeparatorHKY251 == null) {
			jSeparatorHKY251 = new JSeparator();
			jSeparatorHKY251.setBounds(new Rectangle(254, 264, 348, 10));
		}
		return jSeparatorHKY251;
	}

	/**
	 * This method initializes jSeparatorHKY2511
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY2511() {
		if (jSeparatorHKY2511 == null) {
			jSeparatorHKY2511 = new JSeparator();
			jSeparatorHKY2511.setBounds(new Rectangle(254, 264, 348, 10));
		}
		return jSeparatorHKY2511;
	}

	/**
	 * This method initializes jSeparatorHKY25111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKY25111() {
		if (jSeparatorHKY25111 == null) {
			jSeparatorHKY25111 = new JSeparator();
			jSeparatorHKY25111.setBounds(new Rectangle(254, 264, 348, 10));
		}
		return jSeparatorHKY25111;
	}

	/**
	 * This method initializes jSeparatorHKYM1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1() {
		if (jSeparatorHKYM1 == null) {
			jSeparatorHKYM1 = new JSeparator();
			jSeparatorHKYM1.setLocation(new Point(339, 189));
			jSeparatorHKYM1.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM1;
	}

	/**
	 * This method initializes jSeparatorHKYM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM10() {
		if (jSeparatorHKYM10 == null) {
			jSeparatorHKYM10 = new JSeparator();
			jSeparatorHKYM10.setLocation(new Point(39, 212));
			jSeparatorHKYM10.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM10;
	}

	/**
	 * This method initializes jSeparatorHKYM101
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM101() {
		if (jSeparatorHKYM101 == null) {
			jSeparatorHKYM101 = new JSeparator();
			jSeparatorHKYM101.setLocation(new Point(39, 212));
			jSeparatorHKYM101.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM101;
	}

	/**
	 * This method initializes jSeparatorHKYM1011
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1011() {
		if (jSeparatorHKYM1011 == null) {
			jSeparatorHKYM1011 = new JSeparator();
			jSeparatorHKYM1011.setLocation(new Point(39, 212));
			jSeparatorHKYM1011.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM1011;
	}

	/**
	 * This method initializes jSeparatorHKYM10111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM10111() {
		if (jSeparatorHKYM10111 == null) {
			jSeparatorHKYM10111 = new JSeparator();
			jSeparatorHKYM10111.setLocation(new Point(39, 212));
			jSeparatorHKYM10111.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM10111;
	}

	/**
	 * This method initializes jSeparatorHKYM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM11() {
		if (jSeparatorHKYM11 == null) {
			jSeparatorHKYM11 = new JSeparator();
			jSeparatorHKYM11.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorHKYM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM11.setBackground(Color.white);
		}
		return jSeparatorHKYM11;
	}

	/**
	 * This method initializes jSeparatorHKYM110
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM110() {
		if (jSeparatorHKYM110 == null) {
			jSeparatorHKYM110 = new JSeparator();
			jSeparatorHKYM110.setLocation(new Point(339, 189));
			jSeparatorHKYM110.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM110.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM110;
	}

	/**
	 * This method initializes jSeparatorHKYM1101
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1101() {
		if (jSeparatorHKYM1101 == null) {
			jSeparatorHKYM1101 = new JSeparator();
			jSeparatorHKYM1101.setLocation(new Point(339, 189));
			jSeparatorHKYM1101.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1101.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM1101;
	}

	/**
	 * This method initializes jSeparatorHKYM11011
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM11011() {
		if (jSeparatorHKYM11011 == null) {
			jSeparatorHKYM11011 = new JSeparator();
			jSeparatorHKYM11011.setLocation(new Point(339, 189));
			jSeparatorHKYM11011.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM11011.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM11011;
	}

	/**
	 * This method initializes jSeparatorHKYM111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM111() {
		if (jSeparatorHKYM111 == null) {
			jSeparatorHKYM111 = new JSeparator();
			jSeparatorHKYM111.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorHKYM111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM111.setBackground(Color.white);
		}
		return jSeparatorHKYM111;
	}

	/**
	 * This method initializes jSeparatorHKYM1111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1111() {
		if (jSeparatorHKYM1111 == null) {
			jSeparatorHKYM1111 = new JSeparator();
			jSeparatorHKYM1111.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorHKYM1111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1111.setBackground(Color.white);
		}
		return jSeparatorHKYM1111;
	}

	/**
	 * This method initializes jSeparatorHKYM11111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM11111() {
		if (jSeparatorHKYM11111 == null) {
			jSeparatorHKYM11111 = new JSeparator();
			jSeparatorHKYM11111.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorHKYM11111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM11111.setBackground(Color.white);
		}
		return jSeparatorHKYM11111;
	}

	/**
	 * This method initializes jSeparatorHKYM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM12() {
		if (jSeparatorHKYM12 == null) {
			jSeparatorHKYM12 = new JSeparator();
			jSeparatorHKYM12.setLocation(new Point(39, 188));
			jSeparatorHKYM12.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM12;
	}

	/**
	 * This method initializes jSeparatorHKYM121
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM121() {
		if (jSeparatorHKYM121 == null) {
			jSeparatorHKYM121 = new JSeparator();
			jSeparatorHKYM121.setLocation(new Point(39, 188));
			jSeparatorHKYM121.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM121;
	}

	/**
	 * This method initializes jSeparatorHKYM1211
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1211() {
		if (jSeparatorHKYM1211 == null) {
			jSeparatorHKYM1211 = new JSeparator();
			jSeparatorHKYM1211.setLocation(new Point(39, 188));
			jSeparatorHKYM1211.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM1211;
	}

	/**
	 * This method initializes jSeparatorHKYM12111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM12111() {
		if (jSeparatorHKYM12111 == null) {
			jSeparatorHKYM12111 = new JSeparator();
			jSeparatorHKYM12111.setLocation(new Point(39, 188));
			jSeparatorHKYM12111.setSize(new Dimension(301, 10));
		}
		return jSeparatorHKYM12111;
	}

	/**
	 * This method initializes jSeparatorHKYM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM13() {
		if (jSeparatorHKYM13 == null) {
			jSeparatorHKYM13 = new JSeparator();
			jSeparatorHKYM13.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorHKYM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM13.setBackground(Color.white);
		}
		return jSeparatorHKYM13;
	}

	/**
	 * This method initializes jSeparatorHKYM131
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM131() {
		if (jSeparatorHKYM131 == null) {
			jSeparatorHKYM131 = new JSeparator();
			jSeparatorHKYM131.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorHKYM131.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM131.setBackground(Color.white);
		}
		return jSeparatorHKYM131;
	}

	/**
	 * This method initializes jSeparatorHKYM1311
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1311() {
		if (jSeparatorHKYM1311 == null) {
			jSeparatorHKYM1311 = new JSeparator();
			jSeparatorHKYM1311.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorHKYM1311.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1311.setBackground(Color.white);
		}
		return jSeparatorHKYM1311;
	}

	/**
	 * This method initializes jSeparatorHKYM13111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM13111() {
		if (jSeparatorHKYM13111 == null) {
			jSeparatorHKYM13111 = new JSeparator();
			jSeparatorHKYM13111.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorHKYM13111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM13111.setBackground(Color.white);
		}
		return jSeparatorHKYM13111;
	}

	/**
	 * This method initializes jSeparatorHKYM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM14() {
		if (jSeparatorHKYM14 == null) {
			jSeparatorHKYM14 = new JSeparator();
			jSeparatorHKYM14.setLocation(new Point(39, 150));
			jSeparatorHKYM14.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM14;
	}

	/**
	 * This method initializes jSeparatorHKYM141
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM141() {
		if (jSeparatorHKYM141 == null) {
			jSeparatorHKYM141 = new JSeparator();
			jSeparatorHKYM141.setLocation(new Point(39, 150));
			jSeparatorHKYM141.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM141;
	}

	/**
	 * This method initializes jSeparatorHKYM1411
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1411() {
		if (jSeparatorHKYM1411 == null) {
			jSeparatorHKYM1411 = new JSeparator();
			jSeparatorHKYM1411.setLocation(new Point(39, 150));
			jSeparatorHKYM1411.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM1411;
	}

	/**
	 * This method initializes jSeparatorHKYM14111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM14111() {
		if (jSeparatorHKYM14111 == null) {
			jSeparatorHKYM14111 = new JSeparator();
			jSeparatorHKYM14111.setLocation(new Point(39, 150));
			jSeparatorHKYM14111.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM14111;
	}

	/**
	 * This method initializes jSeparatorHKYM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM15() {
		if (jSeparatorHKYM15 == null) {
			jSeparatorHKYM15 = new JSeparator();
			jSeparatorHKYM15.setLocation(new Point(257, 128));
			jSeparatorHKYM15.setBackground(Color.white);
			jSeparatorHKYM15.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM15.setSize(new Dimension(10, 22));
		}
		return jSeparatorHKYM15;
	}

	/**
	 * This method initializes jSeparatorHKYM151
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM151() {
		if (jSeparatorHKYM151 == null) {
			jSeparatorHKYM151 = new JSeparator();
			jSeparatorHKYM151.setLocation(new Point(257, 128));
			jSeparatorHKYM151.setBackground(Color.white);
			jSeparatorHKYM151.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM151.setSize(new Dimension(10, 22));
		}
		return jSeparatorHKYM151;
	}

	/**
	 * This method initializes jSeparatorHKYM1511
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1511() {
		if (jSeparatorHKYM1511 == null) {
			jSeparatorHKYM1511 = new JSeparator();
			jSeparatorHKYM1511.setLocation(new Point(257, 128));
			jSeparatorHKYM1511.setBackground(Color.white);
			jSeparatorHKYM1511.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1511.setSize(new Dimension(10, 22));
		}
		return jSeparatorHKYM1511;
	}

	/**
	 * This method initializes jSeparatorHKYM15111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM15111() {
		if (jSeparatorHKYM15111 == null) {
			jSeparatorHKYM15111 = new JSeparator();
			jSeparatorHKYM15111.setLocation(new Point(257, 128));
			jSeparatorHKYM15111.setBackground(Color.white);
			jSeparatorHKYM15111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM15111.setSize(new Dimension(10, 22));
		}
		return jSeparatorHKYM15111;
	}

	/**
	 * This method initializes jSeparatorHKYM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM16() {
		if (jSeparatorHKYM16 == null) {
			jSeparatorHKYM16 = new JSeparator();
			jSeparatorHKYM16.setBounds(new Rectangle(39, 127, 218, 10));
		}
		return jSeparatorHKYM16;
	}

	/**
	 * This method initializes jSeparatorHKYM161
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM161() {
		if (jSeparatorHKYM161 == null) {
			jSeparatorHKYM161 = new JSeparator();
			jSeparatorHKYM161.setBounds(new Rectangle(39, 127, 218, 10));
		}
		return jSeparatorHKYM161;
	}

	/**
	 * This method initializes jSeparatorHKYM1611
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1611() {
		if (jSeparatorHKYM1611 == null) {
			jSeparatorHKYM1611 = new JSeparator();
			jSeparatorHKYM1611.setBounds(new Rectangle(39, 127, 218, 10));
		}
		return jSeparatorHKYM1611;
	}

	/**
	 * This method initializes jSeparatorHKYM16111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM16111() {
		if (jSeparatorHKYM16111 == null) {
			jSeparatorHKYM16111 = new JSeparator();
			jSeparatorHKYM16111.setBounds(new Rectangle(39, 127, 218, 10));
		}
		return jSeparatorHKYM16111;
	}

	/**
	 * This method initializes jSeparatorHKYM17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM17() {
		if (jSeparatorHKYM17 == null) {
			jSeparatorHKYM17 = new JSeparator();
			jSeparatorHKYM17.setLocation(new Point(39, 254));
			jSeparatorHKYM17.setBackground(Color.white);
			jSeparatorHKYM17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM17.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM17;
	}

	/**
	 * This method initializes jSeparatorHKYM171
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM171() {
		if (jSeparatorHKYM171 == null) {
			jSeparatorHKYM171 = new JSeparator();
			jSeparatorHKYM171.setLocation(new Point(39, 254));
			jSeparatorHKYM171.setBackground(Color.white);
			jSeparatorHKYM171.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM171.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM171;
	}

	/**
	 * This method initializes jSeparatorHKYM1711
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1711() {
		if (jSeparatorHKYM1711 == null) {
			jSeparatorHKYM1711 = new JSeparator();
			jSeparatorHKYM1711.setLocation(new Point(39, 254));
			jSeparatorHKYM1711.setBackground(Color.white);
			jSeparatorHKYM1711.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1711.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM1711;
	}

	/**
	 * This method initializes jSeparatorHKYM17111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM17111() {
		if (jSeparatorHKYM17111 == null) {
			jSeparatorHKYM17111 = new JSeparator();
			jSeparatorHKYM17111.setLocation(new Point(39, 254));
			jSeparatorHKYM17111.setBackground(Color.white);
			jSeparatorHKYM17111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM17111.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM17111;
	}

	/**
	 * This method initializes jSeparatorHKYM18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM18() {
		if (jSeparatorHKYM18 == null) {
			jSeparatorHKYM18 = new JSeparator();
			jSeparatorHKYM18.setLocation(new Point(253, 254));
			jSeparatorHKYM18.setBackground(Color.white);
			jSeparatorHKYM18.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM18.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM18;
	}

	/**
	 * This method initializes jSeparatorHKYM181
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM181() {
		if (jSeparatorHKYM181 == null) {
			jSeparatorHKYM181 = new JSeparator();
			jSeparatorHKYM181.setLocation(new Point(253, 254));
			jSeparatorHKYM181.setBackground(Color.white);
			jSeparatorHKYM181.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM181.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM181;
	}

	/**
	 * This method initializes jSeparatorHKYM1811
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1811() {
		if (jSeparatorHKYM1811 == null) {
			jSeparatorHKYM1811 = new JSeparator();
			jSeparatorHKYM1811.setLocation(new Point(253, 254));
			jSeparatorHKYM1811.setBackground(Color.white);
			jSeparatorHKYM1811.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM1811.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM1811;
	}

	/**
	 * This method initializes jSeparatorHKYM18111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM18111() {
		if (jSeparatorHKYM18111 == null) {
			jSeparatorHKYM18111 = new JSeparator();
			jSeparatorHKYM18111.setLocation(new Point(253, 254));
			jSeparatorHKYM18111.setBackground(Color.white);
			jSeparatorHKYM18111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM18111.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM18111;
	}

	/**
	 * This method initializes jSeparatorHKYM19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM19() {
		if (jSeparatorHKYM19 == null) {
			jSeparatorHKYM19 = new JSeparator();
			jSeparatorHKYM19.setLocation(new Point(39, 277));
			jSeparatorHKYM19.setSize(new Dimension(215, 10));
		}
		return jSeparatorHKYM19;
	}

	/**
	 * This method initializes jSeparatorHKYM191
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM191() {
		if (jSeparatorHKYM191 == null) {
			jSeparatorHKYM191 = new JSeparator();
			jSeparatorHKYM191.setLocation(new Point(39, 277));
			jSeparatorHKYM191.setSize(new Dimension(215, 10));
		}
		return jSeparatorHKYM191;
	}

	/**
	 * This method initializes jSeparatorHKYM1911
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM1911() {
		if (jSeparatorHKYM1911 == null) {
			jSeparatorHKYM1911 = new JSeparator();
			jSeparatorHKYM1911.setLocation(new Point(39, 277));
			jSeparatorHKYM1911.setSize(new Dimension(215, 10));
		}
		return jSeparatorHKYM1911;
	}

	/**
	 * This method initializes jSeparatorHKYM19111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM19111() {
		if (jSeparatorHKYM19111 == null) {
			jSeparatorHKYM19111 = new JSeparator();
			jSeparatorHKYM19111.setLocation(new Point(39, 277));
			jSeparatorHKYM19111.setSize(new Dimension(215, 10));
		}
		return jSeparatorHKYM19111;
	}

	/**
	 * This method initializes jSeparatorHKYM20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM20() {
		if (jSeparatorHKYM20 == null) {
			jSeparatorHKYM20 = new JSeparator();
			jSeparatorHKYM20.setBounds(new Rectangle(39, 253, 215, 10));
		}
		return jSeparatorHKYM20;
	}

	/**
	 * This method initializes jSeparatorHKYM201
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM201() {
		if (jSeparatorHKYM201 == null) {
			jSeparatorHKYM201 = new JSeparator();
			jSeparatorHKYM201.setBounds(new Rectangle(39, 253, 215, 10));
		}
		return jSeparatorHKYM201;
	}

	/**
	 * This method initializes jSeparatorHKYM2011
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM2011() {
		if (jSeparatorHKYM2011 == null) {
			jSeparatorHKYM2011 = new JSeparator();
			jSeparatorHKYM2011.setBounds(new Rectangle(39, 253, 215, 10));
		}
		return jSeparatorHKYM2011;
	}

	/**
	 * This method initializes jSeparatorHKYM20111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM20111() {
		if (jSeparatorHKYM20111 == null) {
			jSeparatorHKYM20111 = new JSeparator();
			jSeparatorHKYM20111.setBounds(new Rectangle(39, 253, 215, 10));
		}
		return jSeparatorHKYM20111;
	}

	/**
	 * This method initializes jSeparatorHKYM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM3() {
		if (jSeparatorHKYM3 == null) {
			jSeparatorHKYM3 = new JSeparator();
			jSeparatorHKYM3.setLocation(new Point(215, 3));
			jSeparatorHKYM3.setBackground(Color.white);
			jSeparatorHKYM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM3.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM3;
	}

	/**
	 * This method initializes jSeparatorHKYM31
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM31() {
		if (jSeparatorHKYM31 == null) {
			jSeparatorHKYM31 = new JSeparator();
			jSeparatorHKYM31.setLocation(new Point(215, 3));
			jSeparatorHKYM31.setBackground(Color.white);
			jSeparatorHKYM31.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM31.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM31;
	}

	/**
	 * This method initializes jSeparatorHKYM311
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM311() {
		if (jSeparatorHKYM311 == null) {
			jSeparatorHKYM311 = new JSeparator();
			jSeparatorHKYM311.setLocation(new Point(215, 3));
			jSeparatorHKYM311.setBackground(Color.white);
			jSeparatorHKYM311.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM311.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM311;
	}

	/**
	 * This method initializes jSeparatorHKYM3111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM3111() {
		if (jSeparatorHKYM3111 == null) {
			jSeparatorHKYM3111 = new JSeparator();
			jSeparatorHKYM3111.setLocation(new Point(215, 3));
			jSeparatorHKYM3111.setBackground(Color.white);
			jSeparatorHKYM3111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM3111.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM3111;
	}

	/**
	 * This method initializes jSeparatorHKYM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM4() {
		if (jSeparatorHKYM4 == null) {
			jSeparatorHKYM4 = new JSeparator();
			jSeparatorHKYM4.setLocation(new Point(39, 2));
			jSeparatorHKYM4.setBackground(Color.white);
			jSeparatorHKYM4.setSize(new Dimension(176, 10));
		}
		return jSeparatorHKYM4;
	}

	/**
	 * This method initializes jSeparatorHKYM41
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM41() {
		if (jSeparatorHKYM41 == null) {
			jSeparatorHKYM41 = new JSeparator();
			jSeparatorHKYM41.setLocation(new Point(39, 2));
			jSeparatorHKYM41.setBackground(Color.white);
			jSeparatorHKYM41.setSize(new Dimension(176, 10));
		}
		return jSeparatorHKYM41;
	}

	/**
	 * This method initializes jSeparatorHKYM411
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM411() {
		if (jSeparatorHKYM411 == null) {
			jSeparatorHKYM411 = new JSeparator();
			jSeparatorHKYM411.setLocation(new Point(39, 2));
			jSeparatorHKYM411.setBackground(Color.white);
			jSeparatorHKYM411.setSize(new Dimension(176, 10));
		}
		return jSeparatorHKYM411;
	}

	/**
	 * This method initializes jSeparatorHKYM4111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM4111() {
		if (jSeparatorHKYM4111 == null) {
			jSeparatorHKYM4111 = new JSeparator();
			jSeparatorHKYM4111.setLocation(new Point(39, 2));
			jSeparatorHKYM4111.setBackground(Color.white);
			jSeparatorHKYM4111.setSize(new Dimension(176, 10));
		}
		return jSeparatorHKYM4111;
	}

	/**
	 * This method initializes jSeparatorHKYM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM5() {
		if (jSeparatorHKYM5 == null) {
			jSeparatorHKYM5 = new JSeparator();
			jSeparatorHKYM5.setLocation(new Point(38, 63));
			jSeparatorHKYM5.setBackground(Color.white);
			jSeparatorHKYM5.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM5.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM5;
	}

	/**
	 * This method initializes jSeparatorHKYM51
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM51() {
		if (jSeparatorHKYM51 == null) {
			jSeparatorHKYM51 = new JSeparator();
			jSeparatorHKYM51.setLocation(new Point(38, 63));
			jSeparatorHKYM51.setBackground(Color.white);
			jSeparatorHKYM51.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM51.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM51;
	}

	/**
	 * This method initializes jSeparatorHKYM511
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM511() {
		if (jSeparatorHKYM511 == null) {
			jSeparatorHKYM511 = new JSeparator();
			jSeparatorHKYM511.setLocation(new Point(38, 63));
			jSeparatorHKYM511.setBackground(Color.white);
			jSeparatorHKYM511.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM511.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM511;
	}

	/**
	 * This method initializes jSeparatorHKYM5111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM5111() {
		if (jSeparatorHKYM5111 == null) {
			jSeparatorHKYM5111 = new JSeparator();
			jSeparatorHKYM5111.setLocation(new Point(38, 63));
			jSeparatorHKYM5111.setBackground(Color.white);
			jSeparatorHKYM5111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM5111.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM5111;
	}

	/**
	 * This method initializes jSeparatorHKYM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM6() {
		if (jSeparatorHKYM6 == null) {
			jSeparatorHKYM6 = new JSeparator();
			jSeparatorHKYM6.setLocation(new Point(38, 89));
			jSeparatorHKYM6.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM6;
	}

	/**
	 * This method initializes jSeparatorHKYM61
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM61() {
		if (jSeparatorHKYM61 == null) {
			jSeparatorHKYM61 = new JSeparator();
			jSeparatorHKYM61.setLocation(new Point(38, 89));
			jSeparatorHKYM61.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM61;
	}

	/**
	 * This method initializes jSeparatorHKYM611
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM611() {
		if (jSeparatorHKYM611 == null) {
			jSeparatorHKYM611 = new JSeparator();
			jSeparatorHKYM611.setLocation(new Point(38, 89));
			jSeparatorHKYM611.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM611;
	}

	/**
	 * This method initializes jSeparatorHKYM6111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM6111() {
		if (jSeparatorHKYM6111 == null) {
			jSeparatorHKYM6111 = new JSeparator();
			jSeparatorHKYM6111.setLocation(new Point(38, 89));
			jSeparatorHKYM6111.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM6111;
	}

	/**
	 * This method initializes jSeparatorHKYM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM7() {
		if (jSeparatorHKYM7 == null) {
			jSeparatorHKYM7 = new JSeparator();
			jSeparatorHKYM7.setLocation(new Point(255, 63));
			jSeparatorHKYM7.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM7.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM7;
	}

	/**
	 * This method initializes jSeparatorHKYM71
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM71() {
		if (jSeparatorHKYM71 == null) {
			jSeparatorHKYM71 = new JSeparator();
			jSeparatorHKYM71.setLocation(new Point(255, 63));
			jSeparatorHKYM71.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM71.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM71;
	}

	/**
	 * This method initializes jSeparatorHKYM711
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM711() {
		if (jSeparatorHKYM711 == null) {
			jSeparatorHKYM711 = new JSeparator();
			jSeparatorHKYM711.setLocation(new Point(255, 63));
			jSeparatorHKYM711.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM711.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM711;
	}

	/**
	 * This method initializes jSeparatorHKYM7111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM7111() {
		if (jSeparatorHKYM7111 == null) {
			jSeparatorHKYM7111 = new JSeparator();
			jSeparatorHKYM7111.setLocation(new Point(255, 63));
			jSeparatorHKYM7111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM7111.setSize(new Dimension(10, 26));
		}
		return jSeparatorHKYM7111;
	}

	/**
	 * This method initializes jSeparatorHKYM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM8() {
		if (jSeparatorHKYM8 == null) {
			jSeparatorHKYM8 = new JSeparator();
			jSeparatorHKYM8.setLocation(new Point(38, 62));
			jSeparatorHKYM8.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM8;
	}

	/**
	 * This method initializes jSeparatorHKYM81
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM81() {
		if (jSeparatorHKYM81 == null) {
			jSeparatorHKYM81 = new JSeparator();
			jSeparatorHKYM81.setLocation(new Point(38, 62));
			jSeparatorHKYM81.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM81;
	}

	/**
	 * This method initializes jSeparatorHKYM811
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM811() {
		if (jSeparatorHKYM811 == null) {
			jSeparatorHKYM811 = new JSeparator();
			jSeparatorHKYM811.setLocation(new Point(38, 62));
			jSeparatorHKYM811.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM811;
	}

	/**
	 * This method initializes jSeparatorHKYM8111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM8111() {
		if (jSeparatorHKYM8111 == null) {
			jSeparatorHKYM8111 = new JSeparator();
			jSeparatorHKYM8111.setLocation(new Point(38, 62));
			jSeparatorHKYM8111.setSize(new Dimension(218, 10));
		}
		return jSeparatorHKYM8111;
	}

	/**
	 * This method initializes jSeparatorHKYM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM9() {
		if (jSeparatorHKYM9 == null) {
			jSeparatorHKYM9 = new JSeparator();
			jSeparatorHKYM9.setLocation(new Point(39, 189));
			jSeparatorHKYM9.setBackground(Color.white);
			jSeparatorHKYM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM9.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM9;
	}

	/**
	 * This method initializes jSeparatorHKYM91
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM91() {
		if (jSeparatorHKYM91 == null) {
			jSeparatorHKYM91 = new JSeparator();
			jSeparatorHKYM91.setLocation(new Point(39, 189));
			jSeparatorHKYM91.setBackground(Color.white);
			jSeparatorHKYM91.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM91.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM91;
	}

	/**
	 * This method initializes jSeparatorHKYM911
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM911() {
		if (jSeparatorHKYM911 == null) {
			jSeparatorHKYM911 = new JSeparator();
			jSeparatorHKYM911.setLocation(new Point(39, 189));
			jSeparatorHKYM911.setBackground(Color.white);
			jSeparatorHKYM911.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM911.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM911;
	}

	/**
	 * This method initializes jSeparatorHKYM9111
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHKYM9111() {
		if (jSeparatorHKYM9111 == null) {
			jSeparatorHKYM9111 = new JSeparator();
			jSeparatorHKYM9111.setLocation(new Point(39, 189));
			jSeparatorHKYM9111.setBackground(Color.white);
			jSeparatorHKYM9111.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHKYM9111.setSize(new Dimension(10, 23));
		}
		return jSeparatorHKYM9111;
	}

	/**
	 * This method initializes jSeparatorHM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorHM13() {
		if (jSeparatorHM13 == null) {
			jSeparatorHM13 = new JSeparator();
			jSeparatorHM13.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorHM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorHM13.setBackground(Color.white);
		}
		return jSeparatorHM13;
	}

	/**
	 * This method initializes jSeparatorJTT01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT01() {
		if (jSeparatorJTT01 == null) {
			jSeparatorJTT01 = new JSeparator();
			jSeparatorJTT01.setLocation(new Point(11, 12));
			jSeparatorJTT01.setSize(new Dimension(28, 10));
		}
		return jSeparatorJTT01;
	}

	/**
	 * This method initializes jSeparatorJTT02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT02() {
		if (jSeparatorJTT02 == null) {
			jSeparatorJTT02 = new JSeparator();
			jSeparatorJTT02.setLocation(new Point(10, 12));
			jSeparatorJTT02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT02.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT02;
	}

	/**
	 * This method initializes jSeparatorJTT03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT03() {
		if (jSeparatorJTT03 == null) {
			jSeparatorJTT03 = new JSeparator();
			jSeparatorJTT03.setLocation(new Point(10, 52));
			jSeparatorJTT03.setSize(new Dimension(591, 10));
		}
		return jSeparatorJTT03;
	}

	/**
	 * This method initializes jSeparatorJTT04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT04() {
		if (jSeparatorJTT04 == null) {
			jSeparatorJTT04 = new JSeparator();
			jSeparatorJTT04.setLocation(new Point(601, 13));
			jSeparatorJTT04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT04.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT04;
	}

	/**
	 * This method initializes jSeparatorJTT05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT05() {
		if (jSeparatorJTT05 == null) {
			jSeparatorJTT05 = new JSeparator();
			jSeparatorJTT05.setLocation(new Point(209, 12));
			jSeparatorJTT05.setSize(new Dimension(393, 10));
		}
		return jSeparatorJTT05;
	}

	/**
	 * This method initializes jSeparatorJTT11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT11() {
		if (jSeparatorJTT11 == null) {
			jSeparatorJTT11 = new JSeparator();
			jSeparatorJTT11.setLocation(new Point(11, 91));
			jSeparatorJTT11.setSize(new Dimension(28, 10));
		}
		return jSeparatorJTT11;
	}

	/**
	 * This method initializes jSeparatorJTT12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT12() {
		if (jSeparatorJTT12 == null) {
			jSeparatorJTT12 = new JSeparator();
			jSeparatorJTT12.setLocation(new Point(10, 91));
			jSeparatorJTT12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT12.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT12;
	}

	/**
	 * This method initializes jSeparatorJTT13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT13() {
		if (jSeparatorJTT13 == null) {
			jSeparatorJTT13 = new JSeparator();
			jSeparatorJTT13.setLocation(new Point(10, 131));
			jSeparatorJTT13.setSize(new Dimension(592, 10));
		}
		return jSeparatorJTT13;
	}

	/**
	 * This method initializes jSeparatorJTT14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT14() {
		if (jSeparatorJTT14 == null) {
			jSeparatorJTT14 = new JSeparator();
			jSeparatorJTT14.setLocation(new Point(601, 91));
			jSeparatorJTT14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT14.setSize(new Dimension(10, 41));
		}
		return jSeparatorJTT14;
	}

	/**
	 * This method initializes jSeparatorJTT15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT15() {
		if (jSeparatorJTT15 == null) {
			jSeparatorJTT15 = new JSeparator();
			jSeparatorJTT15.setLocation(new Point(256, 91));
			jSeparatorJTT15.setSize(new Dimension(346, 10));
		}
		return jSeparatorJTT15;
	}

	/**
	 * This method initializes jSeparatorJTT16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT16() {
		if (jSeparatorJTT16 == null) {
			jSeparatorJTT16 = new JSeparator();
			jSeparatorJTT16.setLocation(new Point(11, 171));
			jSeparatorJTT16.setSize(new Dimension(28, 10));
		}
		return jSeparatorJTT16;
	}

	/**
	 * This method initializes jSeparatorJTT17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT17() {
		if (jSeparatorJTT17 == null) {
			jSeparatorJTT17 = new JSeparator();
			jSeparatorJTT17.setLocation(new Point(10, 171));
			jSeparatorJTT17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT17.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT17;
	}

	/**
	 * This method initializes jSeparatorJTT18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT18() {
		if (jSeparatorJTT18 == null) {
			jSeparatorJTT18 = new JSeparator();
			jSeparatorJTT18.setLocation(new Point(10, 211));
			jSeparatorJTT18.setSize(new Dimension(592, 10));
		}
		return jSeparatorJTT18;
	}

	/**
	 * This method initializes jSeparatorJTT19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT19() {
		if (jSeparatorJTT19 == null) {
			jSeparatorJTT19 = new JSeparator();
			jSeparatorJTT19.setLocation(new Point(601, 171));
			jSeparatorJTT19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT19.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT19;
	}

	/**
	 * This method initializes jSeparatorJTT20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT20() {
		if (jSeparatorJTT20 == null) {
			jSeparatorJTT20 = new JSeparator();
			jSeparatorJTT20.setLocation(new Point(341, 170));
			jSeparatorJTT20.setSize(new Dimension(260, 10));
		}
		return jSeparatorJTT20;
	}

	/**
	 * This method initializes jSeparatorJTT21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT21() {
		if (jSeparatorJTT21 == null) {
			jSeparatorJTT21 = new JSeparator();
			jSeparatorJTT21.setLocation(new Point(11, 250));
			jSeparatorJTT21.setSize(new Dimension(28, 10));
		}
		return jSeparatorJTT21;
	}

	/**
	 * This method initializes jSeparatorJTT22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT22() {
		if (jSeparatorJTT22 == null) {
			jSeparatorJTT22 = new JSeparator();
			jSeparatorJTT22.setLocation(new Point(10, 250));
			jSeparatorJTT22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT22.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT22;
	}

	/**
	 * This method initializes jSeparatorJTT23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT23() {
		if (jSeparatorJTT23 == null) {
			jSeparatorJTT23 = new JSeparator();
			jSeparatorJTT23.setLocation(new Point(10, 290));
			jSeparatorJTT23.setSize(new Dimension(592, 10));
		}
		return jSeparatorJTT23;
	}

	/**
	 * This method initializes jSeparatorJTT24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT24() {
		if (jSeparatorJTT24 == null) {
			jSeparatorJTT24 = new JSeparator();
			jSeparatorJTT24.setLocation(new Point(602, 250));
			jSeparatorJTT24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTT24.setSize(new Dimension(10, 40));
		}
		return jSeparatorJTT24;
	}

	/**
	 * This method initializes jSeparatorJTT25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTT25() {
		if (jSeparatorJTT25 == null) {
			jSeparatorJTT25 = new JSeparator();
			jSeparatorJTT25.setLocation(new Point(258, 250));
			jSeparatorJTT25.setSize(new Dimension(346, 10));
		}
		return jSeparatorJTT25;
	}

	/**
	 * This method initializes jSeparatorJTTM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM10() {
		if (jSeparatorJTTM10 == null) {
			jSeparatorJTTM10 = new JSeparator();
			jSeparatorJTTM10.setLocation(new Point(39, 185));
			jSeparatorJTTM10.setSize(new Dimension(300, 10));
		}
		return jSeparatorJTTM10;
	}

	/**
	 * This method initializes jSeparatorJTTM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM11() {
		if (jSeparatorJTTM11 == null) {
			jSeparatorJTTM11 = new JSeparator();
			jSeparatorJTTM11.setLocation(new Point(339, 159));
			jSeparatorJTTM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTTM11.setSize(new Dimension(10, 26));
		}
		return jSeparatorJTTM11;
	}

	/**
	 * This method initializes jSeparatorJTTM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM12() {
		if (jSeparatorJTTM12 == null) {
			jSeparatorJTTM12 = new JSeparator();
			jSeparatorJTTM12.setLocation(new Point(39, 158));
			jSeparatorJTTM12.setSize(new Dimension(300, 10));
		}
		return jSeparatorJTTM12;
	}

	/**
	 * This method initializes jSeparatorJTTM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM13() {
		if (jSeparatorJTTM13 == null) {
			jSeparatorJTTM13 = new JSeparator();
			jSeparatorJTTM13.setLocation(new Point(39, 238));
			jSeparatorJTTM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTTM13.setSize(new Dimension(10, 26));
		}
		return jSeparatorJTTM13;
	}

	/**
	 * This method initializes jSeparatorJTTM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM14() {
		if (jSeparatorJTTM14 == null) {
			jSeparatorJTTM14 = new JSeparator();
			jSeparatorJTTM14.setLocation(new Point(256, 238));
			jSeparatorJTTM14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTTM14.setSize(new Dimension(10, 26));
		}
		return jSeparatorJTTM14;
	}

	/**
	 * This method initializes jSeparatorJTTM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM15() {
		if (jSeparatorJTTM15 == null) {
			jSeparatorJTTM15 = new JSeparator();
			jSeparatorJTTM15.setLocation(new Point(39, 264));
			jSeparatorJTTM15.setSize(new Dimension(218, 10));
		}
		return jSeparatorJTTM15;
	}

	/**
	 * This method initializes jSeparatorJTTM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM16() {
		if (jSeparatorJTTM16 == null) {
			jSeparatorJTTM16 = new JSeparator();
			jSeparatorJTTM16.setLocation(new Point(39, 237));
			jSeparatorJTTM16.setSize(new Dimension(218, 10));
		}
		return jSeparatorJTTM16;
	}

	/**
	 * This method initializes jSeparatorJTTM2
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM2() {
		if (jSeparatorJTTM2 == null) {
			jSeparatorJTTM2 = new JSeparator();
			jSeparatorJTTM2.setLocation(new Point(39, 28));
			jSeparatorJTTM2.setSize(new Dimension(168, 10));
		}
		return jSeparatorJTTM2;
	}

	/**
	 * This method initializes jSeparatorJTTM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM3() {
		if (jSeparatorJTTM3 == null) {
			jSeparatorJTTM3 = new JSeparator();
			jSeparatorJTTM3.setLocation(new Point(207, 3));
			jSeparatorJTTM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTTM3.setSize(new Dimension(10, 25));
		}
		return jSeparatorJTTM3;
	}

	/**
	 * This method initializes jSeparatorJTTM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM4() {
		if (jSeparatorJTTM4 == null) {
			jSeparatorJTTM4 = new JSeparator();
			jSeparatorJTTM4.setLocation(new Point(39, 1));
			jSeparatorJTTM4.setSize(new Dimension(168, 8));
		}
		return jSeparatorJTTM4;
	}

	/**
	 * This method initializes jSeparatorJTTM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM5() {
		if (jSeparatorJTTM5 == null) {
			jSeparatorJTTM5 = new JSeparator();
			jSeparatorJTTM5.setBounds(new Rectangle(39, 79, 10, 26));
			jSeparatorJTTM5.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorJTTM5;
	}

	/**
	 * This method initializes jSeparatorJTTM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM6() {
		if (jSeparatorJTTM6 == null) {
			jSeparatorJTTM6 = new JSeparator();
			jSeparatorJTTM6.setLocation(new Point(254, 79));
			jSeparatorJTTM6.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTTM6.setSize(new Dimension(10, 26));
		}
		return jSeparatorJTTM6;
	}

	/**
	 * This method initializes jSeparatorJTTM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM7() {
		if (jSeparatorJTTM7 == null) {
			jSeparatorJTTM7 = new JSeparator();
			jSeparatorJTTM7.setBounds(new Rectangle(40, 105, 215, 10));
		}
		return jSeparatorJTTM7;
	}

	/**
	 * This method initializes jSeparatorJTTM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM8() {
		if (jSeparatorJTTM8 == null) {
			jSeparatorJTTM8 = new JSeparator();
			jSeparatorJTTM8.setLocation(new Point(40, 78));
			jSeparatorJTTM8.setSize(new Dimension(214, 10));
		}
		return jSeparatorJTTM8;
	}

	/**
	 * This method initializes jSeparatorJTTM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorJTTM9() {
		if (jSeparatorJTTM9 == null) {
			jSeparatorJTTM9 = new JSeparator();
			jSeparatorJTTM9.setLocation(new Point(39, 159));
			jSeparatorJTTM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorJTTM9.setSize(new Dimension(10, 26));
		}
		return jSeparatorJTTM9;
	}

	/**
	 * This method initializes jSeparatorK2P01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P01() {
		if (jSeparatorK2P01 == null) {
			jSeparatorK2P01 = new JSeparator();
			jSeparatorK2P01.setLocation(new Point(11, 12));
			jSeparatorK2P01.setBackground(Color.white);
			jSeparatorK2P01.setSize(new Dimension(28, 10));
		}
		return jSeparatorK2P01;
	}

	/**
	 * This method initializes jSeparatorK2P02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P02() {
		if (jSeparatorK2P02 == null) {
			jSeparatorK2P02 = new JSeparator();
			jSeparatorK2P02.setLocation(new Point(10, 12));
			jSeparatorK2P02.setBackground(Color.white);
			jSeparatorK2P02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P02.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P02;
	}

	/**
	 * This method initializes jSeparatorK2P03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P03() {
		if (jSeparatorK2P03 == null) {
			jSeparatorK2P03 = new JSeparator();
			jSeparatorK2P03.setLocation(new Point(10, 52));
			jSeparatorK2P03.setBackground(Color.white);
			jSeparatorK2P03.setSize(new Dimension(591, 10));
		}
		return jSeparatorK2P03;
	}

	/**
	 * This method initializes jSeparatorK2P04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P04() {
		if (jSeparatorK2P04 == null) {
			jSeparatorK2P04 = new JSeparator();
			jSeparatorK2P04.setLocation(new Point(601, 13));
			jSeparatorK2P04.setBackground(Color.white);
			jSeparatorK2P04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P04.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P04;
	}

	/**
	 * This method initializes jSeparatorK2P05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P05() {
		if (jSeparatorK2P05 == null) {
			jSeparatorK2P05 = new JSeparator();
			jSeparatorK2P05.setLocation(new Point(218, 12));
			jSeparatorK2P05.setBackground(Color.white);
			jSeparatorK2P05.setSize(new Dimension(384, 10));
		}
		return jSeparatorK2P05;
	}

	/**
	 * This method initializes jSeparatorK2P06
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P06() {
		if (jSeparatorK2P06 == null) {
			jSeparatorK2P06 = new JSeparator();
			jSeparatorK2P06.setLocation(new Point(11, 75));
			jSeparatorK2P06.setSize(new Dimension(28, 10));
		}
		return jSeparatorK2P06;
	}

	/**
	 * This method initializes jSeparatorK2P07
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P07() {
		if (jSeparatorK2P07 == null) {
			jSeparatorK2P07 = new JSeparator();
			jSeparatorK2P07.setLocation(new Point(10, 75));
			jSeparatorK2P07.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P07.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P07;
	}

	/**
	 * This method initializes jSeparatorK2P08
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P08() {
		if (jSeparatorK2P08 == null) {
			jSeparatorK2P08 = new JSeparator();
			jSeparatorK2P08.setLocation(new Point(10, 115));
			jSeparatorK2P08.setSize(new Dimension(592, 10));
		}
		return jSeparatorK2P08;
	}

	/**
	 * This method initializes jSeparatorK2P09
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P09() {
		if (jSeparatorK2P09 == null) {
			jSeparatorK2P09 = new JSeparator();
			jSeparatorK2P09.setLocation(new Point(601, 75));
			jSeparatorK2P09.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P09.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P09;
	}

	/**
	 * This method initializes jSeparatorK2P10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P10() {
		if (jSeparatorK2P10 == null) {
			jSeparatorK2P10 = new JSeparator();
			jSeparatorK2P10.setLocation(new Point(252, 75));
			jSeparatorK2P10.setSize(new Dimension(351, 10));
		}
		return jSeparatorK2P10;
	}

	/**
	 * This method initializes jSeparatorK2P11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P11() {
		if (jSeparatorK2P11 == null) {
			jSeparatorK2P11 = new JSeparator();
			jSeparatorK2P11.setLocation(new Point(11, 138));
			jSeparatorK2P11.setSize(new Dimension(28, 10));
		}
		return jSeparatorK2P11;
	}

	/**
	 * This method initializes jSeparatorK2P12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P12() {
		if (jSeparatorK2P12 == null) {
			jSeparatorK2P12 = new JSeparator();
			jSeparatorK2P12.setLocation(new Point(10, 138));
			jSeparatorK2P12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P12.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P12;
	}

	/**
	 * This method initializes jSeparatorK2P13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P13() {
		if (jSeparatorK2P13 == null) {
			jSeparatorK2P13 = new JSeparator();
			jSeparatorK2P13.setLocation(new Point(10, 178));
			jSeparatorK2P13.setSize(new Dimension(592, 10));
		}
		return jSeparatorK2P13;
	}

	/**
	 * This method initializes jSeparatorK2P14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P14() {
		if (jSeparatorK2P14 == null) {
			jSeparatorK2P14 = new JSeparator();
			jSeparatorK2P14.setLocation(new Point(601, 138));
			jSeparatorK2P14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P14.setSize(new Dimension(10, 41));
		}
		return jSeparatorK2P14;
	}

	/**
	 * This method initializes jSeparatorK2P15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P15() {
		if (jSeparatorK2P15 == null) {
			jSeparatorK2P15 = new JSeparator();
			jSeparatorK2P15.setLocation(new Point(254, 138));
			jSeparatorK2P15.setSize(new Dimension(348, 10));
		}
		return jSeparatorK2P15;
	}

	/**
	 * This method initializes jSeparatorK2P16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P16() {
		if (jSeparatorK2P16 == null) {
			jSeparatorK2P16 = new JSeparator();
			jSeparatorK2P16.setLocation(new Point(11, 201));
			jSeparatorK2P16.setSize(new Dimension(28, 10));
		}
		return jSeparatorK2P16;
	}

	/**
	 * This method initializes jSeparatorK2P17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P17() {
		if (jSeparatorK2P17 == null) {
			jSeparatorK2P17 = new JSeparator();
			jSeparatorK2P17.setLocation(new Point(10, 201));
			jSeparatorK2P17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P17.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P17;
	}

	/**
	 * This method initializes jSeparatorK2P18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P18() {
		if (jSeparatorK2P18 == null) {
			jSeparatorK2P18 = new JSeparator();
			jSeparatorK2P18.setLocation(new Point(10, 241));
			jSeparatorK2P18.setSize(new Dimension(592, 10));
		}
		return jSeparatorK2P18;
	}

	/**
	 * This method initializes jSeparatorK2P19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P19() {
		if (jSeparatorK2P19 == null) {
			jSeparatorK2P19 = new JSeparator();
			jSeparatorK2P19.setLocation(new Point(601, 202));
			jSeparatorK2P19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P19.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P19;
	}

	/**
	 * This method initializes jSeparatorK2P20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P20() {
		if (jSeparatorK2P20 == null) {
			jSeparatorK2P20 = new JSeparator();
			jSeparatorK2P20.setLocation(new Point(341, 201));
			jSeparatorK2P20.setSize(new Dimension(261, 10));
		}
		return jSeparatorK2P20;
	}

	/**
	 * This method initializes jSeparatorK2P21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P21() {
		if (jSeparatorK2P21 == null) {
			jSeparatorK2P21 = new JSeparator();
			jSeparatorK2P21.setLocation(new Point(11, 264));
			jSeparatorK2P21.setSize(new Dimension(28, 10));
		}
		return jSeparatorK2P21;
	}

	/**
	 * This method initializes jSeparatorK2P22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P22() {
		if (jSeparatorK2P22 == null) {
			jSeparatorK2P22 = new JSeparator();
			jSeparatorK2P22.setLocation(new Point(10, 264));
			jSeparatorK2P22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P22.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P22;
	}

	/**
	 * This method initializes jSeparatorK2P23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P23() {
		if (jSeparatorK2P23 == null) {
			jSeparatorK2P23 = new JSeparator();
			jSeparatorK2P23.setLocation(new Point(10, 304));
			jSeparatorK2P23.setSize(new Dimension(592, 10));
		}
		return jSeparatorK2P23;
	}

	/**
	 * This method initializes jSeparatorK2P24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P24() {
		if (jSeparatorK2P24 == null) {
			jSeparatorK2P24 = new JSeparator();
			jSeparatorK2P24.setLocation(new Point(602, 264));
			jSeparatorK2P24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2P24.setSize(new Dimension(10, 40));
		}
		return jSeparatorK2P24;
	}

	/**
	 * This method initializes jSeparatorK2P25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2P25() {
		if (jSeparatorK2P25 == null) {
			jSeparatorK2P25 = new JSeparator();
			jSeparatorK2P25.setBounds(new Rectangle(250, 264, 353, 10));
		}
		return jSeparatorK2P25;
	}

	/**
	 * This method initializes jSeparatorK2PM1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM1() {
		if (jSeparatorK2PM1 == null) {
			jSeparatorK2PM1 = new JSeparator();
			jSeparatorK2PM1.setLocation(new Point(339, 189));
			jSeparatorK2PM1.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM1.setSize(new Dimension(10, 23));
		}
		return jSeparatorK2PM1;
	}

	/**
	 * This method initializes jSeparatorK2PM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM10() {
		if (jSeparatorK2PM10 == null) {
			jSeparatorK2PM10 = new JSeparator();
			jSeparatorK2PM10.setLocation(new Point(39, 212));
			jSeparatorK2PM10.setSize(new Dimension(301, 10));
		}
		return jSeparatorK2PM10;
	}

	/**
	 * This method initializes jSeparatorK2PM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM11() {
		if (jSeparatorK2PM11 == null) {
			jSeparatorK2PM11 = new JSeparator();
			jSeparatorK2PM11.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorK2PM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM11.setBackground(Color.white);
		}
		return jSeparatorK2PM11;
	}

	/**
	 * This method initializes jSeparatorK2PM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM12() {
		if (jSeparatorK2PM12 == null) {
			jSeparatorK2PM12 = new JSeparator();
			jSeparatorK2PM12.setLocation(new Point(39, 188));
			jSeparatorK2PM12.setSize(new Dimension(300, 10));
		}
		return jSeparatorK2PM12;
	}

	/**
	 * This method initializes jSeparatorK2PM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM14() {
		if (jSeparatorK2PM14 == null) {
			jSeparatorK2PM14 = new JSeparator();
			jSeparatorK2PM14.setLocation(new Point(39, 150));
			jSeparatorK2PM14.setSize(new Dimension(215, 10));
		}
		return jSeparatorK2PM14;
	}

	/**
	 * This method initializes jSeparatorK2PM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM15() {
		if (jSeparatorK2PM15 == null) {
			jSeparatorK2PM15 = new JSeparator();
			jSeparatorK2PM15.setLocation(new Point(254, 129));
			jSeparatorK2PM15.setBackground(Color.white);
			jSeparatorK2PM15.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM15.setSize(new Dimension(10, 22));
		}
		return jSeparatorK2PM15;
	}

	/**
	 * This method initializes jSeparatorK2PM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM16() {
		if (jSeparatorK2PM16 == null) {
			jSeparatorK2PM16 = new JSeparator();
			jSeparatorK2PM16.setBounds(new Rectangle(39, 127, 215, 10));
		}
		return jSeparatorK2PM16;
	}

	/**
	 * This method initializes jSeparatorK2PM17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM17() {
		if (jSeparatorK2PM17 == null) {
			jSeparatorK2PM17 = new JSeparator();
			jSeparatorK2PM17.setLocation(new Point(39, 254));
			jSeparatorK2PM17.setBackground(Color.white);
			jSeparatorK2PM17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM17.setSize(new Dimension(10, 23));
		}
		return jSeparatorK2PM17;
	}

	/**
	 * This method initializes jSeparatorK2PM18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM18() {
		if (jSeparatorK2PM18 == null) {
			jSeparatorK2PM18 = new JSeparator();
			jSeparatorK2PM18.setLocation(new Point(250, 255));
			jSeparatorK2PM18.setBackground(Color.white);
			jSeparatorK2PM18.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM18.setSize(new Dimension(10, 23));
		}
		return jSeparatorK2PM18;
	}

	/**
	 * This method initializes jSeparatorK2PM19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM19() {
		if (jSeparatorK2PM19 == null) {
			jSeparatorK2PM19 = new JSeparator();
			jSeparatorK2PM19.setLocation(new Point(39, 277));
			jSeparatorK2PM19.setSize(new Dimension(212, 10));
		}
		return jSeparatorK2PM19;
	}

	/**
	 * This method initializes jSeparatorK2PM2
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM2() {
		if (jSeparatorK2PM2 == null) {
			jSeparatorK2PM2 = new JSeparator();
			jSeparatorK2PM2.setBounds(new Rectangle(39, 26, 178, 10));
			jSeparatorK2PM2.setPreferredSize(new Dimension(0, 2));
			jSeparatorK2PM2.setBackground(Color.white);
		}
		return jSeparatorK2PM2;
	}

	/**
	 * This method initializes jSeparatorK2PM20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM20() {
		if (jSeparatorK2PM20 == null) {
			jSeparatorK2PM20 = new JSeparator();
			jSeparatorK2PM20.setBounds(new Rectangle(39, 253, 212, 10));
		}
		return jSeparatorK2PM20;
	}

	/**
	 * This method initializes jSeparatorK2PM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM3() {
		if (jSeparatorK2PM3 == null) {
			jSeparatorK2PM3 = new JSeparator();
			jSeparatorK2PM3.setLocation(new Point(217, 3));
			jSeparatorK2PM3.setBackground(Color.white);
			jSeparatorK2PM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM3.setSize(new Dimension(10, 23));
		}
		return jSeparatorK2PM3;
	}

	/**
	 * This method initializes jSeparatorK2PM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM4() {
		if (jSeparatorK2PM4 == null) {
			jSeparatorK2PM4 = new JSeparator();
			jSeparatorK2PM4.setLocation(new Point(39, 2));
			jSeparatorK2PM4.setBackground(Color.white);
			jSeparatorK2PM4.setSize(new Dimension(178, 10));
		}
		return jSeparatorK2PM4;
	}

	/**
	 * This method initializes jSeparatorK2PM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM5() {
		if (jSeparatorK2PM5 == null) {
			jSeparatorK2PM5 = new JSeparator();
			jSeparatorK2PM5.setLocation(new Point(38, 63));
			jSeparatorK2PM5.setBackground(Color.white);
			jSeparatorK2PM5.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM5.setSize(new Dimension(10, 26));
		}
		return jSeparatorK2PM5;
	}

	/**
	 * This method initializes jSeparatorK2PM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM6() {
		if (jSeparatorK2PM6 == null) {
			jSeparatorK2PM6 = new JSeparator();
			jSeparatorK2PM6.setLocation(new Point(38, 89));
			jSeparatorK2PM6.setSize(new Dimension(215, 10));
		}
		return jSeparatorK2PM6;
	}

	/**
	 * This method initializes jSeparatorK2PM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM8() {
		if (jSeparatorK2PM8 == null) {
			jSeparatorK2PM8 = new JSeparator();
			jSeparatorK2PM8.setLocation(new Point(38, 62));
			jSeparatorK2PM8.setSize(new Dimension(215, 10));
		}
		return jSeparatorK2PM8;
	}

	/**
	 * This method initializes jSeparatorK2PM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorK2PM9() {
		if (jSeparatorK2PM9 == null) {
			jSeparatorK2PM9 = new JSeparator();
			jSeparatorK2PM9.setLocation(new Point(39, 189));
			jSeparatorK2PM9.setBackground(Color.white);
			jSeparatorK2PM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorK2PM9.setSize(new Dimension(10, 23));
		}
		return jSeparatorK2PM9;
	}

	/**
	 * This method initializes jSeparatorM17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorM17() {
		if (jSeparatorM17 == null) {
			jSeparatorM17 = new JSeparator();
			jSeparatorM17.setLocation(new Point(39, 254));
			jSeparatorM17.setBackground(Color.white);
			jSeparatorM17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorM17.setSize(new Dimension(10, 23));
		}
		return jSeparatorM17;
	}

	/**
	 * This method initializes jSeparatorM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorM7() {
		if (jSeparatorM7 == null) {
			jSeparatorM7 = new JSeparator();
			jSeparatorM7.setLocation(new Point(252, 64));
			jSeparatorM7.setOrientation(SwingConstants.VERTICAL);
			jSeparatorM7.setSize(new Dimension(10, 26));
		}
		return jSeparatorM7;
	}

	/**
	 * This method initializes jSeparatorMtREV01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV01() {
		if (jSeparatorMtREV01 == null) {
			jSeparatorMtREV01 = new JSeparator();
			jSeparatorMtREV01.setLocation(new Point(11, 12));
			jSeparatorMtREV01.setSize(new Dimension(28, 10));
		}
		return jSeparatorMtREV01;
	}

	/**
	 * This method initializes jSeparatorMtREV02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV02() {
		if (jSeparatorMtREV02 == null) {
			jSeparatorMtREV02 = new JSeparator();
			jSeparatorMtREV02.setLocation(new Point(10, 12));
			jSeparatorMtREV02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV02.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV02;
	}

	/**
	 * This method initializes jSeparatorMtREV03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV03() {
		if (jSeparatorMtREV03 == null) {
			jSeparatorMtREV03 = new JSeparator();
			jSeparatorMtREV03.setLocation(new Point(10, 52));
			jSeparatorMtREV03.setSize(new Dimension(591, 10));
		}
		return jSeparatorMtREV03;
	}

	/**
	 * This method initializes jSeparatorMtREV04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV04() {
		if (jSeparatorMtREV04 == null) {
			jSeparatorMtREV04 = new JSeparator();
			jSeparatorMtREV04.setLocation(new Point(601, 13));
			jSeparatorMtREV04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV04.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV04;
	}

	/**
	 * This method initializes jSeparatorMtREV05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV05() {
		if (jSeparatorMtREV05 == null) {
			jSeparatorMtREV05 = new JSeparator();
			jSeparatorMtREV05.setLocation(new Point(224, 12));
			jSeparatorMtREV05.setSize(new Dimension(378, 10));
		}
		return jSeparatorMtREV05;
	}

	/**
	 * This method initializes jSeparatorMtREV1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV1() {
		if (jSeparatorMtREV1 == null) {
			jSeparatorMtREV1 = new JSeparator();
			jSeparatorMtREV1.setBounds(new Rectangle(39, 2, 10, 26));
			jSeparatorMtREV1.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorMtREV1;
	}

	/**
	 * This method initializes jSeparatorMtREV11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV11() {
		if (jSeparatorMtREV11 == null) {
			jSeparatorMtREV11 = new JSeparator();
			jSeparatorMtREV11.setLocation(new Point(11, 91));
			jSeparatorMtREV11.setSize(new Dimension(28, 10));
		}
		return jSeparatorMtREV11;
	}

	/**
	 * This method initializes jSeparatorMtREV12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV12() {
		if (jSeparatorMtREV12 == null) {
			jSeparatorMtREV12 = new JSeparator();
			jSeparatorMtREV12.setLocation(new Point(10, 91));
			jSeparatorMtREV12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV12.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV12;
	}

	/**
	 * This method initializes jSeparatorMtREV13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV13() {
		if (jSeparatorMtREV13 == null) {
			jSeparatorMtREV13 = new JSeparator();
			jSeparatorMtREV13.setLocation(new Point(10, 131));
			jSeparatorMtREV13.setSize(new Dimension(592, 10));
		}
		return jSeparatorMtREV13;
	}

	/**
	 * This method initializes jSeparatorMtREV14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV14() {
		if (jSeparatorMtREV14 == null) {
			jSeparatorMtREV14 = new JSeparator();
			jSeparatorMtREV14.setLocation(new Point(601, 91));
			jSeparatorMtREV14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV14.setSize(new Dimension(10, 41));
		}
		return jSeparatorMtREV14;
	}

	/**
	 * This method initializes jSeparatorMtREV15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV15() {
		if (jSeparatorMtREV15 == null) {
			jSeparatorMtREV15 = new JSeparator();
			jSeparatorMtREV15.setLocation(new Point(253, 91));
			jSeparatorMtREV15.setSize(new Dimension(349, 10));
		}
		return jSeparatorMtREV15;
	}

	/**
	 * This method initializes jSeparatorMtREV16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV16() {
		if (jSeparatorMtREV16 == null) {
			jSeparatorMtREV16 = new JSeparator();
			jSeparatorMtREV16.setLocation(new Point(11, 171));
			jSeparatorMtREV16.setSize(new Dimension(28, 10));
		}
		return jSeparatorMtREV16;
	}

	/**
	 * This method initializes jSeparatorMtREV17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV17() {
		if (jSeparatorMtREV17 == null) {
			jSeparatorMtREV17 = new JSeparator();
			jSeparatorMtREV17.setLocation(new Point(10, 171));
			jSeparatorMtREV17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV17.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV17;
	}

	/**
	 * This method initializes jSeparatorMtREV18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV18() {
		if (jSeparatorMtREV18 == null) {
			jSeparatorMtREV18 = new JSeparator();
			jSeparatorMtREV18.setLocation(new Point(10, 211));
			jSeparatorMtREV18.setSize(new Dimension(592, 10));
		}
		return jSeparatorMtREV18;
	}

	/**
	 * This method initializes jSeparatorMtREV19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV19() {
		if (jSeparatorMtREV19 == null) {
			jSeparatorMtREV19 = new JSeparator();
			jSeparatorMtREV19.setLocation(new Point(601, 171));
			jSeparatorMtREV19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV19.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV19;
	}

	/**
	 * This method initializes jSeparatorMtREV20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV20() {
		if (jSeparatorMtREV20 == null) {
			jSeparatorMtREV20 = new JSeparator();
			jSeparatorMtREV20.setLocation(new Point(341, 170));
			jSeparatorMtREV20.setSize(new Dimension(261, 10));
		}
		return jSeparatorMtREV20;
	}

	/**
	 * This method initializes jSeparatorMtREV22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV22() {
		if (jSeparatorMtREV22 == null) {
			jSeparatorMtREV22 = new JSeparator();
			jSeparatorMtREV22.setLocation(new Point(10, 250));
			jSeparatorMtREV22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV22.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV22;
	}

	/**
	 * This method initializes jSeparatorMtREV23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV23() {
		if (jSeparatorMtREV23 == null) {
			jSeparatorMtREV23 = new JSeparator();
			jSeparatorMtREV23.setLocation(new Point(10, 290));
			jSeparatorMtREV23.setSize(new Dimension(592, 10));
		}
		return jSeparatorMtREV23;
	}

	/**
	 * This method initializes jSeparatorMtREV24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV24() {
		if (jSeparatorMtREV24 == null) {
			jSeparatorMtREV24 = new JSeparator();
			jSeparatorMtREV24.setLocation(new Point(602, 250));
			jSeparatorMtREV24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREV24.setSize(new Dimension(10, 40));
		}
		return jSeparatorMtREV24;
	}

	/**
	 * This method initializes jSeparatorMtREV25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREV25() {
		if (jSeparatorMtREV25 == null) {
			jSeparatorMtREV25 = new JSeparator();
			jSeparatorMtREV25.setLocation(new Point(252, 250));
			jSeparatorMtREV25.setSize(new Dimension(352, 10));
		}
		return jSeparatorMtREV25;
	}

	/**
	 * This method initializes jSeparatorMtREVM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM10() {
		if (jSeparatorMtREVM10 == null) {
			jSeparatorMtREVM10 = new JSeparator();
			jSeparatorMtREVM10.setLocation(new Point(39, 185));
			jSeparatorMtREVM10.setSize(new Dimension(301, 10));
		}
		return jSeparatorMtREVM10;
	}

	/**
	 * This method initializes jSeparatorMtREVM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM11() {
		if (jSeparatorMtREVM11 == null) {
			jSeparatorMtREVM11 = new JSeparator();
			jSeparatorMtREVM11.setLocation(new Point(339, 159));
			jSeparatorMtREVM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREVM11.setSize(new Dimension(10, 26));
		}
		return jSeparatorMtREVM11;
	}

	/**
	 * This method initializes jSeparatorMtREVM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM12() {
		if (jSeparatorMtREVM12 == null) {
			jSeparatorMtREVM12 = new JSeparator();
			jSeparatorMtREVM12.setLocation(new Point(39, 158));
			jSeparatorMtREVM12.setSize(new Dimension(301, 10));
		}
		return jSeparatorMtREVM12;
	}

	/**
	 * This method initializes jSeparatorMtREVM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM13() {
		if (jSeparatorMtREVM13 == null) {
			jSeparatorMtREVM13 = new JSeparator();
			jSeparatorMtREVM13.setLocation(new Point(39, 238));
			jSeparatorMtREVM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREVM13.setSize(new Dimension(10, 26));
		}
		return jSeparatorMtREVM13;
	}

	/**
	 * This method initializes jSeparatorMtREVM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM14() {
		if (jSeparatorMtREVM14 == null) {
			jSeparatorMtREVM14 = new JSeparator();
			jSeparatorMtREVM14.setLocation(new Point(250, 238));
			jSeparatorMtREVM14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREVM14.setSize(new Dimension(10, 26));
		}
		return jSeparatorMtREVM14;
	}

	/**
	 * This method initializes jSeparatorMtREVM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM15() {
		if (jSeparatorMtREVM15 == null) {
			jSeparatorMtREVM15 = new JSeparator();
			jSeparatorMtREVM15.setLocation(new Point(39, 264));
			jSeparatorMtREVM15.setSize(new Dimension(211, 10));
		}
		return jSeparatorMtREVM15;
	}

	/**
	 * This method initializes jSeparatorMtREVM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM16() {
		if (jSeparatorMtREVM16 == null) {
			jSeparatorMtREVM16 = new JSeparator();
			jSeparatorMtREVM16.setLocation(new Point(39, 237));
			jSeparatorMtREVM16.setSize(new Dimension(212, 10));
		}
		return jSeparatorMtREVM16;
	}

	/**
	 * This method initializes jSeparatorMtREVM21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM21() {
		if (jSeparatorMtREVM21 == null) {
			jSeparatorMtREVM21 = new JSeparator();
			jSeparatorMtREVM21.setLocation(new Point(39, 28));
			jSeparatorMtREVM21.setSize(new Dimension(185, 10));
		}
		return jSeparatorMtREVM21;
	}

	/**
	 * This method initializes jSeparatorMtREVM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM3() {
		if (jSeparatorMtREVM3 == null) {
			jSeparatorMtREVM3 = new JSeparator();
			jSeparatorMtREVM3.setLocation(new Point(223, 3));
			jSeparatorMtREVM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREVM3.setSize(new Dimension(10, 25));
		}
		return jSeparatorMtREVM3;
	}

	/**
	 * This method initializes jSeparatorMtREVM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM4() {
		if (jSeparatorMtREVM4 == null) {
			jSeparatorMtREVM4 = new JSeparator();
			jSeparatorMtREVM4.setLocation(new Point(39, 1));
			jSeparatorMtREVM4.setSize(new Dimension(185, 8));
		}
		return jSeparatorMtREVM4;
	}

	/**
	 * This method initializes jSeparatorMtREVM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM5() {
		if (jSeparatorMtREVM5 == null) {
			jSeparatorMtREVM5 = new JSeparator();
			jSeparatorMtREVM5.setBounds(new Rectangle(39, 79, 10, 26));
			jSeparatorMtREVM5.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorMtREVM5;
	}

	/**
	 * This method initializes jSeparatorMtREVM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM6() {
		if (jSeparatorMtREVM6 == null) {
			jSeparatorMtREVM6 = new JSeparator();
			jSeparatorMtREVM6.setLocation(new Point(248, 79));
			jSeparatorMtREVM6.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREVM6.setSize(new Dimension(10, 26));
		}
		return jSeparatorMtREVM6;
	}

	/**
	 * This method initializes jSeparatorMtREVM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM7() {
		if (jSeparatorMtREVM7 == null) {
			jSeparatorMtREVM7 = new JSeparator();
			jSeparatorMtREVM7.setBounds(new Rectangle(40, 105, 209, 10));
		}
		return jSeparatorMtREVM7;
	}

	/**
	 * This method initializes jSeparatorMtREVM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM8() {
		if (jSeparatorMtREVM8 == null) {
			jSeparatorMtREVM8 = new JSeparator();
			jSeparatorMtREVM8.setLocation(new Point(40, 78));
			jSeparatorMtREVM8.setSize(new Dimension(209, 10));
		}
		return jSeparatorMtREVM8;
	}

	/**
	 * This method initializes jSeparatorMtREVM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorMtREVM9() {
		if (jSeparatorMtREVM9 == null) {
			jSeparatorMtREVM9 = new JSeparator();
			jSeparatorMtREVM9.setLocation(new Point(39, 159));
			jSeparatorMtREVM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorMtREVM9.setSize(new Dimension(10, 26));
		}
		return jSeparatorMtREVM9;
	}

	/**
	 * This method initializes jSeparatorS0
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS0() {
		if (jSeparatorS0 == null) {
			jSeparatorS0 = new JSeparator();
			jSeparatorS0.setSize(new Dimension(79, 10));
			jSeparatorS0.setLocation(new Point(87, 27));
		}
		return jSeparatorS0;
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
	 * This method initializes jSeparatorS10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorS10() {
		if (jSeparatorS10 == null) {
			jSeparatorS10 = new JSeparator();
			jSeparatorS10.setSize(new Dimension(113, 10));
			jSeparatorS10.setLocation(new Point(86, 176));
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
			jSeparatorS11.setLocation(new Point(86, 199));
			jSeparatorS11.setSize(new Dimension(113, 10));
		}
		return jSeparatorS11;
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
			jSeparatorS2.setSize(new Dimension(80, 10));
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
			jSeparatorS3.setLocation(new Point(166, 28));
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
			jSeparatorS4.setLocation(new Point(86, 102));
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
			jSeparatorS5.setLocation(new Point(185, 102));
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
			jSeparatorS6.setBounds(new Rectangle(86, 101, 100, 10));
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
			jSeparatorS7.setBounds(new Rectangle(86, 124, 99, 10));
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
			jSeparatorS8.setLocation(new Point(86, 177));
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
			jSeparatorS9.setLocation(new Point(198, 177));
		}
		return jSeparatorS9;
	}

	/**
	 * This method initializes jSeparatorTN9301
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9301() {
		if (jSeparatorTN9301 == null) {
			jSeparatorTN9301 = new JSeparator();
			jSeparatorTN9301.setLocation(new Point(11, 12));
			jSeparatorTN9301.setBackground(Color.white);
			jSeparatorTN9301.setSize(new Dimension(28, 10));
		}
		return jSeparatorTN9301;
	}

	/**
	 * This method initializes jSeparatorTN9302
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9302() {
		if (jSeparatorTN9302 == null) {
			jSeparatorTN9302 = new JSeparator();
			jSeparatorTN9302.setLocation(new Point(10, 12));
			jSeparatorTN9302.setBackground(Color.white);
			jSeparatorTN9302.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9302.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9302;
	}

	/**
	 * This method initializes jSeparatorTN9303
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9303() {
		if (jSeparatorTN9303 == null) {
			jSeparatorTN9303 = new JSeparator();
			jSeparatorTN9303.setLocation(new Point(10, 52));
			jSeparatorTN9303.setBackground(Color.white);
			jSeparatorTN9303.setSize(new Dimension(591, 10));
		}
		return jSeparatorTN9303;
	}

	/**
	 * This method initializes jSeparatorTN9304
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9304() {
		if (jSeparatorTN9304 == null) {
			jSeparatorTN9304 = new JSeparator();
			jSeparatorTN9304.setLocation(new Point(601, 13));
			jSeparatorTN9304.setBackground(Color.white);
			jSeparatorTN9304.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9304.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9304;
	}

	/**
	 * This method initializes jSeparatorTN9305
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9305() {
		if (jSeparatorTN9305 == null) {
			jSeparatorTN9305 = new JSeparator();
			jSeparatorTN9305.setLocation(new Point(216, 12));
			jSeparatorTN9305.setBackground(Color.white);
			jSeparatorTN9305.setSize(new Dimension(386, 10));
		}
		return jSeparatorTN9305;
	}

	/**
	 * This method initializes jSeparatorTN9306
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9306() {
		if (jSeparatorTN9306 == null) {
			jSeparatorTN9306 = new JSeparator();
			jSeparatorTN9306.setLocation(new Point(11, 75));
			jSeparatorTN9306.setSize(new Dimension(28, 10));
		}
		return jSeparatorTN9306;
	}

	/**
	 * This method initializes jSeparatorTN9307
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9307() {
		if (jSeparatorTN9307 == null) {
			jSeparatorTN9307 = new JSeparator();
			jSeparatorTN9307.setLocation(new Point(10, 75));
			jSeparatorTN9307.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9307.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9307;
	}

	/**
	 * This method initializes jSeparatorTN9308
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9308() {
		if (jSeparatorTN9308 == null) {
			jSeparatorTN9308 = new JSeparator();
			jSeparatorTN9308.setLocation(new Point(10, 115));
			jSeparatorTN9308.setSize(new Dimension(592, 10));
		}
		return jSeparatorTN9308;
	}

	/**
	 * This method initializes jSeparatorTN9309
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9309() {
		if (jSeparatorTN9309 == null) {
			jSeparatorTN9309 = new JSeparator();
			jSeparatorTN9309.setLocation(new Point(601, 75));
			jSeparatorTN9309.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9309.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9309;
	}

	/**
	 * This method initializes jSeparatorTN9310
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9310() {
		if (jSeparatorTN9310 == null) {
			jSeparatorTN9310 = new JSeparator();
			jSeparatorTN9310.setLocation(new Point(256, 75));
			jSeparatorTN9310.setSize(new Dimension(347, 10));
		}
		return jSeparatorTN9310;
	}

	/**
	 * This method initializes jSeparatorTN9311
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9311() {
		if (jSeparatorTN9311 == null) {
			jSeparatorTN9311 = new JSeparator();
			jSeparatorTN9311.setLocation(new Point(11, 138));
			jSeparatorTN9311.setSize(new Dimension(28, 10));
		}
		return jSeparatorTN9311;
	}

	/**
	 * This method initializes jSeparatorTN9312
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9312() {
		if (jSeparatorTN9312 == null) {
			jSeparatorTN9312 = new JSeparator();
			jSeparatorTN9312.setLocation(new Point(10, 138));
			jSeparatorTN9312.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9312.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9312;
	}

	/**
	 * This method initializes jSeparatorTN9313
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9313() {
		if (jSeparatorTN9313 == null) {
			jSeparatorTN9313 = new JSeparator();
			jSeparatorTN9313.setLocation(new Point(10, 178));
			jSeparatorTN9313.setSize(new Dimension(592, 10));
		}
		return jSeparatorTN9313;
	}

	/**
	 * This method initializes jSeparatorTN9314
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9314() {
		if (jSeparatorTN9314 == null) {
			jSeparatorTN9314 = new JSeparator();
			jSeparatorTN9314.setLocation(new Point(601, 138));
			jSeparatorTN9314.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9314.setSize(new Dimension(10, 41));
		}
		return jSeparatorTN9314;
	}

	/**
	 * This method initializes jSeparatorTN9315
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9315() {
		if (jSeparatorTN9315 == null) {
			jSeparatorTN9315 = new JSeparator();
			jSeparatorTN9315.setLocation(new Point(258, 138));
			jSeparatorTN9315.setSize(new Dimension(344, 10));
		}
		return jSeparatorTN9315;
	}

	/**
	 * This method initializes jSeparatorTN9316
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9316() {
		if (jSeparatorTN9316 == null) {
			jSeparatorTN9316 = new JSeparator();
			jSeparatorTN9316.setLocation(new Point(11, 201));
			jSeparatorTN9316.setSize(new Dimension(28, 10));
		}
		return jSeparatorTN9316;
	}

	/**
	 * This method initializes jSeparatorTN9317
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9317() {
		if (jSeparatorTN9317 == null) {
			jSeparatorTN9317 = new JSeparator();
			jSeparatorTN9317.setLocation(new Point(10, 201));
			jSeparatorTN9317.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9317.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9317;
	}

	/**
	 * This method initializes jSeparatorTN9318
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9318() {
		if (jSeparatorTN9318 == null) {
			jSeparatorTN9318 = new JSeparator();
			jSeparatorTN9318.setLocation(new Point(10, 241));
			jSeparatorTN9318.setSize(new Dimension(592, 10));
		}
		return jSeparatorTN9318;
	}

	/**
	 * This method initializes jSeparatorTN9319
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9319() {
		if (jSeparatorTN9319 == null) {
			jSeparatorTN9319 = new JSeparator();
			jSeparatorTN9319.setLocation(new Point(601, 202));
			jSeparatorTN9319.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9319.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9319;
	}

	/**
	 * This method initializes jSeparatorTN9320
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9320() {
		if (jSeparatorTN9320 == null) {
			jSeparatorTN9320 = new JSeparator();
			jSeparatorTN9320.setLocation(new Point(341, 201));
			jSeparatorTN9320.setSize(new Dimension(261, 10));
		}
		return jSeparatorTN9320;
	}

	/**
	 * This method initializes jSeparatorTN9321
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9321() {
		if (jSeparatorTN9321 == null) {
			jSeparatorTN9321 = new JSeparator();
			jSeparatorTN9321.setLocation(new Point(11, 264));
			jSeparatorTN9321.setSize(new Dimension(28, 10));
		}
		return jSeparatorTN9321;
	}

	/**
	 * This method initializes jSeparatorTN9322
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9322() {
		if (jSeparatorTN9322 == null) {
			jSeparatorTN9322 = new JSeparator();
			jSeparatorTN9322.setLocation(new Point(10, 264));
			jSeparatorTN9322.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9322.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9322;
	}

	/**
	 * This method initializes jSeparatorTN9323
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9323() {
		if (jSeparatorTN9323 == null) {
			jSeparatorTN9323 = new JSeparator();
			jSeparatorTN9323.setLocation(new Point(10, 304));
			jSeparatorTN9323.setSize(new Dimension(592, 10));
		}
		return jSeparatorTN9323;
	}

	/**
	 * This method initializes jSeparatorTN9324
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9324() {
		if (jSeparatorTN9324 == null) {
			jSeparatorTN9324 = new JSeparator();
			jSeparatorTN9324.setLocation(new Point(602, 264));
			jSeparatorTN9324.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN9324.setSize(new Dimension(10, 40));
		}
		return jSeparatorTN9324;
	}

	/**
	 * This method initializes jSeparatorTN9325
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN9325() {
		if (jSeparatorTN9325 == null) {
			jSeparatorTN9325 = new JSeparator();
			jSeparatorTN9325.setBounds(new Rectangle(254, 264, 349, 10));
		}
		return jSeparatorTN9325;
	}

	/**
	 * This method initializes jSeparatorTN93M1
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M1() {
		if (jSeparatorTN93M1 == null) {
			jSeparatorTN93M1 = new JSeparator();
			jSeparatorTN93M1.setLocation(new Point(339, 189));
			jSeparatorTN93M1.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M1.setSize(new Dimension(10, 23));
		}
		return jSeparatorTN93M1;
	}

	/**
	 * This method initializes jSeparatorTN93M10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M10() {
		if (jSeparatorTN93M10 == null) {
			jSeparatorTN93M10 = new JSeparator();
			jSeparatorTN93M10.setLocation(new Point(39, 212));
			jSeparatorTN93M10.setSize(new Dimension(301, 9));
		}
		return jSeparatorTN93M10;
	}

	/**
	 * This method initializes jSeparatorTN93M11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M11() {
		if (jSeparatorTN93M11 == null) {
			jSeparatorTN93M11 = new JSeparator();
			jSeparatorTN93M11.setBounds(new Rectangle(38, 3, 10, 25));
			jSeparatorTN93M11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M11.setBackground(Color.white);
		}
		return jSeparatorTN93M11;
	}

	/**
	 * This method initializes jSeparatorTN93M12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M12() {
		if (jSeparatorTN93M12 == null) {
			jSeparatorTN93M12 = new JSeparator();
			jSeparatorTN93M12.setLocation(new Point(39, 188));
			jSeparatorTN93M12.setSize(new Dimension(301, 9));
		}
		return jSeparatorTN93M12;
	}

	/**
	 * This method initializes jSeparatorTN93M13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M13() {
		if (jSeparatorTN93M13 == null) {
			jSeparatorTN93M13 = new JSeparator();
			jSeparatorTN93M13.setBounds(new Rectangle(39, 128, 10, 22));
			jSeparatorTN93M13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M13.setBackground(Color.white);
		}
		return jSeparatorTN93M13;
	}

	/**
	 * This method initializes jSeparatorTN93M14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M14() {
		if (jSeparatorTN93M14 == null) {
			jSeparatorTN93M14 = new JSeparator();
			jSeparatorTN93M14.setLocation(new Point(39, 150));
			jSeparatorTN93M14.setSize(new Dimension(219, 10));
		}
		return jSeparatorTN93M14;
	}

	/**
	 * This method initializes jSeparatorTN93M15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M15() {
		if (jSeparatorTN93M15 == null) {
			jSeparatorTN93M15 = new JSeparator();
			jSeparatorTN93M15.setLocation(new Point(257, 128));
			jSeparatorTN93M15.setBackground(Color.white);
			jSeparatorTN93M15.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M15.setSize(new Dimension(10, 22));
		}
		return jSeparatorTN93M15;
	}

	/**
	 * This method initializes jSeparatorTN93M16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M16() {
		if (jSeparatorTN93M16 == null) {
			jSeparatorTN93M16 = new JSeparator();
			jSeparatorTN93M16.setBounds(new Rectangle(39, 127, 219, 10));
		}
		return jSeparatorTN93M16;
	}

	/**
	 * This method initializes jSeparatorTN93M18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M18() {
		if (jSeparatorTN93M18 == null) {
			jSeparatorTN93M18 = new JSeparator();
			jSeparatorTN93M18.setLocation(new Point(253, 254));
			jSeparatorTN93M18.setBackground(Color.white);
			jSeparatorTN93M18.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M18.setSize(new Dimension(10, 23));
		}
		return jSeparatorTN93M18;
	}

	/**
	 * This method initializes jSeparatorTN93M19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M19() {
		if (jSeparatorTN93M19 == null) {
			jSeparatorTN93M19 = new JSeparator();
			jSeparatorTN93M19.setLocation(new Point(39, 277));
			jSeparatorTN93M19.setSize(new Dimension(216, 10));
		}
		return jSeparatorTN93M19;
	}

	/**
	 * This method initializes jSeparatorTN93M2
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M2() {
		if (jSeparatorTN93M2 == null) {
			jSeparatorTN93M2 = new JSeparator();
			jSeparatorTN93M2.setBounds(new Rectangle(39, 26, 176, 10));
			jSeparatorTN93M2.setPreferredSize(new Dimension(0, 2));
			jSeparatorTN93M2.setBackground(Color.white);
		}
		return jSeparatorTN93M2;
	}

	/**
	 * This method initializes jSeparatorTN93M20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M20() {
		if (jSeparatorTN93M20 == null) {
			jSeparatorTN93M20 = new JSeparator();
			jSeparatorTN93M20.setBounds(new Rectangle(39, 253, 216, 10));
		}
		return jSeparatorTN93M20;
	}

	/**
	 * This method initializes jSeparatorTN93M3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M3() {
		if (jSeparatorTN93M3 == null) {
			jSeparatorTN93M3 = new JSeparator();
			jSeparatorTN93M3.setLocation(new Point(215, 3));
			jSeparatorTN93M3.setBackground(Color.white);
			jSeparatorTN93M3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M3.setSize(new Dimension(10, 23));
		}
		return jSeparatorTN93M3;
	}

	/**
	 * This method initializes jSeparatorTN93M4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M4() {
		if (jSeparatorTN93M4 == null) {
			jSeparatorTN93M4 = new JSeparator();
			jSeparatorTN93M4.setLocation(new Point(39, 2));
			jSeparatorTN93M4.setBackground(Color.white);
			jSeparatorTN93M4.setSize(new Dimension(176, 10));
		}
		return jSeparatorTN93M4;
	}

	/**
	 * This method initializes jSeparatorTN93M5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M5() {
		if (jSeparatorTN93M5 == null) {
			jSeparatorTN93M5 = new JSeparator();
			jSeparatorTN93M5.setLocation(new Point(38, 63));
			jSeparatorTN93M5.setBackground(Color.white);
			jSeparatorTN93M5.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M5.setSize(new Dimension(10, 26));
		}
		return jSeparatorTN93M5;
	}

	/**
	 * This method initializes jSeparatorTN93M6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M6() {
		if (jSeparatorTN93M6 == null) {
			jSeparatorTN93M6 = new JSeparator();
			jSeparatorTN93M6.setLocation(new Point(38, 89));
			jSeparatorTN93M6.setSize(new Dimension(219, 10));
		}
		return jSeparatorTN93M6;
	}

	/**
	 * This method initializes jSeparatorTN93M7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M7() {
		if (jSeparatorTN93M7 == null) {
			jSeparatorTN93M7 = new JSeparator();
			jSeparatorTN93M7.setLocation(new Point(255, 63));
			jSeparatorTN93M7.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M7.setSize(new Dimension(10, 26));
		}
		return jSeparatorTN93M7;
	}

	/**
	 * This method initializes jSeparatorTN93M8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M8() {
		if (jSeparatorTN93M8 == null) {
			jSeparatorTN93M8 = new JSeparator();
			jSeparatorTN93M8.setLocation(new Point(38, 62));
			jSeparatorTN93M8.setSize(new Dimension(219, 10));
		}
		return jSeparatorTN93M8;
	}

	/**
	 * This method initializes jSeparatorTN93M9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorTN93M9() {
		if (jSeparatorTN93M9 == null) {
			jSeparatorTN93M9 = new JSeparator();
			jSeparatorTN93M9.setLocation(new Point(39, 189));
			jSeparatorTN93M9.setBackground(Color.white);
			jSeparatorTN93M9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorTN93M9.setSize(new Dimension(10, 23));
		}
		return jSeparatorTN93M9;
	}

	/**
	 * This method initializes jSeparatorWAG01
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG01() {
		if (jSeparatorWAG01 == null) {
			jSeparatorWAG01 = new JSeparator();
			jSeparatorWAG01.setLocation(new Point(11, 12));
			jSeparatorWAG01.setSize(new Dimension(28, 10));
		}
		return jSeparatorWAG01;
	}

	/**
	 * This method initializes jSeparatorWAG02
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG02() {
		if (jSeparatorWAG02 == null) {
			jSeparatorWAG02 = new JSeparator();
			jSeparatorWAG02.setLocation(new Point(10, 12));
			jSeparatorWAG02.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG02.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG02;
	}

	/**
	 * This method initializes jSeparatorWAG03
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG03() {
		if (jSeparatorWAG03 == null) {
			jSeparatorWAG03 = new JSeparator();
			jSeparatorWAG03.setLocation(new Point(10, 52));
			jSeparatorWAG03.setSize(new Dimension(591, 10));
		}
		return jSeparatorWAG03;
	}

	/**
	 * This method initializes jSeparatorWAG04
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG04() {
		if (jSeparatorWAG04 == null) {
			jSeparatorWAG04 = new JSeparator();
			jSeparatorWAG04.setLocation(new Point(601, 13));
			jSeparatorWAG04.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG04.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG04;
	}

	/**
	 * This method initializes jSeparatorWAG05
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG05() {
		if (jSeparatorWAG05 == null) {
			jSeparatorWAG05 = new JSeparator();
			jSeparatorWAG05.setLocation(new Point(209, 12));
			jSeparatorWAG05.setSize(new Dimension(393, 10));
		}
		return jSeparatorWAG05;
	}

	/**
	 * This method initializes jSeparatorWAG11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG11() {
		if (jSeparatorWAG11 == null) {
			jSeparatorWAG11 = new JSeparator();
			jSeparatorWAG11.setLocation(new Point(11, 91));
			jSeparatorWAG11.setSize(new Dimension(28, 10));
		}
		return jSeparatorWAG11;
	}

	/**
	 * This method initializes jSeparatorWAG110
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG110() {
		if (jSeparatorWAG110 == null) {
			jSeparatorWAG110 = new JSeparator();
			jSeparatorWAG110.setBounds(new Rectangle(39, 2, 10, 26));
			jSeparatorWAG110.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorWAG110;
	}

	/**
	 * This method initializes jSeparatorWAG12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG12() {
		if (jSeparatorWAG12 == null) {
			jSeparatorWAG12 = new JSeparator();
			jSeparatorWAG12.setLocation(new Point(10, 91));
			jSeparatorWAG12.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG12.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG12;
	}

	/**
	 * This method initializes jSeparatorWAG13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG13() {
		if (jSeparatorWAG13 == null) {
			jSeparatorWAG13 = new JSeparator();
			jSeparatorWAG13.setLocation(new Point(10, 131));
			jSeparatorWAG13.setSize(new Dimension(592, 10));
		}
		return jSeparatorWAG13;
	}

	/**
	 * This method initializes jSeparatorWAG14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG14() {
		if (jSeparatorWAG14 == null) {
			jSeparatorWAG14 = new JSeparator();
			jSeparatorWAG14.setLocation(new Point(601, 91));
			jSeparatorWAG14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG14.setSize(new Dimension(10, 41));
		}
		return jSeparatorWAG14;
	}

	/**
	 * This method initializes jSeparatorWAG15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG15() {
		if (jSeparatorWAG15 == null) {
			jSeparatorWAG15 = new JSeparator();
			jSeparatorWAG15.setLocation(new Point(247, 91));
			jSeparatorWAG15.setSize(new Dimension(355, 10));
		}
		return jSeparatorWAG15;
	}

	/**
	 * This method initializes jSeparatorWAG16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG16() {
		if (jSeparatorWAG16 == null) {
			jSeparatorWAG16 = new JSeparator();
			jSeparatorWAG16.setLocation(new Point(11, 171));
			jSeparatorWAG16.setSize(new Dimension(28, 10));
		}
		return jSeparatorWAG16;
	}

	/**
	 * This method initializes jSeparatorWAG17
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG17() {
		if (jSeparatorWAG17 == null) {
			jSeparatorWAG17 = new JSeparator();
			jSeparatorWAG17.setLocation(new Point(10, 171));
			jSeparatorWAG17.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG17.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG17;
	}

	/**
	 * This method initializes jSeparatorWAG18
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG18() {
		if (jSeparatorWAG18 == null) {
			jSeparatorWAG18 = new JSeparator();
			jSeparatorWAG18.setLocation(new Point(10, 211));
			jSeparatorWAG18.setSize(new Dimension(592, 10));
		}
		return jSeparatorWAG18;
	}

	/**
	 * This method initializes jSeparatorWAG19
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG19() {
		if (jSeparatorWAG19 == null) {
			jSeparatorWAG19 = new JSeparator();
			jSeparatorWAG19.setLocation(new Point(601, 171));
			jSeparatorWAG19.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG19.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG19;
	}

	/**
	 * This method initializes jSeparatorWAG20
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG20() {
		if (jSeparatorWAG20 == null) {
			jSeparatorWAG20 = new JSeparator();
			jSeparatorWAG20.setLocation(new Point(341, 170));
			jSeparatorWAG20.setSize(new Dimension(261, 10));
		}
		return jSeparatorWAG20;
	}

	/**
	 * This method initializes jSeparatorWAG21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG21() {
		if (jSeparatorWAG21 == null) {
			jSeparatorWAG21 = new JSeparator();
			jSeparatorWAG21.setLocation(new Point(11, 250));
			jSeparatorWAG21.setSize(new Dimension(28, 10));
		}
		return jSeparatorWAG21;
	}

	/**
	 * This method initializes jSeparatorWAG22
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG22() {
		if (jSeparatorWAG22 == null) {
			jSeparatorWAG22 = new JSeparator();
			jSeparatorWAG22.setLocation(new Point(10, 250));
			jSeparatorWAG22.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG22.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG22;
	}

	/**
	 * This method initializes jSeparatorWAG23
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG23() {
		if (jSeparatorWAG23 == null) {
			jSeparatorWAG23 = new JSeparator();
			jSeparatorWAG23.setLocation(new Point(10, 290));
			jSeparatorWAG23.setSize(new Dimension(592, 10));
		}
		return jSeparatorWAG23;
	}

	/**
	 * This method initializes jSeparatorWAG24
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG24() {
		if (jSeparatorWAG24 == null) {
			jSeparatorWAG24 = new JSeparator();
			jSeparatorWAG24.setLocation(new Point(602, 250));
			jSeparatorWAG24.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAG24.setSize(new Dimension(10, 40));
		}
		return jSeparatorWAG24;
	}

	/**
	 * This method initializes jSeparatorWAG25
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAG25() {
		if (jSeparatorWAG25 == null) {
			jSeparatorWAG25 = new JSeparator();
			jSeparatorWAG25.setLocation(new Point(257, 250));
			jSeparatorWAG25.setSize(new Dimension(347, 10));
		}
		return jSeparatorWAG25;
	}

	/**
	 * This method initializes jSeparatorWAGM10
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM10() {
		if (jSeparatorWAGM10 == null) {
			jSeparatorWAGM10 = new JSeparator();
			jSeparatorWAGM10.setLocation(new Point(39, 185));
			jSeparatorWAGM10.setSize(new Dimension(301, 10));
		}
		return jSeparatorWAGM10;
	}

	/**
	 * This method initializes jSeparatorWAGM11
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM11() {
		if (jSeparatorWAGM11 == null) {
			jSeparatorWAGM11 = new JSeparator();
			jSeparatorWAGM11.setLocation(new Point(339, 159));
			jSeparatorWAGM11.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAGM11.setSize(new Dimension(10, 26));
		}
		return jSeparatorWAGM11;
	}

	/**
	 * This method initializes jSeparatorWAGM12
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM12() {
		if (jSeparatorWAGM12 == null) {
			jSeparatorWAGM12 = new JSeparator();
			jSeparatorWAGM12.setLocation(new Point(39, 158));
			jSeparatorWAGM12.setSize(new Dimension(301, 10));
		}
		return jSeparatorWAGM12;
	}

	/**
	 * This method initializes jSeparatorWAGM13
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM13() {
		if (jSeparatorWAGM13 == null) {
			jSeparatorWAGM13 = new JSeparator();
			jSeparatorWAGM13.setLocation(new Point(39, 238));
			jSeparatorWAGM13.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAGM13.setSize(new Dimension(10, 26));
		}
		return jSeparatorWAGM13;
	}

	/**
	 * This method initializes jSeparatorWAGM14
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM14() {
		if (jSeparatorWAGM14 == null) {
			jSeparatorWAGM14 = new JSeparator();
			jSeparatorWAGM14.setLocation(new Point(256, 238));
			jSeparatorWAGM14.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAGM14.setSize(new Dimension(10, 26));
		}
		return jSeparatorWAGM14;
	}

	/**
	 * This method initializes jSeparatorWAGM15
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM15() {
		if (jSeparatorWAGM15 == null) {
			jSeparatorWAGM15 = new JSeparator();
			jSeparatorWAGM15.setLocation(new Point(39, 264));
			jSeparatorWAGM15.setSize(new Dimension(218, 10));
		}
		return jSeparatorWAGM15;
	}

	/**
	 * This method initializes jSeparatorWAGM16
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM16() {
		if (jSeparatorWAGM16 == null) {
			jSeparatorWAGM16 = new JSeparator();
			jSeparatorWAGM16.setLocation(new Point(39, 237));
			jSeparatorWAGM16.setSize(new Dimension(218, 10));
		}
		return jSeparatorWAGM16;
	}

	/**
	 * This method initializes jSeparatorWAGM2
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM2() {
		if (jSeparatorWAGM2 == null) {
			jSeparatorWAGM2 = new JSeparator();
			jSeparatorWAGM2.setLocation(new Point(39, 28));
			jSeparatorWAGM2.setSize(new Dimension(168, 10));
		}
		return jSeparatorWAGM2;
	}

	/**
	 * This method initializes jSeparatorWAGM3
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM3() {
		if (jSeparatorWAGM3 == null) {
			jSeparatorWAGM3 = new JSeparator();
			jSeparatorWAGM3.setLocation(new Point(207, 3));
			jSeparatorWAGM3.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAGM3.setSize(new Dimension(10, 25));
		}
		return jSeparatorWAGM3;
	}

	/**
	 * This method initializes jSeparatorWAGM4
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM4() {
		if (jSeparatorWAGM4 == null) {
			jSeparatorWAGM4 = new JSeparator();
			jSeparatorWAGM4.setLocation(new Point(39, 1));
			jSeparatorWAGM4.setSize(new Dimension(168, 8));
		}
		return jSeparatorWAGM4;
	}

	/**
	 * This method initializes jSeparatorWAGM5
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM5() {
		if (jSeparatorWAGM5 == null) {
			jSeparatorWAGM5 = new JSeparator();
			jSeparatorWAGM5.setBounds(new Rectangle(39, 79, 10, 26));
			jSeparatorWAGM5.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparatorWAGM5;
	}

	/**
	 * This method initializes jSeparatorWAGM6
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM6() {
		if (jSeparatorWAGM6 == null) {
			jSeparatorWAGM6 = new JSeparator();
			jSeparatorWAGM6.setLocation(new Point(246, 79));
			jSeparatorWAGM6.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAGM6.setSize(new Dimension(10, 26));
		}
		return jSeparatorWAGM6;
	}

	/**
	 * This method initializes jSeparatorWAGM7
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM7() {
		if (jSeparatorWAGM7 == null) {
			jSeparatorWAGM7 = new JSeparator();
			jSeparatorWAGM7.setBounds(new Rectangle(40, 105, 207, 10));
		}
		return jSeparatorWAGM7;
	}

	/**
	 * This method initializes jSeparatorWAGM8
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM8() {
		if (jSeparatorWAGM8 == null) {
			jSeparatorWAGM8 = new JSeparator();
			jSeparatorWAGM8.setLocation(new Point(40, 78));
			jSeparatorWAGM8.setSize(new Dimension(207, 10));
		}
		return jSeparatorWAGM8;
	}

	/**
	 * This method initializes jSeparatorWAGM9
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparatorWAGM9() {
		if (jSeparatorWAGM9 == null) {
			jSeparatorWAGM9 = new JSeparator();
			jSeparatorWAGM9.setLocation(new Point(39, 159));
			jSeparatorWAGM9.setOrientation(SwingConstants.VERTICAL);
			jSeparatorWAGM9.setSize(new Dimension(10, 26));
		}
		return jSeparatorWAGM9;
	}

	/**
	 * Este metodo inicializa o jTabbedPaneGeral
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPaneGeral() {
		if (jTabbedPaneGeral == null) {
			jTabbedPaneGeral = new JTabbedPane();
			jTabbedPaneGeral.setLocation(new Point(33, 10));
			jTabbedPaneGeral.setSize(625, 380);
			jTabbedPaneGeral.setBackground(new Color(192, 209, 226));
			jTabbedPaneGeral.addTab("Seqüência",getIcon(oldImagesPath+"anotacao.png"),getJPanelSequencia(), null);
                        jTabbedPaneGeral.addTab("Modelo - DNA",getIcon(oldImagesPath+"dna_aba.png"),getJPanelDNA(), null);
			jTabbedPaneGeral.addTab("Modelo - AA",getIcon(oldImagesPath+"aa.png"),getJPanelAA(), null);
			jTabbedPaneGeral.addTab("Árvore",getIcon(oldImagesPath+"HyperTree.gif"),getJPanelArvore(), null);
			jTabbedPaneGeral.addTab("Bootstrap",getIcon(oldImagesPath+"bootstrap.png"),getJPanelBootstrap(), null);
		}
		return jTabbedPaneGeral;
	}

	/**
	 * This method initializes jTabbedPaneModelosAA
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPaneModelosAA() {
		if (jTabbedPaneModelosAA == null) {
			imagemAA = getIcon(oldImagesPath+"dnaBackground.jpg");
			jTabbedPaneModelosAA = new JTabbedPane() {
				public static final long serialVersionUID = 1L;

				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					imagemAA.paintIcon(this, g, 2, 2);
				}
			};
			jTabbedPaneModelosAA.setSize(new Dimension(619, 345));
			jTabbedPaneModelosAA.setLocation(new Point(0, 0));
			jTabbedPaneModelosAA.setBackground(Color.white);
		}
		return jTabbedPaneModelosAA;
	}

	/**
	 * This method initializes jTabbedPaneModelosDNA
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPaneModelosDNA() {
		if (jTabbedPaneModelosDNA == null) {
			imagemDNA = new ImageIcon();

			jTabbedPaneModelosDNA = new JTabbedPane() {
				public static final long serialVersionUID = 1L;

				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					imagemDNA.paintIcon(this, g, 2, 2);
				}
			};

			jTabbedPaneModelosDNA.setSize(new Dimension(619, 344));
			jTabbedPaneModelosDNA.setLocation(new Point(0, 0));
			jTabbedPaneModelosDNA.setBackground(Color.white);
			jTabbedPaneModelosDNA.setTabPlacement(JTabbedPane.TOP);
			jTabbedPaneModelosDNA.setVisible(true);
			jTabbedPaneModelosDNA.addTab("F84", null, getJPanelF84(), null);
			jTabbedPaneModelosDNA.addTab("JC69", null, getJPanelJC69(), null);
			jTabbedPaneModelosDNA.addTab("TN93", null, getJPanelTN93(), null);
			jTabbedPaneModelosDNA.addTab("HKY", null, getJPanelHKY(), null);
			jTabbedPaneModelosDNA.addTab("K2P", null, getJPanelK2P(), null);
			jTabbedPaneModelosDNA.addTab("GTR", null, getJPanelGTR(), null);
			jTabbedPaneModelosDNA.addTab("F81", null, getJPanelF81(), null);
		}
		return jTabbedPaneModelosDNA;
	}

	/**
	 * This method initializes jTabbedPaneTipoExecucao
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPaneTipoExecucao() {
		if (jTabbedPaneTipoExecucao == null) {
			jTabbedPaneTipoExecucao = new JTabbedPane();
			jTabbedPaneTipoExecucao.setBounds(new Rectangle(0, 0, 242, 143));
			jTabbedPaneTipoExecucao.addTab("Seqüencial", null,
					getJPanelTipoExecucaoSequencial(), null);
			jTabbedPaneTipoExecucao.addTab("Paralelo", null,
					getJPanelTipoExecucaoParalelo(), null);
		}
		return jTabbedPaneTipoExecucao;
	}

	/**
	 * This method initializes jTextFieldArquivoArvore
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldArquivoArvore() {
		if (jTextFieldArquivoArvore == null) {
			jTextFieldArquivoArvore = new JTextField();
			jTextFieldArquivoArvore.setLocation(new Point(220, 48));
			jTextFieldArquivoArvore.setBackground(Color.white);
			jTextFieldArquivoArvore.setEditable(false);
			jTextFieldArquivoArvore.setSize(new Dimension(150, 20));
		}
		return jTextFieldArquivoArvore;
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
			jTextFieldArquivoSequencia.setBackground(Color.white);
			jTextFieldArquivoSequencia.setLocation(new Point(194, 25));
                        jTextFieldArquivoSequencia.setEnabled(false);
		}
		return jTextFieldArquivoSequencia;
	}

	/**
	 * This method initializes SeparatorDCMut21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getSeparatorDCMut21() {
		if (SeparatorDCMut21 == null) {
			SeparatorDCMut21 = new JSeparator();
			SeparatorDCMut21.setLocation(new Point(11, 250));
			SeparatorDCMut21.setSize(new Dimension(28, 10));
		}
		return SeparatorDCMut21;
	}

	/**
	 * This method initializes SeparatorMtREV21
	 * 
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getSeparatorMtREV21() {
		if (SeparatorMtREV21 == null) {
			SeparatorMtREV21 = new JSeparator();
			SeparatorMtREV21.setLocation(new Point(11, 250));
			SeparatorMtREV21.setSize(new Dimension(28, 10));
		}
		return SeparatorMtREV21;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void initialize() {
		this.setSize(790, 470);
		this.setBackground(new Color(173, 200, 226));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(oldImagesPath+"IGrafuAF.png"));
		this.setJMenuBar(getJJMenuBar());
		initializeJPanelBootstrap();
		this.setContentPane(getJContentPane());
		this.setTitle("IGrafu: PHYML");

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width - getSize().width) / 2,
				(dimension.height - getSize().height) / 2);

		this.setVisible(true);
                this.setResizable(false);
                this.repaint();
	}

	public void setImagemAA(ImageIcon imagemAA) {
		this.imagemAA = imagemAA;
	}

	public void setImagemDNA(ImageIcon imagemDNA) {
		this.imagemDNA = imagemDNA;
	}

	public void setJLabelArquivoSequencia(JLabel labelArquivoSequencia) {
		jLabelArquivoSequencia = labelArquivoSequencia;
	}

	public void setJLabelGamaDayhoff(JLabel labelGamaDayhoff) {
		jLabelGamaDayhoff = labelGamaDayhoff;
	}

	public void setJLabelGamaDCMut(JLabel labelGamaDCMut) {
		jLabelGamaDCMut = labelGamaDCMut;
	}

	public void setJLabelGamaF84(JLabel labelGamaF84) {
		jLabelGamaF84 = labelGamaF84;
	}

	public void setJLabelGamaHKY(JLabel labelGamaHKY) {
		jLabelGamaHKY = labelGamaHKY;
	}

	public void setJLabelGamaJTT(JLabel labelGamaJTT) {
		jLabelGamaJTT = labelGamaJTT;
	}

	public void setJLabelGamaK2P(JLabel labelGamaK2P) {
		jLabelGamaK2P = labelGamaK2P;
	}

	public void setJLabelGamaMtREV(JLabel labelGamaMtREV) {
		jLabelGamaMtREV = labelGamaMtREV;
	}

	public void setJLabelGamaTN93(JLabel labelGamaTN93) {
		jLabelGamaTN93 = labelGamaTN93;
	}

	public void setJLabelGamaWAG(JLabel labelGamaWAG) {
		jLabelGamaWAG = labelGamaWAG;
	}

	public void setJLabelModeloSelecionadoDayhoff(
			JLabel labelModeloSelecionadoDayhoff) {
		jLabelModeloSelecionadoDayhoff = labelModeloSelecionadoDayhoff;
	}

	public void setJLabelModeloSelecionadoDCMut(
			JLabel labelModeloSelecionadoDCMut) {
		jLabelModeloSelecionadoDCMut = labelModeloSelecionadoDCMut;
	}

	public void setJLabelModeloSelecionadoHKY(JLabel labelModeloSelecionadoHKY) {
		jLabelModeloSelecionadoHKY = labelModeloSelecionadoHKY;
	}

	public void setJLabelModeloSelecionadoJC69(JLabel labelModeloSelecionadoJC69) {
	}

	public void setJLabelModeloSelecionadoJTT(JLabel labelModeloSelecionadoJTT) {
		jLabelModeloSelecionadoJTT = labelModeloSelecionadoJTT;
	}

	public void setJLabelModeloSelecionadoK2P(JLabel labelModeloSelecionadoK2P) {
		jLabelModeloSelecionadoK2P = labelModeloSelecionadoK2P;
	}

	public void setJLabelModeloSelecionadoMtREV(
			JLabel labelModeloSelecionadoMtREV) {
		jLabelModeloSelecionadoMtREV = labelModeloSelecionadoMtREV;
	}

	public void setJLabelModeloSelecionadoTN93(JLabel labelModeloSelecionadoTN93) {
		jLabelModeloSelecionadoTN93 = labelModeloSelecionadoTN93;
	}

	public void setJLabelModeloSelecionadoWAG(JLabel labelModeloSelecionadoWAG) {
		jLabelModeloSelecionadoWAG = labelModeloSelecionadoWAG;
	}

	public void setJLabelModeloUtilizadoDayhoff(
			JLabel labelModeloUtilizadoDayhoff) {
		jLabelModeloUtilizadoDayhoff = labelModeloUtilizadoDayhoff;
	}

	public void setJLabelModeloUtilizadoDCMut(JLabel labelModeloUtilizadoDCMut) {
		jLabelModeloUtilizadoDCMut = labelModeloUtilizadoDCMut;
	}

	public void setJLabelModeloUtilizadoF84(JLabel labelModeloUtilizadoF84) {
		jLabelModeloUtilizadoF84 = labelModeloUtilizadoF84;
	}

	public void setJLabelModeloUtilizadoHKY(JLabel labelModeloUtilizadoHKY) {
		jLabelModeloUtilizadoHKY = labelModeloUtilizadoHKY;
	}

	public void setJLabelModeloUtilizadoJTT(JLabel labelModeloUtilizadoJTT) {
		jLabelModeloUtilizadoJTT = labelModeloUtilizadoJTT;
	}

	public void setJLabelModeloUtilizadoK2P(JLabel labelModeloUtilizadoK2P) {
		jLabelModeloUtilizadoK2P = labelModeloUtilizadoK2P;
	}

	public void setJLabelModeloUtilizadoMtREV(JLabel labelModeloUtilizadoMtREV) {
		jLabelModeloUtilizadoMtREV = labelModeloUtilizadoMtREV;
	}

	public void setJLabelModeloUtilizadoTN93(JLabel labelModeloUtilizadoTN93) {
		jLabelModeloUtilizadoTN93 = labelModeloUtilizadoTN93;
	}

	public void setJLabelModeloUtilizadoWAG(JLabel labelModeloUtilizadoWAG) {
		jLabelModeloUtilizadoWAG = labelModeloUtilizadoWAG;
	}

	public void setJLabelProporcaoDayhoff(JLabel labelProporcaoDayhoff) {
		jLabelProporcaoDayhoff = labelProporcaoDayhoff;
	}

	public void setJLabelProporcaoDCMut(JLabel labelProporcaoDCMut) {
		jLabelProporcaoDCMut = labelProporcaoDCMut;
	}

	public void setJLabelProporcaoF84(JLabel labelProporcaoF84) {
		jLabelProporcaoF84 = labelProporcaoF84;
	}

	public void setJLabelProporcaoHKY(JLabel labelProporcaoHKY) {
		jLabelProporcaoHKY = labelProporcaoHKY;
	}

	public void setJLabelProporcaoJTT(JLabel labelProporcaoJTT) {
		jLabelProporcaoJTT = labelProporcaoJTT;
	}

	public void setJLabelProporcaoK2P(JLabel labelProporcaoK2P) {
		jLabelProporcaoK2P = labelProporcaoK2P;
	}

	public void setJLabelProporcaoMtREV(JLabel labelProporcaoMtREV) {
		jLabelProporcaoMtREV = labelProporcaoMtREV;
	}

	public void setJLabelProporcaoTN93(JLabel labelProporcaoTN93) {
		jLabelProporcaoTN93 = labelProporcaoTN93;
	}

	public void setJLabelProporcaoWAG(JLabel labelProporcaoWAG) {
		jLabelProporcaoWAG = labelProporcaoWAG;
	}

	public void setJLabelRelacao(JLabel labelRelacao) {
		jLabelRelacaoTN93 = labelRelacao;
	}

	public void setJLabelRelacaoF84(JLabel labelRelacaoF84) {
		jLabelRelacaoF84 = labelRelacaoF84;
	}

	public void setJLabelRelacaoHKY(JLabel labelRelacaoHKY) {
		jLabelRelacaoHKY = labelRelacaoHKY;
	}

	public void setJLabelRelacaoK2P(JLabel labelRelacaoK2P) {
		jLabelRelacaoK2P = labelRelacaoK2P;
	}

	public void setJLabelTaxaArvore(JLabel labelTaxaArvore) {
		jLabelTaxaArvore = labelTaxaArvore;
	}

	public void setJLabelTaxaDayhoff(JLabel labelTaxaDayhoff) {
		jLabelTaxaDayhoff = labelTaxaDayhoff;
	}

	public void setJLabelTaxaDCMut(JLabel labelTaxaDCMut) {
		jLabelTaxaDCMut = labelTaxaDCMut;
	}

	public void setJLabelTaxaF84(JLabel labelTaxaF84) {
		jLabelTaxaF84 = labelTaxaF84;
	}

	public void setJLabelTaxaHKY(JLabel labelTaxaHKY) {
		jLabelTaxaHKY = labelTaxaHKY;
	}

	public void setJLabelTaxaJTT(JLabel labelTaxaJTT) {
		jLabelTaxaJTT = labelTaxaJTT;
	}

	public void setJLabelTaxaK2P(JLabel labelTaxaK2P) {
		jLabelTaxaK2P = labelTaxaK2P;
	}

	public void setJLabelTaxaMtREV(JLabel labelTaxaMtREV) {
		jLabelTaxaMtREV = labelTaxaMtREV;
	}

	public void setJLabelTaxaTN93(JLabel labelTaxaTN93) {
		jLabelTaxaTN93 = labelTaxaTN93;
	}

	public void setJLabelTaxaWAG(JLabel labelTaxaWAG) {
		jLabelTaxaWAG = labelTaxaWAG;
	}

	public void setJLabelTipoArquivo(JLabel labelTipoArquivo) {
		jLabelTipoArquivo = labelTipoArquivo;
	}

	public void setJLabelTipoDado(JLabel labelTipoDado) {
		jLabelTipoDado = labelTipoDado;
	}

	public void setJLabelTipoExecucaoParalelo(JLabel labelTipoExecucaoParalelo) {
		jLabelTipoExecucaoParalelo = labelTipoExecucaoParalelo;
	}

	public void setJLabelTipoExecucaoSequencial(
			JLabel labelTipoExecucaoSequencial) {
		jLabelTipoExecucaoSequencial = labelTipoExecucaoSequencial;
	}

	public void setJLabelTopologiaArvore(JLabel labelTopologiaArvore) {
		jLabelTopologiaArvore = labelTopologiaArvore;
	}
	

}