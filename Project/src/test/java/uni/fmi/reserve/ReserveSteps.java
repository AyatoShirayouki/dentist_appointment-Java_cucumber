package uni.fmi.reserve;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.models.Role;
import uni.fmi.reserve.model.ReserveScreenModel;

public class ReserveSteps {
	private ReserveScreenModel model;
	
	@Given("^User opens the reservation window$")
	public void user_opens_the_reservation_window() throws Throwable {
	    model = new ReserveScreenModel();
	}

	@When("^Enters valid date$")
	public void enters_valid_date() throws Throwable {
	    model.setRequestedDate("10-02-2022");
	}

	@When("^Enters valid hour$")
	public void enters_valid_hour() throws Throwable {
	    model.setRequestedHour("13:00:00");
	}

	@When("^Enters valid role$")
	public void enters_valid_role() throws Throwable {
	    model.setRole("Patient");
	}

	@When("^Enters valid user credentials$")
	public void enters_valid_user_credentials() throws Throwable {
	    model.setUser("Ivan", "Dimitrov", "idimitrov@mail.bg", "0895553214", model.getRole());
	}

	@When("^Presses the send button$")
	public void presses_the_send_button() throws Throwable {
	    model.clickReserveButton();
	}

	@Then("^Sees a success message$")
	public void sees_a_success_message() throws Throwable {
		if(model.getRole().getUserRole() == "Dentist") {
			assertEquals("Success", model.getMessage());
		}
		else if(model.getRole().getUserRole() == "Receptionist") {
			assertEquals("Success", model.getMessage());
		}
		else {
			assertEquals("Success - Email sent", model.getMessage());
		}
	}

	@Then("^Sees a missing date message$")
	public void sees_a_missing_date_message() throws Throwable {
		assertEquals("Enter date and hour", model.getMessage());
	}

	@Then("^Sees a missing hour message$")
	public void sees_a_missing_hour_message() throws Throwable {
		assertEquals("Enter date and hour", model.getMessage());
	}

	@Then("^Sees a missing input data message$")
	public void sees_a_missing_input_data_message() throws Throwable {
		assertEquals("Missing input data", model.getMessage());
	}
	
	@Then("^Sees a missing role message$")
	public void sees_a_missing_role_message() throws Throwable {
		assertEquals("Enter user role", model.getMessage());
	}

	@Then("^Sees a missing user credentials message$")
	public void sees_a_missing_user_credentials_message() throws Throwable {
		assertEquals("Enter user credentials", model.getMessage());
	}
}
