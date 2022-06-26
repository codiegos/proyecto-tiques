package com.inacap.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leand
 */
public class Usuario {

    public String nombre;
    public String username;
    public String password;
    public int idTipoUsuario;
    
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public Usuario(String nombre,String username, String password, int idTipoUsuario) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.idTipoUsuario = idTipoUsuario;

    }
    
    
    public int validarSesion() {
        ConexionBD c = new ConexionBD();
        // Creamos la sentencia que se ejecutará en MYSQL
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        try {
            PreparedStatement sentencia = c.conn.prepareStatement(sql);

            sentencia.setString(1, username);
            sentencia.setString(2, password);

            ResultSet resultado = sentencia.executeQuery();
            
           
            if (resultado.next()) {
                // retornamos el idTipoUsuario, si es 1 es adminitrador, si es 2 es ejecutivo
                return resultado.getInt("idTipoUsuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
      
    }
    
        public int insertar() {
        // variable que retornaremos para saber cuántas filas fueron afectadas..
        // si el valor es superior a 0, entonces insertamos correctamente.
        int estado = 0;
        // DEBEMOS usar bloques try catch siempre que interactuamos con terceros.. ya que los mismo
        // podrían no estar disponibles.. por ejemplo, que el server mysql esté abajo
        try {
            ConexionBD c = new ConexionBD();
            String sql = "INSERT INTO usuario (nombre, username, password, idTipoUsuario)"
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia = c.conn.prepareStatement(sql);
            
            sentencia.setString(1, nombre);
            sentencia.setString(2, username);
            sentencia.setString(3, password);
            sentencia.setInt(4, idTipoUsuario);

            estado = sentencia.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return estado;
    }
    
}
    

