/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que representa as ações de manipulação de dados na tabela pessoa
 */
public class novaSolicitacaoDAO extends DAO {

    public void inserir(novaSolicitacao ns, String nucleo_email) throws Exception {
        Connection c = obterConexao();
        String sql = "INSERT INTO nova_solicitacao (id, titulo_obra, autor_obra, observacao, formato_acessível, arquivo, pcd_matricula, nucleo_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, ns.getId());
        stmt.setString(2, ns.getTitulo_obra());
        stmt.setString(3, ns.getAutor_obra());       
        stmt.setString(4, ns.getObservacao());
        /*COMBOBOX*/
        stmt.setString(5, ns.getFormato_acessivel());
        stmt.setString(6, ns.getArquivo());
        stmt.setInt(7, ns.getPcd().getMatricula());  
        stmt.setString(8, nucleo_email);
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível inserir esta nova solicitação");
        }
    }
}
