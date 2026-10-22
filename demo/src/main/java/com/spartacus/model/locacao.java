package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_locacao;
import java.time.LocalDate;
import java.time.LocalTime;

public class locacao implements INTERFACE_locacao {

    private int id_locacao_pk;
    private LocalDate DataAgendadaParaColeta_locacao;
    private LocalTime HorarioAgendadoParaColeta_locacao;
    private LocalTime HorarioDeColeta_locacao;
    private LocalDate DataDeColeta_locacao;
    private double Periodo_locacao;
    private int id_cliente_pk;
    private int id_carro_pk;

    private String MetodoDePagamento_locacao;
    private LocalTime HorarioDePagamento_locacao;
    private LocalDate DataDePagamento_locacao;
    private Double ValorDeEntrada_locacao;

    public locacao(
        int id_locacao_pk,
        LocalDate DataAgendadaParaColeta_locacao,
        LocalTime HorarioAgendadoParaColeta_locacao,
        LocalTime HorarioDeColeta_locacao,
        LocalDate DataDeColeta_locacao,
        double Periodo_locacao,
        int id_cliente_pk,
        int id_carro_pk,
        String MetodoDePagamento_locacao,
        LocalTime HorarioDePagamento_locacao,
        LocalDate DataDePagamento_locacao,
        Double ValorDeEntrada_locacao
    ) {
        this.id_locacao_pk = id_locacao_pk;
        this.DataAgendadaParaColeta_locacao = DataAgendadaParaColeta_locacao;
        this.HorarioAgendadoParaColeta_locacao = HorarioAgendadoParaColeta_locacao;
        this.HorarioDeColeta_locacao = HorarioDeColeta_locacao;
        this.DataDeColeta_locacao = DataDeColeta_locacao;
        this.Periodo_locacao = Periodo_locacao;
        this.id_cliente_pk = id_cliente_pk;
        this.id_carro_pk = id_carro_pk;

        this.MetodoDePagamento_locacao = MetodoDePagamento_locacao;
        this.HorarioDePagamento_locacao = HorarioDePagamento_locacao;
        this.DataDePagamento_locacao = DataDePagamento_locacao;
        this.ValorDeEntrada_locacao = ValorDeEntrada_locacao;
    }

    public int getIdLocacao_Locacao() {
        return id_locacao_pk;
    }

    public LocalDate getDataAgendada_Locacao() {
        return DataAgendadaParaColeta_locacao;
    }

    public LocalTime getHorarioAgendado_Locacao() {
        return HorarioAgendadoParaColeta_locacao;
    }

    public LocalTime getHorarioColeta_Locacao() {
        return HorarioDeColeta_locacao;
    }

    public LocalDate getDataColeta_Locacao() {
        return DataDeColeta_locacao;
    }

    public double getPeriodo_Locacao() {
        return Periodo_locacao;
    }

    public int getIdCliente_Locacao() {
        return id_cliente_pk;
    }

    public int getIdCarro_Locacao() {
        return id_carro_pk;
    }

    public String getMetodoDePagamento_Locacao() {
        return MetodoDePagamento_locacao;
    }

    public LocalTime getHorarioDePagamento_Locacao() {
        return HorarioDePagamento_locacao;
    }

    public LocalDate getDataDePagamento_Locacao() {
        return DataDePagamento_locacao;
    }

    public Double getValorDeEntrada_Locacao() {
        return ValorDeEntrada_locacao;
    }
}