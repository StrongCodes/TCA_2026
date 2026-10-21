
package com.spartacus.dao;

import com.spartacus.db.ConexãoBD;
import com.spartacus.model.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            comando.setString(1, carro.getModelo_Carro());
            comando.setInt(2, carro.getAno_Carro());
            comando.setString(3, carro.getCor_Carro());
            comando.setBoolean(4, carro.getDisponibilidade_Carro());
            comando.setInt(5, carro.getIdMotor_Carro());

            if (carro.getIdDesconto_Carro() == null) {
                comando.setNull(6, java.sql.Types.INTEGER);
            } else {
                comando.setInt(6, carro.getIdDesconto_Carro());
            }

            comando.executeUpdate();
        }
    }

    
    public static Object ConsultarCarroPorID(
        int idCarro,
        String AtributoDesejado
    ) {

        String sql = "SELECT * FROM carro WHERE id_carro_pk = ?";

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(1, idCarro);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {

                    if (AtributoDesejado.equals("modelo_carro")) {
                        return resultado.getString("modelo_carro");
                    }
                    else if (AtributoDesejado.equals("ano_carro")) {
                        return resultado.getString("ano_carro");
                    }
                    else if (AtributoDesejado.equals("cor_carro")) {
                        return resultado.getString("cor_carro");
                    }
                    else if (AtributoDesejado.equals("disponibilidade_carro")) {
                        return resultado.getBoolean("disponibilidade_carro");
                    }
                    else if (AtributoDesejado.equals("nota")) {
                        return resultado.getDouble("nota");
                    }
                    else if (AtributoDesejado.equals("motor_id_motor_fk")) {
                        return resultado.getInt("motor_id_motor_fk");
                    }
                    else if (AtributoDesejado.equals("desconto_id_desconto_pk")) {
                        return resultado.getObject("desconto_id_desconto_pk", Integer.class);
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
