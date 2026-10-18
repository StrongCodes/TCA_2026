package com.spartacus.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexãoBD {

    private static final String URL =
        "jdbc:mysql://localhost:3306/BancoBD";

    private static final String USUARIO = "spartacus_app";
    private static final String SENHA = "senha";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}