// tower of hanoi

class TOI
{
    static int c = 0;
    static void towerOfHanoi(int n, char from_rod,
                             char to_rod, char aux_rod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        c++;
        System.out.println("Move disk "+ n + " from rod " + from_rod +" to rod " + to_rod );
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
        System.out.println("counter is " + c);
    }
}
