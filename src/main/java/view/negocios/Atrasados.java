package view.negocios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Negocios;

public class Atrasados extends javax.swing.JFrame {

   // CRIANDO OBJETOS DE MANIPULAÇÃO
   Negocios manipulado = new Negocios();

   public Atrasados() {
      initComponents();

      // CARREGANDO A TABELA
      this.carregaTabela();
   }

   // METODO PARA CARREGAR OS DADOS NA TABELA
   private void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tablelaEmpresimosAtrasados.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Negocios> atrasados = manipulado.listarNegociosAtrasados();

      if (atrasados.size() == 0) {
         JOptionPane.showMessageDialog(null, "Boa notícia!!!\nNão há empréstimos atrasados");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Negocios esteNegocio : atrasados) {
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
      tablelaEmpresimosAtrasados = new javax.swing.JTable();
      botaoAtualizar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Lista de empréstimos não devolvidos");

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
      jLabel1.setText("Lista de empréstimos não devolvidos");

      tablelaEmpresimosAtrasados.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Ferramenta", "Amigo", "Início", "Fim", "Término"
         }
      ));
      jScrollPane1.setViewportView(tablelaEmpresimosAtrasados);
      if (tablelaEmpresimosAtrasados.getColumnModel().getColumnCount() > 0) {
         tablelaEmpresimosAtrasados.getColumnModel().getColumn(0).setMaxWidth(30);
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
                  .addGap(0, 213, Short.MAX_VALUE))
               .addComponent(jScrollPane1))
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addGap(267, 267, 267)
            .addComponent(botaoAtualizar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(botaoVoltar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            new Atrasados().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoAtualizar;
   private javax.swing.JButton botaoVoltar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tablelaEmpresimosAtrasados;
   // End of variables declaration//GEN-END:variables
}
