let idAnterior = 0;
let CategoriaAtual = 0;

function SelecionouCategoria(id){
    CategoriaAtual = id;

    if(CategoriaAtual == 0)
    {
        document.getElementById("DivCategoriaAnterior").style.display = "none"
    }
    else
    {
        document.getElementById("DivCategoriaAnterior").style.display = "flex"
    }


    if(CategoriaAtual == 7)
    {
        document.getElementById("DivCategoriaSeguinte").style.display = "none"
    }
    else
    {
        document.getElementById("DivCategoriaSeguinte").style.display = "flex"
    }

    if(CategoriaAtual >= 0)
    {
        document.getElementById(`${CategoriaAtual}`)
        .style.animation = "CategoriaSelecionada 0s linear forwards"
    }

    if(idAnterior >= 0 && idAnterior != CategoriaAtual)
    {
        document.getElementById(`${idAnterior}`)
        .style.animation = "CategoriaNaoSelecionada 0s linear forwards"
    }
    idAnterior = CategoriaAtual;
}

let intervalo = setInterval(() => {
    SelecionouCategoria(0);

    clearInterval(intervalo);
}, 1);

let posicaoEsteira = 0;

function CategoriaAnterior(){
    let aux = CategoriaAtual - 1;

    if(aux >= 0){SelecionouCategoria(aux);}

    if(aux > 0)
    {
        posicaoEsteira += 1335;

        document.getElementById("DivEsteira").style.transform =
            `translateX(${posicaoEsteira}px)`;
    }
}

function CategoriaSeguinte(){
    let aux = CategoriaAtual + 1;

    if(aux >= 0 && aux < 8)
    {
        SelecionouCategoria(aux);

        if(aux > 1){posicaoEsteira -= 1335;}

        document.getElementById("DivEsteira").style.transform =
            `translateX(${posicaoEsteira}px)`;
    }
}

auxMenu = 1;
function Menu(){
    if(auxMenu == 1)
    {

        document.getElementById("DivBotaoMenu").style.animation = "MenuAberto 0.5s linear forwards";

        document.getElementById("DivDetalhe_2").style.animation = "AnimacaoMenu_Detalhe2_Abrir 0s linear forwards"
    
        document.getElementById("DivDetalhe_1").style.animation = "AnimacaoMenu_Detalhe1_Abrir 0.1s linear forwards"
    
        document.getElementById("DivDetalhe_3").style.animation = "AnimacaoMenu_Detalhe3_Abrir 0.1s linear forwards"
        
        document.getElementById("DivMenu").style.animation = "ApareceMenu 0.5s linear forwards"
        
        document.getElementById("DivMenu").style.display = "flex"
        auxMenu = 0;
    }
    else
    {
        document.getElementById("DivBotaoMenu").style.animation = "MenuFechado 0.5s linear forwards";

        document.getElementById("DivDetalhe_1").style.animation = "AnimacaoMenu_Detalhe1_Fechar 0.1s linear forwards"
        
        document.getElementById("DivDetalhe_3").style.animation = "AnimacaoMenu_Detalhe3_Fechar 0.1s linear forwards"
        
        document.getElementById("DivDetalhe_2").style.animation = "AnimacaoMenu_Detalhe2_Fechar 0s linear forwards"
        
        document.getElementById("DivMenu").style.animation = "EscondeMenu 0.5s linear forwards"
        
        setTimeout(() => {
            document.getElementById("DivMenu").style.display = "none"
        }, 500)
        auxMenu = 1;
    }
}

function VoltaTopo(){
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}

function AbreLogin(){
    document.getElementById("DivFundo").style.display = "flex"
    document.getElementById("DivLogin").style.display = "flex";
    document.getElementById("DivFundo").style.backdropFilter = "blur(5px)";
    document.body.style.overflowY = "hidden";
}

function FechaLogin(){
    document.getElementById("DivFundo").style.display = "none"
    document.getElementById("DivLogin").style.display = "none";
    document.getElementById("DivFundo").style.backdropFilter = "none";
    document.body.style.overflowY = "auto";
}

let sinalNome = 0;

document.getElementById("InputTextoNomeLogin").addEventListener("focus", function() {

    document.getElementById("ParagrafoNome").style.animation =
        "AnimaçaoDoInputNomeClick 0.1s linear forwards";

    sinalNome = 1;
});

document.getElementById("InputTextoNomeLogin").addEventListener("blur", function() {

    if (sinalNome)
    {
        document.getElementById("ParagrafoNome").style.animation =
            "AnimaçaoDoInputNomeSemClick 0.1s linear forwards";
    }

});


let sinalEmail = 0;

document.getElementById("InputTextoEmailLogin").addEventListener("focus", function() {

    document.getElementById("ParagrafoEmail").style.animation =
        "AnimaçaoDoInputEmailClick 0.1s linear forwards";
    sinalEmail = 1;

});

document.getElementById("InputTextoEmailLogin").addEventListener("blur", function() {

    if(sinalEmail)
    {
        document.getElementById("ParagrafoEmail").style.animation =
        "AnimaçaoDoInputEmailSemClick 0.1s linear forwards";
    }
});


let sinalSenha = 0;

document.getElementById("InputTextoSenhaLogin").addEventListener("focus", function() {

    document.getElementById("ParagrafoSenha").style.animation =
        "AnimaçaoDoInputSenhaClick 0.1s linear forwards";

    sinalSenha = 1
});

document.getElementById("InputTextoSenhaLogin").addEventListener("blur", function() {

    if(sinalSenha)
    {
        document.getElementById("ParagrafoSenha").style.animation =
            "AnimaçaoDoInputSenhaSemClick 0.1s linear forwards";
    }

});

let sinalCpf = 0;

document.getElementById("InputTextoCpfLogin").addEventListener("focus", function() {

    document.getElementById("ParagrafoCpf").style.animation =
        "AnimaçaoDoInputCpfClick 0.1s linear forwards";

    sinalCpf = 1;
});

document.getElementById("InputTextoCpfLogin").addEventListener("blur", function() {

    if (sinalCpf)
    {
        document.getElementById("ParagrafoCpf").style.animation =
            "AnimaçaoDoInputCpfSemClick 0.1s linear forwards";
    }

});

let inputNome = document.getElementById("InputTextoNomeLogin");

let placeholderNomeOriginal = inputNome.placeholder;


inputNome.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "Seu nome completo";
    }, 50)

});


inputNome.addEventListener("blur", function(){

    this.placeholder = placeholderNomeOriginal;

});



let input = document.getElementById("InputTextoEmailLogin");

let placeholderOriginal = input.placeholder;

input.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "seu@email.com";
    }, 50)
});


input.addEventListener("blur", function(){
    this.placeholder = placeholderOriginal;
});



let inputSenha = document.getElementById("InputTextoSenhaLogin");

let placeholderSenhaOriginal = inputSenha.placeholder;


inputSenha.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "Sua senha";
    }, 50)

});


inputSenha.addEventListener("blur", function(){

    this.placeholder = placeholderSenhaOriginal;

});



let inputCpf = document.getElementById("InputTextoCpfLogin");

let placeholderCpfOriginal = inputCpf.placeholder;


inputCpf.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "000.000.000-00";
    }, 50)

});


inputCpf.addEventListener("blur", function(){

    this.placeholder = placeholderCpfOriginal;

});

let div = document.getElementById("DivContato");

div.addEventListener("mouseenter", () => {
    div.style.animation = "AnimaçaoContato 0.5s linear forwards";
    setTimeout(() =>{
        document.getElementById("ParagrafoContato").style.display = "flex";
    }, 300)
    document.getElementById("DivLogoWhatsApp").style.right = "-2%"
    document.getElementById("DivLogoWhatsApp").style.transform = "scale(1.40)"
});

div.addEventListener("mouseleave", () => {
    div.style.animation = "AnimaçaoContatoDois 0.5s linear forwards";
    document.getElementById("ParagrafoContato").style.display = "none"
    document.getElementById("DivLogoWhatsApp").style.right = "-12.5%"
    document.getElementById("DivLogoWhatsApp").style.transform = "none"
});

function MudaTela(TelaDesejada) {
    if (!TelaDesejada) return;

    const Janela = window.open(`/TELAS/${TelaDesejada}.html`, "_blank");

    if (Janela) {
        Janela.focus();
    }
}

document.addEventListener("DOMContentLoaded", () => {
    PersonalizaDetalhes(10);
});

async function PersonalizaDetalhes(id){
    let modelo = await ConsultarCarroPorID(id, "modelo_carro");
    document.getElementById("DivTeste").style.backgroundImage = `url('/imagens/${modelo}/Vermelho.png')`;
}

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
