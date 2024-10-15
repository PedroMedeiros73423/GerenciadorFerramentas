// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ferramentas;

public class FerramentasDAO extends ServidorDAO {

   // ATRIBUTOS =============================================================
   private final ArrayList<Ferramentas> listaDeFerramentas = new ArrayList<>();

   // LISTAR TODAS =============================================================
   public ArrayList<Ferramentas> listarTodas() {
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

            Ferramentas esta = new Ferramentas(id, nome, marca, valor);

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
   public Ferramentas listarUmaObjeto(int id) {
      // CRIANDO UM OBJETO
      Ferramentas ferramenta = new Ferramentas();

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

   public ArrayList<Ferramentas> listarUmaLista(int id) {
      // CRIANDO UM OBJETO
      Ferramentas ferramenta = new Ferramentas();

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
   public boolean inserirFerramenta(Ferramentas novaFerramenta) {
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);
      }
   }

   // MODIFICAR UMA FERRAMENTA =================================================
   public boolean modificarFerramenta(Ferramentas estaFerramenta) {
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
   public boolean deletarFerramenta(int id) {
      // VERIFICANDO SE O AMIGO EXISTE
      Ferramentas estragada = listarUmaObjeto(id);
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
         System.out.println("Erro:" + erro);
         throw new RuntimeException(erro);

      }
   }
}
