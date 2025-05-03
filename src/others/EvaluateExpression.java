package others;

/**
 * Evaluate an expression string with + and * without stack
 * e,g 12+23*40
 * @author abhradeep.kundu
 *
 */
public class EvaluateExpression {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Answer: " +calculate("12+23*40+25*8+20"));

	}
	
	static int calculate(String s) {
		int ans = 0;
		String[] splits = s.split("\\+");
		int[] subMul = new int[splits.length];
		int i = 0;
		for(String subStr : splits) {
			String[] mulSub = subStr.split("\\*");
			int innerMul = 1;
			for(String mul : mulSub) {
				innerMul *= Integer.parseInt(mul.trim());
			}
			subMul[i++] = innerMul;
		}
		for(int sum : subMul) {
			ans += sum;
		}
		
		return ans;
	}

}
