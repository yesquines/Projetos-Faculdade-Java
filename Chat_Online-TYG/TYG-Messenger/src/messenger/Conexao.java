package messenger;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class Conexao {

	protected Socket s;
	protected String nome;
	protected static List<String> nomeconectados = new ArrayList<String>();
	int conectados;
	Controle ctr;
	Tela t;

	// CONSTRUTOR
	public Conexao(Tela t) {
		this.t = t;

		try {
			s = new Socket("208.89.212.86", 5000); 
			showMessageDialog(null, "Bem Vindo ao TYG Messenger!");
			t.conectar.setEnabled(false);
			t.desconectar.setEnabled(true);
			t.texto.setEditable(true);
			validaNome();
			if (nome != null) {
				if (!nome.trim().isEmpty()) {
			nomeconectados.add(nome);
			PrintStream out = new PrintStream(s.getOutputStream());
			out.println(nomeconectados);
				}
			}

		} catch (IOException e) {

			showMessageDialog(null, "\f \f \f---CONEXÃO COM SERVIDO FALHOU!!!--- \n\f Por favor tentar Novamente mais Tarde. \n\n Erro: " + e.getStackTrace() ,"", ERROR_MESSAGE);

		}

	}

	public void fecharConexao() {

		try {
			
			s.close();
			t.conectar.setEnabled(true);
			t.desconectar.setEnabled(false);
			t.texto.setEditable(false);
			String saida = "servdesc";
			PrintStream out;
			out = new PrintStream(s.getOutputStream());
			out.println(saida);

		} catch (Exception e) {
			
			System.out.println("Erro fecharConexão Cliente: " + e.getMessage());

		}

	}

	public void validaNome() throws IOException {
		
		nome = showInputDialog(null, "Digite seu Nome: ", "");
		if (nome != null) {
			if (nome.trim().isEmpty()) {
				validaNome();
			}
		} else {
			s.close();
			fecharConexao();
		}
	}

}
