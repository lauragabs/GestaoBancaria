package proj_int.bank.repository;

import proj_int.bank.domain.Transferencia;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransferenciaRepository {

    private final JdbcTemplate jdbcTemplate;

    public TransferenciaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Transferencia transferencia) {
        String sql = "INSERT INTO transferencia (conta_destino_transferencia, id_transacao) VALUES (?, ?)";
        jdbcTemplate.update(sql, transferencia.getContaDestinoTransferencia(), transferencia.getIdTransacao());
    }

    public List<Transferencia> listar() {
        String sql = "SELECT * FROM transferencia";
        return jdbcTemplate.query(sql, new TransferenciaRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Transferencia buscarPorId(int id) {
        String sql = "SELECT * FROM transferencia WHERE id_transferencia = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TransferenciaRowMapper());
    }

    public void atualizar(Transferencia transferencia) {
        String sql = "UPDATE transferencia SET conta_destino_transferencia = ?, id_transacao = ? WHERE id_transferencia = ?";
        jdbcTemplate.update(sql, transferencia.getContaDestinoTransferencia(), transferencia.getIdTransacao(), transferencia.getIdTransferencia());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM transferencia WHERE id_transferencia = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class TransferenciaRowMapper implements RowMapper<Transferencia> {
        @Override
        public Transferencia mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Transferencia(
                    rs.getInt("id_transferencia"),
                    rs.getInt("conta_destino_transferencia"),
                    rs.getInt("id_transacao")
            );
        }
    }
}
