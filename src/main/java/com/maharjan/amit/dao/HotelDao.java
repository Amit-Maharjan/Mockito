package com.maharjan.amit.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
    public List<String> fetchAvailableRooms() throws SQLException {
        List<String> availableRooms = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from rooms");
        while (resultSet.next()) {
            availableRooms.add(resultSet.getString("Room Name"));
        }
        return availableRooms;
    }
}
