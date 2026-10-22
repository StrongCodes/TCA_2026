package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_reembolso {
    int getId_Reembolso_pk();
    double getValor_Reembolso();
    LocalDate getDataSoli_Reembolso();
    LocalTime getHoraSoli_Reembolso();
    LocalDate getData_Reembolso();
    LocalTime getHora_Reembolso();
    Integer getCompra_id_compra_pk();
    Integer getLocacao_id_locacao_pk();
}