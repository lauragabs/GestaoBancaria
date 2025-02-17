package proj_int.bank.domain;

import java.util.Date;

public class Fatura {
    private int idFatura;
    private Date dataVencimento;
    private double valor;
    private int idCartao;

    public Fatura(int idFatura, Date dataVencimento, double valor, int idCartao) {
        this.idFatura = idFatura;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.idCartao = idCartao;
    }

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }
}