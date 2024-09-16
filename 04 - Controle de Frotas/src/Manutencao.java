import java.util.Date;

public class Manutencao {
    private Veiculo veiculo;
    private Date date;
    double valor;
    private String servico;

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    public String getServico() {
        return servico;
    }

    public Manutencao(Veiculo veiculo, Date date, double valor, String servico) {
        setVeiculo(veiculo);
        setDate(date);
        setValor(valor);
        setServico(servico);
    }
}
