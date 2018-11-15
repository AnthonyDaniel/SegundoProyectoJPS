
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administracion.ContenedorEstudiante;
import Modelo.Administracion.IEstudiante;
import Modelo.Entidades.EntidadEstudiante;
import Vista.Estudiante.InterfazEstudiante;
import Vista.Interfaz;
import Vista.Profesor.InterfazProfesor;
import Vista.Profesor.ListaAsignaturas;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;





/**
 *
 * @author Thony
 */
public class ControladorEstudiante {
    private final IEstudiante iEstudiante;
    private final InterfazEstudiante interfazEstu;
    private ListaAsignaturas interfazAsig;
    public ControladorEstudiante(Interfaz interfazPrin, InterfazEstudiante _interfazEstudiante){
        iEstudiante = new ContenedorEstudiante();
        interfazEstu = _interfazEstudiante;
        interfazPrin.panelContenedor.add(interfazEstu).repaint();       
        
        tablaListarEstudiantes();       
        interfazEstu.tablaEstudiantes.add(interfazAsig);
        
        interfazPrin.panelContenedor.add(interfazEstu).repaint();
        interfazPrin.panelContenedor.updateUI();
    }
     
   
    
   
    
    private void tablaListarEstudiantes(){
        
    interfazAsig = new ListaAsignaturas();
        String id;
        EntidadEstudiante e = new EntidadEstudiante();
        List lista = iEstudiante.listarEstudiantes(5);        
        
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