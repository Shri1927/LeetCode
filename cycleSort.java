public class cycleSort {
 
    //[1....N]
    static void cycleSortt(int arr[]) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int actualPos = arr[index] - 1;
            if (arr[index] <= n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    //[0....N]
    static void cycleSort0toN(int arr[]) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int actualPos = arr[index];
            if (arr[index] < n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }

    static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static void cyclicSort(int arr[]){

        int n = arr.length;
        for(int cycles=0; cycles<n-1; cycles++){
            int pos = cycles;
            int item = arr[cycles];

            // finding smaller elements
            for(int i=cycles+1; i<n; i++){
                if(arr[i]<item){
                    pos++;
                }
            }

            // Element is at cooorect position
            if(pos == cycles){
                continue;
            }

            // Ignore Duplicates
            while(arr[pos] == item){
                pos++;
            }

            // swapping
            if(pos != cycles){
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }

            //check if more swaps are required
            while(pos != cycles){
                 pos = cycles;
                 for(int i=cycles+1; i<n; i++){
                    if(arr[i]<item){
                        pos++;
                    }
                }
            }

            // ignore duplicates
            while(arr[pos] == item){
                pos++;
            }

            if(item != arr[pos]){
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4, 5,0};
        cyclicSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }
    }
}
