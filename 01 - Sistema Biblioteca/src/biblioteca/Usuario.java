package biblioteca;

public class Usuario {
    // private é visível apenas dentro da própria classe, já protected é visível em
    // classes "filhas".
    private String nome; // Pq todo mundo tem um nome.
    protected int maxLivros;/// Visível nas subclasses (Aluno, Professor)
    protected boolean podeEmprestar; // Será true enqauto i < maxLivros

    public Usuario(String nome, int maxLivros) { // Pensei em deixar construtor em branco, mas resolvi que melhor não.
        this.nome = nome; // Inicializa a variável 'nome' da classe Usuario
    }

    // Métodos para acessar os dados
    public String getNomeUsuario() {
        return nome;
    }

    /*
     * Definir as regras de empréstimo
     * 
     * Pensando que o Aluno pode pegar até um Livro e o Professor até 3 livros.
     * 
     * Vamos:
     * Verificar quantos livros o usuário já emprestou. (Com o método pode
     * emprestar)
     * Comparar essa quantidade com o limite permitido para o tipo de usuário (Aluno
     * ou Professor).
     * Se o número de livros emprestados for menor que o limite, o usuário pode
     * pegar outro livro.
     * Se o limite já foi atingido, o usuário não está apto a pegar outro livro.
     */

    public boolean podeEmprestar(int livrosEmprestados) {// Numa funçãoboo
        return livrosEmprestados < maxLivros; // Verifica se o usuário pode pegar mais livros
    }

}
