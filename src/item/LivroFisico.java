package item;

public class LivroFisico extends Item {
    private int quantidadeDisponivel;

    public LivroFisico(String titulo, String autor, String isbn, int quantidade) {
        super(titulo, autor, isbn);
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.quantidadeDisponivel = quantidade;
    }

    @Override
    public boolean isDisponivel() {
        return quantidadeDisponivel > 0;
    }

    @Override
    public void emprestar() {
        if (!isDisponivel()) throw new IllegalStateException("Nenhuma cópia disponível para empréstimo.");
        quantidadeDisponivel--;
    }

    @Override
    public void devolver() {
        quantidadeDisponivel++;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.printf("Tipo: Físico | Cópias disponíveis: %d%n", quantidadeDisponivel);
    }
}
