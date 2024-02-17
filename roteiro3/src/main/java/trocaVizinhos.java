import java.util.*;

public class trocaVizinhos{

    public static void main(String[] args){
        trocaVizinhos troca = new trocaVizinhos();

        Scanner sc = new Scanner(System.in);

        String[] entradas = sc.nextLine().split(" ");
        System.out.println(Arrays.toString(troca.trocaVizinhoRecursiva(entradas, 0)));
    }

    public String[] trocaVizinhoRecursiva(String[] n, int idx){
        if(idx < n.length - 1){
            String aux = n[idx];
            n[idx] = n[idx + 1];
            n[idx + 1] = aux;
            return trocaVizinhoRecursiva(n, idx+2);
        }
        return n;
    }
}