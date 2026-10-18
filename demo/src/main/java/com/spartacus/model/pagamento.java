
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_pagamento;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class pagamento implements INTERFACE_pagamento {

    private int id_pagamento_pk;
    private String MetodoDePagamento_pagamento;
    private LocalTime HorarioDePagamento_pagamento;
    private LocalDate DataDePagamento_pagamento;
    private BigDecimal ValorDeEntrada_pagamento;
    private BigDecimal ValorTotal_pagamento;
    private Integer id_compra_pk;
    private Integer id_locacao_pk;

    public pagamento(
        int id_pagamento_pk,
        String metodo,
        LocalTime horario,
        LocalDate data,
        BigDecimal valorEntrada,
        BigDecimal valorTotal,
        Integer id_compra_pk,
        Integer id_locacao_pk
    ) {
        this.id_pagamento_pk = id_pagamento_pk;
        this.MetodoDePagamento_pagamento = metodo;
        this.HorarioDePagamento_pagamento = horario;
        this.DataDePagamento_pagamento = data;
        this.ValorDeEntrada_pagamento = valorEntrada;
        this.ValorTotal_pagamento = valorTotal;
        this.id_compra_pk = id_compra_pk;
        this.id_locacao_pk = id_locacao_pk;
    }

    public int getIdPagamento() { return id_pagamento_pk; }
    public String getMetodo() { return MetodoDePagamento_pagamento; }
    public LocalTime getHorario() { return HorarioDePagamento_pagamento; }
    public LocalDate getData() { return DataDePagamento_pagamento; }
    public BigDecimal getValorEntrada() { return ValorDeEntrada_pagamento; }
    public BigDecimal getValorTotal() { return ValorTotal_pagamento; }
    public Integer getIdCompra() { return id_compra_pk; }
    public Integer getIdLocacao() { return id_locacao_pk; }
}
