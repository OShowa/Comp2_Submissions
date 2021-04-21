public class Produto {

    private int quantidadeEmEstoque = -1;

    private String descricao;

    private int pesoEmGramas;

    private Dimensoes dimensoes;

    private float precoEmReais;

    private String urlDaImagem;

    public Produto() {

        this("Sem descrição!\n", "Sem imagem!\n");

    }

    public Produto(String descricao) {

        this(descricao, "Sem imagem!\n");

    }

    public Produto(String descricao, String urlDaImagem) {

        this.descricao = descricao;

        this.urlDaImagem = urlDaImagem;

    }

    /**
     * @return uma descrição textual do produto
     */
    public String getDescricao() {

        return this.descricao;
    }

    public int getPesoEmGramas() {

        return this.pesoEmGramas;
    }

    public Dimensoes getDimensoes() {

        return this.dimensoes;
    }

    public float getPrecoEmReais() {

        return this.precoEmReais;
    }

    public void setPrecoEmReais(float preco) {

        this.precoEmReais = preco;

    }

    public String getUrlDaImagem() {

        return this.urlDaImagem;
    }

    public int getQuantidadeEmEstoque() {

        return this.quantidadeEmEstoque;
    }

    public void mexerNoEstoque(int quantidade) {

        if (this.quantidadeEmEstoque == -1) this.quantidadeEmEstoque = 0;

        this.quantidadeEmEstoque += quantidade;

    }

}
