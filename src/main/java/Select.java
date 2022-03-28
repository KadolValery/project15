import java.math.BigDecimal;
import java.sql.*;

public class Select {
    public static void main(String[] args) {
        String sql= "SELECT * FROM EMPLOYEE";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root","11111111");
            Statement statement=conn.createStatement()) {

            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                Timestamp createdDate = resultSet.getTimestamp("createdate");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                obj.setCreatedDate(createdDate);

                System.out.println(obj);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
