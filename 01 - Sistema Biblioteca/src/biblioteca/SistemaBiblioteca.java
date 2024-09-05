package biblioteca;

import java.util.Scanner;

/*Instruções:
 * 
 * Crie um sistema para gerenciar uma biblioteca. O sistema deve permitir que o
 * usuário adicione novos livros, cadastre usuários e faça operações de
 * empréstimo e devolução de livros através de um menu de opções. 
 * Criar métodos para adicionar livros, registrar usuários, realizar 
 * empréstimos e devoluções, listar livros disponíveis e listar livros emprestados. 
 * Criar classes Aluno e Professor, sendo que o aluno pode emprestar apenas 1 por vez
 *  e o professor 3 livros por vez.
*/

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {//Nosso lindo e cheiroso menu
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Listar Livros Disponíveis");
            System.out.println("6. Listar Livros Emprestados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {

            }
        }
    }
}
