
package view.amigos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigos;

public class Gerenciador extends javax.swing.JFrame {

    // CRIANDO UM OBJETO DE MANIPULAÇÃO
   Amigos manipulado = new Amigos("", "", "", "");
    
    public Gerenciador() {
        initComponents();
        
        // CARREGANDO A TABELA
      this.carregaTabela();
    }
    
    // METODO PARA CARREGAR OS DADOS NA TABELA
   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) tabelaAmigos.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigos> todosAmigos = manipulado.listarTodos();

      if (todosAmigos.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há amigos cadastrados");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Amigos esteAmigo : todosAmigos) {
         modelo.addRow(new Object[]{
            esteAmigo.getAmigoId(),
            esteAmigo.getAmigoNome(),
            esteAmigo.getAmigoEmail(),
            esteAmigo.getAmigoEndereco(),
            esteAmigo.getAmigoTelefone()
         });
      }

      // LIMPANDO O FORMULÁRIO
      amigoNome.setText("");
      amigoEmail.setText("");
      amigoEndereco.setText("");
      amigoTelefone.setText("");

      // MANIPULANDO OS BOTÕES
      botaoCadastrar.setEnabled(true);
      botaoSalvar.setEnabled(false);
      botaoDeletar.setEnabled(false);
   }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amigoTelefone = new javax.swing.JTextField();
        botaoCadastrar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoDeletar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAmigos = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amigoEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amigoNome = new javax.swing.JTextField();
        amigoEndereco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GERENCIADOR AMIGOS");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Gerenciar Amigos");

        botaoDeletar.setText("Deletar");
        botaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeletarActionPerformed(evt);
            }
        });

        tabelaAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Endereço", "Telefone"
            }
        ));
        tabelaAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAmigos);

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel5.setText("Email");

        jLabel3.setText("Endereço");

        jLabel4.setText("Telefone");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addContainerGap(745, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(amigoTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amigoEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amigoEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                            .addComponent(amigoNome, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 127, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVoltar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amigoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amigoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amigoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amigoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoDeletar)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoLimpar))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        // SALVANDO NO BANCO
        boolean result = manipulado.inserirAmigo(amigoNome.getText(), amigoEmail.getText(), amigoEndereco.getText(), amigoTelefone.getText());
        if (result == true) {
            // RECARREGAR TABELA
            this.carregaTabela();
            // JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o amigo no banco de dados");
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // SE TEM ALGUMA LINHA SELECIONADA
        if (this.tabelaAmigos.getSelectedRow() != -1) {
            // LENDO O ID DA LINHA
            int id = Integer.parseInt(this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 0).toString());

            // SALVANDO NO BANCO
            boolean result = manipulado.editarAmigo(id, amigoNome.getText(), amigoEmail.getText(), amigoEndereco.getText(), amigoTelefone.getText());
            if (result == true) {
                // RECARREGAR TABELA
                this.carregaTabela();
                // JOptionPane.showMessageDialog(null, "Alterações de amigo salvas com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível as alterações de amigo");
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarActionPerformed
        // SE TEM ALGUMA LINHA SELECIONADA
        if (this.tabelaAmigos.getSelectedRow() != -1) {
            // CONFIRMAR DELEÇÃO
            Object[] options = {"Sim", "Não"};
            int seguir = JOptionPane.showOptionDialog(this, "Deseja mesmo excluir esse amigo?", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
            if (seguir != 0) {
                return;
            }

            // LENDO OS DADOS DA LINHA
            int id = Integer.parseInt(this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 0).toString());

            // VERIFICAR SE A FERRAMENTA AINDA ESTÁ EMPRESTADA
            int emprestimos = manipulado.temEmprestimos(id);
            if (emprestimos > 0) {
                JOptionPane.showMessageDialog(null, "Não é possível excluir o amigo.\n\nEle possui : " + emprestimos + " registros de empréstimo.\nExclua todos os registros de empréstimos referentes a este amigo antes de deletar");
                return;
            }

            // DELETANDO DO BANCO
            boolean result = manipulado.deletarAmigo(id);

            // PÓS PROCESSAMENTO
            if (result == true) {
                // RECARREGAR TABELA
                this.carregaTabela();
                JOptionPane.showMessageDialog(null, "Amigo deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao deletar amigo");
            }
        }
    }//GEN-LAST:event_botaoDeletarActionPerformed

    private void tabelaAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAmigosMouseClicked
        // SE TEM ALGUMA LINHA SELECIONADA
        if (this.tabelaAmigos.getSelectedRow() != -1) {
            // LENDO OS DADOS DA LINHA
            String nome = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 1).toString();
            String email = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 2).toString();
            String endereco = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 3).toString();
            String telefone = this.tabelaAmigos.getValueAt(this.tabelaAmigos.getSelectedRow(), 4).toString();

            // PREENCHENDO O FORMULÁRIO
            amigoNome.setText(nome);
            amigoEmail.setText(email);
            amigoEndereco.setText(endereco);
            amigoTelefone.setText(telefone);

            // MANIPULANDO BOTÕES
            botaoCadastrar.setEnabled(false);
            botaoSalvar.setEnabled(true);
            botaoDeletar.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaAmigosMouseClicked

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        // LIMPANDO O FORMULÁRIO
        amigoNome.setText("");
        amigoEmail.setText("");
        amigoEndereco.setText("");
        amigoTelefone.setText("");

        // MANIPULANDO OS BOTÕES
        botaoCadastrar.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoDeletar.setEnabled(false);
    }//GEN-LAST:event_botaoLimparActionPerformed


    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Gerenciador().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amigoEmail;
    private javax.swing.JTextField amigoEndereco;
    private javax.swing.JTextField amigoNome;
    private javax.swing.JTextField amigoTelefone;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAmigos;
    // End of variables declaration//GEN-END:variables
}
