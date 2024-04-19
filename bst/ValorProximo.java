import java.util.Scanner;

public class ValorProximo {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        String[] entrada = sc.nextLine().split(" ");
        int n = sc.nextInt();


        for(String ent: entrada){
            int i = Integer.parseInt(ent);
            bst.add(i);
        }
    }
}
