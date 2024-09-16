import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Frota frota = new Frota(); // criando um objeto Frota

        System.out.println("Bem-vindo ao sistema de gerenciamento de frota!");

        while (true) {
            System.out.println("\n Digite 1 para cadastrar um novo motorista; " +
                    "\n Digite 2 para cadastrar um veiculo (Carro, Caminhão, Moto);" +
                    "\n Digite 3 para registrar manutencao;" +
                    "\n Digite 4 para rastrear veiculo;" +
                    "\n Digite 5 para rastrear os veiculos de uma cidade;");

            int menu = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (menu) {
                case 1: // Cadastrar motorista

                    System.out.println("Cadastrando um novo motorista:" +
                            "\nDigite o nome do motorista: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o CPF do motorista: (somente os numeros)");
                    int cpf = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.println("Digite o número da CNH do motorista:");
                    int numCNH = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.println("Digite a categoria da CNH do motorista:");
                    String catCNH = scanner.nextLine();

                    Motorista motorista = new Motorista(nome, cpf, numCNH, catCNH); // Construtor Motorista
                    frota.adicionarMotorista(motorista);   // Adiciona motorista na lista de motoristas

                    break;

                case 2: // Cadastrar um veículo (Carro, Caminhão, Moto)

                    System.out.println("Cadastrando um novo veiculo:");
                    boolean veiculoBoolean = true;
                    String tipo = "";

                    while (veiculoBoolean) { // Meu para selecionar tipo de veiculo
                        System.out.println("Digite 1 se o veiculo for um Carro" +
                                "\nDigite 2 se o veiculo for um Caminhao" +
                                "\nDigite 3 se o veiculo for uma Moto");
                        int menuVeiculo = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        switch (menuVeiculo) {
                            case 1:
                                tipo = "Carro";
                                veiculoBoolean = false;
                                break;
                            case 2:
                                tipo = "Caminhao";
                                veiculoBoolean = false;
                                break;
                            case 3:
                                tipo = "Moto";
                                veiculoBoolean = false;
                                break;
                            default:
                                System.out.println("Opção inválida, favor digitar uma das opções do menu.");
                                break;
                        }
                    }

                    System.out.println("Digite a placa do veiculo:");
                    String placa = scanner.nextLine();

                    System.out.println("Digite a localização do veiculo:");
                    String localizacao = scanner.nextLine();

                    System.out.println("Digite modelo do veiculo:");
                    String modelo = scanner.nextLine();

                    System.out.println("Digite ano do veiculo:");
                    int ano = scanner.nextInt();

                    Manutencao manutencao = null; // A manutenção inicializa como nula
                    Veiculo veiculo = new Veiculo(tipo, placa, localizacao, modelo, ano, manutencao);

                    frota.adicionarVeiculo(veiculo); //metodo para adicionar veico na frota
                    break;

                case 3: // Registrar manutenção

                    System.out.println("Informe a placa do veiculo:");
                    placa = scanner.nextLine();
                    Veiculo veiculoManutencao = null;

                    // Busca o veiculo pela placa
                    for (Veiculo veiculoV : frota.getVeiculos()) {
                        if (veiculoV.getPlaca().equalsIgnoreCase(placa)) {
                            veiculoManutencao = veiculoV;
                            break;
                        }
                    }

                    if (veiculoManutencao == null) { // verifica se a veiculoManutencao
                        System.out.println("Veiculo não foi encontrado.");
                        break;
                    }

                    System.out.println("Informe a data da manutenção no formato (Dia/mes/ano): Ex:15/01/2024");
                    String dataString = scanner.nextLine();

                    if (!ValidarData.validarData(dataString)) {
                        System.out.println("Data inválida. Não foi possível cadastrar a manutenção com a data informada.");
                        break;
                    }

                    Date data = new Date(); // Inicializa com a data atual como fallback
                    try {
                        data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString); // Converte a string para uma data
                    } catch (ParseException e) {
                        System.out.println("Erro na análise da data.");
                        break;
                    }

                    System.out.println("Informe o valor da manutenção:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer após nextDouble()

                    System.out.println("Informe qual serviço foi realizado:");
                    String servico = scanner.nextLine();

                    // Criar o objeto de manutenção
                    Manutencao novaManutencao = new Manutencao(veiculoManutencao, data, valor, servico);
                    frota.registrarManutencao(novaManutencao);

                    System.out.println("Manutenção registrada com sucesso!");
                    break;

                case 4: // Localiza veiculo

                    System.out.println("Informe a placa do veiculo a ser localizado:");
                    placa = scanner.nextLine();
                    int aux = 0;

                    // Busca o veiculo pela placa
                    for (Veiculo veiculoV : frota.getVeiculos()) {
                        if (veiculoV.getPlaca().equalsIgnoreCase(placa)) {
                            System.out.println( veiculoV.getTipo() + " modelo " + veiculoV.getModelo() + " com placa: " + veiculoV.getPlaca() + ", esta na cidade " + veiculoV.getLocalizacao());
                            aux ++;
                            break;
                        }
                    }

                    if (aux == 0) { // Verifica se o veiculo foi encontrado
                        System.out.println("Veiculo não foi encontrado.");
                        break;
                    }
                    break;

                case 5: // Rastrear veículos de detrminada cidade
                    System.out.println("Digite a cidade para listar os veículos:");
                    String cidade = scanner.nextLine();

                    aux = 0;

                    System.out.println("Veículos na cidade " + cidade + ":");
                    for (Veiculo v : frota.getVeiculos()) {
                        if (v.getLocalizacao().equalsIgnoreCase(cidade)) {
                            System.out.println( v.getTipo() + " modelo " + v.getModelo() + " com a placa: " + v.getPlaca());
                            aux++;
                        }
                    }
                    if (aux ==0) // verifica se a cidade foi encontrada
                        System.out.println("Nenhum veiculo foi encontrado na cidade.\n");
                    break;

                default:
                    System.out.println("Opção inválida, digite uma das opções do menu.");
                    break;
            }

        }

    }
}