package au.id.tmoschou.unleashed.game.server.service;

import au.id.tmoschou.unleashed.game.server.domain.Location;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Gao on 4/07/15.
 */
public class DatabaseService {
    private Connection connection;

    public DatabaseService(){
        getConnection();
    }

    public ArrayList<Location> getLocationByType (String objectType){

        ArrayList<Location> resultList = new ArrayList<>();

        String queryString = "SELECT * FROM location WHERE object_type = " + objectType;

        ResultSet resultSet;

        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);

            while (resultSet.next()){
                resultList.add(
                        new Location(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getDouble(3),
                                resultSet.getDouble(4),
                                resultSet.getDouble(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                resultSet.getInt(10),
                                resultSet.getInt(11),
                                resultSet.getInt(12),
                                resultSet.getInt(13)
                                ));

                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + "localhost" + ":3306/" + "unleashed";
            System.out.println(url);
            String username = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, username, password);


        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                connection.close();
                System.out.println("close ok");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
