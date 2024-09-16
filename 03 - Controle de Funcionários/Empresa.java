import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Departamento> departamentos;

    public Empresa(String nome) {
        this.nome = nome;
        this.departamentos = new ArrayList<>();
    }

    public void adicionarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void listarDepartamentos() {
        System.out.println("Departamentos da empresa " + nome + ":");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }

    public void listarFuncionariosPorDepartamento() {
        for (Departamento departamento : departamentos) {
            departamento.listarFuncionarios();
        }
    }
}
