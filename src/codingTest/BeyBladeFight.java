package codingTest;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BeyBladeFight {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);  
        String totalTestCase = sc.nextLine();
        String sizeOfPlayers = sc.nextLine();
        List<String> gRevPowerList = new ArrayList<String>();
        List<String> oppPowerList = new ArrayList<String>();
        
        int totalTCCount = Integer.parseInt(totalTestCase);
        
		for (int i = 0; i < totalTCCount; i++) {
			gRevPowerList.add(sc.nextLine());
			oppPowerList.add(sc.nextLine());
		}
		
		for (int i = 0; i < totalTCCount; i++) {
			String gRevPower = gRevPowerList.get(i);
			double[] gRevPowerArr = Stream.of(gRevPower.split(" "))
					.mapToDouble(token -> Double.parseDouble(token))
					.toArray();
			String oppPower = oppPowerList.get(i);
			double[] oppPowerArr = Stream.of(oppPower.split(" "))
					.mapToDouble(token -> Double.parseDouble(token))
					.toArray();

			solve(gRevPowerArr, oppPowerArr);
			
			
		}

	}

	private static void solve(double[] gRevPowerArr, double[] oppPowerArr) {
		Arrays.sort(gRevPowerArr);
		Arrays.sort(oppPowerArr);
		int maxWinC = 0;
		
		for (int i = 0; i < gRevPowerArr.length; i++) {
			int c = 0;
			int winC = 0;
			for (double power : oppPowerArr) {
				if (gRevPowerArr[c] > power) {
					winC++;
				}
				c++;
			}
			if (winC > maxWinC) {
				maxWinC = winC;
			}
			leftRotateByOne(gRevPowerArr);
		}
		System.out.println(maxWinC);
	}
	
	private static void leftRotateByOne(double arr[]) { 
         
        double temp = arr[0]; 
        for (int i = 0; i < arr.length - 1; i++)  {
        	arr[i] = arr[i + 1]; 
        }
        arr[arr.length - 1] = temp; 
    } 

}
