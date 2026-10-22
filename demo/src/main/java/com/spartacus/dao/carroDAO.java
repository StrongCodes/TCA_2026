package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class carroDAO {

    public void cadastrar(carro carro) throws SQLException {

        String sql = """
            INSERT INTO carro (
                modelo_carro,
                potenciaMotor_carro,
                tipoMotor_carro,
                numDeCilindros_motor,
                nota
            )
            VALUES (?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setString(1, carro.getModelo_carro());
            comando.setString(2, carro.getPotencia_motor());
            comando.setString(3, carro.getTipo_motor());
            comando.setInt(4, carro.getNumDeCilindros_motor());
            comando.setDouble(5, carro.getNota());

            comando.executeUpdate();
        }
    }

    public static Object ConsultarCarroPorID(
        int idCarro,
        String AtributoDesejado
    ) {

        String sql = "SELECT * FROM carro WHERE id_carro_pk = ?";

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(1, idCarro);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {

                    switch (AtributoDesejado) {

                        case "id_carro_pk":
                            return resultado.getInt("id_carro_pk");

                        case "modelo_carro":
                            return resultado.getString("modelo_carro");

                        case "potenciaMotor_carro":
                            return resultado.getString("potenciaMotor_carro");

                        case "tipoMotor_carro":
                            return resultado.getString("tipoMotor_carro");

                        case "numDeCilindros_motor":
                            return resultado.getInt("numDeCilindros_motor");

                        case "nota":
                            return resultado.getDouble("nota");

                        default:
                            return null;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}