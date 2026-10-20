
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_cliente;

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

    public int getIdCliente_Cliente() {
        return id_cliente_pk;
    }

    public String getNome_Cliente() {
        return nome_cliente;
    }

    public String getSenha_Cliente() {
        return senha_cliente;
    }

    public String getEmail_Cliente() {
        return email_cliente;
    }

    public String getTelefone_Cliente() {
        return telefone_cliente;
    }

    public String getCEP_Cliente() {
        return CEP;
    }
}