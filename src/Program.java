import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room Number:");
		int number = sc.nextInt();
		System.out.println("Check in Date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check Out Date (dd/MM/yyyy)");
		Date checKout = sdf.parse(sc.next());
		System.out.println();
		
		if(!checKout.after(checkIn)) {
			System.out.println("Error in reservation: Check-Out must be after check-in date");
			
		}else {
			Reservation reservation = new Reservation(number, checkIn, checKout);
			System.out.println(reservation);

			System.out.println();
			System.out.println("Enter data to upadte the reservation");
			System.out.println("Check in Date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check Out Date (dd/MM/yyyy)");
			checKout = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checKout);
			if(error !=null) {
				System.out.println("Error in reservation:" + error);
			}
			System.out.println("Reservartion " + reservation);
			
			
		}
		
		
		
		sc.close();

	}

}
