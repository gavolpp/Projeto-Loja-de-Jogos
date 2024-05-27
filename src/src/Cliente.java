import java.util.ArrayList;
//Classe Cliente que herda de Pessoa e implementa IPessoa
public class Cliente extends Pessoa implements IPessoa{
    private double cpf;
    private String endereco;
    private double saldo;

    ArrayList<Cliente> clientes = new ArrayList<>();

    //construtor com tratamento de excessão
    public Cliente(String nome, int idade, double cpf, String endereco, double saldo)
    {
        super(nome, idade);
        this.cpf = cpf;
        this.endereco = endereco;
        this.saldo = saldo;
        if(idade<=0)
            throw new IllegalArgumentException("Idade Invalida");
        if(nome == null)
            throw new IllegalArgumentException("Nome deve ser preenchido");
        if(cpf<=0)
            throw new IllegalArgumentException("Cpf deve ser preenchido");
        if(endereco==null)
            throw new IllegalArgumentException("Endereço deve ser preenchido");
        if(saldo<0)
            throw new IllegalArgumentException("Saldo Invalido");

    }

    @Override
    public void exibir()
    {
        System.out.println("Nome: "+ nome );
        System.out.println("Idade: "+ idade);
        System.out.println("CPF: "+ cpf);
        System.out.println("Endereço: "+ endereco);
        System.out.println("Saldo: "+ saldo);
    }

    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        if(cpf<=0)
            throw new IllegalArgumentException("Cpf deve ser preenchido");
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco==null)
            throw new IllegalArgumentException("Endereço deve ser preenchido");
        this.endereco = endereco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo<0)
            throw new IllegalArgumentException("Saldo Invalido");
        this.saldo = saldo;
    }
}
