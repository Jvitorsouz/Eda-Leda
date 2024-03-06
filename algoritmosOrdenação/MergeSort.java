import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] x = new int[] {9, 30, 1, 3, 22, -4, 10, 1, 2, 11};
        mergeSort(x, 0, x.length-1);
        System.out.println(Arrays.toString(x));


    }

    public static void mergeSort(int[] v, int ini, int fim){
        if(ini < fim){

            int meio = (ini+fim)/2;

            mergeSort(v, ini, meio);
            mergeSort(v, meio+1, fim);
            merge(v, ini, meio, fim);
        }
    }

    public static void merge(int[] v, int ini, int meio, int fim){

        int[] helper = new int[v.length];
        for(int i = ini; i <= fim; i++){
            helper[i] = v[i];
        }
        int i = ini;
        int j = meio +1;
        int k = ini;

        while(i <= meio && j <= fim){
            if(helper[i] <= helper[j]){
                v[k++] = helper[i++];
            }else{
                v[k++] = helper[j++];
            }
        }

        while(i <= meio){
            v[k++] = helper[i++];
        }
    }

    
}
