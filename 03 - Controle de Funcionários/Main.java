public class Main {
  public static void main(String[] args) {
    
    // Criando a empresa
    Empresa empresa = new Empresa("Griot");

    // Criando departamentos
    Departamento desenvolvimento = new Departamento("Desenvolvimento");
    Departamento vendas = new Departamento("Vendas");

    // Adicionando departamentos à empresa
    empresa.adicionarDepartamento(desenvolvimento);
    empresa.adicionarDepartamento(vendas);

    // Criando funcionários
    Funcionario dev1 = new Funcionario("Giovanna", 3000.0, "Desenvolvedora");
    Funcionario dev2 = new Funcionario("Lucas", 3500.0, "Desenvolvedor");
    Gerente gerenteVendas = new Gerente("Ana", 5000.0, 20000.0); // Gerente com 20 mil em vendas

    // Adicionando funcionários aos departamentos
    desenvolvimento.adicionarFuncionario(dev1);
    desenvolvimento.adicionarFuncionario(dev2);
    vendas.adicionarFuncionario(gerenteVendas);

    // Listar funcionários por departamento
    empresa.listarFuncionariosPorDepartamento();

    // Mostrar salário do gerente (com adicional por vendas)
    System.out.println("Salário de Ana (Gerente): " + gerenteVendas.getSalario());

    // Promover um funcionário
    dev1.promover("Desenvolvedora Sênior", 1000.0);
    System.out.println("Após promoção: " + dev1);
  }
}
