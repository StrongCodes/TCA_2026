package com.spartacus.interfaces;

import java.time.LocalDate;
import java.math.BigDecimal;

public interface INTERFACE_desconto {
    public int getId();
    public BigDecimal getPorcentagem();
    public LocalDate getDataInicio();
    public LocalDate getDataFinal();
}
