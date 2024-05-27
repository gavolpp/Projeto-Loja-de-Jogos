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
        clientes.removeIf(cliente -> cliente.getCpf() == (cpf));
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
        funcionarios.removeIf(funcionario -> funcionario.getCpf() == (cpf));
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
