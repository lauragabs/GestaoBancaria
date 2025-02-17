
const apiURL = "http://10.10.22.14:8080/clientes";

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
        let clientes = await response.json();

        let clienteEncontrado = clientes.find(cliente => cliente.cpf == idBusca);

        if (clienteEncontrado) {
            document.getElementById("resultadoBusca").innerHTML = `
                <div class="bg-white p-4 border rounded mt-4">
                    <p><strong>ID:</strong> ${clienteEncontrado.id}</p>
                    <p><strong>Nome:</strong> ${clienteEncontrado.nome}</p>
                    <p><strong>Email:</strong> ${clienteEncontrado.email}</p>
                    <p><strong>Telefone:</strong> ${clienteEncontrado.telefone}</p>
                    <button onclick="abrirModalEditar(${clienteEncontrado.id}, '${clienteEncontrado.nome}', '${clienteEncontrado.email}', '${clienteEncontrado.telefone}')" class="bg-yellow-500 text-white px-4 py-2 mt-2 rounded">Editar</button>
                    <button onclick="excluirCliente(${clienteEncontrado.id})" class="bg-red-600 text-white px-4 py-2 mt-2 rounded">Excluir</button>
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

function abrirModalEditar(id, nome, email, telefone) {
    document.getElementById("editId").value = id;
    document.getElementById("editNome").value = nome;
    document.getElementById("editEmail").value = email;
    document.getElementById("editTelefone").value = telefone;
    
    document.getElementById("modalEditar").classList.remove("hidden");
}

function fecharModal() {
    document.getElementById("modalEditar").classList.add("hidden");
}

async function salvarEdicao() {
    let id = document.getElementById("editId").value;
    let clienteAtualizado = {
        nome: document.getElementById("editNome").value,
        email: document.getElementById("editEmail").value,
        telefone: document.getElementById("editTelefone").value
    };

    try {
        let response = await fetch(`${apiURL}/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(clienteAtualizado)
        });

        if (response.ok) {
            alert("Cliente atualizado com sucesso!");
            fecharModal();
            buscarCliente(); 
        } else {
            alert("Erro ao atualizar o cliente.");
        }
    } catch (error) {
        console.error("Erro ao atualizar o cliente:", error);
        alert("Erro ao atualizar o cliente.");
    }
}
async function excluirCliente(id) {
    if (!confirm("Tem certeza que deseja excluir este cliente?")) return;

    try {
        let response = await fetch(`${apiURL}/${id}`, {
            method: "DELETE"
        });

        if (response.ok) {
            alert("Cliente excluído com sucesso!");
            document.getElementById("resultadoBusca").innerHTML = ""; 
        } else {
            alert("Erro ao excluir o cliente.");
        }
    } catch (error) {
        console.error("Erro ao excluir o cliente:", error);
        alert("Erro ao excluir o cliente.");
    }
}


async function listarClientes() {
    try {
        let response = await fetch(apiURL);
        let clientes = await response.json();

        let tabela = document.getElementById("tabelaClientes");
        tabela.innerHTML = ""; 

        if (clientes.length === 0) {
            tabela.innerHTML = `<tr><td colspan="5" class="text-center py-4">Nenhum cliente encontrado.</td></tr>`;
            return;
        }

        clientes.forEach(cliente => {
            let linha = `
                <tr class="border-b">
                    <td class="py-2 px-4 border">${cliente.id}</td>
                    <td class="py-2 px-4 border">${cliente.nome}</td>
                    <td class="py-2 px-4 border">${cliente.email}</td>
                    <td class="py-2 px-4 border">${cliente.telefone}</td>
                </tr>
            `;
            tabela.innerHTML += linha;
        });

    } catch (error) {
        console.error("Erro ao buscar clientes:", error);
        document.getElementById("tabelaClientes").innerHTML = `<tr><td colspan="5" class="text-center py-4 text-red-600">Erro ao carregar clientes.</td></tr>`;
    }
}

// Carregar a lista de clientes quando a página for carregada
document.addEventListener("DOMContentLoaded", listarClientes);
async function carregarRelatorios() {
    try {
        let response = await fetch(apiRelatorioURL);
        let dados = await response.json();

        preencherTabela("tabelaDepositos", dados.transacoesDeposito, ["id_cliente", "nome_cliente", "transacoes_deposito"]);
        preencherTabela("tabelaSaldos", dados.saldoTotal, ["id_cliente", "nome_cliente", "saldo_total"]);
        preencherTabela("tabelaEmprestimos", dados.emprestimosPendentes, ["id_cliente", "nome_cliente", "total_emprestimo"]);

    } catch (error) {
        console.error("Erro ao carregar relatórios:", error);
        ["tabelaDepositos", "tabelaSaldos", "tabelaEmprestimos"].forEach(id => {
            document.getElementById(id).innerHTML = `<tr><td colspan="3" class="text-center py-4 text-red-600">Erro ao carregar dados.</td></tr>`;
        });
    }
}

function preencherTabela(idTabela, dados, colunas) {
    let tabela = document.getElementById(idTabela);
    tabela.innerHTML = "";

    if (dados.length === 0) {
        tabela.innerHTML = `<tr><td colspan="${colunas.length}" class="text-center py-4">Nenhum dado encontrado.</td></tr>`;
        return;
    }

    dados.forEach(item => {
        let linha = "<tr class='border-b'>";
        colunas.forEach(coluna => {
            linha += `<td class="py-2 px-4 border">${item[coluna]}</td>`;
        });
        linha += "</tr>";
        tabela.innerHTML += linha;
    });
}

// Carregar os relatórios quando a página for carregada
document.addEventListener("DOMContentLoaded", carregarRelatorios);