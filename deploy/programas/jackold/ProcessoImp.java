import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;



 public class ProcessoImp extends UnicastRemoteObject implements ProcessoRemoto {

     public ProcessoImp() throws RemoteException {
         super();
     }
     
     public void criarProcesso( Vector<String> cmd, int inicio, int fim) throws RemoteException {
    	 Process novo = null;
    	
    	 for (int i=inicio; i<fim;i++) {
			try {
 		     	novo = Runtime.getRuntime().exec(cmd.get(i));
 			    novo.waitFor();
 			    novo.destroy();
 		    } catch (Exception expection) {
 			  System.out.println("ERRO-P2: Nao foi possivel executar o aplicativo !");
 			 System.exit(1);
 		    }  
         }
    	 System.exit(0);
     }
     
 }
 
