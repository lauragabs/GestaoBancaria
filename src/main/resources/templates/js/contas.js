let contas = [];

document.getElementById("formConta")?.addEventListener("submit", function(event) {
    event.preventDefault();

    let novaConta = {
        id: contas.length + 1,
        saldo: document.getElementById("saldo").value,
        tipo: document.getElementById("tipo").value,
        dataAbertura: document.getElementById("dataAbertura").value,
        idCliente: document.getElementById("idCliente").value,
        idAgencia: document.getElementById("idAgencia").value
    };

    contas.push(novaConta);
    alert("Conta cadastrada com sucesso!");
    console.log(contas);
});

function buscarConta() {
    let idBusca = document.getElementById("buscarId").value;
    let contaEncontrada = contas.find(conta => conta.id == idBusca);

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
