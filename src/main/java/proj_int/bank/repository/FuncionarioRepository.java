package proj_int.bank.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import proj_int.bank.domain.Funcionario;

@Repository
public class FuncionarioRepository {

    private JdbcTemplate conexaoBanco;

    public FuncionarioRepository(JdbcTemplate conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public void inserirFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cargo, telefone, cpf, endereco, data_nascimento, salario, email, data_admissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conexaoBanco.update(sql, 
            funcionario.getNome(),
            funcionario.getCargo(),
            funcionario.getTelefone(),
            funcionario.getCpf(),
            funcionario.getEndereco(),
            funcionario.getDataNascimento(),
            funcionario.getSalario(),
            funcionario.getEmail(),
            funcionario.getDataAdmissao()
        );
    }

    public void deletarFuncionarioPorId (Integer id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        conexaoBanco.update(sql, id);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET cargo = ?, telefone = ?, endereco = ?, salario = ?, email = ? WHERE id = ?";
        conexaoBanco.update(sql, 
            funcionario.getCargo(),
            funcionario.getTelefone(),
            funcionario.getEndereco(),
            funcionario.getSalario(),
            funcionario.getEmail(),
            funcionario.getId()
        );
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";
        return conexaoBanco.queryForObject(sql, new Object[]{cpf}, (res, rowNum) -> 
            new Funcionario (
                res.getInt("id"),
                res.getString("nome"),
                res.getString("cargo"),
                res.getString("telefone"),
                res.getString("cpf"),
                res.getString("endereco"),
                res.getDate("data_nascimento").toLocalDate(),
                res.getFloat("salario"),
                res.getString("email"),
                res.getDate("data_admissao").toLocalDate()
            )
        );
    }

}
