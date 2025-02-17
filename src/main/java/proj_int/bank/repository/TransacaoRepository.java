package proj_int.bank.repository;

import proj_int.bank.domain.Transacao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransacaoRepository {

    private final JdbcTemplate jdbcTemplate;

    public TransacaoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Transacao transacao) {
        String sql = "INSERT INTO transacao (tipo_transacao, valor_transacao, data_transacao, id_conta) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, transacao.getTipoTransacao(), transacao.getValorTransacao(), transacao.getDataTransacao(), transacao.getIdConta());
    }

    public List<Transacao> listar() {
        String sql = "SELECT * FROM transacao";
        return jdbcTemplate.query(sql, new TransacaoRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Transacao buscarPorId(int id) {
        String sql = "SELECT * FROM transacao WHERE id_transacao = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TransacaoRowMapper());
    }

    public void atualizar(Transacao transacao) {
        String sql = "UPDATE transacao SET tipo_transacao = ?, valor_transacao = ?, data_transacao = ?, id_conta = ? WHERE id_transacao = ?";
        jdbcTemplate.update(sql, transacao.getTipoTransacao(), transacao.getValorTransacao(), transacao.getDataTransacao(), transacao.getIdConta(), transacao.getIdTransacao());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM transacao WHERE id_transacao = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class TransacaoRowMapper implements RowMapper<Transacao> {
        @Override
        public Transacao mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Transacao(
                    rs.getInt("id_transacao"),
                    rs.getString("tipo_transacao"),
                    rs.getBigDecimal("valor_transacao"),
                    rs.getDate("data_transacao"),
                    rs.getInt("id_conta")
            );
        }
    }
}
