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
        String sql = "INSERT INTO Agencia (nome_agencia, endereco_agencia, telefone_agencia) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, agencia.getNome(), agencia.getEndereco(), agencia.getTelefone());
    }

    public List<Agencia> listar() {
        String sql = "SELECT * FROM Agencia";
        return jdbcTemplate.query(sql, new AgenciaRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Agencia buscarPorId(int id) {
        String sql = "SELECT * FROM Agencia WHERE id_agencia = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new AgenciaRowMapper());
    }

    public void atualizar(Agencia agencia) {
        String sql = "UPDATE Agencia SET nome_agencia = ?, endereco_agencia = ?, telefone_agencia = ? WHERE id_agencia = ?";
        jdbcTemplate.update(sql, agencia.getNome(), agencia.getEndereco(), agencia.getTelefone(), agencia.getId());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Agencia WHERE id_agencia = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class AgenciaRowMapper implements RowMapper<Agencia> {
        @Override
        public Agencia mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Agencia(
                    rs.getInt("id_agencia"),
                    rs.getString("nome_agencia"),
                    rs.getString("endereco_agencia"),
                    rs.getString("telefone_agencia")
            );
        }
    }
}
