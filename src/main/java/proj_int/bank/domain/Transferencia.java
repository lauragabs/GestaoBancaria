package proj_int.bank.domain;

public class Transferencia {
    private int idTransferencia;
    private int contaDestinoTransferencia;
    private int idTransacao;

    public Transferencia(int idTransferencia, int contaDestinoTransferencia, int idTransacao) {
        this.idTransferencia = idTransferencia;
        this.contaDestinoTransferencia = contaDestinoTransferencia;
        this.idTransacao = idTransacao;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public int getContaDestinoTransferencia() {
        return contaDestinoTransferencia;
    }

    public void setContaDestinoTransferencia(int contaDestinoTransferencia) {
        this.contaDestinoTransferencia = contaDestinoTransferencia;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }
}