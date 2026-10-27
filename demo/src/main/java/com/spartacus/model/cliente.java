package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_cliente;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cliente implements INTERFACE_cliente {

    private int id_cliente_pk;
    private String nome_cliente;
    private String senha_cliente;
    private String email_cliente;
    private String cpf_cliente;

    public cliente(
        int id_cliente_pk,
        String nome_cliente,
        String senha_cliente,
        String email_cliente,
        String cpf_cliente
    ) {
        this.id_cliente_pk = id_cliente_pk;
        this.nome_cliente = nome_cliente;
        this.senha_cliente = senha_cliente;
        this.email_cliente = email_cliente;
        this.cpf_cliente = cpf_cliente;
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
                cpf_cliente
            )
            VALUES (?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {
            comando.setString(1, cliente.nome_cliente);
            comando.setString(2, cliente.senha_cliente);
            comando.setString(3, cliente.email_cliente);
            comando.setString(4, cliente.cpf_cliente);

            comando.executeUpdate();
        }
    }

    public static Object ConsultarClientePorID(
        int idCliente,
        String AtributoDesejado
    ) {
    
        String sql = """
            SELECT *
            FROM cliente
            WHERE id_cliente_pk = ?
            """;
    
        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
        
            comando.setInt(1, idCliente);
        
            try (ResultSet resultado = comando.executeQuery()) {
            
                if (resultado.next()) {
                
                    switch (AtributoDesejado) {
                    
                        case "id_cliente_pk":
                            return resultado.getInt("id_cliente_pk");
                    
                        case "nome_cliente":
                            return resultado.getString("nome_cliente");
                    
                        case "email_cliente":
                            return resultado.getString("email_cliente");
                    
                        case "cpf_cliente":
                            return resultado.getString("cpf_cliente");
                    
                        default:
                            return null;
                    }
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null;
    }
}