const apiURL = "http://10.10.22.14:8080/cartoes";

document.getElementById("formCartao")?.addEventListener("submit", async function(event) {
    event.preventDefault();

    let novoCartao = {
        tipoCartao: document.getElementById("tipoCartao").value,
        limiteCartao: parseFloat(document.getElementById("limiteCartao").value),
        dataValidadeCartao: document.getElementById("dataValidadeCartao").value,
        numCartao: parseInt(document.getElementById("numCartao").value),
        idConta: parseInt(document.getElementById("idConta").value)
    };

    console.log(novoCartao);

    try {
        let response = await fetch(apiURL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(novoCartao)
        });

        if (response.ok) {
            alert("Cartão cadastrado com sucesso!");
            document.getElementById("formCartao").reset();
        } else {
            alert("Erro ao cadastrar o cartão.");
        }
    } catch (error) {
        console.error("Erro ao cadastrar o cartão:", error);
        alert("Erro ao cadastrar o cartão.");
    }
});

async function buscarCartao() {
    let idBusca = document.getElementById("buscarIdConta").value;

    try {
        let response = await fetch(apiURL);
        console.log(response);
        let cartoes = await response.json();

        let cartoesEncontrados = cartoes.filter(cartao => cartao.idConta == idBusca);

        if (cartoesEncontrados.length > 0) {
            let resultadoHTML = cartoesEncontrados.map(cartao => `
                <div class="bg-white p-4 border rounded mt-4">
                    <p><strong>ID:</strong> ${cartao.idCartao}</p>
                    <p><strong>Tipo:</strong> ${cartao.tipoCartao}</p>
                    <p><strong>Limite:</strong> ${cartao.limiteCartao}</p>
                    <p><strong>Data de Validade:</strong> ${cartao.dataValidadeCartao}</p>
                    <p><strong>Número:</strong> ${cartao.numCartao}</p>
                    <p><strong>ID da Conta:</strong> ${cartao.idConta}</p>
                </div>
            `).join('');

            document.getElementById("resultadoBusca").innerHTML = resultadoHTML;
        } else {
            document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Cartão não encontrado.</p>";
        }
    } catch (error) {
        console.error("Erro ao buscar o cartão:", error);
        document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Erro ao buscar o cartão.</p>";
    }
}