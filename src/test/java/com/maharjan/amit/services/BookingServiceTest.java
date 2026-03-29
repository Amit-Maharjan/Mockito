package com.maharjan.amit.services;

import com.maharjan.amit.dao.HotelDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingServiceTest {
    private BookingService bookingService;
    private HotelDao hotelDaoMock;

    @Before
    public void setUp() {
        hotelDaoMock = mock(HotelDao.class);
        bookingService = new BookingService(hotelDaoMock);
    }

    @Test
    public void checkRoomAvailabilityReturnsTrue() throws SQLException {
        List<String> availableRooms = Arrays.asList("1", "2", "3");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        boolean result = bookingService.checkRoomAvailability("1");

        Assert.assertTrue(result);
    }

    @Test
    public void checkRoomAvailabilityReturnsFalse() throws SQLException {
        List<String> availableRooms = Arrays.asList("1", "2", "3");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

        boolean result = bookingService.checkRoomAvailability("4");

        Assert.assertFalse(result);
    }
}
