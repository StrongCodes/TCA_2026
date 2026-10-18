
package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_locacao {
    int getIdLocacao();
    LocalDate getDataAgendada();
    LocalTime getHorarioAgendado();
    LocalTime getHorarioColeta();
    LocalDate getDataColeta();
    String getPeriodo();
    int getIdCliente();
    int getIdCarro();
}
