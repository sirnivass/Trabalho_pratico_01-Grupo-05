class Alimento extends Produto {
     public Alimento(String Nome, double Valor){
         super(Nome, Valor);
     }

     public String getTipo(){
         return "Alimento";
     }
}
