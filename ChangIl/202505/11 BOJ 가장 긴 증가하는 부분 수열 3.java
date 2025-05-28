import java.io.*;
import java.util.*;

class Main{

    public static int binarySearch(int[] arr, int high, int val){
        int low = 0;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < val){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cpArr = new int[n];
        int length = 1;
        cpArr[0] = arr[0];

        for (int i = 1 ; i < n ; i ++){
            int index = binarySearch(cpArr, length, arr[i]);
            if (index == length){
                cpArr[length++] = arr[i];
            }else{
                cpArr[index] = arr[i];
            }
        }
        System.out.println(length);
    }

    /*
    가장 긴 증가하는 수열 문제 (lis)
    * 최장 수열의 길이만 출력해도 됨 : 배열 정보 기억할 필요 없음
    * 새로운 배열을 만들어서 그 index를 찾고 하는 방식 기억하제?

     */
}