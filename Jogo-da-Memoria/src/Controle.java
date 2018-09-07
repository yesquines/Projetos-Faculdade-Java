
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Controle extends WindowAdapter implements ActionListener {

    Tela t;
    ArrayList<Integer> num2 = new ArrayList<Integer>();
    int numclick = 0;
    int primeiroclick = 0;
    int segundoclick = 0;
    int acerto = 0;
    int acerto2 = 0;
    int erro = 0;
    int pontuacao = 0;
    String primeiroicon;
    String segundoicon;
    
    public Controle(Tela t) {
        this.t = t;

    }

    public void novoJogo() {
    	
    	for (int i = 0; i < 25; i++) {
    		t.reinicio.setEnabled(true);
    		t.botao[i].setIcon(new ImageIcon(getClass().getResource("/imagens/leaf-icon_small.jpg")));
    		t.botao[i].setEnabled(true);
            t.botao[i].setVisible(false);
            t.imagem[i].setVisible(true);
            if (i < 13){
            int imgnovo = sorteiaNumeroII(12);
            t.imagem[i].setIcon(new ImageIcon(getClass().getResource("/imagens/" + imgnovo + ".jpg")));
            	if(num2.size() == 12){
            		num2.clear();
            		num2.removeAll(num2);
            	}
            } else {
            	int imgnovo2 = sorteiaNumeroII(12);
                t.imagem[i].setIcon(new ImageIcon(getClass().getResource("/imagens/" + imgnovo2 + ".jpg")));
                if (num2.size() == 12){
                	num2.clear();
                	num2.removeAll(num2);
                }
            }
            viratudo(i);
            t.numacerto.setText("0");
            t.numerro.setText("0");
            t.numponto.setText("0");
            numclick = 0;
            acerto2 = 0;
            
        }
    }

    public void reiniciaJogo(){

    for (int i = 0; i <= 24; i++) {
					t.botao[i].setIcon(new ImageIcon(getClass().getResource("/imagens/leaf-icon_small.jpg")));
					t.botao[i].setEnabled(true);
                    t.botao[i].setVisible(false);
                    t.imagem[i].setVisible(true);
                    t.numerro.setText("0");
                    t.numacerto.setText("0");
                    t.numponto.setText("0");
                    numclick = 0;
                    acerto2 = 0;
                    viratudo(i);
                }
    }

     public void fechaJogo() {

        int x = JOptionPane.showConfirmDialog(null, "Confirma o Fechamento do Jogo?", " ", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        } 
    }  
    
    public void sobreJogo(){
    	
    	JPanel sobrejg = new JPanel();
    	sobrejg.setLayout(new GridLayout(0, 1));
    	TitledBorder bordasobre = new TitledBorder("Jogo da Memória - APS - Nov/2014.");
        bordasobre.setTitleColor(Color.red);
        sobrejg.setBorder(bordasobre);
    	JLabel desen = new JLabel("Desenvolvido por: Alexandre Forcellini e Yago Ésquines.");
    	JLabel facul = new JLabel("Ciência da Computação - UNIP - Universidade Paulista.");
    	JLabel espaco1 = new JLabel();
    	JLabel ling = new JLabel("Linguagem de Desenvolvimento: Java 7.");
    	JLabel plataforma = new JLabel("Plataforma: Eclipse Platform 3.8.0 e NetBeans IDE 7.0.1.");
    	JLabel update = new JLabel("<html><b>Versão: JMA 2.1 - Ultima Atualização: 16/03/2015<b><html>");
    	JLabel espaco2 = new JLabel();
    	JLabel obs = new JLabel("**Este jogo foi desenvolvido com fins educacionais.");
    	sobrejg.add(update);
    	sobrejg.add(desen);
    	sobrejg.add(facul);
    	sobrejg.add(espaco1);
    	sobrejg.add(ling);
    	sobrejg.add(plataforma);
    	sobrejg.add(espaco2);
    	sobrejg.add(obs);
    	
    	
    	JOptionPane.showMessageDialog(null, sobrejg, "Sobre o Jogo", JOptionPane.PLAIN_MESSAGE);
    	
    }

    public void instrucoesJogo(){

        JPanel instrujg = new JPanel();
        instrujg.setLayout(new GridLayout(1, 2));
        instrujg.setPreferredSize(new Dimension(600, 250));
        JPanel txtinstr = new JPanel();
    	txtinstr.setLayout(new GridLayout(0, 1));
    	TitledBorder bordasobre = new TitledBorder("Instrucoes do Jogo - APS - Nov/2014.");
        bordasobre.setTitleColor(Color.RED);
        txtinstr.setBorder(bordasobre);
    	JLabel instr1 = new JLabel("<html>- O Jogador tem direito de virar <br /> duas imagens por vez<html>");
    	JLabel instr2 = new JLabel("<html>- O Jogador tem um acerto quando vira <br /> duas imagens iguais<html>");
        JLabel instr3 = new JLabel("<html>- Caso as imagens forem diferentes, <br /> elas ficam ocultas novamente e o Jogador tem que tentar novamente<html>");
        JLabel instr4 = new JLabel("<html>- O Jogo acaba quando todas os pares de <br /> imagens forem encontrados<html>");
    	JPanel pontos = new JPanel();
        pontos.setLayout(new GridLayout(0, 1));
        TitledBorder bordapontos = new TitledBorder("PONTUAÇÃO");
        bordapontos.setTitleColor(Color.RED);
        pontos.setBorder(bordapontos);
    	JLabel pontos1 = new JLabel("- Acertos = +10 pontos");
        JLabel pontos2 = new JLabel("- Erros = -3 pontos");
    	JLabel obs = new JLabel("<html><u>**SE ATENDE AS DICAS AMBIENTAIS <br /> EM CADA PAR DE IMAGEM**</u><html>");
    	txtinstr.add(instr1);
    	txtinstr.add(instr2);
        txtinstr.add(instr3);
        txtinstr.add(instr4);
        pontos.add(pontos1);
        pontos.add(pontos2);
        pontos.add(obs);
    	instrujg.add(txtinstr);
        instrujg.add(pontos);
       
    	JOptionPane.showMessageDialog(null, instrujg, "Instruções do Jogo", JOptionPane.PLAIN_MESSAGE);

    }
    
    public void resumoJogo(){
    	
    	JPanel resumojogo = new JPanel();
    	resumojogo.setLayout(new GridLayout(0, 1));
    	TitledBorder bordaresumo = new TitledBorder("Jogo da Memória - APS - Nov/2014.");
        bordaresumo.setTitleColor(Color.red);
        resumojogo.setBorder(bordaresumo);
    	JLabel txt = new JLabel("FIM DO JOGO!");
    	JLabel resultado1 = new JLabel("ACERTOS: "+t.numacerto.getText());
    	JLabel resultado2 = new JLabel("ERROS: "+t.numerro.getText());
    	JLabel resultado3 = new JLabel("**    Parabéns, sua pontuação foi:   **");
    	JLabel resultado4 = new JLabel("PONTUAÇÃO: "+t.numponto.getText());
    	resumojogo.add(txt);
    	resumojogo.add(resultado1);
    	resumojogo.add(resultado2);
    	resumojogo.add(resultado3);
    	resumojogo.add(resultado4);
    	
    	JOptionPane.showMessageDialog(null, resumojogo, "RESUMO DO JOGO", JOptionPane.PLAIN_MESSAGE);
    	
    }

     public void acertoJogo(){
        String x = t.numacerto.getText();
        acerto = Integer.parseInt(x);
        acerto++;
        x = Integer.toString(acerto);
        t.numacerto.setText(x);
        
        String y = t.numponto.getText();
        pontuacao = Integer.parseInt(y);
        pontuacao += 10;
        y = Integer.toString(pontuacao);
        t.numponto.setText(y);
    } 

        public void erroJogo(){
        String x = t.numerro.getText();
        erro = Integer.parseInt(x);
        erro++;
        x = Integer.toString(erro);
        t.numerro.setText(x);
        
        String y = t.numponto.getText();
        pontuacao = Integer.parseInt(y);
        pontuacao -= 3;
        y = Integer.toString(pontuacao);
        t.numponto.setText(y);
    }

    public int sorteiaNumeroII(int n) {
    	
        int numero = (int)(Math.random() * n) + 1;
        //se não existir adiciona
        if (!num2.contains(numero)) {
            num2.add(numero);
            return numero;
        } else {
            return sorteiaNumeroII(n);
        }

    }
    
    public void viraPeca(int i, int primeiro, int segundo){
    	int tempo = 1000;
    		ActionListener time = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
        	    for(int k = 0; k < 25; k++){
        	    numclick = 0;
                t.botao[primeiroclick].setVisible(true);
                t.imagem[primeiroclick].setVisible(false);
                t.botao[segundoclick].setVisible(true);
                t.imagem[segundoclick].setVisible(false); }
				}
			};
    	Timer timer = new  Timer(tempo, time);
    	timer.setRepeats(false);
    	timer.start();
    }
    
    public void viratudo(int i){
    	int tempo = 4500;
    		ActionListener time = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
        	    for(int k = 0; k < 25; k++){
                t.botao[k].setVisible(true);
                t.imagem[k].setVisible(false);
                 }
				}
			};
    	Timer timer = new  Timer(tempo, time);
    	timer.setRepeats(false);
    	timer.start();
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        fechaJogo();
    }
    
    public void actionPerformed(ActionEvent e) {

        //Evento para Sair do Jogo
        if (e.getSource().equals(t.sobre2)) {
            sobreJogo();
        }

        if (e.getSource().equals(t.instrucoes)){
            instrucoesJogo();
        }
    	
        //Evento para Sair do Jogo
        if (e.getSource().equals(t.sair)) {
            fechaJogo();
        }

        //Evento para Reiniciar o Jogo
        if (e.getSource().equals(t.reinicio)) {
            int r = JOptionPane.showConfirmDialog(null, "Deseje Reiniciar o Jogo?", " ", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                reiniciaJogo();
            }
        }

        //Evento para Novo Jogo
        if (e.getSource().equals(t.novo)) {
            int z = JOptionPane.showConfirmDialog(null, "Deseja começar um Novo do Jogo?", " ", JOptionPane.YES_NO_OPTION);
            if (z == JOptionPane.YES_OPTION) {
                novoJogo();
            }
        }

        //Eventos de Clique
        for(int i = 0; i < 25; i++){
    	   if (e.getSource().equals(t.botao[i])) {
            	numclick++;
                if(numclick == 1) {
                		primeiroclick = i;
                		t.botao[primeiroclick].setVisible(false);
                		t.imagem[primeiroclick].setVisible(true);
                		primeiroicon = t.imagem[primeiroclick].getIcon().toString();
                		                		
                } 
                if(numclick == 2){
                			segundoclick = i;
                			t.botao[segundoclick].setVisible(false);
                			t.imagem[segundoclick].setVisible(true);
                			segundoicon = t.imagem[segundoclick].getIcon().toString();
                			
                			if(primeiroicon.equals(segundoicon)){
                   					t.imagem[primeiroclick].setVisible(true);
                					//t.imagem[primeiroclick].setEnabled(false);
                					t.imagem[segundoclick].setVisible(true);
                					//t.imagem[segundoclick].setEnabled(false);
                					acertoJogo();
                					acerto2++;
                					numclick = 0;
                    } else{
                    	erroJogo();
                    	viraPeca(i, primeiroclick, segundoclick);
                    
                   }
                if(acerto2 == 12){
                	
                	resumoJogo();
                	acerto2 = 0;
                	
                }
                }
             }  
        }
  	}
//FECHA CLASSE
}