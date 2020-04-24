package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer rooNumber;
	private Date  checkIn;
	private Date checKout;
	
	private static SimpleDateFormat sdf	 =  new SimpleDateFormat("dd/MM/yyyy");
		
	public Reservation(Integer rooNumber, Date checkIn, Date checKout) throws DomainException {
		  
		if (!checKout.after(checkIn)) {
			throw new DomainException("Error in reservation : Check-out date must be after");
		}
		this.rooNumber = rooNumber;
		this.checkIn = checkIn;
		this.checKout = checKout;
	}

	public Integer getRooNumber() {
		return rooNumber;
	}

	public void setRooNumber(Integer rooNumber) {
		this.rooNumber = rooNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChecKout() {
		return checKout;
	}

	private long duration() {
		long diff = checKout.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checKin, Date checkOut) throws DomainException {

		Date now = new Date();

		if (checkIn.before(now) || checKout.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future");
		}
		if (!checKout.after(checkIn)) {
			throw new DomainException("Error in reservation : Check-out date must be after");
		}
		this.checkIn = checKin;
		this.checKout = checkOut;
		
		
	}
	
	@Override
	public String toString() {
		return "Room"
				+ rooNumber
				+", check-in: "
				+sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checKout)
				+", "
				+duration()
				+" nights";
	}
	

}
