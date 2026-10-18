
package com.spartacus.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_pagamento {
    int getIdPagamento();
    String getMetodo();
    LocalTime getHorario();
    LocalDate getData();
    BigDecimal getValorEntrada();
    BigDecimal getValorTotal();
    Integer getIdCompra();
    Integer getIdLocacao();
}
