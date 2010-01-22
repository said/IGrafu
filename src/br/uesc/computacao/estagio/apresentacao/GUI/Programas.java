package br.uesc.computacao.estagio.apresentacao.GUI;

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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Classe que gera a tela Programas
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */

public class Programas extends JFrame {

	/**
	 * Variaveis Globais
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabelProgramas = null;

	private JRadioButton jRadioButtonPHYML = null;

	private JRadioButton jRadioButtonDIGRAFU = null;

	private JRadioButton jRadioButtonMrBayes = null;

	private JRadioButton jRadioButtonParcimonia = null;

	private JSeparator jSeparator = null;

	private JSeparator jSeparator1 = null;

	private JSeparator jSeparator2 = null;

	private JSeparator jSeparator3 = null;

	private JSeparator jSeparator4 = null;

	private JSeparator jSeparator5 = null;

	private JSeparator jSeparator6 = null;

	private JSeparator jSeparator7 = null;

	private JSeparator jSeparator8 = null;

	private JButton jButtonVoltar = null;

	private JButton jButtonAvancar = null;

	/**
	 * This is the default constructor
	 */
	public Programas() {
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
		this.setBackground(new Color(173, 200, 226));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/IGrafuAF.png")));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( ( dimension.width - getSize().width )/2, ( dimension.height - getSize().height )/2 );
		this.setContentPane(getJContentPane());
		this.setTitle("IGRAFU: Programas");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelProgramas = new JLabel();
			jLabelProgramas.setBounds(new Rectangle(306, 100, 223, 16));
			jLabelProgramas.setText("Informe o programa a ser utilizado:");

			final ImageIcon modoExecucao = new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/rna.png"));
			jContentPane = new JPanel(){
				public static final long serialVersionUID = 1L;

				protected void paintComponent( Graphics g ){
                    super.paintComponent(g);
                    modoExecucao.paintIcon(this,g,0,0);
                }
            };

			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(173, 200, 226));
			jContentPane.add(jLabelProgramas, null);
			jContentPane.add(getJRadioButtonPHYML(), null);
			jContentPane.add(getJRadioButtonDIGRAFU(), null);
			jContentPane.add(getJRadioButtonMrBayes(), null);
			jContentPane.add(getJRadioButtonParcimonia(), null);
			jContentPane.add(getJSeparator(), null);
			jContentPane.add(getJSeparator1(), null);
			jContentPane.add(getJSeparator2(), null);
			jContentPane.add(getJSeparator3(), null);
			jContentPane.add(getJSeparator4(), null);
			jContentPane.add(getJSeparator5(), null);
			jContentPane.add(getJSeparator6(), null);
			jContentPane.add(getJSeparator7(), null);
			jContentPane.add(getJSeparator8(), null);
			jContentPane.add(getJButtonVoltar(), null);
			jContentPane.add(getJButtonAvancar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jRadioButtonPHYML
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonPHYML() {
		if (jRadioButtonPHYML == null) {
			jRadioButtonPHYML = new JRadioButton();
			jRadioButtonPHYML.setBackground(new Color(173, 200, 226));
			jRadioButtonPHYML.setSize(new Dimension(88, 21));
			jRadioButtonPHYML.setLocation(new Point(358, 145));
			jRadioButtonPHYML.setText("PHYML");
		}
		return jRadioButtonPHYML;
	}

	/**
	 * This method initializes jRadioButtonDIGRAFU
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonDIGRAFU() {
		if (jRadioButtonDIGRAFU == null) {
			jRadioButtonDIGRAFU = new JRadioButton();
			jRadioButtonDIGRAFU.setText("DIGRAFU");
			jRadioButtonDIGRAFU.setSize(new Dimension(96, 24));
			jRadioButtonDIGRAFU.setLocation(new Point(358, 185));
			jRadioButtonDIGRAFU.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonDIGRAFU;
	}

	/**
	 * This method initializes jRadioButtonMrBayes
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonMrBayes() {
		if (jRadioButtonMrBayes == null) {
			jRadioButtonMrBayes = new JRadioButton();
			jRadioButtonMrBayes.setText("Mr. Bayes");
			jRadioButtonMrBayes.setSize(new Dimension(101, 24));
			jRadioButtonMrBayes.setLocation(new Point(358, 225));
			jRadioButtonMrBayes.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonMrBayes;
	}

	/**
	 * This method initializes jRadioButtonParcimonia
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonParcimonia() {
		if (jRadioButtonParcimonia == null) {
			jRadioButtonParcimonia = new JRadioButton();
			jRadioButtonParcimonia.setText("Parcimônia");
			jRadioButtonParcimonia.setSize(new Dimension(111, 24));
			jRadioButtonParcimonia.setLocation(new Point(358, 265));
			jRadioButtonParcimonia.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonParcimonia;
	}

	/**
	 * This method initializes jSeparator
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator() {
		if (jSeparator == null) {
			jSeparator = new JSeparator();
			jSeparator.setOrientation(SwingConstants.VERTICAL);
			jSeparator.setSize(new Dimension(10, 22));
			jSeparator.setLocation(new Point(299, 97));
		}
		return jSeparator;
	}

	/**
	 * This method initializes jSeparator1
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1() {
		if (jSeparator1 == null) {
			jSeparator1 = new JSeparator();
			jSeparator1.setSize(new Dimension(229, 10));
			jSeparator1.setLocation(new Point(300, 96));
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
			jSeparator2.setOrientation(SwingConstants.VERTICAL);
			jSeparator2.setSize(new Dimension(10, 22));
			jSeparator2.setLocation(new Point(529, 97));
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
			jSeparator3.setBounds(new Rectangle(299, 119, 231, 10));
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
			jSeparator4.setLocation(new Point(279, 108));
			jSeparator4.setSize(new Dimension(22, 10));
		}
		return jSeparator4;
	}

	/**
	 * This method initializes jSeparator5
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator5() {
		if (jSeparator5 == null) {
			jSeparator5 = new JSeparator();
			jSeparator5.setLocation(new Point(528, 107));
			jSeparator5.setSize(new Dimension(20, 10));
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
			jSeparator6.setLocation(new Point(278, 108));
			jSeparator6.setSize(new Dimension(10, 199));
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
			jSeparator7.setLocation(new Point(278, 306));
			jSeparator7.setSize(new Dimension(271, 10));
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
			jSeparator8.setBounds(new Rectangle(548, 108, 10, 200));
			jSeparator8.setOrientation(SwingConstants.VERTICAL);
		}
		return jSeparator8;
	}

	/**
	 * This method initializes jButtonVoltar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonVoltar() {
		if (jButtonVoltar == null) {
			jButtonVoltar = new JButton();
			jButtonVoltar.setLocation(new Point(655, 339));
			jButtonVoltar.setText("Voltar");
			jButtonVoltar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png")));
			jButtonVoltar.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonVoltar.setSize(new Dimension(110, 30));
			jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonVoltar;
	}

	/**
	 * This method initializes jButtonAvancar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAvancar() {
		if (jButtonAvancar == null) {
			jButtonAvancar = new JButton();
			jButtonAvancar.setLocation(new Point(655, 384));
			jButtonAvancar.setText("Avançar");
			jButtonAvancar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/avancar.png")));
			jButtonAvancar.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonAvancar.setSize(new Dimension(110, 30));
			jButtonAvancar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonAvancar;
	}

	public JLabel getJLabelProgramas() {
		return jLabelProgramas;
	}

}
