package uni.fmi.models;

import java.util.*;

public class Reservation {

	 private String ReservationNumber;
	 private String RequestedDate;
	 private String RequestedHour;
	 private AvailableHour availableHour;
	 private User owner;
	
    public Reservation(String ReservationNumber, String RequestedDate, String RequestedHour, User owner) {
    	this.ReservationNumber = ReservationNumber;
    	this.RequestedDate = RequestedDate;
    	this.RequestedHour = RequestedHour;
    	this.owner = owner;
    }

    public String getReservationNumber() {
       return ReservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.ReservationNumber = reservationNumber;
    }

    public String getRequestedDate() {
        return RequestedDate;
    }

    public String getRequestedHour() {
        return RequestedHour;
    }

    public void setRequestedDate(String fromDate) {
        this.RequestedDate = fromDate;
    }

    public void setRequestedHour(String fromHour) {
        this.RequestedHour = fromHour;
    }

    public AvailableHour getAvailableHour() {
        return availableHour;
    }
    
    public void setAvailableHour(AvailableHour availableHour) {
        this.availableHour = availableHour;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

}