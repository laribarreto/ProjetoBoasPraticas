package pessoa;

public class Leitor extends Pessoa {
    private final String cpf;

    public Leitor(String nome, String cpf) {
        super(nome);
        if (!cpf.matches("\\d{11}"))
            throw new IllegalArgumentException("CPF inválido: deve conter 11 dígitos.");
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
