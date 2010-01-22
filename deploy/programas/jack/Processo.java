import java.io.BufferedReader;
import java.io.InputStreamReader;

	/**
	 * @author JACKELINE 
	 * 
	 */
public class Processo {
	
	/**
	 * Esta classe so tem um metodo para criar outro processo.
	 * 
	 *  @return void
	 */	
	public static void criarProcesso(String comando) {
			Process novo = null;
			BufferedReader buffer;
			String entrada;
			try {
				novo = Runtime.getRuntime().exec(comando);
				buffer = new BufferedReader(new InputStreamReader(novo
						.getInputStream()));
				
				novo.waitFor();
				entrada = buffer.readLine();
				while(entrada!=null){
					System.out.println(entrada);
					entrada = buffer.readLine();
				}

				buffer=null;
				
				novo.destroy();
				System.gc();

			} catch (Exception expection) {
				System.out.println("Nao foi possivel executar o aplicativo!");
				System.exit(0);

			}
		}
	
}

