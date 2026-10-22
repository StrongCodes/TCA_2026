package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.parcela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class parcelaDAO {

    public void cadastrar(parcela parcela) throws SQLException {

        String sql = """
            INSERT INTO parcela (
                NumeroDeParcelas_pk,
                DataDeVencimento_parcela,
                status_parcela,
                locacao_id_locacao_pk,
                compra_id_compra_pk
            )
            VALUES (?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(
                1,
                parcela.getNumeroDeParcelas_pk()
            );

            comando.setDate(
                2,
                java.sql.Date.valueOf(
                    parcela.getDataDeVencimento_parcela()
                )
            );

            comando.setString(
                3,
                parcela.getStatus_parcela()
            );

            if (parcela.getLocacao_id_locacao_pk() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(
                    4,
                    parcela.getLocacao_id_locacao_pk()
                );
            }

            if (parcela.getCompra_id_compra_pk() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(
                    5,
                    parcela.getCompra_id_compra_pk()
                );
            }

            comando.executeUpdate();
        }
    }
}