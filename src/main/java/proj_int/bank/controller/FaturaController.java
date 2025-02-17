package proj_int.bank.controller;

import proj_int.bank.domain.Fatura;
import proj_int.bank.repository.FaturaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final FaturaRepository faturaRepository;

    public FaturaController(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Fatura fatura) {
        faturaRepository.salvar(fatura);
        return new ResponseEntity<>("Fatura criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fatura>> listar() {
        List<Fatura> faturas = faturaRepository.listar();
        return new ResponseEntity<>(faturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> buscarPorId(@PathVariable int id) {
        Fatura fatura = faturaRepository.buscarPorId(id);
        return fatura != null ? new ResponseEntity<>(fatura, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Fatura fatura) {
        fatura.setIdFatura(id);
        faturaRepository.atualizar(fatura);
        return new ResponseEntity<>("Fatura atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        faturaRepository.excluir(id);
        return new ResponseEntity<>("Fatura excluída com sucesso!", HttpStatus.OK);
    }
}
