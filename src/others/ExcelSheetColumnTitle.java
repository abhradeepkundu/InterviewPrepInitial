package others;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(701));
		System.out.println(goodS(701));
	}

	public static String convertToTitle(int n) {
        int div = n;
        String s = "";
        while(div > 26) {
            int rem = div % 26;
            div = div / 26;
            if(rem==0) {
                div--;
            }
            s = convert(rem) + s;
        }
        s = convert(div%26) + s;
        return s;
    }
    
    public static String convert(int n) {
        String s="";
        switch(n) {
            case 1: {s= s+"A"; break;}
            case 2: {s= s+"B"; break;}  
                case 3: {s= s+"C"; break;}  
                case 4: {s= s+"D"; break;}  
                case 5: {s= s+"E"; break;}  
                case 6: {s= s+"F"; break;}  
                case 7: {s= s+"G"; break;}  
            case 8: {s= s+"H"; break;}  
                case 9: {s= s+"I"; break;}  
                case 10: {s= s+"J"; break;}  
                case 11: {s= s+"K"; break;}  
                case 12: {s= s+"L"; break;}  
                case 13: {s= s+"M"; break;}  
                case 14: {s= s+"N"; break;}  
                case 15: {s= s+"O"; break;}  
                case 16: {s= s+"P"; break;}  
                case 17: {s= s+"Q"; break;}  
                case 18: {s= s+"R"; break;}  
                case 19: {s= s+"S"; break;}  
                case 20: {s= s+"T"; break;}  
                case 21: {s= s+"U"; break;}  
                case 22: {s= s+"V"; break;}  
                case 23: {s= s+"W"; break;}  
                case 24: {s= s+"X"; break;}  
                case 25: {s= s+"Y"; break;} 
                case  0: {s= s+"Z"; break;}  
                
        }
        return s;
    }
    public static String goodS(int n) {
    	if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        n--;
        while (n >= 0) {
            sb.insert(0,  (char) ('A' + (n % 26)));
            n = (n / 26) - 1;
        }

        return sb.toString();
    }
}
