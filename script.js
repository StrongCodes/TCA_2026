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

function CategoriaAnterior(){
    let aux = CategoriaAtual - 1;
    if(aux >= 0)
    {
        SelecionouCategoria(aux);
    }
}

function CategoriaSeguinte(){
    let aux = CategoriaAtual + 1;
    if(aux >= 0 && aux < 8)
    {
        SelecionouCategoria(aux);    
    }
}