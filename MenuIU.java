import java.awt.*;
import javax.swing.*;


public class MenuIU extends JFrame {
    private JButton comoJugarButton;
    private JButton paraQueSirveButton;
    private JButton jugarButton;

    public MenuIU() {
        setTitle("Menú del Juego");
        setSize(1920, 1080); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        comoJugarButton = new JButton("Cómo jugar");
        jugarButton = new JButton("Jugar");
        paraQueSirveButton = new JButton("Para qué sirve");
       

        // Establecer el tamaño preferido de los botones
        comoJugarButton.setPreferredSize(new Dimension(200, 50));
        jugarButton.setPreferredSize(new Dimension(200, 50));
        paraQueSirveButton.setPreferredSize(new Dimension(200, 50));
        
        
        comoJugarButton.setBackground(Color.LIGHT_GRAY);
        comoJugarButton.setForeground(Color.BLACK);
        jugarButton.setBackground(Color.GREEN);
        jugarButton.setForeground(Color.WHITE);
        paraQueSirveButton.setBackground(Color.BLUE);
        paraQueSirveButton.setForeground(Color.WHITE);
        

        // Agregar los botones al panel
        buttonPanel.add(Box.createHorizontalGlue()); // Espacio en blanco a la izquierda
        buttonPanel.add(comoJugarButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre botones
        buttonPanel.add(jugarButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre botones
        buttonPanel.add(paraQueSirveButton);
        buttonPanel.add(Box.createHorizontalGlue()); // Espacio en blanco a la derecha

        add(buttonPanel);
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
}
