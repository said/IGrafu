package br.uesc.computacao.estagio.aplicacao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import br.uesc.computacao.estagio.aplicacao.controlador.ControladorDIGRAFU;
import br.uesc.computacao.estagio.aplicacao.controlador.ControladorIGrafu;
import br.uesc.computacao.estagio.aplicacao.controlador.ControladorConversor;
import br.uesc.computacao.estagio.aplicacao.controlador.ControladorPHYML;
import br.uesc.computacao.estagio.aplicacao.controlador.ControladorSeqboot;
import br.uesc.computacao.estagio.aplicacao.controlador.GerarParametrosConversor;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;


/**
 * Classe utilizada para executar os programas contidos na IGrafu
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

public class Processo {

    /**
     * Variaveis globais.
     */
    private static Process phyml = null;
    private static Process digrafu = null;
    private static Process hypertree = null;
    private static Process seqbootPHYML = null;
    private static Process seqbootDIGRAFU = null;
    private static Process execucaoAutomatica = null;

    private static String nomeArquivoSequencia = "";
    public static String pegaCaminho = "";
    public static String corrigeCaminho = "";

    public static String localSaida;

    public static String ERRO = "Erro";

	public static String ERRO1 = "ERRO  não foi possível executar o PHYML!";

	public static String ERRO2 = "ERRO  não foi possível executar o DIGRAFU!";

	public static String ERRO3 = "ERRO  não foi possível executar o HyperTree!";

	public static String EXEC_PHYML = "PHYML terminou de ser executado!";

	public static String EXEC_PHYML_1 = "Execução - PHYML";

	public static String EXEC_DIGRAFU = "DIGRAFU terminou de ser executado!";

	public static String EXEC_DIGRAFU_1 = "Execução - DIGRAFU";

	public static String PERFIL = "";

	public static String PERFIL_EXECUCAO = "";

	public static String ERRO_PERFIL = "";


    /**
     * Construtur default.
     */
    public Processo() {}

    /**
     * Metodo utilizado para executar o PHYML
     *
     * @return void
     */
    public static void processarPHYML() {
    	pegaCaminho();
        
        localSaida = (pegaCaminho) + (corrigeCaminho) + "/arquivos_saida/phyml";


    	nomeArquivoSequencia = ControladorIGrafu.phyml.getJTextFieldArquivoSequencia().getText();

        try {

            System.out.println(("Emitindo permissão ao phyml sequencial.\nchmod 777 "+ Processo.corrigeCaminho + "/programas/phyml_v2.4.5/phyml"));
            phyml = Runtime.getRuntime().exec(("chmod 777 "+ (pegaCaminho) + (corrigeCaminho) + "/programas/phyml_v2.4.5/phyml"));

            if(ControladorIGrafu.phyml.getJCheckBoxTipoExecucaoParalelo().isSelected()) {

                String auxCombo = "";

                if(ControladorIGrafu.phyml.getJTabbedPaneTipoExecucao().getSelectedComponent()==
                        ControladorIGrafu.phyml.getJPanelTipoExecucaoParalelo()) {
                	//devolve a quantidade de processadores a ser utilizada na execucao
                    auxCombo += ControladorIGrafu.phyml.getJComboBoxTipoExecucaoParalelo().getSelectedItem();

                    System.out.println("Log - phyml executado paralelamente:\n");
                    System.out.println(("/usr/local/mpich-1.2.7p1/bin/mpirun -np " + (auxCombo) + " -nolocal " + " "
                    + (pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_paralelo/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo)));

                    phyml = Runtime.getRuntime().exec(("/usr/local/mpich-1.2.7p1/bin/mpirun -np " + (auxCombo) + " -nolocal " + " "
                            + (pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_paralelo/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo)));

                    phyml.waitFor();
                        JOptionPane.showMessageDialog(null, EXEC_PHYML, EXEC_PHYML_1, JOptionPane.INFORMATION_MESSAGE);
                        if(ControladorPHYML.perfil == true) {
                        	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorPHYML.nomePerfil);
                        	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ("/usr/local/mpich-1.2.7p1/bin/mpirun -np " + (auxCombo) + " -nolocal " + " "
                                    + (pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_paralelo/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo)));
                        	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ControladorPHYML.guardaArquivo);
                        }
                        ControladorPHYML.perfil = false;
                    phyml.destroy();
                }

                if(ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() != ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getItemAt(0)) {

                    	System.out.println("Log - phyml executado com ssh sequencialmente:\n");
                    	System.out.println("ssh " + ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() + " " +
                        		(pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo) + " ; exit");
                        phyml = Runtime.getRuntime().exec("ssh " + ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() + " " +
                        		(pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo) + " ; exit");

                        phyml.waitFor();
                            JOptionPane.showMessageDialog(null, EXEC_PHYML, EXEC_PHYML_1, JOptionPane.INFORMATION_MESSAGE);
                            if(ControladorPHYML.perfil == true) {
                            	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorPHYML.nomePerfil);
                            	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ("ssh " + ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() + " " +
                                							(pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ")));
                            	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ControladorPHYML.guardaArquivo + " ; exit");
                            }
                            ControladorPHYML.perfil = false;
                        phyml.destroy();
                    }
                    else {
                    	System.out.println("Log - phyml executado sequencialmente:\n");
                    	System.out.println((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo));

						phyml = Runtime.getRuntime().exec((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo));
						phyml.waitFor();
                			JOptionPane.showMessageDialog(null, EXEC_PHYML, EXEC_PHYML_1, JOptionPane.INFORMATION_MESSAGE);
                			if(ControladorPHYML.perfil == true) {
                				ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorPHYML.nomePerfil);
                            	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ")));
                            	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ControladorPHYML.guardaArquivo);
                            }
                            ControladorPHYML.perfil = false;
                		phyml.destroy();
                    }
            }
            else {
            	System.out.println("Log - phyml executado sequencialmente:\n");
            	System.out.println((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo));
                phyml = Runtime.getRuntime().exec((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo));

                phyml.waitFor();
                    JOptionPane.showMessageDialog(null, EXEC_PHYML, EXEC_PHYML_1, JOptionPane.INFORMATION_MESSAGE);
                    if(ControladorPHYML.perfil == true) {
                    	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorPHYML.nomePerfil);
                    	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ")));
                    	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, ControladorPHYML.guardaArquivo);
                    }
                    ControladorPHYML.perfil = false;
                phyml.destroy();
            }
            //GerarParametrosConversor.movePHYML(nomeArquivoSequencia, ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().getText());
            
        }
        catch(Exception expection) {
            JOptionPane.showMessageDialog(null, ERRO1, ERRO, JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * Metodo utilizado para executar o SEQBOOT-PHYML-sequencial
     *
     * @return void
     */
    public static void processarSeqbootPHYMLSequencial() {
    	pegaCaminho();

    	try {
    		String inicio = "cd " + pegaCaminho + (corrigeCaminho) + "/programas/jack/ ; " + (pegaCaminho + corrigeCaminho + "jre/bin/java ") + "PhymlSequencial ";
    		String seqboot = pegaCaminho + (corrigeCaminho) +"/programas/seqboot/seqboot " + ControladorSeqboot.guardaNomeSequencia + ControladorSeqboot.trataParametrosSeqboot + " ";
    		String phymlSeqboot = "";
    		String consense = " " + pegaCaminho + (corrigeCaminho) + "/programas/consense/consense " +	ControladorSeqboot.trataParametrosConsense;

    		if(true) {
                if(ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() !=
                	ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getItemAt(0)) {

                	inicio = "ssh " + ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() + " ; " +
                			 "cd " + pegaCaminho + (corrigeCaminho) +"/programas/jack/ ; " + (pegaCaminho + corrigeCaminho + "jre/bin/java ") + "PhymlSequencial ";

                	consense = " " + pegaCaminho + (corrigeCaminho) +"/programas/consense/consense " +	ControladorSeqboot.trataParametrosConsense + " ; exit";

                	phymlSeqboot += ((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaArquivo));

                }
                else {
                	phymlSeqboot += ((pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml ") + (ControladorPHYML.guardaNomeSequencia) + (ControladorPHYML.guardaArquivo));

                }
    		}

    		String comando = inicio + seqboot + phymlSeqboot + consense;

    		if(ManipulaArquivo.existeArquivo("exec_phyml_bootstrap_sequencial.sh")) {
    			ManipulaArquivo.deletaArquivo("exec_phyml_bootstrap_sequencial.sh");
    		}

    		ManipulaArquivo.gravaArquivo( "exec_phyml_bootstrap_sequencial.sh", comando );

    		System.out.println("Log - phyml executado com bootstrap sequencial:\n" + inicio + seqboot + phymlSeqboot + consense);
    		seqbootPHYML = Runtime.getRuntime().exec("chmod 777 exec_phyml_bootstrap_sequencial.sh");
    		seqbootPHYML = Runtime.getRuntime().exec("./exec_phyml_bootstrap_sequencial.sh");

    		seqbootPHYML.waitFor();
    			JOptionPane.showMessageDialog(null, "PHYML com bootstrap terminou a execução!", "PHYML - bootstrap", JOptionPane.INFORMATION_MESSAGE);
    			if(ControladorPHYML.perfil == true) {
    				ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorPHYML.nomePerfil);
                	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, (inicio + pegaCaminho + "/programas/seqboot/seqboot "));
                	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, (ControladorSeqboot.trataParametrosSeqboot + " " + phymlSeqboot + consense));
                }
                ControladorPHYML.perfil = false;
            seqbootPHYML.destroy();

    	}
    	catch(Exception expection) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar o PHYML com bootstrap!", "PHYML - bootstrap", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo utilizado para executar o SEQBOOT-PHYML-paralelo
     *
     * @return void
     */
    public static void processarSeqbootPHYMLParalelo() {
    	pegaCaminho();

    	try {
    		String inicio = "cd " + pegaCaminho + "/programas/jack/ ; " + (pegaCaminho + corrigeCaminho + "jre/bin/java ") + "PhymlParalelo ";
    		String seqboot = pegaCaminho + "/programas/seqboot/seqboot " + ControladorSeqboot.guardaNomeSequencia + ControladorSeqboot.trataParametrosSeqboot + " ";
    		String phymlSeqboot = "";
    		String consense = pegaCaminho + "/programas/consense/consense " +	ControladorSeqboot.trataParametrosConsense;

    		if(ControladorIGrafu.phyml.getJCheckBoxTipoExecucaoParalelo().isSelected()) {
    			String quantidadeProcessadores = "";

            	//devolve a quantidade de processadores a ser utilizada na execucao
    			quantidadeProcessadores += ControladorIGrafu.phyml.getJComboBoxTipoExecucaoParalelo().getSelectedItem();

                phymlSeqboot += ((quantidadeProcessadores) + " " + (pegaCaminho) + (corrigeCaminho) + ("/programas/phyml_v2.4.5/phyml") + (ControladorPHYML.guardaArquivo) + " ");
    		}
    		String comando = inicio + seqboot + phymlSeqboot + consense;

    		if(ManipulaArquivo.existeArquivo("exec_phyml_bootstrap_paralelo.sh")) {
    			ManipulaArquivo.deletaArquivo("exec_phyml_bootstrap_paralelo.sh");
    		}

    		ManipulaArquivo.gravaArquivo( "exec_phyml_bootstrap_paralelo.sh", comando );

    		System.out.println("Log - phyml executado com bootstrap paralelo:\n" + inicio + seqboot + phymlSeqboot + consense);
    		seqbootPHYML = Runtime.getRuntime().exec("chmod 777 exec_phyml_bootstrap_paralelo.sh");
    		seqbootPHYML = Runtime.getRuntime().exec("./exec_phyml_bootstrap_paralelo.sh");

    		seqbootPHYML.waitFor();
    			JOptionPane.showMessageDialog(null, "PHYML paralelo com bootstrap terminou a execução!", "PHYML - bootstrap", JOptionPane.INFORMATION_MESSAGE);
    			if(ControladorPHYML.perfil == true) {
    				ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorPHYML.nomePerfil);
    				ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, (inicio + pegaCaminho + "/programas/seqboot/seqboot "));
                	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorPHYML.nomePerfil, (ControladorSeqboot.trataParametrosSeqboot + " " + phymlSeqboot + consense));
                }
                ControladorPHYML.perfil = false;
            seqbootPHYML.destroy();
    	}
    	catch(Exception expection) {
            JOptionPane.showMessageDialog(null, ERRO2, ERRO, JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * Metodo utilizado para executar o Grafu Distancia
     *
     * @return void
     */
    public static void processarDIGRAFU() {

		BufferedReader buffer;
		String output = "";
    	pegaCaminho();
    	
    	//String linhaExecucao = pegaCaminho + corrigeCaminho + "/programas/digrafu/Run.pl "
    	//					   + ControladorDIGRAFU.guardaNomeSequencia + ControladorDIGRAFU.guardaArquivo;

        try {
        	
        	/*
        	 * Execução do DiGrafu
        	 */
        	if(ManipulaArquivo.existeArquivo(pegaCaminho + "/arquivos_saida/digrafu/out_" + ControladorConversor.arquivoSaida))
        		ManipulaArquivo.deletaArquivo(pegaCaminho + "/arquivos_saida/digrafu/out_" + ControladorConversor.arquivoSaida);
        	
        	System.out.println("\nLog - DiGrafu executado sequencialmente:\n" + (pegaCaminho) + (corrigeCaminho) + ("/programas/digrafu/Run.pl ")
					   + (ControladorDIGRAFU.guardaNomeSequencia) + (ControladorDIGRAFU.guardaArquivo));
        	digrafu = Runtime.getRuntime().exec((pegaCaminho) + (corrigeCaminho) + ("/programas/digrafu/Run.pl ")
					   + (ControladorDIGRAFU.guardaNomeSequencia) + (ControladorDIGRAFU.guardaArquivo));
        	
        	buffer = new BufferedReader(new InputStreamReader(digrafu.getInputStream()));
        	digrafu.waitFor();

        	int count = 0;
			String tempout = buffer.readLine();
			while( (tempout != null) && (count < 6) ){
				output += tempout + "\n";
				tempout = buffer.readLine();
				count++;
			}

			buffer=null;
			
            digrafu.destroy();
            
            if(output != ""){
            	JOptionPane.showMessageDialog(null, output, ERRO, JOptionPane.ERROR_MESSAGE);
            }
            else{
            
	            if(ControladorDIGRAFU.perfil == true) {
					ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorDIGRAFU.nomePerfil);
					ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorDIGRAFU.nomePerfil, ((pegaCaminho) + (corrigeCaminho) + ("/programas/digrafu/Run.pl INPUT ")));
	            	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorDIGRAFU.nomePerfil, (ControladorDIGRAFU.guardaArquivo));
	            }
	            ControladorDIGRAFU.perfil = false;
	
	            JOptionPane.showMessageDialog(null, EXEC_DIGRAFU, EXEC_DIGRAFU_1, JOptionPane.INFORMATION_MESSAGE);
	            
            }
            
        }
        catch(Exception expection) {
            JOptionPane.showMessageDialog(null, ERRO2, ERRO, JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * Metodo utilizado para executar o SEQBOOT-DIGRAFU-sequencial
     *
     * @return void
     */
    public static void processarSeqbootDIGRAFUSequencial() {
    	pegaCaminho();

    	try {
    		String inicio = "cd " + pegaCaminho + "/programas/jack/ ; " + (pegaCaminho + corrigeCaminho + "jre/bin/java ") + "DigrafuSequencial ";
    		String seqboot = pegaCaminho + "/programas/seqboot/seqboot " + (ControladorSeqboot.guardaNomeSequencia) + ControladorSeqboot.trataParametrosSeqboot + " ";
    		String digrafuSeqboot = "";
    		String consense = pegaCaminho + "/programas/consense/consense " +	ControladorSeqboot.trataParametrosConsense;

                if(ControladorIGrafu.digrafu.getComboModoExecucaoSequencial().getSelectedItem() !=
                	ControladorIGrafu.digrafu.getComboModoExecucaoSequencial().getItemAt(0)) {

                	inicio = "ssh " + ControladorIGrafu.phyml.getJComboBoxTipoExecucaoSequencial().getSelectedItem() + " ; " +
       			 			 "cd " + pegaCaminho + "/programas/jack/ ; " + (pegaCaminho + corrigeCaminho + "jre/bin/java ") + "DigrafuSequencial ";

                	consense = pegaCaminho + "/programas/consense/consense " +	ControladorSeqboot.trataParametrosConsense + " ; exit";

                	digrafuSeqboot += ((pegaCaminho) + (corrigeCaminho) + ("/programas/digrafu/Run.pl ") +  (ControladorDIGRAFU.guardaArquivo) + " ");

                }
                else {
                	digrafuSeqboot += ((pegaCaminho) + (corrigeCaminho) + ("/programas/digrafu/Run.pl ") +  (ControladorDIGRAFU.guardaArquivo) + " ");

                }

                String comando = inicio + seqboot + digrafuSeqboot + consense;

        		if(ManipulaArquivo.existeArquivo("exec_digrafu_bootstrap_sequencial.sh")) {
        			ManipulaArquivo.deletaArquivo("exec_digrafu_bootstrap_sequencial.sh");
        		}

        		ManipulaArquivo.gravaArquivo( "exec_digrafu_bootstrap_sequencial.sh", comando );

        		System.out.println("Log - DiGrafu executado com bootstrap sequencial:\n" + comando);
        		seqbootDIGRAFU = Runtime.getRuntime().exec("chmod 777 exec_digrafu_bootstrap_sequencial.sh");
        		seqbootDIGRAFU = Runtime.getRuntime().exec("./exec_digrafu_bootstrap_sequencial.sh");

        		seqbootDIGRAFU.waitFor();
        			JOptionPane.showMessageDialog(null, "DiGrafu com bootstrap terminou a execução!", "DiGrafu - bootstrap", JOptionPane.INFORMATION_MESSAGE);
        			if(ControladorDIGRAFU.perfil == true) {
        				ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + "nomes_perfil", ControladorDIGRAFU.nomePerfil);
        				ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorDIGRAFU.nomePerfil, (inicio + pegaCaminho + "/programas/seqboot/seqboot "));
                    	ManipulaArquivo.gravaArquivo(pegaCaminho + (corrigeCaminho) + "/perfil/" + ControladorDIGRAFU.nomePerfil, (ControladorSeqboot.trataParametrosSeqboot + " " + digrafuSeqboot + consense));
                    }
                    ControladorDIGRAFU.perfil = false;
            	seqbootDIGRAFU.destroy();

    	}
    	catch(Exception expection) {
            JOptionPane.showMessageDialog(null, ERRO2, ERRO, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo utilizado para executar o HyperTree sem bootstrap
     *
     * @return void
     */
    public static void processarHyperTreePHYML() {
    	pegaCaminho();

    	Thread threadHyperTreePHYML = new Thread(new Runnable() {
			public void run() {
				try {

		        	if(!(ManipulaArquivo.existeArquivo(GerarParametrosConversor.arvore))) {

                                    System.out.println(("Log - phyml - Sequence file - HyperTree (no file): "+GerarParametrosConversor.arvore));

		        		hypertree = Runtime.getRuntime().exec((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar"));
//		        		hypertree = Runtime.getRuntime().exec(("java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar"));

		        	}
		            else {

		            	System.out.println(("Log - phyml - Sequence file - HyperTree: " + GerarParametrosConversor.arvore));
                                System.out.println((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
		                + GerarParametrosConversor.arvore);

		            	hypertree = Runtime.getRuntime().exec((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
		                + GerarParametrosConversor.arvore);
//		            	hypertree = Runtime.getRuntime().exec(("java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
//		                + nomeArquivoSequencia + "_phyml_tree.txt");


		            }
		        	try {
		    			hypertree.waitFor();
		    		} catch (InterruptedException e) {
		    			e.printStackTrace();
		    		}
		        }
		        catch(Exception expection) {

		        		JOptionPane.showMessageDialog(null, ERRO3, ERRO, JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
    	threadHyperTreePHYML.setPriority(10);
    	threadHyperTreePHYML.start();
    }

    /**
     * Metodo utilizado para executar o HyperTree depois do phyml com bootstrap
     *
     * @return void
     */
    public static void processarHyperTreePHYMLBootstrap() {
    	pegaCaminho();

    	Thread threadHyperTreePHYML = new Thread(new Runnable() {
			public void run() {
				try {

		        	if(!(ManipulaArquivo.existeArquivo(ControladorIGrafu.seqboot.getJTextFieldArvore().getText())) ) {

		        		hypertree = Runtime.getRuntime().exec((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar"));
//		        		hypertree = Runtime.getRuntime().exec(("java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar"));

		        	}
		            else {

		            	System.out.println(("Log - phyml - Sequence file - HyperTree: " + ControladorIGrafu.seqboot.getJTextFieldArvore().getText()));

		            	hypertree = Runtime.getRuntime().exec((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
		                + ControladorIGrafu.seqboot.getJTextFieldArvore().getText());
//		            	hypertree = Runtime.getRuntime().exec(("java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
//		                + nomeArquivoSequencia + "_phyml_tree.txt");


		            }
		        	try {
		    			hypertree.waitFor();
		    		} catch (InterruptedException e) {
		    			e.printStackTrace();
		    		}
		        }
		        catch(Exception expection) {

		        		JOptionPane.showMessageDialog(null, ERRO3, ERRO, JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
    	threadHyperTreePHYML.setPriority(10);
    	threadHyperTreePHYML.start();
    }

    /**
     * Metodo utilizado para executar o HyperTree
     *
     * @return void
     */
    public static void processarHyperTreeDIGRAFU() {
    	pegaCaminho();

    	Thread threadHyperTreeDIGRAFU = new Thread(new Runnable() {
			public void run() {
				try {

                                     System.out.println(("Emitindo permissão ao java.\nchmod 777 "+ Processo.corrigeCaminho + "/jre/bin/java"));
                                    hypertree = Runtime.getRuntime().exec(("chmod 777 "+ Processo.corrigeCaminho + "/jre/bin/java"));

		        	if(!(ManipulaArquivo.existeArquivo(ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().getText() + "/out_" + ControladorConversor.arquivoSaida))) {

		        		hypertree = Runtime.getRuntime().exec((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar"));
//		        		hypertree = Runtime.getRuntime().exec(("java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar"));


		        	}
		            else {
		            	System.out.println(("Log - DiGrafu - Sequence file - HyperTree: " + ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().getText() + "/out_" + ControladorConversor.arquivoSaida));

		            	hypertree = Runtime.getRuntime().exec((pegaCaminho + corrigeCaminho + "jre/bin/java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
		                + ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().getText() + "/out_" + ControladorConversor.arquivoSaida);

//		            	hypertree = Runtime.getRuntime().exec(("java -jar ") + (pegaCaminho) + (corrigeCaminho) + ("/programas/hypertree/HyperTree.jar ")
//		            	+ pegaCaminho + "arquivos_saida/digrafu/" + "out_" + ControladorJanelaTeste.arquivoSaida);


		            }
		        	try {
		    			hypertree.waitFor();
		    		} catch (InterruptedException e) {
		    			e.printStackTrace();
		    		}

		        }
		        catch(Exception expection) {

		        		JOptionPane.showMessageDialog(null, ERRO3, ERRO, JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
    	threadHyperTreeDIGRAFU.setPriority(10);
    	threadHyperTreeDIGRAFU.start();


    }

    /*
     * Metodo utilizado para traduzir Portugues/Ingles
     */
    public static void traduzir() {
    	ERRO = Tradutor.traduzir("Erro", "Error");

    	ERRO1 = Tradutor.traduzir("Não foi possível executar o PHYML!", "Was not possible to execute the PHYML!");

    	ERRO2 = Tradutor.traduzir("Não foi possível executar o DIGRAFU!", "Was not possible to execute the DIGRAFU!");

    	ERRO3 = Tradutor.traduzir("Não foi possível executar o HyperTree!", "Was not possible to execute the HyperTree!");

    	EXEC_PHYML = Tradutor.traduzir("PHYML terminou de ser executado!", "PHYML finished to be executed!");

    	EXEC_PHYML_1 = Tradutor.traduzir("Execução - PHYML", "Execution - PHYML");

    	EXEC_DIGRAFU = Tradutor.traduzir("DIGRAFU terminou de ser executado!", "DIGRAFU finished to be executed!");

    	EXEC_DIGRAFU_1 = Tradutor.traduzir("Execução - DIGRAFU", "Execution - DIGRAFU");

    	PERFIL = Tradutor.traduzir("Perfil executado com sucesso!", "profile Successfully executed!");

    	PERFIL_EXECUCAO = Tradutor.traduzir("Execução do Perfil", "Profile execution");

    	ERRO_PERFIL = Tradutor.traduzir("Não foi possível executar!", "Was not possible execute!");
    }

    public static void execucaoPerfil() {
    	if(ManipulaArquivo.existeArquivo("executa_perfil.sh")) {
			ManipulaArquivo.deletaArquivo("executa_perfil.sh");
		}

    	try {
    		ManipulaArquivo.gravaArquivo( "executa_perfil.sh", (ManipulaArquivo.leLinha("perfil/" +
    				ControladorIGrafu.modoExecucao.getJComboBoxExecucaoPerfil().getSelectedItem(), 0)) +
    				(ControladorIGrafu.modoExecucao.getJTextFieldArquivoSequencia().getText()) +
    				(ManipulaArquivo.leLinha("perfil/" + ControladorIGrafu.modoExecucao.getJComboBoxExecucaoPerfil().getSelectedItem(), 1)));

    		System.out.println("Log - Execução automática:\n" + (ManipulaArquivo.leLinha("perfil/" +
    				ControladorIGrafu.modoExecucao.getJComboBoxExecucaoPerfil().getSelectedItem(), 0)) +
    				(ControladorIGrafu.modoExecucao.getJTextFieldArquivoSequencia().getText()) +
    				(ManipulaArquivo.leLinha("perfil/" + ControladorIGrafu.modoExecucao.getJComboBoxExecucaoPerfil().getSelectedItem(), 1)));

    		execucaoAutomatica = Runtime.getRuntime().exec("chmod 777 executa_perfil.sh");
    		execucaoAutomatica = Runtime.getRuntime().exec("./executa_perfil.sh");

    		execucaoAutomatica.waitFor();
    		JOptionPane.showMessageDialog(null, PERFIL, PERFIL_EXECUCAO, JOptionPane.INFORMATION_MESSAGE);
    		if(ManipulaArquivo.existeArquivo("executa_perfil.sh")) {
    			ManipulaArquivo.deletaArquivo("executa_perfil.sh");
    		}
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(null, ERRO_PERFIL, PERFIL_EXECUCAO, JOptionPane.ERROR_MESSAGE);
		}

    }

    /**
     * Metodo utilizado para retornar o local onde a IGRAFU 2.0 está instalada
     */
    public static void pegaCaminho() {
    	File file = new File( "pegaCaminho.txt" );

    	pegaCaminho = caminho(file.getAbsolutePath());

    	ManipulaArquivo.deletaArquivo("pegaCaminho.txt");

    	traduzir();
    }

    /*
     * Metodo para nao permitir caracteries iguais no campo
     */
    public static String caminho(String str) {
    	String aux = "";
    	String caminho = "";

    	for(int i = 1; i <= str.length(); i++) {

    		if(str.substring(i - 1, i).equals("/")) {
    			caminho = aux + "/";
    		}

    		aux = str.substring(0, i);
    	}

    	return caminho;
    }

}