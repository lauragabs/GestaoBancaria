package proj_int.bank.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import proj_int.bank.domain.Cliente;
import proj_int.bank.domain.Conta;

@Repository
public class ContaRepository {

    private JdbcTemplate conexaoBanco;

    public ContaRepository(JdbcTemplate conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public void deletarContaPorId(Integer id) {
        String sql = "DELETE FROM Conta WHERE id = ?";
        conexaoBanco.update(sql, id);
    }

    public void inserirConta(Conta conta) {
        String sql = "INSERT INTO Conta (tipoConta, saldo, idCliente, dataCriacao) VALUES (?, ?, ?, ?)";
        conexaoBanco.update(sql, conta.getTipoConta(), 
                                conta.getSaldo(), 
                                conta.getCliente().getId(), 
                                conta.getDataCriacao()
                            );
    }

    public void atualizarConta(Conta conta) {
        String sql = "UPDATE Conta SET saldo = ?, tipoConta = ? WHERE id = ?";
        conexaoBanco.update(sql, conta.getSaldo(), 
                                conta.getTipoConta(),
                                conta.getId()
                            );
    }

    public List<Conta> listarContaPorCpf(String cpf) {
        String sql = "SELECT c.* FROM Conta c " +
                     "JOIN Cliente cl ON c.idCliente = cl.id " +
                     "WHERE cl.cpf = ?";

        return conexaoBanco.query(sql, new Object[]{cpf}, (res, rowNum) -> 
            new Conta (
                res.getInt("id"),
                res.getString("tipoConta"),
                res.getFloat("saldo"),
                new Cliente(res.getInt("idCliente")),
                res.getDate("dataCriacao").toLocalDate()
            )
        );
    }


}
