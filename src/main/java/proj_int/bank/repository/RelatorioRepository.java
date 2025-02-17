package proj_int.bank.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Repository
public class RelatorioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Resumo de saldo total por cliente
    public List<Map<String, Object>> findSaldoTotalPorCliente() {
        String query = "SELECT c.id_cliente, c.nome_cliente, SUM(co.saldo_conta) AS saldo_total " +
                       "FROM Cliente c " +
                       "JOIN Conta co ON c.id_cliente = co.id_cliente " +
                       "GROUP BY c.id_cliente, c.nome_cliente";
        return jdbcTemplate.queryForList(query);
    }

    // Transações de depósito realizadas por cliente
    public List<Map<String, Object>> findTransacoesDepositoPorCliente() {
        String query = "SELECT c.id_cliente, c.nome_cliente, COUNT(t.id_transacao) AS transacoes_deposito " +
                       "FROM Cliente c " +
                       "JOIN Conta co ON c.id_cliente = co.id_cliente " +
                       "JOIN Agencia a ON co.id_agencia = a.id_agencia " +
                       "JOIN Transacao t ON co.id_conta = t.id_conta " +
                       "WHERE t.tipo_transacao = 'deposito' " +
                       "GROUP BY a.id_agencia, c.id_cliente";
        return jdbcTemplate.queryForList(query);
    }

    // Empréstimos e valores devidos por cliente com parcelas pendentes
    public List<Map<String, Object>> findEmprestimosPendentesPorCliente() {
        String query = "SELECT cl.id_cliente, cl.nome_cliente, SUM(e.valor_empr) AS total_emprestimo " +
                       "FROM Cliente cl " +
                       "JOIN Conta co ON cl.id_cliente = co.id_cliente " +
                       "JOIN Emprestimos e ON co.id_conta = e.id_conta " +
                       "WHERE e.numParcelas_empr > 0 " +
                       "GROUP BY cl.id_cliente, cl.nome_cliente";
        return jdbcTemplate.queryForList(query);
    }
}
