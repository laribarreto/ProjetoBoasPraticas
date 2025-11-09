package item;

public class LivroDigital extends Item {

    public LivroDigital(String titulo, String autor, String isbn) {
        super(titulo, autor, isbn);
    }

    @Override
    public boolean isDisponivel() {
        return true;
    }

    @Override
    public void emprestar() {
        // Sempre disponível
    }

    @Override
    public void devolver() {
        // Nenhuma ação necessária
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Digital | Sempre disponível");
    }
}
