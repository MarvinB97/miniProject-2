import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MenuJuego {
    private MenuIU menuIU;

    public MenuJuego() {
        menuIU = new MenuIU();

        menuIU.getComoJugarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarComoJugar();
            }
        });

        menuIU.getParaQueSirveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarParaQueSirve();
            }
        });

        menuIU.getJugarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
    }

    public void mostrarComoJugar() {
        JOptionPane.showMessageDialog(menuIU, "Instrucciones de cómo jugar.");
    }

    public void mostrarParaQueSirve() {
    JFrame frame = new JFrame("Para qué sirve el juego");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(400, 300); // Tamaño de la ventana

    
   
    JTextArea mensajeTextArea = new JTextArea(
        "Este juego pone en accion la habilidad para comparar patrones visuales, " +
        "entrenando ademas la atencion a los detalles y la velocidad perceptiva. " +
        "Estas capacidades son relevantes cuando hay que hacerlo de forma rapida," +
        "por ejemplo al reconocer fotografias,caras,objetos,cotidianos o palabras escritas."        
    );
    mensajeTextArea.setWrapStyleWord(true);
    mensajeTextArea.setLineWrap(true);
    mensajeTextArea.setCaretPosition(0); // Coloca el cursor al principio

    
    JScrollPane scrollPane = new JScrollPane(mensajeTextArea);
    
    frame.add(scrollPane);
    frame.setVisible(true);
}


    public void iniciarJuego() {
        // Aquí puedes agregar la lógica para iniciar el juego.
        // Por ejemplo, abrir una nueva ventana de juego.
    }

    public void mostrarMenu() {
        menuIU.mostrarVentana();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuJuego menuJuego = new MenuJuego();
                menuJuego.mostrarMenu();
            }
        });
    }
}
