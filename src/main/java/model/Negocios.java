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

}
