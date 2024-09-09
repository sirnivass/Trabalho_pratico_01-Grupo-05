import java.util.ArrayList;
import java.util.List;

public class Frota {
    private List<Motorista> motoristas; // Cria uma lista de motorista
    private List<Veiculo> veiculos;  // Cria uma lista de Veiculos
    private List<Manutencao> manutencoes; //Cria uma lista de manutencoes

    // Construtor da classe
    public Frota() {
        motoristas = new ArrayList<>();
        veiculos = new ArrayList<>();
        manutencoes = new ArrayList<>();
    }

    public void adicionarMotorista(Motorista motorista) {
        int aux = 0;

        // Verifica se o CPF já foi cadastrado.
        for (Motorista m : motoristas){
            if (motorista.getCpf() == m.getCpf()){
                System.out.println("ERRO: já existe um motorista o mesmo CPF.\n");
                aux = 1;
                break;
            }
        }
        if (aux == 0){
            motoristas.add(motorista);
            System.out.println("Motorista cadastrado com sucesso.\n");
        }

    }

    public void adicionarVeiculo(Veiculo veiculo) {
        int aux = 0;

        // Verifica se a placa já foi cadastrada.
        for (Veiculo v : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(v.getPlaca())) {
                System.out.println("ERRO: já existe um veiculo com mesma placa.\n");
                aux = 1;
                break;
            }
        }
        if (aux==0){
            veiculos.add(veiculo);
            System.out.println("Veiculo cadastrado com sucesso.\n");
        }
    }

    public void registrarManutencao(Manutencao manutencao) {
        manutencoes.add(manutencao);
    }

    public List<Veiculo> listarVeiculosPorCidade(String cidade) {
        List<Veiculo> veiculosNaCidade = new ArrayList<>();

        // proucura por cidades com o nome da string cidade
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getLocalizacao().equalsIgnoreCase(cidade)) {
                veiculosNaCidade.add(veiculo);
            }
        }
        return veiculosNaCidade;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }
}