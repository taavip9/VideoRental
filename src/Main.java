/**
 * Created by Taavi on 15.04.2017.
 */
public class Main {

    public static void main(String[] args) {
        Movie uusfilm = new Movie(1, "Elu");
        Customer client = new Customer();
        MovieRental filmstore = new MovieRental();
        filmstore.addnewmovie("Cinderella", 1);
        filmstore.addnewmovie("Fast 8", 1);
        filmstore.addnewmovie("Dallas buyers club", 2);
        filmstore.getlibmovies();
        filmstore.listallfilms();
        filmstore.rentoutMovie("Fast 8", 3, client);
        filmstore.rentoutMovie("Dallas buyers club", 2, client);
        filmstore.customerTotal(client);
        client.bonuspoints = 25;
        filmstore.paywithbonus(client, "Cinderella", 1);
        //filmstore.paywithbonus(client, client.rentedfilms.get(0), 1);

    }
}
