import java.util.ArrayList;
import java.util.List;

public class Usuario implements Comparable<Usuario> {

    private int id;

    private List<Usuario> amigos;

    private CalculadorIntersecao calculadorIntersecao;

    public Usuario(int id, CalculadorIntersecao calculador) {
        // instancia um calculador de interseção
        this.id = id;
        this.amigos = new ArrayList<>();
        this.calculadorIntersecao = calculador;
    }

    public int getId() {
        return id;
    }

    public List<Usuario> getAmigos() {
        return this.amigos;
    }

    /**
     * Retorna a quantidade de amigos em comum entre este Usuario e o
     * outro Usuario informado.
     *
     * @param outro outro Usuario da rede social
     * @return o tamanho da interseção dos conjuntos de amigos
     */
    public int obterQuantidadeDeAmigosEmComum(Usuario outro) {
        return calculadorIntersecao.obterIntersecao(amigos, outro.getAmigos()).size();
    }

    public void adicionarAmigos(Usuario amigo) {
        this.amigos.add(amigo);
    }

    // o metódo abaixo serve para comparar a performance de forma mais justa em UsuarioTest.

    public void setCalculadorIntersecao(CalculadorIntersecao calculador) {
        this.calculadorIntersecao = calculador;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.id - o.id;
    }
}
