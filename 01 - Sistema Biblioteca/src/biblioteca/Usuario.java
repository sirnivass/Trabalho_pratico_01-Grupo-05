package biblioteca;

public class Usuario {
    // private é visível apenas dentro da própria classe, já protected é visível em
    // classes "filhas".
    private String nome; // Pq todo mundo tem um nome.
    private String cadastro;// Pq todo sistema de biblioteca tem um cadastro de usuario.
    protected int maxLivros;/// Visível nas subclasses (Aluno, Professor)

    public Usuario(String nome, String cadastro) { // Pensei em deixar construtor em branco, mas resolvi que melhor não.
        this.nome = nome; // Inicializa a variável 'nome' da classe Usuario
        this.cadastro = cadastro; // Inicializa a variável 'cadastro' da classe Usuario
    }

    // Métodos para acessar os dados
    public String getNomeUsuario() {
        return nome;
    }

    public String getCadastro() {
        return cadastro;
    }

}
