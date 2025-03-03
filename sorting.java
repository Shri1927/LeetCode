public class sorting {
    
    public static void main(String[] args) {
        int arr[] = {9,5,1,4,6,1};
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }

    public static void printArray(int arr[]) {

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
    }

    public static void insertionSort(int arr[]) {
        
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
}
