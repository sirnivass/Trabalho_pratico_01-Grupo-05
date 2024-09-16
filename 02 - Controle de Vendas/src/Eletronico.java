class Eletronico extends Produto{
    public Eletronico(String Nome, double Valor){
        super(Nome, Valor);
    }

    public String getTipo(){
        return "Eletrônico";
    }
}
