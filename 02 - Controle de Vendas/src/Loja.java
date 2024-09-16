import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> catalogo;
    private List<Cliente> clientes;
    private List<Venda> historicoVendas;
    

    public Loja() {
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.historicoVendas = new ArrayList<>();
    }


    public void adicionarProduto(Produto produto) {
        catalogo.add(produto);
    }


    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarVenda(Cliente cliente, List<Produto> produtos) {
        Venda venda = new Venda(cliente, produtos);
        historicoVendas.add(venda);
        System.out.println("Venda realizada: " + venda);
    }

    public double calcularTotalVenda(List<Produto> produtos) {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }


    public void listarHistoricoVendas() {
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            for (Venda venda : historicoVendas) {
                System.out.println(venda);
            }
        }
    }


}
