
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_reembolso;
import com.spartacus.db.ConexãoBD;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class reembolso implements INTERFACE_reembolso {

    private int id_Reembolso_pk;
    private double valor_Reembolso;
    private LocalDate DataSoli_Reembolso;
    private LocalTime HoraSoli_Reembolso;
    private LocalDate Data_Reembolso;
    private LocalTime Hora_Reembolso;
    private Integer compra_id_compra_pk;
    private Integer locacao_id_locacao_pk;
    private int cliente_id_cliente_pk;

    public reembolso(
        int id_Reembolso_pk,
        double valor_Reembolso,
        LocalDate DataSoli_Reembolso,
        LocalTime HoraSoli_Reembolso,
        LocalDate Data_Reembolso,
        LocalTime Hora_Reembolso,
        Integer compra_id_compra_pk,
        Integer locacao_id_locacao_pk,
        int cliente_id_cliente_pk
    ) {
        this.id_Reembolso_pk = id_Reembolso_pk;
        this.valor_Reembolso = valor_Reembolso;
        this.DataSoli_Reembolso = DataSoli_Reembolso;
        this.HoraSoli_Reembolso = HoraSoli_Reembolso;
        this.Data_Reembolso = Data_Reembolso;
        this.Hora_Reembolso = Hora_Reembolso;
        this.compra_id_compra_pk = compra_id_compra_pk;
        this.locacao_id_locacao_pk = locacao_id_locacao_pk;
        this.cliente_id_cliente_pk = cliente_id_cliente_pk;
    }

    public int getId_Reembolso_pk() {
        return id_Reembolso_pk;
    }

    public void cadastrar(reembolso reembolso) throws SQLException {

        String sql = """
            INSERT INTO Reembolso (
                valor_Reembolso,
                DataSoli_Reembolso,
                HoraSoli_Reembolso,
                Data_Reembolso,
                Hora_Reembolso,
                compra_id_compra_pk,
                locacao_id_locacao_pk,
                cliente_id_cliente_pk
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setDouble(1, reembolso.valor_Reembolso);

            comando.setDate(
                2,
                java.sql.Date.valueOf(reembolso.DataSoli_Reembolso)
            );

            comando.setTime(
                3,
                java.sql.Time.valueOf(reembolso.HoraSoli_Reembolso)
            );

            if (reembolso.Data_Reembolso == null) {
                comando.setNull(4, Types.DATE);
            } else {
                comando.setDate(
                    4,
                    java.sql.Date.valueOf(reembolso.Data_Reembolso)
                );
            }

            if (reembolso.Hora_Reembolso == null) {
                comando.setNull(5, Types.TIME);
            } else {
                comando.setTime(
                    5,
                    java.sql.Time.valueOf(reembolso.Hora_Reembolso)
                );
            }

            if (reembolso.compra_id_compra_pk == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, reembolso.compra_id_compra_pk);
            }

            if (reembolso.locacao_id_locacao_pk == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, reembolso.locacao_id_locacao_pk);
            }

            comando.setInt(8, reembolso.cliente_id_cliente_pk);

            comando.executeUpdate();
        }
    }
}