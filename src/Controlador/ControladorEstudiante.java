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
import Vista.Estudiante.ListaAsistenciaEstu;
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
    private ListaAsistenciaEstu listAsistencia;
   
    public ControladorEstudiante(Interfaz interfazPrin, InterfazEstudiante _interfazEstudiante){
        iEstudiante = new ContenedorEstudiante();
        interfazAsignaturaEstu = new ListarAsignaturaEstu();
        interfazListEstudiantes = new ListarEstudiantes();
        listNotas = new ListaNota();
        listAsistencia = new ListaAsistenciaEstu();
        interfazEstu = _interfazEstudiante;
        
        interfazPrin.panelContenedor.add(interfazEstu).repaint();       
        
      
        listarNotasClick();
        listarAsignaturasClick();
        mostrarNota();
      //Pruebas
        iEstudiante.listarProfesores(0);
      
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
    private void tablaListarAsignaturas(){
        List lista = iEstudiante.listarAsignaturas("504250813");
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
    private void tablaListarNotas(){
        EntidadEstudiante e = new EntidadEstudiante();
        
        List lista = iEstudiante.listarNotas("504250813", "2");// que lo agarre del login y que el id de la asignatura lo agarre cuando seleccione un campo de texto
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
    private void tablaListarAsistencia(){
       
      
        List lista = iEstudiante.listarAsistencias(13);
        interfazAsignaturaEstu.tableAsignaturasEstu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazAsignaturaEstu.tableAsignaturasEstu.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"Asignatura","Cedula Estudiante","Asistencia"};
        DefaultTableModel model = new DefaultTableModel(etiquetas, 0);
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("IdAsignatura");
            fila[1] = tupla.get("IdEstudiante");
            fila[2] = tupla.get("Idx");
            
            model.addRow(fila);
        }
       interfazAsignaturaEstu.tableAsignaturasEstu.setModel(model);
       
    }
    private void listarNotasClick(){
        interfazEstu.btnListarNotasEstu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                tablaListarNotas();
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(listNotas).repaint();
                interfazEstu.panelEstudiantes.updateUI();
            }
        
        
        });
       
        
    }
     private void listarAsignaturasClick(){
            interfazEstu.btnListarAsignatura.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    tablaListarAsignaturas();
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(interfazAsignaturaEstu).repaint();
                interfazEstu.panelEstudiantes.updateUI();
                }
            
            });
        }
    private void mostrarNota(){
        interfazAsignaturaEstu.btnMostrarNotasEstu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                tablaListarNotas();
                interfazEstu.panelEstudiantes.removeAll();
                interfazEstu.panelEstudiantes.add(listNotas).repaint();
                interfazEstu.panelEstudiantes.updateUI();
            }
        
        });
    }
    

}

