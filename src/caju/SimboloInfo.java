package caju;

public class SimboloInfo {
    // informações do simbolo
    String tipo;
    Boolean atribuido;

    public SimboloInfo(String tipo, Boolean atribuido) {
        this.tipo = tipo;
        this.atribuido = atribuido;
    }

    public void valor_atribuido() {
        atribuido = true;
    }
}
