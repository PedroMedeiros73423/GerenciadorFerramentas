
package view.ferramentas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ferramentas;


public class Emprestadas extends javax.swing.JFrame {
    
    // CRIANDO UM OBJETO DE MANIPULAÇÃO
    Ferramentas manipulado = new Ferramentas("", "", 0.0);


    public Emprestadas() {
        initComponents();
        
        // CARREGANDO A TABELA
        this.carregaTabela();
    }
    
    // METODO PARA CARREGAR OS DADOS NA TABELA
    public void carregaTabela() {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaEmprestadas.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Ferramentas> todasEmprestadas = manipulado.listarEmprestadas();

      if (todasEmprestadas.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há ferramentas emprestadas");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Ferramentas estaFerramenta : todasEmprestadas) {
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
        tabelaEmprestadas = new javax.swing.JTable();
        botaoAtualizar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FERRAMENTAS EMPRESTADAS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Lista de Ferramentas Emprestadas");

        tabelaEmprestadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaEmprestadas);

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
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(botaoAtualizar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoVoltar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
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
            new Emprestadas().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEmprestadas;
    // End of variables declaration//GEN-END:variables
}
