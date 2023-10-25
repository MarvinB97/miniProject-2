import java.awt.*;
import javax.swing.*;

public class MenuIU extends JFrame {
    private JButton comoJugarButton;
    private JButton jugarButton;
    private JButton paraQueSirveButton;
    

    public MenuIU() {
        setTitle("Menú del Juego");
        setSize(1920, 1080); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.PINK); // Color de fondo
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        setContentPane(contentPane);

        // Establecer el diseño para el contenido
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); 

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        comoJugarButton = new JButton("Cómo jugar");
        jugarButton = new JButton("Jugar");
        paraQueSirveButton = new JButton("Para qué sirve");
        

        // Establecer el tamaño preferido de los botones
        comoJugarButton.setPreferredSize(new Dimension(200, 50));
        jugarButton.setPreferredSize(new Dimension(200, 50));
        paraQueSirveButton.setPreferredSize(new Dimension(200, 50));

        // Configurar la alineación de los botones
        comoJugarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jugarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        paraQueSirveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar los botones al panel
        buttonPanel.add(comoJugarButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre botones
        buttonPanel.add(jugarButton); 
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre botones
        buttonPanel.add(paraQueSirveButton);

        contentPane.add(Box.createVerticalGlue()); // Espacio en blanco arriba
        contentPane.add(buttonPanel);
        contentPane.add(Box.createVerticalGlue()); // Espacio en blanco abajo
    }

    public JButton getComoJugarButton() {
        return comoJugarButton;
    }

    public JButton getParaQueSirveButton() {
        return paraQueSirveButton;
    }

    public JButton getJugarButton() {
        return jugarButton;
    }

    public void mostrarVentana() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuIU menuIU = new MenuIU();
                menuIU.mostrarVentana();
            }
        });
    }
}
