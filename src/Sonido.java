
package Modelo;

import javax.sound.sampled.*;
import java.io.*;


public class Sonido {

	public Sonido() {
		// TODO Auto-generated constructor stub
	}
	
	public void realizarSonido(String nombreSonido){
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	        System.out.println("Error al reproducir el sonido.");
	        }
	     }

}
