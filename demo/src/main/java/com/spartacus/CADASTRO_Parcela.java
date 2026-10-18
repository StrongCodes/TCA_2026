package com.spartacus;

import com.spartacus.model.parcela;
import com.spartacus.dao.parcelaDAO;
import java.time.LocalDate;

public class CADASTRO_Parcela {

    public static void ColetaDados_Parcela(
        Integer id_parcela,
        int Numero_parcela,
        LocalDate DataVencimento_parcela,
        String Status_parcela,
        int id_pagamento_pk
    ) {
        try {
            parcela novaParcela = new parcela(
                id_parcela,
                Numero_parcela,
                DataVencimento_parcela,
                Status_parcela,
                id_pagamento_pk
            );

            parcelaDAO dao = new parcelaDAO();
            dao.cadastrar(novaParcela);

            System.out.println("Parcela cadastrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}