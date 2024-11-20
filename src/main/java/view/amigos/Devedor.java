package view.amigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigo;

public class Devedor extends javax.swing.JFrame {

   // CRIANDO UM OBJETO DE MANIPULAÇÃO
   Amigo manipulado = new Amigo("", "", "", "");

   public Devedor() {
      initComponents();

      // CARREGANDO A TABELA
      this.carregaTabela();
   }
   // METODO PARA CARREGAR OS DADOS NA TABELA

   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaDevedores.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigo> devedores = manipulado.listarDevedores();

      if (devedores.size() == 0) {
         JOptionPane.showMessageDialog(null, "BOA NOTÍCIA!\nNão há amigos devendo ferramentas emprestadas!");
      }

      // INSERINDO OS DADOS NA TABELA
      for (Amigo esteAmigo : devedores) {
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

      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tabelaDevedores = new javax.swing.JTable();
      botaoAtualizar = new javax.swing.JButton();
      botãoVoltar = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
      jLabel1.setText("Lista de amigos devedores");

      tabelaDevedores.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Nome", "Email", "Endereço", "Telefone"
         }
      ));
      jScrollPane1.setViewportView(tabelaDevedores);

      botaoAtualizar.setText("Atualizar");
      botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAtualizarActionPerformed(evt);
         }
      });

      botãoVoltar.setText("Voltar");
      botãoVoltar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botãoVoltarActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(291, 291, 291)
                  .addComponent(botaoAtualizar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(botãoVoltar)))
            .addContainerGap(28, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(14, 14, 14)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoAtualizar)
               .addComponent(botãoVoltar))
            .addGap(18, 18, 18))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
       // RECARREGANDO A TABELA
       this.carregaTabela();
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botãoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botãoVoltarActionPerformed
       this.dispose();
    }//GEN-LAST:event_botãoVoltarActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Devedor().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoAtualizar;
   private javax.swing.JButton botãoVoltar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tabelaDevedores;
   // End of variables declaration//GEN-END:variables
}
