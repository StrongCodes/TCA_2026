package com.spartacus.model;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.spartacus.interfaces.INTERFACE_desconto;

public class desconto implements INTERFACE_desconto{
    private int id_desconto_pk;
    private BigDecimal porcentagem_desconto;
    private LocalDate data_inicio_desconto;
    private LocalDate data_final_desconto;

    public desconto(int id_desconto_pk, BigDecimal porcentagem_desconto, LocalDate data_inicio_desconto,LocalDate data_final_desconto){
        this.id_desconto_pk = id_desconto_pk;
        this.porcentagem_desconto = porcentagem_desconto;
        this.data_inicio_desconto = data_inicio_desconto;
        this.data_final_desconto = data_final_desconto;
    }

    public int getId(){
        return id_desconto_pk;
    }

    public BigDecimal getPorcentagem(){
        return porcentagem_desconto;
    }

    public LocalDate getDataInicio(){
        return data_inicio_desconto;
    }

    public LocalDate getDataFinal(){
        return data_final_desconto;
    }
}