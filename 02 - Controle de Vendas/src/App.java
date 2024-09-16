import java.util.Arrays;

public class App {

    /*Instruções:
     * implemente um sistema de controle de vendas para uma loja.
     * Esse sistema deve permitir que o usuário adicione produtos 
     * ao catálogo, realize vendas e visualize o histórico de vendas. 
     * As seguintes classes devem ser implementadas: 
     * Produto, Cliente, Venda, Loja. 
     * A loja pode ter produtos eletrônicos e alimentícios. 
     * Implemente métodos para adicionar produtos, 
     * cadastrar clientes, realizar vendas, calcular o total da venda 
     * e listar o histórico de vendas.
    */
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja();

        Produto Fone = new Eletronico("Fone", 250);
        Produto notebook = new Eletronico("Notebook", 4000);
        Produto Farinha = new Alimento("Farinha", 2.5);
        Produto Melancia = new Alimento("Melancia", 4.0);

        loja.adicionarProduto(Fone);
        loja.adicionarProduto(notebook);
        loja.adicionarProduto(Farinha);
        loja.adicionarProduto(Melancia);

        Cliente cliente = new Cliente("Amanda Silva", "140.807.901-53");
        loja.cadastrarCliente(cliente);

        loja.realizarVenda(cliente, Arrays.asList(Fone, Farinha, Melancia, notebook));


        loja.listarHistoricoVendas();
    }
}
