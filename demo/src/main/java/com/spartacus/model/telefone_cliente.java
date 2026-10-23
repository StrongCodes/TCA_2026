
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_telefone_cliente;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class telefone_cliente implements INTERFACE_telefone_cliente {

    private int id_TelefoneCliente_pk;
    private String telefone_TelefoneCliente;
    private int cliente_id_cliente_pk;

    public telefone_cliente(
        int id_TelefoneCliente_pk,
        String telefone_TelefoneCliente,
        int cliente_id_cliente_pk
    ) {
        this.id_TelefoneCliente_pk = id_TelefoneCliente_pk;
        this.telefone_TelefoneCliente = telefone_TelefoneCliente;
        this.cliente_id_cliente_pk = cliente_id_cliente_pk;
    }

    public int getId_TelefoneCliente_pk() {
        return id_TelefoneCliente_pk;
    }

    public void cadastrar(telefone_cliente telefone) throws SQLException {

        String sql = """
            INSERT INTO TelefoneCliente (
                telefone_TelefoneCliente,
                cliente_id_cliente_pk
            )
            VALUES (?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setString(
                1,
                telefone.telefone_TelefoneCliente
            );

            comando.setInt(
                2,
                telefone.cliente_id_cliente_pk
            );

            comando.executeUpdate();
        }
    }
}