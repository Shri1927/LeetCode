public class day_06_infiniteAarBS {
    
    static void findMinAbsDiff(int arr[], int target){
        int ans = -1;
        int res = 0;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                ans = mid;
                break;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(ans == -1){
            if(end == -1){
                res = Math.abs(arr[start]);
            }else if(start == arr.length){
                res = Math.abs(arr[end]);
            }else{
                int ans1 = Math.abs(target - arr[start]);
                int ans2 = Math.abs(target - arr[end]);
                res = Math.min(ans1, ans2);
            }
        }

        System.out.println(res);
    }

    static int[] findRangeinfiniteArr(int arr[], int target){
         int res[] = new int[2];
         int start = 0;
         int end = 1;

         while(arr[end] < target){
            start = end;
            end = 2 * end;
         }

        res[0] = start;
        res[1] = end;

        return res;
    }

    static void binarySearch(int arr[], int target, int range[]){
        int ans = -1;
        int start = range[0];
        int end = range[range.length-1];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                ans = mid;
                break;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(ans == -1){
            System.out.println("not found");
        }else{
            System.out.println("element found at index "+ans);
        }
    }

    static void findfirstOcc(int arr[], int taget, int start, int end){
         int ans = -1;
         while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == taget){
                ans = mid;
                end = end-1;
            }else if(arr[mid] < taget){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }

        if(ans == -1){
            System.out.println("not found");
        }else{
            System.out.println("element found at index "+ans);
        }
    }

    static void lastfirstOcc(int arr[], int taget, int start, int end){
        int ans = -1;
        while(start <= end){
           int mid = start + (end - start)/2;
           if(arr[mid] == taget){
               ans = mid;
               start = mid+1;
           }else if(arr[mid] < taget){
               start = mid + 1;
           }else{
               end = mid -1;
           }
       }

       if(ans == -1){
           System.out.println("not found");
       }else{
           System.out.println("element found at index "+ans);
       }
   }

    static void firstOneInArr(int arr[], int taget){
        int range[] = findRangeinfiniteArr(arr, taget);
        findfirstOcc(arr, taget, range[0], range[1]);
        lastfirstOcc(arr, taget, range[0], range[1]);
    }
    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0,1,1,1,1};
        // findMinAbsDiff(arr, 50);
        // int res[] = findRangeinfiniteArr(arr, 15);
        // System.out.println(res[0]+ ","+res[1]);
        // binarySearch(arr, 15 ,res);
        firstOneInArr(arr, 1);
    }
}
