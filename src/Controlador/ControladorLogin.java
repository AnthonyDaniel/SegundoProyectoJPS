
package Controlador;

import Modelo.Login.ILogin;
import Modelo.Login.LoginMetodos;
import Vista.Interfaz;
import Vista.Administracion.InterfazAdministracion;
import Vista.Estudiante.InterfazEstudiante;
import Vista.Login.InterfazLogin;
import Vista.Profesor.InterfazProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ControladorLogin {
    
    private Interfaz interfaz;
    private InterfazLogin interfazLogin;
    private ILogin login;
    private InterfazAdministracion administracion;
    private InterfazProfesor profesor;
    private InterfazEstudiante estudiante;
    
    public ControladorLogin(Interfaz e, InterfazLogin a, ILogin lm, InterfazAdministracion _administracion, InterfazProfesor _profesor, InterfazEstudiante _estudiante){
    
        interfazLogin = a;
        interfaz = e;
        login = lm;
        administracion = _administracion;
        profesor = _profesor;
        estudiante = _estudiante;
        AceptarClick(e,a);
        EventoEnterAceptar(e, a);
    }
    
    private void AceptarClick(Interfaz e, InterfazLogin a){
    
        interfazLogin.jButtonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
               ValidarDatos( e,  a);
            
            }
        });
    
    }
    
    private void EventoEnterAceptar(Interfaz e, InterfazLogin a){
        interfazLogin.jButtonAceptar.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent ke) { //Captura la tecla precionada
               if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                   ValidarDatos( e,  a);
               }
            }
        });
    
    }
    
    private void ValidarDatos(Interfaz e, InterfazLogin a){
         if(!interfazLogin.jTextFieldCedula.getText().equals("") &&!interfazLogin.jPasswordFieldContrasena.getText().equals("")){
                    
                        interfazLogin.jLabelMensaje.setText("");

                        if(login.verificarUsuario(interfazLogin.jTextFieldCedula.getText(),interfazLogin.jPasswordFieldContrasena.getText())){
                        
                              a.dispose();
                              
                              if(login.verificarQueTipoDeUsuarioEs().equals("Administrador")){
                                  e.panelContenedor.add(administracion).repaint();
                              }else if(login.verificarQueTipoDeUsuarioEs().equals("Estudiante")){
                                  e.panelContenedor.add(estudiante).repaint();
                              }else{
                                  e.panelContenedor.add(profesor).repaint();
                              }
                              Limpiar();
                              e.setVisible(true);
                       
                        }else{
                            
                            interfazLogin.jLabelMensaje.setText("El Usuario no existe");

                        }
                }else{
                  
                    interfazLogin.jLabelMensaje.setText("No debes dejar espacios en blancos");
                    
                }
    }
    
    private void Limpiar(){
        
        interfazLogin.jTextFieldCedula.setText("");
        interfazLogin.jPasswordFieldContrasena.setText("");
    
    }
}
