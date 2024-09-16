import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
        Scanner scanner = new Scanner(System.in);
        final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Clínico Geral");
            System.out.println("2. Cadastrar Especialista");
            System.out.println("3. Cadastrar Paciente");
            System.out.println("4. Agendar Consulta");
            System.out.println("5. Registrar Diagnóstico");
            System.out.println("6. Consultas Agendadas");
            System.out.println("7. Listar Consultas por Paciente");
            System.out.println("8. Listar Consultas por Médico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarClinicoGeral(consultorio, scanner);
                    break;

                case 2:
                    cadastrarEspecialista(consultorio, scanner);
                    break;

                case 3:
                    cadastrarPaciente(consultorio, scanner);
                    break;

                case 4:
                    agendarConsulta(consultorio, scanner, fmt);
                    break;

                case 5:
                    diagnosticar(consultorio, scanner);
                    break;

                case 6:
                    consultorio.consultasAgendadas();
                    break;

                case 7:
                    consultasPaciente(consultorio, scanner);
                    break;

                case 8:
                    consultasMedico(consultorio, scanner);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarClinicoGeral(Consultorio consultorio, Scanner scanner) {
        System.out.print("Nome do Clínico Geral: ");
        String nomeClinicoGeral = scanner.nextLine();
        System.out.print("CRM: ");
        String crmClinicoGeral = scanner.nextLine();
        consultorio.cadastrarMedico(new ClinicoGeral(nomeClinicoGeral, crmClinicoGeral));
    }

    public static void cadastrarEspecialista(Consultorio consultorio, Scanner scanner) {
        System.out.print("Nome do Especialista: ");
        String nomeEspecialista = scanner.nextLine();
        System.out.print("CRM: ");
        String crmEspecialista = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        consultorio.cadastrarMedico(new Especialista(nomeEspecialista, crmEspecialista, especialidade));
    }

    public static void cadastrarPaciente(Consultorio consultorio, Scanner scanner) {
        System.out.print("Nome do Paciente: ");
        String nomePaciente = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfPaciente = scanner.nextLine();
        consultorio.cadastrarPaciente(new Paciente(nomePaciente, cpfPaciente));
    }

    // Solicita o nome do paciente, do médico e a data da consulta e valida a data
    public static void agendarConsulta(Consultorio consultorio, Scanner scanner, DateTimeFormatter fmt) {
        System.out.print("Nome do Médico: ");
        String nomeMedico = scanner.nextLine();
        System.out.print("Nome do Paciente: ");
        String nomePaciente = scanner.nextLine();
        System.out.print("Data da Consulta (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        try {
            LocalDate dataConsulta = LocalDate.parse(data, fmt);
            if (dataConsulta.isBefore(LocalDate.now())) {
                System.out.println("Data inválida. Consultas devem ser agendadas para datas futuras.");
                return;
            }
            consultorio.agendarConsulta(nomeMedico, nomePaciente, dataConsulta);
        } catch (Exception e) {
            System.out.println("Formato de data inválido.");
        }
    }

    public static void diagnosticar(Consultorio consultorio, Scanner scanner) {
        System.out.print("Id da Consulta: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();
        consultorio.registrarDiagnostico(id, diagnostico);
    }

    public static void consultasPaciente(Consultorio consultorio, Scanner scanner) {
        System.out.print("Nome do Paciente: ");
        String nomePaciente = scanner.nextLine();
        consultorio.listarConsultasPorPaciente(nomePaciente);
    }

    public static void consultasMedico(Consultorio consultorio, Scanner scanner) {
        System.out.print("Nome do Médico: ");
        String nomeMedico = scanner.nextLine();
        consultorio.listarConsultasPorMedico(nomeMedico);
    }
}
