public class Especialista extends Medico { // classe herança de médico especialista
    private String especialidade;

    public Especialista(String nome, String crm, String especialidade) {
        super(nome, crm);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return super.toString() + "Especialidade: " + getEspecialidade();
    }
}
