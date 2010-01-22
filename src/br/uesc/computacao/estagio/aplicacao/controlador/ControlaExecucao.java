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

	/*
	 * Metodo de controle da execucao do DiGrafu
	 */
	public static void executaDIGRAFU() {
		
		ControladorDIGRAFU.guardaArquivo = "";
		
        if(GeraParametrosDIGRAFU.trataAbaSequecia())
            if(GeraParametrosDIGRAFU.trataAbaModeloDNA()){
            	
            	if(ControladorModoManualBootstrap.bootstrap == true) {
            		GeraParametrosSeqboot.trataAbasSequenciaSeqboot();
					GeraParametrosSeqboot.trataAbaConsense();
                    Processo.processarSeqbootDIGRAFUSequencial();
            	}
            	else Processo.processarDIGRAFU();
            	
            	ControladorDIGRAFU.guardaArquivo = "";
            	
            }
        
	}
	
}

