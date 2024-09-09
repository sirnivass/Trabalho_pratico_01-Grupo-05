public class Motorista {
    private String nome;
    private int cpf;
    private int numeroCNH;
    private  String categoriaCNH;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public int getCpf() {
        return cpf;
    }

    public void setNumeroCNH(int numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
    public int getNumeroCNH() {
        return numeroCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }
    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public Motorista(String nome, int cpf, int numeroCNH, String categoriaCNH) {
        setNome(nome);
        setCpf(cpf);
        setNumeroCNH(numeroCNH);
        setCategoriaCNH(categoriaCNH);
    }
}
