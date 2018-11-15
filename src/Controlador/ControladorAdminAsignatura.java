
package Controlador;

import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Vista.Administracion.AgregarAsignatura;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorAdminAsignatura {
    
    private InterfazAdministracion interfazAdministracion;
    private EntidadAsignatura asignatura;
    private IAsignatura interfaceAsignatura;
    private AgregarAsignatura agregarAsignatura;
    
    public ControladorAdminAsignatura(InterfazAdministracion e, IAsignatura a, EntidadAsignatura r, AgregarAsignatura aa){
     
            agregarAsignatura = aa;
            interfazAdministracion = e;
            interfaceAsignatura = a;
            asignatura= r;
            interfazAdministracion.panelAgregar.add(aa).repaint();
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
