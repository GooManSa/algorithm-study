````java
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] switchArr = new int[len+1];

        String switchState = br.readLine();
        StringTokenizer st = new StringTokenizer(switchState);

        for (int i = 1; i <= len; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int studentLen = Integer.parseInt(br.readLine());

        for(int i = 0; i < studentLen; i++){
            StringTokenizer active = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(active.nextToken());
            int number = Integer.parseInt(active.nextToken());

            if(gender == 1){
                for(int j = number; j <= len; j +=  number){
                    if(switchArr[j] == 1) switchArr[j] = 0;
                    else switchArr[j] = 1;
                }
            } else {
                if(switchArr[number] == 1) switchArr[number] = 0;
                else switchArr[number] = 1;

                int left = number - 1;
                int right = number + 1;

                while ((left > 0 && right <= len) && switchArr[left] == switchArr[right]) {
                    if(switchArr[left] == 1) switchArr[left] = 0;
                    else switchArr[left] = 1;

                    if(switchArr[right] == 1) switchArr[right] = 0;
                    else switchArr[right] = 1;

                    left--;
                    right++;
                }
            }

        }

        for (int i = 1;  i <= len; i++) {
            System.out.print(switchArr[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
````