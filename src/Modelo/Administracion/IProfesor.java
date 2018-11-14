/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import Modelo.Entidades.EntidadAsignatura;
import Modelo.Entidades.EntidadAusencia;
import Modelo.Entidades.EntidadEstudiante;
import Modelo.Entidades.EntidadProfesor;
import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public interface IProfesor {
    public ArrayList<EntidadEstudiante> listarEstudiantes(int _idAsginatura);
    public ArrayList<EntidadAsignatura> listarAsignaturas(int _idProf);
    public ArrayList<EntidadProfesor> listarProfesores();
    public void ponerNota();
    public void ponerFalta();
    public void modificarNota();
    public void modificarFalta();
    public ArrayList<EntidadAusencia> listarAusencias(int _cedEst, int _idAsignatura);
}
