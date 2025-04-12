/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.airline;

import capytravel.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author a
 */
public class AirlineDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private AirlineDTO airline = null;
    private List<AirlineDTO> list = null;

    //Hàm lấy toàn bộ danh sách Airline
    public List<AirlineDTO> getList() {
        List<AirlineDTO> list = new ArrayList<>();
        String sql = " SELECT airlineID, airlineName, airlineStatus FROM Airline ";

        try {
            Connection con = DBUtils.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    AirlineDTO airline = new AirlineDTO();
                    airline.setAirlineID(rs.getString("airlineID"));
                    airline.setAirlineName(rs.getString("airlineName"));
                    airline.setAirlineStatus(rs.getBoolean("airlineStatus"));
                    list.add(airline);
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("getList ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

    //Hàm load thông tin từ id của danh sách Airline
    public AirlineDTO load(String id) {
        String sql = " SELECT airlineID, airlineName, airlineStatus FROM Airline ";
        sql += " WHERE airlineID = ? ";
        try {
            Connection con = DBUtils.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    AirlineDTO airline = new AirlineDTO();
                    airline.setAirlineID(rs.getString("airlineID"));
                    airline.setAirlineName(rs.getString("airlineName"));
                    airline.setAirlineStatus(rs.getBoolean("airlineStatus"));
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("getList ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return airline;

    }

    //Hàm search thông tin từ danh sách Airline
    public List<AirlineDTO> searchAirline(String keyword) {

        String sql = " SELECT airlineID, airlineName, airlineStatus FROM Airline ";
        if (keyword != null || !keyword.isEmpty()) {
            sql += " WHERE airlineID LIKE ? OR airlineName LIKE ? ";
        }

        if (keyword == null) {
            keyword = "";
        }

        list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            if (keyword != null || !keyword.isEmpty()) {
                ps.setString(1, '%' + keyword + '%');
                ps.setString(2, '%' + keyword + '%');
            }
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    airline = new AirlineDTO();
                    airline.setAirlineID(rs.getString("airlineID"));
                    airline.setAirlineName(rs.getString("airlineName"));
                    airline.setAirlineStatus(rs.getBoolean("airlineStatus"));
                    list.add(airline);
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("searchAirline ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

    //Hàm cập nhật đối tượng cụ thể trong danh sách Airline
    public boolean updateAirline(AirlineDTO airline) {

        String sql = " UPDATE Airline ";
        sql += " SET airlineName = ?, airlineStatus = ? ";
        sql += " WHERE airlineID = ? ";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, airline.getAirlineName());
            ps.setBoolean(2, airline.isAirlineStatus());
            ps.setString(3, airline.getAirlineID());

            ps.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            System.out.println("updateAirline ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    //Hàm tạo 1 đối tượng cho danh sách Airline
    public boolean createAirline(AirlineDTO airline) {

        String sql = " INSERT INTO Airline(airlineID, airlineName, airlineStatus) ";
        sql += " VALUES(?, ?, ?) ";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, airline.getAirlineID());
            ps.setString(2, airline.getAirlineName());
            ps.setBoolean(3, airline.isAirlineStatus());

            ps.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            System.out.println("createAirline ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    //Hàm xóa 1 đối tượng trong danh sách Airline
    public boolean deteleAirline(String id) {
        String sql = " UPDATE Airline ";
        sql += " SET airlineStatus = 0 ";
        sql += " WHERE airlineID = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);

            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println("deteleAirline ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    public List<AirlineDTO> airlinebooking(String departureAirport, String arrivalAirport) {
        Set<AirlineDTO> set = new HashSet<>(); // Sử dụng Set để loại bỏ trùng lặp
        String sql = " SELECT a.airlineID, a.airlineName, a.airlineStatus "
                + "FROM Airline a "
                + "JOIN Flights f ON a.airlineID = f.airlineID "
                + "WHERE f.active = 1 AND f.departureAirport = ? AND f.arrivalAirport = ?;";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, departureAirport);
            ps.setString(2, arrivalAirport);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AirlineDTO airline = new AirlineDTO();
                airline.setAirlineID(rs.getString("airlineID"));
                airline.setAirlineName(rs.getString("airlineName"));
                airline.setAirlineStatus(rs.getBoolean("airlineStatus"));
                set.add(airline); // Thêm vào Set
            }
        } catch (SQLException ex) {
            System.out.println("getList ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return new ArrayList<>(set); // Trả về danh sách từ Set
    }
    
      

    //test
}
