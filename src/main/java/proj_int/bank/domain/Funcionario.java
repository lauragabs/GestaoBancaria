package proj_int.bank.domain;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    private Integer id;
    private String nome;
    private String cargo;    
    private String telefone;
    private String cpf;
    private String endereco;
    private LocalDate dataNascimento;
    private float salario;
    private String email;
    private LocalDate dataAdmissao;

}
