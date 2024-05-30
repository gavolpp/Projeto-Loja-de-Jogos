public class Funcionario extends Pessoa implements IPessoa {
    private double cpf;
    private double salario;
    private int telefone;

    public Funcionario(String nome, int idade, double cpf, double salario, int telefone) {
        super(nome, idade);
        setCpf(cpf);
        setSalario(salario);
        setTelefone(telefone);
    }

    // Getters e Setters
    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        if (cpf <= 0) throw new IllegalArgumentException("CPF deve ser preenchido");
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) throw new IllegalArgumentException("Salário deve ser preenchido");
        this.salario = salario;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        if (telefone <= 0) throw new IllegalArgumentException("Telefone deve ser preenchido");
        this.telefone = telefone;
    }

    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Telefone: " + telefone);
    }
}