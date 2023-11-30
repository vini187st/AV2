package provaAv2;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criando categorias
        Categoria categoria1 = new Categoria("Alimentos");
        Categoria categoria2 = new Categoria("Limpeza");

        // Criando produtos alimentos e de limpezas
        Produto produto1 = new Produto("Arroz", 5.0, "Arroz tipo 5kg", 50, categoria1);
        Produto produto2 = new Produto("Feijão", 4.0, "Feijão preto 1kg", 30, categoria1);
        Produto produto3 = new Produto("Detergente", 2.5, "Detergente neutro 500ml", 40, categoria2);
        Produto produto4 = new Produto("veja", 7.0, "veja 350ml", 20, categoria2);
        Produto produto5 = new Produto("Óleo de Soja", 2.5, "Óleo de soja 750ml", 25, categoria1);

        // Criando lista de produtos
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);
        listaProdutos.add(produto4);
        listaProdutos.add(produto5);

        // Criando pedidos 1 e 2
        Pedido pedido1 = new Pedido(1, new Date(), 0, 1);
        Pedido pedido2 = new Pedido(2, new Date(), 0, 2);

        // Criando itens de pedido
        PedidoItem item1 = new PedidoItem("Arroz", 2, 5.0);
        PedidoItem item2 = new PedidoItem("Feijão", 3, 4.0);
        PedidoItem item3 = new PedidoItem("Detergente", 1, 2.5);
        PedidoItem item4 = new PedidoItem("veja", 2, 7.0);
        PedidoItem item5 = new PedidoItem("Óleo de Soja", 1, 3.5);

        // Validando e inserindo itens nos pedidos
        if (validaItem(item1, listaProdutos)) {
            pedido1.inserirItensPedido(item1);
            atualizaEstoque(item1, listaProdutos);
        }

        if (validaItem(item2, listaProdutos)) {
            pedido1.inserirItensPedido(item2);
            atualizaEstoque(item2, listaProdutos);
        }

        if (validaItem(item3, listaProdutos)) {
            pedido1.inserirItensPedido(item3);
            atualizaEstoque(item3, listaProdutos);
        }

        if (validaItem(item4, listaProdutos)) {
            pedido2.inserirItensPedido(item4);
            atualizaEstoque(item4, listaProdutos);
        }

        if (validaItem(item5, listaProdutos)) {
            pedido2.inserirItensPedido(item5);
            atualizaEstoque(item5, listaProdutos);
        }

        // Atualizando status dos pedidos
        pedido1.alterarStatus(2);
        pedido2.alterarStatus(2);

        // Calculando o total a pagar para cada pedido
        double totalPagarPedido1 = pedido1.calculaTotalPagar();
        double totalPagarPedido2 = pedido2.calculaTotalPagar();

        // Exibindo resultados
        System.out.println("Pedido 1 - Total a Pagar: R$" + totalPagarPedido1);
        System.out.println("Pedido 2 - Total a Pagar: R$" + totalPagarPedido2);
    }

    // Método para validar se um item de pedido existe na lista de produtos
    private static boolean validaItem(PedidoItem item, ArrayList<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            if (produto.getNomeProduto().equals(item.getNomeItem())) {
                return true;
            }
        }
        System.out.println("Erro: Produto não encontrado para o item " + item.getNomeItem());
        return false;
    }

    // Método para atualizar o estoque após a inserção do item
    private static void atualizaEstoque(PedidoItem item, ArrayList<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            if (produto.getNomeProduto().equals(item.getNomeItem())) {
                int novoEstoque = produto.getEstoqueAtual() - item.getQtdeItem();
                produto.setEstoqueAtual(novoEstoque);
                System.out.println("Estoque atualizado para o produto " + produto.getNomeProduto() + ": " + novoEstoque);
                break;
            }
        }
    }
}
