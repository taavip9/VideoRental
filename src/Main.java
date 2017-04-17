/**
 * Created by Taavi on 15.04.2017.
 */
public class Main {

    public static void main(String[] args) {
        Movie uusfilm = new Movie(1, "Elu");
        Customer client = new Customer();
        MovieRental filmstore = new MovieRental();

        //Adding new movies
        filmstore.addnewmovie("Cinderella", 3);
        filmstore.addnewmovie("Fast 8", 1);
        filmstore.addnewmovie("Dallas buyers club", 2);
        filmstore.addnewmovie("Animal house", 3);
        filmstore.getlibmovies();
        //Adding new movies

        //Changing a movie's name and type
        filmstore.changemoviename("Dallas buyers club", "Texas buyers club");
        filmstore.changemovietype("Texas buyers club", 3);
        filmstore.getlibmovies();
        //Changing a movie's name and type

        //Renting out movies and calculating a rental's total
        filmstore.rentoutMovie("Fast 8", 3, client);
        filmstore.rentoutMovie("Cinderella", 2, client);
        filmstore.customerTotal(client);
        //Renting out movies and calculating a rental's total

        //Returning movies, one with no late days and one movie with 1 late day
        filmstore.returnmovie("Fast 8", 0, client);
        filmstore.returnmovie("Cinderella", 1, client);
        //Returning movies, one with no late days and one movie with 1 late day


        //Test to pay with bonus points,  when there isn't enough bonus points
        client.bonuspoints = 33;
        filmstore.paywithbonus(client, "Fast 8", 2);

        //Successful bonus points transaction
        filmstore.paywithbonus(client, "Fast 8", 1);


        /*client.bonuspoints = 25;
        filmstore.paywithbonus(client, "Cinderella", 1);
        //filmstore.paywithbonus(client, client.rentedfilms.get(0), 1);
        filmstore.returnmovie("Fast 8", 0, client);*/

    }
}
