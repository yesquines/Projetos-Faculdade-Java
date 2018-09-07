package messenger;
import java.awt.*;
import javax.swing.*;
//import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;


@SuppressWarnings("serial")
public class Tela extends JFrame{
	
	/* VARIAVEIS */
	protected Controle c = new Controle(this);
	/* MENU */
	protected JMenuBar barra = new JMenuBar();
	protected JMenu menu = new JMenu("Menu");
	protected JMenuItem sobre = new JMenuItem("Sobre");
	protected JMenuItem divisao = new JMenuItem("--------");
	protected JMenuItem sair = new JMenuItem("Sair");
	//protected JMenu menu2 = new JMenu("Conversa");
	//protected JMenu menu3 = new JMenu("Opções");
	/* PAINEIS */
	protected JPanel PanelArea = new JPanel();
	protected JPanel Paneltexto = new JPanel();
	protected JPanel Panelinfo = new JPanel();
	protected JPanel Paneltot = new JPanel();
	protected JPanel space = new JPanel();
	protected JPanel space1 = new JPanel();
	protected JPanel space2 = new JPanel();
	protected JPanel space3 = new JPanel();
	protected JPanel space4 = new JPanel();
	protected JPanel space5 = new JPanel();
	protected JPanel space6 = new JPanel();
	/* AREA DE TEXTO */
	protected JTextArea areatxt = new JTextArea(20, 100);
	protected JScrollPane scroll = new JScrollPane(areatxt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	/* USUARIOS */
	protected JButton conectar = new JButton("Conectar");
	protected JButton desconectar = new JButton("Desconectar");
	//protected JTextArea conectados = new JTextArea(4, 20);
	//protected JScrollPane scroll2 = new JScrollPane(conectados, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//protected TitledBorder borda2 = new TitledBorder("Conectados:");
	/* CAIXA DE TEXTO */
	protected JTextArea texto = new JTextArea(5, 30);
	protected JScrollPane scroll3 = new JScrollPane(texto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	public Tela() {

        this.setTitle("TYG MESSENGER");
        this.setResizable(true);
        this.setSize(800, 600);
        this.setLocation(150, 0);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(c);
        
        /* MenuBar */
        this.add(space, BorderLayout.WEST);
        this.add(space1, BorderLayout.EAST);
        this.setJMenuBar(barra);
        barra.add(menu);
        menu.add(sobre);
        menu.add(divisao);
        menu.add(sair);
        divisao.setEnabled(false);
        sobre.addActionListener(c);
        sair.addActionListener(c);
        //barra.add(menu2);
        //barra.add(menu3);
        
        /* AREA DE CONEXÃO */
        this.add(Panelinfo, BorderLayout.NORTH);
        Panelinfo.setLayout(new FlowLayout());
        Panelinfo.add(conectar);
        conectar.addActionListener(c);
        Panelinfo.add(desconectar);
        desconectar.addActionListener(c);
        desconectar.setEnabled(false);
        
        /* AREA DE TEXTO */
        this.add(PanelArea);
        PanelArea.setLayout(new BorderLayout());
        PanelArea.add(scroll, BorderLayout.CENTER);
        DefaultCaret caret = (DefaultCaret)areatxt.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        areatxt.setLineWrap(true);
        areatxt.setVisible(true);
        areatxt.setEditable(false);	
        areatxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
	
        /* CONECTADOS  
        PanelArea.add(scroll2, BorderLayout.EAST);
        conectados.setEditable(false);
        conectados.setLineWrap(true);
        conectados.setBorder(borda2);
        conectados.setOpaque(false); */  
        
        /* CAIXA DE TEXTO */
        this.add(Paneltexto, BorderLayout.SOUTH);
        Paneltexto.setLayout(new BorderLayout());
        Paneltexto.add(scroll3, BorderLayout.CENTER);
        DefaultCaret caret2 = (DefaultCaret)areatxt.getCaret();
        caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        Paneltexto.add(space3, BorderLayout.NORTH);
        Paneltexto.add(space4, BorderLayout.WEST);
        Paneltexto.add(space5, BorderLayout.EAST);
        Paneltexto.add(space6, BorderLayout.SOUTH);
        space6.add(Paneltot);
        texto.setEditable(false);
		texto.setLineWrap(true);
		texto.setVisible(true);
        texto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		texto.addKeyListener(c);
	}	
	
}
