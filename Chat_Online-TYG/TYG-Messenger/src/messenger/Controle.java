package messenger;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import static javax.swing.JOptionPane.*;

public class Controle extends WindowAdapter implements ActionListener,
		KeyListener {

	protected Tela t;
	protected Conexao c;
	protected BufferedReader br;
	protected InputStreamReader isr;
	protected String conectado;
	protected ArrayList<String> connected = new ArrayList<String>();
	int conexaoativa = 0;

	public Controle(Tela t) {
		this.t = t;

	}

	public void Mensagem() {

		String mensagem = "\f (" + Calendar.getInstance().getTime() + ") "
				+ c.nome.toUpperCase() + ": ";

		try {

			PrintStream out = new PrintStream(c.s.getOutputStream());
			mensagem += t.texto.getText();

			out.println(mensagem);
			t.texto.setText(null);
		} catch (IOException e) {

			showMessageDialog(
					null,
					"\f \f \f---MENSAGEM NÃO ENVIADA!!!--- \n\f Por favor verificar conexão. \n\n Erro: "
							+ e.getStackTrace(), "", ERROR_MESSAGE);

		}

	}

	public void Conectados() {

		String online = "\t\t\t ***** " + c.nome + " está Online" + " *****";

		try {

			PrintStream out = new PrintStream(c.s.getOutputStream());
			online = online.toUpperCase();

			out.println(online);

		} catch (IOException e) {

			System.out.println("Erro Conectados Cliente: " + e.getMessage());

		}

	}

	public void Desconectado() {

		String off = "\t\t\t***** " + c.nome + " está Offline" + " *****";

		try {

			PrintStream out = new PrintStream(c.s.getOutputStream());
			off = off.toUpperCase();
			out.println(off);

		} catch (IOException e) {

			System.out.println("Erro Desconectados Cliente: " + e.getMessage());

		}

	}

	public void Thread() {

		Thread tratamento = new Thread(new Runnable() {

			String msg;
			//String conect;

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {

					isr = new InputStreamReader(c.s.getInputStream());
					br = new BufferedReader(isr);
					//ObjectInputStream iin =  new ObjectInputStream(c.s.getInputStream());
					//Object items = iin.readObject();
					
					while ((msg = br.readLine()) != null) {
						
						t.areatxt.setText(t.areatxt.getText() + msg + "\n");
						//t.conectados.setText(items + "\n");
						// conectados = c.nomeconectados.size();
						// x = Integer.toString(conectados);
						// t.numconect.setText(x);

					}

					isr.close();
					br.close();

				} catch (IOException e) {

					showMessageDialog(null, "Conexão Desconectada", "",
							ERROR_MESSAGE);

				} /*catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Erro: " + e.getMessage());
				}*/

			}
		});

		tratamento.start();

	}
	
    public void sobreJogo(){
    	
    	JPanel sobrejg = new JPanel();
    	sobrejg.setLayout(new GridLayout(0, 1));
    	TitledBorder bordasobre = new TitledBorder("TYG Messenger - APS - Mai/2015.");
        bordasobre.setTitleColor(Color.red);
        sobrejg.setBorder(bordasobre);
    	JLabel desen = new JLabel("Desenvolvido por: Gustavo Costa, Thamirys Moura e Yago Ésquines.");
    	JLabel facul = new JLabel("Ciência da Computação - UNIP - Universidade Paulista.");
    	JLabel espaco1 = new JLabel();
    	JLabel ling = new JLabel("Linguagem de Desenvolvimento: Java 7.");
    	JLabel plataforma = new JLabel("Plataforma: Eclipse Platform 3.8.0");
    	JLabel espaco2 = new JLabel();
    	JLabel obs = new JLabel("**Este jogo foi desenvolvido com fins educacionais.");
    	sobrejg.add(desen);
    	sobrejg.add(facul);
    	sobrejg.add(espaco1);
    	sobrejg.add(ling);
    	sobrejg.add(plataforma);
    	sobrejg.add(espaco2);
    	sobrejg.add(obs);
    	
    	
    	JOptionPane.showMessageDialog(null, sobrejg, "Sobre o Messenger", JOptionPane.PLAIN_MESSAGE);
    	
    }


	public void actionPerformed(ActionEvent e) {

		// EVENTO CONECTAR
		if (e.getSource().equals(t.conectar)) {

			c = new Conexao(t);
			conexaoativa = 1;
			Thread();
			Conectados();

		}

		if (e.getSource().equals(t.desconectar)) {
			
			Desconectado();
			c.fecharConexao();
			try {
				isr.close();
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro Desconectar Cliente: " + e1.getMessage());
			}
			

		}
		
		if (e.getSource().equals(t.sobre)) {
            sobreJogo();
        }
		
		//Evento para Sair do Jogo
        if (e.getSource().equals(t.sair)) {
            fechaChat();
        }

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.isShiftDown()) {

				t.texto.append("\n");

			} else{
				Mensagem();
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void fechaChat() {

		int x = JOptionPane.showConfirmDialog(null,
				"Confirma o Fechamento do Chat?", " ",
				JOptionPane.YES_NO_OPTION);
		if (x == JOptionPane.YES_OPTION) {
			if(conexaoativa == 0){
				System.exit(0);
				} else{
			c.fecharConexao();
			System.exit(0);}
		}
	}

	
	@Override
	public void windowClosing(WindowEvent e) {
		fechaChat();
	}
	
}
