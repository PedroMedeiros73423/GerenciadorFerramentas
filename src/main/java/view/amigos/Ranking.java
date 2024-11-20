package view.amigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigo;

public class Ranking extends javax.swing.JFrame {

   // CRIANDO UM OBJETO DE MANIPULAÇÃO
   Amigo manipulado = new Amigo();

   public Ranking() {
      initComponents();

      // CARREGANDO A TABELA
      this.carregaTabela();
   }

   // METODO PARA CARREGAR OS DADOS NA TABELA
   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaAmigosRanking.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigo> ranking = manipulado.getRanking();

      if (ranking.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há dados suficientes para formar o ranking");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Amigo esteAmigo : ranking) {
         modelo.addRow(new Object[]{
            esteAmigo.getAmigoId(),
            esteAmigo.getAmigoNome(),
            esteAmigo.getAmigoEmail(),
            esteAmigo.getAmigoEndereco(),
            esteAmigo.getAmigoTelefone()
         });
      }
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      tabelaAmigosRanking = new javax.swing.JTable();
      botaoAtualizar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("RANKING");

      tabelaAmigosRanking.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Empréstimos", "Nome", "Email", "Endereço", "Telefone"
         }
      ));
      jScrollPane1.setViewportView(tabelaAmigosRanking);

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

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
      jLabel1.setText("Ranking de empréstimos");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addGap(0, 227, Short.MAX_VALUE))
               .addComponent(jScrollPane1))
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addGap(301, 301, 301)
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoAtualizar)
               .addComponent(botaoVoltar))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
       // RECARREGAR A TABELA
       this.carregaTabela();
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
       this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Ranking().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoAtualizar;
   private javax.swing.JButton botaoVoltar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tabelaAmigosRanking;
   // End of variables declaration//GEN-END:variables
}
