import java.util.Arrays;
import java.util.Scanner;

public class WinOrLose {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nos = scan.nextInt();
		for(int i = 0 ; i < nos; i++) {
			int playerNo = scan.nextInt();
			scan.nextLine();
			String[] villain = scan.nextLine().split(" ");
			String[] player = scan.nextLine().split(" ");
			
			if(villain.length != player.length || playerNo != villain.length) {
				System.out.println("LOSE");
				continue;
			}
			int[] villainStrength = new int[playerNo];
			int[] playerStrength = new int[playerNo];
			int j = 0;
			for(String s : villain) {
				villainStrength[j] = Integer.parseInt(s);
				j++;
			}
			j=0;
			for(String s : player) {
				playerStrength[j] = Integer.parseInt(s);
				j++;
			}
			predict(villainStrength, playerStrength);
		}
		
	}

	private static void predict(int[] villain, int[] player) {
		Arrays.sort(villain);
		Arrays.sort(player);
		int cnt = 0;
		for(int i : player) {
			if(i <= villain[cnt++]) {
				System.out.println("LOSE");
				return;
			}
		}
		System.out.println("WIN");
	}

	

}
