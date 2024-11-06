// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigos;
import model.Ferramentas;
import model.Negocios;

public class NegociosDAO extends ServidorDAO {

   // ATRIBUTOS =============================================================
   private final ArrayList<Negocios> listaDeNegocios = new ArrayList<>();

   // LISTAR TODOS =============================================================
   // RELATÓRIO DE TODOS OS NEGÓCIOS REALIZADOS
   public ArrayList<Negocios> listarNegocios() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM negocios");
         // ResultSet res = stmt.executeQuery("SELECT negocioId, ferramentas.ferramentaNome AS negocioFerramentaId, amigos.amigoNome AS negocioAmigoId, negocioInicio, negocioFim, negocioFinal FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId  INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId ORDER BY negocioId");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            int amigoId = res.getInt("negocioAmigoId");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocios este = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);

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

   // LISTAR TODOS join =============================================================
   // RELATÓRIO DE TODOS OS NEGÓCIOS REALIZADOS
   public String listarNegociosJoin() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
//      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT negocioId, ferramentas.ferramentaNome AS negocioFerramentaId, amigos.amigoNome AS negocioAmigoId, negocioInicio, negocioFim, negocioFinal FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId  INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId ORDER BY negocioId");

         System.out.println(res.getRow());

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
//         while (res.next()) {
//            // PEGANDO DOS DADOS DO NEGÓCIO
//            int id = res.getInt("negocioId");
//            int ferramentaId = res.getInt("negocioFerramentaId");
//            int amigoId = res.getInt("negocioAmigoId");
//            String inicio = res.getString("negocioInicio");
//            String fim = res.getString("negocioFim");
//            String terminou = res.getString("negocioFinal");
//
//            Negocios este = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);
//
//            // ADICIONAR O NEGÓCIO NA LISTA
//            listaDeNegocios.add(este);
//         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return "";
   }

   // LISTAR UM ================================================================
   public Negocios listarUmObjeto(int id) {
      // CRIANDO UM OBJETO
      Negocios negocio = new Negocios();

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

   public ArrayList<Negocios> listarUmLista(int id) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      // CRIANDO UM OBJETO
      Negocios negocio = new Negocios();

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
      return listaDeNegocios;
   }

   // CADASTRA NOVO NEGÓCIO ===================================================
   public boolean inserirNegocio(Negocios novoNegocio) {
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // MODIFICAR UM NEGÓCIO =====================================================
   public boolean modificarNegocio(Negocios esteNegocio) {
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // DELETAR UM NEGÓCIO =======================================================
   public boolean deletarNegocio(int id) {
      // VERIFICANDO SE O NEGÓCIO EXISTE
      Negocios desfeito = listarUmObjeto(id);
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);

      }
   }

   // ENCERRAR UM NEGÓCIO ======================================================
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // FINALIZAR UM NEGÓCIO =====================================================
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // LISTAR NEGÓCIOS ATIVOS ===================================================
   // RELATÓRIO LISTAR NEGÓCIOS ATIVOS
   public ArrayList<Negocios> listarNegociosAtivos() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT negocioId, ferramentas.ferramentaNome AS negocioFerramentaId, amigos.amigoNome AS negocioAmigoId, negocioInicio, negocioFim, negocioFinal FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId  INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioFim > now()");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            int amigoId = res.getInt("negocioAmigoId");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocios este = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);

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
   // RELATÓRIO LISTAR TODOS OS NEGÓCIOS ATRASADOS
   public ArrayList<Negocios> listarNegociosAtrasados() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT negocioId, ferramentas.ferramentaNome AS negocioFerramentaId, amigos.amigoNome AS negocioAmigoId, negocioInicio, negocioFim, negocioFinal FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId  INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioFim < now() AND negocios.negocioFim != negocios.negocioFinal");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            int amigoId = res.getInt("negocioAmigoId");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocios este = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);

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

   // LISTAR NEGÓCIOS ATRASADOS ================================================
   // RELATÓRIO LISTAR NEGÓCIOS ATRASADOS PARA UM AMIGO ESPECÍFICO
   public ArrayList<Negocios> verificarNegociosAtrasados(int suspeito) {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT negocioId, ferramentas.ferramentaNome AS negocioFerramentaId, amigos.amigoNome AS negocioAmigoId, negocioInicio, negocioFim, negocioFinal FROM `negocios` INNER JOIN ferramentas ON negocios.negocioFerramentaId = ferramentas.ferramentaId  INNER JOIN amigos ON negocios.negocioAmigoId = amigos.amigoId WHERE negocios.negocioAmigoId = " + suspeito + " AND negocios.negocioFim < now() AND negocios.negocioFim != negocios.negocioFinal");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DO NEGÓCIO
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            int amigoId = res.getInt("negocioAmigoId");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocios este = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);

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
}
