
package com.spartacus;

import com.spartacus.model.reembolso;
import com.spartacus.dao.reembolsoDAO;
import java.time.LocalDate;
import java.time.LocalTime;

public class CADASTRO_reembolso {

    public static void ColetaDados_Reembolso(
        Integer id_reembolso_pk,
        double valor_reembolso,
        LocalDate dataSol_reembolso,
        LocalDate dataRes_reembolso,
        LocalTime horarioAgendadoParaColeta_reembolso,
        LocalTime horarioDeColeta_reembolso,
        int id_cliente_pk,
        int id_pagamento_pk
    ) {
        try {
            reembolso novoReembolso = new reembolso(
                id_reembolso_pk,
                valor_reembolso,
                dataSol_reembolso,
                dataRes_reembolso,
                horarioAgendadoParaColeta_reembolso,
                horarioDeColeta_reembolso,
                id_cliente_pk,
                id_pagamento_pk
            );

            reembolsoDAO dao = new reembolsoDAO();
            dao.cadastrar(novoReembolso);

            System.out.println("Reembolso cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
