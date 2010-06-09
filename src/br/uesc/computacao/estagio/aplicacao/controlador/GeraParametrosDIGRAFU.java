package br.uesc.computacao.estagio.aplicacao.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.util.ManipulaArquivo;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;

/**
 * Classe que gerencia os parametros escolhidos na tela DiGrafu
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 */


public class GeraParametrosDIGRAFU {
	
	// Constantes de identificação do modelo
	public static final int
							KIMURA = 0, // Modelo comum à DNA e proteína
							// Modelos de DNA
							F84	   = 1,
							JC69   = 2,
							LOGDET = 3,
							// Modelos de proteína
							JTT	   = 1,
							PMB    = 2,
							PAM    = 3;

	private static String tipo = "dna";
	private static int modelo = KIMURA;

	public static String ERRO = "Erro";

	/**
     * Este metodo trata os dados da aba - Sequencia para poder gerar o arquivo que sera passado ao DiGrafu
     * Caso alguma opcao esteja errada ou sem preenchimento o tipo de retorno e um byte = 0, assim indica que teve erro e o metodo e
     * Abortado
     * Caso o retorno seja um byte = 1, indica que o metodo foi executado com sucesso, todos os dados estavam corretos
     *
     * @return byte
     */
    //Tratando dados para gerar arquivo
    public static boolean trataParametrosSequencia() {
    	//Limpa a variável
    	ControladorDIGRAFU.guardaArquivo = "";

    	if(ControladorModoManualBootstrap.bootstrap == false) {
//    		Arquivo entrada
            if(ControladorConversor.arquivoSaida.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do arquivo da seqüência", "Seqüência", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
/*            else {
            	ControladorDIGRAFU.guardaNomeSequencia = "INPUT " + ControladorDIGRAFU.guardaNomeSequencia;
            }*/

            //Arquivo de saida
            ControladorDIGRAFU.guardaArquivo += " OUTPUT " + caminho() + "arquivos_saida/digrafu/out_" + ControladorConversor.arquivoSaida;

            /*	
             * PREFERENCE  pref
             *	A prioridade é dada ao  tempo  de  execução[t],  a  exatidão  do 
             *  método[a] (padrão) ou a ambos [ta].
			 */
            ControladorDIGRAFU.guardaArquivo += " PREFERENCE ";
            
            if(!(ControladorIGrafu.digrafu.getCheckBoxExatidao().isSelected()) && !(ControladorIGrafu.digrafu.getCheckBoxExecucao().isSelected())){
            	JOptionPane.showMessageDialog(null, "Informe o tempo", "Exatidão/Execução", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            else {
            	
                if(ControladorIGrafu.digrafu.getCheckBoxExecucao().isSelected())
                	ControladorDIGRAFU.guardaArquivo += "t";
                if(ControladorIGrafu.digrafu.getCheckBoxExatidao().isSelected())
                	ControladorDIGRAFU.guardaArquivo += "a";
                
            }
        	
        	ControladorDIGRAFU.guardaArquivo += " TYPE " + getTipo();
        	ControladorDIGRAFU.guardaArquivo += " MODEL " + getModelo();
            
    	}

        return true;
    }

    /**
     * Este metodo trata os dados da aba Modelo - DNA para poder gerar o arquivo que sera passado ao DiGrafu
     * Caso alguma opcao esteja errada ou sem preenchimento o tipo de retorno e um byte = 0, assim indica que teve erro e o metodo e
     * Abortado
     * Caso o retorno seja um byte = 1, indica que o metodo foi executado com sucesso, todos os dados estavam corretos
     *
     * @return byte
     */
    public static boolean trataParametrosDNA() {
    	
    	switch(modelo){
    	
    		case F84:
    			// Frequências
    			if(ControladorIGrafu.digrafu.getCheckBoxFrequenciasEmpiricas().isSelected()){
    				
    				float frequenciaTotal = (
    						Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasA().getValue().toString()) +
    						Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasC().getValue().toString()) +
    						Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasG().getValue().toString()) +
    						Float.valueOf(ControladorIGrafu.digrafu.getSpinnerFrequenciasT().getValue().toString())
    						);
    				
    				if(frequenciaTotal == 1)
        			ControladorDIGRAFU.guardaArquivo += " FREQUE "
                    		  +	ControladorIGrafu.digrafu.getSpinnerFrequenciasA().getValue() + ","
                    		  + ControladorIGrafu.digrafu.getSpinnerFrequenciasC().getValue() + ","
                    		  + ControladorIGrafu.digrafu.getSpinnerFrequenciasG().getValue() + ","
                    		  + ControladorIGrafu.digrafu.getSpinnerFrequenciasT().getValue();
    				else{
    					JOptionPane.showMessageDialog(null, "A soma das frequências deve ser igual a 1", ERRO, JOptionPane.ERROR_MESSAGE);
    					return false;
    				}
    			}
    		
    		case KIMURA:
    			// Taxa Transição/Transversão
    			if(ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().getText().length() > 0)
        			ControladorDIGRAFU.guardaArquivo += " RATIO "
        				+ ControladorIGrafu.digrafu.getCampoNumericoTransicaoTransversao().getText();
    		
    		case JC69:
    			// Distribuição Gamma
    			if(ControladorIGrafu.digrafu.getCampoNumericoCV().getText().length() != 0){
    				ControladorDIGRAFU.guardaArquivo += " CV "
    					+ ControladorIGrafu.digrafu.getCampoNumericoCV().getText();
    				if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected())
        				ControladorDIGRAFU.guardaArquivo += " ISITE "
        					+ ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().getValue();
    			}
    			// Categorias
    			if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected())
    				ControladorDIGRAFU.guardaArquivo +=
    					getValoresCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
    		
    		case LOGDET:
    			// Pesos para Sítios
    			if(ControladorIGrafu.digrafu.getCheckBoxPesos().isSelected()){
    				if(ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().isSelected())
    					ControladorDIGRAFU.guardaArquivo += " WEIGHT " + getPesos();
    				else if(ControladorIGrafu.digrafu.getRadioBotaoPesosManual().isSelected())
        				ControladorDIGRAFU.guardaArquivo += " WEIGHT "
        					+ ControladorIGrafu.digrafu.getAreaTextoPesos().getText();        					
    			}
    	
    	}
    	
    	return true;
        
    }
    
    public static boolean trataParametrosProteina() {
    	
    	if(modelo != KIMURA){
			// Distribuição Gamma
			if(ControladorIGrafu.digrafu.getCampoNumericoCV().getText().length() != 0){
				ControladorDIGRAFU.guardaArquivo += " CV "
					+ ControladorIGrafu.digrafu.getCampoNumericoCV().getText();
				if(ControladorIGrafu.digrafu.getCheckBoxSitiosInvariantes().isSelected())
    				ControladorDIGRAFU.guardaArquivo += " ISITE "
    					+ ControladorIGrafu.digrafu.getSpinnerSitiosInvariantes().getValue();
			}
			// Categorias
			if(ControladorIGrafu.digrafu.getCheckBoxCategorias().isSelected())
				ControladorDIGRAFU.guardaArquivo +=
					getValoresCategorias((Integer)ControladorIGrafu.digrafu.getSpinnerCategoriasNum().getValue());
		
			// Pesos para Sítios
			if(ControladorIGrafu.digrafu.getCheckBoxPesos().isSelected()){
				if(ControladorIGrafu.digrafu.getRadioBotaoPesosDoArquivo().isSelected())
					ControladorDIGRAFU.guardaArquivo += " WEIGHT " + getPesos();
				else if(ControladorIGrafu.digrafu.getRadioBotaoPesosManual().isSelected())
    				ControladorDIGRAFU.guardaArquivo += " WEIGHT "
    					+ ControladorIGrafu.digrafu.getAreaTextoPesos().getText();        					
			}
    	
    	}
    	
    	return true;
        
    }
    
    public static String getTipo(){
    	
    	if(ControladorIGrafu.digrafu.getComboTipo().getSelectedItem() == "DNA")
    		return "dna";
    	else
    		return "prot";
    	
    }
    
    public static String getModelo(){
    	
    	if(getTipo() == "dna"){
    		modelo = ControladorIGrafu.digrafu.getComboModeloDNA().getSelectedIndex();
	    	switch(modelo){
		    	case F84:
		    		return "f84";
		    	case JC69:
		    		return "jc69";
		    	case LOGDET:
		    		return "logdet";
	    	}
		}
    	else{
    		modelo = ControladorIGrafu.digrafu.getComboModeloProteina().getSelectedIndex();
	    	switch(modelo){
		    	case JTT:
		    		return "jtt";
		    	case PMB:
		    		return "pmb";
		    	case PAM:
		    		return "pam";
	    	}
    	}
    	
		return "kimura";
    	
    }
    
    public static String getModeloDNA(){
    	
    	modelo = ControladorIGrafu.digrafu.getComboModeloDNA().getSelectedIndex(); 
    	
    	switch(modelo){
	    	case F84:
	    		return "f84";
	    	case JC69:
	    		return "jc69";
	    	case LOGDET:
	    		return "logdet";
	    	default:
	    		return "kimura";
    	}
    	
    }
    
    public static String getModeloProteina(){
    	
    	modelo = ControladorIGrafu.digrafu.getComboModeloProteina().getSelectedIndex();
    	
    	switch(modelo){
	    	case JTT:
	    		return "jtt";
	    	case PMB:
	    		return "pmb";
	    	case PAM:
	    		return "pam";
	    	default:
	    		return "kimura";
    	}
    	
    }
	
	private static String getPesos(){
		
		BufferedReader arquivo = null;
		String pesos = "";
		
    	try {
			arquivo = new BufferedReader(new FileReader(ControladorIGrafu.digrafu.getCampoTextoPesosDoArquivo().getText()));
    	String linha;
    	while((linha = arquivo.readLine()) != null)
    		pesos += linha;
		}
        catch (FileNotFoundException f) {
            JOptionPane.showMessageDialog(null, "ERRO - Arquivo não encontrado.", ERRO, JOptionPane.ERROR_MESSAGE);
		}
        catch (IOException g) {
            JOptionPane.showMessageDialog(null, "ERRO - IO", ERRO, JOptionPane.ERROR_MESSAGE);
		}
    	
    	return pesos;
        
    }
    
    private static String getValoresCategorias(Integer numCat){
    	
    	String valoresCategorias = "";
    	
    	switch(numCat){

	    	case 9:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria9().getText().length() > 0)
	    			valoresCategorias += "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria9().getText();
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
	    	case 8:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria8().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria8().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
	    	case 7:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria7().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria7().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
	    	case 6:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria6().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria6().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
	    	case 5:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria5().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria5().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
	    	case 4:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria4().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria4().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
    		case 3:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria3().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria3().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
	    	case 2:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria2().getText().length() > 0)
	    			valoresCategorias = "," + ControladorIGrafu.digrafu.getCampoNumericoCategoria2().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}
    		case 1:
	    		if(ControladorIGrafu.digrafu.getCampoNumericoCategoria1().getText().length() > 0)
	    			valoresCategorias = " CATEGORIES "
	    				+ ControladorIGrafu.digrafu.getCampoNumericoCategoria1().getText() + valoresCategorias;
	    		else{
	    			JOptionPane.showMessageDialog(null, "O valor de cada categoria deve ser preenchido", "Dados Incompletos", JOptionPane.WARNING_MESSAGE);
	    			return "";
	    		}	    	
	    	
    	}
    	return valoresCategorias;
    	
    }

    // O método retorna o caminho do diretório que está sendo utilizado
    public static String caminho() {
    	
    	return (System.getProperty("user.dir")+"/");
    }

}
