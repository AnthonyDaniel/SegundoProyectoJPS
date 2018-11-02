
package controlador;

import modelo.Prueba;
import vista.Vista;


public class controlador {
    
    //Unicamente crearemos el objeto aca
    public Vista vista;
    private Prueba prueba;
    
    public controlador(){
        vista = new Vista();
        prueba = new Prueba(vista);
    }
    
}
