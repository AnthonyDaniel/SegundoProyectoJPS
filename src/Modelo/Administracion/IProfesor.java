/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public interface IProfesor {
    public ArrayList<EntidadEstudiante> listarEstudiantes(String _idAsginatura);
    public List listarAsignaturas(String _idProf);
    public List listarProfesores();
    public void ponerNota(double _nota, String _idEst, String _idAsig);
    public double obtenerNota(String _idEst, String _idAsig);
    public void ponerFalta(String _fecha, String _idAsig, String _idEst, String _estado);    
    public void modificarFalta(String _idEst, String _idAsig, String _fecha, String _estado);
    public List listarAusencias(String _cedEst, String _idAsignatura);
}
