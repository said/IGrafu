import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;


 public interface ProcessoRemoto extends Remote {
 
     public void criarProcesso( Vector<String> cmd, int inicio, int fim ) throws RemoteException;
   
 } 
