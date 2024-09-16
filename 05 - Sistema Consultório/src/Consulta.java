import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consulta { //cria a classe consulta e faz a formatação da data

    private int id;
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private String diagnostico;
    private String status; 
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Consulta(int id, Medico medico, Paciente paciente, LocalDate data) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.diagnostico = "Não diagnosticado"; //iniacializa sem nenhum diagnostico
        this.status = "Agendada";
    }

    public int getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void registrarDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
        this.status = "Finalizada";
    }

    public void cancelar() {
        this.status = "Cancelada";
    }

    @Override
    public String toString() {
        return getId() + " - Consulta de " + getPaciente().getNome() + " com " + getMedico() + " em " + fmt.format(getData()) + "\nDiagnóstico: " + diagnostico;
    }
}
