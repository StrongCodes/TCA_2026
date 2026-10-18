
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_parcela;
import java.time.LocalDate;

public class parcela implements INTERFACE_parcela {

    private int id_parcela;
    private int Numero_parcela;
    private LocalDate DataVencimento_parcela;
    private String Status_parcela;
    private int id_pagamento_pk;

    public parcela(
        int id_parcela,
        int numero,
        LocalDate dataVencimento,
        String status,
        int id_pagamento_pk
    ) {
        this.id_parcela = id_parcela;
        this.Numero_parcela = numero;
        this.DataVencimento_parcela = dataVencimento;
        this.Status_parcela = status;
        this.id_pagamento_pk = id_pagamento_pk;
    }

    public int getIdParcela() { return id_parcela; }
    public int getNumero() { return Numero_parcela; }
    public LocalDate getDataVencimento() { return DataVencimento_parcela; }
    public String getStatus() { return Status_parcela; }
    public int getIdPagamento() { return id_pagamento_pk; }
}
