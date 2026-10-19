
package com.spartacus;

import com.spartacus.dao.descontoDAO;
import com.spartacus.model.desconto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CADASTRO_Desconto {

    public static void main() {
        try {
            desconto novoDesconto = new desconto(
                0,
                new BigDecimal("15.00"),
                LocalDate.of(2026, 10, 18),
                LocalDate.of(2026, 12, 31)
            );

            descontoDAO dao = new descontoDAO();
            dao.cadastrar(novoDesconto);

            System.out.println("Desconto cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
