public class Produto {
    protected int codigo;
    protected double preco;
    protected String descricao;
    protected String dataLancamento;
    protected String estado;

    public Produto(int codigo, double preco, String descricao, String dataLancamento, String estado) {
            this.codigo = codigo;
            this.preco = preco;
            this.descricao = descricao;
            this.dataLancamento = dataLancamento;
            this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String getEstado() {
        return estado;
    }
}