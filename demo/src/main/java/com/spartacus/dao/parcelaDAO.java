
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
                Numero_parcela,
                DataVencimento_parcela,
                Status_parcela,
                id_pagamento_pk
            ) VALUES (?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
            comando.setInt(1, parcela.getNumero_Parcela());
            comando.setDate(
                2,
                java.sql.Date.valueOf(parcela.getDataVencimento_Parcela())
            );

            if (parcela.getStatus_Parcela() == null)
                comando.setNull(3, Types.VARCHAR);
            else
                comando.setString(3, parcela.getStatus_Parcela());

            comando.setInt(4, parcela.getIdPagamento_Parcela());

            comando.executeUpdate();
        }
    }
}