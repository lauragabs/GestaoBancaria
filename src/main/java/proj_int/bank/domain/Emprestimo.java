package proj_int.bank.domain;

import java.time.LocalDate;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    private Integer id;
    private float valor;
    private int parcelas;
    private float juros;
    private String garantia;
    private LocalDate dataVencimento;
    private Conta conta;
}
