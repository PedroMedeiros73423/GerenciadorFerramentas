// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Negocios;

public class NegociosDAO extends ServidorDAO {

   // ATRIBUTOS =============================================================
   private final ArrayList<Negocios> listaDeNegocios = new ArrayList<>();

   // LISTAR TODAS =============================================================
   public ArrayList<Negocios> listarNegocios() {
      // LIMPAR A LISTA ANTES DE INSERIR ALGO NELA
      listaDeNegocios.clear();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM negocios");

         // PROCESSANDO CADA LINHA RETORNADA DO BANCO
         while (res.next()) {
            // PEGANDO DOS DADOS DA FERRAMENTA
            int id = res.getInt("negocioId");
            int ferramentaId = res.getInt("negocioFerramentaId");
            int amigoId = res.getInt("negocioAmigoId");
            String inicio = res.getString("negocioInicio");
            String fim = res.getString("negocioFim");
            String terminou = res.getString("negocioFinal");

            Negocios este = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);

            // ADICIONAR O NEGOCIO NA LISTA
            listaDeNegocios.add(este);
         }
         stmt.close();

      } catch (SQLException ex) {
         System.out.println("Erro:" + ex);
      }

      // RETORNAR A LISTA
      return listaDeNegocios;
   }

   // LISTAR UMA ===============================================================
   public Negocios listarUmObjeto(int id) {
      // CRIANDO UM OBJETO
      Negocios negocio = new Negocios();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM negocios WHERE negocioId = " + id);
         res.next();

         // PEGANDO DOS DADOS DO NEGOCIO
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
      // CRIANDO UM OBJETO
      Negocios negocio = new Negocios();

      try {
         // FAZENDO A BUSCA NO BANCO DE DADOS
         Statement stmt = super.getConexao().createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM negocios WHERE negocioId = " + id);
         res.next();

         // PEGANDO DOS DADOS DO NEGOCIO
         negocio.setNegocioId(res.getInt("negocioId"));
         negocio.setNegocioFerramentaId(res.getInt("negocioFerramentaId"));
         negocio.setNegocioAmigoId(res.getInt("negocioAmigoId"));
         negocio.setNegocioInicio(res.getString("negocioInicio"));
         negocio.setNegocioFim(res.getString("negocioFim"));
         negocio.setNegocioFinal(res.getString("negocioFinal"));

         // ADICIONAR A FERRAMENTA NA LISTA
         listaDeNegocios.add(negocio);

         stmt.close();
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
      }
      return listaDeNegocios;
   }

   // CADASTRA NOVO NEGOCIO ===================================================
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
            stmt.setString(6, novoNegocio.getNegocioFinal());

            stmt.execute();
            stmt.cancel();
         }

         return true;
      } catch (SQLException erro) {
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // MODIFICAR UMA FERRAMENTA =================================================
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
   
   // DELETAR UMA FERRAMENTA ===================================================
   public boolean deletarNegocio(int id) {
      // VERIFICANDO SE A FERRAMENTA EXISTE
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

}
