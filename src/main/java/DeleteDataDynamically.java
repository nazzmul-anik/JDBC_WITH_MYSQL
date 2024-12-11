import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDataDynamically {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/credible";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully..."+connection);

            String deleteQuery = "delete from studentInfo where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

            Scanner scanner = new Scanner(System.in);
            System.out.print("For Delete, Enter Student ID: ");
            int id = scanner.nextInt();

            preparedStatement.setInt(1, id);
            int value = preparedStatement.executeUpdate();
            if(value == 1){
                System.out.println("Delete Data Successfully.");
            }else{
                System.out.println("There Was A Problem.");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
