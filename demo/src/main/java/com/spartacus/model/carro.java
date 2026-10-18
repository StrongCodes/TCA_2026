
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_carro;

public class carro implements INTERFACE_carro {

    private int id_carro_pk;
    private String modelo_carro;
    private int ano_carro;
    private String cor_carro;
    private boolean Disponibilidade_carro;
    private int id_motor;
    private Integer id_desconto_pk;

    public carro(int id_carro_pk, String modelo_carro, int ano_carro, String cor_carro, boolean Disponibilidade_carro, int id_motor, Integer id_desconto_pk) {
        this.id_carro_pk = id_carro_pk;
        this.modelo_carro = modelo_carro;
        this.ano_carro = ano_carro;
        this.cor_carro = cor_carro;
        this.Disponibilidade_carro = Disponibilidade_carro;
        this.id_motor = id_motor;
        this.id_desconto_pk = id_desconto_pk;
    }

    public int getIdCarro() {
        return id_carro_pk;
    }

    public String getModelo() {
        return modelo_carro;
    }

    public int getAno() {
        return ano_carro;
    }

    public String getCor() {
        return cor_carro;
    }

    public boolean getDisponibilidade() {
        return Disponibilidade_carro;
    }

    public int getIdMotor() {
        return id_motor;
    }

    public Integer getIdDesconto() {
        return id_desconto_pk;
    }
}
