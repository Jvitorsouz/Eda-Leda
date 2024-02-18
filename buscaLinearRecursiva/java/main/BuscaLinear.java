//Exemplo de uma busca linear ordem(n)
public class BuscaLinear {


    public static void main(String[] args){
        BuscaLinear busca = new BuscaLinear();

        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(busca.buscaLinear(v, 1)); // 0
        System.out.println(busca.buscaLinear(v, 11)); // -1
    }


    public int buscaLinear(int[] v, int key){
        for(int i=0; i<v.length;  i++){
            if(v[i] == key){
                return i;
            }
        }
        return -1;
    }
    
}
