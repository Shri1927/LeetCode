import java.util.Scanner;

public class TripExpenseEqualizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            double[] expenses = new double[n];
            double total = 0.0;

            for (int i = 0; i < n; i++) {
                expenses[i] = scanner.nextDouble();
                total += expenses[i];
            }

            double average = Math.floor((total / n) * 100) / 100;
            double positiveDiff = 0.0, negativeDiff = 0.0;

            // for (double expense : expenses) {
            //     double diff = expense - average;
            //     if (diff > 0) positiveDiff += diff;
            //     else negativeDiff -= diff;
            // }

            for(int i=0; i<expenses.length; i++){
                double diff = expenses[i] - average;
                if(diff > 0){
                    positiveDiff += diff;
                }else{
                    negativeDiff -= diff;
                }
            }

            System.out.printf("$%.2f%n", Math.min(positiveDiff, negativeDiff));
        }

        scanner.close();
    }
}