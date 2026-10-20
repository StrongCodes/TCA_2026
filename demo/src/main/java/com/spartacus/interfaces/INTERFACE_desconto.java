package com.spartacus.interfaces;

import java.time.LocalDate;
import java.math.BigDecimal;

public interface INTERFACE_desconto {
    public int getIdDesconto_Desconto();
    public BigDecimal getPorcentagem_Desconto();
    public LocalDate getDataInicio_Desconto();
    public LocalDate getDataFinal_Desconto();
}
