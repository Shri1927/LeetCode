public class MinimumPagesAllocation {
    
    // Minimum Page Allocation to students
    static int minPageAllocation(int books[], int students){
        int res = -1;
        if(books.length < students){
            return -1;
        }
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i=0; i<books.length; i++){
            if(books[i] > start){
                start = books[i];
            }
            end += books[i];
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isAllocationPossible(books,mid,students)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

    static boolean isAllocationPossible(int books[], int maxPages, int students){
        int currStudCount = 1;
        int pages = 0;
        for(int i=0; i<books.length; i++){
            pages += books[i];
            if(pages > maxPages){
                currStudCount += 1;
                pages = books[i];
            }
            if(currStudCount > students){
                return false;
            }
        }
        return true;
    }

    // Capacity of Shipment
    static int dailyShipment(int packages[], int days){
        int res = -1;
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i=0; i<packages.length; i++){
            if(packages[i] > start){
                start = packages[i];
            }
                end += packages[i];
            
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isAllocationPossible(packages, mid, days)){
                res = mid;
                end = end -1;
            }else{
                start = mid +1;
            }
        }

        return res;
            
    }

    // Koko eating Bananas
    static int minEatingSpeed(int[] piles, int h) {
        int ans = -1;
        int start = 0;
        int end = Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++){
            if(piles[i] > end){
                end = piles[i];
            }
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isEatingspeedValid(piles, mid , h)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }

    static boolean isEatingspeedValid(int piles[], int eatingSpeed, int hours){
        int hoursSpent = 0;
        for(int i=0; i<piles.length; i++){
            hoursSpent += piles[i]/eatingSpeed;
            if(piles[i]%eatingSpeed != 0){
                hoursSpent += 1;
            }

            if(hoursSpent > hours) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int res = dailyShipment (arr, 5);
        System.out.println(res);
    }
}