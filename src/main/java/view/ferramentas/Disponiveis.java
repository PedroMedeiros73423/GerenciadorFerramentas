
package view.ferramentas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ferramentas;


public class Disponiveis extends javax.swing.JFrame {
    
    // CRIANDO UM OBJETO DE MANIPULAÇÃO
   Ferramentas manipulado = new Ferramentas("", "", 0.0);


    public Disponiveis() {
        initComponents();
        
        // CARREGANDO A TABELA
        this.carregaTabela();
    }
    
    // METODO PARA CARREGAR OS DADOS NA TABELA
    public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaDisponiveis.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Ferramentas> todasDisponiveis = manipulado.listarDisponiveis();

      if (todasDisponiveis.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há ferramentas disponível para emprestar");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Ferramentas estaFerramenta : todasDisponiveis) {
         modelo.addRow(new Object[]{
            estaFerramenta.getFerramentaId(),
            estaFerramenta.getFerramentaNome(),
            estaFerramenta.getFerramentaMarca(),
            estaFerramenta.getFerramentaValor()
         });
      }
   }


    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tabelaDisponiveis = new javax.swing.JTable();
      botaoAtualizar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("FERRAMENTAS DISPONÍVEIS");

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
      jLabel1.setText("Lista de Ferramentas Disponíveis");

      tabelaDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Nome", "Marca", "Valor"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }
      });
      jScrollPane1.setViewportView(tabelaDisponiveis);

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
                  .addGap(31, 31, 31)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addGap(17, 17, 17)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(263, 263, 263)
                  .addComponent(botaoAtualizar)
                  .addGap(26, 26, 26)
                  .addComponent(botaoVoltar)))
            .addContainerGap(17, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoAtualizar)
               .addComponent(botaoVoltar))
            .addContainerGap())
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
            new Disponiveis().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoAtualizar;
   private javax.swing.JButton botaoVoltar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tabelaDisponiveis;
   // End of variables declaration//GEN-END:variables
}
