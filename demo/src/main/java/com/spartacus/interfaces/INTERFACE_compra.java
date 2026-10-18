
package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_compra {
    int getIdCompra();
    LocalDate getDataAgendada();
    LocalDate getDataColeta();
    LocalTime getHorarioAgendado();
    LocalTime getHorarioColeta();
    int getIdCliente();
    int getIdCarro();
}
