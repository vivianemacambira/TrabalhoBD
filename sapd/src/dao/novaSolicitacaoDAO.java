package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class novaSolicitacaoDAO extends DAO {

    public void inserir(novaSolicitacao ns) throws Exception {
        Connection c = obterConexao();
        String sql = "INSERT INTO nova_solicitacao (titulo_obra, autor_obra, observacao, formato_acessivel, arquivo, pcd_matricula, "
                + "nucleo_email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, ns.getTitulo_obra());
        stmt.setString(2, ns.getAutor_obra());       
        stmt.setString(3, ns.getObservacao());
        /*COMBOBOX*/
        stmt.setString(4, ns.getFormato_acessivel());
        stmt.setString(5, ns.getArquivo());
        stmt.setInt(6, ns.getPcd().getMatricula());  
        stmt.setString(7, ns.getNucleo().getEmail());
        int resultado = stmt.executeUpdate();
        stmt.close();
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível inserir esta nova solicitação");
        }
    }
    public novaSolicitacao obter(String titulo_obra) throws Exception {
        novaSolicitacao NS = null;
        Connection c = obterConexao();
        String sql = "SELECT titulo_obra, autor_obra, observacao, formato_acessivel, arquivo, pcd_matricula, nucleo_email, id FROM nova_solicitacao WHERE titulo_obra = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, titulo_obra);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            NS = new novaSolicitacao(); 
            NS.setID(rs.getInt("id"));
            NS.setTitulo_obra(rs.getString("titulo_obra"));
            NS.setAutor_obra(rs.getString("autor_obra"));
            NS.setObservacao(rs.getString("observacao"));
            NS.setFormato_acessivel(rs.getString("formato_acessivel"));
            NS.setArquivo(rs.getString("arquivo"));
            PCDDAO PCDdao = new PCDDAO();
            NS.setPcd(PCDdao.obter(rs.getInt("pcd_matricula"))); //aqui é aquela implementação pra pôr o objeto
            NucleoDAO Nucledao = new NucleoDAO();
            NS.setNucleo(Nucledao.obter(rs.getString("nucleo_email")));
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (NS == null) {
            throw new Exception("Não foi possível localizar esta solicitação");
        }
        return NS;
    }
}
