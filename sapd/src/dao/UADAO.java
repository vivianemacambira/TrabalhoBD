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
public class UADAO extends DAO {

    public UA obter(int id) throws Exception {
        NucleoDAO nucleoDAO = new NucleoDAO();
        CampusDAO campusDAO = new CampusDAO();
        
        UA ua = null;
        Connection c = obterConexao();
        String sql = "SELECT id, nome, campus_id, nucleo_email FROM UA WHERE id = ?";
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
            throw new Exception("Não foi possível localizar esta pessoa");
        }
        return ua;
    }   
    
    //SELECT nucleo_email FROM nucleo as n, ua as u where n.email = u.nucleo_email and u.id = ?
    public static void main(String[] args) throws Exception {
        UADAO u = new UADAO();
        UA ua = u.obter(6);
        System.out.println(ua.getId());
        System.out.println(ua.getNome());
        System.out.println(ua.getCampus().getNome());
        System.out.println(ua.getNucleo().getEmail());
    }
}
