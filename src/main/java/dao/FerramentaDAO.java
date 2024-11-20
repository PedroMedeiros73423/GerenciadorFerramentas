// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ferramenta;

public class FerramentaDAO extends ServidorDAO {

   // ATRIBUTOS ================================================================
   /**
    * Lista utilizada para retornar os dados de consultas feitas no banco de
    * dados. Ela precisa ser limpa antes de usar.
    */
   private final ArrayList<Ferramenta> listaDeFerramentas = new ArrayList<>();

   // LISTAR TODAS =============================================================
   /**
    * Método para retornar todos os elementos da tabela ferramentas. Ele retorna
    * uma lista de objetos, onde cada objeto corresponde a uma linha da tabela.
    */
   public ArrayList<Ferramenta> listarTodas() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeFerramentas.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DA FERRAMENTA
            int id = res.getInt("ferramentaId");
            String nome = res.getString("ferramentaNome");
            String marca = res.getString("ferramentaMarca");
            double valor = res.getDouble("ferramentaValor");

            Ferramenta esta = new Ferramenta(id, nome, marca, valor);

            // ADICIONAR A FERRAMENTA NA LISTA
            listaDeFerramentas.add(esta);
         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeFerramentas;
   }

   // LISTAR UMA ===============================================================
   /**
    * Método para retornar uma ferramenta da tabela. Recebe como parâmetro o ID
    * da ferramenta e retorna um objeto.
    */
   public Ferramenta listarUmaObjeto(int id) {
      // CRIANDO UM OBJETO
      Ferramenta ferramenta = new Ferramenta();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas WHERE ferramentaId = " + id);
         res.next();

         // PEGANDO DOS DADOS DA FERRAMENTA
         ferramenta.setFerramentaId(res.getInt("ferramentaId"));
         ferramenta.setFerramentaNome(res.getString("ferramentaNome"));
         ferramenta.setFerramentaMarca(res.getString("ferramentaMarca"));
         ferramenta.setFerramentaValor(res.getDouble("ferramentaValor"));

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return ferramenta;
   }

   /**
    * Método para retornar uma ferramenta da tabela. Recebe como parâmetro o ID
    * da ferramenta e retorna uma lista.
    */
   public ArrayList<Ferramenta> listarUmaLista(int id) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeFerramentas.clear();

      // CRIANDO UM OBJETO
      Ferramenta ferramenta = new Ferramenta();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas WHERE ferramentaId = " + id);
         res.next();

         // PEGANDO DOS DADOS DA FERRAMENTA
         ferramenta.setFerramentaId(res.getInt("ferramentaId"));
         ferramenta.setFerramentaNome(res.getString("ferramentaNome"));
         ferramenta.setFerramentaMarca(res.getString("ferramentaMarca"));
         ferramenta.setFerramentaValor(res.getDouble("ferramentaValor"));

         // ADICIONAR A FERRAMENTA NA LISTA
         listaDeFerramentas.add(ferramenta);

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return listaDeFerramentas;
   }

   // CADASTRA NOVA FERRAMENTA =================================================
   /**
    * Método para cadastrar uma ferramenta na tabela. Recebe como parâmetro um
    * objeto e insere no banco de dados. Retorna true se houve sucesso ou false
    * em caso de erro.
    */
   public boolean inserirFerramenta(Ferramenta novaFerramenta) {
      // CRIANDO A QUERY
      String sql = "INSERT INTO ferramentas(ferramentaId, ferramentaNome, ferramentaMarca, ferramentaValor) VALUES(?,?,?,?)";

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            // CONFIGURANDO OS PARÂMETROS DA QUERY
            stmt.setString(1, null);
            stmt.setString(2, novaFerramenta.getFerramentaNome());
            stmt.setString(3, novaFerramenta.getFerramentaMarca());
            stmt.setDouble(4, novaFerramenta.getFerramentaValor());

            stmt.execute();
            stmt.cancel();
         }

         return true;
      } catch (SQLException erro) {
         return false;
      }
   }

   // MODIFICAR UMA FERRAMENTA =================================================
   /**
    * Método para modificar uma ferramenta da tabela. Recebe como parâmetro um
    * objeto de ferramenta, faz a modificação no banco e retorna true em caso de
    * sucesso ou false em caso de erro.
    */
   public boolean modificarFerramenta(Ferramenta estaFerramenta) {
      // CRIANDO A QUERY
      String sql = "UPDATE ferramentas SET ferramentaNome = ?, ferramentaMarca = ?, ferramentaValor = ? WHERE ferramentaId = ?";

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            // CONFIGURANDO OS PARÂMETROS DA QUERY
            stmt.setString(1, estaFerramenta.getFerramentaNome());
            stmt.setString(2, estaFerramenta.getFerramentaMarca());
            stmt.setDouble(3, estaFerramenta.getFerramentaValor());
            stmt.setInt(4, estaFerramenta.getFerramentaId());

            stmt.execute();
            stmt.cancel();
         }

         return true;
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // DELETAR UMA FERRAMENTA ===================================================
   /**
    * Método para apagar uma ferramenta da tabela. Recebe como parâmetro o ID da
    * ferramenta, verifica se a ferramenta existe, caso exista, apaga do banco.
    * OBS.: caso a ferramenta já possua relacionamentos ela não será apagada e
    * será retornado false.
    */
   public boolean deletarFerramenta(int id) {
      // VERIFICANDO SE A FERRAMENTA EXISTE
      Ferramenta estragada = listarUmaObjeto(id);
      if (estragada.getFerramentaId() != id) {
         return false;
      }

      // CRIANDO A QUERY
      String sql = "DELETE FROM ferramentas WHERE ferramentaId = " + id;

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
    * Método utilizado para fazer um resumo a respeito da tabela ferramentas.
    * Quantas ferramentas tem? Quanto se gastou para comprar todas elas? Usada
    * para construir o dashborad.
    */
   public Double[] fazerResumo() {
      // CRIANDO O ARRAY DE RETORNO
      Double[] resumoFerramentas = new Double[2];

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT COUNT(*) AS quantidade, sum(ferramentas.ferramentaValor) As investimento FROM ferramentas");
         res.next();

         // PEGANDO DOS DADOS DO RESUMO
         resumoFerramentas[0] = Double.valueOf(res.getInt("quantidade"));
         resumoFerramentas[1] = res.getDouble("investimento");

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }

      return resumoFerramentas;
   }

   // LISTAR TODAS DISPONÍVEIS =================================================
   /**
    * Método utilizado para retornar uma lista de ferramentas que estão
    * disponíveis para empréstimos. Retorna uma lista de objetos.
    */
   public ArrayList<Ferramenta> listarDisponiveis() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeFerramentas.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         // ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas LEFT JOIN negocios ON ferramentas.ferramentaId = negocios.negocioFerramentaId WHERE (negocios.negocioId IS NULL OR negocios.negocioFinal IS NOT NULL) AND negocios.negocioFim != negocios.negocioFinal");
         ResultSet res = stmt.executeQuery("SELECT distinct ferramentas.* FROM ferramentas WHERE ferramentas.ferramentaId NOT IN (SELECT DISTINCT negocios.negocioFerramentaId FROM negocios)");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DA FERRAMENTA
            int id = res.getInt("ferramentaId");
            String nome = res.getString("ferramentaNome");
            String marca = res.getString("ferramentaMarca");
            double valor = res.getDouble("ferramentaValor");

            Ferramenta esta = new Ferramenta(id, nome, marca, valor);

            // ADICIONAR A FERRAMENTA NA LISTA
            listaDeFerramentas.add(esta);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeFerramentas;
   }

   // BUSCAR FERRAMENTAS DISPONÍVEIS ===========================================
   /**
    * Método utilizado para retornar uma lista de ferramentas que estão
    * disponíveis para empréstimos. Porém este método também recebe um parâmetro
    * que permite pesquisar pelo nome ou pela marca da ferramenta. Retorna uma
    * lista de objetos.
    */
   public ArrayList<Ferramenta> buscarDisponiveis(String texto) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeFerramentas.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         // ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas LEFT JOIN negocios ON ferramentas.ferramentaId = negocios.negocioFerramentaId WHERE ((negocios.negocioId IS NULL OR negocios.negocioFinal IS NOT NULL) AND negocios.negocioFim != negocios.negocioFinal) AND (ferramentas.ferramentaNome LIKE '%" + texto + "%' OR ferramentas.ferramentaMarca LIKE '%" + texto + "%')");
         ResultSet res = stmt.executeQuery("SELECT DISTINCT ferramentas.* FROM ferramentas WHERE ferramentas.ferramentaId NOT IN (SELECT DISTINCT negocios.negocioFerramentaId FROM negocios) AND (ferramentas.ferramentaNome LIKE '%" + texto + "%' OR ferramentas.ferramentaMarca LIKE '%" + texto + "%')");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DA FERRAMENTA
            int id = res.getInt("ferramentaId");
            String nome = res.getString("ferramentaNome");
            String marca = res.getString("ferramentaMarca");
            double valor = res.getDouble("ferramentaValor");

            Ferramenta esta = new Ferramenta(id, nome, marca, valor);

            // ADICIONAR A FERRAMENTA NA LISTA
            listaDeFerramentas.add(esta);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeFerramentas;
   }

   // SABER SE A FERRAMENTA JÁ FOI EMPRESTADA ==================================
   /**
    * Método utilizado para saber se o amigo que está fazendo um empréstimo possui
    * ferramentas emprestadas que já expiraram o prazo e ele ainda não devolveu.
    * Retorna a quantidade de ferramentas não devolvidas pelo amigo. Caso ocorra
    * um erro na consulta retorna um número bem grande para indicar que algo
    * está errado.
    */
   public int temEmprestimos(int id) {
      // DEFININDO UMA QUANTIDADE INICIAL
      int quantidade = 99;

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT count(*) AS quantidade FROM ferramentas LEFT JOIN negocios ON ferramentas.ferramentaId = negocios.negocioFerramentaId WHERE negocios.negocioFerramentaId = " + id);

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

   // LISTAR TODAS EMPRESTADAS =================================================
   /**
    * Método utilizado para todas as ferramentas que estão emprestadas, não
    * importa se dentro do prazo ou com o prazo ja expirado. Retorna uma lista
    * de objetos.
    */
   public ArrayList<Ferramenta> listarEmprestadas() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeFerramentas.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas INNER JOIN negocios ON ferramentas.ferramentaId = negocios.negocioFerramentaId WHERE negocios.negocioFinal IS NULL");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DA FERRAMENTA
            int id = res.getInt("ferramentaId");
            String nome = res.getString("ferramentaNome");
            String marca = res.getString("ferramentaMarca");
            double valor = res.getDouble("ferramentaValor");

            Ferramenta esta = new Ferramenta(id, nome, marca, valor);

            // ADICIONAR A FERRAMENTA NA LISTA
            listaDeFerramentas.add(esta);
         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeFerramentas;
   }
}
