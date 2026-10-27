// LÓGICA ESTEIRA DE CARROS:

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

if (document.getElementById("DivCategoriaAnterior")) {
    SelecionouCategoria(0);
}


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








// LÓGICA MENU:

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








// LÓGICA VOLTA AO TOPO DO RODAPÉ

function VoltaTopo(){
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}








// LÓGICA LOGIN:

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

if (document.getElementById("InputTextoNomeLogin")) {

    let sinalNome = 0;

    document.getElementById("InputTextoNomeLogin").addEventListener("focus", function() {

        document.getElementById("ParagrafoNome").style.animation =
            "AnimaçaoDoInputNomeClick 0.1s linear forwards";

        sinalNome = 1;
    });

    document.getElementById("InputTextoNomeLogin").addEventListener("blur", function() {

        if (sinalNome && document.getElementById("InputTextoNomeLogin").value.trim() === "") {
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

        if (sinalEmail && document.getElementById("InputTextoEmailLogin").value.trim() === "") {
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

        if (sinalSenha && document.getElementById("InputTextoSenhaLogin").value.trim() === "") {
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

        if (sinalCpf && document.getElementById("InputTextoCpfLogin").value.trim() === "") {
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
}








// LÓGICA CADASTRO:

if (document.getElementById("InputTextoNomeCadastro")) {
    let CadastroSinalNome = 0;

    document.getElementById("InputTextoNomeCadastro").addEventListener("focus", function() {

        document.getElementById("ParagrafoNome").style.animation =
            "AnimaçaoDoInputNomeClick 0.1s linear forwards";

        CadastroSinalNome = 1;
    });

    document.getElementById("InputTextoNomeCadastro").addEventListener("blur", function() {
        
        if (CadastroSinalNome && this.value.trim() === "") {
            document.getElementById("ParagrafoNome").style.animation =
                "AnimaçaoDoInputNomeSemClick 0.1s linear forwards";
        }
    
    });


    let CadastroSinalEmail = 0;

    document.getElementById("InputTextoEmailCadastro").addEventListener("focus", function() {

        document.getElementById("ParagrafoEmail").style.animation =
            "AnimaçaoDoInputEmailClick 0.1s linear forwards";
        CadastroSinalEmail = 1;

    });

    document.getElementById("InputTextoEmailCadastro").addEventListener("blur", function() {
    
        if (CadastroSinalEmail && this.value.trim() === "") {
            document.getElementById("ParagrafoEmail").style.animation =
                "AnimaçaoDoInputEmailSemClick 0.1s linear forwards";
        }
    
    });


    let CadastroSinalSenha = 0;

    document.getElementById("InputTextoSenhaCadastro").addEventListener("focus", function() {

        document.getElementById("ParagrafoSenha").style.animation =
            "AnimaçaoDoInputSenhaClick 0.1s linear forwards";

        CadastroSinalSenha = 1;
    });

    document.getElementById("InputTextoSenhaCadastro").addEventListener("blur", function() {
        
        if (CadastroSinalSenha && this.value.trim() === "") {
            document.getElementById("ParagrafoSenha").style.animation =
                "AnimaçaoDoInputSenhaSemClick 0.1s linear forwards";
        }
    
    });

    let CadastroSinalCpf = 0;

    document.getElementById("InputTextoCpfCadastro").addEventListener("focus", function() {

        document.getElementById("ParagrafoCpf").style.animation =
            "AnimaçaoDoInputCpfClick 0.1s linear forwards";

        CadastroSinalCpf = 1;
    });

    document.getElementById("InputTextoCpfCadastro").addEventListener("blur", function() {
        
        if (CadastroSinalCpf && this.value.trim() === "") {
            document.getElementById("ParagrafoCpf").style.animation =
                "AnimaçaoDoInputCpfSemClick 0.1s linear forwards";
        }
    
    });

    let CadastroInputNome = document.getElementById("InputTextoNomeCadastro");

    let CadastroPlaceholderNomeOriginal = CadastroInputNome.placeholder;


    CadastroInputNome.addEventListener("focus", function(){

        setTimeout(() =>{
            this.placeholder = "Seu nome completo";
        }, 50)

    });


    CadastroInputNome.addEventListener("blur", function(){

        this.placeholder = CadastroPlaceholderNomeOriginal;

    });


    let CadastroInput = document.getElementById("InputTextoEmailCadastro");

    let CadastroPlaceholderOriginal = CadastroInput.placeholder;

    CadastroInput.addEventListener("focus", function(){

        setTimeout(() =>{
            this.placeholder = "seu@email.com";
        }, 50)
    });


    CadastroInput.addEventListener("blur", function(){
        this.placeholder = CadastroPlaceholderOriginal;
    });


    let CadastroInputSenha = document.getElementById("InputTextoSenhaCadastro");

    let CadastroPlaceholderSenhaOriginal = CadastroInputSenha.placeholder;


    CadastroInputSenha.addEventListener("focus", function(){

        setTimeout(() =>{
            this.placeholder = "Sua senha";
        }, 50)

    });


    CadastroInputSenha.addEventListener("blur", function(){

        this.placeholder = CadastroPlaceholderSenhaOriginal;

    });


    let CadastroInputCpf = document.getElementById("InputTextoCpfCadastro");

    let CadastroPlaceholderCpfOriginal = CadastroInputCpf.placeholder;


    CadastroInputCpf.addEventListener("focus", function(){

        setTimeout(() =>{
            this.placeholder = "000.000.000-00";
        }, 50)

    });


    CadastroInputCpf.addEventListener("blur", function(){

        this.placeholder = CadastroPlaceholderCpfOriginal;

    });
}








// LÓGICA DO CONTATO:

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
