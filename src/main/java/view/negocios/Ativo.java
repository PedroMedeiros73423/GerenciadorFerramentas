package view.negocios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Negocio;

public class Ativo extends javax.swing.JFrame {

   // CRIANDO OBJETOS DE MANIPULAÇÃO
   Negocio manipulado = new Negocio();

   public Ativo() {
      initComponents();

      // CARREGANDO A TABELA
      this.carregaTabela();
   }

   // METODO PARA CARREGAR OS DADOS NA TABELA
   private void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaEmprestimosAtuais.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Negocio> atuais = manipulado.listarNegociosAtivos();

      if (atuais.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não empréstimos no momento");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Negocio esteNegocio : atuais) {
         modelo.addRow(new Object[]{
            esteNegocio.getNegocioId(),
            esteNegocio.getNegocioFerramentaNome(),
            esteNegocio.getNegocioAmigoNome(),
            esteNegocio.getNegocioInicio(),
            esteNegocio.getNegocioFim(),
            esteNegocio.getNegocioFinal()
         });
      }
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tabelaEmprestimosAtuais = new javax.swing.JTable();
      botaoAtualizar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Lista de empréstios ativos");

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
      jLabel1.setText("Lista de empréstimos ativos");

      tabelaEmprestimosAtuais.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Ferramenta", "Amigo", "Início", "Fim", "Término"
         }
      ));
      jScrollPane1.setViewportView(tabelaEmprestimosAtuais);
      if (tabelaEmprestimosAtuais.getColumnModel().getColumnCount() > 0) {
         tabelaEmprestimosAtuais.getColumnModel().getColumn(0).setMaxWidth(30);
      }

      botaoAtualizar.setText("Atualizar");
      botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAtualizarActionPerformed(evt);
         }
      });

      botaoVoltar.setText("Voltar");
      botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoVoltarActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE))
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addGap(304, 304, 304)
            .addComponent(botaoAtualizar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(botaoVoltar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoAtualizar)
               .addComponent(botaoVoltar))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
      this.dispose();
   }//GEN-LAST:event_botaoVoltarActionPerformed

   private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
      // RECARREGANDO A TABELA
      this.carregaTabela();
   }//GEN-LAST:event_botaoAtualizarActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Ativo().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoAtualizar;
   private javax.swing.JButton botaoVoltar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tabelaEmprestimosAtuais;
   // End of variables declaration//GEN-END:variables
}
