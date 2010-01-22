import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.util.Vector;
import java.util.concurrent.*;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
  

public class Conexao {
	
	String host;
	Vector<String> comando;
	int inicio, fim;
	
		
	public Conexao(Vector<String> coma, String nomeNo, int ini, int fim){
		this.host= nomeNo;
		this.comando= coma;
		this.inicio=ini;
		this.fim=fim;
	}
	
   
    public void init(){
    	try{  
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            ProcessoRemoto stub = (ProcessoRemoto) registry.lookup ("ProcessoService"+host);
            
          stub.criarProcesso(comando, inicio,fim); 
             
        }catch(RemoteException Re){
            System.out.println(Re.getMessage());
        }catch(NotBoundException NBe){
            System.out.println(NBe.getMessage());
        }
   }

    
    public void fechaConexao(){
	   try {
		 Naming.unbind("ProcessoService"+host);
		 System.out.println("Fechando conexao...");
		 }
	     catch( MalformedURLException e ) {
	         System.out.println();
	         System.out.println( "ERRO C7 - MalformedURLException: " + e.toString() );
	     }
	     catch( RemoteException e ) {
	         System.out.println();
	         System.out.println( "ERRO C8 - RemoteException: " + e.toString() );
	     }
	     catch( NotBoundException e ) {
	         System.out.println();
	         System.out.println( "ERRO C9 - NotBoundException: " + e.toString() );
	     }
	     catch( Exception e ) {
	         System.out.println();
	         System.out.println( "ERRO C10 - Exception: " + e.toString() );
	     }
	 }


}