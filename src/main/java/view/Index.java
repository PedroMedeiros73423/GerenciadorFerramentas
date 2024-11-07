package view;

import model.Amigos;
import model.Ferramentas;

public class Index extends javax.swing.JFrame {

   // FUNÇÃO PARA CARREGAR O DASHBOARD
   private void carregarDashboard() {
      // RESUMO DAS FERRAMENTAS
//      Ferramentas ferramenta = new Ferramentas();
//      Double[] resumoFerramentas = ferramenta.fazerResumo();
//      ferramentasQuantidade.setText(String.format("%.0f", resumoFerramentas[0]));
//      ferramentasValor.setText("R$ " + String.format("%.2f", resumoFerramentas[1]));

      // RESUMO DOS AMIGOS
//      Amigos amigo = new Amigos();
//      int resumoAmigos = amigo.fazerRezumo();
//      amigosQuantidade.setText(String.valueOf(resumoAmigos));
   }

   public Index() {
      initComponents();

      // CARREGANDO O DASHBOARD
      this.carregarDashboard();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel2 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      ferramentasQuantidade = new javax.swing.JLabel();
      ferramentasValor = new javax.swing.JLabel();
      jSeparator1 = new javax.swing.JSeparator();
      jPanel3 = new javax.swing.JPanel();
      jLabel7 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      amigosQuantidade = new javax.swing.JLabel();
      jSeparator2 = new javax.swing.JSeparator();
      jPanel4 = new javax.swing.JPanel();
      Emprestimos = new javax.swing.JLabel();
      jSeparator3 = new javax.swing.JSeparator();
      jLabel2 = new javax.swing.JLabel();
      jMenuBar1 = new javax.swing.JMenuBar();
      ferramentasMenu = new javax.swing.JMenu();
      ferramentasMenuGerenciar = new javax.swing.JMenuItem();
      ferramentasMenuEmprestadas = new javax.swing.JMenuItem();
      ferramentasMenuDisponiveis = new javax.swing.JMenuItem();
      amigosMenu = new javax.swing.JMenu();
      amigosMenuGerenciar = new javax.swing.JMenuItem();
      amigosMenuEmprestados = new javax.swing.JMenuItem();
      amigosMenuDevedores = new javax.swing.JMenuItem();
      negociosMenu = new javax.swing.JMenu();
      negociosMenuGerenciar = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Gerenciador de ferramentas");

      jPanel2.setBackground(new java.awt.Color(255, 255, 255));
      jPanel2.setPreferredSize(new java.awt.Dimension(200, 125));

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      jLabel1.setText("Ferramentas");

      jLabel4.setText("Quantidade: ");

      jLabel5.setText("Valor gasto:");

      ferramentasQuantidade.setText("0");

      ferramentasValor.setText("0");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel4)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(ferramentasQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel5)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(ferramentasValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())
         .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(57, 57, 57)
            .addComponent(jLabel1)
            .addContainerGap(36, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(4, 4, 4)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(4, 4, 4)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(ferramentasQuantidade))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(ferramentasValor))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel3.setBackground(new java.awt.Color(255, 255, 255));
      jPanel3.setPreferredSize(new java.awt.Dimension(200, 125));

      jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      jLabel7.setText("Amigos");

      jLabel8.setText("Quantidade: ");

      amigosQuantidade.setText("0");

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(amigosQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(14, 14, 14))
         .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(57, 57, 57)
            .addComponent(jLabel7)
            .addContainerGap(77, Short.MAX_VALUE))
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel7)
            .addGap(4, 4, 4)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(4, 4, 4)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel8)
               .addComponent(amigosQuantidade))
            .addContainerGap(34, Short.MAX_VALUE))
      );

      jPanel4.setBackground(new java.awt.Color(255, 255, 255));
      jPanel4.setPreferredSize(new java.awt.Dimension(230, 125));

      Emprestimos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      Emprestimos.setText("Negócios");

      javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
      jPanel4.setLayout(jPanel4Layout);
      jPanel4Layout.setHorizontalGroup(
         jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
         .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(57, 57, 57)
            .addComponent(Emprestimos)
            .addContainerGap(60, Short.MAX_VALUE))
      );
      jPanel4Layout.setVerticalGroup(
         jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(Emprestimos)
            .addGap(4, 4, 4)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(54, Short.MAX_VALUE))
      );

      jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
      jLabel2.setText("Dashboard");

      jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

      ferramentasMenu.setText("Ferramentas");

      ferramentasMenuGerenciar.setText("Gerenciar");
      ferramentasMenu.add(ferramentasMenuGerenciar);

      ferramentasMenuEmprestadas.setText("Listar emprestadas");
      ferramentasMenu.add(ferramentasMenuEmprestadas);

      ferramentasMenuDisponiveis.setText("Listar disponíveis");
      ferramentasMenu.add(ferramentasMenuDisponiveis);

      jMenuBar1.add(ferramentasMenu);

      amigosMenu.setText("Amigos");

      amigosMenuGerenciar.setText("Gerenciar");
      amigosMenu.add(amigosMenuGerenciar);

      amigosMenuEmprestados.setText("Listar emprestados");
      amigosMenu.add(amigosMenuEmprestados);

      amigosMenuDevedores.setText("Listar devedores");
      amigosMenu.add(amigosMenuDevedores);

      jMenuBar1.add(amigosMenu);

      negociosMenu.setText("Negócios");

      negociosMenuGerenciar.setText("Gerenciar");
      negociosMenuGerenciar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            negociosMenuGerenciarActionPerformed(evt);
         }
      });
      negociosMenu.add(negociosMenuGerenciar);

      jMenuBar1.add(negociosMenu);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
            .addGap(15, 15, 15))
         .addGroup(layout.createSequentialGroup()
            .addGap(243, 243, 243)
            .addComponent(jLabel2)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(282, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void negociosMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negociosMenuGerenciarActionPerformed
       // TODO add your handling code here:
       Gerenciador objeto = new Gerenciador();
       objeto.setVisible(true);
    }//GEN-LAST:event_negociosMenuGerenciarActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Index().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel Emprestimos;
   private javax.swing.JMenu amigosMenu;
   private javax.swing.JMenuItem amigosMenuDevedores;
   private javax.swing.JMenuItem amigosMenuEmprestados;
   private javax.swing.JMenuItem amigosMenuGerenciar;
   private javax.swing.JLabel amigosQuantidade;
   private javax.swing.JMenu ferramentasMenu;
   private javax.swing.JMenuItem ferramentasMenuDisponiveis;
   private javax.swing.JMenuItem ferramentasMenuEmprestadas;
   private javax.swing.JMenuItem ferramentasMenuGerenciar;
   private javax.swing.JLabel ferramentasQuantidade;
   private javax.swing.JLabel ferramentasValor;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JPanel jPanel4;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JSeparator jSeparator2;
   private javax.swing.JSeparator jSeparator3;
   private javax.swing.JMenu negociosMenu;
   private javax.swing.JMenuItem negociosMenuGerenciar;
   // End of variables declaration//GEN-END:variables
}
