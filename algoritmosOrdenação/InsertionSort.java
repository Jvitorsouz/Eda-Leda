import java.util.Arrays;

public class InsertionSort {
    
    public static void main(String[] args) {
        int[] x = new int[] {9, 30, 1, 3, 22, -4, 10, 1, 2, 11};
        insertionSort(x);
        System.out.println(Arrays.toString(x));
    }

    public static void insertionSort(int[] v){

        for(int i = 1; i<v.length; i++){

            int j = i;
            while(j > 0 && v[j] < v[j-1]){
                swap(v, j, --j);
                
            }
        }
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
