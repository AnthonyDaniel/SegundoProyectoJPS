
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Vista;

public class Prueba{
    private Vista vista; // Creo un instancia sin asignarle ningun valor
    public Prueba(Vista vistaEnviadoDesdeElControlador){
        vista = vistaEnviadoDesdeElControlador;
        funcionBoton();
    }
    
    void funcionBoton(){
            
        vista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Welcome");
            }
        });
    }
  
}
