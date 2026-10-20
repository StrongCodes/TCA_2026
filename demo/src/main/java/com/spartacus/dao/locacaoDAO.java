
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
            if (locacao.getDataAgendada_Locacao() == null)
                comando.setNull(1, Types.DATE);
            else
                comando.setDate(1, java.sql.Date.valueOf(locacao.getDataAgendada_Locacao()));

            if (locacao.getHorarioAgendado_Locacao() == null)
                comando.setNull(2, Types.TIME);
            else
                comando.setTime(2, java.sql.Time.valueOf(locacao.getHorarioAgendado_Locacao()));

            if (locacao.getHorarioColeta_Locacao() == null)
                comando.setNull(3, Types.TIME);
            else
                comando.setTime(3, java.sql.Time.valueOf(locacao.getHorarioColeta_Locacao()));

            if (locacao.getDataColeta_Locacao() == null)
                comando.setNull(4, Types.DATE);
            else
                comando.setDate(4, java.sql.Date.valueOf(locacao.getDataColeta_Locacao()));

            if (locacao.getPeriodo_Locacao() == null)
                comando.setNull(5, Types.VARCHAR);
            else
                comando.setString(5, locacao.getPeriodo_Locacao());

            comando.setInt(6, locacao.getIdCliente_Locacao());
            comando.setInt(7, locacao.getIdCarro_Locacao());

            comando.executeUpdate();
        }
    }
}
