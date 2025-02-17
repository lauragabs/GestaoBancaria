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
        String sql = "INSERT INTO emprestimo (valor, num_parcelas, juros, garantia, data_vencimento, id_conta) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, emprestimo.getValor(), emprestimo.getNumParcelas(), emprestimo.getJuros(),
                emprestimo.getGarantia(), emprestimo.getDataVencimento(), emprestimo.getIdConta());
    }

    public List<Emprestimo> listar() {
        String sql = "SELECT * FROM emprestimo";
        return jdbcTemplate.query(sql, new EmprestimoRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Emprestimo buscarPorId(int id) {
        String sql = "SELECT * FROM emprestimo WHERE id_emprestimo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmprestimoRowMapper());
    }

    public void atualizar(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimo SET valor = ?, num_parcelas = ?, juros = ?, garantia = ?, data_vencimento = ?, id_conta = ? WHERE id_emprestimo = ?";
        jdbcTemplate.update(sql, emprestimo.getValor(), emprestimo.getNumParcelas(), emprestimo.getJuros(),
                emprestimo.getGarantia(), emprestimo.getDataVencimento(), emprestimo.getIdConta(), emprestimo.getIdEmprestimo());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM emprestimo WHERE id_emprestimo = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class EmprestimoRowMapper implements RowMapper<Emprestimo> {
        @Override
        public Emprestimo mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Emprestimo(
                    rs.getInt("id_emprestimo"),
                    rs.getDouble("valor"),
                    rs.getInt("num_parcelas"),
                    rs.getFloat("juros"),
                    rs.getString("garantia"),
                    rs.getDate("data_vencimento"),
                    rs.getInt("id_conta")
            );
        }
    }
}
