package br.uesc.computacao.estagio.aplicacao.controlador;


import br.uesc.computacao.estagio.aplicacao.util.Processo;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import java.io.File;

/**
 * Classe utilizada para controlar a execucao dos programas
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */


public class ControlaExecucao {

	public static ControlaExecucao controlaExecucao = null;

	public ControlaExecucao() { }

	/*
	 * Metodo de controle da execucao do phyml
	 */
	public static void executaPHYML() {
            Processo.pegaCaminho();
	ControladorPHYML.guardaArquivo = "";
	ControladorSeqboot.trataParametrosSeqboot = "";

        if(GeraParametrosPHYML.trataAbaSequecia()) {
            if((GeraParametrosPHYML.trataAbaModeloDNA()) || (GeraParametrosPHYML.trataAbaModeloAA())) {
                if(GeraParametrosPHYML.trataAbaModeloArvore()) {
        				if(ControladorModoManualBootstrap.bootstrap) {
        					if(ControladorIGrafu.phyml.getJCheckBoxTipoExecucaoParalelo().isSelected()) {
        						GeraParametrosSeqboot.trataAbasSequenciaSeqboot();
        						GeraParametrosSeqboot.trataAbaConsense();
        						Processo.processarSeqbootPHYMLParalelo();
                                ControladorPHYML.guardaArquivo = "";
        					}
        					else {
        		
        					}
        				}
        				else {
                                            Processo.processarPHYML();
                                            ControladorPHYML.guardaArquivo = "";
                                           
        				}
                }
                else return;
            }
            else return;
        }
        else return;
        if(GeraParametrosPHYML.trataAbaSequecia())
        	ControladorPHYML.guardaArquivo = "";
        if((GeraParametrosPHYML.trataAbaModeloDNA()) || (GeraParametrosPHYML.trataAbaModeloAA()))
        	ControladorPHYML.guardaArquivo = "";
        if(GeraParametrosPHYML.trataAbaModeloArvore())
        	ControladorPHYML.guardaArquivo = "";

       Thread move = new Thread (new Runnable(){
                            public void run(){
                                //GerarParametrosConversor.movePHYML();
                                GerarParametrosConversor.moveArquivo(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText(), ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().getText());




                            }
                        });
                      move.start();

    }

	/**
	 * Método responsável por executar o DiGrafu através da classe Processo.
	 * O método verifica se todos os parâmetros estão validados através das
	 * classes "GeraParametros" bem como se está se fazendo uso de bootstrap.  
	 */
	public static void executaDIGRAFU() {
		
		ControladorDIGRAFU.guardaArquivo = "";
		
        if(GeraParametrosDIGRAFU.trataParametrosSequencia()){
			if(tipoDNAValidado() || tipoProteinaValidado()){
            	if(ControladorModoManualBootstrap.bootstrap == true){
            		if(bootstrapValidado()){
            			// Temporariamente este método irá tratar também a
            			// execução paralela
            			Processo.processarSeqbootDIGRAFUSequencial();
            		}
            	}
            	else
            		Processo.processarDIGRAFU();
            }
        }
        else{
			System.out.println("Erro em parâmetro(s) da sequência");
        }
        
    	ControladorDIGRAFU.guardaArquivo = "";
        
	}
	
	/**
	 * Verifica parâmetros de DNA
	 * @return true se os parâmtros de DNA estiverem validados
	 */
	private static boolean tipoDNAValidado(){
		
		if((GeraParametrosDIGRAFU.getTipo() == "dna") &&
			GeraParametrosDIGRAFU.trataParametrosDNA())
			return true;
		else{
			System.out.println("Erro em parâmetro(s) de dna");
			return false;
		}
		
	}

	/**
	 * Verifica parâmetros de proteína
	 * @return true se os parâmtros de DNA estiverem validados
	 */
	private static boolean tipoProteinaValidado(){
		
		if((GeraParametrosDIGRAFU.getTipo() == "proteina") &&
			GeraParametrosDIGRAFU.trataParametrosProteina())
			return true;
		else{
			System.out.println("Erro em parâmetro(s) de proteína");
			return false;
		}
		
	}

	/**
	 * Verifica parâmetros de bootstrap
	 * @return true se os parâmtros de bootstrap estiverem validados
	 */
	private static boolean bootstrapValidado(){
		
		if(GeraParametrosSeqboot.trataAbasSequenciaSeqboot()){
			if(GeraParametrosSeqboot.trataAbaConsense())
				return true;
			else{
				System.out.println("Erro em parâmetro(s) da aba Consense");
				return false;
			}
		}
		else{
			System.out.println("Erro em parâmetro(s) da aba Seqboot");
			return false;
		}
		
	}
	
}

