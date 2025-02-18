const apiURL = "http://10.10.22.14:8080/contas";

document.getElementById("formConta")?.addEventListener("submit", async function(event) {
    event.preventDefault();

    let novaConta = {
        saldo: document.getElementById("saldo").value,
        tipo: document.getElementById("tipo").value,
        dataAbertura: document.getElementById("dataAbertura").value,
        idCliente: document.getElementById("idCliente").value,
        idAgencia: document.getElementById("idAgencia").value
    };

    try {
        let response = await fetch(apiURL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(novaConta)
        });

        if (response.ok) {
            alert("Conta cadastrada com sucesso!");
            document.getElementById("formConta").reset();
        } else {
            alert("Erro ao cadastrar a conta.");
        }
    } catch (error) {
        console.error("Erro ao cadastrar o conta:", error);
        alert("Erro ao cadastrar o conta.");
    }
});

async function buscarConta() {
    let idBusca = document.getElementById("buscarId").value;
    try {
        let response = await fetch(apiURL);
        let contas = await response.json();

        let contaEncontrada = contas.filter(conta => conta.idConta == idBusca);
        if (contaEncontrada) {
            document.getElementById("resultadoBusca").innerHTML = `
                <div class="bg-white p-4 border rounded mt-4">
                    <p><strong>ID:</strong> ${contaEncontrada.id}</p>
                    <p><strong>Saldo:</strong> ${contaEncontrada.saldo}</p>
                    <p><strong>Tipo:</strong> ${contaEncontrada.tipo}</p>
                    <p><strong>Data de Abertura:</strong> ${contaEncontrada.dataAbertura}</p>
                    <p><strong>ID Cliente:</strong> ${contaEncontrada.idCliente}</p>
                    <p><strong>ID Agência:</strong> ${contaEncontrada.idAgencia}</p>
                </div>
            `;
        } else {
            document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Conta não encontrada.</p>";
        }
    }
    
    catch (error) {
        console.error("Erro ao buscar a conta:", error);
        document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Erro ao buscar a conta.</p>";
    }
}
