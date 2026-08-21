import java.util.*;

public class test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Deque<Integer> deque = new ArrayDeque<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 0;

        for (int i = 0; i < n; i++) {

            int num = in.nextInt();

            deque.addLast(num);

            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);

            if (deque.size() > m) {

                int removed = deque.removeFirst();

                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0)
                    map.remove(removed);
            }

            if (deque.size() == m) {
                max = Math.max(max, map.size());
            }
        }

        System.out.println(max);
    }
}



Output:
Input (stdin)
6 3
5 3 5 2 3 2
Expected Output
3