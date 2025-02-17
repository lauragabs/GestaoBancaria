package proj_int.bank.domain;

public class Gerente {
    private int idGerente;
    private String nivelGerente;
    private int idFunc;

    public Gerente(int idGerente, String nivelGerente, int idFunc) {
        this.idGerente = idGerente;
        this.nivelGerente = nivelGerente;
        this.idFunc = idFunc;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public String getNivelGerente() {
        return nivelGerente;
    }

    public void setNivelGerente(String nivelGerente) {
        this.nivelGerente = nivelGerente;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
}
