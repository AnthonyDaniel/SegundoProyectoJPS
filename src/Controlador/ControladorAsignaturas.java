
package Controlador;

import Modelo.Administracion.ContenedorAsignatura;
import Modelo.Administracion.IAsignatura;
import Modelo.Administracion.IProfesor;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Vista.Administracion.InterfazAdministracion;
import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorAsignaturas {
    
    private InterfazAdministracion interfazAdministracion;
    private EntidadAsignatura asignatura;
    private IAsignatura interfaceAsignatura;
    
    public ControladorAsignaturas( InterfazAdministracion e, IAsignatura a, EntidadAsignatura r){
     
            interfazAdministracion = e;
            interfaceAsignatura = a;
            asignatura= r;
            mostrarEnTabla();
        
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
        
   }
