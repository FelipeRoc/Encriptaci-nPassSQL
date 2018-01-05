/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejpassword;

import java.sql.*;
/**
 *
 * @author Felipe
 */
public class ModelUsuario {
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static final String ENLACE = "jdbc:mysql://localhost:3306/ejercicios";
    private Connection conexion;
    private Statement smt = null;
    
    public ModelUsuario(){
        try{
            this.conexion = DriverManager.getConnection(ENLACE, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa");
            this.smt = (Statement) this.conexion.createStatement();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public void cerrar_consulta(){
        try{
            this.smt.close();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public boolean comprobar_usuario(String usuario, String password){
        try{
            //Desencriptaciòn con Algoritmo AES.
            String consulta = "SELECT AES_DECRYPT(Contrasena,\"clave1\") AS pass FROM usuario_ejercicio WHERE Usuario=\""+usuario+"\"";            
            //Ejecuto la consulta.
            ResultSet resultado = this.smt.executeQuery(consulta);
            if(resultado.first()){
                String password2 = resultado.getString("pass");                       
                if(password2.equals(password)){//Compración de datos.
                    return true;
                }
            }          
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
        return false;        
    }
    
}
