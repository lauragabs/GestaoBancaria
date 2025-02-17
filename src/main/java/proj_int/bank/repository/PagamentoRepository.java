package proj_int.bank.repository;

import proj_int.bank.domain.Pagamento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PagamentoRepository {

    private final JdbcTemplate jdbcTemplate;

    public PagamentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Pagamento pagamento) {
        String sql = "INSERT INTO pagamento (data_pagamento, valor, descricao, id_emprestimo) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, pagamento.getDataPagamento(), pagamento.getValor(), pagamento.getDescricao(), pagamento.getIdEmprestimo());
    }

    public List<Pagamento> listar() {
        String sql = "SELECT * FROM pagamento";
        return jdbcTemplate.query(sql, new PagamentoRowMapper());
    }

    @SuppressWarnings("deprecation")
    public Pagamento buscarPorId(int id) {
        String sql = "SELECT * FROM pagamento WHERE id_pagamento = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PagamentoRowMapper());
    }

    public void atualizar(Pagamento pagamento) {
        String sql = "UPDATE pagamento SET data_pagamento = ?, valor = ?, descricao = ?, id_emprestimo = ? WHERE id_pagamento = ?";
        jdbcTemplate.update(sql, pagamento.getDataPagamento(), pagamento.getValor(), pagamento.getDescricao(), pagamento.getIdEmprestimo(), pagamento.getIdPagamento());
    }

    public void excluir(int id) {
        String sql = "DELETE FROM pagamento WHERE id_pagamento = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class PagamentoRowMapper implements RowMapper<Pagamento> {
        @Override
        public Pagamento mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Pagamento(
                    rs.getInt("id_pagamento"),
                    rs.getDate("data_pagamento"),
                    rs.getDouble("valor"),
                    rs.getString("descricao"),
                    rs.getInt("id_emprestimo")
            );
        }
    }
}
