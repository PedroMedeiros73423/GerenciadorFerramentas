// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import model.Amigo;

public class AmigoDAO extends ServidorDAO {

   // ATRIBUTOS ================================================================
   /**
    * Lista utilizada para retornar os dados de consultas feitas no banco de
    * dados. Ela precisa ser limpa antes de usar.
    */
   private final ArrayList<Amigo> listaDeAmigos = new ArrayList<>();

   // LISTAR TODOS =============================================================
   /**
    * Método para retornar todos os elementos da tabela amigos. Ele retorna uma
    * lista de objetos, onde cada objeto corresponde a uma linha da tabela.
    */
   public ArrayList<Amigo> listarTodos() {
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

            Amigo este = new Amigo(id, nome, email, endereco, telefone);

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
   /**
    * Método para buscar amigos tanto pelo nome, email ou telefone. Ele recebe
    * uma string como parâmetro e retorna uma lista de objetos com os amigos
    * encontrados na busca
    */
   public ArrayList<Amigo> buscarAmigos(String texto) {
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

            Amigo este = new Amigo(id, nome, email, endereco, telefone);

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
   /**
    * Método para retornar a quantidade de empréstidos que um determinado amigo
    * já fez. Ele recebe como parâmetro o ID do amigo. Caso o amigo não tenha
    * empréstimos retorna zero. Caso ocorra algum erro na busca, retorna um
    * número bem alto para indicar que alguma coisa está errada
    */
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
   /**
    * Método para retornar um amigo da tabela. Recebe como parâmetro o ID do
    * amigo e retorna um objeto.
    */
   public Amigo listarUmObjeto(int id) {
      // CRIANDO UM OBJETO
      Amigo amigo = new Amigo();

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

   /**
    * Método para retornar um amigo da tabela. Recebe como parâmetro o ID do
    * amigo e retorna uma lista.
    */
   public ArrayList<Amigo> listarUmLista(int id) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeAmigos.clear();

      // CRIANDO UM OBJETO
      Amigo amigo = new Amigo();

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
   /**
    * Método para cadastrar um amigo na tabela. Recebe como parâmetro um objeto
    * e insere no banco de dados. Retorna true se houve sucesso ou false em caso
    * de erro.
    */
   public boolean inserirAmigo(Amigo novoAmigo) {
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
   /**
    * Método para modificar um amigo da tabela. Recebe como parâmetro um objeto
    * de amigo, faz a modificação no banco e retorna true em caso de sucesso ou
    * false em caso de erro.
    */
   public boolean modificarAmigo(Amigo esteAmigo) {
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
   /**
    * Método para apagar um amigo da tabela. Recebe como parâmetro o ID do
    * amigo, verifica se o amigo existe, caso exista, apaga do banco. OBS.: caso
    * o amigo já possua relacionamentos ele não será apagado e será retornado
    * false.
    */
   public boolean deletarAmigo(int id) {
      // VERIFICANDO SE O AMIGO EXISTE
      Amigo desamigo = listarUmObjeto(id);
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
   /**
    * Método utilizado para fazer um resumo a respeito da tabela amigos. Quantos
    * amigos tem? Quantos possuem empréstimos ativos Quantos possuem empréstimos
    * atrasados. Retorna as informações em um array de inteiros. Usada para
    * construir o dashborad.
    */
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
   /**
    * Método para retornar somente os amigos que possuem empréstimos em dia.
    * Retorna uma lista de objetos de amigos.
    */
   public ArrayList<Amigo> listarEmpmrestados() {
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

            Amigo este = new Amigo(id, nome, email, endereco, telefone);

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
   /**
    * Método para retornar somente amigos que possuem empréstimos atrasados.
    * Retorna uma lista de objetos amigos.
    */
   public ArrayList<Amigo> listarDevedores() {
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

            Amigo este = new Amigo(id, nome, email, endereco, telefone);

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
   /**
    * Método para retornar um ranking de amigos em ordem descendente dos amigos
    * que possuem mais empréstimos. Retorna uma lista de objetos de amigos,
    * porém o ID de cada amigo é substituído pela quantidade de empréstimos que
    * ele possui
    */
   public ArrayList<Amigo> getRanking() {
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

            Amigo este = new Amigo(id, nome, email, endereco, telefone);

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
   /**
    * Método para retornar os amigos que pegaram ferramentas emprestadas mas
    * nunca devolveram nenhuma. Retorna uma lista de objetos de amigos. O
    * processo precisou ser feito no código java. Não conseguimos encontrar um
    * SQL que fizesse todo o trabalho em um único comando O RELATÓRIO MAIS
    * DIFÍCIL DE TODOS PARA FAZER
    */
   public ArrayList<Amigo> getInadimplentes() {
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
            Amigo este = new Amigo(cnt1, nome, email, endereco, telefone);

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
