package uni.fmi.service.reserve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.joda.time.format.DateTimeFormat;
import uni.fmi.models.AvailableHour;
import uni.fmi.models.Reservation;
import uni.fmi.models.Role;
import uni.fmi.models.User;

public class ReserveService {
	private static List<Role> adminRoleDb = Collections.singletonList(
			new Role("Dentist")
		);
	private static List<Role> patientRoleDb = Collections.singletonList(
			new Role("Patient")
		);
	private static List<Role> receptionistRoleDb = Collections.singletonList(
			new Role("Receptionist")
		);
	private static List<User> dentistDb = Collections.singletonList(
			new User("Ivan", "Dimitrov", "idimitrov@mail.bg", "0895553214")
		);
	private static List<User> patientDb = Collections.singletonList(
		new User("Georgi", "Petrov", "gpetrov@mail.bg", "0896667779")
	);
	private static List<User> receptionistDb = Collections.singletonList(
			new User("Gergana", "Stoyanova", "gstoyanova@mail.bg", "0896661119")
		);
	private static List<AvailableHour> availableHourDb = Collections.singletonList(
			new AvailableHour("10-02-2022", "12:30:00", "10-02-2022", "14:30:00", dentistDb.get(0))
		);
	
	public static String MakeAppintment(String requestedDate, String requestedHour, User user) {
		
		if(null == requestedDate && null == requestedHour && user == null) {
			return "Missing input data";
		}
		
		else if (null == requestedDate || null == requestedHour) {
			return "Enter date and hour";
		}
		
		else if(user == null) {
			return "Enter user credentials";
		}
		
		else if(user.getRole() == null) {
			return "Enter user role";
		}
		
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		boolean isValid = false;
		
		String err = "ok";
		
		Date AHFromDate = new Date();
		
		try {
			String date = availableHourDb.get(0).getFromDate() + " " + availableHourDb.get(0).getFromHour();
			AHFromDate = simpleDateFormat.parse(date);
		} catch (ParseException e2) {
			e2.printStackTrace();
			err = "1. " + e2.getMessage() + "\n";
		}
		
		Date AHToDate = new Date();
		
		try {
			AHToDate = simpleDateFormat.parse(availableHourDb.get(0).getToDate() + " " +
					availableHourDb.get(0).getToHour());
		} catch (ParseException e1) {
			e1.printStackTrace();
			err += "2. " + e1.getMessage() + "\n";
		}
		
		Date RRequestedDate = new Date();
		
		
		try {
			RRequestedDate = simpleDateFormat.parse(requestedDate + " " +
					requestedHour);
		} catch (ParseException e) {
			e.printStackTrace();
			err += "3. " + e.getMessage() + "\n";
		}
		
		if((RRequestedDate.after(AHFromDate) || RRequestedDate.equals(AHFromDate)) && 
				(RRequestedDate.before(AHToDate) || RRequestedDate.equals(AHToDate))) {
			isValid = true;
			Random rand = new Random();
			String requestNumber = String.format("%04d%n", rand.nextInt(10000));
			Reservation reservation = new Reservation(requestNumber, requestedDate, requestedHour, user);
		}
		
		if(user.getRole().getUserRole() == "Dentist") {
			return isValid ? "Success" : "Incorrect data - " + err;
		}
		else if(user.getRole().getUserRole() == "Receptionist") {
			return isValid ? "Success" : "Incorrect data - " + err;
		}
		else if(user.getRole().getUserRole() == "Patient") {
			return isValid ? "Success - Email sent" : "Incorrect data - " + err;
		}
		else {
			return "Enter user role";
		}
	}
	
}
