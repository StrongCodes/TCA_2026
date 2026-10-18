package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.desconto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class descontoDAO {

    // O método de cadastro fica aqui dentro
    public void cadastrar(desconto desconto)
            throws SQLException {

        String sql = """
            INSERT INTO desconto (
                porcentagem_desconto,
                data_inicio_desconto,
                data_final_desconto
            )
            VALUES (?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {
            comando.setBigDecimal(
                1, desconto.getPorcentagem()
            );

            comando.setDate(
                2,
                desconto.getDataInicio() == null
                    ? null
                    : Date.valueOf(desconto.getDataInicio())
            );

            comando.setDate(
                3,
                desconto.getDataFinal() == null
                    ? null
                    : Date.valueOf(desconto.getDataFinal())
            );

            comando.executeUpdate();
        }
    }
}

