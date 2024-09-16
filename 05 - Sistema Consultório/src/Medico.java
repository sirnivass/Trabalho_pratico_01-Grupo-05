public class Medico { // cria a classe médico com nome e CRM
    private String nome;
    private String crm;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public String toString() { // retorna printando o nome do médico e o CRM
        return "Médico " + getNome() + " (CRM: " + getCrm() + ")";
    }
}
