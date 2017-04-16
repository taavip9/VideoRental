/**
 * Created by Taavi on 15.04.2017.
 */
public class Movie {

    int MovieClass;
    String MovieName;


    public Movie(int mclass, String mname){

        if (mclass == 1 || mclass ==2 || mclass==3){
            MovieClass = mclass;
            MovieName = mname;
        } else {
            throw new RuntimeException("Movies can be only three categories: 1 - New release, 2 - Regular film or " +
                    "3 - Old film. Please select one of those options. Your input for the movie "+mname+" was: "+mclass);
        }
    }

    public int getmtype() {
        return MovieClass ;
    }

    public String getmname(){
        return MovieName;
    }

    public int changeType (int typenew){
        MovieClass = typenew;

        return MovieClass;
    }

    public String changeName (String namenew){
        MovieName = namenew;

        return MovieName;
    }


}
