import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taavi on 15.04.2017.
 */

//A Class that is created when a customer rents a movie
public class Rental {

    Movie RentedMovie;
    int RentedDays;
    int cost;

    //Constructor that calculates the cost of the rental, so that the cost is calculated at object declaration.
    public Rental (int rentaldays, Movie moviename){
        RentedDays = rentaldays;
        RentedMovie = moviename;
        if (moviename.getmtype() == 1){
            cost = 4*rentaldays;
        } else if (moviename.getmtype() == 2){
            if (rentaldays>3){
                cost = 3+((rentaldays-3)*3);
            } else{
                cost = 3;
            }
        } else {
            if (rentaldays>5){
                cost = 3+((rentaldays-5)*3);
            } else{
                cost = 3;
            }
        }

    }

    //Method that returns the name of the rented movie
    public Movie getmovie(){
        return RentedMovie;
    }


}
