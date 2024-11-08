// PACOTES
package model;

//IMPORTAÇÕES
import dao.NegociosDAO;
import java.util.ArrayList;

// IMPORTAÇÕES
public class Negocios {

   // ATRIBUTOS ================================================================
   private int negocioId;
   private int negocioFerramentaId;
   private int negocioAmigoId;
   private String negocioInicio;
   private String negocioFim;
   private String negocioFinal;

   // CONSTRUTORES =============================================================
   public Negocios() {
      this(0, 0, 0, "", "", "");
   }

   public Negocios(int negocioFerramentaId, int negocioAmigoId, String negocioInicio, String negocioFim, String negocioFinal) {
      this.negocioFerramentaId = negocioFerramentaId;
      this.negocioAmigoId = negocioAmigoId;
      this.negocioInicio = negocioInicio;
      this.negocioFim = negocioFim;
      this.negocioFinal = negocioFinal;
   }

   public Negocios(int negocioId, int negocioFerramentaId, int negocioAmigoId, String negocioInicio, String negocioFim, String negocioFinal) {
      this.negocioId = negocioId;
      this.negocioFerramentaId = negocioFerramentaId;
      this.negocioAmigoId = negocioAmigoId;
      this.negocioInicio = negocioInicio;
      this.negocioFim = negocioFim;
      this.negocioFinal = negocioFinal;
   }

   // GETTERS / SETTERS ========================================================
   public int getNegocioId() {
      return negocioId;
   }

   public int getNegocioFerramentaId() {
      return negocioFerramentaId;
   }

   public int getNegocioAmigoId() {
      return negocioAmigoId;
   }

   public String getNegocioInicio() {
      return negocioInicio;
   }

   public String getNegocioFim() {
      return negocioFim;
   }

   public String getNegocioFinal() {
      return negocioFinal;
   }

   public void setNegocioId(int negocioId) {
      this.negocioId = negocioId;
   }

   public void setNegocioFerramentaId(int negocioFerramentaId) {
      this.negocioFerramentaId = negocioFerramentaId;
   }

   public void setNegocioAmigoId(int negocioAmigoId) {
      this.negocioAmigoId = negocioAmigoId;
   }

   public void setNegocioInicio(String negocioInicio) {
      this.negocioInicio = negocioInicio;
   }

   public void setNegocioFim(String negocioFim) {
      this.negocioFim = negocioFim;
   }

   public void setNegocioFinal(String negocioFinal) {
      this.negocioFinal = negocioFinal;
   }

   // OUTROS METODOS ===========================================================
   // LISTAR NEGOCIOS ==========================================================
   public ArrayList<Negocios> listarTodos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.listarNegocios();
   }

   // LISTAR UM ================================================================
   public Negocios listarUm(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.listarUmObjeto(id);
   }

   // CADASTRAR NEGOCIO ========================================================
   public boolean cadastrarNegocio(int ferramentaId, int amigoId, String inicio, String fim, String terminou) {
      // CRIANDO UM OBJETO COM O  NOVO AMIGO
      Negocios novoNegocio = new Negocios(ferramentaId, amigoId, inicio, fim, terminou);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.inserirNegocio(novoNegocio);

      return true;
   }

   // EDITAR NEGOCIO ===========================================================
   public boolean editarNegocio(int id, int ferramentaId, int amigoId, String inicio, String fim, String terminou) {
      // CRIANDO UM OBJETO DE NEGOCIO
       Negocios esteNegocio = new Negocios(id, ferramentaId, amigoId, inicio, fim, terminou);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.modificarNegocio(esteNegocio);

      return true;
   }

   // APAGAR UM NEGOCIO ========================================================
   public boolean apagarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.deletarNegocio(id);

      return true;
   }
}
