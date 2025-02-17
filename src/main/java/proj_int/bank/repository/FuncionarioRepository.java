package proj_int.bank.repository;

import proj_int.bank.domain.Funcionario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FuncionarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public FuncionarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (nome_func, cargo_func, telefone_func, cpf_func, endereco_func, dataNasc_func, salario_func, sexo_func, id_agencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, funcionario.getNomeFunc(), funcionario.getCargoFunc(), funcionario.getTelefoneFunc(),
                funcionario.getCpfFunc(), funcionario.getEnderecoFunc(), funcionario.getDataNascFunc(),
                funcionario.getSalarioFunc(), funcionario.getSexoFunc(), funcionario.getIdAgencia());
    }

    public List<Funcionario> listar() {
        String sql = "SELECT * FROM Funcionario";
        return jdbcTemplate.query(sql, new FuncionarioRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM Funcionario WHERE id_func = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FuncionarioRowMapper());
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE Funcionario SET nome_func = ?, cargo_func = ?, telefone_func = ?, cpf_func = ?, endereco_func = ?, dataNasc_func = ?, salario_func = ?, sexo_func = ?, id_agencia = ? WHERE id_func = ?";
        jdbcTemplate.update(sql, funcionario.getNomeFunc(), funcionario.getCargoFunc(), funcionario.getTelefoneFunc(),
                funcionario.getCpfFunc(), funcionario.getEnderecoFunc(), funcionario.getDataNascFunc(),
                funcionario.getSalarioFunc(), funcionario.getSexoFunc(), funcionario.getIdAgencia(), funcionario.getIdFunc());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Funcionario WHERE id_func = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class FuncionarioRowMapper implements RowMapper<Funcionario> {
        @Override
        public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Funcionario(
                    rs.getInt("id_func"),
                    rs.getString("nome_func"),
                    rs.getString("cargo_func"),
                    rs.getString("telefone_func"),
                    rs.getString("cpf_func"),
                    rs.getString("endereco_func"),
                    rs.getDate("dataNasc_func"),
                    rs.getDouble("salario_func"),
                    rs.getString("sexo_func"),
                    rs.getInt("id_agencia")
            );
        }
    }
}
