import pessoa.Bibliotecario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bibliotecario bibliotecario = new Bibliotecario("Admin");

        int opcao;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Listar Livros");
            System.out.println("2 - Listar Leitores");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Realizar Devolução");
            System.out.println("5 - Listar Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1 -> bibliotecario.listarLivros();
                    case 2 -> bibliotecario.listarLeitores();
                    case 3 -> bibliotecario.realizarEmprestimo();
                    case 4 -> bibliotecario.realizarDevolucao();
                    case 5 -> bibliotecario.listarEmprestimos();
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
