package dados;

import pessoa.Leitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BaseDeLeitores {

    private static final List<Leitor> leitores = new ArrayList<>();

    static {
        carregarLeitoresIniciais();
    }

    private BaseDeLeitores() {}

    private static void carregarLeitoresIniciais() {
        leitores.add(new Leitor("Ana Costa", "12345678909"));
        leitores.add(new Leitor("Bruno Silva", "98765432100"));
        leitores.add(new Leitor("Carla Mendes", "11122233344"));
    }

    public static List<Leitor> listarLeitores() {
        return Collections.unmodifiableList(leitores);
    }

    public static void adicionarLeitor(Leitor leitor) {
        if (leitor == null) throw new IllegalArgumentException("Leitor não pode ser nulo.");
        boolean cpfDuplicado = leitores.stream().anyMatch(l -> l.getCpf().equalsIgnoreCase(leitor.getCpf()));
        if (cpfDuplicado) throw new IllegalArgumentException("Já existe um leitor com o CPF: " + leitor.getCpf());
        leitores.add(leitor);
    }
}
