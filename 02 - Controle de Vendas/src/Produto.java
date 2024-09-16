public class Produto {
    private String Nome;
    private double Valor;

    public Produto(String Nome, double Valor){
        this.Nome = Nome;
        this.Valor = Valor;
    }

    public String getNome(){
        return Nome;
    }

    public double getValor(){
        return Valor;
    }


}
