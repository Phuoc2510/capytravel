/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import capytravel.airline.AirlineDAO;
import capytravel.airline.AirlineDTO;
import capytravel.airport.AirportDAO;
import capytravel.airport.AirportDTO;
import capytravel.flights.FlightsDAO;
import capytravel.flights.FlightsDTO;
import capytravel.users.UsersDAO;
import capytravel.users.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a
 */
public class LoginController extends HttpServlet {

    private final String LOGIN_HOME = "login.jsp";
    private final String USER_HOME_PAGE = "home.jsp";
    private final String ADMIN_HOME_PAGE = "admin.jsp/User.jsp/userHomeView.jsp";

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String url = LOGIN_HOME;
        try {
            //goi DAO
            UsersDAO dao = new UsersDAO();

            UsersDTO user = new UsersDTO();
            //goi method checkLogin cua DAO
            user = dao.checkLogin(username, password);

            //neu ket qua la true, set url bang HOME_PAGE
            if (user != null) {

                AirportDAO airportdao = new AirportDAO();
                List<AirportDTO> airport = airportdao.list();

                AirlineDAO airlineDao = new AirlineDAO();
                List<AirlineDTO> airline = airlineDao.getList();

//                FlightsDAO flightdao = new  FlightsDAO();
//                 List<FlightsDTO> flight = flightdao.chooseFlightList();
                HttpSession session = request.getSession(true);
                session.setAttribute("CHECK_LOGIN", user);
                session.setAttribute("CHECK_ROLE", user.getRole());
                session.setAttribute("CHOOSE_AIRPORT", airport);
                session.setAttribute("CHOOSE_AIRLINE", airline);
//                session.setAttribute("CHOOSE_FLIGHT", flight);

                if (user.getRole().equals("US")) {
                    url = USER_HOME_PAGE;
                } else if (user.getRole().equals("AD")) {
                    url = "UserController";
                }
            } else {
                request.setAttribute("ERROR", "Wrong UserID or Password");
                url = LOGIN_HOME;
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
