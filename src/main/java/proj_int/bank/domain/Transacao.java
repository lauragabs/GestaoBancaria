package proj_int.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transacao {
    private int idTransacao;
    private String tipoTransacao;
    private BigDecimal valorTransacao;
    private Date dataTransacao;
    private int idConta;

    // Construtor padrão
    public Transacao() {
    }

    // Construtor com parâmetros
    public Transacao(int idTransacao, String tipoTransacao, BigDecimal valorTransacao, Date dataTransacao, int idConta) {
        this.idTransacao = idTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.dataTransacao = dataTransacao;
        this.idConta = idConta;
    }

    // Getters e Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
