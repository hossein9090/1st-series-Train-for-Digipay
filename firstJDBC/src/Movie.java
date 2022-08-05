import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private int year;
    private Double imdb;
    private List<Genre> genres;
    private List<Director> directors;

    {
        genres = new ArrayList<>();
        directors = new ArrayList<>();
    }

    public Movie() {
    }

    public Movie(int id, String title, int year, Double imdb) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imdb = imdb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public static List<Movie> getAllMovies(){
        List<Movie> movies=new ArrayList<>();

        try (Connection conn=JDBCUtil.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * from movies");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Movie movie=new Movie();

                movie.setId(rs.getInt(1));
                movie.setTitle(rs.getString(2));
                movie.setYear(rs.getInt(3));
                movie.setImdb(rs.getDouble(4));
                movies.add(movie);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return movies;
    }

    public List<Director> getAllDirectors(){
        List<Director> directors=new ArrayList<>();
        try (Connection conn=JDBCUtil.getConnection()){
            PreparedStatement ps=conn.prepareStatement("select Directors.id, Directors.director_name,directors.IMDB, Movies.movie_name\n" +
                    "from Directors\n" +
                    "join Director_Movie ON Directors.id = Director_Movie.Director_id\n" +
                    "join Movies On Movies.id = Director_Movie.Movie_id\n" +
                    "where movies.id=?");

            ps.setInt(1,this.id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Director director=new Director(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getDouble(3));
                directors.add(director);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return directors;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", year=" + year + "]";
    }
}

