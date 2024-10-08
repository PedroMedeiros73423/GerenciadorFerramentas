package principal;

public class Elias {
   // ATRIBUTOS
   private final String nome = "Elias Bernabé Turchiéllo";
   private String curso;
   private String fase;
   
   // CONSTRUTORES
   public Elias() {
      
   }
   public Elias(String curso, String fase) {
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
