/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.controller;

import capytravel.users.UsersDAO;
import capytravel.users.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class RegisterController extends HttpServlet {

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

        String url = "register.jsp";
        try {
            UsersDAO dao = new UsersDAO();
            UsersDTO user = new UsersDTO();

            // Lấy thông tin từ request
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");

            // Thiết lập thông tin người dùng
            user.setUserName(username);
            user.setPassword(password);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);

            // Lấy danh sách người dùng từ cơ sở dữ liệu
            List<UsersDTO> check = dao.getList();
            List<String> userNames = new ArrayList<>();
            List<String> emails = new ArrayList<>();

            // Duyệt qua từng UsersDTO để lấy tên người dùng và email
            for (UsersDTO userDTO : check) {
                userNames.add(userDTO.getUserName());
                emails.add(userDTO.getEmail());
            }

            // Kiểm tra xem tên người dùng và email đã tồn tại chưa
            if (!userNames.contains(username) && !emails.contains(email)) {
                // Nếu tên người dùng và email chưa tồn tại, thực hiện đăng ký
                dao.insertUser(user);
                request.setAttribute("successRegisterMessage", "Account created successfully!");
                url = "login.jsp"; // Chuyển hướng đến trang đăng nhập
            } else {
                // Nếu tên người dùng hoặc email đã tồn tại, hiển thị thông báo lỗi
                request.setAttribute("errorRegisterMessage", "Username or email already exists. Please try again.");
                url = "register.jsp"; // Quay lại trang đăng ký
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorRegisterMessage", "Database error occurred. Please try again.");
            url = "register.jsp"; // Quay lại trang đăng ký
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
