
package Modelo.Login;

public class EntidadUsuario {
    
    private String cedula;
    private String contraseña;
    
    public EntidadUsuario(){
        cedula = "";
        contraseña = "";
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
