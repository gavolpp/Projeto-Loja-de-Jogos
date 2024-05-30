import java.util.ArrayList;

public class Cadastro {
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Produto> produtos;

    public Cadastro() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        produtos = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerClientePorCPF(double cpf) {
        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                clienteRemover = cliente;
                break;
            }
        }
        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void exibirClientes() {
        for (Cliente cliente : clientes) {
            cliente.exibir();
            System.out.println();
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionarioPorCPF(double cpf) {
        Funcionario funcionarioRemover = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf() == cpf) {
                funcionarioRemover = funcionario;
                break;
            }
        }
        if (funcionarioRemover != null) {
            funcionarios.remove(funcionarioRemover);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void exibirFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibir();
            System.out.println();
        }
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
}
