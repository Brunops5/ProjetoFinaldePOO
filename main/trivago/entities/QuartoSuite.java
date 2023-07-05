package main.trivago.entities;

public class QuartoSuite extends Quarto {

    private final boolean hidromassagem;
    private final double acrescimo;

    public QuartoSuite(int numero, int camas, int vagasGaragem, boolean hidromassagem, double acrescimo) {
        super(numero, camas, vagasGaragem);
        this.hidromassagem = hidromassagem;
        this.acrescimo = acrescimo;
        this.setValorDiaria(this.getValorDiaria() * this.getAcrescimo());
    }

    public boolean isHidromassagem() {
        return hidromassagem;
    }


    public double getAcrescimo() {
        return acrescimo;
    }


}
