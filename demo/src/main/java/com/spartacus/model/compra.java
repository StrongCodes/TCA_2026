
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_compra;
import java.time.LocalDate;
import java.time.LocalTime;

public class compra implements INTERFACE_compra {

    private int id_compra_pk;
    private LocalDate DataAgendadaParaColeta_compra;
    private LocalDate DataDeColeta_compra;
    private LocalTime HorarioAgendadoParaColeta_compra;
    private LocalTime HorarioDeColeta_compra;
    private int id_cliente_pk;
    private int id_carro_pk;

    public compra(
        int id_compra_pk,
        LocalDate dataAgendada,
        LocalDate dataColeta,
        LocalTime horarioAgendado,
        LocalTime horarioColeta,
        int id_cliente_pk,
        int id_carro_pk
    ) {
        this.id_compra_pk = id_compra_pk;
        this.DataAgendadaParaColeta_compra = dataAgendada;
        this.DataDeColeta_compra = dataColeta;
        this.HorarioAgendadoParaColeta_compra = horarioAgendado;
        this.HorarioDeColeta_compra = horarioColeta;
        this.id_cliente_pk = id_cliente_pk;
        this.id_carro_pk = id_carro_pk;
    }

    public int getIdCompra_Compra() { 
        return id_compra_pk; 
    }

    public LocalDate getDataAgendada_Compra() { 
        return DataAgendadaParaColeta_compra;
    }
    
    public LocalDate getDataColeta_Compra() { 
        return DataDeColeta_compra; 
    }
    
    public LocalTime getHorarioAgendado_Compra() { 
        return HorarioAgendadoParaColeta_compra; 
    }
    
    public LocalTime getHorarioColeta_Compra() { 
        return HorarioDeColeta_compra; 
    }
    
    public int getIdCliente_Compra() { 
        return id_cliente_pk; 
    }
    
    public int getIdCarro_Compra() { 
        return id_carro_pk; 
    }
}
