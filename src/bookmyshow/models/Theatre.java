package bookmyshow.models;

import java.util.List;

public class Theatre {
	List<Hall> halls;

	public Theatre(List<Hall> halls) {
		this.halls = halls;
	}

	public List<Hall> getHalls() {
		return halls;
	}
}
