package biblioteca;

import java.util.ArrayList;// Importa a classe ArrayList para permitir o uso de listas dinâmicas
                           // Já que nao temos banco, vamos guardar os resultado na memória.

public class Biblioteca { // Declaração da classe Biblioteca que vai gerenciar os livros, usuários e empréstimos

    private ArrayList<Livro> livros = new ArrayList<>();// O ideal era gravar no Banco, mas como nao temos, vamos gravar isso num array. 
                                                        // Cria uma lista de objetos do tipo Livro para armazenar os livros da biblioteca

    private ArrayList<Usuario> usuarios = new ArrayList<>();// Cria uma lista de objetos do tipo Usuario para armazenar os usuários cadastrados

    private ArrayList<String> emprestimos = new ArrayList<>();// Cria uma lista de Strings para armazenar os registros de empréstimos realizados (nome do usuário + livro emprestado)

    public void adicionarLivro(String titulo) {// Método para adicionar um novo livro à biblioteca. Recebe o título como argumento.

        livros.add(new Livro(titulo));// Adiciona um novo objeto Livro à lista 'livros' com base no título fornecido

        System.out.println("Livro adicionado: " + titulo);// Imprime uma mensagem informando que o livro foi adicionado com sucesso
    }

    public void cadastrarUsuario(Usuario usuario) {// Método para cadastrar um novo usuário na biblioteca. Recebe um objeto Usuario como argumento.

        usuarios.add(usuario);// Adiciona o objeto Usuario à lista 'usuarios'

        System.out.println("Usuário cadastrado: " + usuario.getNomeUsuario());// Imprime uma mensagem com o nome do usuário recém-cadastrado
    }

    public void listarLivrosDisponiveis() {// Método para listar todos os livros disponíveis (não emprestados) na biblioteca

        System.out.println("Livros disponíveis:");// Exibe a mensagem de cabeçalho para a lista de livros disponíveis

        for (Livro livro : livros) {// Percorre a lista de livros

            if (!livro.isEmprestado()) {// Verifica se o livro não está emprestado

                System.out.println(livro.getTitulo());// Exibe o título do livro disponível
            }
        }
    }

    public void listarLivrosEmprestados() {// Método para listar todos os livros que estão emprestados

        System.out.println("Livros emprestados:");// Exibe a mensagem de cabeçalho para a lista de livros emprestados

        for (String emprestimo : emprestimos) {// Percorre a lista de empréstimos

            System.out.println(emprestimo);// Exibe o registro de cada empréstimo
        }
    }

    public void realizarEmprestimo(String nomeUsuario, String tituloLivro) {// Método para realizar um empréstimo. Recebe o nome do usuário e o título do livro como parâmetros.

        Usuario usuario = encontrarUsuario(nomeUsuario);// Encontra o usuário pelo nome usando o método encontrarUsuario()

        Livro livro = encontrarLivro(tituloLivro);// Encontra o livro pelo título usando o método encontrarLivro()

        if (usuario != null && livro != null) {// Verifica se tanto o usuário quanto o livro foram encontrados
            
            // Conta quantos livros o usuário já emprestou, filtrando a lista de empréstimos pelo nome do usuário
            long livrosEmprestados = emprestimos.stream().filter(e -> e.startsWith(nomeUsuario)).count();
            
                            // Verifica se o usuário pode emprestar mais livros (baseado na regra de negócio de limite) e se o livro não está emprestado
            if (usuario.podeEmprestar((int) livrosEmprestados) && !livro.isEmprestado()) {


                livro.setEmprestado(true);// Marca o livro como emprestado

                emprestimos.add(nomeUsuario + " emprestou " + tituloLivro);// Adiciona o registro do empréstimo na lista de empréstimos

                System.out.println("Empréstimo realizado.");// Exibe mensagem de confirmação de empréstimo
            } else {
                System.out.println("Empréstimo não permitido.");// Exibe mensagem caso o usuário não possa emprestar mais livros ou o livro já esteja emprestado
            }
        } else {
            System.out.println("Usuário ou livro não encontrado.");// Exibe mensagem se o usuário ou o livro não forem encontrados
        }
    }

    public void realizarDevolucao(String nomeUsuario, String tituloLivro) {// Método para realizar a devolução de um livro. Recebe o nome do usuário e o título do livro como parâmetros.

        Livro livro = encontrarLivro(tituloLivro);// Encontra o livro pelo título usando o método encontrarLivro()

        if (livro != null && livro.isEmprestado()) {// Verifica se o livro foi encontrado e se ele está emprestado

            livro.setEmprestado(false);// Marca o livro como não emprestado (disponível)

            emprestimos.removeIf(e -> e.equals(nomeUsuario + " emprestou " + tituloLivro));// Remove o registro do empréstimo da lista de empréstimos

            System.out.println("Devolução realizada.");// Exibe mensagem de confirmação da devolução
        } else {
            System.out.println("Livro não encontrado ou não está emprestado.");// Exibe mensagem se o livro não for encontrado ou se ele já não estiver emprestado
        }
    }

    private Usuario encontrarUsuario(String nomeUsuario) {// Método privado para encontrar um usuário pelo nome na lista de usuários

        for (Usuario usuario : usuarios) {// Percorre a lista de usuários

            if (usuario.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {// Verifica se o nome do usuário é igual ao nome fornecido (ignora maiúsculas e minúsculas)

                return usuario;// Retorna o usuário se encontrado
            }
        }

        return null;// Retorna 'null' se o usuário não for encontrado
    }

    private Livro encontrarLivro(String tituloLivro) {// Método privado para encontrar um livro pelo título na lista de livros

        for (Livro livro : livros) {// Percorre a lista de livros

            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {// Verifica se o título do livro é igual ao título fornecido (ignora maiúsculas e minúsculas)

                return livro;// Retorna o livro se encontrado
            }
        }

        return null;// Retorna 'null' se o livro não for encontrado
    }
}