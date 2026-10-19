
package com.spartacus;

import com.spartacus.model.motor;
import com.spartacus.dao.motorDAO;

public class CADASTRO_Motor {

    public static void main() {
        try {
            motor novoMotor = new motor(
                0,
                "150 cv",
                "Flex",
                4
            );

            motorDAO dao = new motorDAO();
            dao.cadastrar(novoMotor);

            System.out.println("Motor cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}