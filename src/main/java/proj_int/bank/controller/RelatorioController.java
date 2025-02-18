package proj_int.bank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proj_int.bank.repository.RelatorioRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class RelatorioController {

    @Autowired
    private RelatorioRepository clienteRepository;

    @GetMapping("/relatorio")
    public Map<String, List<Map<String, Object>>> getRelatorio() {

        List<Map<String, Object>> saldoTotal = clienteRepository.findSaldoTotalPorCliente();
        List<Map<String, Object>> transacoesDeposito = clienteRepository.findTransacoesDepositoPorCliente();
        List<Map<String, Object>> emprestimosPendentes = clienteRepository.findEmprestimosPendentesPorCliente();

        return Map.of(
                "saldoTotal", saldoTotal,
                "transacoesDeposito", transacoesDeposito,
                "emprestimosPendentes", emprestimosPendentes
        );
    }
}
