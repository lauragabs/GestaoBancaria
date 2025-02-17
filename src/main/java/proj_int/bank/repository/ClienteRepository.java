package proj_int.bank.repository;

import proj_int.bank.domain.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome_cliente, sexo_cliente, cpf_cliente, endereco_cliente, email_cliente, telefone_cliente, dataNasc_cliente, login_cliente, senha_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getNome(), cliente.getSexo(), cliente.getCpf(), cliente.getEndereco(),
                cliente.getEmail(), cliente.getTelefone(), cliente.getDataNascimento(), cliente.getLogin(), cliente.getSenha());
    }

    public List<Cliente> listar() {
        String sql = "SELECT * FROM Cliente";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ClienteRowMapper());
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome_cliente = ?, sexo_cliente = ?, cpf_cliente = ?, endereco_cliente = ?, email_cliente = ?, telefone_cliente = ?, dataNasc_cliente = ?, login_cliente = ?, senha_cliente = ? WHERE id_cliente = ?";
        jdbcTemplate.update(sql, cliente.getNome(), cliente.getSexo(), cliente.getCpf(), cliente.getEndereco(),
                cliente.getEmail(), cliente.getTelefone(), cliente.getDataNascimento(), cliente.getLogin(), cliente.getSenha(), cliente.getId());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nome_cliente"),
                    rs.getString("sexo_cliente"),
                    rs.getString("cpf_cliente"),
                    rs.getString("endereco_cliente"),
                    rs.getString("email_cliente"),
                    rs.getString("telefone_cliente"),
                    rs.getDate("dataNasc_cliente"),
                    rs.getString("login_cliente"),
                    rs.getString("senha_cliente")
            );
        }
    }
}
