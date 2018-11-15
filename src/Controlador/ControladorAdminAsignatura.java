
package Controlador;

import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarAsignatura;
import Vista.Administracion.AgregarEstudiante;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class ControladorAdminAsignatura {
    
    private InterfazAdministracion interfazAdministracion;
    private EntidadAsignatura asignatura;
    private IAsignatura interfaceAsignatura;
    private AgregarAsignatura agregarAsignatura;
    private List<EntidadProfesor>  datos;
    
    public ControladorAdminAsignatura(InterfazAdministracion e, IAsignatura a, EntidadAsignatura r, AgregarAsignatura aa){
     
            agregarAsignatura = aa;
            interfazAdministracion = e;
            interfaceAsignatura = a;
            asignatura= r;
            interfazAdministracion.panelAgregar.add(aa).repaint();
            comboBox();
            mostrarEnTabla();
            Agregar();
           //Modificar();
            //Eliminar();
        
    }
    
    public List<EntidadProfesor> comboBox(){
        
        agregarAsignatura.jComboBoxProfesores.removeAllItems();
        
        Session session = new HibernateUtil().buildSessionFactory().openSession();        
                    session.beginTransaction();
   
                    datos=session.createCriteria(EntidadProfesor.class).list();
        
                    session.getTransaction().commit();
                    session.close();
                   
                    for(EntidadProfesor e: datos){
                        
                        agregarAsignatura.jComboBoxProfesores.addItem(e.getNombre());
                    
                    }
                    
                    
            return datos;
    
    }
    
    public void mostrarEnTabla(){
        
        interfazAdministracion.jRadioButonAsignaturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                if(interfazAdministracion.jRadioButonAsignaturas.isSelected()){
                    try {
                        List<EntidadAsignatura> lista= interfaceAsignatura.listar();

                        String[][] matriz = new String[lista.size()][4];

                        for(int i = 0; i<lista.size();i++){

                            EntidadAsignatura aux = lista.get(i);

                            matriz[i][0] = aux.getIdAsignatura()+"";
                            matriz[i][1] = aux.getNombre();
                            matriz[i][2] = aux.getProfesor().getNombre();

                        }

                                interfazAdministracion.jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
                                     matriz,
                                    new String [] {
                                "ID", "Nombre", "PROFESER"
                                    }
                                ));

                                } catch (Exception ex) {
                                   JOptionPane.showMessageDialog(null, "Error en el metodoAdministracion-> Comunicar al desarrollador");
                                }
                }
            
            }
        });
       
        }
    
    public void Agregar(){
    
        JOptionPane.showMessageDialog(null, "EntroAgregar");
           agregarAsignatura.jButtonAgregar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   JOptionPane.showMessageDialog(null, "Escucho el metodo");
                 
                   asignatura.setNombre(agregarAsignatura.jTextFieldNombre.getText());
                   asignatura.setIdAsignatura(agregarAsignatura.jTextFieldId.getText());
                   asignatura.setHorario(agregarAsignatura.jTextFieldHorario.getText());
                   
                   
                   String as = agregarAsignatura.jComboBoxProfesores.getSelectedItem()+ "";
                   
                   JOptionPane.showMessageDialog(null, as);
                   
                   for (EntidadProfesor e : datos){
                       
                       if(e.getNombre().equals(as)){
                           asignatura.setProfesor(e);
                           JOptionPane.showMessageDialog(null, "1");
                       }
                       JOptionPane.showMessageDialog(null, "2");
                   }
                   
                   JOptionPane.showMessageDialog(null, asignatura.getProfesor().getNombre());
                   
                  if(interfaceAsignatura.validarDatos()){
                
                   if(interfaceAsignatura.agregarAsignatura(asignatura));
                   else {
                   JOptionPane.showMessageDialog(null, "ErrorGuardar");
                   }
                  }else{
               
                   JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios");
               }
               }
           });
    }
    
    public void Modificar(){
    
        JOptionPane.showMessageDialog(null, "EntroModificar");
           agregarAsignatura.jButtonModificar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   JOptionPane.showMessageDialog(null, "Escucho el metodo modificar");
                   EntidadProfesor s = new EntidadProfesor();
                   s.setId("Julio");
                   s.setContrasena("1234");
                   s.setApe1("Bolivar");
                   s.setNombre("Nombre");
                   asignatura.setNombre(agregarAsignatura.jTextFieldNombre.getText());
                   asignatura.setIdAsignatura(agregarAsignatura.jTextFieldId.getText());
                   asignatura.setHorario(agregarAsignatura.jTextFieldHorario.getText());
                   asignatura.setProfesor(s);
                   
                  if(interfaceAsignatura.validarDatos()){
                
                   if(interfaceAsignatura.modificarAsignatura(asignatura));
                   else {
                     JOptionPane.showMessageDialog(null, "ErrorGuardar");
                   }
                  }else{
               
                   JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios");
               }
               }
           });
    }
    
    public void Eliminar(){
    
        JOptionPane.showMessageDialog(null, "EntroModificar");
           agregarAsignatura.jButtonModificar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   JOptionPane.showMessageDialog(null, "Escucho el metodo modificar");
                   EntidadProfesor s = new EntidadProfesor();
                   s.setId("Julio");
                   s.setContrasena("1234");
                   s.setApe1("Bolivar");
                   s.setNombre("Nombre");
                   asignatura.setNombre(agregarAsignatura.jTextFieldNombre.getText());
                   asignatura.setIdAsignatura(agregarAsignatura.jTextFieldId.getText());
                   asignatura.setHorario(agregarAsignatura.jTextFieldHorario.getText());
                   asignatura.setProfesor(s);
                   
                  if(interfaceAsignatura.validarDatos()){
                
                   if(interfaceAsignatura.eliminarAsignatura(asignatura));
                   else {
                     JOptionPane.showMessageDialog(null, "ErrorGuardar");
                   }
                  }else{
               
                   JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios");
               }
               }
           });
    }
    
   }
    