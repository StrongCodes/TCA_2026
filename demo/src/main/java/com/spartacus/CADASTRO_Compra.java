
package com.spartacus;

import com.spartacus.model.compra;
import com.spartacus.dao.compraDAO;
import java.time.LocalDate;
import java.time.LocalTime;

public class CADASTRO_Compra {

    public static void ColetaDados_Compra(
        Integer id_compra_pk,
        LocalDate DataAgendadaParaColeta_compra,
        LocalDate DataDeColeta_compra,
        LocalTime HorarioAgendadoParaColeta_compra,
        LocalTime HorarioDeColeta_compra,
        int id_cliente_pk,
        int id_carro_pk
    ) {
        try {
            compra novaCompra = new compra(
                id_compra_pk,
                DataAgendadaParaColeta_compra,
                DataDeColeta_compra,
                HorarioAgendadoParaColeta_compra,
                HorarioDeColeta_compra,
                id_cliente_pk,
                id_carro_pk
            );

            compraDAO dao = new compraDAO();
            dao.cadastrar(novaCompra);

            System.out.println("Compra cadastrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}