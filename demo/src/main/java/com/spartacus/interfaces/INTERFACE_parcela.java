
package com.spartacus.interfaces;

import java.time.LocalDate;

public interface INTERFACE_parcela {
    int getIdParcela_Parcela();
    int getNumero_Parcela();
    LocalDate getDataVencimento_Parcela();
    String getStatus_Parcela();
    int getIdPagamento_Parcela();
}
