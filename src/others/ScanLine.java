package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ScanLine {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
		int N = in.nextInt();
        for(int i = 0; i < N; i++) {
            int type = in.nextInt();
            int data = 0;
            if(type == 1) {
                data = in.nextInt();
            }
            stackOP(type, data);
        }
        in.close();
        List<Character> c = new ArrayList<Character>();
    }
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> maxStack = new Stack<Integer>();
    public static void stackOP(int type, int data) {
        switch(type) {
                case(1): {
                    stack.push(data);
                    if(maxStack.isEmpty() || data > maxStack.peek()) {
                        maxStack.push(data);
                    }  
                    break;
                }
                case(2): {
                    if(stack.isEmpty()) {
                        break;
                    } 
                    int stackData = stack.pop();
                    int max = maxStack.peek();
                    if(stackData == max) maxStack.pop();
                    break;
                }
                case(3): {
                    if(maxStack.isEmpty()) {
                        break;
                    }
                    System.out.println(maxStack.peek());
                    break;
                }
                default:
                    break;
        }
    }

}
