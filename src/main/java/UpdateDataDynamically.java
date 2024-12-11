import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDataDynamically {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/credible";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully..."+connection);

            String updateQuery = "update studentInfo set name=?, address=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Student Name: ");
            String name = scanner.next();
            System.out.print("Enter Student Address: ");
            String address = scanner.next();

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setInt(3, id);
            int value = preparedStatement.executeUpdate();
            if(value == 1){
                System.out.println("Update Data Successfully.");
            }else{
                System.out.println("There Was A Problem.");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
