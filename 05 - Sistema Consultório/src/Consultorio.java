import java.util.ArrayList;
import java.time.LocalDate;

public class Consultorio {
    private int contConsultas = 1;
    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Consulta> consultas;

    public Consultorio() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
        System.out.println("Médico cadastrado: " + medico);
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println(paciente + " cadastrado.");
    }

    public void agendarConsulta(String nomeMedico, String nomePaciente, LocalDate data) {
        Medico medico = buscarMedico(nomeMedico);
        Paciente paciente = buscarPaciente(nomePaciente);

        if (medico != null && paciente != null) {
            Consulta consulta = new Consulta(contConsultas, medico, paciente, data);
            consultas.add(consulta);
            System.out.println("Consulta agendada.");
            contConsultas++;
        } else {
            System.out.println("Erro ao agendar. Verifique os nomes.");
        }
    }

    public void registrarDiagnostico(int id, String diagnostico) {
        Consulta consulta = buscarConsulta(id);
        if (consulta != null) {
            consulta.registrarDiagnostico(diagnostico);
            System.out.println("Diagnóstico registrado.");
            return;
        }
        System.out.println("Consulta não encontrada.");
    }

    public void cancelarConsulta(int id) {
        Consulta consulta = buscarConsulta(id);
        if (consulta != null) {
            consulta.cancelar();
            System.out.println("Consulta cancelada.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    public void consultasAgendadas() {
        System.out.println("Consultas agendadas:");
        for (Consulta consulta : consultas) {
            if (consulta.getStatus().equalsIgnoreCase("Agendada")) {
                System.out.println(consulta);
            }
        }
    }

    public void listarConsultasPorPaciente(String nomePaciente) {
        Paciente paciente = buscarPaciente(nomePaciente);
        if (paciente != null) {
            System.out.println("Histórico de consultas de " + paciente.getNome() + ":");
            for (Consulta consulta : consultas) {
                if (consulta.getPaciente().getNome().equalsIgnoreCase(nomePaciente)) {
                    System.out.println(consulta);
                }
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void listarConsultasPorMedico(String nomeMedico) {
        Medico medico = buscarMedico(nomeMedico);
        if (medico != null) {
            System.out.println("Consultas realizadas por " + medico.getNome() + ":");
            for (Consulta consulta : consultas) {
                if (consulta.getMedico().getNome().equalsIgnoreCase(nomeMedico)) {
                    System.out.println(consulta);
                }
            }
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    private Medico buscarMedico(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                return medico;
            }
        }
        return null;
    }

    private Paciente buscarPaciente(String nome) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
            }
        }
        return null;
    }

    private Consulta buscarConsulta(int id) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }
}
