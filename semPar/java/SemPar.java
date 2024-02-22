import java.util.Scanner;

class SemPar{


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        System.out.println(semPar(entrada));

    }

    public static String semPar(String[] v){

        for(int i=0; i<v.length; i++){
            int aux = 0;
            for(int j=0; j<v.length; j++){
                if(v[i].equals(v[j])){
                    aux++;
                }
            }
            if(aux == 1){
                return v[i];
            }
        }


        return null;
    }
}