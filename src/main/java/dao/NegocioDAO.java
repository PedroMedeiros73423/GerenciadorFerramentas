// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Negocio;

public class NegocioDAO extends ServidorDAO {

   // ATRIBUTOS ================================================================
   /**
    * Lista utilizada para retornar os dados de consultas feitas no banco de
    * dados. Ela precisa ser limpa antes de usar.
    */
   private final ArrayList<Negocio> listaDeNegocios = new ArrayList<>();

   // LISTAR TODOS =============================================================
   /**
    * Método para retornar todos os elementos da tabela negócios. Ele retorna
    * uma lista de objetos, onde cada objeto corresponde a uma linha da tabela.
    */
   public ArrayList<Negocio> listarNegocios() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId  INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId ORDER BY negocioId");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            String ferramentaNome = res.getString("ferramentaNome");
            int amigoId = res.getInt("negocioAmigoId");
            String amigoNome = res.getString("amigoNome");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocio este = new Negocio(id, ferramentaId, ferramentaNome, amigoId, amigoNome, inicio, fim, terminou);

            // ADICIONAR O NEGÓCIO NA LISTA
            listaDeNegocios.add(este);
         }
         stmt.close();
      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeNegocios;
   }

   // LISTAR UM ================================================================
   /**
    * Método para retornar um empréstimo da tabela. Recebe como parâmetro o ID
    * do empréstimo e retorna um objeto.
    */
   public Negocio listarUmObjeto(int id) {
      // CRIANDO UM OBJETO
      Negocio negocio = new Negocio();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM negocios WHERE negocioId = " + id);
         res.next();

         // PEGANDO DOS DADOS DO NEGÓCIO
         negocio.setNegocioId(res.getInt("negocioId"));
         negocio.setNegocioFerramentaId(res.getInt("negocioFerramentaId"));
         negocio.setNegocioAmigoId(res.getInt("negocioAmigoId"));
         negocio.setNegocioInicio(res.getString("negocioInicio"));
         negocio.setNegocioFim(res.getString("negocioFim"));
         negocio.setNegocioFinal(res.getString("negocioFinal"));

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return negocio;
   }

   /**
    * Método para retornar um empréstimo da tabela. Recebe como parâmetro o ID
    * do empréstimo e retorna uma lista.
    */
   public ArrayList<Negocio> listarUmLista(int id) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      // CRIANDO UM OBJETO
      Negocio negocio = new Negocio();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM negocios WHERE negocioId = " + id);
         res.next();

         // PEGANDO DOS DADOS DO NEGÓCIO
         negocio.setNegocioId(res.getInt("negocioId"));
         negocio.setNegocioFerramentaId(res.getInt("negocioFerramentaId"));
         negocio.setNegocioAmigoId(res.getInt("negocioAmigoId"));
         negocio.setNegocioInicio(res.getString("negocioInicio"));
         negocio.setNegocioFim(res.getString("negocioFim"));
         negocio.setNegocioFinal(res.getString("negocioFinal"));

         // ADICIONAR O NEGÓCIO NA LISTA
         listaDeNegocios.add(negocio);

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }

      // RETORNAR A LISTA
      return listaDeNegocios;
   }

   // CADASTRA NOVO NEGÓCIO ===================================================
   /**
    * Método para cadastrar um empreésitmo na tabela. Recebe como parâmetro um
    * objeto e insere no banco de dados. Retorna true se houve sucesso ou false
    * em caso de erro.
    */
   public boolean inserirNegocio(Negocio novoNegocio) {
      // CRIANDO A QUERY
      String sql = "INSERT INTO negocios(negocioId, negocioFerramentaId, negocioAmigoId, negocioInicio, negocioFim, negocioFinal) VALUES(?,?,?,?,?,?)";

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            // CONFIGURANDO OS PARÂMETROS DA QUERY
            stmt.setString(1, null);
            stmt.setInt(2, novoNegocio.getNegocioFerramentaId());
            stmt.setInt(3, novoNegocio.getNegocioAmigoId());
            stmt.setString(4, novoNegocio.getNegocioInicio());
            stmt.setString(5, novoNegocio.getNegocioFim());
            // stmt.setString(6, novoNegocio.getNegocioFinal());
            // stmt.setString(6, "0000-00-00 00:00:00");
            stmt.setString(6, null);

            stmt.execute();
            stmt.cancel();
         }
         return true;
      } catch (SQLException erro) {
         return false;
      }
   }

   // MODIFICAR UM NEGÓCIO =====================================================
   /**
    * Método para modificar um empréstimo da tabela. Recebe como parâmetro um
    * objeto de empréstimo, faz a modificação no banco e retorna true em caso de
    * sucesso ou false em caso de erro.
    */
   public boolean modificarNegocio(Negocio esteNegocio) {
      // CRIANDO A QUERY
      String sql = "UPDATE negocios SET negocioFerramentaId = ?, negocioAmigoId = ?, negocioInicio = ?, negocioFim = ?, negocioFinal = ?  WHERE negocioId = ?";

      try {
         try (
            // PREPARANDO A CONEXÃO COM O BANCO
             PreparedStatement stmt = super.getConexao().prepareStatement(sql)) {

            // CONFIGURANDO OS PARÂMETROS DA QUERY
            stmt.setInt(1, esteNegocio.getNegocioFerramentaId());
            stmt.setInt(2, esteNegocio.getNegocioAmigoId());
            stmt.setString(3, esteNegocio.getNegocioInicio());
            stmt.setString(4, esteNegocio.getNegocioFim());
            stmt.setString(5, esteNegocio.getNegocioFinal());
            stmt.setInt(6, esteNegocio.getNegocioId());

            stmt.execute();
            stmt.cancel();
         }
         return true;
      } catch (SQLException erro) {
         return false;
      }
   }

   // DELETAR UM NEGÓCIO =======================================================
   /**
    * Método para apagar um empréstimo da tabela. Recebe como parâmetro o ID do
    * empréstimo, verifica se o empréstimo existe, caso exista, apaga do banco.
    */
   public boolean deletarNegocio(int id) {
      // VERIFICANDO SE O NEGÓCIO EXISTE
      Negocio desfeito = listarUmObjeto(id);
      if (desfeito.getNegocioId() != id) {
         return false;
      }

      // CRIANDO A QUERY
      String sql = "DELETE FROM negocios WHERE negocioId = " + id;

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

   // ENCERRAR UM NEGÓCIO ======================================================
   /**
    * Método para finalizar um empréstimo. Só é utilizado quando o amigo devolve
    * a ferramenta dentro do prazo do empréstimo. Ele altera a coluna negocioFim
    * e preenche a coluna negocioFinal com a data e hora em que o empréstimo foi
    * encerrado.
    */
   public boolean encerrarNegocio(int id) {
      // CRIANDO A QUERY
      String sql = "UPDATE negocios SET negocioFim = now(), negocioFinal = now() WHERE negocioId = " + id;

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

   // FINALIZAR UM NEGÓCIO =====================================================
   /**
    * Método para terminar um empréstimo. Só é utilizado quando o amigo devolve
    * a ferramenta com o prazo expirado. Ele preenche a coluna negocioFinal com
    * a data e hora em que o empréstimo foi encerrado. Dessa forma é mantido o
    * histórico de quais ferramentas foram devolvidas dora do prazo.
    */
   public boolean finalizarNegocio(int id) {
      // CRIANDO A QUERY
      String sql = "UPDATE negocios SET negocioFinal = now() WHERE negocioId = " + id;

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

   // LISTAR NEGÓCIOS ATIVOS ===================================================
   /**
    * Método para listar somente empréstimos que estão dentro do prazo legal.
    * Retorna uma lista de objetos.
    */
   public ArrayList<Negocio> listarNegociosAtivos() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioFinal IS NULL");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            String ferramentaNome = res.getString("ferramentaNome");
            int amigoId = res.getInt("negocioAmigoId");
            String amigoNome = res.getString("amigoNome");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocio este = new Negocio(id, ferramentaId, ferramentaNome, amigoId, amigoNome, inicio, fim, terminou);

            // ADICIONAR O NEGÓCIO NA LISTA
            listaDeNegocios.add(este);
         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeNegocios;
   }

   // LISTAR NEGÓCIOS ATRASADOS ===================================================
   /**
    * Método para listar somente empréstimos que estão fora do prazo legal.
    * Retorna uma lista de objetos.
    */
   public ArrayList<Negocio> listarNegociosAtrasados() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioFim < now() AND negocios.negocioFinal IS NULL");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            String ferramentaNome = res.getString("ferramentaNome");
            int amigoId = res.getInt("negocioAmigoId");
            String amigoNome = res.getString("amigoNome");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocio este = new Negocio(id, ferramentaId, ferramentaNome, amigoId, amigoNome, inicio, fim, terminou);

            // ADICIONAR O NEGÓCIO NA LISTA
            listaDeNegocios.add(este);
         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeNegocios;
   }

   // VERIFICAR SE UM AMIGO TEM PENDÊNCIAS =====================================
   /**
    * Método para verificar se o amigo que está pedindo uma ferramenta
    * emprestada possui ferramentas emprestadas e não devolvidas no prazo.
    * Retorna a quantidade de ferramentas que o amigo não devolveu. Caso ocorra
    * algum erro na consulta retorna um número bem grande para indicar que
    * alguma coisa está errada.
    */
   public int verificaPendencias(int amigoId) {
      // DEFININDO UMA QUANTIDADE INICIAL
      int quantidade = 99;

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT count(*) AS quantidade FROM `negocios` WHERE negocios.negocioAmigoId = " + amigoId + " AND negocios.negocioFim < now() AND negocios.negocioFinal IS NULL");

         // PROCESSANDO A RESPOSTA
         while (res.next()) {
            quantidade = res.getInt("quantidade");
         }

         // RETORNANDO O VALOR
         stmt.close();
         return quantidade;
      } catch (SQLException ex) {
         // COMO NÃO FOI POSSÍVEL CONSULTAR NO BANCO, ALERTA O USUÁRIO COM UM NOMERO GRANDE
         return 1000;
      }
   }

   // RESUMO ===================================================================
   /**
    * Método utilizado para fazer um resumo a respeito da tabela negócios.
    * Quantos empréstimos existe? Quanto empréstimos estão em dia? Quantos
    * empréstimos estão atrasados? Retorna um array de inteiros com as
    * informações do resumo. Usada para construir o dashborad.
    */
   public int[] fazerResumo() {
      // CRIANDO O ARRAY DE RETORNO
      int[] resumoNegocios = new int[3];

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();

         // QUANTIDADE DE EMPRESTIMOS
         ResultSet res = stmt.executeQuery("SELECT COUNT(*) AS quantidade FROM negocios");
         res.next();
         resumoNegocios[0] = res.getInt("quantidade");

         // QUANTIDADE DE EMPRESTIMOS EM DIA
         res = stmt.executeQuery("SELECT COUNT(*) AS quantidade FROM negocios WHERE negocios.negocioFim >= now() AND negocios.negocioFinal IS NULL");
         res.next();
         resumoNegocios[1] = res.getInt("quantidade");

         // QUANTIDADE DE EMPRESTIMOS EM DIA
         res = stmt.executeQuery("SELECT COUNT(*) AS quantidade FROM negocios WHERE negocios.negocioFim < now() AND negocios.negocioFinal IS NULL");
         res.next();
         resumoNegocios[2] = res.getInt("quantidade");

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }

      // RETORNAR O RESUMO
      return resumoNegocios;
   }
}
