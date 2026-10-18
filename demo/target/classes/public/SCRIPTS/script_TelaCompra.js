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