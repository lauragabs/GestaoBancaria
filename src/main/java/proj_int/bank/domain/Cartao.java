package proj_int.bank.domain;

import java.util.Date;

public class Cartao {
    private int idCartao;
    private String tipoCartao;
    private double limiteCartao;
    private Date dataValidadeCartao;
    private long numCartao;
    private int idConta;

    public Cartao(int idCartao, String tipoCartao, double limiteCartao, Date dataValidadeCartao, long numCartao,
            int idConta) {
        this.idCartao = idCartao;
        this.tipoCartao = tipoCartao;
        this.limiteCartao = limiteCartao;
        this.dataValidadeCartao = dataValidadeCartao;
        this.numCartao = numCartao;
        this.idConta = idConta;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public Date getDataValidadeCartao() {
        return dataValidadeCartao;
    }

    public void setDataValidadeCartao(Date dataValidadeCartao) {
        this.dataValidadeCartao = dataValidadeCartao;
    }

    public long getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(long numCartao) {
        this.numCartao = numCartao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}