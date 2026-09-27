package lw02.prelab;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main (String [] args){

        Scanner scanner = new Scanner(Main.class.getResourceAsStream ("transaction.txt"));

        LinkedList <String[]> transactions = new LinkedList<>();

        while (scanner.hasNext()){
            String name = scanner.next();
            String type = scanner.next();
            int amount = scanner.nextInt();

            String [] data = {name, type, String.valueOf(amount)};
            transactions.add(data);

        }

        LinkedList <String> customer = new LinkedList<>();

        for (int i = 0; i < transactions.size(); i++){
            String[] a = transactions.get(i);
            String customerName = a [0];

            if (!customer.contains(customerName)){
                customer.add(customerName);
                customer.add("0");
            }
        }

        Queue <String[]> transaction = new LinkedList<>(transactions);
        Stack <String[]> failedTransaction = new Stack<>();

        while (!transaction.isEmpty()){
            String [] data = transaction.poll();

            String name = data[0];
            String type = data[1];
            int amount = Integer.parseInt(data[2]);

            int index = customer.indexOf(name);

            int balance = Integer.parseInt(customer.get(index + 1));

            if (type.equals("DEPOSIT")){
                balance += amount;
                customer.set(index + 1, String.valueOf(balance));
            } else if (type.equals("WITHDRAW")){
                if (balance >= amount){
                    balance -= amount;
                    customer.set(index + 1, String.valueOf(balance));
                } else {
                    failedTransaction.push(data);
                }
            }
        }

        System.out.println("=== Final Balance ===");

        for (int i = 0; i < customer.size(); i += 2){
            System.out.print(customer.get(i) + " : " + customer.get(i+1));
            System.out.println();
        }

        System.out.println();

        System.out.println("=== Failed Transaction ===");

        while (!failedTransaction.isEmpty()){
            String[] data = failedTransaction.pop();
            System.out.println(data[0] + " " + data[1] + " " + data[2]);
        }

    }

}
