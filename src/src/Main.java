import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main loja = new Main();
        loja.menu();
    }


    public void menu() {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Cadastrar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("5. Cadastrar Produto");
            System.out.println("6. Excluir Produto");
            System.out.println("7. Buscar Cliente");
            System.out.println("8. Buscar Funcionário");
            System.out.println("9. Buscar Produto");
            System.out.println("10. Exibir Clientes");
            System.out.println("11. Exibir Funcionários");
            System.out.println("12. Exibir Produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: excluirCliente(); break;
                case 3: cadastrarFuncionario(); break;
                case 4: excluirFuncionario(); break;
                //case 5: cadastrarProduto(); break;
                //case 6: excluirProduto(); break;
                case 7: buscarCliente(); break;
                case 8: buscarFuncionario(); break;
                //case 9: buscarProduto(); break;
                case 10: exibirClientes(); break;
                case 11: exibirFuncionarios(); break;
                //case 12: exibirProdutos(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }



    private void cadastrarCliente() {
        System.out.print("\nNome do Cliente: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty()) {
            System.out.println("Erro ao cadastrar cliente: Nome deve ser preenchido.\n");
            return;
        }

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        if (idade <= 0) {
            System.out.println("Erro ao cadastrar cliente: Idade deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("CPF: ");
        double cpf = scanner.nextDouble();
        if (cpf <= 0) {
            System.out.println("Erro ao cadastrar cliente: CPF deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        if (endereco.trim().isEmpty()) {
            System.out.println("Erro ao cadastrar cliente: Endereço deve ser preenchido.\n");
            return;
        }

        System.out.print("Saldo: ");
        double saldo = scanner.nextDouble();
        if (saldo < 0) {
            System.out.println("Erro ao cadastrar cliente: Saldo não pode ser negativo.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        Cliente cliente = new Cliente(nome, idade, cpf, endereco, saldo);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.\n");
    }



    private void excluirCliente() {
        System.out.print("\nCPF do cliente a ser excluído: ");
        double cpf = scanner.nextDouble();
        scanner.nextLine();
        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                clienteRemover = cliente;
                break;
            }
        }
        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            System.out.println("Cliente removido com sucesso.\n");
        } else {
            System.out.println("Cliente não encontrado.\n");
        }
    }



    private void cadastrarFuncionario() {
        System.out.print("\nNome do Funcionário: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty()) {
            System.out.println("Erro ao cadastrar funcionário: Nome deve ser preenchido.\n");
            return;
        }

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        if (idade <= 0) {
            System.out.println("Erro ao cadastrar funcionário: Idade deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("CPF: ");
        double cpf = scanner.nextDouble();
        if (cpf <= 0) {
            System.out.println("Erro ao cadastrar funcionário: CPF deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        if (salario < 0) {
            System.out.println("Erro ao cadastrar funcionário: Salário não pode ser negativo.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Telefone: ");
        int telefone = scanner.nextInt();
        if (telefone <= 0) {
            System.out.println("Erro ao cadastrar funcionário: Telefone deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, idade, cpf, salario, telefone);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso.\n");
    }



    private void excluirFuncionario() {
        System.out.print("\nCPF do funcionário a ser excluído: ");
        double cpf = scanner.nextDouble();
        scanner.nextLine();
        Funcionario funcionarioRemover = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf() == cpf) {
                funcionarioRemover = funcionario;
                break;
            }
        }
        if (funcionarioRemover != null) {
            funcionarios.remove(funcionarioRemover);
            System.out.println("Funcionário removido com sucesso.\n");
        } else {
            System.out.println("Funcionário não encontrado.\n");
        }
    }


    private void buscarCliente() {
        System.out.print("\nCPF do cliente a ser buscado: ");
        double cpf = scanner.nextDouble();
        scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                cliente.exibir();
                return;
            }
        }
        System.out.println("Cliente não encontrado.\n");
    }


    private void buscarFuncionario() {
        System.out.print("\nCPF do funcionário a ser buscado: ");
        double cpf = scanner.nextDouble();
        scanner.nextLine();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf() == cpf) {
                funcionario.exibir();
                return;
            }
        }
        System.out.println("Funcionário não encontrado.\n");
    }


    private void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.\n");
            return;
        }
        for (Cliente cliente : clientes) {
            cliente.exibir();
            System.out.println();
        }
    }


    private void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.\n");
            return;
        }
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibir();
            System.out.println();
        }
    }
}