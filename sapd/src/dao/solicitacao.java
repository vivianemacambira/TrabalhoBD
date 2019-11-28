package dao;

public class solicitacao {

    private novaSolicitacao nova_solicitacao;
    private String autor_obra;
    private String data_prevista;
    private String status;
    private String arquivo;

    public novaSolicitacao getNova_solicitacao() {
        return nova_solicitacao;
    }

    public void setNova_solicitacao(novaSolicitacao nova_solicitacao) {
        this.nova_solicitacao = nova_solicitacao;
    }

    public String getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(String data_prevista) {
        this.data_prevista = data_prevista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getAutor_obra() {
        return autor_obra;
    }

    public void setAutor_obra(String autor_obra) {
        this.autor_obra = autor_obra;
    }

}
