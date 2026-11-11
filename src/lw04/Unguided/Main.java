package lw04.Unguided;
import java.util.Scanner;

public class Main {
    static int steps;

    static void sortParcel(int[] a, int from, int to){
        int n = a.length;

        for (int i = from; i < to; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (a[j] < a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    static int findParcel(int[] a, int target){
        int low = 0;
        int high = a.length - 1;
        steps = 0;

        while (low <= high){
            int mid = (low + high) / 2;
            steps++;

            if (a[mid] == target){
                return mid;
            } else if (target < a[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    static void printShelf(int[] a){
        for (int i = 0; i < a.length; i++){
            if (i > 0){
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = sc.nextInt();
        int[] parcels = new int[n];
        for (int i = 0; i < n; i++){
            parcels[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] req = new int[m];
        for (int i = 0; i < m; i++){
            req[i] = sc.nextInt();
        }

        sc.close();

        sortParcel(parcels, 0, 2);

        int[] battery = new int[n];
        for (int i = 0; i < n; i++){
            battery[i] = parcels[i];
        }

        sortParcel(parcels, 2, n - 1);

        System.out.println("==== After 2 Passes ====");
        printShelf(battery);
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        printShelf(parcels);
        System.out.println();

        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++){
            int pos = findParcel(parcels, req[i]);
            if (pos != -1){
                System.out.println(req[i] + ": FOUND at index " + pos + " (steps: " + steps + ")");
            } else {
                System.out.println(req[i] + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
}