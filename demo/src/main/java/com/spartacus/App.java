
package com.spartacus;

import io.javalin.Javalin;
import java.util.Map;

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
        }).start(8080);

        System.out.println(
            "SPARTACUS iniciado em http://localhost:8080"
        );
    }
}