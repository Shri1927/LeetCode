import java.util.Arrays;

public class day_09_minProductDistributed {
    
    static int minimizedMaximum(int n, int quntities[]){
        int ans = -1;
        int start = 1;
        int end = Integer.MIN_VALUE;

        for(int i=0; i<quntities.length; i++){
            if(quntities[i] > end){
                end = quntities[i];  
            }
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isDistributionValid(quntities, mid, n)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    static boolean isDistributionValid(int quntities[], int maxquntities, int distribtion){

        int currDistribution = 0;
        for(int i=0; i<quntities.length; i++){
            currDistribution += quntities[i]/maxquntities;
            if(quntities[i] % 2 != 0){
                currDistribution += 1;
            }

            if(currDistribution > distribtion) return false;
        }

        return true;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        if(stalls.length < k){
            return -1;
        }
        Arrays.sort(stalls);
        int ans = -1;
        int start = 1;
        int end = stalls[stalls.length-1] - stalls[0];
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isAllocationPossible(stalls, mid, k)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return ans;
    }
    
    static boolean isAllocationPossible(int stalls[], int minDistance, int cows){
        int cowsCount = 1;
        int prevCowdist = stalls[0];
        
        for(int i=0; i<stalls.length; i++){
            if(stalls[i] - prevCowdist >= minDistance){
                cowsCount += 1;
                prevCowdist = stalls[i];
            }
            
            if(cowsCount >= cows){
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {6, 7, 9, 11, 13, 15};
        int res = aggressiveCows(arr, 4);
        System.out.println(res);
    }
}
