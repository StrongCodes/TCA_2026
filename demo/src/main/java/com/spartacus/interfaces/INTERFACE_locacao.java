
package com.spartacus.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INTERFACE_locacao {
    int getIdLocacao_Locacao();
    LocalDate getDataAgendada_Locacao();
    LocalTime getHorarioAgendado_Locacao();
    LocalTime getHorarioColeta_Locacao();
    LocalDate getDataColeta_Locacao();
    String getPeriodo_Locacao();
    int getIdCliente_Locacao();
    int getIdCarro_Locacao();
}
