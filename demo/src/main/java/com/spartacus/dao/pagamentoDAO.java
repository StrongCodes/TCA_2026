
package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class pagamentoDAO {

    public void cadastrar(pagamento pagamento) throws SQLException {
        String sql = """
            INSERT INTO pagamento (
                MetodoDePagamento_pagamento,
                HorarioDePagamento_pagamento,
                DataDePagamento_pagamento,
                ValorDeEntrada_pagamento,
                ValorTotal_pagamento,
                id_compra_pk,
                id_locacao_pk
            ) VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
            comando.setString(1, pagamento.getMetodo_Pagamento());

            if (pagamento.getHorario_Pagamento() == null)
                comando.setNull(2, Types.TIME);
            else
                comando.setTime(2, java.sql.Time.valueOf(pagamento.getHorario_Pagamento()));

            if (pagamento.getData_Pagamento() == null)
                comando.setNull(3, Types.DATE);
            else
                comando.setDate(3, java.sql.Date.valueOf(pagamento.getData_Pagamento()));

            if (pagamento.getValorEntrada_Pagamento() == null)
                comando.setNull(4, Types.DECIMAL);
            else
                comando.setBigDecimal(4, pagamento.getValorEntrada_Pagamento());

            comando.setBigDecimal(5, pagamento.getValorTotal_Pagamento());

            if (pagamento.getIdCompra_Pagamento() == null)
                comando.setNull(6, Types.INTEGER);
            else
                comando.setInt(6, pagamento.getIdCompra_Pagamento());

            if (pagamento.getIdLocacao_Pagamento() == null)
                comando.setNull(7, Types.INTEGER);
            else
                comando.setInt(7, pagamento.getIdLocacao_Pagamento());

            comando.executeUpdate();
        }
    }
}