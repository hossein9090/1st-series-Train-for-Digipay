import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private Integer id;
    private String name;
    private Double imdb;
    private List<Movie> movies = new ArrayList<>();

    public Director() {
    }

    public Director(Integer id, String name, Double imdb) {
        this.id = id;
        this.name = name;
        this.imdb = imdb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }



    @Override
    public String toString() {
        return "Director [id=" + id + ", name=" + name + ", imdb=" + imdb + "]";
    }
}


