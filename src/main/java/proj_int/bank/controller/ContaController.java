package proj_int.bank.controller;

import proj_int.bank.domain.Conta;
import proj_int.bank.repository.AgenciaRepository;
import proj_int.bank.repository.ClienteRepository;
import proj_int.bank.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;
    private final AgenciaRepository agenciaRepository;

    public ContaController(
            ContaRepository contaRepository,
            ClienteRepository clienteRepository,
            AgenciaRepository agenciaRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
        this.agenciaRepository = agenciaRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Conta conta) {
        clienteRepository.buscarPorId(0);
        contaRepository.salvar(conta);
        return new ResponseEntity<>("Conta criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> listar() {
        List<Conta> contas = contaRepository.listar();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable int id) {
        Conta conta = contaRepository.buscarPorId(id);
        return conta != null ? new ResponseEntity<>(conta, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Conta conta) {
        conta.setId(id);
        contaRepository.atualizar(conta);
        return new ResponseEntity<>("Conta atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        contaRepository.excluir(id);
        return new ResponseEntity<>("Conta excluída com sucesso!", HttpStatus.OK);
    }
}
