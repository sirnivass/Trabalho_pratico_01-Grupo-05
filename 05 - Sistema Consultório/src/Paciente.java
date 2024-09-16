public class Paciente { //cria a classe paciente com nome e CPF
    private String nome;
    private String cpf;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Paciente: " + nome + " (CPF: " + cpf + ")"; //retorna printando o nome e CPF do paciente
    }
}
