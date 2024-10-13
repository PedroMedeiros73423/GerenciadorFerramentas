package model;

import javax.swing.JOptionPane;

public class NewFerramentas {
    //VARIÁVEIS DA FERRAMENTAS
    private String ferramentaNome;
    private String ferramentaMarca;
    private int ferramentaValor;
    
    //CONSTRUTORES
    public NewFerramentas() {

        this("", "", 0);

    }

    public NewFerramentas(String ferramentaNome, String ferramentaMarca, int ferramentaValor) {
        this.ferramentaNome = ferramentaNome;
        this.ferramentaMarca = ferramentaMarca;
        this.ferramentaValor = ferramentaValor;
    }
    
    //GETERS
    public String getFerramentaNome() {
        return ferramentaNome;
    }

    public String getFerramentaMarca() {
        return ferramentaMarca;
    }

    public int getFerramentaValor() {
        return ferramentaValor;
    }
    
    //SETTERS
    public void setFerramentaNome(String ferramentaNome) {
        this.ferramentaNome = ferramentaNome;
    }

    public void setFerramentaMarca(String ferramentaMarca) {
        this.ferramentaMarca = ferramentaMarca;
    }

    public void setFerramentaValor(int ferramentaValor) {
            if (ferramentaValor < 0) {
            JOptionPane.showMessageDialog(null, "ID da ferramenta não pode ser negativo. Por favor, insira um valor válido.");
        } else {
            this.ferramentaValor = ferramentaValor;
        }
    }
    
    //INSTANCIAR
    public void leituraFerramenta() {
        int id;
        do {
            id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ferramenta (não pode ser negativo)"));
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "ID inválido. Tente novamente.");
            }
        } while (id < 0);

        setFerramentaNome(JOptionPane.showInputDialog("Digite o nome da ferramenta"));
        setFerramentaMarca(JOptionPane.showInputDialog("Digite a marca da ferramenta"));
        int valor;
        do {
            valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da ferramenta (não pode ser negativo)"));
            if (valor < 0) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.");
            }
        } while (valor < 0);
        
        setFerramentaValor(valor);
    }

    public String mostrarFerramenta() {
        return ", " + "NOME: " + getFerramentaNome() + ", " + "MARCA: " + getFerramentaMarca() + ", " + "VALOR: " + getFerramentaValor() + "$ Reais" + ".";
    }
}
