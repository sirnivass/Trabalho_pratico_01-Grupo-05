package biblioteca;

import java.util.Scanner;

public class SistemaBiblioteca {
    @Test
    public static void main(String[] args) {
        
        Scanner escolha = new Scanner(System.in); // Inicializa o objeto Scanner para leitura do teclado
        Biblioteca biblioteca = new Biblioteca(); // Inicializa a instância de Biblioteca para usar os métodos

        while (true) { // Loop infinito para exibir o menu até o usuário escolher a opção de sair (opção 7)
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Listar Livros Disponíveis");
            System.out.println("6. Listar Livros Emprestados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = escolha.nextInt(); // Lê a opção escolhida pelo usuário
            escolha.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Adicionar Livro
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = escolha.nextLine(); // Lê o título do livro fornecido
                    biblioteca.adicionarLivro(tituloLivro); // Chama o método para adicionar o livro
                    break;

                case 2:
                    // Cadastrar Usuário
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = escolha.nextLine(); // Lê o nome do usuário fornecido
                    System.out.print("O usuário é aluno (1) ou professor (2)? ");
                    int tipoUsuario = escolha.nextInt(); // Lê o tipo de usuário (1 para Aluno, 2 para Professor)
                    escolha.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

                    if (tipoUsuario == 1) {
                        biblioteca.cadastrarUsuario(new Aluno(nomeUsuario, 1)); // Cadastra um novo aluno
                    } else if (tipoUsuario == 2) {
                        biblioteca.cadastrarUsuario(new Professor(nomeUsuario, 3)); // Cadastra um novo professor
                    } else {
                        System.out.println("Tipo de usuário inválido."); // Exibe erro para tipo inválido
                    }
                    break;

                case 3:
                    // Realizar Empréstimo
                    System.out.print("Digite o nome do usuário: ");
                    nomeUsuario = escolha.nextLine(); // Lê o nome do usuário
                    System.out.print("Digite o título do livro: ");
                    tituloLivro = escolha.nextLine(); // Lê o título do livro
                    biblioteca.realizarEmprestimo(nomeUsuario, tituloLivro); // Chama o método para realizar empréstimo
                    break;

                case 4:
                    // Realizar Devolução
                    System.out.print("Digite o nome do usuário: ");
                    nomeUsuario = escolha.nextLine(); // Lê o nome do usuário
                    System.out.print("Digite o título do livro: ");
                    tituloLivro = escolha.nextLine(); // Lê o título do livro
                    biblioteca.realizarDevolucao(nomeUsuario, tituloLivro); // Chama o método para realizar a devolução
                    break;

                case 5:
                    // Listar Livros Disponíveis
                    biblioteca.listarLivrosDisponiveis(); // Lista os livros que não estão emprestados
                    break;

                case 6:
                    // Listar Livros Emprestados
                    biblioteca.listarLivrosEmprestados(); // Lista os livros que estão emprestados
                    break;

                case 7:
                    // Sair
                    System.out.println("Saindo...");
                    escolha.close(); // Fecha o Scanner
                    return; // Encerra o programa

                default:
                    // Opção inválida
                    System.out.println("Opção inválida.");
            }
        }
    }
}
