
package Controlador;

import Modelo.Administracion.IAdminEstudiante;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadNota;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarEstudiante;
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
    
    public ControladorAdminEstudiante(InterfazAdministracion e, IAdminEstudiante a, EntidadEstudiante r, Estudiantes es, AgregarEstudiante ae){
            panelEstudiantes=es;
            interfazAdministracion = e;
            interfaceAdminEstudiante = a;
            estudiante= r;
            agregarEstudiante=ae;
          
            interfazAdministracion.contenedorEstudiantes.add(ae).repaint();
            interfazAdministracion.panelAgregarEstudiantes.add(es).repaint();
            
            mostrarEnTabla();
            mostrarEnPanel();
            agregar();
            modificar();
            eliminar();
            buscar();
            DefaultTabla();
            Materias();
    }
    
    public void Materias(){
    
              
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
        session.beginTransaction();
   
        List<EntidadAsignatura> materias;
       
        materias=session.createCriteria(EntidadAsignatura.class).list();
       
        session.getTransaction().commit();
        session.close();
       
        agregarEstudiante.jComboBoxMateria1.removeAllItems();
        agregarEstudiante.jComboBoxMateria2.removeAllItems();
        agregarEstudiante.jComboBoxMateria3.removeAllItems();
        agregarEstudiante.jComboBoxMateria4.removeAllItems();
        agregarEstudiante.jComboBoxMateria5.removeAllItems();
        agregarEstudiante.jComboBoxMateria6.removeAllItems();
                
        agregarEstudiante.jComboBoxMateria1.addItem("");
        agregarEstudiante.jComboBoxMateria2.addItem("");
        agregarEstudiante.jComboBoxMateria3.addItem("");
        agregarEstudiante.jComboBoxMateria4.addItem("");
        agregarEstudiante.jComboBoxMateria5.addItem("");
        agregarEstudiante.jComboBoxMateria6.addItem("");
                
        for(EntidadAsignatura e:materias){
        
            agregarEstudiante.jComboBoxMateria1.addItem(e.getNombre() + "" + e.getHorario());
            agregarEstudiante.jComboBoxMateria2.addItem(e.getNombre() + "" + e.getHorario());
            agregarEstudiante.jComboBoxMateria3.addItem(e.getNombre() + "" + e.getHorario());
            agregarEstudiante.jComboBoxMateria4.addItem(e.getNombre() + "" + e.getHorario());
            agregarEstudiante.jComboBoxMateria5.addItem(e.getNombre() + "" + e.getHorario());
            agregarEstudiante.jComboBoxMateria6.addItem(e.getNombre() + "" + e.getHorario());
               
        }
    
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
                    
                    EntidadNota e1 = new EntidadNota();
                    EntidadNota e2 = new EntidadNota();
                    EntidadNota e3 = new EntidadNota();
                    EntidadNota e4 = new EntidadNota();
                    EntidadNota e5 = new EntidadNota();
                    EntidadNota e6 = new EntidadNota();
                    
                          Session session = new HibernateUtil().buildSessionFactory().openSession();        
                          session.beginTransaction();
   
                          List<EntidadAsignatura> materias;
       
                          materias=session.createCriteria(EntidadAsignatura.class).list();
       
                          
                   
                         for(EntidadAsignatura o : materias){
                         try{
                             if(agregarEstudiante.jComboBoxMateria1.getSelectedItem().equals(o.getNombre() + "" + o.getHorario())){
                             
                                 e1.setAsignatura(o);
                             
                             }
                             if(agregarEstudiante.jComboBoxMateria2.getSelectedItem().equals(o.getNombre() + "" + o.getHorario())){
                             
                                 e2.setAsignatura(o);
                             
                             }
                            if(agregarEstudiante.jComboBoxMateria3.getSelectedItem().equals(o.getNombre() + "" + o.getHorario())){
                             
                                 e3.setAsignatura(o);
                             
                             }
                             if(agregarEstudiante.jComboBoxMateria4.getSelectedItem().equals(o.getNombre() + "" + o.getHorario())){
                             
                                 e4.setAsignatura(o);
                             
                             }
                             if(agregarEstudiante.jComboBoxMateria5.getSelectedItem().equals(o.getNombre() + "" + o.getHorario())){
                             
                                 e5.setAsignatura(o);
                             
                             }
                             if(agregarEstudiante.jComboBoxMateria6.getSelectedItem().equals(o.getNombre() + "" + o.getHorario())){
                             
                                 e6.setAsignatura(o);
                             
                             }
                         }catch(Exception e){}
                    
                         }
                         //Pruebas
                     try{
                     e1.setEstudiante(estudiante);
                     
                   //  estudiante.getNota().add(e1);
                     session.save(e1);
                     }catch(Exception r){
                     JOptionPane.showMessageDialog(null,"Error");
                     }
                     try{
                     e2.setEstudiante(estudiante);    
                     estudiante.getNota().add(e2);
                     session.save(e2);
                     }catch(Exception r){}
                     try{
                     e3.setEstudiante(estudiante);   
                     estudiante.getNota().add(e3);
                     session.save(e3);
                     }catch(Exception r){}
                     try{
                     e4.setEstudiante(estudiante);    
                     estudiante.getNota().add(e4);
                     session.save(e4);
                     }catch(Exception r){}
                     try{ 
                     e5.setEstudiante(estudiante);    
                     estudiante.getNota().add(e5);
                     session.save(e5);
                     }catch(Exception r){}
                     try{ 
                     e6.setEstudiante(estudiante);    
                     estudiante.getNota().add(e6);
                     session.save(e6);
                     }catch(Exception r){}
                     
                    session.getTransaction().commit();
                    session.close(); 
                    
                   try {
                       if(interfaceAdminEstudiante.agregarEstudiante(estudiante))
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
