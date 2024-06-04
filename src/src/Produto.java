public class Produto {
    protected int codigo;
    protected double preco;
    protected String descricao;
    protected String dataLancamento;
    protected String estado;

    public Produto(int codigo, double preco, String descricao, String dataLancamento, String estado) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código deve ser maior que zero.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição deve ser preenchida.");
        }
        if (dataLancamento == null || dataLancamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Data de lançamento deve ser preenchida.");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("Estado deve ser preenchido.");
        }

        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código deve ser maior que zero.");
        }
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição deve ser preenchida.");
        }
        this.descricao = descricao;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        if (dataLancamento == null || dataLancamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Data de lançamento deve ser preenchida.");
        }
        this.dataLancamento = dataLancamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("Estado deve ser preenchido.");
        }
        this.estado = estado;
    }
}