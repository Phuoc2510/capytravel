/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.users;

import capytravel.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author a
 */
public class UsersDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    // hàm này dùng để check thông tin đăng nhập của user
    public UsersDTO checkLogin(String name, String password) throws SQLException {
        UsersDTO user = null;
        try {
            // ket noi database
            con = DBUtils.getConnection();

            //check con có = null hay không
            if (con != null) {

                // set cau truy van
                String sql = "SELECT userName, firstName, lastName, role, userID "
                        + "FROM Users "
                        + "WHERE userName = ? AND  password = ? AND status = 1 ";

                //prepare cau truy van
                pstm = con.prepareCall(sql);

                pstm.setString(1, name);
                pstm.setString(2, password);

                //execute truy van
                rs = pstm.executeQuery();

                if (rs.next()) {
                    user = new UsersDTO();

                    String userName = rs.getString("userName");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    int userID = rs.getInt("userID");
                    String role = rs.getString("role");

                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setUserName(userName);
                    user.setRole(role);
                    user.setUserID(userID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //dong resultset
            if (rs != null) {
                rs.close();
            }

            //dong prepare statement
            if (pstm != null) {
                pstm.close();
            }

            //dong connection
            if (con != null) {
                con.close();
            }
        }
        return user;
    }

    private ArrayList<UsersDTO> UserList;

    //hàm này dùng để list danh sách table User
    public ArrayList<UsersDTO> getList() {
        UserList = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DBUtils.getConnection();

            if (con != null) {
                // Câu lệnh SQL để chọn tất cả người dùng
                String sql = "SELECT userID, firstName, lastName, userName, password, gender, email, "
                        + "phoneNumber, dateOfBirth, identificationNumber,avatar, role, status "
                        + "FROM Users "
                        + "WHERE role = 'US' ";

                // Chuẩn bị câu lệnh SQL
                pstm = con.prepareStatement(sql);

                // Thực thi câu lệnh và lấy kết quả
                rs = pstm.executeQuery();

                while (rs.next()) {
                    // Khởi tạo người dùng mới
                    UsersDTO user = new UsersDTO();
                    user.setUserID(rs.getInt("userID"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setDateOfBirth(rs.getDate("dateOfBirth"));
                    user.setIdentificationNumber(rs.getString("identificationNumber"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getBoolean("status"));

                    UserList.add(user);
                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return UserList; // Trả về danh sách người dùng
    }

    //hàm này dùng để search 1 detail profile user
    public UsersDTO searchUser(String keyword) {
        UsersDTO user = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DBUtils.getConnection();

            if (con != null) {
                // Câu lệnh SQL để chọn tất cả người dùng
                String sql = " SELECT userID, firstName, lastName, userName, password, gender, email, "
                        + "phoneNumber, dateOfBirth, identificationNumber,avatar, role, status "
                        + "FROM Users "
                        + "WHERE userName = ? ";

                // Chuẩn bị câu lệnh SQL
                pstm = con.prepareStatement(sql);

                pstm.setString(1, keyword);
                // Thực thi câu lệnh và lấy kết quả
                rs = pstm.executeQuery();

                while (rs.next()) {
                    // Khởi tạo người dùng mới
                    user = new UsersDTO();
                    user.setUserID(rs.getInt("userID"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setDateOfBirth(rs.getDate("dateOfBirth"));
                    user.setIdentificationNumber(rs.getString("identificationNumber"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getBoolean("status"));

                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return user; // Trả về danh sách người dùng
    }

    public UsersDTO searchPassword(int keyword) {
        UsersDTO user = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DBUtils.getConnection();

            if (con != null) {
                // Câu lệnh SQL để chọn tất cả người dùng
                String sql = " SELECT  password "
                        + "FROM Users "
                        + "WHERE userID = ? ";

                // Chuẩn bị câu lệnh SQL
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, keyword);
                // Thực thi câu lệnh và lấy kết quả
                rs = pstm.executeQuery();

                while (rs.next()) {
                    // Khởi tạo người dùng mới
                    user = new UsersDTO();
                    user.setPassword(rs.getString("password"));

                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return user; // Trả về danh sách người dùng
    }

    public boolean updatePassword(UsersDTO user) throws SQLException {

        try {
            con = DBUtils.getConnection();

            if (con != null) {

                String sql = "UPDATE Users "
                        + " SET password = ? "
                        + " WHERE userID = ? ";

                pstm = con.prepareStatement(sql);
                pstm.setString(1, user.getPassword());
                pstm.setInt(2, user.getUserID());

                int result = pstm.executeUpdate();

                return result > 0;

            }
        } catch (Exception e) {

        } finally {
            if (pstm != null) {
                pstm.close();
            }

            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    //hàm này dùng để search danh sách User bằng Name
    public ArrayList<UsersDTO> searchUserbyName(String keyword) {
        UsersDTO user = null;
        UserList = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DBUtils.getConnection();

            if (con != null) {
                // Câu lệnh SQL để chọn tất cả người dùng
                String sql = "SELECT userID, firstName, lastName, userName, password, gender, email, "
                        + "phoneNumber, dateOfBirth, identificationNumber,avatar, role, status "
                        + "FROM Users "
                        + "WHERE firstName like ? AND role = 'US'";

                // Chuẩn bị câu lệnh SQL
                pstm = con.prepareStatement(sql);

                pstm.setString(1, "%" + keyword + "%");

                // Thực thi câu lệnh và lấy kết quả
                rs = pstm.executeQuery();

                while (rs.next()) {
                    // Khởi tạo người dùng mới
                    user = new UsersDTO();
                    user.setUserID(rs.getInt("userID"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    //      user.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate()); // Chuyển đổi về LocalDate
                    user.setIdentificationNumber(rs.getString("identificationNumber"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getBoolean("status"));
                    UserList.add(user);
                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return UserList; // Trả về danh sách người dùng
    }

    //hàm này dùng để search detail User bằng ID
    public UsersDTO searchUserByID(int keyword) {
        UsersDTO user = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            con = DBUtils.getConnection();

            if (con != null) {
                // Câu lệnh SQL để chọn tất cả người dùng
                String sql = "SELECT userID, firstName, lastName, userName, password, gender, email, "
                        + "phoneNumber, dateOfBirth, identificationNumber,avatar, role, status "
                        + "FROM Users "
                        + "WHERE userID = ? ";

                // Chuẩn bị câu lệnh SQL
                pstm = con.prepareStatement(sql);

                pstm.setInt(1, keyword);
                // Thực thi câu lệnh và lấy kết quả
                rs = pstm.executeQuery();

                while (rs.next()) {
                    // Khởi tạo người dùng mới
                    user = new UsersDTO();
                    user.setUserID(rs.getInt("userID"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setUserName(rs.getString("userName"));
                    user.setPassword(rs.getString("password"));
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setDateOfBirth(rs.getDate("dateOfBirth"));
                    user.setIdentificationNumber(rs.getString("identificationNumber"));
                    user.setAvatar(rs.getString("avatar"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getBoolean("status"));

                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
        return user; // Trả về danh sách người dùng
    }

    //hàm này dùng để khởi tạo ID tự tăng 
    private int genent() throws SQLException {
        int id = 1; // Khởi tạo ID mặc định
        String sql = "SELECT MAX(userID) AS ID FROM Users";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement pstm = con.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery()) {

            if (rs.next()) {
                id = rs.getInt("ID") + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return id;
    }

    /* hàm này dùng để insert thông tin user để đăng ký
       các thông tin được set : userID, username, password, full name, email và checkAdmin */
    public boolean RegisterAccount(UsersDTO user) throws SQLException {
        try {

            con = DBUtils.getConnection();

            if (con != null) {

                String sql = "INSERT into Users(userID, userName, password, firstName, lastName, email, role, status) "
                        + "VALUES(?,?,?,?,?,?,?,?) ";

                pstm = con.prepareStatement(sql);

                int id = genent();
                pstm.setInt(1, id);
                pstm.setString(2, user.getUserName());
                pstm.setString(3, user.getPassword());
                pstm.setString(4, user.getFirstName());
                pstm.setString(5, user.getLastName());
                pstm.setString(6, user.getEmail());
                pstm.setString(7, "US");
                pstm.setBoolean(8, true);

                int col = pstm.executeUpdate();

                return col > 0;

            }

        } catch (Exception e) {

        } finally {
            if (pstm != null) {
                pstm.close();
            }

            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    // hàm này dùng để update User(admin)
    public boolean updateUser(UsersDTO user) throws SQLException {

        try {
            con = DBUtils.getConnection();

            if (con != null) {

                String sql = "UPDATE Users "
                        + "SET userName = ? ,firstName = ?, lastName = ? ,phoneNumber = ?, "
                        + "identificationNumber = ?, email = ?, dateOfBirth = ? , gender = ?, status = ?, password = ? "
                        + "WHERE userID = ? ";

                pstm = con.prepareStatement(sql);

                pstm.setString(1, user.getUserName());
                pstm.setString(2, user.getFirstName());
                pstm.setString(3, user.getLastName());
                pstm.setString(4, user.getPhoneNumber());
                pstm.setString(5, user.getIdentificationNumber());
                pstm.setString(6, user.getEmail());
                pstm.setDate(7, user.getDateOfBirth());
                pstm.setString(8, user.getGender());
                pstm.setBoolean(9, user.isStatus());
                pstm.setString(10, user.getPassword());
                pstm.setInt(11, user.getUserID());

                int result = pstm.executeUpdate();

                return result > 0;

            }
        } catch (Exception e) {

        } finally {
            if (pstm != null) {
                pstm.close();
            }

            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    // hàm này dùng để update profile User
   public boolean updateProfile(UsersDTO user) throws SQLException {

        try {
            con = DBUtils.getConnection();

            if (con != null) {

                String sql = "UPDATE Users "
                        + "SET userName = ? ,firstName = ?, lastName = ? ,phoneNumber = ?, "
                        + "identificationNumber = ?, email = ?, dateOfBirth = ? , gender = ? ,avatar=?"
                        + " WHERE userID = ? ";

                pstm = con.prepareStatement(sql);

                pstm.setString(1, user.getUserName());
                pstm.setString(2, user.getFirstName());
                pstm.setString(3, user.getLastName());
                pstm.setString(4, user.getPhoneNumber());
                pstm.setString(5, user.getIdentificationNumber());
                pstm.setString(6, user.getEmail());
                pstm.setDate(7, user.getDateOfBirth());
                pstm.setString(8, user.getGender());
                pstm.setString(9, user.getAvatar());
                pstm.setInt(10, user.getUserID());

                int result = pstm.executeUpdate();

                return result > 0;

            }
        } catch (Exception e) {
            System.out.println("Error updating profile: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }

            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    //hàm này dùng để Delete(Set Status = 0) User
    public boolean delete(int id) {

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "UPDATE Users "
                        + "SET status = 0 "
                        + "WHERE userID = ? ";

                pstm = con.prepareStatement(sql);
                pstm.setInt(1, id);
                int result = pstm.executeUpdate();

                if (result > 0) {
                    return true;
                }
            }
            con.close();
        } catch (Exception e) {

        }
        return false;
    }

    public boolean insertUser(UsersDTO user) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "INSERT INTO Users (userID, firstName, lastName, userName, password, gender, email, phoneNumber, dateOfBirth, identificationNumber, role, status) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                pstm = con.prepareStatement(sql);

                pstm.setInt(1, genent());
                pstm.setString(2, user.getFirstName());
                pstm.setString(3, user.getLastName());
                pstm.setString(4, user.getUserName());
                pstm.setString(5, user.getPassword());
                pstm.setString(6, user.getGender());
                pstm.setString(7, user.getEmail());
                pstm.setString(8, user.getPhoneNumber());
                pstm.setDate(9, user.getDateOfBirth());
                pstm.setString(10, user.getIdentificationNumber());
                pstm.setString(11, "US");
                pstm.setBoolean(12, true);

                int result = pstm.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
}
