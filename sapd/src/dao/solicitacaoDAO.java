package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        
    public solicitacao obter(int idNS) throws Exception {
        solicitacao sol = null;
        Connection c = obterConexao();
        String sql = "SELECT data_prevista, status, arquivo FROM solicitacao WHERE nova_solicitacao_id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, idNS);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            sol = new solicitacao();
            sol.setData_prevista(rs.getString("data_prevista"));
            sol.setStatus(rs.getString("status"));
            sol.setArquivo(rs.getString("arquivo"));
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (sol == null) {
            throw new Exception("Não foi possível localizar este Campus");
        }
        return sol;
    }  

    public List<solicitacao> obterTodos(int idPCD) throws Exception {
        List<solicitacao> solicitacoesPCD = new ArrayList<solicitacao>();
        solicitacao S = null;
        Connection c = obterConexao();
        String sql = "SELECT DISTINCT nova_solicitacao.titulo_obra, nova_solicitacao.autor_obra, solicitacao.status, \n" +
        "solicitacao.data_prevista, solicitacao.arquivo FROM nova_solicitacao, solicitacao, PCD\n" +
        "WHERE nova_solicitacao.pcd_matricula = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, idPCD);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            S = new solicitacao();
            novaSolicitacaoDAO NSDAO = new novaSolicitacaoDAO();
            String nomeTituloObra = rs.getString("titulo_obra");
            novaSolicitacao NS = NSDAO.obter(nomeTituloObra);
            S.setNova_solicitacao(NS);
            S.setAutor_obra(NS.getAutor_obra());
            S.setStatus(rs.getString("status"));
            S.setData_prevista(rs.getString("data_prevista"));
            S.setArquivo(rs.getString("arquivo"));
            solicitacoesPCD.add(S);
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        return solicitacoesPCD;
    }
}
