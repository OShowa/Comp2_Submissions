import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album<T extends Colecionavel> {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private final Repositorio<T> repositorio;
    private final int quantItensPorPacotinho;

    private List<T> figurinhasColadas;  // direct addressing
    private int quantFigurinhasColadas;

    // poderíamos fazer novamente direct addressing para as repetidas,
    // mas vamos usar um HashMap aqui só para treinarmos
    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio<T> repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantItensPorPacotinho = quantItensPorPacotinho;

        int tamanhoFisicoDaLista = getTamanho() + 1;
        this.figurinhasColadas = new ArrayList<>(tamanhoFisicoDaLista);
        // inicializa as posições com nulls, para poder acessá-las diretamente
        for (int i = 0; i < tamanhoFisicoDaLista; i++) {
            this.figurinhasColadas.add(null);
        }
        this.quantFigurinhasColadas = 0;

        this.contRepetidasByPosicao = new HashMap<>();
    }

    public void receberNovoPacotinho(Pacotinho<T> pacotinho) {
        ArrayList<T> figurinhasDoPacotinho = pacotinho.getFigurinhas();
        if (figurinhasDoPacotinho.size() != this.quantItensPorPacotinho) {
            return;  // melhor ainda: lançaria uma checked exception
        }

        for (T fig : pacotinho.getFigurinhas()) {
            final int posicao = fig.getPosicao();
            if (possuiItemColado(posicao)) {
                // adiciona como repetida

                // jeito pior
//                Integer contRepetidas = this.contRepetidasByPosicao.get(posicao);
//                this.contRepetidasByPosicao.put(
//                        posicao, contRepetidas == null ? 1 : contRepetidas + 1);

                // jeito mais elegante: getOrDefault
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                // item inédito
                this.figurinhasColadas.set(posicao, fig);
                this.quantFigurinhasColadas++;
            }
        }
    }

    public Colecionavel getItemColado(int posicao) {
        return figurinhasColadas.get(posicao);
        // ToDo IMPLEMENT ME!!!
    }

    public boolean possuiItemColado(int posicao) {
        if ((posicao > repositorio.getTotalFigurinhas()) || (posicao < 1)) return false;
        return figurinhasColadas.get(posicao) != null;

        // ToDo IMPLEMENT ME!!!
    }

    public boolean possuiItemRepetido(int posicao) {

        if ((posicao > repositorio.getTotalFigurinhas()) || (posicao < 1)) return false;
        return contRepetidasByPosicao.containsKey(posicao);
        // ToDo IMPLEMENT ME!!!
    }

    public int getTamanho() {
        return this.repositorio.getTotalFigurinhas();
    }

    public int getQuantItensColados() {
//        int contador = 0;
//        for (Figurinha fig : this.figurinhasColadas) {
//            if (fig != null) {
//                contador++;
//            }
//        }
//        return contador;

        // melhor jeito: atributo!
        return this.quantFigurinhasColadas;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {

        float porcentagemEmFloat = PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f;

        if (porcentagemEmFloat <= (float) this.quantFigurinhasColadas / repositorio.getTotalFigurinhas()) {
            this.figurinhasColadas = this.repositorio.getTodasAsFigurinhas();
            this.quantFigurinhasColadas = this.repositorio.getTotalFigurinhas();
        }

        // ToDo IMPLEMENT ME!!!
    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }

//    public static void main(String[] args) {
//        ArrayList<Integer> meuArrayList = new ArrayList<>(200);
//
//        // inicializa as posições com nulls, para poder acessá-las diretamente
//        for (int i = 0; i < 200; i++) {
//            meuArrayList.add(null);
//        }
//
////        System.out.println(meuArrayList.get(3));
//
//        meuArrayList.add(3, 300000);  // insert com shift right
//
//        for (int numero : meuArrayList) {
//            System.out.println(numero);
//        }
//    }
}
