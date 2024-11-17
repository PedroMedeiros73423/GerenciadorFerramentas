package view.negocios;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigos;
import model.Ferramentas;
import model.Negocios;

public class Gerenciador extends javax.swing.JFrame {

   // CRIANDO OBJETOS DE MANIPULAÇÃO ===========================================
   Negocios manipulado = new Negocios();
   Ferramentas disponiveis = new Ferramentas();
   Amigos meusAmigos = new Amigos();

   // FORMATO DE DATA PARA O MYSQL =============================================
   SimpleDateFormat dataSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   // CONSTRUTOR ===============================================================
   public Gerenciador() {
      initComponents();

      // CARREGANDO A TABELA
      this.carregaTabela();

      // DEFINIR O TEMPO PADRÃO DE EMPRÉSTIMO
      this.tempoEmprestimo();
   }

   // METODO PARA CARREGAR OS DADOS NA TABELA ==================================
   private void carregaTabela() {
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
            esteNegocio.getNegocioFerramentaNome(),
            esteNegocio.getNegocioAmigoId(),
            esteNegocio.getNegocioAmigoNome(),
            esteNegocio.getNegocioInicio(),
            esteNegocio.getNegocioFim(),
            esteNegocio.getNegocioFinal()
         });
      }

      // LIMPANDO O FORMULÁRIO
      negocioFerramentaNome.setText("");
      negocioAmigoNome.setText("");

      // MANIPULANDO OS BOTÕES
      botaoCadastrar.setEnabled(true);
      botaoDevolver.setEnabled(false);
      botaoFinalizar.setEnabled(false);
      botaoSalvar.setEnabled(false);
      botaoDeletar.setEnabled(false);
   }

   // METODO PARA CARREGAR FERRAMENTAS DISPONÍVEIS =============================
   private void carregarFerramentas(String texto) {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaResultadoFerramentas.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Ferramentas> fDisponivies;

      if (texto.length() == 0) {
         fDisponivies = disponiveis.listarDisponiveis();
      } else {
         fDisponivies = disponiveis.buscarDisponiveis(texto);
      }

      if (fDisponivies.size() == 0) {
         JOptionPane.showMessageDialog(null, "Não há ferramentas disponíveis");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Ferramentas estaFerramenta : fDisponivies) {
         modelo.addRow(new Object[]{
            estaFerramenta.getFerramentaId(),
            estaFerramenta.getFerramentaNome(),
            estaFerramenta.getFerramentaMarca(),
            estaFerramenta.getFerramentaValor()
         });
      }
   }

   // METODO PARA CARREGAR A LISTA DE AMIGOS ===================================
   private void carregarAmigos(String texto) {
      // LENDO O MODELO DA TABELA
      DefaultTableModel modelo = (DefaultTableModel) this.tabelaResultadoAmigos.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigos> listaAmigos;

      if (texto.length() == 0) {
         listaAmigos = this.meusAmigos.listarTodos();
      } else {
         listaAmigos = this.meusAmigos.buscarAmigos(texto);
      }

      if (listaAmigos.size() == 0) {
         JOptionPane.showMessageDialog(null, "Nenhum amigo ecnotrado");
      }

      // INSRINDO OS DADOS NA TABELA
      for (Amigos esteAmigo : listaAmigos) {
         modelo.addRow(new Object[]{
            esteAmigo.getAmigoId(),
            esteAmigo.getAmigoNome(),
            esteAmigo.getAmigoEmail(),
            esteAmigo.getAmigoEndereco(),
            esteAmigo.getAmigoTelefone()
         });
      }
   }

   // METODO PARA DEFINIR UM TEMPO PADRÃO DE EMPRÉSTIMOS =======================
   private void tempoEmprestimo() {
      // ADICIONANDO 15 DIAS
      String fim = dataSql.format(new Date().getTime() + (1000 * 60 * 60 * 24 * 15));

      // PREENCHENDO O FORMULÁRIO
      negocioFim.setText(fim);
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane2 = new javax.swing.JScrollPane();
      jList1 = new javax.swing.JList<>();
      jToggleButton1 = new javax.swing.JToggleButton();
      pesquiserFerramenta = new javax.swing.JDialog();
      jLabel6 = new javax.swing.JLabel();
      jScrollPane3 = new javax.swing.JScrollPane();
      tabelaResultadoFerramentas = new javax.swing.JTable();
      botaoSelecionarFerramenta = new javax.swing.JButton();
      botaoListarFerramentas = new javax.swing.JButton();
      jLabel8 = new javax.swing.JLabel();
      buscaFerramenta = new javax.swing.JTextField();
      botaoBuscarFerramenta = new javax.swing.JButton();
      pesquisarAmigo = new javax.swing.JDialog();
      botaoSelecionarAmigo = new javax.swing.JButton();
      botaoListarAmigos = new javax.swing.JButton();
      jLabel5 = new javax.swing.JLabel();
      jScrollPane5 = new javax.swing.JScrollPane();
      tabelaResultadoAmigos = new javax.swing.JTable();
      buscaAmigo = new javax.swing.JTextField();
      jLabel7 = new javax.swing.JLabel();
      botaoBuscarAmigo = new javax.swing.JButton();
      jScrollPane4 = new javax.swing.JScrollPane();
      tabelaAmigos = new javax.swing.JTable();
      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tabelaNegocios = new javax.swing.JTable();
      botaoCadastrar = new javax.swing.JButton();
      botaoSalvar = new javax.swing.JButton();
      botaoDeletar = new javax.swing.JButton();
      botaoLimpar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      negocioFim = new javax.swing.JTextField();
      botaoFinalizar = new javax.swing.JButton();
      botaoDevolver = new javax.swing.JButton();
      negocioFerramentaNome = new javax.swing.JTextField();
      negocioAmigoNome = new javax.swing.JTextField();
      jSeparator1 = new javax.swing.JSeparator();

      jList1.setModel(new javax.swing.AbstractListModel<String>() {
         String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public String getElementAt(int i) { return strings[i]; }
      });
      jScrollPane2.setViewportView(jList1);

      jToggleButton1.setText("jToggleButton1");

      pesquiserFerramenta.setTitle("Buscar ferramenta");
      pesquiserFerramenta.setMinimumSize(new java.awt.Dimension(800, 300));

      jLabel6.setText("Resultado");

      tabelaResultadoFerramentas.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Nome", "Marca", "Valor"
         }
      ));
      tabelaResultadoFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaResultadoFerramentasMouseClicked(evt);
         }
      });
      jScrollPane3.setViewportView(tabelaResultadoFerramentas);
      if (tabelaResultadoFerramentas.getColumnModel().getColumnCount() > 0) {
         tabelaResultadoFerramentas.getColumnModel().getColumn(0).setMaxWidth(30);
      }

      botaoSelecionarFerramenta.setText("Selecionar");
      botaoSelecionarFerramenta.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSelecionarFerramentaActionPerformed(evt);
         }
      });

      botaoListarFerramentas.setText("Listar disponíveis");
      botaoListarFerramentas.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoListarFerramentasActionPerformed(evt);
         }
      });

      jLabel8.setText("Digite o nome ou a marca da ferramenta");

      botaoBuscarFerramenta.setText("Buscar");
      botaoBuscarFerramenta.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoBuscarFerramentaActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout pesquiserFerramentaLayout = new javax.swing.GroupLayout(pesquiserFerramenta.getContentPane());
      pesquiserFerramenta.getContentPane().setLayout(pesquiserFerramentaLayout);
      pesquiserFerramentaLayout.setHorizontalGroup(
         pesquiserFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pesquiserFerramentaLayout.createSequentialGroup()
            .addGroup(pesquiserFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(pesquiserFerramentaLayout.createSequentialGroup()
                  .addGap(12, 12, 12)
                  .addGroup(pesquiserFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel6)
                     .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel8)
                     .addGroup(pesquiserFerramentaLayout.createSequentialGroup()
                        .addComponent(buscaFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoBuscarFerramenta))))
               .addGroup(pesquiserFerramentaLayout.createSequentialGroup()
                  .addGap(281, 281, 281)
                  .addComponent(botaoSelecionarFerramenta)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(botaoListarFerramentas)))
            .addContainerGap(15, Short.MAX_VALUE))
      );
      pesquiserFerramentaLayout.setVerticalGroup(
         pesquiserFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pesquiserFerramentaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pesquiserFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(buscaFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(botaoBuscarFerramenta))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(pesquiserFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoSelecionarFerramenta)
               .addComponent(botaoListarFerramentas))
            .addContainerGap(18, Short.MAX_VALUE))
      );

      botaoSelecionarAmigo.setText("Slecionar");
      botaoSelecionarAmigo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSelecionarAmigoActionPerformed(evt);
         }
      });

      botaoListarAmigos.setText("Listar todos");
      botaoListarAmigos.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoListarAmigosActionPerformed(evt);
         }
      });

      jLabel5.setText("Resultado");

      tabelaResultadoAmigos.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "Nome", "Email", "Endereço", "Telefone"
         }
      ));
      tabelaResultadoAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaResultadoAmigosMouseClicked(evt);
         }
      });
      jScrollPane5.setViewportView(tabelaResultadoAmigos);
      if (tabelaResultadoAmigos.getColumnModel().getColumnCount() > 0) {
         tabelaResultadoAmigos.getColumnModel().getColumn(0).setMaxWidth(30);
      }

      jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel7.setText("Informe o nome, email ou telefone do amigo");

      botaoBuscarAmigo.setText("Buscar");
      botaoBuscarAmigo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoBuscarAmigoActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout pesquisarAmigoLayout = new javax.swing.GroupLayout(pesquisarAmigo.getContentPane());
      pesquisarAmigo.getContentPane().setLayout(pesquisarAmigoLayout);
      pesquisarAmigoLayout.setHorizontalGroup(
         pesquisarAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(pesquisarAmigoLayout.createSequentialGroup()
            .addGroup(pesquisarAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(pesquisarAmigoLayout.createSequentialGroup()
                  .addGap(278, 278, 278)
                  .addComponent(botaoSelecionarAmigo)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(botaoListarAmigos))
               .addGroup(pesquisarAmigoLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(pesquisarAmigoLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel5))
               .addGroup(pesquisarAmigoLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(buscaAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(botaoBuscarAmigo))
               .addGroup(pesquisarAmigoLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel7)))
            .addContainerGap(17, Short.MAX_VALUE))
      );
      pesquisarAmigoLayout.setVerticalGroup(
         pesquisarAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pesquisarAmigoLayout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pesquisarAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(buscaAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(botaoBuscarAmigo))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(pesquisarAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botaoSelecionarAmigo)
               .addComponent(botaoListarAmigos))
            .addContainerGap())
      );

      tabelaAmigos.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
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
      jScrollPane4.setViewportView(tabelaAmigos);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Gerenciar Empréstimos");

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
      jLabel1.setText("Gerenciar empréstimos");

      tabelaNegocios.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "FID", "Ferramenta", "AID", "Amigo", "Início", "Fim", "Término"
         }
      ));
      tabelaNegocios.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaNegociosMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tabelaNegocios);
      if (tabelaNegocios.getColumnModel().getColumnCount() > 0) {
         tabelaNegocios.getColumnModel().getColumn(0).setMaxWidth(30);
         tabelaNegocios.getColumnModel().getColumn(1).setMinWidth(0);
         tabelaNegocios.getColumnModel().getColumn(1).setMaxWidth(0);
         tabelaNegocios.getColumnModel().getColumn(3).setMinWidth(0);
         tabelaNegocios.getColumnModel().getColumn(3).setMaxWidth(0);
      }

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

      botaoDeletar.setText("Deletar");
      botaoDeletar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoDeletarActionPerformed(evt);
         }
      });

      botaoLimpar.setText("Limpar");
      botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoLimparActionPerformed(evt);
         }
      });

      botaoVoltar.setText("Voltar");
      botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoVoltarActionPerformed(evt);
         }
      });

      jLabel2.setText("Ferramenta (clique para pesquisar)");

      jLabel3.setText("Amigo (clique para pesquisar)");

      jLabel4.setText("Emprestar até:");

      botaoFinalizar.setText("Finalizar");
      botaoFinalizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoFinalizarActionPerformed(evt);
         }
      });

      botaoDevolver.setText("Devolver");
      botaoDevolver.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoDevolverActionPerformed(evt);
         }
      });

      negocioFerramentaNome.setEditable(false);
      negocioFerramentaNome.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            negocioFerramentaNomeMouseClicked(evt);
         }
      });

      negocioAmigoNome.setEditable(false);
      negocioAmigoNome.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            negocioAmigoNomeMouseClicked(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel1)
                           .addComponent(jLabel2)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(negocioFerramentaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(jLabel3)
                                 .addComponent(negocioAmigoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(negocioFim, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(jLabel4)))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
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
                        .addComponent(botaoVoltar)))
                  .addGap(0, 9, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jSeparator1)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(jLabel3)
               .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(negocioFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(negocioFerramentaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(negocioAmigoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(5, 5, 5)
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

   private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
      this.dispose();
   }//GEN-LAST:event_botaoVoltarActionPerformed

   private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
      // VERIFICAR SE O AMIGO TEM FERRAMENTAS ATRASADAS
      int quantidadeAtrasada = manipulado.verificaPendencias(manipulado.getNegocioAmigoId());

      if (quantidadeAtrasada > 0) {
         Object[] options = {"Sim", "Não"};
         int seguir = JOptionPane.showOptionDialog(this, "Amigo: " + negocioAmigoNome.getText() + "\nTem: " + quantidadeAtrasada + " ferramentas não devolvidas\n\nDeseja mesmo emprestar mais uma ferramenta?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);

         if (seguir != 0) {
            // ABORTANDO
            return;
         }
      }

      // DEFININDO A DATA DE INÍCIO COMO SENDO AGORA
      String inicio = dataSql.format(new Date().getTime());

      // INSERIR NO BANCO
      boolean result = manipulado.cadastrarNegocio(manipulado.getNegocioFerramentaId(), manipulado.getNegocioAmigoId(), inicio, negocioFim.getText(), null);

      if (result == true) {
         this.carregaTabela();
         this.tempoEmprestimo();
         // JOptionPane.showMessageDialog(null, "Empréstimo cadastrado com sucesso");

         // LIMPANDO O OBJETO MANIPULADO
         manipulado.setNegocioFerramentaId(0);
         manipulado.setNegocioAmigoId(0);
      } else {
         JOptionPane.showMessageDialog(null, "Erro ao cadastrar empréstimo");
      }
   }//GEN-LAST:event_botaoCadastrarActionPerformed

   private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
      // RESETANDO OS CAMPOS
      negocioFerramentaNome.setText("");
      negocioAmigoNome.setText("");
      tempoEmprestimo();

      // MANIPULANDO BOTÕES
      botaoCadastrar.setEnabled(true);
      botaoSalvar.setEnabled(false);
      botaoDeletar.setEnabled(false);
      botaoDevolver.setEnabled(false);
      botaoFinalizar.setEnabled(false);

   }//GEN-LAST:event_botaoLimparActionPerformed

   private void tabelaNegociosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNegociosMouseClicked
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaNegocios.getSelectedRow() != -1) {
         // COLETANDO DADOS DA TABELA
         int fId = Integer.parseInt(this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 1).toString());
         String ferramentaNome = this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 2).toString();
         int aId = Integer.parseInt(this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 3).toString());
         String amigoNome = this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 4).toString();
         String dataInicio = this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 5).toString();
         String dataFim = this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 6).toString();
         String dataFinal = "";
         try {
            dataFinal = this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 7).toString();
         } catch (Exception e) {
         }

         // CARREGANDO ITENS NO FORMULÁRIO
         negocioFerramentaNome.setText(String.valueOf(ferramentaNome));
         negocioAmigoNome.setText(String.valueOf(amigoNome));
         negocioFim.setText(dataFim);

         // SALVANDO AS CHAVE ESTRANGEIRAS NO OBJETO DE MANIPULAÇÃO
         manipulado.setNegocioFerramentaId(fId);
         manipulado.setNegocioAmigoId(aId);

         // MANIPULANDO BOTÕES
         botaoCadastrar.setEnabled(false);
         botaoDeletar.setEnabled(true);
         if (dataFinal.length() > 0) {
            botaoSalvar.setEnabled(false);
            botaoDevolver.setEnabled(false);
            botaoFinalizar.setEnabled(false);
         } else {
            botaoSalvar.setEnabled(true);
         }
         // DEVOLVER OU FINALIZAR
         Date agora = new Date();
         try {
            if (agora.after(dataSql.parse(dataFim)) && dataFinal.length() == 0) {
               botaoFinalizar.setEnabled(true);
               botaoDevolver.setEnabled(false);
            } else if (agora.after(dataSql.parse(dataFim)) && dataFinal.length() > 0) {
               botaoFinalizar.setEnabled(false);
               botaoDevolver.setEnabled(false);
            } else {
               botaoFinalizar.setEnabled(false);
               botaoDevolver.setEnabled(true);
            }
         } catch (Exception e) {
            botaoDevolver.setEnabled(false);
            botaoFinalizar.setEnabled(false);
         }
      }
   }//GEN-LAST:event_tabelaNegociosMouseClicked

   private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaNegocios.getSelectedRow() != -1) {
         // COLETANDO O ID E A DATA DE INÍCIO DA TABELA
         int nId = Integer.parseInt(this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 0).toString());
         String inicio = this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 5).toString();

         // VALIDANDO AS DATAS AQUI PARA APROVEITAR O OBJETO FORMATADOR E PODER RETORNAR UMA MENSAGEM PERDONALIZADA
         String fim = negocioFim.getText();
         try {
            if (dataSql.parse(fim).before(dataSql.parse(inicio))) {
               JOptionPane.showMessageDialog(null, "Início : " + inicio + "\nFim   : " + fim + "\n\nA data do fim do empréstimo não pode ser menor do que a data de início");
               return;
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema detectado com as datas de início e fim do empréstimo");
            return;
         }

         // SALVANDO NO BANCO
         boolean result = manipulado.editarNegocio(nId, manipulado.getNegocioFerramentaId(), manipulado.getNegocioAmigoId(), inicio, fim, null);
         if (result == true) {
            this.carregaTabela();
            this.tempoEmprestimo();
            // JOptionPane.showMessageDialog(null, "Empréstimo atualizado com sucesso");

            // LIMPANDO O OBJETO MANIPULADO
            manipulado.setNegocioFerramentaId(0);
            manipulado.setNegocioAmigoId(0);
         } else {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar empréstimo");
         }
      }
   }//GEN-LAST:event_botaoSalvarActionPerformed

   private void botaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarActionPerformed
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaNegocios.getSelectedRow() != -1) {
         // CONFIRMAR DELEÇÃO
         Object[] options = {"Sim", "Não"};
         int seguir = JOptionPane.showOptionDialog(this, "Deseja mesmo excluir esse empréstimo?", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);

         if (seguir != 0) {
            // ABORTANDO
            return;
         }

         // COLETANDO O ID DO NEGÓCIO
         int nId = Integer.parseInt(this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 0).toString());

         // APAGANDO
         boolean result = manipulado.deletarNegocio(nId);

         if (result == true) {
            this.carregaTabela();
            this.tempoEmprestimo();
            // JOptionPane.showMessageDialog(null, "Empréstimo deletado com sucesso");

            // LIMPANDO O OBJETO MANIPULADO
            manipulado.setNegocioFerramentaId(0);
            manipulado.setNegocioAmigoId(0);
         } else {
            JOptionPane.showMessageDialog(null, "Erro ao deletar empréstimo");
         }
      }
   }//GEN-LAST:event_botaoDeletarActionPerformed

   private void botaoDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDevolverActionPerformed
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaNegocios.getSelectedRow() != -1) {
         // COLETANDO O ID DO NEGÓCIO
         int nId = Integer.parseInt(this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 0).toString());

         // SALVANDO NO BANCO
         boolean result = manipulado.encerrarNegocio(nId);

         if (result == true) {
            this.carregaTabela();
            this.tempoEmprestimo();
            JOptionPane.showMessageDialog(null, "Ferramenta devolvida com sucesso");

            // LIMPANDO O OBJETO MANIPULADO
            manipulado.setNegocioFerramentaId(0);
            manipulado.setNegocioAmigoId(0);
         } else {
            JOptionPane.showMessageDialog(null, "Erro ao devolver ferramenta");
         }
      }
   }//GEN-LAST:event_botaoDevolverActionPerformed

   private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarActionPerformed
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaNegocios.getSelectedRow() != -1) {
         // COLETANDO O ID DO NEGÓCIO
         int nId = Integer.parseInt(this.tabelaNegocios.getValueAt(this.tabelaNegocios.getSelectedRow(), 0).toString());

         // SALVANDO NO BANCO
         boolean result = manipulado.finalizarNegocio(nId);

         if (result == true) {
            this.carregaTabela();
            this.tempoEmprestimo();
            JOptionPane.showMessageDialog(null, "Ferramenta atrasada devolvida com sucesso");

            // LIMPANDO O OBJETO MANIPULADO
            manipulado.setNegocioFerramentaId(0);
            manipulado.setNegocioAmigoId(0);
         } else {
            JOptionPane.showMessageDialog(null, "Erro ao devolver ferramenta atrasada");
         }
      }
   }//GEN-LAST:event_botaoFinalizarActionPerformed

   private void tabelaResultadoFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaResultadoFerramentasMouseClicked
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaResultadoFerramentas.getSelectedRow() != -1) {
         // MANIPULANDO BOTÕES
         botaoSelecionarFerramenta.setEnabled(true);
      }
   }//GEN-LAST:event_tabelaResultadoFerramentasMouseClicked

   private void botaoListarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarFerramentasActionPerformed
      this.carregarFerramentas("");
   }//GEN-LAST:event_botaoListarFerramentasActionPerformed

   private void botaoSelecionarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarFerramentaActionPerformed
      // COLETANDO OS DADOS DA TABELA
      int fId = Integer.parseInt(this.tabelaResultadoFerramentas.getValueAt(this.tabelaResultadoFerramentas.getSelectedRow(), 0).toString());
      String nome = this.tabelaResultadoFerramentas.getValueAt(this.tabelaResultadoFerramentas.getSelectedRow(), 1).toString();

      // SALVANDO A ESCOLHA
      manipulado.setNegocioFerramentaId(fId);
      negocioFerramentaNome.setText(nome);

      // FECHANDO A JANELA
      pesquiserFerramenta.setVisible(false);
   }//GEN-LAST:event_botaoSelecionarFerramentaActionPerformed

   private void negocioFerramentaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_negocioFerramentaNomeMouseClicked
      // ABRINDO A JANELA PARA PESQUISAR FERRAMENTAS
      pesquiserFerramenta.setSize(820, 350);
      pesquiserFerramenta.setVisible(true);
      pesquiserFerramenta.setLocationRelativeTo(null);
      botaoSelecionarFerramenta.setEnabled(false);
      // this.carregarFerramentas("");
   }//GEN-LAST:event_negocioFerramentaNomeMouseClicked

   private void tabelaAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAmigosMouseClicked

   }//GEN-LAST:event_tabelaAmigosMouseClicked

   private void negocioAmigoNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_negocioAmigoNomeMouseClicked
      // ABRINDO A JANELA PARA PESQUISER AMIGOS
      pesquisarAmigo.setSize(820, 350);
      pesquisarAmigo.setVisible(true);
      pesquisarAmigo.setLocationRelativeTo(null);
      botaoSelecionarAmigo.setEnabled(false);
      // this.carregarAmigos("");
   }//GEN-LAST:event_negocioAmigoNomeMouseClicked

   private void botaoListarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoListarAmigosActionPerformed
      this.carregarAmigos("");
   }//GEN-LAST:event_botaoListarAmigosActionPerformed

   private void botaoSelecionarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarAmigoActionPerformed
      // COLETANDO OS DADOS DA LINHA DA TABELA
      int aId = Integer.parseInt(this.tabelaResultadoAmigos.getValueAt(this.tabelaResultadoAmigos.getSelectedRow(), 0).toString());
      String nome = this.tabelaResultadoAmigos.getValueAt(this.tabelaResultadoAmigos.getSelectedRow(), 1).toString();

      // SALVANDO A ESCOLHA
      manipulado.setNegocioAmigoId(aId);
      negocioAmigoNome.setText(nome);

      // FECHANDO A JANELA
      pesquisarAmigo.setVisible(false);
   }//GEN-LAST:event_botaoSelecionarAmigoActionPerformed

   private void tabelaResultadoAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaResultadoAmigosMouseClicked
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaResultadoAmigos.getSelectedRow() != -1) {
         // MANIPULANDO BOTÕES
         botaoSelecionarAmigo.setEnabled(true);
      }
   }//GEN-LAST:event_tabelaResultadoAmigosMouseClicked

   private void botaoBuscarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarAmigoActionPerformed
      // LENDO O FORMULÁRIO
      String texto = buscaAmigo.getText();
      if (texto.length() == 0) {
         JOptionPane.showMessageDialog(null, "Informe o nome, email ou o telefone do amigo que deseja localizar");
         return;
      }

      // CARREGANDO A TABELA DE BUSCA
      this.carregarAmigos(texto);
   }//GEN-LAST:event_botaoBuscarAmigoActionPerformed

   private void botaoBuscarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarFerramentaActionPerformed
      // LENDO O FORMULÁRIO
      String texto = buscaFerramenta.getText();
      if (texto.length() == 0) {
         JOptionPane.showMessageDialog(null, "Informe o nome ou a marca da ferramenta que deseja localizar");
         return;
      }

      // CARREGANDO A TABELA DE BUSCA
      this.carregarFerramentas(texto);
   }//GEN-LAST:event_botaoBuscarFerramentaActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Gerenciador().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botaoBuscarAmigo;
   private javax.swing.JButton botaoBuscarFerramenta;
   private javax.swing.JButton botaoCadastrar;
   private javax.swing.JButton botaoDeletar;
   private javax.swing.JButton botaoDevolver;
   private javax.swing.JButton botaoFinalizar;
   private javax.swing.JButton botaoLimpar;
   private javax.swing.JButton botaoListarAmigos;
   private javax.swing.JButton botaoListarFerramentas;
   private javax.swing.JButton botaoSalvar;
   private javax.swing.JButton botaoSelecionarAmigo;
   private javax.swing.JButton botaoSelecionarFerramenta;
   private javax.swing.JButton botaoVoltar;
   private javax.swing.JTextField buscaAmigo;
   private javax.swing.JTextField buscaFerramenta;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JList<String> jList1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JToggleButton jToggleButton1;
   private javax.swing.JTextField negocioAmigoNome;
   private javax.swing.JTextField negocioFerramentaNome;
   private javax.swing.JTextField negocioFim;
   private javax.swing.JDialog pesquisarAmigo;
   private javax.swing.JDialog pesquiserFerramenta;
   private javax.swing.JTable tabelaAmigos;
   private javax.swing.JTable tabelaNegocios;
   private javax.swing.JTable tabelaResultadoAmigos;
   private javax.swing.JTable tabelaResultadoFerramentas;
   // End of variables declaration//GEN-END:variables
}
