package com.maharjan.amit.services;

import com.maharjan.amit.dao.HotelDao;

import java.sql.SQLException;
import java.util.List;

public class BookingService {
    private HotelDao hotelDao;

    public BookingService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    public boolean checkRoomAvailability(String roomName) throws SQLException {
        List<String> availableRooms = hotelDao.fetchAvailableRooms();
        return availableRooms.contains(roomName);
    }
}
