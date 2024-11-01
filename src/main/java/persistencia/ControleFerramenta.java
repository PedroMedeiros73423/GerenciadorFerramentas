package persistencia;

import java.util.ArrayList;
import model.Ferramentas;

public class ControleFerramenta {

    private ArrayList<Ferramentas> ferramentas = new ArrayList<>();

    public boolean salvar(Ferramentas F) {
        if (F != null) {
            ferramentas.add(F);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Ferramentas> retornarTodos() {
        return ferramentas;
    }
}
