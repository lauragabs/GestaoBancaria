package proj_int.bank.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import proj_int.bank.domain.Cartao;
import proj_int.bank.domain.Conta;

@Repository
public class CartaoRepository {

    private JdbcTemplate conexaoBanco;

    public CartaoRepository(JdbcTemplate conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public List<Cartao> listarCartoesPorCpf(String cpf) {
        String sql = "SELECT c.* FROM Cartao c " +
                     "JOIN Conta co ON c.idConta = co.id " +
                     "JOIN Cliente cl ON co.idCliente = cl.id " +
                     "WHERE cl.cpf = ?";

        return conexaoBanco.query(sql, new Object[]{cpf}, (res, rowNum) -> 
            new Cartao (
                res.getInt("id"),
                new Conta(res.getInt("idConta")),
                res.getString("numero"),
                res.getDate("dataVencimento").toLocalDate(),
                res.getFloat("limite"),
                res.getString("tipo"),
                res.getInt("cvv")
            )
        );
    }

    public void deletarCartaoPorId (Integer id) {
        String sql = "DELETE FROM Cartao WHERE id = ?";
        conexaoBanco.update(sql, id);
    }

    public void inserirCartao(Cartao cartao) {
        String sql = "INSERT INTO Cartao (idConta, numero, dataVencimento, limite, tipo, cvv) VALUES (?, ?, ?, ?, ?, ?)";
        conexaoBanco.update(sql, cartao.getConta().getId(), 
                                cartao.getNumero(), 
                                cartao.getDataVencimento(), 
                                cartao.getLimite(), 
                                cartao.getTipo(), 
                                cartao.getCvv()
                            );
    }

    public void atualizarLimiteCartao(Cartao cartao) {
        String sql = "UPDATE Cartao SET limite = ? WHERE id = ?";
        conexaoBanco.update(sql, cartao.getLimite(), 
                                cartao.getId()
                            );
    }
}