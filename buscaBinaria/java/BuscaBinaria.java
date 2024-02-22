class BuscaBinaria{


    public static void main(String[] args){

        int[] n = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(buscaBinaria(n, 0, n.length-1, 6));




    }

    public static int buscaBinaria(int[] v, int ini, int fim, int key){
        if(ini<=fim){
            int meio = (ini+fim)/2;
            if(v[meio] == key){
                return meio;
            }

            if(key < v[meio]){
                return buscaBinaria(v, ini, meio-1, key);
            }else{
                return buscaBinaria(v, meio+1, fim, key);
            }
        }else{
            return -1;
        }
    }
}