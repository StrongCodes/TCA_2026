package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_parcela;
import java.time.LocalDate;

public class parcela implements INTERFACE_parcela {

    private int id_parcela_pk;
    private int NumeroDeParcelas_pk;
    private LocalDate DataDeVencimento_parcela;
    private String status_parcela;
    private Integer locacao_id_locacao_pk;
    private Integer compra_id_compra_pk;

    public parcela(
        int id_parcela_pk,
        int NumeroDeParcelas_pk,
        LocalDate DataDeVencimento_parcela,
        String status_parcela,
        Integer locacao_id_locacao_pk,
        Integer compra_id_compra_pk
    ) {
        this.id_parcela_pk = id_parcela_pk;
        this.NumeroDeParcelas_pk = NumeroDeParcelas_pk;
        this.DataDeVencimento_parcela = DataDeVencimento_parcela;
        this.status_parcela = status_parcela;
        this.locacao_id_locacao_pk = locacao_id_locacao_pk;
        this.compra_id_compra_pk = compra_id_compra_pk;
    }

    public int getId_parcela_pk() {
        return id_parcela_pk;
    }

    public int getNumeroDeParcelas_pk() {
        return NumeroDeParcelas_pk;
    }

    public LocalDate getDataDeVencimento_parcela() {
        return DataDeVencimento_parcela;
    }

    public String getStatus_parcela() {
        return status_parcela;
    }

    public Integer getLocacao_id_locacao_pk() {
        return locacao_id_locacao_pk;
    }

    public Integer getCompra_id_compra_pk() {
        return compra_id_compra_pk;
    }
}