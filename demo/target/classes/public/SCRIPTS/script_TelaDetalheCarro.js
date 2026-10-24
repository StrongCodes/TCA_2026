document.addEventListener("DOMContentLoaded", () => {

    const IDdetalhes = sessionStorage.getItem("IDdetalhes");

    if (IDdetalhes !== null) {
        PersonalizaDetalhes(IDdetalhes);
    }

});

async function PersonalizaDetalhes(id) {

    try {

        let modelo = await ConsultarCarroPorID(id, "modelo_carro");
        let TipoMotor = await ConsultarCarroPorID(id, "tipoMotor_carro");
        let potenciaMotor_carro = await ConsultarCarroPorID(id, "potenciaMotor_carro");
        let numDeCilindros_carro = await ConsultarCarroPorID(id, "numDeCilindros_carro");
        let ano = await ConsultarCarroDisponivelPorID(id, "ano_carroDisponivel");
        let cor = await ConsultarCarroDisponivelPorID(id, "cor_carroDisponivel"); 
        let preco = await ConsultarCarroDisponivelPorID(id, "preco_carroDisponivel");
        let nota = await ConsultarCarroDisponivelPorID(id, "nota_carroDisponivel");

        console.log("Preço original:", preco);

        let precoFormatado = Number(preco).toLocaleString("pt-BR", {
            minimumFractionDigits: 2,
            maximumFractionDigits: 2
        });
        precoFormatado = precoFormatado.replace(",", ".");
        
        document.getElementById("DivDetalhesImagem")
        .style.backgroundImage = `url('/imagens/${modelo}/Branco.png')`;

        document.getElementById("ParagrafoMelhorForma")
        .innerText = `Escolha a melhor forma de ter o seu ${modelo}`;

        document.getElementById("ParagrafoModelo")
        .innerText = modelo;

        document.getElementById("ParagrafoAnoeCor")
        .innerText = `${modelo} • ${cor}`

        document.getElementById("ParagrafoPreço")
        .innerText = `R$ ${precoFormatado}`;

        document.getElementById("ParagrafoValorCombustivel")
        .innerText = TipoMotor;

        document.getElementById("ParagrafoValorPotencia")
        .innerText = potenciaMotor_carro;

        document.getElementById("ParagrafoValorCilindros")
        .innerText = numDeCilindros_carro;

        document.getElementById("ParagrafoValorAvaliacao")
        .innerText = nota;


    } catch (erro) {

        console.error("Erro ao personalizar detalhes:", erro);
    }
}