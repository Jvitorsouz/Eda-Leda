import java.util.Scanner;

class WarmUp{


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");

        System.out.println(warmUp(entrada, n));
    }

    public static String warmUp(String[] v, int n){
        String seq = "";
        for(int i=0; i<v.length; i++){
            int number = Integer.parseInt(v[i]);
            seq += (number * n) + " ";
        }

        
        return seq.trim();
    }
}