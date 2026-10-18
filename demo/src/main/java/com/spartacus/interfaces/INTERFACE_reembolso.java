
package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_reembolso {
    public int getIdReembolso();
    public double getValor();
    public LocalDate getDataSolicitacao();
    public LocalDate getDataResolucao();
    public LocalTime getHorarioAgendado();
    public LocalTime getHorarioColeta();
    public int getIdCliente();
    public int getIdPagamento();
}
