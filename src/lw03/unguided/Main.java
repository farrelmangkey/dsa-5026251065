package lw03.unguided;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Set <String> registrations = new LinkedHashSet<>();
        int total = 0;

        while (sc.hasNext()){
            String regist = sc.nextLine();
            if (!registrations.contains(regist)){
                registrations.add(regist);
                total++;
            }
        }

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        Map <String, String> checkins = new LinkedHashMap<>();
        int successCheckIn = 0;
        int rejected = 0;
        System.out.println("==== Event Check-In Results ====");

        while (sc2.hasNext()){
            String checkin = sc2.nextLine();
            if (checkins.containsKey(checkin)){
                checkins.put(checkin, "already checked in");
                System.out.println(checkin + ": Rejected (already checked in)");
                rejected++;
            } else {
                if (registrations.contains(checkin)){
                checkins.put(checkin, "Checked in");
                successCheckIn++;
                System.out.println(checkin + ": Checked in");
            } else {
                checkins.put(checkin, "Rejected (not registered)");
                rejected++;
                System.out.println(checkin + ": Rejected (not registered)");
            } 
            }
        }
        System.out.println();
        System.out.println("==== Final Event Summary ====");
        System.out.println("Registered Students: " + total);
        System.out.println("Successful Check-Ins: " + successCheckIn);
        System.out.println("Absent students: " + (total - successCheckIn));
        System.out.println("Rejected attempts: " + rejected);
        sc.close();
    }
}