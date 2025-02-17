package proj_int.bank.controller;

import proj_int.bank.domain.Cartao;
import proj_int.bank.repository.CartaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoRepository cartaoRepository;

    public CartaoController(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Cartao cartao) {
        cartaoRepository.salvar(cartao);
        return new ResponseEntity<>("Cartão criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> listar() {
        List<Cartao> cartoes = cartaoRepository.listar();
        return new ResponseEntity<>(cartoes, HttpStatus.OK);
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity<Cartao> buscarPorId(@PathVariable int idCartao) {
        Cartao cartao = cartaoRepository.buscarPorId(idCartao);
        return cartao != null ? new ResponseEntity<>(cartao, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{idCartao}")
    public ResponseEntity<String> atualizar(@PathVariable int idCartao, @RequestBody Cartao cartao) {
        cartao.setIdCartao(idCartao);
        cartaoRepository.atualizar(cartao);
        return new ResponseEntity<>("Cartão atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{idCartao}")
    public ResponseEntity<String> excluir(@PathVariable int idCartao) {
        cartaoRepository.excluir(idCartao);
        return new ResponseEntity<>("Cartão excluído com sucesso!", HttpStatus.OK);
    }
}
