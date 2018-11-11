
package Controlador;


import Modelo.Login.ILogin;
import Modelo.Login.Login;
import Vista.InterfazPrincipal;
import Vista.Login.PanelLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ControladorLogin {
   
    public ILogin login;
    private PanelLogin panelLogin;
    private InterfazPrincipal interfazPrincipal;
    public ControladorLogin(InterfazPrincipal e){
            interfazPrincipal = e;
            login = new Login(e);
            panelLogin = new PanelLogin();
        
            BotonLogearse();
     
            
    }
    private void BotonLogearse(){
        interfazPrincipal.jButtonLogear.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent me) {
                interfazPrincipal.prueba.add(panelLogin).repaint();
                JOptionPane.showMessageDialog(null, "Parece que esta bien");
             }
        });
       
    }
    private void Logearse(){
        login.Logear();
 
    }
    private void CerrarSesion(){
    
    }
}
