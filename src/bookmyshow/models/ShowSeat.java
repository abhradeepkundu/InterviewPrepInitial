package bookmyshow.models;

public class ShowSeat {
	enum SeatStatus {
		booked,
		processing,
		empty
	}
	
	SeatStatus status;
	Seat seat;

}
