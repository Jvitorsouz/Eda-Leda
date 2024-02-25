import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args) {
        
        int[] x = new int[]{2, 4, 3, -1};
        //int[] y = new int[]{-1, 2, 3, 4};

        assert Arrays.equals(selectionSort(x), new int[]{-1, 2, 3, 4}) == true;
        
    }


    public static int[] selectionSort(int[] v){

        for(int i=0; i < v.length; i++){

            int indiceMenor = i;
            for(int j= i+1; j<v.length; j++){
                if(v[j] < v[indiceMenor]){
                    indiceMenor = j;
                }
            }

            int aux = v[i];
            v[i] = v[indiceMenor];
            v[indiceMenor] = aux;
        }


        return v;
    }
    
}
