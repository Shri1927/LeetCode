public class pigeonHoleSort {
    
    static void pigeonholeSort(int arr[]){

        int n = arr.length;
        int maxEl = Integer.MIN_VALUE;
        int minEL = Integer.MAX_VALUE;

        // Finding Min and Max
        for(int i=0; i<n; i++){
            if(arr[i] < minEL){
                minEL = arr[i];
            }

            if(arr[i] > maxEl){
                maxEl = arr[i];
            }
        }
 
        if(maxEl == Integer.MIN_VALUE || minEL == Integer.MAX_VALUE){
            return;
        }

        // Finding Count or Frequency
        int size = maxEl - minEL+1;
        int pigeonhole[] = new int[size];
        for(int i=0; i<n; i++){
            int idx = arr[i]-minEL;
            pigeonhole[idx]++;
        }

        // Arranging in sorted Order
        int insertidx = 0;
        for(int j=0; j<size; j++){
            while(pigeonhole[j]>0){  
            arr[insertidx] = j+minEL;
            insertidx++;
            pigeonhole[j]--;
            }
        }


    }

    
    public static void main(String[] args) {
        int arr[] = {24,22,25,22,21,27};
        pigeonholeSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print("["+arr[i]+"]");
        }
    }
}
