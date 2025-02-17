package proj_int.bank.repository;

import proj_int.bank.domain.Conta;
import proj_int.bank.domain.Cliente;
import proj_int.bank.domain.Agencia;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ContaRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Conta conta) {
        String sql = "INSERT INTO Conta (saldo_conta, tipo_conta, dataAbertura_conta, id_cliente, id_agencia) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, conta.getSaldo(), conta.getTipo(), conta.getDataAbertura(),
                conta.getCliente().getId(), conta.getAgencia().getId());
    }

    public List<Conta> listar() {
        String sql = "SELECT \n" + //
                        "    c.id_conta AS ID_Conta,\n" + //
                        "    c.saldo_conta AS Saldo,\n" + //
                        "    c.tipo_conta AS Tipo_Conta,\n" + //
                        "    c.dataAbertura_conta AS Data_Abertura,\n" + //
                        "    \n" + //
                        "    cli.id_cliente AS ID_Cliente,\n" + //
                        "    cli.nome_cliente AS Nome_Cliente,\n" + //
                        "    cli.sexo_cliente AS Sexo,\n" + //
                        "    cli.cpf_cliente AS CPF,\n" + //
                        "    cli.endereco_cliente AS Endereco_Cliente,\n" + //
                        "    cli.email_cliente AS Email,\n" + //
                        "    cli.telefone_cliente AS Telefone,\n" + //
                        "    cli.dataNasc_cliente AS Data_Nascimento,\n" + //
                        "    cli.login_cliente AS Login,\n" + //
                        "    cli.senha_cliente AS Senha, -- Cuidado com armazenamento de senhas em texto puro\n" + //
                        "    \n" + //
                        "    a.id_agencia AS ID_Agencia,\n" + //
                        "    a.nome_agencia AS Nome_Agencia,\n" + //
                        "    a.endereco_agencia AS Endereco_Agencia,\n" + //
                        "    a.telefone_agencia AS Telefone_Agencia\n" + //
                        "FROM \n" + //
                        "    Conta c\n" + //
                        "JOIN \n" + //
                        "    Cliente cli ON c.id_cliente = cli.id_cliente\n" + //
                        "JOIN \n" + //
                        "    Agencia a ON c.id_agencia = a.id_agencia;";
        return jdbcTemplate.query(sql, new ContaRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Conta buscarPorId(int id) {
        String sql = "SELECT \n" + //
                        "    c.id_conta AS ID_Conta,\n" + //
                        "    c.saldo_conta AS Saldo,\n" + //
                        "    c.tipo_conta AS Tipo_Conta,\n" + //
                        "    c.dataAbertura_conta AS Data_Abertura,\n" + //
                        "    \n" + //
                        "    cli.id_cliente AS ID_Cliente,\n" + //
                        "    cli.nome_cliente AS Nome_Cliente,\n" + //
                        "    cli.sexo_cliente AS Sexo,\n" + //
                        "    cli.cpf_cliente AS CPF,\n" + //
                        "    cli.endereco_cliente AS Endereco_Cliente,\n" + //
                        "    cli.email_cliente AS Email,\n" + //
                        "    cli.telefone_cliente AS Telefone,\n" + //
                        "    cli.dataNasc_cliente AS Data_Nascimento,\n" + //
                        "    cli.login_cliente AS Login,\n" + //
                        "    cli.senha_cliente AS Senha, -- Cuidado com armazenamento de senhas em texto puro\n" + //
                        "    \n" + //
                        "    a.id_agencia AS ID_Agencia,\n" + //
                        "    a.nome_agencia AS Nome_Agencia,\n" + //
                        "    a.endereco_agencia AS Endereco_Agencia,\n" + //
                        "    a.telefone_agencia AS Telefone_Agencia\n" + //
                        "FROM \n" + //
                        "    Conta c\n" + //
                        "JOIN \n" + //
                        "    Cliente cli ON c.id_cliente = cli.id_cliente\n" + //
                        "JOIN \n" + //
                        "    Agencia a ON c.id_agencia = a.id_agencia\n" +
                        "WHERE c.id_conta = ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ContaRowMapper());
    }

    public void atualizar(Conta conta) {
        String sql = "UPDATE Conta SET saldo_conta = ?, tipo_conta = ?, dataAbertura_conta = ?, id_cliente = ?, id_agencia = ? WHERE id_conta = ?";
        jdbcTemplate.update(sql, conta.getSaldo(), conta.getTipo(), conta.getDataAbertura(),
                conta.getCliente().getId(), conta.getAgencia().getId(), conta.getId());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Conta WHERE id_conta = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ContaRowMapper implements RowMapper<Conta> {
        @Override
        public Conta mapRow(ResultSet rs, int rowNum) throws SQLException {
            // Mapeando os dados da conta
            int idConta = rs.getInt("ID_Conta");
            double saldo = rs.getDouble("Saldo");
            String tipoConta = rs.getString("Tipo_Conta");
            Date dataAbertura = rs.getTimestamp("Data_Abertura");
            
            // Mapeando os dados do cliente
            int idCliente = rs.getInt("ID_Cliente");
            String nomeCliente = rs.getString("Nome_Cliente");
            String sexoCliente = rs.getString("Sexo");
            String cpfCliente = rs.getString("CPF");
            String enderecoCliente = rs.getString("Endereco_Cliente");
            String emailCliente = rs.getString("Email");
            String telefoneCliente = rs.getString("Telefone");
            Date dataNascimentoCliente = rs.getDate("Data_Nascimento");
            String loginCliente = rs.getString("Login");
            String senhaCliente = rs.getString("Senha");
            
            Cliente cliente = new Cliente(idCliente, nomeCliente, sexoCliente, cpfCliente, enderecoCliente, emailCliente, telefoneCliente, dataNascimentoCliente, loginCliente, senhaCliente);
            
            // Mapeando os dados da agência
            int idAgencia = rs.getInt("ID_Agencia");
            String nomeAgencia = rs.getString("Nome_Agencia");
            String enderecoAgencia = rs.getString("Endereco_Agencia");
            String telefoneAgencia = rs.getString("Telefone_Agencia");
            
            Agencia agencia = new Agencia(idAgencia, nomeAgencia, enderecoAgencia, telefoneAgencia);
            
            // Criando e retornando a conta com os dados mapeados
            return new Conta(idConta, saldo, tipoConta, dataAbertura, cliente, agencia);
        }
    }

}
