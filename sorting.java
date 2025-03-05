public class sorting {
    
    public static void main(String[] args) {
        int arr[] = {2,7,1,5,4,6,3,0};
        printArray(arr,"original array");
        int res[] = countingSort(arr);
        printArray(res,"sorted array");
    }

    public static void printArray(int arr[], String msg) {

        System.out.println("Printing " + msg);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(",");
            }
        }
        System.out.println();
        
    }

    public static void ascinsertionSort(int arr[]) {
         
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;

            //Shifting logic
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }

            //placing element at j+1
            arr[j+1] = key;
        }
    }
    public static void descinsertionSort(int arr[]) {
        
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;

            //Shifting logic
            while(j>=0 && arr[j]<key){
                arr[j+1] = arr[j];
                j--;
            }

            //placing element at j+1
            arr[j+1] = key;
        }
    }

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for(int i=0;i<n;i++){

            int minEl = arr[i];
            int minidx = i;
            for(int j=i+1; j<n; j++){

                if(arr[j]<minEl){
                    minEl = arr[j];
                    minidx = j;
                }
            }

            swap(arr,i,minidx);
        }
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        int passes = n-2;  // Passes
        for(int i=0;i<=n-2;i++){
            boolean flag = false;
            for(int j=0; j<=n-2-i; j++){ // pairs
                if(arr[j]<arr[j+1]){
                    swap(arr, j, j+1); // Swapping
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("No swaps \n __________________________________");
                break;
            }
            printArray(arr,"Array after psss "+i);
        }
        
    }

    public static void brickSort(int arr[]) {
        int n = arr.length;
        int passes = n-2;
        boolean isSorted = false;
        while(!isSorted){
            boolean flag = false;
            // enven indes pairs swap
            for(int i=0; i<=passes; i+=2){
                if(arr[i]>arr[i+1]){
                    swap(arr, i, i+1);
                    flag = true;
                }
            }
            // odd indes pairs swap
            for(int i=1; i<=passes; i+=2){
                if(arr[i]>arr[i+1]){
                    swap(arr, i, i+1);
                    flag = true;
                }
            }

            if(!flag){
                isSorted = true;
            }
        }
    }

    public static int[] countingSort(int arr[]){
        // find k
        int k = Integer.MIN_VALUE;
        int n = arr.length;
        int sortedArr[] = new int[n];

        for(int i=0;i<n;i++){
           if(arr[i] > k){
             k = arr[i];
           }
        }

        if(k == Integer.MIN_VALUE){
            System.out.println("Empty Value");
            return sortedArr;
        }

        // counting Frequency
        int count[] = new int[k+1];
        for(int i=0; i<n; i++){
            int idx = arr[i];
            count[idx]+=1;
        }

        // updating frequency
        for(int i=1; i<=k; i++){
            count[i]+=count[i-1];
        }

        // Arranging
        for(int i=n-1; i>=0; i--){
            int val = arr[i];
            int countVal = --count[val];
            sortedArr[countVal] = val;

        }

        return sortedArr;
    }

    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
