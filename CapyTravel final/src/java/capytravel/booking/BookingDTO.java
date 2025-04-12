/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.booking;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author a
 */
public class BookingDTO {

    private int bookingID; // ID của đặt vé
    private int userID; // ID người dùng
    private String fullName;
    private String departureFlight; // Chuyến bay đi
    private String returnFlight ;
    private Date bookingDate; // Ngày đặt vé
    private int totalAmount; // Tổng số tiền
    private String paymentMethod; // Phương thức thanh toán

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    

    public String getDepartureFlight() {
        return departureFlight;
    }

    public void setDepartureFlight(String departureFlight) {
        this.departureFlight = departureFlight;
    }

    public String getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(String returnFlight) {
        this.returnFlight = returnFlight;
    }
    
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    
    
}
