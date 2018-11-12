
package Modelo.Entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="Estudiante")
public class EntidadEstudiante implements Serializable  {
    
    @Id
    @Column(name="Cedula")
    private int id;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Apellido")
    private String ape1;

    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdEstudiante")
    @IndexColumn(name="idx")
    private List<EntidadAsistencia> asistencia;
   
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="AssignaturaEstudiante", joinColumns={@JoinColumn(name="IdEstudiante")}, inverseJoinColumns={@JoinColumn(name="IdAsignatura")})
    private Set<EntidadAsignatura> asignaturas=new HashSet();
   
    public EntidadEstudiante(){ 
    }

    public EntidadEstudiante(int id, String nombre, String ape1) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public List<EntidadAsistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<EntidadAsistencia> asistencia) {
        this.asistencia = asistencia;
    }

    public Set<EntidadAsignatura> getAsignatura() {
        return asignaturas;
    }

    public void setAsignatura(Set<EntidadAsignatura> modulos) {
        this.asignaturas = modulos;
    }


}
