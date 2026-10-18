
package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class carroDAO {

    public void cadastrar(carro carro) throws SQLException {

        String sql = """
            INSERT INTO carro (
                modelo_carro,
                ano_carro,
                cor_carro,
                Disponibilidade_carro,
                id_motor,
                id_desconto_pk
            )
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {
            comando.setString(1, carro.getModelo());
            comando.setInt(2, carro.getAno());
            comando.setString(3, carro.getCor());
            comando.setBoolean(4, carro.getDisponibilidade());
            comando.setInt(5, carro.getIdMotor());

            if (carro.getIdDesconto() == null) {
                comando.setNull(6, java.sql.Types.INTEGER);
            } else {
                comando.setInt(6, carro.getIdDesconto());
            }

            comando.executeUpdate();
        }
    }
}
