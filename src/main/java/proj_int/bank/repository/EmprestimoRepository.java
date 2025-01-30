package proj_int.bank.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import proj_int.bank.domain.Conta;
import proj_int.bank.domain.Emprestimo;

@Repository
public class EmprestimoRepository {

    private JdbcTemplate conexaoBanco;

    public EmprestimoRepository(JdbcTemplate conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public void inserirEmprestimo(Emprestimo emprestimo) {
        String sql = "INSERT INTO Emprestimo (idConta, valor, parcelas, juros, garantia, dataVencimento) VALUES (?, ?, ?, ?, ?,?)";
        conexaoBanco.update(sql, emprestimo.getConta().getId(), 
                                emprestimo.getValor(), 
                                emprestimo.getParcelas(), 
                                emprestimo.getJuros(), 
                                emprestimo.getGarantia(),
                                emprestimo.getDataVencimento()
                            );
    }

    public void deletarEmprestimoPorId (Integer id) {
        String sql = "DELETE FROM Emprestimo WHERE id = ?";
        conexaoBanco.update(sql, id);
    }

    public List<Emprestimo> listarEmprestimosPorCpf(String cpf) {
        String sql = "SELECT e.* FROM Emprestimo e " +
                     "JOIN Conta co ON e.idConta = co.id " +
                     "JOIN Cliente cl ON co.idCliente = cl.id " +
                     "WHERE cl.cpf = ?";

        return conexaoBanco.query(sql, new Object[]{cpf}, (res, rowNum) -> 
            new Emprestimo (
                res.getInt("id"),
                res.getFloat("valor"),
                res.getInt("parcelas"),
                res.getFloat("juros"),
                res.getString("garantia"),
                res.getDate("dataVencimento").toLocalDate(),
                new Conta(res.getInt("idConta"))
            )
        );
    }

}
