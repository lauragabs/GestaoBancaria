package proj_int.bank.domain;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cartao {

    private Integer id; 
    private Conta conta;
    private String numero;
    private LocalDate dataVencimento;
    private float limite;
    private String tipo;
    private int cvv; 

}
