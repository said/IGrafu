package br.uesc.computacao.estagio.test.GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.uesc.computacao.estagio.aplicacao.util.JBorderedPanel;

public class JBPanelTester implements Tester {

	@Override
	public void beginTest() {
		JFrame frame = new JFrame("Outer Frame");
		JLabel label = new JLabel("OLOLOLOLOLOLOLOL");
		frame.setSize(200, 150);
		frame.setLayout(null);
		JBorderedPanel panel = new JBorderedPanel(
				label, true, new Dimension(400, 350), 130);
		panel.setLocation(0, 0);
		panel.setBackground(Color.RED);
		JButton testButton = new JButton("Test");
		testButton.setSize(testButton.getPreferredSize());
		testButton.setLocation(100, 50);
		
		panel.add(testButton);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setText("LOL");
	}
	public static void main(String[] args) {
		Tester testerClass = new JBPanelTester();
		testerClass.beginTest();
	}

}
