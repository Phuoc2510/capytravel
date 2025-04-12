package capytravel.airport;

import capytravel.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO implements Serializable {

    public List<AirportDTO> list() {
        List<AirportDTO> list = new ArrayList<>();
        String sql = "SELECT airportID, airportName, location, status FROM Airport";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String airportID = rs.getString("airportID");
                String airportName = rs.getString("airportName");
                String location = rs.getString("location");
                int status = rs.getInt("status");

                AirportDTO airport = new AirportDTO();
                airport.setAirportID(airportID);
                airport.setAirportName(airportName);
                airport.setLocation(location);
                airport.setStatus(status);

                list.add(airport);
            }
        } catch (Exception e) {
            System.out.println("Error in list method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return list;
    }

    public AirportDTO load(String id) {
        AirportDTO airport = null;
        String sql = "SELECT airportID, airportName, location, status FROM Airport";
        sql += " WHERE airportID = ? ";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String airportID = rs.getString("airportID");
                String airportName = rs.getString("airportName");
                String location = rs.getString("location");
                int status = rs.getInt("status");

                airport = new AirportDTO();
                airport.setAirportID(airportID);
                airport.setAirportName(airportName);
                airport.setLocation(location);
                airport.setStatus(status);

            }
        } catch (Exception e) {
            System.out.println("Error in list method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return airport;
    }

    public List<AirportDTO> search(String id) {
        List<AirportDTO> list = new ArrayList<>();
        String sql = " SELECT airportID, airportName, location, status FROM Airport ";
        sql += " WHERE airportName LIKE ? OR location LIKE ?";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + id.trim() + "%");
            stmt.setString(2, "%" + id.trim() + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String airportID = rs.getString("airportID");
                String airportName = rs.getString("airportName");
                String location = rs.getString("location");
                int status = rs.getInt("status");

                AirportDTO airport = new AirportDTO();
                airport.setAirportID(airportID);
                airport.setAirportName(airportName);
                airport.setLocation(location);
                airport.setStatus(status);

                list.add(airport);
            }
        } catch (Exception e) {
            System.out.println("Error in search method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(AirportDTO airport) {
        String sql = "UPDATE Airport SET airportName = ?, location = ?, status = ? WHERE airportID = ?";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, airport.getAirportName());
            stmt.setString(2, airport.getLocation());
            stmt.setInt(3, airport.getStatus());
            stmt.setString(4, airport.getAirportID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error in update method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(AirportDTO airport) {
        String sql = "INSERT INTO Airport(airportID, airportName, location, status) VALUES(?, ?, ?, ?)";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, airport.getAirportID());
            stmt.setString(2, airport.getAirportName());
            stmt.setString(3, airport.getLocation());
            stmt.setInt(4, airport.getStatus());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error in insert method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = " UPDATE Airport SET status = 0 WHERE airportID = ? ";
        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error in delete method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return false;
    }

    public AirportDTO searchLocationToBooking(String id) {
        AirportDTO airport = null;
        String sql = " SELECT airportID, airportName, location, status FROM Airport ";
        sql += " WHERE airportID = ? ";

        try (
                Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String airportID = rs.getString("airportID");
                String airportName = rs.getString("airportName");
                String location = rs.getString("location");
                int status = rs.getInt("status");

                airport = new AirportDTO();
                airport.setAirportID(airportID);
                airport.setAirportName(airportName);
                airport.setLocation(location);
                airport.setStatus(status);

            }
        } catch (Exception e) {
            System.out.println("Error in search method at AirportDAO: " + e.toString());
            e.printStackTrace();
        }
        return airport;
    }

}
