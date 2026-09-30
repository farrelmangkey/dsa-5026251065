package lw01.unguided;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        WashService[] wash = new WashService[16];

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("washes.txt"));

        int loop = scanner.nextInt();

        for (int i = 0; i < loop; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            if (type.equals("MOTORCYCLE")) {
                wash[i] = new MotorcycleWash(id, days);
            } else {
                wash[i] = new CarWash(id, days, units);
            }
        }

        for (int i = 0; i < wash.length; i++) {
            WashService service = wash[i];
            System.out.println(service.summary());
            
        }
    }
}
