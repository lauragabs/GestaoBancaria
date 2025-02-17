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
        String sql = "INSERT INTO cliente (nome, sexo, cpf, endereco, email, telefone, data_nascimento, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cliente.getNome(), cliente.getSexo(), cliente.getCpf(), cliente.getEndereco(),
                cliente.getEmail(), cliente.getTelefone(), cliente.getDataNascimento(), cliente.getLogin(), cliente.getSenha());
    }

    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ClienteRowMapper());
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, sexo = ?, cpf = ?, endereco = ?, email = ?, telefone = ?, data_nascimento = ?, login = ?, senha = ? WHERE id = ?";
        jdbcTemplate.update(sql, cliente.getNome(), cliente.getSexo(), cliente.getCpf(), cliente.getEndereco(),
                cliente.getEmail(), cliente.getTelefone(), cliente.getDataNascimento(), cliente.getLogin(), cliente.getSenha(), cliente.getId());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getDate("data_nascimento"),
                    rs.getString("login"),
                    rs.getString("senha")
            );
        }
    }
}
