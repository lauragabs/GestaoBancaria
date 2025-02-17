package proj_int.bank.controller;

import proj_int.bank.domain.Transacao;
import proj_int.bank.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Transacao transacao) {
        transacaoRepository.salvar(transacao);
        return new ResponseEntity<>("Transação criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listar() {
        List<Transacao> transacoes = transacaoRepository.listar();
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable int id) {
        Transacao transacao = transacaoRepository.buscarPorId(id);
        return transacao != null ? new ResponseEntity<>(transacao, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Transacao transacao) {
        transacao.setIdTransacao(id);
        transacaoRepository.atualizar(transacao);
        return new ResponseEntity<>("Transação atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        transacaoRepository.excluir(id);
        return new ResponseEntity<>("Transação excluída com sucesso!", HttpStatus.OK);
    }
}
