public class Recibo {

    private Produto produto;

    private int quantidade;

    private float valorTotalDaCompra;

    private Usuario usuario;

    public Recibo(Produto produto, int quantidade, Usuario usuario) {

        this.produto = produto;

        this.quantidade = quantidade;

        this.valorTotalDaCompra = produto.getPrecoEmReais() * quantidade;

        this.usuario = usuario;

    }

    public float getValorTotalDaCompra() {

        return this.valorTotalDaCompra;
    }

    public Usuario getUsuario() {

        return this.usuario;
    }

    @Override
    public String toString(){

        String classeDoProduto = this.produto.getClass().toString();

        classeDoProduto = classeDoProduto.substring(6);

        String valorDoRecibo = String.format("%.2f", valorTotalDaCompra);

        String nomeDoUsuario = this.usuario.getNome();

        String quantidade = String.format("%d", this.quantidade);

        String nomeDoProduto = this.produto.toString();

        String string = "Recibo no valor de R$" + valorDoRecibo + " para " + nomeDoUsuario +
                " referente à compra de " + quantidade + " unidades de " + classeDoProduto + ": " +
                nomeDoProduto;

        return string;
    }

}
