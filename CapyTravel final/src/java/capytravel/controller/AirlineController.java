/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import capytravel.airline.AirlineDAO;
import capytravel.airline.AirlineDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuja
 */
public class AirlineController extends HttpServlet {

    private final String ADMIN_PAGE_HOME = "admin/airline/airlineHomeView.jsp";
    private final String ADMIN_PAGE_ADD = "admin/airline/airlineAddView.jsp";
    private final String ADMIN_PAGE_RELOAD = "CapyTravelController?action=airlineAdminManagement";
    private final String ADMIN_PAGE_EDIT = "admin/airline/airlineEditView.jsp";

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

        String action = request.getParameter("action");
        String keyword = request.getParameter("keyword");
        String url = ADMIN_PAGE_HOME;
        try {

            //Trở về trang chính của airline
            if (action.equals("airlineAdminManagement")) {
                AirlineDAO dao = new AirlineDAO();
                List<AirlineDTO> list = dao.getList();
                request.setAttribute("LIST_AIRLINE", list);

                //Trở về trang chính của airline sau khi search
            } else if (action.equals("airlineAdminSearch")) {
                AirlineDAO dao = new AirlineDAO();
                List<AirlineDTO> list = dao.searchAirline(keyword.trim());
                request.setAttribute("LIST_AIRLINE", list);

                //Trở về trang chính của airline sau khi insert
            } else if (action.equals("airlineAdminInsert")) {
                url = ADMIN_PAGE_ADD;

                //Trở về trang chính của airline sau khi add
            } else if (action.equals("airlineAdminAdd")) {
                String airlineID = request.getParameter("airlineID");
                String airlineName = request.getParameter("airlineName");

                Boolean airlineStatus = null;
                try {
                    airlineStatus = Boolean.parseBoolean(request.getParameter("airlineStatus"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AirlineDTO airline = new AirlineDTO();
                airline.setAirlineID(airlineID);
                airline.setAirlineName(airlineName);
                airline.setAirlineStatus(airlineStatus);
                AirlineDAO dao = new AirlineDAO();
                dao.createAirline(airline);
                url = ADMIN_PAGE_RELOAD;

                //Trở về trang chính của airline sau khi delete
            } else if (action.equals("airlineAdminDelete")) {
                String airlineID = request.getParameter("airlineID");
                AirlineDAO dao = new AirlineDAO();
                dao.deteleAirline(airlineID);
                url = ADMIN_PAGE_RELOAD;

                //Trở về trang chính của airline sau khi edit
            } else if (action.equals("airlineAdminEdit")) {
                String airlineID = request.getParameter("airlineID");

                String airlineName = request.getParameter("airlineName");

                String status = request.getParameter("airlineStatus");
                boolean airlineStatus = Boolean.parseBoolean(status);
                AirlineDTO airline_details = new AirlineDTO(airlineID, airlineName, airlineStatus);
                request.setAttribute("AIRLINE_DETAILS", airline_details);

                url = ADMIN_PAGE_EDIT;

                //Trở về trang chính của airline sau khi update
            } else if (action.equals("airlineAdminUpdate")) {
                String airlineID = request.getParameter("airlineID");
                String airlineName = request.getParameter("airlineName");
                Boolean airlineStatus = null;
                try {
                    airlineStatus = Boolean.parseBoolean(request.getParameter("airlineStatus"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                AirlineDAO dao = new AirlineDAO();
                AirlineDTO airline = new AirlineDTO();
                airline.setAirlineID(airlineID);
                airline.setAirlineName(airlineName);
                airline.setAirlineStatus(airlineStatus);
                dao.updateAirline(airline);
                url = ADMIN_PAGE_RELOAD;
                //Trở về trang chính của airline sau khi cancel các action
            } else if (action.equals("cancel")) {
                AirlineDAO dao = new AirlineDAO();
                List<AirlineDTO> list = dao.getList();
                request.setAttribute("LIST_AIRLINE", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
