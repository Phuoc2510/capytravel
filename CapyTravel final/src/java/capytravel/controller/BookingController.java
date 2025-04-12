/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import capytravel.booking.BookingDAO;
import capytravel.booking.BookingDTO;
import capytravel.users.UsersDAO;
import capytravel.users.UsersDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a
 */
public class BookingController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        if (session == null && request.getAttribute("CHECK_LOGIN") == null) {
            response.sendRedirect("CapyTravelController");
            return;
        }
        
        String keyword = request.getParameter("keyword");
        String action = request.getParameter("action");
        
        String url = "admin/Booking/bookingList.jsp";
        BookingDAO boDAO = new BookingDAO();
        try {
            
            BookingDAO dao = new BookingDAO();
            List<BookingDTO> list = dao.list(keyword);
            request.setAttribute("bookinglist", list);
            
            if (action.equals("bookingAdminDetail")) {
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ex) {
                    log("Parameter id has wrong format.");
                }
                
                BookingDTO booking = null;
                if (id != null) {
                    booking = boDAO.load(id);
                }
                if (booking != null) {
                    request.setAttribute("bookingdetail", booking);
                    url = "admin/Booking/bookingdetails.jsp";
                }
            } else if (action.equals("bookingAdminEdit")) {
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ex) {
                    log("Parameter id has wrong format.");
                }
                
                BookingDTO booking = null;
                if (id != null) {
                    booking = boDAO.load(id);
                }
                
                request.setAttribute("bookingdetail", booking);
                request.setAttribute("bookingaction", "bookingupdate");
                request.setAttribute("pagetitle", "Edit");
                
                url = "admin/Booking/bookingForm.jsp";
                
            } else if (action.equals("bookingupdate")) {
                
                Integer id = null;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ex) {
                    log("Parameter id has wrong format.");
                }
                Integer userid = null;
                try {
                    userid = Integer.parseInt(request.getParameter("userid"));
                } catch (NumberFormatException ex) {
                    log("Parameter user id has wrong format.");
                }
                
                String departureFlight = request.getParameter("departureFlight");
                String returnFlight = request.getParameter("returnFlight");
                
                String bookingDateString = request.getParameter("bookingDate");
                // Chuyển đổi từ String sang Date
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
                java.util.Date date = formatter.parse(bookingDateString);
                java.sql.Date bookingDate = new java.sql.Date(date.getTime());
                
                int totalAmount = 0;
                try {
                    totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
                } catch (NumberFormatException ex) {
                    log("Parameter Total Amount has wrong format.");
                }
                
                String paymentMethod = request.getParameter("paymentMethod");
                
                BookingDTO booking = null;
                if (id != null) {
                    booking = boDAO.load(id);
                }
                if (booking != null) {
                    booking.setUserID(userid);
                    booking.getDepartureFlight();
                    booking.setReturnFlight(returnFlight);
                    booking.setBookingDate(bookingDate);
                    booking.setTotalAmount(totalAmount);
                    booking.setPaymentMethod(paymentMethod);
                    
                    boDAO.update(booking);
                    
                    request.setAttribute("bookingdetail", booking);
                    url = "CapyTravelController?action=bookingAdminDetail";
                }
            } else if (action.equals("bookingAdminCreate")) {
                BookingDTO booking = new BookingDTO();
                request.setAttribute("bookingaction", "bookinginsert");
                request.setAttribute("pagetitle", "Create");
                url = "admin/Booking/bookingForm.jsp";
            } else if (action.equals("bookinginsert")) {
                
                int userid = 0;
                try {
                    userid = Integer.parseInt(request.getParameter("userid"));
                } catch (NumberFormatException ex) {
                    log("Parameter userid has wrong format.");
                }
                
                String departureFlight = request.getParameter("departureFlight");
                String returnFlight = request.getParameter("returnFlight");
                
                String bookingDateString = request.getParameter("bookingDate");
                // Chuyển đổi từ String sang Date
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
                java.util.Date date = formatter.parse(bookingDateString);
                java.sql.Date bookingDate = new java.sql.Date(date.getTime());
                
                int totalAmount = 0;
                try {
                    totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
                } catch (NumberFormatException ex) {
                    log("Parameter totalAmount has wrong format.");
                }
                
                String paymentMethod = request.getParameter("paymentMethod");
                
                BookingDTO booking = new BookingDTO();
                
                booking.setUserID(userid);
                booking.setDepartureFlight(departureFlight);
                booking.setReturnFlight(returnFlight);
                booking.setBookingDate(bookingDate);
                booking.setTotalAmount(totalAmount);
                booking.setPaymentMethod(paymentMethod);
                
                boDAO.insert(booking);
                
                request.setAttribute("bookingdetail", booking);
                url = "admin/Booking/bookingdetails.jsp";

                /* --------------------------------------------*/
            } //user
            else if (action.equals("bookingFlightChoose")) {
                session.setAttribute("FLIGHT_TIME_DEPARTURE", request.getParameter("flightTimeDeparture"));
                session.setAttribute("FLIGHT_TIME_RETURN", request.getParameter("flightTimeReturn"));
                
                int userId = Integer.parseInt(request.getParameter("userid"));
                
                String airline_return = request.getParameter("airlinereturn");
                String airline_departure = request.getParameter("airlinedeparture");
                
                request.setAttribute("AIRLINE_RETURN", airline_return);
                request.setAttribute("AIRLINE_DEPARTURE", airline_departure);
                
                
                   session.setAttribute("AIRLINE_RETURNR", airline_return);
                session.setAttribute("AIRLINE_DEPARTURER", airline_departure);
                
                
                request.setAttribute("flightTimeReturn", request.getParameter("flightTimeReturn"));
                
                String flightTimeDeparture = request.getParameter("flightTimeDeparture");
                String flightTimeReturn = request.getParameter("flightTimeReturn");
                request.setAttribute("flightTimeReturn", flightTimeReturn);
                
                String flightIDReturn = request.getParameter("flightIDReturn");
                String flightIDDeparture = request.getParameter("flightIDDeparture");


//
                // Lấy thông tin người dùng
                UsersDAO userDAO = new UsersDAO();
                UsersDTO userInfo = userDAO.searchUserByID(userId);
                
                request.setAttribute("USER_INFORMATION", userInfo);
                
                url = "ConfirmBooking/HomeBooking.jsp";
                
            } else if (action.equals("bookingUserCreate")) {
                
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                
                BookingDAO booking_dao = new BookingDAO();
                BookingDTO booking = new BookingDTO();
                
                String departureFlight = request.getParameter("flightIDDeparture");
                String returnFlight = request.getParameter("flightIDReturn");
                String bookingDateValue = request.getParameter("bookingDate").trim();
                java.util.Date DateValue = simpleDate.parse(bookingDateValue);
                java.sql.Date bookingDate = new java.sql.Date(DateValue.getTime());
                
                String userIDValue = request.getParameter("id");
                int userID = Integer.parseInt(userIDValue);
                
                String totalAmountValue = request.getParameter("totalAmount").trim();
                int totalAmount = Integer.parseInt(totalAmountValue);
                
                booking.setUserID(userID);
                booking.setDepartureFlight(departureFlight);
                booking.setReturnFlight(returnFlight);
                booking.setBookingDate(bookingDate);
                booking.setTotalAmount(totalAmount);

//                booking_dao.insert(booking);
                session.setAttribute("BOOKING_CREATE_VALUE", booking);
                url = "/ConfirmBooking/booking-payment.jsp";
            } else if (action.equals("bookingPayConfirm")) {
                BookingDTO booking = new BookingDTO();
                
                booking = (BookingDTO) session.getAttribute("BOOKING_CREATE_VALUE");
                String methodID = request.getParameter("methodID");
                booking.setPaymentMethod(methodID);
                boolean createBooking = dao.createNewBooking(booking);
                if (createBooking) {
                    session.setAttribute("BOOKING_CREATE_VALUE", booking);
                    url = "CapyTravelController?action=paymentUserCreate";
                } else {
                    url = "home.jsp";
                }
                
            } else if (action.equals("bookingShow")) {
                UsersDTO user = (UsersDTO) session.getAttribute("CHECK_LOGIN");
                int getUserID = user.getUserID();
                List<BookingDTO> booklist = dao.showBook(getUserID);
                request.setAttribute("BOOKINGSHOW", booklist);
                
                url = "showbooking.jsp";
            }
            
        } catch (Exception e) {
            
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
