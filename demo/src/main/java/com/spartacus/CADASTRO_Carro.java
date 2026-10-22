package com.spartacus;

import com.spartacus.model.carro;
import com.spartacus.dao.carroDAO;

public class CADASTRO_Carro {

    public static void main(String[] args) {
        try {

            carro novoCarro = new carro(
                0,
                "Fiat Mobi",
                "75 cv",
                "Flex",
                3,
                5.0
            );

            carroDAO dao = new carroDAO();
            dao.cadastrar(novoCarro);

            System.out.println("Carro cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}