package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class compraDAO {

    public void cadastrar(compra compra) throws SQLException {

        String sql = """
            INSERT INTO compra (
                dataAgendadaParaColeta_compra,
                dataDeColeta_compra,
                horarioAgendadoParaColeta_compra,
                horaDeColeta_compra,
                cliente_id_cliente_pk,
                Carro_Disponivel_id_carro_pk,
                MetodoDePagamento_compra,
                HorarioDePagamento_compra,
                DataDePagamento_compra,
                ValorDeEntrada_compra
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            if (compra.getDataAgendada_Compra() == null) {
                comando.setNull(1, Types.DATE);
            } else {
                comando.setDate(
                    1,
                    java.sql.Date.valueOf(
                        compra.getDataAgendada_Compra()
                    )
                );
            }

            if (compra.getDataColeta_Compra() == null) {
                comando.setNull(2, Types.DATE);
            } else {
                comando.setDate(
                    2,
                    java.sql.Date.valueOf(
                        compra.getDataColeta_Compra()
                    )
                );
            }

            if (compra.getHorarioAgendado_Compra() == null) {
                comando.setNull(3, Types.TIME);
            } else {
                comando.setTime(
                    3,
                    java.sql.Time.valueOf(
                        compra.getHorarioAgendado_Compra()
                    )
                );
            }

            if (compra.getHorarioColeta_Compra() == null) {
                comando.setNull(4, Types.TIME);
            } else {
                comando.setTime(
                    4,
                    java.sql.Time.valueOf(
                        compra.getHorarioColeta_Compra()
                    )
                );
            }

            comando.setInt(
                5,
                compra.getIdCliente_Compra()
            );

            comando.setInt(
                6,
                compra.getIdCarro_Compra()
            );

            if (compra.getMetodoDePagamento_Compra() == null) {
                comando.setNull(7, Types.VARCHAR);
            } else {
                comando.setString(
                    7,
                    compra.getMetodoDePagamento_Compra()
                );
            }

            if (compra.getHorarioDePagamento_Compra() == null) {
                comando.setNull(8, Types.TIME);
            } else {
                comando.setTime(
                    8,
                    java.sql.Time.valueOf(
                        compra.getHorarioDePagamento_Compra()
                    )
                );
            }

            if (compra.getDataDePagamento_Compra() == null) {
                comando.setNull(9, Types.DATE);
            } else {
                comando.setDate(
                    9,
                    java.sql.Date.valueOf(
                        compra.getDataDePagamento_Compra()
                    )
                );
            }

            if (compra.getValorDeEntrada_Compra() == null) {
                comando.setNull(10, Types.DOUBLE);
            } else {
                comando.setDouble(
                    10,
                    compra.getValorDeEntrada_Compra()
                );
            }

            comando.executeUpdate();
        }
    }
}