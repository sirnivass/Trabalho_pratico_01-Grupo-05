public class ClinicoGeral extends Medico { // classe herança de médico para clico geral
    public ClinicoGeral(String nome, String crm) {
        super(nome, crm);
    }

    @Override
    public String toString() {
        return super.toString() + " Clínico Geral";
    }
}
