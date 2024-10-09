package principal;

public class Pedro {
   // ATRIBUTOS
   private final String nome = "Pedro Henrique Medeiros";
   private String curso;
   private String fase;
   
   // CONSTRUTORES
   public Pedro() {
      
   }
   public Pedro(String curso, String fase) {
      this.curso = curso;
      this.fase = fase;
   }
   
   
   // GETERS / SETTERS
   public String getNome() {
      return nome;
   }

   public String getCurso() {
      return curso;
   }

   public String getFase() {
      return fase;
   }

   public void setCurso(String curso) {
      this.curso = curso;
   }

   public void setFase(String fase) {
      this.fase = fase;
   }



   
}