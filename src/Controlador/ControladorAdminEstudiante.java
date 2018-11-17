
package Controlador;

import Modelo.Administracion.IAdminEstudiante;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadNota;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarEstudiante;
import Vista.Administracion.AgregarMaterias;
import Vista.Administracion.Estudiantes;
import Vista.Administracion.FichasAsignatura;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class ControladorAdminEstudiante {
   public InterfazAdministracion interfazAdministracion;
    public EntidadEstudiante estudiante;
    public IAdminEstudiante interfaceAdminEstudiante;
    public Estudiantes panelEstudiantes;
    public AgregarEstudiante agregarEstudiante;
    public AgregarMaterias agregarMateria;
    
    public ControladorAdminEstudiante(InterfazAdministracion e, IAdminEstudiante a, EntidadEstudiante r, Estudiantes es, AgregarEstudiante ae,AgregarMaterias an){
            panelEstudiantes=es;
            interfazAdministracion = e;
            interfaceAdminEstudiante = a;
            estudiante= r;
            agregarEstudiante=ae;
            agregarMateria=an;
          
            interfazAdministracion.contenedorEstudiantes.add(ae).repaint();
            interfazAdministracion.panelAgregarEstudiantes.add(es).repaint();
            interfazAdministracion.panelAgregarMaterias.add(an).repaint();
            
            mostrarEnTabla();
            mostrarEnPanel();
            agregar();
            modificar();
            eliminar();
            buscar();
            DefaultTabla();
            Materias();
            AgregarMateria();
    }
    
    public void Materias(){
    
        List<EntidadAsignatura> materias;
       try {
           
         materias = interfaceAdminEstudiante.listarAsignaturas();
           
        agregarMateria.jComboBoxMaterias.removeAllItems();
        agregarMateria.jComboBoxMaterias.addItem("");
       
        for(EntidadAsignatura e:materias){
        
            agregarMateria.jComboBoxMaterias.addItem(e.getIdAsignatura());
               
        }
       } catch (Exception ex) {
           Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    
    }
    
     public void AgregarMateria(){
    agregarMateria.btnAgregar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
             
                    String ced= agregarMateria.txtCedula.getText();
                    
                    String idA=agregarMateria.jComboBoxMaterias.getSelectedItem().toString();
                
                    interfaceAdminEstudiante.ponerAsignatura(ced,idA);
                    JOptionPane.showMessageDialog(null,"Asignatura Agregada");
        }
    
    });
  }
    public void DefaultTabla(){
    
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
    
      
       public void mostrarEnPanel(){
    
        interfazAdministracion.panelAgregarEstudiantes.removeAll();
        Estudiantes fa;
      
       try {
           for(EntidadEstudiante e: interfaceAdminEstudiante.listar()){
               fa = null;
               fa = new Estudiantes(this);
               fa.jTextFieldCedula.setText(e.getId());
               fa.jTextFieldNombre.setText(e.getNombre());
               fa.jTextFieldApellidos.setText(e.getApe1());
               fa.jTextFieldContrasena.setText(e.getContrasena());
               
               interfazAdministracion.panelAgregarEstudiantes.add(fa).repaint();
               
           }
       } catch (Exception ex) {
           Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
       }
            interfazAdministracion.panelAgregarEstudiantes.updateUI();
         
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
    
           agregarEstudiante.btnAgregar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   
                   estudiante.setId(agregarEstudiante.txtCedula.getText());
                   estudiante.setNombre(agregarEstudiante.txtNombre.getText());
                   estudiante.setApe1(agregarEstudiante.txtApellido.getText());
                   estudiante.setContrasena(agregarEstudiante.txtContrasenia.getText());
                   
                    panelEstudiantes.jTextFieldCedula.setText(agregarEstudiante.txtCedula.getText());
                    panelEstudiantes.jTextFieldNombre.setText(agregarEstudiante.txtNombre.getText());
                    panelEstudiantes.jTextFieldApellidos.setText(agregarEstudiante.txtApellido.getText());
                    panelEstudiantes.jTextFieldContrasena.setText(agregarEstudiante.txtContrasenia.getText());
                  
                   try {
                       if(interfaceAdminEstudiante.agregarEstudiante(estudiante)){
                             JOptionPane.showMessageDialog(null, "Agregado");
                       }
                     
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
    
           panelEstudiantes.btnModificar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   
                    
                   estudiante.setId(panelEstudiantes.jTextFieldCedula.getText());
                   estudiante.setNombre(panelEstudiantes.jTextFieldNombre.getText());
                   estudiante.setApe1(panelEstudiantes.jTextFieldApellidos.getText());
                   estudiante.setContrasena(panelEstudiantes.jTextFieldContrasena.getText());
                   
                  
                
                   try {
                       if(interfaceAdminEstudiante.modificarEstudiante(estudiante))
                           mostrarEnPanel();
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
    
           panelEstudiantes.btnEliminar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                       
                   estudiante.setId(panelEstudiantes.jTextFieldCedula.getText());
                   estudiante.setNombre(panelEstudiantes.jTextFieldNombre.getText());
                   estudiante.setApe1(panelEstudiantes.jTextFieldApellidos.getText());
                   estudiante.setContrasena(panelEstudiantes.jTextFieldContrasena.getText());
                   
                
                   try {
                       if(interfaceAdminEstudiante.eliminarEstudiante(estudiante))
                           mostrarEnPanel();
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
