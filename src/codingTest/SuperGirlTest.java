package codingTest;

import java.util.Scanner;
import java.util.stream.Stream;

public class SuperGirlTest {

	public static void main(String args[] ) throws Exception {

    	//Write code here
        Scanner sc= new Scanner(System.in);  
        String totalCount= sc.nextLine();  
        String ingReqForPG = sc.nextLine();
        String ingAvailable = sc.nextLine();

        double[] ingReqForPGArr = Stream.of(ingReqForPG.split(" "))
                .mapToDouble(token -> Double.parseDouble(token))
                .toArray();
        double[] ingAvailableArr = Stream.of(ingAvailable.split(" "))
        		.mapToDouble(token -> Double.parseDouble(token))
                .toArray();
        int minNoPos = checkForMaxPGPossible(ingReqForPGArr, ingAvailableArr);
        System.out.println(minNoPos);

   }

	private static int checkForMaxPGPossible(double[] ingReqForPGArr, double[] ingAvailableArr) {
		if(ingReqForPGArr.length == 0 || ingAvailableArr.length == 0) {
			return 0;
		}
		int count = 0;
		double minNumber = Double.MAX_VALUE;
		for (double resReq : ingReqForPGArr) {
			double resAvail = ingAvailableArr[count];
			if(resReq == 0.0) continue;
			double noOfPG = resAvail / resReq;
			minNumber = Math.min(minNumber, noOfPG);
			count++;
		}
		return (int) minNumber;
	}
	
	
//	3 6 7 5 3 5 6 2 9 1 
//	2 7 0 9 3 6 0 6 2 6 
//	
//	9 7 6 6 5 5 3 3 2 1
//	9 7 6 6 6 3 2 2 0 0
}
