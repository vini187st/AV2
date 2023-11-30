package provaAv2;

import java.util.ArrayList;
import java.util.Date;

class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido;

    public Pedido(int numeroPedido, Date dataHoraPedido, double precoTotal, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = dataHoraPedido;
        this.precoTotal = precoTotal;
        this.statusPedido = statusPedido;
        this.itensPedido = new ArrayList<>();
    }

    // aplicação dos Getters e Setters
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    // Método para inserir itens no pedido
    public void inserirItensPedido(PedidoItem item) {
        this.itensPedido.add(item);
    }

    // Método para excluir itens do pedido
    public void excluirItensPedido(PedidoItem item) {
        this.itensPedido.remove(item);
    }

    // Método para calcular o total a pagar
    public double calculaTotalPagar() {
        double total = 0;
        for (PedidoItem item : itensPedido) {
            total += item.getPrecoItem();
        }
        return total;
    }

    // Método para alterar o status do pedido
    public void alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
    }

    // Método para consultar pedido
    public boolean consultarPedido(Pedido pedido) {
        return this.numeroPedido == pedido.getNumeroPedido();
    }
}

