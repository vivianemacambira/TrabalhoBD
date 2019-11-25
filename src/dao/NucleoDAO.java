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
}
