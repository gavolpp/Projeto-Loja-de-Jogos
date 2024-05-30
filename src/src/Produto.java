public abstract class Produto {
    protected double preco;
    protected String tipo = "";
    protected String descricao;
    protected String dataLancamento;
    protected String estado = "";

    public Produto(double preco, String descricao, String dataLancamento)
    {

    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco<=0)
            throw new IllegalArgumentException("Preço invalido");
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}