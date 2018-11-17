/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Administracion;

import java.util.List;

/**
 *
 * @author Edris Jose Rios
 */
public interface IEstudiante {
    public List listarEstudiantes(String _idAsginatura);
    public List listarProfesores(String _idAsignatura);
    public List listarNotas(String id, String Asignatura);
    public List listarAsignaturas(String id);
    public List listarAsistencias(String id, String idAsig);
}

