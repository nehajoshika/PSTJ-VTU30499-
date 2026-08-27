import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    public boolean matches(String word, String pattern) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (map.containsKey(p)) {
                if (map.get(p) != w) {
                    return false;
                }
            } else {
                if (used.contains(w)) {
                    return false;
                }

                map.put(p, w);
                used.add(w);
            }
        }

        return true;
    }
}
Output:
Input
words =
["abc","deq","mee","aqq","dkd","ccc"]
pattern =
"abb"
Output
["mee","aqq"]
Expected
["mee","aqq"]