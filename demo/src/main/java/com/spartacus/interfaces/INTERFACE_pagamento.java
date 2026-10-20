
package com.spartacus.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_pagamento {
    int getIdPagamento_Pagamento();
    String getMetodo_Pagamento();
    LocalTime getHorario_Pagamento();
    LocalDate getData_Pagamento();
    BigDecimal getValorEntrada_Pagamento();
    BigDecimal getValorTotal_Pagamento();
    Integer getIdCompra_Pagamento();
    Integer getIdLocacao_Pagamento();
}
