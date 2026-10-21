
package com.spartacus;

import io.javalin.Javalin;
import java.util.Map;
import com.spartacus.dao.carroDAO;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {

            config.staticFiles.add("/public");

            config.routes.get("/api/status", ctx -> {
                ctx.json(Map.of(
                    "loja", "SPARTACUS",
                    "status", "online"
                ));
            });

            config.routes.get("/api/ConsultarCarroPorID/{ID}/{AtributoDesejado}", ctx -> {

                int ID = Integer.parseInt(ctx.pathParam("ID"));
                String AtributoDesejado = ctx.pathParam("AtributoDesejado");

                Object Resultado = carroDAO.ConsultarCarroPorID(ID, AtributoDesejado);

                if (Resultado != null) {
                    ctx.json(Resultado);
                } else {
                    ctx.status(404).result("Carro ou atributo não encontrado");
                }
            });

        }).start(8080);

        System.out.println(
            "SPARTACUS iniciado em http://localhost:8080"
        );
    }
}