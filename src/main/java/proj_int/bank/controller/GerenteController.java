package proj_int.bank.controller;

import proj_int.bank.domain.Gerente;
import proj_int.bank.repository.GerenteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    private final GerenteRepository gerenteRepository;

    public GerenteController(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Gerente gerente) {
        gerenteRepository.salvar(gerente);
        return new ResponseEntity<>("Gerente criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Gerente>> listar() {
        List<Gerente> gerentes = gerenteRepository.listar();
        return new ResponseEntity<>(gerentes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> buscarPorId(@PathVariable int id) {
        Gerente gerente = gerenteRepository.buscarPorId(id);
        return gerente != null ? new ResponseEntity<>(gerente, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Gerente gerente) {
        gerente.setIdGerente(id);
        gerenteRepository.atualizar(gerente);
        return new ResponseEntity<>("Gerente atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        gerenteRepository.excluir(id);
        return new ResponseEntity<>("Gerente excluído com sucesso!", HttpStatus.OK);
    }
}
