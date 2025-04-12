/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import capytravel.booking.BookingDAO;
import capytravel.booking.BookingDTO;
import capytravel.payment.PaymentDAO;
import capytravel.payment.PaymentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phuoc
 */
@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {

    private final String RELOAD = "admin/Payment/paymentHomeView.jsp";

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
        String url = "admin/Payment/paymentList.jsp";
        String action = request.getParameter("action");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PaymentDAO dao = new PaymentDAO();
        int paymentID;
        int bookingID;
        String payment_Date;
        double amount;
        String paymentMethod;

        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("CHECK_LOGIN") == null) {
            response.sendRedirect("CapyTravelController");
            return;
        }
        try {
            if (action.equals("paymentAdminManagement")) {
                List<PaymentDTO> list = dao.list();
                if (list != null) {
                    request.setAttribute("PAYMENT", list);
                    url = "admin/Payment/paymentHomeView.jsp";
                }
            } else if (action.equals("paymentAdminSearch")) {
                String keyword = request.getParameter("keyword");
                if (keyword != null && !keyword.isEmpty()) {
                    List<PaymentDTO> list = dao.search(keyword);
                    if (list != null) {
                        request.setAttribute("PAYMENT", list);
                        url = "admin/Payment/paymentHomeView.jsp";
                    }
                } else {
                    url = "CapyTravelController?action=paymentAdminManagement";
                }
            } else if (action.equals("paymentAdminEdit")) {
                String id = request.getParameter("id");
                PaymentDTO payment = dao.load(id);
                request.setAttribute("PAYMENT", payment);

                url = "admin/Payment/paymentEditView.jsp";

            } else if (action.equals("paymentAdminCancel")) {
                List<PaymentDTO> payment = dao.list();
                if (payment != null) {
                    request.setAttribute("PAYMENT", payment);
                    url = "admin/Payment/paymentHomeView.jsp";
                }
            } else if (action.equals("paymentAdminUpdate")) {
                paymentID = Integer.parseInt(request.getParameter("id"));
                payment_Date = request.getParameter("paymentDate");
                amount = Double.parseDouble(request.getParameter("amount"));
                paymentMethod = request.getParameter("paymentMethod");
                java.util.Date date = sdf.parse(payment_Date);
                java.sql.Date paymentDate = new java.sql.Date(date.getTime());
                PaymentDTO payment = new PaymentDTO();
                payment.setPaymentID(paymentID);
                payment.setPaymentDate(paymentDate);
                payment.setAmount(amount);
                payment.setPaymentMethod(paymentMethod);
                dao.update(payment);
                List<PaymentDTO> list = dao.list();
                if (list != null) {
                    request.setAttribute("PAYMENT", list);
                    url = "admin/Payment/paymentHomeView.jsp";
                } else {
                    url = "admin/Payment/paymentEditView.jsp";
                }
            } else if (action.equals("paymentAdminAdd")) {
                url = "admin/Payment/paymentAddView.jsp";
            } else if (action.equals("paymentAdminSave")) {
                bookingID = Integer.parseInt(request.getParameter("bookingID"));
                payment_Date = request.getParameter("paymentDate");
                amount = Double.parseDouble(request.getParameter("amount"));
                paymentMethod = request.getParameter("paymentMethod");

                java.util.Date date = sdf.parse(payment_Date);
                java.sql.Date paymentDate = new java.sql.Date(date.getTime());
                BookingDTO booking = new BookingDTO();
                BookingDAO daoBooking = new BookingDAO();
                daoBooking.load(bookingID);
                booking.setUserID(booking.getUserID());
                booking.setDepartureFlight(booking.getDepartureFlight());
                booking.setBookingDate(booking.getBookingDate());
                PaymentDTO payment = new PaymentDTO();
                payment.setPaymentDate(paymentDate);
                payment.setAmount(amount);
                payment.setPaymentMethod(paymentMethod);
                dao.insert(booking, payment);
                List<PaymentDTO> list = dao.list();
                if (list != null) {
                    request.setAttribute("PAYMENT", list);
                    url = RELOAD;
                }
            } else if (action.equals("paymentUserCreate")) {
                BookingDTO booking = (BookingDTO) session.getAttribute("BOOKING_CREATE_VALUE");
              
                BookingDAO bookingdao = new BookingDAO();
                
                boolean payment = dao.createNewPayment(booking, bookingdao.getMaxBookingID());
                if(payment) {
                    session.removeAttribute("BOOKING_CREATE_VALUE");
                    url = "home.jsp";
                } else {
                    url = "login.jsp";
                }
            }
        } catch (Exception e) {
            log("Error at PaymentController: " + e.toString());
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
