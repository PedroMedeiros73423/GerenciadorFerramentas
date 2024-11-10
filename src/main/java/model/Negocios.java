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
   private String negocioFerramentaNome;
   private int negocioAmigoId;
   private String negocioAmigoNome;
   private String negocioInicio;
   private String negocioFim;
   private String negocioFinal;

   // CONSTRUTORES =============================================================
   public Negocios() {
      this(0, 0, "", 0, "", "", "", "");
   }

   public Negocios(int negocioFerramentaId, int negocioAmigoId, String negocioInicio, String negocioFim, String negocioFinal) {
      this.negocioFerramentaId = negocioFerramentaId;
      this.negocioAmigoId = negocioAmigoId;
      this.negocioInicio = negocioInicio;
      this.negocioFim = negocioFim;
      this.negocioFinal = negocioFinal;
   }

   public Negocios(int negocioId, int negocioFerramentaId, String ferramentaNome, int negocioAmigoId, String amigoNome, String negocioInicio, String negocioFim, String negocioFinal) {
      this.negocioId = negocioId;
      this.negocioFerramentaId = negocioFerramentaId;
      this.negocioFerramentaNome = ferramentaNome;
      this.negocioAmigoId = negocioAmigoId;
      this.negocioAmigoNome = amigoNome;
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

   public String getNegocioFerramentaNome() {
      return negocioFerramentaNome;
   }

   public void setNegocioFerramentaNome(String negocioFerramentaNome) {
      this.negocioFerramentaNome = negocioFerramentaNome;
   }

   public String getNegocioAmigoNome() {
      return negocioAmigoNome;
   }

   public void setNegocioAmigoNome(String negocioAmigoNome) {
      this.negocioAmigoNome = negocioAmigoNome;
   }

   // OUTROS METODOS ===========================================================
   // LISTAR NEGOCIOS ==========================================================
   public ArrayList<Negocios> listarTodos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.listarNegocios();
   }

   // LISTAR EMPRÉSTIMOS NÃO DEVOLVIDOS ========================================
   public ArrayList<Negocios> listarNegociosAtrasados() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.listarNegociosAtrasados();
   }

   // LISTAR EMPRÉSTIMOS ativos ================================================
   public ArrayList<Negocios> listarNegociosAtivos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.listarNegociosAtivos();
   }

   // LISTAR UM ================================================================
   public Negocios listarUm(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.listarUmObjeto(id);
   }

   // CADASTRAR NEGOCIO ========================================================
   public boolean cadastrarNegocio(int ferramentaId, int amigoId, String inicio, String fim, String terminou) {
      // VALIDANDO OS DADOS
      if (ferramentaId == 0 || amigoId == 0) {
         return false;
      }
      // CRIANDO UM OBJETO COM O NOVO NEGÓCIO
      Negocios novoNegocio = new Negocios(ferramentaId, amigoId, inicio, fim, terminou);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.inserirNegocio(novoNegocio);

      return true;
   }

   // EDITAR NEGOCIO ===========================================================
   public boolean editarNegocio(int id, int ferramentaId, int amigoId, String inicio, String fim, String terminou) {
      // CRIANDO UM OBJETO DE NEGOCIO SOMENTE COM AS CHAVES ESTRANGEIRAS
      Negocios esteNegocio = new Negocios(id, ferramentaId, "", amigoId, "", inicio, fim, terminou);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.modificarNegocio(esteNegocio);

      return true;
   }

   // DELETAR UM NEGOCIO =======================================================
   public boolean deletarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.deletarNegocio(id);

      return true;
   }

   // ENCERRAR UM NEGOCIO ======================================================
   public boolean encerrarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.encerrarNegocio(id);

      return true;
   }

   // FINALIZAR UM NEGOCIO =====================================================
   public boolean finalizarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      db.finalizarNegocio(id);

      return true;
   }

   public int verificaPendencias(int amigoId) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.verificaPendencias(amigoId);
   }
   
      // RESUMO ===================================================================
   public int[] fazerResumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegociosDAO db = new NegociosDAO();
      return db.fazerResumo();
   }
}
