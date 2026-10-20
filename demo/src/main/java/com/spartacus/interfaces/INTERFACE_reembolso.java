
package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_reembolso {
    public int getIdReembolso_Reembolso();
    public double getValor_Reembolso();
    public LocalDate getDataSolicitacao_Reembolso();
    public LocalDate getDataResolucao_Reembolso();
    public LocalTime getHorarioAgendado_Reembolso();
    public LocalTime getHorarioColeta_Reembolso();
    public int getIdCliente_Reembolso();
    public int getIdPagamento_Reembolso();
}
