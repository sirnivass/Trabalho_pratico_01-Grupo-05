package biblioteca;

//Classe pública como manda o figurino
public class Livro {//Sim eu criei uma classe Livro, já que tudo é classe, livro será classe tb.
    private String titulo; //Atributo Privado, como manda o professor
    private String autor;
    private boolean emprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    public String getAutor() {
        return autor;
    }

}