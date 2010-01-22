package br.uesc.computacao.estagio.aplicacao.controlador;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.io.IOException;


import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import br.uesc.computacao.estagio.aplicacao.util.Processo;
import br.uesc.computacao.estagio.aplicacao.util.Tradutor;
import br.uesc.computacao.estagio.apresentacao.GUI.Conversor;

//////////////////////////////////////////////////////////////////////////////

public class ControladorConversor implements ActionListener {

//    public static boolean bootstrap = false;
    public static String ERRO = "Erro";
    public static String ERRO1 = "Erro - Não foi possível abrir a tela anterior!";
    public static String ERRO2 = "Erro - Não foi possível abrir a próxima tela!";
    public static String INFORME_BOOTSTRAP = "Informe se deseja utilizar bootstrap!";
    public static String FECHAR = "Deseja sair do sistema?";
    public static String SAIR = "Sair";
    public static String CANCELAR = "Cancelar";

    public static String INFORME_ENTRADA = "Informe o arquivo de entrada !";
    public static String ENTRADA = "Tipo de entrada";
    public static String INFORME_FORMATO = "Informe o formato do arquivo de entrada!";
    public static String SEQUENCIA = "Sequencia";
    public static String SISTEMA_ARQUIVO = "ERRO - Não foi possível visualizar o sistema de arquivos!";


    public static String arquivoSaida = "";
    public static File caminho;
    JFileChooser fc = new JFileChooser();
    public static String nomeArquivoIN, endereco, diretorioAtual=".";



    public ControladorConversor() {
        ControladorIGrafu.conversor = new Conversor();
        ControladorIGrafu.conversor.setResizable(false);
        ControladorIGrafu.conversor.setVisible(true);
        ControladorIGrafu.conversor.repaint();
        ControladorIGrafu.conversor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ControladorIGrafu.conversor.addWindowListener(new java.awt.event.WindowAdapter() {
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
        //buttonGroupJanelaTeste();

        ControladorIGrafu.conversor.getJButtonAbreArquivoEntrada().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonVoltar().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonAvancar().addActionListener(this);
        ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonComplementoReverso().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonListarSequencia().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonCheckSum().addActionListener(this);
        ControladorIGrafu.conversor.getJRadioButtonSaidaNaoDigrafu().addActionListener(this);
        ControladorIGrafu.conversor.getJRadioButtonSaidaSimDigrafu().addActionListener(this);
        ControladorIGrafu.conversor.getJRadioButtonSaidaNaoPhyml().addActionListener(this);
        ControladorIGrafu.conversor.getJRadioButtonSaidaSimPhyml().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonSalvarSaidaDigrafu().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonSalvarSaidaPhyml().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonAbreArquivoEntradaConversor().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonAbreArquivoSaidaConversor().addActionListener(this);
        ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().addActionListener(this);
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addActionListener(this);
        ControladorIGrafu.conversor.getJButtonExecutar().addActionListener(this);
        
        
    }
//////////////////////////////////////////////////////////////////////////////////

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

//////////////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent e) {

        /*VOLTAR*/

        if(e.getSource() == ControladorIGrafu.conversor.getJButtonVoltar()) {
            try {
                if(ControladorIGrafu.modoExecucao == null) {
                    ControladorIGrafu.conversor.removeNotify();
                    new ControladorModoExecucao();
                    ControladorModoExecucao.traduzir();
                    ControladorIGrafu.modoExecucao.setVisible(true);
                    ControladorIGrafu.modoExecucao.repaint();
                    ControladorIGrafu.conversor.setVisible(false);
                }
                else {
                    ControladorIGrafu.conversor.removeNotify();
                    ControladorModoExecucao.traduzir();
                    ControladorIGrafu.modoExecucao.setVisible(true);
                    ControladorIGrafu.modoExecucao.repaint();
                    ControladorIGrafu.conversor.setVisible(false);
                }
            }
            catch (NullPointerException nullPointerException) {
                JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);
            }
        }
//******************************************************************************

        /*AVANÇAR*/

        else if(e.getSource() == ControladorIGrafu.conversor.getJButtonAvancar()) {

            if(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()!= 0) {
                if(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText().length() != 0) {
                    try{
                        ControladorIGrafu.modoExecucao.removeNotify();
                        new ControladorModoManualBootstrap();

                        ControladorModoManualBootstrap.traduzir();
                        ControladorIGrafu.modoManualBootstrap.setVisible(true);
                        ControladorIGrafu.modoManualBootstrap.repaint();
                        ControladorIGrafu.conversor.setVisible(false);

                        GerarParametrosConversor.arqEntrada = ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex();
                        System.out.println(GerarParametrosConversor.arqEntrada);

                    }
                    catch (NullPointerException nullPointerException) {
                        JOptionPane.showMessageDialog(null, "ERRO - Não foi possível abrir a próxima tela!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, INFORME_ENTRADA, ENTRADA, JOptionPane.INFORMATION_MESSAGE);

                }
            }
            else{
                JOptionPane.showMessageDialog(null, INFORME_FORMATO, SEQUENCIA, JOptionPane.INFORMATION_MESSAGE);
            }
        }
//*****************************************************************************
        else{
            if(e.getSource() == ControladorIGrafu.conversor.getJButtonAbreArquivoEntrada()) {
                try {
                    if(Navegar.navegar == null) {
                        Navegar.navegar = new Navegar();
                        Navegar.navegar.abreArquivos();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText(Navegar.file.getAbsolutePath());
                            arquivoSaida = "" + Navegar.file.getName();
                        }
                    }
                    else {
                        Navegar.navegar.abreArquivos();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().setText(Navegar.file.getAbsolutePath());
                            arquivoSaida = "" + Navegar.file.getName();
                        }
                    }
                }
                catch (NullPointerException nullPointerException) {
                    JOptionPane.showMessageDialog(null, SISTEMA_ARQUIVO, ERRO, JOptionPane.ERROR_MESSAGE);
                }

                if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                    if(ControladorIGrafu.seqboot != null) {
                        ControladorIGrafu.seqboot.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
                    }
                    if(ControladorIGrafu.phyml != null){
                        ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
                    }
                    if(ControladorIGrafu.digrafu != null){
                    //    ControladorIGrafu.digrafu.getJTextFieldArquivoSequencia().setText(Navegar.file.getAbsolutePath());
                    }
                    if(ControladorIGrafu.conversor != null){
                        ControladorIGrafu.conversor.getJTextFieldComplementoReverso().setText(Navegar.file.getAbsolutePath());
                        ControladorIGrafu.conversor.getJTextFieldListarSequencia().setText(Navegar.file.getAbsolutePath());
                        ControladorIGrafu.conversor.getJTextFieldCheckSum().setText(Navegar.file.getAbsolutePath());
                    }
                }
                if((ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()!= 0) &&
                        (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()!= 6)) {
                    ControladorIGrafu.conversor.getJTabbedPrimaria().setEnabledAt(1, true);
                }
                else{
                     ControladorIGrafu.conversor.getJTabbedPrimaria().setEnabledAt(1, false);
                }
            }
        }
        if(e.getSource() == ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia()){

            System.out.println("Formato de entrada escolhido:"+ ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex());

            if((ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()!= 0)) {
                 if(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText() != ""){
                     ControladorIGrafu.conversor.getJTabbedPrimaria().setEnabledAt(1, true);
                 }
            }
            else{
                ControladorIGrafu.conversor.getJTabbedPrimaria().setEnabledAt(1, false);
            }
            if((ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 6) 
                    || (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 2)
                    || (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 10) 
                    || (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 11)){
                //ControladorIGrafu.conversor.getJTextFieldListarSequencia().setEnabled(false);
                //ControladorIGrafu.conversor.getJButtonListarSequencia().setEnabled(false);
            }
            else{
                ControladorIGrafu.conversor.getJTextFieldListarSequencia().setEnabled(true);
                ControladorIGrafu.conversor.getJButtonListarSequencia().setEnabled(true);
            }


        }
        if(e.getSource() == ControladorIGrafu.conversor.getJButtonComplementoReverso()){
            GerarParametrosConversor.ComplementoReverso();
        }
         if(e.getSource() == ControladorIGrafu.conversor.getJButtonListarSequencia()){
            GerarParametrosConversor.ListarSequencias();
        }
         if(e.getSource() == ControladorIGrafu.conversor.getJButtonCheckSum()){
            GerarParametrosConversor.ObterChecksum();
        }
        
        if(e.getSource() == ControladorIGrafu.conversor.getJRadioButtonSaidaNaoDigrafu()){
            ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().setEnabled(false);
            ControladorIGrafu.conversor.getJButtonSalvarSaidaDigrafu().setEnabled(false);
            ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().setText((GeraParametrosDIGRAFU.caminho()+Processo.corrigeCaminho.toString()+"/arquivos_saida/digrafu"));


        }
        if(e.getSource() == ControladorIGrafu.conversor.getJRadioButtonSaidaSimDigrafu()){
           ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().setEnabled(true);
           ControladorIGrafu.conversor.getJButtonSalvarSaidaDigrafu().setEnabled(true);
        }
         if(e.getSource() == ControladorIGrafu.conversor.getJRadioButtonSaidaNaoPhyml()){
           ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().setEnabled(false);
           ControladorIGrafu.conversor.getJButtonSalvarSaidaPhyml().setEnabled(false);
           ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().setText(Processo.pegaCaminho+Processo.corrigeCaminho.toString()+"/arquivos_saida/phyml/");
        }
        if(e.getSource() == ControladorIGrafu.conversor.getJRadioButtonSaidaSimPhyml()){
           ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().setEnabled(true);
           ControladorIGrafu.conversor.getJButtonSalvarSaidaPhyml().setEnabled(true);
        }
        
        if(e.getSource() == ControladorIGrafu.conversor.getJButtonSalvarSaidaDigrafu()){
             try {
                    if(Navegar.navegar == null) {
                        Navegar.navegar = new Navegar();
                        Navegar.navegar.abreDiretorios();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().setText(Navegar.file.getAbsolutePath());
                           
                        }
                    }
                    else {
                         Navegar.navegar.abreDiretorios();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().setText(Navegar.file.getAbsolutePath());
                            
                        }
                    }
                }
                catch (NullPointerException nullPointerException) {
                    JOptionPane.showMessageDialog(null, SISTEMA_ARQUIVO, ERRO, JOptionPane.ERROR_MESSAGE);
                }
        }
        if(e.getSource() == ControladorIGrafu.conversor.getJButtonSalvarSaidaPhyml()){
            try {
                    if(Navegar.navegar == null) {
                        Navegar.navegar = new Navegar();
                        Navegar.navegar.abreDiretorios();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().setText(Navegar.file.getAbsolutePath());
                           
                        }
                    }
                    else {
                         Navegar.navegar.abreDiretorios();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().setText(Navegar.file.getAbsolutePath());
                            
                        }
                    }
                }
                catch (NullPointerException nullPointerException) {
                    JOptionPane.showMessageDialog(null, SISTEMA_ARQUIVO, ERRO, JOptionPane.ERROR_MESSAGE);
                }
        }
        if(e.getSource() == ControladorIGrafu.conversor.getJButtonAbreArquivoEntradaConversor()){
            try {
                    if(Navegar.navegar == null) {
                        Navegar.navegar = new Navegar();
                        Navegar.navegar.abreArquivos();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldArquivoEntradaConversor().setText(Navegar.file.getAbsolutePath());
                           
                        }
                    }
                    else {
                         Navegar.navegar.abreArquivos();
                        if(Navegar.getReturnVal() == JFileChooser.APPROVE_OPTION) {
                            ControladorIGrafu.conversor.getJTextFieldArquivoEntradaConversor().setText(Navegar.file.getAbsolutePath());
                            
                        }
                    }
                }
                catch (NullPointerException nullPointerException) {
                    JOptionPane.showMessageDialog(null, SISTEMA_ARQUIVO, ERRO, JOptionPane.ERROR_MESSAGE);
                }
            
          
        }
        if(e.getSource() == ControladorIGrafu.conversor.getJButtonAbreArquivoSaidaConversor()){
            File caminhoOUT;
            try {

                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                //int res = fc.showOpenDialog(null);
                int res = fc.showSaveDialog(null);
                diretorioAtual = fc.getCurrentDirectory().toString();
                if ( res == JFileChooser.CANCEL_OPTION ) return;
                    if(res == JFileChooser.APPROVE_OPTION){
                        caminhoOUT= fc.getSelectedFile();//variável com o caminhoOUT do arquivo
                        ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().setText(caminhoOUT.getPath());

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
                    }

                }
                catch (NullPointerException nullPointerException) {
                    JOptionPane.showMessageDialog(null, SISTEMA_ARQUIVO, ERRO, JOptionPane.ERROR_MESSAGE);
                }
            if(!(ControladorIGrafu.conversor.getJTextFieldArquivoEntradaConversor().getText().isEmpty()) &&
                !(ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().getText().isEmpty())){
                ControladorIGrafu.conversor.getJButtonExecutar().setVisible(true);
                ControladorIGrafu.conversor.getJButtonExecutar().setEnabled(true);
            }
            else{
                ControladorIGrafu.conversor.getJButtonExecutar().setVisible(false);
                ControladorIGrafu.conversor.getJButtonExecutar().setEnabled(false);
            }
        }

        
        if(e.getSource() ==ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor()){

           System.out.println("Formato de entrada escolhido:"+ ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex());


           if(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 0){
               ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().setEnabled(false);
               ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().setEnabled(false);
               ControladorIGrafu.conversor.getJButtonAbreArquivoSaidaConversor().setEnabled(false);
               ControladorIGrafu.conversor.getJButtonExecutar().setVisible(false);
           }
           else{
               if(ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex()!=0){
                   ControladorIGrafu.conversor.getJButtonExecutar().setVisible(true);
               }
               if(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 11){
                   ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().setEnabled(true);
                   ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().setEnabled(true);
                   ControladorIGrafu.conversor.getJButtonAbreArquivoSaidaConversor().setEnabled(true);
                   //GerarParametrosConversor.criaComboBoxDataConvert();
                   GerarParametrosConversor.criaComboBoxSaidaConversor();
               }
               else{
                   ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().setEnabled(true);
                   ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().setEnabled(true);
                   ControladorIGrafu.conversor.getJButtonAbreArquivoSaidaConversor().setEnabled(true);
                   //GerarParametrosConversor.criaComboBoxReadSeq();
                   GerarParametrosConversor.criaComboBoxSaidaConversor();
               }
           }
        }
        if(e.getSource() ==ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor()){
            System.out.println("Formato de saida escolhido:"+ ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex());
        }

        if(e.getSource() == ControladorIGrafu.conversor.getJButtonExecutar()){
            if((ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getItemCount() == 6) ||
                (ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex() == 19)   ){
                GerarParametrosConversor.DataConvertConversorIndependente();
                //GerarParametrosConversor.ReadSeqConversorIndependente();
            }
            else{
                //GerarParametrosConversor.DataConvertConversorIndependente();
                GerarParametrosConversor.ReadSeqConversorIndependente();
            }
        }


    }
    

///////////////////////////////////////////////////////////////////////////////
    /*
     * Metodo de traducao Portugues/Ingles
     */
    public static void traduzir() {

        //ControladorIGrafu.conversor.getJButtonAbreArquivoEntrada().setText(Tradutor.traduzir("Avançar","Advance"));
        //ControladorIGrafu.conversor.getJButtonVoltar().setText(Tradutor.traduzir("Voltar","Back"));
        ControladorIGrafu.conversor.getJButtonAvancar().setText(Tradutor.traduzir("Avançar","Advance"));
        ControladorIGrafu.conversor.getJButtonVoltar().setText(Tradutor.traduzir("Voltar","Back"));
        ControladorIGrafu.conversor.getJButtonExecutar().setText(Tradutor.traduzir("Executar","Execute"));
        

        FECHAR = Tradutor.traduzir("Deseja sair do sistema?", "Do you want to leave the system?");
        SAIR = Tradutor.traduzir("Sair","Exit");
        CANCELAR = Tradutor.traduzir("Cancelar","Cancel");
        ERRO = Tradutor.traduzir("Erro","Error");
        ERRO1 = Tradutor.traduzir("Não foi possível abrir a tela anterior!","Was not possible open the previous screen!");
        ERRO2 = Tradutor.traduzir("Não foi possível abrir a próxima tela!","Was not possible open the next screen!");
        INFORME_BOOTSTRAP = Tradutor.traduzir("Informe se deseja utilizar bootstrap!", "Informs if desires use bootstrap!");
    }
    


}