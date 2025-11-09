package pessoa;

import dados.BaseDeLeitores;
import dados.BaseDeLivros;
import emprestimo.Emprestimo;
import item.Item;

import java.util.*;

public class Bibliotecario extends Pessoa {

    private final List<Emprestimo> emprestimos = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public Bibliotecario(String nome) {
        super(nome);
    }

    public void listarLivros() {
        BaseDeLivros.listarLivros().forEach(Item::exibirInfo);
    }

    public void listarLeitores() {
        BaseDeLeitores.listarLeitores()
                .forEach(l -> System.out.println("ID: " + l.getId() + " | Nome: " + l.getNome()));
    }

    public void realizarEmprestimo() {
        listarLeitores();
        System.out.print("Digite o CPF do leitor: ");
        String cpf = sc.nextLine();

        Leitor leitor = BaseDeLeitores.listarLeitores()
                .stream().filter(l -> l.getCpf().equals(cpf)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Leitor não encontrado."));

        listarLivros();
        System.out.print("Digite o ID do livro: ");
        int id = sc.nextInt(); sc.nextLine();

        Item item = BaseDeLivros.listarLivros().stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado."));

        if (!item.isDisponivel()) throw new IllegalStateException("Livro indisponível.");
        item.emprestar();

        Emprestimo emp = new Emprestimo(leitor, item);
        emprestimos.add(emp);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void realizarDevolucao() {
        System.out.print("Digite o ID do empréstimo: ");
        int id = sc.nextInt(); sc.nextLine();

        Emprestimo emp = emprestimos.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado."));

        emp.devolver();
    }

    public void listarEmprestimos() {
        emprestimos.forEach(Emprestimo::exibirInfo);
    }
}
