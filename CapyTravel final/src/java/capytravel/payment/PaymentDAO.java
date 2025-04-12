package capytravel.payment;

import capytravel.booking.BookingDTO;
import capytravel.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements Serializable {

    public List<PaymentDTO> list() {
        List<PaymentDTO> list = new ArrayList<>();
        String sql = " SELECT paymentID, bookingID, paymentDate, amount, paymentMethod FROM Payment ";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int paymentID = rs.getInt("paymentID");
                int bookingID = rs.getInt("bookingID");
                Date paymentDate = rs.getDate("paymentDate");
                double amount = rs.getInt("amount");
                String paymentMethod = rs.getString("paymentMethod");

                PaymentDTO payment = new PaymentDTO();
                payment.setPaymentID(paymentID);
                payment.setBookingID(bookingID);
                payment.setPaymentDate(paymentDate);
                payment.setAmount(amount);
                payment.setPaymentMethod(paymentMethod);
                list.add(payment);
            }
        } catch (Exception e) {
            System.out.println("Error in list method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return list;
    }

    public PaymentDTO load(String id) {
        PaymentDTO payment = null;
        String sql = " SELECT paymentID, bookingID, paymentDate, amount, paymentMethod FROM Payment ";
        sql += " WHERE paymentID = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int paymentID = rs.getInt("paymentID");
                int bookingID = rs.getInt("bookingID");
                Date paymentDate = rs.getDate("paymentDate");
                double amount = rs.getDouble("amount");
                String paymentMethod = rs.getString("paymentMethod");

                payment = new PaymentDTO();
                payment.setPaymentID(paymentID);
                payment.setBookingID(bookingID);
                payment.setPaymentDate(paymentDate);
                payment.setAmount(amount);
                payment.setPaymentMethod(paymentMethod);

            }
        } catch (Exception e) {
            System.out.println("Error in list method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return payment;
    }

    public List<PaymentDTO> search(String keyword) {
        List<PaymentDTO> list = new ArrayList<>();
        String sql = " SELECT paymentID, bookingID, paymentDate, amount, paymentMethod FROM Payment ";
        sql += " WHERE bookingID = ? ";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            Integer idSearch = Integer.parseInt(keyword);
            stmt.setInt(1, idSearch);
//            stmt.setString(2, "%" + id.trim() + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int paymentID = rs.getInt("paymentID");
                int bookingID = rs.getInt("bookingID");
                Date paymentDate = rs.getDate("paymentDate");
                double amount = rs.getInt("amount");
                String paymentMethod = rs.getString("paymentMethod");

                PaymentDTO payment = new PaymentDTO();
                payment.setPaymentID(paymentID);
                payment.setBookingID(bookingID);
                payment.setPaymentDate(paymentDate);
                payment.setAmount(amount);
                payment.setPaymentMethod(paymentMethod);
                list.add(payment);
            }
        } catch (Exception e) {
            System.out.println("Error in search method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(PaymentDTO payment) {
        String sql = "UPDATE Payment SET paymentDate = ?, amount = ?, paymentMethod = ? WHERE paymentID = ?";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDate(1, payment.getPaymentDate());
            stmt.setDouble(2, payment.getAmount());
            stmt.setString(3, payment.getPaymentMethod());
            stmt.setInt(4, payment.getPaymentID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error in update method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(BookingDTO booking, PaymentDTO payment) {
        String sql = "INSERT INTO Payment (bookingID, paymentDate, amount, paymentMethod) "
                + "VALUES ((SELECT bookingID FROM Booking WHERE userID = ? AND departureFlight = ? AND bookingDate = ?), ?, ?, ?)";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, booking.getUserID());
            stmt.setInt(2, Integer.parseInt(booking.getDepartureFlight())); // Cần chắc chắn rằng departureFlight là một số
            stmt.setDate(3, booking.getBookingDate());
            stmt.setDate(4, payment.getPaymentDate());
            stmt.setDouble(5, payment.getAmount());
            stmt.setString(6, payment.getPaymentMethod());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true; // Chèn thành công
            } else {
                System.out.println("No rows affected. Ensure that the booking exists.");
                return false; // Không có bản ghi nào được chèn
            }
        } catch (SQLException e) {
            System.out.println("SQL Error in insert method at PaymentDAO: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in insert method at PaymentDAO: " + e.toString());
            e.printStackTrace();
        }
        return false; // Kết thúc mà không thành công
    }

    public boolean createNewPayment(BookingDTO booking, int bookingID ) {
        String sql = "INSERT INTO Payment (bookingID, paymentDate, amount, paymentMethod) "
                + "VALUES(?,?,?,?)";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, bookingID);
            stmt.setDate(2, booking.getBookingDate());

            stmt.setInt(3, booking.getTotalAmount());
            stmt.setString(4, booking.getPaymentMethod());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true; // Chèn thành công
            } else {
                System.out.println("No rows affected. Ensure that the booking exists.");
                return false; // Không có bản ghi nào được chèn
            }
        } catch (SQLException e) {
            System.out.println("SQL Error in insert method at PaymentDAO: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in insert method at PaymentDAO: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }
}
