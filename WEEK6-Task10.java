import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;

class Result {

    static int[] odd;
    static int[] even;
    static int[] tree;
    static int[] leftBest;
    static int[] rightBest;

    static int n;
    static int size;

    // Manacher's Algorithm
    // type = 0 -> odd palindromes
    // type = 1 -> even palindromes
    static void manacher(char[] s, int m, int type) {

        int[] arr = (type == 0) ? odd : even;

        int i = 0;
        int j = 0;

        while (i < m) {

            while (i - j >= 0 &&
                   i + j + type < m &&
                   s[i - j] == s[i + j + type]) {
                j++;
            }

            arr[i] = j;

            int k = 1;

            while (k < j &&
                   arr[i - k] != arr[i] - k) {

                arr[i + k] =
                    Math.min(arr[i - k], arr[i] - k);

                k++;
            }

            i += k;
            j = Math.max(j - k, 0);
        }
    }

    // Segment tree range update
    static void updateTree(
            int node,
            int left,
            int right,
            int ql,
            int qr,
            int value) {

        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            tree[node] =
                Math.max(tree[node], value);
            return;
        }

        int mid = (left + right) / 2;

        updateTree(
            node * 2,
            left,
            mid,
            ql,
            qr,
            value
        );

        updateTree(
            node * 2 + 1,
            mid + 1,
            right,
            ql,
            qr,
            value
        );
    }

    // Process palindrome centered at pos
    static void process(int pos, int type) {

        int[] arr =
            (type == 0) ? odd : even;

        int radius = arr[pos];

        // Limit palindrome length to n
        int diff =
            radius * 2
            - (type == 0 ? 1 : 0)
            - n;

        if (diff > 0) {

            diff += diff & 1;

            radius -= diff / 2;
        }

        int left =
            pos - radius + 1;

        int right =
            pos + radius
            - (type == 0 ? 1 : 0);

        int length =
            radius * 2
            - (type == 0 ? 1 : 0);

        if ((type == 0 && radius > 1) ||
            (type == 1 && radius > 0)) {

            leftBest[left] =
                Math.max(
                    leftBest[left],
                    length
                );

            rightBest[right] =
                Math.max(
                    rightBest[right],
                    length
                );

            // Rotations where this palindrome fits
            int ql =
                Math.max(
                    0,
                    right - n + 1
                );

            int qr =
                Math.min(
                    n - 1,
                    left
                );

            if (ql <= qr) {

                updateTree(
                    1,
                    0,
                    size - 1,
                    ql,
                    qr,
                    length
                );
            }
        }
    }

    // Segment tree query
    static int queryTree(int position) {

        int node = position + size;

        int answer = 1;

        while (node > 0) {

            answer =
                Math.max(
                    answer,
                    tree[node]
                );

            node /= 2;
        }

        return answer;
    }

    public static List<Integer> circularPalindromes(String s) {

        n = s.length();

        /*
         * Duplicate the string so that
         * circular rotations become normal substrings.
         */
        String doubled =
            s + s.substring(0, n - 1);

        char[] chars =
            doubled.toCharArray();

        int m =
            2 * n - 1;

        odd =
            new int[m];

        even =
            new int[m];

        // Find all odd palindromes
        manacher(
            chars,
            m,
            0
        );

        // Find all even palindromes
        manacher(
            chars,
            m,
            1
        );

        // Build segment tree
        size = 1;

        while (size < n) {
            size *= 2;
        }

        tree =
            new int[size * 2];

        leftBest =
            new int[m];

        rightBest =
            new int[m];

        // Process all palindrome centers
        for (int i = 0; i < m; i++) {

            // Odd palindrome
            process(
                i,
                0
            );

            // Even palindrome
            process(
                i,
                1
            );
        }

        /*
         * Propagate palindrome lengths.
         * When moving one position away,
         * maximum palindrome length decreases by 2.
         */
        for (int i = 1; i < m; i++) {

            leftBest[i] =
                Math.max(
                    leftBest[i],
                    leftBest[i - 1] - 2
                );

            rightBest[m - i - 1] =
                Math.max(
                    rightBest[m - i - 1],
                    rightBest[m - i] - 2
                );
        }

        List<Integer> answer =
            new ArrayList<>();

        // Calculate answer for every rotation
        for (int i = 0; i < n; i++) {

            int best =
                queryTree(i);

            best =
                Math.max(
                    best,
                    leftBest[i]
                );

            best =
                Math.max(
                    best,
                    rightBest[i + n - 1]
                );

            answer.add(best);
        }

        return answer;
    }
}

public class Solution {

    public static void main(String[] args)
        throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(
                new InputStreamReader(System.in)
            );

        BufferedWriter bufferedWriter =
            new BufferedWriter(
                new FileWriter(
                    System.getenv("OUTPUT_PATH")
                )
            );

        int n =
            Integer.parseInt(
                bufferedReader
                    .readLine()
                    .trim()
            );

        String s =
            bufferedReader.readLine();

        List<Integer> result =
            Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

Output:
Compiler Message
Success
Input (stdin)
13
aaaaabbbbaaaa
Expected Output
12
12
10
8
8
9
11
13
11
9
8
8
10
