// Define que esta classe faz parte do pacote 'biblioteca', o que organiza o código e facilita a importação de outras classes deste pacote.
package biblioteca;

public class Livro {// Sim eu criei uma classe Livro, já que tudo é classe, livro será classe tb.
    // Declaração da classe 'Livro', que modela um livro no sistema de gerenciamento
    // da biblioteca.
    private String titulo; // Declara o atributo 'titulo', que armazena o título do livro.
                           // Como é 'private', só pode ser acessado diretamente dentro da classe 'Livro'.

    private boolean emprestado; // Declara o atributo 'emprestado', que indica se o livro está emprestado ou
                                // não.
                                // O tipo booleano armazena 'true' (se estiver emprestado) ou 'false' (se
                                // estiver disponível).

    public Livro(String titulo) { // Construtor da classe 'Livro'. É chamado ao criar um novo objeto 'Livro'.
                                  // Ele recebe o título do livro como parâmetro e inicializa o atributo 'titulo'.

        this.titulo = titulo; // Atribui o valor do parâmetro 'titulo' ao atributo 'titulo' da instância atual
                              // (usando 'this' para referir-se ao campo da classe).

        this.emprestado = false; // Inicializa o atributo 'emprestado' como 'false', indicando que o livro está
                                 // disponível por padrão quando criado.
    }

    public String getTitulo() { // Método getter para obter o título do livro. Como o campo 'titulo' é privado,
                                // este método fornece acesso ao título de fora da classe.

        return titulo;// Retorna o título do livro.
    }

    public boolean estaEmprestado() {
        // Método getter para verificar se o livro está emprestado.
        // Este método retorna o valor do campo 'emprestado', permitindo que outras
        // classes saibam se o livro está emprestado.

        return emprestado;// 'true' = emprestado ou 'false' = disponível    
    }

    public void setEmprestado(boolean emprestado) {// Método setter para alterar o estado de empréstimo do livro.
                                                   // Este método permite definir se o livro está emprestado ou disponível,
                                                   // recebendo um valor booleano como argumento.

        this.emprestado = emprestado; // Atribui o valor do parâmetro 'emprestado' ao campo 'emprestado' do objeto
                                      // atual (usando 'this' para diferenciar o campo do parâmetro).
    }
}