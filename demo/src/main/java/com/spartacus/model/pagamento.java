
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

    public int getIdPagamento_Pagamento() { 
        return id_pagamento_pk; 
    }

    public String getMetodo_Pagamento() { 
        return MetodoDePagamento_pagamento; 
    }
    
    public LocalTime getHorario_Pagamento() { 
        return HorarioDePagamento_pagamento; 
    }
    
    public LocalDate getData_Pagamento() { 
        return DataDePagamento_pagamento; 
    }

    public BigDecimal getValorEntrada_Pagamento() { 
        return ValorDeEntrada_pagamento; 
    }

    public BigDecimal getValorTotal_Pagamento() { 
        return ValorTotal_pagamento; 
    }

    public Integer getIdCompra_Pagamento() { 
        return id_compra_pk; 
    }
    
    public Integer getIdLocacao_Pagamento() { 
        return id_locacao_pk; 
    }
}