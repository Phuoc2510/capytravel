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
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UserController extends HttpServlet {

    private final String PROFILE_HOME = "profile.jsp";
    private final String HOME_PAGE = "home.jsp";

    private final String ADMIN_HOME_PAGE = "admin/User/userHomeView.jsp";
    private final String ADMIN_HOME_PAGE_RELOAD = "CapyTravelController?action=userAdminList";
    private final String ADMIN_DETAIL_PAGE = "admin/User/userDetailsView.jsp";

    private final String ADMIN_EDIT_PAGE = "admin/User/userEditView.jsp";
    private final String ADMIN_INSERT_PAGE = "admin/User/userAddView.jsp";

    private final String USER_BOOKING_PAYMENT = "ConfirmBooking/booking-payment.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "";
        String action = request.getParameter("action");
        UsersDAO dao = new UsersDAO();
        UsersDTO user = new UsersDTO();
        ArrayList<UsersDTO> userlist = dao.getList();
        request.setAttribute("USER_LIST", userlist);

        HttpSession session = request.getSession();

        int userID;
        String firstName;
        String lastName;
        String userName;
        String password;
        String gender;
        String email;
        String phoneNumber;
//        Date dateOfBirth;
        String identificationNumber;
        boolean status;

        if (session == null || session.getAttribute("CHECK_LOGIN") == null || session.getAttribute("CHECK_ROLE") == null) {
            response.sendRedirect("CapyTravelController");
            return;
        }

        //search trong profile
        String role = (String) session.getAttribute("CHECK_ROLE");

        try {
            if (role.equals("US")) {
                //chuyển hướng về trang profile
                if (action.equals("userEditProfile")) {

                    user = (UsersDTO) session.getAttribute("CHECK_LOGIN");
                    UsersDTO userListProfile = dao.searchUserByID(user.getUserID());

                    request.setAttribute("SEARCH_USER", userListProfile);
                    url = PROFILE_HOME;
                } else if (action.equals("userSaveProfile")) {
                    user = new UsersDTO();
                    String id = request.getParameter("id");
                    int idValue = Integer.parseInt(id);

                    firstName = request.getParameter("firstname");
                    lastName = request.getParameter("lastname");
                    userName = request.getParameter("username");
                    email = request.getParameter("email");
                    phoneNumber = request.getParameter("phonenumber");
                    gender = request.getParameter("gender");

                    // password
                    String currentPassword = request.getParameter("currentPassword");
                    String newPassword = request.getParameter("newPassword");
                    String repeatNewPassword = request.getParameter("repeatNewPassword");
                    UsersDTO passwordSQL = dao.searchPassword(idValue);
                    String pass = passwordSQL.getPassword();
                    if (pass.equals(currentPassword)) {
                        if (newPassword.equals(repeatNewPassword)) {
                            user = new UsersDTO();
                            user.setPassword(repeatNewPassword);
                            user.setUserID(idValue);
                            dao.updatePassword(user);
                            request.setAttribute("passwordSuccess", "Password Updated Successfully!");
                            url = "profile.jsp"; // Chuyển hướng về profile
                        }
                    } else {
                        request.setAttribute("passwordError", "Wrong Password or New Password and Repeate Password doesn't matched"); // Thiết lập lỗi
                        url = "profile.jsp"; // Chuyển hướng về profile
                    }
                    String dateOfBirthValue = request.getParameter("dateOfBirth");
                    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date DateValue = simpleDate.parse(dateOfBirthValue);

                    java.sql.Date pubDate = new java.sql.Date(DateValue.getTime());

                    String identificationnumber = request.getParameter("identificationnumber");

                    String avatar = request.getParameter("avatar");

                    user.setUserID(idValue);
                    user.setUserName(userName);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setPhoneNumber(phoneNumber);
                    user.setGender(gender);
                    user.setEmail(email);
                    user.setDateOfBirth(pubDate);
                    user.setIdentificationNumber(identificationnumber);
                    if (avatar != null) {
                        user.setAvatar(avatar);
                    }  //else{
//                        user.setAvatar(request.getParameter("currentAvatarPath"));
//                    }

                    boolean updateProfile = dao.updateProfile(user);

                    if (updateProfile) {
                        url = "CapyTravelController?action=userEditProfile";
                    } else {
                        url = HOME_PAGE;
                    }

                } else if (action.equals("userCancelProfile")) {
                    url = HOME_PAGE;

                    //-------------------------------USER PAYMENT----------------------------------------------------
                } else if (action.equals("userContinuePayment")) {
                    user = new UsersDTO();
                    String id = request.getParameter("id");
                    int idValue = Integer.parseInt(id);

                    firstName = request.getParameter("firstname");
                    lastName = request.getParameter("lastname");
                    userName = request.getParameter("username");
                    email = request.getParameter("email");
                    phoneNumber = request.getParameter("phonenumber");
                    gender = request.getParameter("gender");

                    String dateOfBirthValue = request.getParameter("dateOfBirth");
                    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date DateValue = simpleDate.parse(dateOfBirthValue);

                    java.sql.Date pubDate = new java.sql.Date(DateValue.getTime());

                    String identificationnumber = request.getParameter("identificationnumber");

                    user.setUserID(idValue);
                    user.setUserName(userName);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setPhoneNumber(phoneNumber);
                    user.setGender(gender);
                    user.setEmail(email);
                    user.setDateOfBirth(pubDate);
                    user.setIdentificationNumber(identificationnumber);

                    dao.updateProfile(user);
                    url = "BookingController?action=bookingUserCreate";
//                    boolean updateProfile = dao.updateProfile(user);
//
//                    if (updateProfile) {
//                        url = USER_BOOKING_PAYMENT;
//                    } else {
//                        url = ADMIN_HOME_PAGE;
//                    }
                }
            }

            //-------------------------------USER PAYMENT-----------------------------------------------------
            if (role.equals("AD")) {
                url = ADMIN_HOME_PAGE;
            }
            if (action.equals("userAdminList")) {
                url = ADMIN_HOME_PAGE;
            } else if (action.equals("userAdminDetail")) {
                String ID = request.getParameter("userID");
                userID = Integer.parseInt(ID);
                UsersDTO user_detail = dao.searchUserByID(userID);
                request.setAttribute("DETAIL_USER", user_detail);
                url = ADMIN_DETAIL_PAGE;
            } else if (action.equals("userAdminSearch")) {
                String keyword = request.getParameter("searchValue");
                ArrayList<UsersDTO> searchUserAdmin = dao.searchUserbyName(keyword);
                request.setAttribute("SEARCH_RESULT", searchUserAdmin);
                url = ADMIN_HOME_PAGE;
            } else if (action.equals("userAdminDelete")) {
                String lastSearch = request.getParameter("lastsearch") != null ? request.getParameter("lastsearch") : "";

                String ID = request.getParameter("userID");
                userID = Integer.parseInt(ID);
                if (!lastSearch.equals("")) {
                    dao.delete(userID);
                    url = "CapyTravelController?"
                            + "searchValue=" + lastSearch
                            + "&action=userAdminSearch";

                    response.sendRedirect(url);
                    return;
                } else {
                    dao.delete(userID);
                    url = "CapyTravelController?"
                            + "action=userAdminList";
                    response.sendRedirect(url);
                    return;
                }
            } else if (action.equals("userAdminEdit")) {
                String ID = request.getParameter("userID");
                userID = Integer.parseInt(ID);
                UsersDTO user_detail = dao.searchUserByID(userID);
                request.setAttribute("DETAIL_USER", user_detail);
                url = ADMIN_EDIT_PAGE;
            } else if (action.equals("userAdminSave")) {
                user = new UsersDTO();
                userID = Integer.parseInt(request.getParameter("userID"));
                user.setUserID(userID);

                user.setFirstName(request.getParameter("firstName"));
                user.setLastName(request.getParameter("lastName"));
                user.setUserName(request.getParameter("userName"));

                user.setPassword(request.getParameter("password"));
                // Chuyển đổi ngày tháng
                String dob = request.getParameter("dob");
                String dateValue = request.getParameter("dob");
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = simpleDate.parse(dateValue);
                java.sql.Date pubDate = new java.sql.Date(utilDate.getTime());
                user.setDateOfBirth(pubDate);

                user.setPhoneNumber(request.getParameter("phoneNumber"));
                user.setGender(request.getParameter("gender"));
                user.setEmail(request.getParameter("email"));
                user.setIdentificationNumber(request.getParameter("identificationNumber"));
                user.setStatus(Boolean.parseBoolean(request.getParameter("status")));

                // Cập nhật thông tin người dùng
                boolean isUpdated = dao.updateUser(user);
                if (isUpdated) {
                    request.setAttribute("UPDATE_MESSAGE", "User information updated successfully.");
                    url = "CapyTravelController?action=userAdminDetail&userID=" + userID;
                } else {
                    request.setAttribute("UPDATE_MESSAGE", "Failed to update user information.");
                    url = HOME_PAGE; // Quay lại trang chỉnh sửa
                }
            } else if (action.equals("userAdminAdd")) {
                user = new UsersDTO();
                user.setFirstName(request.getParameter("firstName"));
                user.setLastName(request.getParameter("lastName"));
                user.setUserName(request.getParameter("userName"));

                String dateValue = request.getParameter("dob");
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate = simpleDate.parse(dateValue);
                java.sql.Date pubDate = new java.sql.Date(utilDate.getTime());
                user.setDateOfBirth(pubDate);
                user.setPhoneNumber(request.getParameter("phoneNumber"));
                user.setGender(request.getParameter("gender"));
                user.setEmail(request.getParameter("email"));
                user.setIdentificationNumber(request.getParameter("identificationNumber"));
                user.setStatus(Boolean.parseBoolean(request.getParameter("status")));

                if (dao.insertUser(user)) {
                    url = ADMIN_HOME_PAGE_RELOAD;
                } else {
                    url = ADMIN_HOME_PAGE;
                }
            } else if (action.equals("userAdminInsert")) {
                url = ADMIN_INSERT_PAGE;
            }

        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.INFO, "Action: {0}", action);
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
