import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry ;
import java.rmi.RemoteException;
import java.rmi.AlreadyBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.io.IOException;

public class ProcessoServer {
	
 public ProcessoServer(String host) {
	      try{
	    	  ProcessoRemoto   stub  = new ProcessoImp();
	          Registry registry = LocateRegistry.createRegistry(1099);	        
	          //Dá um nome pra ele no registro
	           registry.bind ("ProcessoService"+host, stub);
	  
	         System.out.println ("Servidor iniciado ...");  
	      }catch(RemoteException Re){
	         System.out.println(Re.getMessage());
	      }catch(AlreadyBoundException ABe){
	         System.out.println(ABe.getMessage());
	      }catch(IOException IOe){
	         System.out.println(IOe.getMessage());
	      }  
 }
 
 
 public static void main(String[] args) {
	          new ProcessoServer(args[0]);
	      }
	  
 }

