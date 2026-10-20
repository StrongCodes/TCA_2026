
package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clienteDAO {

    public void cadastrar(cliente cliente) throws SQLException {

        String sql = """
            INSERT INTO cliente (
                nome_cliente,
                senha_cliente,
                email_cliente,
                telefone_cliente,
                CEP
            )
            VALUES (?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {
            comando.setString(1, cliente.getNome_Cliente());
            comando.setString(2, cliente.getSenha_Cliente());
            comando.setString(3, cliente.getEmail_Cliente());

            if (cliente.getTelefone_Cliente() == null) {
                comando.setNull(4, java.sql.Types.VARCHAR);
            } else {
                comando.setString(4, cliente.getTelefone_Cliente());
            }

            comando.setString(5, cliente.getCEP_Cliente());

            comando.executeUpdate();
        }
    }
}