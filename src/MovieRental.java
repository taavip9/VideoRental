import java.util.*;

/**
 * Created by Taavi on 15.04.2017.
 */

public class MovieRental {

    List<Movie> MoviesLibrary = new ArrayList<Movie>();
    List<Movie> RentedMovies = new ArrayList<Movie>();

    public MovieRental(){

    }

    //Method to change the type of the movie. Type 1 - New release, 2 - Regular rental, 3 - Old movie

    public void changemovietype(String moviename, int newtype){
        Movie result = findmovievianame(MoviesLibrary, moviename);
        MoviesLibrary.get(MoviesLibrary.indexOf(result)).changeType(newtype);
    }

    //Method to change a movie's name, in case it was inserted incorrectly etc

    public void changemoviename (String moviename, String newname){
        Movie result = findmovievianame(MoviesLibrary, moviename);
        MoviesLibrary.get(MoviesLibrary.indexOf(result)).changeName(newname);
    }

    //Method to calculate the total fare for a rental

    public int customerTotal(Customer client){
        int totalprice=0;
        for(int  i=0; i<client.rentedfilms.size();i++){
            Rental rental = client.rentedfilms.get(i);
            System.out.println("Movie "+rental.getmovie().getmname()+", price: "+rental.cost+"EUR");
            totalprice = totalprice + rental.cost;
        }
        System.out.println("Total price: "+totalprice+"EUR");
        return totalprice;
    }

    //List movies that are not rented out

    public void getlibmovies(){
        for(int i = 0; i<MoviesLibrary.size();i++){
            System.out.println(MoviesLibrary.get(i).getmname()+", "+
                    MoviesLibrary.get(i).getmtype());
        }
    }

    //List all movies in library

    public void listallfilms (){
        for(int i = 0; i<MoviesLibrary.size();i++){
            System.out.println(MoviesLibrary.get(i).getmname()+", "+
                    MoviesLibrary.get(i).getmtype());
        }
        for(int i = 0; i<RentedMovies.size();i++){
            System.out.println(RentedMovies.get(i).getmname()+", "+
                    RentedMovies.get(i).getmtype());
        }
    }

    //Method to add a new movie to the library

    public void addnewmovie(String moviename, int category){
        MoviesLibrary.add(new Movie(category, moviename));
        System.out.println("Movie "+moviename+" added to the database.");
    }

    //Method to remove a movie from the library

    public void removemovie (String moviename){

        if (findmovievianame(MoviesLibrary, moviename)!=null){
            System.out.println("Movie "+moviename+" removed from library.");
            MoviesLibrary.remove(findmovievianame(MoviesLibrary, moviename));
        } else {
            throw new RuntimeException("Movie "+moviename+" is not in the database and therefore can't be" +
                    " removed. Please check movie name.");
        }
    }

    //Method to find a movie from a list by inserting a String value in the method

    public Movie findmovievianame (List<Movie> listing, String moviename){
        for (Movie movie: listing){
            if (movie.getmname().equals(moviename)){
                return movie;
            }
        }
        return null;
    }

    //Method that checks if a movie is rented out and returns it. Late fees will also be calculated using this method

    public void returnmovie(String moviename, int latedays, Customer client){

        Movie result = findmovievianame(RentedMovies, moviename);
        if (result != null){
            client.ismovierented(result);

            int price;
            Movie retfilm = RentedMovies.get(RentedMovies.indexOf(result));
            MoviesLibrary.add(retfilm);
            RentedMovies.remove(retfilm);

            if (latedays == 0){
                price = 0;
                System.out.println("Movie "+moviename+" returned with no late fees.");

            }else{
                if(retfilm.getmtype() == 1){
                    price = 4*latedays;
                } else{
                    price = 3*latedays;
                }

                System.out.println("Extra fee for "+latedays+" late day(s) on movie "+retfilm.getmname()+": "
                        +price+"EUR");
            }
        }else{
            throw new RuntimeException("Movie "+moviename+" is not rented out.");
        }

    }

    //Method that checks if a client has enough bonus points. If so, it can be used to pay for new rentals

    public void paywithbonus(Customer client, String moviename, int days){

        Movie movierent = findmovievianame(MoviesLibrary, moviename);

        if (client.bonuspoints<25*days) {
            throw new RuntimeException("Not enough bonus points to pay for rental. Required bonus points: "
                    +25*days+", currently have: "+client.bonuspoints+" points.");
        } else {

            if (movierent.getmtype() == 1) {
                rentoutMovie(movierent.getmname(), days, client);
                client.bonuspoints = client.bonuspoints - (25 * days);
                System.out.println("Movie rental for movie "+movierent.getmname()+" paid with" +
                        " bonus points for "+days+" day(s). "+client.bonuspoints+" bonus points remain");
            } else if (movierent.getmtype() == 2){
                throw new RuntimeException("Bonus points can only be used to rent new releases. Current movie is" +
                        " a regular rental");
            } else {
                throw new RuntimeException("Bonus points can only be used to rent new releases. Current movie is" +
                        " an old film");
            }
        }
    }

    //Method to rent out a movie

    public void rentoutMovie(String moviename, int days, Customer client){

        Movie result = findmovievianame(MoviesLibrary, moviename);
        if (result != null){
            Rental new_rental = new Rental(days, result);
            client.rentedfilms.add(new_rental);

            if(result.getmtype()!=1){
                client.bonuspoints = client.bonuspoints+2;
            } else {
                client.bonuspoints ++;
            }

            RentedMovies.add(result);
            MoviesLibrary.remove(result);
        }else{
            throw new RuntimeException("Movie "+moviename+" is not in the database and therefore can't be" +
                    " rented. Please check movie name.");
        }
    }


}
