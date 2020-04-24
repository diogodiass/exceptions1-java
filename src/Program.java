import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		try {
			System.out.println("Room Number:");
			int number = sc.nextInt();
			System.out.println("Check in Date (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check Out Date (dd/MM/yyyy)");
			Date checKout = sdf.parse(sc.next());
			System.out.println();
	
			Reservation reservation = new Reservation(number, checkIn, checKout);
			System.out.println(reservation);
	
			System.out.println();
			System.out.println("Enter data to upadte the reservation");
			System.out.println("Check in Date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check Out Date (dd/MM/yyyy)");
			checKout = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checKout);
			System.out.println("Reservartion " + reservation);
		}
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch(DomainException e){
			System.out.println("Error in reservation: " + e.getMessage());
		}

		sc.close();

	}

}
