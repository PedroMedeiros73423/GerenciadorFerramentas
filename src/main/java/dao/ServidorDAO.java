// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServidorDAO {

   // ATRIBUTOS ================================================================
   /**
    * Configurar nesses atributos o servidor, a porta, o banco de dados, usuário
    * e senha.
    */
   private final String server = "127.0.0.1";
   private final int port = 3306;
   private final String database = "ferramentas";
   private final String user = "root";
   private final String password = "unisul";
   private final String url = "jdbc:mysql://" + server + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC";

   // CONEXÃO COM O BANCO ======================================================
   /**
    * Método utilizado para criar a conexão com o servidor de banco de dados.
    * Retorna um objeto do tipo Connection ou imprime no terminal algumas
    * mensagens de erro caso não seja possível fazer a conexão.
    */
   public Connection getConexao() {
      // CRIAR A CONEXÃO
      Connection connection = null;

      // CONECTAR
      try {
         // CARREGAMENTO DO JDBC DRIVER
         String driver = "com.mysql.cj.jdbc.Driver";
         Class.forName(driver);

         // CONECTANDO NO BANCO
         connection = DriverManager.getConnection(url, user, password);

         // TESTANDO..
//         if (connection != null) {
//            System.out.println("Status: Conectado!");
//         } else {
//            System.out.println("Status: NÃO CONECTADO!");
//         }
         return connection;

      } catch (ClassNotFoundException e) {
         // DRIVER NÃO ENCONTRADO
         System.out.println("\nO DRIVER NAO FOI ENCONTRADO: " + e.getMessage());
         return null;
      } catch (SQLException e) {
         // ERRO DE AUTENTICAÇÃO
         System.out.println("NAO FOI POSSIVEL CONECTAR NO SERVIDOR DE BANCO DE DADOS");
         return null;
      }
   }

}
