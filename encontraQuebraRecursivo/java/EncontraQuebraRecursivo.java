import java.util.Scanner;

class EncontraQuebraRecursivo{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        EncontraQuebraRecursivo encontra = new EncontraQuebraRecursivo();
        String[] entrada = sc.nextLine().split(" ");

        System.out.println(encontra.encontraQuebraRecursivo(entrada, 0));
    }


    public int encontraQuebraRecursivo(String[] v, int idx){
        if(idx >= v.length-1){
            return -1;
        }
        if(Integer.parseInt(v[idx+1]) < Integer.parseInt(v[idx])){
            return idx+1;
        }

        return encontraQuebraRecursivo(v, idx+1);
    }
}