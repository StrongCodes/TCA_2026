package com.spartacus.interfaces;

import java.time.LocalDate;

public interface INTERFACE_parcela {
    int getId_parcela_pk();
    int getNumeroDeParcelas_pk();
    LocalDate getDataDeVencimento_parcela();
    String getStatus_parcela();
    Integer getLocacao_id_locacao_pk();
    Integer getCompra_id_compra_pk();
}