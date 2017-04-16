import java.util.*;

/**
 * Created by Taavi on 15.04.2017.
 */

public class MovieRental {

    List<Movie> MoviesLibrary = new ArrayList<Movie>();
    List<Movie> RentedMovies = new ArrayList<Movie>();

    public MovieRental(){

    }

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

    public void getlibmovies(){
        for(int i = 0; i<MoviesLibrary.size();i++){
            System.out.println(MoviesLibrary.get(i).getmname()+", "+
                    MoviesLibrary.get(i).getmtype());
        }
    }

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
    public void addnewmovie(String moviename, int category){
        MoviesLibrary.add(new Movie(category, moviename));
        System.out.println("Movie "+moviename+" added to the database.");
    }

    public void removemovie (String moviename){

        if (findmovievianame(MoviesLibrary, moviename)!=null){
            System.out.println("Movie "+moviename+" removed from library.");
            MoviesLibrary.remove(findmovievianame(MoviesLibrary, moviename));
        } else {
            throw new RuntimeException("Movie "+moviename+" is not in the database and therefore can't be" +
                    " removed. Please check movie name.");
        }
    }

    public Movie findmovievianame (List<Movie> listing, String moviename){
        for (Movie movie: listing){
            if (movie.getmname().equals(moviename)){
                return movie;
            }
        }
        return null;
    }


}
