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
    public List listarEstudiantes(int _idAsginatura);
    public List listarProfesores(int _idAsignatura);
    public List listarNotas(int id);
    public List listarAsistencias(int id);
}

