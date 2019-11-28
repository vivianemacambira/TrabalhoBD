package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NucleoDAO extends DAO {

    public Nucleo obter(String email) throws Exception {
        Nucleo n = null;
        Connection c = obterConexao();
        String sql = "SELECT email, senha FROM nucleo WHERE email = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            n = new Nucleo();
            n.setEmail(rs.getString("email"));
            n.setSenha(rs.getString("senha"));
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (n == null) {
            throw new Exception("Não foi possível localizar este núcleo");
        }
        return n;
    }
    
    public void atualizarSenha(Nucleo p) throws Exception {
        Connection c = obterConexao();
        String sql = "UPDATE nucleo SET senha = ? WHERE email = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, p.getSenha() );
        stmt.setString(2, p.getEmail());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível atualizar esta pessoa");
        }
    }
}
