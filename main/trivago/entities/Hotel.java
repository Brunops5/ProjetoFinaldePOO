package main.trivago.entities;

public class Hotel {
    public final static int MAX_TAM = 10;
    Quarto[] quartos;
     final Estacionamento estacionamento = new Estacionamento(MAX_TAM);
    public int quartosTotais, quartosOcupados, quartosLivres, quartosSuit;

    public Hotel() {
        quartosTotais = 100;
        quartosOcupados = 0;
        quartosLivres = 100;
        quartosSuit = 10;
    }

    // Getters e Setters

    public Quarto[] getQuartos() {
        return quartos;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    //
    //
    //
    public void inserirQuarto(Quarto quarto) {
        for (int i = 0; i < this.quartos.length; i++) {
            if (this.quartos[i] == null) {
                this.quartos[i] = quarto;
                break;
            }
        }
    }

    public void iniciarQuartos(int numeroQuartos) {
        this.quartos = new Quarto[numeroQuartos];
    }

    public boolean temVagas() {
        return this.quartosLivres != 0;
    }

    public boolean isQuartoLivre(int numeroQuarto) {
        Quarto quarto = this.getQuartoPorNumero(numeroQuarto);
        if (quarto != null)
            return !quarto.isOcupado();
        return false;
    }

    public void checkinCliente(Cliente cliente, int numeroQuarto) {
        this.getQuartoPorNumero(numeroQuarto).setCliente(cliente);
        if (cliente.hasCarro()) {
            this.estacionamento.ocuparVaga();
        }
        this.quartosLivres--;
        this.quartosOcupados++;
    }

    Quarto getQuartoPorNumero(int numeroQuarto) {
        for (Quarto quarto : this.quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                return quarto;
            }
        }
        return null;
    }

    public double checkoutCliente(int numeroQuarto, int duracao) {
        if (this.getQuartoPorNumero(numeroQuarto).getCliente().hasCarro()) {
            this.estacionamento.liberarVaga();
        }
        this.quartosLivres++;
        this.quartosOcupados--;
        this.getQuartoPorNumero(numeroQuarto).setCliente(null);
        return this.getQuartoPorNumero(numeroQuarto).calcPreco(duracao);
    }
}
