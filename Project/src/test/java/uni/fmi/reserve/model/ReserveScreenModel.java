package uni.fmi.reserve.model;

import uni.fmi.models.Role;
import uni.fmi.models.User;
import uni.fmi.service.reserve.ReserveService;;

public class ReserveScreenModel {
	private String requestedDate;
	private String requestedHour;
	private String message;
	private User user;
	private Role role;
	
	public void setRequestedDate(final String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public void setRequestedHour(final String requestedHour) {
		this.requestedHour = requestedHour;
	}
	
	public void setRole(final String roleName) {
		role = new Role(roleName);
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setUser(final String firstName, final String lastName, final String email, final String phoneNumber,
    		final Role role) {
		user = new User(firstName, lastName, email, phoneNumber);
		user.setRole(role);
    }
	
	public User getUser() {
		return this.user;
	}

	public void clickReserveButton() {
		message = ReserveService.MakeAppintment(requestedDate, requestedHour, user);

	}

	public String getMessage() {
		return message;
	}
}
