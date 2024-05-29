import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CreateOperation {
    public static void createTable(Scanner scanner) throws SQLException, ParseException {
        System.out.println("Enter the student name: ");
        String studentName = scanner.next();
        System.out.println("Enter the student Gender: ");
        String studentGender = scanner.next();
        System.out.println("Enter the student DOB: dd-mm-YYYY ");
        String studentDOB = scanner.next();
        System.out.println("Enter the student DOJ: dd-mm-YYYY ");
        String studentDOJ = scanner.next();
        System.out.println("Enter the student DOM: dd-mm-YYYY : ");
        String studentDOM = scanner.next();

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");

        java.util.Date uDateofBirth =simpleDateFormat.parse(studentDOB);
        java.util.Date uDateofJoining =simpleDateFormat.parse(studentDOJ);
        java.util.Date uDateofMoving =simpleDateFormat.parse(studentDOM);

        long timeDateofBirth = uDateofBirth.getTime();
        long timeDateofJoining = uDateofJoining.getTime();
        long timeDateofMoving = uDateofMoving.getTime();

        java.sql.Date sqlDateOfBirth = new java.sql.Date(timeDateofBirth);
        java.sql.Date sqlDateOfJoining = new java.sql.Date(timeDateofJoining);
        java.sql.Date sqlDateOfMoving = new java.sql.Date(timeDateofMoving);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = JdbcConnection.getJdbcConnection();
            if (connection != null) {
                System.out.println("Connected to database");

                String sqlQueryCreate = "insert into assignment(student_name,student_gender,student_dob,student_doj,student_dom) values(?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sqlQueryCreate);

                if (preparedStatement != null) {
                    preparedStatement.setString(1, studentName);
                    preparedStatement.setString(2, studentGender);
                    preparedStatement.setDate(3, sqlDateOfBirth);
                    preparedStatement.setDate(4, sqlDateOfJoining);
                    preparedStatement.setDate(5, sqlDateOfMoving);

                    int numberOfRowsAffected = preparedStatement.executeUpdate();
                    System.out.printf("Number of Rows Affected is %d",numberOfRowsAffected);
                    System.out.println();
                }


            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }


    }
}
