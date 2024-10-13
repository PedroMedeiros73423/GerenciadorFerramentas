package model;

import javax.swing.JOptionPane;

public class NewAmigos {
    //VARIÁVEIS DE NEW AMIGOS
    private String amigoNome;
    private String amigoEmail;
    private String amigoEndereco;
    private String amigoTelefone;
    
    //CONSTRUTORES
    public NewAmigos() {

        this("", "", "", "");

    }

    public NewAmigos(String amigoNome, String amigoEmail, String amigoEndereco, String amigoTelefone) {
        this.amigoNome = amigoNome;
        this.amigoEmail = amigoEmail;
        this.amigoEndereco = amigoEndereco;
        this.amigoTelefone = amigoTelefone;
    }
    
    //GETERS
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
    
    //SETTERS
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
    
    //INSTANCIAR
    public void leituraAmigos() {
        int id;
        do {
            id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do amigo (não pode ser negativo)"));
            if (id < 0) {
                JOptionPane.showMessageDialog(null, "ID inválido. Tente novamente.");
            }
        } while (id < 0);

        setAmigoNome(JOptionPane.showInputDialog("Digite o nome do amigo"));
        setAmigoEmail(JOptionPane.showInputDialog("Digite o e-mail do amigo"));
        setAmigoEndereco(JOptionPane.showInputDialog("Digite o endereço do amigo"));
        setAmigoTelefone(JOptionPane.showInputDialog("Digite o telefone do amigo"));
    }

    public String mostrarAmigos() {
        return ", " + "NOME: " + getAmigoNome() + ", " + "EMAIL: " + getAmigoEmail() + ", " + "ENDERECO: " + getAmigoEndereco() + ", " + "Telefone: " + getAmigoTelefone() + ".";
    }
}
