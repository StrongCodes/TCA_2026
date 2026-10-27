async function VerificaInputCadastro() {
    let inputNomeC = document.getElementById("InputTextoNomeCadastro");
    let inputEmailC = document.getElementById("InputTextoEmailCadastro");
    let inputSenhaC = document.getElementById("InputTextoSenhaCadastro");
    let inputCpfC = document.getElementById("InputTextoCpfCadastro");

    if (
        (inputNomeC.value.trim() !== "") &&
        (inputEmailC.value.trim() !== "") &&
        (inputSenhaC.value.trim() !== "") &&
        (inputCpfC.value.trim() !== "")
    ) {
        if(
            await ValidaLogin_Cliente(
                inputNomeC.value.trim(),
                inputEmailC.value.trim(),
                inputSenhaC.value.trim(),
                inputCpfC.value.trim()
            ) === 1
        ){
            document.getElementById("ParagrafoErroCadastro").innerText = "Credeciais já em uso!";
            document.getElementById("ParagrafoErroCadastro").style.color = "red";
            document.getElementById("ParagrafoErroCadastro").style.display = "block";
        }
        else{
            try {
                if (
                    await ValidaCadastro_Cliente(
                        inputNomeC.value.trim(),
                        inputSenhaC.value.trim(),
                        inputEmailC.value.trim(),
                        inputCpfC.value.trim()
                    ) === 1
                ) {
                    document.getElementById("ParagrafoErroCadastro").innerText = "Cadastro bem sucedido!";
                    document.getElementById("ParagrafoErroCadastro").style.color = "green";
                    document.getElementById("ParagrafoErroCadastro").style.display = "block";
                
                    setTimeout(() => {
                        window.close();
                    }, 1000);
                }
                else {
                    document.getElementById("ParagrafoErroCadastro").innerText = "Não foi possível realizar o cadastro!";
                    document.getElementById("ParagrafoErroCadastro").style.color = "red";
                    document.getElementById("ParagrafoErroCadastro").style.display = "block";
                }
            }
            catch (erro) {
                console.error(erro);
            
                document.getElementById("ParagrafoErroCadastro").innerText = "Erro ao conectar com o servidor!";
                document.getElementById("ParagrafoErroCadastro").style.color = "red";
                document.getElementById("ParagrafoErroCadastro").style.display = "block";
            }
        }
    }
    else {
        document.getElementById("ParagrafoErroCadastro").innerText = "Preencha todos os campos.";
        document.getElementById("ParagrafoErroCadastro").style.color = "red";
        document.getElementById("ParagrafoErroCadastro").style.display = "block";
    }

    inputNomeC.value = "";
    inputEmailC.value = "";
    inputSenhaC.value = "";
    inputCpfC.value = "";
}

async function VerificaInputLogin() {
    let inputNomeL = document.getElementById("InputTextoNomeLogin");
    let inputEmailL = document.getElementById("InputTextoEmailLogin");
    let inputSenhaL = document.getElementById("InputTextoSenhaLogin");
    let inputCpfL = document.getElementById("InputTextoCpfLogin");

    if (
        (inputNomeL.value.trim() !== "") &&
        (inputEmailL.value.trim() !== "") &&
        (inputSenhaL.value.trim() !== "") &&
        (inputCpfL.value.trim() !== "")
    ) {
        try {
            if(
                await ValidaLogin_Cliente(
                    inputNomeL.value.trim(),
                    inputEmailL.value.trim(),
                    inputSenhaL.value.trim(),
                    inputCpfL.value.trim()
                ) === 1
            ){
                document.getElementById("ParagrafoErroLogin").innerText = "Login bem sucedido!";
                document.getElementById("ParagrafoErroLogin").style.color = "green";
                document.getElementById("ParagrafoErroLogin").style.display = "block";
            }
            else{
                document.getElementById("ParagrafoErroLogin").innerText = "Não foi possível validar suas credenciais!";
                document.getElementById("ParagrafoErroLogin").style.color = "red";
                document.getElementById("ParagrafoErroLogin").style.display = "block";
            }
        }
        catch (erro) {
            console.error(erro);
            document.getElementById("ParagrafoErroLogin").innerText = "Erro ao conectar com o servidor!";
            document.getElementById("ParagrafoErroLogin").style.color = "red";
            document.getElementById("ParagrafoErroLogin").style.display = "block";
        }
    }
    else {
        document.getElementById("ParagrafoErroLogin").innerText = "Preencha todos os campos.";
        document.getElementById("ParagrafoErroLogin").style.color = "red";
        document.getElementById("ParagrafoErroLogin").style.display = "block";
    }
}

async function ValidaLogin_Cliente(Nome, Email, Senha, Cpf) {

    const resposta = await fetch(
        `/api/ValidaLogin_Cliente/${encodeURIComponent(Nome)}/${encodeURIComponent(Email)}/${encodeURIComponent(Senha)}/${encodeURIComponent(Cpf)}`
    );

    if (!resposta.ok) {
        throw new Error("Erro ao validar login");
    }

    const Resultado = await resposta.text();
    return Number(Resultado);
}

async function ValidaCadastro_Cliente(Nome, Senha, Email, Cpf) {

    const resposta = await fetch(
        `/api/ValidaCadastro_Cliente/${encodeURIComponent(Nome)}/${encodeURIComponent(Senha)}/${encodeURIComponent(Email)}/${encodeURIComponent(Cpf)}`
    );

    if (!resposta.ok) {
        throw new Error("Erro ao validar cadastro");
    }

    const Resultado = await resposta.text();
    return Number(Resultado);
}