import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UpdateOperation {
    public static void updateTable(Scanner scanner) throws ParseException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println("Enter the student id: ");
        int studentId = scanner.nextInt();
        System.out.println("Enter the DoM: dd-MM-YYYY");
        String dom = scanner.next();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date udoM = sdf.parse(dom);

        long time = udoM.getTime();

        java.sql.Date sqldate = new java.sql.Date(time);




        String url = "jdbc:mysql://localhost:3306/ineuron";
        String user = "root";
        String password = "root";

        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            if(connection != null){

                String sqlUpdateQuery = "update assignment set student_dom=? where student_id=?";
                preparedStatement = connection.prepareStatement(sqlUpdateQuery);

                if (preparedStatement != null) {
                    preparedStatement.setDate(1, sqldate);
                    preparedStatement.setInt(2, studentId);


                    int numberOfRowsUpdated = preparedStatement.executeUpdate();
                    System.out.println("The number of rows updated: " + numberOfRowsUpdated);

                }

            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }

        }
    }
}
