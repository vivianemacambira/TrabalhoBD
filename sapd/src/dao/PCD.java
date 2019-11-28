package dao;

public class PCD {

    public Integer matricula;
    private Integer telefone;
    private UA ua_id;
    private String nome;
    private String condicao_deficiencia;
    private String email;
    private String curso;
    private String senha;
   
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public UA getUa_id() {
        return ua_id;
    }

    public void setUa_id(UA ua_id) {
        this.ua_id = ua_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCondicao_deficiencia() {
        return condicao_deficiencia;
    }

    public void setCondicao_deficiencia(String condicao_deficiencia) {
        this.condicao_deficiencia = condicao_deficiencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
