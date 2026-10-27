
package com.spartacus;

import io.javalin.Javalin;
import java.util.Map;
import com.spartacus.model.carro;
import com.spartacus.model.carroDisponivel;
import com.spartacus.validators.verificacoes;

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

            config.routes.get("/api/ConsultarCarroDisponivelPorID/{ID}/{AtributoDesejado}", ctx -> {

                int ID = Integer.parseInt(ctx.pathParam("ID"));
                String AtributoDesejado = ctx.pathParam("AtributoDesejado");

                Object Resultado = carroDisponivel.ConsultarCarroDisponivelPorID(ID, AtributoDesejado);

                if (Resultado != null) {
                    ctx.json(Resultado);
                } else {
                    ctx.status(404).result("Carro ou atributo não encontrado");
                }
            });

            config.routes.get("/api/ConsultarCarroPorID/{ID}/{AtributoDesejado}", ctx -> {

                int ID = Integer.parseInt(ctx.pathParam("ID"));
                String AtributoDesejado = ctx.pathParam("AtributoDesejado");

                Object Resultado = carro.ConsultarCarroPorID(ID, AtributoDesejado);

                if (Resultado != null) {
                    ctx.json(Resultado);
                } else {
                    ctx.status(404).result("Carro ou atributo não encontrado");
                }
            });

            config.routes.get("/api/ValidaCadastro_Cliente/{Nome}/{Senha}/{Email}/{Cpf}", ctx -> {

                String Nome = ctx.pathParam("Nome");
                String Senha = ctx.pathParam("Senha");
                String Email = ctx.pathParam("Email");
                String Cpf = ctx.pathParam("Cpf");

                try {
                    int Resultado = verificacoes.ValidaCadastro_Cliente(
                        Nome,
                        Senha,
                        Email,
                        Cpf
                    );
                
                    ctx.result(String.valueOf(Resultado));
                
                } catch (Exception e) {
                    e.printStackTrace();
                    ctx.status(500).result("Erro interno ao cadastrar cliente");
                }
            });
            
            config.routes.get("/api/ValidaLogin_Cliente/{Nome}/{Email}/{Senha}/{Cpf}", ctx -> {

                String Nome = ctx.pathParam("Nome");
                String Email = ctx.pathParam("Email");
                String Senha = ctx.pathParam("Senha");
                String Cpf = ctx.pathParam("Cpf");

                int Resultado = verificacoes.ValidaLogin_Cliente(
                    Nome,
                    Email,
                    Senha,
                    Cpf
                );
            
                ctx.result(String.valueOf(Resultado));
            });

        }).start(8080);

        System.out.println(
            "SPARTACUS iniciado em http://localhost:8080"
        );
    }
}