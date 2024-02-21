public class SomaRecursiva{
	
	public static void main(String[] args){
		SomaRecursiva soma = new SomaRecursiva();

		int[] v =  new int[]{7, 9, 2, 4, 9, 8};
		assert soma.somaRecursiva(v,0) == 39;


		int[] x = new int[]{-1};
		assert soma.somaRecursiva(x,0) == -1;

		int[] z = new int[]{};
		assert soma.somaRecursiva(z,0) == 0;

		int[] a = new int[]{-1, -1, -1, -1};
		assert soma.somaRecursiva(a,0) == -4;

		int[] b = new int[]{1, 2, 3, 4, 5};
		assert soma.somaRecursiva(b, 0) == 15;
	}


	public int somaRecursiva(int[] v, int idx){
		if(idx == v.length){
			return 0;
		}
		return v[idx] + somaRecursiva(v, idx+1);
	}
}
