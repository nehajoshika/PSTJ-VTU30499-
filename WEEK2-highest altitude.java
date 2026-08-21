class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];

            if (altitude > maxAltitude) {
                maxAltitude = altitude;
            }
        }

        return maxAltitude;
    }
}

output:
Accepted
Runtime: 0 ms
Case 1
Case 2
Input
gain =
[-5,1,5,0,-7]
Output
1
Expected
1