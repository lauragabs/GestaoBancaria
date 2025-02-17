package proj_int.bank.repository;

import proj_int.bank.domain.Gerente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GerenteRepository {

    private final JdbcTemplate jdbcTemplate;

    public GerenteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Gerente gerente) {
        String sql = "INSERT INTO gerente (nivel_gerente, id_func) VALUES (?, ?)";
        jdbcTemplate.update(sql, gerente.getNivelGerente(), gerente.getIdFunc());
    }

    public List<Gerente> listar() {
        String sql = "SELECT * FROM gerente";
        return jdbcTemplate.query(sql, new GerenteRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Gerente buscarPorId(int id) {
        String sql = "SELECT * FROM gerente WHERE id_gerente = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new GerenteRowMapper());
    }

    public void atualizar(Gerente gerente) {
        String sql = "UPDATE gerente SET nivel_gerente = ?, id_func = ? WHERE id_gerente = ?";
        jdbcTemplate.update(sql, gerente.getNivelGerente(), gerente.getIdFunc(), gerente.getIdGerente());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM gerente WHERE id_gerente = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class GerenteRowMapper implements RowMapper<Gerente> {
        @Override
        public Gerente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Gerente(
                    rs.getInt("id_gerente"),
                    rs.getString("nivel_gerente"),
                    rs.getInt("id_func")
            );
        }
    }
}
