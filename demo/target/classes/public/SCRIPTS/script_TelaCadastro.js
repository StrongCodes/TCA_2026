let sinalNome = 0;

document.getElementById("InputTextoNomeCadastro").addEventListener("focus", function() {

    document.getElementById("ParagrafoNome").style.animation =
        "AnimaçaoDoInputNomeClick 0.1s linear forwards";

    sinalNome = 1;
});

document.getElementById("InputTextoNomeCadastro").addEventListener("blur", function() {

    if (sinalNome)
    {
        document.getElementById("ParagrafoNome").style.animation =
            "AnimaçaoDoInputNomeSemClick 0.1s linear forwards";
    }

});


let sinalEmail = 0;

document.getElementById("InputTextoEmailCadastro").addEventListener("focus", function() {

    document.getElementById("ParagrafoEmail").style.animation =
        "AnimaçaoDoInputEmailClick 0.1s linear forwards";
    sinalEmail = 1;

});

document.getElementById("InputTextoEmailCadastro").addEventListener("blur", function() {

    if(sinalEmail)
    {
        document.getElementById("ParagrafoEmail").style.animation =
        "AnimaçaoDoInputEmailSemClick 0.1s linear forwards";
    }
});


let sinalSenha = 0;

document.getElementById("InputTextoSenhaCadastro").addEventListener("focus", function() {

    document.getElementById("ParagrafoSenha").style.animation =
        "AnimaçaoDoInputSenhaClick 0.1s linear forwards";

    sinalSenha = 1;
});

document.getElementById("InputTextoSenhaCadastro").addEventListener("blur", function() {

    if(sinalSenha)
    {
        document.getElementById("ParagrafoSenha").style.animation =
            "AnimaçaoDoInputSenhaSemClick 0.1s linear forwards";
    }

});

let sinalCpf = 0;

document.getElementById("InputTextoCpfCadastro").addEventListener("focus", function() {

    document.getElementById("ParagrafoCpf").style.animation =
        "AnimaçaoDoInputCpfClick 0.1s linear forwards";

    sinalCpf = 1;
});

document.getElementById("InputTextoCpfCadastro").addEventListener("blur", function() {

    if (sinalCpf)
    {
        document.getElementById("ParagrafoCpf").style.animation =
            "AnimaçaoDoInputCpfSemClick 0.1s linear forwards";
    }

});

let inputNome = document.getElementById("InputTextoNomeCadastro");

let placeholderNomeOriginal = inputNome.placeholder;


inputNome.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "Seu nome completo";
    }, 50)

});


inputNome.addEventListener("blur", function(){

    this.placeholder = placeholderNomeOriginal;

});


let input = document.getElementById("InputTextoEmailCadastro");

let placeholderOriginal = input.placeholder;

input.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "seu@email.com";
    }, 50)
});


input.addEventListener("blur", function(){
    this.placeholder = placeholderOriginal;
});


let inputSenha = document.getElementById("InputTextoSenhaCadastro");

let placeholderSenhaOriginal = inputSenha.placeholder;


inputSenha.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "Sua senha";
    }, 50)

});


inputSenha.addEventListener("blur", function(){

    this.placeholder = placeholderSenhaOriginal;

});


let inputCpf = document.getElementById("InputTextoCpfCadastro");

let placeholderCpfOriginal = inputCpf.placeholder;


inputCpf.addEventListener("focus", function(){

    setTimeout(() =>{
        this.placeholder = "000.000.000-00";
    }, 50)

});


inputCpf.addEventListener("blur", function(){

    this.placeholder = placeholderCpfOriginal;

});
