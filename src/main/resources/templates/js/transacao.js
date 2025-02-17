let transacoes = [];

document.getElementById("formTransacao")?.addEventListener("submit", function(event) {
    event.preventDefault();

    let novaTransacao = {
        id: transacoes.length + 1,
        valor: document.getElementById("valor").value,
        tipo: document.getElementById("tipo").value,
    };

    transacoes.push(novaTransacao);
    alert("Transação cadastrada com sucesso!");
    console.log(transacoes);
} );