package others;

public class MatrixRotation {
	
	void rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length)
			return;
		
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++) {
			int begin = layer;
			int end = (n-1) - layer;
			for(int i = begin; i < end; i++) {
				int offset = i - begin;
				int top = matrix[begin][i];
				//left -> top
				matrix[begin][i] = matrix[end-offset][begin];
				//bottom->left
				matrix[end-offset][begin] = matrix[end][end-offset];
				//right->bottom
				matrix[end][end-offset]=matrix[i][end];
				//right->top
				matrix[i][end]=top;
			}
		}
	}
	
	//Transpose method of matrix rotation
	
	static void transpose(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length)
			return;
		int l = matrix.length;
		for(int i =0 ; i < l ; i++) {
			for(int j = i; j < l ; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	static void reverseColumns(int[][] matrix) {
		int l = matrix.length;
		for(int i = 0; i < l; i++) {
			for(int j= 0, k=l-1; j < k; j++, k--) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = temp;
			}
		}
	}
	// Function for print matrix 
    static void printMatrix(int arr[][]) 
    { 
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr[0].length; 
                 j++) 
                System.out.print(arr[i][j] + " "); 
            System.out.println(""); 
        } 
    } 
  
    // Function to anticlockwise rotate 
    // matrix by 90 degree 
    static void rotate90(int arr[][]) 
    { 
        transpose(arr); 
        printMatrix(arr); 
        reverseColumns(arr); 
    } 
	
	public static void main(String[] args) 
    { 
        int arr[][] = { { 1, 2, 3, 4 }, 
                        { 5, 6, 7, 8 }, 
                        { 9, 10, 11, 12 }, 
                        { 13, 14, 15, 16 } }; 
  
        rotate90(arr); 
        printMatrix(arr); 
    } 

}
