package com.softtek.CRUD_RESSFULL.repo;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Conexion {
    private Connection miConexion;

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        miConexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/northwind", "postgres", "1234");
    }

    public void cerrarConexion() throws SQLException {
        if (miConexion != null) {
            miConexion.close();
        }
    }

    public Connection getMiConexion() {
        return miConexion;
    }
}