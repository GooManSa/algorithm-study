import java.io.*;
import java.util.*;


class Main{



    public static int[] toInt(String pos){
        int[] p = new int[2];
        p[0] = pos.charAt(0) - 'A';
        p[1] = pos.charAt(1) - '1';
        return p;
    }

    public static String toStr(int[] pos){
        String p = "";
        p += (char) ('A' + pos[0]);
        p += Integer.toString(pos[1]+1);
        return p;
    }


    public static int[] nextMove(String move){
        int vert = 0;
        int hori = 0;

        switch(move){
            case "T":
                vert = 1;
                break;
            case "B":
                vert = -1;
                break;
            case "L":
                hori = -1;
                break;
            case "R":
                hori = 1;
                break;
            case "RT":
                vert = 1;
                hori = 1;
                break;
            case "RB":
                vert = -1;
                hori = 1;
                break;
            case "LB":
                vert = -1;
                hori = -1;
                break;
            case "LT":
                vert = 1;
                hori = -1;
                break;
        }

        int[] next = new int[2];
        next[0] = hori;
        next[1] = vert;
        return next;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kp = st.nextToken();
        String rp = st.nextToken();
        int[] k = toInt(kp);
        int[] r = toInt(rp);

        int moves = Integer.parseInt(st.nextToken());

        while(moves-->0){
            String move = br.readLine();
            int[] nm = nextMove(move);
            int nk0 = k[0] + nm[0];
            int nk1 = k[1] + nm[1];
            int nr0 = r[0] + nm[0];
            int nr1 = r[1] + nm[1];

            if (nk0 < 0 || nk0 >= 8 || nk1 < 0 || nk1 >= 8){
                continue;
            } else if (nk0 == r[0] && nk1 == r[1]){
                if (nr0 < 0 || nr0 >= 8 || nr1 < 0 || nr1 >= 8){
                    continue;
                } else {
                    k[0] = nk0;
                    k[1] = nk1;
                    r[0] = nr0;
                    r[1] = nr1;
                }
            } else {
                k[0] = nk0;
                k[1] = nk1;
            }
        }

        System.out.println(toStr(k));
        System.out.println(toStr(r));

    }

}

// 단순구현문제 -> 조건을 빡빡하게 구현하는 연습이 필요하다