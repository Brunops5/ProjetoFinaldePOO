package main.trivago.entities;

public class Quarto {

    private int numero;
    private int camas;
    private int vagasGaragem;
    private double valorDiaria;

    private Cliente cliente; //Um quarto possue um cliente.

    public Quarto(int numero, int camas, int vagasGaragem) {
        this.numero = numero;
        this.camas = camas;
        this.vagasGaragem = vagasGaragem;
        this.valorDiaria = 100;
        this.cliente = null;
    }

    public Quarto() {

    }

    public boolean isOcupado() {
        return this.cliente != null;
    }

    public double calcPreco(int dias) {
        return dias * this.getValorDiaria();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
