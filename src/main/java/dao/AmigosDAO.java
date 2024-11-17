// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import model.Amigos;

public class AmigosDAO extends ServidorDAO {

   // ATRIBUTOS ================================================================
   private final ArrayList<Amigos> listaDeAmigos = new ArrayList<>();

   // LISTAR TODOS =============================================================
   public ArrayList<Amigos> listarTodos() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM amigos");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO AMIGO
            int id = res.getInt("amigoId");
            String nome = res.getString("amigoNome");
            String email = res.getString("amigoEmail");
            String endereco = res.getString("amigoEndereco");
            String telefone = res.getString("amigoTelefone");

            Amigos este = new Amigos(id, nome, email, endereco, telefone);

            // ADICIONAR O AMIGO NA LISTA
            listaDeAmigos.add(este);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }
      // RETORNAR A LISTA
      return listaDeAmigos;
   }

   // LISTAR TODOS =============================================================
   public ArrayList<Amigos> buscarAmigos(String texto) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM amigos WHERE amigos.amigoNome LIKE '%" + texto + "%' OR amigos.amigoEmail LIKE '%" + texto + "%' OR amigos.amigoTelefone LIKE '%" + texto + "%'");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO AMIGO
            int id = res.getInt("amigoId");
            String nome = res.getString("amigoNome");
            String email = res.getString("amigoEmail");
            String endereco = res.getString("amigoEndereco");
            String telefone = res.getString("amigoTelefone");

            Amigos este = new Amigos(id, nome, email, endereco, telefone);

            // ADICIONAR O AMIGO NA LISTA
            listaDeAmigos.add(este);
         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }
      // RETORNAR A LISTA
      return listaDeAmigos;
   }

   // SABER SE O AMIGO JÁ FEZ ALGUM EMPRÉSTIMO =================================
   public int temEmprestimos(int id) {
      // DEFININDO UMA QUANTIDADE INICIAL
      int quantidade = 99;

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT count(*) AS quantidade FROM amigos LEFT JOIN negocios ON amigos.amigoId = negocios.negocioFerramentaId WHERE negocios.negocioAmigoId = " + id);

         // PROCESSANDO A RESPOSTA
         while (res.next()) {
            quantidade = res.getInt("quantidade");
         }

         // RETORNANDO O VALOR
         stmt.close();
         return quantidade;
      } catch (SQLException ex) {
         return 1000;
      }
   }

   // LISTAR UM ================================================================
   public Amigos listarUmObjeto(int id) {
      // CRIANDO UM OBJETO
      Amigos amigo = new Amigos();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM amigos WHERE amigoId = " + id);
         res.next();

         // PEGANDO DOS DADOS DO AMIGO
         amigo.setAmigoId(res.getInt("amigoId"));
         amigo.setAmigoNome(res.getString("amigoNome"));
         amigo.setAmigoEmail(res.getString("amigoEmail"));
         amigo.setAmigoEndereco(res.getString("amigoEndereco"));
         amigo.setAmigoTelefone(res.getString("amigoTelefone"));

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return amigo;
   }

   public ArrayList<Amigos> listarUmLista(int id) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      // CRIANDO UM OBJETO
      Amigos amigo = new Amigos();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM amigos WHERE amigoId = " + id);
         res.next();

         // PEGANDO DOS DADOS DA FERRAMENTA
         amigo.setAmigoId(res.getInt("amigoId"));
         amigo.setAmigoNome(res.getString("amigoNome"));
         amigo.setAmigoEmail(res.getString("amigoEmail"));
         amigo.setAmigoEndereco(res.getString("amigoEndereco"));
         amigo.setAmigoTelefone(res.getString("amigoTelefone"));

         // ADICIONAR O AMIGO NA LISTA
         listaDeAmigos.add(amigo);

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return listaDeAmigos;
   }

   // CADASTRA NOVO AMIGO ======================================================
   public boolean inserirAmigo(Amigos novoAmigo) {
      // CRIANDO A QUERY
      String sql = "INSERT INTO amigos(amigoId, amigoNome, amigoEmail, amigoEndereco, amigoTelefone) VALUES(?,?,?,?,?)";

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            // CONFIGURANDO OS PARÂMETROS DA QUERY
            stmt.setString(1, null);
            stmt.setString(2, novoAmigo.getAmigoNome());
            stmt.setString(3, novoAmigo.getAmigoEmail());
            stmt.setString(4, novoAmigo.getAmigoEndereco());
            stmt.setString(5, novoAmigo.getAmigoTelefone());

            stmt.execute();
            stmt.cancel();
         }
         return true;
      } catch (SQLException erro) {
         return false;
      }
   }

   // MODIFICAR UM AMIGO =======================================================
   public boolean modificarAmigo(Amigos esteAmigo) {
      // CRIANDO A QUERY
      String sql = "UPDATE amigos SET amigoNome = ?, amigoEmail = ?, amigoEndereco = ?, amigoTelefone = ? WHERE amigoId = ?";

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            // CONFIGURANDO OS PARÂMETROS DA QUERY
            stmt.setString(1, esteAmigo.getAmigoNome());
            stmt.setString(2, esteAmigo.getAmigoEmail());
            stmt.setString(3, esteAmigo.getAmigoEndereco());
            stmt.setString(4, esteAmigo.getAmigoTelefone());
            stmt.setInt(5, esteAmigo.getAmigoId());

            stmt.execute();
            stmt.cancel();
         }
         return true;
      } catch (SQLException erro) {
         return false;
      }
   }

   // DELETAR UM AMIGO =========================================================
   public boolean deletarAmigo(int id) {
      // VERIFICANDO SE O AMIGO EXISTE
      Amigos desamigo = listarUmObjeto(id);
      if (desamigo.getAmigoId() != id) {
         return false;
      }

      // CRIANDO A QUERY
      String sql = "DELETE FROM amigos WHERE amigoId = " + id;

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            stmt.execute();
            stmt.cancel();
         }
         return true;
      } catch (SQLException erro) {
         return false;
      }
   }

   // RESUMO ===================================================================
   public int[] fazerResumo() {
      // CRIANDO A VARIÁVEL DE RETORNO
      int resumoAmigos[] = new int[4];

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();

         // QUANTIDADE DE AMINGOS
         ResultSet res = stmt.executeQuery("SELECT COUNT(*) AS quantidade FROM amigos");
         res.next();
         resumoAmigos[0] = res.getInt("quantidade");

         // QUANTIDADE DE AMIGOS COM EMPRÉSTIMOS
         res = stmt.executeQuery("SELECT count(DISTINCT negocios.negocioAmigoId) AS quantidade FROM negocios WHERE negocios.negocioFim >= now() AND negocios.negocioFinal IS NULL");
         res.next();
         resumoAmigos[1] = res.getInt("quantidade");

         // QUANTIDADE DE AMIGOS COM EMPRÉSTIMOS ATRASADOS
         res = stmt.executeQuery("SELECT count(DISTINCT negocios.negocioAmigoId) AS quantidade FROM negocios WHERE negocios.negocioFim < now() AND negocios.negocioFinal IS NULL");
         res.next();
         resumoAmigos[2] = res.getInt("quantidade");

         // QUANTIDADE DE AMIGOS COM EMPRÉSTIMOS DEVOLVIDOS DENTRO DO PRAZO
         // res = stmt.executeQuery("SELECT count(DISTINCT negocios.negocioAmigoId) AS quantidade FROM negocios WHERE negocios.negocioFim = negocios.negocioFinal");
         // res.next();
         // resumoAmigos[3] = res.getInt("quantidade");
         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return resumoAmigos;
   }

   // EMPRESTADOS ==============================================================
   public ArrayList<Amigos> listarEmpmrestados() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         // ResultSet res = stmt.executeQuery("SELECT amigos.amigoId, amigos.amigoNome, amigos.amigoEmail, amigos.amigoEndereco, amigos.amigoTelefone FROM amigos INNER JOIN negocios ON amigos.amigoId = negocios.negocioAmigoId WHERE negocios.negocioFim > now() GROUP BY  amigos.amigoId, amigos.amigoNome");
         ResultSet res = stmt.executeQuery("SELECT amigos.* FROM amigos INNER JOIN negocios ON amigos.amigoId = negocios.negocioAmigoId WHERE negocios.negocioFim > now() GROUP BY  amigos.amigoId, amigos.amigoNome");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO AMIGO
            int id = res.getInt("amigoId");
            String nome = res.getString("amigoNome");
            String email = res.getString("amigoEmail");
            String endereco = res.getString("amigoEndereco");
            String telefone = res.getString("amigoTelefone");

            Amigos este = new Amigos(id, nome, email, endereco, telefone);

            // ADICIONAR O AMIGO NA LISTA
            listaDeAmigos.add(este);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeAmigos;
   }

   // DEVEDORES ================================================================
   public ArrayList<Amigos> listarDevedores() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT amigos.* FROM amigos INNER JOIN negocios ON amigos.amigoId = negocios.negocioAmigoId WHERE now() > negocios.negocioFim AND negocios.negocioFinal IS NULL GROUP BY amigos.amigoId, amigos.amigoNome");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO AMIGO
            int id = res.getInt("amigoId");
            String nome = res.getString("amigoNome");
            String email = res.getString("amigoEmail");
            String endereco = res.getString("amigoEndereco");
            String telefone = res.getString("amigoTelefone");

            Amigos este = new Amigos(id, nome, email, endereco, telefone);

            // ADICIONAR O AMIGO NA LISTA
            listaDeAmigos.add(este);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeAmigos;
   }

   // OBTENDO O RANKING DOS AMIGOS COM MAIS EMPRÉSTIMOS ========================
   public ArrayList<Amigos> getRanking() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT amigos.*,  count(*) AS emprestimos FROM amigos INNER JOIN negocios ON amigos.amigoId = negocios.negocioAmigoId GROUP BY negocios.negocioAmigoId ORDER BY emprestimos DESC");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO AMIGO
            int id = res.getInt("emprestimos"); // Neste caso não interessa o ID o amigo mas sim a quantidade de empréstimos que ele já fez, então foi modificada a função desse atributo
            String nome = res.getString("amigoNome");
            String email = res.getString("amigoEmail");
            String endereco = res.getString("amigoEndereco");
            String telefone = res.getString("amigoTelefone");

            Amigos este = new Amigos(id, nome, email, endereco, telefone);

            // ADICIONAR O AMIGO NA LISTA
            listaDeAmigos.add(este);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeAmigos;
   }

   // INADIMPLENTES ============================================================
   public ArrayList<Amigos> getInadimplentes() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      // VETOR PARA ARMAZENAR A LISTA DE ID DE AMIGOS
      Vector<Integer> amigosId = new Vector<Integer>();

      // VARIÁVEIS
      int cnt1;
      int cnt2;
      String nome = "";
      String email = "";
      String endereco = "";
      String telefone = "";

      try {
         // CONECTANDO NO BANCO
         Statement stmt = super.getConexao().createStatement();

         // PEGANDO OS IDS DOS AMIGOS
         ResultSet res = stmt.executeQuery("SELECT amigoId FROM amigos");
         while (res.next()) {
            amigosId.add(res.getInt("amigoid"));
         }

         // VERIFICANDO CADA AMIGO DA LISTA
         for (Integer x : amigosId) {
            // EMPRÉSTIMOS ATIVOS
            ResultSet res1 = stmt.executeQuery("SELECT * FROM negocios INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioFinal IS NULL AND negocios.negocioFim < NOW() AND negocios.negocioAmigoId = " + x);
            cnt1 = 0;
            while (res1.next()) {
               nome = res1.getString("amigoNome");
               email = res1.getString("amigoEmail");
               endereco = res1.getString("amigoEndereco");
               telefone = res1.getString("amigoTelefone");
               cnt1++;
            }

            // EMPRÉSTIMOS ATRASADOS
            ResultSet res2 = stmt.executeQuery("SELECT * FROM negocios INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioFinal IS NOT NULL AND negocios.negocioAmigoId = " + x);
            cnt2 = 0;
            while (res2.next()) {
               cnt2++;
            }

            // SE JÁ DEVOLVEU PELO MENOS UMA, IGNORAR
            if (cnt2 > 0 || (cnt1 == 0 && cnt2 == 0)) {
               continue;
            }

            // CRIANDO UM OBJETO DE AMIGO
            Amigos este = new Amigos(cnt1, nome, email, endereco, telefone);

            // ADICIONAR O AMIGO NA LISTA
            listaDeAmigos.add(este);

         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeAmigos;
   }
}
