
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class TestApp {

    public static void main(String[] args) throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter number corresponding the Operation: ");
            System.out.println("1.Create");
            System.out.println("2.Delete");
            System.out.println("3.Display");
            System.out.println("4.Update");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> CreateOperation.createTable(scanner);
                case 2 -> DeleteOperation.deleteRow(scanner);
                case 3 -> ReadOperation.readTable();
                case 4 -> UpdateOperation.updateTable(scanner);
                case 5 -> {
                    System.out.println("Exiting the program");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Input Please try again");
            }
        }
    }
}
