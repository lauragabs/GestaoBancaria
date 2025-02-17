package proj_int.bank.domain;

import java.util.Date;

public class Emprestimo {
    private int idEmprestimo;
    private double valor;
    private int numParcelas;
    private float juros;
    private String garantia;
    private Date dataVencimento;
    private int idConta;

    public Emprestimo(int id, double valor, int numParcelas, float juros, String garantia,
                       Date dataVencimento, int idConta) {
        this.idEmprestimo = id;
        this.valor = valor;
        this.numParcelas = numParcelas;
        this.juros = juros;
        this.garantia = garantia;
        this.dataVencimento = dataVencimento;
        this.idConta = idConta;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}