// PACOTES
package principal;

// IMPORTAÇÕES
import view.Index;

public class Principal {

   public static void main(String[] args) {
      /**
       * Instanciando e abrindo apenas a tela inicial do programa. As demais
       * telas e funcionalidades serão acessadas pela barra de menu superior.
       */
      // INSTANCIAR INTERFACE GRÁFICA
      Index dashboard = new Index();
      dashboard.setVisible(true);
      dashboard.setLocationRelativeTo(null);
   }
}
