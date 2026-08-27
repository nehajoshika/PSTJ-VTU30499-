import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
    int current = arr.get(0);
    int maxSub = arr.get(0);

    int maxElement = arr.get(0);
    int positiveSum = 0;

    for (int i = 0; i < arr.size(); i++) {

        if (arr.get(i) > 0) {
            positiveSum += arr.get(i);
        }

        maxElement = Math.max(maxElement, arr.get(i));

        if (i > 0) {
            current = Math.max(arr.get(i), current + arr.get(i));
            maxSub = Math.max(maxSub, current);
        }
    }

    int maxSequence = positiveSum > 0 ? positiveSum : maxElement;

    return Arrays.asList(maxSub, maxSequence);
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
OUtput: Compiler Message
Success
Input (stdin)
2
4
1 2 3 4
6
2 -1 2 3 4 -5
Expected Output
10 10
10 11