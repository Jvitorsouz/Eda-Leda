import java.util.Arrays;

public class findMaxCrossingSubArray{

    public static void main(String[] args){

        findMaxCrossingSubArray find = new findMaxCrossingSubArray();
        int[] seq = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        String saida = find.find_max_crossing_subArray(seq, 0, (seq.length/2) -1, seq.length);
        
        String[] seq2 = saida.split(" ");
        int inicio = Integer.parseInt(seq2[0]);
        int fim = Integer.parseInt(seq2[1]);
        
        int[] subArray = new int[(fim-inicio)+1];
        for(int i =0; i<subArray.length; i++){
            subArray[i] = seq[inicio];
            inicio++;
        }

       System.out.println(Arrays.toString(subArray));
       System.out.println("Soma: " + seq2[2]);

    }

    public String find_max_crossing_subArray(int[] array, int low, int mid, int high){
        String seq = "";

        int left_sum = 0;
        int sum = 0;
        int max_left = 0;
        for(int i = mid; i>=low; i--){
            sum += array[i];
            if(sum > left_sum){
                left_sum = sum;
                max_left = i;
            }
        }

        seq += max_left + " ";

        int right_sum = 0;
        sum = 0;
        int max_right = 0;
        for(int j = mid+1; j<high; j++){
            sum += array[j];
            if(sum > right_sum){
                right_sum = sum;
                max_right = j;
            }
        }

        seq += max_right + " " + (left_sum + right_sum);
        return seq;
    }
}