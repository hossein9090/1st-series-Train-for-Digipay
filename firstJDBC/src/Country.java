import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Country {
    private int code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    private List<City> cities;

    {
        cities = new ArrayList<>();
    }

    public Country() {
    }

    public Country(Integer code, String name, String continent, int population,
                   double surfaceArea, double gnp, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.capital = capital;
        this.gnp = gnp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public List<City> getCities() {
        try (Connection conn = JDBCUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cities where countryCode=?");
            ps.setInt(1,this.code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.cities.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3)
                        , rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getAllCities(){
        try (Connection conn = JDBCUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from cities");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.cities.add(new City(rs.getInt(1), rs.getString(2), rs.getInt(3)
                        , rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.cities;
    }

    public static List<Country> findAllCountries(){
        List<Country> countries=new ArrayList<>();
        try (Connection con = JDBCUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from country");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                public Country(Integer code, String name, String continent, int population,
//                double surfaceArea, double gnp, int capital) {
//                    this.code = code;
//                    this.name = name;
//                    this.continent = continent;
//                    this.surfaceArea = surfaceArea;
//                    this.population = population;
//                    this.capital = capital;
//                    this.gnp = gnp;
//                }
                Country country = new Country(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getInt(7));
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;

    }

    @Override
    public String toString() {
        return "Country [ name=" + name + ", population=" + population + "]";
    }

}
