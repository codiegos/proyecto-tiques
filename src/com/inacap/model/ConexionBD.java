package com.inacap.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author leand
 */
public class ConexionBD {
    
    private String DSN = "jdbc:mysql://localhost:3306/inacap";
    private String USER = "root";
    private String PASS = "";
    public Connection conn;

    // El constructor en JAVA siempre tiene exactamente el mismo nombre de la clase
    public ConexionBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DSN, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}