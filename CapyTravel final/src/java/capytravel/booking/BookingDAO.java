/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.booking;

import capytravel.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class BookingDAO {

    private List<BookingDTO> list;

    public List<BookingDTO> list(String keyword) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BookingDTO booking = null;
        list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();

            String sql = " select b.bookingID,"
                    + "    CONCAT(u.firstName, ' ', u.lastName) AS fullName,"
                    + "    f1.flightCode AS departureFlightCode,"
                    + "    f2.flightCode AS returnFlightCode "
                    + "FROM "
                    + "    Booking b "
                    + "JOIN "
                    + "Users u ON b.userID = u.userID "
                    + "LEFT JOIN "
                    + "    Flights f1 ON b.departureFlight = f1.flightID "
                    + "LEFT JOIN "
                    + "    Flights f2 ON b.returnFlight = f2.flightID ";

            if (keyword != null && !keyword.isEmpty()) {
                sql += " where CONCAT(u.firstName, ' ', u.lastName) LIKE ? "
                        + "or f1.flightCode like ? or f2.flightCode like ?";
            }
            ps = con.prepareStatement(sql);
            if (keyword != null && !keyword.isEmpty()) {
                ps.setString(1, "%" + keyword.trim() + "%");
                ps.setString(2, "%" + keyword.trim() + "%");
                ps.setString(3, "%" + keyword.trim() + "%");
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookingID = rs.getInt("bookingID");
                String fullName = rs.getString("fullName");
                String departureFlightCode = rs.getString("departureFlightCode");
                String returnFlightCode = rs.getString("returnFlightCode");

                booking = new BookingDTO();
                booking.setBookingID(bookingID);
                booking.setFullName(fullName);
                booking.setDepartureFlight(departureFlightCode);
                booking.setReturnFlight(returnFlightCode);

                list.add(booking);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Flights List is error!! " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

    public BookingDTO load(Integer id) {

        String sql = " select b.bookingID,"
                + "    u.userID,"
                + "    CONCAT(u.firstName, ' ', u.lastName) AS fullName,"
                + "    f1.flightCode AS departureFlightCode,"
                + "    f2.flightCode AS returnFlightCode, "
                + "    b.bookingDate,"
                + "    b.totalAmount,"
                + "    pm.methodName AS paymentMethod "
                + "FROM "
                + "    Booking b "
                + "JOIN "
                + "Users u ON b.userID = u.userID "
                + "LEFT JOIN "
                + "    Flights f1 ON b.departureFlight = f1.flightID "
                + "LEFT JOIN "
                + "    Flights f2 ON b.returnFlight = f2.flightID "
                + "LEFT JOIN "
                + "    PaymentMethod pm ON b.paymentMethod = pm.methodID "
                + "where bookingID = ? ";
        BookingDTO booking = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int bookingID = rs.getInt("bookingID");
                int userID = rs.getInt("userID");
                String fullName = rs.getString("fullName");
                String departureFlight = rs.getString("departureFlightCode");
                String returnFlight = rs.getString("returnFlightCode");
                Date bookingDate = rs.getDate("bookingDate");
                int totalAmount = rs.getInt("totalAmount");
                String paymentMethod = rs.getString("paymentMethod");

                booking = new BookingDTO();
                booking.setBookingID(bookingID);
                booking.setUserID(userID);
                booking.setFullName(fullName);
                booking.setDepartureFlight(departureFlight);
                booking.setReturnFlight(returnFlight);
                booking.setBookingDate(bookingDate);
                booking.setTotalAmount(totalAmount);
                booking.setPaymentMethod(paymentMethod);

            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Flights Load is error!! " + ex.getMessage());
            ex.printStackTrace();
        }
        return booking;
    }

    public boolean update(BookingDTO booking) {

        String sql = "UPDATE Booking "
                + "SET "
                + "    userID = ?, "
                + "    departureFlight = (SELECT flightID FROM Flights WHERE flightCode = ?), "
                + "    returnFlight = (SELECT flightID FROM Flights WHERE flightCode = ?), "
                + "    bookingDate = ?, "
                + "    totalAmount = ?, "
                + "    paymentMethod = (SELECT methodID FROM PaymentMethod WHERE methodName = ?) "
                + "WHERE "
                + "    bookingID = ?;";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, booking.getUserID());
            ps.setString(2, booking.getDepartureFlight());
            ps.setString(3, booking.getReturnFlight());
            ps.setDate(4, booking.getBookingDate());
            ps.setInt(5, booking.getTotalAmount());
            ps.setString(6, booking.getPaymentMethod());
            ps.setInt(7, booking.getBookingID());

            ps.executeUpdate();

            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Update Booking is error!! " + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public Integer insert(BookingDTO booking) {

        String sql = "INSERT INTO Booking (userID, departureFlight, returnFlight, bookingDate, totalAmount, paymentMethod) "
                + "VALUES (?, "
                + "  (SELECT flightID FROM Flights WHERE flightCode = ?), "
                + "  (SELECT flightID FROM Flights WHERE flightCode = ?), "
                + "  ?, ?, "
                + "  (SELECT methodID FROM PaymentMethod WHERE methodName = ?))";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, booking.getUserID());
            ps.setString(2, booking.getDepartureFlight());
            ps.setString(3, booking.getReturnFlight());
            ps.setDate(4, booking.getBookingDate());
            ps.setInt(5, booking.getTotalAmount());
            ps.setString(6, booking.getPaymentMethod());

            ps.executeUpdate();

            con.close();
            return booking.getBookingID();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //ham nay dung de generate new booking khi user giao dich
    public boolean createNewBooking(BookingDTO booking) {

        String sql = "INSERT INTO Booking (userID, departureFlight, bookingDate, totalAmount, paymentMethod, returnFlight) "
                + "VALUES(?,?,?,?,?,?)";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, booking.getUserID());
            ps.setString(2, booking.getDepartureFlight());
            ps.setDate(3, booking.getBookingDate());
            ps.setInt(4, booking.getTotalAmount());
            ps.setString(5, booking.getPaymentMethod());
            ps.setString(6, booking.getReturnFlight());
            int rs = ps.executeUpdate();

            if (rs > 0) {
                return true;
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public int getMaxBookingID() {
        String sql = "SELECT MAX(bookingID) AS maxBookingID "
                + "FROM Booking";
        int maxBookingID = 0;

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {

                maxBookingID = rs.getObject("maxBookingID") != null ? rs.getInt("maxBookingID") : 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxBookingID;
    }


    
    
    //ham nay de load lai booking tu user
    public List<BookingDTO> showBook(int id) {
        List<BookingDTO> list = new ArrayList<>();
        System.out.println("id: " + id);

        String sql = " SELECT \n"
                + "    b.departureFlight,\n"
                + "    b.returnFlight,\n"
                + "    b.bookingDate,\n"
                + "    CASE \n"
                + "        WHEN b.departureFlight = f.flightID THEN f.flightTime \n"
                + "        ELSE NULL \n"
                + "    END AS departureFlightTime,\n"
                + "    CASE \n"
                + "        WHEN b.returnFlight = f2.flightID THEN f2.flightTime \n"
                + "        ELSE NULL \n"
                + "    END AS returnFlightTime,\n"
                + "    b.totalAmount,\n"
                + "    b.paymentMethod,\n"
                + "    a1.airportName AS departureAirport,\n"
                + "    a2.airportName AS arrivalAirport,\n"
                + "    a3.airportName AS returnDepartureAirport,\n"
                + "    a4.airportName AS returnArrivalAirport\n"
                + "FROM \n"
                + "    Booking b\n"
                + "LEFT JOIN \n"
                + "    Flights f ON b.departureFlight = f.flightID\n"
                + "LEFT JOIN \n"
                + "    Flights f2 ON b.returnFlight = f2.flightID\n"
                + "LEFT JOIN \n"
                + "    Airport a1 ON f.departureAirport = a1.airportID  -- Sân bay khởi hành cho chuyến bay đi\n"
                + "LEFT JOIN \n"
                + "    Airport a2 ON f.ArrivalAirport = a2.airportID      -- Sân bay đến cho chuyến bay đi\n"
                + "LEFT JOIN \n"
                + "    Airport a3 ON f2.departureAirport = a3.airportID  -- Sân bay khởi hành cho chuyến bay về\n"
                + "LEFT JOIN \n"
                + "    Airport a4 ON f2.ArrivalAirport = a4.airportID    -- Sân bay đến cho chuyến bay về\n"
                + "\n"
                + "	WHERE userID = ? ";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BookingDTO booklist = new BookingDTO();

                    String departureAirport = rs.getString("departureAirport");
                    String arrivalAirport = rs.getString("arrivalAirport");

                    String returnDepartureAirport = rs.getString("returnDepartureAirport");
                    String returnArrivalAirport = rs.getString("returnArrivalAirport");

                    String departureFlight = null;
                    String returnFlight = null;

                    if (departureAirport != null && arrivalAirport != null) {
                        departureFlight = departureAirport + "-" + arrivalAirport;
                    }
if (returnDepartureAirport != null && returnArrivalAirport != null) {
                        returnFlight = returnDepartureAirport + "-" + returnArrivalAirport;
                    }

                    Date bookingDate = rs.getDate("bookingDate");
                    int totalAmount = rs.getInt("totalAmount");
                    String paymentMethod = rs.getString("paymentMethod");

                    booklist = new BookingDTO();
                    booklist.setDepartureFlight(departureFlight);
                    booklist.setReturnFlight(returnFlight);
                    booklist.setBookingDate(bookingDate);
                    booklist.setTotalAmount(totalAmount);
                    booklist.setPaymentMethod(paymentMethod);

                    list.add(booklist);
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("BookShow Load is error!! " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }
    
    


    
}
