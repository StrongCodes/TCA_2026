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
            INSERT INTO Reembolso (
                valor_Reembolso,
                DataSoli_Reembolso,
                HoraSoli_Reembolso,
                Data_Reembolso,
                Hora_Reembolso,
                compra_id_compra_pk,
                locacao_id_locacao_pk
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setDouble(
                1,
                reembolso.getValor_Reembolso()
            );

            comando.setDate(
                2,
                java.sql.Date.valueOf(
                    reembolso.getDataSoli_Reembolso()
                )
            );

            comando.setTime(
                3,
                java.sql.Time.valueOf(
                    reembolso.getHoraSoli_Reembolso()
                )
            );

            if (reembolso.getData_Reembolso() == null) {
                comando.setNull(4, Types.DATE);
            } else {
                comando.setDate(
                    4,
                    java.sql.Date.valueOf(
                        reembolso.getData_Reembolso()
                    )
                );
            }

            if (reembolso.getHora_Reembolso() == null) {
                comando.setNull(5, Types.TIME);
            } else {
                comando.setTime(
                    5,
                    java.sql.Time.valueOf(
                        reembolso.getHora_Reembolso()
                    )
                );
            }

            if (reembolso.getCompra_id_compra_pk() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(
                    6,
                    reembolso.getCompra_id_compra_pk()
                );
            }

            if (reembolso.getLocacao_id_locacao_pk() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(
                    7,
                    reembolso.getLocacao_id_locacao_pk()
                );
            }

            comando.executeUpdate();
        }
    }
}