import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchAllData {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/credible";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully..."+connection);

            String fetchQuery = "select *from studentInfo";
            PreparedStatement preparedStatement = connection.prepareStatement(fetchQuery);


            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Id\tName\tAddress");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                System.out.println(id+"\t"+name+"\t"+address);
            }

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
