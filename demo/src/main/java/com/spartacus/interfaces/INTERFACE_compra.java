package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_compra {
    int getIdCompra_Compra();
    LocalDate getDataAgendada_Compra();
    LocalDate getDataColeta_Compra();
    LocalTime getHorarioAgendado_Compra();
    LocalTime getHorarioColeta_Compra();
    int getIdCliente_Compra();
    int getIdCarro_Compra();
    String getMetodoDePagamento_Compra();
    LocalTime getHorarioDePagamento_Compra();
    LocalDate getDataDePagamento_Compra();
    Double getValorDeEntrada_Compra();
}