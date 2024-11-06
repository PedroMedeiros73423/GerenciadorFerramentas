package view;

public class Index extends javax.swing.JFrame {

    public Index() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jTelaDesktop = new javax.swing.JDesktopPane();
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

      jTelaDesktop.setBackground(new java.awt.Color(255, 255, 255));

      javax.swing.GroupLayout jTelaDesktopLayout = new javax.swing.GroupLayout(jTelaDesktop);
      jTelaDesktop.setLayout(jTelaDesktopLayout);
      jTelaDesktopLayout.setHorizontalGroup(
         jTelaDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 643, Short.MAX_VALUE)
      );
      jTelaDesktopLayout.setVerticalGroup(
         jTelaDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 453, Short.MAX_VALUE)
      );

      jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

      ferramentasMenu.setText("Ferramentas");

      ferramentasMenuGerenciar.setText("Gerenciar");
      ferramentasMenuGerenciar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            ferramentasMenuGerenciarActionPerformed(evt);
         }
      });
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
         .addComponent(jTelaDesktop)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jTelaDesktop)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void ferramentasMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferramentasMenuGerenciarActionPerformed

    }//GEN-LAST:event_ferramentasMenuGerenciarActionPerformed

    private void negociosMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negociosMenuGerenciarActionPerformed
        // TODO add your handling code here:
        FrmEmprestarFerramenta objeto = new FrmEmprestarFerramenta();
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
   private javax.swing.JMenu amigosMenu;
   private javax.swing.JMenuItem amigosMenuDevedores;
   private javax.swing.JMenuItem amigosMenuEmprestados;
   private javax.swing.JMenuItem amigosMenuGerenciar;
   private javax.swing.JMenu ferramentasMenu;
   private javax.swing.JMenuItem ferramentasMenuDisponiveis;
   private javax.swing.JMenuItem ferramentasMenuEmprestadas;
   private javax.swing.JMenuItem ferramentasMenuGerenciar;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JDesktopPane jTelaDesktop;
   private javax.swing.JMenu negociosMenu;
   private javax.swing.JMenuItem negociosMenuGerenciar;
   // End of variables declaration//GEN-END:variables
}
