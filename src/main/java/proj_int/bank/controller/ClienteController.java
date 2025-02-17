package proj_int.bank.controller;

import proj_int.bank.domain.Cliente;
import proj_int.bank.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Cliente cliente) {
        clienteRepository.salvar(cliente);
        return new ResponseEntity<>("Cliente criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteRepository.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        return cliente != null ? new ResponseEntity<>(cliente, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteRepository.atualizar(cliente);
        return new ResponseEntity<>("Cliente atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        clienteRepository.excluir(id);
        return new ResponseEntity<>("Cliente excluído com sucesso!", HttpStatus.OK);
    }

    
}
