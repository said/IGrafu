package br.uesc.computacao.estagio.test.GUI;

import br.uesc.computacao.estagio.apresentacao.GUI.PHYML;

public class PHYMLTester implements Tester {

	/**
	 * @param args not used.
	 */
	public static void main(String[] args) {
		Tester testerClass = new PHYMLTester();
		testerClass.beginTest();
	}

	@Override
	public void beginTest() {
		PHYML testedClass = new PHYML();
		testedClass.setVisible(true);
		
	}


}
