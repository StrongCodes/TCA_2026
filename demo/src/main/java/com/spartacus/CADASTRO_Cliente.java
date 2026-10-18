
package com.spartacus;

import com.spartacus.model.cliente;
import com.spartacus.dao.clienteDAO;

public class CADASTRO_Cliente {

    public static void ColetaDados_Cliente(
        Integer id_cliente_pk,
        String nome_cliente,
        String senha_cliente,
        String email_cliente,
        String telefone_cliente,
        String CEP
    ) {
        try {
            cliente novoCliente = new cliente(
                id_cliente_pk,
                nome_cliente,
                senha_cliente,
                email_cliente,
                telefone_cliente,
                CEP
            );

            clienteDAO dao = new clienteDAO();
            dao.cadastrar(novoCliente);

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}