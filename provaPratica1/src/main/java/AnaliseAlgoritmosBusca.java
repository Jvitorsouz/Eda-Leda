public class AnaliseAlgoritmosBusca {
    
    public int contaPassosBinaria(int[] v, int ini, int fim, int k) {
        if(ini <= fim){
            int meio = (ini+fim)/2;
            
            if(v[meio] == k){
                return 0;
            }

            if(k > v[meio]){
                return 1 + contaPassosBinaria(v, meio+1, fim, k);
            }else{
                return 1 + contaPassosBinaria(v, ini, meio-1, k);
            }
        }else{
            return 0;
        }
    
    }

    public int contaPassosLinear(int[] v, int k) {
        for(int i =0; i<v.length; i++){
            if(v[i] == k){
                return i+1;
            }
        }
        return v.length;
    }

}
