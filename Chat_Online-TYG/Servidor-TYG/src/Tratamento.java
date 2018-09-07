
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Tratamento {

	private Socket cliente;
	private ArrayList<PrintStream> clientes;
	private ArrayList<String> conect = new ArrayList<String>();
	private String conectados;
	

	public Tratamento(Socket cliente, ArrayList<PrintStream> clientes, ArrayList<String> conect) {
		this.cliente = cliente;
		this.clientes = clientes;
		this.conect = conect;
		Thread();

	}

	private void Thread() {

		Thread tratamento = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				String msgrecebida = null;
 
				try {

					InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
					BufferedReader in = new BufferedReader(isr);
					//ObjectOutputStream oout = new ObjectOutputStream(cliente.getOutputStream());
					conectados = in.readLine();
					conectados = conectados.toUpperCase();
					System.out.println(conectados + " está conectado");
					conect.add(conectados);
					//oout.writeObject(conect);
						
					while ((msgrecebida = in.readLine()) != null) {
						
						if(msgrecebida == "servdesc"){
							
							/* for(int i = 0; i <= conect.size(); i++){
							
							if(conect.get(i).contentEquals(conectados)){
							conect.remove(i);
							oout.writeObject(conect);
								}
							} */
							cliente.close();
							
						}else{
						//oout.writeObject(conect);
						enviaMsg(msgrecebida);
						}

					}
					
					isr.close();
					in.close();
					System.out.println(conectados + " está desconectado");
					
				} catch (IOException e) {

					System.out.println("Erro Thread Servidor: " + e.getMessage());

				}

			}
		});
		
		tratamento.start();

	}

	private void enviaMsg(String msg) {
		
		for (int i = 0; i < clientes.size(); i++) {

			clientes.get(i).println(msg);
			clientes.get(i).flush();

		}
		
	}
	
}
