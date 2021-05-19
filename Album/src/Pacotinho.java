import java.util.ArrayList;
import java.util.Random;

public class Pacotinho<T extends Colecionavel> {

    private final ArrayList<T> figurinhasNoPacotinho = new ArrayList<>();

    public Pacotinho(Repositorio<T> repo, int[] posicoesDesejadas) {

        for (int i : posicoesDesejadas) {
            this.figurinhasNoPacotinho.add(repo.getFigurinhaEspecifica(i));
        }

        // ToDo IMPLEMENT ME!!!
    }

    /**
     * Produz um pacotinho com quantFigurinhas sorteadas aleatoriamente
     * dentre aqueles presentes no repositório informado.
     *
     * @param repo o repositório desejado
     * @param quantFigurinhas a quantidade de figurinhas a constar no pacotinho
     */
    public Pacotinho(Repositorio<T> repo, int quantFigurinhas) {

        for (int i = 0; i < quantFigurinhas; i++) {

            Random random = new Random();
            int figurinhaAleatoria;

            figurinhaAleatoria = random.nextInt(repo.getTotalFigurinhas()) + 1;

            this.figurinhasNoPacotinho.add(repo.getFigurinhaEspecifica(figurinhaAleatoria));

        }

        // ToDo IMPLEMENT ME!!!
    }

    public ArrayList<T> getFigurinhas() {

        ArrayList<T> figurinhas = new ArrayList<>();

        figurinhas.addAll(figurinhasNoPacotinho);

        return figurinhas;  // ToDo IMPLEMENT ME!!!

    }
}
