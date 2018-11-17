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
import Vista.Estudiante.ListaAsistencias;

import Vista.Estudiante.ListaNota;

import Vista.Estudiante.ListarAsignaturaEstu;

import Vista.Estudiante.ListarEstudiantes;
import Vista.Interfaz;
import Vista.Profesor.InterfazProfesor;
import Vista.Profesor.ListaAsignaturas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private ListarAsignaturaEstu interfazAsignaturaEstu;
    private ListarEstudiantes interfazListEstudiantes;
    private ListaNota listNotas;
    private ListaAsistencias listAsistencia;
   
    public ControladorEstudiante(Interfaz interfazPrin, String idEstudiante){
        iEstudiante = new ContenedorEstudiante();
        interfazAsignaturaEstu = new ListarAsignaturaEstu();
        interfazListEstudiantes = new ListarEstudiantes();
        listNotas = new ListaNota();
        listAsistencia = new ListaAsistencias();
        interfazEstu = new InterfazEstudiante();
        
        interfazPrin.panelContenedor.add(interfazEstu).repaint();       
        
      
        listarNotasClick(idEstudiante);
        listarAsignaturasClick(idEstudiante);
        mostrarNota(idEstudiante);
        mostrarAsistencia(idEstudiante);
      //Pruebas
        iEstudiante.listarProfesores(idEstudiante);
      
    }
     
   
    
   
    
    private void tablaListarEstudiantes(){
        
    
      
        EntidadEstudiante e = new EntidadEstudiante();
       
        List lista = iEstudiante.listarEstudiantes("5");        
        
        listNotas.tabla_notas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listNotas.tabla_notas.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"Asignaruta","Nombre"};
        DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("IdAsignatura");
            fila[1] = tupla.get("Nombre");            
            model.addRow(fila);
        }
      listNotas.tabla_notas.setModel(model);
       
    }
    private void tablaListarAsignaturas(String id){
        List lista = iEstudiante.listarAsignaturas(id);
        interfazAsignaturaEstu.tableAsignaturasEstu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazAsignaturaEstu.tableAsignaturasEstu.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"Asignaruta","Nombre"};
        DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("IdAsignatura");
            fila[1] = tupla.get("IdEstudiante");            
            model.addRow(fila);
        }
        interfazAsignaturaEstu.tableAsignaturasEstu.setModel(model);
      } 
    private void tablaListarNotas(String id){
        EntidadEstudiante e = new EntidadEstudiante();
        String notas;
        notas =  (String) interfazAsignaturaEstu.tableAsignaturasEstu.getValueAt(interfazAsignaturaEstu.tableAsignaturasEstu.getSelectedRow(), 0);
       
          List lista = iEstudiante.listarNotas(id, notas);// que lo agarre del login y que el id de la asignatura lo agarre cuando seleccione un campo de texto
          listNotas.tabla_notas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          listNotas.tabla_notas.getTableHeader().setReorderingAllowed(false);
        
        Object[] etiquetas = {"IdAsignatura","IdEstudiante", "Notas"};
        DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[3];
            fila[0] = tupla.get("IdAsignatura");
            fila[1] = tupla.get("IdEstudiante");  
            fila[2] = tupla.get("Nota");
            model.addRow(fila);
        }
        listNotas.tabla_notas.setModel(model);
        
    }
    private void tablaListarAsistencia(String id){
       String notas;
        notas =  (String) interfazAsignaturaEstu.tableAsignaturasEstu.getValueAt(interfazAsignaturaEstu.tableAsignaturasEstu.getSelectedRow(), 0);
        List lista = iEstudiante.listarAsistencias(id, notas);
        listAsistencia.tableAsistencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listAsistencia.tableAsistencia.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"Fecha","Ausencia"};
        DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("Fecha");
            fila[1] = tupla.get("Justificacion");
            
            
            model.addRow(fila);
        }
       listAsistencia.tableAsistencia.setModel(model);
       
    }
    private void listarNotasClick(String id){
        interfazEstu.btnListarNotasEstu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                tablaListarNotas(id);
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(listNotas).repaint();
                interfazEstu.panelEstudiantes.updateUI();
            }
        
        
        });
       
        
    }
     private void listarAsignaturasClick(String id){
            interfazEstu.btnListarAsignatura.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    tablaListarAsignaturas(id);
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(interfazAsignaturaEstu).repaint();
                interfazEstu.panelEstudiantes.updateUI();
                }
            
            });
        }
    private void mostrarNota(String id){
        interfazAsignaturaEstu.btnMostrarNotasEstu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                tablaListarNotas(id);
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(listNotas).repaint();
                interfazEstu.panelEstudiantes.updateUI();
            }
        
        });
    }
    private void mostrarAsistencia(String id){
        interfazAsignaturaEstu.btnMostrarAsistencia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                tablaListarAsistencia(id);
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(listAsistencia).repaint();
                interfazEstu.panelEstudiantes.updateUI();
            }
        
        
        });
    }
    

}

