package br.uesc.computacao.estagio.apresentacao.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.uesc.computacao.estagio.aplicacao.controlador.ControladorConversor;
import br.uesc.computacao.estagio.aplicacao.controlador.ControladorIGrafu;
import br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField;

//import br.uesc.computacao.estagio.aplicacao.util.JNumberField;


/**
 * Tela do DiGrafu
 * @author Gilmar
 * 
 */

public class DIGRAFU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int nivel1 = 40;
	int nivel2 = 98;
	int nivel3 = 260;
	int coluna1 = 20;
	int coluna2 = 340;
	Dimension size1 = new Dimension(300, 58);
	Dimension size2 = new Dimension(300, 140);
	Dimension size3 = new Dimension(300, 150);
	
	public static int x;
	public static int y;
	
	private JPanel painelPrincipal = null;
	private JMenuBar barraMenuPrincipal = null;
	private JMenu menuArquivo = null;
	private JMenu menuConfiguracao = null;
	private JMenu menuAjuda = null;
	private JProgressBar barraProgressoExecucao = null;
	
	
	// Painéis para os parâmetros do DiGrafu
	private JPanel painelSequencia = null;
	private JPanel painelTipo = null;
	private JPanel painelModelo = null;
	private JPanel painelTransicaoTransversao = null;
	private JPanel painelPesos = null;
	private JPanel painelDistribuicaoGamma = null;
	private JPanel painelFrequencias = null;
	private JPanel painelCategorias = null;
	private JPanel painelPreferencia = null;
	private JPanel painelBotoes = null;
	
	
	// Componentes dos painéis
	
	// Sequência
	private JLabel labelSequencia = null;
	private JTextField campoTextoSequencia = null;
	
	// Tipo
	private JLabel labelTipo = null;
	private JComboBox comboTipo = null;
	
	// Modelo
	private JLabel labelModelo = null;
	private JComboBox comboModelo = null;
	private JComboBox comboModeloDNA = null;
	private JComboBox comboModeloProteina = null;
	private JPanel painelCardModelo = null;
	
	// Taxa transição/transversão
	private JLabel labelTransicaoTransversao = null;
	private JNumberFloatField campoNumericoTransicaoTransversao = null;
	
	// Pesos
	private JLabel labelPesos = null;
	private JLabel labelPesosUsar = null;
	private JLabel labelPesosDoArquivo = null;
	private JCheckBox checkBoxPesos = null;
	private JScrollPane painelRolagemAreaTextoPesos = null;
	private JTextArea areaTextoPesos = null;
	private JButton botaoPesosAbrir = null;
	private JRadioButton radioBotaoPesosManual = null;
	private JRadioButton radioBotaoPesosDoArquivo = null;
	private ButtonGroup grupoBotoesPesos = null;
	private JTextField campoTextoPesosDoArquivo = null;
	private JPanel painelPesosManual = null;
	private JPanel painelPesosDoArquivo = null;
	private JPanel painelCardPesos = null;
	private JButton botaoLimparPesos = null;
	private JButton botaoEditarPesos = null;
	
	// Distribuição Gamma
	private JLabel labelGamma = null;
	private JLabel labelCoeficienteVariacao = null;
	private JLabel labelSitiosInvariantes = null;
	private JNumberFloatField campoNumericoCV = null;
	private JCheckBox checkBoxSitiosInvariantes = null;
	private JSpinner spinnerSitiosInvariantes = null;
	
	// Frequências
	private JCheckBox checkBoxFrequenciasEmpiricas = null;
	private JLabel labelFrequencias = null;
	private JLabel labelFrequenciasA = null;
	private JLabel labelFrequenciasC = null;
	private JLabel labelFrequenciasG = null;
	private JLabel labelFrequenciasT = null;
	private JSlider sliderFrequenciasA = null;
	private JSlider sliderFrequenciasC = null;
	private JSlider sliderFrequenciasG = null;
	private JSlider sliderFrequenciasT = null;
	private JSpinner spinnerFrequenciasA = null;
	private JSpinner spinnerFrequenciasC = null;
	private JSpinner spinnerFrequenciasG = null;
	private JSpinner spinnerFrequenciasT = null;
	private JLabel labelFrequenciasTotal = null;
	private JLabel labelFrequenciasTotalNum = null;
	
	// Categorias
	private JLabel labelCategorias = null;
	private JLabel labelCategoriasDefinir = null;
	private JLabel labelCategoriasDoArquivo = null;
	private JCheckBox checkBoxCategorias = null;
	private JSpinner spinnerCategoriasNum = null;
	private JScrollPane painelRolagemAreaTextoCategorias = null;
	private JTextArea areaTextoCategorias = null;
	private JButton botaoCategoriasAbrir = null;
	private JLabel labelCategoria1 = null;
	private JTextField campoNumericoCategoria1 = null;
	private JLabel labelCategoria2 = null;
	private JTextField campoNumericoCategoria2 = null;
	private JLabel labelCategoria3 = null;
	private JTextField campoNumericoCategoria3 = null;
	private JLabel labelCategoria4 = null;
	private JTextField campoNumericoCategoria4 = null;
	private JLabel labelCategoria5 = null;
	private JTextField campoNumericoCategoria5 = null;
	private JLabel labelCategoria6 = null;
	private JTextField campoNumericoCategoria6 = null;
	private JLabel labelCategoria7 = null;
	private JTextField campoNumericoCategoria7 = null;
	private JLabel labelCategoria8 = null;
	private JTextField campoNumericoCategoria8 = null;
	private JLabel labelCategoria9 = null;
	private JTextField campoNumericoCategoria9 = null;
	private JRadioButton radioBotaoCategoriasManual = null;
	private JRadioButton radioBotaoCategoriasDoArquivo = null;
	private ButtonGroup grupoBotoesCategorias = null;
	private JTextField campoTextoCategoriasDoArquivo = null;
	private JPanel painelCategoriasManual = null;
	private JPanel painelCategoriasDoArquivo = null;
	private JPanel painelCardCategorias = null;
	private JButton botaoLimparCategorias = null;
	private JButton botaoEditarCategorias = null;
	
	// Preferências
	private JLabel labelPreferencia = null;
	private JCheckBox checkBoxExatidao = null;
	private JCheckBox checkBoxExecucao = null;
	
	
	// Botoes
	private JButton botaoInicio = null;
	private JButton botaoEditor = null;
	private JButton botaoVoltar = null;
	private JButton botaoExecutar = null;
	private JButton botaoVisualizar = null;

	
	// Janelinha de modo de execução
	private JDialog dialogoModoExecucao = null;
	private JTabbedPane painelAbasModoExecucao = null;
	private JPanel painelModoExecucao = null;
	private JPanel painelModoExecucaoSequencial = null;
	private JPanel painelModoExecucaoParalela = null;
	private JComboBox comboModoExecucaoSequencial = null;
	private JComboBox comboModoExecucaoParalela = null;
	private JButton botaoModoExecucaoExecutar = null;
	
	
	public DIGRAFU(){
		super();
		initialize();
	}
	
	private void initialize(){
		this.setSize(790, 470);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/IGrafuAF.png")));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( dimension.width - getSize().width )/2, ( dimension.height - getSize().height )/2 );
        this.setJMenuBar(getBarraMenuPrincipal());
        this.setContentPane(getPainelPrincipal());
        this.setTitle("IGRAFU: DiGrafu");
        this.setResizable(false);
	}
		
	public JMenuBar getBarraMenuPrincipal(){
		
		if(barraMenuPrincipal == null){
			barraMenuPrincipal = new JMenuBar();
			barraMenuPrincipal.add(getMenuArquivo());
			barraMenuPrincipal.add(getMenuConfiguracao());
			barraMenuPrincipal.add(getMenuAjuda());
		}
		return barraMenuPrincipal;
		
	}
	
	public JPanel getPainelPrincipal(){
				
		if(painelPrincipal == null){

			painelPrincipal = new JPanel();
            
			painelPrincipal.setBackground(new Color(173, 200, 226));
			painelPrincipal.setLayout(null);
			
			painelPrincipal.add(getPainelSequencia());
			painelPrincipal.add(getPainelTipo());
			painelPrincipal.add(getPainelModelo());
			painelPrincipal.add(getPainelTransicaoTransversao());
			painelPrincipal.add(getPainelPesos());
			painelPrincipal.add(getPainelDistribuicaoGamma());
			painelPrincipal.add(getPainelCategorias());
			painelPrincipal.add(getPainelFrequencias());
			painelPrincipal.add(getPainelPreferencia());
			painelPrincipal.add(getBotaoInicio());
			painelPrincipal.add(getBotaoEditor());
			painelPrincipal.add(getBotaoVoltar());
			painelPrincipal.add(getBotaoExecutar());
			painelPrincipal.add(getBotaoVisualizar());
			painelPrincipal.add(getBarraProgressoExecucao());
						
		}
		return painelPrincipal;
		
	}
	
	public JMenu getMenuArquivo(){
		
		if(menuArquivo == null){
			menuArquivo = new JMenu("Arquivo");
		}
		return menuArquivo;
		
	}
	
	public JMenu getMenuConfiguracao(){
		
		if(menuConfiguracao == null){
			menuConfiguracao = new JMenu("Configuracao");
		}
		return menuConfiguracao;
		
	}
	
	public JMenu getMenuAjuda(){
		
		if(menuAjuda == null){
			menuAjuda = new JMenu("Ajuda");
		}
		return menuAjuda;
		
	}
	
	public JPanel getPainelSequencia(){
				
		if(painelSequencia == null){
			painelSequencia = new JPanel();
			painelSequencia.setLayout(null);
			painelSequencia.setBackground(new Color(230, 234, 240));
			painelSequencia.setSize(new Dimension(788, 20));
			painelSequencia.setLocation(new Point(0, 0));
			painelSequencia.add(getLabelSequencia());
		}
		return painelSequencia;
		
	}
	
	public JLabel getLabelSequencia(){
		
		if(labelSequencia == null){
			labelSequencia = new JLabel();
			labelSequencia.setFont(new Font("Arial", Font.BOLD, 12));
			labelSequencia.setSize(new Dimension(778, 20));
			labelSequencia.setLocation(new Point(10, 0));
			labelSequencia.setText("Sequência: " + ControladorConversor.arquivoSaida);
		}
		return labelSequencia;
		
	}
	
	public JPanel getPainelTipo(){
		
		TitledBorder bordaTitulo = null;
		
		if(painelTipo == null){
			painelTipo = new JPanel();
			painelTipo.setBackground(new Color(173, 200, 226));
			painelTipo.setSize(new Dimension((size1.width/2)-5, size1.height));
			painelTipo.setLocation(new Point(coluna1, nivel1));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Tipo");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelTipo.setBorder(bordaTitulo);
			// painelTipo.add(getLabelTipo());
			painelTipo.add(getComboTipo());
			painelTipo.setToolTipText("Selecione o Tipo de dado de entrada");
		}
		return painelTipo;
		
	}

	public JLabel getLabelTipo(){
		
		if(labelTipo == null){
			labelTipo = new JLabel();
			labelTipo.setFont(new Font("Arial", Font.PLAIN, 12));
			labelTipo.setSize(new Dimension(78, 20));
			labelTipo.setLocation(new Point(10, 0));
			labelTipo.setText("Tipo");
		}
		return labelTipo;
		
	}
	
	public JComboBox getComboTipo(){
		
		String[] modelos = {"DNA", "Proteína"};
		
		if(comboTipo == null){
			comboTipo = new JComboBox(modelos);
			comboTipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			comboTipo.setToolTipText("Selecione o Tipo de dado de entrada");
		}
		return comboTipo;
		
	}
	
	public JPanel getPainelModelo(){
		
		TitledBorder bordaTitulo = null;
		
		if(painelModelo == null){
			painelModelo = new JPanel();
			painelModelo.setBackground(new Color(173, 200, 226));
			painelModelo.setSize(new Dimension((size1.width/2)-5, size1.height));
			painelModelo.setLocation(new Point(coluna1+painelModelo.getWidth()+10, nivel1));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Modelo");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelModelo.setBorder(bordaTitulo);
			// painelModelo.add(getLabelModelo(), BorderLayout.CENTER);
			// painelModelo.add(getComboModelo());
			painelModelo.add(getPainelCardModelo());
			painelModelo.setToolTipText("Selecione o modelo de substituição");
		}
		return painelModelo;
		
	}

	public JLabel getLabelModelo(){
		
		if(labelModelo == null){
			labelModelo = new JLabel();
			labelModelo.setFont(new Font("Arial", Font.PLAIN, 12));
			//labelModelo.setSize(new Dimension(78, 16));
			labelModelo.setLocation(new Point(coluna1+25, nivel1-5));
			labelModelo.setText("Modelo");
			labelModelo.setBorder(BorderFactory.createLineBorder(Color.white));
		}
		return labelModelo;
		
	}
	
	public JComboBox getComboModeloDNA(){
		
		String[] modelos = {"Kimura", "F84", "Jukes-Cantor", "LogDet"};
		
		if(comboModeloDNA == null){
			comboModeloDNA = new JComboBox(modelos);
			comboModeloDNA.setCursor(new Cursor(Cursor.HAND_CURSOR));
			comboModeloDNA.setToolTipText("Selecione o modelo de substituição");
		}
		return comboModeloDNA;
		
	}
	
	public JComboBox getComboModeloProteina(){
		
		String[] modelos = {"Kimura", "JTT", "PMB", "PAM"};
		
		if(comboModeloProteina == null){
			comboModeloProteina = new JComboBox(modelos);
			comboModeloProteina.setCursor(new Cursor(Cursor.HAND_CURSOR));
			comboModeloProteina.setToolTipText("Selecione o modelo de substituição");
		}
		return comboModeloProteina;
		
	}
	
	public JPanel getPainelCardModelo(){
		
		if(painelCardModelo == null){
			painelCardModelo = new JPanel(new CardLayout());
			painelCardModelo.setBackground(new Color(173, 200, 226));
			painelCardModelo.add(getComboModeloDNA(), "DNA");
			painelCardModelo.add(getComboModeloProteina(), "Proteína");
		}
		return painelCardModelo;
		
	}
	
	public JPanel getPainelTransicaoTransversao(){
		
		TitledBorder bordaTitulo = null;
		
		if(painelTransicaoTransversao == null){
			painelTransicaoTransversao = new JPanel();
			painelTransicaoTransversao.setBackground(new Color(173, 200, 226));
			painelTransicaoTransversao.setSize(size1);
			painelTransicaoTransversao.setLocation(new Point(coluna2, nivel1));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Transição/Transversão");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelTransicaoTransversao.setBorder(bordaTitulo);
			painelTransicaoTransversao.add(getCampoNumericoTransicaoTransversao());
			painelTransicaoTransversao.setToolTipText(
					"<html>" +
					"Taxa de transição/transversão esperada<br>" +
					"*Número real maior que 0.0" +
					"</html>");
		}
		return painelTransicaoTransversao;
		
	}
	
	public JNumberFloatField getCampoNumericoTransicaoTransversao(){
		
		if(campoNumericoTransicaoTransversao == null){
			campoNumericoTransicaoTransversao = new JNumberFloatField();
			// campoNumericoTransicaoTransversao.setValue(2);
			campoNumericoTransicaoTransversao.setToolTipText(
					"<html>" +
					"Taxa de transição/transversão esperada<br>" +
					"*Número real maior que 0.0" +
					"</html>");
		}
		return campoNumericoTransicaoTransversao;
		
	}
	
	public JPanel getPainelPesos(){
		
		TitledBorder bordaTitulo = null;
		GridBagConstraints c = new GridBagConstraints();
		
		if(painelPesos == null){
			painelPesos = new JPanel();
			painelPesos.setLayout(new GridBagLayout());
			painelPesos.setBackground(new Color(173, 200, 226));
			painelPesos.setSize(size3);
			painelPesos.setLocation(new Point(coluna1, nivel3));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Pesos");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelPesos.setBorder(bordaTitulo);
			painelPesos.setToolTipText(
					"<html>" +
					"<b>Pesos para os sítios</b><br>" +
					"Usar apenas parte dos sítios da sequência" +
					"</html>");

			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 2;
			c.anchor = GridBagConstraints.CENTER;
			//c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.insets = new Insets(0, 0, 0, 0);
			c.ipadx = 0;
			c.ipady = 0;
			painelPesos.add(getCheckBoxPesos(), c);
			
/*			c.gridx = 0;
			c.gridy = 1;
			c.anchor = GridBagConstraints.CENTER;
			c.gridwidth = 1;
			painelPesos.add(getLabelPesosDoArquivo(), c);*/
			
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.anchor = GridBagConstraints.EAST;
			painelPesos.add(getRadioBotaoPesosDoArquivo(), c);

			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			c.anchor = GridBagConstraints.WEST;
			painelPesos.add(getRadioBotaoPesosManual(), c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 2;
			c.anchor = GridBagConstraints.CENTER;
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(3, 3, 3, 3);
			painelPesos.add(getPainelCardPesos(), c);
			
/*			
			c.gridx = 1;
			c.gridy = 0;
			c.gridwidth = 1;
			painelPesos.add(getBotaoPesosAbrir(), c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 2;
			painelPesos.add(getPainelRolagemAreaTextoPesos(), c);*/
			// painelPesos.add(getAreaTextoPesos());

			getGrupoBotoesPesos();

		}
		return painelPesos;
		
	}
	
	public JLabel getLabelPesosUsar(){
		
		if(labelPesosUsar == null){
			labelPesosUsar = new JLabel("Usar pesos para sítios");
			labelPesosUsar.setSize(new Dimension(100, 10));
			// labelPesosUsar.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return labelPesosUsar;
		
	}
	
	public JCheckBox getCheckBoxPesos(){
		
		if(checkBoxPesos == null){
			checkBoxPesos = new JCheckBox();
			checkBoxPesos.setText("Usar pesos para sítios");
			//checkBoxPesos.setSize(new Dimension(100, 10));
		}
		return checkBoxPesos;
	}
	
	public JLabel getLabelPesosDoArquivo(){
		
		if(labelPesosDoArquivo == null){
			labelPesosDoArquivo = new JLabel("Arquivo:");
			// labelPesosDoArquivo.setSize(new Dimension(100, 15));
			// labelPesosDoArquivo.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return labelPesosDoArquivo;
		
	}
	
	public JButton getBotaoPesosAbrir(){
		
		if(botaoPesosAbrir == null){
			botaoPesosAbrir = new JButton("Abrir");
			botaoPesosAbrir.setSize(new Dimension(30, 20));
			botaoPesosAbrir.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoPesosAbrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
			botaoPesosAbrir.setToolTipText("Abrir arquivo com pesos");
		}
		return botaoPesosAbrir;
		
	}
	
	public JScrollPane getPainelRolagemAreaTextoPesos(){
		
		if(painelRolagemAreaTextoPesos == null){
			painelRolagemAreaTextoPesos = new JScrollPane(getAreaTextoPesos());
			//painelRolagemAreaTextoPesos.setPreferredSize(new Dimension(30, 30));
			// painelRolagemAreaTextoPesos.setSize(new Dimension(30, 30));
		}
		return painelRolagemAreaTextoPesos;
		
	}
	
	public JTextArea getAreaTextoPesos(){
		
		if(areaTextoPesos == null){
			areaTextoPesos = new JTextArea();
			// areaTextoPesos.setSize(new Dimension(30, 30 ));
			// areaTextoPesos.setEditable(true);
			// areaTextoPesos.setLocation(new Point(5, 20));
			// areaTextoPesos.setBounds(new Rectangle(5, 130, 90, 100));
			areaTextoPesos.setToolTipText(
					"<html>" +
					"Insira os índices dos sítios que devem ser considerados " +
					"separados por vírgula sem espaço<br>" +
					"*O índice do primeiro sítio é 0, do segundo é 1, assim " +
					"por diante" +
					"</html>");
		}
		return areaTextoPesos;
	}
	
	public JRadioButton getRadioBotaoPesosManual(){
		
		if(radioBotaoPesosManual == null){
			radioBotaoPesosManual = new JRadioButton("Manual");
			radioBotaoPesosManual.setToolTipText("Inserir peso de cada sítio " +
					"manualmente");
		}
		return radioBotaoPesosManual;
		
	}
		
	public JRadioButton getRadioBotaoPesosDoArquivo(){
		
		if(radioBotaoPesosDoArquivo == null){
			radioBotaoPesosDoArquivo = new JRadioButton("Do arquivo");
			radioBotaoPesosDoArquivo.setToolTipText("Usar pesos a partir de " +
					"um arquivo");
		}
		return radioBotaoPesosDoArquivo;
		
	}
		
	public ButtonGroup getGrupoBotoesPesos(){
		
		if(grupoBotoesPesos == null){
			grupoBotoesPesos = new ButtonGroup();
			grupoBotoesPesos.add(getRadioBotaoPesosDoArquivo());
			grupoBotoesPesos.add(getRadioBotaoPesosManual());
		}
		return grupoBotoesPesos;
		
	}
		
	public JTextField getCampoTextoPesosDoArquivo(){
		
		if(campoTextoPesosDoArquivo == null){
			campoTextoPesosDoArquivo = new JTextField(18);
			campoTextoPesosDoArquivo.setEditable(false);
		}
		return campoTextoPesosDoArquivo;
		
	}
	
	public JButton getBotaoLimparPesos(){
		
		if(botaoLimparPesos == null){
			botaoLimparPesos = new JButton("Limpar");
			botaoLimparPesos.setSize(new Dimension(30, 20));
			botaoLimparPesos.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoLimparPesos.setCursor(new Cursor(Cursor.HAND_CURSOR));
			botaoLimparPesos.setToolTipText("Limpar caixa de texto");
		}
		return botaoLimparPesos;
		
	}
	
	public JButton getBotaoEditarPesos(){
		
		if(botaoEditarPesos == null){
			botaoEditarPesos = new JButton("Editar");
			botaoEditarPesos.setSize(new Dimension(30, 20));
			botaoEditarPesos.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoEditarPesos.setCursor(new Cursor(Cursor.HAND_CURSOR));
			botaoEditarPesos.setToolTipText("Editar arquivo de pesos");
		}
		return botaoEditarPesos;
		
	}
	
	public JPanel getPainelPesosManual(){

		GridBagConstraints c = new GridBagConstraints();
		
		if(painelPesosManual == null){
			painelPesosManual = new JPanel(new GridBagLayout());
			painelPesosManual.setBackground(new Color(173, 200, 226));
			
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.ipadx = 180;
			c.ipady = 20;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.LINE_START;
			painelPesosManual.add(getPainelRolagemAreaTextoPesos(), c);
			
			c.gridx = 1;
			c.ipadx = 0;
			c.ipady = 0;
			c.fill = GridBagConstraints.NONE;
			c.anchor = GridBagConstraints.LINE_END;
			painelPesosManual.add(getBotaoLimparPesos(), c);
		}
		return painelPesosManual;
		
	}
	
	public JPanel getPainelPesosDoArquivo(){
		
		GridBagConstraints c = new GridBagConstraints();
		
		if(painelPesosDoArquivo == null){
			painelPesosDoArquivo = new JPanel();
			painelPesosDoArquivo.setLayout(new GridBagLayout());
			painelPesosDoArquivo.setBackground(new Color(173, 200, 226));
			
			c.weightx = 0.5;
			painelPesosDoArquivo.add(getLabelPesosDoArquivo(), c);
			
			c.gridx = 1;
			c.gridwidth = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			painelPesosDoArquivo.add(getCampoTextoPesosDoArquivo(), c);
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			//c.weightx = 0.0;
			c.fill = GridBagConstraints.NONE;
			c.anchor = GridBagConstraints.LINE_END;
			painelPesosDoArquivo.add(getBotaoPesosAbrir(), c);

			c.gridx = 2;
			c.weightx = 0.0;
			painelPesosDoArquivo.add(getBotaoEditarPesos(), c);
		}
		return painelPesosDoArquivo;
		
	}
	
	public JPanel getPainelCardPesos(){
		
		if(painelCardPesos == null){
			painelCardPesos = new JPanel(new CardLayout());
			painelCardPesos.setBackground(new Color(173, 200, 226));
			painelCardPesos.add(getPainelPesosDoArquivo(), "Do arquivo");
			painelCardPesos.add(getPainelPesosManual(), "Manual");
		}
		return painelCardPesos;
		
	}
	
	public JPanel getPainelDistribuicaoGamma(){
		
		TitledBorder bordaTitulo = null;
		
		if(painelDistribuicaoGamma == null){
			painelDistribuicaoGamma = new JPanel();
			painelDistribuicaoGamma.setBackground(new Color(173, 200, 226));
			painelDistribuicaoGamma.setSize(new Dimension(size1.width, size1.height+40));
			painelDistribuicaoGamma.setLocation(new Point(coluna1, nivel2));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Distribuição Gamma");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelDistribuicaoGamma.setBorder(bordaTitulo);
			painelDistribuicaoGamma.add(getLabelCoeficienteVariacao());
			painelDistribuicaoGamma.add(getCampoNumericoCV());
			painelDistribuicaoGamma.add(getCheckBoxSitiosInvariantes());
			painelDistribuicaoGamma.add(getLabelSitiosInvariantes());
			painelDistribuicaoGamma.add(getSpinnerSitiosInvariantes());
		}
		return painelDistribuicaoGamma;
		
	}
	
	public JLabel getLabelCoeficienteVariacao(){
		
		if(labelCoeficienteVariacao == null){
			labelCoeficienteVariacao = new JLabel("Coeficiente de variação: ");
			//labelCoeficienteVariacao.setBounds(new Rectangle(0, 110, 100, 200));
			labelCoeficienteVariacao.setToolTipText(
					"<html>" +
					"Inserir um coeficiente de variação para a taxa de " +
					"substituição entre sítios<br>*Deve ser positivo" +
					"</html>");
		}
		return labelCoeficienteVariacao;
		
	}
	
	public JNumberFloatField getCampoNumericoCV(){
		
		if(campoNumericoCV == null){
			campoNumericoCV = new JNumberFloatField();
			// campoNumericoCV.setSize(new Dimension(20, 10));
			//campoTextoCV.setBounds(new Rectangle(0, 110, 100, 200));
			campoNumericoCV.setToolTipText(
					"<html>" +
					"Inserir um coeficiente de variação para a taxa de " +
					"substituição entre sítios<br>" +
					"*Deve ser positivo" +
					"</html>");
		}
		return campoNumericoCV;
		
	}
	

	public JCheckBox getCheckBoxSitiosInvariantes(){
		
		if(checkBoxSitiosInvariantes == null){
			checkBoxSitiosInvariantes = new JCheckBox();
			checkBoxSitiosInvariantes.setText("Definir sítios invariantes");
			//checkBoxSitiosInvariantes.setSize(new Dimension(100, 10));
		}
		return checkBoxSitiosInvariantes;
	}
	
	public JLabel getLabelSitiosInvariantes(){
		
		if(labelSitiosInvariantes == null){
			labelSitiosInvariantes = new JLabel("Sítios Invariantes: ");
			//labelSitiosInvariantes.setBounds(new Rectangle(0, 110, 100, 200));
			//labelSitiosInvariantes.setEnabled(false);
			labelSitiosInvariantes.setToolTipText(
					"<html>" +
					"Fração de sítios invariantes<br>" +
					"*Deve estar entre 0 e 1" +
					"</html>");
		}
		return labelSitiosInvariantes;
		
	}
	
	public JSpinner getSpinnerSitiosInvariantes(){
		
		SpinnerModel sitiosInvariantesSpinnerModel = new SpinnerNumberModel(0.01, 0.01, 0.99, 0.01);
		
		if(spinnerSitiosInvariantes == null){
			spinnerSitiosInvariantes = new JSpinner(sitiosInvariantesSpinnerModel);
			//spinnerSitiosInvariantes.setBounds(new Rectangle(0, 110, 100, 200));
			//spinnerSitiosInvariantes.setEnabled(false);
			spinnerSitiosInvariantes.setToolTipText(
					"<html>" +
					"Fração de sítios invariantes<br>" +
					"*Deve estar entre 0 e 1" +
					"</html>");
		}
		return spinnerSitiosInvariantes;
		
	}
	
	public JPanel getPainelFrequencias(){
		
		TitledBorder bordaTitulo = null;
		GridBagConstraints c = new GridBagConstraints();
		
		if(painelFrequencias == null){
			painelFrequencias = new JPanel();
			painelFrequencias.setLayout(new GridBagLayout());
			painelFrequencias.setBackground(new Color(173, 200, 226));
			painelFrequencias.setSize(size2);
			painelFrequencias.setLocation(new Point(coluna2, nivel2));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Frequências");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelFrequencias.setBorder(bordaTitulo);
			painelFrequencias.setToolTipText(
					"<html>" +
					"Frequências para as bases<br>" +
					"*A soma das frequências deve ser igual a 1" +
					"</html>");
			
			c.gridx = 0;
			c.gridy = 0;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 3;
			painelFrequencias.add(getCheckBoxFrequenciasEmpiricas(), c);
			
			c.gridx = 0;
			c.gridy = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getLabelFrequenciasA(), c);
			
			c.gridx = 1;
			c.gridy = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getSliderFrequenciasA(), c);

			c.gridx = 2;
			c.gridy = 1;
			c.fill = GridBagConstraints.EAST;
			c.gridwidth = 1;
			painelFrequencias.add(getSpinnerFrequenciasA(), c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getLabelFrequenciasC(), c);

			c.gridx = 1;
			c.gridy = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getSliderFrequenciasC(), c);

			c.gridx = 2;
			c.gridy = 2;
			c.fill = GridBagConstraints.EAST;
			c.gridwidth = 1;
			painelFrequencias.add(getSpinnerFrequenciasC(), c);

			c.gridx = 0;
			c.gridy = 3;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getLabelFrequenciasG(), c);

			c.gridx = 1;
			c.gridy = 3;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getSliderFrequenciasG(), c);

			c.gridx = 2;
			c.gridy = 3;
			c.fill = GridBagConstraints.EAST;
			c.gridwidth = 1;
			painelFrequencias.add(getSpinnerFrequenciasG(), c);
			
			c.gridx = 0;
			c.gridy = 4;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getLabelFrequenciasT(), c);

			c.gridx = 1;
			c.gridy = 4;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridwidth = 1;
			painelFrequencias.add(getSliderFrequenciasT(), c);

			c.gridx = 2;
			c.gridy = 4;
			c.fill = GridBagConstraints.EAST;
			c.gridwidth = 1;
			painelFrequencias.add(getSpinnerFrequenciasT(), c);

			c.gridx = 0;
			c.gridy = 5;
			c.fill = GridBagConstraints.WEST;
			c.anchor = GridBagConstraints.LINE_END;
			c.gridwidth = 2;
			painelFrequencias.add(getLabelFrequenciasTotal(), c);

			c.gridx = 2;
			c.gridy = 5;
			c.fill = GridBagConstraints.EAST;
			c.anchor = GridBagConstraints.CENTER;
			c.gridwidth = 1;
			painelFrequencias.add(getLabelFrequenciasTotalNum(), c);
		}
		return painelFrequencias;
		
	}
	
	public JCheckBox getCheckBoxFrequenciasEmpiricas(){
		
		if(checkBoxFrequenciasEmpiricas == null){
			checkBoxFrequenciasEmpiricas = new JCheckBox();
			checkBoxFrequenciasEmpiricas.setText("Definir frequências");
			//checkBoxFrequenciasEmpiricas.setSelected(true);
			// checkBoxFrequenciasEmpiricas.setAlignmentX(CENTER_ALIGNMENT);
		}
		return checkBoxFrequenciasEmpiricas;
		
	}
	
	public JLabel getLabelFrequenciasA(){
		
		if(labelFrequenciasA == null){
			labelFrequenciasA = new JLabel("A");
			labelFrequenciasA.setToolTipText("Adenina");
		}
		return labelFrequenciasA;
		
	}
	
	public JLabel getLabelFrequenciasC(){
		
		if(labelFrequenciasC == null){
			labelFrequenciasC = new JLabel("C");
			labelFrequenciasC.setToolTipText("Citosina");
		}
		return labelFrequenciasC;
		
	}
	
	public JLabel getLabelFrequenciasG(){
		
		if(labelFrequenciasG == null){
			labelFrequenciasG = new JLabel("G");
			labelFrequenciasG.setToolTipText("Guanina");
		}
		return labelFrequenciasG;
		
	}
	
	public JLabel getLabelFrequenciasT(){
		
		if(labelFrequenciasT == null){
			labelFrequenciasT = new JLabel("T");
			labelFrequenciasT.setToolTipText("Timina");
		}
		return labelFrequenciasT;
		
	}
	
	public JSlider getSliderFrequenciasA(){
		
		if(sliderFrequenciasA == null){
			sliderFrequenciasA = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasA.setPreferredSize(new Dimension(120, 20));
			sliderFrequenciasA.setToolTipText("Frequência de adenina");
		}
		return sliderFrequenciasA;
		
	}
	
	public JSlider getSliderFrequenciasC(){
		
		if(sliderFrequenciasC == null){
			sliderFrequenciasC = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasC.setPreferredSize(new Dimension(120, 20));
			sliderFrequenciasC.setToolTipText("Frequência de citosina");
		}
		return sliderFrequenciasC;
		
	}
	
	public JSlider getSliderFrequenciasG(){
		
		if(sliderFrequenciasG == null){
			sliderFrequenciasG = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasG.setPreferredSize(new Dimension(120, 20));
			sliderFrequenciasG.setToolTipText("Frequência de guanina");
		}
		return sliderFrequenciasG;
		
	}
	
	public JSlider getSliderFrequenciasT(){
		
		if(sliderFrequenciasT == null){
			sliderFrequenciasT = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasT.setPreferredSize(new Dimension(120, 20));
			sliderFrequenciasT.setToolTipText("Frequência de timina");
		}
		return sliderFrequenciasT;
		
	}
	
	public JSpinner getSpinnerFrequenciasA(){
		
		SpinnerModel frequenciasSpinnerModel = new SpinnerNumberModel(0.25, 0.00, 1.00, 0.01);
		
		if(spinnerFrequenciasA == null){
			spinnerFrequenciasA = new JSpinner(frequenciasSpinnerModel);
			spinnerFrequenciasA.setPreferredSize(new Dimension(50, 20));
			//spinnerFrequenciasA.setBounds(new Rectangle(0, 110, 100, 200));
			//spinnerFrequenciasA.setEnabled(false);
			spinnerFrequenciasA.setToolTipText("Frequência de adenina");
		}
		return spinnerFrequenciasA;
		
	}
	
	public JSpinner getSpinnerFrequenciasC(){
		
		SpinnerModel frequenciasSpinnerModel = new SpinnerNumberModel(0.25, 0.00, 1.00, 0.01);
		
		if(spinnerFrequenciasC == null){
			spinnerFrequenciasC = new JSpinner(frequenciasSpinnerModel);
			spinnerFrequenciasC.setPreferredSize(new Dimension(50, 20));
			//spinnerFrequenciasC.setBounds(new Rectangle(0, 110, 100, 200));
			//spinnerFrequenciasC.setEnabled(false);
			spinnerFrequenciasC.setToolTipText("Frequência de citosina");
		}
		return spinnerFrequenciasC;
		
	}
	
	public JSpinner getSpinnerFrequenciasG(){
		
		SpinnerModel frequenciasSpinnerModel = new SpinnerNumberModel(0.25, 0.00, 1.00, 0.01);
		
		if(spinnerFrequenciasG == null){
			spinnerFrequenciasG = new JSpinner(frequenciasSpinnerModel);
			spinnerFrequenciasG.setPreferredSize(new Dimension(50, 20));
			//spinnerFrequenciasG.setBounds(new Rectangle(0, 110, 100, 200));
			//spinnerFrequenciasG.setEnabled(false);
			spinnerFrequenciasG.setToolTipText("Frequência de guanina");
		}
		return spinnerFrequenciasG;
		
	}
	
	public JSpinner getSpinnerFrequenciasT(){
		
		SpinnerModel frequenciasSpinnerModel = new SpinnerNumberModel(0.25, 0.00, 1.00, 0.01);
		
		if(spinnerFrequenciasT == null){
			spinnerFrequenciasT = new JSpinner(frequenciasSpinnerModel);
			spinnerFrequenciasT.setPreferredSize(new Dimension(50, 20));
			//spinnerFrequenciasT.setBounds(new Rectangle(0, 110, 100, 200));
			//spinnerFrequenciasT.setEnabled(false);
			spinnerFrequenciasT.setToolTipText("Frequência de timina");
		}
		return spinnerFrequenciasT;
		
	}
	
	public JLabel getLabelFrequenciasTotal(){
		
		if(labelFrequenciasTotal == null){
			labelFrequenciasTotal = new JLabel("Total: ");
		}
		return labelFrequenciasTotal;
		
	}
	
	public JLabel getLabelFrequenciasTotalNum(){
		
		if(labelFrequenciasTotalNum == null){
			labelFrequenciasTotalNum = new JLabel("1,00");
		}
		return labelFrequenciasTotalNum;
		
	}
	
	public JPanel getPainelCategorias(){
		
		TitledBorder bordaTitulo = null;
		GridBagConstraints c = new GridBagConstraints();
		
		if(painelCategorias == null){
			painelCategorias = new JPanel();
			painelCategorias.setLayout(new GridBagLayout());
			painelCategorias.setBackground(new Color(173, 200, 226));
			painelCategorias.setSize(size3.width, size3.height + 20);
			painelCategorias.setLocation(new Point(coluna2, nivel3 - 20));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Categorias");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelCategorias.setBorder(bordaTitulo);
			// painelCategorias.add(getLabelCategoriasDefinir());
			painelCategorias.setToolTipText(
					"<html>" +
					"Definição de categorias<br>" +
					"*Valores relativos entre si" +
					"</html>");
			
			c.gridx = 0;
			c.gridy = 0;
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.gridwidth = 5;
			// c.fill = GridBagConstraints.HORIZONTAL;
			// c.anchor = GridBagConstraints.PAGE_START;
			painelCategorias.add(getCheckBoxCategorias(), c);
			
/*			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 5;
			//c.gridheight = 5;
			//c.anchor = GridBagConstraints.CENTER;
			//c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.insets = new Insets(0, 0, 0, 0);
			//c.ipadx = 0;
			//c.ipady = 0;
			painelCategorias.add(getCheckBoxCategorias(), c);*/
			
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			painelCategorias.add(getSpinnerCategoriasNum(), c);
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria1(), c);
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria1(), c);
			
			c.gridx = 2;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria2(), c);
			
			c.gridx = 2;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria2(), c);
			
			c.gridx = 3;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria3(), c);
			
			c.gridx = 3;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria3(), c);
			
			c.gridx = 4;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria4(), c);
			
			c.gridx = 4;
			c.gridy = 1;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria4(), c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria5(), c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria5(), c);
			
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria6(), c);
			
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria6(), c);
			
			c.gridx = 2;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria7(), c);
			
			c.gridx = 2;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria7(), c);
			
			c.gridx = 3;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria8(), c);
			
			c.gridx = 3;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria8(), c);
			
			c.gridx = 4;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getLabelCategoria9(), c);
			
			c.gridx = 4;
			c.gridy = 2;
			c.gridwidth = 1;
			c.ipadx = 20;
			//c.fill = GridBagConstraints.REMAINDER;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getCampoNumericoCategoria9(), c);
			
/*			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 3;
			c.ipadx = 0;
			c.anchor = GridBagConstraints.LINE_END;
			painelCategorias.add(getLabelCategoriasDoArquivo(), c);
			
			c.gridx = 3;
			c.gridy = 3;
			c.gridwidth = 2;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategorias.add(getBotaoCategoriasAbrir(), c);*/

			
/*			c.gridx = 0;
			c.gridy = 4;
			c.gridwidth = 5;
			c.anchor = GridBagConstraints.CENTER;
			painelCategorias.add(getPainelRolagemAreaTextoCategorias(), c);*/
			
			
/*			c.gridx = 0;
			c.gridy = 1;
			c.anchor = GridBagConstraints.CENTER;
			c.gridwidth = 1;
			painelPesos.add(getLabelCategoriasDoArquivo(), c);*/
			
			c.ipadx = 0;
			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 3;
			c.anchor = GridBagConstraints.EAST;
			painelCategorias.add(getRadioBotaoCategoriasDoArquivo(), c);

			c.gridx = 3;
			c.gridy = 3;
			c.gridwidth = 2;
			c.anchor = GridBagConstraints.WEST;
			painelCategorias.add(getRadioBotaoCategoriasManual(), c);
			
			c.gridx = 0;
			c.gridy = 4;
			c.gridwidth = 5;
			c.anchor = GridBagConstraints.CENTER;
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(3, 3, 3, 3);
			painelCategorias.add(getPainelCardCategorias(), c);
			
			getGrupoBotoesCategorias();
			
		}
		return painelCategorias;
		
	}
	
	public JLabel getLabelCategoriasDefinir(){
		
		if(labelCategoriasDefinir == null){
			labelCategoriasDefinir = new JLabel("Definir categorias");
			//labelCategoriasDefinir.setBounds(new Rectangle(0, 110, 100, 200));
		}
		return labelCategoriasDefinir;
		
	}
	
	public JLabel getLabelCategoria1(){
		
		if(labelCategoria1 == null){
			labelCategoria1 = new JLabel("1:");
		}
		return labelCategoria1;
	}
	
	
	public JTextField getCampoNumericoCategoria1(){
		
		if(campoNumericoCategoria1 == null){
			campoNumericoCategoria1 = new JTextField();
			campoNumericoCategoria1.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria1;
		
	}
	
	public JLabel getLabelCategoria2(){
		
		if(labelCategoria2 == null){
			labelCategoria2 = new JLabel("2:");
		}
		return labelCategoria2;
	}
	
	
	public JTextField getCampoNumericoCategoria2(){
		
		if(campoNumericoCategoria2 == null){
			campoNumericoCategoria2 = new JTextField();
			campoNumericoCategoria2.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria2;
		
	}
	
	public JLabel getLabelCategoria3(){
		
		if(labelCategoria3 == null){
			labelCategoria3 = new JLabel("3:");
		}
		return labelCategoria3;
	}
	
	
	public JTextField getCampoNumericoCategoria3(){
		
		if(campoNumericoCategoria3 == null){
			campoNumericoCategoria3 = new JTextField();
			campoNumericoCategoria3.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria3;
		
	}
	
	public JLabel getLabelCategoria4(){
		
		if(labelCategoria4 == null){
			labelCategoria4 = new JLabel("4:");
		}
		return labelCategoria4;
	}
	
	
	public JTextField getCampoNumericoCategoria4(){
		
		if(campoNumericoCategoria4 == null){
			campoNumericoCategoria4 = new JTextField();
			campoNumericoCategoria4.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria4;
		
	}
	
	public JLabel getLabelCategoria5(){
		
		if(labelCategoria5 == null){
			labelCategoria5 = new JLabel("5:");
		}
		return labelCategoria5;
	}
	
	
	public JTextField getCampoNumericoCategoria5(){
		
		if(campoNumericoCategoria5 == null){
			campoNumericoCategoria5 = new JTextField();
			campoNumericoCategoria5.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria5;
		
	}
	
	public JLabel getLabelCategoria6(){
		
		if(labelCategoria6 == null){
			labelCategoria6 = new JLabel("6:");
		}
		return labelCategoria6;
	}
	
	
	public JTextField getCampoNumericoCategoria6(){
		
		if(campoNumericoCategoria6 == null){
			campoNumericoCategoria6 = new JTextField();
			campoNumericoCategoria6.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria6;
		
	}
	
	public JLabel getLabelCategoria7(){
		
		if(labelCategoria7 == null){
			labelCategoria7 = new JLabel("7:");
		}
		return labelCategoria7;
	}
	
	
	public JTextField getCampoNumericoCategoria7(){
		
		if(campoNumericoCategoria7 == null){
			campoNumericoCategoria7 = new JTextField();
			campoNumericoCategoria7.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria7;
		
	}
	
	public JLabel getLabelCategoria8(){
		
		if(labelCategoria8 == null){
			labelCategoria8 = new JLabel("8:");
		}
		return labelCategoria8;
	}
	
	
	public JTextField getCampoNumericoCategoria8(){
		
		if(campoNumericoCategoria8 == null){
			campoNumericoCategoria8 = new JTextField();
			campoNumericoCategoria8.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria8;
		
	}
	
	public JLabel getLabelCategoria9(){
		
		if(labelCategoria9 == null){
			labelCategoria9 = new JLabel("9:");
		}
		return labelCategoria9;
	}
	
	
	public JTextField getCampoNumericoCategoria9(){
		
		if(campoNumericoCategoria9 == null){
			campoNumericoCategoria9 = new JTextField();
			campoNumericoCategoria9.setToolTipText("Valor deve ser não negativo");
		}
		return campoNumericoCategoria9;
		
	}
	
	public JLabel getLabelCategoriasDoArquivo(){
		
		if(labelCategoriasDoArquivo == null){
			labelCategoriasDoArquivo = new JLabel("Arquivo: ");
		}
		return labelCategoriasDoArquivo;
	}
	
	public JCheckBox getCheckBoxCategorias(){
		
		if(checkBoxCategorias == null){
			checkBoxCategorias = new JCheckBox("Definir categorias");
		}
		return checkBoxCategorias;
	}
	
	public JSpinner getSpinnerCategoriasNum(){

		SpinnerModel numCategoriasSpinnerModel = new SpinnerNumberModel(1, 1, 9, 1);

		if(spinnerCategoriasNum == null){
			spinnerCategoriasNum = new JSpinner(numCategoriasSpinnerModel);
			//spinnerCategoriasNum.setSize(new Dimension(30, 20));
			//spinnerCategoriasNum.setBounds(new Rectangle(5, 100, 90, 100));
		}
		return spinnerCategoriasNum;
		
	}
	
	public JScrollPane getPainelRolagemAreaTextoCategorias(){
		
		if(painelRolagemAreaTextoCategorias == null){
			painelRolagemAreaTextoCategorias = new JScrollPane(getAreaTextoCategorias());
		}
		return painelRolagemAreaTextoCategorias;
		
	}
	
	public JTextArea getAreaTextoCategorias(){
		
		if(areaTextoCategorias == null){
			areaTextoCategorias = new JTextArea(3, 16);
			//areaTextoCategorias.setBounds(new Rectangle(5, 130, 90, 100));
			areaTextoCategorias.setToolTipText(
					"<html>" +
					"Indique as categorias que serão seguidas pelos sítios " +
					"correspondentes<br>" +
					"</html>");
		}
		return areaTextoCategorias;
	}
	
	public JButton getBotaoCategoriasAbrir(){
		
		if(botaoCategoriasAbrir == null){
			botaoCategoriasAbrir = new JButton("Abrir");
			botaoCategoriasAbrir.setSize(new Dimension(30, 20));
			botaoCategoriasAbrir.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoCategoriasAbrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
			botaoCategoriasAbrir.setToolTipText("Abrir arquivo de categorias");
		}
		return botaoCategoriasAbrir;
	}
	
	public JRadioButton getRadioBotaoCategoriasManual(){
		
		if(radioBotaoCategoriasManual == null){
			radioBotaoCategoriasManual = new JRadioButton("Manual");
			radioBotaoCategoriasManual.setToolTipText(
					"<html>" +
					"Atribuir categorias aos sítios manualmente<br>" +
					"</html>");
		}
		return radioBotaoCategoriasManual;
		
	}
		
	public JRadioButton getRadioBotaoCategoriasDoArquivo(){
		
		if(radioBotaoCategoriasDoArquivo == null){
			radioBotaoCategoriasDoArquivo = new JRadioButton("Do arquivo");
			radioBotaoCategoriasDoArquivo.setToolTipText(
					"<html>" +
					"Utilizar um arquivo de categorias<br>" +
					"</html>");
		}
		return radioBotaoCategoriasDoArquivo;
		
	}
		
	public ButtonGroup getGrupoBotoesCategorias(){
		
		if(grupoBotoesCategorias == null){
			grupoBotoesCategorias = new ButtonGroup();
			grupoBotoesCategorias.add(getRadioBotaoCategoriasDoArquivo());
			grupoBotoesCategorias.add(getRadioBotaoCategoriasManual());
		}
		return grupoBotoesCategorias;
		
	}
		
	public JTextField getCampoTextoCategoriasDoArquivo(){
		
		if(campoTextoCategoriasDoArquivo == null){
			campoTextoCategoriasDoArquivo = new JTextField(18);
			campoTextoCategoriasDoArquivo.setEditable(false);
		}
		return campoTextoCategoriasDoArquivo;
		
	}
	
	public JButton getBotaoLimparCategorias(){
		
		if(botaoLimparCategorias == null){
			botaoLimparCategorias = new JButton("Limpar");
			botaoLimparCategorias.setSize(new Dimension(30, 20));
			botaoLimparCategorias.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoLimparCategorias.setCursor(new Cursor(Cursor.HAND_CURSOR));
			botaoLimparCategorias.setToolTipText("Limpar caixa de texto");
		}
		return botaoLimparCategorias;
		
	}
	
	public JButton getBotaoEditarCategorias(){
		
		if(botaoEditarCategorias == null){
			botaoEditarCategorias = new JButton("Editar");
			botaoEditarCategorias.setSize(new Dimension(30, 20));
			botaoEditarCategorias.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoEditarCategorias.setCursor(new Cursor(Cursor.HAND_CURSOR));
			botaoEditarCategorias.setToolTipText("Editar arquivo de categorias");
		}
		return botaoEditarCategorias;
		
	}
	
	public JPanel getPainelCategoriasManual(){

		GridBagConstraints c = new GridBagConstraints();
		
		if(painelCategoriasManual == null){
			painelCategoriasManual = new JPanel(new GridBagLayout());
			painelCategoriasManual.setBackground(new Color(173, 200, 226));
			
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.ipadx = 180;
			c.ipady = 20;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.LINE_START;
			painelCategoriasManual.add(getPainelRolagemAreaTextoCategorias(), c);
			
			c.gridx = 1;
			c.ipadx = 0;
			c.ipady = 0;
			c.fill = GridBagConstraints.NONE;
			c.anchor = GridBagConstraints.LINE_END;
			painelCategoriasManual.add(getBotaoLimparCategorias(), c);
		}
		return painelCategoriasManual;
		
	}
	
	public JPanel getPainelCategoriasDoArquivo(){
		
		GridBagConstraints c = new GridBagConstraints();
		
		if(painelCategoriasDoArquivo == null){
			painelCategoriasDoArquivo = new JPanel();
			painelCategoriasDoArquivo.setLayout(new GridBagLayout());
			painelCategoriasDoArquivo.setBackground(new Color(173, 200, 226));
			
			c.weightx = 0.5;
			painelCategoriasDoArquivo.add(getLabelCategoriasDoArquivo(), c);
			
			c.gridx = 1;
			c.gridwidth = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			painelCategoriasDoArquivo.add(getCampoTextoCategoriasDoArquivo(), c);
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			//c.weightx = 0.0;
			c.fill = GridBagConstraints.NONE;
			c.anchor = GridBagConstraints.LINE_END;
			painelCategoriasDoArquivo.add(getBotaoCategoriasAbrir(), c);

			c.gridx = 2;
			c.weightx = 0.0;
			painelCategoriasDoArquivo.add(getBotaoEditarCategorias(), c);
		}
		return painelCategoriasDoArquivo;
		
	}
	
	public JPanel getPainelCardCategorias(){
		
		if(painelCardCategorias == null){
			painelCardCategorias = new JPanel(new CardLayout());
			painelCardCategorias.setBackground(new Color(173, 200, 226));
			painelCardCategorias.add(getPainelCategoriasDoArquivo(), "Do arquivo");
			painelCardCategorias.add(getPainelCategoriasManual(), "Manual");
		}
		return painelCardCategorias;
		
	}
	
	public JPanel getPainelPreferencia(){

		TitledBorder bordaTitulo = null;
		
		if(painelPreferencia == null){
			painelPreferencia = new JPanel();
			//painelPreferencia.setLayout(null);
			painelPreferencia.setBackground(new Color(173, 200, 226));
			painelPreferencia.setSize(new Dimension(size1));
			painelPreferencia.setLocation(new Point(coluna1, nivel2 + size1.height + 40));
			//painelPreferencia.setBorder(BorderFactory.createLineBorder(Color.white));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Preferência de Execução");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelPreferencia.setBorder(bordaTitulo);
			// painelPreferencia.add(getLabelPreferencia());
			painelPreferencia.add(getCheckBoxExatidao());
			painelPreferencia.add(getCheckBoxExecucao());
			painelPreferencia.setToolTipText("Critérios preferencias de execução");
		}
		return painelPreferencia;
		
	}
	
	public JLabel getLabelPreferencia(){
		
		if(labelPreferencia == null){
			labelPreferencia = new JLabel("Prioridade: ");
			//labelPreferencia.setSize(50, 30);
		}
		return labelPreferencia;
	}
	
	public JCheckBox getCheckBoxExatidao(){
		
		if(checkBoxExatidao == null){
			checkBoxExatidao = new JCheckBox();
			checkBoxExatidao.setText("Exatidão");
			//checkBoxExatidao.setSelected(true);
			//checkBoxExatidao.setSize(50, 30);
			checkBoxExatidao.setToolTipText("Priorizar exatidão do método");
		}
		return checkBoxExatidao;
	}
	
	public JCheckBox getCheckBoxExecucao(){
		
		if(checkBoxExecucao == null){
			checkBoxExecucao = new JCheckBox();
			checkBoxExecucao.setText("Tempo");
			checkBoxExecucao.setToolTipText("Priorizar tempo de execução");
		}
		return checkBoxExecucao;
	}
	
	
	// Botões laterais
	
	public JPanel getPainelBotoes(){
		
		if(painelBotoes == null){
			painelBotoes = new JPanel();
			painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
			painelBotoes.setBackground(new Color(173, 200, 226));
			//painelBotoes.setSize(new Dimension(700, 60));
			//painelBotoes.setLocation(new Point(0, 31));
			painelBotoes.add(getBotaoInicio());
			painelBotoes.add(getBotaoEditor());
			painelBotoes.add(getBotaoVoltar());
			painelBotoes.add(getBotaoExecutar());
			painelBotoes.add(getBotaoVisualizar());
		}
		return painelBotoes;
		
	}
	
	public JButton getBotaoInicio(){
		if(botaoInicio == null){
			botaoInicio = new JButton();
			botaoInicio.setBounds(new Rectangle(663+x, 150+y, 117, 25));
			botaoInicio.setText("Início");
			botaoInicio.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoInicio.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/home.png")));
			botaoInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return botaoInicio;
	}
	
	public JButton getBotaoEditor(){
		if(botaoEditor == null){
			botaoEditor = new JButton();
			botaoEditor.setText("Editor");
			botaoEditor.setSize(new Dimension(117, 25));
			botaoEditor.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/filoEditor.png")));
			botaoEditor.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoEditor.setLocation(new Point(663, 276));
			botaoEditor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
		return botaoEditor;
	}
	
	public JButton getBotaoVoltar(){
		if(botaoVoltar == null){
			botaoVoltar = new JButton();
			botaoVoltar.setText("Voltar");
			botaoVoltar.setSize(new Dimension(117, 25));
			botaoVoltar.setLocation(new Point(663, 120));
			botaoVoltar.setFont(new Font("Arial", Font.BOLD, 10));
			botaoVoltar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png")));
			botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return botaoVoltar;
	}
	
	public JButton getBotaoExecutar(){
		if(botaoExecutar == null){
			botaoExecutar = new JButton();
			botaoExecutar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/Ok.png")));
			botaoExecutar.setFont(new Font("Arial", Font.BOLD, 10));
			botaoExecutar.setSize(new Dimension(117, 25));
			botaoExecutar.setLocation(new Point(663, 70));
			botaoExecutar.setText("Executar");
			botaoExecutar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return botaoExecutar;
	}
	
	public JButton getBotaoVisualizar(){
		if(botaoVisualizar == null){
			botaoVisualizar = new JButton();
			botaoVisualizar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/HyperTree.gif")));
			botaoVisualizar.setLocation(new Point(663, 326));
			botaoVisualizar.setSize(new Dimension(117, 25));
			botaoVisualizar.setText("Visualizar");
			botaoVisualizar.setFont(new Font("Arial", Font.BOLD, 10));
			botaoVisualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return botaoVisualizar;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Janelinha de Execução
	 */

	public JDialog getDialogoModoExecucao() {
		if (dialogoModoExecucao == null) {
			dialogoModoExecucao = new JDialog(this);
			dialogoModoExecucao.setSize(new Dimension(252, 210));
			dialogoModoExecucao.setTitle("Modo de Execução");
			dialogoModoExecucao.setContentPane(getPainelModoExecucao());
			dialogoModoExecucao.setResizable(false);

			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			dialogoModoExecucao.setLocation(
					(dimension.width - ControladorIGrafu.digrafu.getX()) / 2,
					(dimension.height - ControladorIGrafu.digrafu.getY()) / 2
			);

			dialogoModoExecucao.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
		return dialogoModoExecucao;
	}

	public JPanel getPainelModoExecucao() {
		if (painelModoExecucao == null) {
			painelModoExecucao = new JPanel();
			painelModoExecucao.setLayout(null);
			painelModoExecucao.setBackground(new Color(230, 234, 240));
			painelModoExecucao.add(getPainelAbasModoExecucao(), null);
			painelModoExecucao.add(getBotaoModoExecucaoExecutar(), null);
		}
		return painelModoExecucao;
	}

	public JTabbedPane getPainelAbasModoExecucao() {
		if (painelAbasModoExecucao == null) {
			painelAbasModoExecucao = new JTabbedPane();
			painelAbasModoExecucao.setBounds(new Rectangle(0, 0, 242, 143));
			painelAbasModoExecucao.addTab("Sequencial", null, getPainelModoExecucaoSequencial(), null);
			painelAbasModoExecucao.addTab("Paralela", null, getPainelModoExecucaoParalela(), null);
		}
		return painelAbasModoExecucao;
	}
	
	public JPanel getPainelModoExecucaoSequencial() {
		
		if (painelModoExecucaoSequencial == null) {
			painelModoExecucaoSequencial = new JPanel();
			painelModoExecucaoSequencial.setLayout(null);
			painelModoExecucaoSequencial.setBackground(new Color(173, 200, 226));
			painelModoExecucaoSequencial.add(getComboModoExecucaoSequencial(), null);
		}
		return painelModoExecucaoSequencial;
	}

	public JComboBox getComboModoExecucaoSequencial(){
		
		String[] localExecucao = {"Servidor", "Nó 1", "Nó 2", "Nó 3", "Nó 4"};
		
		if(comboModoExecucaoSequencial == null){
			comboModoExecucaoSequencial = new JComboBox(localExecucao);
			comboModoExecucaoSequencial.setLocation(new Point(70, 41));
			comboModoExecucaoSequencial.setSize(new Dimension(105, 20));
			comboModoExecucaoSequencial.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return comboModoExecucaoSequencial;
		
	}
	
	public JPanel getPainelModoExecucaoParalela() {
		if (painelModoExecucaoParalela == null) {
			painelModoExecucaoParalela = new JPanel();
			painelModoExecucaoParalela.setLayout(null);
			painelModoExecucaoParalela.setBackground(new Color(173, 200, 226));
			painelModoExecucaoParalela.add(getComboModoExecucaoParalela(), null);
		}
		return painelModoExecucaoParalela;
	}
	
	public JComboBox getComboModoExecucaoParalela(){
		
		String[] numProcessadores = {"2", "3", "4"};
		
		if(comboModoExecucaoParalela == null){
			comboModoExecucaoParalela = new JComboBox(numProcessadores);
			comboModoExecucaoParalela.setLocation(new Point(70, 41));
			comboModoExecucaoParalela.setSize(new Dimension(105, 20));
			comboModoExecucaoParalela.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return comboModoExecucaoParalela;
		
	}
	
	public JButton getBotaoModoExecucaoExecutar() {
		if (botaoModoExecucaoExecutar == null) {
			botaoModoExecucaoExecutar = new JButton();
			botaoModoExecucaoExecutar.setSize(new Dimension(99, 22));
			botaoModoExecucaoExecutar.setLocation(new Point(71, 152));
			botaoModoExecucaoExecutar.setText("Executar");
		}
		return botaoModoExecucaoExecutar;
	}
	
	public JProgressBar getBarraProgressoExecucao() {
		if (barraProgressoExecucao == null) {
			barraProgressoExecucao = new JProgressBar();
			barraProgressoExecucao.setSize(new Dimension(194, 15));
			barraProgressoExecucao.setLocation(new Point(34, nivel3+size3.height));
			barraProgressoExecucao.setVisible(false);
		}
		return barraProgressoExecucao;
	}
	
}
