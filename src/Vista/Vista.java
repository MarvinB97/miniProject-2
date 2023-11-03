/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

//import Modelo.Sonido;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.util.Vector;
import java.awt.event.ActionListener;

/**
 *
 * @author Xavier , Marvin Nuñez
 */


public class Vista{
    //private Sonido ringtong;
		
	private JFrame frame;
	private JPanel visto, panelJuego,panelMenu,panelResultados,panelInstrucciones;
	
	//elementos del panel del menu
	private JButton btnJugar,btnMenu2;
	
	private JButton comoJugarButton;
    
    
    //private MenuIU menuIU;
    private JLabel txt;
    private String mensajesComoJugar = "<html><h2>INSTRUCCIONES</h3>"
    		+ "<p>1) En Adosa2 aparecen en pantalla una serie de baldosas.<p>"
    	+ "<p>Las baldosas van cambiando de 1 en 1 mostrando distintos diseños.</p>"
    	+ "<p>Podrás saber qué baldosa cambiar en cada momento gracias a un reborde de color azul.</p>"
        +"<p>2) En el momento en que veas en pantalla 2 baldosas idénticas, </p>"
        + "<p>debes presionar rápidamente el pulsador blanco que aparece en la zona inferior derecha </p>"
        +"<p>3) Hay dos formas de presionar el pulsador:</p>"
        + "<p>-Pulsar directamente el botón blanco en pantalla</p>"
        + "<p>-Pulsar la barra de espacio del teclado </p>"
        +"<p>4) ¡OJO! Si no pulsas a tiempo perderás vidas.</p>"
        + "<p>A medida que el juego avanza el ritmo al que cambian las baldosas es mayor y tu tiempo</p>"
        + "<p>de reacción es menor.</p></html>";
    	
	
	
	//elementos del panel de juego
    private JLabel lblPuntuacion,lblNumPuntuacion,lblVidas;
    private Vector<JButton> btnJuego = new Vector<JButton>(8);;
    private JButton btnRevisar,btnVidas,btnSonido;
    private Vector<ImageIcon> icono = new Vector<ImageIcon>(12);
    private Vector<ImageIcon> iconoEscale = new Vector<ImageIcon>(12);
    
    //elementos del panel de Resultados
    private JLabel lblResultados;
    private JButton btnMenu;

    
    public void addImagenIcon() {
    	String src;
        for(int i=0;i<13;i++) {
        	src = "src/images/" + i + ".jpeg";
        	this.icono.add(new ImageIcon(src));
            this.iconoEscale.add(new ImageIcon(icono.get(i).getImage().getScaledInstance(100,100, java.awt.Image.SCALE_DEFAULT)));
        }
    }
    

    public Vista() {
    	
	    //ringtong = new Sonido();
    	
    	//--------WINDOW.---------
    	frame = new JFrame("Juego 2");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(700, 500);
    	frame.setLocationRelativeTo(null);

        
    	
    	
    	
    	//---------------------------INSTRUCCIONES (COMO JUGAR)----------------------------------
        panelInstrucciones = new JPanel();
        panelInstrucciones.setLayout(new BorderLayout());
        panelInstrucciones.setName("Instrucciones");

        
        txt = new JLabel(this.mensajesComoJugar);
        btnMenu2 = new JButton("Menu");
        btnMenu2.setBackground(Color.BLUE);
        btnMenu2.setForeground(Color.WHITE);
        
        JPanel panelInstruc = new JPanel();
        panelInstruc.add(txt);
        JPanel panelInstruc2 = new JPanel();
        panelInstruc2.add(btnMenu2);
        
        
        panelInstrucciones.add(panelInstruc, BorderLayout.CENTER);
        panelInstrucciones.add(panelInstruc2, BorderLayout.SOUTH);
        
        
    	//---------------------------MENU----------------------------------

        panelMenu = new JPanel();
        panelMenu.setLayout(new BorderLayout());
        
        JPanel panelMen= new JPanel();
        panelMen.setName("Menú del Juego");
        panelMen.setLayout(new BoxLayout(panelMen, BoxLayout.X_AXIS));

        comoJugarButton = new JButton("Cómo jugar");
        btnJugar = new JButton("Jugar");
       
        // Establecer el tamaño preferido de los botones
        comoJugarButton.setPreferredSize(new Dimension(300, 50));
        btnJugar.setPreferredSize(new Dimension(300, 50));
        
        
        comoJugarButton.setBackground(Color.BLUE);
        comoJugarButton.setForeground(Color.WHITE);
        btnJugar.setBackground(Color.BLUE);
        btnJugar.setForeground(Color.WHITE);
        

        // Agregar los botones al panel
        panelMen.add(Box.createHorizontalGlue()); // Espacio en blanco a la izquierda
        panelMen.add(comoJugarButton);
        panelMen.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre botones
        panelMen.add(btnJugar);
        panelMen.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre botones
        panelMen.add(Box.createHorizontalGlue()); // Espacio en blanco a la derecha
    	
        panelMenu.add(panelMen,BorderLayout.CENTER);
    	
    	
    	//---------------------------JUEGO----------------------------------
        //ETIQUETAS
        lblPuntuacion = new JLabel("Punt: ");
        lblNumPuntuacion = new JLabel("000");
        lblVidas = new JLabel("");
        
        //BOTONES
        for(int i = 0;i<8;i++) {
        	btnJuego.add(new JButton());
        }
        //btnVidas = new JButton("xxx");
        btnSonido = new JButton("o<|)");
        btnRevisar = new JButton("Click");
        
        btnSonido.setBackground(Color.BLUE);
        btnSonido.setForeground(Color.WHITE);
        
        btnRevisar.setBackground(Color.BLUE);
        btnRevisar.setForeground(Color.WHITE);
        
        
        addImagenIcon();
        
        //fondo de btn por default
        for(int i = 0; i < 8; i++) {
        	setImagen(i, 0,false); 
        }

		
		
        //AÑADIENDO LOS ELEMENTOS A LOS PANELES
        
        panelJuego = new JPanel();
        panelJuego.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(lblPuntuacion);
        topPanel.add(lblNumPuntuacion);
        topPanel.add(lblVidas);
        //topPanel.add(btnVidas);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
        leftPanel.add(btnJuego.get(4));
        leftPanel.add(btnJuego.get(0));
        
        JPanel centerPanel = new JPanel();
        BoxLayout caja = new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS);
        centerPanel.setLayout(caja);
        centerPanel.add(btnJuego.get(5));
        centerPanel.add(btnJuego.get(1));
        centerPanel.add(btnJuego.get(3));
        centerPanel.add(btnJuego.get(7));
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
        rightPanel.add(btnJuego.get(2));
        rightPanel.add(btnJuego.get(6));
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(btnSonido);
        bottomPanel.add(btnRevisar);
        
        
        JPanel centro = new JPanel(new FlowLayout());
        centro.setBackground(Color.GRAY);
        centro.add(leftPanel);
        centro.add(centerPanel);
        centro.add(rightPanel); 
        
        panelJuego.add(topPanel, BorderLayout.NORTH);
        panelJuego.add(centro,BorderLayout.CENTER);
        panelJuego.add(bottomPanel, BorderLayout.SOUTH);
        
        
        
        
        
        
    	//---------------------------RESULTADOS----------------------------------
        panelResultados = new JPanel();
        panelResultados.setLayout(new BorderLayout());
        
        lblResultados = new JLabel("");
        btnMenu = new JButton("Menu");
        
        btnMenu.setBackground(Color.BLUE);
        btnMenu.setForeground(Color.WHITE);
        
        panelResultados.add(lblResultados, BorderLayout.CENTER);
        panelResultados.add(btnMenu, BorderLayout.SOUTH);
        

        
        
        //-----------------------MOSTRAR EN EL FRAME----------------------------
        
        visto = new JPanel();
        visto.add(panelMenu);
        visto.add(panelResultados);
        visto.add(panelJuego);
        visto.add(panelInstrucciones);
        
        //--SE PONE POR DEFAULT EL MENU
        
        panelResultados.setVisible(false);
        panelJuego.setVisible(false);
        panelInstrucciones.setVisible(false);
        
        frame.add(visto);
        frame.setVisible(true);
    }
    
    
    
    
    //-----Metodos------
    
    public void setImagen(int numBtn, int numImage, boolean Bool) {
    	this.btnJuego.get(numBtn).setIcon(iconoEscale.get(numImage));
    	
		if(Bool) {
			this.btnJuego.get(numBtn).setBorder(new EtchedBorder(EtchedBorder.RAISED,Color.red,Color.blue));
		}else {
			this.btnJuego.get(numBtn).setBorder(null);
		}
    }
    

    
    public String getTxtPuntaje() {
        return this.lblNumPuntuacion.getText();
    }
    
    public void setTxtPuntaje(String txt) {
        this.lblNumPuntuacion.setText(txt);
    }
    
    public void setTxtLblResultados(String result) {
        lblResultados.setText(result);
    }
    
    public void setTxtLblVidas(String vidas) {
	    lblVidas.setText(vidas);
	}


	public void setVista(int value) {
    	if(value == 0) {
    		panelMenu.setVisible(false);
            panelJuego.setVisible(false);
            panelResultados.setVisible(true);
            panelInstrucciones.setVisible(false);

    	}else if(value == 1) {
    		panelMenu.setVisible(false);
            panelJuego.setVisible(true);
            panelResultados.setVisible(false);
            panelInstrucciones.setVisible(false);

    	}else if(value == 2) {
    		panelMenu.setVisible(true);
            panelJuego.setVisible(false);
            panelResultados.setVisible(false);
            panelInstrucciones.setVisible(false);

    	}else if(value == 3) {
    		panelMenu.setVisible(false);
            panelJuego.setVisible(false);
            panelResultados.setVisible(false);
            panelInstrucciones.setVisible(true);
    	}
    }
    
    
    
    //-------ACTION LISTENERS----------
    public void presionarListener(ActionListener listener) {
        btnRevisar.addActionListener(listener);
    }

    public void sonidoOnOffListener(ActionListener listener) {
        btnSonido.addActionListener(listener);
    }
    
    public void goMenu(ActionListener listener) {
        btnMenu.addActionListener(listener);
        btnMenu2.addActionListener(listener);

    }
    
    
    public void goJuego(ActionListener listener) {
        btnJugar.addActionListener(listener);
    }
    
    public void goInstrucciones(ActionListener listener) {
    	comoJugarButton.addActionListener(listener);
    }
    
    
    
    
    
    //---------ACTIONS ON MENU----------
    public void getComoJugarButton(ActionListener listener) {
    	comoJugarButton.addActionListener(listener);//mostrarComoJugar(ventanaActual);
    }
    
   
}
