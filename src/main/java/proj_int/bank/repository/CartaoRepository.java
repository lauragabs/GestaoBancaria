package proj_int.bank.repository;

import proj_int.bank.domain.Cartao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartaoRepository {

    private final JdbcTemplate jdbcTemplate;

    public CartaoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Cartao cartao) {
        String sql = "INSERT INTO Cartao (tipo_cartao, limite_cartao, dataValidade_cartao, num_cartao, id_conta) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cartao.getTipoCartao(), cartao.getLimiteCartao(), cartao.getDataValidadeCartao(),
                cartao.getNumCartao(), cartao.getIdConta());
    }

    public List<Cartao> listar() {
        String sql = "SELECT * FROM Cartao";
        return jdbcTemplate.query(sql, new CartaoRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Cartao buscarPorId(int idCartao) {
        String sql = "SELECT * FROM Cartao WHERE id_cartao = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idCartao}, new CartaoRowMapper());
    }

    public void atualizar(Cartao cartao) {
        String sql = "UPDATE Cartao SET tipo_cartao = ?, limite_cartao = ?, dataValidade_cartao = ?, num_cartao = ?, id_conta = ? WHERE id_cartao = ?";
        jdbcTemplate.update(sql, cartao.getTipoCartao(), cartao.getLimiteCartao(), cartao.getDataValidadeCartao(),
                cartao.getNumCartao(), cartao.getIdConta(), cartao.getIdCartao());
    }

    public void excluir(int idCartao) {
        String sql = "DELETE FROM Cartao WHERE id_cartao = ?";
        jdbcTemplate.update(sql, idCartao);
    }

    private static class CartaoRowMapper implements RowMapper<Cartao> {
        @Override
        public Cartao mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cartao(
                    rs.getInt("id_cartao"),
                    rs.getString("tipo_cartao"),
                    rs.getDouble("limite_cartao"),
                    rs.getDate("dataValidade_cartao"),
                    rs.getLong("num_cartao"),
                    rs.getInt("id_conta")
            );
        }
    }
}
