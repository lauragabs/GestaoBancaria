package proj_int.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import proj_int.bank.repository.CartaoRepository;

@Controller
@RequestMapping("/cartao")
public class CartaoController {

    private final CartaoRepository cartaoRepository;

    public CartaoController(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    

}
