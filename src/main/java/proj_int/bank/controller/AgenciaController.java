package proj_int.bank.controller;

import proj_int.bank.domain.Agencia;
import proj_int.bank.repository.AgenciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

    private final AgenciaRepository agenciaRepository;

    public AgenciaController(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Agencia agencia) {
        agenciaRepository.salvar(agencia);
        return new ResponseEntity<>("Agência criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agencia>> listar() {
        List<Agencia> agencias = agenciaRepository.listar();
        return new ResponseEntity<>(agencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agencia> buscarPorId(@PathVariable int id) {
        Agencia agencia = agenciaRepository.buscarPorId(id);
        return agencia != null ? new ResponseEntity<>(agencia, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Agencia agencia) {
        agencia.setId(id);
        agenciaRepository.atualizar(agencia);
        return new ResponseEntity<>("Agência atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        agenciaRepository.excluir(id);
        return new ResponseEntity<>("Agência excluída com sucesso!", HttpStatus.OK);
    }
}
