// import java.util.Scanner;

// public class day_03_arrays {

//     static void printArray(int[] arr) {
//         for (int i = 0; i < arr.length; i++) {
//             System.out.println("Element at index " + i + " : " + arr[i]);
//         }
//     }

//     static void insertArray(int value[]){
//         int arr[] = new int[5];
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = value[i];
//         };
//         printArray(arr);
//     }

//     static void insertAtBeg(int arr[], int value, int pos){
//         for(int i=arr.length-2; i>=pos; i--){
//             arr[i+1] = arr[i];
//         }
//         arr[pos] = value;
//     }

//     static void delete(int arr[], int pos){
//         for(int i=pos; i<=arr.length-2; i++){
//             arr[i] = arr[i+1];
//         }
//         arr[arr.length-1] = 0;

//     }
    
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int arr[] = {2,4,5,8};
//         int value = 10;
//         printArray(arr);
//         delete(arr, 1);
//         System.out.println();
//         printArray(arr);
//     }
// }

public class day_03_arrays {

    static int secondLargest(int arr[]){
        int largest = 0;
        int secondLargest = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){ 
                largest = arr[i];
            }

            if(arr[i] > secondLargest && arr[i] < largest){
                secondLargest = arr[i];
            }
            
        }

        return secondLargest;
    }
    public static void main(String[] args) {
        int arr[] = {2,43,54,566,32,445,56,54,345};
        System.out.println(secondLargest(arr));
    }
}