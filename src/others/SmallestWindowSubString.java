package others;

public class SmallestWindowSubString {
	static final int no_of_chars = 256;

	// Function to find smallest window containing
	// all characters of 'pat'
	static String findSubString(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();

		// check if string's length is less than pattern's
		// length. If yes then no such window can exist
		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}

		int hash_pat[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];

		// store occurrence ofs characters of pattern
		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		for (int i = 0; i < no_of_chars; i++)
			System.out.print(hash_pat[i]);

		System.out.println();
		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		// start traversing the string
		int count = 0; // count of characters
		for (int j = 0; j < len1; j++) {
			// count occurrence of characters of string
			hash_str[str.charAt(j)]++;

			// If string's char matches with pattern's char
			// then increment count
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;

			// if all the characters are matched
			if (count == len2) {
//				for (int i = 0; i < no_of_chars; i++)
//					System.out.print(hash_str[i]);
//
//				System.out.println();
				// Try to minimize the window i.e., check if
				// any character is occurring more no. of times
				// than its occurrence in pattern, if yes
				// then remove it from starting and also remove
				// the useless characters.
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
				System.out.println("j:" + j + " start_index:" + start_index + " length:" + len_window);
			}

		}

		// If no window found
		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		// Return substring starting from start_index
		// and length min_len
		return str.substring(start_index, start_index + min_len);
	}

	static void minWindow(String str, String pat) {
		int len = str.length();
		int len2 = pat.length();
		int small_window = Integer.MAX_VALUE;
		int start = 0;
		int start_index = -1;

		int count = 0;
		int[] hash_pat = new int[256];
		int[] hash_str = new int[256];

		for (int i = 0; i < len2; i++) {
			hash_pat[pat.charAt(i)]++;
		}

		for (int i = 0; i < len; i++) {
			char t = str.charAt(i);
			hash_str[t]++;

			if (hash_pat[t] > 0 && hash_pat[t] >= hash_str[t]) {
				count++;
			}
			if (count == len2) {
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {
					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
						hash_str[str.charAt(start)]--;
					}
					start++;
				}
				int len_window = i + 1 - start;
				if (len_window < small_window) {
					small_window = len_window;
					start_index = start;
				}

			}

		}
		if (start_index == -1) {
			System.out.println("No window exist");
		} else {
			System.out.println(str.substring(start_index, start_index + small_window));
		}
	}

	public static void main(String[] args) {
		String str = "this si a test sitistng";
		String pat = "tist";

		System.out.println("Smallest window is :\n " + findSubString(str, pat));
		System.out.println("Now it is my turn");
		minWindow(str, pat);
	}

}
