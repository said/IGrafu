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
 * Classe que gera a segunda tela da IGrafu "Bootstrap"
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

public class ModoManualBootstrap extends JFrame {

	/**
	 * Variaveis Globais
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelUtilizarBootstrap = null;
	private JRadioButton jRadioButtonModoManualBootstrapSim = null;
	private JRadioButton jRadioButtonModoManualBootstrapNao = null;
	private JButton jButtonAvancar = null;
	private JSeparator jSeparator1 = null;
	private JSeparator jSeparator2 = null;
	private JSeparator jSeparator3 = null;
	private JSeparator jSeparator4 = null;
	private JSeparator jSeparator5 = null;
	private JSeparator jSeparator6 = null;
	private JSeparator jSeparator7 = null;
	private JSeparator jSeparator8 = null;
	private JSeparator jSeparator9 = null;
	private JButton jButtonVoltar = null;
	/**
	 * This is the default constructor
	 */
	public ModoManualBootstrap() {
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
		this.setTitle("IGRAFU: Bootstrap");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelUtilizarBootstrap = new JLabel();
			jLabelUtilizarBootstrap.setLocation(new Point(339, 127));
			jLabelUtilizarBootstrap.setText("Deseja utilizar bootstrap?");
			jLabelUtilizarBootstrap.setSize(new Dimension(164, 16));

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
			jContentPane.add(jLabelUtilizarBootstrap, null);
			jContentPane.add(getJRadioButtonModoManualBootstrapSim(), null);
			jContentPane.add(getJRadioButtonModoManualBootstrapNao(), null);
			jContentPane.add(getJButtonAvancar(), null);
			jContentPane.add(getJSeparator1(), null);
			jContentPane.add(getJSeparator2(), null);
			jContentPane.add(getJSeparator3(), null);
			jContentPane.add(getJSeparator4(), null);
			jContentPane.add(getJSeparator5(), null);
			jContentPane.add(getJSeparator6(), null);
			jContentPane.add(getJSeparator7(), null);
			jContentPane.add(getJSeparator8(), null);
			jContentPane.add(getJSeparator9(), null);
			jContentPane.add(getJButtonVoltar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jRadioButtonModoManualBootstrapSim
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonModoManualBootstrapSim() {
		if (jRadioButtonModoManualBootstrapSim == null) {
			jRadioButtonModoManualBootstrapSim = new JRadioButton();
			jRadioButtonModoManualBootstrapSim.setLocation(new Point(385, 179));
			jRadioButtonModoManualBootstrapSim.setBackground(new Color(173, 200, 226));
			jRadioButtonModoManualBootstrapSim.setText("Sim");
			jRadioButtonModoManualBootstrapSim.setSize(new Dimension(48, 21));
			jRadioButtonModoManualBootstrapSim.setSelected(true);
		}
		return jRadioButtonModoManualBootstrapSim;
	}

	/**
	 * This method initializes jRadioButtonModoManualBootstrapNao
	 *
	 * @return javax.swing.JRadioButton
	 */
	public JRadioButton getJRadioButtonModoManualBootstrapNao() {
		if (jRadioButtonModoManualBootstrapNao == null) {
			jRadioButtonModoManualBootstrapNao = new JRadioButton();
			jRadioButtonModoManualBootstrapNao.setLocation(new Point(385, 229));
			jRadioButtonModoManualBootstrapNao.setBackground(new Color(173, 200, 226));
			jRadioButtonModoManualBootstrapNao.setText("Não");
			jRadioButtonModoManualBootstrapNao.setSize(new Dimension(50, 21));
		}
		return jRadioButtonModoManualBootstrapNao;
	}

	/**
	 * This method initializes jButtonAvancar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAvancar() {
		if (jButtonAvancar == null) {
			jButtonAvancar = new JButton();
			jButtonAvancar.setBounds(new Rectangle(655, 384, 110, 30));
			jButtonAvancar.setText("Avançar");
			jButtonAvancar.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonAvancar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/avancar.png")));
			jButtonAvancar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonAvancar;
	}

	/**
	 * This method initializes jSeparator1
	 *
	 * @return javax.swing.JSeparator
	 */
	public JSeparator getJSeparator1() {
		if (jSeparator1 == null) {
			jSeparator1 = new JSeparator();
			jSeparator1.setBounds(new Rectangle(331, 122, 10, 26));
			jSeparator1.setOrientation(SwingConstants.VERTICAL);
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
			jSeparator2.setLocation(new Point(331, 121));
			jSeparator2.setSize(new Dimension(173, 10));
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
			jSeparator3.setLocation(new Point(504, 122));
			jSeparator3.setOrientation(SwingConstants.VERTICAL);
			jSeparator3.setSize(new Dimension(10, 26));
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
			jSeparator4.setLocation(new Point(331, 148));
			jSeparator4.setSize(new Dimension(174, 10));
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
			jSeparator5.setLocation(new Point(300, 134));
			jSeparator5.setSize(new Dimension(32, 10));
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
			jSeparator6.setLocation(new Point(504, 134));
			jSeparator6.setSize(new Dimension(45, 10));
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
			jSeparator7.setLocation(new Point(299, 134));
			jSeparator7.setOrientation(SwingConstants.VERTICAL);
			jSeparator7.setSize(new Dimension(10, 126));
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
			jSeparator8.setBounds(new Rectangle(549, 134, 10, 126));
			jSeparator8.setOrientation(SwingConstants.VERTICAL);
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
			jSeparator9.setBounds(new Rectangle(299, 260, 251, 10));
		}
		return jSeparator9;
	}

	/**
	 * This method initializes jButtonVoltar
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonVoltar() {
		if (jButtonVoltar == null) {
			jButtonVoltar = new JButton();
			jButtonVoltar.setText("Voltar");
			jButtonVoltar.setLocation(new Point(655, 339));
			jButtonVoltar.setSize(new Dimension(110, 30));
			jButtonVoltar.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonVoltar.setIcon(new ImageIcon(getClass().getResource("/br/uesc/computacao/estagio/apresentacao/figuras/voltar.png")));
			jButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jButtonVoltar;
	}

	public JLabel getJLabelUtilizarBootstrap() {
		return jLabelUtilizarBootstrap;
	}

}
