//Classe Abstrata Pessoa
public abstract class Pessoa {
    //Atributos
    protected int idade;
    protected String nome;

    //Construtor Vazio
    public Pessoa(String nome, int idade) {

    }

    //Getters and Setters
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        //se idade for menor ou igual a zero lança uma excessão
        if(idade<=0)
            throw new IllegalArgumentException("Idade Invalida");
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    //se nome for vazio lança uma excessão
    public void setNome(String nome) {
        if(nome == null)
            throw new IllegalArgumentException("Nome deve ser preenchido");
        this.nome = nome;
    }
}
