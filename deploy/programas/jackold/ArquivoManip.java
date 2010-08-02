	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Vector;
	/**
	 * @author JACKELINE
	 * 
	 */
public class ArquivoManip {

	    /**
		 * Retorna um Vector contendo todo o conteudo do arquivo fileName, sendo
		 * que cada posicao do Vector representa um conjunto do arquivo.
		 * 
		 * @param String
		 * @exception IOException
		 * @exception
		 * @return Vector
		 */
	    public Vector getFileVector( String fileName )
	    { 
	    	String texto,marcador;
	        Vector<String> conteudo =new Vector<String>();
	        
	        File file = new File( fileName );
	        if( file.exists() ) {
	        	try {
	                BufferedReader in = new BufferedReader( new FileReader( fileName ) );
	                StringBuffer buffer = new StringBuffer();
	                
	                texto=in.readLine();
	                marcador =new String(texto);
	                buffer.append(marcador+"\n");
	                
	                while( (texto = in.readLine()) != null ) {
	                	if(texto.equals(marcador)) {	                		
	                		conteudo.addElement( new String(buffer.toString())); 		
	              	        buffer.delete(0,buffer.capacity());
	               	     }
	                 buffer.append( texto+"\n" );	                	
	                }
	                conteudo.add( new String(buffer.toString())); 
	                in.close();
	            }
	            catch( IOException ioe ){
	                ioe.printStackTrace();
	                System.out.println(" Erro 01 - Nao foi possivel ler o arquivo \n'");
	            }
	    		catch( Exception e ) {
	    			e.printStackTrace();
	    			System.out.println(" Erro 02 - Nao foi possivel ler o arquivo \n'");
	    		}
	        } else {
	        	System.out.println(" Erro 03 - Nao foi possivel encontrar o arquivo "+ fileName +"\n"); 
	        	}
	        
	        return conteudo;
	    }
	    
	    public Vector getFileLine( String fileName )
	    { 
	    	String texto;
	        Vector<String> conteudo =new Vector<String>();
	        
	        File file = new File( fileName );
	        if( file.exists() ) {
	        	try {
	                BufferedReader in = new BufferedReader( new FileReader( fileName ) );
	                	               
	                while( (texto = in.readLine()) != null ) {	                		
	                		conteudo.add( texto); 		
	              	 }
	                in.close();             	
	                	                
	            }
	            catch( IOException ioe ){
	                ioe.printStackTrace();
	                System.out.println(" Erro 01 - Nao foi possivel ler o arquivo \n'");
	            }
	    		catch( Exception e ) {
	    			e.printStackTrace();
	    			System.out.println(" Erro 02 - Nao foi possivel ler o arquivo \n'");
	    		}
	        } else {
	        	System.out.println(" Erro 03 - Nao foi possivel encontrar o arquivo "+ fileName +"\n"); 
	        	}
	        
	        return conteudo;
	    }
	 
	    /**
		 * CRIA ARQUIVOS acrescentando no nome um numero e copia conteudo do
		 * vetor.
		 * 
		 * @exception IOException
		 * @param Vector
		 * @return Vector
		 * @throws Exception
		 */
	    public void newFileOut3(Vector vetor, String diret, int pc) throws Exception
	    {   
	       int elementos, tamanho;
	       
	       tamanho= vetor.size();
		   elementos= tamanho/pc;
		   String outfile = "",texto = "";
			  
		   try{  
			  	   for(int i=0;i<pc;i++)
		   { 	
	          outfile=diret+"_"+ i ;
	             
	            File file = new File(outfile);               
	                if(file.exists() )
	                   file.delete() ;
	              
	                 file.createNewFile();
	                 
	                 
	                for(int k=i*elementos;k<((i+1)*elementos);k++)
	                  texto+=  (String)vetor.get(k)+"\n";
	          
	                addToFile(texto, file);
	            texto = "";      
	           
		   }
		   
		   if(tamanho%pc != 0)
		   {// possui resto
			 for(int l=elementos*pc;l<tamanho;l++)
			   texto+=  (String)vetor.get(l)+"\n";
			File ultimo = new File(outfile); 		   
		    addToFile(texto, ultimo);
		   }
		   }catch(IOException ioex){
	           ioex.printStackTrace();
	     }
		  
	}
	    
	    public String[] newFileOut2(Vector vetor, String diret) throws Exception
	    {  
	    	
	       String       outfile      = null;
	       int          elementos    = vetor.size();
		   StringBuffer buffer       = null;	   
		   String[]     arquivoSaida = new String[elementos];
		   
		   for(int i=0;i<elementos;i++)	   {       
	          outfile=diret+"outFile_Sample_0"+ i ;
	          arquivoSaida[i]=outfile;
	          try{          	  
	               File file = new File(outfile);
	               
	                if(file.exists() )
	                   file.delete() ;
	              
	                 file.createNewFile();
	                 buffer=  trataEntrada((String)vetor.get(i));
	                 addToFile(buffer.toString(), file);
	                
	            }catch(IOException ioex){
	            ioex.printStackTrace();
	            }      
	        outfile=null;   
	     } 
		   return arquivoSaida;
	}// fim do metodo
	    
	    public Vector<String> newFileOut(Vector vetor, String diret) throws Exception
	    {   int elementos;
	    
		   elementos= vetor.size();
		   
		   String outfile ;
		   Vector<String> arquivoSaida = new Vector<String>();
		
		   
		   for(int i=0;i<elementos;i++)
		   {       
	       outfile=diret+"outSample_"+ i ;
	       arquivoSaida.add(outfile);  
	          try{ 
	               File file = new File(outfile);
	                              
	                if(file.exists() )
	                   file.delete() ;
	              
	                 file.createNewFile();
	                
	                addToFile((String)vetor.get(i), file);
	              
	                
	      }catch(IOException ioex){
	            ioex.printStackTrace();
	      }
	      
	      outfile="";
	      
	    
	     } 
		   return arquivoSaida;
	}
	    /**
		 * ESCREVE NO ARQUIVO O TEXTO PASSADOS COMO PARAMETROS
		 * 
		 * @exception IOException
		 * @exception Exception
		 * @param STRING,
		 *            STRING
		 * @return VOID
		 */
		public void addToFile(  String texto, File file ) throws Exception
		    {
		       	        
		           try {
		            FileWriter writer = new FileWriter( file, true );
		            PrintWriter saida = new PrintWriter( writer, true );
		            saida.println( texto );
		            saida.close();
		            writer.close();
		        }
		        catch( IOException ioe ) {
		            ioe.printStackTrace();
		            System.out.println(" Erro 04 - Nao foi possivel adicionar o texto ao arquivo \n'");
		        }
				catch( Exception e ) {
					e.printStackTrace();
					System.out.println(" Erro 05 - Nao foi possivel adicionar o texto ao arquivo \n'"); 
				} 
		    }
		 /**
			 * Retorna todo conteudo do arquivo passado como parametro formato
			 * String
			 * 
			 * @exception IOException
			 * @exception Exception
			 * @param STRING
			 * @return String
			 */ 
	    public String getFile(String arq )
	    {
	        String conteudoDoArquivo = null;
	        File file = new File( arq );
	        if( file.exists() ) {
	        	try {
	                BufferedReader in = new BufferedReader( new FileReader( arq ) );
	                String line = null;
	                StringBuffer buffer = new StringBuffer();
	                while( (line = in.readLine()) != null )
	                   buffer.append( line + "\n");
	                in.close();
	                conteudoDoArquivo = buffer.toString();
	            }
	            catch( IOException ioe ){
	                ioe.printStackTrace();
	                System.out.println("Erro 06 - Nao foi possivel ler o arquivo " +arq+" \n");
	            }
	    		catch( Exception e ) {
	    			e.printStackTrace();
	    			System.out.println(" Erro 07 - Nao foi possivel ler o arquivo \n");
	    		}
	        } else {
	        	System.out.println(" Erro 08 - Nao foi possivel ler o arquivo " +arq+" \n"); 
	        }
	        
	        return conteudoDoArquivo;
	    }
		/**
		 * Cria um unico arquivo com o nome passado como parametro contendo
		 * conteudo de todos arquivos contido na lista.
		 * 
		 * @exception IOException
		 * @exception Exception
		 * @param String,
		 *            Vector
		 * @return void
		 */ 
	    public  String UnicoArq( String diretorio, Vector nomes) throws Exception{
	    	
			  int tamanho=nomes.size();
						  
			  try{ 
	            File file = new File(diretorio+"tree_Mult");
	               if(file.exists() )
	                     file.delete() ;               
	               file.createNewFile();
	               for(int i=0; i<tamanho;i++) 
	     		     addToFile(  getFile((String) nomes.get(i)), file );
	   	     
		          }catch(IOException ioex){
		            ioex.printStackTrace();
		          }   
		   return "tree_Mult";
		  }
	      
	    public File criaInstancia(String nome){
	    	
	             File file = new File(nome);
	    	 return file;
	    }
	    
	    public StringBuffer trataEntrada( String texto){
	    	String conteudo, substring,aux;
	    	int line, index=0,cont=0, pont=0;
	    	char ch;
	    	
	    	StringBuffer buffer = new StringBuffer();    	
	    
	    	line=texto.indexOf("\n");// 1 quebra de linha do texto
	    	substring= texto.substring(0,line);
	    	
	    	buffer.append( substring + "\n");// esp + sitios
	    	index= Integer.parseInt(substring.substring(substring.lastIndexOf(" ")+1));
	    	conteudo= texto.substring(line+1);// somente nome + sitios
	    	
	    	while(cont<conteudo.length()){
	    
	    	cont= conteudo.indexOf(" ");
	    	aux=conteudo.substring(0, cont);    	
	    	buffer.append(aux+ "\n");// nome
	    	pont=0;
	    	substring="";
	    	while(pont<index){
	    		ch=conteudo.charAt(cont);
	    		if(!(ch==' '|| ch=='\n'|| ch=='\t')){
	    			substring+=ch;
	    			pont++;
	    		}
	    		cont++;  
	    		
	    	}
	    	
	    	buffer.append(substring);// sitios
	    	
	    	
	    	conteudo=conteudo.substring(++cont);// proximo nome e sitios
	   
	    	
	    	
	    	}
	      	
	    	return buffer;
	    }
	    
	   /**
		 * public String qualDiretorio (String completo){ String diretorio; int
		 * posicao;
		 * 
		 * diretorio = completo;// diretorio do arquivo saida. posicao =
		 * diretorio.lastIndexOf('/');//retorna a posiçao da ultima ocorencia.
		 * diretorio = diretorio.substring(0,posicao+1);// so o diretorio.
		 * return diretorio; }
		 */

	}





