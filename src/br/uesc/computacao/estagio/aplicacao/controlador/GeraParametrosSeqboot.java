package br.uesc.computacao.estagio.aplicacao.controlador;

import javax.swing.JOptionPane;

/**
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */


public class GeraParametrosSeqboot {

	private static String ARQUIVO = "Informe o arquivo da seqüência";

	private static String SEQUENCIA = "Seqüencia";

//	private static String TIPO_DADO = "Informe o tipo de dado";
//
//	private static String ARQUIVO_SEQUENCIA_TIPO = "Informe o tipo de arquivo da seqüência\n Seqüencial/Intercalado";
//
//	private static String ARQUIVO_SEQUENCIA = "Arquivo da seqüência";
//
//	private static String BOOTSTRAP_INTERNO = "Informe o Bootstrap interno";
//
//	private static String BOOTSTRAP_EXTERNO = "Informe a quantidade de bootstrap!";
//
//	private static String LOCAIS_INVARIAVEIS = "Informe as proporções de locais invariáveis";
//
//	private static String PROPORCOES = "Proporções";
//
//	private static String INFORME_MODELO_DNA = "Informe o Modelo - DNA a ser utilizado!";
//
//	private static String INFORME_MODELO_AA = "Informe o Modelo - AA a ser utilizado!";
//
//	private static String MODELO_AA = "Modelo AA";
//
//	private static String MODELO_DNA = "Modelo DNA";
//
//	private static String PARAMETRO_GAMA = "Informe o parâmetro gama da distribuição!";
//
//	private static String PARAMETRO = "Parâmetro";
//
//	private static String ARQUIVO_ARVORE = "Informe o arquivo da árvore";
//
//	private static String ARVORE = "Árvore";
//
//	private static String ARVORE_BIONJ = "Escolha o Arquivo da árvore ou o BIONJ";
//
//	private static String ARQUIVO_BIONJ = "Arquivo/BIONJ";
//
//	private static String ESCOLHA_TOPOLOGIA = "Escolha a Topologia";
//
//	private static String TOPOLOGIA = "Topologia";
//
//	private static String TAXA_ARVORE = "Escolha a Taxa da árvore";
//
//	private static String TAXA = "Taxa";

	public static boolean trataAbasSequenciaSeqboot() {
		ControladorSeqboot.trataParametrosSeqboot = "";

		if (ControladorIGrafu.seqboot.getJTextFieldArquivoSequencia().getText().length() == 0) {
			JOptionPane.showMessageDialog(null, ARQUIVO, SEQUENCIA,	JOptionPane.INFORMATION_MESSAGE);
			return false;
		} /*else
			ControladorSeqboot.guardaNomeSequencia = ControladorIGrafu.seqboot.getJTextFieldArquivoSequencia().getText();*/

		if (ControladorIGrafu.seqboot.getJNumberFieldSemente().getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe um valor impar!", "Semente", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			ControladorSeqboot.trataParametrosSeqboot += " " + ControladorIGrafu.seqboot.getJNumberFieldSemente().getText();

		if (ControladorIGrafu.seqboot.getJNumberFieldReplicas().getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe um valor válido!",	"Replicas", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			ControladorSeqboot.trataParametrosSeqboot += " "	+ ControladorIGrafu.seqboot.getJNumberFieldReplicas().getText();


		if (ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getItemAt(0))
			ControladorSeqboot.trataParametrosSeqboot += " " + "SEQU";

		else if (ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getItemAt(1))
			ControladorSeqboot.trataParametrosSeqboot += " " + "MORF";

		else if (ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getItemAt(2))
			ControladorSeqboot.trataParametrosSeqboot += " " + "REST";

		else if (ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoSequencia().getItemAt(3))
			ControladorSeqboot.trataParametrosSeqboot += " " + "FREQ";


		if (ControladorIGrafu.seqboot.getJComboBoxModelo().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxModelo().getItemAt(0))
			ControladorSeqboot.trataParametrosSeqboot += " " + "BOOT";

		else if (ControladorIGrafu.seqboot.getJComboBoxModelo().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxModelo().getItemAt(1))
			ControladorSeqboot.trataParametrosSeqboot += " " + "JACK";

		else if (ControladorIGrafu.seqboot.getJComboBoxModelo().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxModelo().getItemAt(2))
			ControladorSeqboot.trataParametrosSeqboot += " " + "PERM";

		else if (ControladorIGrafu.seqboot.getJComboBoxModelo().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxModelo().getItemAt(3))
			ControladorSeqboot.trataParametrosSeqboot += " " + "PORD";

		else if (ControladorIGrafu.seqboot.getJComboBoxModelo().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxModelo().getItemAt(4))
			ControladorSeqboot.trataParametrosSeqboot += " " + "PSPEC";


		if (ControladorIGrafu.seqboot.getJComboBoxFormato().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxFormato().getItemAt(0))
			ControladorSeqboot.trataParametrosSeqboot += " " + "S";

		else if (ControladorIGrafu.seqboot.getJComboBoxFormato().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxFormato().getItemAt(1))
			ControladorSeqboot.trataParametrosSeqboot += " " + "I";


		if (ControladorIGrafu.seqboot.getJComboBoxTipoDado().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoDado().getItemAt(0))
			ControladorSeqboot.trataParametrosSeqboot += " " + "DNA";

		else if (ControladorIGrafu.seqboot.getJComboBoxTipoDado().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoDado().getItemAt(1))
			ControladorSeqboot.trataParametrosSeqboot += " " + "RNA";

		else if (ControladorIGrafu.seqboot.getJComboBoxTipoDado().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxTipoDado().getItemAt(2))
			ControladorSeqboot.trataParametrosSeqboot += " " + "PRO";

///////////////////////////////////////////DUVIDA//////////////////////////////////////
		if(ControladorIGrafu.seqboot.getJTextFieldCategoriasSitios().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJTextFieldCategoriasSitios().getText().length() != 0) {
				//tirar duvida com JACK sobre ALL - CAT - FAC
				ControladorSeqboot.trataParametrosSeqboot += " " + "ALL " + ControladorIGrafu.seqboot.getJTextFieldCategoriasSitios().getText();
			}
		}

		if(ControladorIGrafu.seqboot.getJCheckBoxEnzimas().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJCheckBoxEnzimas().isSelected())
				ControladorSeqboot.trataParametrosSeqboot += " " + "ENZIMA";
		}

		if(ControladorIGrafu.seqboot.getJNumberFieldBloco().isEnabled()) {
			if((ControladorIGrafu.seqboot.getJNumberFieldBloco().getlength() > 0) &&
			   (ControladorIGrafu.seqboot.getJNumberFieldBloco().getValue() > 1))
				ControladorSeqboot.trataParametrosSeqboot += " BLOCO " + ControladorIGrafu.seqboot.getJNumberFieldBloco().getText();
		}

		if(ControladorIGrafu.seqboot.getJTextFieldPesos().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJTextFieldPesos().getText().length() != 0)
				ControladorSeqboot.trataParametrosSeqboot += " " + "WEIGHT " + ControladorIGrafu.seqboot.getJTextFieldPesos().getText();
		}

		if(ControladorIGrafu.seqboot.getJCheckBoxMultiplosArquivosSaidaDados().isEnabled() &&
				ControladorIGrafu.seqboot.getJCheckBoxMultiplosArquivosSaidaPesos().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJCheckBoxMultiplosArquivosSaidaPesos().isSelected())
				ControladorSeqboot.trataParametrosSeqboot += " " + "JUSTW";
			else if(ControladorIGrafu.seqboot.getJCheckBoxMultiplosArquivosSaidaDados().isSelected())
				ControladorSeqboot.trataParametrosSeqboot += " " + "OUTD";
		}

		if(ControladorIGrafu.seqboot.getJTextFieldArquivoMisturado().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJTextFieldArquivoMisturado().getText().length() != 0)
				ControladorSeqboot.trataParametrosSeqboot += " " + "MIX " + ControladorIGrafu.seqboot.getJTextFieldArquivoMisturado().getText();
		}

		if(ControladorIGrafu.seqboot.getJTextFieldArquivoAncestral().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJTextFieldArquivoAncestral().getText().length() != 0)
				ControladorSeqboot.trataParametrosSeqboot += " " + "ANC " + ControladorIGrafu.seqboot.getJTextFieldArquivoAncestral().getText();
		}

		if(ControladorIGrafu.seqboot.getJNumberFieldAmostras().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJNumberFieldAmostras().getText().length() != 0)
				ControladorSeqboot.trataParametrosSeqboot += " " + "FRACAO " + ControladorIGrafu.seqboot.getJNumberFieldAmostras().getText();
		}

		if(ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().isEnabled()) {
			if(ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getSelectedItem() !=
				ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getItemAt(0)) {
				if (ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getSelectedItem() ==
					ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getItemAt(1))
					ControladorSeqboot.trataParametrosSeqboot += " " + "RESC " + "PHY";

				else if (ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getSelectedItem() ==
					ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getItemAt(2))
					ControladorSeqboot.trataParametrosSeqboot += " " + "RESC " + "NEX";

				else if (ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getSelectedItem() ==
					ControladorIGrafu.seqboot.getJComboBoxFormatoSaida().getItemAt(3))
					ControladorSeqboot.trataParametrosSeqboot += " " + "RESC " + "XML";
			}
		}

		return true;
	}

	public static boolean trataAbaConsense() {
		ControladorSeqboot.trataParametrosConsense = "";

		if(ControladorIGrafu.seqboot.getJRadioButtonRaizSim().isSelected() || ControladorIGrafu.seqboot.getJRadioButtonRaizNao().isSelected()) {
			if(ControladorIGrafu.seqboot.getJRadioButtonRaizSim().isSelected())
				ControladorSeqboot.trataParametrosConsense += " S";

			else if(ControladorIGrafu.seqboot.getJRadioButtonRaizNao().isSelected())
				ControladorSeqboot.trataParametrosConsense += " " + "N";
		}
		else {
			JOptionPane.showMessageDialog(null, "Informe se trata a árvore com ou sem raiz", "Consense - Raíz", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		if (ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getItemAt(0))
			ControladorSeqboot.trataParametrosConsense += " " + "MRE";

		else if (ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getItemAt(1))
			ControladorSeqboot.trataParametrosConsense += " " + "STR";

		else if (ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getItemAt(2))
			ControladorSeqboot.trataParametrosConsense += " " + "MR";

		else if (ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getItemAt(3))
			ControladorSeqboot.trataParametrosConsense += " " + "ML";


		if(ControladorIGrafu.seqboot.getJNumberFieldMaiorAncestral().getText().length() != 0)
			ControladorSeqboot.trataParametrosConsense += " " + "ROOT " + ControladorIGrafu.seqboot.getJNumberFieldMaiorAncestral().getText();

		if(ControladorIGrafu.seqboot.getJCheckBoxEspeciesArquivoSaidaIndicar().isSelected())
			ControladorSeqboot.trataParametrosConsense += " " + "PRINT";

		if(ControladorIGrafu.seqboot.getJCheckBoxExecucaoIndicar().isSelected())
			ControladorSeqboot.trataParametrosConsense += " " + "RUN";

		if(ControladorIGrafu.seqboot.getJCheckBoxArvoreArquivoSaidaDesenhar().isSelected())
			ControladorSeqboot.trataParametrosConsense += " " + "TREE";

		if(ControladorIGrafu.seqboot.getJTextFieldArvore().getText().length() != 0)
			ControladorSeqboot.trataParametrosConsense += " " + "FILE " + ControladorIGrafu.seqboot.getJTextFieldArvore().getText();

		if (ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getSelectedItem() ==
			ControladorIGrafu.seqboot.getJComboBoxAvaliacao().getItemAt(3)) {

			if(ControladorIGrafu.seqboot.getJCheckBoxFracaoTempoUsar().isSelected()) {
				if(ControladorIGrafu.seqboot.getJNumberFloatFieldFracaoTempo().getText().length() != 0)
					ControladorSeqboot.trataParametrosConsense += " " + "FRACTION " + ControladorIGrafu.seqboot.getJNumberFloatFieldFracaoTempo().getText();
			}

		}

		return true;
	}

}
