package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
	// write your code here
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\sql.properties"));
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");

//        Class.forName(driver);
        String sql = "select * from city where CountryCode = ?";

        Connection connection = DriverManager.getConnection(url, user, pwd);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"ABW");
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){

            System.out.println("查询成功！");
        }
        preparedStatement.close();
        connection.close();
    }
}
