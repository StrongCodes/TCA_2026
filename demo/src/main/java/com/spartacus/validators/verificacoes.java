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

    public int ValidaCadastro_Cliente(
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
}

//    public int ValidaLogin_Cliente(String email_cliente, String senha_cliente){

//        String sqlCount = """
//            SELECT COUNT(*)
//            FROM cliente
//            """;

//        String sql = """
//            SELECT email_cliente, senha_cliente
//            FROM cliente
//            WHERE id_cliente_pk = ?
//            """;
    
//        try (
//            Connection conexao = ConexãoBD.conectar();
//            PreparedStatement comandoTotal = conexao.prepareStatement(sqlCount)
//        ) {
//            ResultSet resultadoDaContagem = comandoTotal.executeQuery();
//            int Valor = 0;
//            if (resultadoDaContagem.next()) {
//                Valor = resultadoDaContagem.getInt(1);
//            }
        
//            try (ResultSet resultado = comando.executeQuery()) {
            
//                if (resultado.next()) {

//                }
//            }
        
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    
//        return null;
//    }
//}