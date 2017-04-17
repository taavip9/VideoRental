import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taavi on 15.04.2017.
 */
public class Customer {

    List<Rental> rentedfilms = new ArrayList<>();
    int bonuspoints;

    //An empty constructor for the Customer class
    public Customer (){

    }

    //Method to check if a client has rented a movie

    public void ismovierented(Movie movie){
        for (int i = 0; i<rentedfilms.size(); i++){

            Movie compmovie = rentedfilms.get(i).getmovie();
            if(compmovie.getmname()==movie.getmname()){
                rentedfilms.remove(i);
                break;
            }else{
                throw new RuntimeException("The movie "+movie.getmname()+" has not been rented by this client.");
            }
        }
    }
}
