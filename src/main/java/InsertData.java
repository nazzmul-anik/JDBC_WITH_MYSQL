import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/credible";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully..."+connection);

            String insertQuery = "insert into studentInfo(name, address) values(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Tushi");
            preparedStatement.setString(2, "Polton");
            int value = preparedStatement.executeUpdate();
            if(value == 1){
                System.out.println("Save Data Successfully.");
            }else{
                System.out.println("There Was A Problem.");
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
