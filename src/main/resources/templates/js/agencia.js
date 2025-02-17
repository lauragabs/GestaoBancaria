const apiURL = "http://10.10.22.14:8080/agencias";

document.getElementById("formAgencia")?.addEventListener("submit", function(event) {
    event.preventDefault();

    let novaAgencia = {
        nome: document.getElementById("nome").value,
        endereco: document.getElementById("endereco").value,
        telefone: document.getElementById("telefone").value
    };

    fetch(apiURL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(novaAgencia)
    }).then(response => {
        if (response.ok) {
            alert("Agência cadastrada com sucesso!");
            document.getElementById("formAgencia").reset();
        } else {
            alert("Erro ao cadastrar a agência.");
        }
    });

});

async function buscarAgencia() {
    let idBusca = document.getElementById("buscarId").value;

    try {
        let response = await fetch(apiURL);
        let agencias = await response.json();

        let agenciaEncontrada = agencias.find(agencia => agencia.id == idBusca);

        if (agenciaEncontrada) {
            document.getElementById("resultadoBusca").innerHTML = `
                <div class="bg-white p-4 border rounded mt-4">
                    <p><strong>ID:</strong> ${agenciaEncontrada.id}</p>
                    <p><strong>Nome:</strong> ${agenciaEncontrada.nome}</p>
                    <p><strong>Endereço:</strong> ${agenciaEncontrada.endereco}</p>
                </div>
            `;
        } else {
            document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Agência não encontrada.</p>";
        }
    } catch (error) {
        console.error("Erro ao buscar a agência:", error);
        document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Erro ao buscar a agência.</p>";
    }
}