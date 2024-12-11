import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {
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

            preparedStatement.setString(1, "Jhaka Naka");
            preparedStatement.setString(2, "Goran");
            preparedStatement.setInt(3, 2);
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
