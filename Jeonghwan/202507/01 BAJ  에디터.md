```java
import java.util.*;
import java.io.*;

public class Main {

    public static class Editor{
        StringBuilder string = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        public Editor(String init) {
            string.append(init);
        }

        public void left() {
            Optional<Character> c = pop(string);
            if (!c.isEmpty()) {
                buffer.append(c.get());
            }
        }

        public void right() {
            Optional<Character> c = pop(buffer);
            if (!c.isEmpty()) {
                string.append(c.get());
            }
        }

        public void backSpace() {
            if (string.length() != 0) {
                string.deleteCharAt(string.length() - 1);
            }
        }

        public void input(String c) {
            string.append(c);
        }

        public void print() {
            string.append(buffer.reverse());
            System.out.println(string);
        }

        private Optional<Character> pop(StringBuilder sb) {
            if (sb.length() == 0) return Optional.empty();
            char ret = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            return Optional.of(ret);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String initString = br.readLine();
        int M = Integer.parseInt(br.readLine());


        Editor editor = new Editor(initString);
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            if ("L".equals(op)) {
                editor.left();
            } else if ("D".equals(op)) {
                editor.right();
            } else if ("B".equals(op)) {
                editor.backSpace();
            } else {
                String ch = st.nextToken();
                editor.input(ch);
            }
        }

        editor.print();
    }
}
å
```
