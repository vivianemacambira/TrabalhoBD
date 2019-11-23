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
public class PCDDAO extends DAO {

    public void inserir(PCD p) throws Exception {
        Connection c = obterConexao();
        String sql = "INSERT INTO pcd (matricula, nome, condicao_deficiencia, telefone, email, curso, senha, ua_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, p.getMatricula());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getCondicao_deficiencia());       
        stmt.setInt(4, p.getTelefone());
        stmt.setString(5, p.getEmail());
        stmt.setString(6, p.getCurso());
        stmt.setString(7, p.getSenha());  
        /*COMBOBOX*/
        stmt.setInt(8, p.getUa().getId());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível inserir este PCD");
        }
    }

    public void atualizar(PCD p) throws Exception {
        Connection c = obterConexao();
        String sql = "UPDATE PCD SET telefone = ?, email = ? WHERE matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, p.getTelefone());
        stmt.setString(2, p.getEmail());
        stmt.setInt(3, p.getMatricula());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível atualizar este PCD");
        }
    }

    public void remover(PCD p) throws Exception {
        Connection c = obterConexao();
        String sql = "DELETE FROM PCD WHERE matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, p.getMatricula());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível remover este PCD");
        }
    }

    public PCD obter(int matricula) throws Exception {
        PCD p = null;
        Connection c = obterConexao();
        String sql = "SELECT matricula, nome, condicao_deficiencia, telefone, email, curso, ua_id FROM PCD WHERE matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, matricula);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            p = new PCD();
            p.setMatricula(rs.getInt("matricula"));
            p.setNome(rs.getString("nome"));
            p.setCondicao_deficiencia(rs.getString("condicao_deficiencia"));
            p.setTelefone(rs.getInt("telefone"));
            p.setEmail(rs.getString("email"));
            p.setCurso(rs.getString("curso"));
            
            UADAO dao = new UADAO();
            p.setUa(dao.obter(rs.getInt("ua_id"))); //aqui é aquela implementação pra pôr o objeto
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (p == null) {
            throw new Exception("Não foi possível localizar este PCD");
        }
        return p;
    }

    public List<PCD> obterTodos() throws Exception {
        List<PCD> listaPCD = new ArrayList<PCD>();
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
            listaPCD.add(p);
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        return listaPCD;
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
