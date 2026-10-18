package com.spartacus;

import com.spartacus.model.pagamento;
import com.spartacus.dao.pagamentoDAO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CADASTRO_Pagamento {

    public static void ColetaDados_Pagamento(
        Integer id_pagamento_pk,
        String MetodoDePagamento_pagamento,
        LocalTime HorarioDePagamento_pagamento,
        LocalDate DataDePagamento_pagamento,
        BigDecimal ValorDeEntrada_pagamento,
        BigDecimal ValorTotal_pagamento,
        Integer id_compra_pk,
        Integer id_locacao_pk
    ) {
        try {
            pagamento novoPagamento = new pagamento(
                id_pagamento_pk,
                MetodoDePagamento_pagamento,
                HorarioDePagamento_pagamento,
                DataDePagamento_pagamento,
                ValorDeEntrada_pagamento,
                ValorTotal_pagamento,
                id_compra_pk,
                id_locacao_pk
            );

            pagamentoDAO dao = new pagamentoDAO();
            dao.cadastrar(novoPagamento);

            System.out.println("Pagamento cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}