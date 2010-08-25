/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesc.computacao.estagio.aplicacao.controlador;
import br.uesc.computacao.estagio.aplicacao.util.Navegar;
import br.uesc.computacao.estagio.aplicacao.util.ManipulaArquivo;
import br.uesc.computacao.estagio.aplicacao.util.Processo;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author maranduba
 */
public  class GerarParametrosConversor {
    public static int arqEntrada = 0;
    public static String arqConvertidoPath;
    public static String pathOriginal;
    public static String extConversor="";

    public static String caminhoEntrada, caminhoSaida;
    public static String arvore;



    public static String ChamaConversorIGrafu(){
    	int converterPara = 1;
        Processo.pegaCaminho();
        
        if(ControladorConversor.novoArquivo == false){
            System.out.print("\n\nARQUIVO JÁ CONVERTIDO, NÃO SE REALIZA CONVERSÃO\n\n");
           return ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText();
        }
        
       switch(arqEntrada){
           case 1:arqConvertidoPath = ReadSeqIGrafu();;break; //ACEDB
           case 2:arqConvertidoPath = ReadSeqIGrafu();break; //Clustal
           case 3:arqConvertidoPath = ReadSeqIGrafu();;break;//EMBL
           case 4:arqConvertidoPath = DataConvertIGrafu(converterPara);break;//Fasta
           case 5:arqConvertidoPath = ReadSeqIGrafu();break;//GenBank
           case 6:arqConvertidoPath = DataConvertIGrafu(converterPara);break;//Mega
           case 7:arqConvertidoPath = ReadSeqIGrafu();;break;//MSF
           case 8:arqConvertidoPath = ReadSeqIGrafu();;break;//NBRF
           case 9:arqConvertidoPath = DataConvertIGrafu(converterPara);break;//Nexus
           case 10:return Navegar.file.getPath();//Phylip sequencial, não faz nada
           case 11:arqConvertidoPath = DataConvertIGrafu(converterPara);break;//Philip intercalado
           case 12:arqConvertidoPath = ReadSeqIGrafu();;break;//Pir
           case 13:arqConvertidoPath = ReadSeqIGrafu();;break;//Plain
           case 14:arqConvertidoPath = ReadSeqIGrafu();;break;//Stanford
           case 15:arqConvertidoPath = ReadSeqIGrafu();break; // XML


       }
       
       ControladorConversor.novoArquivo = false;
       System.out.println("\n\nO arquivo é novo =" + ControladorConversor.novoArquivo);
       
       // ManipulaArquivo.deletaArquivo(pathSaidaReadSeq);
       return arqConvertidoPath;
    }
//////////////////////////////////////////////////////////////////////////////////////

    public static String DataConvertIGrafu(int converterPara){
        Process dataConvert;
        String pathSaidaDataConvert="";
        String formatoSaida="";

        System.out.println("Utilizando o DataConvert");


        pathOriginal = ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText();
        //pathSaidaDataConvert = ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText();

        if(converterPara == 1){
            formatoSaida = "phylip";
        }


         File entrada = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());

        if(ControladorIGrafu.programas.getJRadioButtonDIGRAFU().isSelected()){
            pathSaidaDataConvert = ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().getText() +
                               "/"+entrada.getName();
        }
        else
            if(ControladorIGrafu.programas.getJRadioButtonPHYML().isSelected()){
                pathSaidaDataConvert = ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().getText() +
                               "/"+entrada.getName();
            }


        try {
            dataConvert = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    (formatoSaida) + (" -i ") +
                    (pathOriginal) + (" -o ") +
                    (pathSaidaDataConvert+"_convertido."+formatoSaida));
            dataConvert.waitFor();

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                   (formatoSaida) + (" -i ") +
                    (pathOriginal) + (" -o ") +
                    (pathSaidaDataConvert+"_convertido."+formatoSaida));
            dataConvert.waitFor();

            } catch (IOException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }
        File file = new File(pathSaidaDataConvert+"_convertido.phylip");
        file.deleteOnExit();

         return (pathSaidaDataConvert+"_convertido.phylip");
    }
///////////////////////////////////////////////////////////////////////////////////////////

    public static String ReadSeqIGrafu(){
        Process readSeq;
        Process dataConvert;
        String pathSaidaReadSeq="";
        int formatoEntrada = retornaFormatoIGrafuEntrada();

        System.out.println("Utilizando o ReadSeq");
        
        pathOriginal = ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText();
        //pathSaidaReadSeq = ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText();
        
        File entrada = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());

        if(ControladorIGrafu.programas.getJRadioButtonDIGRAFU().isSelected()){
            pathSaidaReadSeq = ControladorIGrafu.conversor.getJTextFieldSalvarSaidaDigrafu().getText() +
                               "/"+entrada.getName();
        }
        else
            if(ControladorIGrafu.programas.getJRadioButtonPHYML().isSelected()){
                pathSaidaReadSeq = ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml().getText() +
                               "/"+entrada.getName();
            }

        
        try {
            readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    ("NEXUS ") + ("-inform="+formatoEntrada) + (" -o ") +
                    (pathSaidaReadSeq +"_aux.nexus ") + //Saida auxiliar
                    (pathOriginal) ); //Entrada

            readSeq.waitFor();

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                   (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                   ("NEXUS ") + ("-inform="+formatoEntrada) + (" -o ") +
                   (pathSaidaReadSeq +"_aux.nexus ") +
                   (pathOriginal) );

            //pathSaidaReadSeq = (pathSaidaReadSeq +"_aux.nexus").toString();

            dataConvert = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    ("phylip") + (" -i ") +
                   (pathSaidaReadSeq +"_aux.nexus") + (" -o ") +
                   (pathSaidaReadSeq+"_convertido.phylip"));

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    ("phylip") + (" -i ") +
                   (pathSaidaReadSeq +"_aux.nexus") + (" -o ") +
                   (pathSaidaReadSeq+"_convertido.phylip"));

            //pathOriginal = pathOriginal+"_converted.phylip";

        } catch (IOException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }

        // ManipulaArquivo.deletaArquivo(pathSaidaReadSeq+"_aux.nexus");

        File file = new File(pathSaidaReadSeq+"_convertido.phylip");
        file.deleteOnExit();
         
         File file2 = new File(pathSaidaReadSeq+"_aux.nexus");
         file2.deleteOnExit();
         
         return (pathSaidaReadSeq+"_convertido.phylip");
        //return "";
    }
    
/////////////////////////////////////////////////////////////////////////////////////

    public static void ChamaConversorIndependente(){
        Process readSeq, dataConvert;
        
        int formatoEntrada = retornaFormatoConversorReadseqEntrada();
        int formatoSaida = retornaFormatoConversorReadseqSaida();
        
        if((ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 11)){
            try {
                dataConvert = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                        (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                        ("phylip") + (" -i ") +
                        (caminhoEntrada) + (" -o ") +
                        (caminhoSaida +"_aux.phylip"));
                dataConvert.waitFor();

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                        (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                        ("phylip") + (" -i ") +
                        (caminhoEntrada) + (" -o ") +
                        (caminhoSaida +"_aux.phylip"));
            
            readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    (formatoSaida) + (" -inform="+formatoEntrada) + (" -o ") +
                    (caminhoSaida +"."+extConversor) + //Saida
                    (caminhoSaida +"_aux.phylip") ); //Entrada
            readSeq.waitFor();
            
            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    (formatoSaida) + (" -inform="+formatoEntrada) + (" -o ") +
                    (caminhoSaida +"."+extConversor) + //Saida
                    (caminhoSaida +"_aux.phylip") ); //Entrada
            
            ManipulaArquivo.deletaArquivo(caminhoSaida +"_aux.phylip");

            } catch (IOException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }
        }
        else{
            if(ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex() == 10){
                 try {
                
            readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    ("17") + (" -inform="+formatoEntrada) + (" -o ") +
                    (caminhoSaida +"_aux.nexus") + //Saida
                    (caminhoEntrada) ); //Entrada
            readSeq.waitFor();
            
            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    ("17") + (" -inform="+formatoEntrada) + (" -o ") +
                    (caminhoSaida +"_aux.nexus") + //Saida
                    (caminhoEntrada) ); //Entrada
            
            dataConvert = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                        (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                        ("mega") + (" -i ") +
                        (caminhoSaida +"_aux.nexus") + (" -o ") +
                        (caminhoSaida +"."+extConversor));
                dataConvert.waitFor();

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                        (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                        ("mega") + (" -i ") +
                        (caminhoSaida +"_aux.nexus") + (" -o ") +
                        (caminhoSaida +"."+extConversor));
            
            ManipulaArquivo.deletaArquivo(caminhoSaida +"_aux.nexus");

            } catch (IOException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }
            }
            else{
                ReadSeqConversorIndependente();
            }
        }
        if(ManipulaArquivo.existeArquivo(caminhoSaida +"."+extConversor)){
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Conversor", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Conversor", JOptionPane.ERROR_MESSAGE);
            }
    }
/////////////////////////////////////////////////////////////////////////////////////
    
    public static void ReadSeqConversorIndependente(){
        Process readSeq;
        Process dataConvert;
        
        int formatoEntrada = retornaFormatoConversorReadseqEntrada();
        int formatoSaida = retornaFormatoConversorReadseqSaida();

        System.out.println("Conversor: ReadSeq");
        
        caminhoEntrada = ControladorIGrafu.conversor.getJTextFieldArquivoEntradaConversor().getText();
        caminhoSaida = ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().getText();
        
        Processo.pegaCaminho();
        
        try {
            readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    (formatoSaida) + (" -inform="+formatoEntrada) + (" -o ") +
                    (caminhoSaida +"."+extConversor) + //Saida
                    (" " +caminhoEntrada) ); //Entrada

            readSeq.waitFor();

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                  (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                  (formatoSaida) + (" -inform="+formatoEntrada) + (" -o ") +
                  (caminhoSaida +"."+extConversor) + //Saida
                  (" " +caminhoEntrada) ); //Entrada
             if(ManipulaArquivo.existeArquivo(caminhoSaida +"."+extConversor)){
                System.out.println("Operação realizada com sucesso! \n Arquivo " + caminhoSaida +"."+extConversor + "criado");
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Conversor de formatos", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!\nVerifique o nome dado ao arquivo de saída.", "Conversor de Formatos", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }

    }

///////////////////////////////////////////////////////////////////////////////
    
    public static void DataConvertConversorIndependente(){
        Process dataConvert;

        
        String formatoSaida = retornaFormatoConversorDataConvertSaida();

        System.out.println("Conversor: DataConvert");

        caminhoEntrada = ControladorIGrafu.conversor.getJTextFieldArquivoEntradaConversor().getText();
        caminhoSaida = ControladorIGrafu.conversor.getJTextFieldArquivoSaidaConversor().getText();

        Processo.pegaCaminho();

        try {

            System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    (formatoSaida) + (" -i ") +
                    (caminhoEntrada) + (" -o ") +
                    (caminhoSaida +"."+extConversor));


            dataConvert = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    (formatoSaida) + (" -i ") +
                    (caminhoEntrada) + (" -o ") +
                    (caminhoSaida +"."+extConversor));
            dataConvert.waitFor();

             if(ManipulaArquivo.existeArquivo(caminhoSaida +"."+extConversor)){
                System.out.println("Operação realizada com sucesso! \n Arquivo criado: " + caminhoSaida +"."+extConversor);
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Conversor de formatos", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!\nVerifique o nome dado ao arquivo de saída.", "Conversor de Formatos", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }

    }

///////////////////////////////////////////////////////////////////////////////

    public static void ComplementoReverso(){
         Process readSeq;
         Process dataConvert;

         try {
             
              System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                   (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                    (retornaFormatoIGrafuEntrada() +" -reverse") + (" -o ") +
                    (ControladorIGrafu.conversor.getJTextFieldComplementoReverso().getText() +"_complemento_reverso.txt ") + //Saida auxiliar
                    (ControladorIGrafu.conversor.getJTextFieldComplementoReverso().getText()) ); //Entrada

            readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                    (retornaFormatoIGrafuEntrada() +" -reverse") + (" -o ") +
                    (ControladorIGrafu.conversor.getJTextFieldComplementoReverso().getText() +"_complemento_reverso.txt ") + //Saida auxiliar
                    (ControladorIGrafu.conversor.getJTextFieldComplementoReverso().getText()) ); //Entrada

            readSeq.waitFor();
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Complemento Reverso", JOptionPane.INFORMATION_MESSAGE);


        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Complemento Reverso", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Complemento Reverso", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }
 
    }

///////////////////////////////////////////////////////////////////////////////
    public static void ListarSequencias(){
         Process readSeq;
         Process dataConvert;
         String entrada;
         String entradaAux;


         entrada = ControladorIGrafu.conversor.getJTextFieldListarSequencia().getText() ;

         try {
             if(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 2){

                 System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    (8) + ("") + (" -o ") +
                    (entrada +"_aux_list_fasta.txt ") + //Saida
                    (entrada) ); //Entrada

                  readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run -f ") +
                    (8) + ("") + (" -o ") +
                    (entrada +"_aux_list_fasta.txt ") + //Saida
                    (entrada) ); //Entrada

            readSeq.waitFor();

             System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                   (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                     ("-list") + (" -o ") +
                    (entrada +"_sequencias.txt ") + //
                    (entrada +"_aux_list_fasta.txt") ); //Entrada

             readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                    ("-list") + (" -o ") +
                    (entrada +"_sequencias.txt ") + //
                    (entrada +"_aux_list_fasta.txt") ); //Entrada

             ManipulaArquivo.deletaArquivo(entrada +"_aux_list_fasta.txt");

             }
             else

             if((ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 6)//mega
                || (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 9) // nexus
                || (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 10)//phylip
                || (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()== 11)){//phylip

                  System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    ("fasta") + (" -i ") +
                    (entrada) + (" -o ") +
                    (entrada +"_aux_list_fasta.txt"));
            

                  dataConvert = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/DataConvert.jar DataConvert.Driver -t ") +
                    ("fasta") + (" -i ") +
                    (entrada) + (" -o ") +
                    (entrada +"_aux_list_fasta.txt"));
            dataConvert.waitFor();

                

                 System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                   (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                     ("-list") + (" -o ") +
                    (entrada +"_sequencias.txt ") + //
                    (entrada +"_aux_list_fasta.txt") ); //Entrada

             readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                    ("-list") + (" -o ") +
                    (entrada +"_sequencias.txt ") + //
                    (entrada +"_aux_list_fasta.txt") ); //Entrada

            readSeq.waitFor();

            ManipulaArquivo.deletaArquivo(entrada +"_aux_list.txt");

             }
        
                
             else{
                 System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                         (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                         ("-list") + (" -o ") +
                         (entrada +"_sequencias.txt ") + //
                         (entrada) ); //Entrada

                 readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                    ("-list") + (" -o ") +
                    (entrada +"_sequencias.txt ") + //
                    (entrada) ); //Entrada
                 
                 readSeq.waitFor();

             }

             JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Listar Sequências", JOptionPane.INFORMATION_MESSAGE);
             ManipulaArquivo.deletaArquivo(entrada +"_aux_list.txt");
      


        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Listar Sequências", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Listar Sequências", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }

         
    }

///////////////////////////////////////////////////////////////////////////////
    public static void ObterChecksum(){
         Process readSeq;

         try {

                System.out.println((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                   (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                     ("-ch") + (" -o ") +
                    (ControladorIGrafu.conversor.getJTextFieldCheckSum().getText() +"_checksum.txt ") + //Saida auxiliar
                    (ControladorIGrafu.conversor.getJTextFieldCheckSum().getText()) ); //Entrada

            readSeq = Runtime.getRuntime().exec((Processo.pegaCaminho + Processo.corrigeCaminho+"/jre/bin/java -cp ") +
                    (Processo.pegaCaminho + Processo.corrigeCaminho+"/programas/conversor/readseq.jar run ") +
                    ("-ch") + (" -o ") +
                    (ControladorIGrafu.conversor.getJTextFieldCheckSum().getText() +"_checksum.txt ") + //Saida auxiliar
                    (ControladorIGrafu.conversor.getJTextFieldCheckSum().getText()) ); //Entrada

            readSeq.waitFor();

           JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Checksum", JOptionPane.INFORMATION_MESSAGE);

          

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Checksum", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "A operação não pode ser realizada!", "Checksum", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
            }
    }

///////////////////////////////////////////////////////////////////////////////

    public static int retornaFormatoIGrafuEntrada(){
         int saida=0;
         switch(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaSequencia().getSelectedIndex()){
           case 1: saida = 25;break; //ACEDB
           case 2: saida = 22;break; //Clustal
           case 3: saida = 4;break;//EMBL
           case 4: saida = 8;break;//Fasta
           case 5: saida = 2;break;//GenBank
           //case 6: saida = ;break;//Mega
           case 7: saida = 15;break;//MSF
           case 8: saida = 3;break;//NBRF
           case 9: saida = 17;break;//Nexus
           case 10: saida = 12;break;//Phylip sequencial, não faz nada
           case 11: saida = 12;break;//Philip intercalado
           case 12: saida = 14;break;//Pir
           case 13: saida = 13;break;//Plain
           case 14: saida = 1;break;//Stanford
           case 15: saida = 19;break; // XML

       }
         return saida;
    }
///////////////////////////////////////////////////////////////////////////////

    public static int retornaFormatoConversorReadseqEntrada(){
         int saida=0;
         switch(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex()){
           case 1: saida = 25;break; //ACEDB
           case 2: saida = 20;break; //Blast
           case 3: saida = 22;break; //Clustal
           case 4: saida = 6;break; //DNAStrider
           case 5: saida = 4;break;//EMBL
           case 6: saida = 8;break;//Fasta
           case 7: saida = 23;break;//FlatFeat
           case 8: saida = 5;break; //GCG
           case 9: saida = 24; break;//GFF
           case 10: saida = 2;break;//GenBank
           case 11: saida = 15;break;//MSF
           case 12: saida = 3;break;//NBRF
           case 13: saida = 17;break;//Nexus
           case 14: saida = 14;break;//Pir
           case 15: saida = 12;break;//Phylip sequencial, não faz nada
           case 16: saida = 13;break;//Plain
           case 17: saida = 1;break;//Stanford
           case 18: saida = 19;break; // XML

       }
         return saida;


    }

///////////////////////////////////////////////////////////////////////////////

    public static int retornaFormatoConversorReadseqSaida(){
         int saida=0;
         switch(ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex()){
           case 1: saida = 25;extConversor="ACEDB";break; //ACEDB
           case 2: saida = 22;extConversor="Clustal";break; //Clustal
           case 3: saida = 6;extConversor="DNAStrider";break; //DNAStrider
           case 4: saida = 4;extConversor="EMBL";break;//EMBL
           case 5: saida = 8;extConversor="Fasta";break;//Fasta
           case 6: saida = 23;extConversor="FlatFeat";break;//FlatFeat
           case 7: saida = 5;extConversor="GCG";break; //GCG
           case 8: saida = 24;extConversor="GFF";break;//GFF
           case 9: saida = 2;extConversor="GanBank";break;//GenBank
           case 10: saida = 15;extConversor="MSF";break;//MSF
           case 11: saida = 3;extConversor="NBRF";break;//NBRF
           case 12: saida = 17;extConversor="Nexus";break;//Nexus
           case 13: saida = 14;extConversor="Pir";break;//Pir
           case 14: saida = 12;extConversor="Phylip";break;//Phylip sequencial, não faz nada
           case 15: saida = 13;extConversor="Plain";break;//Plain
           case 16: saida = 18;extConversor="Pretty";break;//Pretty
           case 17: saida = 1;extConversor="Stanford";break;//Stanford
           case 18: saida = 19;extConversor="XML";break; // XML

       }
         return saida;

    }

///////////////////////////////////////////////////////////////////////////////

    public static String retornaFormatoConversorDataConvertSaida(){
         String saida = "";
         switch(ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex()){
           case 1: saida = "aln";extConversor="Clustal";break; //Clustal
           case 2: saida = "fasta";extConversor="Fasta";break; //Fasta
           case 3: saida = "mega";extConversor="Mega";break; //Mega
           case 4: saida = "nexus";extConversor="Nexus";break; //Nexus
           case 5: saida = "phylip";extConversor="Phylip";break;//Phylip
           case 19: saida = "mega";extConversor="Mega";break; //Mega
       }
         return saida;
    }

///////////////////////////////////////////////////////////////////////////////

    public static void criaComboBoxDataConvert(){
    ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().setEnabled(true);
    if((ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex()==0) ||
        (ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getItemCount()!=6)){
        limpaComboBox();
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Selecione um tipo...");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Clustal");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Fasta");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("MEGA");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("NEXUS");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Phylip");
    }

}

///////////////////////////////////////////////////////////////////////////////

    public static void criaComboBoxReadSeq(){
    ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().setEnabled(true);
    if((ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getSelectedIndex()==0) ||
        (ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().getItemCount()!=19)){
        limpaComboBox();
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Selecione um tipo...");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("ACEDB");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Clustal");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("DNAStrider");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("EMBL");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Fasta");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("FlatFeat");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("GCG");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("GFF");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("GenBank");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("MSF");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("NBRF");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("NEXUS");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("PIR");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Phylip");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Plain");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Pretty");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("Stanford");
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("XML");
    }
}

///////////////////////////////////////////////////////////////////////////////

    public static void criaComboBoxSaidaConversor(){
        ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().setEnabled(true);

        if((ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 3) || // Clustal
            (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 6) || // Fasta
            (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 14) || // Nexus
            (ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 16)){ // Phylip

            criaComboBoxReadSeq();
            ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().addItem("MEGA");//19

        }
        else{
            if(ControladorIGrafu.conversor.getJComboBoxTipoDadoEntradaConversor().getSelectedIndex() == 11){
                criaComboBoxDataConvert();
            }
            else{
                criaComboBoxReadSeq();
            }
        }





    }
 

///////////////////////////////////////////////////////////////////////////////

   public static void limpaComboBox(){
    ControladorIGrafu.conversor.getJComboBoxTipoDadoSaidaConversor().removeAllItems();
}


///////////////////////////////////////////////////////////////////////////////
    
  public static void movePHYML(){
      // Processo.pegaCaminho();
       File[] file=null;

       System.out.println("Arquivo: "+ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_lk.txt");
       System.out.println("Novo local:"+ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml()  + Navegar.file.getName()+"_phyml_lk.txt");

       file[0] = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_lk.txt");
       file[0].renameTo(new File(ControladorIGrafu.conversor.getJTextFieldSalvarSaidaPhyml() + Navegar.file.getName()+"_phyml_lk.txt"));

      //file[0] = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_boot_stats.txt");
      //file[0].renameTo(new File(Processo.pegaCaminho + Processo.corrigeCaminho+file[0].getName()+"/arquivos_saida/phyml"));

   //   file[1] = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_boot_trees.txt");
   //   file[1].renameTo(new File(Processo.pegaCaminho + Processo.corrigeCaminho+file[1].getName()+"/arquivos_saida/phyml"));

   //   file[2] = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_boot_lk.txt");
   //   file[2].renameTo(new File(Processo.pegaCaminho + Processo.corrigeCaminho+file[2].getName()+"/arquivos_saida/phyml"));

   //   file[3] = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_boot_stat.txt");
   //   file[3].renameTo(new File(Processo.pegaCaminho + Processo.corrigeCaminho+file[3].getName()+"/arquivos_saida/phyml"));

    //  file[4] = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText()+"_phyml_boot_tree.txt");
   //   file[4].renameTo(new File(Processo.pegaCaminho + Processo.corrigeCaminho+file[4].getName()+"/arquivos_saida/phyml"));



                 
    }
    
///////////////////////////////////////////////////////////////////////////////    

public static void moveArquivo(String arquivo, String saida){
    Process mover;
    File teste;

try {
            if(!saida.isEmpty()){
            mover = Runtime.getRuntime().exec(("mv ")+(arquivo +"_phyml_boot_stats.txt ")+(saida));
            mover = Runtime.getRuntime().exec(("mv ")+(arquivo +"_phyml_boot_trees.txt ")+(saida));
            mover = Runtime.getRuntime().exec(("mv ")+(arquivo +"_phyml_lk.txt ")+(saida));
            mover = Runtime.getRuntime().exec(("mv ")+(arquivo +"_phyml_stat.txt ")+(saida));
            mover = Runtime.getRuntime().exec(("mv ")+(arquivo +"_phyml_tree.txt ")+(saida));
            mover.waitFor();

            System.out.println(("mv ")+(arquivo +"_phyml_boot_stats.txt ")+(saida));
            System.out.println(("mv ")+(arquivo +"_phyml_boot_trees.txt ")+(saida));
            System.out.println(("mv ")+(arquivo +"_phyml_lk.txt ")+(saida));
            System.out.println(("mv ")+(arquivo +"_phyml_stat.txt ")+(saida));
            System.out.println(("mv ")+(arquivo +"_phyml_tree.txt ")+(saida));

            teste = new File(ControladorIGrafu.conversor.getJTextFieldArquivoEntrada().getText());
            arvore = saida +"/"+ teste.getName() + "_phyml_tree.txt";
            }

          } catch (IOException ex) {
            System.out.println("Erro na execução do comando:\n" + ex.getMessage());
        } catch (InterruptedException ex) {
                System.out.println("Erro na execução do comando:\n" + ex.getMessage());
        }

}

}