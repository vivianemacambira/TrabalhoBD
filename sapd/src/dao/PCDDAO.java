package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PCDDAO extends DAO {

    public void inserir(PCD p) throws Exception {
        Connection c = obterConexao();
        String sql = "INSERT INTO PCD (matricula, nome, condicao_deficiencia, telefone, email, curso, senha, ua_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, p.getMatricula());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getCondicao_deficiencia());       
        stmt.setInt(4, p.getTelefone());
        stmt.setString(5, p.getEmail());
        stmt.setString(6, p.getCurso());
        stmt.setString(7, p.getSenha());  
        stmt.setInt(8, p.getUa_id().getId());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível inserir esta pessoa");
        }
    }

    public void atualizarSenha(PCD p) throws Exception {
        Connection c = obterConexao();
        String sql = "UPDATE PCD SET senha = ? WHERE matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, p.getSenha());
        stmt.setInt(2, p.getMatricula());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível atualizar esta pessoa");
        }
    }
    
    public void atualizarEmail(PCD p) throws Exception {
        Connection c = obterConexao();
        String sql = "UPDATE PCD SET email = ? WHERE matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, p.getEmail());
        stmt.setInt(2, p.getMatricula());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível atualizar esta pessoa");
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
            throw new Exception("Não foi possível remover esta pessoa");
        }
    }

    public PCD obter(int matricula) throws Exception {
        PCD p = null;
        Connection c = obterConexao();
        String sql = "SELECT matricula, nome, condicao_deficiencia, telefone, email, curso, senha, ua_id FROM PCD WHERE matricula = ?";
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
            p.setUa_id(dao.obter(rs.getInt("ua_id"))); //aqui é aquela implementação pra pôr o objeto
            p.setSenha(rs.getString("senha"));
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (p == null) {
            throw new Exception("Não foi possível localizar esta pessoa");
        }
        return p;
    }
}
