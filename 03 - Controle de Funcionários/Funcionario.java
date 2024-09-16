public class Funcionario {
  private String nome;
  private double salario;
  private String cargo;

  public Funcionario(String nome, double salario, String cargo) {
    this.nome = nome;
    this.salario = salario;
    this.cargo = cargo;
  }

  public String getNome() {
    return nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getCargo() {
    return cargo;
  }

  public void promover(String novoCargo, double aumento) {
    this.cargo = novoCargo;
    this.salario += aumento;
  }

  @Override
  public String toString() {
    return "Nome: " + nome + ", Cargo: " + cargo + ", Salário: " + salario;
  }
}
