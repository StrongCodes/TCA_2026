
package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.reembolso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class reembolsoDAO {

    public void cadastrar(reembolso reembolso) throws SQLException {

        String sql = """
            INSERT INTO reembolso (
                valor_reembolso,
                dataSol_reembolso,
                dataRes_reembolso,
                horarioAgendadoParaColeta_reembolso,
                horarioDeColeta_reembolso,
                cliente_id_cliente_fk,
                pagamento_id_pagamento_pk
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
            comando.setDouble(1, reembolso.getValor_Reembolso());

            comando.setDate(
                2,
                java.sql.Date.valueOf(reembolso.getDataSolicitacao_Reembolso())
            );

            if (reembolso.getDataResolucao_Reembolso() == null) {
                comando.setNull(3, Types.DATE);
            } else {
                comando.setDate(
                    3,
                    java.sql.Date.valueOf(reembolso.getDataResolucao_Reembolso())
                );
            }

            comando.setTime(
                4,
                java.sql.Time.valueOf(reembolso.getHorarioAgendado_Reembolso())
            );

            if (reembolso.getHorarioColeta_Reembolso() == null) {
                comando.setNull(5, Types.TIME);
            } else {
                comando.setTime(
                    5,
                    java.sql.Time.valueOf(reembolso.getHorarioColeta_Reembolso())
                );
            }

            comando.setInt(6, reembolso.getIdCliente_Reembolso());
            comando.setInt(7, reembolso.getIdPagamento_Reembolso());

            comando.executeUpdate();
        }
    }
}