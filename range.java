import java.util.Scanner;

public class range {

    static int range3to1(int n){
        int count = 1;
        while(n!=1){
            if(n%2 != 0){
                n = 3*n+1;
            }else{
                n=n/2;
            }
            count++;
        }
        
        return count;
    }

    static int fromitojRange(int i, int j){
        int start = Math.min(i, j);
        int end = Math.max(i, j);
        int maxLength = 0;

        for(int  num=start; num <= end; num++){
            maxLength = Math.max(maxLength, range3to1(num));
        }

        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the range of the Cycle : ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        int res = fromitojRange(i, j);
        System.out.println(i+ "\t"+j+"\t"+res);

    }
}