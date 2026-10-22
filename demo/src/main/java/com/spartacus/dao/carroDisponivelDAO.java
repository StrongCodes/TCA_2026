package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.carroDisponivel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class carroDisponivelDAO {

    public void cadastrar(carroDisponivel carro) throws SQLException {

        String sql = """
            INSERT INTO Carro_Disponivel (
                id_carro_pk,
                ano_carro,
                cor_carro,
                disponibilidade_carro,
                id_desconto_pk
            )
            VALUES (?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(1, carro.getId_carro_pk());
            comando.setInt(2, carro.getAno_carro());
            comando.setString(3, carro.getCor_carro());
            comando.setBoolean(4, carro.getDisponibilidade_carro());

            if (carro.getId_desconto_pk() == null) {
                comando.setNull(5, java.sql.Types.INTEGER);
            } else {
                comando.setInt(5, carro.getId_desconto_pk());
            }

            comando.executeUpdate();
        }
    }

    public static Object ConsultarCarroDisponivelPorID(
        int idCarro,
        String AtributoDesejado
    ) {

        String sql = """
            SELECT *
            FROM Carro_Disponivel
            WHERE id_carro_pk = ?
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(1, idCarro);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {

                    switch (AtributoDesejado) {

                        case "id_carroDisponivel_pk":
                            return resultado.getInt("id_carroDisponivel_pk");

                        case "ano_carroDisponivel":
                            return resultado.getInt("ano_carroDisponivel");

                        case "cor_carroDisponivel":
                            return resultado.getString("cor_carroDisponivel");

                        case "disponibilidade_carroDisponivel":
                            return resultado.getBoolean("disponibilidade_carroDisponivel");

                        case "id_desconto_pk":
                            int idDesconto = resultado.getInt("id_desconto_pk");

                            if (resultado.wasNull()) {
                                return null;
                            }

                            return idDesconto;

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