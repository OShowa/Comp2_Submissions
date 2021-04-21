public class Livro extends Produto {

    private String nome;

    private String editora;

    public Livro(String nome, String editora) {

        this.nome = nome;

        this.editora = editora;

    }

    private int numeroDePaginas() {
        return 0;  // ToDo IMPLEMENT ME!!!!
    }

    public String getTrechoEmDestaque() {
        return null;  // ToDo IMPLEMENT ME!!!!
    }

    public String getAutor() {
        return null;  // ToDo IMPLEMENT ME!!!!
    }

    public int getAnoDePublicacao() {
        return 0;  // ToDo IMPLEMENT ME!!!!
    }

    @Override
    public String toString() {

        return nome;
    }
}
