import java.util.ArrayList;
//Classe funcionario que herda de Pessoa e implementa IPessoa
public class Funcionario extends Pessoa implements IPessoa {
    private double cpf;
    private double salario;
    private double telefone;



    //construtor com tratamento de excessão
    public Funcionario (String nome, int idade, double cpf, double salario, double telefone) {
        super(nome, idade);
        this.cpf = cpf;
        this.salario = salario;
        this.telefone = telefone;
        if(idade<=0)
            throw new IllegalArgumentException("Idade Invalida");
        if(nome == null)
            throw new IllegalArgumentException("Nome deve ser preenchido");
        if(cpf<=0)
            throw new IllegalArgumentException("Cpf deve ser preenchido");
        if(salario<=0)
            throw new IllegalArgumentException("Salario Inválido");
        if(telefone<0)
            throw new IllegalArgumentException("Telefone Inválido");
    }

    //função implementada de IPessoa
    @Override
    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Telefone: " + telefone);
    }
//getters and setters
    public double getCpf() {
        return cpf;
    }

    public void setCpf(double cpf) {
        if (cpf <= 0)
            throw new IllegalArgumentException("CPF deve ser preenchido");
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <=0)
            throw new IllegalArgumentException("Sálario deve ser preenchido");
        this.salario = salario;
    }

    public double getTelefone() {
        return telefone;
    }

    public void setTelefone(double telefone) {
        if (telefone <=0)
            throw new IllegalArgumentException("Sálario deve ser preenchido");
        this.telefone = telefone;
    }

}
