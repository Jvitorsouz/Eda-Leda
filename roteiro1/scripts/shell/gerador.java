import java.util.Random;

public class gerador{

	public static void main(String[] args){
		String resultado = "";
		for(int i=0; i<100; i++){
			Random random = new Random();
			int random_number = random.nextInt(1000) +1;
			for(int j =0; j<random_number; j++){
				resultado += "a ";
			}
			resultado += "\n";
		}

		System.out.println(resultado);
	}

}	
