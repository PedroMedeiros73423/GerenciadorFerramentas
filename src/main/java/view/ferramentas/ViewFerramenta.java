package view.ferramentas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ferramentas;

public class ViewFerramenta extends javax.swing.JFrame {

   private void carregarDashboard() {
      // RESUMO DAS FERRAMENTAS
      Ferramentas ferramenta = new Ferramentas();
      Double[] resumoFerramentas = ferramenta.fazerResumo();
      somaQuantidade.setText(String.format("%.0f", resumoFerramentas[0]));
      somaValor.setText("R$ " + String.format("%.2f", resumoFerramentas[1]));
   }
   Ferramentas manipulado = new Ferramentas("", "", 0.0);

   public ViewFerramenta() {
      initComponents();

      // CARREGANDO A TABELA
      carregaTabela();
   }

   // METODO PARA CARREGAR OS DADOS NA TABELA
   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.JTTabelaFerramentas.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Ferramentas> todasFerramentas = manipulado.listarTodas();

      if (todasFerramentas.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há nenhuma ferramenta cadastrada");
      }

      // INSRINDO OS DADOS NA TABELA
      double soma = 0;
      int quantidade = 0;
      for (Ferramentas estaFerramenta : todasFerramentas) {
         modelo.addRow(new Object[]{
            estaFerramenta.getFerramentaId(),
            estaFerramenta.getFerramentaNome(),
            estaFerramenta.getFerramentaMarca(),
            estaFerramenta.getFerramentaValor()
         });
         soma += estaFerramenta.getFerramentaValor();
         quantidade += 1;
      }
      somaValor.setText("R$ " + String.format("%.2f", soma));
      somaQuantidade.setText(String.valueOf(quantidade));

      // LIMPANDO O FORMULÁRIO
      JTFNome.setText("");
      JTFMarca.setText("");
      JTFValor.setText("");

      // MANIPULANDO OS BOTÕES
      JBRegistrar.setEnabled(true);
      JBAtualizar.setEnabled(false);
      JBExcluir.setEnabled(false);

   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      jTable1 = new javax.swing.JTable();
      jLayeredPane1 = new javax.swing.JLayeredPane();
      jRadioButton1 = new javax.swing.JRadioButton();
      jPanel1 = new javax.swing.JPanel();
      jLabel4 = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      JTTabelaFerramentas = new javax.swing.JTable();
      JTFValor = new javax.swing.JTextField();
      JBAtualizar = new javax.swing.JButton();
      JBExcluir = new javax.swing.JButton();
      JBFechar = new javax.swing.JButton();
      JBRegistrar = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      JTFNome = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      JTFMarca = new javax.swing.JTextField();
      jLabel3 = new javax.swing.JLabel();
      JBLimpar = new javax.swing.JButton();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      somaValor = new javax.swing.JLabel();
      somaQuantidade = new javax.swing.JLabel();
      atualizarTabela = new javax.swing.JButton();

      jTable1.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ));
      jScrollPane1.setViewportView(jTable1);

      javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
      jLayeredPane1.setLayout(jLayeredPane1Layout);
      jLayeredPane1Layout.setHorizontalGroup(
         jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 100, Short.MAX_VALUE)
      );
      jLayeredPane1Layout.setVerticalGroup(
         jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 100, Short.MAX_VALUE)
      );

      jRadioButton1.setText("jRadioButton1");

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("FERRAMENTAS");

      jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
      jLabel4.setText("FERRAMENTA");

      JTTabelaFerramentas.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "ID", "Nome", "Marca", "Valor"
         }
      ));
      JTTabelaFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            JTTabelaFerramentasMouseClicked(evt);
         }
      });
      jScrollPane2.setViewportView(JTTabelaFerramentas);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(299, 299, 299)
            .addComponent(jLabel4)
            .addContainerGap(341, Short.MAX_VALUE))
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
               .addContainerGap()))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel4)
            .addContainerGap(192, Short.MAX_VALUE))
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
               .addContainerGap(65, Short.MAX_VALUE)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap()))
      );

      JBAtualizar.setText("Atualizar");
      JBAtualizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            JBAtualizarActionPerformed(evt);
         }
      });

      JBExcluir.setText("Excluir");
      JBExcluir.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            JBExcluirActionPerformed(evt);
         }
      });

      JBFechar.setText("Fechar");
      JBFechar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            JBFecharActionPerformed(evt);
         }
      });

      JBRegistrar.setText("Registrar");
      JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            JBRegistrarActionPerformed(evt);
         }
      });

      jLabel1.setText("Nome");

      jLabel2.setText("Marca");

      jLabel3.setText("Valor");

      JBLimpar.setText("Limpar");
      JBLimpar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            JBLimparActionPerformed(evt);
         }
      });

      jLabel5.setText("Valor total das ferramentas:");

      jLabel6.setText("Quantidade de ferramentas:");

      somaValor.setText("0");

      somaQuantidade.setText("0");

      atualizarTabela.setText("Atualizar Valores da tabela");
      atualizarTabela.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            atualizarTabelaActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
         .addGroup(layout.createSequentialGroup()
            .addGap(178, 178, 178)
            .addComponent(JBRegistrar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(JBAtualizar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(JBLimpar)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(JBExcluir)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(JBFechar)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jLabel3)
               .addComponent(jLabel2)
               .addComponent(jLabel1)
               .addComponent(JTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(JTFMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
               .addComponent(JTFNome))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(somaValor))
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(somaQuantidade)))
                  .addGap(48, 48, 48))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(atualizarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel5)
                     .addComponent(somaValor))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel6)
                     .addComponent(somaQuantidade))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(atualizarTabela)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(JTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(JBExcluir)
               .addComponent(JBFechar)
               .addComponent(JBRegistrar)
               .addComponent(JBAtualizar)
               .addComponent(JBLimpar))
            .addContainerGap(9, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
       this.dispose();
    }//GEN-LAST:event_JBFecharActionPerformed

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarActionPerformed
       // LENDO O VALOR, CASO ESTEJA VAZIO DEFINIR COMO ZERO
       Double valor = 0.0;
       String val = JTFValor.getText();
       if (val.length() > 0) {
          valor = Double.parseDouble(val);
       }

       // SALVANDO NO BANCO DE DADOS
       boolean result = manipulado.inserirFerramenta(JTFNome.getText(), JTFMarca.getText(), valor);

       // PÓS PROCESSAMENTO
       if (result == true) {
          // RECARREGAR TABELA
          carregaTabela();
          JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso");
       } else {
          JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a ferramenta no banco de dados");
       }
    }//GEN-LAST:event_JBRegistrarActionPerformed

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
       if (this.JTTabelaFerramentas.getSelectedRow() == -1) {
          JOptionPane.showMessageDialog(null, "É preciso escolher um para deletar primeiro");
       }
       if (this.JTTabelaFerramentas.getSelectedRow() != -1) {
          // CONFIRMAR DELEÇÃO
          Object[] options = {"Sim", "Não"};
          int seguir = JOptionPane.showOptionDialog(this, "Deseja mesmo excluir essa ferramenta?", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
          if (seguir != 0) {
             return;
          }

          // LENDO OS DADOS DA LINHA
          int id = Integer.parseInt(this.JTTabelaFerramentas.getValueAt(this.JTTabelaFerramentas.getSelectedRow(), 0).toString());

          // DELETANDO DO BANCO
          boolean result = manipulado.deletarFerramenta(id);
          if (result == true) {
             // RECARREGAR TABELA
             DefaultTableModel gf = (DefaultTableModel) JTTabelaFerramentas.getModel();
             gf.removeRow(JTTabelaFerramentas.getSelectedRow());
             JOptionPane.showMessageDialog(null, "Removido com sucesso!");

          } else {
             JOptionPane.showMessageDialog(null, "Erro ao deletar ferramenta");
          }
       }


    }//GEN-LAST:event_JBExcluirActionPerformed

    private void JBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAtualizarActionPerformed
       // LENDO O ID DA LINHA
       int id = Integer.parseInt(this.JTTabelaFerramentas.getValueAt(this.JTTabelaFerramentas.getSelectedRow(), 0).toString());

       // LENDO O VALOR, CASO ESTEJA VAZIO DEFINIR COMO ZERO
       Double valor = 0.0;
       String val = JTFValor.getText();
       if (val.length() > 0) {
          valor = Double.parseDouble(val);
       }

       // SALVANDO NO BANCO
       boolean result = manipulado.editarFerramenta(id, JTFNome.getText(), JTFMarca.getText(), valor);

       // PÓS PROCESSAMENTO
       if (result == true) {
          // RECARREGAR TABELA
          carregaTabela();
          JOptionPane.showMessageDialog(null, "Alterações de ferramenta salvas com sucesso");
       } else {
          JOptionPane.showMessageDialog(null, "Não foi possível salvar as alterações de ferramenta");
       }
    }//GEN-LAST:event_JBAtualizarActionPerformed

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
       // LIMPANDO O FORMULÁRIO 
       JTFNome.setText("");
       JTFMarca.setText("");
       JTFValor.setText("");

       // MANIPULANDO BOTÕES
       JBRegistrar.setEnabled(true);
       JBAtualizar.setEnabled(false);
       JBExcluir.setEnabled(false);
    }//GEN-LAST:event_JBLimparActionPerformed

    private void JTTabelaFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTTabelaFerramentasMouseClicked
       // SE TEM ALGUMA LINHA SELECIONADA
       if (this.JTTabelaFerramentas.getSelectedRow() != -1) {
          // LENDO OS DADOS DA LINHA
          String nome = this.JTTabelaFerramentas.getValueAt(this.JTTabelaFerramentas.getSelectedRow(), 1).toString();
          String marca = this.JTTabelaFerramentas.getValueAt(this.JTTabelaFerramentas.getSelectedRow(), 2).toString();
          String valor = this.JTTabelaFerramentas.getValueAt(this.JTTabelaFerramentas.getSelectedRow(), 3).toString();

          // PREENCHENDO O FORMULÁRIO
          JTFNome.setText(nome);
          JTFMarca.setText(marca);
          JTFValor.setText(valor);

          // MANIPULANDO BOTÕES
          JBRegistrar.setEnabled(false);
          JBAtualizar.setEnabled(true);
          JBExcluir.setEnabled(true);
       }
    }//GEN-LAST:event_JTTabelaFerramentasMouseClicked

    private void atualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaActionPerformed
       this.carregarDashboard();
    }//GEN-LAST:event_atualizarTabelaActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new ViewFerramenta().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton JBAtualizar;
   private javax.swing.JButton JBExcluir;
   private javax.swing.JButton JBFechar;
   private javax.swing.JButton JBLimpar;
   private javax.swing.JButton JBRegistrar;
   private javax.swing.JTextField JTFMarca;
   private javax.swing.JTextField JTFNome;
   private javax.swing.JTextField JTFValor;
   private javax.swing.JTable JTTabelaFerramentas;
   private javax.swing.JButton atualizarTabela;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLayeredPane jLayeredPane1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JRadioButton jRadioButton1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable jTable1;
   private javax.swing.JLabel somaQuantidade;
   private javax.swing.JLabel somaValor;
   // End of variables declaration//GEN-END:variables
}
