package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CampusDAO extends DAO {

    public Campus obter(int id) throws Exception {
        Campus campus = null;
        Connection c = obterConexao();
        String sql = "SELECT id, nome FROM campus WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            campus = new Campus();
            campus.setId(rs.getInt("id"));
            campus.setNome(rs.getString("nome"));
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (campus == null) {
            throw new Exception("Não foi possível localizar este Campus");
        }
        return campus;
    }  
}
