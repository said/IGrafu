package br.uesc.computacao.estagio.aplicacao.controlador;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import br.uesc.computacao.estagio.aplicacao.util.SplashWindow;
import br.uesc.computacao.estagio.apresentacao.GUI.DIGRAFU;
import br.uesc.computacao.estagio.apresentacao.GUI.Editor;
import br.uesc.computacao.estagio.apresentacao.GUI.Metodos;
import br.uesc.computacao.estagio.apresentacao.GUI.ModoExecucao;
import br.uesc.computacao.estagio.apresentacao.GUI.ModoManualBootstrap;
import br.uesc.computacao.estagio.apresentacao.GUI.PHYML;
import br.uesc.computacao.estagio.apresentacao.GUI.Programas;
import br.uesc.computacao.estagio.apresentacao.GUI.Seqboot;
import br.uesc.computacao.estagio.apresentacao.GUI.Conversor;

/*
 * Classe que controla a execução inicial da IGrafu
 * Possui referencia para todas as classes de interface grafica da camada de apresentacao
 *
 * autor: Zilton Cordeiro Junior
 */

public class ControladorIGrafu {

	/*
	 * Variáveis Globais, referencia para todas as classes do pacote br.uesc.computacao.estagio.apresentacao.GUI
	 */
	public static ModoExecucao modoExecucao = null;
	public static ModoManualBootstrap modoManualBootstrap = null;
	public static Seqboot seqboot = null;
	public static Programas programas = null;
	public static Metodos metodos = null;
	public static  PHYML phyml = null;
	public static  DIGRAFU digrafu = null;
	public static Editor editor = null;
        public static Conversor conversor = null;

	public ControladorIGrafu() {
		new ControladorModoExecucao();
		// new ControladorConversor();
		// new ControladorPHYML();
		// new ControladorDIGRAFU();
		// new ControladorProgramas();
		// GerarParametrosConversor.ConversorDataConvert();
	}

	/*
	 * Metodo utilizado para fazer a animacao da tela de splash
	 */
	public static void animacao() {
		SplashWindow splash = new SplashWindow("/br/uesc/computacao/estagio/apresentacao/figuras/splashIGRAFU.png");
		splash.open(5000);
		splash.close();
	}

        public static void novaInstancia(){
            modoExecucao = null;
            modoManualBootstrap = null;
            seqboot = null;
            programas = null;
            metodos = null;
            phyml = null;
            digrafu = null;
            editor = null;
            conversor = null;
        }

	/*
	 * Metodo main - execucao da IGrafu
	 * Chamada do metodo animacao e lookAndFeel
	 */
	public static void main(String[] args) {
		// animacao();
		try {

			UIManager.setLookAndFeel( "de.muntjak.tinylookandfeel.TinyLookAndFeel" );
			UIManager.put( "Separator.background", new ColorUIResource(Color.WHITE) );
			UIManager.put( "TextField.background", new ColorUIResource(Color.WHITE) );
			UIManager.put( "Label.font", new Font("Arial", Font.BOLD, 12) );
			UIManager.put( "RadioButton.font", new Font("Arial", Font.BOLD, 12) );
			UIManager.put( "CheckBox.font", new Font("Arial", Font.BOLD, 12) );
                        


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new ControladorIGrafu();
		
/*		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new ControladorIGrafu();
            }
        });*/
		
	}

}
