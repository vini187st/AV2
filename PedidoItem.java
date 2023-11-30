package provaAv2;
import java.util.ArrayList;
import java.util.Date;
class PedidoItem {
    private String nomeItem;
    private int qtdeItem;
    private double precoItem;

    public PedidoItem(String nomeItem, int qtdeItem, double precoItem) {
        this.nomeItem = nomeItem;
        this.qtdeItem = qtdeItem;
        this.precoItem = precoItem;
    }

    // Getters e Setters
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQtdeItem() {
        return qtdeItem;
    }

    public void setQtdeItem(int qtdeItem) {
        this.qtdeItem = qtdeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    // Método para atualizar estoque do item
    public boolean atualizarEstoqueItem() {
        // Implemente a lógica para atualizar o estoque do item, se necessário
        return true;
    }
}

