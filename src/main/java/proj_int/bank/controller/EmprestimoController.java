package proj_int.bank.controller;

import proj_int.bank.domain.Emprestimo;
import proj_int.bank.repository.EmprestimoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Emprestimo emprestimo) {
        emprestimoRepository.salvar(emprestimo);
        return new ResponseEntity<>("Empréstimo criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listar() {
        List<Emprestimo> emprestimos = emprestimoRepository.listar();
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable int id) {
        Emprestimo emprestimo = emprestimoRepository.buscarPorId(id);
        return emprestimo != null ? new ResponseEntity<>(emprestimo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Emprestimo emprestimo) {
        emprestimo.setIdEmprestimo(id);
        emprestimoRepository.atualizar(emprestimo);
        return new ResponseEntity<>("Empréstimo atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        emprestimoRepository.excluir(id);
        return new ResponseEntity<>("Empréstimo excluído com sucesso!", HttpStatus.OK);
    }
}
