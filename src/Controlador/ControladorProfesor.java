/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Administracion.ContenedorProfesor;
import Modelo.Administracion.IProfesor;
/**
 *
 * @author Mauricio
 */
public class ControladorProfesor {
    
    private IProfesor interfaceProfesor;
    
    public ControladorProfesor(){
        interfaceProfesor = new ContenedorProfesor();
        
//        interfaceProfesor.listarEstudiantes(3);
//        interfaceProfesor.listarAsignaturas(504110539);
//        interfaceProfesor.listarProfesores();
    }
}
