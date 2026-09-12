class ParkingSystem {
    int[] slots;
    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{big, medium, small};
    }
    public boolean addCar(int carType) {
        int index = carType - 1;
        if (slots[index] > 0) {
            slots[index]--;
            return true;
        }
        return false;
    }
}

Output:
Input
["ParkingSystem","addCar","addCar","addCar","addCar"]
[[1,1,0],[1],[2],[3],[1]]
Output
[null,true,true,false,false]
Expected
[null,true,true,false,false]