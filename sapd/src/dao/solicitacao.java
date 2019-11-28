/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Leonardo Oliveira Moreira
 * 
 * Classe que representa a entidade pessoa
 */
public class solicitacao {

    private novaSolicitacao nova_solicitacao;
    private String data_prevista;
    private String status;
    private String arquivo;

    /**
     * @return the nova_solicitacao
     */
    public novaSolicitacao getNova_solicitacao() {
        return nova_solicitacao;
    }

    /**
     * @param nova_solicitacao the nova_solicitacao to set
     */
    public void setNova_solicitacao(novaSolicitacao nova_solicitacao) {
        this.nova_solicitacao = nova_solicitacao;
    }

    /**
     * @return the data_prevista
     */
    public String getData_prevista() {
        return data_prevista;
    }

    /**
     * @param data_prevista the data_prevista to set
     */
    public void setData_prevista(String data_prevista) {
        this.data_prevista = data_prevista;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the arquivo
     */
    public String getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

   

    
    
}
