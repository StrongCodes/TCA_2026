
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
                DataAgendadaParaColeta_locacao,
                HorarioAgendadoParaColeta_locacao,
                HorarioDeColeta_locacao,
                DataDeColeta_locacao,
                Periodo_locacao,
                id_cliente_pk,
                id_carro_pk
            ) VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
            if (locacao.getDataAgendada() == null)
                comando.setNull(1, Types.DATE);
            else
                comando.setDate(1, java.sql.Date.valueOf(locacao.getDataAgendada()));

            if (locacao.getHorarioAgendado() == null)
                comando.setNull(2, Types.TIME);
            else
                comando.setTime(2, java.sql.Time.valueOf(locacao.getHorarioAgendado()));

            if (locacao.getHorarioColeta() == null)
                comando.setNull(3, Types.TIME);
            else
                comando.setTime(3, java.sql.Time.valueOf(locacao.getHorarioColeta()));

            if (locacao.getDataColeta() == null)
                comando.setNull(4, Types.DATE);
            else
                comando.setDate(4, java.sql.Date.valueOf(locacao.getDataColeta()));

            if (locacao.getPeriodo() == null)
                comando.setNull(5, Types.VARCHAR);
            else
                comando.setString(5, locacao.getPeriodo());

            comando.setInt(6, locacao.getIdCliente());
            comando.setInt(7, locacao.getIdCarro());

            comando.executeUpdate();
        }
    }
}
