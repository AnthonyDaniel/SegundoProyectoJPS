/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Administracion.ContenedorProfesor;
import Modelo.Administracion.IProfesor;
import Modelo.Entidades.*;
import Vista.Profesor.*;
import Vista.Interfaz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class ControladorProfesor {
    
    private final IProfesor iProfesor;
    private final InterfazProfesor interfazProf;
    private ListaAsignaturas interfazAsig;
    
    public ControladorProfesor(Interfaz interfazPrin){
        
        iProfesor = new ContenedorProfesor();
        interfazProf = new InterfazProfesor();
                        
        interfazPrin.panelContenedor.add(interfazProf).repaint();       
        
        cargarTablaAsignaturas();       
        interfazProf.panel_Contenido.add(interfazAsig);
        
        interfazPrin.panelContenedor.add(interfazProf).repaint();
        interfazPrin.panelContenedor.updateUI();
        
//        interfaceProfesor.listarEstudiantes(2);
//        interfaceProfesor.listarAsignaturas(1536);
//        interfaceProfesor.listarProfesores();
    }
    
    private void cargarTablaAsignaturas(){
        interfazAsig = new ListaAsignaturas();
        
        List lista = iProfesor.listarAsignaturas(1536);        
        
        interfazAsig.tbl_ListaAsig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazAsig.tbl_ListaAsig.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"CODIGO","NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("IdAsignatura");
            fila[1] = tupla.get("Nombre");            
            model.addRow(fila);
        }
        interfazAsig.tbl_ListaAsig.setModel(model); 
    }
}
