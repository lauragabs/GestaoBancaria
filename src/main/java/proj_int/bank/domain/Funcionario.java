package proj_int.bank.domain;

import java.util.Date;

public class Funcionario {
    private int idFunc;
    private String nomeFunc;
    private String cargoFunc;
    private String telefoneFunc;
    private String cpfFunc;
    private String enderecoFunc;
    private Date dataNascFunc;
    private double salarioFunc;
    private String sexoFunc;
    private int idAgencia;

    public Funcionario(int idFunc, String nomeFunc, String cargoFunc, String telefoneFunc, String cpfFunc,
            String enderecoFunc, Date dataNascFunc, double salarioFunc, String sexoFunc, int idAgencia) {
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
        this.cargoFunc = cargoFunc;
        this.telefoneFunc = telefoneFunc;
        this.cpfFunc = cpfFunc;
        this.enderecoFunc = enderecoFunc;
        this.dataNascFunc = dataNascFunc;
        this.salarioFunc = salarioFunc;
        this.sexoFunc = sexoFunc;
        this.idAgencia = idAgencia;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getCargoFunc() {
        return cargoFunc;
    }

    public void setCargoFunc(String cargoFunc) {
        this.cargoFunc = cargoFunc;
    }

    public String getTelefoneFunc() {
        return telefoneFunc;
    }

    public void setTelefoneFunc(String telefoneFunc) {
        this.telefoneFunc = telefoneFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getEnderecoFunc() {
        return enderecoFunc;
    }

    public void setEnderecoFunc(String enderecoFunc) {
        this.enderecoFunc = enderecoFunc;
    }

    public Date getDataNascFunc() {
        return dataNascFunc;
    }

    public void setDataNascFunc(Date dataNascFunc) {
        this.dataNascFunc = dataNascFunc;
    }

    public double getSalarioFunc() {
        return salarioFunc;
    }

    public void setSalarioFunc(double salarioFunc) {
        this.salarioFunc = salarioFunc;
    }

    public String getSexoFunc() {
        return sexoFunc;
    }

    public void setSexoFunc(String sexoFunc) {
        this.sexoFunc = sexoFunc;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }
}