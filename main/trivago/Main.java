package main.trivago;

import main.trivago.entities.Hotel;
import main.trivago.entities.Quarto;
import main.trivago.entities.QuartoSuite;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void setarQuartos(Hotel hotel) {
        hotel.iniciarQuartos(Hotel.MAX_TAM);
        hotel.inserirQuarto(new Quarto(0, 1, 0));
        hotel.inserirQuarto(new Quarto(1, 1, 0));
        hotel.inserirQuarto(new Quarto(2, 1, 0));
        hotel.inserirQuarto(new Quarto(3, 1, 0));
        hotel.inserirQuarto(new Quarto(4, 1, 0));
        hotel.inserirQuarto(new Quarto(5, 1, 0));
        hotel.inserirQuarto(new Quarto(6, 1, 0));
        hotel.inserirQuarto(new QuartoSuite(7, 2, 2, true, 1.5));
        hotel.inserirQuarto(new QuartoSuite(8, 2, 2, true, 1.5));
        hotel.inserirQuarto(new QuartoSuite(9, 2, 2, true, 1.5));
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        setarQuartos(hotel);
 
    }


}