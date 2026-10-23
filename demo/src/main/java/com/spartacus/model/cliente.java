package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_cliente;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cliente implements INTERFACE_cliente {

    private int id_cliente_pk;
    private String nome_cliente;
    private String senha_cliente;
    private String email_cliente;
    private String telefone_cliente;
    private String CEP;

    public cliente(
        int id_cliente_pk,
        String nome_cliente,
        String senha_cliente,
        String email_cliente,
        String telefone_cliente,
        String CEP
    ) {
        this.id_cliente_pk = id_cliente_pk;
        this.nome_cliente = nome_cliente;
        this.senha_cliente = senha_cliente;
        this.email_cliente = email_cliente;
        this.telefone_cliente = telefone_cliente;
        this.CEP = CEP;
    }

    public int getId_cliente_pk() {
        return id_cliente_pk;
    }

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
            comando.setString(1, cliente.nome_cliente);
            comando.setString(2, cliente.senha_cliente);
            comando.setString(3, cliente.email_cliente);

            if (cliente.telefone_cliente == null) {
                comando.setNull(4, java.sql.Types.VARCHAR);
            } else {
                comando.setString(4, cliente.telefone_cliente);
            }

            comando.setString(5, cliente.CEP);

            comando.executeUpdate();
        }
    }
}