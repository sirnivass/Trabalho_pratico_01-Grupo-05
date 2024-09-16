import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void listarFuncionarios() {
        System.out.println("Funcionários do departamento " + nome + ":");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}
