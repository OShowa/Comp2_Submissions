import java.awt.*;

public class Selo implements Colecionavel {

    private final Image imagem;

    private final int posicao;

    private final float valorNominal;

    private final String pais;

    public Selo(int posicao, String urlDaImagem, float valorNominal, String pais){

        this.imagem = obterImagem(urlDaImagem);
        this.posicao = posicao;

        this.valorNominal = valorNominal;
        this.pais = pais;

    }

    private Image obterImagem(String urlDaImagem) {
        // baixaria uma imagem da internet...
        return null;
    }

    public float getValorNominal() { return valorNominal; }

    public String getPais() { return pais; }

    public Image getImagem() { return imagem; }
    public int getPosicao() { return posicao; }

}
