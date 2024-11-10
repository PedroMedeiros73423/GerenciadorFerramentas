// PACOTES
package principal;

// IMPORTAÇÕES
import view.Index;

public class Principal {
   public static void main(String[] args) {
      // INSTANCIAR INTERFACE GRÁFICA
      Index dashboard = new Index();
      dashboard.setVisible(true);
      dashboard.setLocationRelativeTo(null);
   }
}
