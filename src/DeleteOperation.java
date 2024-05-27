import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class DeleteOperation {
    public static void deleteRow(Scanner scanner) throws ParseException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        System.out.println("Enter the student id: ");
        int studentId = scanner.nextInt();

        String url = "jdbc:mysql://localhost:3306/ineuron";
        String user = "root";
        String password = "root";

        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            if(connection != null){

                String sqlDeleteQuery = "delete from assignment where student_id = ?";
                preparedStatement = connection.prepareStatement(sqlDeleteQuery);

                if (preparedStatement != null) {
                    preparedStatement.setInt(1, studentId);


                    int numberOfRowsUpdated = preparedStatement.executeUpdate();
                    System.out.println("The number of rows deleted: " + numberOfRowsUpdated);

                }

            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
