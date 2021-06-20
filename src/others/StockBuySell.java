package others;

public class StockBuySell {

	class Interval {
		public int buy;
		public int sell;
	};

	public void maximize(int price[], int n) {
		if (n == 1)
			return;

		int count = 0; // count of solution pairs

		// solution vector
		Interval sol[] = new Interval[n / 2 + 1];
		
		for(int i = 0; i < sol.length;  i++) {
			sol[i] = new Interval();
		}

		int i = 0;
		while (i < n - 1) {
			// Find Local Minima. Note that the limit is (n-2) as we are
			// comparing present element to the next element.
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			// If we reached the end, break
			// as no further solution possible
			if (i == n - 1)
				break;

			// Store the index of minima
			sol[count].buy = i++;

			// Find Local Maxima. Note that the limit is (n-1) as we are
			// comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			// Store the index of maxima
			sol[count].sell = i - 1;

			// Increment count of buy/sell pairs
			count++;
		}
		// print solution
		if (count == 0) {
			System.out.println("There is no day when buying");
		} else {
			for (int j = 0; j < count; j++) {
				System.out.println("Buy on day: " + sol[j].buy + " Sell on day: " + sol[j].sell);

			}
		}
	}
	
	public static void main(String[] args) {
		// stock prices on consecutive days 
	    int price[] = { 100, 180, 40, 310, 40, 535, 695 }; 
	    int n = price.length; 
	  
	    StockBuySell sbs = new StockBuySell();
	    sbs.maximize(price, n);
	}
}
