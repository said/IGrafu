package br.uesc.computacao.estagio.apresentacao.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import br.uesc.computacao.estagio.aplicacao.util.JNumberFloatField;

public class PainelParametrosDigrafu extends JPanel {

	int nivel1 = 5;
	int nivel2 = 68;
	int nivel3 = 230;
	int coluna1 = 10;
	int coluna2 = 320;
	Dimension size1 = new Dimension(300, 58);
	Dimension size2 = new Dimension(300, 140);
	Dimension size3 = new Dimension(300, 145);
	
	public static int x;
	public static int y;		
	
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
	
	public PainelParametrosDigrafu() {
		
		super();
		
		setBackground(new Color(173, 200, 226));
		setLayout(null);
		
		add(getPainelModelo());
		add(getPainelTransicaoTransversao());
		add(getPainelPesos());
		add(getPainelDistribuicaoGamma());
		add(getPainelCategorias());
		add(getPainelFrequencias());
		add(getPainelPreferencia());
		
	}
	
	public JPanel getPainelModelo(){
		
		TitledBorder bordaTitulo = null;
		
		if(painelModelo == null){
			painelModelo = new JPanel();
			painelModelo.setBackground(new Color(173, 200, 226));
			painelModelo.setSize(new Dimension(size1.width, size1.height));
			painelModelo.setLocation(new Point(coluna1, nivel1));
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Modelo");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelModelo.setBorder(bordaTitulo);
			// painelModelo.add(getLabelModelo(), BorderLayout.CENTER);
			// painelModelo.add(getComboModelo());
			painelModelo.add(getPainelCardModelo());
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
		
		String[] modelos = {"kimura", "f84", "jc69", "logdet"};
		
		if(comboModeloDNA == null){
			comboModeloDNA = new JComboBox(modelos);
			comboModeloDNA.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return comboModeloDNA;
		
	}
	
	public JComboBox getComboModeloProteina(){
		
		String[] modelos = {"kimura", "jtt", "pmb", "pam"};
		
		if(comboModeloProteina == null){
			comboModeloProteina = new JComboBox(modelos);
			comboModeloProteina.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return comboModeloProteina;
		
	}
	
	public JPanel getPainelCardModelo(){
		
		if(painelCardModelo == null){
			painelCardModelo = new JPanel(new CardLayout());
			painelCardModelo.setBackground(new Color(173, 200, 226));
			painelCardModelo.add(getComboModeloDNA(), "dna");
			painelCardModelo.add(getComboModeloProteina(), "proteína");
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
			bordaTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Transicao/Transversao");
			bordaTitulo.setTitleJustification(TitledBorder.CENTER);
			bordaTitulo.setTitleFont(new Font("Arial", Font.BOLD, 12));
			painelTransicaoTransversao.setBorder(bordaTitulo);
			painelTransicaoTransversao.add(getCampoNumericoTransicaoTransversao());
		}
		return painelTransicaoTransversao;
		
	}
	
	public JNumberFloatField getCampoNumericoTransicaoTransversao(){
		
		if(campoNumericoTransicaoTransversao == null){
			campoNumericoTransicaoTransversao = new JNumberFloatField();
			// campoNumericoTransicaoTransversao.setValue(2);
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
		}
		return areaTextoPesos;
	}
	
	public JRadioButton getRadioBotaoPesosManual(){
		
		if(radioBotaoPesosManual == null){
			radioBotaoPesosManual = new JRadioButton("Manual");
		}
		return radioBotaoPesosManual;
		
	}
		
	public JRadioButton getRadioBotaoPesosDoArquivo(){
		
		if(radioBotaoPesosDoArquivo == null){
			radioBotaoPesosDoArquivo = new JRadioButton("Do arquivo");
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
		}
		return botaoLimparPesos;
		
	}
	
	public JButton getBotaoEditarPesos(){
		
		if(botaoEditarPesos == null){
			botaoEditarPesos = new JButton("Editar");
			botaoEditarPesos.setSize(new Dimension(30, 20));
			botaoEditarPesos.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoEditarPesos.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		}
		return labelCoeficienteVariacao;
		
	}
	
	public JNumberFloatField getCampoNumericoCV(){
		
		if(campoNumericoCV == null){
			campoNumericoCV = new JNumberFloatField();
			// campoNumericoCV.setSize(new Dimension(20, 10));
			//campoTextoCV.setBounds(new Rectangle(0, 110, 100, 200));
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
		}
		return labelSitiosInvariantes;
		
	}
	
	public JSpinner getSpinnerSitiosInvariantes(){
		
		SpinnerModel sitiosInvariantesSpinnerModel = new SpinnerNumberModel(0.01, 0.01, 0.99, 0.01);
		
		if(spinnerSitiosInvariantes == null){
			spinnerSitiosInvariantes = new JSpinner(sitiosInvariantesSpinnerModel);
			//spinnerSitiosInvariantes.setBounds(new Rectangle(0, 110, 100, 200));
			//spinnerSitiosInvariantes.setEnabled(false);
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
		}
		return labelFrequenciasA;
		
	}
	
	public JLabel getLabelFrequenciasC(){
		
		if(labelFrequenciasC == null){
			labelFrequenciasC = new JLabel("C");
		}
		return labelFrequenciasC;
		
	}
	
	public JLabel getLabelFrequenciasG(){
		
		if(labelFrequenciasG == null){
			labelFrequenciasG = new JLabel("G");
		}
		return labelFrequenciasG;
		
	}
	
	public JLabel getLabelFrequenciasT(){
		
		if(labelFrequenciasT == null){
			labelFrequenciasT = new JLabel("T");
		}
		return labelFrequenciasT;
		
	}
	
	public JSlider getSliderFrequenciasA(){
		
		if(sliderFrequenciasA == null){
			sliderFrequenciasA = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasA.setPreferredSize(new Dimension(120, 20));
		}
		return sliderFrequenciasA;
		
	}
	
	public JSlider getSliderFrequenciasC(){
		
		if(sliderFrequenciasC == null){
			sliderFrequenciasC = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasC.setPreferredSize(new Dimension(120, 20));
		}
		return sliderFrequenciasC;
		
	}
	
	public JSlider getSliderFrequenciasG(){
		
		if(sliderFrequenciasG == null){
			sliderFrequenciasG = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasG.setPreferredSize(new Dimension(120, 20));
		}
		return sliderFrequenciasG;
		
	}
	
	public JSlider getSliderFrequenciasT(){
		
		if(sliderFrequenciasT == null){
			sliderFrequenciasT = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
			sliderFrequenciasT.setPreferredSize(new Dimension(120, 20));
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
		}
		return areaTextoCategorias;
	}
	
	public JButton getBotaoCategoriasAbrir(){
		
		if(botaoCategoriasAbrir == null){
			botaoCategoriasAbrir = new JButton("Abrir");
			botaoCategoriasAbrir.setSize(new Dimension(30, 20));
			botaoCategoriasAbrir.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoCategoriasAbrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return botaoCategoriasAbrir;
	}
	
	public JRadioButton getRadioBotaoCategoriasManual(){
		
		if(radioBotaoCategoriasManual == null){
			radioBotaoCategoriasManual = new JRadioButton("Manual");
		}
		return radioBotaoCategoriasManual;
		
	}
		
	public JRadioButton getRadioBotaoCategoriasDoArquivo(){
		
		if(radioBotaoCategoriasDoArquivo == null){
			radioBotaoCategoriasDoArquivo = new JRadioButton("Do arquivo");
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
		}
		return botaoLimparCategorias;
		
	}
	
	public JButton getBotaoEditarCategorias(){
		
		if(botaoEditarCategorias == null){
			botaoEditarCategorias = new JButton("Editar");
			botaoEditarCategorias.setSize(new Dimension(30, 20));
			botaoEditarCategorias.setFont(new Font("Dialog", Font.BOLD, 10));
			botaoEditarCategorias.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
		}
		return checkBoxExatidao;
	}
	
	public JCheckBox getCheckBoxExecucao(){
		
		if(checkBoxExecucao == null){
			checkBoxExecucao = new JCheckBox();
			checkBoxExecucao.setText("Tempo");
		}
		return checkBoxExecucao;
	}
	

}
