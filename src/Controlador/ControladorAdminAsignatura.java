
package Controlador;

import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import Modelo.Hibernate.HibernateUtil;
import Vista.Administracion.AgregarAsignatura;
import Vista.Administracion.AgregarEstudiante;
import Vista.Administracion.FichasAsignatura;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class ControladorAdminAsignatura {
    
    public InterfazAdministracion interfazAdministracion;
    public EntidadAsignatura asignatura;
    public IAsignatura interfaceAsignatura;
    public AgregarAsignatura agregarAsignatura;
    public List<EntidadProfesor>  datos;
    
    public ControladorAdminAsignatura(InterfazAdministracion e, IAsignatura a, EntidadAsignatura r, AgregarAsignatura aa){
     
            agregarAsignatura = aa;
            interfazAdministracion = e;
            interfaceAsignatura = a;
            asignatura= r;
            interfazAdministracion.panelAgregar.add(aa).repaint();
            comboBox();
            mostrarEnPanel();
            mostrarEnTabla();
            Agregar();
          //  buscar();
        
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
    
    public void mostrarEnPanel(){
    
        interfazAdministracion.panelAsignaturas.removeAll();
        FichasAsignatura fa;
      
        for(EntidadAsignatura e: interfaceAsignatura.listar()){
            fa = null;
            fa = new FichasAsignatura(this);
            fa.jComboBoxProfesores.removeAllItems();
            
              for(EntidadProfesor i : datos){    
                fa.jComboBoxProfesores.addItem(i.getNombre());
              }
              try{
                if(e.getProfesor().getNombre().equals(""));
                else{
                    fa.jComboBoxProfesores.setSelectedItem(e.getProfesor().getNombre());
                }
                fa.jComboBoxProfesores.setSelectedItem(e.getProfesor().getNombre());
              
              }catch(Exception u){}
              
            
            fa.jTextFieldId.setText(e.getIdModulo());
            fa.jTextFieldNombre.setText(e.getNombre());
            fa.jTextFieldHorario.setText(e.getHorario());
          
            interfazAdministracion.panelAsignaturas.add(fa).repaint();
            
        }
            interfazAdministracion.panelAsignaturas.updateUI();
         
    }
    
       public void buscar(){
        interfazAdministracion.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
          
                List<EntidadAsignatura> info;
                info = interfaceAsignatura.listar();
                
                try {
                  String aux = "";
                    for(EntidadAsignatura i : info){
                        
                        if(i.getIdAsignatura().equals(interfazAdministracion.txtBuscar.getText())
                                || i.getNombre().equals(interfazAdministracion.txtBuscar.getText())){
                            
                            aux = aux + i.getIdAsignatura() + " Nombre" + i.getNombre() + " Horario" + i.getHorario() + " Profesor" + i.getProfesor().getNombre();
                        
                        }
                    
                    }
                    
                    JOptionPane.showMessageDialog(null, datos);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdminEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
            
        });
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
                                "ID", "Nombre", "PROFESOR"
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
    
           agregarAsignatura.jButtonAgregar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   asignatura.setNombre(agregarAsignatura.jTextFieldNombre.getText());
                   asignatura.setIdAsignatura(agregarAsignatura.jTextFieldId.getText());
                   asignatura.setHorario(agregarAsignatura.jTextFieldHorario.getText());
                   
                   String as = agregarAsignatura.jComboBoxProfesores.getSelectedItem()+ "";
                   
                   for (EntidadProfesor e : datos){
                       
                       if(e.getNombre().equals(as)){
                           asignatura.setProfesor(e);
                       }
                   }
                   
                  if(interfaceAsignatura.validarDatos()){
                
                   if(interfaceAsignatura.agregarAsignatura(asignatura)){
                       mostrarEnPanel();
                       JOptionPane.showMessageDialog(null, "Guardado");
                   }
                   else {
                   JOptionPane.showMessageDialog(null, "Error Guardar");
                   }
                  }else{
               
                   JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios");
               }
               }
           });
    }
    
   
   }
    