package model;

public class Amigos {
    
    private int amigoId;
    private String amigoNome;
    private String amigoEmail;
    private String amigoEndereco;
 
    public Amigos() {
     
     this(0, "","","");
    }

    public Amigos(int amigoId, String amigoNome, String amigoEmail, String amigoEndereco) {
        this.amigoId = amigoId;
        this.amigoNome = amigoNome;
        this.amigoEmail = amigoEmail;
        this.amigoEndereco = amigoEndereco;
    }

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
 
}

