package br.uesc.computacao.estagio.aplicacao.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

 /**
 * Esta classe gerencia uma tela de splash.
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */

public class SplashWindow extends JWindow implements WindowListener {

	private static final long serialVersionUID = 1L;

	private JLabel imagem = null;

	private ImageIcon figura = null;

	/**
	 * Construtor, rebece uma String com o endereco da imagem que sera exibida
	 * na tela de splash.
	 *
	 * @param splash
	 *            String com o endereco da imagem exibida na tela de splash.
	 */
	public SplashWindow(String splash) {
		figura = new ImageIcon(getClass().getResource(splash));
		imagem = new JLabel(figura);
		imagem.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	}

	public ImageIcon getFigura() {
		return figura;
	}

	/**
	 * Exibe a tela de splash. Recebe um int que informa o tempo de exibicao, em
	 * milisegundos, da tela de splash.
	 *
	 * @param tempo
	 *            int que indica o tempo, em milisegundos, que sera exibida a
	 *            tela de splash.
	 * @return void
	 */
	public void open(int tempo) {
		this.getContentPane().add(imagem);
		this.pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width - getSize().width) / 2,
				(dimension.height - getSize().height) / 2);
		this.addWindowListener(this);
		this.setVisible(true);

		sleep(tempo);
	}

	public void open() {
		this.getContentPane().add(imagem);
		this.pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width - getSize().width) / 2,
				(dimension.height - getSize().height) / 2);
		this.addWindowListener(this);
		this.setVisible(true);
	}

	/**
	 * Aguarda um tempo em milisegundos
	 *
	 * @param tempo
	 *            int que representa o tempo, em milisegundos, que
	 *            será aguardado.
	 * @exception InterruptedException
	 * @exception Exception
	 * @return void
	 */
	private void sleep(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			JOptionPane.showMessageDialog(null, " Erro - Falha no sleep do Splash ", " Erro ",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Erro - Falha no sleep do Splash ", " Erro ",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Fecha a janela de splash
	 *
	 * @return void
	 */
	public void close() {
		dispose();
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowOpened(WindowEvent windowevent) {
		Graphics2D graphics2d = (Graphics2D) getGlassPane().getGraphics();
		graphics2d.setColor(new Color(51, 102, 153));
		graphics2d.setFont(new Font("SansSerif", 0, 16));
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowActivated(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return coid
	 */
	public void windowClosed(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowClosing(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowDeactivated(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowDeiconified(WindowEvent windowevent) {
	}

	/**
	 * @param windowevent
	 * @return void
	 */
	public void windowIconified(WindowEvent windowevent) {
	}
}