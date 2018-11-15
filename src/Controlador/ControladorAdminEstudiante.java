
package Controlador;

import Modelo.Administracion.IAdminEstudiante;
import Modelo.Administracion.IAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorAdminEstudiante {
   private InterfazAdministracion interfazAdministracion;
    private EntidadEstudiante estudiante;
    private IAdminEstudiante interfaceAdminEstudiante;
    
    public ControladorAdminEstudiante(InterfazAdministracion e, IAdminEstudiante a, EntidadEstudiante r){
            interfazAdministracion = e;
            interfaceAdminEstudiante = a;
            estudiante= r;
            
            mostrarEnTabla();
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
                interfaceAdminEstudiante.listarEstudiantes(interfazAdministracion.)
            }
            
        });
    }
}
