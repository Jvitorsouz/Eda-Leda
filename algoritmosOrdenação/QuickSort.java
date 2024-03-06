import java.util.Arrays;

public class QuickSort {
    

    public static void main(String[] args) {
        int[] x = new int[] {9, 30, 1, 3, 22, -4, 10, 1, 2, 11};
        quickSort(x, 0, x.length-1);
        System.out.println(Arrays.toString(x));
    }

    public static void quickSort(int[] v, int ini, int fim){

        if(ini < fim){
            int pivot_idx = particionamentoLomuto(v, ini, fim);
            quickSort(v, ini, pivot_idx -1);
            quickSort(v, pivot_idx+1, fim);
        }
    }

    public static int particionamentoLomuto(int[] v, int ini, int fim){

        int range = fim - ini +1;
        int random_pivot = (int) (Math.random() * range) + ini;
        swap(v, ini, random_pivot);

        int i = ini;
        int pivot = v[ini];

        for(int j = ini+1; j<=fim; j++){
            if(v[j] <= pivot){
                swap(v, ++i, j);
            }
        }

        swap(v, ini, i);




        return i;
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
