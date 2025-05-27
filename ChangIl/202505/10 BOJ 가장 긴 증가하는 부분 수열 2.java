import java.io.*;
import java.util.*;

class Main{

    public static int binarySearch(int[] lis, int high, int val){
        int low = 0;

        while(low < high){
            int mid = (low + high)/2;

            if (lis[mid] < val) {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n];
        int high = 1;

        lis[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            int idx = binarySearch(lis,high,arr[i]);
            if (idx == high){
                lis[high++] = arr[i];
            }
            else {
                lis[idx] = arr[i];
            }
        }

        System.out.println(high);
    }

    /*
    n만큼 순회하며,

     */
}