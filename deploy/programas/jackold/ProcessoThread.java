import java.util.Vector;
import java.util.concurrent.*;
 
 public class ProcessoThread implements Runnable {
	 
	Conexao conexao;
	CyclicBarrier barrier;
		 
	public ProcessoThread(Vector<String> coma, CyclicBarrier barr,String nomeNo, int ini, int fim){
		conexao= new Conexao(coma,nomeNo,ini,fim);
		barrier=barr;		
	}
		
   public void run(){
		conexao.init();	
		conexao.fechaConexao();
	   
	   	    try {
	   	      barrier.await();
	            } catch (InterruptedException ex) { 
	                 System.out.println(ex); 
	            } catch (BrokenBarrierException ex) { 
	                 System.out.println(ex); 
	            }
	 }
	 
}
