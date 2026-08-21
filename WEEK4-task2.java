import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();

            int[] left = new int[26];
            int[] right = new int[26];

            if (n % 2 == 0) {
                for (int i = 0; i < n / 2; i++) {
                    left[s.charAt(i) - 'a']++;
                }

                for (int i = n / 2; i < n; i++) {
                    right[s.charAt(i) - 'a']++;
                }
            } else {
                for (int i = 0; i < n / 2; i++) {
                    left[s.charAt(i) - 'a']++;
                }

                for (int i = n / 2 + 1; i < n; i++) {
                    right[s.charAt(i) - 'a']++;
                }
            }

            boolean lapindrome = true;

            for (int i = 0; i < 26; i++) {
                if (left[i] != right[i]) {
                    lapindrome = false;
                    break;
                }
            }

            if (lapindrome) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

6
gaga
abcde
rotor
xyzxy
abbaab
ababc