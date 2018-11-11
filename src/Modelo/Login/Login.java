
package Modelo.Login;

import Vista.InterfazPrincipal;
import Vista.Login.PanelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Login implements ILogin{
    private InterfazPrincipal interfazPrincipal;
    
    public Login(InterfazPrincipal e){
        
        interfazPrincipal = e;
    }

    @Override
    public boolean Logear() {
      
        return false;
    }

    @Override
    public boolean CerrarSesion() {
       JOptionPane.showMessageDialog(null, "Cerrando sesion....");
        return false;
    }
    
}
