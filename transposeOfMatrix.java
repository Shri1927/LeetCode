public class transposeOfMatrix {

    // using extra space
    public int[][] transpose(int[][] matrix) {
        int [][] ans =new int [matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length ;i++){
            for(int j=0 ;j<matrix[i].length;j++){
                  ans[j][i]=matrix[i][j];
            }
        }
            return ans;
    }      


    //without using extra space
    public void swap(int matrix[][], int i, int j){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i] = temp;
    }
    
    public void transpose(int n, int mat[][]) {
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                swap(mat,i,j);
            }
        }
    }
} 