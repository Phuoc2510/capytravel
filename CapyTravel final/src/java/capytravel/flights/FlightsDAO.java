/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.flights;

import capytravel.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author a
 */
public class FlightsDAO implements Serializable {

    private List<FlightsDTO> list;

    public List<FlightsDTO> list(String keyword) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FlightsDTO flight = null;
        list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();

            if (con != null) {

                String sql = " select flightID,flightCode,departureDate,active from Flights ";
                if (keyword != null && !keyword.isEmpty()) {
                    sql += " where flightCode like ?";
                }

                ps = con.prepareStatement(sql);
                if (keyword != null && !keyword.isEmpty()) {
                    ps.setString(1, "%" + keyword.trim() + "%");
                }
                rs = ps.executeQuery();

                while (rs.next()) {
                    int flightID = rs.getInt("flightID");
                    String flightCode = rs.getString("flightCode");
                    Date departureDate = rs.getDate("departureDate");
                    int active = rs.getInt("active");
                    flight = new FlightsDTO();
                    flight.setFlightID(flightID);
                    flight.setFlightCode(flightCode);
                    flight.setDepartureDate(departureDate);
                    flight.setActive(active);

                    list.add(flight);
                }
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Flights List is error!! " + ex.getMessage());
            ex.printStackTrace();
        }

        return list;
    }

    public FlightsDTO load(Integer id) {

        String sql = " select flightID,flightCode,departureDate,departureAirport,ArrivalAirport,flightTime,airlineID,active "
                + " from Flights "
                + " where flightID = ? ";
        FlightsDTO flight = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String flightCode = rs.getString("flightCode");
                Date departureDate = rs.getDate("departureDate");
                String departureAirport = rs.getString("departureAirport");
                String arrivalAirport = rs.getString("ArrivalAirport");
                Time flightTime = rs.getTime("flightTime");
                String airlineID = rs.getString("airlineID");
                int active = rs.getInt("active");
                flight = new FlightsDTO();

                flight.setFlightID(id);
                flight.setFlightCode(flightCode);
                flight.setDepartureDate(departureDate);
                flight.setDepartureAirport(departureAirport);
                flight.setArrivalAirport(arrivalAirport);
                flight.setFlightTime(flightTime);
                flight.setAirlineID(airlineID);
                flight.setActive(active);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Flights Load is error!! " + ex.getMessage());
            ex.printStackTrace();
        }
        return flight;
    }

    public boolean update(FlightsDTO flight) {

        String sql = " update Flights set flightCode=?,departureDate=?,departureAirport=?,ArrivalAirport=?,"
                + "flightTime=?,airlineID=?,active=? "
                + "where flightID = ? ";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, flight.getFlightCode());
            ps.setDate(2, flight.getDepartureDate());
            ps.setString(3, flight.getDepartureAirport());
            ps.setString(4, flight.getArrivalAirport());
            ps.setTime(5, flight.getFlightTime());
            ps.setString(6, flight.getAirlineID());
            ps.setInt(7, flight.getActive());
            ps.setInt(8, flight.getFlightID());

            ps.executeUpdate();

            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Update Flight is error!! " + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(Integer id) {

        String sql = " update Flights set active = 0 where flightID = ? ";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Delete flight  is error!! " + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public Integer insert(FlightsDTO flight) {

        String sql = " insert into Flights(flightID, flightCode, departureDate,"
                + " departureAirport, ArrivalAirport, flightTime, airlineID,active) "
                + " values (?,?,?,?,?,?,?,?) ";
        int newId = getMaxId() + 1; // Tăng lên 1 để tạo ID mới
        flight.setFlightID(newId);
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, flight.getFlightID());
            ps.setString(2, flight.getFlightCode());
            ps.setDate(3, flight.getDepartureDate());
            ps.setString(4, flight.getDepartureAirport());
            ps.setString(5, flight.getArrivalAirport());
            ps.setTime(6, flight.getFlightTime());
            ps.setString(7, flight.getAirlineID());
            ps.setInt(8, flight.getActive());

            ps.executeUpdate();

            con.close();
            return flight.getFlightID();
        } catch (SQLException ex) {
            System.out.println("Update flight  is error!! " + ex.getMessage());
            ex.printStackTrace();
        }

        return null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(flightID) AS MaxID FROM Flights";
        int maxId = 0; // Giá trị mặc định

        try (Connection con = DBUtils.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                maxId = rs.getInt("MaxID"); // Lấy ID lớn nhất
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching max flight ID: " + ex.getMessage());
            ex.printStackTrace();
        }

        return maxId;
    }

    public List<FlightsDTO> chooseFlightList(String departureAirport, String arrivalAirport, Date departureDate) {
        List<FlightsDTO> list = new ArrayList<>(); // Khởi tạo danh sách
        String sql = "SELECT "
                + "    f.flightID, "
                + "    f.flightCode, "
                + "    f.departureAirport, " // Tên sân bay khởi hành
                + "    f.arrivalAirport, " // Tên sân bay đến
                + "    f.flightTime, f.departureDate, "
                + "    a.airlineName " // Tên hãng hàng không
                + "FROM "
                + "    Flights f "
                + "JOIN "
                + "    Airline a ON f.airlineID = a.airlineID " // Kết nối với bảng Airline
                + "WHERE "
                + "    f.active = 1 and departureAirport= ? and arrivalAirport=? and f.departureDate = ? ;"; // Chỉ lấy các chuyến bay đang hoạt động

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, departureAirport);
            ps.setString(2, arrivalAirport);
            ps.setDate(3, departureDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FlightsDTO flight = new FlightsDTO();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setFlightCode(rs.getString("flightCode"));
                flight.setDepartureAirport(rs.getString("departureAirport"));
                flight.setArrivalAirport(rs.getString("arrivalAirport"));
                flight.setFlightTime(rs.getTime("flightTime"));
                flight.setAirlineID(rs.getString("airlineName"));
                flight.setDepartureDate(rs.getDate("departureDate"));
                list.add(flight);
            }
        } catch (SQLException ex) {
            System.out.println("Choose Flights List Load is error!! " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

    public List<FlightsDTO> chooseFlightSearch(String departureAirport, String arrivalAirport, Date departureDate, String keyword) {
        List<FlightsDTO> list = new ArrayList<>(); // Khởi tạo danh sách
        String sql = "SELECT "
                + "    f.flightID, "
                + "    f.flightCode, "
                + "    f.departureAirport, " // Tên sân bay khởi hành
                + "    f.arrivalAirport, " // Tên sân bay đến
                + "    f.flightTime, f.departureDate, "
                + "    a.airlineName " // Tên hãng hàng không
                + "FROM "
                + "    Flights f "
                + "JOIN "
                + "    Airline a ON f.airlineID = a.airlineID " // Kết nối với bảng Airline
                + "WHERE "
                + "    f.active = 1 AND f.departureAirport = ? AND f.arrivalAirport = ? AND f.departureDate = ?";

        // Nếu keyword không rỗng hoặc null, thêm điều kiện tìm kiếm theo airlineID
        if (keyword != null && !keyword.isEmpty()) {
            sql += " AND f.airlineID = ?";
        }

        try (Connection con = DBUtils.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, departureAirport);
            ps.setString(2, arrivalAirport);
            ps.setDate(3, departureDate);

            // Gán giá trị cho tham số `keyword` nếu nó không rỗng hoặc null
            if (keyword != null && !keyword.isEmpty()) {
                ps.setString(4, keyword);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FlightsDTO flight = new FlightsDTO();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setFlightCode(rs.getString("flightCode"));
                flight.setDepartureAirport(rs.getString("departureAirport"));
                flight.setArrivalAirport(rs.getString("arrivalAirport"));
                flight.setFlightTime(rs.getTime("flightTime"));
                flight.setAirlineID(rs.getString("airlineName"));
                flight.setDepartureDate(rs.getDate("departureDate"));
                list.add(flight);
            }
            
        } catch (SQLException ex) {
            System.out.println("Choose Flights List Load is error!! " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

}
