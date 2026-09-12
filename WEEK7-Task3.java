import java.util.*;

class UndergroundSystem {

    // id -> check-in station and time
    HashMap<Integer, Pair> checkInMap;

    // route -> [total travel time, number of trips]
    HashMap<String, double[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        // Get customer's check-in information
        Pair checkIn = checkInMap.get(id);

        String startStation = checkIn.station;
        int startTime = checkIn.time;

        // Calculate travel time
        int travelTime = t - startTime;

        // Create route key
        String route = startStation + "," + stationName;

        // If route doesn't exist, create it
        if (!routeMap.containsKey(route)) {
            routeMap.put(route, new double[]{0, 0});
        }

        // Add travel time
        routeMap.get(route)[0] += travelTime;

        // Increase number of trips
        routeMap.get(route)[1]++;

        // Customer is no longer checked in
        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "," + endStation;

        double[] data = routeMap.get(route);

        double totalTime = data[0];
        double numberOfTrips = data[1];

        return totalTime / numberOfTrips;
    }

    // Helper class
    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

Output:
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]