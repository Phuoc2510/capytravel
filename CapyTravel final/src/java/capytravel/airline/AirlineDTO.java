/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capytravel.airline;

import java.io.Serializable;

/**
 *
 * @author a
 */
public class AirlineDTO implements Serializable {

    private String airlineID;
    private String airlineName;
    private boolean airlineStatus;

    public AirlineDTO(String airlineID, String airlineName, boolean airlineStatus) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
        this.airlineStatus = airlineStatus;
    }

 

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public boolean isAirlineStatus() {
        return airlineStatus;
    }

    public void setAirlineStatus(boolean airlineStatus) {
        this.airlineStatus = airlineStatus;
    }

    public AirlineDTO() {
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AirlineDTO that = (AirlineDTO) obj;
        return airlineID != null && airlineID.equals(that.airlineID); // So sánh theo airlineID
    }

    @Override
    public int hashCode() {
        return airlineID != null ? airlineID.hashCode() : 0;
    }
    
}
