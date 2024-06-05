public class Funcionario extends Pessoa implements IPessoa {
    private double cpf;
    private double salario;
    private int telefone;

    public Funcionario(String nome, int idade, double cpf, double salario, int telefone) {
        super(nome, idade);
        this.cpf = cpf;
        this.salario = salario;
        this.telefone = telefone;
    }

    public double getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }


    public int getTelefone() {
        return telefone;
    }

    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Telefone: " + telefone);
    }
}