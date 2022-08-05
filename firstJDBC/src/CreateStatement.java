import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CreateStatement {

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;

//        String query = "drop table test";


//        String query = "create table Country(" +
//                "code int not null primary key," +
//                "name varchar(20)," +
//                "continent varchar(20)," +
//                "surfaceArea double," +
//                "population int," +
//                "gnp int," +
//                "capital int," +
//                "cities varchar(250))";


//        String query = "create table City(" +
//                "id int not null primary key," +
//                "name varchar(20)," +
//                "population int," +
//                "countryCode int," +
//                "constraint fk_country foreign key(countryCode)" +
//                " references Country(code))";

        String query = "SELECT * FROM country";


        try{
            //get connection
            conn = JDBCUtil.getConnection();

            //create statement
            statement = conn.createStatement();

            //execute query
//             statement.executeUpdate(query);

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String string = resultSet.getString("code");
                System.out.println(string);
            }


            //close connection
            statement.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

