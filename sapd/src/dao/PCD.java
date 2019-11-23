/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

public class PCD {

    private Integer matricula;
    private Integer telefone;
    private UA ua;
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

    public UA getUa() {
        return ua;
    }

    public void setUa(UA ua) {
        this.ua = ua;
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
