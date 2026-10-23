package com.spartacus.model;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.spartacus.interfaces.INTERFACE_desconto;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class desconto implements INTERFACE_desconto {

    private int id_desconto_pk;
    private BigDecimal porcentagem_desconto;
    private LocalDate data_inicio_desconto;
    private LocalDate data_final_desconto;

    public desconto(
        int id_desconto_pk,
        BigDecimal porcentagem_desconto,
        LocalDate data_inicio_desconto,
        LocalDate data_final_desconto
    ) {
        this.id_desconto_pk = id_desconto_pk;
        this.porcentagem_desconto = porcentagem_desconto;
        this.data_inicio_desconto = data_inicio_desconto;
        this.data_final_desconto = data_final_desconto;
    }

    public int getIdDesconto_Desconto() {
        return id_desconto_pk;
    }

    public void cadastrar(desconto desconto) throws SQLException {

        String sql = """
            INSERT INTO desconto (
                porcentagem_desconto,
                data_inicio_desconto,
                data_final_desconto
            )
            VALUES (?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setBigDecimal(
                1, desconto.porcentagem_desconto
            );

            comando.setDate(
                2,
                desconto.data_inicio_desconto == null
                    ? null
                    : Date.valueOf(desconto.data_inicio_desconto)
            );

            comando.setDate(
                3,
                desconto.data_final_desconto == null
                    ? null
                    : Date.valueOf(desconto.data_final_desconto)
            );

            comando.executeUpdate();
        }
    }
}