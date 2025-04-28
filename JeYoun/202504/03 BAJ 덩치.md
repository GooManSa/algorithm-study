```JAVA
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        List<int[]> infos = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int caseNumber = Integer.parseInt(br.readLine());


        for (int i = 0; i < caseNumber; i++) {
            String[] info = br.readLine().split(" ");
            infos.add(new int[]{Integer.parseInt(info[0]), Integer.parseInt(info[1])});

        }

        for (int i = 0; i < caseNumber; i++) {
            int[] info = infos.get(i);
            int rank = 1;
            for (int j = 0; j < caseNumber; j++) {

                if( i == j ) continue;

                int[] info2 = infos.get(j);

                if(info[0] < info2[0] && info[1] < info2[1]) {
                    rank++;
                }
            }
            answer.add(rank);
        }

        for (int i = 0; i < answer.size() - 1; i++) {
            System.out.print(answer.get(i) + " ");
        }

        System.out.println(answer.get(answer.size() - 1));
    }
}
```