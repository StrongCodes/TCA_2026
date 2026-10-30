// LÓGICA MUDA TELA:

let Janela;

function MudaTela(TelaDesejada, id = null) {
    if (!TelaDesejada) return;

    if (id !== null) {
        sessionStorage.setItem("IDdetalhes", id);
    }

    Janela = window.open(`/TELAS/${TelaDesejada}.html`, "_blank");

    if (Janela) {
        Janela.focus();
    }
}








//LÓGICA DE PERSONALIZAR A TELA DE DETALHES:

document.addEventListener("DOMContentLoaded", () => {

    const IDdetalhes = sessionStorage.getItem("IDdetalhes");

    if (IDdetalhes !== null) {
        PersonalizaDetalhes(IDdetalhes);
    }

});

document.addEventListener("DOMContentLoaded", () => {
    PersonalizaDetalhes(IDdetalhes);
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








// LÓGICA PERSONALIZAR DADOS DA ESTEIRA DA TELA INICIAL:

async function AtualizaCarros_Categorias(i) {

    let modelo = await ConsultarCarroPorID(i, "modelo_carro");
    let cor = await ConsultarCarroDisponivelPorID(i, "cor_carroDisponivel");
    let Paragrafo = document.getElementById(`ParagrafoCarro${i}`)

    document.getElementById(`DivCarro_${i}`).style.backgroundImage = `url('/imagens/${modelo}/${cor}.png')`;

    if (Paragrafo) {
        Paragrafo.innerText = modelo;
    }
}

for (let i = 1; i <= 21; i++) {

    const Div = document.getElementById(`DivCarro_${i}`);

    if (Div) {

        const Observador = new IntersectionObserver((entradas) => {

            if (entradas[0].isIntersecting) {
                AtualizaCarros_Categorias(i);
            }

        });

        Observador.observe(Div);
    }
}








// LÓGICA PARA CONSULTAR OS METODOS DAS CLASSES:

async function ConsultarCarroPorID(ID, AtributoDesejado) {

    const resposta = await fetch(
        `/api/ConsultarCarroPorID/${ID}/${AtributoDesejado}`
    );

    if (!resposta.ok) {
        throw new Error("Erro ao consultar carro");
    }

    const Resultado = await resposta.text();

    return Resultado;
}

async function ConsultarCarroDisponivelPorID(ID, AtributoDesejado) {

    const resposta = await fetch(
        `/api/ConsultarCarroDisponivelPorID/${ID}/${AtributoDesejado}`
    );

    if (!resposta.ok) {
        throw new Error("Erro ao consultar carro");
    }

    const Resultado = await resposta.text();

    return Resultado;
}

document.getElementById("DivBotaoComprar").onclick = function() {
    MudaTela('TelaCompra', IDdetalhes);
};