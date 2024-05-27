import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int resposta = 0;

        do {
            System.out.println("      Loja de Jogos");
            System.out.println("__________________________");
            System.out.println("Digite o que deseja fazer: ");
            System.out.println("1-Cadastro de Clientes");
            System.out.println("2-Cadastro de Funcionarios");
            System.out.println("3-Cadastro de Produtos");
            System.out.println("0-Sair do Sistema");
            sc1.next(String.valueOf(resposta));
            switch (resposta){
                case 1: cadastroCliente();
                    break;
                case 2: cadastroFuncionario();
                    break;
                case 3: cadastroProduto();
                    break;
                case 0:
                    System.out.printf("Encerrando o Programa...");
                    break;
                default:
                    System.out.printf("Digite um valor valido");

            }
        } while (resposta!=0);
    }

    private static void cadastroCliente() {
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        double cpf = 0;
        String endereco = "";
        double saldo = 0;

        System.out.println("Digite o nome do cliente: ");
        scanner.next(nome);
        System.out.println("Digite o Cpf do cliente: ");
        scanner.next(String.valueOf(cpf));
        System.out.println("Digite o endereço do cliente: ");
        scanner.next(endereco);
        System.out.println("Digite o Saldo do cliente: ");
        scanner.next(String.valueOf(saldo));
        clientes.add(new Cliente(nome,cpf,endereco,saldo));
    }

    private static void cadastroFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário: ");
    }

    private static void cadastroProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        scanner.next();

    }
}
