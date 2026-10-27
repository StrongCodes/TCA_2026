package com.spartacus.validators;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;

import com.spartacus.model.carro;
import com.spartacus.model.carroDisponivel;
import com.spartacus.model.cliente;
import com.spartacus.model.compra;
import com.spartacus.model.desconto;
import com.spartacus.model.locacao;
import com.spartacus.model.parcela;
import com.spartacus.model.reembolso;
import com.spartacus.model.telefone_cliente;

public class verificacoes {

    public static int ValidaCadastro_Cliente(
        String nome_cliente,
        String senha_cliente,
        String email_cliente,
        String cpf_cliente
    ) throws Exception {

        boolean erro = false;

        String EMAIL_regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)+$";
        String CPF_regex = "^[0-9]{11}$";

        if (nome_cliente == null || nome_cliente.isBlank() || nome_cliente.length() > 150) {
            erro = true;
        }

        if (senha_cliente == null || senha_cliente.isBlank()) {
            erro = true;
        }

        if (email_cliente == null || !email_cliente.matches(EMAIL_regex)) {
            erro = true;
        }

        if (cpf_cliente == null || !cpf_cliente.matches(CPF_regex)) {
            erro = true;
        }

        if (!erro) {

            cliente cliente = new cliente(
                0,
                nome_cliente,
                senha_cliente,
                email_cliente,
                cpf_cliente
            );

            cliente.cadastrar(cliente);

            return 1;
        }
        else {
            return 0;
        }
    }



    public static int ValidaLogin_Cliente(
        String nome_cliente,
        String email_cliente,
        String senha_cliente,
        String cpf_cliente
    ){ 

        String sql = """
            SELECT * FROM cliente
            WHERE 
                email_cliente = ? OR
                cpf_cliente = ?
            """;
        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {     
            
            comando.setString(1, email_cliente);
            comando.setString(2, cpf_cliente);

            try (ResultSet resultado = comando.executeQuery()) {
            
                if (resultado.next()) {
                    return 1;
                }
                else{
                    return 0;
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }    
    }
}