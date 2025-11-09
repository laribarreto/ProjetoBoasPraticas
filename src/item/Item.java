package item;

public abstract class Item {
    private static int contador = 1;
    private final int id;
    private final String titulo;
    private final String autor;
    private final String isbn;

    protected Item(String titulo, String autor, String isbn) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }

    public abstract boolean isDisponivel();
    public abstract void emprestar();
    public abstract void devolver();

    public void exibirInfo() {
        System.out.printf("ID: %d | %s | Autor: %s | ISBN: %s%n", id, titulo, autor, isbn);
    }
}
