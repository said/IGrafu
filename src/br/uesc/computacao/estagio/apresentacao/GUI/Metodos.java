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
 * Classe que gera a tela Metodos
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

public class Metodos extends JFrame {

	/**
	 * Variaveis Globais
	 */

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabelMetodos = null;

	private JRadioButton jRadioButtonMaximaVerossimilhanca = null;

	private JRadioButton jRadioButtonDistancia = null;

	private JRadioButton jRadioButtonParcimonia = null;

	private JRadioButton jRadioButtonBayes = null;

	private JSeparator jSeparator = null;

	private JSeparator jSeparator1 = null;

	private JSeparator jSeparator2 = null;

	private JSeparator jSeparator3 = null;

	private JSeparator jSeparator4 = null;

	private JSeparator jSeparator5 = null;

	private JSeparator jSeparator6 = null;

	private JSeparator jSeparator7 = null;

	private JSeparator jSeparator8 = null;

	private JButton jButtonAvancar = null;

	private JButton jButtonVoltar = null;

	/**
	 * This is the default constructor
	 */
	public Metodos() {
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/IGrafuAF.png")));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( ( dimension.width - getSize().width )/2, ( dimension.height - getSize().height )/2 );
		this.setBackground(new Color(173, 200, 226));
		this.setContentPane(getJContentPane());
		this.setTitle("IGRAFU: Métodos");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelMetodos = new JLabel();
			jLabelMetodos.setText("Qual método deseja utilizar?");
			jLabelMetodos.setLocation(new Point(339, 120));
			jLabelMetodos.setSize(new Dimension(187, 16));

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
			jContentPane.add(jLabelMetodos, null);
			jContentPane.add(getJRadioButtonMaximaVerossimilhanca(), null);
			jContentPane.add(getJRadioButtonDistancia(), null);
			jContentPane.add(getJRadioButtonParcimonia(), null);
			jContentPane.add(getJRadioButtonBayes(), null);
			jContentPane.add(getJSeparator(), null);
			jContentPane.add(getJSeparator1(), null);
			jContentPane.add(getJSeparator2(), null);
			jContentPane.add(getJSeparator3(), null);
			jContentPane.add(getJSeparator4(), null);
			jContentPane.add(getJSeparator5(), null);
			jContentPane.add(getJSeparator6(), null);
			jContentPane.add(getJSeparator7(), null);
			jContentPane.add(getJSeparator8(), null);
			jContentPane.add(getJButtonAvancar(), null);
			jContentPane.add(getJButtonVoltar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jRadioButtonMaximaVerossimilhanca
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonMaximaVerossimilhanca() {
		if (jRadioButtonMaximaVerossimilhanca == null) {
			jRadioButtonMaximaVerossimilhanca = new JRadioButton();
			jRadioButtonMaximaVerossimilhanca.setBounds(new Rectangle(339, 168, 197, 21));
			jRadioButtonMaximaVerossimilhanca.setBackground(new Color(173, 200, 226));
			jRadioButtonMaximaVerossimilhanca.setText("Máxima Verossimilhança");
			jRadioButtonMaximaVerossimilhanca.setSelected(true);
		}
		return jRadioButtonMaximaVerossimilhanca;
	}

	/**
	 * This method initializes jRadioButtonDistancia
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonDistancia() {
		if (jRadioButtonDistancia == null) {
			jRadioButtonDistancia = new JRadioButton();
			jRadioButtonDistancia.setText("Distância");
			jRadioButtonDistancia.setSize(new Dimension(101, 24));
			jRadioButtonDistancia.setLocation(new Point(339, 208));
			jRadioButtonDistancia.setBackground(new Color(173, 200, 226));
		}
		return jRadioButtonDistancia;
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
			jRadioButtonParcimonia.setSize(new Dimension(110, 24));
			jRadioButtonParcimonia.setLocation(new Point(339, 248));
			jRadioButtonParcimonia.setBackground(new Color(173, 200, 226));
			//jRadioButtonParcimonia.setVisible(false);
                        jRadioButtonParcimonia.setEnabled(false);
		}
		return jRadioButtonParcimonia;
	}

	/**
	 * This method initializes jRadioButtonBayes
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonBayes() {
		if (jRadioButtonBayes == null) {
			jRadioButtonBayes = new JRadioButton();
			jRadioButtonBayes.setText("Bayes");
			jRadioButtonBayes.setSize(new Dimension(83, 24));
			jRadioButtonBayes.setLocation(new Point(339, 288));
			jRadioButtonBayes.setBackground(new Color(173, 200, 226));
			//jRadioButtonBayes.setVisible(false);
                        jRadioButtonBayes.setEnabled(false);
		}
		return jRadioButtonBayes;
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
			jSeparator.setLocation(new Point(333, 117));
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
			jSeparator1.setLocation(new Point(333, 116));
			jSeparator1.setSize(new Dimension(194, 10));
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
			jSeparator2.setLocation(new Point(527, 117));
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
			jSeparator3.setLocation(new Point(333, 139));
			jSeparator3.setSize(new Dimension(195, 10));
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
			jSeparator4.setBounds(new Rectangle(300, 128, 34, 10));
			jSeparator4.setOrientation(SwingConstants.HORIZONTAL);
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
			jSeparator5.setOrientation(SwingConstants.VERTICAL);
			jSeparator5.setLocation(new Point(299, 128));
			jSeparator5.setSize(new Dimension(10, 192));
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
			jSeparator6.setBounds(new Rectangle(299, 319, 252, 10));
			jSeparator6.setOrientation(SwingConstants.HORIZONTAL);
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
			jSeparator7.setOrientation(SwingConstants.HORIZONTAL);
			jSeparator7.setLocation(new Point(527, 128));
			jSeparator7.setSize(new Dimension(23, 10));
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
			jSeparator8.setLocation(new Point(550, 128));
			jSeparator8.setSize(new Dimension(10, 192));
		}
		return jSeparator8;
	}

	/**
	 * This method initializes jButtonAvancar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAvancar() {
		if (jButtonAvancar == null) {
			jButtonAvancar = new JButton();
			jButtonAvancar.setSize(new Dimension(110, 30));
			jButtonAvancar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/avancar.png")));
			jButtonAvancar.setText("Avançar");
			jButtonAvancar.setFont(new Font("Dialog", Font.BOLD, 11));
			jButtonAvancar.setLocation(new Point(655, 384));
			jButtonAvancar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonAvancar;
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
			jButtonVoltar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png")));
			jButtonVoltar.setText("Voltar");
			jButtonVoltar.setFont(new Font("Dialog", Font.BOLD, 11));
			jButtonVoltar.setSize(new Dimension(110, 30));
			jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonVoltar;
	}

	public JLabel getJLabelMetodos() {
		return jLabelMetodos;
	}
}
