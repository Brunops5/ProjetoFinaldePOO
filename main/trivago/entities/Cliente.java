package main.trivago.entities;

public class Cliente {
    private String nome;
    private int idade;
    private String cpf;
    private boolean carro;
    private boolean familia;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean hasCarro() {
        return carro;
    }

    public void setCarro(boolean carro) {
        this.carro = carro;
    }

    public boolean hasFamilia() {
        return familia;
    }

    public void setFamilia(boolean familia) {
        this.familia = familia;
    }


}
