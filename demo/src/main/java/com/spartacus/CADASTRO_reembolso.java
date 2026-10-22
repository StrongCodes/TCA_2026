package com.spartacus;

import com.spartacus.model.reembolso;
import com.spartacus.dao.reembolsoDAO;
import java.time.LocalDate;
import java.time.LocalTime;

public class CADASTRO_reembolso {

    public static void ColetaDados_Reembolso(
        int id_Reembolso_pk,
        double valor_Reembolso,
        LocalDate DataSoli_Reembolso,
        LocalTime HoraSoli_Reembolso,
        LocalDate Data_Reembolso,
        LocalTime Hora_Reembolso,
        Integer compra_id_compra_pk,
        Integer locacao_id_locacao_pk
    ) {
        try {

            reembolso novoReembolso = new reembolso(
                id_Reembolso_pk,
                valor_Reembolso,
                DataSoli_Reembolso,
                HoraSoli_Reembolso,
                Data_Reembolso,
                Hora_Reembolso,
                compra_id_compra_pk,
                locacao_id_locacao_pk
            );

            reembolsoDAO dao = new reembolsoDAO();
            dao.cadastrar(novoReembolso);

            System.out.println("Reembolso cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}