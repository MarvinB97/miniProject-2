import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuJuego {
    private MenuIU menuIU;
    private int ventanaActual = 1;
    private String[] mensajesComoJugar = {
        "1/4\n\nEn Adosa2 aparecen en pantalla una serie de baldosas.\nLas baldosas van cambiando de 1 en 1 mostrando distintos diseños.\nPodrás saber qué baldosa cambiar en cada momento gracias a un reborde de color azul.",
        "2/4\n\nEn el momento en que veas en pantalla 2 baldosas idénticas, debes presionar rápidamente el pulsador blanco que aparece en la zona inferior derecha",
        "3/4\n\nHay dos formas de presionar el pulsador:\n-Pulsar directamente el botón blanco en pantalla\n-Pulsar la barra de espacio del teclado",
        "4/4\n\n¡OJO! Si no pulsas a tiempo perderás vidas.\nA medida que el juego avanza el ritmo al que cambian las baldosas es mayor y tu tiempo de reacción es menor."
    };

    public MenuJuego() {
        menuIU = new MenuIU();

        menuIU.getComoJugarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarComoJugar(ventanaActual);
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

    public void mostrarComoJugar(int ventana) {
        JFrame frame = new JFrame("Cómo Jugar - Ventana " + ventana);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea mensajeTextArea = new JTextArea(mensajesComoJugar[ventana - 1]);
        mensajeTextArea.setWrapStyleWord(true);
        mensajeTextArea.setLineWrap(true);
        mensajeTextArea.setCaretPosition(0);

        JButton volverButton = new JButton("Volver al Menú Principal");
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                mostrarMenu();
            }
        });

        JButton siguienteButton = new JButton("Siguiente");
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (ventana < 4) {
                    ventanaActual = ventana + 1;
                    mostrarComoJugar(ventana + 1);
                } else {
                    mostrarMenu();
                }
            }
        });

        JButton anteriorButton = new JButton("Anterior");
        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (ventana > 1) {
                    ventanaActual = ventana - 1;
                    mostrarComoJugar(ventana - 1);
                } else {
                    mostrarMenu();
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(mensajeTextArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        if (ventana > 1) {
            buttonPanel.add(anteriorButton);
        }
        if (ventana < 4) {
            buttonPanel.add(siguienteButton);
        }
        buttonPanel.add(volverButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void mostrarParaQueSirve() {
        JFrame frame = new JFrame("Para qué Sirve el Juego");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea mensajeTextArea = new JTextArea(
            "Este juego pone en acción la habilidad para comparar patrones visuales, entrenando además la atención a los detalles y la velocidad perceptiva.\nEstas capacidades son relevantes cuando hay que hacerlo de forma rápida, por ejemplo al reconocer fotografías, caras, objetos cotidianos o palabras escritas."
        );
        mensajeTextArea.setWrapStyleWord(true);
        mensajeTextArea.setLineWrap(true);
        mensajeTextArea.setCaretPosition(0);

        JButton regresarButton = new JButton("Volver al Menú Principal");
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                mostrarMenu();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(mensajeTextArea, BorderLayout.CENTER);
        panel.add(regresarButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void iniciarJuego() {
        // Aquí puedes agregar la lógica para iniciar el juego.
        // Por ejemplo, abrir una nueva ventana de juego.
    }

    public void mostrarMenu() {
        ventanaActual = 1;
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
