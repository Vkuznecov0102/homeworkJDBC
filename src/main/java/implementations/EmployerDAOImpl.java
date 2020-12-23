package implementations;

import dao.EmployerDAO;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class EmployerDAOImpl implements EmployerDAO {

    public static final String PATH_TO_PROPERTIES ="C:/Users/Simho/Desktop/app.properties";

    @SneakyThrows
    @Override
    public int getAgeByUserName(String name) {

        File file = new File(PATH_TO_PROPERTIES);
        Properties props=new Properties();
        props.load(new FileInputStream(file));

        final String DB_URL = props.getProperty("url");
        final String DB_LOGIN = props.getProperty("login");
        final String DB_PASSWORD = props.getProperty("password");

                try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
                     Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select age from java_schema.employers where name='"+name+"'");
            resultSet.next();
            return resultSet.getInt("age");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }


}
