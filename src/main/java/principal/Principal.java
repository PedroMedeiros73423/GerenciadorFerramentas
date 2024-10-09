// PACOTES
package principal;

import model.Amigos;
import model.Ferramentas;


public class Principal {

   public static void main(String[] args) {
      // INSTANCIAR
      Amigos amigos = new Amigos();
      amigos.leituraAmigos();
      System.out.println("As informações do amigo são => " + amigos.mostrarAmigos());
      
      Ferramentas ferramentas = new Ferramentas();
      ferramentas.leituraFerramenta();
      System.out.println("As informações da ferramenta são => " + ferramentas.mostrarFerramenta());
      
      
      Elias aluno1 = new Elias();
      Joaoiuncks aluno2 = new Joaoiuncks();
      Pedro aluno3 = new Pedro();
      
      
      // IDENTIFICAÇÃO DOS ALUNOS
      System.out.println("======================================================");
      System.out.println("PROJETO A3");
      System.out.println("======================================================");
      System.out.println("MEMBROS DO GRUPO");
      System.out.println("Aluno 01: " + aluno1.getNome());
      System.out.println("Aluno 02: " + aluno2.getNome());
      System.out.println("Aluno 03: " + aluno3.getNome());
      System.out.println("");
      
      
      
      
      
   }
}
