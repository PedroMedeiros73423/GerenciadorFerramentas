// PACOTES
package model;

// IMPORTAÇÕES
import javax.swing.JOptionPane;
import dao.AmigosDAO;
import java.util.ArrayList;

public class Amigos {

   // ATRIBUTOS ================================================================
   private int amigoId;
   private String amigoNome;
   private String amigoEmail;
   private String amigoEndereco;
   private String amigoTelefone;

   // CONSTRUTORES =============================================================
   public Amigos() {
      this(0, "", "", "", "");
   }

   public Amigos(String amigoNome, String amigoEmail, String amigoEndereco, String amigoTelefone) {
      this.amigoNome = amigoNome;
      this.amigoEmail = amigoEmail;
      this.amigoEndereco = amigoEndereco;
      this.amigoTelefone = amigoTelefone;
   }

   public Amigos(int amigoId, String amigoNome, String amigoEmail, String amigoEndereco, String amigoTelefone) {
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
   public ArrayList<Amigos> listarTodos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.listarTodos();
   }

   // LISTAR UM ================================================================
   public Amigos listarUm(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.listarUmObjeto(id);
   }

   // buscar AMIGO =============================================================
   public ArrayList<Amigos> buscarAmigos(String texto) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.buscarAmigos(texto);
   }

   // CADASTRAR AMIGO ==========================================================
   public boolean inserirAmigo(String nome, String email, String endereco, String telefone) {
      // VALIDANDO OS DADOS
      if (nome.length() < 5 || email.length() < 5 || endereco.length() < 5 || telefone.length() < 5) {
         return false;
      }

      // CRIANDO UM OBJETO COM O  NOVO AMIGO
      Amigos novoAmigo = new Amigos(nome, email, endereco, telefone);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
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
      Amigos esteAmigo = new Amigos(id, nome, email, endereco, telefone);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      db.modificarAmigo(esteAmigo);

      return true;
   }

   // APAGAR UM AMIGO ==========================================================
   public boolean deletarAmigo(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      db.deletarAmigo(id);

      return true;
   }

   // LISTAR EMPRESTADOS =======================================================
   public ArrayList<Amigos> listarEmprestados() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.listarEmpmrestados();
   }

   // RANKING DE EMPRÉSTIMOS ===================================================
   public ArrayList<Amigos> getRanking() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.getRanking();
   }

   // LISTAR OS AMIGOS QUE NUNCA DEVOLVERAM AS FERRAMENTAS =====================
   public ArrayList<Amigos> getInadimplentes() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.getInadimplentes();
   }

   // LISTAR DEVEDORES =========================================================
   public ArrayList<Amigos> listarDevedores() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.listarDevedores();
   }

   // RESUMO ===================================================================
   public int[] fazerRezumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.fazerResumo();
   }

   // VERIFICAR SE O AMIGO TEM EMPRÉSTIMOS =====================================
   public int temEmprestimos(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigosDAO db = new AmigosDAO();
      return db.temEmprestimos(id);
   }
}
