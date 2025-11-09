package dados;

import item.Item;
import item.LivroDigital;
import item.LivroFisico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BaseDeLivros {

    private static final List<Item> livros = new ArrayList<>();

    static {
        carregarLivrosIniciais();
    }

    private BaseDeLivros() {}

    private static void carregarLivrosIniciais() {
        livros.add(new LivroFisico("Dom Casmurro", "Machado de Assis", "9788535914849", 5));
        livros.add(new LivroFisico("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "9788522031443", 3));
        livros.add(new LivroDigital("Clean Code", "Robert C. Martin", "9780132350884"));
        livros.add(new LivroDigital("Java: Como Programar", "Deitel & Deitel", "9788534608367"));
    }

    public static List<Item> listarLivros() {
        return Collections.unmodifiableList(livros);
    }

    public static void adicionarLivro(Item livro) {
        if (livro == null) throw new IllegalArgumentException("Livro não pode ser nulo.");
        boolean jaExiste = livros.stream().anyMatch(l -> l.getIsbn().equalsIgnoreCase(livro.getIsbn()));
        if (jaExiste) throw new IllegalArgumentException("Já existe um livro com este ISBN: " + livro.getIsbn());
        livros.add(livro);
    }
}
