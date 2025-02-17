const apiURL = "http://10.10.22.14:8080/cartoes";

document.getElementById("formCliente")?.addEventListener("submit", async function(event) {
    event.preventDefault();

    let novoCliente = {
        nome: document.getElementById("nome").value,
        sexo: document.getElementById("sexo").value,
        cpf: document.getElementById("cpf").value,
        endereco: document.getElementById("endereco").value,
        email: document.getElementById("email").value,
        telefone: document.getElementById("telefone").value,
        dataNascimento: document.getElementById("dataNascimento").value,
        login: document.getElementById("login").value,
        senha: document.getElementById("senha").value
    };

    try {
        let response = await fetch(apiURL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(novoCliente)
        });

        if (response.ok) {
            alert("Cliente cadastrado com sucesso!");
            document.getElementById("formCliente").reset();
        } else {
            alert("Erro ao cadastrar o cliente.");
        }
    } catch (error) {
        console.error("Erro ao cadastrar o cliente:", error);
        alert("Erro ao cadastrar o cliente.");
    }
});

async function buscarCliente() {
    let idBusca = document.getElementById("buscarCPF").value;

    try {
        let response = await fetch(apiURL);
        console.log(response);
        let clientes = await response.json();

        let clienteEncontrado = clientes.find(cliente => cliente.cpf == idBusca);

        if (clienteEncontrado) {
            document.getElementById("resultadoBusca").innerHTML = `
                <div class="bg-white p-4 border rounded mt-4">
                    <p><strong>ID:</strong> ${clienteEncontrado.id}</p>
                    <p><strong>Nome:</strong> ${clienteEncontrado.nome}</p>
                    <p><strong>Sexo:</strong> ${clienteEncontrado.sexo}</p>
                    <p><strong>CPF:</strong> ${clienteEncontrado.cpf}</p>
                    <p><strong>Endereço:</strong> ${clienteEncontrado.endereco}</p>
                    <p><strong>Email:</strong> ${clienteEncontrado.email}</p>
                    <p><strong>Telefone:</strong> ${clienteEncontrado.telefone}</p>
                    <p><strong>Data de Nascimento:</strong> ${clienteEncontrado.dataNascimento}</p>
                    <p><strong>Login:</strong> ${clienteEncontrado.login}</p>
                </div>
            `;
        } else {
            document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Cliente não encontrado.</p>";
        }
    } catch (error) {
        console.error("Erro ao buscar o cliente:", error);
        document.getElementById("resultadoBusca").innerHTML = "<p class='text-red-600 mt-4'>Erro ao buscar o cliente.</p>";
    }
}