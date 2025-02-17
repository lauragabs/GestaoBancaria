package proj_int.bank.controller;

import proj_int.bank.domain.Funcionario;
import proj_int.bank.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Funcionario funcionario) {
        funcionarioRepository.salvar(funcionario);
        return new ResponseEntity<>("Funcionário criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        List<Funcionario> funcionarios = funcionarioRepository.listar();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable int id) {
        Funcionario funcionario = funcionarioRepository.buscarPorId(id);
        return funcionario != null ? new ResponseEntity<>(funcionario, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Funcionario funcionario) {
        funcionario.setIdFunc(id);
        funcionarioRepository.atualizar(funcionario);
        return new ResponseEntity<>("Funcionário atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        funcionarioRepository.excluir(id);
        return new ResponseEntity<>("Funcionário excluído com sucesso!", HttpStatus.OK);
    }
}
