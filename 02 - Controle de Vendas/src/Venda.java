import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Venda(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + ", Total: R$ " + total;
    }




}
