
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_parcela;
import com.spartacus.db.ConexãoBD;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class parcela implements INTERFACE_parcela {

    private int id_parcela_pk;
    private int NumeroDeParcelas_parcela;
    private LocalDate DataDeVencimento_parcela;
    private String status_parcela;
    private Integer locacao_id_locacao_pk;
    private Integer compra_id_compra_pk;

    private double ValorTotal_parcela;
    private double ValorDeEntrada_parcela;
    private String MetodoDePagamento_parcela;
    private LocalDate DataDePagamento_parcela;
    private LocalTime HorarioDePagamento_parcela;

    public parcela(
        int id_parcela_pk,
        int NumeroDeParcelas_parcela,
        LocalDate DataDeVencimento_parcela,
        String status_parcela,
        Integer locacao_id_locacao_pk,
        Integer compra_id_compra_pk,
        double ValorTotal_parcela,
        double ValorDeEntrada_parcela,
        String MetodoDePagamento_parcela,
        LocalDate DataDePagamento_parcela,
        LocalTime HorarioDePagamento_parcela
    ) {
        this.id_parcela_pk = id_parcela_pk;
        this.NumeroDeParcelas_parcela = NumeroDeParcelas_parcela;
        this.DataDeVencimento_parcela = DataDeVencimento_parcela;
        this.status_parcela = status_parcela;
        this.locacao_id_locacao_pk = locacao_id_locacao_pk;
        this.compra_id_compra_pk = compra_id_compra_pk;

        this.ValorTotal_parcela = ValorTotal_parcela;
        this.ValorDeEntrada_parcela = ValorDeEntrada_parcela;
        this.MetodoDePagamento_parcela = MetodoDePagamento_parcela;
        this.DataDePagamento_parcela = DataDePagamento_parcela;
        this.HorarioDePagamento_parcela = HorarioDePagamento_parcela;
    }

    public int getId_parcela_pk() {
        return id_parcela_pk;
    }

    public void cadastrar(parcela parcela) throws SQLException {

        String sql = """
            INSERT INTO parcela (
                NumeroDeParcelas_parcela,
                DataDeVencimento_parcela,
                status_parcela,
                locacao_id_locacao_pk,
                compra_id_compra_pk,
                ValorTotal_parcela,
                ValorDeEntrada_parcela,
                MetodoDePagamento_parcela,
                DataDePagamento_parcela,
                HorarioDePagamento_parcela
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(1, parcela.NumeroDeParcelas_parcela);

            comando.setDate(
                2,
                java.sql.Date.valueOf(parcela.DataDeVencimento_parcela)
            );

            comando.setString(3, parcela.status_parcela);

            if (parcela.locacao_id_locacao_pk == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, parcela.locacao_id_locacao_pk);
            }

            if (parcela.compra_id_compra_pk == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, parcela.compra_id_compra_pk);
            }

            comando.setDouble(6, parcela.ValorTotal_parcela);

            comando.setDouble(7, parcela.ValorDeEntrada_parcela);

            comando.setString(
                8,
                parcela.MetodoDePagamento_parcela
            );

            if (parcela.DataDePagamento_parcela == null) {
                comando.setNull(9, Types.DATE);
            } else {
                comando.setDate(
                    9,
                    java.sql.Date.valueOf(parcela.DataDePagamento_parcela)
                );
            }

            if (parcela.HorarioDePagamento_parcela == null) {
                comando.setNull(10, Types.TIME);
            } else {
                comando.setTime(
                    10,
                    java.sql.Time.valueOf(parcela.HorarioDePagamento_parcela)
                );
            }

            comando.executeUpdate();
        }
    }
}