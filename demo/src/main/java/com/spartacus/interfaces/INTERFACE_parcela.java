
package com.spartacus.interfaces;

import java.time.LocalDate;

public interface INTERFACE_parcela {
    int getIdParcela();
    int getNumero();
    LocalDate getDataVencimento();
    String getStatus();
    int getIdPagamento();
}
