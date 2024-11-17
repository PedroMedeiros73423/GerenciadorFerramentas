
package view.amigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigos;


public class Emprestados extends javax.swing.JFrame {

    
    // CRIANDO UM OBJETO DE MANIPULAÇÃO
   Amigos manipulado = new Amigos("", "", "", "");
   
    public Emprestados() {
        initComponents();
        
        // CARREGANDO A TABELA
      this.carregaTabela();
   }
    
        // METODO PARA CARREGAR OS DADOS NA TABELA
   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaEmprestados.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigos> emprestados = manipulado.listarEmprestados();

      if (emprestados.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há amigos com ferramentas emprestadas!");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Amigos esteAmigo : emprestados) {
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
      tabelaEmprestados = new javax.swing.JTable();
      botaoAtualizar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
      jLabel1.setText("Lista de amigos com empréstimos");

      tabelaEmprestados.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Nome", "Email", "Endereço", "Telefone"
         }
      ));
      jScrollPane1.setViewportView(tabelaEmprestados);

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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(16, 16, 16)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel1)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(283, 283, 283)
                  .addComponent(botaoAtualizar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(botaoVoltar)))
            .addContainerGap(18, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoAtualizar)
               .addComponent(botaoVoltar))
            .addGap(14, 14, 14))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        // RECARREGANDO A TABELA
        this.carregaTabela();
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

  
    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Emprestados().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoAtualizar;
   private javax.swing.JButton botaoVoltar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tabelaEmprestados;
   // End of variables declaration//GEN-END:variables
}
