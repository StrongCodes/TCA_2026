package com.spartacus;

import com.spartacus.model.locacao;
import com.spartacus.dao.locacaoDAO;
import java.time.LocalDate;
import java.time.LocalTime;

public class CADASTRO_Locacao {

    public static void ColetaDados_Locacao(
        Integer id_locacao_pk,
        LocalDate DataAgendadaParaColeta_locacao,
        LocalTime HorarioAgendadoParaColeta_locacao,
        LocalTime HorarioDeColeta_locacao,
        LocalDate DataDeColeta_locacao,
        double Periodo_locacao,
        int id_cliente_pk,
        int id_carro_pk,
        String MetodoDePagamento_locacao,
        LocalTime HorarioDePagamento_locacao,
        LocalDate DataDePagamento_locacao,
        Double ValorDeEntrada_locacao
    ) {
        try {

            locacao novaLocacao = new locacao(
                id_locacao_pk == null ? 0 : id_locacao_pk,
                DataAgendadaParaColeta_locacao,
                HorarioAgendadoParaColeta_locacao,
                HorarioDeColeta_locacao,
                DataDeColeta_locacao,
                Periodo_locacao,
                id_cliente_pk,
                id_carro_pk,
                MetodoDePagamento_locacao,
                HorarioDePagamento_locacao,
                DataDePagamento_locacao,
                ValorDeEntrada_locacao
            );

            locacaoDAO dao = new locacaoDAO();
            dao.cadastrar(novaLocacao);

            System.out.println("Locação cadastrada com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}