/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a
 */
@WebServlet(name = "CapyTravelController", urlPatterns = {"/CapyTravelController"})
public class CapyTravelController extends HttpServlet {
    
    private final String LOGIN_HOME = "login.jsp";
    private final String LOGIN_CONTROLLER = "LoginController";
    
    private final String REGISTER_CONTROLLER = "RegisterController";
    private final String REGISTER_HOME = "register.jsp";
    
    private final String LOGOUT_CONTROLLER = "LogoutController";
    private final String USER_CONTROLLER = "UserController";
    
    private final String Flight_CONTROLLER = "FlightsController";
    
    private final String AIRPORT_CONTROLLER = "AirportController";
    
    private final String BOOKING_CONTROLLER = "BookingController";
    
    private final String AIRLINE_CONTROLLER = "AirlineController";
    
    private final String PAYMENT_CONTROLLER = "PaymentController";
    private final String BOOKING_BANK_TRANSFER_HOME = "/ConfirmBooking/bank-transfer.jsp";
    private final String E_WALLET_TRANSFER_CONFIRM_PAGE = "/ConfirmBooking/E_wallet_transfer.jsp";

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

        //set url mac dinh bang trang login
        String url = LOGIN_HOME;

        /* để tất cả các controller cùng tên là action nhưng khác value
         cấu trúc: action = tên bảng+động từ(ví dụ: table airport : action=airportSearch */
        String action = request.getParameter("action");
        
        try {

            //ĐIỀU HƯỚNG LOGIN, REGISTER
            
            if ( action == null || action.equals("userLogin")) {
                url = LOGIN_CONTROLLER;
                //điều hướng về register controller sau khi user điền xong form đăng ký
            } else if (action.equals("userRegister")) {
                url = REGISTER_CONTROLLER;
                //điều hướng khi user press vào nút đăng ký ở trang login
            } else if (action.equals("userCreateNewAccount")) {
                url = REGISTER_HOME;

                //ĐIỀU HƯỚNG TRANG PROFILE
            } else if (action.equals("userLogout")) {
                url = LOGOUT_CONTROLLER;

                //user
            } else if (action.equals("userEditProfile") //nút edit
                    || action.equals("userSaveProfile") //nút save
                    || action.equals("userCancelProfile")) { //nút cancel
                url = USER_CONTROLLER;

                //admin
            } else if (action.equals("userAdminList")
                    || action.equals("userAdminManagement")
                    || action.equals("userAdminDetail")
                    || action.equals("userAdminSearch")
                    || action.equals("userAdminDelete")
                    || action.equals("userAdminSave")
                    || action.equals("userAdminEdit")
                    || action.equals("userAdminAdd")
                    || action.equals("userAdminInsert") || action.equals("userAdminBack")) {
                
                url = USER_CONTROLLER;

                //user payment
            } else if (action.equals("userContinuePayment")) {
                url = USER_CONTROLLER;
                
            } else if (action.equals("PayandShowQR")) {
                String payment = request.getParameter("payment");
                if (payment.equals("bank-transfer")) {
                    url = BOOKING_BANK_TRANSFER_HOME;
                } else {
                    url = E_WALLET_TRANSFER_CONFIRM_PAGE;
                }
         
            } else if (action.equals("FlightAdmin")
                    || action.equals("Search")
                    || action.equals("Back")
                    || action.equals("Detail")
                    || action.equals("Delete")
                    || action.equals("Edit") || action.equals("update")
                    || action.equals("Create") || action.equals("insert")
                    || action.equals("flightUserSearch")) {
                url = Flight_CONTROLLER;
                
            } //điều hướng đến AirportController để xử lý
            else if (action.equals("airportAdminManagement")
                    || action.equals("airportAdminUpdate")
                    || action.equals("airportAdminAdd")
                    || action.equals("airportAdminSave")
                    || action.equals("cancel")
                    || action.equals("airportAdminEdit")
                    || action.equals("airportAdminDelete")
                    || action.equals("airportAdminSearch")) {//nút edit{ //nút cancel
                url = AIRPORT_CONTROLLER;
                
            } else if (action.equals("BookingManagement")
                    || action.equals("bookingAdminSearch")
                    || action.equals("bookingAdminDetail")
                    || action.equals("bookingAdminBack")
                    || action.equals("bookingAdminEdit")
                    || action.equals("bookingupdate")
                    || action.equals("bookingAdminCreate")
                    || action.equals("bookinginsert")
                    //user
                    || action.equals("bookingFlightChoose")
                    || action.equals("bookingUserCreate")
                    || action.equals("bookingPayConfirm")
                    || action.equals("bookingShow")) {
                url = BOOKING_CONTROLLER;
            } //điều hướng đến AirlineController để xử lý
            else if (action.equals("airlineAdminManagement")
                    || action.equals("airlineAdminUpdate")
                    || action.equals("airlineAdminAdd")
                    || action.equals("airlineAdminInsert")
                    || action.equals("cancel")
                    || action.equals("airlineAdminEdit")
                    || action.equals("airlineAdminDelete")
                    || action.equals("airlineAdminSearch")) {//nút edit{ //nút cancel
                url = AIRLINE_CONTROLLER;
            } //điều hướng đến PaymentController để xử lý
            else if (action.equals("paymentAdminManagement")
                    || action.equals("paymentAdminSearch")
                    || action.equals("paymentAdminSave")
                    || action.equals("paymentAdminAdd")
                    || action.equals("paymentAdminCancel")
                    || action.equals("paymentAdminEdit")
                    || action.equals("paymentAdminUpdate")
                    || action.equals("paymentAdminCreate")
                    || action.equals("paymentUserCreate")) {
                url = PAYMENT_CONTROLLER;
            }
            
        } catch (Exception e) {
            
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
