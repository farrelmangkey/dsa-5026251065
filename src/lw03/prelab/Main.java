package lw03.prelab;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String [] args){
        //problem 1
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List <String> playlist = new ArrayList<>();

        while (sc.hasNext()){
            String input = sc.next();

            if (input.equals("ADD")){
                String song = sc.nextLine();
                playlist.add(song);
            } else if (input.equals("INSERT")){
                int index = sc.nextInt();
                String song = sc.nextLine();
                playlist.add(index, song);
            } else {
                String song = sc.nextLine();
                playlist.remove(song);
            }

            

        }
        int angka = 1;
        System.out.println("==== Problem 1 ====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++){
            System.out.println(angka + ":" + playlist.get(i));
            angka++;
        }

        System.out.println();

        //problem 2
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set <String> participants = new LinkedHashSet<>();
        int duplicate = 0;
        while (sc2.hasNext()){
            String participant = sc2.nextLine();
            
            if (participants.contains(participant)){
                duplicate++;
            } else {
                participants.add(participant);
            }
        }

        int angka2 = 1;
        System.out.println("==== Problem 2 ====");
        System.out.println("Unique Participants: " + participants.size());
        for (String participant : participants){
            System.out.println(angka2 + ". " + participant);
            angka2++;
        }
        System.out.println("Duplicate registrations: " + duplicate);

        System.out.println();

        //problem 3
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map <String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0; 

        while (sc3.hasNext()){
            String input3 = sc3.next();

            if (input3.equals("ADD")){
                String item = sc3.next();
                int qty = sc3.nextInt();

                if(!inventory.containsKey(item)){
                inventory.put(item, qty);
                } else {
                    int currentQty = inventory.get(item);
                    inventory.put(item, currentQty + qty);
                }

            } else {
                String item = sc3.next();
                int qty = sc3.nextInt();
                int currentQty = inventory.getOrDefault(item, 0);

                if(inventory.containsKey(item) && currentQty >= qty){
                    inventory.put(item, currentQty - qty);
                } else {
                    failed++;
                }
            }
        }

        System.out.println("==== Problem 3 ====");
        for (String item : inventory.keySet()){
            System.out.println(item + ": " + inventory.get(item));
        }
        System.out.println("Failed sales: " + failed);
    }
}
