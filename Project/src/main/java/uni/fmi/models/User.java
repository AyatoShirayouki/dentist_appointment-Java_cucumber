package uni.fmi.models;

import java.util.Set;

public class User {

	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Role role;
    private Set<AvailableHour> availableHours;
    private Set<Reservation> reservations;
	
    public User(final String firstName, final String lastName, final String email, final String phoneNumber) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservation(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<AvailableHour> getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHour(Set<AvailableHour> availableHours) {
        this.availableHours = availableHours;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}