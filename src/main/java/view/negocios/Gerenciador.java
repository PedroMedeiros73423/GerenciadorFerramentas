
package view.negocios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
      DefaultTableModel modelo = (DefaultTableModel) tabelaNegocios.getModel();
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
      DefaultTableModel modelo = (DefaultTableModel) tabelaNegocios.getModel();
      modelo.setNumRows(0);

      // BUSCANDO OS DADOS NO BANCO
      ArrayList<Amigos> listaAmigos;
      
      if (texto.length() == 0) {
         listaAmigos = this.meusAmigos.listarTodas();
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

      jLabel4 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tabelaNegocios = new javax.swing.JTable();
      botaoCadastrar = new javax.swing.JButton();
      negocioFerramentaNome = new javax.swing.JTextField();
      botaoSalvar = new javax.swing.JButton();
      negocioAmigoNome = new javax.swing.JTextField();
      botaoDeletar = new javax.swing.JButton();
      jSeparator1 = new javax.swing.JSeparator();
      botaoLimpar = new javax.swing.JButton();
      botaoVoltar = new javax.swing.JButton();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      negocioFim = new javax.swing.JTextField();
      botaoFinalizar = new javax.swing.JButton();
      botaoDevolver = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Gerenciador de Empréstimos");

      jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
      jLabel4.setText("Gerenciar Empréstimos");

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

      negocioFerramentaNome.setEditable(false);
      negocioFerramentaNome.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            negocioFerramentaNomeMouseClicked(evt);
         }
      });

      botaoSalvar.setText("Salvar");
      botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarActionPerformed(evt);
         }
      });

      negocioAmigoNome.setEditable(false);
      negocioAmigoNome.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            negocioAmigoNomeMouseClicked(evt);
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

      jLabel6.setText("Emprestar até:");

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

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jSeparator1)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel4)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                           .addComponent(jLabel6)))
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
                        .addComponent(botaoVoltar)))
                  .addGap(0, 9, Short.MAX_VALUE)))
            .addContainerGap())
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
               .addComponent(jLabel6))
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

    private void negocioFerramentaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_negocioFerramentaNomeMouseClicked
        // ABRINDO A JANELA PARA PESQUISAR FERRAMENTAS
        pesquiserFerramenta.setSize(820, 350);
        pesquiserFerramenta.setVisible(true);
        pesquiserFerramenta.setLocationRelativeTo(null);
        botaoSelecionarFerramenta.setEnabled(false);
        // this.carregarFerramentas("");
    }//GEN-LAST:event_negocioFerramentaNomeMouseClicked
     
    private void negocioFerramentaNomeActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }
    private void tabelaAmigosMouseClicked(java.awt.event.MouseEvent evt) {                                          

   }
    
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

    private void negocioAmigoNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_negocioAmigoNomeMouseClicked
        // ABRINDO A JANELA PARA PESQUISER AMIGOS
        pesquisarAmigo.setSize(820, 350);
        pesquisarAmigo.setVisible(true);
        pesquisarAmigo.setLocationRelativeTo(null);
        botaoSelecionarAmigo.setEnabled(false);
        // this.carregarAmigos("");
    }//GEN-LAST:event_negocioAmigoNomeMouseClicked

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

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarActionPerformed
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
    }//GEN-LAST:event_botaoFinalizarActionPerformed

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
        
    private void tabelaNegociosMouseClicked(java.awt.event.MouseEvent evt) {                                            
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
   }
    private void tabelaResultadoFerramentasMouseClicked(java.awt.event.MouseEvent evt) {                                                        
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaResultadoFerramentas.getSelectedRow() != -1) {
         // MANIPULANDO BOTÕES
         botaoSelecionarFerramenta.setEnabled(true);
      }
   }
    private void botaoListarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {                                                       
      this.carregarFerramentas("");
   }
    private void botaoSelecionarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {                                                          
      // COLETANDO OS DADOS DA TABELA
      int fId = Integer.parseInt(this.tabelaResultadoFerramentas.getValueAt(this.tabelaResultadoFerramentas.getSelectedRow(), 0).toString());
      String nome = this.tabelaResultadoFerramentas.getValueAt(this.tabelaResultadoFerramentas.getSelectedRow(), 1).toString();

      // SALVANDO A ESCOLHA
      manipulado.setNegocioFerramentaId(fId);
      negocioFerramentaNome.setText(nome);

      // FECHANDO A JANELA
      pesquiserFerramenta.setVisible(false);
   }
    private void botaoListarAmigosActionPerformed(java.awt.event.ActionEvent evt) {                                                  
      this.carregarAmigos("");
   }
    private void botaoSelecionarAmigoActionPerformed(java.awt.event.ActionEvent evt) {                                                     
      // COLETANDO OS DADOS DA LINHA DA TABELA
      int aId = Integer.parseInt(this.tabelaResultadoAmigos.getValueAt(this.tabelaResultadoAmigos.getSelectedRow(), 0).toString());
      String nome = this.tabelaResultadoAmigos.getValueAt(this.tabelaResultadoAmigos.getSelectedRow(), 1).toString();

      // SALVANDO A ESCOLHA
      manipulado.setNegocioAmigoId(aId);
      negocioAmigoNome.setText(nome);

      // FECHANDO A JANELA
      pesquisarAmigo.setVisible(false);
   }
    private void tabelaResultadoAmigosMouseClicked(java.awt.event.MouseEvent evt) {                                                   
      // SE TEM ALGUMA LINHA SELECIONADA
      if (this.tabelaResultadoAmigos.getSelectedRow() != -1) {
         // MANIPULANDO BOTÕES
         botaoSelecionarAmigo.setEnabled(true);
      }
   }
    private void botaoBuscarAmigoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
      // LENDO O FORMULÁRIO
      String texto = buscaAmigo.getText();
      if (texto.length() == 0) {
         JOptionPane.showMessageDialog(null, "Informe o nome, email ou o telefone do amigo que deseja localizar");
         return;
      }

      // CARREGANDO A TABELA DE BUSCA
      this.carregarAmigos(texto);
   }
    private void botaoBuscarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {                                                      
      // LENDO O FORMULÁRIO
      String texto = buscaFerramenta.getText();
      if (texto.length() == 0) {
         JOptionPane.showMessageDialog(null, "Informe o nome ou a marca da ferramenta que deseja localizar");
         return;
      }

      // CARREGANDO A TABELA DE BUSCA
      this.carregarFerramentas(texto);
   }

    public static void main(String args[]) {
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
   private javax.swing.JLabel jLabel6;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JTextField negocioAmigoNome;
   private javax.swing.JTextField negocioFerramentaNome;
   private javax.swing.JTextField negocioFim;
   private javax.swing.JTable tabelaNegocios;
   // End of variables declaration//GEN-END:variables
}
