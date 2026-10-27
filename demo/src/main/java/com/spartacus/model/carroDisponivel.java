
package com.spartacus.model;

import com.spartacus.interfaces.INTERFACE_carroDisponivel;
import com.spartacus.db.ConexãoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class carroDisponivel extends carro implements INTERFACE_carroDisponivel {

    private int ano_carro;
    private String cor_carro;
    private boolean Disponibilidade_carro;
    private Integer id_desconto_pk;
    private float nota_carroDisponivel;
    private float preco_carroDisponivel;

    public carroDisponivel(
        int id_carro_pk,
        String modelo_carro,
        double Potencia_motor,
        String Tipo_motor,
        int NumDeCilindros_motor,
        int ano_carro,
        String cor_carro,
        boolean Disponibilidade_carro,
        Integer id_desconto_pk,
        float nota_carroDisponivel,
        float preco_carroDisponivel
    ) {
        super(
            id_carro_pk,
            modelo_carro,
            Potencia_motor,
            Tipo_motor,
            NumDeCilindros_motor
        );

        this.ano_carro = ano_carro;
        this.cor_carro = cor_carro;
        this.Disponibilidade_carro = Disponibilidade_carro;
        this.id_desconto_pk = id_desconto_pk;
        this.nota_carroDisponivel = nota_carroDisponivel;
        this.preco_carroDisponivel = preco_carroDisponivel;
    }

    public void cadastrar(carroDisponivel carro) throws SQLException {

        String sql = """
            INSERT INTO Carro_Disponivel (
                id_carro_pk,
                ano_carroDisponivel,
                cor_carroDisponivel,
                disponibilidade_carroDisponivel,
                nota_carroDisponivel,
                preco_carroDisponivel,
                desconto_id_desconto_pk
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {
            comando.setInt(1, carro.getId_carro_pk());
            comando.setInt(2, carro.ano_carro);
            comando.setString(3, carro.cor_carro);
            comando.setBoolean(4, carro.Disponibilidade_carro);
            comando.setFloat(5, carro.nota_carroDisponivel);
            comando.setFloat(6, carro.preco_carroDisponivel);

            if (carro.id_desconto_pk == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, carro.id_desconto_pk);
            }

            comando.executeUpdate();
        }
    }

    public static Object ConsultarCarroDisponivelPorID(
        int idCarro,
        String AtributoDesejado
    ) {

        String sql = """
            SELECT *
            FROM Carro_Disponivel
            WHERE id_carro_pk = ?
            """;

        try (
            Connection conexao = ConexãoBD.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)
        ) {

            comando.setInt(1, idCarro);

            try (ResultSet resultado = comando.executeQuery()) {

                if (resultado.next()) {

                    switch (AtributoDesejado) {

                        case "id_carro_pk":
                            return resultado.getInt("id_carro_pk");

                        case "ano_carroDisponivel":
                            return resultado.getInt("ano_carroDisponivel");

                        case "cor_carroDisponivel":
                            return resultado.getString("cor_carroDisponivel");

                        case "disponibilidade_carroDisponivel":
                            return resultado.getBoolean("disponibilidade_carroDisponivel");

                        case "nota_carroDisponivel":
                            return resultado.getFloat("nota_carroDisponivel");

                        case "preco_carroDisponivel":
                            return resultado.getFloat("preco_carroDisponivel");

                        case "desconto_id_desconto_pk":

                            int idDesconto = resultado.getInt(
                                "desconto_id_desconto_pk"
                            );

                            if (resultado.wasNull()) {
                                return null;
                            }

                            return idDesconto;

                        default:
                            return null;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}