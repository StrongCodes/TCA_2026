
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_locacao;
import com.spartacus.db.ConexãoBD;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class locacao implements INTERFACE_locacao {

    private int id_locacao_pk;
    private LocalDate DataAgendadaParaColeta_locacao;
    private LocalTime HorarioAgendadoParaColeta_locacao;
    private LocalTime HorarioDeColeta_locacao;
    private LocalDate DataDeColeta_locacao;
    private double Periodo_locacao;
    private int id_cliente_pk;
    private int id_carro_pk;

    public locacao(
        int id_locacao_pk,
        LocalDate DataAgendadaParaColeta_locacao,
        LocalTime HorarioAgendadoParaColeta_locacao,
        LocalTime HorarioDeColeta_locacao,
        LocalDate DataDeColeta_locacao,
        double Periodo_locacao,
        int id_cliente_pk,
        int id_carro_pk
    ) {
        this.id_locacao_pk = id_locacao_pk;
        this.DataAgendadaParaColeta_locacao = DataAgendadaParaColeta_locacao;
        this.HorarioAgendadoParaColeta_locacao = HorarioAgendadoParaColeta_locacao;
        this.HorarioDeColeta_locacao = HorarioDeColeta_locacao;
        this.DataDeColeta_locacao = DataDeColeta_locacao;
        this.Periodo_locacao = Periodo_locacao;
        this.id_cliente_pk = id_cliente_pk;
        this.id_carro_pk = id_carro_pk;
    }

    public int getIdLocacao_Locacao() {
        return id_locacao_pk;
    }

    public void cadastrar(locacao locacao) throws SQLException {

        String sql = """
            INSERT INTO locacao (
                dataAgendadaParaColeta_locacao,
                horarioAgendadoParaColeta_locacao,
                horaDeColeta_locacao,
                dataDeColeta_locacao,
                Periodo_locacao,
                cliente_id_cliente_pk,
                Carro_Disponivel_id_carro_pk
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            if (locacao.DataAgendadaParaColeta_locacao == null) {
                comando.setNull(1, Types.DATE);
            } else {
                comando.setDate(
                    1,
                    java.sql.Date.valueOf(
                        locacao.DataAgendadaParaColeta_locacao
                    )
                );
            }

            if (locacao.HorarioAgendadoParaColeta_locacao == null) {
                comando.setNull(2, Types.TIME);
            } else {
                comando.setTime(
                    2,
                    java.sql.Time.valueOf(
                        locacao.HorarioAgendadoParaColeta_locacao
                    )
                );
            }

            if (locacao.HorarioDeColeta_locacao == null) {
                comando.setNull(3, Types.TIME);
            } else {
                comando.setTime(
                    3,
                    java.sql.Time.valueOf(
                        locacao.HorarioDeColeta_locacao
                    )
                );
            }

            if (locacao.DataDeColeta_locacao == null) {
                comando.setNull(4, Types.DATE);
            } else {
                comando.setDate(
                    4,
                    java.sql.Date.valueOf(
                        locacao.DataDeColeta_locacao
                    )
                );
            }

            comando.setDouble(
                5,
                locacao.Periodo_locacao
            );

            comando.setInt(
                6,
                locacao.id_cliente_pk
            );

            comando.setInt(
                7,
                locacao.id_carro_pk
            );

            comando.executeUpdate();
        }
    }
}