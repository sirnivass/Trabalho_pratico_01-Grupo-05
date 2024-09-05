package biblioteca;

public class Professor extends Usuario {// Classe filha de usuario
    public Professor(String nome, String cadastro) {// Chama o construtor da classe pai com dois parâmetros (nome e
                                                    // cadastro)
        // A palavra-chave super é usada para chamar o construtor da classe pai.
        // Em resumo super(nome) garante que a variável nome da classe Usuario seja
        // corretamente inicializada ao criar objetos das filhas (aluno e professor)
        super(nome, cadastro); // super, chama o construtor de Usuario que espera um 'nome' e 'cadastro'
        this.maxLivros = 3; // Professor pode emprestar até 3 livros
    }
}
