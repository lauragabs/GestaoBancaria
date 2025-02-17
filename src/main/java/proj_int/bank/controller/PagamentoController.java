package proj_int.bank.controller;

import proj_int.bank.domain.Pagamento;
import proj_int.bank.repository.PagamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoController(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Pagamento pagamento) {
        pagamentoRepository.salvar(pagamento);
        return new ResponseEntity<>("Pagamento criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listar() {
        List<Pagamento> pagamentos = pagamentoRepository.listar();
        return new ResponseEntity<>(pagamentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable int id) {
        Pagamento pagamento = pagamentoRepository.buscarPorId(id);
        return pagamento != null ? new ResponseEntity<>(pagamento, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Pagamento pagamento) {
        pagamento.setIdPagamento(id);
        pagamentoRepository.atualizar(pagamento);
        return new ResponseEntity<>("Pagamento atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        pagamentoRepository.excluir(id);
        return new ResponseEntity<>("Pagamento excluído com sucesso!", HttpStatus.OK);
    }
}
