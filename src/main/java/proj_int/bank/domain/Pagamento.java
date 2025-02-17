package proj_int.bank.domain;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private Date dataPagamento;
    private double valor;
    private String descricao;
    private int idEmprestimo;

    public Pagamento(int id, Date data, double valor, String descricao, int idEmpr) {
        this.idPagamento = id;
        this.dataPagamento = data;
        this.valor = valor;
        this.descricao = descricao;
        this.idEmprestimo = idEmpr;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
}
