package proj_int.bank.repository;

import proj_int.bank.domain.Conta;
import proj_int.bank.domain.Cliente;
import proj_int.bank.domain.Agencia;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContaRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Conta conta) {
        String sql = "INSERT INTO conta (saldo, tipo, data_abertura, id_cliente, id_agencia) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, conta.getSaldo(), conta.getTipo(), conta.getDataAbertura(),
                conta.getCliente().getId(), conta.getAgencia().getId());
    }

    public List<Conta> listar() {
        String sql = "SELECT * FROM conta";
        return jdbcTemplate.query(sql, new ContaRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Conta buscarPorId(int id) {
        String sql = "SELECT * FROM conta WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ContaRowMapper());
    }

    public void atualizar(Conta conta) {
        String sql = "UPDATE conta SET saldo = ?, tipo = ?, data_abertura = ?, id_cliente = ?, id_agencia = ? WHERE id = ?";
        jdbcTemplate.update(sql, conta.getSaldo(), conta.getTipo(), conta.getDataAbertura(),
                conta.getCliente().getId(), conta.getAgencia().getId(), conta.getId());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM conta WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ContaRowMapper implements RowMapper<Conta> {
        @Override
        public Conta mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente cliente = new Cliente(rs.getInt("id_cliente"), "", "", "", "", "", "", rs.getDate("data_nascimento"), "", "");
            Agencia agencia = new Agencia(rs.getInt("id_agencia"), "", "", "");

            return new Conta(
                    rs.getInt("id"),
                    rs.getDouble("saldo"),
                    rs.getString("tipo"),
                    rs.getDate("data_abertura"),
                    cliente,
                    agencia
            );
        }
    }
}
