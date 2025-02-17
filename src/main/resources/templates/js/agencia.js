let agencias = [];

document.getElementById("formAgencia")?.addEventListener("submit", function(event) {
    event.preventDefault();

    let novaAgencia = {
        id: agencias.length + 1,
        nome: document.getElementById("nome").value,
        endereco: document.getElementById("endereco").value
    };

    agencias.push(novaAgencia);
    alert("Agência cadastrada com sucesso!");
    console.log(agencias);
});

function buscarAgencia() {
    let idBusca = document.getElementById("buscarId").value;
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
}
