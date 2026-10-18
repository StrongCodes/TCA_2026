package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.motor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class motorDAO {

    public void cadastrar(motor motor) throws SQLException {

        String sql = """
            INSERT INTO motor (Potencia_motor, Tipo_motor, NumDeCilindros_motor)
            VALUES (?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {
            comando.setString(
                1, motor.getPotencia_Motor()
            );

            comando.setString(
                2, motor.getTipoMotor_Motor()
            );

            comando.setInt(
                3,
                motor.getNumCilindros_Motor()
            );

            comando.executeUpdate();
        }
    }
}