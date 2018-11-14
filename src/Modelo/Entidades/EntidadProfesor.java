
package Modelo.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Profesor")
public class EntidadProfesor implements Serializable  {
    
    @Id
    @Column(name="Id")
    private String id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="ape1")
    private String ape1;
    
    @Column(name="ape2")    
    private String ape2;
    
    @Column(name="Contrasena")
    private String contrasena;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdProfesor")
    @IndexColumn(name="idx")
    private List<EntidadAsignatura> correosElectronicos;
    

    public EntidadProfesor(){ 
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

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<EntidadAsignatura> getCorreosElectronicos() {
        return correosElectronicos;
    }

    public void setCorreosElectronicos(List<EntidadAsignatura> correosElectronicos) {
        this.correosElectronicos = correosElectronicos;
    }

    
   
}
