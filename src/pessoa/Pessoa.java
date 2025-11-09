package pessoa;

public abstract class Pessoa {
    private static int contador = 1;
    private final int id;
    private final String nome;

    protected Pessoa(String nome) {
        this.id = contador++;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
}
