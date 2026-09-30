package lw02.Unguided;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("order.txt")
        );

        LinkedList <String[]> orders = new LinkedList<>();

        while (scanner.hasNext()){
            String name = scanner.next();
            String sideDish = scanner.next();
            String drink = scanner.next();
            int table = scanner.nextInt();

            String [] orderData = {name, sideDish, drink, String.valueOf(table)};
            orders.add(orderData);
        }

        scanner.close();

        LinkedList <String> stockData = new LinkedList<>();
        String dataBakso = "Bakso";
        int jumlahBakso = 2;

        String dataSate = "Sate";
        int jumlahSate = 1;

        String dataSoto = "Soto";
        int jumlahSoto = 2;

        stockData.add(dataBakso);
        stockData.add(String.valueOf(jumlahBakso));

        stockData.add(dataSate);
        stockData.add(String.valueOf(jumlahSate));

        stockData.add(dataSoto);
        stockData.add(String.valueOf(jumlahSoto));


        LinkedList <String> stockDrink = new LinkedList<>();

        String dataEsTeh = "Es Teh";
        int jumlahEsTeh = 4;
        
        String dataEsJeruk = "Es Jeruk";
        int jumlahEsJeruk = 2;

        stockDrink.add(dataEsTeh);
        stockDrink.add(String.valueOf(jumlahEsTeh));

        stockDrink.add(dataEsJeruk);
        stockDrink.add(String.valueOf(jumlahEsJeruk));

        Queue <String[]> transactions = new LinkedList<>(orders);
        Stack <String[]> failed = new Stack<>();

        while (!transactions.isEmpty()){
            String [] data = transactions.poll();

            String name = data [0];
            String food = data [1];
            String drink = data [2];
            int table = Integer.parseInt(data[3]);

            int menu = stockData.indexOf(food);
            int minum = stockDrink.indexOf(drink);
            int stockMenu = Integer.parseInt(stockData.get(menu + 1));
            int stockMinum = Integer.parseInt(stockDrink.get(minum + 1));

            if (food.equals("Bakso")){
                if (stockMenu >= 1){
                    int z = stockMenu -1;
                    stockData.set(menu + 1, String.valueOf(z));
                } else {
                    failed.push(data);
                }
                
            } else if (food.equals("Sate")){
                if (stockMenu >=1){
                    int z = stockMenu - 1;
                    stockData.set(menu + 1, String.valueOf(z));
                } else {
                    failed.push(data);
                }
            } else if (food.equals("Soto")){
                if (stockMenu >=1){
                    int z = stockMenu - 1;
                    stockData.set(menu + 1, String.valueOf(z));
                } else {
                    failed.push(data);
                }
            }

            if (drink.equals("Es Teh")){
                if(stockMinum >= 1){
                    int z = stockMinum - 1;
                    stockDrink.set(minum + 1, String.valueOf(z));
                } else {
                    failed.push(data);
                }
            } else {
                if (stockMinum >= 1){
                    int z = stockMinum - 1;
                    stockDrink.set(minum + 1, String.valueOf(z));
                } else {
                    failed.push(data);
                }
            }

        }

        System.out.println("=== Successfully Processed Orders ===");

        for (int i = 0; i < transactions.size(); i ++){
            String [] data1 = transactions.poll();
            
            System.out.println(data1[0] + " " + data1[1] + " " + data1[2] + " " + data1[3]);
        }

        System.out.println("=== Failed Orders ===");

        while(!failed.isEmpty()){
            String [] dataFailed = failed.pop();
            System.out.println(dataFailed[0] + " " + dataFailed[1] + " " + dataFailed[2] + " " + dataFailed[3]);
        }
    }
    
}

