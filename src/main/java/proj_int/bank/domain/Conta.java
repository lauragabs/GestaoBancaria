package proj_int.bank.domain;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    private Integer id; 
    private String tipoConta;
    private float saldo;
    private Cliente cliente;
    private LocalDate dataCriacao;

}
