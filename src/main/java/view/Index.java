// PACOTES
package view;

// IMPORTAÇÕES
import javax.swing.JOptionPane;
import view.negocios.Gerenciador;
import model.Amigo;
import model.Ferramenta;
import model.Negocio;
//import view.amigos.Gerenciador;
public class Index extends javax.swing.JFrame {

   // FUNÇÃO PARA CARREGAR O DASHBOARD
   private void carregarDashboard() {
      // RESUMO DAS FERRAMENTAS
      Ferramenta ferramenta = new Ferramenta();
      Double[] resumoFerramentas = ferramenta.fazerResumo();
      ferramentasQuantidade.setText(String.format("%.0f", resumoFerramentas[0]));
      ferramentasValor.setText("R$ " + String.format("%.2f", resumoFerramentas[1]));

      // RESUMO DOS AMIGOS
      Amigo amigo = new Amigo();
      int resumoAmigos[] = amigo.fazerRezumo();
      amigosQuantidade.setText(String.valueOf(resumoAmigos[0]));
      amigosAtivos.setText(String.valueOf(resumoAmigos[1]));
      amigosAtrasados.setText(String.valueOf(resumoAmigos[2]));

      // RESUMO DOS EMPRÉSTIMOS
      Negocio negocio = new Negocio();
      int resumoNegocios[] = negocio.fazerResumo();
      negociosTotal.setText(String.valueOf(resumoNegocios[0]));
      negociosAtivos.setText(String.valueOf(resumoNegocios[1]));
      negociosAtrasados.setText(String.valueOf(resumoNegocios[2]));
   }

   public Index() {
      initComponents();

      // CARREGANDO O DASHBOARD
      this.carregarDashboard();
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        amigosAtivos = new javax.swing.JLabel();
        amigosAtrasados = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Emprestimos = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        negociosTotal = new javax.swing.JLabel();
        negociosAtivos = new javax.swing.JLabel();
        negociosAtrasados = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoAtualizar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        ferramentasMenu = new javax.swing.JMenu();
        ferramentasMenuGerenciar = new javax.swing.JMenuItem();
        ferramentasMenuEmprestadas = new javax.swing.JMenuItem();
        ferramentasMenuDisponiveis = new javax.swing.JMenuItem();
        amigosMenu = new javax.swing.JMenu();
        amigosMenuGerenciar = new javax.swing.JMenuItem();
        amigosMenuEmprestados = new javax.swing.JMenuItem();
        amigosMenuDevedores = new javax.swing.JMenuItem();
        amigosMenuRanking = new javax.swing.JMenuItem();
        amigosMenuInadimplentes = new javax.swing.JMenuItem();
        negociosMenu = new javax.swing.JMenu();
        negociosMenuGerenciar = new javax.swing.JMenuItem();
        negociosMenuAtivos = new javax.swing.JMenuItem();
        negociosMenuAtrasados = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de ferramentas");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(230, 125));
        jPanel2.setMinimumSize(new java.awt.Dimension(230, 125));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 125));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ferramentas");

        jLabel4.setText("Quantidade: ");

        jLabel5.setText("Valor gasto:");

        ferramentasQuantidade.setText("0");

        ferramentasValor.setText("R$ 0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ferramentasQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ferramentasValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
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
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 125));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Amigos");

        jLabel8.setText("Quantidade: ");

        amigosQuantidade.setText("0");

        jLabel3.setText("Empréstimos em dia:");

        jLabel6.setText("Empréstimos atrasados: ");

        amigosAtivos.setText("0");

        amigosAtrasados.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amigosAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amigosAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amigosQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel7)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amigosQuantidade)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amigosAtivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(amigosAtrasados))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(230, 125));

        Emprestimos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Emprestimos.setText("Negócios");

        jLabel9.setText("Quantidade:");

        jLabel10.setText("Ativos:");

        jLabel11.setText("Atrazados:");

        negociosTotal.setText("0");

        negociosAtivos.setText("0");

        negociosAtrasados.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(negociosAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(negociosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(negociosAtrasados, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(Emprestimos)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Emprestimos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(negociosTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(negociosAtivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(negociosAtrasados))
                .addGap(14, 14, 14))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Dashboard");

        botaoAtualizar.setText("Aualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        jButton1.setText("Membros do projeto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        ferramentasMenuEmprestadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferramentasMenuEmprestadasActionPerformed(evt);
            }
        });
        ferramentasMenu.add(ferramentasMenuEmprestadas);

        ferramentasMenuDisponiveis.setText("Listar disponíveis");
        ferramentasMenuDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferramentasMenuDisponiveisActionPerformed(evt);
            }
        });
        ferramentasMenu.add(ferramentasMenuDisponiveis);

        jMenuBar1.add(ferramentasMenu);

        amigosMenu.setText("Amigos");

        amigosMenuGerenciar.setText("Gerenciar");
        amigosMenuGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amigosMenuGerenciarActionPerformed(evt);
            }
        });
        amigosMenu.add(amigosMenuGerenciar);

        amigosMenuEmprestados.setText("Listar emprestados");
        amigosMenuEmprestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amigosMenuEmprestadosActionPerformed(evt);
            }
        });
        amigosMenu.add(amigosMenuEmprestados);

        amigosMenuDevedores.setText("Listar devedores");
        amigosMenuDevedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amigosMenuDevedoresActionPerformed(evt);
            }
        });
        amigosMenu.add(amigosMenuDevedores);

        amigosMenuRanking.setText("Ranking");
        amigosMenuRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amigosMenuRankingActionPerformed(evt);
            }
        });
        amigosMenu.add(amigosMenuRanking);

        amigosMenuInadimplentes.setText("Inadimplentes");
        amigosMenuInadimplentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amigosMenuInadimplentesActionPerformed(evt);
            }
        });
        amigosMenu.add(amigosMenuInadimplentes);

        jMenuBar1.add(amigosMenu);

        negociosMenu.setText("Empréstimos");

        negociosMenuGerenciar.setText("Gerenciar");
        negociosMenuGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negociosMenuGerenciarActionPerformed(evt);
            }
        });
        negociosMenu.add(negociosMenuGerenciar);

        negociosMenuAtivos.setText("Listar ativos");
        negociosMenuAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negociosMenuAtivosActionPerformed(evt);
            }
        });
        negociosMenu.add(negociosMenuAtivos);

        negociosMenuAtrasados.setText("Listar atrasados");
        negociosMenuAtrasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negociosMenuAtrasadosActionPerformed(evt);
            }
        });
        negociosMenu.add(negociosMenuAtrasados);

        jMenuBar1.add(negociosMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(botaoAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAtualizar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void negociosMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negociosMenuGerenciarActionPerformed
       // ABRINDO A TELA PARA GERENCIAR NEGÓCIOS
       view.negocios.Gerenciador gerente = new view.negocios.Gerenciador();
       gerente.setVisible(true);
       gerente.setLocationRelativeTo(null);
    }//GEN-LAST:event_negociosMenuGerenciarActionPerformed

    private void ferramentasMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferramentasMenuGerenciarActionPerformed
       // ABRINDO A TELA PARA GERENCIAR FERRAMENTAS
       view.ferramentas.Gerenciador objeto = new view.ferramentas.Gerenciador();
       objeto.setVisible(true);
       objeto.setLocationRelativeTo(null);
    }//GEN-LAST:event_ferramentasMenuGerenciarActionPerformed

   private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
      // RECARREGAR O DASHBOARD
      this.carregarDashboard();
   }//GEN-LAST:event_botaoAtualizarActionPerformed

   private void ferramentasMenuEmprestadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferramentasMenuEmprestadasActionPerformed
      // ABRINDO A TELA COM A LISTA DE FERRAMENTAS EMPRESTADAS
      view.ferramentas.Emprestada emprestadas = new view.ferramentas.Emprestada();
      emprestadas.setVisible(true);
      emprestadas.setLocationRelativeTo(null);
   }//GEN-LAST:event_ferramentasMenuEmprestadasActionPerformed

   private void ferramentasMenuDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferramentasMenuDisponiveisActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE FERRAMENTAS DISPONÍVEIS PARA EMPRÉSTIMOS
      view.ferramentas.Disponivel disponivel = new view.ferramentas.Disponivel();
      disponivel.setVisible(true);
      disponivel.setLocationRelativeTo(null);
   }//GEN-LAST:event_ferramentasMenuDisponiveisActionPerformed

   private void amigosMenuGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amigosMenuGerenciarActionPerformed
      view.amigos.Gerenciador objeto = new view.amigos.Gerenciador();
      objeto.setVisible(true);
      objeto.setLocationRelativeTo(null);
   }//GEN-LAST:event_amigosMenuGerenciarActionPerformed

   private void amigosMenuEmprestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amigosMenuEmprestadosActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE AMIGOS QUE POSSUEM EMPRÉSTIMOS ATIVOS
      view.amigos.Emprestado emprestados = new view.amigos.Emprestado();
      emprestados.setVisible(true);
      emprestados.setLocationRelativeTo(null);
   }//GEN-LAST:event_amigosMenuEmprestadosActionPerformed

   private void amigosMenuDevedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amigosMenuDevedoresActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE AMIGOS COM EMPRESTIMOS PENDENTES
      view.amigos.Devedor devedores = new view.amigos.Devedor();
      devedores.setVisible(true);
      devedores.setLocationRelativeTo(null);
   }//GEN-LAST:event_amigosMenuDevedoresActionPerformed

   private void amigosMenuRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amigosMenuRankingActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE DOS AMIGOS COM MAIS EMPRÉSTIMOS
      view.amigos.Ranking ranking = new view.amigos.Ranking();
      ranking.setVisible(true);
      ranking.setLocationRelativeTo(null);
   }//GEN-LAST:event_amigosMenuRankingActionPerformed

   private void amigosMenuInadimplentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amigosMenuInadimplentesActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE AMIGOS QUE NUNCA DEVOLVERAM AS FERRAMENTAS
      view.amigos.Inadimplante inadimplentes = new view.amigos.Inadimplante();
      inadimplentes.setVisible(true);
      inadimplentes.setLocationRelativeTo(null);
   }//GEN-LAST:event_amigosMenuInadimplentesActionPerformed

   private void negociosMenuAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negociosMenuAtivosActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE EMPRÉSTIMOS ATIVOS NO MOMENTO
      view.negocios.Ativo ativos = new view.negocios.Ativo();
      ativos.setVisible(true);
      ativos.setLocationRelativeTo(null);
   }//GEN-LAST:event_negociosMenuAtivosActionPerformed

   private void negociosMenuAtrasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negociosMenuAtrasadosActionPerformed
      // ABRIRINDO A TELA COM A LISTA DE EMPRÉSTIMOS PENDENTES
      view.negocios.Atrasado atrasados = new view.negocios.Atrasado();
      atrasados.setVisible(true);
      atrasados.setLocationRelativeTo(null);
   }//GEN-LAST:event_negociosMenuAtrasadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // IDENTIFICAÇÃO DOS ALUNOS
       JOptionPane.showMessageDialog(null, "====================================================== \n PROJETO A3 \n ====================================================== \n MEMBROS DO GRUPO \n Aluno 01: " + "João Vitor Iuncks \n Aluno 02: " + "Elias Bernabé Turchiéllo \n Aluno 03: " + "Pedro Henrique Medeiros ");
    }//GEN-LAST:event_jButton1ActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Index().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Emprestimos;
    private javax.swing.JLabel amigosAtivos;
    private javax.swing.JLabel amigosAtrasados;
    private javax.swing.JMenu amigosMenu;
    private javax.swing.JMenuItem amigosMenuDevedores;
    private javax.swing.JMenuItem amigosMenuEmprestados;
    private javax.swing.JMenuItem amigosMenuGerenciar;
    private javax.swing.JMenuItem amigosMenuInadimplentes;
    private javax.swing.JMenuItem amigosMenuRanking;
    private javax.swing.JLabel amigosQuantidade;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JMenu ferramentasMenu;
    private javax.swing.JMenuItem ferramentasMenuDisponiveis;
    private javax.swing.JMenuItem ferramentasMenuEmprestadas;
    private javax.swing.JMenuItem ferramentasMenuGerenciar;
    private javax.swing.JLabel ferramentasQuantidade;
    private javax.swing.JLabel ferramentasValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel negociosAtivos;
    private javax.swing.JLabel negociosAtrasados;
    private javax.swing.JMenu negociosMenu;
    private javax.swing.JMenuItem negociosMenuAtivos;
    private javax.swing.JMenuItem negociosMenuAtrasados;
    private javax.swing.JMenuItem negociosMenuGerenciar;
    private javax.swing.JLabel negociosTotal;
    // End of variables declaration//GEN-END:variables
}
