package proj_int.bank.repository;

import proj_int.bank.domain.Emprestimo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmprestimoRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmprestimoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Emprestimo emprestimo) {
        String sql = "INSERT INTO Emprestimos (valor_empr, numParcelas_empr, juros_empr, garantia_empr, dataVencimento_empr, id_conta) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, emprestimo.getValor(), emprestimo.getNumParcelas(), emprestimo.getJuros(),
                emprestimo.getGarantia(), emprestimo.getDataVencimento(), emprestimo.getIdConta());
    }

    public List<Emprestimo> listar() {
        String sql = "SELECT * FROM Emprestimos";
        return jdbcTemplate.query(sql, new EmprestimoRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Emprestimo buscarPorId(int id) {
        String sql = "SELECT * FROM Emprestimos WHERE id_empr = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmprestimoRowMapper());
    }

    public void atualizar(Emprestimo emprestimo) {
        String sql = "UPDATE Emprestimos SET valor_empr = ?, numParcelas_empr = ?, juros_empr = ?, garantia_empr = ?, dataVencimento_empr = ?, id_conta = ? WHERE id_empr = ?";
        jdbcTemplate.update(sql, emprestimo.getValor(), emprestimo.getNumParcelas(), emprestimo.getJuros(),
                emprestimo.getGarantia(), emprestimo.getDataVencimento(), emprestimo.getIdConta(), emprestimo.getIdEmprestimo());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Emprestimos WHERE id_empr = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class EmprestimoRowMapper implements RowMapper<Emprestimo> {
        @Override
        public Emprestimo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Emprestimo(
                    rs.getInt("id_empr"),
                    rs.getDouble("valor_empr"),
                    rs.getInt("numParcelas_empr"),
                    rs.getFloat("juros_empr"),
                    rs.getString("garantia_empr"),
                    rs.getDate("dataVencimento_empr"),
                    rs.getInt("id_conta")
            );
        }
    }
}
