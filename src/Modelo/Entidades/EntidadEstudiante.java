
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
    private String id;
    
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Apellido")
    private String ape1;
    
    @Column(name="Contrasena")
    private String contrasena;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdEstudiante")
    @IndexColumn(name="idx")
    private List<EntidadAsistencia> asistencia;
   
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdEstudiante")
    @IndexColumn(name="idx")
    private List<EntidadNota> nota;
    
    
   
    public EntidadEstudiante(){ 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<EntidadAsistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<EntidadAsistencia> asistencia) {
        this.asistencia = asistencia;
    }



  
    
}
