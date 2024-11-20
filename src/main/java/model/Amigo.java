// PACOTES
package model;

// IMPORTAÇÕES
import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

   // ATRIBUTOS ================================================================
   private int amigoId;
   private String amigoNome;
   private String amigoEmail;
   private String amigoEndereco;
   private String amigoTelefone;

   // CONSTRUTORES =============================================================
   public Amigo() {
      this(0, "", "", "", "");
   }

   public Amigo(String amigoNome, String amigoEmail, String amigoEndereco, String amigoTelefone) {
      this.amigoNome = amigoNome;
      this.amigoEmail = amigoEmail;
      this.amigoEndereco = amigoEndereco;
      this.amigoTelefone = amigoTelefone;
   }

   public Amigo(int amigoId, String amigoNome, String amigoEmail, String amigoEndereco, String amigoTelefone) {
      this.amigoId = amigoId;
      this.amigoNome = amigoNome;
      this.amigoEmail = amigoEmail;
      this.amigoEndereco = amigoEndereco;
      this.amigoTelefone = amigoTelefone;
   }

   // GETTERS / SETTERS ========================================================
   public int getAmigoId() {
      return amigoId;
   }

   public String getAmigoNome() {
      return amigoNome;
   }

   public String getAmigoEmail() {
      return amigoEmail;
   }

   public String getAmigoEndereco() {
      return amigoEndereco;
   }

   public String getAmigoTelefone() {
      return amigoTelefone;
   }

   public void setAmigoId(int amigoId) {
      this.amigoId = amigoId;
   }

   public void setAmigoNome(String amigoNome) {
      this.amigoNome = amigoNome;
   }

   public void setAmigoEmail(String amigoEmail) {
      this.amigoEmail = amigoEmail;
   }

   public void setAmigoEndereco(String amigoEndereco) {
      this.amigoEndereco = amigoEndereco;
   }

   public void setAmigoTelefone(String amigoTelefone) {
      this.amigoTelefone = amigoTelefone;
   }

   // LISTAR AMIGOS ============================================================
   public ArrayList<Amigo> listarTodos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarTodos();
   }

   // LISTAR UM ================================================================
   public Amigo listarUm(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarUmObjeto(id);
   }

   // buscar AMIGO =============================================================
   public ArrayList<Amigo> buscarAmigos(String texto) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.buscarAmigos(texto);
   }

   // CADASTRAR AMIGO ==========================================================
   public boolean inserirAmigo(String nome, String email, String endereco, String telefone) {
      // VALIDANDO OS DADOS
      if (nome.length() < 5 || email.length() < 5 || endereco.length() < 5 || telefone.length() < 5) {
         return false;
      }

      // CRIANDO UM OBJETO COM O  NOVO AMIGO
      Amigo novoAmigo = new Amigo(nome, email, endereco, telefone);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      db.inserirAmigo(novoAmigo);

      return true;
   }

   // EDITAR AMIGO =============================================================
   public boolean editarAmigo(int id, String nome, String email, String endereco, String telefone) {
      // VALIDANDO OS DADOS
      if (nome.length() < 5 || email.length() < 5 || endereco.length() < 5 || telefone.length() < 5) {
         return false;
      }

      // CRIANDO UM OBJETO COM O AMIGO
      Amigo esteAmigo = new Amigo(id, nome, email, endereco, telefone);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      db.modificarAmigo(esteAmigo);

      return true;
   }

   // APAGAR UM AMIGO ==========================================================
   public boolean deletarAmigo(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      db.deletarAmigo(id);

      return true;
   }

   // LISTAR EMPRESTADOS =======================================================
   public ArrayList<Amigo> listarEmprestados() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarEmpmrestados();
   }

   // RANKING DE EMPRÉSTIMOS ===================================================
   public ArrayList<Amigo> getRanking() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.getRanking();
   }

   // LISTAR OS AMIGOS QUE NUNCA DEVOLVERAM AS FERRAMENTAS =====================
   public ArrayList<Amigo> getInadimplentes() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.getInadimplentes();
   }

   // LISTAR DEVEDORES =========================================================
   public ArrayList<Amigo> listarDevedores() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarDevedores();
   }

   // RESUMO ===================================================================
   public int[] fazerRezumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.fazerResumo();
   }

   // VERIFICAR SE O AMIGO TEM EMPRÉSTIMOS =====================================
   public int temEmprestimos(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.temEmprestimos(id);
   }
}
