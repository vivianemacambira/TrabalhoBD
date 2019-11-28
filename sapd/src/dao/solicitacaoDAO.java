/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
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
public class solicitacaoDAO extends DAO {
        public void inserir(solicitacao s) throws Exception {
        Connection c = obterConexao();
        String sql = "INSERT INTO solicitacao (data_prevista, nova_solicitacao_id, status, arquivo) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, s.getData_prevista());
        stmt.setInt(2, s.getNova_solicitacao().getId());       
        stmt.setString(3, s.getStatus());
        stmt.setString(4, s.getArquivo());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível inserir esta nova solicitação");
        }
    }

    public List<PCD> obterTodos(int idPCD) throws Exception {
        List<PCD> pessoas = new ArrayList<PCD>();
        Connection c = obterConexao();
        String sql = "SELECT matricula, nome, condicao_deficiencia, telefone, email, curso FROM PCD";
        PreparedStatement stmt = c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            PCD p = new PCD();
            p.setMatricula(rs.getInt("matricula"));
            p.setNome(rs.getString("nome"));
            p.setCondicao_deficiencia(rs.getString("condicao_deficiencia"));
            p.setTelefone(rs.getInt("telefone"));
            p.setEmail(rs.getString("email"));
            p.setCurso(rs.getString("curso"));
            pessoas.add(p);
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        return pessoas;
    }
  
}
