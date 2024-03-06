import java.util.Arrays;

public class SelectionSort{

    public static void main(String[] args) {
         int[] x = new int[] {9, 30, 1, 3, 22, -4, 10, 1, 2, 11};
         selectionSort(x);
         System.out.println(Arrays.toString(x));
    }

    public static void selectionSort(int[] v){

        for(int i = 0; i<v.length; i++){

            int idx_MenorElemento = i;
            for(int j = i+1; j<v.length; j++){
                if(v[j] < v[idx_MenorElemento]){
                    idx_MenorElemento = j;
                }
            }

            swap(v, i, idx_MenorElemento);
        }
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}