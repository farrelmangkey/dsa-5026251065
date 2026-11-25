package lw06.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();

        String data = read.nextLine();
        String [] arr = data.split(" ");
        for(String s : arr){
            bst.insert(Integer.parseInt(s));
        }   
        int target = read.nextInt();

        System.out.print("Preorder  : ");
        bst.preOrder();

        System.out.print("Inorder  : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Nodes : " + bst.countNodes());
        System.out.println("Leaves : " + bst.countLeaves());

        read.close();
    }
}
