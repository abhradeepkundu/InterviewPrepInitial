package bookmyshow.models;

import java.util.List;

public class Hall {
	List<Seat> seats;
	List<Show> show;
	
	public Hall(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
