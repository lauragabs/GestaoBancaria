package proj_int.bank.repository;

import proj_int.bank.domain.Agencia;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AgenciaRepository {

    private final JdbcTemplate jdbcTemplate;

    public AgenciaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Agencia agencia) {
        String sql = "INSERT INTO agencia (nome, endereco, telefone) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, agencia.getNome(), agencia.getEndereco(), agencia.getTelefone());
    }

    public List<Agencia> listar() {
        String sql = "SELECT * FROM agencia";
        return jdbcTemplate.query(sql, new AgenciaRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Agencia buscarPorId(int id) {
        String sql = "SELECT * FROM agencia WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new AgenciaRowMapper());
    }

    public void atualizar(Agencia agencia) {
        String sql = "UPDATE agencia SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        jdbcTemplate.update(sql, agencia.getNome(), agencia.getEndereco(), agencia.getTelefone(), agencia.getId());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM agencia WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class AgenciaRowMapper implements RowMapper<Agencia> {
        @Override
        public Agencia mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Agencia(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("telefone")
            );
        }
    }
}
