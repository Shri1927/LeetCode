public class matrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(n,matrix);

        // Reverse rows
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    static void rotateby90(int mat[][]) {
        int n = mat.length;
        transpose(n,mat);

       // row swapping
       for(int i=0; i<n/2; i++){
           for(int j=0; j<n; j++){
               int temp = mat[i][j];
               mat[i][j] = mat[n-1-i][j];
               mat[n-1-i][j] = temp;
           }
       }
   }

    static void swap(int matrix[][], int i, int j){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i] = temp;
    }
    
    static void transpose(int n, int mat[][]) {
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                swap(mat,i,j);
            }
        }
    }

    
   
}
