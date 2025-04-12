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
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class FlightsController extends HttpServlet {

    private final String ADMIN_PAGE_HOME = "admin/Flight/flightHomeView.jsp";
    private final String ADMIN_PAGE_DETAILS = "admin/Flight/flightDetailsView.jsp";
    private final String ADMIN_PAGE_MANAGE = "admin/Flight/flightManageView.jsp";

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession(false);
            if (session == null && request.getAttribute("CHECK_LOGIN") == null) {
                response.sendRedirect("CapyTravelController");
                return;
            }

            String keyword = request.getParameter("keyword");
            String action = request.getParameter("action");

            String url = ADMIN_PAGE_HOME;
            FlightsDAO flightDAO = new FlightsDAO();

            try {

                FlightsDAO dao = new FlightsDAO();
                List<FlightsDTO> list = dao.list(keyword);
                request.setAttribute("flightlist", list);

                if (action.equals("Detail")) {
                    Integer id = null;
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException ex) {
                        log("Parameter id has wrong format.");
                    }

                    FlightsDTO flight = null;
                    if (id != null) {
                        flight = flightDAO.load(id);
                    }
                    if (flight != null) {
                        request.setAttribute("flightdetail", flight);
                        url = ADMIN_PAGE_DETAILS;
                    }

                } else if (action.equals("Delete")) {
                    keyword = request.getParameter("keyword");
                    Integer id = null;
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException ex) {
                        log("Parameter id has wrong format.");
                    }

                    flightDAO.delete(id);

                    list = flightDAO.list(keyword);

                    request.setAttribute("flightlist", list);
                    url = "CapyTravelController?keyword=" + keyword + "&action=Search";

                } else if (action.equals("Edit")) {
                    Integer id = null;
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException ex) {
                        log("Parameter id has wrong format.");
                    }

                    FlightsDTO flight = null;
                    if (id != null) {
                        flight = flightDAO.load(id);
                    }

                    request.setAttribute("flightdetail", flight);
                    request.setAttribute("flightaction", "update");
                    request.setAttribute("pagetitle", "Edit");

                    url = ADMIN_PAGE_MANAGE;

                } else if (action.equals("update")) {

                    Integer id = null;
                    try {
                        id = Integer.parseInt(request.getParameter("id"));
                    } catch (NumberFormatException ex) {
                        log("Parameter id has wrong format.");
                    }
                    String flightCode = request.getParameter("flightCode");

                    String departureDateString = request.getParameter("departureDate");
                    // Chuyển đổi từ String sang Date
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
                    java.util.Date date = formatter.parse(departureDateString);
                    java.sql.Date departureDate = new java.sql.Date(date.getTime());

                    String departureAirport = request.getParameter("departureAirport");
                    String arrivalAirport = request.getParameter("arrivalAirport");

                    String flightTimeString = request.getParameter("flightTime");
                    Time flightTime = null;
                    try {
                        // Định dạng thời gian (giả sử định dạng là "HH:mm:ss")
                        SimpleDateFormat formatters = new SimpleDateFormat("HH:mm");
                        // Chuyển đổi từ String sang Date
                        java.util.Date parsedDate = formatters.parse(flightTimeString);
                        // Chuyển đổi từ Date sang Time
                        flightTime = new Time(parsedDate.getTime());
                    } catch (ParseException e) {
                        log("Parameter flightTime has wrong format.");
                    }

                    String airlineID = request.getParameter("airlineID");

                    int active = 0;
                    try {
                        active = Integer.parseInt(request.getParameter("active"));
                    } catch (NumberFormatException ex) {
                        log("Parameter active has wrong format.");
                    }

                    FlightsDTO flight = null;
                    if (id != null) {
                        flight = flightDAO.load(id);
                    }
                    if (flight != null) {
                        flight.setFlightCode(flightCode);
                        flight.setDepartureDate(departureDate);
                        flight.setDepartureAirport(departureAirport);
                        flight.setArrivalAirport(arrivalAirport);
                        flight.setFlightTime(flightTime);
                        flight.setAirlineID(airlineID);
                        flight.setActive(active);

                        flightDAO.update(flight);

                        request.setAttribute("flightdetail", flight);
                        url = ADMIN_PAGE_DETAILS;
                    }
                } else if (action.equals("Create")) {

                    FlightsDTO flight = new FlightsDTO();

                    request.setAttribute("flightaction", "insert");
                    // set title cho trang
                    request.setAttribute("pagetitle", "Create");

                    url = ADMIN_PAGE_MANAGE;
                } else if (action.equals("insert")) {

                    String flightCode = request.getParameter("flightCode");
                    System.out.println(flightCode);
                    String departureDateString = request.getParameter("departureDate");
                    // Chuyển đổi từ String sang Date
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
                    java.util.Date date = formatter.parse(departureDateString);
                    java.sql.Date departureDate = new java.sql.Date(date.getTime());

                    String departureAirport = request.getParameter("departureAirport");
                    String arrivalAirport = request.getParameter("arrivalAirport");

                    String flightTimeString = request.getParameter("flightTime");
                    Time flightTime = null;
                    try {
                        // Định dạng thời gian (giả sử định dạng là "HH:mm:ss")
                        SimpleDateFormat formatters = new SimpleDateFormat("HH:mm");
                        // Chuyển đổi từ String sang Date
                        java.util.Date parsedDate = formatters.parse(flightTimeString);
                        // Chuyển đổi từ Date sang Time
                        flightTime = new Time(parsedDate.getTime());
                    } catch (ParseException e) {
                        log("Parameter flightTime has wrong format.");
                    }

                    String airlineID = request.getParameter("airlineID");

                    int active = 0;
                    try {
                        active = Integer.parseInt(request.getParameter("active"));
                    } catch (NumberFormatException ex) {
                        log("Parameter active has wrong format.");
                    }

                    FlightsDTO flight = new FlightsDTO();

                    flight.setFlightCode(flightCode);
                    flight.setDepartureDate(departureDate);
                    flight.setDepartureAirport(departureAirport);
                    flight.setArrivalAirport(arrivalAirport);
                    flight.setFlightTime(flightTime);
                    flight.setAirlineID(airlineID);
                    flight.setActive(active);

                    flightDAO.insert(flight);

                    request.setAttribute("flightdetail", flight);
                    url = ADMIN_PAGE_DETAILS;
                } else if (action.equals("flightUserSearch")) {

                    String keywords = request.getParameter("keyword");

                    String departureAirport = request.getParameter("departureAirport");
                    String arrivalAirport = request.getParameter("arrivalAirport");

                    String encodedDepartureDate = request.getParameter("departure-date");
                    String encodedReturnDate = request.getParameter("return-date");

                    String decodedDepartureDate = URLDecoder.decode(encodedDepartureDate, "UTF-8");
                    String decodedReturnDate = URLDecoder.decode(encodedReturnDate, "UTF-8");

                    SimpleDateFormat originalFormat = new SimpleDateFormat("MMM d, yyyy");

                    java.util.Date parsedDate = originalFormat.parse(decodedDepartureDate);
                    java.util.Date parsedDateR = originalFormat.parse(decodedReturnDate);

                    java.sql.Date sqlDepartureDate = new java.sql.Date(parsedDate.getTime());
                    java.sql.Date sqlReturnDate = new java.sql.Date(parsedDateR.getTime());

                    request.setAttribute("departureDate", sqlDepartureDate);
                    request.setAttribute("returnDate", sqlReturnDate);

                    SimpleDateFormat targetFormat = new SimpleDateFormat("d 'tháng' M 'năm' yyyy", new java.util.Locale("vi", "VN"));
                    String formattedDepartureDate = targetFormat.format(parsedDate);

                    AirlineDAO airline = new AirlineDAO();
                    List<AirlineDTO> airlinelist = airline.airlinebooking(departureAirport, arrivalAirport);

                    AirportDAO airportdao = new AirportDAO();
                    AirportDTO departureLocation = airportdao.searchLocationToBooking(departureAirport);
                    AirportDTO arrivalLocation = airportdao.searchLocationToBooking(arrivalAirport);

                    AirlineDAO airlinedao = new AirlineDAO();

                    FlightsDTO flight = new FlightsDTO();
                    flight.setDepartureAirport(departureLocation.getLocation());
                    flight.setArrivalAirport(arrivalLocation.getLocation());
                    flight.setDepartureDate(sqlDepartureDate);

                    session.setAttribute("CHOOSE_AIRLINE", airlinelist);
                    session.setAttribute("FLIGHT_DETAILS", flight);
                    session.setAttribute("CHOOSE_FLIGHT", dao.chooseFlightSearch(departureAirport, arrivalAirport, sqlDepartureDate, keywords));
                    request.setAttribute("AIRLINE_DEPARTURE", request.getParameter("airlinedeparture"));

                    url = "ConfirmBooking/chooseFlight.jsp";
                } else if (action.equals("flightUserSearchs")) {

                    String keywords = request.getParameter("keyword");

                    String departureAirport = request.getParameter("departureAirport");
                    String arrivalAirport = request.getParameter("arrivalAirport");

                    String encodedDepartureDate = request.getParameter("departure-date");

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
                    java.util.Date date = formatter.parse(encodedDepartureDate);
                    java.sql.Date departureDate = new java.sql.Date(date.getTime());

                    AirlineDAO airline = new AirlineDAO();
                    List<AirlineDTO> airlinelist = airline.airlinebooking(departureAirport, arrivalAirport);

                    AirportDAO airportdao = new AirportDAO();

                    AirportDTO departureLocation = airportdao.searchLocationToBooking(departureAirport);
                    AirportDTO arrivalLocation = airportdao.searchLocationToBooking(arrivalAirport);

                    FlightsDTO flight = new FlightsDTO();
                    flight.setArrivalAirport(departureLocation.getLocation());
                    flight.setDepartureAirport(arrivalLocation.getLocation());
                    flight.setDepartureDate(departureDate);

                    request.setAttribute("CHOOSE_AIRLINE", airlinelist);
                    session.setAttribute("FLIGHT_DETAILS", flight);
                    session.setAttribute("CHOOSE_FLIGHT", dao.chooseFlightSearch(departureAirport, arrivalAirport, departureDate, keywords));
                    url = "ConfirmBooking/chooseFlight.jsp";

                } else if (action.equals("flightUserSearchReturn")) {
                    String flightTimeDeparture = request.getParameter("flightTimeDeparture");
                    String flightTimeReturn = request.getParameter("flightTimeReturn");
                    
                    
                    String arrivalAirport = request.getParameter("departureAirport");
                    String departureAirport = request.getParameter("arrivalAirport");

                    String encodedReturnDate = request.getParameter("returnDate");

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày
                    java.util.Date date = formatter.parse(encodedReturnDate);
                    java.sql.Date returnDate = new java.sql.Date(date.getTime());

                    keyword = request.getParameter("keyword");

                    AirlineDAO airline = new AirlineDAO();
                    List<AirlineDTO> airlinelist = airline.airlinebooking(departureAirport, arrivalAirport);

                    AirportDAO airportdao = new AirportDAO();
                    AirportDTO departureLocation = airportdao.searchLocationToBooking(departureAirport);
                    AirportDTO arrivalLocation = airportdao.searchLocationToBooking(arrivalAirport);

                    AirlineDAO airlinedao = new AirlineDAO();

                    FlightsDTO flight = new FlightsDTO();
                    flight.setDepartureAirport(departureLocation.getLocation());
                    flight.setArrivalAirport(arrivalLocation.getLocation());
                    flight.setDepartureDate(returnDate);

                    session.setAttribute("CHOOSE_AIRLINE_RETURN", airlinelist);
                    session.setAttribute("FLIGHT_DETAILS_RETURN", flight);
                    session.setAttribute("CHOOSE_FLIGHT_RERURN", dao.chooseFlightSearch(departureAirport, arrivalAirport, returnDate, keyword));
                    request.setAttribute("FLIGHT_TIME_DEPARTURE", flightTimeDeparture);
                    request.setAttribute("FLIGHT_TIME_RETURN", flightTimeReturn);
                    
                    
                    
                    url = "ConfirmBooking/chooseReturnFlight.jsp";
                }

            } catch (Exception e) {

            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }

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
