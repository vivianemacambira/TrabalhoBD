/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import dao.novaSolicitacao;
import dao.novaSolicitacaoDAO;
import dao.solicitacao;
import dao.solicitacaoDAO;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author leoomoreira
 */
public class NovaSolicitacao extends javax.swing.JFrame {
    private File selectedFile;
    private TelaPrincipal login;
    String[] dados = {"PDF/A","Material ampliado"};
    public static novaSolicitacao ns = new novaSolicitacao();
    public static novaSolicitacao testarNS = new novaSolicitacao();
    novaSolicitacaoDAO nsdao = new novaSolicitacaoDAO();

    public NovaSolicitacao() {
        initComponents();
        setLocationRelativeTo(null);
        comboFormatoAcessivel.removeAllItems();
        for(int i = 0; i <dados.length; i++) {
            comboFormatoAcessivel.addItem(dados[i]);
        }
        this.login = new TelaPrincipal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rotuloCodigo = new javax.swing.JLabel();
        rotuloNome = new javax.swing.JLabel();
        rotuloLogin = new javax.swing.JLabel();
        textoTituloObra = new javax.swing.JTextField();
        textoAutorObra = new javax.swing.JTextField();
        textoObservacoes = new javax.swing.JTextField();
        botaoEnviar = new javax.swing.JButton();
        rotuloLogin1 = new javax.swing.JLabel();
        comboFormatoAcessivel = new javax.swing.JComboBox();
        tituloNovaSolicitacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botaoEscolherArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir Pessoa");
        setName("dialogInserirPessoa"); // NOI18N

        rotuloCodigo.setText("Título da Obra:");

        rotuloNome.setText("Autor da Obra:");

        rotuloLogin.setText("Observações:");

        textoObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoObservacoesActionPerformed(evt);
            }
        });

        botaoEnviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoEnviar.setText("Enviar");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });

        rotuloLogin1.setText("Formato Acessível Desejado:");

        comboFormatoAcessivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFormatoAcessivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFormatoAcessivelActionPerformed(evt);
            }
        });

        tituloNovaSolicitacao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tituloNovaSolicitacao.setText("Nova Solicitação");

        jLabel1.setText("Material a ser editado:");

        botaoEscolherArquivo.setText("Escolher arquivo");
        botaoEscolherArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEscolherArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textoTituloObra))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textoAutorObra))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotuloLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textoObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rotuloLogin1)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboFormatoAcessivel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botaoEscolherArquivo))))
                    .addComponent(tituloNovaSolicitacao, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloNovaSolicitacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloCodigo)
                    .addComponent(textoTituloObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloNome)
                    .addComponent(textoAutorObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloLogin)
                    .addComponent(textoObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloLogin1)
                    .addComponent(comboFormatoAcessivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEscolherArquivo)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        textoTituloObra.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente enviar essa solicitação?", "Nova Solicitação", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                ns.setTitulo_obra(textoTituloObra.getText());
                ns.setAutor_obra(textoAutorObra.getText());
                ns.setObservacao(textoObservacoes.getText());
                String fa = dados[(comboFormatoAcessivel.getSelectedIndex())];
                ns.setFormato_acessivel (fa);
                ns.setArquivo(selectedFile.getAbsolutePath());
                ns.setPcd(TelaPrincipal.pd2);
                ns.setNucleo(TelaPrincipal.novoNucleo);
                nsdao.inserir(ns);
                JOptionPane.showMessageDialog(this, "Solicitação enviada com sucesso", "Nova Solicitação", JOptionPane.INFORMATION_MESSAGE);
                new OpcoesSistema().setVisible(true);
                this.dispose();                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Houve um erro", "Nova Solicitação", JOptionPane.ERROR_MESSAGE);
            }
        }
        try{
            testarNS = nsdao.obter(ns.getTitulo_obra());
            System.out.println(testarNS.getId());
            solicitacao testeSolicitacao = new solicitacao();
            testeSolicitacao.setNova_solicitacao(testarNS);
            testeSolicitacao.setArquivo("Não disponível");
            testeSolicitacao.setStatus("Recebido");
            testeSolicitacao.setData_prevista("Não disponível");
            solicitacaoDAO solicitacaoDAO = new solicitacaoDAO();
            solicitacaoDAO.inserir(testeSolicitacao);          
        } catch (Exception ex) {
            Logger.getLogger(NovaSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Solicitação não inserida", "Nova Solicitação", JOptionPane.ERROR_MESSAGE);
        } 
        botaoEnviar.transferFocus();
        
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void comboFormatoAcessivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFormatoAcessivelActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboFormatoAcessivelActionPerformed

    private void textoObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoObservacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoObservacoesActionPerformed

    private void botaoEscolherArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEscolherArquivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }
    }//GEN-LAST:event_botaoEscolherArquivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoEscolherArquivo;
    private javax.swing.JComboBox comboFormatoAcessivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel rotuloCodigo;
    private javax.swing.JLabel rotuloLogin;
    private javax.swing.JLabel rotuloLogin1;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JTextField textoAutorObra;
    private javax.swing.JTextField textoObservacoes;
    private javax.swing.JTextField textoTituloObra;
    private javax.swing.JLabel tituloNovaSolicitacao;
    // End of variables declaration//GEN-END:variables
}
