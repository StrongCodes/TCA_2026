package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_compra;
import java.time.LocalDate;
import java.time.LocalTime;

public class compra implements INTERFACE_compra {

    private int id_compra_pk;
    private LocalDate DataAgendadaParaColeta_compra;
    private LocalDate DataDeColeta_compra;
    private LocalTime HorarioAgendadoParaColeta_compra;
    private LocalTime HorarioDeColeta_compra;
    private int id_cliente_pk;
    private int id_carro_pk;

    private String MetodoDePagamento_compra;
    private LocalTime HorarioDePagamento_compra;
    private LocalDate DataDePagamento_compra;
    private Double ValorDeEntrada_compra;

    public compra(
        int id_compra_pk,
        LocalDate DataAgendadaParaColeta_compra,
        LocalDate DataDeColeta_compra,
        LocalTime HorarioAgendadoParaColeta_compra,
        LocalTime HorarioDeColeta_compra,
        int id_cliente_pk,
        int id_carro_pk,
        String MetodoDePagamento_compra,
        LocalTime HorarioDePagamento_compra,
        LocalDate DataDePagamento_compra,
        Double ValorDeEntrada_compra
    ) {
        this.id_compra_pk = id_compra_pk;
        this.DataAgendadaParaColeta_compra = DataAgendadaParaColeta_compra;
        this.DataDeColeta_compra = DataDeColeta_compra;
        this.HorarioAgendadoParaColeta_compra = HorarioAgendadoParaColeta_compra;
        this.HorarioDeColeta_compra = HorarioDeColeta_compra;
        this.id_cliente_pk = id_cliente_pk;
        this.id_carro_pk = id_carro_pk;

        this.MetodoDePagamento_compra = MetodoDePagamento_compra;
        this.HorarioDePagamento_compra = HorarioDePagamento_compra;
        this.DataDePagamento_compra = DataDePagamento_compra;
        this.ValorDeEntrada_compra = ValorDeEntrada_compra;
    }

    public int getIdCompra_Compra() {
        return id_compra_pk;
    }

    public LocalDate getDataAgendada_Compra() {
        return DataAgendadaParaColeta_compra;
    }

    public LocalDate getDataColeta_Compra() {
        return DataDeColeta_compra;
    }

    public LocalTime getHorarioAgendado_Compra() {
        return HorarioAgendadoParaColeta_compra;
    }

    public LocalTime getHorarioColeta_Compra() {
        return HorarioDeColeta_compra;
    }

    public int getIdCliente_Compra() {
        return id_cliente_pk;
    }

    public int getIdCarro_Compra() {
        return id_carro_pk;
    }

    public String getMetodoDePagamento_Compra() {
        return MetodoDePagamento_compra;
    }

    public LocalTime getHorarioDePagamento_Compra() {
        return HorarioDePagamento_compra;
    }

    public LocalDate getDataDePagamento_Compra() {
        return DataDePagamento_compra;
    }

    public Double getValorDeEntrada_Compra() {
        return ValorDeEntrada_compra;
    }
}