// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigos;

public class AmigosDAO extends ServidorDAO {

   // ATRIBUTOS =============================================================
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);

      }
   }

}
