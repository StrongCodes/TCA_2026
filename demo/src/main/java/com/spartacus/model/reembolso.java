
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_reembolso;
import java.time.LocalDate;
import java.time.LocalTime;

public class reembolso implements INTERFACE_reembolso {

    private int id_reembolso_pk;
    private double valor_reembolso;
    private LocalDate dataSol_reembolso;
    private LocalDate dataRes_reembolso;
    private LocalTime horarioAgendadoParaColeta_reembolso;
    private LocalTime horarioDeColeta_reembolso;
    private int cliente_id_cliente_fk;
    private int pagamento_id_pagamento_pk;

    public reembolso(
            int id_reembolso_pk,
            double valor_reembolso,
            LocalDate dataSol_reembolso,
            LocalDate dataRes_reembolso,
            LocalTime horarioAgendadoParaColeta_reembolso,
            LocalTime horarioDeColeta_reembolso,
            int cliente_id_cliente_fk,
            int pagamento_id_pagamento_pk) {

        this.id_reembolso_pk = id_reembolso_pk;
        this.valor_reembolso = valor_reembolso;
        this.dataSol_reembolso = dataSol_reembolso;
        this.dataRes_reembolso = dataRes_reembolso;
        this.horarioAgendadoParaColeta_reembolso =
                horarioAgendadoParaColeta_reembolso;
        this.horarioDeColeta_reembolso = horarioDeColeta_reembolso;
        this.cliente_id_cliente_fk = cliente_id_cliente_fk;
        this.pagamento_id_pagamento_pk = pagamento_id_pagamento_pk;
    }

    public int getIdReembolso() {
        return id_reembolso_pk;
    }

    public double getValor() {
        return valor_reembolso;
    }

    public LocalDate getDataSolicitacao() {
        return dataSol_reembolso;
    }

    public LocalDate getDataResolucao() {
        return dataRes_reembolso;
    }

    public LocalTime getHorarioAgendado() {
        return horarioAgendadoParaColeta_reembolso;
    }

    public LocalTime getHorarioColeta() {
        return horarioDeColeta_reembolso;
    }

    public int getIdCliente() {
        return cliente_id_cliente_fk;
    }

    public int getIdPagamento() {
        return pagamento_id_pagamento_pk;
    }
}