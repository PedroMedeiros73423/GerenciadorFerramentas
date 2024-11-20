// PACOTES
package model;

//IMPORTAÇÕES
import dao.NegocioDAO;
import java.util.ArrayList;

// IMPORTAÇÕES
public class Negocio {

   // ATRIBUTOS ================================================================
   /**
    * Nem todos os atributos são utilizados para manipulação dos objetos. Os
    * atributos negocioFerramentaNome e negocioAmigoNome são utilizados apenas
    * quando se retorna dados do banco que possuem relacionamentos tanto com a
    * tabela de ferramentas quanto com a tabela de negósios.
    */
   private int negocioId;
   private int negocioFerramentaId;
   private String negocioFerramentaNome;
   private int negocioAmigoId;
   private String negocioAmigoNome;
   private String negocioInicio;
   private String negocioFim;
   private String negocioFinal;

   // CONSTRUTORES =============================================================
   /**
    * Construtor com todos os atributos vazios para a criação de objetos sem
    * definição.
    */
   public Negocio() {
      this(0, 0, "", 0, "", "", "", "");
   }

   /**
    * Construtor para inserir dados no banco. Ele só não tem o ID do empréstimo
    * que é atribuído automaticamente pelo banco de dados.
    */
   public Negocio(int negocioFerramentaId, int negocioAmigoId, String negocioInicio, String negocioFim, String negocioFinal) {
      this.negocioFerramentaId = negocioFerramentaId;
      this.negocioAmigoId = negocioAmigoId;
      this.negocioInicio = negocioInicio;
      this.negocioFim = negocioFim;
      this.negocioFinal = negocioFinal;
   }

   /**
    * Construtor com todos os atributos. Usado para receber os dados vindos do
    * banco de dados.
    */
   public Negocio(int negocioId, int negocioFerramentaId, String ferramentaNome, int negocioAmigoId, String amigoNome, String negocioInicio, String negocioFim, String negocioFinal) {
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

   // LISTAR NEGOCIOS ==========================================================
   /**
    * Método para listar todos os empréstimos, independente de estar no prazo de
    * devolução ou não. Não faz nenhum tipo de processamento, apenas chama o
    * método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Negocio> listarTodos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.listarNegocios();
   }

   // LISTAR EMPRÉSTIMOS NÃO DEVOLVIDOS ========================================
   /**
    * Método para listar todos os empréstimos que estão com o prazo legal
    * expirado. Não faz nenhum tipo de processamento, apenas chama o método DAO
    * responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Negocio> listarNegociosAtrasados() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.listarNegociosAtrasados();
   }

   // LISTAR EMPRÉSTIMOS ATIVOS ================================================
   /**
    * Método para listar todos os empréstimos que estão dentro do prazo legal
    * para devolução. Não faz nenhum tipo de processamento, apenas chama o
    * método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Negocio> listarNegociosAtivos() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.listarNegociosAtivos();
   }

   // LISTAR UM ================================================================
   /**
    * Método para listar apenas um empréstimo. Não faz nenhum tipo de
    * processamento, apenas chama o método DAO responsável encaminhando o ID do
    * empréstimo recebido como parâmetro e retorna direto a resposta vinda do
    * DAO.
    */
   public Negocio listarUm(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.listarUmObjeto(id);
   }

   // CADASTRAR NEGOCIO ========================================================
   /**
    * Método para inserir um empréstimo. Ele recebe todos os dados do empréstimo
    * vindos da interface gráfica, valida os dados recebidos, cria um objeto e
    * chama o método DAO responsável passando como parâmetro o objeto de
    * empréstimo criado. Retorna true ou false.
    */
   public boolean cadastrarNegocio(int ferramentaId, int amigoId, String inicio, String fim, String terminou) {
      // VALIDANDO OS DADOS
      if (ferramentaId == 0 || amigoId == 0) {
         return false;
      }
      // CRIANDO UM OBJETO COM O NOVO NEGÓCIO
      Negocio novoNegocio = new Negocio(ferramentaId, amigoId, inicio, fim, terminou);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.inserirNegocio(novoNegocio);

   }

   // EDITAR NEGOCIO ===========================================================
   /**
    * Método para editar um empréstimo. Ele recebe todos os dados do empréstimo
    * vindos da interface gráfica, valida os dados recebidos, cria um objeto e
    * chama o método DAO responsável passando como parâmetro o objeto de
    * empréstimo criado. Retorna true ou false.
    */
   public boolean editarNegocio(int id, int ferramentaId, int amigoId, String inicio, String fim, String terminou) {
      // CRIANDO UM OBJETO DE NEGOCIO SOMENTE COM AS CHAVES ESTRANGEIRAS
      Negocio esteNegocio = new Negocio(id, ferramentaId, "", amigoId, "", inicio, fim, terminou);

      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.modificarNegocio(esteNegocio);
   }

   // DELETAR UM NEGOCIO =======================================================
   /**
    * Método para deletar um empréstimo. Ele recebe como parâmetro o ID do
    * empréstimo que é para deletar e chama o método DAO responsável passando
    * como parâmetro o ID recebido. Retorna true ou false.
    */
   public boolean deletarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.deletarNegocio(id);
   }

   // ENCERRAR UM NEGOCIO ======================================================
   /**
    * Método para encerrar um empréstimo que está dentro do prazo legal de
    * devolução. Ele recebe como parâmetro o ID do empréstimo e chama o método
    * DAO responsável passando como parâmetro o ID recebido. Retorna true ou
    * false.
    */
   public boolean encerrarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.encerrarNegocio(id);
   }

   // FINALIZAR UM NEGOCIO =====================================================
   /**
    * Método para encerrar um empréstimo que está fora do prazo legal de
    * devolução. Ele recebe como parâmetro o ID do empréstimo e chama o método
    * DAO responsável passando como parâmetro o ID recebido. Retorna true ou
    * false.
    */
   public boolean finalizarNegocio(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.finalizarNegocio(id);
   }

   // VERIFICAR FERRAMENTAS PENDENTES ==========================================
   /**
    * Método para saber a quantidade de ferramentas que o amigo que está
    * tentando fazer um empréstimo ainda tem foram do prazo e não devolvidas.
    * Ele recebe como parâmetro o ID do amigo e chama o método DAO responsável
    * passando como parâmetro o ID recebido. Retorna true ou false.
    */
   public int verificaPendencias(int amigoId) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.verificaPendencias(amigoId);
   }

   // RESUMO ===================================================================
   /**
    * Método para obter os dados referentes aos empréstimos e montar a dashborad
    * da tela inicial. Não faz nenhum tipo de processamento, apenas chama o
    * método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public int[] fazerResumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      NegocioDAO db = new NegocioDAO();
      return db.fazerResumo();
   }
}
