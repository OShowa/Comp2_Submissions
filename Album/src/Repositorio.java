import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Colecionavel> {

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private final List<T> todasAsFigurinhas;

    public Repositorio(String sufixoUrlImagens, int quantFigurinhas){
        todasAsFigurinhas = new ArrayList<>(quantFigurinhas);
        for (int i = 1; i <= quantFigurinhas; i++) {
            Figurinha fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            todasAsFigurinhas.add((T) fig);
        }
    }

    public Repositorio(String sufixoUrlImagens, int quantFigurinhas, String type){
        todasAsFigurinhas = new ArrayList<>(quantFigurinhas);

        switch(type) {
            case("Figurinha"):
                for (int i = 1; i <= quantFigurinhas; i++) {
                    Figurinha fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
                    todasAsFigurinhas.add((T) fig);
                }
                break;
            case("Selo"):
                for (int i = 1; i <= quantFigurinhas; i++) {
                    Selo fig = new Selo(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens,
                            1.2f, "Brasil");

                    todasAsFigurinhas.add((T) fig);
                }
                break;
        }
    }

    public int getTotalFigurinhas() {
        return this.todasAsFigurinhas.size();
    }

    public T getFigurinhaEspecifica(int figurinhaDesejada) {
        return this.todasAsFigurinhas.get(figurinhaDesejada - 1);
    }

    public List<T> getTodasAsFigurinhas() { return todasAsFigurinhas; }
}
