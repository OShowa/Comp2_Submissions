public class Pessoa {

    private String nome;

    private int anoNascimento;

    public Pessoa(String nome) {
        this(nome, 0000);
    }

    public Pessoa(String nome, int anoNascimento) {

        this.nome = nome;
        this.anoNascimento = anoNascimento;

    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }
}
