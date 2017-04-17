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

        //Changing a movie's name and type
        filmstore.changemoviename("Dallas buyers club", "Texas buyers club");
        filmstore.changemovietype("Texas buyers club", 3);
        filmstore.getlibmovies();

        //Renting out movies and calculating a rental's total
        filmstore.rentoutMovie("Fast 8", 3, client);
        filmstore.rentoutMovie("Cinderella", 2, client);
        filmstore.customerTotal(client);

        //Returning movies, one with no late days and one movie with 1 late day
        filmstore.returnmovie("Fast 8", 0, client);
        filmstore.returnmovie("Cinderella", 1, client);

        //Successful bonus points transaction
        client.bonuspoints = 32;
        filmstore.paywithbonus(client, "Fast 8", 1);

        //List movies currently for rent and all movies
        System.out.println("Library films:");
        filmstore.getlibmovies();
        filmstore.rentoutMovie("Animal house", 3, client);
        filmstore.rentoutMovie("Cinderella", 2, client);
        System.out.println("Library films:");
        filmstore.getlibmovies();
        System.out.println("All films:");
        filmstore.listallfilms();


    }
}
