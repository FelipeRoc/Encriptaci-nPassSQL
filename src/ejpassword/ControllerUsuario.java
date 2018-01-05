/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejpassword;

/**
 *
 * @author Felipe
 */
public class ControllerUsuario {
    private String Usuario;
    private char[] Password;
    
public ControllerUsuario(){}

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public char[] getPassword() {
        return Password;
    }

    public void setPassword(char[] Password) {
        this.Password = Password;
    }

    public boolean ingresoUsuario(String usuario, char[] passchar){
        try{
            String password = String.valueOf(passchar);
            ModelUsuario modusu = new ModelUsuario();
            boolean resultado = modusu.comprobar_usuario(usuario, password);
            modusu.cerrar_consulta();
            return resultado;
        }catch(Exception e){
            System.err.println(e);
            return false;
        }
    }
    
    
}
