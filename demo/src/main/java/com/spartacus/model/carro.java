
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_carro;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class carro implements INTERFACE_carro {

    private int id_carro_pk;
    private String modelo_carro;
    private double Potencia_motor;
    private String Tipo_motor;
    private int NumDeCilindros_motor;

    public carro(
        int id_carro_pk,
        String modelo_carro,
        double Potencia_motor,
        String Tipo_motor,
        int NumDeCilindros_motor
    ) {
        this.id_carro_pk = id_carro_pk;
        this.modelo_carro = modelo_carro;
        this.Potencia_motor = Potencia_motor;
        this.Tipo_motor = Tipo_motor;
        this.NumDeCilindros_motor = NumDeCilindros_motor;
    }

    public int getId_carro_pk() {
        return id_carro_pk;
    }

    public void cadastrar(carro carro) throws SQLException {

        String sql = """
            INSERT INTO carro (
                modelo_carro,
                potenciaMotor_carro,
                tipoMotor_carro,
                numDeCilindros_carro
            )
            VALUES (?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setString(1, carro.modelo_carro);
            comando.setDouble(2, carro.Potencia_motor);
            comando.setString(3, carro.Tipo_motor);
            comando.setInt(4, carro.NumDeCilindros_motor);

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
                            return resultado.getDouble("potenciaMotor_carro");

                        case "tipoMotor_carro":
                            return resultado.getString("tipoMotor_carro");

                        case "numDeCilindros_carro":
                            return resultado.getInt("numDeCilindros_carro");

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