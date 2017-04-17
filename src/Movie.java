/**
 * Created by Taavi on 15.04.2017.
 */
public class Movie {

    int MovieClass;
    String MovieName;


    //Constructor for the Movie class. Movies can only be created with mclass ranging from 1-3.
    public Movie(int mclass, String mname){

        if (mclass == 1 || mclass ==2 || mclass==3){
            MovieClass = mclass;
            MovieName = mname;
        } else {
            throw new RuntimeException("Movies can be only three categories: 1 - New release, 2 - Regular film or " +
                    "3 - Old film. Please select one of those options. Your input for the movie "+mname+" was: "+mclass);
        }
    }

    //Method to get a movie's type - 1 - New release, 2 - Regular rental or 3 - an Old movie
    public int getmtype() {
        return MovieClass ;
    }

    //Method to get a movie's name
    public String getmname(){
        return MovieName;
    }

    //Method to change a movie's type
    public int changeType (int typenew){

        if (typenew<1 || typenew>3){
            throw new RuntimeException("Movies can be only three categories: 1 - New release, 2 - Regular film or " +
                    "3 - Old film. Please select one of those options. Your input for the movie "+MovieName+" was: "+typenew);
        }else{
        MovieClass = typenew;
        }

        return MovieClass;
    }

    //Method to change a movie's name
    public String changeName (String namenew){
        MovieName = namenew;

        return MovieName;
    }


}
