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
   /**
    * Construtor com todos os atributos vazios para a criação de objetos sem definição.
    */
   public Amigo() {
      this(0, "", "", "", "");
   }

   /**
    * Construtor para inserir dados no banco. Ele só não tem o ID do amigo que é
    * atribuído automaticamente pelo banco de dados.
    */
   public Amigo(String amigoNome, String amigoEmail, String amigoEndereco, String amigoTelefone) {
      this.amigoNome = amigoNome;
      this.amigoEmail = amigoEmail;
      this.amigoEndereco = amigoEndereco;
      this.amigoTelefone = amigoTelefone;
   }

   /**
    * Construtor com todos os atributos. Usado para receber os dados vindos do
    * banco de dados.
    */
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
   /**
    * Método para listar todos os amigos. Não faz nenhum tipo de processamento,
    * apenas chama o método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Amigo> listarTodos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarTodos();
   }

   // LISTAR UM ================================================================
   /**
    * Método para listar apenas um amigo. Não faz nenhum tipo de processamento,
    * apenas chama o método DAO responsável encaminhando o ID do amigo recebido
    * como parâmetro e retorna direto a resposta vinda do DAO.
    */
   public Amigo listarUm(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarUmObjeto(id);
   }

   // BUSCAR AMIGO =============================================================
   /**
    * Método para listar amigos com base em uma busca por string. Não faz nenhum
    * tipo de processamento, apenas chama o método DAO responsável encaminhado a
    * string de busca e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Amigo> buscarAmigos(String texto) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.buscarAmigos(texto);
   }

   // CADASTRAR AMIGO ==========================================================
   /**
    * Método para inserir um amigo. Ele recebe todos os dados do amigo vindos da
    * interface gráfica, valida os dados recebidos, cria um objeto e chama o
    * método DAO responsável passando como parâmetro o objeto de amigo criado.
    * Retorna true ou false.
    */
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
   /**
    * Método para editar um amigo. Ele recebe todos os dados do amigo vindos da
    * interface gráfica, valida os dados recebidos, cria um objeto e chama o
    * método DAO responsável passando como parâmetro o objeto de amigo criado.
    * Retorna true ou false.
    */
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
   /**
    * Método para deletar um amigo. Ele recebe como parâmetro o ID do amigo que
    * é para deletar e chama o método DAO responsável passando como parâmetro o
    * ID recebido. Retorna true ou false.
    */
   public boolean deletarAmigo(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      db.deletarAmigo(id);

      return true;
   }

   // LISTAR EMPRESTADOS =======================================================
   /**
    * Método para listar todos os amigos que possuem ferramentas emprestadas e
    * dentro do prazo legal do empréstimo. Não faz nenhum tipo de processamento,
    * apenas chama o método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Amigo> listarEmprestados() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarEmpmrestados();
   }

   // RANKING DE EMPRÉSTIMOS ===================================================
   /**
    * Método para listar todos os amigos em forma de ranking descendente tendo
    * como base a quantidade de empréstimos que cada um já fez. Não faz nenhum
    * tipo de processamento, apenas chama o método DAO responsável e retorna
    * direto a resposta vinda do DAO.
    */
   public ArrayList<Amigo> getRanking() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.getRanking();
   }

   // LISTAR OS AMIGOS QUE NUNCA DEVOLVERAM AS FERRAMENTAS =====================
   /**
    * Método para listar todos os amigos que nunca devolveram as ferramentes que
    * pediram emprestadas. Não faz nenhum tipo de processamento, apenas chama o
    * método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Amigo> getInadimplentes() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.getInadimplentes();
   }

   // LISTAR DEVEDORES =========================================================
   /**
    * Método para listar todos os amigos que possuem empréstimos com prazo legal
    * expirado. Não faz nenhum tipo de processamento, apenas chama o método DAO
    * responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Amigo> listarDevedores() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.listarDevedores();
   }

   // RESUMO ===================================================================
   /**
    * Método para obter os dados referentes aos amigos a fim de montar o
    * dashborad da tela inicial. Não faz nenhum tipo de processamento, apenas
    * chama o método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public int[] fazerRezumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.fazerResumo();
   }

   // VERIFICAR SE O AMIGO TEM EMPRÉSTIMOS =====================================
   /**
    * Método para saber a quantidade de empréstimos que um amigo já fez. Não faz
    * nenhum tipo de processamento, apenas chama o método DAO responsável e
    * retorna direto a resposta vinda do DAO.
    */
   public int temEmprestimos(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      AmigoDAO db = new AmigoDAO();
      return db.temEmprestimos(id);
   }
}
