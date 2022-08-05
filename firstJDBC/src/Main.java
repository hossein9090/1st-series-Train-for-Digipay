import java.util.*;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {


        //find the number of movie of each director

        Map<String, Long> moviesOfDirectors = Movie.getAllMovies().stream()
                .map(Movie::getAllDirectors)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Director::getName, Collectors.counting()));

        moviesOfDirectors.entrySet().forEach(System.out::println);


        //find the highest populated city of each country

        List<City> highPopulatedCitiesOfCountries = Country.findAllCountries()
                .stream()
                .map( country -> country.getCities().stream().max(Comparator.comparing(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        highPopulatedCitiesOfCountries.forEach(System.out::println);

    }
}

