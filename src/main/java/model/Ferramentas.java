package model;

import javax.swing.JOptionPane;

public class Ferramentas {
    //VARIÁVEIS DA FERRAMENTAS
    private int ferramentaId;
    private String ferramentaNome;
    private String ferramentaMarca;
    private double ferramentaValor;
    
    //CONSTRUTORES
    public Ferramentas() {

        this(1, "Marreta", "BOSCH", 399.99);

    }

    public Ferramentas(int ferramentaId, String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
        this.ferramentaId = ferramentaId;
        this.ferramentaNome = ferramentaNome;
        this.ferramentaMarca = ferramentaMarca;
        this.ferramentaValor = ferramentaValor;
    }

    public Ferramentas(String ferramentaNome, String ferramentaMarca, double ferramentaValor) {
        this.ferramentaNome = ferramentaNome;
        this.ferramentaMarca = ferramentaMarca;
        this.ferramentaValor = ferramentaValor;
    }
    
    //GETERS
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
    
    //SETTERS
    public void setFerramentaId(int ferramentaId) {
        if (ferramentaId < 0) {
            JOptionPane.showMessageDialog(null, "ID do amigo não pode ser negativo. Por favor, insira um valor válido.");
        } else {
            this.ferramentaId = ferramentaId;
        }
    }

    public void setFerramentaNome(String ferramentaNome) {
        this.ferramentaNome = ferramentaNome;
    }

    public void setFerramentaMarca(String ferramentaMarca) {
        this.ferramentaMarca = ferramentaMarca;
    }

    public void setFerramentaValor(double ferramentaValor) {
            if (ferramentaValor < 0) {
            JOptionPane.showMessageDialog(null, "ID da ferramenta não pode ser negativo. Por favor, insira um valor válido.");
        } else {
            this.ferramentaValor = ferramentaValor;
        }
    }
    
    //INSTANCIAR
//    public void leituraFerramenta() {
//        int id;
//        do {
//            id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ferramenta (não pode ser negativo)"));
//            if (id < 0) {
//                JOptionPane.showMessageDialog(null, "ID inválido. Tente novamente.");
//            }
//        } while (id < 0);
//
//        setFerramentaId(id);
//        setFerramentaNome(JOptionPane.showInputDialog("Digite o nome da ferramenta"));
//        setFerramentaMarca(JOptionPane.showInputDialog("Digite a marca da ferramenta"));
//        double valor;
//        do {
//            valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da ferramenta (não pode ser negativo)"));
//            if (valor < 0) {
//                JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.");
//            }
//        } while (valor < 0);
//        
//        setFerramentaValor(valor);
//    }

    public String mostrarFerramenta() {
        return "ID: " + getFerramentaId() + ", " + "NOME: " + getFerramentaNome() + ", " + "MARCA: " + getFerramentaMarca() + ", " + "VALOR: " + getFerramentaValor() + "$ Reais" + ".";
    }
}
