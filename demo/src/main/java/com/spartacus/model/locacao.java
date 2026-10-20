
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_locacao;
import java.time.LocalDate;
import java.time.LocalTime;

public class locacao implements INTERFACE_locacao {

    private int id_locacao_pk;
    private LocalDate DataAgendadaParaColeta_locacao;
    private LocalTime HorarioAgendadoParaColeta_locacao;
    private LocalTime HorarioDeColeta_locacao;
    private LocalDate DataDeColeta_locacao;
    private String Periodo_locacao;
    private int id_cliente_pk;
    private int id_carro_pk;

    public locacao(
        int id_locacao_pk,
        LocalDate dataAgendada,
        LocalTime horarioAgendado,
        LocalTime horarioColeta,
        LocalDate dataColeta,
        String periodo,
        int id_cliente_pk,
        int id_carro_pk
    ) {
        this.id_locacao_pk = id_locacao_pk;
        this.DataAgendadaParaColeta_locacao = dataAgendada;
        this.HorarioAgendadoParaColeta_locacao = horarioAgendado;
        this.HorarioDeColeta_locacao = horarioColeta;
        this.DataDeColeta_locacao = dataColeta;
        this.Periodo_locacao = periodo;
        this.id_cliente_pk = id_cliente_pk;
        this.id_carro_pk = id_carro_pk;
    }

    public int getIdLocacao_Locacao() { 
        return id_locacao_pk; 
    }
    
    public LocalDate getDataAgendada_Locacao() { 
        return DataAgendadaParaColeta_locacao; 
    }

    public LocalTime getHorarioAgendado_Locacao() { 
        return HorarioAgendadoParaColeta_locacao; 
    }

    public LocalTime getHorarioColeta_Locacao() { 
        return HorarioDeColeta_locacao; 
    }

    public LocalDate getDataColeta_Locacao() { 
        return DataDeColeta_locacao; 
    }
    
    public String getPeriodo_Locacao() { 
        return Periodo_locacao; 
    }

    public int getIdCliente_Locacao() { 
        return id_cliente_pk; 
    }

    public int getIdCarro_Locacao() { 
        return id_carro_pk; 
    }
}