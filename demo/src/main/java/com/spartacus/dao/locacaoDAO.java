package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.locacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class locacaoDAO {

    public void cadastrar(locacao locacao) throws SQLException {

        String sql = """
            INSERT INTO locacao (
                dataAgendadaParaColeta_locacao,
                horarioAgendadoParaColeta_locacao,
                horaDeColeta_locacao,
                dataDeColeta_locacao,
                Periodo_locacao,
                cliente_id_cliente_pk,
                Carro_Disponivel_id_carro_pk,
                MetodoDePagamento_locacao,
                HorarioDePagamento_locacao,
                DataDePagamento_locacao,
                ValorDeEntrada_locacao
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            if (locacao.getDataAgendada_Locacao() == null) {
                comando.setNull(1, Types.DATE);
            } else {
                comando.setDate(
                    1,
                    java.sql.Date.valueOf(
                        locacao.getDataAgendada_Locacao()
                    )
                );
            }

            if (locacao.getHorarioAgendado_Locacao() == null) {
                comando.setNull(2, Types.TIME);
            } else {
                comando.setTime(
                    2,
                    java.sql.Time.valueOf(
                        locacao.getHorarioAgendado_Locacao()
                    )
                );
            }

            if (locacao.getHorarioColeta_Locacao() == null) {
                comando.setNull(3, Types.TIME);
            } else {
                comando.setTime(
                    3,
                    java.sql.Time.valueOf(
                        locacao.getHorarioColeta_Locacao()
                    )
                );
            }

            if (locacao.getDataColeta_Locacao() == null) {
                comando.setNull(4, Types.DATE);
            } else {
                comando.setDate(
                    4,
                    java.sql.Date.valueOf(
                        locacao.getDataColeta_Locacao()
                    )
                );
            }

            comando.setDouble(
                5,
                locacao.getPeriodo_Locacao()
            );

            comando.setInt(
                6,
                locacao.getIdCliente_Locacao()
            );

            comando.setInt(
                7,
                locacao.getIdCarro_Locacao()
            );

            if (locacao.getMetodoDePagamento_Locacao() == null) {
                comando.setNull(8, Types.VARCHAR);
            } else {
                comando.setString(
                    8,
                    locacao.getMetodoDePagamento_Locacao()
                );
            }

            if (locacao.getHorarioDePagamento_Locacao() == null) {
                comando.setNull(9, Types.TIME);
            } else {
                comando.setTime(
                    9,
                    java.sql.Time.valueOf(
                        locacao.getHorarioDePagamento_Locacao()
                    )
                );
            }

            if (locacao.getDataDePagamento_Locacao() == null) {
                comando.setNull(10, Types.DATE);
            } else {
                comando.setDate(
                    10,
                    java.sql.Date.valueOf(
                        locacao.getDataDePagamento_Locacao()
                    )
                );
            }

            if (locacao.getValorDeEntrada_Locacao() == null) {
                comando.setNull(11, Types.DOUBLE);
            } else {
                comando.setDouble(
                    11,
                    locacao.getValorDeEntrada_Locacao()
                );
            }

            comando.executeUpdate();
        }
    }
}