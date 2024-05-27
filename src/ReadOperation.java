import java.sql.*;
import java.text.SimpleDateFormat;

public class ReadOperation {
    public static void readTable() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/ineuron";
        String user = "root";
        String password = "root";

        try{
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url, user, password);

            if(connection != null){
                System.out.println("Successfully connected to database!");
                String sqlReadQuery = "select * from assignment";
                preparedStatement = connection.prepareStatement(sqlReadQuery);

                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String gender = resultSet.getString(3);
                    Date dateOfBirth = resultSet.getDate(4);
                    Date dateOfJoining = resultSet.getDate(5);
                    Date dateOfMoving = resultSet.getDate(6);

                    //Formatting for the End User:
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat formatter2 = new SimpleDateFormat("MM-dd-yyyy");
                    SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");

                    String doB = formatter.format(dateOfBirth);
                    String doJ = formatter2.format(dateOfJoining);
                    String doM = formatter3.format(dateOfMoving);

                    System.out.printf("Student-ID: %d  Student-Name: %s Student-Gender: %s Student-DoB:%s (dd-MM-yyy) Student-DoJ:%s (MM-dd-yyyy) Student-DOM: %s (yyyy-MM-dd)\n",id,name,gender,doB,doJ,doM);
                    System.out.println("");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
