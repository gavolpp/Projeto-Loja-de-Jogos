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
            System.out.println("1. Painel de Clientes");
            System.out.println("2. Painel de Funcionários");
            System.out.println("3. Painel de Produtos");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: painelCliente();
                    break;
                case 2: painelFuncionario();
                    break;
                case 3: painelProduto();
                    break;
                case 0: System.out.println("Saindo...");
                    break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }


    private void painelCliente(){
        int opcao;
        System.out.println("Painel de Clientes");
        System.out.println("1- Cadastrar Cliente");
        System.out.println("2- Excluir Cliente");
        System.out.println("3- Buscar Cliente");
        System.out.println("4- Exibir Clientes");
        System.out.println("5- Relatório de Clientes");
        System.out.println("0- Voltar ao Menu");
        System.out.println("Escolhe a opção desejada: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1: cadastrarCliente();
                break;
            case 2: excluirCliente();
                break;
            case 3: buscarCliente();
                break;
            case 4: exibirClientes();
                break;
            case 5: relatorioClientes();
                break;
            case 0: menu();
                break;
            default:
                System.out.println("Valor inválido");
        }


    }

    private void painelFuncionario(){
        int opcao;
        System.out.println("Painel de Funcionários");
        System.out.println("1- Cadastrar Funcionário");
        System.out.println("2- Excluir Funcionário");
        System.out.println("3- Buscar Funcionário");
        System.out.println("4- Exibir Funcionário");
        System.out.println("0- Voltar ao Menu");
        System.out.println("Escolhe a opção desejada: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1: cadastrarFuncionario();
                break;
            case 2: excluirFuncionario();
                break;
            case 3: buscarFuncionario();
                break;
            case 4: exibirFuncionarios();
                break;
            case 0: menu();
                break;
            default:
                System.out.println("Valor inválido");
        }
    }

    private void painelProduto(){
        int opcao;
        System.out.println("Painel de Produtos");
        System.out.println("1- Cadastrar Produto");
        System.out.println("2- Excluir Produto");
        System.out.println("3- Buscar Produto");
        System.out.println("4- Exibir Produtos");
        System.out.println("5- Relatório de Produtos");
        System.out.println("0- Voltar ao Menu");
        System.out.println("Escolhe a opção desejada: ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1: cadastrarProduto();
                break;
            case 2: excluirProduto();
                break;
            case 3: buscarProduto();
                break;
            case 4: exibirProdutos();
                break;
            case 5: relatorioProdutos();
                break;
            case 0: menu();
                break;
            default:
                System.out.println("Valor inválido");
        }
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

    private void buscarCliente() {
        System.out.print("\nDigite parte do nome do cliente: ");
        String parteDoNome = scanner.nextLine();
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(parteDoNome.toLowerCase())) {
                cliente.exibir();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum cliente encontrado com esse nome.\n");
        }
    }


    private void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.\n");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println("\nNome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Saldo: " + cliente.getSaldo());
            System.out.println();
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


    private void buscarFuncionario() {
        System.out.print("\nCPF do funcionário a ser buscado: ");
        double cpf = scanner.nextDouble();
        scanner.nextLine();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf() == cpf) {
                System.out.println("\nNome: " + funcionario.getNome());
                System.out.println("Idade: " + funcionario.getIdade());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println();
                return;
            }
        }
        System.out.println("Funcionário não encontrado.\n");
    }


    private void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.\n");
            return;
        }
        for (Funcionario funcionario : funcionarios) {
            System.out.println("\nNome: " + funcionario.getNome());
            System.out.println("Idade: " + funcionario.getIdade());
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println();
        }
    }


    private void cadastrarProduto() {
        System.out.print("\nCódigo do Produto: ");
        int codigo = scanner.nextInt();
        if (codigo <= 0) {
            System.out.println("Erro ao cadastrar produto: Código deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        if (preco <= 0) {
            System.out.println("Erro ao cadastrar produto: Preço deve ser maior que zero.\n");
            scanner.nextLine();
            return;
        }
        scanner.nextLine();

        System.out.print("Descrição do Produto: ");
        String descricao = scanner.nextLine();
        if (descricao.trim().isEmpty()) {
            System.out.println("Erro ao cadastrar produto: Descrição deve ser preenchida.\n");
            return;
        }

        System.out.print("Data de Lançamento: ");
        String dataLancamento = scanner.nextLine();
        if (dataLancamento.trim().isEmpty()) {
            System.out.println("Erro ao cadastrar produto: Data de lançamento deve ser preenchida.\n");
            return;
        }

        System.out.print("Estado do Produto: ");
        String estado = scanner.nextLine();
        if (estado.trim().isEmpty()) {
            System.out.println("Erro ao cadastrar produto: Estado deve ser preenchido.\n");
            return;
        }

        Produto produto = new Produto(codigo, preco, descricao, dataLancamento, estado);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso.\n");
    }


    private void excluirProduto() {
        System.out.print("\nCódigo do produto a ser excluído: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            System.out.println("Produto removido com sucesso.\n");
        } else {
            System.out.println("Produto não encontrado.\n");
        }
    }


    private void buscarProduto() {
        System.out.println("\nOpções de busca de produtos:");
        System.out.println("1. Buscar por descrição");
        System.out.println("2. Buscar por código");
        System.out.println("3. Buscar por faixa de preço");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                buscarPorDescricao();
                break;
            case 2:
                buscarPorCodigo();
                break;
            case 3:
                buscarPorFaixaPreco();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void buscarPorDescricao() {
        System.out.print("\nDigite parte da descrição do produto: ");
        String parteDaDescricao = scanner.nextLine();
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getDescricao().toLowerCase().contains(parteDaDescricao.toLowerCase())) {
                exibirDetalhesProduto(produto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com essa descrição.\n");
        }
    }

    private void buscarPorCodigo() {
        System.out.print("\nDigite o código do produto: ");
        int codigo = scanner.nextInt();
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                exibirDetalhesProduto(produto);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com esse código.\n");
        }
    }

    private void buscarPorFaixaPreco() {
        System.out.print("\nDigite o preço mínimo: ");
        double minPreco = scanner.nextDouble();
        System.out.print("Digite o preço máximo: ");
        double maxPreco = scanner.nextDouble();
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getPreco() >= minPreco && produto.getPreco() <= maxPreco) {
                exibirDetalhesProduto(produto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado nessa faixa de preço.\n");
        }
    }

    private void exibirDetalhesProduto(Produto produto) {
        System.out.println("\nCódigo: " + produto.getCodigo());
        System.out.println("Preço: " + produto.getPreco());
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Data de Lançamento: " + produto.getDataLancamento());
        System.out.println("Estado: " + produto.getEstado());
        System.out.println();
    }


    private void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
            return;
        }
        for (Produto produto : produtos) {
            System.out.println("\nCódigo: " + produto.getCodigo());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Data de Lançamento: " + produto.getDataLancamento());
            System.out.println("Estado: " + produto.getEstado());
            System.out.println();
        }
    }


    // Método para encontrar o cliente mais velho
    private Cliente clienteMaisVelho() {
        if (clientes.isEmpty()) {
            return null; // Retorna null se não houver clientes cadastrados
        }

        Cliente maisVelho = clientes.get(0); // Inicializa com o primeiro cliente
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() > maisVelho.getIdade()) {
                maisVelho = cliente;
            }
        }
        return maisVelho;
    }


    // Método para encontrar o cliente mais novo
    private Cliente clienteMaisNovo() {
        Cliente maisNovo = null;
        for (Cliente cliente : clientes) {
            if (maisNovo == null || cliente.getIdade() < maisNovo.getIdade()) {
                maisNovo = cliente;
            }
        }
        return maisNovo;
    }

    // Método para contar a quantidade de clientes com mais de 60 anos
    private int quantidadeClientesMaiores60() {
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() > 60) {
                quantidade++;
            }
        }
        return quantidade;
    }


    // Método para contar a quantidade de clientes com menos de 18 anos
    private int quantidadeClientesMenores18() {
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() < 18) {
                quantidade++;
            }
        }
        return quantidade;
    }


    // Método para calcular a idade média dos clientes
    private double idadeMediaClientes() {
        if (clientes.isEmpty()) {
            return 0;
        }
        int somaIdades = 0;
        for (Cliente cliente : clientes) {
            somaIdades += cliente.getIdade();
        }
        return (double) somaIdades / clientes.size();
    }



    // Método para encontrar o produto mais caro
    private Produto produtoMaisCaro() {
        Produto maisCaro = null;
        for (Produto produto : produtos) {
            if (maisCaro == null || produto.getPreco() > maisCaro.getPreco()) {
                maisCaro = produto;
            }
        }
        return maisCaro;
    }


    // Método para encontrar o produto mais barato
    private Produto produtoMaisBarato() {
        Produto maisBarato = null;
        for (Produto produto : produtos) {
            if (maisBarato == null || produto.getPreco() < maisBarato.getPreco()) {
                maisBarato = produto;
            }
        }
        return maisBarato;
    }


    // Método para calcular a média de preços dos produtos
    private double mediaPrecoProdutos() {
        if (produtos.isEmpty()) {
            return 0;
        }
        double somaPrecos = 0;
        for (Produto produto : produtos) {
            somaPrecos += produto.getPreco();
        }
        return somaPrecos / produtos.size();
    }


    private void relatorioClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Não há nenhum cliente cadastrado.\n");
            return;
        }

        System.out.println("\nRelatório sobre Clientes:");
        System.out.println("1. Cliente mais velho: " + clienteMaisVelho().getNome() + ", " + clienteMaisVelho().getIdade() + " anos");
        System.out.println("2. Cliente mais novo: " + clienteMaisNovo().getNome() + ", " + clienteMaisNovo().getIdade() + " anos");
        System.out.println("3. Quantidade de clientes com mais de 60 anos: " + quantidadeClientesMaiores60());
        System.out.println("4. Quantidade de clientes com menos de 18 anos: " + quantidadeClientesMenores18());
        System.out.println("5. Idade média dos clientes: " + idadeMediaClientes() + " anos\n");
    }


    private void relatorioProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há nenhum produto cadastrado.\n");
            return;
        }
        System.out.println("\nRelatório sobre Produtos:");
        System.out.println("1. Produto mais caro: " + produtoMaisCaro().getDescricao() + ", R$" + produtoMaisCaro().getPreco());
        System.out.println("2. Produto mais barato: " + produtoMaisBarato().getDescricao() + ", R$" + produtoMaisBarato().getPreco());
        System.out.println("3. Preço médio dos produtos: R$" + mediaPrecoProdutos() + "\n");
    }
}