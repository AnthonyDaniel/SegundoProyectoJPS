
package Controlador;

import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Interfaz;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin {
    
    private Interfaz interfaz;
    private Login interfazLogin;
    private ILogin login;
    
    public ControladorLogin(Interfaz e, Login a, ILogin lm){
    
        interfazLogin = a;
        interfaz = e;
        login = lm;
        Validar(e,a);
    }
    
    private void Validar(Interfaz e, Login a){
    
        interfazLogin.jButtonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                if(!interfazLogin.jTextFieldCedula.getText().equals("") &&!interfazLogin.jPasswordFieldContrasena.getText().equals("")){
                    
                        interfazLogin.jLabelMensaje.setText("");

                        if(login.verificarUsuario(interfazLogin.jTextFieldCedula.getText(),interfazLogin.jPasswordFieldContrasena.getText())){
                        
                              a.dispose();
                              e.setVisible(true);
                       
                        }else{
                            
                            interfazLogin.jLabelMensaje.setText("El Usuario no existe");

                        }
                }else{
                  
                    interfazLogin.jLabelMensaje.setText("No debes dejar espacios en blancos");
                    
                }
            
            }
        });
    
    }
    
}
