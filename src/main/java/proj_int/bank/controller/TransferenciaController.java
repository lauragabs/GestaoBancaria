package proj_int.bank.controller;

import proj_int.bank.domain.Transferencia;
import proj_int.bank.repository.TransferenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaController(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Transferencia transferencia) {
        transferenciaRepository.salvar(transferencia);
        return new ResponseEntity<>("Transferência criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listar() {
        List<Transferencia> transferencias = transferenciaRepository.listar();
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transferencia> buscarPorId(@PathVariable int id) {
        Transferencia transferencia = transferenciaRepository.buscarPorId(id);
        return transferencia != null ? new ResponseEntity<>(transferencia, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Transferencia transferencia) {
        transferencia.setIdTransferencia(id);
        transferenciaRepository.atualizar(transferencia);
        return new ResponseEntity<>("Transferência atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        transferenciaRepository.excluir(id);
        return new ResponseEntity<>("Transferência excluída com sucesso!", HttpStatus.OK);
    }
}
