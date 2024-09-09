public class Veiculo {
    private String tipo;
    private String placa;
    private String localizacao;
    private String modelo;
    int ano;
    Manutencao manutencao;


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    // Construtor da classe
    public Veiculo(String tipo, String placa, String localizacao, String modelo, int ano, Manutencao manutencao) {
        setTipo(tipo);
        setPlaca(placa);
        setLocalizacao(localizacao);
        setModelo(modelo);
        setAno(ano);
        this.manutencao = manutencao;
    }

}
