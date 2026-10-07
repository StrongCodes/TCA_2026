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

    if(aux >= 0)
    {
        SelecionouCategoria(aux);

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

        posicaoEsteira -= 1335;

        document.getElementById("DivEsteira").style.transform =
            `translateX(${posicaoEsteira}px)`;
    }
}

aux = 1;
function Menu(){
    if(aux == 1)
    {
        document.getElementById("DivBotaoMenu").style.animation = "MenuAberto 0.5s linear forwards";

        document.getElementById("DivDetalhe_2").style.animation = "AnimacaoMenu_Detalhe2_Abrir 0s linear forwards"
    
        document.getElementById("DivDetalhe_1").style.animation = "AnimacaoMenu_Detalhe1_Abrir 0.1s linear forwards"
    
        document.getElementById("DivDetalhe_3").style.animation = "AnimacaoMenu_Detalhe3_Abrir 0.1s linear forwards"
        
        document.getElementById("DivMenu").style.animation = "ApareceMenu 0.5s linear forwards"
        aux = 0;
    }
    else
    {
        document.getElementById("DivBotaoMenu").style.animation = "MenuFechado 0.5s linear forwards";

        document.getElementById("DivDetalhe_1").style.animation = "AnimacaoMenu_Detalhe1_Fechar 0.1s linear forwards"
        
        document.getElementById("DivDetalhe_3").style.animation = "AnimacaoMenu_Detalhe3_Fechar 0.1s linear forwards"
        
        document.getElementById("DivDetalhe_2").style.animation = "AnimacaoMenu_Detalhe2_Fechar 0s linear forwards"
        
        document.getElementById("DivMenu").style.animation = "EscondeMenu 0.5s linear forwards"
        aux = 1;
    }
}

function VoltaTopo(){
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}