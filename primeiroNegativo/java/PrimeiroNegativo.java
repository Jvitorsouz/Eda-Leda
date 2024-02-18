import java.util.Scanner;

class PrimeiroNegativo{

    public static void main(String[] args){
        PrimeiroNegativo primeiro = new PrimeiroNegativo();

        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        System.out.println(primeiro.primeiroNegativo(entrada, 0));
    }


    public String primeiroNegativo(String[] v, int idx){
        if(idx >= v.length){
            return "-";
        }
        if(Integer.parseInt(v[idx]) < 0){
            return v[idx];
        }
        return primeiroNegativo(v, idx+1);
    }
}