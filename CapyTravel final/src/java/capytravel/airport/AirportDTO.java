/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.airport;

import java.io.Serializable;

/**
 *
 * @author a
 */
public class AirportDTO implements Serializable{
    private String airportID;
    private String airportName;
    private String location;
    private int status;

    public AirportDTO() {
    }

    public AirportDTO(String airportID, String airportName, String location, int status) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.location = location;
        this.status = status;
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    
    
}