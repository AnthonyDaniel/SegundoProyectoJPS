
package Controlador;

import Vista.Interfaz;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin {
    
    private Interfaz interfaz;
    
    public ControladorLogin(Interfaz e, Login a){
    
        interfaz = e;
        BotonAceptar(e,a);
        
    }
    
    private void BotonAceptar(Interfaz e, Login a){

       a.jButtonAceptar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              a.dispose();
              e.setVisible(true);
           }
       });
        
        
    }
    
    
}
