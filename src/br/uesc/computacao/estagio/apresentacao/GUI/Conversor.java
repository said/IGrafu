package br.uesc.computacao.estagio.apresentacao.GUI;

import br.uesc.computacao.estagio.aplicacao.util.Processo;
import br.uesc.computacao.estagio.aplicacao.controlador.GeraParametrosDIGRAFU;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class Conversor extends JFrame {
    int arqEntX=-50;
    int arqEntY=-220;

    int formEntX=-53;
    int formEnty=200;

    int botoesX=0;
    int botoesY=0;

    int SimNaoX=-140;
    int SimNaoX2=-140;
    int SimNaoY=-240;

    int ListarSeqX=-140;
    int ListarSeqY=-140;

    int CheckSumX =-140;
    int CheckSumY = -50;

    int SaidaConversorX =0;
    int SaidaConversorY = 150;

    int SaidaDigrafuX=-10;
    int SaidaDigrafuY=-200;
    int SaidaDigrafuX2=-8;

    int SalvarDiretorioX=-10;
    int SalvarDiretorioY=-200;

    int x=-150;
    int y=-90;
    int help=50;

    private static final long serialVersionUID = 1L;

    private JTabbedPane jTabbedPanePrimaria = null;
    private JTabbedPane jTabbedPaneSecundaria = null;
    private JTabbedPane jTabbedPaneTerciaria = null; // TESTANDO

    private JPanel jContentPanePrincipal = null;
    private JPanel jContentPaneSecundaria = null;
    private JPanel jContentPaneTerciaria = null; //TESTANDO
    private JPanel jContentPaneEntrada = null;
    private JPanel jPanelOpcoes = null;
    private JPanel jPanelConversor = null;
    private JPanel jPanelSaidaPHYML = null;
    private JPanel jPanelSaidaDIGRAFU = null;


    private JLabel jLabelArquivoSequencia = null;
    private JLabel jLabelFormatosDeEntrada = null;
    private JLabel jLabelComplementoReverso = null;
    private JLabel jLabelListarSequencia = null;
    private JLabel jLabelCheckSum = null;
    private JLabel jLabelEntradaConversor = null;
    private JLabel jLabelSaidaConversor = null;
    private JLabel jLabelDiretorioSaidaDigrafu = null;
    private JLabel jLabelDiretorioSaidaPhyml = null;
    private JLabel jLabelSalvarSaidaDigrafu = null;
    private JLabel jLabelSalvarSaidaPhyml = null;

    private JTextField jTextFieldArquivoEntrada = null;
    private JTextField jTextFieldComplementoReverso = null;
    private JTextField jTextFieldListarSequencia= null;
    private JTextField jTextFieldCheckSum= null;
    private JTextField jTextFieldArquivoEntradaConversor = null;
    private JTextField jTextFieldArquivoSaidaConversor = null;
    private JTextField jTextFieldSalvarSaidaDigrafu= null;
    private JTextField jTextFieldSalvarSaidaPhyml= null;


    private JSeparator jSeparatorA1 = null;
    private JSeparator jSeparatorA2 = null;
    private JSeparator jSeparatorA3 = null;
    private JSeparator jSeparatorA4 = null;
    private JSeparator jSeparatorA5 = null;
    private JSeparator jSeparatorA6 = null;
    private JSeparator jSeparatorA7 = null;
    private JSeparator jSeparatorA8 = null;
    private JSeparator jSeparatorA9 = null;

    private JSeparator jSeparatorB1 = null;
    private JSeparator jSeparatorB2 = null;
    private JSeparator jSeparatorB3 = null;
    private JSeparator jSeparatorB4 = null;
    private JSeparator jSeparatorB5 = null;
    private JSeparator jSeparatorB6 = null;
    private JSeparator jSeparatorB7 = null;
    private JSeparator jSeparatorB8 = null;
    private JSeparator jSeparatorB9 = null;

    private JSeparator jSeparatorC1 = null;
    private JSeparator jSeparatorC2 = null;
    private JSeparator jSeparatorC3 = null;
    private JSeparator jSeparatorC4 = null;
    private JSeparator jSeparatorC5 = null;
    private JSeparator jSeparatorC6 = null;
    private JSeparator jSeparatorC7 = null;
    private JSeparator jSeparatorC8 = null;
    private JSeparator jSeparatorC9 = null;

    private JSeparator jSeparatorD1 = null;
    private JSeparator jSeparatorD2 = null;
    private JSeparator jSeparatorD3 = null;
    private JSeparator jSeparatorD4 = null;
    private JSeparator jSeparatorD5 = null;
    private JSeparator jSeparatorD6 = null;
    private JSeparator jSeparatorD7 = null;
    private JSeparator jSeparatorD8 = null;
    private JSeparator jSeparatorD9 = null;

    private JSeparator jSeparatorE1 = null;
    private JSeparator jSeparatorE2 = null;
    private JSeparator jSeparatorE3 = null;
    private JSeparator jSeparatorE4 = null;
    private JSeparator jSeparatorE5 = null;
    private JSeparator jSeparatorE6 = null;
    private JSeparator jSeparatorE7 = null;
    private JSeparator jSeparatorE8 = null;
    private JSeparator jSeparatorE9 = null;

    private JSeparator jSeparatorF1 = null;
    private JSeparator jSeparatorF2 = null;
    private JSeparator jSeparatorF3 = null;
    private JSeparator jSeparatorF4 = null;
    private JSeparator jSeparatorF5 = null;
    private JSeparator jSeparatorF6 = null;
    private JSeparator jSeparatorF7 = null;
    private JSeparator jSeparatorF8 = null;
    private JSeparator jSeparatorF9 = null;
    private JSeparator jSeparatorF10 = null;

    private JSeparator jSeparatorG1 = null;
    private JSeparator jSeparatorG2 = null;
    private JSeparator jSeparatorG3 = null;
    private JSeparator jSeparatorG4 = null;
    private JSeparator jSeparatorG5 = null;
    private JSeparator jSeparatorG6 = null;
    private JSeparator jSeparatorG7 = null;
    private JSeparator jSeparatorG8 = null;
    private JSeparator jSeparatorG9 = null;
    private JSeparator jSeparatorG10 = null;

    private JSeparator jSeparatorH1 = null;
    private JSeparator jSeparatorH2 = null;
    private JSeparator jSeparatorH3 = null;
    private JSeparator jSeparatorH4 = null;
    private JSeparator jSeparatorH5 = null;
    private JSeparator jSeparatorH6 = null;
    private JSeparator jSeparatorH7 = null;
    private JSeparator jSeparatorH8 = null;
    private JSeparator jSeparatorH9 = null;

    private JSeparator jSeparatorI1 = null;
    private JSeparator jSeparatorI2 = null;
    private JSeparator jSeparatorI3 = null;
    private JSeparator jSeparatorI4 = null;
    private JSeparator jSeparatorI5 = null;
    private JSeparator jSeparatorI6 = null;
    private JSeparator jSeparatorI7 = null;
    private JSeparator jSeparatorI8 = null;
    private JSeparator jSeparatorI9 = null;

    private JSeparator jSeparatorJ1 = null;
    private JSeparator jSeparatorJ2 = null;
    private JSeparator jSeparatorJ3 = null;
    private JSeparator jSeparatorJ4 = null;
    private JSeparator jSeparatorJ5 = null;
    private JSeparator jSeparatorJ6 = null;
    private JSeparator jSeparatorJ7 = null;
    private JSeparator jSeparatorJ8 = null;
    private JSeparator jSeparatorJ9 = null;

    private JSeparator jSeparatorL1 = null;
    private JSeparator jSeparatorL2 = null;
    private JSeparator jSeparatorL3 = null;
    private JSeparator jSeparatorL4 = null;
    private JSeparator jSeparatorL5 = null;
    private JSeparator jSeparatorL6 = null;
    private JSeparator jSeparatorL7 = null;
    private JSeparator jSeparatorL8 = null;
    private JSeparator jSeparatorL9 = null;

    private JComboBox jComboFormatosDeEntradaSequencia = null;
    private JComboBox jComboFormatosDeEntradaConversor = null;
    private JComboBox jComboFormatosDeSaidaConversor = null;

    private JButton jButtonAbreArquivoEntrada = null;
    private JButton jButtonComplementoReverso = null;
    private JButton jButtonListarSequencia = null;
    private JButton jButtonCheckSum = null;
    private JButton jButtonVoltar = null;
    private JButton jButtonAvancar = null;
    private JButton jButtonAbreArquivoEntradaConversor = null;
    private JButton jButtonAbreArquivoSaidaConversor = null;
    private JButton jButtonExecutar = null;
    private JButton jButtonSalvarSaidaDigrafu = null;
    private JButton jButtonSalvarSaidaPhyml = null;

    private JRadioButton jRadioButtonComplementoReversoSim = null;
    private JRadioButton jRadioButtonComplementoReversoNao = null;
    private JRadioButton jRadioButtonDiretorioSaidaDigrafuSim = null;
    private JRadioButton jRadioButtonDiretorioSaidaDigrafuNao = null;
    private JRadioButton jRadioButtonDiretorioSaidaPhymlSim = null;
    private JRadioButton jRadioButtonDiretorioSaidaPhymlNao = null;
    private ButtonGroup groupSimNaoPhyml;
    private ButtonGroup groupSimNao;
    private ButtonGroup groupSimNaoDigrafu;


////////////////////////////////////////////////////////////////////////////

    public Conversor() {
        super();
        initialize();
    }

////////////////////////////////////////////////////////////////////////////////

    private void initialize() {
        this.setSize(790, 470);
        this.setBackground(new Color(173, 200, 226));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/IGrafuAF.png")));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( dimension.width - getSize().width )/2, ( dimension.height - getSize().height )/2 );
        getJRadioButtonRaizNao();
        this.setContentPane(getJContentPanelPrincipal());
        this.setTitle("IGRAFU: Entrada");
    }

////////////////////////////////////////////////////////////////////////////////

    public JPanel getJContentPanelPrincipal() {
        if (jContentPanePrincipal == null) {
            jContentPanePrincipal = new JPanel();
            jContentPanePrincipal.setLayout(null);
            jContentPanePrincipal.setBackground(new Color(230, 234, 240));
            
            getJTabbedPrimaria().setEnabledAt(1, false);

            jContentPanePrincipal.add(getJTabbedPrimaria(), null);
            jContentPanePrincipal.add(getJButtonVoltar(), null);
            jContentPanePrincipal.add(getJButtonAvancar(), null);
            jContentPanePrincipal.add(getJButtonExecutar(), null);
        }
        return jContentPanePrincipal;
    }
///////////////////////////////////////////////////////////////////////////////

    public JPanel getJContentPanelSecundaria() {
        if (jContentPaneSecundaria == null) {
            jContentPaneSecundaria = new JPanel();
            jContentPaneSecundaria.setLayout(null);
            jContentPaneSecundaria.setBackground(new Color(230, 234, 240));
            jContentPaneSecundaria.add(getJTabbedPaneSecundaria(), null);
//            getJTabbedPaneSecundaria().setEnabledAt(1, false);

        }
        return jContentPaneSecundaria;
    }
///////////////////////////////////////////////////////////////////////////////

    public JPanel getJContentPanelTerciaria() {
        if (jContentPaneTerciaria == null) {
            jContentPaneTerciaria = new JPanel();
            jContentPaneTerciaria.setLayout(null);
            jContentPaneTerciaria.setBackground(new Color(230, 234, 240));
            jContentPaneTerciaria.add(getJTabbedPaneTerciaria(), null);

        }
        return jContentPaneTerciaria;
    }

//////////////////////////////////////////////////////////////////////////

    public JPanel getJContentPaneEntrada() {
        if (jContentPaneEntrada == null) {
            jLabelFormatosDeEntrada = new JLabel();
            jLabelFormatosDeEntrada.setText("Formato de entrada");
            jLabelFormatosDeEntrada.setSize(new Dimension(140, 15));
            jLabelFormatosDeEntrada.setLocation(new Point(413+formEntX, 31+formEnty));
            jLabelFormatosDeEntrada.setFont(new Font("Arial", Font.BOLD, 12));

            jLabelArquivoSequencia = new JLabel();
            jLabelArquivoSequencia.setBounds(new Rectangle(230+arqEntX, 295+arqEntY, 157, 16));
            jLabelArquivoSequencia.setText("Arquivo da Sequência");

            final ImageIcon modoExecucao = new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/rna.png"));
            jContentPaneEntrada = new JPanel(){
                public static final long serialVersionUID = 1L;
                protected void paintComponent( Graphics g ){
                    super.paintComponent(g);
                    modoExecucao.setImage(modoExecucao.getImage().getScaledInstance(250, 360, 100));
                    modoExecucao.paintIcon(this,g,0,0);
                }
            };
            jContentPaneEntrada.setLayout(null);
            jContentPaneEntrada.setBackground(new Color(173, 200, 226));

            jContentPaneEntrada.add(jLabelArquivoSequencia, null);
            jContentPaneEntrada.add(getJTextFieldArquivoEntrada(), null);
            jContentPaneEntrada.add(getJButtonAbreArquivoEntrada(), null);
            jContentPaneEntrada.add(getJSeparatorA1(), null);
            jContentPaneEntrada.add(getJSeparatorA2(), null);
            jContentPaneEntrada.add(getJSeparatorA3(), null);
            jContentPaneEntrada.add(getJSeparatorA4(), null);
            jContentPaneEntrada.add(getJSeparatorA5(), null);
            jContentPaneEntrada.add(getJSeparatorA6(), null);
            jContentPaneEntrada.add(getJSeparatorA7(), null);
            jContentPaneEntrada.add(getJSeparatorA8(), null);
            jContentPaneEntrada.add(getJSeparatorA9(), null);
            jContentPaneEntrada.add(jLabelFormatosDeEntrada, null);
            jContentPaneEntrada.add(getJSeparatorB1(), null);
            jContentPaneEntrada.add(getJSeparatorB2(), null);
            jContentPaneEntrada.add(getJSeparatorB3(), null);
            jContentPaneEntrada.add(getJSeparatorB4(), null);
            jContentPaneEntrada.add(getJSeparatorB5(), null);
            jContentPaneEntrada.add(getJSeparatorB6(), null);
            jContentPaneEntrada.add(getJSeparatorB7(), null);
            jContentPaneEntrada.add(getJSeparatorB8(), null);
            jContentPaneEntrada.add(getJSeparatorB9(), null);
            jContentPaneEntrada.add(getJComboBoxTipoDadoEntradaSequencia(), null);
            //jContentPaneEntrada.add(getJComboBoxTipoDadoEntradaConversor(), null);
        }
        return jContentPaneEntrada;
    }

/////////////////////////////////////////////////////////////////////////////

    public JPanel getJPanelOpcoes() {
       
        if (jPanelOpcoes == null) {
            jLabelComplementoReverso = new JLabel();
            jLabelComplementoReverso.setText("Complemento Reverso");
            jLabelComplementoReverso.setSize(new Dimension(185, 15));
            jLabelComplementoReverso.setLocation(new Point(233+SimNaoX2, SimNaoY+ 295));
            jLabelComplementoReverso.setFont(new Font("Arial", Font.BOLD, 12));

            jLabelListarSequencia = new JLabel();
            jLabelListarSequencia.setText("Listar Sequencias");
            jLabelListarSequencia.setBounds(new Rectangle(235+ListarSeqX, 295+ListarSeqY, 157, 16));
            jLabelListarSequencia.setFont(new Font("Arial", Font.BOLD, 12));
            
            jLabelCheckSum = new JLabel();
            jLabelCheckSum.setText("Obter Checksum");
            jLabelCheckSum.setBounds(new Rectangle(235+CheckSumX, 295+CheckSumY, 157, 16));
            jLabelCheckSum.setFont(new Font("Arial", Font.BOLD, 12));
            

            jPanelOpcoes = new JPanel();
            jPanelOpcoes.setLayout(null);
            jPanelOpcoes.setBackground(new Color(173, 200, 226));

            jPanelOpcoes.add(jLabelComplementoReverso);
            jPanelOpcoes.add(getJButtonComplementoReverso(), null);
            jPanelOpcoes.add(getJTextFieldComplementoReverso(),null);
            jPanelOpcoes.add(getJSeparatorC1(), null);
            jPanelOpcoes.add(getJSeparatorC2(), null);
            jPanelOpcoes.add(getJSeparatorC3(), null);
            jPanelOpcoes.add(getJSeparatorC4(), null);
            jPanelOpcoes.add(getJSeparatorC5(), null);
            jPanelOpcoes.add(getJSeparatorC6(), null);
            jPanelOpcoes.add(getJSeparatorC7(), null);
            jPanelOpcoes.add(getJSeparatorC8(), null);
            jPanelOpcoes.add(getJSeparatorC9(), null);
            //jPanelOpcoes.add(getJRadioButtonRaizSim(), null);
            //jPanelOpcoes.add(getJRadioButtonRaizNao(), null);

            getJRadioButtonSimNaoGroup();

            jPanelOpcoes.add(jLabelListarSequencia, null);
            jPanelOpcoes.add(getJButtonListarSequencia(), null);
            jPanelOpcoes.add(getJTextFieldListarSequencia(),null);
            jPanelOpcoes.add(getJSeparatorD1(), null);
            jPanelOpcoes.add(getJSeparatorD2(), null);
            jPanelOpcoes.add(getJSeparatorD3(), null);
            jPanelOpcoes.add(getJSeparatorD4(), null);
            jPanelOpcoes.add(getJSeparatorD5(), null);
            jPanelOpcoes.add(getJSeparatorD6(), null);
            jPanelOpcoes.add(getJSeparatorD7(), null);
            jPanelOpcoes.add(getJSeparatorD8(), null);
            jPanelOpcoes.add(getJSeparatorD9(), null);

            jPanelOpcoes.add(jLabelCheckSum, null);
            jPanelOpcoes.add(getJButtonCheckSum(), null);
            jPanelOpcoes.add(getJTextFieldCheckSum(),null);
            jPanelOpcoes.add(getJSeparatorE1(), null);
            jPanelOpcoes.add(getJSeparatorE2(), null);
            jPanelOpcoes.add(getJSeparatorE3(), null);
            jPanelOpcoes.add(getJSeparatorE4(), null);
            jPanelOpcoes.add(getJSeparatorE5(), null);
            jPanelOpcoes.add(getJSeparatorE6(), null);
            jPanelOpcoes.add(getJSeparatorE7(), null);
            jPanelOpcoes.add(getJSeparatorE8(), null);
            jPanelOpcoes.add(getJSeparatorE9(), null);
        }
        return jPanelOpcoes;
    }

/////////////////////////////////////////////////////////////////////////////

    public JPanel getJContentPanelConversor(){
        if(jPanelConversor == null){
            jPanelConversor = new JPanel();
            jPanelConversor.setLayout(null);
            jPanelConversor.setBackground(new Color(173, 200, 226));

            jLabelEntradaConversor = new JLabel();
            jLabelEntradaConversor.setText("Entrada");
            jLabelEntradaConversor.setSize(new Dimension(185, 15));
            jLabelEntradaConversor.setLocation(new Point(290,29));
            jLabelEntradaConversor.setFont(new Font("Arial", Font.BOLD, 12));

            jLabelSaidaConversor = new JLabel();
            jLabelSaidaConversor.setText("Saida");
            jLabelSaidaConversor.setSize(new Dimension(185, 15));
            jLabelSaidaConversor.setLocation(new Point(295+SaidaConversorX,SaidaConversorY+29));
            jLabelSaidaConversor.setFont(new Font("Arial", Font.BOLD, 12));

            jPanelConversor.add(jLabelEntradaConversor);
            jPanelConversor.add(getJSeparatorF1(), null);
            jPanelConversor.add(getJSeparatorF2(), null);
            jPanelConversor.add(getJSeparatorF3(), null);
            jPanelConversor.add(getJSeparatorF4(), null);
            jPanelConversor.add(getJSeparatorF5(), null);
            jPanelConversor.add(getJSeparatorF6(), null);
            jPanelConversor.add(getJSeparatorF7(), null);
            jPanelConversor.add(getJSeparatorF8(), null);
            jPanelConversor.add(getJSeparatorF9(), null);
            jPanelConversor.add(getJSeparatorF10(), null);
            jPanelConversor.add(getJComboBoxTipoDadoEntradaConversor(),null);
            jPanelConversor.add(getJTextFieldArquivoEntradaConversor(), null);
            jPanelConversor.add(getJButtonAbreArquivoEntradaConversor(), null);

            jPanelConversor.add(jLabelSaidaConversor);
            jPanelConversor.add(getJSeparatorG1(), null);
            jPanelConversor.add(getJSeparatorG2(), null);
            jPanelConversor.add(getJSeparatorG3(), null);
            jPanelConversor.add(getJSeparatorG4(), null);
            jPanelConversor.add(getJSeparatorG5(), null);
            jPanelConversor.add(getJSeparatorG6(), null);
            jPanelConversor.add(getJSeparatorG7(), null);
            jPanelConversor.add(getJSeparatorG8(), null);
            jPanelConversor.add(getJSeparatorG9(), null);
            jPanelConversor.add(getJSeparatorG10(), null);

            jPanelConversor.add(getJComboBoxTipoDadoSaidaConversor(),null);

            jPanelConversor.add(getJTextFieldArquivoSaidaConversor(), null);
            jPanelConversor.add(getJButtonAbreArquivoSaidaConversor(), null);
        }
        return jPanelConversor;
    }

//////////////////////////////////////////////////////////////////////////////
    public JPanel getJContentPanelSaidaPHYML(){
        if(jPanelSaidaPHYML == null){
            jPanelSaidaPHYML = new JPanel();
            jPanelSaidaPHYML.setLayout(null);
            jPanelSaidaPHYML.setBackground(new Color(173, 200, 226));

            jLabelDiretorioSaidaPhyml = new JLabel();
            jLabelDiretorioSaidaPhyml.setText("Alterar diretorio de saida");
            jLabelDiretorioSaidaPhyml.setSize(new Dimension(185, 15));
            jLabelDiretorioSaidaPhyml.setLocation(new Point(240-12+SaidaDigrafuX,SaidaDigrafuY+ 254));
            jLabelDiretorioSaidaPhyml.setFont(new Font("Arial", Font.BOLD, 12));

            jLabelSalvarSaidaPhyml = new JLabel();
            jLabelSalvarSaidaPhyml.setBounds(new Rectangle(230+5+x, 295+y, 157, 16));
            jLabelSalvarSaidaPhyml.setText("Diretorio de Saida");

            jPanelSaidaPHYML.add(jLabelDiretorioSaidaPhyml);
            jPanelSaidaPHYML.add(getJSeparatorI1(), null);
            jPanelSaidaPHYML.add(getJSeparatorI2(), null);
            jPanelSaidaPHYML.add(getJSeparatorI3(), null);
            jPanelSaidaPHYML.add(getJSeparatorI4(), null);
            jPanelSaidaPHYML.add(getJSeparatorI5(), null);
            jPanelSaidaPHYML.add(getJSeparatorI6(), null);
            jPanelSaidaPHYML.add(getJSeparatorI7(), null);
            jPanelSaidaPHYML.add(getJSeparatorI8(), null);
            jPanelSaidaPHYML.add(getJSeparatorI9(), null);
            jPanelSaidaPHYML.add(getJRadioButtonSaidaSimPhyml(), null);
            jPanelSaidaPHYML.add(getJRadioButtonSaidaNaoPhyml(), null);

            getJRadioButtonSimNaoGroupPhyml();

            jPanelSaidaPHYML.add(jLabelSalvarSaidaPhyml, null);
            jPanelSaidaPHYML.add(getJButtonSalvarSaidaPhyml(), null);
            jPanelSaidaPHYML.add(getJTextFieldSalvarSaidaPhyml(),null);
            jPanelSaidaPHYML.add(getJSeparatorL1(), null);
            jPanelSaidaPHYML.add(getJSeparatorL2(), null);
            jPanelSaidaPHYML.add(getJSeparatorL3(), null);
            jPanelSaidaPHYML.add(getJSeparatorL4(), null);
            jPanelSaidaPHYML.add(getJSeparatorL5(), null);
            jPanelSaidaPHYML.add(getJSeparatorL6(), null);
            jPanelSaidaPHYML.add(getJSeparatorL7(), null);
            jPanelSaidaPHYML.add(getJSeparatorL8(), null);
            jPanelSaidaPHYML.add(getJSeparatorL9(), null);
        }
        return jPanelSaidaPHYML;

    }

    public JPanel getJContentPanelSaidaDIGRAFU(){
        if(jPanelSaidaDIGRAFU == null){
            jPanelSaidaDIGRAFU = new JPanel();
            jPanelSaidaDIGRAFU.setLayout(null);
            jPanelSaidaDIGRAFU.setBackground(new Color(173, 200, 226));

            jLabelDiretorioSaidaDigrafu = new JLabel();
            jLabelDiretorioSaidaDigrafu.setText("Alterar diretorio de saida");
            jLabelDiretorioSaidaDigrafu.setSize(new Dimension(185, 15));
            jLabelDiretorioSaidaDigrafu.setLocation(new Point(240-12+SaidaDigrafuX,SaidaDigrafuY+ 254));
            jLabelDiretorioSaidaDigrafu.setFont(new Font("Arial", Font.BOLD, 12));

            jLabelSalvarSaidaDigrafu = new JLabel();
            jLabelSalvarSaidaDigrafu.setBounds(new Rectangle(230+5+x, 295+y, 157, 16));
            jLabelSalvarSaidaDigrafu.setText("Diretorio de Saida");

            jPanelSaidaDIGRAFU.add(jLabelDiretorioSaidaDigrafu);
            jPanelSaidaDIGRAFU.add(getJSeparatorH1(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH2(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH3(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH4(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH5(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH6(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH7(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH8(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorH9(), null);
            jPanelSaidaDIGRAFU.add(getJRadioButtonSaidaSimDigrafu(), null);
            jPanelSaidaDIGRAFU.add(getJRadioButtonSaidaNaoDigrafu(), null);

            getJRadioButtonSimNaoGroupDigrafu();

            jPanelSaidaDIGRAFU.add(jLabelSalvarSaidaDigrafu, null);
            jPanelSaidaDIGRAFU.add(getJButtonSalvarSaidaDigrafu(), null);
            jPanelSaidaDIGRAFU.add(getJTextFieldSalvarSaidaDigrafu(),null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ1(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ2(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ3(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ4(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ5(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ6(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ7(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ8(), null);
            jPanelSaidaDIGRAFU.add(getJSeparatorJ9(), null);
        }
        return jPanelSaidaDIGRAFU;

    }

 ///////////////////////////////////////////////////////////////////////////////

    public JTabbedPane getJTabbedPrimaria() {
        if (jTabbedPanePrimaria == null) {
            jTabbedPanePrimaria = new JTabbedPane();
            jTabbedPanePrimaria.setLocation(new Point(33, 10));
            jTabbedPanePrimaria.setSize(625, 400);
            jTabbedPanePrimaria.setBackground(new Color(192, 209, 226));

            //jTabbedPanePrimaria.setEnabledAt(1, false);

            jTabbedPanePrimaria.addTab("Entrada",null,getJContentPaneEntrada(), null);
            jTabbedPanePrimaria.addTab("Opções",null,getJContentPanelSecundaria(), null);
            jTabbedPanePrimaria.addTab("Saida",null,getJContentPanelTerciaria(), null);
            jTabbedPanePrimaria.addTab("Conversor",null,getJContentPanelConversor(), null);

            //jTabbedPanePrimaria.setEnabledAt(1, false);

        }
        return jTabbedPanePrimaria;
    }
///////////////////////////////////////////////////////////////////////////////

     public JTabbedPane getJTabbedPaneSecundaria() {
        if (jTabbedPaneSecundaria == null) {
            jTabbedPaneSecundaria = new JTabbedPane();
            jTabbedPaneSecundaria.setLocation(new Point(0, 0));
            jTabbedPaneSecundaria.setSize(625, 400);
            jTabbedPaneSecundaria.setBackground(new Color(192, 209, 226));
            jTabbedPaneSecundaria.addTab("Entrada",null,getJPanelOpcoes(), null);
            //jTabbedPaneSecundaria.addTab("Saida",null,getJContentPanelTerciaria(), null);

//            jTabbedPaneSecundaria.setEnabledAt(0, false);
            //jTabbedPaneSecundaria.addTab("Conversor",null,getJContentPanelConversor(), null);
        }
        return jTabbedPaneSecundaria;
    }
///////////////////////////////////////////////////////////////////////////////

     public JTabbedPane getJTabbedPaneTerciaria() {
        if (jTabbedPaneTerciaria == null) {
            jTabbedPaneTerciaria = new JTabbedPane();
            jTabbedPaneTerciaria.setLocation(new Point(0, 0));
            jTabbedPaneTerciaria.setSize(625, 400);
            jTabbedPaneTerciaria.setBackground(new Color(192, 209, 226));
            jTabbedPaneTerciaria.addTab("DIGRAFU",null,getJContentPanelSaidaDIGRAFU(), null);
            jTabbedPaneTerciaria.addTab("PHYML",null,getJContentPanelSaidaPHYML(), null);
            //jTabbedPaneTerciaria.addTab("MR. Bayes",null,null, null);
            //jTabbedPaneTerciaria.addTab("Parsimonia",null,null, null);

        }
        return jTabbedPaneTerciaria;
    }

///////////////////////////////////////////////////////////////////////////////

     public JButton getJButtonComplementoReverso() {
        if (jButtonComplementoReverso == null) {
            jButtonComplementoReverso = new JButton();
            //jButtonComplementoReverso.setText("Complemento");
            jButtonComplementoReverso.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/save.gif")));
            jButtonComplementoReverso.setLocation(new Point(70+570+SimNaoX, 288+SimNaoY));
            jButtonComplementoReverso.setSize(new Dimension(30, 29));
            jButtonComplementoReverso.setToolTipText("Salvar arquivo");
            jButtonComplementoReverso.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jButtonComplementoReverso;
    }

/////////////////////////////////////////////////////////////////////////////////
    public JButton getJButtonListarSequencia() {
        if (jButtonListarSequencia == null) {
            jButtonListarSequencia = new JButton();
            //jButtonListarSequencia.setText("Listar");
            jButtonListarSequencia.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/save.gif")));
            jButtonListarSequencia.setLocation(new Point(70+580-10+ListarSeqX, 288+ListarSeqY));
            jButtonListarSequencia.setSize(new Dimension(30, 29));
            jButtonListarSequencia.setToolTipText("Salvar arquivo");
            jButtonListarSequencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jButtonListarSequencia;
    }
/////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonSalvarSaidaDigrafu() {
        if (jButtonSalvarSaidaDigrafu == null) {
            jButtonSalvarSaidaDigrafu = new JButton();
            //jButtonSalvarSaidaDigrafu.setText("Escolher");
            jButtonSalvarSaidaDigrafu.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder_open.gif")));
            jButtonSalvarSaidaDigrafu.setLocation(new Point(30+help+580-10+x, 288+y));
            jButtonSalvarSaidaDigrafu.setSize(new Dimension(30, 29));
            jButtonSalvarSaidaDigrafu.setToolTipText("Escolher diretorio");
            jButtonSalvarSaidaDigrafu.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonSalvarSaidaDigrafu.setEnabled(false);
        }
        return jButtonSalvarSaidaDigrafu;
    }

    public JButton getJButtonSalvarSaidaPhyml() {
        if (jButtonSalvarSaidaPhyml == null) {
            jButtonSalvarSaidaPhyml = new JButton();
            //jButtonSalvarSaidaPhyml.setText("Escolher");
            jButtonSalvarSaidaPhyml.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder_open.gif")));
            jButtonSalvarSaidaPhyml.setLocation(new Point(30+help+580-10+x, 288+y));
            jButtonSalvarSaidaPhyml.setSize(new Dimension(30, 29));
            jButtonSalvarSaidaPhyml.setToolTipText("Escolher diretorio");
            jButtonSalvarSaidaPhyml.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonSalvarSaidaPhyml.setEnabled(false);
        }
        return jButtonSalvarSaidaPhyml;
    }
 //////////////////////////////////////////////////////////////////////////////

    public JTextField getJTextFieldSalvarSaidaDigrafu() {
         Processo.pegaCaminho();

        if (jTextFieldSalvarSaidaDigrafu == null) {
            jTextFieldSalvarSaidaDigrafu = new JTextField();
            jTextFieldSalvarSaidaDigrafu.setBounds(new Rectangle(help+375-20+x, 290+y, 200+30, 24));//setLocation(new Point(399, 294));
           // jTextFieldSalvarSaidaDigrafu.setEditable(false);
            jTextFieldSalvarSaidaDigrafu.setVisible(true);
            jTextFieldSalvarSaidaDigrafu.setEnabled(false);
            jTextFieldSalvarSaidaDigrafu.setText((GeraParametrosDIGRAFU.caminho()+Processo.corrigeCaminho.toString()+"/arquivos_saida/digrafu"));
        }
        return jTextFieldSalvarSaidaDigrafu;
    }

     public JTextField getJTextFieldSalvarSaidaPhyml() {
         Processo.pegaCaminho();

        if (jTextFieldSalvarSaidaPhyml == null) {
            jTextFieldSalvarSaidaPhyml = new JTextField();
            jTextFieldSalvarSaidaPhyml.setBounds(new Rectangle(help+375-20+x, 290+y, 200+30, 24));//setLocation(new Point(399, 294));
            jTextFieldSalvarSaidaPhyml.setEditable(false);
            jTextFieldSalvarSaidaPhyml.setVisible(true);
            jTextFieldSalvarSaidaPhyml.setEnabled(false);
            jTextFieldSalvarSaidaPhyml.setText(Processo.pegaCaminho+Processo.corrigeCaminho.toString()+"/arquivos_saida/phyml/");
        }
        return jTextFieldSalvarSaidaPhyml;
    }

///////////////////////////////////////////////////////////////////////////////

     public JTextField getJTextFieldComplementoReverso() {
        if (jTextFieldComplementoReverso == null) {
            jTextFieldComplementoReverso = new JTextField();
            jTextFieldComplementoReverso.setBounds(new Rectangle(help+355+SimNaoX, 290+SimNaoY, 70+200-help, 24));//setLocation(new Point(399, 294));
            jTextFieldComplementoReverso.setEditable(false);
            jTextFieldComplementoReverso.setVisible(true);
        }
        return jTextFieldComplementoReverso;
    }

///////////////////////////////////////////////////////////////////////////////

    public JTextField getJTextFieldListarSequencia() {
        if (jTextFieldListarSequencia == null) {
            jTextFieldListarSequencia = new JTextField();
            jTextFieldListarSequencia.setBounds(new Rectangle(help+355+ListarSeqX, 290+ListarSeqY, 70+200-help, 24));//setLocation(new Point(399, 294));
            jTextFieldListarSequencia.setEditable(false);
            jTextFieldListarSequencia.setVisible(true);
        }
        return jTextFieldListarSequencia;
    }
///////////////////////////////////////////////////////////////////////////////

    public JSeparator getJSeparatorD1() {
        if (jSeparatorD1 == null) {
            jSeparatorD1 = new JSeparator();
            jSeparatorD1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorD1.setSize(new Dimension(10, 22));
            jSeparatorD1.setLocation(new Point(226+ListarSeqX,ListarSeqY+292));
        }
        return jSeparatorD1;
    }

    public JSeparator getJSeparatorD2() {
        if (jSeparatorD2 == null) {
            jSeparatorD2 = new JSeparator();
            jSeparatorD2.setSize(new Dimension(help+121, 10));
            jSeparatorD2.setLocation(new Point(227+ListarSeqX,ListarSeqY+291));
        }
        return jSeparatorD2;
    }

    public JSeparator getJSeparatorD3() {
        if (jSeparatorD3 == null) {
            jSeparatorD3 = new JSeparator();
            jSeparatorD3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorD3.setSize(new Dimension(10, 22));
            jSeparatorD3.setLocation(new Point(help+347+ListarSeqX,ListarSeqY+292));
        }
        return jSeparatorD3;
    }

    public JSeparator getJSeparatorD4() {
        if (jSeparatorD4 == null) {
            jSeparatorD4 = new JSeparator();
            jSeparatorD4.setLocation(new Point(227+ListarSeqX,ListarSeqY+314));
            jSeparatorD4.setSize(new Dimension(help+121, 10));
        }
        return jSeparatorD4;
    }

    public JSeparator getJSeparatorD5() {
        if (jSeparatorD5 == null) {
            jSeparatorD5 = new JSeparator();
            jSeparatorD5.setLocation(new Point(320-20+ListarSeqX,ListarSeqY+265));
            jSeparatorD5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorD5.setSize(new Dimension(10, 27));
        }
        return jSeparatorD5;
    }

    public JSeparator getJSeparatorD6() {
        if (jSeparatorD6 == null) {
            jSeparatorD6 = new JSeparator();
            jSeparatorD6.setSize(new Dimension(290+95, 10));
            jSeparatorD6.setLocation(new Point(320-20+ListarSeqX,ListarSeqY+264));
        }
        return jSeparatorD6;
    }

    public JSeparator getJSeparatorD7() {
        if (jSeparatorD7 == null) {
            jSeparatorD7 = new JSeparator();
            jSeparatorD7.setBounds(new Rectangle(610+75+ListarSeqX, 265+ListarSeqY, 10, 78));
            jSeparatorD7.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparatorD7;
    }

    public JSeparator getJSeparatorD8() {
        if (jSeparatorD8 == null) {
            jSeparatorD8 = new JSeparator();
            jSeparatorD8.setOrientation(SwingConstants.VERTICAL);
            jSeparatorD8.setSize(new Dimension(10, 27));
            jSeparatorD8.setLocation(new Point(320-20+ListarSeqX,ListarSeqY+314));
        }
        return jSeparatorD8;
    }

    public JSeparator getJSeparatorD9() {
        if (jSeparatorD9 == null) {
            jSeparatorD9 = new JSeparator();
            jSeparatorD9.setSize(new Dimension(290+95, 10));
            jSeparatorD9.setLocation(new Point(320-20+ListarSeqX,ListarSeqY+341));
        }
        return jSeparatorD9;
    }

///////////////////////////////////////////////////////////////////////////////

    public void getJRadioButtonSimNaoGroup(){
        groupSimNao = new ButtonGroup();
        groupSimNao.add(getJRadioButtonRaizSim());
        groupSimNao.add(getJRadioButtonRaizNao());
    }

    public JRadioButton getJRadioButtonRaizSim() {
        if (jRadioButtonComplementoReversoSim == null) {
            jRadioButtonComplementoReversoSim = new JRadioButton();
            jRadioButtonComplementoReversoSim.setText("Sim");
            jRadioButtonComplementoReversoSim.setBounds(new Rectangle(263+SimNaoX2 , SimNaoY+281, 64, 21));
            jRadioButtonComplementoReversoSim.setOpaque(false);
            //jRadioButtonComplementoReversoSim.setSelected(true);

        }
        return jRadioButtonComplementoReversoSim;
    }

    public JRadioButton getJRadioButtonRaizNao() {
        if (jRadioButtonComplementoReversoNao == null) {
            jRadioButtonComplementoReversoNao = new JRadioButton();
            jRadioButtonComplementoReversoNao.setText("Nao");
            jRadioButtonComplementoReversoNao.setSize(new Dimension(69, 23));
            jRadioButtonComplementoReversoNao.setLocation(new Point(338+SimNaoX2 , SimNaoY+281));
            jRadioButtonComplementoReversoNao.setOpaque(false);
            jRadioButtonComplementoReversoNao.setSelected(true);
        }
		return jRadioButtonComplementoReversoNao;
	}
//////////////////////////////////////////////////////////////////////////////

    public void getJRadioButtonSimNaoGroupDigrafu(){
        groupSimNaoDigrafu = new ButtonGroup();
        groupSimNaoDigrafu.add(getJRadioButtonSaidaSimDigrafu());
        groupSimNaoDigrafu.add(getJRadioButtonSaidaNaoDigrafu());
    }

    public JRadioButton getJRadioButtonSaidaSimDigrafu() {
        if (jRadioButtonDiretorioSaidaDigrafuSim == null) {
            jRadioButtonDiretorioSaidaDigrafuSim = new JRadioButton();
            jRadioButtonDiretorioSaidaDigrafuSim.setText("Sim");
            jRadioButtonDiretorioSaidaDigrafuSim.setBounds(new Rectangle(263+SaidaDigrafuX , SaidaDigrafuY+281, 64, 21));
            jRadioButtonDiretorioSaidaDigrafuSim.setOpaque(false);
            //jRadioButtonDiretorioSaidaDigrafuSim.setSelected(true);

        }
        return jRadioButtonDiretorioSaidaDigrafuSim;
    }

    public JRadioButton getJRadioButtonSaidaNaoDigrafu() {
        if (jRadioButtonDiretorioSaidaDigrafuNao == null) {
            jRadioButtonDiretorioSaidaDigrafuNao = new JRadioButton();
            jRadioButtonDiretorioSaidaDigrafuNao.setText("Nao");
            jRadioButtonDiretorioSaidaDigrafuNao.setSize(new Dimension(69, 23));
            jRadioButtonDiretorioSaidaDigrafuNao.setLocation(new Point(338+SaidaDigrafuX , SaidaDigrafuY+281));
            jRadioButtonDiretorioSaidaDigrafuNao.setOpaque(false);
            jRadioButtonDiretorioSaidaDigrafuNao.setSelected(true);
        }
		return jRadioButtonDiretorioSaidaDigrafuNao;
	}
/////////////////////////////////////////////////////////////////////////////

     public void getJRadioButtonSimNaoGroupPhyml(){
        groupSimNaoPhyml = new ButtonGroup();
        groupSimNaoPhyml.add(getJRadioButtonSaidaSimPhyml());
        groupSimNaoPhyml.add(getJRadioButtonSaidaNaoPhyml());
    }

    public JRadioButton getJRadioButtonSaidaSimPhyml() {
        if (jRadioButtonDiretorioSaidaPhymlSim == null) {
            jRadioButtonDiretorioSaidaPhymlSim = new JRadioButton();
            jRadioButtonDiretorioSaidaPhymlSim.setText("Sim");
            jRadioButtonDiretorioSaidaPhymlSim.setBounds(new Rectangle(263+SalvarDiretorioX , SalvarDiretorioY+281, 64, 21));
            jRadioButtonDiretorioSaidaPhymlSim.setOpaque(false);
            //jRadioButtonDiretorioSaidaPhymlSim.setSelected(true);

        }
        return jRadioButtonDiretorioSaidaPhymlSim;
    }

    public JRadioButton getJRadioButtonSaidaNaoPhyml() {
        if (jRadioButtonDiretorioSaidaPhymlNao == null) {
            jRadioButtonDiretorioSaidaPhymlNao = new JRadioButton();
            jRadioButtonDiretorioSaidaPhymlNao.setText("Nao");
            jRadioButtonDiretorioSaidaPhymlNao.setSize(new Dimension(69, 23));
            jRadioButtonDiretorioSaidaPhymlNao.setLocation(new Point(338+SalvarDiretorioX , SalvarDiretorioY+281));
            jRadioButtonDiretorioSaidaPhymlNao.setOpaque(false);
            jRadioButtonDiretorioSaidaPhymlNao.setSelected(true);
        }
		return jRadioButtonDiretorioSaidaPhymlNao;
	}


//////////////////////////////////////////////////////////////////////////////

    public JSeparator getJSeparatorC1() {
        if (jSeparatorC1 == null) {
            jSeparatorC1 = new JSeparator();
            jSeparatorC1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorC1.setSize(new Dimension(10, 22));
            jSeparatorC1.setLocation(new Point(226+SimNaoX2,SimNaoY+292));
        }
        return jSeparatorC1;
    }

    public JSeparator getJSeparatorC2() {
        if (jSeparatorC2 == null) {
            jSeparatorC2 = new JSeparator();
            jSeparatorC2.setSize(new Dimension(help+121, 10));
            jSeparatorC2.setLocation(new Point(227+SimNaoX2,SimNaoY+291));
        }
        return jSeparatorC2;
    }

    public JSeparator getJSeparatorC3() {
        if (jSeparatorC3 == null) {
            jSeparatorC3 = new JSeparator();
            jSeparatorC3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorC3.setSize(new Dimension(10, 22));
            jSeparatorC3.setLocation(new Point(help+347+SimNaoX2,SimNaoY+292));
        }
        return jSeparatorC3;
    }

    public JSeparator getJSeparatorC4() {
        if (jSeparatorC4 == null) {
            jSeparatorC4 = new JSeparator();
            jSeparatorC4.setLocation(new Point(227+SimNaoX2,SimNaoY+314));
            jSeparatorC4.setSize(new Dimension(help+121, 10));
        }
        return jSeparatorC4;
    }

    public JSeparator getJSeparatorC5() {
        if (jSeparatorC5 == null) {
            jSeparatorC5 = new JSeparator();
            jSeparatorC5.setLocation(new Point(320-20+SimNaoX,SimNaoY+265));
            jSeparatorC5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorC5.setSize(new Dimension(10, 27));
        }
        return jSeparatorC5;
    }

    public JSeparator getJSeparatorC6() {
        if (jSeparatorC6 == null) {
            jSeparatorC6 = new JSeparator();
            jSeparatorC6.setSize(new Dimension(290+95, 10));
            jSeparatorC6.setLocation(new Point(320-20+SimNaoX,SimNaoY+264));
        }
        return jSeparatorC6;
    }

    public JSeparator getJSeparatorC7() {
        if (jSeparatorC7 == null) {
            jSeparatorC7 = new JSeparator();
            jSeparatorC7.setBounds(new Rectangle(610+75+SimNaoX, 265+SimNaoY, 10, 78));
            jSeparatorC7.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparatorC7;
    }

    public JSeparator getJSeparatorC8() {
        if (jSeparatorC8 == null) {
            jSeparatorC8 = new JSeparator();
            jSeparatorC8.setOrientation(SwingConstants.VERTICAL);
            jSeparatorC8.setSize(new Dimension(10, 27));
            jSeparatorC8.setLocation(new Point(320-20+SimNaoX,SimNaoY+314));
        }
        return jSeparatorC8;
    }

    public JSeparator getJSeparatorC9() {
        if (jSeparatorC9 == null) {
            jSeparatorC9 = new JSeparator();
            jSeparatorC9.setSize(new Dimension(290+95, 10));
            jSeparatorC9.setLocation(new Point(320-20+SimNaoX,SimNaoY+341));
        }
        return jSeparatorC9;
    }

//////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonAbreArquivoEntrada() {
        if (jButtonAbreArquivoEntrada == null) {
            jButtonAbreArquivoEntrada = new JButton();
            jButtonAbreArquivoEntrada.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
            jButtonAbreArquivoEntrada.setLocation(new Point(560+arqEntX, 290+arqEntY));
            jButtonAbreArquivoEntrada.setSize(new Dimension(30, 29));
            jButtonAbreArquivoEntrada.setToolTipText("Abrir arquivo");
            jButtonAbreArquivoEntrada.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jButtonAbreArquivoEntrada;
    }
//////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonAbreArquivoEntradaConversor() {
        if (jButtonAbreArquivoEntradaConversor == null) {
            jButtonAbreArquivoEntradaConversor = new JButton();
            jButtonAbreArquivoEntradaConversor.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
            jButtonAbreArquivoEntradaConversor.setLocation(new Point(49, 50));
            jButtonAbreArquivoEntradaConversor.setSize(new Dimension(30, 29));
            jButtonAbreArquivoEntradaConversor.setToolTipText("Abrir arquivo");
            jButtonAbreArquivoEntradaConversor.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
        }
        return jButtonAbreArquivoEntradaConversor;
    }
////////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonAbreArquivoSaidaConversor() {
        if (jButtonAbreArquivoSaidaConversor == null) {
            jButtonAbreArquivoSaidaConversor = new JButton();
            jButtonAbreArquivoSaidaConversor.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/folder.png")));
            jButtonAbreArquivoSaidaConversor.setLocation(new Point(49+SaidaConversorX,SaidaConversorY+ 50));
            jButtonAbreArquivoSaidaConversor.setSize(new Dimension(30, 29));
            jButtonAbreArquivoSaidaConversor.setToolTipText("Abrir arquivo");
            jButtonAbreArquivoSaidaConversor.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonAbreArquivoSaidaConversor.setEnabled(false);
        }
        return jButtonAbreArquivoSaidaConversor;
    }

///////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonAvancar() {
        if (jButtonAvancar == null) {
            jButtonAvancar = new JButton();
            jButtonAvancar.setBounds(new Rectangle(663+botoesX, 384+botoesY, 117, 25));
            jButtonAvancar.setText("Avançar");
            jButtonAvancar.setFont(new Font("Dialog", Font.BOLD, 10));
            jButtonAvancar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/avancar.png")));
            jButtonAvancar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jButtonAvancar;
    }

////////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonVoltar() {
        if (jButtonVoltar == null) {
            jButtonVoltar = new JButton();
            jButtonVoltar.setText("Voltar");
            jButtonVoltar.setLocation(new Point(663+botoesX, 339+botoesY));
            jButtonVoltar.setSize(new Dimension(117, 25));
            jButtonVoltar.setFont(new Font("Dialog", Font.BOLD, 10));
            jButtonVoltar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png")));
            jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jButtonVoltar;
    }

////////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonExecutar() {
        if (jButtonExecutar == null) {
            jButtonExecutar = new JButton();
            jButtonExecutar.setText("Executar");
            jButtonExecutar.setLocation(new Point(663, 70));
            jButtonExecutar.setSize(new Dimension(117, 25));
            jButtonExecutar.setFont(new Font("Dialog", Font.BOLD, 10));
            jButtonExecutar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/Ok.png")));
            jButtonExecutar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonExecutar.setVisible(false);
        }
        return jButtonExecutar;
    }

///////////////////////////////////////////////////////////////////////////////

    public JTextField getJTextFieldArquivoEntrada() {
        if (jTextFieldArquivoEntrada == null) {
            jTextFieldArquivoEntrada = new JTextField();
            jTextFieldArquivoEntrada.setLocation(new Point(399+arqEntX, 294+arqEntY));
            jTextFieldArquivoEntrada.setSize(new Dimension(150, 20));
            jTextFieldArquivoEntrada.setEditable(false);
        }
        return jTextFieldArquivoEntrada;
    }
///////////////////////////////////////////////////////////////////////////////

    public JTextField getJTextFieldArquivoEntradaConversor() {
        if (jTextFieldArquivoEntradaConversor == null) {
            jTextFieldArquivoEntradaConversor = new JTextField();
            jTextFieldArquivoEntradaConversor.setLocation(new Point(85, 55));
            jTextFieldArquivoEntradaConversor.setSize(new Dimension(180, 20));
            jTextFieldArquivoEntradaConversor.setEditable(false);
        }
        return jTextFieldArquivoEntradaConversor;
    }


    public JTextField getJTextFieldArquivoSaidaConversor() {
        if (jTextFieldArquivoSaidaConversor == null) {
            jTextFieldArquivoSaidaConversor = new JTextField();
            jTextFieldArquivoSaidaConversor.setLocation(new Point(85+SaidaConversorX,SaidaConversorY+ 55));
            jTextFieldArquivoSaidaConversor.setSize(new Dimension(180, 20));
            jTextFieldArquivoSaidaConversor.setEditable(false);
            jTextFieldArquivoSaidaConversor.setEnabled(false);
        }
        return jTextFieldArquivoSaidaConversor;
    }

///////////////////////////////////////////////////////////////////////////////

    public JSeparator getJSeparatorA1() {
        if (jSeparatorA1 == null) {
            jSeparatorA1 = new JSeparator();
            jSeparatorA1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorA1.setSize(new Dimension(10, 22));
            jSeparatorA1.setLocation(new Point(226+arqEntX,arqEntY+292));
        }
        return jSeparatorA1;
    }

    public JSeparator getJSeparatorA2() {
        if (jSeparatorA2 == null) {
            jSeparatorA2 = new JSeparator();
            jSeparatorA2.setSize(new Dimension(161, 10));
            jSeparatorA2.setLocation(new Point(227+arqEntX,arqEntY+291));
        }
        return jSeparatorA2;
    }

    public JSeparator getJSeparatorA3() {
        if (jSeparatorA3 == null) {
            jSeparatorA3 = new JSeparator();
            jSeparatorA3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorA3.setSize(new Dimension(10, 22));
            jSeparatorA3.setLocation(new Point(387+arqEntX,arqEntY+292));
        }
        return jSeparatorA3;
    }

    public JSeparator getJSeparatorA4() {
        if (jSeparatorA4 == null) {
            jSeparatorA4 = new JSeparator();
            jSeparatorA4.setLocation(new Point(227+arqEntX,arqEntY+314));
            jSeparatorA4.setSize(new Dimension(161, 10));
        }
        return jSeparatorA4;
    }

    public JSeparator getJSeparatorA5() {
        if (jSeparatorA5 == null) {
            jSeparatorA5 = new JSeparator();
            jSeparatorA5.setLocation(new Point(320+arqEntX,arqEntY+265));
            jSeparatorA5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorA5.setSize(new Dimension(10, 27));
        }
        return jSeparatorA5;
    }

    public JSeparator getJSeparatorA6() {
        if (jSeparatorA6 == null) {
            jSeparatorA6 = new JSeparator();
            jSeparatorA6.setSize(new Dimension(294, 10));
            jSeparatorA6.setLocation(new Point(320+arqEntX,arqEntY+264));
        }
        return jSeparatorA6;
    }

    public JSeparator getJSeparatorA7() {
        if (jSeparatorA7 == null) {
            jSeparatorA7 = new JSeparator();
            jSeparatorA7.setBounds(new Rectangle(614+arqEntX, 265+arqEntY, 10, 78));
            jSeparatorA7.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparatorA7;
    }

    public JSeparator getJSeparatorA8() {
        if (jSeparatorA8 == null) {
            jSeparatorA8 = new JSeparator();
            jSeparatorA8.setOrientation(SwingConstants.VERTICAL);
            jSeparatorA8.setSize(new Dimension(10, 27));
            jSeparatorA8.setLocation(new Point(320+arqEntX,arqEntY+314));
        }
        return jSeparatorA8;
    }

    public JSeparator getJSeparatorA9() {
        if (jSeparatorA9 == null) {
            jSeparatorA9 = new JSeparator();
            jSeparatorA9.setSize(new Dimension(295, 10));
            jSeparatorA9.setLocation(new Point(320+arqEntX,arqEntY+341));
        }
        return jSeparatorA9;
    }

///////////////////////////////////////////////////////////////////////////////

    public JComboBox getJComboBoxTipoDadoEntradaSequencia() {
        if (jComboFormatosDeEntradaSequencia == null) {
            jComboFormatosDeEntradaSequencia = new JComboBox();
            jComboFormatosDeEntradaSequencia.setBounds(new Rectangle(375+formEntX, 58+formEnty, 200, 24));
            jComboFormatosDeEntradaSequencia.addItem("Selecione um tipo...");
            jComboFormatosDeEntradaSequencia.addItem("ACEDB");//1
            jComboFormatosDeEntradaSequencia.addItem("Clustal");//2
            jComboFormatosDeEntradaSequencia.addItem("EMBL");//3
            jComboFormatosDeEntradaSequencia.addItem("Fasta");//4
            jComboFormatosDeEntradaSequencia.addItem("GenBAnk");//5
            jComboFormatosDeEntradaSequencia.addItem("MEGA");//6
            jComboFormatosDeEntradaSequencia.addItem("MSF");//7
            jComboFormatosDeEntradaSequencia.addItem("NBRF");//8
            jComboFormatosDeEntradaSequencia.addItem("Nexus");//9
            jComboFormatosDeEntradaSequencia.addItem("Phylip seqüencial");//10
            jComboFormatosDeEntradaSequencia.addItem("Phylip intercalado");//11
            jComboFormatosDeEntradaSequencia.addItem("PIR");//12
            jComboFormatosDeEntradaSequencia.addItem("Plain");//13
            jComboFormatosDeEntradaSequencia.addItem("Stanford");//14
            jComboFormatosDeEntradaSequencia.addItem("XML");//15

            jComboFormatosDeEntradaSequencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jComboFormatosDeEntradaSequencia;
    }

///////////////////////////////////////////////////////////////////////////////

     public JComboBox getJComboBoxTipoDadoEntradaConversor() {
        if (jComboFormatosDeEntradaConversor == null) {
            jComboFormatosDeEntradaConversor = new JComboBox();
            jComboFormatosDeEntradaConversor.setBounds(new Rectangle(355, 53, 200, 24));
            jComboFormatosDeEntradaConversor.addItem("Selecione um tipo...");
            jComboFormatosDeEntradaConversor.addItem("ACEDB");//1
            jComboFormatosDeEntradaConversor.addItem("BLAST");//2
            jComboFormatosDeEntradaConversor.addItem("Clustal");//3
            jComboFormatosDeEntradaConversor.addItem("DNAStrider");//4
            jComboFormatosDeEntradaConversor.addItem("EMBL");//5
            jComboFormatosDeEntradaConversor.addItem("Fasta");//6
            jComboFormatosDeEntradaConversor.addItem("FlatFeat");//7
            jComboFormatosDeEntradaConversor.addItem("GCG");//8
            jComboFormatosDeEntradaConversor.addItem("GFF");//9
            jComboFormatosDeEntradaConversor.addItem("GenBank");//10
            jComboFormatosDeEntradaConversor.addItem("MEGA");//11
            jComboFormatosDeEntradaConversor.addItem("MSF");//12
            jComboFormatosDeEntradaConversor.addItem("NBRF");//13
            jComboFormatosDeEntradaConversor.addItem("NEXUS");//14
            jComboFormatosDeEntradaConversor.addItem("PIR");//15
            jComboFormatosDeEntradaConversor.addItem("Phylip");//16
            jComboFormatosDeEntradaConversor.addItem("Plain");//17
            jComboFormatosDeEntradaConversor.addItem("SCF");//18
            jComboFormatosDeEntradaConversor.addItem("Stanford");//19
            jComboFormatosDeEntradaConversor.addItem("XML");//20

            jComboFormatosDeEntradaConversor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jComboFormatosDeEntradaConversor;
    }

//////////////////////////////////////////////////////////////////////////////

    public JComboBox getJComboBoxTipoDadoSaidaConversor() {
        if (jComboFormatosDeSaidaConversor == null) {
            jComboFormatosDeSaidaConversor = new JComboBox();
            jComboFormatosDeSaidaConversor.setBounds(new Rectangle(355+SaidaConversorX,SaidaConversorY+ 53, 200, 24));
            jComboFormatosDeSaidaConversor.setEnabled(false);
            jComboFormatosDeSaidaConversor.addItem("Selecione um tipo...");
            jComboFormatosDeSaidaConversor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jComboFormatosDeSaidaConversor;
    }

//////////////////////////////////////////////////////////////////////////////

    public JSeparator getJSeparatorB1() {
        if (jSeparatorB1 == null) {
            jSeparatorB1 = new JSeparator();
            jSeparatorB1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorB1.setLocation(new Point(396+formEntX, 28+formEnty));
            jSeparatorB1.setSize(new Dimension(10, 22));
        }
        return jSeparatorB1;
    }

    public JSeparator getJSeparatorB2() {
        if (jSeparatorB2 == null) {
            jSeparatorB2 = new JSeparator();
            jSeparatorB2.setSize(new Dimension(145, 10));
            jSeparatorB2.setLocation(new Point(397+formEntX,formEnty+27));
        }
        return jSeparatorB2;
    }

    public JSeparator getJSeparatorB3() {
        if (jSeparatorB3 == null) {
            jSeparatorB3 = new JSeparator();
            jSeparatorB3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorB3.setSize(new Dimension(10, 22));
            jSeparatorB3.setLocation(new Point(542+formEntX, formEnty+ 28));
        }
        return jSeparatorB3;
    }

    public JSeparator getJSeparatorB4() {
        if (jSeparatorB4 == null) {
            jSeparatorB4 = new JSeparator();
            jSeparatorB4.setBounds(new Rectangle(396+formEntX, formEnty+ 49, 147, 10));
        }
        return jSeparatorB4;
    }

    public JSeparator getJSeparatorB5() {
        if (jSeparatorB5 == null) {
            jSeparatorB5 = new JSeparator();
            jSeparatorB5.setSize(new Dimension(67, 10));
            jSeparatorB5.setLocation(new Point(330+formEntX, formEnty+ 38));
        }
        return jSeparatorB5;
    }

    public JSeparator getJSeparatorB6() {
        if (jSeparatorB6 == null) {
            jSeparatorB6 = new JSeparator();
            jSeparatorB6.setOrientation(SwingConstants.VERTICAL);
            jSeparatorB6.setSize(new Dimension(10, 51));
            jSeparatorB6.setLocation(new Point(610+formEntX, formEnty+ 39));
        }
        return jSeparatorB6;
    }

    public JSeparator getJSeparatorB7() {
        if (jSeparatorB7 == null) {
            jSeparatorB7 = new JSeparator();
            jSeparatorB7.setOrientation(SwingConstants.VERTICAL);
            jSeparatorB7.setSize(new Dimension(10, 51));
            jSeparatorB7.setLocation(new Point(329+formEntX, formEnty+ 38));
        }
        return jSeparatorB7;
    }

    public JSeparator getJSeparatorB8() {
        if (jSeparatorB8 == null) {
            jSeparatorB8 = new JSeparator();
            jSeparatorB8.setSize(new Dimension(68, 10));
            jSeparatorB8.setLocation(new Point(543+formEntX, formEnty+ 38));
        }
        return jSeparatorB8;
    }

    public JSeparator getJSeparatorB9() {
        if (jSeparatorB9 == null) {
            jSeparatorB9 = new JSeparator();
            jSeparatorB9.setBounds(new Rectangle(329+formEntX, formEnty+ 89, 282, 10));
        }
        return jSeparatorB9;
    }


/////////////////////////////////////////////////////////////////////////////

    public JButton getJButtonCheckSum() {
        if (jButtonCheckSum == null) {

            jButtonCheckSum = new JButton();
            jButtonCheckSum.setBounds(new Rectangle(70+570+CheckSumX, 288+CheckSumY, 30, 29));
            //jButtonCheckSum.setText("Obter");
            jButtonCheckSum.setToolTipText("Salvar arquivo");
            jButtonCheckSum.setFont(new Font("Dialog", Font.BOLD, 10));
            jButtonCheckSum.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/save.gif")));
            jButtonCheckSum.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        return jButtonCheckSum;
    }
/////////////////////////////////////////////////////////////////////////////

    public JTextField getJTextFieldCheckSum() {
        if (jTextFieldCheckSum == null) {
            jTextFieldCheckSum = new JTextField();
            jTextFieldCheckSum.setBounds(new Rectangle(help+355+CheckSumX, 290+CheckSumY, 70+200-help, 24));//setLocation(new Point(399, 294));
            jTextFieldCheckSum.setEditable(false);
            jTextFieldCheckSum.setVisible(true);
        }
        return jTextFieldCheckSum;
    }

/////////////////////////////////////////////////////////////////////////////

    public JSeparator getJSeparatorE1() {
        if (jSeparatorE1 == null) {
            jSeparatorE1 = new JSeparator();
            jSeparatorE1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorE1.setSize(new Dimension(10, 22));
            jSeparatorE1.setLocation(new Point(226+CheckSumX,CheckSumY+292));
        }
        return jSeparatorE1;
    }

    public JSeparator getJSeparatorE2() {
        if (jSeparatorE2 == null) {
            jSeparatorE2 = new JSeparator();
            jSeparatorE2.setSize(new Dimension(help+121, 10));
            jSeparatorE2.setLocation(new Point(227+CheckSumX,CheckSumY+291));
        }
        return jSeparatorE2;
    }

    public JSeparator getJSeparatorE3() {
        if (jSeparatorE3 == null) {
            jSeparatorE3 = new JSeparator();
            jSeparatorE3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorE3.setSize(new Dimension(10, 22));
            jSeparatorE3.setLocation(new Point(help+347+CheckSumX,CheckSumY+292));
        }
        return jSeparatorE3;
    }

    public JSeparator getJSeparatorE4() {
        if (jSeparatorE4 == null) {
            jSeparatorE4 = new JSeparator();
            jSeparatorE4.setLocation(new Point(227+CheckSumX,CheckSumY+314));
            jSeparatorE4.setSize(new Dimension(help+121, 10));
        }
        return jSeparatorE4;
    }

    public JSeparator getJSeparatorE5() {
        if (jSeparatorE5 == null) {
            jSeparatorE5 = new JSeparator();
            jSeparatorE5.setLocation(new Point(320-20+CheckSumX,CheckSumY+265));
            jSeparatorE5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorE5.setSize(new Dimension(10, 27));
        }
        return jSeparatorE5;
    }

    public JSeparator getJSeparatorE6() {
        if (jSeparatorE6 == null) {
            jSeparatorE6 = new JSeparator();
            jSeparatorE6.setSize(new Dimension(290+95, 10));
            jSeparatorE6.setLocation(new Point(320-20+CheckSumX,CheckSumY+264));
        }
        return jSeparatorE6;
    }

    public JSeparator getJSeparatorE7() {
        if (jSeparatorE7 == null) {
            jSeparatorE7 = new JSeparator();
            jSeparatorE7.setBounds(new Rectangle(610+75+CheckSumX, 265+CheckSumY, 10, 78));
            jSeparatorE7.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparatorE7;
    }

    public JSeparator getJSeparatorE8() {
        if (jSeparatorE8 == null) {
            jSeparatorE8 = new JSeparator();
            jSeparatorE8.setOrientation(SwingConstants.VERTICAL);
            jSeparatorE8.setSize(new Dimension(10, 27));
            jSeparatorE8.setLocation(new Point(320-20+CheckSumX,CheckSumY+314));
        }
        return jSeparatorE8;
    }

    public JSeparator getJSeparatorE9() {
        if (jSeparatorE9 == null) {
            jSeparatorE9 = new JSeparator();
            jSeparatorE9.setSize(new Dimension(290+95, 10));
            jSeparatorE9.setLocation(new Point(320-20+CheckSumX,CheckSumY+341));
        }
        return jSeparatorE9;
    }
//////////////////////////////////////////////////////////////////////////////

public JSeparator getJSeparatorF1() {
        if (jSeparatorF1 == null) {
            jSeparatorF1 = new JSeparator();
            jSeparatorF1.setLocation(new Point(220 , 25));
            jSeparatorF1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorF1.setSize(new Dimension(10, 22));
        }
        return jSeparatorF1;
    }

    public JSeparator getJSeparatorF2() {
        if (jSeparatorF2 == null) {
            jSeparatorF2 = new JSeparator();
            jSeparatorF2.setLocation(new Point(414 , 24));
            jSeparatorF2.setOrientation(SwingConstants.VERTICAL);
            jSeparatorF2.setSize(new Dimension(10, 24));
        }
        return jSeparatorF2;
    }

    public JSeparator getJSeparatorF3() {
        if (jSeparatorF3 == null) {
            jSeparatorF3 = new JSeparator();
            jSeparatorF3.setLocation(new Point(221 , 24));
            jSeparatorF3.setSize(new Dimension(194, 10));
        }
        return jSeparatorF3;
    }

    public JSeparator getJSeparatorF4() {
        if (jSeparatorF4 == null) {
            jSeparatorF4 = new JSeparator();
            jSeparatorF4.setBounds(new Rectangle(220, 47, 194, 11));
        }
        return jSeparatorF4;
    }

    public JSeparator getJSeparatorF5() {
        if (jSeparatorF5 == null) {
            jSeparatorF5 = new JSeparator();
            jSeparatorF5.setLocation(new Point(35 , 36));
            jSeparatorF5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorF5.setSize(new Dimension(10, 50));
        }
        return jSeparatorF5;
    }

    public JSeparator getJSeparatorF6() {
        if (jSeparatorF6 == null) {
            jSeparatorF6 = new JSeparator();
            jSeparatorF6.setLocation(new Point(414 , 35));
            jSeparatorF6.setOrientation(SwingConstants.HORIZONTAL);
            jSeparatorF6.setSize(new Dimension(176, 10));
        }
        return jSeparatorF6;
    }

    public JSeparator getJSeparatorF7() {
        if (jSeparatorF7 == null) {
            jSeparatorF7 = new JSeparator();
            jSeparatorF7.setBounds(new Rectangle(35, 86, 554, 10));
        }
        return jSeparatorF7;
    }

    public JSeparator getJSeparatorF8() {
        if (jSeparatorF8 == null) {
            jSeparatorF8 = new JSeparator();
            jSeparatorF8.setBounds(new Rectangle(35 , 35, 185, 10));
        }
        return jSeparatorF8;
    }

    public JSeparator getJSeparatorF9() {
        if (jSeparatorF9 == null) {
            jSeparatorF9 = new JSeparator();
            jSeparatorF9.setLocation(new Point(589 , 36));
            jSeparatorF9.setOrientation(SwingConstants.VERTICAL);
            jSeparatorF9.setSize(new Dimension(10, 51));
        }
        return jSeparatorF9;
    }

    public JSeparator getJSeparatorF10() {
        if (jSeparatorF10 == null) {
            jSeparatorF10 = new JSeparator();
            jSeparatorF10.setLocation(new Point(312 , 48));
            jSeparatorF10.setOrientation(SwingConstants.VERTICAL);
            jSeparatorF10.setSize(new Dimension(10, 38));
        }
        return jSeparatorF10;
    }
///////////////////////////////////////////////////////////////////////////////

    public JSeparator getJSeparatorG1() {
        if (jSeparatorG1 == null) {
            jSeparatorG1 = new JSeparator();
            jSeparatorG1.setLocation(new Point(220 +SaidaConversorX,SaidaConversorY+ 25));
            jSeparatorG1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorG1.setSize(new Dimension(10, 22));
        }
        return jSeparatorG1;
    }

    public JSeparator getJSeparatorG2() {
        if (jSeparatorG2 == null) {
            jSeparatorG2 = new JSeparator();
            jSeparatorG2.setLocation(new Point(414 +SaidaConversorX,SaidaConversorY+ 24));
            jSeparatorG2.setOrientation(SwingConstants.VERTICAL);
            jSeparatorG2.setSize(new Dimension(10, 24));
        }
        return jSeparatorG2;
    }

    public JSeparator getJSeparatorG3() {
        if (jSeparatorG3 == null) {
            jSeparatorG3 = new JSeparator();
            jSeparatorG3.setLocation(new Point(221 +SaidaConversorX,SaidaConversorY+ 24));
            jSeparatorG3.setSize(new Dimension(194, 10));
        }
        return jSeparatorG3;
    }

    public JSeparator getJSeparatorG4() {
        if (jSeparatorG4 == null) {
            jSeparatorG4 = new JSeparator();
            jSeparatorG4.setBounds(new Rectangle(220+SaidaConversorX,SaidaConversorY+ 47, 194, 11));
        }
        return jSeparatorG4;
    }

    public JSeparator getJSeparatorG5() {
        if (jSeparatorG5 == null) {
            jSeparatorG5 = new JSeparator();
            jSeparatorG5.setLocation(new Point(35 +SaidaConversorX,SaidaConversorY+ 36));
            jSeparatorG5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorG5.setSize(new Dimension(10, 50));
        }
        return jSeparatorG5;
    }

    public JSeparator getJSeparatorG6() {
        if (jSeparatorG6 == null) {
            jSeparatorG6 = new JSeparator();
            jSeparatorG6.setLocation(new Point(414 +SaidaConversorX,SaidaConversorY+ 35));
            jSeparatorG6.setOrientation(SwingConstants.HORIZONTAL);
            jSeparatorG6.setSize(new Dimension(176, 10));
        }
        return jSeparatorG6;
    }

    public JSeparator getJSeparatorG7() {
        if (jSeparatorG7 == null) {
            jSeparatorG7 = new JSeparator();
            jSeparatorG7.setBounds(new Rectangle(35+SaidaConversorX,SaidaConversorY+ 86, 554, 10));
        }
        return jSeparatorG7;
    }

    public JSeparator getJSeparatorG8() {
        if (jSeparatorG8 == null) {
            jSeparatorG8 = new JSeparator();
            jSeparatorG8.setBounds(new Rectangle(35 +SaidaConversorX,SaidaConversorY+ 35, 185, 10));
        }
        return jSeparatorG8;
    }

    public JSeparator getJSeparatorG9() {
        if (jSeparatorG9 == null) {
            jSeparatorG9 = new JSeparator();
            jSeparatorG9.setLocation(new Point(589 +SaidaConversorX,SaidaConversorY+ 36));
            jSeparatorG9.setOrientation(SwingConstants.VERTICAL);
            jSeparatorG9.setSize(new Dimension(10, 51));
        }
        return jSeparatorG9;
    }

    public JSeparator getJSeparatorG10() {
        if (jSeparatorG10 == null) {
            jSeparatorG10 = new JSeparator();
            jSeparatorG10.setLocation(new Point(312 +SaidaConversorX,SaidaConversorY+ 48));
            jSeparatorG10.setOrientation(SwingConstants.VERTICAL);
            jSeparatorG10.setSize(new Dimension(10, 38));
        }
        return jSeparatorG10;
    }
///////////////////////////////////////////////////////////////////////////////


     public JSeparator getJSeparatorH1() {
        if (jSeparatorH1 == null) {
            jSeparatorH1 = new JSeparator();
            jSeparatorH1.setLocation(new Point(228+SaidaDigrafuX-8 , SaidaDigrafuY+ 250));
            jSeparatorH1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorH1.setSize(new Dimension(10, 22));
        }
        return jSeparatorH1;
    }

    public JSeparator getJSeparatorH2() {
        if (jSeparatorH2 == null) {
            jSeparatorH2 = new JSeparator();
            jSeparatorH2.setLocation(new Point(422+SaidaDigrafuX-8 , SaidaDigrafuY+ 249));
            jSeparatorH2.setOrientation(SwingConstants.VERTICAL);
            jSeparatorH2.setSize(new Dimension(10, 24));
        }
        return jSeparatorH2;
    }

    public JSeparator getJSeparatorH3() {
        if (jSeparatorH3 == null) {
            jSeparatorH3 = new JSeparator();
            jSeparatorH3.setLocation(new Point(229+SaidaDigrafuX-8 , SaidaDigrafuY+ 249));
            jSeparatorH3.setSize(new Dimension(194, 10));
        }
        return jSeparatorH3;
    }

    public JSeparator getJSeparatorH4() {
        if (jSeparatorH4 == null) {
            jSeparatorH4 = new JSeparator();
            jSeparatorH4.setBounds(new Rectangle(228+SaidaDigrafuX-8 , SaidaDigrafuY+ 272, 194, 11));
        }
        return jSeparatorH4;
    }

    public JSeparator getJSeparatorH5() {
        if (jSeparatorH5 == null) {
            jSeparatorH5 = new JSeparator();
            jSeparatorH5.setLocation(new Point(90+SaidaDigrafuX , SaidaDigrafuY+ 261));
            jSeparatorH5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorH5.setSize(new Dimension(10, 50));
        }
        return jSeparatorH5;
    }

    public JSeparator getJSeparatorH6() {
        if (jSeparatorH6 == null) {
            jSeparatorH6 = new JSeparator();
            jSeparatorH6.setLocation(new Point(414+SaidaDigrafuX , SaidaDigrafuY+ 260));
            jSeparatorH6.setOrientation(SwingConstants.HORIZONTAL);
            jSeparatorH6.setSize(new Dimension(130, 10));
        }
        return jSeparatorH6;
    }

    public JSeparator getJSeparatorH7() {
        if (jSeparatorH7 == null) {
            jSeparatorH7 = new JSeparator();
            jSeparatorH7.setBounds(new Rectangle(90+SaidaDigrafuX , SaidaDigrafuY+ 311, 454, 10));
        }
        return jSeparatorH7;
    }

    public JSeparator getJSeparatorH8() {
        if (jSeparatorH8 == null) {
            jSeparatorH8 = new JSeparator();
            jSeparatorH8.setBounds(new Rectangle(90+SaidaDigrafuX , SaidaDigrafuY+ 260, 130, 10));
        }
        return jSeparatorH8;
    }

    public JSeparator getJSeparatorH9() {
        if (jSeparatorH9 == null) {
            jSeparatorH9 = new JSeparator();
            jSeparatorH9.setLocation(new Point(490+53+SaidaDigrafuX , SaidaDigrafuY+ 261));
            jSeparatorH9.setOrientation(SwingConstants.VERTICAL);
            jSeparatorH9.setSize(new Dimension(10, 51));
        }
        return jSeparatorH9;
    }
///////////////////////////////////////////////////////////////////////////

     public JSeparator getJSeparatorI1() {
        if (jSeparatorI1 == null) {
            jSeparatorI1 = new JSeparator();
            jSeparatorI1.setLocation(new Point(228+SalvarDiretorioX-8 , SalvarDiretorioY+ 250));
            jSeparatorI1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorI1.setSize(new Dimension(10, 22));
        }
        return jSeparatorI1;
    }

    public JSeparator getJSeparatorI2() {
        if (jSeparatorI2 == null) {
            jSeparatorI2 = new JSeparator();
            jSeparatorI2.setLocation(new Point(422+SalvarDiretorioX-8 , SalvarDiretorioY+ 249));
            jSeparatorI2.setOrientation(SwingConstants.VERTICAL);
            jSeparatorI2.setSize(new Dimension(10, 24));
        }
        return jSeparatorI2;
    }

    public JSeparator getJSeparatorI3() {
        if (jSeparatorI3 == null) {
            jSeparatorI3 = new JSeparator();
            jSeparatorI3.setLocation(new Point(229+SalvarDiretorioX-8 , SalvarDiretorioY+ 249));
            jSeparatorI3.setSize(new Dimension(194, 10));
        }
        return jSeparatorI3;
    }

    public JSeparator getJSeparatorI4() {
        if (jSeparatorI4 == null) {
            jSeparatorI4 = new JSeparator();
            jSeparatorI4.setBounds(new Rectangle(228+SalvarDiretorioX-8 , SalvarDiretorioY+ 272, 194, 11));
        }
        return jSeparatorI4;
    }

    public JSeparator getJSeparatorI5() {
        if (jSeparatorI5 == null) {
            jSeparatorI5 = new JSeparator();
            jSeparatorI5.setLocation(new Point(90+SalvarDiretorioX , SalvarDiretorioY+ 261));
            jSeparatorI5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorI5.setSize(new Dimension(10, 50));
        }
        return jSeparatorI5;
    }

    public JSeparator getJSeparatorI6() {
        if (jSeparatorI6 == null) {
            jSeparatorI6 = new JSeparator();
            jSeparatorI6.setLocation(new Point(414+SalvarDiretorioX , SalvarDiretorioY+ 260));
            jSeparatorI6.setOrientation(SwingConstants.HORIZONTAL);
            jSeparatorI6.setSize(new Dimension(130, 10));
        }
        return jSeparatorI6;
    }

    public JSeparator getJSeparatorI7() {
        if (jSeparatorI7 == null) {
            jSeparatorI7 = new JSeparator();
            jSeparatorI7.setBounds(new Rectangle(90+SalvarDiretorioX , SalvarDiretorioY+ 311, 454, 10));
        }
        return jSeparatorI7;
    }

    public JSeparator getJSeparatorI8() {
        if (jSeparatorI8 == null) {
            jSeparatorI8 = new JSeparator();
            jSeparatorI8.setBounds(new Rectangle(90+SalvarDiretorioX , SalvarDiretorioY+ 260, 130, 10));
        }
        return jSeparatorI8;
    }

    public JSeparator getJSeparatorI9() {
        if (jSeparatorI9 == null) {
            jSeparatorI9 = new JSeparator();
            jSeparatorI9.setLocation(new Point(490+53+SalvarDiretorioX , SalvarDiretorioY+ 261));
            jSeparatorI9.setOrientation(SwingConstants.VERTICAL);
            jSeparatorI9.setSize(new Dimension(10, 51));
        }
        return jSeparatorI9;
    }
//////////////////////////////////////////////////////////////////////////////

     public JSeparator getJSeparatorJ1() {
        if (jSeparatorJ1 == null) {
            jSeparatorJ1 = new JSeparator();
            jSeparatorJ1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorJ1.setSize(new Dimension(10, 22));
            jSeparatorJ1.setLocation(new Point(226+x,y+292));
        }
        return jSeparatorJ1;
    }

    public JSeparator getJSeparatorJ2() {
        if (jSeparatorJ2 == null) {
            jSeparatorJ2 = new JSeparator();
            jSeparatorJ2.setSize(new Dimension(help+161-40, 10));
            jSeparatorJ2.setLocation(new Point(227+x,y+291));
        }
        return jSeparatorJ2;
    }

    public JSeparator getJSeparatorJ3() {
        if (jSeparatorJ3 == null) {
            jSeparatorJ3 = new JSeparator();
            jSeparatorJ3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorJ3.setSize(new Dimension(10, 22));
            jSeparatorJ3.setLocation(new Point(help+387-40+x,y+292));
        }
        return jSeparatorJ3;
    }

    public JSeparator getJSeparatorJ4() {
        if (jSeparatorJ4 == null) {
            jSeparatorJ4 = new JSeparator();
            jSeparatorJ4.setLocation(new Point(227+x,y+314));
            jSeparatorJ4.setSize(new Dimension(help+161-40, 10));
        }
        return jSeparatorJ4;
    }

    public JSeparator getJSeparatorJ5() {
        if (jSeparatorJ5 == null) {
            jSeparatorJ5 = new JSeparator();
            jSeparatorJ5.setLocation(new Point(320-20+x,y+265));
            jSeparatorJ5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorJ5.setSize(new Dimension(10, 27));
        }
        return jSeparatorJ5;
    }

    public JSeparator getJSeparatorJ6() {
        if (jSeparatorJ6 == null) {
            jSeparatorJ6 = new JSeparator();
            jSeparatorJ6.setSize(new Dimension(290+95, 10));
            jSeparatorJ6.setLocation(new Point(320-20+x,y+264));
        }
        return jSeparatorJ6;
    }

    public JSeparator getJSeparatorJ7() {
        if (jSeparatorJ7 == null) {
            jSeparatorJ7 = new JSeparator();
            jSeparatorJ7.setBounds(new Rectangle(610+75+x, 265+y, 10, 78));
            jSeparatorJ7.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparatorJ7;
    }

    public JSeparator getJSeparatorJ8() {
        if (jSeparatorJ8 == null) {
            jSeparatorJ8 = new JSeparator();
            jSeparatorJ8.setOrientation(SwingConstants.VERTICAL);
            jSeparatorJ8.setSize(new Dimension(10, 27));
            jSeparatorJ8.setLocation(new Point(320-20+x,y+314));
        }
        return jSeparatorJ8;
    }

    public JSeparator getJSeparatorJ9() {
        if (jSeparatorJ9 == null) {
            jSeparatorJ9 = new JSeparator();
            jSeparatorJ9.setSize(new Dimension(290+95, 10));
            jSeparatorJ9.setLocation(new Point(320-20+x,y+341));
        }
        return jSeparatorJ9;
    }
///////////////////////////////////////////////////////////////////////////////
     public JSeparator getJSeparatorL1() {
        if (jSeparatorL1 == null) {
            jSeparatorL1 = new JSeparator();
            jSeparatorL1.setOrientation(SwingConstants.VERTICAL);
            jSeparatorL1.setSize(new Dimension(10, 22));
            jSeparatorL1.setLocation(new Point(226+x,y+292));
        }
        return jSeparatorL1;
    }

    public JSeparator getJSeparatorL2() {
        if (jSeparatorL2 == null) {
            jSeparatorL2 = new JSeparator();
            jSeparatorL2.setSize(new Dimension(help+161-40, 10));
            jSeparatorL2.setLocation(new Point(227+x,y+291));
        }
        return jSeparatorL2;
    }

    public JSeparator getJSeparatorL3() {
        if (jSeparatorL3 == null) {
            jSeparatorL3 = new JSeparator();
            jSeparatorL3.setOrientation(SwingConstants.VERTICAL);
            jSeparatorL3.setSize(new Dimension(10, 22));
            jSeparatorL3.setLocation(new Point(help+387-40+x,y+292));
        }
        return jSeparatorL3;
    }

    public JSeparator getJSeparatorL4() {
        if (jSeparatorL4 == null) {
            jSeparatorL4 = new JSeparator();
            jSeparatorL4.setLocation(new Point(227+x,y+314));
            jSeparatorL4.setSize(new Dimension(help+161-40, 10));
        }
        return jSeparatorL4;
    }

    public JSeparator getJSeparatorL5() {
        if (jSeparatorL5 == null) {
            jSeparatorL5 = new JSeparator();
            jSeparatorL5.setLocation(new Point(320-20+x,y+265));
            jSeparatorL5.setOrientation(SwingConstants.VERTICAL);
            jSeparatorL5.setSize(new Dimension(10, 27));
        }
        return jSeparatorL5;
    }

    public JSeparator getJSeparatorL6() {
        if (jSeparatorL6 == null) {
            jSeparatorL6 = new JSeparator();
            jSeparatorL6.setSize(new Dimension(290+95, 10));
            jSeparatorL6.setLocation(new Point(320-20+x,y+264));
        }
        return jSeparatorL6;
    }

    public JSeparator getJSeparatorL7() {
        if (jSeparatorL7 == null) {
            jSeparatorL7 = new JSeparator();
            jSeparatorL7.setBounds(new Rectangle(610+75+x, 265+y, 10, 78));
            jSeparatorL7.setOrientation(SwingConstants.VERTICAL);
        }
        return jSeparatorL7;
    }

    public JSeparator getJSeparatorL8() {
        if (jSeparatorL8 == null) {
            jSeparatorL8 = new JSeparator();
            jSeparatorL8.setOrientation(SwingConstants.VERTICAL);
            jSeparatorL8.setSize(new Dimension(10, 27));
            jSeparatorL8.setLocation(new Point(320-20+x,y+314));
        }
        return jSeparatorL8;
    }

    public JSeparator getJSeparatorL9() {
        if (jSeparatorL9 == null) {
            jSeparatorL9 = new JSeparator();
            jSeparatorL9.setSize(new Dimension(290+95, 10));
            jSeparatorL9.setLocation(new Point(320-20+x,y+341));
        }
        return jSeparatorL9;
    }

///////////////////////////////////////////////////////////////////////////////
/*
         public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Thread() {
            public void run() {
                new JanelaTeste().setVisible(true);

            }
        });

    }*/
}
