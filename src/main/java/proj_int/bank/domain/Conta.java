package proj_int.bank.domain;

import java.util.Date;

public class Conta {
    private int id;
    private double saldo;
    private String tipo;
    private Date dataAbertura;
    private Cliente cliente;
    private Agencia agencia;

    public Conta(int id, double saldo, String tipo, Date dataAbertura, Cliente cliente, Agencia agencia) {
        this.id = id;
        this.saldo = saldo;
        this.tipo = tipo;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
        this.agencia = agencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Date getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(Date dataAbertura) { this.dataAbertura = dataAbertura; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Agencia getAgencia() { return agencia; }
    public void setAgencia(Agencia agencia) { this.agencia = agencia; }
}
