
package Controlador;

import Modelo.Administracion.IAdminProfesor;
import Modelo.Entidades.EntidadProfesor;
import Vista.Administracion.AgregarProfesor;
import Vista.Administracion.InterfazAdministracion;
import Vista.Administracion.Profesores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorAdminProfesor {
     private InterfazAdministracion interfazAdministracion;
    private EntidadProfesor profesor;
    private IAdminProfesor interfaceAdminProfesor;
    private Profesores panelProfesores;
    private AgregarProfesor agregarProfesor;
    
    public ControladorAdminProfesor(InterfazAdministracion e, IAdminProfesor a, EntidadProfesor r, Profesores es, AgregarProfesor ae){
            panelProfesores=es;
            interfazAdministracion = e;
            interfaceAdminProfesor = a;
            profesor= r;
            agregarProfesor=ae;
            
            interfazAdministracion.contenedorProfesores.add(es).repaint();
            interfazAdministracion.panelAgregarProfesores.add(ae).repaint();
            
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
                        List<EntidadProfesor> lista= interfaceAdminProfesor.listar();

                        String[][] matriz = new String[lista.size()][5];

                        for(int i = 0; i<lista.size();i++){

                            EntidadProfesor aux = lista.get(i);

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
                List<EntidadProfesor> datos;
                try {
                    datos = interfaceAdminProfesor.listarProfesor(
                            Integer.parseInt(interfazAdministracion.txtBuscar.getText()));
                   
                    JOptionPane.showMessageDialog(null, datos);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
            
        });
    }
    
     public void agregar(){
    
           agregarProfesor.btnAgregar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   
                  profesor.setId(agregarProfesor.txtCedula.getText());
                   profesor.setNombre(agregarProfesor.txtNombre.getText());
                   profesor.setApe1(agregarProfesor.txtApellido.getText());
                   profesor.setContrasena(agregarProfesor.txtContrasenia.getText());
   
                    
                   try {
                       if(interfaceAdminProfesor.agregarProfesor(profesor));
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
    
           panelProfesores.btnModificar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   
                    profesor.setId(panelProfesores.jTextFieldCedula.getText());
                   profesor.setNombre(panelProfesores.jTextFieldNombre.getText());
                   profesor.setApe1(panelProfesores.jTextFieldApellidos.getText());
                   profesor.setContrasena(panelProfesores.jTextFieldContrasena.getText());
                   
                   
                
                   try {
                       if(interfaceAdminProfesor.modificarProfesor(profesor));
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
   
           panelProfesores.btnEliminar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                       
                   profesor.setId(panelProfesores.jTextFieldCedula.getText());
                   profesor.setNombre(panelProfesores.jTextFieldNombre.getText());
                   profesor.setApe1(panelProfesores.jTextFieldApellidos.getText());
                   profesor.setContrasena(panelProfesores.jTextFieldContrasena.getText());
                   
                
                   try {
                       if(interfaceAdminProfesor.eliminarProfesor(profesor));
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
