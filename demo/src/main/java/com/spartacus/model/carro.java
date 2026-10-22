package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_carro;

public class carro implements INTERFACE_carro {

    private int id_carro_pk;
    private String modelo_carro;
    private String Potencia_motor;
    private String Tipo_motor;
    private int NumDeCilindros_motor;
    private double nota;

    public carro(
        int id_carro_pk,
        String modelo_carro,
        String Potencia_motor,
        String Tipo_motor,
        int NumDeCilindros_motor,
        double nota
    ) {
        this.id_carro_pk = id_carro_pk;
        this.modelo_carro = modelo_carro;
        this.Potencia_motor = Potencia_motor;
        this.Tipo_motor = Tipo_motor;
        this.NumDeCilindros_motor = NumDeCilindros_motor;
        this.nota = nota;
    }

    public int getId_carro_pk() {
        return id_carro_pk;
    }

    public String getModelo_carro() {
        return modelo_carro;
    }

    public String getPotencia_motor() {
        return Potencia_motor;
    }

    public String getTipo_motor() {
        return Tipo_motor;
    }

    public int getNumDeCilindros_motor() {
        return NumDeCilindros_motor;
    }

    public double getNota() {
        return nota;
    }
}