package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_reembolso;
import java.time.LocalDate;
import java.time.LocalTime;

public class reembolso implements INTERFACE_reembolso {

    private int id_Reembolso_pk;
    private double valor_Reembolso;
    private LocalDate DataSoli_Reembolso;
    private LocalTime HoraSoli_Reembolso;
    private LocalDate Data_Reembolso;
    private LocalTime Hora_Reembolso;
    private Integer compra_id_compra_pk;
    private Integer locacao_id_locacao_pk;

    public reembolso(
        int id_Reembolso_pk,
        double valor_Reembolso,
        LocalDate DataSoli_Reembolso,
        LocalTime HoraSoli_Reembolso,
        LocalDate Data_Reembolso,
        LocalTime Hora_Reembolso,
        Integer compra_id_compra_pk,
        Integer locacao_id_locacao_pk
    ) {

        this.id_Reembolso_pk = id_Reembolso_pk;
        this.valor_Reembolso = valor_Reembolso;
        this.DataSoli_Reembolso = DataSoli_Reembolso;
        this.HoraSoli_Reembolso = HoraSoli_Reembolso;
        this.Data_Reembolso = Data_Reembolso;
        this.Hora_Reembolso = Hora_Reembolso;
        this.compra_id_compra_pk = compra_id_compra_pk;
        this.locacao_id_locacao_pk = locacao_id_locacao_pk;
    }

    public int getId_Reembolso_pk() {
        return id_Reembolso_pk;
    }

    public double getValor_Reembolso() {
        return valor_Reembolso;
    }

    public LocalDate getDataSoli_Reembolso() {
        return DataSoli_Reembolso;
    }

    public LocalTime getHoraSoli_Reembolso() {
        return HoraSoli_Reembolso;
    }

    public LocalDate getData_Reembolso() {
        return Data_Reembolso;
    }

    public LocalTime getHora_Reembolso() {
        return Hora_Reembolso;
    }

    public Integer getCompra_id_compra_pk() {
        return compra_id_compra_pk;
    }

    public Integer getLocacao_id_locacao_pk() {
        return locacao_id_locacao_pk;
    }
}