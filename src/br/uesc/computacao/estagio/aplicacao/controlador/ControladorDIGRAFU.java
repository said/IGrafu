package br.uesc.computacao.estagio.aplicacao.controlador;

/**
 * Classe controladora da tela DiGrafu
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.uesc.computacao.estagio.aplicacao.util.ManipulaArquivo;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import br.uesc.computacao.estagio.aplicacao.util.Processo;
import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.DIGRAFU;

/**
 * Classe que controla a tela DiGrafu
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */

public class ControladorDIGRAFU
		implements ActionListener, ChangeListener, KeyListener, ItemListener {

	/*
	 * Variaveis Globais
	 */
	
	JComponent editor = null;
	JSpinner.NumberEditor field = null;

	public static Processo processo = null;

	public static Navegar navegar = null;

	public static ManipulaArquivo arquivo = null;

	private ButtonGroup grupoBotoesSequenciaTipoDados = null;

	private ButtonGroup grupoBotoesModelosSubstituicaoDNA = null;

	private ButtonGroup grupoBotoesModelosSubstituicaoAA = null;

	private ButtonGroup grupoBotoesConfiguracoes = null;

	public static String ERRO = "Erro";
	public static String ERRO1 = "Erro - Não foi possível abrir a tela anterior!";
	public static String FECHAR = "Deseja sair do sistema?";
	public static String SAIR = "Sair";
	public static String CANCELAR = "Cancelar";

	public static String guardaArquivo = "";

	public static String guardaNomeSequencia = "";

	public static boolean perfil = false;

	public static String nomePerfil = "";

	/*
	 * Construtor
	 */
	public ControladorDIGRAFU() {
		ControladorIGrafu.digrafu = new DIGRAFU();
		

		editor = ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getEditor();
		field = (JSpinner.NumberEditor)editor;
		
		init();
		ControladorIGrafu.digrafu.setVisible(true);
		//System.gc();
		//ControladorIGrafu.digrafu.getJTabbedPaneModelosAA().setToolTipText("O tipo de dado selecionado é DNA.");
		// ControladorIGrafu.digrafu.repaint();


	}

	
	 // Metodo de inicializacao de campos e variaveis
	 
	private void init() {

		inicializaGerencia();
		inicializaCampos();

/*		if(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapNao().isSelected()) {
			if(ControladorIGrafu.conversor != null){
				if(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText() != "") {
					ControladorIGrafu.digrafu.getJTextFieldArquivoSequencia().setText(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());
				}
			}
		}
		else if(ControladorIGrafu.modoManualBootstrap.getJRadioButtonModoManualBootstrapSim().isSelected()) {
			if(ControladorIGrafu.seqboot != null){
				if(ControladorIGrafu.seqboot.getJTextFieldArquivoSequencia().getText() != "") {
					ControladorIGrafu.digrafu.getJTextFieldArquivoSequencia().setText(ControladorIGrafu.seqboot.getJTextFieldArquivoSequencia().getText());
					ControladorIGrafu.modoExecucao.getJTextFieldArquivoSequencia().setText(ControladorIGrafu.seqboot.getJTextFieldArquivoSequencia().getText());
				}
			}
		}*/


                
	}
	 
	public void inicializaGerencia() {

		// ControladorIGrafu.digrafu.getComboTipo().addActionListener(this);
		ControladorIGrafu.digrafu.getComboTipo().addItemListener(this);
		ControladorIGrafu.digrafu.getComboModeloDNA().addActionListener(this);
		ControladorIGrafu.digrafu.getComboModeloProteina().addActionListener(this);
		ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().addActionListener(this);
		ControladorIGrafu.digrafu.getCheckBoxPesos().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoPesosAbrir().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoEditarPesos().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoLimparPesos().addActionListener(this);
		ControladorIGrafu.digrafu.getRadioBotaoPesosManual().addActionListener(this);
		ControladorIGrafu.digrafu.getRadioBotaoPesosManual().setActionCommand("Manual");
		ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().addActionListener(this);
		ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().setActionCommand("Do arquivo");
		ControladorIGrafu.digrafu.getCampoNumericoCV().addActionListener(this);
		ControladorIGrafu.digrafu.getCampoNumericoCV().addKeyListener(this);
		ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().addActionListener(this);
		ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().addChangeListener(this);
		ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().addActionListener(this);
		ControladorIGrafu.digrafu.getSliderFrequenciasA().addChangeListener(this);
		ControladorIGrafu.digrafu.getSliderFrequenciasC().addChangeListener(this);
		ControladorIGrafu.digrafu.getSliderFrequenciasG().addChangeListener(this);
		ControladorIGrafu.digrafu.getSliderFrequenciasT().addChangeListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasA().addChangeListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasC().addChangeListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasG().addChangeListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasT().addChangeListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasA().addKeyListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasC().addKeyListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasG().addKeyListener(this);
		ControladorIGrafu.digrafu.getSpinnerFrequenciasT().addKeyListener(this);
		ControladorIGrafu.digrafu.getCheckBoxCategorias().addActionListener(this);
		ControladorIGrafu.digrafu.getSpinnerCategoriasNum().addChangeListener(this);
		field.getTextField().addKeyListener(this);
		ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoEditarCategorias().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoLimparCategorias().addActionListener(this);
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().addActionListener(this);
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setActionCommand("Manual");
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().addActionListener(this);
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setActionCommand("Do arquivo");
		ControladorIGrafu.digrafu.getCheckBoxExatidao().addActionListener(this);
		ControladorIGrafu.digrafu.getCheckBoxExecucao().addActionListener(this);

		ControladorIGrafu.digrafu.getBotaoEditor().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoExecutar().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoVoltar().addActionListener(this);
        ControladorIGrafu.digrafu.getBotaoInicio().addActionListener(this);
		ControladorIGrafu.digrafu.getBotaoVisualizar().addActionListener(this);
		
		ControladorIGrafu.digrafu.getBotaoModoExecucaoExecutar().addActionListener(this);
		ControladorIGrafu.digrafu.getComboModoExecucaoSequencial().addActionListener(this);
		ControladorIGrafu.digrafu.getComboModoExecucaoParalela().addActionListener(this);
		ControladorIGrafu.digrafu.getDialogoModoExecucao().addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				ControladorIGrafu.digrafu.getDialogoModoExecucao().removeNotify();
				ControladorIGrafu.digrafu.setEnabled(true);
			}
		});

		ControladorIGrafu.digrafu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ControladorIGrafu.digrafu.addWindowListener(new java.awt.event.WindowAdapter() {
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
	}
	
	public void inicializaCampos() {
		
		ControladorIGrafu.digrafu.getComboTipo().setSelectedIndex(0);
		// ControladorIGrafu.digrafu.getComboModelo().setSelectedIndex(0);
		ControladorIGrafu.digrafu.getComboModeloDNA().setSelectedIndex(0);
		
		ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().setValue(2);
		
		ControladorIGrafu.digrafu.getCampoNumericoCV().setText("");
		
		ControladorIGrafu.digrafu.getCheckBoxExatidao().setSelected(true);
		ControladorIGrafu.digrafu.getCheckBoxExecucao().setSelected(false);
		
		ControladorIGrafu.digrafu.getCheckBoxPesos().setSelected(false);
		ControladorIGrafu.digrafu.getLabelPesosDoArquivo().setEnabled(false);
		ControladorIGrafu.digrafu.getBotaoPesosAbrir().setEnabled(false);
		ControladorIGrafu.digrafu.getBotaoEditarPesos().setEnabled(false);
		ControladorIGrafu.digrafu.getAreaTextoPesos().setEnabled(false);
		ControladorIGrafu.digrafu.getRadioBotaoPesosManual().setEnabled(false);
		ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().setEnabled(false);
		ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().setSelected(true);
		
		ControladorIGrafu.digrafu.getCheckBoxCategorias().setSelected(false);
		ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
		ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
		ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
		ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
		ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setSelected(true);
		
		atualizaPainelPrincipal(GeraParametrosDIGRAFU.KIMURA);
		
		ControladorIGrafu.digrafu.repaint();

	}
	
	private void atualizaPainelPrincipal(int modelo){

		if(GeraParametrosDIGRAFU.getTipo() == "dna"){
			
			switch(modelo){
					
				case GeraParametrosDIGRAFU.LOGDET:
	
					ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().setEnabled(false);
					
					ControladorIGrafu.digrafu.getLabelCoeficienteVariacao().setEnabled(false);
					ControladorIGrafu.digrafu.getCampoNumericoCV().setEnabled(false);
					ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
					
					// ControladorIGrafu.digrafu.getPainelFrequencias().setEnabled(false);
					ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(false);
					
					ControladorIGrafu.digrafu.getLabelCategoriasDefinir().setEnabled(false);
					ControladorIGrafu.digrafu.getCheckBoxCategorias().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
					ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(false);
					ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
					ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
					ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(false);
					ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
					ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
					ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
					ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(false);
					ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(false);
					desabilitaCategorias();
					
					break;
					
				case GeraParametrosDIGRAFU.JC69:
	
					ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().setEnabled(false);
					
					ControladorIGrafu.digrafu.getLabelCoeficienteVariacao().setEnabled(true);
					ControladorIGrafu.digrafu.getCampoNumericoCV().setEnabled(true);
					
					if(ControladorIGrafu.digrafu.getCampoNumericoCV().getlength() > 0)
						ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(true);
					else 
						ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
					
					if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
						ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
					}
					else{
						ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
					}
					
					// ControladorIGrafu.digrafu.getPainelFrequencias().setEnabled(false);
					ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(false);
	
					ControladorIGrafu.digrafu.getLabelCategoriasDefinir().setEnabled(true);
					ControladorIGrafu.digrafu.getCheckBoxCategorias().setEnabled(true);
					
					if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected()){
						ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(true);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(true);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(true);
						habilitaCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
					}
					else{
						ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(false);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(false);
						desabilitaCategorias();
					}
					
					break;
					
				case GeraParametrosDIGRAFU.KIMURA:
	
					ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().setEnabled(true);
					
					ControladorIGrafu.digrafu.getLabelCoeficienteVariacao().setEnabled(true);
					ControladorIGrafu.digrafu.getCampoNumericoCV().setEnabled(true);
					
					if(ControladorIGrafu.digrafu.getCampoNumericoCV().getlength() > 0)
						ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(true);
					else 
						ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
					
					if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
						ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
					}
					else{
						ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
					}
					
					// ControladorIGrafu.digrafu.getPainelFrequencias().setEnabled(false);
					ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(false);
					ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(false);
	
					ControladorIGrafu.digrafu.getLabelCategoriasDefinir().setEnabled(true);
					ControladorIGrafu.digrafu.getCheckBoxCategorias().setEnabled(true);
					
					if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected()){
						ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(true);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(true);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(true);
						habilitaCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
					}
					else{
						ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(false);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(false);
						desabilitaCategorias();
					}
					
					break;
					
				case GeraParametrosDIGRAFU.F84:
	
					ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().setEnabled(true);
					
					ControladorIGrafu.digrafu.getLabelCoeficienteVariacao().setEnabled(true);
					ControladorIGrafu.digrafu.getCampoNumericoCV().setEnabled(true);
					
					if(ControladorIGrafu.digrafu.getCampoNumericoCV().getlength() > 0)
						ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(true);
					else 
						ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
					
					if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
						ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
					}
					else{
						ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
					}
					
					// ControladorIGrafu.digrafu.getPainelFrequencias().setEnabled(false);
					ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().setEnabled(true);
	
					if(ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().isSelected()){
						ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(true);
						ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(true);
						ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(true);
						ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(true);
						ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(true);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(true);
					}
					else{
						ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(false);
						ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(false);
						ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(false);
						ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(false);
						ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(false);
						ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(false);
					}
	
					ControladorIGrafu.digrafu.getLabelCategoriasDefinir().setEnabled(true);
					ControladorIGrafu.digrafu.getCheckBoxCategorias().setEnabled(true);
					
					if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected()){
						ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(true);
						ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(true);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(true);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(true);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(true);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(true);
						habilitaCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
					}
					else{
						ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(false);
						ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
						ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(false);
						ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(false);
						desabilitaCategorias();
					}
					
					break;
			}
			
		}else{ // Tipo Proteína

			// Painel Transição/Transversão
			ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().setEnabled(false);
			
			// Painel de Frequências
			// ControladorIGrafu.digrafu.getPainelFrequencias().setEnabled(false);
			ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(false);
			ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(false);
			ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(false);
			ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(false);
			ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(false);
			ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(false);
			ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(false);
			ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(false);
			ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(false);
			
			// Painel de Categorias
			ControladorIGrafu.digrafu.getLabelCategoriasDefinir().setEnabled(true);
			ControladorIGrafu.digrafu.getCheckBoxCategorias().setEnabled(true);
			
			if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected()){
				ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(true);
				ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(true);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(true);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(true);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(true);
				habilitaCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
			}
			else{
				ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(false);
				ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(false);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(false);
				desabilitaCategorias();
			}
			
			// Painel da Distribuição Gamma para o modelo Kimura
			if(modelo == GeraParametrosDIGRAFU.KIMURA){
				ControladorIGrafu.digrafu.getLabelCoeficienteVariacao().setEnabled(false);
				ControladorIGrafu.digrafu.getCampoNumericoCV().setEnabled(false);
				ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
			}
			else{
				ControladorIGrafu.digrafu.getLabelCoeficienteVariacao().setEnabled(true);
				ControladorIGrafu.digrafu.getCampoNumericoCV().setEnabled(true);
				
				if(ControladorIGrafu.digrafu.getCampoNumericoCV().getlength() > 0)
					ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(true);
				else 
					ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
				
				if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
					ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
					ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
				}
				else{
					ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
				}				
			}
			
		}
		
	}

	 // Trata Eventos
	 
	public void actionPerformed(ActionEvent e) {

		// DNA
		
		if(e.getSource() == ControladorIGrafu.digrafu.getComboModeloDNA()){
			
			atualizaPainelPrincipal(ControladorIGrafu.digrafu.getComboModeloDNA().getSelectedIndex());
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getComboModeloProteina()){
			
			atualizaPainelPrincipal(ControladorIGrafu.digrafu.getComboModeloProteina().getSelectedIndex());
			
		}

/*		
		if(e.getSource() == ControladorIGrafu.digrafu.getCampoNumericoCV()){
			if(ControladorIGrafu.digrafu.getCampoNumericoCV().getlength() > 0)
				ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(true);
			else 
				ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
			
			if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
				ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
				ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
			}
			else{
				ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
			}
			
		}
		*/
		if(e.getSource() == ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes()){
			
			if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
				ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
				ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
			}
			else{
				ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
			}
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes()){
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getCheckBoxExatidao()){
			
			if( ControladorIGrafu.digrafu.getCheckBoxExatidao().isSelected() == false &&
				ControladorIGrafu.digrafu.getCheckBoxExecucao().isSelected() == false )
				
				ControladorIGrafu.digrafu.getCheckBoxExatidao().setSelected(true);
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getCheckBoxExecucao()){
			
			if( ControladorIGrafu.digrafu.getCheckBoxExatidao().isSelected() == false &&
				ControladorIGrafu.digrafu.getCheckBoxExecucao().isSelected() == false )
				
				ControladorIGrafu.digrafu.getCheckBoxExecucao().setSelected(true);
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getCheckBoxPesos()){
			
			if(ControladorIGrafu.digrafu.getCheckBoxPesos().isSelected()){
				ControladorIGrafu.digrafu.getLabelPesosDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getCampoTextoPesosDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoPesosAbrir().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoEditarPesos().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoLimparPesos().setEnabled(true);
				ControladorIGrafu.digrafu.getAreaTextoPesos().setEnabled(true);
				ControladorIGrafu.digrafu.getRadioBotaoPesosManual().setEnabled(true);
				ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoPesos().getVerticalScrollBar().setEnabled(true);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoPesos().getHorizontalScrollBar().setEnabled(true);
			}
			else{
				ControladorIGrafu.digrafu.getLabelPesosDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getCampoTextoPesosDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoPesosAbrir().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoEditarPesos().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoLimparPesos().setEnabled(false);
				ControladorIGrafu.digrafu.getAreaTextoPesos().setEnabled(false);
				ControladorIGrafu.digrafu.getRadioBotaoPesosManual().setEnabled(false);
				ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoPesos().getVerticalScrollBar().setEnabled(false);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoPesos().getHorizontalScrollBar().setEnabled(false);
			}
			
		}
		
		if( e.getSource() == ControladorIGrafu.digrafu.getRadioBotaoPesosManual() ||
			e.getSource() == ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo() ){
			
			CardLayout cl = (CardLayout)ControladorIGrafu.digrafu.getPainelCardPesos().getLayout();
			cl.show(ControladorIGrafu.digrafu.getPainelCardPesos(), (String)e.getActionCommand());
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoPesosAbrir()) {
			
			BufferedReader arquivo = null;
			
            try {
                if(Navegar.navegar == null) {
                    Navegar.navegar = new Navegar();
                }
                Navegar.navegar.abreArquivos();
                if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                	ControladorIGrafu.digrafu.getCampoTextoPesosDoArquivo().setText(Navegar.file.getAbsolutePath());
/*                	arquivo = new BufferedReader(new FileReader(Navegar.file.getAbsolutePath()));
                	String linha;
                	while((linha = arquivo.readLine()) != null)
                		ControladorIGrafu.digrafu.getAreaTextoPesos().setText(linha);*/
                }
            }
            catch (NullPointerException nullPointerException) {
                JOptionPane.showMessageDialog(null, "ERRO - Arquivos", ERRO, JOptionPane.ERROR_MESSAGE);
            }
/*            catch (FileNotFoundException f) {
                JOptionPane.showMessageDialog(null, "ERRO - Arquivo não encontrado.", ERRO, JOptionPane.ERROR_MESSAGE);
			}
            catch (IOException g) {
                JOptionPane.showMessageDialog(null, "ERRO - IO", ERRO, JOptionPane.ERROR_MESSAGE);
			}*/
            
        }
		
		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoLimparPesos()){
			
			ControladorIGrafu.digrafu.getAreaTextoPesos().setText("");
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoEditarPesos()){

			new ControladorEditor();
			ControladorEditor.traduzir();
			ControladorIGrafu.editor.getJTextArea().setText(
					ManipulaArquivo.leArquivo(ControladorIGrafu.digrafu.getCampoTextoPesosDoArquivo().getText()));
			ControladorIGrafu.editor.getJTabbedPane().setTitleAt(0, ControladorIGrafu.digrafu.getCampoTextoPesosDoArquivo().getText());
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getCheckBoxCategorias()){
			
			if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected()){
				ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(true);
				ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(true);
				ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(true);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(true);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(true);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(true);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(true);
				habilitaCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
			}
			else{
				ControladorIGrafu.digrafu.getSpinnerCategoriasNum().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelCategoriasDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoCategoriasAbrir().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoEditarCategorias().setEnabled(false);
				ControladorIGrafu.digrafu.getBotaoLimparCategorias().setEnabled(false);
				ControladorIGrafu.digrafu.getAreaTextoCategorias().setEnabled(false);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual().setEnabled(false);
				ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo().setEnabled(false);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getVerticalScrollBar().setEnabled(false);
				ControladorIGrafu.digrafu.getPainelRolagemAreaTextoCategorias().getHorizontalScrollBar().setEnabled(false);
				desabilitaCategorias();
			}
			
		}
		
		if( e.getSource() == ControladorIGrafu.digrafu.getRadioBotaoCategoriasManual() ||
				e.getSource() == ControladorIGrafu.digrafu.getRadioBotaoCategoriasDoArquivo() ){
				
				CardLayout cl = (CardLayout)ControladorIGrafu.digrafu.getPainelCardCategorias().getLayout();
				cl.show(ControladorIGrafu.digrafu.getPainelCardCategorias(), (String)e.getActionCommand());
				
		}

		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoCategoriasAbrir()) {
			
			BufferedReader arquivo = null;
			
            try {
                if(Navegar.navegar == null) {
                    Navegar.navegar = new Navegar();
                }
                Navegar.navegar.abreArquivos();
                if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                	ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().setText(Navegar.file.getAbsolutePath());
/*                	arquivo = new BufferedReader(new FileReader(Navegar.file.getAbsolutePath()));
                	String linha;
                	while((linha = arquivo.readLine()) != null)
                		ControladorIGrafu.digrafu.getAreaTextoCategorias().setText(linha);*/
                }
            }
            catch (NullPointerException nullPointerException) {
                JOptionPane.showMessageDialog(null, "ERRO - Arquivos", ERRO, JOptionPane.ERROR_MESSAGE);
            }
/*            catch (FileNotFoundException f) {
                JOptionPane.showMessageDialog(null, "ERRO - Arquivo não encontrado.", ERRO, JOptionPane.ERROR_MESSAGE);
			}
            catch (IOException g) {
                JOptionPane.showMessageDialog(null, "ERRO - IO", ERRO, JOptionPane.ERROR_MESSAGE);
			}*/
            
        }
		
		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoLimparCategorias()){
			
			ControladorIGrafu.digrafu.getAreaTextoCategorias().setText("");
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoEditarCategorias()){

			new ControladorEditor();
			ControladorEditor.traduzir();
			ControladorIGrafu.editor.getJTextArea().setText(
					ManipulaArquivo.leArquivo(ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().getText()));
			ControladorIGrafu.editor.getJTabbedPane().setTitleAt(0, ControladorIGrafu.digrafu.getCampoTextoCategoriasDoArquivo().getText());
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas()){
			
			if(ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().isSelected()){
				ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(true);
				ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(true);
				ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(true);
				ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(true);
				ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(true);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(true);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(true);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(true);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(true);
				ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(true);
			}
			else{
				ControladorIGrafu.digrafu.getLabelFrequenciasA().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelFrequenciasC().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelFrequenciasG().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelFrequenciasT().setEnabled(false);
				ControladorIGrafu.digrafu.getSliderFrequenciasA().setEnabled(false);
				ControladorIGrafu.digrafu.getSliderFrequenciasC().setEnabled(false);
				ControladorIGrafu.digrafu.getSliderFrequenciasG().setEnabled(false);
				ControladorIGrafu.digrafu.getSliderFrequenciasT().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelFrequenciasTotal().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setEnabled(false);
			}
			
		}

		if (e.getSource() == ControladorIGrafu.digrafu.getBotaoEditor()) {
			
			new ControladorEditor();
			ControladorEditor.traduzir();
			
		}

		if (e.getSource() == ControladorIGrafu.digrafu.getBotaoExecutar()) {
			
	        // Convertendo para phylip sequencial
	        ControladorDIGRAFU.guardaNomeSequencia = GerarParametrosConversor.ChamaConversorIGrafu();
	        ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText(ControladorDIGRAFU.guardaNomeSequencia);
	        //ControladorIGrafu.digrafu.getLabelSequencia().setText("Sequência: " + ControladorDIGRAFU.guardaNomeSequencia);
	        ControladorSeqboot.guardaNomeSequencia = ControladorDIGRAFU.guardaNomeSequencia;
	        ControladorDIGRAFU.guardaNomeSequencia = "INPUT " + ControladorDIGRAFU.guardaNomeSequencia;
                    
			if(GeraParametrosDIGRAFU.trataParametrosSequencia()){
				if((GeraParametrosDIGRAFU.getTipo() == "dna") &&
				    GeraParametrosDIGRAFU.trataParametrosDNA()){
					ControladorIGrafu.digrafu.setEnabled(false);
					ControladorIGrafu.digrafu.getDialogoModoExecucao().setVisible(true);
					ControladorIGrafu.digrafu.getPainelModoExecucao().setVisible(true);
					ControladorIGrafu.digrafu.getPainelModoExecucao().setEnabled(true);
				}
				else if((GeraParametrosDIGRAFU.getTipo() == "proteina") &&
						 GeraParametrosDIGRAFU.trataParametrosProteina()){
					ControladorIGrafu.digrafu.setEnabled(false);
					ControladorIGrafu.digrafu.getDialogoModoExecucao().setVisible(true);
					ControladorIGrafu.digrafu.getPainelModoExecucao().setVisible(true);
					ControladorIGrafu.digrafu.getPainelModoExecucao().setEnabled(true);
				}
			}
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoModoExecucaoExecutar()){
			
			ControladorIGrafu.digrafu.getDialogoModoExecucao().removeNotify();
			ControladorIGrafu.digrafu.getDialogoModoExecucao().setVisible(false);
			ControladorIGrafu.digrafu.setEnabled(true);
			ControladorIGrafu.digrafu.getBarraProgressoExecucao().setVisible(true);
			ControladorIGrafu.digrafu.getBarraProgressoExecucao().setStringPainted(true);

			Thread threadProgress = new Thread(new Runnable() {
				public void run() {
					ControladorIGrafu.digrafu.getBarraProgressoExecucao().setString("Executando DiGrafu");
					ControladorIGrafu.digrafu.getBarraProgressoExecucao().setIndeterminate(true);
				}
			});
			threadProgress.setDaemon(true);
			threadProgress.start();

			Thread threadDigrafu = new Thread(new Runnable() {
				public void run() {
					ControlaExecucao.executaDIGRAFU();
                    // Processo.processarDIGRAFU();
					ControladorIGrafu.digrafu.getBarraProgressoExecucao().setVisible(false);
				}
			});
			threadDigrafu.start();
			
		}

/*		if (e.getSource() == ControladorIGrafu.digrafu.getJButtonArquivoSequencia()) {
			if(Navegar.navegar == null) {
				Navegar.navegar = new Navegar();
				Navegar.navegar.abreArquivos();
				if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
					ControladorIGrafu.digrafu.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
					ControladorModoExecucao.arquivoSaida = "" + Navegar.file.getName();
				}
			}
			else {
					Navegar.navegar.abreArquivos();
					if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
						ControladorIGrafu.digrafu.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
						ControladorModoExecucao.arquivoSaida = "" + Navegar.file.getName();
					}
			}
		}*/

		if (e.getSource() == ControladorIGrafu.digrafu.getBotaoVisualizar()) {
			Processo.processarHyperTreeDIGRAFU();
		}


		if(e.getSource() == ControladorIGrafu.digrafu.getBotaoVoltar()) {
			try {
				if(ControladorIGrafu.programas == null) {
					ControladorIGrafu.digrafu.removeNotify();
					new ControladorProgramas();
					ControladorProgramas.traduzir();
					ControladorIGrafu.programas.setVisible(false);
					ControladorIGrafu.programas.setVisible(true);
					ControladorIGrafu.programas.repaint();
				}
				else {
					ControladorIGrafu.digrafu.removeNotify();
					ControladorProgramas.traduzir();
					ControladorIGrafu.programas.setVisible(false);
					ControladorIGrafu.programas.setVisible(true);
					ControladorIGrafu.programas.repaint();
				}
			}
			catch (NullPointerException nullPointerException) {
				JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);
			}
		}
                
        if(e.getSource() == ControladorIGrafu.digrafu.getBotaoInicio()) {
			ControladorIGrafu.digrafu.removeNotify();
                        //ControladorIGrafu.novaInstancia();
                        ControladorIGrafu.conversor.setVisible(true);
                        ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().setSelectedIndex(0);
                        ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText("");
                        ControladorIGrafu.conversor.repaint();
                        ControladorIGrafu.digrafu.setVisible(false);
		}

/*		if(e.getSource() == ControladorIGrafu.digrafu.getJMenuItemCriarPerfil()) {
			nomePerfil = JOptionPane.showInputDialog(Tradutor.traduzir("<html>Informe o nome do perfil.<br>O perfil será criado após a<br>próxima execução do Phyml.</html>","<html>Inform the name of the profile.<br>The profile will be created in the<br>next Phyml execution."));
			perfil = true;
		}

		if(e.getSource() == ControladorIGrafu.digrafu.getJCheckBoxMenuItemIngles() || e.getSource() == ControladorIGrafu.digrafu.getJCheckBoxMenuItemPortugues()) {
			if(ControladorIGrafu.digrafu.getJCheckBoxMenuItemIngles().isSelected()) {
				Tradutor.setLinguage(1);
				traduzir();
			}
			else {
				Tradutor.setLinguage(0);
				traduzir();
			}
			
		}

		if(e.getSource() == ControladorIGrafu.digrafu.getJMenuItemFechar()) {
			Object[] opcoes = { SAIR, CANCELAR };
			int opcao = JOptionPane.showOptionDialog(null, FECHAR,
					"IGRAFU 2.0", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, opcoes, opcoes[1]);

			if (opcao == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}*/
	}


	public void itemStateChanged(ItemEvent e) {
		
		CardLayout cl = (CardLayout)ControladorIGrafu.digrafu.getPainelCardModelo().getLayout();
		cl.show(ControladorIGrafu.digrafu.getPainelCardModelo(), (String)e.getItem());

		if(e.getItem() == "DNA")
			atualizaPainelPrincipal(ControladorIGrafu.digrafu.getComboModeloDNA().getSelectedIndex());
		else
			atualizaPainelPrincipal(ControladorIGrafu.digrafu.getComboModeloProteina().getSelectedIndex());
		
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		
		if(e.getSource() == ControladorIGrafu.digrafu.getCampoNumericoCV()){
			if(ControladorIGrafu.digrafu.getCampoNumericoCV().getlength() > 0){
				ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(true);
				if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected()){
					ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(true);
					ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(true);
				}
				else{
					ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
					ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
				}
			}
			else{
				ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().setEnabled(false);
				ControladorIGrafu.digrafu.getLabelSitiosInvariantes().setEnabled(false);
				ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().setEnabled(false);
			}
		}
		

		if(e.getSource() == field.getTextField())
			habilitaCategorias(Integer.parseInt(field.getTextField().getText()));
		
	}
	
	public void stateChanged(ChangeEvent e){

		if( e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasA() ||
			e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasC() ||
			e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasG() ||
			e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasT() ||
			e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasA() ||
			e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasC() ||
			e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasG() ||
			e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasT()){
			
			verificaTotalFrequencia();
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasA())
			ControladorIGrafu.digrafu.getSpinnerFrequenciasA().setValue(
					Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSliderFrequenciasA().getValue()))/100);
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasC())
			ControladorIGrafu.digrafu.getSpinnerFrequenciasC().setValue(
					Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSliderFrequenciasC().getValue()))/100);
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasG())
			ControladorIGrafu.digrafu.getSpinnerFrequenciasG().setValue(
					Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSliderFrequenciasG().getValue()))/100);
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSliderFrequenciasT())
			ControladorIGrafu.digrafu.getSpinnerFrequenciasT().setValue(
					Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSliderFrequenciasT().getValue()))/100);
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasA()){
			
			float tempVal = Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasA().getValue()))*100;
			
			ControladorIGrafu.digrafu.getSliderFrequenciasA().setValue((int)tempVal);
			
		}
			
		if(e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasC()){
			
			float tempVal = Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasC().getValue()))*100;
			
			ControladorIGrafu.digrafu.getSliderFrequenciasC().setValue((int)tempVal);
			
		}

		if(e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasG()){
			
			float tempVal = Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasG().getValue()))*100;
			
			ControladorIGrafu.digrafu.getSliderFrequenciasG().setValue((int)tempVal);
			
		}

		if(e.getSource() == ControladorIGrafu.digrafu.getSpinnerFrequenciasT()){
			
			float tempVal = Float.valueOf(String.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasT().getValue()))*100;
			
			ControladorIGrafu.digrafu.getSliderFrequenciasT().setValue((int)tempVal);
			
		}
		
		if(e.getSource() == ControladorIGrafu.digrafu.getSpinnerCategoriasNum())
			habilitaCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
		
	}
	
	private void habilitaCategorias(Integer num){
		

		if(num == 1){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 2){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 3){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 4){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 5){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 6){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 7){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 8){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		}
		if(num == 9){
			ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(true);
			ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(true);
			ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(true);
		}
		
	}
	
	private void verificaTotalFrequencia(){
		
		float frequenciaTotal = (
				Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasA().getValue().toString()) +
				Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasC().getValue().toString()) +
				Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasG().getValue().toString()) +
				Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasT().getValue().toString())
				);
		
		ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setText(String.format("%.2f", frequenciaTotal));
		
/*		if(frequenciaTotal <= 1.0 )
			ControladorIGrafu.digrafu.getLabelFrequenciasTotalNum().setText(String.format("%.2f", frequenciaTotal));
		else{
			ControladorIGrafu.digrafu.getSliderFrequenciasA().setValue(100 - (
					ControladorIGrafu.digrafu.getSliderFrequenciasC().getValue() +
					ControladorIGrafu.digrafu.getSliderFrequenciasC().getValue() +
					ControladorIGrafu.digrafu.getSliderFrequenciasC().getValue()));
			JOptionPane.showMessageDialog(null, "A soma das frequências deve ser igual a 1", ERRO, JOptionPane.ERROR_MESSAGE);
			return;
		}*/
		
	}
	
	private void desabilitaCategorias(){
		
		ControladorIGrafu.digrafu.getLabelCategoria1().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria1().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria2().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria2().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria3().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria3().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria4().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria4().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria5().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria5().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria6().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria6().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria7().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria7().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria8().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria8().setEnabled(false);
		ControladorIGrafu.digrafu.getLabelCategoria9().setEnabled(false);
		ControladorIGrafu.digrafu.getCampoNumericoCategoria9().setEnabled(false);
		
	}

	
	 // Metodo de traducao Portugues/Ingles
/*	 
	public static void traduzir() {
		ControladorIGrafu.digrafu.getJRadioButtonTempoExatidao().setText(Tradutor.traduzir("Exatidão", "Accuracy"));
		ControladorIGrafu.digrafu.getJRadioButtonTempoExecucao().setText(Tradutor.traduzir("Execução", "Execution"));

		ControladorIGrafu.digrafu.getJTabbedPaneGeral().setTitleAt(0, Tradutor.traduzir("Seqüência","Sequence"));
		ControladorIGrafu.digrafu.getJTabbedPaneGeral().setTitleAt(1, Tradutor.traduzir("Modelo - DNA","Model - DNA"));
//		ControladorIGrafu.digrafu.getJTabbedPaneGeral().setTitleAt(2, Tradutor.traduzir("Modelo - AA","Model - AA"));

		ControladorIGrafu.digrafu.getJLabelArquivoSequencia().setText(Tradutor.traduzir("Seqüências","Sequences"));
		ControladorIGrafu.digrafu.getJButtonArquivoSequencia().setToolTipText(Tradutor.traduzir("Informe o local onde está o arquivo da seqüência.", "Inform the place where is the sequence file."));
		ControladorIGrafu.digrafu.getJRadioButtonTipoDadoAA().setText(Tradutor.traduzir("Aminoácido","Amino-Acid"));
		ControladorIGrafu.digrafu.getJLabelTipoDado().setText(Tradutor.traduzir("Tipo de dado", "Data type"));
		ControladorIGrafu.digrafu.getJButtonExecutar().setText(Tradutor.traduzir("Executar","Execute"));
		ControladorIGrafu.digrafu.getJButtonVoltar().setText(Tradutor.traduzir("Voltar","Back"));
		ControladorIGrafu.digrafu.getJButtonEditor().setText(Tradutor.traduzir("Editor","Edition"));
		ControladorIGrafu.digrafu.getJButtonVisualizar().setText(Tradutor.traduzir("Visualizar","Visualize"));
		ControladorIGrafu.digrafu.getJLabelTempo().setText(Tradutor.traduzir("Tempo", "Time"));

		ControladorIGrafu.digrafu.getJMenuArquivo().setText(Tradutor.traduzir("Arquivo", "File"));
		ControladorIGrafu.digrafu.getJMenuConfiguracoes().setText(Tradutor.traduzir("Configurações", "Configurations"));
		ControladorIGrafu.digrafu.getJMenuItemFechar().setText(Tradutor.traduzir("Sair", "Exit"));

		nomePerfil = Tradutor.traduzir("<html>Informe o nome do perfil.<br>O perfil será criado após a<br>próxima execução do Phyml.</html>","<html>Inform the name of the profile.<br>The profile will be created in the<br>next Phyml execution.");


		traduzirDNA();

		ControladorIGrafu.digrafu.getJMenuIdiomas().setText(Tradutor.traduzir("Idioma","Language"));
		ControladorIGrafu.digrafu.getJCheckBoxMenuItemIngles().setText(Tradutor.traduzir("Inglês","English"));
		ControladorIGrafu.digrafu.getJCheckBoxMenuItemPortugues().setText(Tradutor.traduzir("Português","Portuguese"));
		ControladorIGrafu.digrafu.getJMenuPerfil().setText(Tradutor.traduzir("Perfil","Profile"));
		ControladorIGrafu.digrafu.getJMenuItemDeletarPerfil().setText(Tradutor.traduzir("Deletar Perfil","Delete profile"));
		ControladorIGrafu.digrafu.getJMenuItemCriarPerfil().setText(Tradutor.traduzir("Criar Perfil","Create profile"));

		FECHAR = Tradutor.traduzir("Deseja sair do sistema?", "Do you want to leave the system?");
		SAIR = Tradutor.traduzir("Sair","Exit");
		CANCELAR = Tradutor.traduzir("Cancelar","Cancel");
		ERRO = Tradutor.traduzir("Erro","Error");
		ERRO1 = Tradutor.traduzir("Não foi possível abrir a tela anterior!","Was not possible open the previous screen!");

		ControladorIGrafu.digrafu.repaint();
	}

	
	 // Metodo de traducao Portugues/Ingles
	 
	public static void traduzirDNA() {
		ControladorIGrafu.digrafu.getJTabbedPaneModelosAA().setToolTipText(Tradutor.traduzir("O tipo de dado selecionado é DNA.","The type of selected data is DNA."));

		ControladorIGrafu.digrafu.getJLabelModeloSelecionadoLogDet().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.digrafu.getJLabelModeloSelecionadoJC69().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.digrafu.getJLabelModeloSelecionadoF84().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));
		ControladorIGrafu.digrafu.getJLabelModeloSelecionadoKimura().setText(Tradutor.traduzir("Modelo selecionado:", "Selected model:"));

		ControladorIGrafu.digrafu.getJRadioButtonUtilizarModeloF84().setText(Tradutor.traduzir("Utilizar o modelo F84", "Use F84 model"));
		ControladorIGrafu.digrafu.getJRadioButtonUtilizarModeloKimura().setText(Tradutor.traduzir("Utilizar o modelo Kimura", "Use Kimura model"));
		ControladorIGrafu.digrafu.getJRadioButtonUtilizarModeloLogDet().setText(Tradutor.traduzir("Utilizar o modelo LogDet", "Use LogDet model"));
		ControladorIGrafu.digrafu.getJRadioButtonUtilizarModeloJC69().setText(Tradutor.traduzir("Utilizar o modelo JC69", "Use JC69 model"));

		ControladorIGrafu.digrafu.getJLabelPesosSitiosF84().setText(Tradutor.traduzir("Pesos para sítios", "Weights for sites"));
		ControladorIGrafu.digrafu.getJLabelPesosSitiosKimura().setText(Tradutor.traduzir("Pesos para sítios", "Weights for sites"));
		ControladorIGrafu.digrafu.getJLabelPesosSitiosLogDet().setText(Tradutor.traduzir("Pesos para sítios", "Weights for sites"));
		ControladorIGrafu.digrafu.getJLabelPesosSitiosJC69().setText(Tradutor.traduzir("Pesos para sítios", "Weights for sites"));

		ControladorIGrafu.digrafu.getJLabelRelacaoKimura().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));
		ControladorIGrafu.digrafu.getJLabelRelacaoF84().setText(Tradutor.traduzir("Relação Transição/Transversão", "Transition/transversion ratio"));

		ControladorIGrafu.digrafu.getJLabelFrequenciaF84().setText(Tradutor.traduzir("Freqüências empíricas", "Empirical frequencies"));

		ControladorIGrafu.digrafu.getJLabelFracaoSitiosInvariantesF84().setText(Tradutor.traduzir("Fração de sítios invariantes", "Fraction of invariantes sites"));
		ControladorIGrafu.digrafu.getJLabelFracaoSitiosInvariantesJC69().setText(Tradutor.traduzir("Fração de sítios invariantes", "Fraction of invariantes sites"));
		ControladorIGrafu.digrafu.getJLabelFracaoSitiosInvariantesKimura().setText(Tradutor.traduzir("Fração de sítios invariantes", "Fraction of invariantes sites"));

		ControladorIGrafu.digrafu.getJRadioButtonPesosSitiosNaoF84().setText(Tradutor.traduzir("Não", "No"));
		ControladorIGrafu.digrafu.getJRadioButtonPesosSitiosNaoJC69().setText(Tradutor.traduzir("Não", "No"));
		ControladorIGrafu.digrafu.getJRadioButtonPesosSitiosNaoKimura().setText(Tradutor.traduzir("Não", "No"));
		ControladorIGrafu.digrafu.getJRadioButtonPesosSitiosNaoLogDet().setText(Tradutor.traduzir("Não", "No"));

		ControladorIGrafu.digrafu.getJCheckBoxFrequenciasEmpiricasSim().setText(Tradutor.traduzir("Sim", "Yes"));

		ControladorIGrafu.digrafu.getJLabelDistribuicaoGamaF84().setText(Tradutor.traduzir("Distribuição Gama", "Distribution Gamma"));
		ControladorIGrafu.digrafu.getJLabelDistribuicaoGamaJC69().setText(Tradutor.traduzir("Distribuição Gama", "Distribution Gamma"));
		ControladorIGrafu.digrafu.getJLabelDistribuicaoGamaKimura().setText(Tradutor.traduzir("Distribuição Gama", "Distribution Gamma"));
		ControladorIGrafu.digrafu.getJButtonExecutarSequencial().setText(Tradutor.traduzir("Executar", "Execute"));
	}
*/


	/**
     * Metodo utilizado para retornar se existem mais de um caracter igual no texto
     *
     * @return boolean
     *//*
    public boolean possuiVarios(String str, String igual) {
    	int aux = 0;

    	if(igual.length() > 1)
    		return false;

    	for(int i = 1; i <= str.length(); i++) {
    		if(str.substring(i - 1, i).equals(igual))
    			aux++;
    	}

    	if(aux > 1)
			return true;
    	else
    		return false;
    }
*/
}
