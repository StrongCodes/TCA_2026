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

function AbreLogin(){
    document.getElementById("DivFundo").style.display = "flex"
    document.getElementById("DivLogin").style.display = "flex";
}

function FechaLogin(){
    document.getElementById("DivFundo").style.display = "none"
    document.getElementById("DivLogin").style.display = "none";
}


let sinalEmail = 0;

document.getElementById("InputTextoEmailLogin").addEventListener("focus", function() {

    document.getElementById("ParagrafoEmail").style.animation =
        "AnimaçaoDoInputEmailClick 0.1s linear forwards";
    sinalEmail = 1;

});


let sinalSenha = 0;

document.getElementById("InputTextoSenhaLogin").addEventListener("focus", function() {

    document.getElementById("ParagrafoSenha").style.animation =
        "AnimaçaoDoInputSenhaClick 0.1s linear forwards";

    sinalSenha = 1
});


document.getElementById("InputTextoEmailLogin").addEventListener("blur", function() {

    if(sinalEmail)
    {
        document.getElementById("ParagrafoEmail").style.animation =
        "AnimaçaoDoInputEmailSemClick 0.1s linear forwards";
    }
});



document.getElementById("InputTextoSenhaLogin").addEventListener("blur", function() {

    if(sinalSenha)
    {
        document.getElementById("ParagrafoSenha").style.animation =
            "AnimaçaoDoInputSenhaSemClick 0.1s linear forwards";
    }

});