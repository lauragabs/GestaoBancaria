let clientes = [];

document.getElementById("formCliente")?.addEventListener("submit", function(event) {
    event.preventDefault();

    let novoCliente = {
        id: clientes.length + 1,
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        endereco: document.getElementById("endereco").value
    };

    clientes.push(novoCliente);
    alert("Cliente cadastrado com sucesso!");
    console.log(clientes);
});

function buscarCliente() {
    let cpfBusca = document.getElementById("buscarCpf").value;
    let clienteEncontrado = clientes.find(cliente => cliente.cpf === cpfBusca);

    if (clienteEncontrado) {
        document.getElementById("resultadoBusca").innerHTML = `
            <div class="bg-white p-4 border rounded mt-4">
                <p><strong>ID:</strong> ${clienteEncontrado.id}</p>
                <p><strong>Nome:</strong> ${clienteEncontrado.nome}</p>
                <p><strong>CPF:</strong> ${clienteEncontrado.cpf}</p>
                <p><strong>Endereço:</strong> ${clienteEncontrado.endereco}</p>
            </div>
        `;
    } else {
        document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Cliente não encontrado.</p>";
    }
}
