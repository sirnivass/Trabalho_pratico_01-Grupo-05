public class Gerente extends Funcionario {
  private double totalVendas;

  public Gerente(String nome, double salario, double totalVendas) {
      super(nome, salario, "Gerente");
      this.totalVendas = totalVendas;
  }

  public void adicionarVenda(double valorVenda) {
      totalVendas += valorVenda;
  }

  @Override
  public double getSalario() {
      return super.getSalario() + (0.005 * totalVendas); // Adicional de 0.5% sobre as vendas
  }
}
