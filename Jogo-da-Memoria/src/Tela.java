import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Tela extends JFrame {

    protected String jpg = ".jpg";
    protected int tamanho = 130;
    ArrayList<Integer> num = new ArrayList<Integer>();
    /* Controle do Jogo */
    protected Controle c = new Controle(this);
    /* Layout GAME */
    protected FlowLayout layout = new FlowLayout();
    /* Criando Menu Bar/Menus/Submenus */
    protected JMenuBar barra = new JMenuBar();
    protected JMenu sobre = new JMenu("Menu do Jogo");
    protected JMenuItem sobre2 = new JMenuItem("Sobre");
    protected JMenuItem instrucoes = new JMenuItem("Instruções");
    protected JMenuItem sair = new JMenuItem("Sair");
    /* PANEL */
    protected JPanel memoria = new JPanel();
    protected JPanel label1 = new JPanel();
    protected JPanel label2 = new JPanel();
    protected JPanel painelspace = new JPanel();
    protected JPanel painelspace2 = new JPanel();
    /* Criando Label */
    protected JLabel acerto = new JLabel("Acertos: ");
    protected JLabel erro = new JLabel("Erros: ");
    protected JLabel pontuacao = new JLabel("Pontuação Total:");
    protected JLabel espaco = new JLabel("");
    protected JLabel txt = new JLabel("<html><b>CLIENTE NO BOTÃO 'NOVO JOGO' PARA INICIAR A PARTIDA<b><html>");
    /* Criando TextFiel */
    protected JTextField numacerto = new JTextField("0");
    protected JTextField numerro = new JTextField("0");
    protected JTextField numponto = new JTextField("0");
    /* Criando Botões */
    protected JButton novo = new JButton("Novo Jogo");
    protected JButton reinicio = new JButton("Reiniciar Jogo");
    protected JButton botao[] = new JButton[24];
    /* Criando Imagens */
    protected JLabel imagem[] = new JLabel[24];

    public Tela() {

        this.setTitle("JMA - Jogo da Memoria Ambiental");
        this.setSize(1024, 698);
        this.setLocation(150, 0);
        this.setResizable(false);
        this.add(painelspace, BorderLayout.WEST);
        this.add(painelspace2, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(c);

        /*Menu*/
        this.setJMenuBar(barra);
        barra.add(sobre);
        sobre.add(instrucoes);
        sobre.add(sobre2);
        sobre.add(sair);
        instrucoes.addActionListener(c);
        sobre2.addActionListener(c);
        sair.addActionListener(c);

        /* Label Novo Jogo / Reiniciar */
        label1.setLayout(layout);
        TitledBorder borda1 = new TitledBorder("");
        label1.setBorder(borda1);
        this.add(label1, BorderLayout.SOUTH);
        novo.setPreferredSize(new Dimension(200, 30));
        reinicio.setPreferredSize(new Dimension(200, 30));
        reinicio.setEnabled(false);
        label1.add(novo);
        novo.addActionListener(c);
        label1.add(reinicio);
        reinicio.addActionListener(c);

        /* Label da Acerto/Erros */
        label2.setLayout(layout);
        TitledBorder borda2 = new TitledBorder("GAME - MEMORIA AMBIENTAL");
        label2.setBorder(borda2);
        label2.setSize(20, 0);
        label2.add(acerto);
        numacerto.setEditable(false);
        numacerto.setBackground(Color.WHITE);
        numacerto.setForeground(Color.BLUE);
        label2.add(numacerto);
        label2.add(erro);
        numerro.setEditable(false);
        numerro.setBackground(Color.WHITE);
        numerro.setForeground(Color.RED);
        label2.add(numerro);
        label2.add(pontuacao);
        numponto.setEditable(false);
        numponto.setBackground(Color.WHITE);
        numponto.setForeground(Color.GREEN);
        label2.add(numponto);
        this.add(label2, BorderLayout.NORTH);
        
        /* Grid do Jogo */
        this.add(memoria);
        memoria.setLayout(null);
        txt.setForeground(Color.RED);
        
        for (int i = 0; i < 25; i++) {
     	
            ImageIcon imgbotao = new ImageIcon(getClass().getResource("/imagens/leaf-icon_small.jpg"));
            botao[i] = new JButton(imgbotao);
            if (i <= 5){
                botao[i].setBounds(i * 170, 2, tamanho, tamanho);
            } else if (i <= 11) {
                int j = i;
                j = j - 6;
                botao[i].setBounds((j * 170)  , 135, tamanho, tamanho);
            } else if (i <= 17) {
                int k = i;
                k = k - 12;
                botao[i].setBounds((k * 170)  , 268, tamanho, tamanho);
            } else if (i <= 24) {
                int l = i;
                l = l - 18;
                botao[i].setBounds((l * 170)  , 400, tamanho, tamanho);
            }
            memoria.add(botao[i]);
            botao[i].addActionListener(c);
            botao[i].setVisible(true);
            botao[i].setEnabled(false);
            
            //CONDIÇÃO - IMG RAMDOM
            if (i < 13){
            	int random = sorteiaNumero(12);
            	ImageIcon imgjogo = new ImageIcon(getClass().getResource("/imagens/" + random + jpg));
            	imagem[i] = new JLabel();
            	imagem[i].setIcon(imgjogo);
            		if(num.size() == 12){
            			num.clear();
            			num.removeAll(num);
            		}
            	} else {
            		int random2 = sorteiaNumero(12);
            	ImageIcon imgjogo2 = new ImageIcon(getClass().getResource("/imagens/" + random2 + jpg));
            	imagem[i] = new JLabel();
            	imagem[i].setIcon(imgjogo2); }
            
            //POSIÇÃO NA TELA
             if (i <= 5){
                imagem[i].setBounds(i * 170, 2, tamanho, tamanho);
            } else if (i <= 11) {
                int j = i;
                j = j - 6;
                imagem[i].setBounds((j * 170)  , 135, tamanho, tamanho);
            } else if (i <= 17) {
                int k = i;
                k = k - 12;
                imagem[i].setBounds((k * 170)  , 268, tamanho, tamanho);
            } else if (i <= 24) {
                int l = i;
                l = l - 18;
                imagem[i].setBounds((l * 170)  , 400, tamanho, tamanho);
            }
          	memoria.add(imagem[i]);
            imagem[i].setVisible(false);
            if (i == 23){
            	JOptionPane.showMessageDialog(null, txt);
            }
            
        }
        
//FIM CONSTRUTOR
    }
    // GERA NUMERO ALEATORIO SEM REPETIÇÃO
    
    
	public int sorteiaNumero(int n) {
		
		int numero = 1 + (int) (Math.random() * n);
        //se não existir adiciona
        if (!num.contains(numero)) {
            num.add(numero);
            return numero;
        } else {
            return sorteiaNumero(n);
        }
		
    }
    
//FIM_CLASSE
}