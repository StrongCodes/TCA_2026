
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
                DataAgendadaParaColeta_compra,
                DataDeColeta_compra,
                HorarioAgendadoParaColeta_compra,
                HorarioDeColeta_compra,
                id_cliente_pk,
                id_carro_pk
            ) VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
            if (compra.getDataAgendada_Compra() == null)
                comando.setNull(1, Types.DATE);
            else
                comando.setDate(1, java.sql.Date.valueOf(compra.getDataAgendada_Compra()));

            if (compra.getDataColeta_Compra() == null)
                comando.setNull(2, Types.DATE);
            else
                comando.setDate(2, java.sql.Date.valueOf(compra.getDataColeta_Compra()));

            if (compra.getHorarioAgendado_Compra() == null)
                comando.setNull(3, Types.TIME);
            else
                comando.setTime(3, java.sql.Time.valueOf(compra.getHorarioAgendado_Compra()));

            if (compra.getHorarioColeta_Compra() == null)
                comando.setNull(4, Types.TIME);
            else
                comando.setTime(4, java.sql.Time.valueOf(compra.getHorarioColeta_Compra()));

            comando.setInt(5, compra.getIdCliente_Compra());
            comando.setInt(6, compra.getIdCarro_Compra());

            comando.executeUpdate();
        }
    }
}
