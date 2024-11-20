// PACOTES
package model;

// IMPORTAÇÕES
import javax.swing.JOptionPane;
import dao.FerramentaDAO;
import java.util.ArrayList;

public class Ferramenta {

   // ATRIBUTOS ================================================================
   private int ferramentaId;
   private String ferramentaNome;
   private String ferramentaMarca;
   private double ferramentaValor;

   // CONSTRUTORES =============================================================
   public Ferramenta() {
      this(0, "", "", 0);

   }

   public Ferramenta(String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
      this.ferramentaNome = ferramentaNome;
      this.ferramentaMarca = ferramentaMarca;
      this.ferramentaValor = ferramentaValor;
   }

   public Ferramenta(int ferramentaId, String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
      this.ferramentaId = ferramentaId;
      this.ferramentaNome = ferramentaNome;
      this.ferramentaMarca = ferramentaMarca;
      this.ferramentaValor = ferramentaValor;
   }

   // GETTERS / SETTERS ========================================================
   public int getFerramentaId() {
      return ferramentaId;
   }

   public String getFerramentaNome() {
      return ferramentaNome;
   }

   public String getFerramentaMarca() {
      return ferramentaMarca;
   }

   public double getFerramentaValor() {
      return ferramentaValor;
   }

   public void setFerramentaId(int ferramentaId) {
      this.ferramentaId = ferramentaId;
   }

   public void setFerramentaNome(String ferramentaNome) {
      this.ferramentaNome = ferramentaNome;
   }

   public void setFerramentaMarca(String ferramentaMarca) {
      this.ferramentaMarca = ferramentaMarca;
   }

   public void setFerramentaValor(double ferramentaValor) {
      if (ferramentaValor < 0) {
         ferramentaValor = 0;
      }

      this.ferramentaValor = ferramentaValor;
   }

   // OUTROS METODOS 
   // LISTAR FERRAMENTAS =======================================================
   public ArrayList<Ferramenta> listarTodas() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarTodas();
   }

   // LISTAR UMA ===============================================================
   public Ferramenta listarUma(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarUmaObjeto(id);
   }

   // CADASTRAR FERRAMENTA =====================================================
   public boolean inserirFerramenta(String nome, String marca, double valor) {
      // VALIDAR OS DADOS
      if (nome.length() < 5 || marca.length() < 3 || valor <= 0) {
         return false;
      }

      // CRIANDO UM OBJETO COM A NOVA FERRAMENTA
      Ferramenta novaFerramenta = new Ferramenta(nome, marca, valor);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      boolean result = db.inserirFerramenta(novaFerramenta);

      return result;
   }

   // EDITAR FERRAMENTA ========================================================
   public boolean editarFerramenta(int id, String nome, String marca, double valor) {
      // VALIDAR OS DADOS
      if (nome.length() < 5 || marca.length() < 3 || valor <= 0) {
         return false;
      }

      // CRIANDO UM OBJETO COM A FERRAMENTA
      Ferramenta estaFerramenta = new Ferramenta(id, nome, marca, valor);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      boolean result = db.modificarFerramenta(estaFerramenta);

      return result;
   }

   // APAGAR UMA FERRAMENTA ====================================================
   public boolean deletarFerramenta(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      boolean result = db.deletarFerramenta(id);

      if (result == false) {
         JOptionPane.showMessageDialog(null, "Não foi possível deletar a ferramenta");
      }

      return result;
   }

   // LISTAR SOMENTE DISPONÍVEIS ===============================================
   public ArrayList<Ferramenta> listarDisponiveis() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarDisponiveis();
   }

   // BUSCARA FERRAMENTAS DISPONÍVEIS ==========================================
   public ArrayList<Ferramenta> buscarDisponiveis(String texto) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.buscarDisponiveis(texto);
   }

   // LISTAR SOMENTE EMPRESTADAS ===============================================
   public ArrayList<Ferramenta> listarEmprestadas() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarEmprestadas();
   }

   // RESUMO ===================================================================
   public Double[] fazerResumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.fazerResumo();
   }

   // VERIFICAR SE A FERRAMENTA TEM EMPRÉSTIMOS ================================
   public int temEmprestimos(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.temEmprestimos(id);
   }
}
