public class Cliente extends Pessoa implements IPessoa{
    private double cpf;
    private String endereco;
    private double saldo;

    public Cliente(String nome, int idade, double cpf, String endereco, double saldo)
    {
        super(nome, idade);
        this.cpf = cpf;
        this.endereco = endereco;
        this.saldo = saldo;
    }

    @Override
    public void exibir()
    {
        System.out.println("\nNome: "+ nome );
        System.out.println("Idade: "+ idade);
        System.out.println("CPF: "+ cpf);
        System.out.println("Endereço: "+ endereco);
        System.out.println("Saldo: "+ saldo + "\n");
    }

    public double getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }
}

