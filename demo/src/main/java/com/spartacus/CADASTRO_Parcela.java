package com.spartacus;

import com.spartacus.model.parcela;
import com.spartacus.dao.parcelaDAO;
import java.time.LocalDate;

public class CADASTRO_Parcela {

    public static void ColetaDados_Parcela(
        int id_parcela_pk,
        int NumeroDeParcelas_pk,
        LocalDate DataDeVencimento_parcela,
        String status_parcela,
        Integer locacao_id_locacao_pk,
        Integer compra_id_compra_pk
    ) {
        try {

            parcela novaParcela = new parcela(
                id_parcela_pk,
                NumeroDeParcelas_pk,
                DataDeVencimento_parcela,
                status_parcela,
                locacao_id_locacao_pk,
                compra_id_compra_pk
            );

            parcelaDAO dao = new parcelaDAO();
            dao.cadastrar(novaParcela);

            System.out.println("Parcela cadastrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}