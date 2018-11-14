
package Controlador;

import Modelo.Administracion.ContenedorAsignatura;
import Modelo.Entidades.EntidadAsignatura;
import Vista.Administracion.InterfazAdministracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorAsignaturas {
    
    private InterfazAdministracion interfazAdministracion;
    private ContenedorAsignatura contenedorAsignatura;
    private EntidadAsignatura asignatura;
    
    public ControladorAsignaturas(InterfazAdministracion e){
        interfazAdministracion = e;
        contenedorAsignatura = new ContenedorAsignatura();
        asignatura= new EntidadAsignatura();
        
        evento();
    }
    
    public void buscar(){
        interfazAdministracion.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    
    public void evento(){
          List<EntidadAsignatura> list;
        try {
            list = contenedorAsignatura.listar();
             JOptionPane.showMessageDialog(null,list.get(1).getNombre(), "mngfgfdgh", 0);
        } catch (Exception ex) {
            Logger.getLogger(ControladorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
//             
//        if(interfazAdministracion.rBtnAsignatura.isSelected()){
//            DefaultTableModel modelotabla=new DefaultTableModel();
//           
// 
//            Object[] fila=new Object[list.size()];
//            
//                 for(int i=0;i<list.size();i++){
//                  fila[i]=asignatura.getIdAsignatura();
//                  fila[i]=asignatura.getNombre();
//  
//                  modelotabla.addRow(fila);
//                 interfazAdministracion.tablaListas.setModel(modelotabla);
//                }
//         
       
    }
}
