import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.*;


public class Servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//msgrecebida;
		ArrayList<PrintStream> clientes = new ArrayList<PrintStream>();
		ArrayList<String> conect = new ArrayList<String>();
		
		
		try{
		
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(5000);
		System.out.println("Servidor Iniciado!");
		System.out.println("Ouvindo na Porta 5000");
		Socket cliente;
		
		while(true){
			
			cliente = server.accept();
			System.out.println("Conexão Estabelecida");
			System.out.println("Conexão feita com o cliente " + cliente.getInetAddress().getHostAddress());
			
			//Salva Endereço dos Clientes Conectados
			clientes.add(new PrintStream(cliente.getOutputStream()));

			//Tratamento das Ações
			@SuppressWarnings("unused")
			Tratamento mensagem = new Tratamento(cliente,clientes,conect);
			
		}
		
		} catch(IOException e){
			
			System.out.println("Erro Servidor: " + e.getMessage());
			
		}
		
	}

}
