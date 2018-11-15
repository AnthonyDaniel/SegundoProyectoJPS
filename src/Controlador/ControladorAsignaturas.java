
package Controlador;

import Modelo.Administracion.ContenedorAsignatura;
import Modelo.Administracion.IAsignatura;
import Modelo.Administracion.IProfesor;
import Modelo.Entidades.EntidadAsignatura;
import Vista.Administracion.InterfazAdministracion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorAsignaturas {
    
    private InterfazAdministracion interfazAdministracion;
    private EntidadAsignatura asignatura;
    
    private IAsignatura interfaceAsignatura;
    
    public ControladorAsignaturas(InterfazAdministracion e){
        try {
            interfazAdministracion = e;
            interfaceAsignatura = new ContenedorAsignatura();
            asignatura=new EntidadAsignatura();
            interfaceAsignatura.listar();
            evento();
//        agregar();
//        listarUnos();
        } catch (Exception ex) {
            Logger.getLogger(ControladorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   void evento(){
//        try {
//            List<EntidadAsignatura> lista= interfaceAsignatura.listar();
//            for ( int i = 0; i < lista.size(); i++ ){
//                System.out.print(i);
////                JOptionPane.showMessageDialog(null, i);
//            }
//
////            if(interfazAdministracion.rBtnAsignaturas.isSelected()){
////                System.out.print("kjhgf");
////            }
//            
//        } catch (Exception ex) {
//            Logger.getLogger(ControladorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
       
   }
   
//   void agregar(){
//       asignatura.setIdAsignatura(1);
//       asignatura.setNombre("keli");
//
//       
//        try {
//            interfaceAsignatura.agregarAsignatura(asignatura);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   }
//   
//   void listarUnos(){
//        try {
//            interfaceAsignatura.listarUnicos(3);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   }
}
