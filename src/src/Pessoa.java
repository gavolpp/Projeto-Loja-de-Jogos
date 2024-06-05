//Classe Abstrata Pessoa
public abstract class Pessoa {
    //Atributos
    protected int idade;
    protected String nome;

    //Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }


    //Getters and Setters
    public int getIdade() {
        return idade;
    }


    public String getNome() {
        return nome;
    }

}
