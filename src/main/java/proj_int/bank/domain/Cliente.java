package proj_int.bank.domain;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Integer id;
    private String login;
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;
    private String sexo;
    private LocalDate dataNascimento;

}