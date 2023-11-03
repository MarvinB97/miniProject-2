/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Vista.Vista;
import Modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author Xavier , Marvin Nuñez
 */
public class Controller {
    private Modelo model;
    private Vista view;
    
    public Controller(Modelo model, Vista view) {
        this.model = model;
        this.view = view;

        view.presionarListener(new clickListener());
        view.sonidoOnOffListener(new songListener());
        view.goMenu(new menuListener());
        view.goJuego(new jugarListener());
        view.goInstrucciones(new instruccionesListener());
    }
    
    
    
    public void startTimer() {
       	Timer timer = new Timer();
         
        TimerTask tarea = new TimerTask(){
             @Override
             public void run() {
            	 avanzarVista();
            	 actualizarVista();
            	 
            	 stopTime();
            	
            	 //---Reducir vidas solo al clickear erroneamente
            	 //---o al no clickear habiendo imagenes repetidas
            	 if(model.getCounter()==0) {
            		 if(model.verificarEleccion()) {
                  		 model.addErrores();
                  		 model.dicreaseVida();
                  	 }
            	 }
        		 if(model.getVidas()<=0) {
        			 timer.cancel();
        			 view.setTxtLblResultados(model.getTxtResultados());
        			 view.setVista(0);
        		 }
        		 
        		 model.setCounter(0);
            	 
             }};
             
             timer.schedule(tarea,0,100);
         
    }
    
    
    //-----cambio el inicio o final del timer.shedule
    public void changePeriodT() {
    	model.changePeriodTimer();
    }
    
    
    //para el tiempo por 6 seg.
    public void stopTime() {
    	try {
    		TimeUnit.SECONDS.sleep(model.getPeriodTime());
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}
    }


    class clickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	if(model.verificarEleccion()) {
        		model.addAcierto();
        		model.addPuntaje();
        	}else {
        		model.addErrores();
        		model.dicreaseVida();
        	}
        	
        	model.changePeriodTimer();
        	model.setCounter(1);
        	
        }
    }

    class songListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//soooonidooo();
        }
    }
    
    
    class jugarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	model.resetearValores();
        	avanzarVista();
        	startTimer();
        	view.setVista(1);
        }
    }
    
    class menuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	view.setVista(2);
        }
    }
    
    class instruccionesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	view.setVista(3);
        }
    }
    


    //---------REFRESCAR PANTALLA----------
    private void actualizarVista() {    	
    	int indexRepeat = model.setBoolImage();
    	
    	if(indexRepeat == -1) {
    		indexRepeat = model.getRepeatIndex(); //poner aleatorio (recomendacion)
    	}
    	
    	for(int i = 0;i < model.getNumImag(); i++) {
    		if(indexRepeat == i) {
    			view.setImagen(i,model.getIndiceImagen(i),true);
    		}else{
    			view.setImagen(i,model.getIndiceImagen(i),false);    			
    		}
    	}
    	
    	for(int i = model.getNumImag(); i < 8; i++) {
    			view.setImagen(i,0,false);
    	}
    	
    	view.setTxtPuntaje("00" + model.getPuntaje());
		view.setTxtLblVidas("___________________________Vidas: "+(model.getVidas()));
    	
    }
    //--------ACTUALIZAR PANTALLA Y VALORES
    private void avanzarVista() {
    	model.cambiarOrdenImagenes();
    	model.addNumImag();
    }
    
    
}
