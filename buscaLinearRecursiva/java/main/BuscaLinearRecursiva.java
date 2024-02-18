import java.util.Arrays;
import java.util.Scanner;

class BuscaLinearRecursiva {

    public static void main(String[] args){
        BuscaLinearRecursiva busca = new BuscaLinearRecursiva();
        /* 
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(busca.buscaLinearRecursiva(v, 1, 0)); // 0
        System.out.println(busca.buscaLinearRecursiva(v, 10, 0)); // 9
        System.out.println(busca.buscaLinearRecursiva(v, 11, 0)); // -1*/

        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] v = Arrays.stream(entrada).mapToInt(Integer::parseInt).toArray();
        int key = sc.nextInt();
        System.out.println(busca.buscaLinearRecursiva(v, key, 0));
    }
 
    
    public int buscaLinearRecursiva(int[] v, int key, int idx){
        if(idx < v.length){
            if(v[idx] == key){
                return idx;
            }else{
                return buscaLinearRecursiva(v, key, idx+1);
            }
        }
        return -1;
    }
}
