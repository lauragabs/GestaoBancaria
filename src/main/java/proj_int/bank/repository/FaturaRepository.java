package proj_int.bank.repository;

import proj_int.bank.domain.Fatura;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FaturaRepository {

    private final JdbcTemplate jdbcTemplate;

    public FaturaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Fatura fatura) {
        String sql = "INSERT INTO fatura (data_vencimento, valor, id_cartao) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, fatura.getDataVencimento(), fatura.getValor(), fatura.getIdCartao());
    }

    public List<Fatura> listar() {
        String sql = "SELECT * FROM fatura";
        return jdbcTemplate.query(sql, new FaturaRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Fatura buscarPorId(int id) {
        String sql = "SELECT * FROM fatura WHERE id_fatura = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FaturaRowMapper());
    }

    public void atualizar(Fatura fatura) {
        String sql = "UPDATE fatura SET data_vencimento = ?, valor = ?, id_cartao = ? WHERE id_fatura = ?";
        jdbcTemplate.update(sql, fatura.getDataVencimento(), fatura.getValor(), fatura.getIdCartao(), fatura.getIdFatura());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM fatura WHERE id_fatura = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class FaturaRowMapper implements RowMapper<Fatura> {
        @Override
        public Fatura mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Fatura(
                    rs.getInt("id_fatura"),
                    rs.getDate("data_vencimento"),
                    rs.getDouble("valor"),
                    rs.getInt("id_cartao")
            );
        }
    }
}
