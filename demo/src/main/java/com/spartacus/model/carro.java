
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
    private double nota;

    public carro(int id_carro_pk, String modelo_carro, int ano_carro, String cor_carro, boolean Disponibilidade_carro, int id_motor, Integer id_desconto_pk, double nota) {
        this.id_carro_pk = id_carro_pk;
        this.modelo_carro = modelo_carro;
        this.ano_carro = ano_carro;
        this.cor_carro = cor_carro;
        this.Disponibilidade_carro = Disponibilidade_carro;
        this.id_motor = id_motor;
        this.id_desconto_pk = id_desconto_pk;
        this.nota = nota;

    }

    public int getIdCarro_Carro() {
        return id_carro_pk;
    }

    public String getModelo_Carro() {
        return modelo_carro;
    }

    public int getAno_Carro() {
        return ano_carro;
    }

    public String getCor_Carro() {
        return cor_carro;
    }

    public boolean getDisponibilidade_Carro() {
        return Disponibilidade_carro;
    }

    public int getIdMotor_Carro() {
        return id_motor;
    }

    public Integer getIdDesconto_Carro() {
        return id_desconto_pk;
    }

    public double getNota_Carro(){
        return nota;
    }
}
