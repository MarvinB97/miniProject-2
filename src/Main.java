/*
 * ------------------------------------------------------------
 * Name Proyecto: miniProyecto-1
 * nombre participantes: Xavier , Marvin Nuñez
 * File: Main.java
 * Relaciones: clase principal en donde se ejecuta el codigo
 * Ultima modificacion 06-10-23
 * ------------------------------------------------------------
 */


//Se importan las librerias
//import javax.swing.*;

import Controller.Controller;
import Modelo.Modelo;
import Vista.Vista;

/**
 *
 * @author Xavier , Marvin Nuñez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Modelo model = new Modelo();
        Vista view = new Vista();
        Controller controller = new Controller(model, view);
    }
    
}
