import java.util.Scanner;

class BuscaBinaria{


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int key = sc.nextInt();
        System.out.println(buscaBinaria(entrada, 0, entrada.length-1, key));

    }

    public static String buscaBinaria(String[] v, int ini, int fim, int key){
        if(ini<=fim){
            int meio = (ini+fim)/2;
            if(Integer.parseInt(v[meio]) == key){
                return "" + meio;
            }

            if(key < Integer.parseInt(v[meio])){
                return meio + "\n" + buscaBinaria(v, ini, meio-1, key);
            }else{
                return meio + "\n" + buscaBinaria(v, meio+1, fim, key);
            }
        }else{
            return "-1";
        }
    }
}