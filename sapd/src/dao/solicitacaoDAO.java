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
public class solicitacaoDAO extends DAO {

    public solicitacao obter(novaSolicitacao id) throws Exception {
        solicitacao s = null;
        Connection c = obterConexao();
        String sql = "SELECT solicitacao.nova_solicitacao_id, nova_solicitacao.titulo_obra, nova_solicitacao.autor_obra, solicitacao.status, solicitacao.data_prevista, solicitacao.arquivo FROM nova_solicitacao,solicitacao WHERE matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, matricula);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            s = new solicitacao();
            s.setMatricula(rs.getInt("matricula"));
            s.setNome(rs.getString("nome"));
            s.setCondicao_deficiencia(rs.getString("condicao_deficiencia"));
            s.setTelefone(rs.getInt("telefone"));
            s.setEmail(rs.getString("email"));
            s.setCurso(rs.getString("curso"));
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (s == null) {
            throw new Exception("Não foi possível localizar esta pessoa");
        }
        return s;
    }

    public List<PCD> obterTodos() throws Exception {
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

    public List<PCD> obterPorNomeELogin(String nome, String login) throws Exception {
        if (nome == null || nome.trim().length() == 0) {
            nome = "%";
        } else {
            nome = "%" + nome.toUpperCase() + "%";
        }
        if (login == null || login.trim().length() == 0) {
            login = "%";
        } else {
            login = "%" + login.toUpperCase() + "%";
        }
        List<PCD> pessoas = new ArrayList<PCD>();
        Connection c = obterConexao();
        String sql = "SELECT matricula, nome, condicao_deficiencia, telefone, email, curso FROM PCD WHERE upper(nome) LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, nome);
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
