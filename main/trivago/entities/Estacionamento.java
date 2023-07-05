package main.trivago.entities;

public class Estacionamento {
	private final int vagasTotais;
	private int vagasOcupadas;

	 //costrutor padrao 
    public Estacionamento(int vagas){ 
        this.vagasTotais = vagas;
        vagasOcupadas = 0;
    }
    
    public void ocuparVaga() {
    	this.setVagasOcupadas(this.getVagasOcupadas() + 1);
    }
    public void liberarVaga() {
    	this.setVagasOcupadas(this.getVagasOcupadas() - 1);
    }

	public int getVagasOcupadas() {
		return vagasOcupadas;
	}

	public void setVagasOcupadas(int vagasOcupadas) {
		this.vagasOcupadas = vagasOcupadas;
	}

	public int getVagasLivres() {
		return this.vagasTotais- this.vagasOcupadas;
	}

   }


