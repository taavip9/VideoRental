import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by taavpo on 17.04.2017.
 */
public class test {

    Movie uusfilm = new Movie(1, "Elu");
    Movie class2film = new Movie(2, "Film");
    Customer client = new Customer();
    MovieRental filmstore = new MovieRental();

    @Test
    public void NotEnoughPoints(){

        boolean error = false;


        try {
            filmstore.paywithbonus(client, "Elu", 1);
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }

    @Test
    public void WrongMovieTypeForBonusPoints(){
        boolean error = false;
        client.bonuspoints = 38;
        filmstore.MoviesLibrary.add(class2film);

        try {
            filmstore.paywithbonus(client, "Film", 1);
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }

    @Test
    public void AddMovieWithWrongType(){
        boolean error = false;

        try {
            filmstore.addnewmovie("I Robot", 4);
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }

    @Test
    public void ReturnMovieClientHasntRented(){
        boolean error = false;

        try {
            filmstore.returnmovie("Elu", 0, client);
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }

    @Test
    public void RemoveMovieNotInLibrary(){
        boolean error = false;

        try {
            filmstore.removemovie("Indiana Jones");
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }

    @Test
    public void ChangeMovieTypeToForbiddenNumber(){
        boolean error = false;

        try {
            filmstore.MoviesLibrary.add(uusfilm);
            filmstore.changemovietype("Elu", 4);
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }

    @Test
    public void RentOutMovieNotInLibrary(){
        boolean error = false;

        try {
            filmstore.rentoutMovie("Alien", 8, client);
        }catch (RuntimeException e){
            error = true;
            System.out.println("Error message: "+e.getMessage());
        }

        Assert.assertTrue(error);
    }
}
