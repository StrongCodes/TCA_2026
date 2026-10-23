
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_compra;
import com.spartacus.db.ConexãoBD;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

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
        LocalDate DataAgendadaParaColeta_compra,
        LocalDate DataDeColeta_compra,
        LocalTime HorarioAgendadoParaColeta_compra,
        LocalTime HorarioDeColeta_compra,
        int id_cliente_pk,
        int id_carro_pk
    ) {
        this.id_compra_pk = id_compra_pk;
        this.DataAgendadaParaColeta_compra = DataAgendadaParaColeta_compra;
        this.DataDeColeta_compra = DataDeColeta_compra;
        this.HorarioAgendadoParaColeta_compra = HorarioAgendadoParaColeta_compra;
        this.HorarioDeColeta_compra = HorarioDeColeta_compra;
        this.id_cliente_pk = id_cliente_pk;
        this.id_carro_pk = id_carro_pk;
    }

    public int getIdCompra_Compra() {
        return id_compra_pk;
    }

    public void cadastrar(compra compra) throws SQLException {

        String sql = """
            INSERT INTO compra (
                dataAgendadaParaColeta_compra,
                dataDeColeta_compra,
                horarioAgendadoParaColeta_compra,
                horaDeColeta_compra,
                cliente_id_cliente_pk,
                Carro_Disponivel_id_carro_pk
            )
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            if (compra.DataAgendadaParaColeta_compra == null) {
                comando.setNull(1, Types.DATE);
            } else {
                comando.setDate(
                    1,
                    java.sql.Date.valueOf(
                        compra.DataAgendadaParaColeta_compra
                    )
                );
            }

            if (compra.DataDeColeta_compra == null) {
                comando.setNull(2, Types.DATE);
            } else {
                comando.setDate(
                    2,
                    java.sql.Date.valueOf(
                        compra.DataDeColeta_compra
                    )
                );
            }

            if (compra.HorarioAgendadoParaColeta_compra == null) {
                comando.setNull(3, Types.TIME);
            } else {
                comando.setTime(
                    3,
                    java.sql.Time.valueOf(
                        compra.HorarioAgendadoParaColeta_compra
                    )
                );
            }

            if (compra.HorarioDeColeta_compra == null) {
                comando.setNull(4, Types.TIME);
            } else {
                comando.setTime(
                    4,
                    java.sql.Time.valueOf(
                        compra.HorarioDeColeta_compra
                    )
                );
            }

            comando.setInt(
                5,
                compra.id_cliente_pk
            );

            comando.setInt(
                6,
                compra.id_carro_pk
            );

            comando.executeUpdate();
        }
    }
}