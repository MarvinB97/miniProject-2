/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Xavier , Marvin Nuñez
 * File: Main.java
 * Relaciones: clase principal en donde se ejecuta el codigo
 * Ultima modificacion 06-10-23
 * ------------------------------------------------------------
 */

package Modelo;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Xavier , Marvin Nuñez
 */
public class Modelo {
    private int vidas, puntaje, aciertos, errores, counter, periodTimer, numImag,randomNum;
    private Vector<Integer> indiceImagenes = new Vector<Integer>(13);
    private Vector<Boolean> setBorderImagen = new Vector<Boolean>(8);   
    
    

    public Modelo() {
    	vidas = 4;
    	puntaje = 0;
    	aciertos = 0;
    	errores = 0;
    	counter = 0;
    	numImag = 2;
    	
    	periodTimer = 6;
    	
    	for(int i = 0; i<13; i++) {
    		indiceImagenes.add(0);
    	}
    	
    	for(int i = 0; i<8; i++) {
    		setBorderImagen.add(false);
    	}
    }
    
    
    
    
    //Mezcla de forma aleatoria las imagenes
    public void cambiarOrdenImagenes() {
    	//num aleatorio entre 1-12
    	//nos da el indice de la imagen repetida
    	this.randomNum = 1+(int)(Math.random() * (12));
    	
    	for(int i = 0; i<12; i++) {
    		this.indiceImagenes.set(i,i+1);
    	}
    	
		this.indiceImagenes.set(12,this.randomNum);
    	
    	Collections.shuffle(this.indiceImagenes);
    }
    

    
    public int setBoolImage() {
    	int value = -1;//valor diferente al esperado
    	    	
    	for(int i = 0;i < this.numImag; i++) {
    		for(int j = i+1;j < this.numImag; j++) {
    			if(this.indiceImagenes.get(i) == this.indiceImagenes.get(j)) {
    				value = i;
    			}
    		}
    	}
    	return value;
    }
    
    public boolean verificarEleccion() {
    	boolean value = false;
    	    	
    	for(int i = 0;i < this.numImag; i++) {
    		for(int j = i+1;j < this.numImag; j++) {
    			if(this.indiceImagenes.get(i) == this.indiceImagenes.get(j)) {
    				value = true;
    			}
    		}
    	}
    	
    	return value;
    }
    
    
    
    

    public void addPuntaje() {
    	this.puntaje++;
    }
    
    public void addAcierto() {
        this.aciertos++;
    }

    public void addErrores() {
        this.errores++;
    }
    
    public void dicreaseVida() {
    	this.vidas--;
    }
    
    public void addCounter() {
    	this.counter++;
    }
    
    public void addNumImag() {
    	if(this.numImag < 8) {
    		this.numImag++;
    	}
    }
    
    public void changePeriodTimer() {
    	this.periodTimer = periodTimer - 1;
    }
    
    
    //valor de counter = 0, si se da click el valor es 1
    public void setCounter(int value) {
    	this.counter = value;
    }
    
    
    
    //----metodos getters----------
    public int getPeriodTime() {
    	return this.periodTimer;
    }
    
    public int getRepeatIndex() {
    	//num aleatorio entre 0-numImag
    	//nos da el indice de la imagen repetida
    	return (int)(Math.random() * (this.numImag));
    }
    
    public int getIndiceImagen(int ind) {
    	return this.indiceImagenes.get(ind);
    }
    
    public int getCounter() {
    	return this.counter;
    }
    
    public int getNumImag() {
    	return this.numImag;
    }
    
    public int getErrores() {
    	return this.errores;
    }
    
    public int getVidas() {
    	return this.vidas;
    }
    
    public int getPuntaje() {
    	return this.puntaje;
    }
    
    public String getTxtResultados() {
    	String txt = "<html><h2><b>Resultados:</b></h2>"
    			+ "<p>---------------------------</p>"
    			+ "<p>Puntaje:...............00"+this.puntaje + "</p>"
    			+ "<p>Aciertos:.............."+this.aciertos + "</p>"
    			+ "<p>Errores:..............."+this.errores + "</p></html>";
    	
    	return txt;
    }
    
    
    
    
    
    //--------reiniciar los valores--------
    public void resetearValores() {
    	this.vidas = 4;
    	this.puntaje = 0;
    	this.aciertos = 0;
    	this.errores = 0;
    	this.counter = 0;
    	this.numImag = 2;
    	
    	periodTimer = 6;
    
    	
    }
    
    
}
