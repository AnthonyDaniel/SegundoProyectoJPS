
package Controlador;

import Modelo.Administracion.IAdminEstudiante;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Vista.Administracion.AgregarEstudiante;
import Vista.Administracion.Estudiantes;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorAdminEstudiante {
   private InterfazAdministracion interfazAdministracion;
    private EntidadEstudiante estudiante;
    private IAdminEstudiante interfaceAdminEstudiante;
    private Estudiantes panelEstudiantes;
    private AgregarEstudiante agregarEstudiante;
    
    public ControladorAdminEstudiante(InterfazAdministracion e, IAdminEstudiante a, EntidadEstudiante r, Estudiantes es, AgregarEstudiante ae){
            panelEstudiantes=es;
            interfazAdministracion = e;
            interfaceAdminEstudiante = a;
            estudiante= r;
            agregarEstudiante=ae;
          
            interfazAdministracion.contenedorEstudiantes.add(es).repaint();
            interfazAdministracion.panelAgregarEstudiantes.add(ae).repaint();
            
            mostrarEnTabla();
            agregar();
            modificar();
            eliminar();
            buscar();
    }
    
    public void mostrarEnTabla(){
        
        interfazAdministracion.jRadioButtonEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                if(interfazAdministracion.jRadioButtonEstudiantes.isSelected()){
              try {
                        List<EntidadEstudiante> lista= interfaceAdminEstudiante.listar();

                        String[][] matriz = new String[lista.size()][5];

                        for(int i = 0; i<lista.size();i++){

                            EntidadEstudiante aux = lista.get(i);

                            matriz[i][0] = aux.getId()+"";
                            matriz[i][1] = aux.getNombre();
                            matriz[i][2] = aux.getApe1();
                            matriz[i][3] = aux.getContrasena();

                        }

                                interfazAdministracion.jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
                                     matriz,
                                    new String [] {
                                "ID", "Nombre", "Apellidos","Contrasenia"
                                   
                                    }
                                ));

                                } catch (Exception ex) {
                                   JOptionPane.showMessageDialog(null, "Error en el metodoAdministracion-> Comunicar al desarrollador");
                                }
                }
            
            }
        });
       
        }
    
     public void buscar(){
        interfazAdministracion.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                List<EntidadEstudiante> datos;
                try {
                    datos = interfaceAdminEstudiante.listarEstudiantes(
                            Integer.parseInt(interfazAdministracion.txtBuscar.getText()));
                   
                    JOptionPane.showMessageDialog(null, datos);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
            
        });
    }
    
     public void agregar(){
    
        JOptionPane.showMessageDialog(null, "EntroAgregar");
           agregarEstudiante.btnAgregar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   JOptionPane.showMessageDialog(null, "Escucho el metodo");
                   
                   estudiante.setId(agregarEstudiante.txtCedula.getText());
                   estudiante.setNombre(agregarEstudiante.txtNombre.getText());
                   estudiante.setApe1(agregarEstudiante.txtApellido.getText());
                   estudiante.setContrasena(agregarEstudiante.txtContrasenia.getText());
                   
                    panelEstudiantes.jTextFieldCedula.setText(agregarEstudiante.txtCedula.getText());
                    panelEstudiantes.jTextFieldNombre.setText(agregarEstudiante.txtNombre.getText());
                    panelEstudiantes.jTextFieldApellidos.setText(agregarEstudiante.txtApellido.getText());
                    panelEstudiantes.jTextFieldContrasena.setText(agregarEstudiante.txtContrasenia.getText());
                    
                   try {
                       if(interfaceAdminEstudiante.agregarEstudiante(estudiante));
                       else {
                           JOptionPane.showMessageDialog(null, "ErrorGuardar");
                       }
                   } catch (Exception ex) {
                       Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
               }
           });
    }
    
    public void modificar(){
    
        JOptionPane.showMessageDialog(null, "EntroModificar");
           panelEstudiantes.btnModificar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   JOptionPane.showMessageDialog(null, "Escucho el metodo modificar");
                   
                    
                   estudiante.setId(panelEstudiantes.jTextFieldCedula.getText());
                   estudiante.setNombre(panelEstudiantes.jTextFieldNombre.getText());
                   estudiante.setApe1(panelEstudiantes.jTextFieldApellidos.getText());
                   estudiante.setContrasena(panelEstudiantes.jTextFieldContrasena.getText());
                   
                  
                
                   try {
                       if(interfaceAdminEstudiante.modificarEstudiante(estudiante));
                       else {
                           JOptionPane.showMessageDialog(null, "ErrorGuardar");
                       }
                   } catch (Exception ex) {
                       Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
               }
           });
    }
    
    public void eliminar(){
    
        JOptionPane.showMessageDialog(null, "EntroModificar");
           panelEstudiantes.btnEliminar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   JOptionPane.showMessageDialog(null, "Escucho el metodo modificar");
                       
                   estudiante.setId(panelEstudiantes.jTextFieldCedula.getText());
                   estudiante.setNombre(panelEstudiantes.jTextFieldNombre.getText());
                   estudiante.setApe1(panelEstudiantes.jTextFieldApellidos.getText());
                   estudiante.setContrasena(panelEstudiantes.jTextFieldContrasena.getText());
                   
                
                   try {
                       if(interfaceAdminEstudiante.eliminarEstudiante(estudiante));
                       else {
                           JOptionPane.showMessageDialog(null, "ErrorGuardar");
                       }
                   } catch (Exception ex) {
                       Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
               }
           });
    }
}
