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
   /**
    * Construtor com todos os atributos vazios para a criação de objetos sem
    * definição.
    */
   public Ferramenta() {
      this(0, "", "", 0);

   }

   /**
    * Construtor para inserir dados no banco. Ele só não tem o ID da ferramenta
    * que é atribuído automaticamente pelo banco de dados.
    */
   public Ferramenta(String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
      this.ferramentaNome = ferramentaNome;
      this.ferramentaMarca = ferramentaMarca;
      this.ferramentaValor = ferramentaValor;
   }

   /**
    * Construtor com todos os atributos. Usado para receber os dados vindos do
    * banco de dados.
    */
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
   /**
    * Método para listar todas as ferramentas. Não faz nenhum tipo de
    * processamento, apenas chama o método DAO responsável e retorna direto a
    * resposta vinda do DAO.
    */
   public ArrayList<Ferramenta> listarTodas() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarTodas();
   }

   // LISTAR UMA ===============================================================
   /**
    * Método para listar apenas uma ferramenta. Não faz nenhum tipo de
    * processamento, apenas chama o método DAO responsável encaminhando o ID da
    * ferramenta recebido como parâmetro e retorna direto a resposta vinda do
    * DAO.
    */
   public Ferramenta listarUma(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarUmaObjeto(id);
   }

   // CADASTRAR FERRAMENTA =====================================================
   /**
    * Método para inserir uma ferramenta. Ele recebe todos os dados da
    * ferramenta vindos da interface gráfica, valida os dados recebidos, cria um
    * objeto e chama o método DAO responsável passando como parâmetro o objeto
    * de ferramenta criado. Retorna true ou false.
    */
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
   /**
    * Método para editar uma ferramenta. Ele recebe todos os dados da ferramenta
    * vindos da interface gráfica, valida os dados recebidos, cria um objeto e
    * chama o método DAO responsável passando como parâmetro o objeto de
    * ferramenta criado. Retorna true ou false.
    */
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
   /**
    * Método para deletar uma ferramenta. Ele recebe como parâmetro o ID da
    * ferramenta que é para deletar e chama o método DAO responsável passando
    * como parâmetro o ID recebido. Retorna true ou false.
    */
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
   /**
    * Método para listar todas as ferramentas que estão disponíveis para
    * empréstimo. Não faz nenhum tipo de processamento, apenas chama o método
    * DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Ferramenta> listarDisponiveis() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarDisponiveis();
   }

   // BUSCARA FERRAMENTAS DISPONÍVEIS ==========================================
   /**
    * Método para listar todas as ferramentas que estão disponíveis para
    * empréstimo, porém filtrando com uma string recebida como parâmetro. Não
    * faz nenhum tipo de processamento, apenas chama o método DAO responsável
    * encaminhando a string recebida e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Ferramenta> buscarDisponiveis(String texto) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.buscarDisponiveis(texto);
   }

   // LISTAR SOMENTE EMPRESTADAS ===============================================
   /**
    * Método para listar todas as ferramentas que estão emprestadas e dentro do
    * prazo legal do empréstimo. Não faz nenhum tipo de processamento, apenas
    * chama o método DAO responsável e retorna direto a resposta vinda do DAO.
    */
   public ArrayList<Ferramenta> listarEmprestadas() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.listarEmprestadas();
   }

   // RESUMO ===================================================================
   /**
    * Método para obter as informações a respeito das ferramentes e montar o
    * dashborad da tela inicial do programa. Não faz nenhum tipo de
    * processamento, apenas chama o método DAO responsável e retorna direto a
    * resposta vinda do DAO.
    */
   public Double[] fazerResumo() {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.fazerResumo();
   }

   // VERIFICAR SE A FERRAMENTA TEM EMPRÉSTIMOS ================================
   /**
    * Método para saber quantas ferramentas não devolvidas dentro do prazo legal
    * o amigo em questão ainda tem. Recebe como parâmetro o ID do amigo que se
    * deseja verificar. Não faz nenhum tipo de processamento, apenas chama o
    * método DAO responsável encaminhando o ID recebido como parâmetro e retorna
    * direto a resposta vinda do DAO.
    */
   public int temEmprestimos(int id) {
      // CRIANDO O OBJETO DO BANCO DE DADOS
      FerramentaDAO db = new FerramentaDAO();
      return db.temEmprestimos(id);
   }
}
