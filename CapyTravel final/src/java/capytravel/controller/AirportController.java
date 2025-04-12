/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import capytravel.airport.AirportDAO;
import capytravel.airport.AirportDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
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

public class AirportController extends HttpServlet {

    private final String RELOAD = "admin/airport/airportHomeView.jsp";
    private final String ADMIN_PAGE_HOME = "admin/airport/airportHomeView.jsp";
    private final String ADMIN_PAGE_EDIT = "admin/airport/airportEditView.jsp";
    private final String ADMIN_PAGE_ADD = "admin/airport/airportAddView.jsp";

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
        String url =  ADMIN_PAGE_HOME;
        String action = request.getParameter("action");
        AirportDAO dao = new AirportDAO();
        String airportID;
        String airportName;
        String location;
        int status;

        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("CHECK_LOGIN") == null) {
            response.sendRedirect("CapyTravelController");
            return;
        }

//        String username = (String) session.getAttribute("USERNAME");
//        user = dao.searchUser(username);
//
//        request.setAttribute("SEARCH_USER", user);
        try {
            if (action.equals("airportAdminManagement")) {
                List<AirportDTO> airport = dao.list();
                if (airport != null) {
                    request.setAttribute("AIRPORT", airport);
                    
                    url = ADMIN_PAGE_HOME;
                }
            } else if (action.equals("airportAdminSearch")) {
                String keyword = request.getParameter("keyword");
                List<AirportDTO> airport = dao.search(keyword);
                if (airport != null) {
                    request.setAttribute("AIRPORT", airport);
                    url = ADMIN_PAGE_HOME;
                }

            } else if (action.equals("airportAdminDelete")) {
                String id = request.getParameter("id");
                String keyword = request.getParameter("keyword");
                dao.delete(id);
                url = "CapyTravelController?textSearch=" + keyword + "&action=airportAdminSearch";

            } else if (action.equals("airportAdminEdit")) {
                String id = request.getParameter("id");
                AirportDTO airport = dao.load(id);
                request.setAttribute("AIRPORT", airport);
                
                url = ADMIN_PAGE_EDIT;

            } else if (action.equals("cancel")) {
                List<AirportDTO> airport = dao.list();
                if (airport != null) {
                    request.setAttribute("AIRPORT", airport);
                    url = ADMIN_PAGE_HOME;
                }
            } else if (action.equals("airportAdminUpdate")) {
                String id = request.getParameter("id");
                airportID = request.getParameter("airportID");
                airportName = request.getParameter("airportName");
                location = request.getParameter("location");
                status = Integer.parseInt(request.getParameter("status"));
                AirportDTO airport = new AirportDTO();
                airport.setAirportID(airportID);
                airport.setAirportName(airportName);
                airport.setLocation(location);
                airport.setStatus(status);
                dao.update(airport);
                List<AirportDTO> list = dao.list();
                if (list != null) {
                    request.setAttribute("AIRPORT", list);
                    url = RELOAD;
                }
            } else if (action.equals("airportAdminAdd")) {
                url = ADMIN_PAGE_ADD;
            } else if (action.equals("airportAdminSave")) {

                airportID = request.getParameter("airportID");
                airportName = request.getParameter("airportName");
                location = request.getParameter("location");
                status = Integer.parseInt(request.getParameter("status"));

                AirportDTO airport = new AirportDTO();
                airport.setAirportID(airportID);
                airport.setAirportName(airportName);
                airport.setLocation(location);
                airport.setStatus(status);
                dao.insert(airport);
                List<AirportDTO> list = dao.list();
                if (list != null) {
                    request.setAttribute("AIRPORT", list);
                    url = RELOAD;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
