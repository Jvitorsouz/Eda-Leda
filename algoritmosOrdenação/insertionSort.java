import java.util.Arrays;

public class insertionSort{

    public static void main(String[] args){
        insertionSort ordena = new insertionSort();

        int[] n = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(ordena.InsertionSort(n)));


    }

    public int[] InsertionSort(int[] n){

        for(int j = 1; j < n.length; j++){
            int chave = n[j];
            int i = j - 1;
            while(i >= 0 && n[i] > chave){
                n[i+1] = n[i];
                i--;
            }
            n[i+1] = chave;
        }

        return n;
    }
}