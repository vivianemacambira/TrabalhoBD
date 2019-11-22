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
            throw new Exception("Não foi possível localizar esta pessoa");
        }
        return campus;
    }   
}
