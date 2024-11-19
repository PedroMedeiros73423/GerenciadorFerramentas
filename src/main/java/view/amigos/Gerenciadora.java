package view.amigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigos;

public class Gerenciadora extends javax.swing.JFrame {

   Amigos manipulado = new Amigos("", "", "", "");

   public Gerenciadora() {
      initComponents();

      // CARREGANDO A TABELA
      carregaTabela();
   }

   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.JTTabelaAmigos.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigos> todasAmigoses = manipulado.listarTodos();

      if (todasAmigoses.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há nenhum amigo cadastrado");
      }

      for (Amigos esteAmigos : todasAmigoses) {
         modelo.addRow(new Object[]{
            esteAmigos.getAmigoId(),
            esteAmigos.getAmigoNome(),
            esteAmigos.getAmigoEmail(),
            esteAmigos.getAmigoEndereco(),
            esteAmigos.getAmigoTelefone()
         });

         // LIMPANDO O FORMULÁRIO
         JTFNomeAmigo.setText("");
         JTFEndereco.setText("");
         JTFEmail.setText("");
         JTFTelefone.setText("");

         // MANIPULANDO OS BOTÕES
         JBRegistrar.setEnabled(true);
         JBAtualizar.setEnabled(false);
         JBExcluir.setEnabled(false);
      }
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        atualizarTabela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTTabelaAmigos = new javax.swing.JTable();
        JBFechar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBAtualizar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();
        JBRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JTFEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFNomeAmigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel6.setText("Quantidade de ferramentas:");

        atualizarTabela.setText("Atualizar Valores da tabela");
        atualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AMIGOS");

        JTTabelaAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereço", "E-mail", "Telefone"
            }
        ));
        JTTabelaAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTTabelaAmigosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTTabelaAmigos);

        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

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

        JBRegistrar.setText("Registrar");
        JBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Endereço");

        JTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFEmailActionPerformed(evt);
            }
        });

        jLabel4.setText("E-mail");

        jLabel5.setText("Telefone");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Gerenciar Amigos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 337, Short.MAX_VALUE)
                .addComponent(JBRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBFechar)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(JTFEmail)
                            .addComponent(JTFEndereco)
                            .addComponent(JTFNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBFechar)
                    .addComponent(JBExcluir)
                    .addComponent(JBRegistrar)
                    .addComponent(JBAtualizar)
                    .addComponent(JBLimpar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTTabelaAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTTabelaAmigosMouseClicked
       // SE TEM ALGUMA LINHA SELECIONADA
       if (this.JTTabelaAmigos.getSelectedRow() != -1) {
          // LENDO OS DADOS DA LINHA
          String nome = this.JTTabelaAmigos.getValueAt(this.JTTabelaAmigos.getSelectedRow(), 1).toString();
          String endereco = this.JTTabelaAmigos.getValueAt(this.JTTabelaAmigos.getSelectedRow(), 2).toString();
          String email = this.JTTabelaAmigos.getValueAt(this.JTTabelaAmigos.getSelectedRow(), 3).toString();
          String telefone = this.JTTabelaAmigos.getValueAt(this.JTTabelaAmigos.getSelectedRow(), 4).toString();
          // PREENCHENDO O FORMULÁRIO
          JTFNomeAmigo.setText(nome);
          JTFEndereco.setText(endereco);
          JTFEmail.setText(email);
          JTFTelefone.setText(telefone);

          // MANIPULANDO BOTÕES
          JBRegistrar.setEnabled(false);
          JBAtualizar.setEnabled(true);
          JBExcluir.setEnabled(true);
       }
    }//GEN-LAST:event_JTTabelaAmigosMouseClicked

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
       this.dispose();
    }//GEN-LAST:event_JBFecharActionPerformed

    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
       // LIMPANDO O FORMULÁRIO 
       JTFNomeAmigo.setText("");
       JTFEndereco.setText("");
       JTFEmail.setText("");
       JTFTelefone.setText("");

       // MANIPULANDO OS BOTÕES
       JBRegistrar.setEnabled(true);
       JBAtualizar.setEnabled(false);
       JBExcluir.setEnabled(false);

    }//GEN-LAST:event_JBLimparActionPerformed

    private void JBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAtualizarActionPerformed
       // LENDO O ID DA LINHA
       int id = Integer.parseInt(this.JTTabelaAmigos.getValueAt(this.JTTabelaAmigos.getSelectedRow(), 0).toString());

       // SALVANDO NO BANCO
       boolean result = manipulado.editarAmigo(id, JTFNomeAmigo.getText(), JTFEndereco.getText(), JTFEmail.getText(), JTFTelefone.getText());

       // PÓS PROCESSAMENTO
       if (result == true) {
          // RECARREGAR TABELA
          carregaTabela();
          JOptionPane.showMessageDialog(null, "Alterações de amigo salvas com sucesso");
       } else {
          JOptionPane.showMessageDialog(null, "Não foi possível salvar as alterações de amigo");
       }
    }//GEN-LAST:event_JBAtualizarActionPerformed

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed
       if (this.JTTabelaAmigos.getSelectedRow() == -1) {
          JOptionPane.showMessageDialog(null, "É preciso escolher um para deletar primeiro");
       }
       if (this.JTTabelaAmigos.getSelectedRow() != -1) {
          // CONFIRMAR DELEÇÃO
          Object[] options = {"Sim", "Não"};
          int seguir = JOptionPane.showOptionDialog(this, "Deseja mesmo excluir esse amigo?", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
          if (seguir != 0) {
             return;
          }

          // LENDO OS DADOS DA LINHA
          int id = Integer.parseInt(this.JTTabelaAmigos.getValueAt(this.JTTabelaAmigos.getSelectedRow(), 0).toString());

          // DELETANDO DO BANCO
          boolean result = manipulado.deletarAmigo(id);
          if (result == true) {
             // RECARREGAR TABELA
             DefaultTableModel gf = (DefaultTableModel) JTTabelaAmigos.getModel();
             gf.removeRow(JTTabelaAmigos.getSelectedRow());
             JOptionPane.showMessageDialog(null, "Removido com sucesso!");

          } else {
             JOptionPane.showMessageDialog(null, "Erro ao deletar amigo");
          }
       }

    }//GEN-LAST:event_JBExcluirActionPerformed

    private void JBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarActionPerformed
       // SALVANDO NO BANCO DE DADOS
       boolean result = manipulado.inserirAmigo(JTFNomeAmigo.getText(), JTFEndereco.getText(), JTFEmail.getText(), JTFTelefone.getText());

       // PÓS PROCESSAMENTO
       if (result == true) {
          // RECARREGAR TABELA
          carregaTabela();
          JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso");
       } else {
          JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o amigo no banco de dados");
       }

    }//GEN-LAST:event_JBRegistrarActionPerformed

    private void atualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaActionPerformed

    }//GEN-LAST:event_atualizarTabelaActionPerformed

    private void JTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFEmailActionPerformed

    }//GEN-LAST:event_JTFEmailActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Gerenciadora().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAtualizar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JButton JBFechar;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JButton JBRegistrar;
    private javax.swing.JTextField JTFEmail;
    private javax.swing.JTextField JTFEndereco;
    private javax.swing.JTextField JTFNomeAmigo;
    private javax.swing.JTextField JTFTelefone;
    private javax.swing.JTable JTTabelaAmigos;
    private javax.swing.JButton atualizarTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
