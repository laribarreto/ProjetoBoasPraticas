package emprestimo;

import item.Item;
import pessoa.Leitor;

import java.time.LocalDate;

public class Emprestimo {
    private static int contador = 1;
    private final int id;
    private final Leitor leitor;
    private final Item item;
    private final LocalDate dataEmprestimo;
    private boolean devolvido;

    public Emprestimo(Leitor leitor, Item item) {
        this.id = contador++;
        this.leitor = leitor;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.devolvido = false;
    }

    public int getId() { return id; }
    public Leitor getLeitor() { return leitor; }
    public boolean isDevolvido() { return devolvido; }

    public void devolver() {
        if (devolvido) throw new IllegalStateException("Este empréstimo já foi devolvido.");
        item.devolver();
        devolvido = true;
        System.out.println("Livro devolvido com sucesso!");
    }

    public void exibirInfo() {
        System.out.printf("ID: %d | Livro: %s | Leitor: %s | Data: %s | Devolvido: %s%n",
                id, item.getTitulo(), leitor.getNome(), dataEmprestimo, devolvido ? "Sim" : "Não");
    }
}
