// PACOTES
package model;

// IMPORTAÇÕES
import javax.swing.JOptionPane;
import dao.FerramentasDAO;
import java.util.ArrayList;

public class Ferramentas {

   // ATRIBUTOS ================================================================
   private int ferramentaId;
   private String ferramentaNome;
   private String ferramentaMarca;
   private double ferramentaValor;

   // CONSTRUTORES =============================================================
   public Ferramentas() {
      this(0, "", "", 0);

   }

   public Ferramentas(String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
      this.ferramentaNome = ferramentaNome;
      this.ferramentaMarca = ferramentaMarca;
      this.ferramentaValor = ferramentaValor;
   }

   public Ferramentas(int ferramentaId, String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
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
   public ArrayList<Ferramentas> listarTodas() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.listarTodas();
   }

   // LISTAR UMA ===============================================================
   public Ferramentas listarUma(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.listarUmaObjeto(id);
   }

   // CADASTRAR FERRAMENTA =====================================================
   public boolean inserirFerramenta(String nome, String marca, double valor) {
      // VALIDAR OS DADOS
      if (nome.length() < 5 || marca.length() < 3 || valor <= 0) {
         return false;
      }

      // CRIANDO UM OBJETO COM A NOVA FERRAMENTA
      Ferramentas novaFerramenta = new Ferramentas(nome, marca, valor);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
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
      Ferramentas estaFerramenta = new Ferramentas(id, nome, marca, valor);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      boolean result = db.modificarFerramenta(estaFerramenta);

      return result;
   }

   // APAGAR UMA FERRAMENTA ====================================================
   public boolean deletarFerramenta(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      boolean result = db.deletarFerramenta(id);

      if (result == false) {
         JOptionPane.showMessageDialog(null, "Não foi possível deletar a ferramenta");
      }

      return result;
   }

   // LISTAR SOMENTE DISPONÍVEIS ===============================================
   public ArrayList<Ferramentas> listarDisponiveis() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.listarDisponiveis();
   }

   // BUSCARA FERRAMENTAS DISPONÍVEIS ==========================================
   public ArrayList<Ferramentas> buscarDisponiveis(String texto) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.buscarDisponiveis(texto);
   }

   // LISTAR SOMENTE EMPRESTADAS ===============================================
   public ArrayList<Ferramentas> listarEmprestadas() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.listarEmprestadas();
   }

   // RESUMO ===================================================================
   public Double[] fazerResumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.fazerResumo();
   }

   // VERIFICAR SE A FERRAMENTA TEM EMPRÉSTIMOS ================================
   public int temEmprestimos(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentasDAO db = new FerramentasDAO();
      return db.temEmprestimos(id);
   }
}
