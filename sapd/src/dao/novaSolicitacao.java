package dao;

public class novaSolicitacao {

    private int id;
    private String titulo_obra;
    private String autor_obra;
    private String observacao;
    private String formato_acessivel;
    private String arquivo;
    private PCD pcd;
    private Nucleo nucleo;

    public PCD getPcd() {
        return pcd;
    }

    public void setPcd(PCD pcd) {
        this.pcd = pcd;
    }

    public String getTitulo_obra() {
        return titulo_obra;
    }

    public void setTitulo_obra(String titulo_obra) {
        this.titulo_obra = titulo_obra;
    }

    public String getAutor_obra() {
        return autor_obra;
    }

    public void setAutor_obra(String autor_obra) {
        this.autor_obra = autor_obra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getFormato_acessivel() {
        return formato_acessivel;
    }

    public void setFormato_acessivel(String formato_acessivel) {
        this.formato_acessivel = formato_acessivel;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public int getId() {
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }  
}
