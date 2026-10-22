package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_carroDisponivel;

public class carroDisponivel extends carro implements INTERFACE_carroDisponivel {

    private int ano_carro;
    private String cor_carro;
    private boolean Disponibilidade_carro;
    private Integer id_desconto_pk;

    public carroDisponivel(
        int id_carro_pk,
        String modelo_carro,
        String Potencia_motor,
        String Tipo_motor,
        int NumDeCilindros_motor,
        double nota,
        int ano_carro,
        String cor_carro,
        boolean Disponibilidade_carro,
        Integer id_desconto_pk
    ) {
        super(
            id_carro_pk,
            modelo_carro,
            Potencia_motor,
            Tipo_motor,
            NumDeCilindros_motor,
            nota
        );

        this.ano_carro = ano_carro;
        this.cor_carro = cor_carro;
        this.Disponibilidade_carro = Disponibilidade_carro;
        this.id_desconto_pk = id_desconto_pk;
    }

    @Override
    public int getAno_carro() {
        return ano_carro;
    }

    @Override
    public String getCor_carro() {
        return cor_carro;
    }

    @Override
    public boolean getDisponibilidade_carro() {
        return Disponibilidade_carro;
    }

    @Override
    public Integer getId_desconto_pk() {
        return id_desconto_pk;
    }
}