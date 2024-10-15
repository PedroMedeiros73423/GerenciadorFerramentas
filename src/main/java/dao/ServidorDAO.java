// PACOTES
package dao;

// IMPORTAÇÕES
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServidorDAO {

   // ATRIBUTOS ================================================================
   private final String server = "8.8.8.8";
   private final int port = 3306;
   private final String database = "ferramentas";
   private final String user = "sergey";
   private final String password = "euNaoSerTaLoco!";
   private final String url = "jdbc:mysql://" + server + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC";

   // CONEXÃO COM O BANCO ======================================================
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
