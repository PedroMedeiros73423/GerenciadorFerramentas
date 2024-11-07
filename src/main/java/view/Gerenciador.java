/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigos;
import model.Ferramentas;
import model.Negocios;

/**
 *
 * @author Pedro
 */
class Item
    {
        private int id;
        private String description;
 
        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }
 
        public int getId()
        {
            return id;
        }
 
        public String getDescription()
        {
            return description;
        }
 
        public String toString()
        {
            return description;
        }
    }
public class Gerenciador extends javax.swing.JFrame {
    
   // CRIANDO UM OBJETO DE MANIPULAÇÃO
   Negocios manipulado = new Negocios();
   Ferramentas disponiveis = new Ferramentas();
   Amigos meusAmigos = new Amigos();
   
   SimpleDateFormat dataSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   public Gerenciador() {
      initComponents();

      // CARREGANDO A TABELA
      carregaTabela();

      // CARREGANDO A LISTA DE FERRAMENTAS DISPONÍVEIS
      carregarFerramentas();

      // CARREGANDO A LISTA DE AMIGOS
      carregarAmigos();
      
      // DEFINIR O TEMPO PADRÃO DE EMPRÉSTIMO
      tempoEmprestimo();
   }
   // METODO PARA CARREGAR OS DADOS NA TABELA
   public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaNegocios.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Negocios> todosNegocios = manipulado.listarTodos();

      if (todosNegocios.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há empréstimos registrados");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Negocios esteNegocio : todosNegocios) {
         modelo.addRow(new Object[]{
            esteNegocio.getNegocioId(),
            esteNegocio.getNegocioFerramentaId(),
            esteNegocio.getNegocioAmigoId(),
            esteNegocio.getNegocioInicio(),
            esteNegocio.getNegocioFim(),
            esteNegocio.getNegocioFinal()
         });
      }

      // LIMPANDO O FORMULÁRIO
      negocioFerramentaId.setSelectedIndex(0);
      negocioAmigoId.setSelectedIndex(0);
      negocioFim.setText("0000-00-00 00:00:00");

      // MANIPULANDO OS BOTÕES
      botaoCadastrar.setEnabled(true);
      botaoDevolver.setEnabled(false);
      botaoFinalizar.setEnabled(false);
      botaoSalvar.setEnabled(false);
      botaoDeletar.setEnabled(false);

   }
   
   // METODO PAR ACARREGAR A LISTA DE FERRAMENTAS DISPONÍVEIS
   public void carregarFerramentas() {
      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Ferramentas> todasDisponiveis = disponiveis.listarDisponiveis();

      // INSRINDO OS DADOS NA TABELA
      for (Ferramentas estaFerramenta : todasDisponiveis) {
           negocioFerramentaId.addItem(estaFerramenta.getFerramentaNome());
//         negocioFerramentaId.insertItemAt(estaFerramenta.getFerramentaNome(), estaFerramenta.getFerramentaId());

      }
   }
   
   // METODO PAR CARREGAR A LISTA DE AMIGOS
   public void carregarAmigos() {
      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigos> listaAmigos = meusAmigos.listarTodos();

      // INSRINDO OS DADOS NA TABELA
      for (Amigos esteAmigo : listaAmigos) {
         negocioAmigoId.addItem(esteAmigo.getAmigoNome());
      }
   }
   // METODO PARA DEFINIR UM TEMPO PADRÃO PARA OS EMPRÉSTIMOS
   public void tempoEmprestimo() {
      // PEGANDO DA DATA ATUAL
      String ini = dataSql.format(new Date());
      
      // ADICIONANDO 15 DIAS
      String fim = dataSql.format(new Date().getTime() + (1000 * 60 * 60 * 24 * 15));
      
      // PREENCHENDO O FORMULÁRIO
      negocioFim.setText(fim);

   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaNegocios = new javax.swing.JTable();
        botaoCadastrar = new javax.swing.JButton();
        botaoFinalizar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoDevolver = new javax.swing.JButton();
        botaoDeletar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        negocioFerramentaId = new javax.swing.JComboBox<>();
        negocioAmigoId = new javax.swing.JComboBox<>();
        negocioFim = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setText("Gerenciar empréstimos");

        tabelaNegocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Amigo", "Início", "Fim", "Término"
            }
        ));
        jScrollPane1.setViewportView(tabelaNegocios);

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoFinalizar.setText("Finalizar");

        botaoSalvar.setText("Salvar");

        botaoDevolver.setText("Devolver");

        botaoDeletar.setText("Deletar");

        botaoLimpar.setText("Limpar");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ferramenta");

        jLabel3.setText("Amigo");

        jLabel5.setText("Até");

        negocioFerramentaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a ferramenta" }));

        negocioAmigoId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o amigo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(negocioFerramentaId, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(negocioAmigoId, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(negocioFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(botaoCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoDevolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoFinalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoVoltar)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(negocioFerramentaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(negocioAmigoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(negocioFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoFinalizar)
                    .addComponent(botaoDevolver)
                    .addComponent(botaoDeletar)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoVoltar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        System.out.println(negocioFerramentaId.getSelectedIndex());
        System.out.println(negocioAmigoId.getSelectedIndex());
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerenciador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JButton botaoDevolver;
    private javax.swing.JButton botaoFinalizar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> negocioAmigoId;
    private javax.swing.JComboBox<String> negocioFerramentaId;
    private javax.swing.JTextField negocioFim;
    private javax.swing.JTable tabelaNegocios;
    // End of variables declaration//GEN-END:variables
}
