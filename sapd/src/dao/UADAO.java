package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UADAO extends DAO {

    public UA obter(int id) throws Exception {
        NucleoDAO nucleoDAO = new NucleoDAO();
        CampusDAO campusDAO = new CampusDAO();
        
        UA ua = null;
        Connection c = obterConexao();
        String sql = "SELECT id, nome, campus_id, nucleo_email FROM ua WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ua = new UA();
            ua.setId(rs.getInt("id"));
            ua.setNome(rs.getString("nome"));
            ua.setCampus(campusDAO.obter(rs.getInt("campus_id")));
            String nucleo_email = rs.getString("nucleo_email");
            Nucleo n = nucleoDAO.obter(nucleo_email);
            ua.setNucleo(n);
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (ua == null) {
            throw new Exception("Não foi possível localizar esta unidade acadêmica");
        }
        return ua;
    }   
    
    public List<UA> obterTodos() throws Exception {
        List<UA> ua = new ArrayList<UA>();
        Connection c = obterConexao();
        String sql = "SELECT id,nome FROM ua";
        PreparedStatement stmt = c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            UA u = new UA();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            ua.add(u);
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        return ua;
    }
}
